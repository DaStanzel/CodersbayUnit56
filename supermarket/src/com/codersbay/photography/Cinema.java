package com.codersbay.photography;

import java.time.LocalTime;

public class Cinema {
	Movie movies[];
	MovieRoom[] movieRooms;
	public Cinema(Movie[] movies,MovieRoom[] movieRooms) {
		this.movies=movies;
		this.movieRooms=movieRooms;
		
	}
	/**
	 * In Cinema is a MovieTable
	 * The print out from Time now to end of the MovieTable
	 * @param lt the time now what the user have. if null then print from begin of day.
	 */
	public void printMovieGuide(LocalTime lt,int show_entries) {
		int m_i[]=new int[this.movieRooms.length];
		long m_secound[]=new long[this.movieRooms.length];
		//begin The time
		if(lt==null) { //printed all movies
			System.out.println("----------------- [ movies ] -------------------------");
			for(int g_i=0;g_i<this.movieRooms.length;g_i++) {
				m_i[g_i]=0;
				LocalTime move_begin=this.movieRooms[g_i].begin;
				long second = ((move_begin.getHour()*60)+move_begin.getMinute())*60+move_begin.getSecond();
				m_secound[g_i]=second;
			}
		} else { //printed from the LocalTime lt to end of guide.length
			System.out.println(
				"----- [ CINEMA "
				+String.format("%2d:%2d:%2d",lt.getHour(),lt.getMinute(),lt.getSecond())
				+" ] -----"
			);
			long ltsecond=((lt.getHour()*60)+lt.getMinute())*60+lt.getSecond();
			for(int g_i=0;g_i<this.movieRooms.length;g_i++) {
				m_i[g_i]=0;
				LocalTime move_begin=this.movieRooms[g_i].begin;
				long second = ((move_begin.getHour()*60)+move_begin.getMinute())*60+move_begin.getSecond();
				System.out.print("while("+ltsecond+">"+second+")  -->  ");
				while(ltsecond > second) {
					int duration_in_second=(int)Math.round(this.movieRooms[g_i].movie[m_i[g_i]].duration_per_hour*60*60);
					System.out.print(String.format(" %d ",duration_in_second));
					second+=duration_in_second;
					m_i[g_i]++;
				}
				System.out.println(ltsecond+">="+second);
				m_secound[g_i]=second;
			} // for end     g_i>=guide.length
		} // if end lt==null und lt!=null
		//print begin to end
		for(int i=0;i<show_entries;i++) {
			/*for(int i=0;i<this.movieRooms.length;i++) {
				long secound=m_secound[i];
				long minute=secound/60;
				long hour=minute/60;
				hour%=24;
				minute%=60;
				secound%=60;
				System.out.print(
					this.movieRooms[i].cinema_hall+"->"+hour+":"+minute+":"+secound+" | "
				);
			}
			System.out.println();*/
			int print_g_i;
			for(print_g_i=0;print_g_i<this.movieRooms.length;print_g_i++)
				if(m_i[print_g_i]<this.movieRooms[print_g_i].movie.length)
					break;//in the Cinema in this Room is playing a movie
			//System.out.println("print_g_i="+print_g_i);
			if(print_g_i>=this.movieRooms.length)
				break;//All movie are Printed;
			for(int g_i=print_g_i+1;g_i<this.movieRooms.length;g_i++) {
				if(m_i[g_i]>=this.movieRooms[g_i].movie.length)
					continue;//In the Cinema in this Room is quite
				if(m_secound[g_i]<m_secound[print_g_i]) {
					//System.out.println("if("+m_secound[g_i]+"<"+m_secound[print_g_i]+")");
					print_g_i=g_i;	
				}
			}
			long secound=m_secound[print_g_i];
			long minute=secound/60;
			long hour=minute/60;
			hour%=24;
			minute%=60;
			secound%=60;
			System.out.println(
				String.format("%02d:%02d:%02d", hour,minute,secound) //time
				+" | "+this.movieRooms[print_g_i].cinema_hall //cinema_hall
				+" | "+this.movieRooms[print_g_i].movie[m_i[print_g_i]] //movie
			);
			int duration_in_second=(int)Math.round(this.movieRooms[print_g_i].movie[m_i[print_g_i]].duration_per_hour*60*60);
			m_secound[print_g_i]+=duration_in_second;
			m_i[print_g_i]+=1;
		}
		System.out.println("-----------------------------------------------");
	}
}
