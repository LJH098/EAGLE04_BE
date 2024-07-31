package EAGLE04.demo.application.service.favorite;

import EAGLE04.demo.application.domain.CategoryEntity;
import EAGLE04.demo.application.domain.FavoriteEntity;
import EAGLE04.demo.application.domain.MemberEntity;
import EAGLE04.demo.application.port.in.favorite.AddFavoriteUseCase;
import EAGLE04.demo.application.port.out.category.CategoryPort;
import EAGLE04.demo.application.port.out.favorite.FavoritePort;
import EAGLE04.demo.application.port.out.member.MemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddFavoriteService implements AddFavoriteUseCase {
    private final FavoritePort favoritePort;
    private final MemberPort memberPort;
    private final CategoryPort categoryPort;

    @Override
    public Void add(Long memberId, Long categoryId) {
        MemberEntity member = memberPort.findById(memberId);
        CategoryEntity category = categoryPort.findById(categoryId);
        FavoriteEntity favorite = FavoriteEntity.builder()
                .categoryEntity(category)
                .memberEntity(member)
                .build();
        favoritePort.command(favorite);
        return null;
    }
}
