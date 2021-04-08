package lesson2;

public class Controls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int		i1 = 10, i2 = 20;
		double	d1 = 10, d2 = 20;
		
		System.err.println("i1 == i2 ? "+(i1 == i2));
		System.err.println("d1 == d2 ? "+(d1 == d2));
		// == equals
		// != not equals
		// > greater than
		// >= greater than or equals
		// < less than
		// <= less than or equals
		
		boolean	b1 = true, b2 = false;
		
		System.err.println("b1 || b2 ? "+(b1 || b2));
		System.err.println("b1 && b2 ? "+(b1 && b2));
//		System.err.println("b1 != b2 ? "+(b1 != b2));
		System.err.println("! b1 ? "+(! b1));
		
		System.err.println("b1 | b2 ? "+(b1 | b2));
		System.err.println("b1 & b2 ? "+(b1 & b2));
//		System.err.println("b1 != b2 ? "+(b1 != b2));
		
		i1 = 0;
		i1 = -123456;
		i1 = 2_4_5_120; // 245120
		i1 = 0b100110;
		i1 = 0x24FE;
		i1 = 077; // 01234567
		
		long	long1;
		
		long1 = 123456789012345678L;
		
		float	f1;
		
		f1 = 2.5f;
		f1 = 1.0_3e-1_2f;
		
		char c1;
		
		c1 = 10;
		c1 = '\r';
		c1 = '\012';
		c1 = '\u0398';
		System.err.println("c1="+c1);
		
		b1 = true;
		b1 = false;
		
		b1 = true;
		
		i1 = i2;	// i1 = (i2 = 10)
		i1 = i2;	// i1 = (i2 = 10)
		i1 += 10;	// i1 = i1 + 10;
		i2 <<= 5;	// i2 = i2 << 5;
		
		i2 = i1++;		// i1 = i1 + 1;
		i1--;		// i1 = i1 - 1;

		i2 = ++i1;		// i1 = i1 + 1;
		--i1;		// i1 = i1 - 1;
		
		if (i1 < i2) {	// begin
			if (d1 < d2) {
				System.err.println("I1 > I2  AND D1 < d2 !!!");
			}	
			else {
				System.err.println("I1 > I2 AND D1 >= D2 !!!");
			}
		}	// end
		
		while (i1 > 0) {
			if (i1 < i2/*сегодня дождь*/) {
//				break;
				continue;
			}
			i1--;
		}
		
		do {
			i2--;
		} while (i2 > 0);
		// 	i2--;
		//	while (i2 > 0) {
		//		i2--;
		//	}

		for (int index = 0; index < 10; index++) {
			if (index % 2 == 0) {
				continue;
			}
			else {
				System.err.println("Index="+index);
			}
		}
		// int index = 0;
		//
		// while (index < 10) {
		//		System.err.println("Index="+index);
		//		index++;
		// }
		for (i1 = 0; i1 < 10; i1++) {
			System.err.println("Index="+i1);
		}
		
		switch (i1+i2/2) {
			case 0 :	
				System.err.println("ZERO!!!!!!!!!!!!");
				break;
			case 10 :	
			case 15 :	
				System.err.println("TEN!!!!!!!!!!!!");
				break;
			case 20 :	
				System.err.println("TWENTY!!!!!!!!!!!!");
				break;
			default : 	System.err.println("DON'T KNOW!!!!!!!!!!!!");
		}
		
		
		
//		else {
//			System.err.println("I1 <= I2 !!!");
//		}
		return;
	}

}
