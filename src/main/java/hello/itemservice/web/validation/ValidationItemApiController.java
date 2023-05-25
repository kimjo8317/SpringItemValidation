package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {

    @PostMapping("/add")
    //ItemSaveForm에 맞는 타입이 아니면(ex.숫자가아닌문자) (HttpMessageConverter 실패)
    // json -> 객체로 만들어줘야 검증이든 뭐든 할수있음 실패하면 컨트롤러 자체가 못넘어옴
    public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult) {
    //RequestBody + Validated 검증 , bindingResult검증결과 (json API넘기기)
        log.info("API 컨트롤러 호출");

        //itemName , price , quantity 등 타입에 맞지않는 값이 넘어올경우 검증에러발생된다.
        if (bindingResult.hasErrors()) {
            log.info("검증 오류 발생 errors={}", bindingResult);
            return bindingResult.getAllErrors();
        }
        //Object에러 자식은 field에러임 , getAllErrors는 모든 에러를불러오는것
        //결과적으로 제이슨결과를 반환해줌


        log.info("성공 로직 실행");
        return form;
    }
}
