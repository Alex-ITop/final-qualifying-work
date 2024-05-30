package diplom.buisness.utils;

import diplom.data.dto.Material;
import diplom.data.exceptions.FilesException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Метод для работы с файлами (считывания, записи)
 */
public class FileUtils {

    public static List<Double> importDataMas(String file) {
        List<Double> values = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                values.add(Double.parseDouble(line));
            }
            return values;
        } catch (FileNotFoundException e) {
            throw new FilesException(String.format("Файл %s не найден", file));
        }
        catch (IOException e) {
            throw new FilesException("Ошибка чтения файлов");
        }
    }

    public static void writeMaterialToFile(String file, Material data) {
        try(FileWriter writer = new FileWriter(file, true)) {
            String material = data.getName() + " " + data.getYoungModule() + " " + data.getPoissonRatio();
            writer.write(material);
            writer.write("\n");
        } catch (FileNotFoundException e) {
            throw new FilesException(String.format("Файл %s не найден", file));
        }
        catch (IOException e) {
            throw new FilesException("Ошибка чтения файлов");
        }
    }

    public static List<Material> loadMaterialsFromFile(String file) {
        List<Material> materials = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] materialString = line.split(" ");
                Material material = new Material(materialString[0], Double.parseDouble(materialString[1]), Double.parseDouble(materialString[2]));
                materials.add(material);
            }
            return materials;
        } catch (FileNotFoundException e) {
            throw new FilesException(String.format("Файл %s не найден", file));
        }
        catch (IOException e) {
            throw new FilesException("Ошибка чтения файлов");
        }
    }

    public static void writeParametersToFile(String file, List<Double> parameters) {
        try(FileWriter writer = new FileWriter(file, true)) {
            for (Double parameter: parameters) {
                writer.write(parameter.toString());
                writer.write(" ");
            }
            writer.write("\n");
        } catch (FileNotFoundException e) {
            throw new FilesException(String.format("Файл %s не найден", file));
        }
        catch (IOException e) {
            throw new FilesException("Ошибка чтения файлов");
        }
    }
}
