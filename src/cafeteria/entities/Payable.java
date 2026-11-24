package cafeteria.entities;

/** Contrato de pagamento; cada tipo de funcionário o calcula à sua maneira (polimorfismo). */
public interface Payable {
    /** Calcula o valor do pagamento. */
    public double calculatePayment();
}
