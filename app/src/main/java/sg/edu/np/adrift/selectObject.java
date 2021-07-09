package sg.edu.np.adrift;

public class selectObject {
    private String text1;
    private int image;



    public selectObject(int image, String text) {
        this.image=image;
        this.text1=text;
    }
    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



}
