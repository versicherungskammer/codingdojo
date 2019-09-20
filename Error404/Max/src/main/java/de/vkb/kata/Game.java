package de.vkb.kata;

public class Game {

	
	public int gaming(int s1, int s2) {
		//draft
		if(s1==s2) {
			return 0;
		}
		//case s1 smaller s2
		if (s1<s2) {
			switch ((s2-s1)%5)
			{
			case(1):return 1;
			case(3):return 1;
			case(4):return 1;
			case(0):return 1;
			default:return 2;
			}
		}
		//s1 bigger s2 (reverse order)
		else {
			switch ((s1-s2)%5)
			{
			case(1):return 2;
			case(3):return 2;
			case(4):return 2;
			case(0):return 2;
			default:return 1;
			}
		}

	}
}
