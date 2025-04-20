//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario(1, "German", "german@gmail.com");
        Tecnico tecnico1 = new Tecnico(1, "Carlos", "Sistemas");
        TicketSoporte ticket1 = new TicketSoporte("Problemas en la computadora", usuario1);

        ticket1.asignarTecnico(tecnico1.getNombre());
        SistemaSoporte sistema = new SistemaSoporte();
        sistema.agregarTicket(ticket1);

        ticket1.cerrarTicket();

        sistema.listarTickets();
    }
}