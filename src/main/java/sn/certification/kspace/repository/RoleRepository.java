package sn.certification.kspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.certification.kspace.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
