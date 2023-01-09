import math.Glob;
import quant.state.State;

public class T19_6_Factorization_49 {

	public static void main(String args[]) {
		// Create an state of 19 qubits
		State st = new State();
		st.add_qubits(19);
		int[] groups = { 3, 3, 6, 6, 1 }; // xxx xxx xxxxxx xxxxxx x
		st.setGroups(groups);

		int[] qH = { 0, 1, 2, 3, 4, 5 };
		st.hadamard(qH);
		
		int[] qNot_for_cmp = { 12, 13, 17 }; // 110001 <<-- in binary. in decimal -->> 49  
		st.not(qNot_for_cmp);
		
		st.not(18);  // ancilla
		st.hadamard( 18 );
		st.oracle();
		
		int max_count = 6;
		for( int count = 1; count <= max_count ; count ++ ) {
		  st.diffuser();
	      st.oracle();		
		}
		
		st.hadamard( 18 );		
		
        st.print();
		Glob.print(st.measure(1));
	}
}
