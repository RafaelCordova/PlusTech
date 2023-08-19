package org.examen.PlusTech.run;

import org.openxava.util.*;

public class PlusTech {

	public static void main(String[] args) throws Exception {
		DBServer.start("PlusTech-db");
		AppServer.run("PlusTech");
	}

}
