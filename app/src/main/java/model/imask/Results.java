package model.imask;

/**
 * Created by HUZY_KAMZ on 2/13/2017.
 */

public class Results {
    private String SchoolName;
    private String MarkScored;
    private String NormalTotal;
    private String PercentTotal;
    private String position;

    public String getNormalTotal() {
        return NormalTotal;
    }

    public void setNormalTotal(String normalTotal) {
        NormalTotal = normalTotal;
    }

    public String getPercentTotal() {
        return PercentTotal;
    }

    public void setPercentTotal(String percentTotal) {
        PercentTotal = percentTotal;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        this.SchoolName = schoolName;
    }

    public String getMarkScored() {
        return MarkScored;
    }

    public void setMarkScored(String markScored) {
        MarkScored = markScored;
    }
}
