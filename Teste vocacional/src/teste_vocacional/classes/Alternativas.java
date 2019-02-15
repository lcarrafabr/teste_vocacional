/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste_vocacional.classes;

import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Id;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo Fracalossi Lucas e Luciano Carrafa Benfica
 */
public class Alternativas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer codAlternativa;
    private Integer codPergunta;
    private String alternativa;
    private Integer codVocacao;
    private String letra;

    public Alternativas() {
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Alternativas(Integer codAlternativa) {
        this.codAlternativa = codAlternativa;
    }

    public Integer getCodAlternativa() {
        return codAlternativa;
    }

    public void setCodAlternativa(Integer codAlternativa) {
        this.codAlternativa = codAlternativa;
    }

    public Integer getCodPergunta() {
        return codPergunta;
    }

    public void setCodPergunta(Integer codPergunta) {
        this.codPergunta = codPergunta;
    }

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    public Integer getCodVocacao() {
        return codVocacao;
    }

    public void setCodVocacao(Integer codVocacao) {
        this.codVocacao = codVocacao;
    }


   public ResultSet getConsultar() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT * "+
                      "FROM alternativas a LEFT OUTER JOIN vocacoes v "+
                      "on a.codAlternativa = v.codVocacao "+
                      "where a.codAlternativa = a.codAlternativa ";

            int quantParam = 0;

            if (getCodPergunta() != null){
               comando = comando + " AND codPergunta = ? ";
            }

            if (getCodAlternativa() != null){
               comando = comando + " AND codAlternativa = ? ";
            }

            if (getAlternativa() != null){
               comando = comando + " AND Alternativa = ? ";
            }

            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCodPergunta() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodPergunta());
            }

            if (getCodAlternativa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodAlternativa());
            }

            if (getAlternativa() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getAlternativa());
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
        hash += (codAlternativa != null ? codAlternativa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alternativas)) {
            return false;
        }
        Alternativas other = (Alternativas) object;
        if ((this.codAlternativa == null && other.codAlternativa != null) || (this.codAlternativa != null && !this.codAlternativa.equals(other.codAlternativa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste_vocacional.Alternativas[codAlternativa=" + codAlternativa + "]";
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO alternativas  "+
" 	(codAlternativa,    "+
" 	codPergunta,        "+
" 	codVocacao,         "+
" 	alternativa,        "+
" 	letra                  "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodPergunta());
        stmt.setInt(2, getCodVocacao());
        stmt.setString(3, getAlternativa());
        stmt.setString(4, getLetra());

        stmt.execute();

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
}
    public ResultSet getConsultarAlternativas2() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select a.*, p.codPergunta, p.pergunta, v.codVocacao, v.vocacao " +
                    "from alternativas a, perguntas p, vocacoes v "+
                    "where a.codAlternativa = a.codAlternativa "+
                    "and p.codPergunta = p.codPergunta "+
                    "and v.codVocacao = v.codVocacao ";

            int quantParam = 0;

            if (getAlternativa() != null) {
                comando = comando + "AND a.alternativa = like ? ";
            }
            if (getCodAlternativa() != null){
               comando = comando + " AND a.CodAlternativa = ? ";
            }
            if (getCodPergunta() != null){
               comando = comando + " AND p.codPergunta like ? ";
            }
            if (getCodVocacao() != null){
               comando = comando + " AND v.vocacao = ? ";
            }



            comando = comando + " order by a.codAlternativa, a.alternativa ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getAlternativa() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getAlternativa()+"%");
            }
            if (getCodAlternativa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodAlternativa());
            }
            if (getCodPergunta() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodPergunta());
            }
            if (getCodVocacao() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodVocacao());
            }


        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }

   public void setAlterar(ClassConecta conexao){

        try{

        String comando = "UPDATE alternativas "+
" 	SET                     "+
" 	codPergunta = ?,               "+
" 	codVocacao = ?,  "+
" 	alternativa = ?,              "+
" 	letra = ?              "+
" 	WHERE "+
" 	codAlternativa = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCodPergunta());
        stmt.setInt(2, getCodVocacao());
        stmt.setString(3, getAlternativa());
        stmt.setString(4, getLetra());
        stmt.setInt(5, getCodAlternativa());

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

" DELETE FROM alternativas  "+
" 	WHERE "+
" 	codAlternativa = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodAlternativa());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
