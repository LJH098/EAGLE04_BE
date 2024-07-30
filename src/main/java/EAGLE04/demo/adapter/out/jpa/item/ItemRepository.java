package EAGLE04.demo.adapter.out.jpa.item;

import EAGLE04.demo.application.domain.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>{
}
