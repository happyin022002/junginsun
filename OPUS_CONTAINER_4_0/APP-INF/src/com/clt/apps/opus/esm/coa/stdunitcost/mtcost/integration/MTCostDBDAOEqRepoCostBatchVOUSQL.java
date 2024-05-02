/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MTCostDBDAOEqRepoCostBatchVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTCostDBDAOEqRepoCostBatchVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * @20141021.SJH : COA_MTY_REPO_UT_COST의 EFF_TO_YRMON 일괄 업데이트
	  * </pre>
	  */
	public MTCostDBDAOEqRepoCostBatchVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOEqRepoCostBatchVOUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_MTY_REPO_UT_COST A" ).append("\n"); 
		query.append("USING(" ).append("\n"); 
		query.append("      SELECT COST_LOC_GRP_CD, CNTR_TPSZ_CD, TRD_CD, SCC_CD, EFF_FM_YRMON, TO_YRMON" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT COST_LOC_GRP_CD, CNTR_TPSZ_CD, TRD_CD, SCC_CD, EFF_FM_YRMON, EFF_TO_YRMON" ).append("\n"); 
		query.append("                   , TO_CHAR(ADD_MONTHS(TO_DATE(LEAD(EFF_FM_YRMON,1) OVER (PARTITION BY COST_LOC_GRP_CD, CNTR_TPSZ_CD, TRD_CD, SCC_CD ORDER BY EFF_FM_YRMON), 'YYYYMM'),-1), 'YYYYMM') TO_YRMON" ).append("\n"); 
		query.append("              FROM COA_MTY_REPO_UT_COST" ).append("\n"); 
		query.append("              ORDER BY COST_LOC_GRP_CD, CNTR_TPSZ_CD, TRD_CD, SCC_CD, EFF_FM_YRMON )" ).append("\n"); 
		query.append("      WHERE TO_YRMON IS NOT NULL" ).append("\n"); 
		query.append("        AND EFF_TO_YRMON IS NULL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (  A.COST_LOC_GRP_CD = B.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("  AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  AND A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("  AND A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("  AND A.EFF_FM_YRMON = B.EFF_FM_YRMON)" ).append("\n"); 
		query.append("WHEN MATCHED THEN UPDATE " ).append("\n"); 
		query.append("    SET EFF_TO_YRMON = B.TO_YRMON" ).append("\n"); 

	}
}