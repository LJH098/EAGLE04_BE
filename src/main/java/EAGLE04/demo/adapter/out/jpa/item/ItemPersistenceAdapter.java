package EAGLE04.demo.adapter.out.jpa.item;

import EAGLE04.demo.application.port.out.item.ItemPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ItemPersistenceAdapter implements ItemPort {
    private final ItemRepository itemRepository;


}
