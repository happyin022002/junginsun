/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOPortLogDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.27
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.12.27 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOPortLogDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PortLogDetail Search
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOPortLogDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOPortLogDetailVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT" ).append("\n"); 
		query.append("CRANE_NO" ).append("\n"); 
		query.append(",WORK_COMM" ).append("\n"); 
		query.append(",WORK_COMP" ).append("\n"); 
		query.append(",BREAK_DOWN" ).append("\n"); 
		query.append(",MEAL" ).append("\n"); 
		query.append(",WEATHER" ).append("\n"); 
		query.append(",OTHER" ).append("\n"); 
		query.append(",TOTAL" ).append("\n"); 
		query.append(",WORK" ).append("\n"); 
		query.append(",LOSE_TIME" ).append("\n"); 
		query.append(",TO_CHAR(FLOOR(NET_WORK)) ||':'|| LTRIM(TO_CHAR(ROUND(ABS(MOD(NET_WORK*60,60))),'00')) AS NET_WORK_HRS" ).append("\n"); 
		query.append(",GROSS_WORK" ).append("\n"); 
		query.append(",GROSS_WORK_HRS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT C.CRANE_NO   CRANE_NO," ).append("\n"); 
		query.append("C.START_DATE	WORK_COMM," ).append("\n"); 
		query.append("C.END_DATE	WORK_COMP," ).append("\n"); 
		query.append("DECODE(LENGTH(BDT_TIME), 4, '00' || BDT_TIME, 5, '0' || BDT_TIME, BDT_TIME) AS BREAK_DOWN," ).append("\n"); 
		query.append("DECODE(LENGTH(MT_TIME), 4, '00' || MT_TIME, 5, '0' || MT_TIME, MT_TIME) AS MEAL," ).append("\n"); 
		query.append("DECODE(LENGTH(BW_TIME), 4, '00' || BW_TIME, 5, '0' || BW_TIME, BW_TIME) AS WEATHER," ).append("\n"); 
		query.append("DECODE(LENGTH(OTHER_TIME), 4, '00' || OTHER_TIME, 5, '0' || OTHER_TIME, OTHER_TIME) AS OTHER," ).append("\n"); 
		query.append("DECODE(LENGTH(LOSE_TIME), 4, '00' || LOSE_TIME, 5, '0' || LOSE_TIME, LOSE_TIME) AS TOTAL," ).append("\n"); 
		query.append("DECODE(LENGTH(WORK_TIME), 4, '00' || WORK_TIME, 5, '0' || WORK_TIME, WORK_TIME) AS WORK," ).append("\n"); 
		query.append("ROUND(TO_NUMBER(SUBSTR(C.LOSE_TIME,1,INSTR(C.LOSE_TIME,':')-1))+TO_NUMBER(SUBSTR(C.LOSE_TIME,INSTR(C.LOSE_TIME,':')+1)/60),2) LOSE_TIME," ).append("\n"); 
		query.append("(C.END_DATE - C.START_DATE)*24 - (TO_NUMBER(SUBSTR(C.LOSE_TIME,1,INSTR(C.LOSE_TIME,':')-1))+TO_NUMBER(SUBSTR(C.LOSE_TIME,INSTR(C.LOSE_TIME,':')+1)/60)) AS NET_WORK," ).append("\n"); 
		query.append("TO_CHAR(ROUND(C.END_DATE - C.START_DATE,2)*24, '999.99')  AS GROSS_WORK," ).append("\n"); 
		query.append("TO_CHAR(FLOOR((C.END_DATE - C.START_DATE)*24)) || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD((C.END_DATE - C.START_DATE)*24*60,60))), '00'))  AS GROSS_WORK_HRS" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_CRANE C" ).append("\n"); 
		query.append("WHERE  V.VSL_CD       = H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   = H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   = H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  = H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD       = C.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO       = C.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD       = C.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD      = C.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND     = C.CALL_IND" ).append("\n"); 
		query.append("AND    V.VSL_CD  	  = @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("AND    V.YD_CD 	      = @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY CRANE_NO" ).append("\n"); 

	}
}