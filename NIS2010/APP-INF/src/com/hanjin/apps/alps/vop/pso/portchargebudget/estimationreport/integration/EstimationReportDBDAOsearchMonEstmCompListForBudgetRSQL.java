/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EstimationReportDBDAOsearchMonEstmCompListForBudgetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.19
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.04.19 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationReportDBDAOsearchMonEstmCompListForBudgetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사업계획 항비실적 summary
	  * </pre>
	  */
	public EstimationReportDBDAOsearchMonEstmCompListForBudgetRSQL(){
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
		params.put("bud_str",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.integration").append("\n"); 
		query.append("FileName : EstimationReportDBDAOsearchMonEstmCompListForBudgetRSQL").append("\n"); 
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
		query.append("SELECT  RLANE_CD                                                          -- LANE" ).append("\n"); 
		query.append("       ,SUM(PT_CHG_CNT) SUM_CNT1                                          -- 항차수" ).append("\n"); 
		query.append("       ,SUM(PT_CNT) SUM_CNT_PORT                                          -- 포트수" ).append("\n"); 
		query.append("       ,SUM(ACT_PT_CNT) SUM_ACT_PORT                                      -- ACT 포트수" ).append("\n"); 
		query.append("       ,SUM(PT_CHG) SUM_AMT1                                              -- 항비" ).append("\n"); 
		query.append("       ,SUM(CNL_FEE_CNT) SUM_CNT2                                         -- 운하통항 항차수" ).append("\n"); 
		query.append("       ,SUM(CNL_FEE) SUM_AMT2                                             -- 운하통항비" ).append("\n"); 
		query.append("       ,SUM(PT_CHG)+SUM(CNL_FEE) TOTAL_SUM_AMT                            -- 전체항비" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("                     BUD_YRMON, " ).append("\n"); 
		query.append("                     RLANE_CD, " ).append("\n"); 
		query.append("                     VSL_CD||SKD_VOY_NO||SKD_DIR_CD, " ).append("\n"); 
		query.append("                     MAX(PT_CNT) PT_CNT," ).append("\n"); 
		query.append("                     MAX(PORT_CHG_AMT) PT_CHG, " ).append("\n"); 
		query.append("                     MAX(CNL_FEE_AMT) CNL_FEE," ).append("\n"); 
		query.append("        SUM(ACT_PT_CNT) ACT_PT_CNT," ).append("\n"); 
		query.append("                     DECODE(SUM(PORT_CHG_AMT), 0, 0, 1) PT_CHG_CNT," ).append("\n"); 
		query.append("                     DECODE(SUM(CNL_FEE_AMT), 0, 0, 1) CNL_FEE_CNT" ).append("\n"); 
		query.append("           FROM  (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("               BUD_SCNR_NO," ).append("\n"); 
		query.append("               TRD_CD," ).append("\n"); 
		query.append("               SUB_TRD_CD," ).append("\n"); 
		query.append("               VSL_CD," ).append("\n"); 
		query.append("               SKD_VOY_NO," ).append("\n"); 
		query.append("               SKD_DIR_CD," ).append("\n"); 
		query.append("               RLANE_CD," ).append("\n"); 
		query.append("               BUD_YRMON," ).append("\n"); 
		query.append("               TURN_PORT_IND_CD," ).append("\n"); 
		query.append("               CNTR_VSL_CLSS_CAPA," ).append("\n"); 
		query.append("               PORT_CHG_AMT," ).append("\n"); 
		query.append("               CNL_FEE_AMT ," ).append("\n"); 
		query.append("               DECODE(TURN_PORT_IND_CD, 'N', 1, 0.5) ACT_PT_CNT," ).append("\n"); 
		query.append("               COUNT(*) OVER(PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD ) PT_CNT" ).append("\n"); 
		query.append("        FROM   PSO_BUD_TRF_PLN " ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("        AND    BUD_SCNR_NO = substr(@[rev_yrmon],0,4) || @[bud_str] -- 사업계획 /*01월 ~ 06월까지 */, ROLLING PLAN  /*07월 ~ 12월까지*/ " ).append("\n"); 
		query.append("        AND    SUBSTR(BUD_YRMON,5,2)  = substr(@[rev_yrmon],6,2)" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           GROUP BY BUD_YRMON, RLANE_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE PT_CHG_CNT<>0" ).append("\n"); 
		query.append("GROUP BY RLANE_CD" ).append("\n"); 
		query.append("ORDER BY RLANE_CD" ).append("\n"); 

	}
}