/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostSetUpDBDAOGeneralExpenseVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.21
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.01.21 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ock, KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOGeneralExpenseVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CostSetUpDBDAOGeneralExpenseVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOGeneralExpenseVORSQL").append("\n"); 
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
		query.append("SELECT REPLACE(@[f_cost_yrmon], '-','') COST_YRMON" ).append("\n"); 
		query.append("      , RHQ.OFC_CD RHQ_CD" ).append("\n"); 
		query.append("      , RHQ.OFC_GRP_NO " ).append("\n"); 
		query.append("      , NVL(GEN.OFC_VW_CD, @[ofc_vw_cd]) OFC_VW_CD" ).append("\n"); 
		query.append("      , NVL(GEN.GEN_EXPN_RTO, 0) GEN_EXPN_RTO" ).append("\n"); 
		query.append("      , NVL(GEN.GEN_EXPN_AMT, 0) GEN_EXPN_AMT" ).append("\n"); 
		query.append("      , (SELECT OTR_EXPN_AMT" ).append("\n"); 
		query.append("           FROM MAS_MNL_COST_STUP" ).append("\n"); 
		query.append("          WHERE COST_YRMON =  REPLACE(@[f_cost_yrmon], '-','')" ).append("\n"); 
		query.append("            AND cost_wk    = 'XX'" ).append("\n"); 
		query.append("            AND RLANE_CD   = 'GENTT'" ).append("\n"); 
		query.append("        ) OTR_EXPN_AMT	-- 일반관리비 확정금액 (메인화면에서 입력)" ).append("\n"); 
		query.append("      , GEN.CRE_USR_ID" ).append("\n"); 
		query.append("      , GEN.UPD_USR_ID" ).append("\n"); 
		query.append("      , '' F_COST_YRMON" ).append("\n"); 
		query.append("      , '' AS F_SWEEK" ).append("\n"); 
		query.append("      , '' AS F_DUR" ).append("\n"); 
		query.append("   FROM MAS_OFC_LVL RHQ" ).append("\n"); 
		query.append("      , MAS_GEN_EXPN_POTN GEN" ).append("\n"); 
		query.append("  WHERE RHQ.OFC_CD        = GEN.RHQ_CD(+)" ).append("\n"); 
		query.append("    AND RHQ.OFC_LVL       = '2'" ).append("\n"); 
		query.append("    AND GEN.OFC_VW_CD(+)  = @[ofc_vw_cd]" ).append("\n"); 
		query.append("    AND GEN.COST_YRMON(+) = REPLACE(@[f_cost_yrmon], '-','')" ).append("\n"); 
		query.append("ORDER BY RHQ_CD" ).append("\n"); 

	}
}