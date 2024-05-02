/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EQHoldingDBDAOSearchEQHldCostPdmNormalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQHoldingDBDAOSearchEQHldCostPdmNormalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Holding Cost PDM 조회
	  * </pre>
	  */
	public EQHoldingDBDAOSearchEQHldCostPdmNormalRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.integration").append("\n"); 
		query.append("FileName : EQHoldingDBDAOSearchEQHldCostPdmNormalRSQL").append("\n"); 
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
		query.append("      ,A.TPSZ_CD" ).append("\n"); 
		query.append("      ,A.ACCT_CD" ).append("\n"); 
		query.append("      ,(SELECT MAS_COST_SRC_CD_NM FROM MAS_COST_SRC_ACCT" ).append("\n"); 
		query.append("          WHERE STND_COST_CD = A.ACCT_CD) ACCT_NM" ).append("\n"); 
		query.append("      ,A.BX_KNT BOX_CNT" ).append("\n"); 
		query.append("      ,A.TTL_COST_AMT" ).append("\n"); 
		query.append("      ,A.DYS_DMT DAY_A" ).append("\n"); 
		query.append("      ,A.DYS_DMT_EXPT DAY_B" ).append("\n"); 
		query.append("      ,A.DYS_DMT_PCT DAY_A_PCT" ).append("\n"); 
		query.append("      ,A.DYS_DMT_EXPT_PCT DAY_B_PCT" ).append("\n"); 
		query.append("      ,A.DYS_DMT_COST DAY_A_COST" ).append("\n"); 
		query.append("      ,A.DYS_DMT_EXPT_COST DAY_B_COST" ).append("\n"); 
		query.append("      ,A.DYS_DMT_EXPT_SEA DAY_C" ).append("\n"); 
		query.append("      ,A.HLD_UC_AMT_DMT PDM_A" ).append("\n"); 
		query.append("      ,A.HLD_UC_AMT_DMT_SEA PDM_C" ).append("\n"); 
		query.append("	  , DYS_NORM, HLD_UC_AMT_NORM, HLD_UC_AMT_NORM_ADJ " ).append("\n"); 
		query.append("  FROM MAS_CNTR_HLD_COST A" ).append("\n"); 
		query.append("  WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("    #if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("      AND A.TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append(" 		AND ACCT_CD IN (select stnd_cost_cd from MAS_COST_SRC_ACCT where SGRP_COST_CD = " ).append("\n"); 
		query.append("	      					CASE WHEN @[f_cost_yrmon] >= '201707' THEN 'EQC3'" ).append("\n"); 
		query.append("							ELSE 'EQCF'" ).append("\n"); 
		query.append("							END   )" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("  ORDER BY COST_YRMON, TPSZ_CD, ACCT_CD" ).append("\n"); 

	}
}