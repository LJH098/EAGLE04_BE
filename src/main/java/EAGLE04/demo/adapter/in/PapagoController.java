package EAGLE04.demo.adapter.in;

import EAGLE04.demo.application.service.papago.PapagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PapagoController {
    private final PapagoService papagoService;
    @PostMapping("/translate")
    public ApiResult<String> translate(@RequestBody PapagoRequest request) throws Exception {
        return ApiUtils.success(papagoService.textTranslation(request));
    }
}
