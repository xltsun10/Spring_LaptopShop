package com.ShopComputer.admin.role;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShopComputer.EntityCommon.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
