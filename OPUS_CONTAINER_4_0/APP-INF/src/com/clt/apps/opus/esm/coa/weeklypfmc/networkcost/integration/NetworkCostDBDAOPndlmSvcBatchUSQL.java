/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NetworkCostDBDAOPndlmSvcBatchUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOPndlmSvcBatchUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TO_YRMON 일괄 업데이트
	  * </pre>
	  */
	public NetworkCostDBDAOPndlmSvcBatchUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOPndlmSvcBatchUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_PNDLM_SVC A " ).append("\n"); 
		query.append("USING(" ).append("\n"); 
		query.append("      SELECT SLAN_CD, DIR_CD, EFF_FM_DT, TO_DT" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT SLAN_CD, DIR_CD, EFF_FM_DT, EFF_TO_DT" ).append("\n"); 
		query.append("                   , TO_CHAR(TO_DATE(LEAD(EFF_FM_DT,1) OVER (PARTITION BY SLAN_CD, DIR_CD ORDER BY EFF_FM_DT),'YYYYMMDD')-1,'YYYYMMDD') TO_DT" ).append("\n"); 
		query.append("              FROM COA_PNDLM_SVC" ).append("\n"); 
		query.append("              ORDER BY SLAN_CD, DIR_CD, EFF_FM_DT )" ).append("\n"); 
		query.append("      WHERE TO_DT IS NOT NULL" ).append("\n"); 
		query.append("        AND EFF_TO_DT IS NULL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (  A.SLAN_CD = B.SLAN_CD" ).append("\n"); 
		query.append("  AND A.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("  AND A.EFF_FM_DT = B.EFF_FM_DT)" ).append("\n"); 
		query.append("WHEN MATCHED THEN UPDATE " ).append("\n"); 
		query.append("    SET EFF_TO_DT = B.TO_DT" ).append("\n"); 

	}
}