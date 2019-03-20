public class Article {

    private String authors = "";
    private String journal = "";
    private String title = "";
    private String year = "";
    private String volume = "";
    private String number = "";
    private String pages = "";
    private String keywords= "";
    private String doi = "";
    private String ISSN= "";
    private String month = "";

    public Article(String authors, String journal, String title, String year, String volume, String number, String pages, String keywords, String doi, String ISSN, String month){

    }

    public Article(){


    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void resetAll(){

         authors = "";
         journal = "";
         title = "";
         year = "";
         volume = "";
         number = "";
         pages = "";
         keywords= "";
         doi = "";
         ISSN= "";
         month = "";

    }

    public String toIEEE(){

        return (authors.replace(" and",",").replace("author={","").replace("}, ","")+". \""+title.replace("title={","").replace("}, ","")+"\", "+journal.replace("journal={","").replace("}, ","")+", vol. "+volume.replace("volume={","").replace("}, ","")+", no. "+number.replace("number={","").replace("}, ","")+", p. "+pages.replace("pages={","").replace("}, ","")+", "+month.replace("month={","").replace("},","")+" "+year.replace("year={","").replace("}, ","")+".");

    }

    public String toACM(){

        return (authors.split("and")[0].replace("author={","")+"et al. "+year.replace("year={","").replace("}, ","")+". "+title.replace("title={","").replace("}, ","")+". "+journal.replace("journal={","").replace("}, ","")+". "+volume.replace("volume={","").replace("}, ","")+", "+number.replace("number={","").replace("}, ","")+" ("+year.replace("year={","").replace("}, ","")+"), "+pages.replace("pages={","").replace("}, ","")+". DOI:https://doi.org/"+ doi.replace("doi={","").replace("}, ","")+".");

    }

    public String toNJ(){

        return (authors.replace(" and"," &").replace("author={","").replace("}, ","")+". "+title.replace("title={","").replace("}, ","")+". "+journal.replace("journal={","").replace("}, ","")+". "+volume.replace("volume={","").replace("}, ","")+", "+pages.replace("pages={","").replace("}, ","")+" ("+year.replace("year={","").replace("}, ","")+").");

    }

}
