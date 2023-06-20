package modelo;

public class CadastrarAviaoModelo extends AeronaveModelo{
    private PassageiroModelo[][] lugares;
    private PassageiroModelo[][] passageiros;

    public CadastrarAviaoModelo(String modelo, int totalFileiras, int totalAssentos) {
        super(modelo);
        this.lugares = new PassageiroModelo[totalFileiras][totalAssentos];
    }

    public CadastrarAviaoModelo() {
        super();
    }

    public PassageiroModelo[][] getLugares() {
        return lugares;
    }

    public void setLugares(int fileira, int assento) {
        this.lugares = new PassageiroModelo[fileira][assento];
    }


    public PassageiroModelo[][] getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(PassageiroModelo[][] passageiros) {
        this.passageiros = passageiros;
    }

    /*
        public PassageiroModelo getPassageiro(int fileira, int assento) {
            return this.lugares[fileira][assento];
        }

        public void setPassageiro(int fileira, int assento, PassageiroModelo passageiro) {
            this.lugares[fileira][assento] = passageiro;
        }
    */
    public boolean verificaLugarOcupado(int fileira, int assento) {
        return this.lugares[fileira][assento] != null;
    }


}

