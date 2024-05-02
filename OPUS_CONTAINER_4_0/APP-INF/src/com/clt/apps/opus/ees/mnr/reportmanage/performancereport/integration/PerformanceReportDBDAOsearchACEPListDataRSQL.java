/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOsearchACEPListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOsearchACEPListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACEP Candidate Cntr List 를 조회한다.
	  * </pre>
	  */
	public PerformanceReportDBDAOsearchACEPListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOsearchACEPListDataRSQL").append("\n"); 
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
		query.append("SELECT ESV.EQ_NO EQ_NO," ).append("\n"); 
		query.append("       ESV.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       ESV.LOC_CD LOC_CD," ).append("\n"); 
		query.append("       ESV.CRNT_YD_CD YD_CD," ).append("\n"); 
		query.append("       ESV.ONH_DT ONH_DT," ).append("\n"); 
		query.append("       ESV.RPR_DT RPR_DT," ).append("\n"); 
		query.append("       ROUND(MONTHS_BETWEEN(TO_DATE(@[cur_dt], 'YYYY-MM-DD'), TO_DATE(ESV.RPR_DT, 'YYYY-MM-DD')),0) OVER_MONTH," ).append("\n"); 
		query.append("       TO_CHAR(ADD_MONTHS(TO_DATE(ESV.RPR_DT, 'YYYY-MM-DD'),30),'YYYY-MM-DD') NEXT_AUDIT_DT " ).append("\n"); 
		query.append("  FROM MNR_EQ_STS_V ESV" ).append("\n"); 
		query.append(" WHERE ESV.EQ_TYPE = 'U'" ).append("\n"); 
		query.append("   AND ESV.ACT_IND = 'A'" ).append("\n"); 
		query.append("   AND ESV.RPR_DT < TO_CHAR(ADD_MONTHS(TO_DATE(@[cur_dt],'YYYY-MM-DD'),-1*@[month]), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${term_type} == 'A') " ).append("\n"); 
		query.append("   AND ESV.LSTM_CD IN ('OW','OL','LP','LT')" ).append("\n"); 
		query.append("   #elseif (${term_type} == 'OWN') " ).append("\n"); 
		query.append("   AND ESV.LSTM_CD IN ('OW','OL','LP')" ).append("\n"); 
		query.append("   #elseif (${term_type} == 'LSE') " ).append("\n"); 
		query.append("   AND ESV.LSTM_CD IN ('LT')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${acep_type} == 'RCC') " ).append("\n"); 
		query.append("   AND ESV.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("   #elseif (${acep_type} == 'LCC') " ).append("\n"); 
		query.append("   AND ESV.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("   #elseif (${acep_type} == 'SCC')  " ).append("\n"); 
		query.append("   AND ESV.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("   #elseif (${acep_type} == 'YARD') " ).append("\n"); 
		query.append("   AND ESV.CRNT_YD_CD = @[loc_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 

	}
}