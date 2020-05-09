package game;

public class Tablero {
    //ARREGLO EN DONDE SE GUARDAN LOS MOVIMIENTOS DE LOS JUGADORES
    public char tablero[][] = new char [3][3];

    public Tablero() {
        
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public char[][] getTablero() {
        return tablero;
    }
    
    //METODO QUE INICIA EL ARREGLO 
    public void inicializarTablero(){
        for(int i = 0; i < 3; i++ ){
            for(int j = 0; j< 3; j++){
                tablero[i][j] = 'n';
            }
        }
    }
    
    //METODO PARA RECUPERAR EL VALOR DE UNA DETERMINADA POSICION
    public char getPosicionTablero(int i, int j) {
        return tablero[i][j];
    }
    
    //METODO PARA ASIGNAR EL MOVIMIENTO A UNA DETERMINADA POSICION
    public void asignarPosicion(int i, int j, char casilla){
        tablero[i][j] = casilla;
    }
    
    //METODO PARA IMPRIMIR EL TABLERO
    public void imprimirTablero(){
        System.out.println("*****************");
        for(int i = 0; i < 3; i++ ){
            for(int j = 0; j< 3; j++){
                if(j<2){
                    System.out.print(" " + tablero[i][j] + " |");
                }
                
                else{
                    System.out.print(" " + tablero[i][j] + " ");                                           
                }
            }    
            
            if(i<2){
                System.out.println("\n-----------");               
            }
        }
        System.out.println("*****************");
    }
}