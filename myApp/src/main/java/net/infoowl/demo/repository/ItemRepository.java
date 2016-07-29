package net.infoowl.demo.repository;

import net.infoowl.demo.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kancer on 26.07.2016.
 */
public interface ItemRepository extends JpaRepository<Item, Integer>{
}
