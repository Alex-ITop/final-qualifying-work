package diplom.buisness.service;

import diplom.buisness.utils.FileUtils;
import diplom.data.dto.FileProperties;
import diplom.data.dto.Material;
import diplom.data.exceptions.WrongParameterException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@NoArgsConstructor
@EnableConfigurationProperties({FileProperties.class})
public class MaterialsService {

    @Autowired
    private FileProperties fileProperties;

    public Material addMaterial(Material material) {
        if (material.getYoungModule()<=0 && (material.getPoissonRatio()>=0.5 || material.getPoissonRatio()<=0)) {
            throw new WrongParameterException("Модуль Юнга должен быть больше 0, а Коэффициент Пуассона должен быть в интервале (0, 0.5)");
        } else if (material.getYoungModule()<=0) {
            throw new WrongParameterException("Модуль Юнга должен быть больше 0");
        } else if (material.getPoissonRatio()>=0.5 || material.getPoissonRatio()<=0) {
            throw new WrongParameterException("Коэффициент Пуассона должен быть в интервале (0, 0.5)");
        } else if (getAllMaterials().stream().allMatch(x -> Objects.equals(x.getName(), material.getName()))) {
            throw new WrongParameterException("Материал с таким названием уже существует");
        } else {
            FileUtils.writeMaterialToFile(fileProperties.getMaterials(), material);
            return material;
        }
    }

    public List<Material> getAllMaterials() {
        return FileUtils.loadMaterialsFromFile(fileProperties.getMaterials());
    }

    public Material getMaterial(String materialName) {
        if (!getAllMaterials().stream().allMatch(x -> Objects.equals(x.getName(), materialName))) {
            throw new WrongParameterException("Материала с таким именем не существует");
        }
        return getAllMaterials().stream().filter(x -> Objects.equals(x.getName(), materialName)).findFirst().get();
    }
}
