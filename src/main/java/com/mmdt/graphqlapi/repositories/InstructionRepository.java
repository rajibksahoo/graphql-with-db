package com.mmdt.graphqlapi.repositories;

import com.mmdt.graphqlapi.entities.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, UUID> {
    // Custom query methods can be added here if needed
}

