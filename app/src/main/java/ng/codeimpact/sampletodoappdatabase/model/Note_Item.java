package ng.codeimpact.sampletodoappdatabase.model;

/**
 * Created by Nsikak  Thompson on 4/5/2017.
 */

public class Note_Item {

    private String title, description;


    public Note_Item(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
