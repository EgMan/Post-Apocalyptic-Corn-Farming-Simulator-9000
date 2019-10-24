import Corn.*;

public class PostApocolypticCornFarmingSimulator9000 {
    public static void main(String[] args) {
        Corn.CornBuilder builder = Corn.CornBuilder.getInstance();

        builder.plow();

        builder.plant(Corn.CornType.SWEET);
        builder.fertilize();
        builder.water();
        Corn corn = builder.harvest();

        Processor shucker = new Shucker();
        Processor butterer = new Butterer();
        Processor cooker = new Cooker();

        shucker.setNext(cooker).setNext(butterer);
        shucker.process(corn);

        builder.plant(Corn.CornType.SWEET);
        builder.fertilize();
        builder.water();
        Corn corn_harvested = builder.harvest();
    }
}
