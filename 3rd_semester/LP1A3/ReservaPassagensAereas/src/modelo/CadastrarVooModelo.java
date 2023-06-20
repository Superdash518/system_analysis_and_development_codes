package modelo;
public class CadastrarVooModelo {
    private String data;
    private String hora;
    private String destino;
    private AeronaveModelo aeronave;
    private PassageiroModelo[] passageiros;

    public CadastrarVooModelo(){

    }
    public CadastrarVooModelo(String data, String hora, String destino, AeronaveModelo aeronave, PassageiroModelo[] passageiros) {
        this.data = data;
        this.hora = hora;
        this.destino = destino;
        this.aeronave = aeronave;
        this.passageiros = passageiros;
    }

    public String getData() {
        return this.data;
    }

    public String getHora() {
        return this.hora;
    }

    public String getDestino() {
        return this.destino;
    }

    public AeronaveModelo getAeronave() {
        return this.aeronave;
    }

    public PassageiroModelo[] getPassageiros() {
        return this.passageiros;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setAeronave(AeronaveModelo aeronave) {
        this.aeronave = aeronave;
    }

    public void setPassageiros(PassageiroModelo[] passageiros) {
        this.passageiros = passageiros;
    }
}
