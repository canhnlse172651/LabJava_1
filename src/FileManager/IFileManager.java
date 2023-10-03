/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package FileManager;

import java.util.List;

/**
 *
 * @author lyhai
 */
public interface IFileManager {
    List<String> readDataFromFile() throws Exception;

    void commitFile(List<String> raws) throws Exception;
}
