package org.homework.model.bean;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User1 on 29.11.2015.
 */
public class Labyrinth {

    private String name;
    private List<Cell> cellsList = new ArrayList<Cell>();
    private List<Cell> cellsPathList = new ArrayList<Cell>();
    private Position maxPosition = new Position();
    private Position startPosition = new Position();

    public Labyrinth(String fileName) {
        // read the file
        readXmlFile(fileName);
        // fill in walls in the cellsList
        fillWalls();
    }

    private void readXmlFile(String fileName) {
        // read the input file
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        InputStream is = this.getClass().getResourceAsStream(fileName);
        
        try {
            reader = factory.createXMLStreamReader(is);
            int event = reader.getEventType();
            while (true) {
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (reader.getName().toString().equals("name")) {
                            reader.next();
                            this.name = reader.getText();
                            break;
                        }
                        if (reader.getName().toString().equals("length-x")) {
                            reader.next();
                            this.maxPosition.setX(Integer.parseInt(reader.getText()));
                            break;
                        }
                        if (reader.getName().toString().equals("length-y")) {
                            reader.next();
                            this.maxPosition.setY(Integer.parseInt(reader.getText()));
                            break;
                        }
                        if (reader.getName().toString().equals("play-start-x")) {
                            reader.next();
                            this.startPosition.setX(Integer.parseInt(reader.getText()));
                            break;
                        }
                        if (reader.getName().toString().equals("play-start-y")) {
                            reader.next();
                            this.startPosition.setY(Integer.parseInt(reader.getText()));
                            break;
                        }
                        if (reader.getName().toString().equals("cell")) {
                            Position position = new Position();
                            boolean isContinue = true;
                            while (isContinue) {
                                switch (reader.getEventType()) {
                                    case XMLStreamConstants.START_ELEMENT:
                                        if (reader.getName().toString().equals("position-x")) {
                                            reader.next();
                                            position.setX(Integer.parseInt(reader.getText()));
                                            break;
                                        }
                                        if (reader.getName().toString().equals("position-y")) {
                                            reader.next();
                                            position.setY(Integer.parseInt(reader.getText()));
                                            cellsList.add(new Cell(position, false));
                                            isContinue = false;
                                            break;
                                        }
                                }
                                if (!reader.hasNext()) {
                                    break;
                                }
                                reader.next();
                            }
                            break;
                        }
                        break;
                }
                if (!reader.hasNext()) {
                    break;
                }
                event = reader.next();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
    }

    private void fillWalls() {
        // fill in walls in the cellsList
        for (Cell cell : cellsList) {
            cellsPathList.add(cell);
        }
        for (int x = 0; x < maxPosition.getX() + 1; x++) {
            for (int y = 0; y < maxPosition.getY() + 1; y++) {
                Cell cell = new Cell(new Position(x , y), true);
                boolean isExists = false;
                for (Cell cellTemp : cellsPathList) {
                    if (cell.getPosition().getX() == cellTemp.getPosition().getX()
                            && cell.getPosition().getY() == cellTemp.getPosition().getY()){
                        isExists = true;
                    }
                }
                if (!isExists) {
                    cellsList.add(cell);
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cell> getCellsList() {
        return cellsList;
    }

    public void setCellsList(List<Cell> cellsList) {
        this.cellsList = cellsList;
    }

    public Position getMaxPosition() {
        return maxPosition;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public List<Cell> getCellsPathList() {
        return cellsPathList;
    }
}
