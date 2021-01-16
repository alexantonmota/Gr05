package VistaCliente;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Asientos {
	
	public static void main(){
		int size=6;
		char salaCine[][]=new char[size][size];
		salaCine=create(size);
		boolean ban=true; //para ejecutar programa

		do{
			UIManager UI=new UIManager();
			UI.put("OptionPane.background", Color.ORANGE);
			UI.put("Panel.background", Color.GRAY);
			UI.put("OptionPane.messageForeground", Color.ORANGE);

			int opcion=(int)Integer.parseInt(JOptionPane.showInputDialog("\nASIENTOS:\n"+
					"1.- Ver estado de la Sala.\n"
//					
));

			switch(opcion){
			case 1: display(salaCine); break;
//			case 2: salaCine=asignarLugar(salaCine);break;
//			case 3: salaCine=escogerLugar(salaCine);break;
			default: ban=false;
			}
		}while(ban);
	}

	public static char[][] create(int size){
		char matriz[][]=new char[size][size];
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				matriz[i][j]='v';
		return matriz;
	}

	
	public static void display(char mat[][]){
		String cad="";
		for(int i=0;i<mat.length;i++){
			for(int j=0; j<mat[i].length; j++){
				cad+=mat[i][j]+" ";
			}
			cad+="\n";
		}
		JOptionPane.showMessageDialog(null,cad);
	}

//	public static char[][] asignarLugar(char mat[][]){
//		char matriz[][]=mat;
//		for(int i=0;i<matriz.length;i++){
//			for(int j=0;j<matriz[i].length;j++){
//				if(matriz[i][j]=='V'){
//					JOptionPane.showMessageDialog(null,"Lugar asignado en la fila "+(i+1)+
//							" y columna "+(j+1));
//					matriz[i][j]='X';
//					return matriz;
//				}else continue;
//			}
//		}
//		return matriz;
//	}
//
//	public static char[][] escogerLugar(char mat[][]){
//		char matriz[][]=mat;
//		do{
//			int fila=(int)Integer.parseInt(JOptionPane.showInputDialog("Selecciona la fila:"));
//			int columna=(int)Integer.parseInt(JOptionPane.showInputDialog("Selecciona la Columna:"));
//			if(matriz[fila-1][columna-1]=='x') JOptionPane.showMessageDialog(null,"Vuelve a seleccionar, ese lugar ya se encuentra ocupado");
//			else{
//				JOptionPane.showMessageDialog(null,"Lugar asignado a la fila "+fila+" y columna "+columna);
//				matriz[fila-1][columna-1]='x';
//				break;
//			}
//		}while(1==1);
//		return matriz;
//	}
}
