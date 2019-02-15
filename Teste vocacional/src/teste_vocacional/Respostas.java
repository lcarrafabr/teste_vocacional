/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste_vocacional;

import teste_vocacional.classes.ClassConecta;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Id;
import javax.swing.JOptionPane;

/**
 *
 * @author LKFalcao
 */
public class Respostas implements Serializable {
    @Id
    private Integer codResposta;
    private Integer codPergunta;
    private Integer codAlternativa;
    private Integer codParticipante;

    public Respostas() {
    }

    public Respostas(Integer codResposta) {
        this.codResposta = codResposta;
    }

    public Integer getCodResposta() {
        return codResposta;
    }

    public void setCodResposta(Integer codResposta) {
        this.codResposta = codResposta;
    }

    public Integer getCodPergunta() {
        return codPergunta;
    }

    public void setCodPergunta(Integer codPergunta) {
        this.codPergunta = codPergunta;
    }

    public Integer getCodAlternativa() {
        return codAlternativa;
    }

    public void setCodAlternativa(Integer codAlternativa) {
        this.codAlternativa = codAlternativa;
    }

    public Integer getCodParticipante() {
        return codParticipante;
    }

    public void setCodParticipante(Integer codParticipante) {
        this.codParticipante = codParticipante;
    }

     public ResultSet getConsultar() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT a.*,v.* "+
                      "FROM alternativas a INNER JOIN vocacoes v "+
                      "on a.codAlternativa = v.codVocacao "+
                      "where a.codAlternativa = a.codAlternativa ";

            int quantParam = 0;

            if (getCodPergunta() != null){
               comando = comando + " AND codPergunta = ? ";
            }

            if (getCodAlternativa() != null){
               comando = comando + " AND codAlternativa = ? ";
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

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }

     void setCadastrar(){

        try{
        //ClassConecta conexao = new ClassConecta();

        String comando = "INSERT INTO respostas "+
	"(codResposta,"+
	"codPergunta, "+
	"codAlternativa,"+
	"codParticipante "+
	") "+
	"VALUES "+
	"(null, "+
	"?, "+
	"?, "+
	"? "+
	") ";


        System.out.println("Executando operação...");
        //conexao.conecta();
        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCodPergunta());
        stmt.setInt(2,getCodAlternativa());
        stmt.setInt(3,getCodParticipante());

        stmt.execute();

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

     public ResultSet getTabularParaImprimir(int codParticipante) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT CONCAT(p.participante,',',' SUA VOCAÇÃO PROFISSIONAL É :\\n ',v.vocacao) AS vocacao,COUNT(*) AS TOTAL "+
                      "FROM participantes p "+
                      "INNER JOIN respostas r "+
                      "ON p.codParticipante = r.codParticipante "+
                      "INNER JOIN perguntas pe "+
                      "ON pe.codPergunta = r.codPergunta "+
                      "INNER JOIN alternativas a "+
                      "ON a.codAlternativa = r.codAlternativa "+
                      "INNER JOIN vocacoes v "+
                      "ON v.codVocacao = a.codVocacao ";

            int quantParam = 0;

            if (codParticipante > 0){
               comando = comando + " AND p.codParticipante = ? ";
            }

           comando = comando + "GROUP BY a.codVocacao "+
                               "ORDER BY 2 DESC LIMIT 1 ";

            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (codParticipante > 0){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, codParticipante);
            }

        resultSet = stmtQuery.executeQuery();
        resultSet.first();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }



     public String getTabular(int codParticipante) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT CONCAT(p.participante,',',' SUA VOCAÇÃO PROFISSIONAL É : ',v.vocacao) AS vocacao,COUNT(*) AS TOTAL "+
                      "FROM participantes p "+
                      "INNER JOIN respostas r "+
                      "ON p.codParticipante = r.codParticipante "+
                      "INNER JOIN perguntas pe "+
                      "ON pe.codPergunta = r.codPergunta "+
                      "INNER JOIN alternativas a "+
                      "ON a.codAlternativa = r.codAlternativa "+
                      "INNER JOIN vocacoes v "+
                      "ON v.codVocacao = a.codVocacao ";

            int quantParam = 0;

            if (codParticipante > 0){
               comando = comando + " AND p.codParticipante = ? ";
            }

           comando = comando + "GROUP BY a.codVocacao "+
                               "ORDER BY 2 DESC LIMIT 1 ";

            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (codParticipante > 0){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, codParticipante);
            }

        resultSet = stmtQuery.executeQuery();
        resultSet.first();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet.getString("vocacao");
     }

   public ResultSet getResultado() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT v.vocacao , count(v.codVocacao)/( "+
            "select count(*) "+
            "from respostas re "+
            "where re.codParticipante = p.codParticipante "+
            ") as votos "+
            "FROM respostas r INNER JOIN alternativas a "+
            "on r.codAlternativa = a.codAlternativa "+
            "INNER JOIN vocacoes v "+
            "on v.codVocacao = a.codVocacao "+
            "INNER JOIN participantes p "+
            "on r.codParticipante = p.codParticipante "+
            "group by v.codVocacao ";


            int quantParam = 0;

            if (getCodParticipante() != null){
               comando = comando + " AND codParticipante = ? ";
            }


            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCodParticipante() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodParticipante());
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
        hash += (codResposta != null ? codResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respostas)) {
            return false;
        }
        Respostas other = (Respostas) object;
        if ((this.codResposta == null && other.codResposta != null) || (this.codResposta != null && !this.codResposta.equals(other.codResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste_vocacional.Respostas[codResposta=" + codResposta + "]";
    }

}
