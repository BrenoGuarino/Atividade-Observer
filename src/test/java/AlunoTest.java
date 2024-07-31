import org.example.Cliente;
import org.example.ServicoStreaming;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void deveNotificarUmCliente() {
        ServicoStreaming servicoStreaming = new ServicoStreaming(27, "Netflix");
        Cliente cliente = new Cliente("Fulano");
        cliente.assinarServico(servicoStreaming);
        servicoStreaming.atualizarCatalogo();
        assertEquals("Fulano, novo filme adicionado no Serviço de Streaming Netflix por 27 R$" , cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        ServicoStreaming servicoStreaming = new ServicoStreaming(15,"Amazon Prime");
        Cliente cliente1 = new Cliente("Fulano");
        Cliente cliente2 = new Cliente("Ciclano");
        cliente1.assinarServico(servicoStreaming);
        cliente2.assinarServico(servicoStreaming);
        servicoStreaming.atualizarCatalogo();
        assertEquals("Fulano, novo filme adicionado no Serviço de Streaming Amazon Prime por 15 R$", cliente1.getUltimaNotificacao());
        assertEquals("Ciclano, novo filme adicionado no Serviço de Streaming Amazon Prime por 15 R$", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        ServicoStreaming servicoStreaming = new ServicoStreaming(15,"Amazon Prime");
        Cliente cliente = new Cliente("Fulano");
        servicoStreaming.atualizarCatalogo();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteservico1() {
        ServicoStreaming servico1 = new ServicoStreaming(27, "Netflix");
        ServicoStreaming servico2 = new ServicoStreaming(15,"Amazon Prime");
        Cliente cliente1 = new Cliente("cliente1");
        Cliente cliente2 = new Cliente("cliente2");
        cliente1.assinarServico(servico1);
        cliente2.assinarServico(servico2);
        servico1.atualizarCatalogo();
        assertEquals("cliente1, novo filme adicionado no Serviço de Streaming Netflix por 27 R$", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}
