package qj.amazon.hard;


public class Cache { // a class to remember frequency and recentness
    int key, f, r;
    public Cache(int k, int f, int r) {key=k;this.f=f;this.r=r;}
    // override equals() and hashCode()
    public boolean equals(Object object) {return key==((Cache) object).key;}
    public int hashCode() {return key;}
}