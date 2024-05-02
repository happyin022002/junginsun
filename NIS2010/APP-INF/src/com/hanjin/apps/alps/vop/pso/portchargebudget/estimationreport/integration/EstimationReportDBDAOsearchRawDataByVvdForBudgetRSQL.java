/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EstimationReportDBDAOsearchRawDataByVvdForBudgetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationReportDBDAOsearchRawDataByVvdForBudgetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Raw data : 추정결산 VVD별 집계
	  * </pre>
	  */
	public EstimationReportDBDAOsearchRawDataByVvdForBudgetRSQL(){
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
		query.append("FileName : EstimationReportDBDAOsearchRawDataByVvdForBudgetRSQL").append("\n"); 
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
		query.append("--PSO 사업계획에서 조회한 VVD별 집계" ).append("\n"); 
		query.append("SELECT RLANE_CD," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       SUM(DECODE(ACCT_CD, 511911, 0, INV_USD_AMT)) PORT_CHARGE," ).append("\n"); 
		query.append("       SUM(DECODE(ACCT_CD, 511911, INV_USD_AMT, 0)) CANAL_FEE," ).append("\n"); 
		query.append("       (SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR WHERE VSL_CD = T1.VSL_CD) CNTR_DZN_CAPA" ).append("\n"); 
		query.append("FROM   PSO_TGT_YD_EXPN T1, TES_LGS_COST T2" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    REV_YRMON= REPLACE(@[rev_yrmon],'-','')" ).append("\n"); 
		query.append("AND    T1.PSO_BZTP_CD='1'" ).append("\n"); 
		query.append("AND    T1.BUD_SCNR_NO= substr(@[rev_yrmon],0,4) || @[bud_str]" ).append("\n"); 
		query.append("AND    T1.LGS_COST_CD=T2.LGS_COST_CD" ).append("\n"); 
		query.append("GROUP BY RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("ORDER BY RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 

	}
}