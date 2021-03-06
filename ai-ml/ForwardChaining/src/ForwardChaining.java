import java.util.*;

class ForwardChaining {
    ArrayList<int[]> clauses;
    
    public ForwardChaining() {
        clauses=new ArrayList<>();
    }
    
    public boolean forwardChaining(int n) {
        // Simplified version of forward chaining algorithm: does not follow the 
        // textbook. This implementation does not run in linear time because it 
        // scans all clauses multiple times. 
        
        boolean[] model=new boolean[n+1];    // All symbols set to false initially.
        
        //  Sanity check clauses
        for(int i=0; i<clauses.size(); i++) {
            int posLits=0;
            int[] clause=clauses.get(i);
            for(int j=0; j<clause.length; j++) {
                assert clause[i]<=n && clause[i]>=-n : "Found reference to variable larger than n.";
                if(clause[j]>0) {
                    posLits++;
                }
            }
            
            assert posLits<=1 : "At most one positive literal is allowed in each clause.";
        }
        
        //  Iterate through set of clauses applying modus ponens until we reach a 
        //  fixpoint.
        boolean fixPoint=false;
        
        while(!fixPoint) {
            fixPoint=true;
            
            for(int i=0; i<clauses.size(); i++) {
                int[] clause=clauses.get(i);
                //  Check all symbols that appear negated in this clause.
                //  If all true, then apply modus ponens. 
                
                boolean allTrue=true;
                
                for(int j=0; j<clause.length; j++) {
                    if(clause[j]<0 && ! model[-clause[j]]) {
                        allTrue=false;
                        break;
                    }
                }
                
                if(allTrue) {
                    boolean goalClause=true;
                    for(int j=0; j<clause.length; j++) {
                        if(clause[j]>0) {
                            goalClause=false;
                            if(! model[clause[j]]) {
                                model[clause[j]]=true;
                                fixPoint=false;
                                System.out.println("Inferred "+clause[j]+" with clause "+Arrays.toString(clause));
                            }
                            
                            break;
                        }
                    }
                    if(goalClause) {
                        // This is a goal clause
                        System.out.println("No models satisfy all clauses simultaneously. False goal clause: "+Arrays.toString(clause));
                        return false;
                    }
                }
            }
        }
        
        System.out.println("Model: ");
        for(int i=1; i<model.length; i++) {
            System.out.println("Variable "+i+" = "+model[i]);
        }
        return true;
    }
    
    public void addClause(int[] c) {
        clauses.add(c);
    }
    
    public void resetClauses() {
        clauses.clear();
    }
    
    public static void example() {
        
        // The following is the CNF of Figure 7.16 in AIMA
        // Symbols A, B, L, M, P, Q are numbered 1..6.
        ForwardChaining fc=new ForwardChaining();
        
        fc.addClause(new int[]{-7, -4, 14});
        fc.addClause(new int[]{-7, -2, 16});
        fc.addClause(new int[]{-10, -1, 17});
        fc.addClause(new int[]{-10, -5, 13});
        fc.addClause(new int[]{-8, -1, -5, 15});
        fc.addClause(new int[]{-8, -1, -3, 17});
        fc.addClause(new int[]{-8, -5, -3, 13});
        fc.addClause(new int[]{-11, -4, -2, 18});
        fc.addClause(new int[]{-11, -4, -6, 14});
        fc.addClause(new int[]{-11, -2, -6, 16});
        fc.addClause(new int[]{-9, -6, 17});
        fc.addClause(new int[]{-9, -2, 18});
        fc.addClause(new int[]{-12, -3, 17});
        fc.addClause(new int[]{-12, -5, 15});
        fc.addClause(new int[]{11});
        fc.addClause(new int[]{10});
        fc.addClause(new int[]{4});
        
        
        //  Call forward chaining. 6 is the number of proposition symbols, which must be
        //  numbered 1..6. 
        
        boolean modelExists = fc.forwardChaining(14);
        System.out.println("Model exists: "+modelExists);
    }
    
    public static void main(String [] args) {
        
        example();
        
    }
    
}
