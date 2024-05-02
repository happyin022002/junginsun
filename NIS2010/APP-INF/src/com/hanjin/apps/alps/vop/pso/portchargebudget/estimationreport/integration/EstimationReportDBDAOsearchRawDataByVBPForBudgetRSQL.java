/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EstimationReportDBDAOsearchRawDataByVBPForBudgetRSQL.java
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

public class EstimationReportDBDAOsearchRawDataByVBPForBudgetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * raw data : 추정결산 VBP별 집계
	  * </pre>
	  */
	public EstimationReportDBDAOsearchRawDataByVBPForBudgetRSQL(){
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
		query.append("FileName : EstimationReportDBDAOsearchRawDataByVBPForBudgetRSQL").append("\n"); 
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
		query.append("--사업계획 Row데이터 VVD(VBP용) " ).append("\n"); 
		query.append("SELECT RLANE_CD ," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       MAX(PORT_CHG_AMT) PORT_CHARGE," ).append("\n"); 
		query.append("       MAX(CNL_FEE_AMT) CANAL_FEE," ).append("\n"); 
		query.append("       (SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR WHERE VSL_CD = PLN.VSL_CD) CNTR_DZN_CAPA" ).append("\n"); 
		query.append("FROM   PSO_BUD_TRF_PLN PLN" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    BUD_SCNR_NO= substr(@[rev_yrmon],0,4) || @[bud_str]" ).append("\n"); 
		query.append("AND    SUBSTR(BUD_YRMON,1,4)= substr(@[rev_yrmon],0,4)" ).append("\n"); 
		query.append("AND    SUBSTR(BUD_YRMON,5,2)= substr(@[rev_yrmon],6,2)" ).append("\n"); 
		query.append("AND    SUB_TRD_CD <>'IP'" ).append("\n"); 
		query.append("AND    PORT_CHG_AMT+CNL_FEE_AMT<>0" ).append("\n"); 
		query.append("group by RLANE_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD" ).append("\n"); 
		query.append("ORDER BY RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 

	}
}