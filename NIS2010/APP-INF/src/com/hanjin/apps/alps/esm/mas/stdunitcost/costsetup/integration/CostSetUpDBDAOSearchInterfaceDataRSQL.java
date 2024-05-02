/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostSetUpDBDAOSearchInterfaceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.05
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.12.05 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOSearchInterfaceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * A/P에서 I/F된 데이터 조회
	  * </pre>
	  */
	public CostSetUpDBDAOSearchInterfaceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOSearchInterfaceDataRSQL").append("\n"); 
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
		query.append("SELECT WP.COST_YR, SUBSTR(AP.RMONTH,5,2) AS REV_MON, WP.COST_WK," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(AP.MGA_ACCOUNT,'51102000',ACTUAL_USD_AMT)),0) AS MT_STEVE," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(AP.MGA_ACCOUNT,'51302000',ACTUAL_USD_AMT)),0) AS MT_TRANS," ).append("\n"); 
		query.append("       NVL(SUM(ACTUAL_USD_AMT),0) AS TTL_AMT" ).append("\n"); 
		query.append("  FROM MAS_HJSAP_INVOICE_AMT_IF AP," ).append("\n"); 
		query.append("       MAS_WK_PRD               WP" ).append("\n"); 
		query.append(" WHERE WP.COST_YR         = SUBSTR(AP.RMONTH,1,4)" ).append("\n"); 
		query.append("   AND AP.RMONTH = REPLACE(@[f_yearweek],'-','')" ).append("\n"); 
		query.append("   AND AP.INTERFACE_DATE  BETWEEN WP.SLS_FM_DT AND WP.SLS_TO_DT" ).append("\n"); 
		query.append(" GROUP BY WP.COST_YR, AP.RMONTH, WP.COST_WK" ).append("\n"); 
		query.append(" ORDER BY WP.COST_YR, WP.COST_WK, AP.RMONTH" ).append("\n"); 

	}
}