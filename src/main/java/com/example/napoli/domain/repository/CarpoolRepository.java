package com.example.napoli.domain.repository;


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
            "c.firstStartAddress LIKE :firstStartAddress " +
            "AND c.firstArriveAddress LIKE :firstArriveAddress " +
            "AND c.minDesiredCharge >= :minCharge " +
            "AND c.maxDesiredCharge <= :maxCharge " +
            "AND c.sex = :sex")
    List<Carpool> searchCarpool(@Param("firstStartAddress") String firstStartAddress,
                                @Param("firstArriveAddress") String firstArriveAddress,
                                @Param("minCharge") int minCharge,
                                @Param("maxCharge") int maxCharge,
                                @Param("sex") String sex);
}
