

package pod12;

import java.math.BigInteger;
import java.util.Random;

    class RSA
    {
        private long p, q, n, phi, e, d;
        
        private BigInteger[] text;
        private BigInteger[] encrypted;
        private BigInteger[] decrypted;

        public RSA(String temp,long p,long q)
        {
            text = new BigInteger[temp.length()];
            encrypted= new BigInteger[temp.length()];
            decrypted= new BigInteger[temp.length()];
            for (int i = 0; i < text.length; i++)
            {
               char s=(temp.charAt(i));
               int f =(int)s;
              String tolong = Integer.toString(f);
                text[i]= new BigInteger(tolong);
                //text[i] = Long.parseLong(tolong);
            }
            this.p = p;
            this.q = q;
            this.n = p * q;
            this.phi = (p - 1)*(q - 1);
            this.e=firsty();
            this.d = dy();
            
        }
        public RSA(long e,long n,String temp)
        { 
            temp=temp.trim();
            String[] elem =temp.split(" ");
            encrypted = new BigInteger[elem.length];
            decrypted= new BigInteger[elem.length];
            for (int i = 0; i < encrypted.length; i++)
            {
             // String l=Character.toString(temp.charAt(i));
                String s =elem[i];
                encrypted[i] = new BigInteger(s);
            }
            this.e = e;
            this.n = n;
        }
        public long getN()
        {
            return n;
        }
        public long getE()
        {
            return e;
        }
        public String getD()
        {
            BigInteger phibig = BigInteger.valueOf(phi);
            BigInteger d = BigInteger.valueOf(e).modInverse(phibig);
            return d.toString();
        }
        public long firsty()
        {
//            Random random = new Random();
//             while(true)
//        {
//       
//        e = random.nextLong() % phi;
//        if(e < 0) e*=-1;
//        String s =Long.toString(e);
//        BigInteger big = new BigInteger(s);
//        BigInteger bigphi=new BigInteger(Long.toString(phi));
//        BigInteger common = bigphi.gcd(big);
//        if((e % 2 != 0) && common.equals(BigInteger.ONE) && e !=1){
//            
//            System.out.print("---"+e+"---");
//            break;
//        }
        
      //  }
            long ax,bx, t;
            for (long i = 2; i < phi; i++)
            {
                ax = i;
                bx = phi;
                while (bx != 0)
                {
                    t = bx;
                    bx = ax % bx;
                    ax = t;
                }
                if (ax == 1) return i;
            }
            return 0;
        }
        
        public long dy(){
        BigInteger phibig = BigInteger.valueOf(phi);
        BigInteger d = BigInteger.valueOf(e).modInverse(phibig);
        String s =d.toString();
       return  Long.parseLong(s);
        
        
        }
        
       // public long dy()
        //{
//            BigInteger phibig = BigInteger.valueOf(phi);
//            BigInteger d = BigInteger.valueOf(e).modInverse(phibig);
            
            
            
//            long i = 1;
//            while (((e * i) - 1) % phi != 0)
//            {
//                i++;
//            }
//            return i;
      //  }

        public void encrypting()
        {
             String ns = Long.toString(n);
             BigInteger nsint = new BigInteger(ns);
            String dbig = Long.toString(d);
             BigInteger dbigint = new BigInteger(dbig); 
            for(int i = 0; i < text.length; i++)
            {
            // long l = text[i];
             //String b = Long.toString(l);
            // BigInteger bint = new BigInteger(b);
                encrypted[i]= text[i].modPow(dbigint, nsint);
                //encrypted[i] = IntPow(bint, e).mod(nsint);
            }
        }
        public void decrypting()
        {
                 String ns = Long.toString(n);
                 BigInteger nsint = new BigInteger(ns); 
                 String ebig = Long.toString(e);
                 BigInteger ebigint = new BigInteger(ebig); 
            
            for (int i = 0; i < encrypted.length; i++)
            {
                 decrypted[i] = encrypted[i].modPow(ebigint, nsint);
               // decrypted[i] = IntPow(encrypted[i], d).mod(nsint);
            }
        }
        
        
        public BigInteger[] getencrypted(){
        return encrypted;
        }
        
        public BigInteger[] getdecrypted(){
        return decrypted;
        }


    }

