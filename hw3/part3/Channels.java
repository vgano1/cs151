public enum Channels{
    ABC(7), NBC(11), FOX(2), KQED(9), KRON(4);
    
    
    private int channel;

    private Channels(int channel) {
        this.channel = channel;
    }
    
    public int getChannel() {
        return channel;
    }
    
}