package com.example.pratica824;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private VBox rootBase;
    @FXML
    private AnchorPane root;

    private AgenziaViaggi agenziaViaggi=new AgenziaViaggi();

    @FXML
    protected void aggiungi() {
        rootBase.getChildren().clear();

        Button b1=new Button("-->");
        b1.setDisable(true);

        ToggleGroup tipoPacchetto=new ToggleGroup();
        RadioButton r1=new RadioButton("Base");
        RadioButton r2=new RadioButton("Con Volo");
        RadioButton r3=new RadioButton("Con pasti");
        RadioButton r4=new RadioButton("Con pasti ed escursioni");
        r1.setToggleGroup(tipoPacchetto);
        r1.setOnMouseClicked( e -> {
            b1.setDisable(false);
        });
        r2.setToggleGroup(tipoPacchetto);
        r2.setOnMouseClicked( e -> {
            b1.setDisable(false);
        });
        HBox h1=new HBox();
        h1.getChildren().addAll(r1,r2);
        h1.setSpacing(10);
        r3.setToggleGroup(tipoPacchetto);
        r3.setOnMouseClicked( e -> {
            b1.setDisable(false);
        });
        r4.setToggleGroup(tipoPacchetto);
        r4.setOnMouseClicked( e -> {
            b1.setDisable(false);
        });
        HBox h2=new HBox();
        h2.getChildren().addAll(r3,r4);
        h2.setSpacing(10);

        rootBase.getChildren().addAll(new Label("INSERIMENTO DI UN NUOVO PACCHETTO"),new Label("Scegli il tipo di pacchetto prima di continuare:"),h1,h2,b1);

        b1.setOnMouseClicked( e -> {
            rootBase.getChildren().clear();
            //Elementi comuni
            Label l1=new Label("Inserire destinazione:");
            TextField t1=new TextField();
            t1.setPromptText("Malibù");
            Label l2=new Label("Inserire durata in giorni:");
            TextField t2=new TextField();
            t2.setPromptText("7");
            Label l3=new Label("Inserire costo base del pacchetto:");
            TextField t3=new TextField();
            t3.setPromptText("1700.00 €");
            Button b2=new Button("Inserisci");

            if (r1.isSelected()){
                rootBase.getChildren().addAll(l1,t1,l2,t2,l3,t3,b2);
                b2.setOnMouseClicked( e1 -> {
                    rootBase.getChildren().clear();
                    if(agenziaViaggi.inserisci(new Viaggio(t1.getText(),Integer.parseInt(t2.getText()),Double.parseDouble(t3.getText()))))
                        mostraMessaggioConferma();
                    else
                        mostraMessaggioErrore();
                });
            } else if (r2.isSelected()) {
                b2.setDisable(true);
                ToggleGroup tipoVolo=new ToggleGroup();
                RadioButton r10=new RadioButton("Andata e ritorno");
                RadioButton r20=new RadioButton("Sola andata");
                r10.setToggleGroup(tipoVolo);
                r10.setOnMouseClicked( e1 -> {
                    b2.setDisable(false);
                });
                r20.setToggleGroup(tipoVolo);
                r20.setOnMouseClicked( e1 -> {
                    b2.setDisable(false);
                });
                HBox h10=new HBox();
                h10.getChildren().addAll(r10,r20);
                h10.setSpacing(10);

                rootBase.getChildren().addAll(l1,t1,l2,t2,l3,t3,h10,b2);

                b2.setOnMouseClicked( e2 -> {
                    rootBase.getChildren().clear();
                    if (r10.isSelected()){
                        if(agenziaViaggi.inserisci(new ViaggioVolo(t1.getText(),Integer.parseInt(t2.getText()),Double.parseDouble(t3.getText()),true)))
                            mostraMessaggioConferma();
                        else
                            mostraMessaggioErrore();
                    }else{
                        if(agenziaViaggi.inserisci(new ViaggioVolo(t1.getText(),Integer.parseInt(t2.getText()),Double.parseDouble(t3.getText()),false)))
                            mostraMessaggioConferma();
                        else
                            mostraMessaggioErrore();
                    }
                });
            } else if (r3.isSelected()) {
                b2.setDisable(true);
                ToggleGroup tipoPasto=new ToggleGroup();
                RadioButton r10=new RadioButton("Pensione completa");
                RadioButton r20=new RadioButton("Mezza pensione");
                r10.setToggleGroup(tipoPasto);
                r10.setOnMouseClicked( e1 -> {
                    b2.setDisable(false);
                });
                r20.setToggleGroup(tipoPasto);
                r20.setOnMouseClicked( e1 -> {
                    b2.setDisable(false);
                });
                HBox h10=new HBox();
                h10.getChildren().addAll(r10,r20);
                h10.setSpacing(10);

                rootBase.getChildren().addAll(l1,t1,l2,t2,l3,t3,h10,b2);

                b2.setOnMouseClicked( e2 -> {
                    rootBase.getChildren().clear();
                    if (r10.isSelected()){
                        if(agenziaViaggi.inserisci(new ViaggioPasti(t1.getText(),Integer.parseInt(t2.getText()),Double.parseDouble(t3.getText()),true)))
                            mostraMessaggioConferma();
                        else
                            mostraMessaggioErrore();
                    }else{
                        if(agenziaViaggi.inserisci(new ViaggioPasti(t1.getText(),Integer.parseInt(t2.getText()),Double.parseDouble(t3.getText()),false)))
                            mostraMessaggioConferma();
                        else
                            mostraMessaggioErrore();
                    }
                });
            }else{
                b2.setDisable(true);
                ToggleGroup tipoPasto=new ToggleGroup();
                RadioButton r10=new RadioButton("Pensione completa");
                RadioButton r20=new RadioButton("Mezza pensione");
                r10.setToggleGroup(tipoPasto);
                r10.setOnMouseClicked( e1 -> {
                    b2.setDisable(false);
                });
                r20.setToggleGroup(tipoPasto);
                r20.setOnMouseClicked( e1 -> {
                    b2.setDisable(false);
                });
                HBox h10=new HBox();
                h10.getChildren().addAll(r10,r20);
                h10.setSpacing(10);

                Label l4=new Label("Inserire numero di escursioni:");
                TextField t4=new TextField();
                t4.setPromptText("10");

                rootBase.getChildren().addAll(l1,t1,l2,t2,l3,t3,h10,l4,t4,b2);

                b2.setOnMouseClicked( e2 -> {
                    rootBase.getChildren().clear();
                    if (r10.isSelected()){
                        if(agenziaViaggi.inserisci(new ViaggioEscursioni(t1.getText(),Integer.parseInt(t2.getText()),Double.parseDouble(t3.getText()),true,Integer.parseInt(t4.getText()))))
                            mostraMessaggioConferma();
                        else
                            mostraMessaggioErrore();
                    }else{
                        if(agenziaViaggi.inserisci(new ViaggioEscursioni(t1.getText(),Integer.parseInt(t2.getText()),Double.parseDouble(t3.getText()),false,Integer.parseInt(t4.getText()))))
                            mostraMessaggioConferma();
                        else
                            mostraMessaggioErrore();
                    }
                });
            }
        });
    }
    @FXML
    protected void vediTutto() {
        rootBase.getChildren().clear();
        if (agenziaViaggi.getInseriti()==0)
            rootBase.getChildren().addAll(new Label("Nessun pacchetto ancora inserito"));
        else
            rootBase.getChildren().addAll(new Label("ECCO A TE TUTTI I PACCHETTI PRESENTI:"),new Label(agenziaViaggi.toString()));
    }
    @FXML
    protected void costoMedio() {
        rootBase.getChildren().clear();
        if (agenziaViaggi.getInseriti()==0)
            rootBase.getChildren().addAll(new Label("Nessun pacchetto ancora inserito"));
        else
            rootBase.getChildren().addAll(new Label("COSTO MEDIO DEI NOSTRI PACCHETTI:"),new Label("COSTO MEDIO: "+agenziaViaggi.getCostoMedio()));
    }
    @FXML
    protected void maxMin() {
        rootBase.getChildren().clear();
        if (agenziaViaggi.getInseriti()==0)
            rootBase.getChildren().addAll(new Label("Nessun pacchetto ancora inserito"));
        else
            rootBase.getChildren().addAll(new Label("ECCO A TE TUTTI I PACCHETTI CON COSTO MASSIMO E MINIMO:"),new Label(agenziaViaggi.getMinMax()));
    }
    @FXML
    public void mostraMessaggioConferma() {
        Label messaggioConferma = new Label("Salvato correttamente");
        messaggioConferma.setStyle("-fx-background-color: #00FF00; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px;");
        messaggioConferma.setTextFill(Color.WHITE);
        messaggioConferma.setOpacity(0.9);
        messaggioConferma.setLayoutX(0);
        messaggioConferma.setLayoutY(520);

        root.getChildren().add(messaggioConferma);

        PauseTransition pausa = new PauseTransition(Duration.seconds(3));
        pausa.setOnFinished(event -> root.getChildren().remove(messaggioConferma));
        pausa.play();
    }
    @FXML
    public void mostraMessaggioErrore() {
        Label messaggioConferma = new Label("Errore nel salvataggio");
        messaggioConferma.setStyle("-fx-background-color: #E44C64; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px;");
        messaggioConferma.setTextFill(Color.WHITE);
        messaggioConferma.setOpacity(0.9);
        messaggioConferma.setLayoutX(0);
        messaggioConferma.setLayoutY(520);

        root.getChildren().add(messaggioConferma);

        PauseTransition pausa = new PauseTransition(Duration.seconds(3));
        pausa.setOnFinished(event -> root.getChildren().remove(messaggioConferma));
        pausa.play();
    }
}