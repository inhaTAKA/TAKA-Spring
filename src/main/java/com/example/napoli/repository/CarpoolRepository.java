package com.example.napoli.repository;


import com.example.napoli.domain.entity.Carpool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarpoolRepository extends JpaRepository<Carpool, Long> {
    Carpool findCarpoolByCarpoolId(Long carpoolId);

    @Query("SELECT c FROM Carpool c WHERE " +
            "(" +
            "(c.firstTransitAddress1 LIKE CONCAT('%', :startKeyword, '%') OR " +
            " c.firstTransitAddress2 LIKE CONCAT('%', :startKeyword, '%') OR " +
            " c.firstTransitAddress3 LIKE CONCAT('%', :startKeyword, '%'))" +
            " OR " +
            "(c.secondTransitAddress1 LIKE CONCAT('%', :startKeyword, '%') OR " +
            " c.secondTransitAddress2 LIKE CONCAT('%', :startKeyword, '%') OR " +
            " c.secondTransitAddress3 LIKE CONCAT('%', :startKeyword, '%'))" +
            ")" +
            "AND (" +
            " c.firstArriveAddress LIKE CONCAT('%', :arriveKeyword, '%') OR " +
            " c.secondArriveAddress LIKE CONCAT('%', :arriveKeyword, '%')" +
            ")" +
            "AND (:minCharge = 0 OR c.minDesiredCharge >= :minCharge) " +
            "AND (:maxCharge = 0 OR c.maxDesiredCharge <= :maxCharge) " +
            "AND c.sex = :sex")
    List<Carpool> searchCarpool(@Param("startKeyword") String startKeyword,
                                @Param("arriveKeyword") String arriveKeyword,
                                @Param("minCharge") int minCharge,
                                @Param("maxCharge") int maxCharge,
                                @Param("sex") String sex);
}
