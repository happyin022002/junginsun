/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOsearchErpDtlExcelDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.20 
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

public class BudgetPortChargeMgtDBDAOsearchErpDtlExcelDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Detail Excel Down 조회
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOsearchErpDtlExcelDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtedate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOsearchErpDtlExcelDataRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(TO_DATE(ACT_DT,'YYYYMMDD'), 'YYYY-MM-DD') AS ACT_DT" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(EXE_YRMON,'YYYYMM'), 'YYYY-MM') AS EXE_YRMON" ).append("\n"); 
		query.append("     , SYS_SRC_ID" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(REV_YRMON,'YYYYMM'), 'YYYY-MM') AS REV_YRMON" ).append("\n"); 
		query.append("     , ACCT_CD" ).append("\n"); 
		query.append("     , COST_CD" ).append("\n"); 
		query.append("     , COST_NM" ).append("\n"); 
		query.append("     , ESTM_SEQ_NO" ).append("\n"); 
		query.append("     , RLANE REV_LANE" ).append("\n"); 
		query.append("     , LOC_CD PORT" ).append("\n"); 
		query.append("     , RVVD REV_VVD" ).append("\n"); 
		query.append("     , LOCL_CURR_CD" ).append("\n"); 
		query.append("     , ESTM_AMT" ).append("\n"); 
		query.append("     , ACT_AMT" ).append("\n"); 
		query.append("     , ACCL_AMT" ).append("\n"); 
		query.append("     , '' CRE_USR_ID" ).append("\n"); 
		query.append("     , '' UPD_USR_ID" ).append("\n"); 
		query.append("     , '' sdt" ).append("\n"); 
		query.append("     , '' edt" ).append("\n"); 
		query.append("     , '' match_flag" ).append("\n"); 
		query.append("     , CONTI_CD" ).append("\n"); 
		query.append("     , CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , UPD_FLG" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("  FROM (SELECT EXE_YRMON" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("             , ACT_DT" ).append("\n"); 
		query.append("             , ACCT_CD" ).append("\n"); 
		query.append("             , ACCT_DTL_CD AS COST_CD" ).append("\n"); 
		query.append("             , (SELECT MAX(X.LGS_COST_FULL_NM) FROM TES_LGS_COST X WHERE X.LGS_COST_CD = G.ACCT_DTL_CD) AS COST_NM" ).append("\n"); 
		query.append("             , (SELECT RLANE_CD" ).append("\n"); 
		query.append("                  FROM AR_MST_REV_VVD A" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = G.VSL_CD" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = G.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = G.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND A.RLANE_DIR_CD = G.REV_DIR_CD" ).append("\n"); 
		query.append("                   AND A.DELT_FLG = 'N' /*2015.09.11 Add*/" ).append("\n"); 
		query.append("                   AND ROWNUM = 1 ) RLANE" ).append("\n"); 
		query.append("             , COST_ACT_PLC_CD AS LOC_CD" ).append("\n"); 
		query.append("             , VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD RVVD" ).append("\n"); 
		query.append("             , LOCL_CURR_CD" ).append("\n"); 
		query.append("             , ESTM_AMT" ).append("\n"); 
		query.append("             , ACT_AMT" ).append("\n"); 
		query.append("             , ACCL_AMT" ).append("\n"); 
		query.append("             , ESTM_SEQ_NO" ).append("\n"); 
		query.append("             , SYS_SRC_ID" ).append("\n"); 
		query.append("             , (SELECT CONTI_CD  FROM MDM_LOCATION WHERE LOC_CD =  SUBSTR(G.COST_ACT_PLC_CD, 1,5) ) CONTI_CD" ).append("\n"); 
		query.append("             , TO_CHAR(VVD_DUR_NO) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , NVL(SUBSTR(UPD_RMK, 1,1), 'N') AS UPD_FLG" ).append("\n"); 
		query.append("             , UPD_USR_ID" ).append("\n"); 
		query.append("             , TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("          FROM GL_ESTM_IF_ERP G" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND G.EXE_YRMON = REPLACE(@[exe_yrmon], '-', '')" ).append("\n"); 
		query.append("           AND G.SYS_SRC_ID = 'PSO' " ).append("\n"); 
		query.append("   		   #if( ${txtsdate} !='' && ${txtedate} !='' )" ).append("\n"); 
		query.append("               AND SUBSTR(ACT_DT,1,6) BETWEEN REPLACE(@[txtsdate], '-', '') AND REPLACE(@[txtedate], '-', '') " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("          /*2016.04.18 Add : Accrual 대상 만 진행함.*/" ).append("\n"); 
		query.append("          AND EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                        FROM SCO_AP_COST_ACT_INFO SACAI" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND SACAI.SRC_MDL_CD          = 'PSO'" ).append("\n"); 
		query.append("                          AND NVL(SACAI.ENBL_FLG, 'N')  = 'N'" ).append("\n"); 
		query.append("                          AND NVL(SACAI.ACCL_FLG, 'N')  = 'Y'" ).append("\n"); 
		query.append("                          AND SACAI.ACT_COST_CD         = G.ACCT_DTL_CD)" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" ORDER BY ACT_DT, ACCT_CD, COST_CD, RLANE, LOC_CD, RVVD, EXE_YRMON, REV_YRMON, LOC_CD, CLPT_IND_SEQ" ).append("\n"); 

	}
}