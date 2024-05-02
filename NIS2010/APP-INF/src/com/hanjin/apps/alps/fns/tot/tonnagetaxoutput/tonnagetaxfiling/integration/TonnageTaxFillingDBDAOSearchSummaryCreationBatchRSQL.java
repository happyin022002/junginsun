/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxFillingDBDAOSearchSummaryCreationBatchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxFillingDBDAOSearchSummaryCreationBatchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic BSA Summary, Actual BSA Summary Batch Job 스케쥴 정보 조회
	  * </pre>
	  */
	public TonnageTaxFillingDBDAOSearchSummaryCreationBatchRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_itm_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("batch_year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.integration").append("\n"); 
		query.append("FileName : TonnageTaxFillingDBDAOSearchSummaryCreationBatchRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	TO_CHAR(TO_DATE(A.JB_FM_YRMON,'YYYYMM'),'YYYY-MM')   JB_FM_YRMON" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.JB_TO_YRMON,'YYYYMM'),'YYYY-MM')   JB_TO_YRMON" ).append("\n"); 
		query.append("	,A.BAT_ITM_NM" ).append("\n"); 
		query.append("	,DECODE(A.BAT_ITM_NM,'Basic BSA Summary','FNS_TOT_B004','Actual BSA Summary','FNS_TOT_B005') BAT_ID" ).append("\n"); 
		query.append("	,'' JB_STATUS" ).append("\n"); 
		query.append("	,TO_CHAR(A.EFF_DT,'YYYY-MM-DD HH24:MI') EFF_DT" ).append("\n"); 
		query.append("	,'' JB_END_DT" ).append("\n"); 
		query.append("	,A.JB_ID JOB_ID" ).append("\n"); 
		query.append("FROM TOT_JB_SKD A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${his_type} == 'status')" ).append("\n"); 
		query.append("    AND ((A.JB_FM_YRMON  BETWEEN @[batch_year]||'01' AND @[batch_year]||'12') OR (A.JB_TO_YRMON  BETWEEN @[batch_year]||'01' AND @[batch_year]||'12'))" ).append("\n"); 
		query.append("  #if (${bat_itm_nm} == 'ALL')" ).append("\n"); 
		query.append("    AND BAT_ITM_NM IN ('Basic BSA Summary','Actual BSA Summary')" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    AND BAT_ITM_NM = @[bat_itm_nm]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#elseif (${his_type} == 'search')" ).append("\n"); 
		query.append("    AND TO_CHAR(A.EFF_DT,'YYYYMM') BETWEEN @[search_year]||'01' AND @[search_year]||'12'" ).append("\n"); 
		query.append("	AND BAT_ITM_NM IN ('Basic BSA Summary','Actual BSA Summary')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("ORDER BY A.EFF_DT DESC" ).append("\n"); 

	}
}