/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchDefaultMonthWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.01.04 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOsearchDefaultMonthWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기간조회
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchDefaultMonthWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dur",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dur",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_trnd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchDefaultMonthWeekRSQL").append("\n"); 
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
		query.append("SELECT MIN(FM_PRD) FM_PRD, MAX(TO_PRD) TO_PRD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT MIN(A.PLN_YR||A.PLN_WK) FM_PRD," ).append("\n"); 
		query.append("MAX(A.PLN_YR||A.PLN_WK) TO_PRD" ).append("\n"); 
		query.append("FROM EQR_WK_PRD A" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT SUBSTR(@[op_trnd_tp_cd],2,1) TP_CD,TO_CHAR(SYSDATE,'YYYY') PLN_YR," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(A.WK_ST_DT,'YYYYMMDD')-(7*@[fm_dur]),'YYYYMMDD') FM_DT," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(A.WK_ST_DT,'YYYYMMDD')-(7*@[to_dur]),'YYYYMMDD') TO_DT" ).append("\n"); 
		query.append("FROM   EQR_WK_PRD A" ).append("\n"); 
		query.append("WHERE  A.PLN_YR BETWEEN TO_CHAR(TO_CHAR(SYSDATE,'YYYY') - 1) AND TO_CHAR(TO_CHAR(SYSDATE,'YYYY') + 1)" ).append("\n"); 
		query.append("AND    TO_CHAR(TRUNC(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])),'YYYYMMDD')  BETWEEN A.WK_ST_DT AND A.WK_END_DT" ).append("\n"); 
		query.append("--AND    TRUNC(sysdate)  BETWEEN A.WK_ST_DT AND A.WK_END_DT" ).append("\n"); 
		query.append("AND    SUBSTR(@[op_trnd_tp_cd],2,1) = 'W'" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("--    AND A.PLN_YR = B.PLN_YR" ).append("\n"); 
		query.append("AND   A.WK_ST_DT IN(B.FM_DT,B.TO_DT)" ).append("\n"); 
		query.append("AND   B.TP_CD = 'W'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT TO_CHAR(ADD_MONTHS(sysdate,-1*@[fm_dur]),'YYYYMM') FM_PRD," ).append("\n"); 
		query.append("TO_CHAR(ADD_MONTHS(sysdate,-1*@[to_dur]),'YYYYMM') TO_PRD" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("WHERE  SUBSTR(@[op_trnd_tp_cd],2,1) = 'M'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}