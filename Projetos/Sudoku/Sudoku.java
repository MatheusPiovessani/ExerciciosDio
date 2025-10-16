import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sudoku {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new Sudoku();
        });
    }

    //Guarda r e c para identificar posição na grade; é JButton, então cada célula é clicável

    class Tile extends JButton {
        int r; // linha
        int c; // coluna

        public Tile(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    int boardWidth = 600;
    int boardHeight = 650;

    //Cria o a tela principal que irá rodar o sudoku
    JFrame frame = new JFrame("Sudoku");
    JLabel textLabel = new JLabel();
    //Cria a parate superior da tela
    JPanel textPanel = new JPanel();
    //Cria a parte do meio da tela; o próprio jogo
    JPanel boardPanel = new JPanel();
    //Cria a parte inferior da tela, onde irá ter as opções de números
    JPanel buttonsPanel = new JPanel();

    //Instancia um botao, que irá ser o numero selecionado
    JButton numSelected = null;
    //Intancia um inteiro que representa a quantidade de erros feitas pelo usuario
    int errors = 0;

    //Cria o puzzel inicial
    String[] puzzle = {
            "--74916-5",
            "2---6-3-9",
            "-----7-1-",
            "-586----4",
            "--3----9-",
            "--62--187",
            "9-4-7---2",
            "67-83----",
            "81--45---"
    };

    //Cria a solução do puzzel para depois servir de comparação
    String[] solution = {
            "387491625",
            "241568379",
            "569327418",
            "758619234",
            "123784596",
            "496253187",
            "934176852",
            "675832941",
            "812945763"
    };

    


    public Sudoku() {
        frame.setSize(boardWidth, boardHeight); //Define o tamanho da tela principal
        frame.setResizable(false); //Define que o tamanho da tela é fixo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Faz o app parar de rodar ao fechar a janela do joog
        frame.setLocationRelativeTo(null); //Faz com que a janela seja aberta no meio da tela, automaticamente
        frame.setLayout(new BorderLayout());

        //TextLabel represente o que será escrito na parte de cima da janela principal
        //Abaixo a fonte e seu tamanho são definidas
        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
        //Defini que a mensagem será mostrada no meio da parte superior da tela
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Sudoku : 0 erros!"); //Mensagem inicial que será mostrada ao usuario

        textPanel.add(textLabel); //Adicional a textPanel ao painel principal
        frame.add(textPanel, BorderLayout.NORTH); //Adicional o painel principal na parte de cima da janela principal

        //Cria um layout de grid 9x9
        boardPanel.setLayout(new GridLayout(9, 9));
        setupTiles();
        //Adiciona o layout na parte do meio da janela principal
        frame.add(boardPanel, BorderLayout.CENTER);

        //Cria outro layout de grid 1x9, para que as opçoes sejam oferecidas ao usuario
        buttonsPanel.setLayout(new GridLayout(1, 9));
        setupButtons();
        //Adiciona o layout na parte de baixo da janela principal
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void setupTiles() {
        //Roda toda a matriz 
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                //Para cada posição cria Tile, define fonte/background dependendo se em puzzle há número ou '-'(vazio) 
                Tile tile = new Tile(r, c);
                char tileChar = puzzle[r].charAt(c);
                if (tileChar != '-') {
                    tile.setFont(new Font("Arial", Font.BOLD, 20));
                    tile.setText(String.valueOf(tileChar));
                    tile.setBackground(Color.lightGray);
                } else {
                    tile.setFont(new Font("Arial", Font.PLAIN, 20));
                    tile.setBackground(Color.white);
                }
                //Ajusta bordas para destacar sub-blocos 3x3(usa MatteBorder para as linhas 3 e 6);
                if (r == 2 && c == 2 || r == 2 && c == 5 || r == 5 && c == 2 || r == 5 && c == 5) {
                    tile.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, Color.black));
                } else if (r == 2 || r == 5) {
                    tile.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, Color.black));
                } else if (c == 2 || c == 5) {
                    tile.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, Color.black));

                } else {
                    tile.setBorder(BorderFactory.createLineBorder(Color.black));
                }
                tile.setFocusable(false);
                boardPanel.add(tile);

                /*Adiciona ActionListener que, ao clicar:
                    - Recupera tile.r e tile.c;
                    - Se numSelected != null (tem numero selecionado) tenta preencher;
                    - Compara com solution; coloca texto ou registra erro
                */

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Tile tile = (Tile) e.getSource();
                        int r = tile.r;
                        int c = tile.c;
                        if (numSelected != null) {
                            String current = tile.getText();
                            if (current != null && !current.isEmpty()) {
                                return; // já preenchida (dada ou colocada)
                            }
                            String numSelectedText = numSelected.getText();
                            String tileSolution = String.valueOf(solution[r].charAt(c));
                            if (tileSolution.equals(numSelectedText)) {
                                tile.setText(numSelectedText);
                            } else {
                                errors += 1;
                                textLabel.setText("Sudoku : " + String.valueOf(errors) + " erros!");
                            }
                        }
                    }
                });
            }
        }
    }
    /*
     * Cria 9 botões. Ao clicar, marca esse botão como selecionado(numSelected) e muda background para indicar seleção
     */

    private void setupButtons() {
        for (int i = 1; i < 10; i++) {
            //Cria um novo botão por iteração
            JButton button = new JButton();
            //Define a fonte e texto do botão(mostra o dígito);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setText(String.valueOf(i));
            //Evita que o botão receba foco de teclado(sem contorno quando cliclado);
            button.setFocusable(false);
            //Define fundo branco padrao
            button.setBackground(Color.white);
            //Adiciona o botão no painel
            buttonsPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //Ao cliclar: obtém o botão fonte...
                    JButton button = (JButton) e.getSource();
                    //Clicando no mesmo botão ja selecionado, ele desseleciona
                    if(numSelected == button){
                        button.setBackground(Color.white);
                        numSelected = null;
                        return;
                    }
                    //Se já existir um numSelected(outro botão previamente selecionado), restaura seu fundo para branco
                    if (numSelected != null) {
                        numSelected.setBackground(Color.white);
                    }
                    //Atualiza numSelected = button; e dá ao botão atual  lightGray para indicar seleção;
                    numSelected = button;
                    numSelected.setBackground(Color.lightGray);
                }
            });
        }

    }
}