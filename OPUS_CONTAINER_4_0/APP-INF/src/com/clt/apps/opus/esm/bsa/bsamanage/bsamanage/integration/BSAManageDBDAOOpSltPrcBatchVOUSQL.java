/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BSAManageDBDAOOpSltPrcBatchVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOOpSltPrcBatchVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BSAManageDBDAOOpSltPrcBatchVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOOpSltPrcBatchVOUSQL").append("\n"); 
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
		query.append("MERGE INTO BSA_OP_SLT_PRC A" ).append("\n"); 
		query.append("USING(" ).append("\n"); 
		query.append("      SELECT TRD_CD, RLANE_CD, DIR_CD, VSL_CAPA, BSA_SLT_PRC_TO_DT, BSA_SLT_PRC_FM_DT, TO_DATE" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT TRD_CD, RLANE_CD, DIR_CD, VSL_CAPA, BSA_SLT_PRC_TO_DT" ).append("\n"); 
		query.append("                   , LAG(BSA_SLT_PRC_FM_DT,1) OVER (PARTITION BY TRD_CD, RLANE_CD, DIR_CD, VSL_CAPA ORDER BY BSA_SLT_PRC_FM_DT) BSA_SLT_PRC_FM_DT                   " ).append("\n"); 
		query.append("                   , TO_CHAR(TO_DATE(BSA_SLT_PRC_FM_DT,'YYYYMMDD')-1,'YYYYMMDD') TO_DATE" ).append("\n"); 
		query.append("              FROM BSA_OP_SLT_PRC " ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("      WHERE BSA_SLT_PRC_FM_DT IS NOT NULL" ).append("\n"); 
		query.append("        AND BSA_SLT_PRC_TO_DT = '99991231'" ).append("\n"); 
		query.append("      ORDER BY TRD_CD, RLANE_CD, DIR_CD, VSL_CAPA, BSA_SLT_PRC_FM_DT" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (  A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("  AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("  AND A.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("  AND A.VSL_CAPA = B.VSL_CAPA" ).append("\n"); 
		query.append("  AND A.BSA_SLT_PRC_FM_DT = B.BSA_SLT_PRC_FM_DT)" ).append("\n"); 
		query.append("WHEN MATCHED THEN UPDATE " ).append("\n"); 
		query.append("    SET BSA_SLT_PRC_TO_DT = B.TO_DATE" ).append("\n"); 

	}
}