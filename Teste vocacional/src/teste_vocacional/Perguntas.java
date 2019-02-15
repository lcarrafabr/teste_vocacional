/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste_vocacional;

import com.mysql.jdbc.PreparedStatement;
import teste_vocacional.classes.ClassConecta;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Id;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo Fracalossi Lucas e Luciano Carrafa Benfica
 */

public class Perguntas implements Serializable {
    @Id
    private Integer codPergunta;
    private String pergunta;
    private Integer sequencia;

    public Perguntas() {
    }

    public Perguntas(Integer codPergunta) {
        this.codPergunta = codPergunta;
    }

    public Integer getCodPergunta() {
        return codPergunta;
    }

    public void setCodPergunta(Integer codPergunta) {
        this.codPergunta = codPergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPergunta != null ? codPergunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perguntas)) {
            return false;
        }
        Perguntas other = (Perguntas) object;
        if ((this.codPergunta == null && other.codPergunta != null) || (this.codPergunta != null && !this.codPergunta.equals(other.codPergunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste_vocacional.Perguntas[codPergunta=" + codPergunta + "]";
    }

     public ResultSet getConsultar() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select * " +
                    "from perguntas "+
                    "where codPergunta = codPergunta ";

            int quantParam = 0;

            if (getCodPergunta() != null){
               comando = comando + " AND codPergunta = ? ";
            }

            if (getSequencia() != null){
               comando = comando + " AND sequencia = ? ";
            }
            if (getPergunta() != null) {
                comando = comando + "AND pergunta like ? ";
            }

            comando = comando + " order by sequencia ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCodPergunta() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodPergunta());
            }

            if (getSequencia() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getSequencia());
            }
            if (getPergunta() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getPergunta()+"%");
            }

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }

    public int getQuantidadeTotalResposta() throws SQLException{
            ResultSet resultSet = null;
            String comando;
            comando = "select count(*) as quantidade " +
                    " from perguntas " ;


            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);
            resultSet = stmtQuery.executeQuery();
            resultSet.first();


            return resultSet.getInt("quantidade");
        }

     public int getQuantidadeTotalPergunta() throws SQLException{
            ResultSet resultSet = null;
            String comando;
            comando = "select max(sequencia) as quantidade " +
                    " from perguntas " ;


            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);
            resultSet = stmtQuery.executeQuery();
            resultSet.first();


            return resultSet.getInt("quantidade");
        }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO perguntas  "+
" 	(codPergunta,     "+
" 	pergunta,         "+
" 	sequencia         "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1,getPergunta());
        stmt.setInt(2, getSequencia());

        stmt.execute();

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
}

    public Integer verificaSequencia(Integer identificador) throws SQLException    {
        ResultSet resultSet = null;

        try
        {

            String comando;
            comando = "SELECT IfNull(p.sequencia,0) as sequencia "+
                      "FROM perguntas p "+
                      "WHERE "+
                      "p.sequencia = "+identificador;

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


        resultSet = stmtQuery.executeQuery();
        resultSet.last();

        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi possível executar o comando SQL" + sqlex);

        }
     if (resultSet.getRow() == 0){
         System.out.println("wasNull");
         return 0;
     }else{
            System.out.println("else");
     return resultSet.getInt("sequencia");
        }
     }

    public void setAlterar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando = "UPDATE perguntas "+
" 	SET                 "+
" 	sequencia = ?,      "+
" 	pergunta = ?        "+
" 	WHERE "+
" 	codPergunta = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getSequencia());
        stmt.setString(2, getPergunta());
        stmt.setInt(3, getCodPergunta());

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
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando =

" DELETE FROM perguntas  "+
" 	WHERE "+
" 	codPergunta = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodPergunta());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

}
