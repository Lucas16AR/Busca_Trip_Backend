// package com.trip.repositories;

// import com.trip.models.VehicleModel;
// import org.springframework.data.repository.CrudRepository;

// public interface VehicleRepository extends CrudRepository<VehicleModel, Long> {
// }

package com.trip.repositories;
import com.trip.models.VehicleModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface VehicleRepository extends JpaRepository<VehicleModel, Long> {

}