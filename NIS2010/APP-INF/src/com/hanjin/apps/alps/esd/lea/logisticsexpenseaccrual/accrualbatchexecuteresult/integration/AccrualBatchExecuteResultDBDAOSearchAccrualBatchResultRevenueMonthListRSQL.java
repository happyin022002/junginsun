/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultRevenueMonthListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultRevenueMonthListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Expense Report by Rev.Month
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultRevenueMonthListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rev_yrmon_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultRevenueMonthListRSQL").append("\n"); 
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
		query.append("SELECT    BB.RHQ_CD" ).append("\n"); 
		query.append("      ,   SS.EXE_YRMON" ).append("\n"); 
		query.append("      ,   SS.REV_YRMON" ).append("\n"); 
		query.append("      ,   SS.MN_COST_TP_CD" ).append("\n"); 
		query.append("      ,   (SELECT  TP.SUB_COST_TP_NM" ).append("\n"); 
		query.append("           FROM    LEA_SUB_COST_TP    TP" ).append("\n"); 
		query.append("           WHERE   TP.SUB_COST_TP_CD  = SS.SUB_COST_TP_CD" ).append("\n"); 
		query.append("          )                                                       AS SUB_COST_TP_NM" ).append("\n"); 
		query.append("      ,   SUM(SS.ESTM_COST_AMT   )                                AS ESTM_COST_AMT   " ).append("\n"); 
		query.append("      ,   SUM(SS.PRE_ACT_COST_AMT)                                AS PRE_ACT_COST_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,   CASE WHEN SS.ACCL_AUTO_CD = 'A' THEN SUM(SS.PST_ACT_COST_AMT)" ).append("\n"); 
		query.append("               ELSE SUM(SS.PRE_ACT_COST_AMT)" ).append("\n"); 
		query.append("          END  																												ACT_COST_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("	  ,   SUM(SS.PST_ACT_COST_AMT) - SUM(SS.PRE_ACT_COST_AMT)           													AS DIF_ACT_COST_AMT" ).append("\n"); 
		query.append("      ,   CASE WHEN SUM(SS.ESTM_COST_AMT) = 0 THEN 0" ).append("\n"); 
		query.append("               ELSE ABS(SUM(SS.PST_ACT_COST_AMT)/SUM(SS.ESTM_COST_AMT))*100" ).append("\n"); 
		query.append("          END                                                                        										AS ACT_COST_RATIO" ).append("\n"); 
		query.append("      ,   SUM(SS.ADJ_ACCL_COST_AMT)                                                  										AS ADJ_ACCL_COST_AMT " ).append("\n"); 
		query.append("      ,   CASE WHEN SS.ACCL_AUTO_CD = 'A' THEN SUM(SS.PST_ACT_COST_AMT) + SUM(SS.ADJ_ACCL_COST_AMT)     " ).append("\n"); 
		query.append("			   ELSE SUM(SS.PRE_ACT_COST_AMT) + SUM(SS.ADJ_ACCL_COST_AMT) " ).append("\n"); 
		query.append("	      END    																											AS CFM_COST_AMT" ).append("\n"); 
		query.append("      ,   CASE WHEN SS.ACCL_AUTO_CD = 'A' THEN SUM(SS.PST_ACT_COST_AMT) + SUM(SS.ADJ_ACCL_COST_AMT) - SUM(SS.ESTM_COST_AMT)" ).append("\n"); 
		query.append("			   ELSE 0" ).append("\n"); 
		query.append("		  END   																											AS DIF_COST_AMT" ).append("\n"); 
		query.append("FROM      LEA_ACCL_COST_SMRY    SS" ).append("\n"); 
		query.append("      ,   " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		SELECT 		YY.RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				,	YY.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				,	YY.SUB_OFC_CD" ).append("\n"); 
		query.append("		 FROM	(	" ).append("\n"); 
		query.append("					------------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("        			SELECT     	DISTINCT" ).append("\n"); 
		query.append("                   				CASE WHEN XX.OFC_CD IN ('SELTBB','SELOPE') THEN 'SHARC' --('SELTOB','SELCOE') THEN 'SHAAS'" ).append("\n"); 
		query.append("                        			 ELSE XX.OFC_N3RD_LVL_CD   " ).append("\n"); 
		query.append("                   				END							AS RHQ_CD  " ).append("\n"); 
		query.append("               				,   CASE WHEN XX.OFC_CD IN ('SELTBB','SELOPE') THEN 'SELSC' --('SELTOB','SELCOE') THEN 'SELBB'" ).append("\n"); 
		query.append("                        			 ELSE XX.OFC_N5TH_LVL_CD   " ).append("\n"); 
		query.append("                   				END  						AS OFC_CD " ).append("\n"); 
		query.append("               				,   XX.OFC_CD            		AS SUB_OFC_CD  " ).append("\n"); 
		query.append("        			FROM       	(" ).append("\n"); 
		query.append("                           SELECT     *" ).append("\n"); 
		query.append("                           FROM       (" ).append("\n"); 
		query.append("                                      SELECT          L.OFC_N3RD_LVL_CD      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                 ,    L.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                 ,    L.OFC_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                 ,    L.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                 ,    L.OFC_APLY_FM_YRMON" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                 ,    ROW_NUMBER() OVER (PARTITION BY L.OFC_CD ORDER BY L.OFC_APLY_TO_YRMON DESC)  OFC_ORDER " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                       FROM           COA_OFC_LVL            L" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                       WHERE          L.OFC_N3RD_LVL_CD      IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                       AND            L.OFC_N5TH_LVL_CD      IS NOT NULL  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                       ) X" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            WHERE      X.OFC_ORDER    = 1   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                          ) XX  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						  UNION ALL SELECT 'SELHO', 'SELCON', 'SELCON' FROM DUAL  --'SELHO', 'SELCOT', 'SELCOT'" ).append("\n"); 
		query.append("                        /* 2012.06.26 :: MANUAL INPUT(OFC:SELCOL) 조회를 위한 HARD CODING */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					------------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				) YY " ).append("\n"); 
		query.append("                       /* COA_OFC_LVL 테이블과 JOIN */" ).append("\n"); 
		query.append("          WHERE        YY.RHQ_CD   = @[f_rhq_cd]" ).append("\n"); 
		query.append("          ) BB" ).append("\n"); 
		query.append("WHERE     SS.REV_YRMON          BETWEEN REPLACE(@[frm_rev_yrmon_from], '-') AND REPLACE(@[frm_rev_yrmon_to], '-')" ).append("\n"); 
		query.append("AND   	  SS.OTR_CRR_FLG  		=  'N'" ).append("\n"); 
		query.append("AND       SS.CTRL_OFC_CD        = BB.SUB_OFC_CD                    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND ( 1 = 2 " ).append("\n"); 
		query.append("#if (${f_cost_type_f} == '1')" ).append("\n"); 
		query.append("    OR SS.MN_COST_TP_CD      IN ('TR', 'TM')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cost_type_m} == '1')" ).append("\n"); 
		query.append("    OR SS.MN_COST_TP_CD = 'MT'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cost_type_c} == '1')" ).append("\n"); 
		query.append("    OR SS.MN_COST_TP_CD = 'CH'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cost_type_fv} == '1')" ).append("\n"); 
		query.append("    OR SS.SUB_COST_TP_CD     IN ('TRDF','TMDF')  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cost_type_ev} == '1')" ).append("\n"); 
		query.append("    OR SS.SUB_COST_TP_CD     IN ('TRDM','TMDM')  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("GROUP BY  BB.RHQ_CD" ).append("\n"); 
		query.append("      ,   SS.EXE_YRMON" ).append("\n"); 
		query.append("      ,   SS.REV_YRMON" ).append("\n"); 
		query.append("      ,   SS.MN_COST_TP_CD  " ).append("\n"); 
		query.append("      ,   SS.SUB_COST_TP_CD " ).append("\n"); 
		query.append("	  ,   SS.ACCL_AUTO_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SS.EXE_YRMON" ).append("\n"); 
		query.append("      ,	 SS.REV_YRMON" ).append("\n"); 
		query.append("      ,  SS.MN_COST_TP_CD" ).append("\n"); 
		query.append("      ,	 SS.SUB_COST_TP_CD" ).append("\n"); 

	}
}