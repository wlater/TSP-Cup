
package Infra;

interface CRUD {
    public boolean criar(String nomeArquivo);
    public String ler(String nomeArquivo);
    public boolean atualizar();
    public boolean excluir();
    
}
