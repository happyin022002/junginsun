/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchYearWeekListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOsearchYearWeekListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016-02-12
	  * Equipment Management > CNTR Inventory > Inventory Status > Land Inventory > Land Inventory with Optimum Stock 
	  * 조회를 위한 week list
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchYearWeekListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchYearWeekListRSQL").append("\n"); 
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
		query.append("WITH EQR_WK AS" ).append("\n"); 
		query.append("(SELECT ROWNUM NUM" ).append("\n"); 
		query.append("       ,A.*" ).append("\n"); 
		query.append("  FROM (SELECT * " ).append("\n"); 
		query.append("          FROM EQR_WK_PRD" ).append("\n"); 
		query.append("        ORDER BY PLN_YR, PLN_WK) A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", B_WK AS" ).append("\n"); 
		query.append("(SELECT E.PLN_YR||E.PLN_WK TGT_YRWK" ).append("\n"); 
		query.append("       ,E.NUM NUM" ).append("\n"); 
		query.append("       ,E.PLN_YR" ).append("\n"); 
		query.append("       ,E.PLN_WK" ).append("\n"); 
		query.append("   FROM EQR_WK E, (SELECT TGT_BSE_DT FROM CIM_OPTM_STK_SMRY" ).append("\n"); 
		query.append("                    WHERE OPTM_STK_MNG_TP_CD = 'B') B" ).append("\n"); 
		query.append("  WHERE TO_DATE(B.TGT_BSE_DT,'YYYYMMDD') BETWEEN TO_DATE(E.WK_ST_DT,'YYYYMMDD') AND TO_DATE(E.WK_END_DT,'YYYYMMDD')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT 'T' WK_FLG " ).append("\n"); 
		query.append("        ,PLN_YR||PLN_WK YRWK" ).append("\n"); 
		query.append("   FROM EQR_WK_PRD " ).append("\n"); 
		query.append("  WHERE SYSDATE BETWEEN TO_DATE(WK_ST_DT,'YYYY/MM/DD HH24:MI:SS') AND TO_DATE(WK_END_DT,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'B' WK_FLG" ).append("\n"); 
		query.append("       ,E.PLN_YR || E.PLN_WK YRWK" ).append("\n"); 
		query.append("  FROM EQR_WK E, B_WK B" ).append("\n"); 
		query.append(" WHERE E.NUM = B.NUM-3" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'PB' WK_FLG" ).append("\n"); 
		query.append("       ,E.PLN_YR || E.PLN_WK YRWK" ).append("\n"); 
		query.append("  FROM EQR_WK E, B_WK B" ).append("\n"); 
		query.append(" WHERE E.NUM = B.NUM-7" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'NB' WK_FLG" ).append("\n"); 
		query.append("       ,E.PLN_YR || E.PLN_WK YRWK" ).append("\n"); 
		query.append("  FROM EQR_WK E, B_WK B" ).append("\n"); 
		query.append(" WHERE E.NUM = B.NUM+1" ).append("\n"); 

	}
}