public class Factory {
    public static Product getProduct(String arg){
        Product product=null;
        if (arg.equalsIgnoreCase("A")){
            product = new ConcreteProcuctA();
            //初始化完成设置product
        }
        else if (arg.equalsIgnoreCase("B")){
            product = new ConcreteProcuctB();
            //初始化完成设置product
        }
        return product;
    }
}
