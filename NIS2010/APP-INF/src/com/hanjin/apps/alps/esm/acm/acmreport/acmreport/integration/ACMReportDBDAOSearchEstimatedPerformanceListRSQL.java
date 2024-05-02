/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ACMReportDBDAOSearchEstimatedPerformanceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMReportDBDAOSearchEstimatedPerformanceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Estimated Performance 정보를 조회
	  * </pre>
	  */
	public ACMReportDBDAOSearchEstimatedPerformanceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration").append("\n"); 
		query.append("FileName : ACMReportDBDAOSearchEstimatedPerformanceListRSQL").append("\n"); 
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
		query.append("SELECT REV_YRMON, " ).append("\n"); 
		query.append("	   BL_NO," ).append("\n"); 
		query.append("	   FAC_SEQ, " ).append("\n"); 
		query.append("	   BKG_NO, " ).append("\n"); 
		query.append("	   SLS_OFC_CD, " ).append("\n"); 
		query.append("	   AR_OFC_CD," ).append("\n"); 
		query.append("	   LOC_CD, " ).append("\n"); 
		query.append("	   GL_DT," ).append("\n"); 
		query.append("	   CURR_CD," ).append("\n"); 
		query.append("	   ACT_IF_COMM_AMT" ).append("\n"); 
		query.append("  FROM AGT_FAC_AR_IF" ).append("\n"); 
		query.append(" WHERE REV_YRMON = REPLACE(@[yrmon], '-', '')" ).append("\n"); 
		query.append("   AND ROWNUM < 100" ).append("\n"); 

	}
}