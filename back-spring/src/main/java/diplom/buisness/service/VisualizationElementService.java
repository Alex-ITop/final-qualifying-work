package diplom.buisness.service;

import diplom.buisness.utils.FileUtils;
import diplom.data.dto.*;
import diplom.data.exceptions.FilesException;
import diplom.data.exceptions.WrongIndexException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@NoArgsConstructor
@EnableConfigurationProperties({FileProperties.class})
public class VisualizationElementService {

    @Autowired
    private FileProperties fileProperties;

    public List<ElementDataArray> getArraysForVisualizeElements(IndexesElementData indexes) {
        List<Double> forceArray = new ArrayList<>();
        for (int i=1; i<=10; i++) {
            forceArray.add((double) (100*i));
        }
        ElementDataFilePath filePathsEint, filePathsSint ;
        if (indexes.getIndexOfMinMaxAvg()==0 && indexes.getIndexOfElement()<3) {
            filePathsEint = getFilePathsForElement(indexes.getIndexOfMaterial(), indexes.getIndexOfElement(), "eint");
            filePathsSint = getFilePathsForElement(indexes.getIndexOfMaterial(), indexes.getIndexOfElement(), "sint");
            return new ArrayList<>(Arrays.asList(getElementDataArray(filePathsSint, forceArray), getElementDataArray(filePathsEint, forceArray)));
        }
        else {
            throw new WrongIndexException("Выбраны неверные индексы");
        }
    }

    public List<AllElementsDataArray> getArraysForVisualizeAllElements(IndexesElementData indexes) {
        List<Double> forceArray = new ArrayList<>();
        for (int i=1; i<=10; i++) {
            forceArray.add((double) (100*i));
        }
        if (indexes.getIndexOfMinMaxAvg()>0 && indexes.getIndexOfElement()==3) {
            var filePathsForAllElementsEint = getFilePathsForAllElements(indexes.getIndexOfMaterial(),
                                                                    indexes.getIndexOfMinMaxAvg(), "eint");
            var filePathsForAllElementsSint = getFilePathsForAllElements(indexes.getIndexOfMaterial(),
                                                                    indexes.getIndexOfMinMaxAvg(), "sint");
            return new ArrayList<>(Arrays.asList(getAllElementsDataArray(filePathsForAllElementsEint, forceArray),
                                                getAllElementsDataArray(filePathsForAllElementsSint, forceArray)));
        }
        else {
            throw new WrongIndexException("Выбраны неверные индексы");
        }
    }

    private ElementDataArray getElementDataArray(ElementDataFilePath filePaths, List<Double> forceArray) {
        List<List<Double>> masFileAvg = new ArrayList<>();
        masFileAvg.add(forceArray);
        masFileAvg.add(FileUtils.importDataMas(filePaths.getAverageDataPath()));
        List<List<Double>> masFileMin = new ArrayList<>();
        masFileMin.add(forceArray);
        masFileMin.add(FileUtils.importDataMas(filePaths.getMinDataPath()));
        List<List<Double>> masFileMax = new ArrayList<>();
        masFileMax.add(forceArray);
        masFileMax.add(FileUtils.importDataMas(filePaths.getMaxDataPath()));
        return new ElementDataArray(masFileMin, masFileAvg, masFileMax);
    }

    private AllElementsDataArray getAllElementsDataArray(AllElementsDataFilePath filePaths, List<Double> forceArray) {
        List<List<Double>> masFileDent = new ArrayList<>();
        masFileDent.add(forceArray);
        masFileDent.add(FileUtils.importDataMas(filePaths.getDentDataPath()));
        List<List<Double>> masFileEmal = new ArrayList<>();
        masFileEmal.add(forceArray);
        masFileEmal.add(FileUtils.importDataMas(filePaths.getEmalDataPath()));
        List<List<Double>> masFileVkl = new ArrayList<>();
        masFileVkl.add(forceArray);
        masFileVkl.add(FileUtils.importDataMas(filePaths.getVklDataPath()));
        return new AllElementsDataArray(masFileDent, masFileEmal, masFileVkl);
    }

    private ElementDataFilePath getFilePathsForElement(int indexOfMaterial, int indexOfElement, String eintOrSint) {
        try {
            StringBuilder filePath = new StringBuilder();
            filePath.append(fileProperties.getDataFiles()).append(" ").append((indexOfMaterial+1));
            String element = "";
            switch (indexOfElement){
                case 0:
                    element = "emal";
                    break;
                case 1:
                    element = "dent";
                    break;
                case 2:
                    element = "vkl";
                    break;
            }
            filePath.append("/").append(element).append("/").append(eintOrSint);
            String filePathMax = filePath + "/Material_" + (indexOfMaterial+1) + "_" + element + "_" + eintOrSint + "_maximum.txt";
            String filePathMin = filePath + "/Material_" + (indexOfMaterial+1) + "_" + element + "_" + eintOrSint + "_minimum.txt";
            String filePathAvg = filePath + "/Material_" + (indexOfMaterial+1) + "_" + element + "_" + eintOrSint + "_average.txt";
            return new ElementDataFilePath(filePathMin, filePathAvg, filePathMax);
        }
        catch (Exception ex) {
            throw new FilesException("Файлы не найдены");
        }
    }

    private AllElementsDataFilePath getFilePathsForAllElements(int indexOfMaterial, int indexOfMinMaxAvg, String eintOrSint) {
        try {
            StringBuilder filePath = new StringBuilder();
            filePath.append(fileProperties.getDataFiles()).append(" ").append((indexOfMaterial+1)).append("/");
            String minMaxAvg = "";
            switch (indexOfMinMaxAvg){
                case 0:
                    minMaxAvg = "minimum";
                    break;
                case 1:
                    minMaxAvg = "average";
                    break;
                case 2:
                    minMaxAvg = "maximum";
                    break;
            }
            String filePathDent = filePath + "dent/" + eintOrSint + "/Material_" + (indexOfMaterial+1) + "_dent_" + eintOrSint + "_" + minMaxAvg + ".txt";
            String filePathEmal = filePath + "emal/" + eintOrSint + "/Material_" + (indexOfMaterial+1) + "_emal_" + eintOrSint + "_" + minMaxAvg + ".txt";
            String filePathVkl = filePath + "vkl/" + eintOrSint + "/Material_" + (indexOfMaterial+1) + "_vkl_" + eintOrSint + "_" + minMaxAvg + ".txt";

            return new AllElementsDataFilePath(filePathDent, filePathEmal, filePathVkl);
        }
        catch (Exception ex) {
            throw new FilesException("Файлы не найдены");
        }
    }
}
