/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostStructureDBDAOSearchCostCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.20 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Dae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOSearchCostCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CostCode 조회
	  * </pre>
	  */
	public CostStructureDBDAOSearchCostCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOSearchCostCodeListRSQL").append("\n"); 
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
		query.append("A.DELT_FLG                                    DELT_FLG" ).append("\n"); 
		query.append(",C.STND_COST_TP_CD                             STND_COST_TP_CD" ).append("\n"); 
		query.append(",A.MGRP_COST_CD                                MGRP_COST_CD" ).append("\n"); 
		query.append(",C.MGRP_COST_CD_DESC                           MGRP_COST_CD_DESC" ).append("\n"); 
		query.append(",A.SGRP_COST_CD                                SGRP_COST_CD" ).append("\n"); 
		query.append(",B.SGRP_COST_CD_DESC                           SGRP_COST_NM" ).append("\n"); 
		query.append(",A.STND_COST_CD                                STND_COST_CD" ).append("\n"); 
		query.append(",A.STND_COST_NM                                STND_COST_NM" ).append("\n"); 
		query.append(",A.PERF_VW_CD                                  PERF_VW_CD" ).append("\n"); 
		query.append(",A.HIR_SCP_FLG                                 HIR_SCP_FLG" ).append("\n"); 
		query.append(",A.RA_MN_COST_CD                               RA_MN_COST_CD" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD00895'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = A.RA_MN_COST_CD)   RA_MN_COST_NM" ).append("\n"); 
		query.append(",A.RA_SGRP_COST_CD" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD00894'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = A.RA_SGRP_COST_CD) RA_SGRP_COST_NM" ).append("\n"); 
		query.append(",A.RA_ACCT_CD                                  RA_ACCT_CD" ).append("\n"); 
		query.append(",A.KRN_COST_FULL_DESC                          KRN_COST_FULL_DESC" ).append("\n"); 
		query.append(",RA_PERF_VW_CD                                 RA_PERF_VW_CD" ).append("\n"); 
		query.append("FROM COA_STND_ACCT A" ).append("\n"); 
		query.append(",COA_SUB_GRP_COST B" ).append("\n"); 
		query.append(",COA_MN_GRP_COST C" ).append("\n"); 
		query.append("WHERE A.MGRP_COST_CD = C.MGRP_COST_CD" ).append("\n"); 
		query.append("AND A.SGRP_COST_CD = B.SGRP_COST_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("C.STND_COST_TP_CD" ).append("\n"); 
		query.append(",A.MGRP_COST_CD" ).append("\n"); 
		query.append(",A.SGRP_COST_CD" ).append("\n"); 
		query.append(",A.STND_COST_CD" ).append("\n"); 

	}
}