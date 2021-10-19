package patterns.builder;

public class BuilderPattern {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder {
        BuilderPattern pattern;

        public Builder() {
            pattern = new BuilderPattern();
        }

        public Builder setId(int id) {
            pattern.id = id;
            return this;
        }

        public Builder setName(String name) {
            pattern.name=name;
            return this;
        }

        public BuilderPattern build() {
            return pattern;
        }
    }
}
