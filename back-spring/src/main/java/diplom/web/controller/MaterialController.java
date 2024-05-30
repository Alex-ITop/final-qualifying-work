package diplom.web.controller;

import diplom.buisness.service.MaterialsService;
import diplom.data.dto.Material;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Materials Controller", description = "Контроллер для работы с материалами")
@RestController
@RequestMapping("/api/materials")
@RequiredArgsConstructor
public class MaterialController {

    @Autowired
    private MaterialsService materialsService;

    @PostMapping("/add")
    @Operation(description = "Добавление нового материала")
    public Material addMaterial(@RequestBody Material material) {
        return materialsService.addMaterial(material);
    }

    @GetMapping()
    @Operation(description = "Получние списка всех материалов")
    public List<Material> getAllMaterials() {
        return materialsService.getAllMaterials();
    }

    @GetMapping("/{materialName}")
    @Operation(description = "Получние списка всех материалов")
    public Material getMaterial(@PathVariable String materialName) {
        return materialsService.getMaterial(materialName);
    }
}
