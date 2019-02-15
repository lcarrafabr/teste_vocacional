/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste_vocacional.classes;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Id;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo Fracalossi Lucas e Luciano Carrafa benfica.
 */
public class Vocacoes implements Serializable  {
    @Id
    private Integer codVocacao;
    private String vocacao;
    private Integer cod_Empresa;

    public Integer getCod_Empresa() {
        return cod_Empresa;
    }

    public void setCod_Empresa(Integer cod_Empresa) {
        this.cod_Empresa = cod_Empresa;
    }

    public Vocacoes() {
    }

    public Vocacoes(Integer codVocacao) {
        this.codVocacao = codVocacao;
    }

    public Integer getCodVocacao() {
        return codVocacao;
    }

    public void setCodVocacao(Integer codVocacao) {
        this.codVocacao = codVocacao;
    }

    public String getVocacao() {
        return vocacao;
    }

    public void setVocacao(String vocacao) {
        this.vocacao = vocacao;
    }

    public void setCadastrar(){

        try{
        //ClassConecta conexao = new ClassConecta();

        String comando = "INSERT INTO vocacoes "+
	"(codVocacao, "+
	"codEmpresa, "+
	"vocacao "+
	") "+
	"VALUES "+
	"(null, "+
	"?, "+
	"? "+
	") ";


        System.out.println("Executando operação...");
        //conexao.conecta();
        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_Empresa());
        stmt.setString(2,getVocacao());
        

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
            comando = "SELECT v.*, e.empresa "+
                      "FROM vocacoes v, empresas e "+
                      "where e.codEmpresa = e.codEmpresa "+
                      "and v.codVocacao = v.codVocacao ";

            int quantParam = 0;

            if (getCodVocacao() != null){
               comando = comando + " AND v.codVocacao = ? ";
            }
            if (getVocacao() != null) {
                comando = comando + "AND v.vocacao like ? ";
            }
            
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCodVocacao() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodVocacao());
            }
            if (getVocacao() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getVocacao()+"%");
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
        hash += (codVocacao != null ? codVocacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vocacoes)) {
            return false;
        }
        Vocacoes other = (Vocacoes) object;
        if ((this.codVocacao == null && other.codVocacao != null) || (this.codVocacao != null && !this.codVocacao.equals(other.codVocacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste_vocacional.Vocacoes[codVocacao=" + codVocacao + "]";
    }

    public void setAlterar(ClassConecta conexao){

        try{
        String comando = "UPDATE vocacoes "+
" 	SET               "+
" 	codEmpresa = ?,   "+
" 	vocacao = ?       "+
" 	WHERE "+
" 	codVocacao = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_Empresa());
        stmt.setString(2, getVocacao());
        stmt.setInt(3, getCodVocacao());

        stmt.executeUpdate();

        System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setExcluir(){

        try{
        String comando =

" DELETE FROM vocacoes  "+
" 	WHERE "+
" 	codVocacao = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodVocacao());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

}
