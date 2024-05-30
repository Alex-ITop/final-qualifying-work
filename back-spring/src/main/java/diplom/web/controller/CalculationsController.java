package diplom.web.controller;

import diplom.buisness.service.ScriptRunnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Calculations Controller", description = "Контроллер для вычислений и дальнейших преобразований")
@RestController
@RequestMapping("/api/calculations")
@RequiredArgsConstructor
public class CalculationsController {

    @Autowired
    private ScriptRunnerService scriptRunnerService;

    @PostMapping()
    @Operation(description = "Запуск вычислений")
    public void calculate() {
        scriptRunnerService.launchANSYS();
    }
}
