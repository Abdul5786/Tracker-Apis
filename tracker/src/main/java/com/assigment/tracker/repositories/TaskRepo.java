package com.assigment.tracker.repositories;

import com.assigment.tracker.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Tasks,String>
{

}
