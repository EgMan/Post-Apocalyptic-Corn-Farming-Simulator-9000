public abstract class Processor {
    public Processor nextProcessor;
 
    public void processIndividual(Corn corn){};
 
    public void process(Corn corn) {
        processIndividual(corn);
        if (nextProcessor != null) {
            nextProcessor.process(corn);
        }
    }
 
    public Processor setNext(Processor next) {
        nextProcessor = next;
        return nextProcessor;
    }
}
 
