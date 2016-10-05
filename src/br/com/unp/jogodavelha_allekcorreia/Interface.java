
package br.com.unp.jogodavelha_allekcorreia;


public class Interface {
    public char[][] tabuleiro = new char[3][3];
    char jogadoratual = 'X';
    public void limparTabuleiro(){
        for(int linhas = 0; linhas < 3; linhas++){
            for (int colunas = 0; colunas < 3; colunas++){
                tabuleiro[linhas][colunas] = ' ';
            }
        }
    }
    public Interface(){
        limparTabuleiro();
    }
    public void mostrarTabuleiro(){
        System.out.println("\t\t#############");
        for (int i = 0; i < 3; i++) { 
            System.out.print("\t\t# "); 
            for (int j = 0; j < 3; j++) { 
                if (j < 2){
                    System.out.print(tabuleiro[i][j] + " | "); 
                }
                else if (j == 2){
                    System.out.println(tabuleiro[i][j] + " #");
                }
            }
         
        }
        System.out.println("\t\t#############");
    }
    public boolean tabuleiroCheio(){
        boolean cheio = true;
        for (int linha = 0; linha < 3; linha++){
            for (int coluna = 0; coluna < 3; coluna++){
                if (tabuleiro[linha][coluna] == ' '){
                    cheio = false;
                }
            }
        }
        return cheio;
    }
    public boolean checarLinha(){
        for (int i = 0; i < 3; i++){
            if((tabuleiro[i][0] != ' ') && (tabuleiro[i][1] == tabuleiro[i][0]) && (tabuleiro[i][2] == tabuleiro[i][0]))
                return true;
        }
        return false;
    }
    public boolean checarColuna(){
        for (int i = 0; i < 3; i++){
            if ((tabuleiro[0][i] != ' ') && (tabuleiro[1][i] == tabuleiro[0][i]) && (tabuleiro[2][i] == tabuleiro[0][i])){
                return true;
            }
        }
        return false;
    }
    public boolean checarDiago(){
        if ((tabuleiro[0][0] != ' ') && (tabuleiro[1][1] == tabuleiro[0][0]) && (tabuleiro[2][2] == tabuleiro[0][0])
            || (tabuleiro [2][0] != ' ') && (tabuleiro[1][1] == tabuleiro[2][0]) && (tabuleiro[0][2] == tabuleiro[2][0])){
            return true;
        }
        return false;
    }
    public boolean ganhou(){
        return (checarLinha() || checarColuna() || checarDiago());
    }
    public boolean jogada(int linha, int coluna){
        if ((linha >= 0) && (linha < 3)){
            if ((coluna >= 0) && (coluna < 3)){
                
                if (tabuleiro[linha][coluna] == ' '){
                    tabuleiro[linha][coluna] = jogadoratual;
                    return true;
                }
                else{
                    System.out.println("Lugar já preenchido!");
                    return false;
                }
            }
            else{
                System.out.println("Coluna inválida!");
                return false;
            }
        }
        else{
            System.out.println("Linha inválida!");
            return false;
        }
    }
    
    public void TrocarJogador(){
        if (jogadoratual == 'X')
            jogadoratual = 'O';
        else
            jogadoratual = 'X';
    }
}


/*0  1  2
0 x  x  x
1 x  x  x
2 x  x  x*/