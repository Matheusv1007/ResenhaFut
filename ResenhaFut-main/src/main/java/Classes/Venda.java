package Classes;

import java.util.Date;
import java.util.LinkedList;

public class Venda {

    private Date dataVenda;
    private LinkedList<ItemVenda> ItemVenda;

    public Venda(){
        this.dataVenda = new Date();
        this.ItemVenda = new LinkedList<>();
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public LinkedList<ItemVenda> getItemVenda() {
        return ItemVenda;
    }

    public void setItemVenda(LinkedList<ItemVenda> itemVenda) {
        ItemVenda = itemVenda;
    }


}
