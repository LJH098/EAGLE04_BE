package EAGLE04.demo.application.service.papago;

import EAGLE04.demo.adapter.in.PapagoRequest;
import EAGLE04.demo.common.config.PapagoConfig;
import EAGLE04.demo.common.dto.papago.PapagoRequestDto;
import EAGLE04.demo.common.dto.papago.PapagoResponseDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PapagoService {
    private final PapagoConfig papagoConfig;
    private final ObjectMapper objectMapper;

    private static RestTemplate restTemplate = new RestTemplate();

    public String textTranslation(PapagoRequest request) throws Exception {

        PapagoRequestDto papagoRequestDto = PapagoRequestDto.builder()
                .source(PapagoConfig.source)
                .target(request.target())
                .text(request.text()).build();

        PapagoResponseDto papagoResponseDto = this.getResponse(buildHttpEntity(papagoRequestDto));
        return papagoResponseDto.message().result().translatedtext();

//        JsonNode jsonNode = objectMapper.readTree(translatedtext);
//        String translatedParsingText = jsonNode.get("text").asText();
//        return translatedParsingText;

    }
        private HttpEntity<PapagoRequestDto> buildHttpEntity (PapagoRequestDto papagoRequestDto){
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(PapagoConfig.CONTENT_TYPE));///?
            headers.add(PapagoConfig.KEY_NAME, papagoConfig.getApiKey());
            headers.add(PapagoConfig.ID_NAME, papagoConfig.getApiId());
            return new HttpEntity<>(papagoRequestDto, headers);
        }

        public PapagoResponseDto getResponse (HttpEntity < PapagoRequestDto > papagoRequestDtoHttpEntity) {
            ResponseEntity<PapagoResponseDto> responseEntity = restTemplate.postForEntity(
                    PapagoConfig.URL,
                    papagoRequestDtoHttpEntity,
                    PapagoResponseDto.class);
            return responseEntity.getBody();
        }

    }
