package com.ShopComputer.site.cartItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ShopComputer.EntityCommon.CartItem;
import com.ShopComputer.EntityCommon.Customer;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	
	@Query("SELECT c FROM CartItem c WHERE c.customer.id =:id")
	public List<CartItem> findByCustomer(@Param("id")Long id);
	
	
	  @Query("SELECT c FROM CartItem c WHERE c.customer = :customer AND c.bill IS NULL")
	    List<CartItem> findAllNotPay(@Param("customer") Customer customer);
	
	public List<CartItem> findByCustomer(Customer c);

}
