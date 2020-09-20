package javaapplication1;
import java.util.*;
public class JavaApplication1 {

    public static  Scanner SN=new Scanner(System.in);
    public static final int WORK_BLACK=1300000;
    public static final int WORK_WHITE=2600000;
    public static final int PAINTING=980000;
    public static void main(String[] args) {
        String[] name_prod;
        int[] quantity_produc; 
        int[] utility_produc;
        double[] price_Home;
        double[] price_center;
        double[] price_neighborhood;
        String[] price_best;
        String[] organize_produc;
        int quantity_product;
        int location_house;
        String total_price_home;
        System.out.println("where the house is located. \\ n dial 0 = north. \\ n 1 = center. \\ n 2 = south");
        location_house=SN.nextInt();
        SN.nextLine();
        System.out.println("Intake of work expense \n");
        System.out.println("enter the quantity of material materials ");
        quantity_product=SN.nextInt();
        //enter the name
        name_prod=name_product(quantity_product);
        quantity_produc=quantity_product(quantity_product,name_prod);
        utility_produc=tip_product(quantity_product,name_prod);
        //enter the price
        price_Home=prise_Homecenter(quantity_product,name_prod);
        price_center=prise_center(quantity_product, name_prod);
        price_neighborhood=prise_neighborhood(quantity_product,name_prod);
        //total value per house place
        total_price_home=totall_price_Home(price_Home,price_center,price_neighborhood,utility_produc,location_house);
        System.out.println(total_price_home+"\n");
        //the best price
        price_best=best_price(quantity_product,price_Home,price_center,price_neighborhood,utility_produc,location_house,name_prod);
        for(int i=0;i<price_best.length;i++){
            System.out.println(price_best[i]+"\n");
        }
        // organize produc for tip
        int search_type;
        System.out.println("what is the type of work  type\n 0 = black work\n 1 = white_work\n 2 = painting");
        search_type=SN.nextInt();
        organize_produc=tip_produc(quantity_product,utility_produc, name_prod, search_type);
        for(int i=0;i<organize_produc.length;i++){
            System.out.println(organize_produc[i]+"\n");
        }
        
    }
    /**
     * name:name_product
     * the method is the one that captures the names
     * @param quantity_product
     * @return produc
     */
    public static String[] name_product(int quantity_product){
        String[] produc=new String[quantity_product];
        System.out.println("enter the following information ");
        for(int i=0;i<produc.length;i++){
            System.out.println("enter the Product name #"+i+1);
            produc[i]=SN.nextLine();
        }return  produc;
    }
    /**
     * name:quantity_product
     * the method is the ones that captures the quantity of product
     * @param quantity_product
     * @param name_prod
     * @return 
     */
    public static int[] quantity_product(int quantity_product,String[] name_prod){
        int[] cant_prodc=new int[quantity_product];
        System.out.println("enter the following information ");
        for(int i=0;i<cant_prodc.length;i++){
            System.out.println("enter quantity of products "+name_prod[i]+" #"+i+1 );
            cant_prodc[i]=SN.nextInt();
            SN.nextLine();
        }return  cant_prodc;
    }
    /**
     * name: tip_product
     * the method is that captures the types of product
     * @param quantity_product
     * @param name_prod
     * @return 
     */
    public static int[] tip_product(int quantity_product,String[] name_prod){
        int[] tip_prodc=new int[quantity_product]; 
        System.out.println("enter the following information ");
        for(int i=0;i<tip_prodc.length;i++){
            System.out.println("enter utility of products "+name_prod[i]+" #"+i+1 );
            System.out.println("enter 0 = work black \n1 = work white \n3 = painting");
            tip_prodc[i]=SN.nextInt();
        }return  tip_prodc;
    }
    /**
     * name:prise_Homecenter
     * the method is that captures price of product the homecenter
     * @param quantity_product
     * @param name_prod
     * @return 
     */
    public static double[] prise_Homecenter(int quantity_product,String[] name_prod){
        double[] price=new double[quantity_product];
        for(int i=0;i<price.length;i++){
            System.out.println("enter price total of products "+name_prod[i]+" #"+i+1 );
            System.out.println("in Homecenter");
            price[i]=SN.nextInt();
        }return price;
    }
    /**
     * name:prise_center
     * the method is that captures price of product the prise center
     * @param quantity_product
     * @param name_prod
     * @return 
     */
    public static double[] prise_center(int quantity_product,String[] name_prod){
        double[] price=new double[quantity_product];
        for(int i=0;i<price.length;i++){
            System.out.println("enter price of products "+name_prod[i]+" #"+i+1 );
            System.out.println("in center");
            price[i]=SN.nextInt();
        }return price;
    }
    /**
     * name:prise_neighborhood
     * the method is that captures price of product the prise prise neighborhood
     * @param quantity_product
     * @param name_prod
     * @return 
     */
    public static double[] prise_neighborhood(int quantity_product,String[] name_prod){
        double[] price=new double[quantity_product];
        for(int i=0;i<price.length;i++){
            System.out.println("enter price of products "+name_prod[i]+" #"+i+1 );
            System.out.println("in neighborhood");
            price[i]=SN.nextInt();
        }return price;
    }
    /**
     * name:totall_price_Home
     * the method is the sum total price 
     * @param price_Home
     * @param price_center
     * @param price_neighborhood
     * @param utility_produc
     * @param location_house
     * @return 
     */
    public static String totall_price_Home(double[]price_Home,double[]price_center,double[]price_neighborhood,int[] utility_produc,int location_house){
        String total=" ";
        int acum_home=0;
        int acum_center=0;
        int acum_neighborhood=0;
        boolean black=false;
        boolean white=false;
        boolean painting=false;
        boolean check1=true;
        boolean check2=true;
        boolean check3=true;
        for(int i=0;i<price_Home.length;i++){
            acum_home+=price_Home[i];
            acum_center+=price_center[i];
            acum_neighborhood+=price_neighborhood[i];
        }
        switch(location_house){
            case 0:
                //price less < 80.000
                if(acum_home<80000){acum_home+=120000;}
                if(acum_center<80000){acum_center+=120000;}
                if(acum_neighborhood<80000){acum_neighborhood+=120000;}
                //price less < 300.000
                if(acum_home<300000){acum_home+=28000;}
                if(acum_center<300000){acum_center+=28000;}
                if(acum_neighborhood<300000){acum_neighborhood+=28000;}
                //price less > 300.000 = addresses = 0$
            break;
            case 1:
                //price less < 80.000
                if(acum_home<80000){acum_home+=50000;}
                if(acum_center<80000){acum_center+=50000;}
                if(acum_neighborhood<80000){acum_neighborhood+=50000;}
                //price less < 300.000 = addresses = 0$
                //price less > 300.000 = addresses = 0$  
            break;
            case 2:
                //price less < 80.000
                if(acum_home<80000){acum_home+=120000;}
                if(acum_center<80000){acum_center+=120000;}
                if(acum_neighborhood<80000){acum_neighborhood+=120000;}
                //price less < 300.000
                if(acum_home<300000){acum_home+=55000;}
                if(acum_center<300000){acum_center+=55000;}
                if(acum_neighborhood<300000){acum_neighborhood+=55000;}
                //price less > 300.000 = addresses = 0$
            break;
                
        }
        for(int i=0;i<price_Home.length;i++){
            if(utility_produc[i]==0){black=true;}
            if(utility_produc[i]==1){white=true;}
            if(utility_produc[i]==2){painting=true;}
            if(black==true&&check1==true){
                acum_home+=WORK_BLACK;
                acum_center+=WORK_BLACK;
                acum_neighborhood+=WORK_BLACK;
                check1=false;
            }
            if(white==true&&check2==true){
                acum_home+=WORK_WHITE;
                acum_center+=WORK_WHITE;
                acum_neighborhood+=WORK_WHITE;
                check2=false;
            }
            if(painting==true&&check3==true){
                acum_home+=PAINTING;
                acum_center+=PAINTING;
                acum_neighborhood+=PAINTING;
                check3=false;
            }
        }
        total=(" purchase value in Homecenter is "+acum_home+"\n purchase value in center is"+acum_center+"\n purchase value in neighborhood is"+acum_neighborhood+"\n including address");
        return total;
    }
    /**
     * name:best_price
     * the method looks for the cheapest form of inventory
     * @param quantity_product
     * @param price_Home
     * @param price_center
     * @param price_neighborhood
     * @param utility_produc
     * @param location_house
     * @param name_prod
     * @return 
     */
    public static String[] best_price(int quantity_product,double[]price_Home,double[]price_center,double[]price_neighborhood,int[] utility_produc,int location_house,String[] name_prod){
        String[] best=new String[quantity_product+1];
        double[] price=new double[3];
        double[] less_price=new double[quantity_product];
        int[] place_less=new int[quantity_product];
        for(int i=0;i<quantity_product;i++){
            price[0]=price_Home[i];
            price[1]=price_center[i];
            price[2]=price_neighborhood[i];
            double less =price[0];
            int cont=0;
            for (int y = 0; y <price.length; y++) {
                if(price[y]<less) {
                    less = price[y];
                    cont=y;
                }
            }
            less_price[i]=less;
            place_less[i]=cont;  
            cont=0;
            for(int p=0;p<price.length;i++){
                price[p]=0;
            }
        }
        double sum_price=0;
        for(int i=0;i<quantity_product;i++){
            sum_price+=place_less[i];
        }
        switch(location_house){
            case 0:
                //price less < 80.000
                if(sum_price<80000){sum_price+=120000;}
                //price less < 300.000
                if(sum_price<300000){sum_price+=28000;}
                //price less > 300.000 = addresses = 0$
            break;
            case 1:
                //price less < 80.000
                if(sum_price<80000){sum_price+=50000;}
                //price less < 300.000 = addresses = 0$
                //price less > 300.000 = addresses = 0$  
            break;
            case 2:
                //price less < 80.000
                if(sum_price<80000){sum_price+=120000;}
                //price less < 300.000
                if(sum_price<300000){sum_price+=55000;}
                //price less > 300.000 = addresses = 0$
            break;
        }
        String show_less_price="";
        for(int i=0;i<quantity_product;i++){
            show_less_price=("the best price of"+name_prod[i]+" is "+less_price[i]+" in "+place_less);
            best[i]=show_less_price;
        }
        best[quantity_product]=("the best inventory price is "+sum_price);
        return best;
    }
    /**
     * name:tip_produc
     * This method shows you the inventory ordered by type of material. black work, white work and painting
     * @param quantity_product
     * @param utility_produc
     * @param name_prod
     * @param search_type
     * @return 
     */
    public static String[] tip_produc(int quantity_product,int[] utility_produc,String[] name_prod,int search_type){
        String[] category_produc=null;
        int acum_black=0;
        int acum_white=0;
        int acum_painting=0;
        for(int i=0;i<quantity_product;i++){
            if(utility_produc[i]==0){acum_black++;}
            if(utility_produc[i]==1){acum_white++;}
            if(utility_produc[i]==2){acum_painting++;}
        }
        String[] category_black=new String[acum_black];
        String[] category_white=new String[acum_white];
        String[] category_painting=new String[acum_painting];
        
        for(int i=0;i<quantity_product;i++){
            if(utility_produc[i]==0){
                for(int y=0;y<category_black.length;y++){
                    category_black[y]=("the produc is "+name_prod[i]+" of type black work");
                }   
            }
            if(utility_produc[i]==1){
                for(int y=0;y<category_white.length;y++){
                    category_white[y]=("the produc is "+name_prod[i]+" of type white work");
                }   
            }
            if(utility_produc[i]==2){
                for(int y=0;y<category_painting.length;y++){
                    category_painting[y]=("the produc is "+name_prod[i]+" of type painting ");
                }   
            }
        }
        switch(search_type){
            case 0:
                category_produc=category_black;
            break;
            case 1:
                category_produc=category_white;
            break;
            case 2:
                category_produc=category_painting;
            break;
        }
        return category_produc;
    }
    
    
}
