/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CostSetUpDBDAOSearchMtyRepoTESTRSCostVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.21
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.02.21 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOSearchMtyRepoTESTRSCostVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MtyRepoTESTRSCostVO 생성
	  * </pre>
	  */
	public CostSetUpDBDAOSearchMtyRepoTESTRSCostVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOSearchMtyRepoTESTRSCostVORSQL").append("\n"); 
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
		query.append("SELECT A.COST_YRMON" ).append("\n"); 
		query.append("     , A.COST_WK                -- WK" ).append("\n"); 
		query.append("     , B.APLY_ADJ_PL_FLG       -- Apply to adjusted P&L" ).append("\n"); 
		query.append("     , B.MTY_TML_MNL_AMT" ).append("\n"); 
		query.append("     , B.MTY_TRSP_MNL_AMT" ).append("\n"); 
		query.append("     , NVL(B.MTY_TML_MNL_AMT,0) + NVL(B.MTY_TRSP_MNL_AMT,0) MTY_TTL_MNL_AMT" ).append("\n"); 
		query.append("     , B.MTY_TML_IF_AMT" ).append("\n"); 
		query.append("     , B.MTY_TRSP_IF_AMT" ).append("\n"); 
		query.append("     , NVL(B.MTY_TML_IF_AMT,0) + NVL(B.MTY_TRSP_IF_AMT,0) MTY_TTL_IF_AMT" ).append("\n"); 
		query.append("     , '' AS SEL_FLG" ).append("\n"); 
		query.append("     , '' AS USER_ID" ).append("\n"); 
		query.append("     , A.SLS_FM_DT" ).append("\n"); 
		query.append("     , B.MTY_TML_CRE_BSE_IF_AMT" ).append("\n"); 
		query.append("     , B.MTY_TRSP_CRE_BSE_IF_AMT" ).append("\n"); 
		query.append("     , NVL(B.MTY_TML_CRE_BSE_IF_AMT,0) + NVL(B.MTY_TRSP_CRE_BSE_IF_AMT,0) MTY_TTL_CRE_IF_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("         SELECT DISTINCT A.COST_YRMON" ).append("\n"); 
		query.append("              , A.COST_WK" ).append("\n"); 
		query.append("              , B.SLS_FM_DT" ).append("\n"); 
		query.append("           FROM COA_MON_VVD A" ).append("\n"); 
		query.append("              , (" ).append("\n"); 
		query.append("                 SELECT COST_WK" ).append("\n"); 
		query.append("                      , SLS_FM_DT" ).append("\n"); 
		query.append("                   FROM COA_WK_PRD" ).append("\n"); 
		query.append("                  WHERE SLS_FM_DT BETWEEN TO_CHAR(TO_DATE(@[f_cost_yrmon], 'YYYYMM') - 90, 'YYYYMMDD') AND TO_CHAR(TO_DATE(@[f_cost_yrmon], 'YYYYMM') + 210, 'YYYYMMDD')" ).append("\n"); 
		query.append("                  AND COST_YR BETWEEN SUBSTR(@[f_cost_yrmon],1,4)-1 AND SUBSTR(@[f_cost_yrmon],1,4)+1" ).append("\n"); 
		query.append("                ) B" ).append("\n"); 
		query.append("          WHERE A.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("            AND A.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("            AND a.COST_WK    = B.COST_WK" ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("      , COA_MTY_REPO_COST_DTL B" ).append("\n"); 
		query.append("  WHERE A.COST_YRMON = B.COST_YRMON(+)" ).append("\n"); 
		query.append("    AND A.COST_WK = B.COST_WK(+)" ).append("\n"); 
		query.append("ORDER BY A.SLS_FM_DT" ).append("\n"); 

	}
}