public class Operation {

    private final int howMany;
    private final int from;
    private final int to;
    
    public Operation(String z) {
        int iterator = 0;
        String[] split = z.split("\\D+");
        if (split[iterator].equals("")) iterator++;
        this.howMany = Integer.parseInt(split[iterator++]);
        this.from = Integer.parseInt(split[iterator++]);
        this.to = Integer.parseInt(split[iterator]);
    }

    public int getHowMany() {
        return howMany;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}