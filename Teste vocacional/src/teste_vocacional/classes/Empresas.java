/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste_vocacional.classes;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LKFalcao
 */
public class Empresas implements Serializable {

  
    private Integer codEmpresa;
    private String empresa;
    private String textoApresentacao;
    private String textoEncerramento;
    private String endereco;

    public Empresas() {
    }

    public Empresas(Integer codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Integer codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTextoApresentacao() {
        return textoApresentacao;
    }

    public void setTextoApresentacao(String textoApresentacao) {
        this.textoApresentacao = textoApresentacao;
    }

    public String getTextoEncerramento() {
        return textoEncerramento;
    }

    public void setTextoEncerramento(String textoEncerramento) {
        this.textoEncerramento = textoEncerramento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

     public void setCadastrar(){

        try{
        //ClassConecta conexao = new ClassConecta();

        String comando = "INSERT INTO empresas "+
	"(codEmpresa, "+
	"empresa, "+
	"textoApresentacao, "+
	"textoEncerramento, "+
	"endereco "+
	") "+
	"VALUES "+
	"(null, "+
	"?, "+
	"?, "+
	"?, "+
	"? "+
	") ";


        System.out.println("Executando operação...");
        //conexao.conecta();
        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1,getEmpresa());
        stmt.setString(2,getTextoApresentacao());
        stmt.setString(3,getTextoEncerramento());
        stmt.setString(4,getEndereco());

        stmt.execute();

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

      public ResultSet getConsultar() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT * "+
                      "FROM empresas "+
                      "where codEmpresa = codEmpresa ";

            int quantParam = 0;

            if (getCodEmpresa() != null){
               comando = comando + " AND codEmpresa = ? ";
            }

               if (getEmpresa() != null) {
                comando = comando + "AND empresa like ?";
            }

            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCodEmpresa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodEmpresa());
            }
            if (getEmpresa() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getEmpresa()+"%");
            }

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "brivcteste_vocacional.Empresas[codEmpresa=" + codEmpresa + "]";
    }

     public void setAlterar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando = "UPDATE empresas "+
" 	SET                     "+
" 	empresa = ?,            "+
" 	textoApresentacao = ?,  "+
" 	textoEncerramento = ?,  "+
"       endereco = ?            "+
" 	WHERE "+
" 	codEmpresa = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1, getEmpresa());
        stmt.setString(2, getTextoApresentacao());
        stmt.setString(3, getTextoEncerramento());
        stmt.setString(4, getEndereco());
        stmt.setInt(5, getCodEmpresa());

        stmt.executeUpdate();

        System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

     public void setExcluir(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando =

" DELETE FROM empresas  "+
" 	WHERE "+
" 	codEmpresa = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodEmpresa());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

}
