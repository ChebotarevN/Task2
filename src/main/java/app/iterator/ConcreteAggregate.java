package app.iterator;

import javafx.scene.image.Image;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class ConcreteAggregate extends Aggregate {
    private String name;
    private Image image;
    private int size;
    private ImageIterator imageIterator;

    @Override
    public Iterator getIterator() {
        imageIterator = new ImageIterator();
        return imageIterator;
    }

    public float getSize() {
        return imageIterator.getSize();
    }

    public float getCorrect() {
        return imageIterator.current;
    }

    public ConcreteAggregate(String name) {
        this.name = name;
    }


    private class ImageIterator implements Iterator {
        private int current = 0;
        ArrayList<String> image = new ArrayList<>();

        private ImageIterator() {
            imgFromFile("C:\\Users\\nikit\\IdeaProjects\\Indicator\\src\\main\\resources\\image");
        }

        private void imgFromFile(String path) {
            File f = new File(path);
            if (f.isDirectory()) {
                String[] fContents = f.list();
                for (int i = 0; i < fContents.length; i++) {
                    if (fContents[i].contains(".jpg"))
                        image.add(f.getPath() + "\\" + fContents[i]);
                    if (!fContents[i].contains("."))
                        imgFromFile(f.getPath() + "\\" + fContents[i]);
                }
            }
        }

        private Image getImage(int iterator) {
            String filename =
                    Paths.get(image.get(iterator - 1)).toUri().toString();
            return new Image(filename);
        }

        protected int getSize() {
            return image.size();
        }

        @Override
        public boolean hasNext() {
            if (image.size() < current + 1) return false;
            return !getImage(current + 1).isError();
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return getImage(++current);
            } else {
                return null;
            }
        }

        public Object preview() {
            current = 1;
            return getImage(current);
        }
    }
}
