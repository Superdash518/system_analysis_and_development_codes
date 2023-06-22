package modelo;

public class AeronaveModelo  {
    private PassageiroModelo[][] passageiros;
    private String modelo;

    public AeronaveModelo(){}
    public AeronaveModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
