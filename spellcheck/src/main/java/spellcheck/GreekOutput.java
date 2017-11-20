package spellcheck;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class GreekOutput {






		public GreekOutput() {}

		 public void printText(String text) {

					try{

					PrintWriter p = new PrintWriter(new OutputStreamWriter(System.out,"Cp737"),true);
					p.println(text);

					}
					  catch (Exception e){
						    if(e instanceof IOException){

						    }
						}

				}
		   }



