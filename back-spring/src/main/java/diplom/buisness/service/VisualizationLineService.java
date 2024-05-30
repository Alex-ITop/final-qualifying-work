package diplom.buisness.service;

import diplom.buisness.utils.ApproximationMNKUtils;
import diplom.buisness.utils.FileUtils;
import diplom.data.dto.LineDataArray;
import diplom.data.dto.FileProperties;
import diplom.data.dto.IndexesLineData;
import diplom.data.exceptions.FilesException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
@EnableConfigurationProperties({FileProperties.class})
public class VisualizationLineService {

    @Autowired
    private FileProperties fileProperties;

    public List<LineDataArray> getArraysForVisualizeLines(IndexesLineData indexes) {
        var filePaths = getFilePaths(indexes.getIndexOfMaterial(), indexes.getIndexOfLine(), indexes.getIndexOfStrength());
        var coord = FileUtils.importDataMas(filePaths.get(2).get(0));
        List<LineDataArray> lineDataArrays = new ArrayList<>();
        for (int i=0; i<filePaths.get(0).size(); i++) {
            String filePathSfri = filePaths.get(0).get(i);
            String filePathPres = filePaths.get(0).get(i);
            var masLineSfri = FileUtils.importDataMas(filePathSfri);
            var finalMasSfri = ApproximationMNKUtils.approximate(coord, masLineSfri);
            var masLinePres = FileUtils.importDataMas(filePathPres);
            var finalMasPres = ApproximationMNKUtils.approximate(coord, masLinePres);
            lineDataArrays.add(new LineDataArray(finalMasSfri, finalMasPres));
        }
        return lineDataArrays;
    }

    private List<List<String>> getFilePaths(int indexOfMaterial, int indexOfLine, int indexOfStrength) {
        try {
            StringBuilder filePath = new StringBuilder();
            filePath.append(fileProperties.getDataFiles()).append(" ").append((indexOfMaterial+1))
                    .append("/line ").append((indexOfLine+1))
                    .append("/Material_").append((indexOfMaterial+1))
                    .append("_p_line_").append((indexOfLine+1))
                    .append("_Cont_F_");
            List<List<String>> masOfFilePath = new ArrayList<>();
            List<String> masOfFilePathSfri = new ArrayList<>();
            List<String> masOfFilePathPres = new ArrayList<>();
            List<String> coordPath = new ArrayList<>();
            if (indexOfStrength==10) {
                for (int i=0; i<indexOfStrength; i++) {
                    String filePathSfri = filePath + Integer.toString(i+1) + "00_SFRI.txt";
                    String filePathPres = filePath + Integer.toString(i+1) + "00_PRES.txt";
                    masOfFilePathSfri.add(filePathSfri);
                    masOfFilePathPres.add(filePathPres);
                }
                masOfFilePath.add(masOfFilePathSfri);
                masOfFilePath.add(masOfFilePathPres);
            }
            else {
                String filePathSfri = filePath + Integer.toString(indexOfStrength+1) + "00_SFRI.txt";
                String filePathPres = filePath + Integer.toString(indexOfStrength+1) + "00_PRES.txt";
                masOfFilePathSfri.add(filePathSfri);
                masOfFilePathPres.add(filePathPres);
                masOfFilePath.add(masOfFilePathSfri);
                masOfFilePath.add(masOfFilePathPres);
            }
            String coords = fileProperties.getCoordFiles()+"/coor_line_"+(indexOfLine+1)+"_F_Y.txt";
            coordPath.add(coords);
            masOfFilePath.add(coordPath);
            return masOfFilePath;
        }
       catch (Exception ex) {
            throw new FilesException("Файлы не найдены");
       }
    }
}
