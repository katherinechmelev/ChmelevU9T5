import java.util.ArrayList;

public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name) {
        this.name = name;
        performers = new ArrayList<Performer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Performer> getPerformers() {
        return performers;
    }

    public boolean addPerformer(Performer p) {
        boolean successful = true;
        if (performers.contains(p)) {
            successful = false;
        } else {
            performers.add(p);
        }
        return successful;
    }

    public boolean removePerformer(Performer p) {
        boolean successful = false;
        if (performers.contains(p)) {
            performers.remove(p);
            successful = true;
        }
        return successful;
    }

    public double averagePerformerAge() {
        int avg = 0;
        for (Performer p : performers) {
            avg += p.getAge();
        }
        return (double) avg / performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age) {
        ArrayList<Performer> performers1 = new ArrayList<>();
        for (Performer p : performers) {
            if (p.getAge() >= age) {
                performers1.add(p);
            }
        }
        return performers1;
    }

    public void groupRehearsal() {
        for (Performer p : performers) {
            System.out.println("Rehearsal call! " + p.getName());
            if (p instanceof Comedian) {
                ((Comedian) p).rehearse(false);
            }else{
                p.rehearse();
            }
        }
    }

    public void cabaretShow(){
        for(Performer performer: performers){
            if(performer instanceof Dancer){
                ((Dancer)performer).pirouette(2);
            }
            performer.perform();
        }
    }
}