package diplom.buisness.service;

import diplom.data.exceptions.ScriptFailureException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ScriptRunnerService {

    public void launchANSYS() {
        String ansysPath = "";
        String directory = "";
        String jobName = "";
        String inputFile = "";
        String outputFile = "";
        Process ansysProcess = runAPDL(ansysPath, directory, jobName, inputFile, outputFile);
    }

    private Process runAPDL(String ansysPath, String directory, String jobName, String inputFile, String outputFile) {
        String callstring = String.format("\"{%s}\" -b -dir \"{%s}\" -np 2 -j \"{%s}\" -i \"{%s}\" -o \"{%s}\"",
                ansysPath, directory, jobName, inputFile, outputFile);
        try {
            Process process = new ProcessBuilder(callstring).start();
            process.waitFor();
            return process;
        }
        catch (Exception e) {
            throw new ScriptFailureException(String.format("Скрипт прервался с ошибкой: {%s}", e.getMessage()));
        }
    }
}
