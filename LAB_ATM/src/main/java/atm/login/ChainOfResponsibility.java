package atm.login;

public abstract class ChainOfResponsibility {
    private ChainOfResponsibility chainOfResponsibility;

    public ChainOfResponsibility getChainOfResponsibility() {
        return chainOfResponsibility;
    }

    public void setChainOfResponsibility(ChainOfResponsibility chainOfResponsibility) {
        this.chainOfResponsibility = chainOfResponsibility;
    }

    public abstract void write(String num, String pass);
}
