/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVODAOStlStatusBsaVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.25 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAOStlStatusBsaVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVODAOStlStatusBsaVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : MakeVODAOStlStatusBsaVORSQL").append("\n"); 
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
		query.append("SELECT  ''ACCT_YRMON," ).append("\n"); 
		query.append("        ''COST_YRMON," ).append("\n"); 
		query.append("        ''JO_CRR_CD," ).append("\n"); 
		query.append("        ''VVD," ).append("\n"); 
		query.append("        ''TRD_CD," ).append("\n"); 
		query.append("        ''RLANE_CD," ).append("\n"); 
		query.append("--        ''COA_BSA_CRR_PERF_AMT," ).append("\n"); 
		query.append("--        ''JOO_STL_LOCL_AMT," ).append("\n"); 
		query.append("--        ''COA_LEASE_CRR_PERF_AMT," ).append("\n"); 
		query.append("--        ''JOO_LEASE_STL_LOCL_AMT," ).append("\n"); 
		query.append("--        ''COA_ADD_CRR_PERF_AMT," ).append("\n"); 
		query.append("--        ''JOO_ADD_STL_LOCL_AMT," ).append("\n"); 
		query.append("--        ''COA101_BGCOLOR_YN," ).append("\n"); 
		query.append("--        ''COA102_BGCOLOR_YN," ).append("\n"); 
		query.append("--        ''COA103_BGCOLOR_YN, " ).append("\n"); 
		query.append("        '' OFC_CD," ).append("\n"); 
		query.append("        '' AS JOO_R_AMT," ).append("\n"); 
		query.append("        '' AS JOO_E_AMT," ).append("\n"); 
		query.append("        '' AS BSA_R_AMT," ).append("\n"); 
		query.append("        '' AS BSA_E_AMT," ).append("\n"); 
		query.append("        '' AS DIFF_R_YN," ).append("\n"); 
		query.append("        '' AS DIFF_E_YN" ).append("\n"); 
		query.append("  FROM  DUAL" ).append("\n"); 

	}
}