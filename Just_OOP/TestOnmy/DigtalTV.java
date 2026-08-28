
class DigtalTV extends Television implements RemoteControl{
    private String  antenna;
    DigtalTV(String brand,int channel,int volume,String antenna){
        super(brand, channel, volume);
        this.antenna = antenna;
    }
    @Override
    public void volumeDown() {
        --volume;
    }
    @Override
    public void volumeUp() {
        
    }
}