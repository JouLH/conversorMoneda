//import jdk.incubator.vector.DoubleVector;

public class Moneda
{
    private String base;
    private String destino;
    private Double cantidad;
    private Double cantidadResultados;

    public Moneda(MonedaOmdb miMonedaOmdb, Double cantidad) {
        this.base = miMonedaOmdb.base_code();
        this.destino = miMonedaOmdb.target_code();
        this.cantidadResultados = Double.valueOf(miMonedaOmdb.conversion_result()) ;
        this.cantidad = cantidad;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCantidadResultados() {
        return cantidadResultados;
    }

    public void setCantidadResultados(Double cantidadResultados) {
        this.cantidadResultados = cantidadResultados;
    }

    @Override
    public String toString() {
        return "El valor " + this.cantidad + " [" + this.base + "]"+
                " corresponde al valor de final de ==> " + this.cantidadResultados + " ["
                + this.destino + "]";
    }
}
