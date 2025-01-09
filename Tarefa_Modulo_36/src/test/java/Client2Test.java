import com.Atividade.DAO.ClienteDAO;
import com.Atividade.DAO.ClienteDAO2;
import com.Atividade.DAO.IClienteDAO;
import com.Atividade.Domain.Cliente;
import com.Atividade.Exceptions.DAOException;
import com.Atividade.Exceptions.MaisDeUmRegistroException;
import com.Atividade.Exceptions.TableException;
import com.Atividade.Exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class Client2Test {


    private IClienteDAO<Cliente> clienteDao;

    private IClienteDAO<Cliente> clienteDB2Dao;

    private Random rd;

    public Client2Test() {
        this.clienteDao = new ClienteDAO();
        this.clienteDB2Dao = new ClienteDAO2();
        rd = new Random();
    }

    @After
    public void end() throws DAOException {
        Collection<Cliente> list1 = clienteDao.buscarTodos();
        excluir1(list1);

        Collection<Cliente> list2 = clienteDB2Dao.buscarTodos();
        excluir2(list2);
    }

    private void excluir1(Collection<Cliente> list) {
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    private void excluir2(Collection<Cliente> list) {
        list.forEach(cli -> {
            try {
                clienteDB2Dao.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Cliente cliente = criarCliente();
        clienteDao.cadastrar(cliente);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

//        cliente.setId(null);

        Cliente cliente2 = criarCliente();
        clienteDB2Dao.cadastrar(cliente2);

        Cliente clienteConsultado2 = clienteDB2Dao.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado2);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        Cliente clienteConsultado = clienteDao.consultar(retorno.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);

        Cliente clienteConsultado1 = clienteDao.consultar(retorno.getId());
        Assert.assertNull(clienteConsultado1);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Test");
        clienteDao.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Test", clienteAlterado.getNome());

        clienteDao.excluir(cliente);
        clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = criarCliente();
        Cliente retorno = clienteDao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        Cliente cliente1 = criarCliente();
        Cliente retorno1 = clienteDao.cadastrar(cliente1);
        Assert.assertNotNull(retorno1);

        Collection<Cliente> list = clienteDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection<Cliente> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.size() == 0);
    }

    private Cliente criarCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("elias");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        return cliente;
    }

}
