/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EQHoldingDBDAOMultiEQHoldingIFMgmtCSQL.java
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

public class EQHoldingDBDAOMultiEQHoldingIFMgmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EQHoldingDBDAOMultiEQHoldingIFMgmtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.integration").append("\n"); 
		query.append("FileName : EQHoldingDBDAOMultiEQHoldingIFMgmtCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_EQ_HLD_IF_MGMT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	COST_YR" ).append("\n"); 
		query.append("	, COST_MON" ).append("\n"); 
		query.append("	, VER_TP_CD" ).append("\n"); 
		query.append("	, IF_VER_CD" ).append("\n"); 
		query.append("	, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, ACT_PRC_AMT" ).append("\n"); 
		query.append("	, ADJ_RT_AMT" ).append("\n"); 
		query.append("	, PLCY_PRC_AMT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" SELECT SUBSTR(@[cost_yrmon],1,4) COST_YR" ).append("\n"); 
		query.append("      , SUBSTR(@[cost_yrmon],5,2) COST_MON" ).append("\n"); 
		query.append("      , 'M' VER_TP_CD" ).append("\n"); 
		query.append("      , '0' IF_VER_CD" ).append("\n"); 
		query.append("      , TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , CASE WHEN @[cost_yrmon] >= '201707' THEN SUM(HLD_UC_AMT_NORM_ADJ)" ).append("\n"); 
		query.append("		ELSE SUM(HLD_UC_AMT_DMT + HLD_UC_AMT_DMT_SEA) " ).append("\n"); 
		query.append("		END  AS ACT_PRC_AMT" ).append("\n"); 
		query.append("      , 100 ADJ_RT_AMT" ).append("\n"); 
		query.append("      , SUM(HLD_UC_AMT_DMT + HLD_UC_AMT_DMT_SEA) PLCY_PRC_AMT" ).append("\n"); 
		query.append("      , @[cre_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE   " ).append("\n"); 
		query.append("      , @[upd_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE  " ).append("\n"); 
		query.append("   FROM MAS_CNTR_HLD_COST" ).append("\n"); 
		query.append("  WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("   AND TPSZ_CD <> 'BOX'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 		AND ACCT_CD IN (select stnd_cost_cd from MAS_COST_SRC_ACCT where SGRP_COST_CD = " ).append("\n"); 
		query.append("	      					CASE WHEN @[cost_yrmon] >= '201707' THEN 'EQC3'" ).append("\n"); 
		query.append("							ELSE 'EQCF'" ).append("\n"); 
		query.append("							END   )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY TPSZ_CD" ).append("\n"); 

	}
}