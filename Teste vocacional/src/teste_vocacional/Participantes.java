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
public class Participantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer codParticipante;
    private String participante;
    private String cidade;
    private String uf;
    private String tel;
    private String email;

    public Participantes() {
    }

    public Participantes(Integer codParticipante) {
        this.codParticipante = codParticipante;
    }

    public Integer getCodParticipante() {
        return codParticipante;
    }

    public void setCodParticipante(Integer codParticipante) {
        this.codParticipante = codParticipante;
    }

    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public ResultSet getConsultar() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT * "+
                      "FROM participantes "+
                      "where codParticipante = codParticipante ";

            int quantParam = 0;

            if (getParticipante() != null){
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

      public Integer getId() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT max(codParticipante) as ID "+
                      "FROM participantes ";



            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


        resultSet = stmtQuery.executeQuery();
        resultSet.first();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet.getInt("ID");
     }

       public Integer getQuantidadeParticipante() throws SQLException{
            ResultSet resultSet = null;
            String comando;
            comando = "select count(codParticipante) as ID2 " +
                    " from participantes " ;


            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);
            resultSet = stmtQuery.executeQuery();
            resultSet.first();


            return resultSet.getInt("ID2");
        }

    void setCadastrar(){

        try{
        //ClassConecta conexao = new ClassConecta();

        String comando = "INSERT INTO participantes "+
	"(codParticipante, "+
	"participante, "+
	"cidade, "+
	"uf, "+
	"tel, "+
	"email "+
	") "+
	"VALUES "+
	"(null, "+
	"?, "+
	"?, "+
	"?, "+
	"?, "+
	"? "+
	") ";


        System.out.println("Executando operação...");
        //conexao.conecta();
        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1,getParticipante());
        stmt.setString(2,getCidade());
        stmt.setString(3,getUf());
        stmt.setString(4,getTel());
        stmt.setString(5,getEmail());

        stmt.execute();

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet getConsultarParticipantesVocacoes() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT participantes.`codParticipante` AS codParticipante, "+
                      "participantes.`participante` AS participante, "+
                      "participantes.`cidade` AS cidade, "+
                      "participantes.`uf` AS uf, "+
                      "participantes.`tel` AS tel, "+
                      "participantes.`email` AS email, "+
                      "( "+
                      "SELECT v.vocacao "+
                      "FROM respostas r INNER JOIN alternativas a "+
                      "on r.codAlternativa = a.codAlternativa "+
                      "INNER JOIN vocacoes v "+
                      "on v.codVocacao = a.codVocacao "+
                      "INNER JOIN participantes p "+
                      "on r.codParticipante = p.codParticipante "+
                      "where p.codParticipante = participantes.codParticipante "+
                      "group by v.codVocacao limit 1 "+
                      ") as vocacao "+
                      "FROM `participantes` participantes ";

            int quantParam = 0;

            if (getParticipante() != null){
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
        hash += (codParticipante != null ? codParticipante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participantes)) {
            return false;
        }
        Participantes other = (Participantes) object;
        if ((this.codParticipante == null && other.codParticipante != null) || (this.codParticipante != null && !this.codParticipante.equals(other.codParticipante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste_vocacional.Participantes[codParticipante=" + codParticipante + "]";
    }

}
