/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOselectYdChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOselectYdChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * selectYdChg
	  * 2016.01.22 ETD Date
	  * 2016.04.18 ACCL_FLG = Y Add
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOselectYdChgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOselectYdChgRSQL").append("\n"); 
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
		query.append("/*Estimate Expense Apply Call : YardChargeVO*/" ).append("\n"); 
		query.append("SELECT YD_CHG_NO" ).append("\n"); 
		query.append("     , YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , YD_CD" ).append("\n"); 
		query.append("     , LGS_COST_CD" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("  FROM (SELECT MAX (C.YD_CHG_NO) YD_CHG_NO" ).append("\n"); 
		query.append("             , MAX (C.YD_CHG_VER_SEQ) YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("             , SUBSTR (MAX (C.YD_CHG_VER_SEQ || C.CURR_CD), -3) CURR_CD" ).append("\n"); 
		query.append("             , C.YD_CD" ).append("\n"); 
		query.append("             , C.LGS_COST_CD" ).append("\n"); 
		query.append("             , C.VNDR_SEQ" ).append("\n"); 
		query.append("             , C.CPLS_FLG" ).append("\n"); 
		query.append("             , COUNT( * ) OVER (PARTITION BY C.YD_CD, C.LGS_COST_CD" ).append("\n"); 
		query.append("                 ORDER BY C.YD_CD, C.LGS_COST_CD) CNT" ).append("\n"); 
		query.append("          FROM PSO_YD_CHG C" ).append("\n"); 
		query.append("             , MDM_VENDOR M" ).append("\n"); 
		query.append("         WHERE C.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("           AND TO_DATE(REPLACE(@[rev_yrmon], '-'),'YYYYMMDD') BETWEEN C.EFF_DT AND C.EXP_DT " ).append("\n"); 
		query.append("           AND C.VNDR_SEQ = M.VNDR_SEQ" ).append("\n"); 
		query.append("         GROUP BY C.YD_CD" ).append("\n"); 
		query.append("             , C.LGS_COST_CD" ).append("\n"); 
		query.append("             , C.VNDR_SEQ" ).append("\n"); 
		query.append("             , C.CPLS_FLG)" ).append("\n"); 
		query.append(" WHERE ( CASE WHEN CNT >= 2 THEN 'Y' ELSE CPLS_FLG END ) = CPLS_FLG" ).append("\n"); 
		query.append("  /*2016.04.18 Add : Accrual 대상 만 진행함.*/" ).append("\n"); 
		query.append("  AND EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                FROM SCO_AP_COST_ACT_INFO SACAI" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND SACAI.SRC_MDL_CD          = 'PSO'" ).append("\n"); 
		query.append("                  AND NVL(SACAI.ENBL_FLG, 'N')  = 'N'" ).append("\n"); 
		query.append("                  AND NVL(SACAI.ACCL_FLG, 'N')  = 'Y'" ).append("\n"); 
		query.append("                  AND SACAI.ACT_COST_CD         = LGS_COST_CD)" ).append("\n"); 

	}
}