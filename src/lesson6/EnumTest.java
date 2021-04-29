package lesson6;

@MyAnnotation(value="dsfkjlkfd",isSpecial=false)
public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DayOfWeek	dow = DayOfWeek.FRIDAY;
		
		Enum dow1 = dow;
		
		System.err.println("Day="+dow);
		if (dow == DayOfWeek.MONDAY) {
			
		}
		switch (dow/*.ordinal()*/) {
			case FRIDAY/*.ordinal()*/ :
				System.err.println("--------- pjatnitsa!");
				break;
			case SUNDAY/*.ordinal()*/ :
				System.err.println("--------- voskresenje!");
				break;
			default :
		}
		
		Class	cl = EnumTest.class;
		MyAnnotation	ann = (MyAnnotation)cl.getAnnotation(MyAnnotation.class);
	
		System.err.println("Ann: value="+ann.value()+", "+ann.isSpecial());
	}

	public /*final class*/enum /*extends java.lang.Enum*/DayOfWeek {
		MONDAY(false), // public static final DayOfWeek MONDAY =
				// new DayOfWeek("MONDAY",0);
		TUESDAY(false),
		WEDNESDAY(false),
		THURSDAY(false),
		FRIDAY(false),
		SATURDAY(true),
		SUNDAY(true); // public static final DayOfWeek SUNDAY =
				// new DayOfWeek("SUNDAY",6);
		private final boolean isCelebrate;
		
		private DayOfWeek(boolean celebrate) {
			this.isCelebrate = celebrate;
		}
		
		public boolean isCelebrate() {
			return isCelebrate;
		}
	}
}

