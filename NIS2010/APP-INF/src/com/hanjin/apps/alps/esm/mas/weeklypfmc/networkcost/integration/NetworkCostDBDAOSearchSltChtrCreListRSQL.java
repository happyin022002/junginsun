/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOSearchSltChtrCreListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchSltChtrCreListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSltChtrCreList SELECT
	  * </pre>
	  */
	public NetworkCostDBDAOSearchSltChtrCreListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchSltChtrCreListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    (CASE WHEN no = 1 THEN 'J'" ).append("\n"); 
		query.append("          WHEN no = 2 THEN 'J'" ).append("\n"); 
		query.append("          WHEN no = 3 THEN 'S'" ).append("\n"); 
		query.append("     END) AS SLT_TP_CD" ).append("\n"); 
		query.append("   ,(CASE WHEN no = 1 THEN 'Joint / Indepent Operation'" ).append("\n"); 
		query.append("          WHEN no = 2 THEN 'Joint / Indepent Operation'" ).append("\n"); 
		query.append("          WHEN no = 3 THEN 'Slot Charter Lane'" ).append("\n"); 
		query.append("     END) AS SLT_TP_NM" ).append("\n"); 
		query.append("   ,(CASE WHEN no = 1 THEN 'SML'" ).append("\n"); 
		query.append("          WHEN no = 2 THEN 'OTH'" ).append("\n"); 
		query.append("          WHEN no = 3 THEN 'OTH'" ).append("\n"); 
		query.append("     END) AS VOP_CD" ).append("\n"); 
		query.append("   ,(CASE WHEN no = 1 THEN ''" ).append("\n"); 
		query.append("          WHEN no = 2 THEN ''" ).append("\n"); 
		query.append("          WHEN no = 3 THEN ''" ).append("\n"); 
		query.append("     END) AS INCM_BZC_CHTR_CD" ).append("\n"); 
		query.append("   ,(CASE WHEN no = 1 THEN ''" ).append("\n"); 
		query.append("          WHEN no = 2 THEN ''" ).append("\n"); 
		query.append("          WHEN no = 3 THEN ''" ).append("\n"); 
		query.append("     END) AS INCM_SUB_LSE_CD" ).append("\n"); 
		query.append("   ,(CASE WHEN no = 1 THEN ''" ).append("\n"); 
		query.append("          WHEN no = 2 THEN ''" ).append("\n"); 
		query.append("          WHEN no = 3 THEN ''" ).append("\n"); 
		query.append("     END) AS INCM_CRS_CHTR_CD" ).append("\n"); 
		query.append("   ,(CASE WHEN no = 1 THEN ''" ).append("\n"); 
		query.append("          WHEN no = 2 THEN 'C'" ).append("\n"); 
		query.append("          WHEN no = 3 THEN 'C'" ).append("\n"); 
		query.append("     END) AS EXPN_BZC_CHTR_CD" ).append("\n"); 
		query.append("   ,(CASE WHEN no = 1 THEN ''" ).append("\n"); 
		query.append("          WHEN no = 2 THEN ''" ).append("\n"); 
		query.append("          WHEN no = 3 THEN ''" ).append("\n"); 
		query.append("     END) AS EXPN_SUB_CHTR_CD" ).append("\n"); 
		query.append("   ,(CASE WHEN no = 1 THEN ''" ).append("\n"); 
		query.append("          WHEN no = 2 THEN ''" ).append("\n"); 
		query.append("          WHEN no = 3 THEN ''" ).append("\n"); 
		query.append("     END) AS EXPN_CRS_CHTR_CD" ).append("\n"); 
		query.append("   ,'R' AS OP_CRE_STS_CD" ).append("\n"); 
		query.append("   ,'Y' AS CRE_SLCT_FLG" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("      ,(SELECT CPY_NO AS no FROM COM_CPY_NO WHERE CPY_NO BETWEEN 1 AND 3)" ).append("\n"); 

	}
}