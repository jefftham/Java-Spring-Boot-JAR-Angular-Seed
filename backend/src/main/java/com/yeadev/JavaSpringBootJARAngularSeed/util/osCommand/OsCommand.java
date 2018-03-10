package com.yeadev.JavaSpringBootJARAngularSeed.util.osCommand;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ref http://www.rgagnon.com/javadetails/java-0014.html

@Slf4j
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OsCommand {

    public static String run(String command) {

        String s;
        String retString = "";
        String errString = "";

        try {
            log.info("Executing command '" + command + "'");
            Process p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            log.debug("Here is the standard output of the command:");
            while ((s = stdInput.readLine()) != null) {
                log.debug(s);
                retString += s;
            }

            // read any errors from the attempted command
            log.debug("Here is the standard error of the command (if any):");
            while ((s = stdError.readLine()) != null) {
                //log.debug(s);
                errString += s;
            }

            log.info("Command execution completed for '"+command+"' .");

        } catch (IOException | InterruptedException e) {
            log.info("exception happened for '"+command+"' .");
            e.printStackTrace();
            log.error(errString);
            return errString;
        }

        return retString;
    }

}
