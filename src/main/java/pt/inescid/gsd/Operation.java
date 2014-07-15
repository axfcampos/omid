package pt.inescid.gsd;

import com.yahoo.omid.tso.RowKey;
import pt.inescid.gsd.k.K;
import pt.inescid.gsd.k.K_Seq;

public class Operation implements Comparable<Operation> {


    private K k;
    private long hash; //row id
    private Transaction parent;

    public Operation(Transaction parent, RowKey r){


//        if(r.sequence != -1 && r.value != -1 && r.time != -1){
//            this.k = new K_TimeSeqValue();
//        }else{
//        if(r.sequence != -1 && r.value != -1 && !(r.time != -1)){
//            this.k = new K_ValueSeq();
//        }else{
//        if(r.sequence != -1 && !(r.value != -1) && r.time != -1){
//            this.k = new K_SeqTime();
//        }else{
//        if(!(r.sequence != -1) && r.value != -1 && r.time != -1){
//            this.k = new K_TimeValue();
//        }else{
//        if(r.sequence != -1 && !(r.value != -1) && !(r.time != -1)){
//            System.out.println("here");
//            this.k = new K_Seq(r.sequence);
//        }else{
//        if(!(r.sequence != -1) && !(r.value != -1) && r.time != -1){
//            this.k = new K_Time();
//        }else{
//        if(!(r.sequence != -1) && r.value != -1 && !(r.time != -1)){
//            this.k = new K_Value();
//        }else{
//            System.out.println("huge error K");
//        }}}}}}}

        this.parent = parent;
        this.k = new K_Seq(r.getSequence());
        this.hash = r.hashCode();
    }

    public long getHash(){
        return this.hash;
    }
    public Transaction getParent(){
        return this.parent;
    }

    public void updateKValues(double value){
        this.k.updateKValues(value);
    }


    @Override
    public int compareTo(Operation o) {

        if(this.k.compareTo(o.k) == 1){
            //i won, im more urgent
            return -1;
        }else{
            //i lost, he is more urgent
            return 1;
        }
    }

    @Override
    public String toString(){
        return this.hash + "->" + k.toString();
    }
}
