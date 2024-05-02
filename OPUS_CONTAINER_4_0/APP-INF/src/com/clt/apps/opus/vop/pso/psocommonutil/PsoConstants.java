/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PortChargeBudgetSC.java
 *@FileTitle : Lane/Port Expense Ratio Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.02.18
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.02.18 진마리아
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.psocommonutil;


/**
 * PsoConstants
 * 
 * @author
 * @see PsoConstants
 * @since J2EE 1.6
 */
public class PsoConstants {
	
	/** OFFICE CODE **/
	public static final String OFC_MODULE = "PSO";
	public static final String HO_VSL_OP_TEAM = "000001"; // Head Office Vessel Operation Team
	
	/** ERROR CODE **/
	public static final String PSO90015 = "PSO90015"; // No office code found. Please check [$s].
	
	/** CANAL **/
	public static final String SUEZ_CANAL = "EGSCA";
	public static final String PANAMA_CANAL = "PAPCA";
	
	/** BATCH DATASOURCE **/
	public static final String BATCH_DATASOURCE = "";
	
	public static final String MEAS_UNIT_CD_HOUR   = "1" ;
	public static final String MEAS_UNIT_CD_CALL   = "2" ;
	public static final String MEAS_UNIT_CD_METER  = "3" ;
	public static final String MEAS_UNIT_CD_FEET   = "4" ;
	public static final String MEAS_UNIT_CD_EA     = "5" ;
	public static final String MEAS_UNIT_CD_HP     = "6" ;
	public static final String MEAS_UNIT_CD_TON    = "7" ;
	public static final String MEAS_UNIT_CD_PERSON = "8" ;
	public static final String MEAS_UNIT_CD_MONTH  = "9" ;
	public static final String MEAS_UNIT_CD_TEU    = "10";
	public static final String MEAS_UNIT_CD_NA     = "11";
	public static final String MEAS_UNIT_CD_FLAG   = "12";
	public static final String MEAS_UNIT_CD_CBM    = "13";
	public static final String MEAS_UNIT_CD_CODE   = "14";
	public static final String MEAS_UNIT_CD_TIME   = "15";
	public static final String MEAS_UNIT_CD_DATE   = "16";
	public static final String MEAS_UNIT_CD_DAY    = "17";
	public static final String MEAS_UNIT_CD_POINT  = "18";
	
	/*Default Manual Input Object*/
	public static final String[] ARRAY_DEFAULT_MANUAL_VALUE_OBJECT_NO = new String[]{
							  "6"	//Arrival No. of Tug
							, "7"	//Departure No. of Tug
							, "8"	//Arrival Tug Power
							, "9"	//Departure Tug Power
							, "10"	//Arrival Tug Used Hour
							, "11"	//Departure Tug Used Hour
							, "17"	//Boat
							, "50"	//Arrival Line Handing Hour
							, "52"	//Barge
							, "57"	//Buoy
							, "60"	//Departure Line handing Hour
							, "75"	//Holiday
							, "78"	//Inspection
							, "86"	//Night
							, "97"	//Sanitation
							, "110"	//TUG Rope
							, "111"	//Used Hour
							, "114"	//SDR
							, "115"	//Tier
							, "116"	//Limit Time
							, "119"	//New Service
							, "125"	//Co-pilot
							, "170"	//Others
							, "171"	//Other Value
		};
	
	/*Default Zero Allow Object : 2016.03.18 Add*/
	public static final String[] ARRAY_DEFAULT_ZERO_ALLOW_OBJECT_NO = new String[]{
							  "93" 	//Remain Vessel Call
							, "94"	//Montly Vessel Call
							, "96"	//Yearly Vessel Call(S/V)
							, "133"	//Yearly Vessel Call(S/L)
							, "156"	//Yearly Vessel Call Port
							, "27"	//M Garbage Volume 2016.04.14
							, "37"	//M Anchoring Hour 2016.04.14
							, "40"	//M Sluge Volume 2016.04.14
							, "93"	//A Remain Vessel Call 2016.04.14
							, "94"	//A Monthly Vessel Call 2016.04.14
							, "96"	//A Yearly Vessel Call(S/V) 2016.04.14
							, "112"	//M Water Volume 2016.04.14
							, "133"	//A Yearly Vessel Call(S/L) 2016.04.14
							, "156"	//A Yearly Vessel Call Port 2016.04.14
	};
	
	/*Default Flag Allow Object : 2016.04.14 Add*/
	public static final String[] ARRAY_DEFAULT_FLAG_ALLOW_OBJECT_NO = new String[]{
							  "17" 	//M Boat
							, "52"	//M Barge
							, "57"	//M Buoy
							, "75"	//M Holiday
							, "78"	//M Inspection
							, "86"	//M Night
							, "97"	//M Sanitation
							, "110"	//M TUG Rope
							, "119"	//M New Service
							, "120"	//A DEM/DET Holiday(ETB)
							, "121"	//A DEM/DET Holiday(ETD)
							, "125"	//M Co-pilot
							, "147"	//A DEM/DET Holiday(ETB except Day)
							, "148"	//A DEM/DET Holiday(ETD except Day)
							, "152"	//A DEM/DET Holiday(ETA)
							, "153"	//A DEM/DET Holiday(ETA except Day)
							, "170"	//M Others
	};
}
