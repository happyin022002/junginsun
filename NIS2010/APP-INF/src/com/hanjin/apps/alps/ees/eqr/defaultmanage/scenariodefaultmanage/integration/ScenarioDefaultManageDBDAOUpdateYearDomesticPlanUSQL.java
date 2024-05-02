/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOUpdateYearDomesticPlanUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.27 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOUpdateYearDomesticPlanUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_dmst_pln 테이블 특정데이터 수정
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOUpdateYearDomesticPlanUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOUpdateYearDomesticPlanUSQL").append("\n"); 
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
		query.append("UPDATE EQR_DMST_PLN" ).append("\n"); 
		query.append("SET CNTR_VOL_QTY = CNTR_VOL_QTY + (SELECT (${rscount} -SUM(CNTR_VOL_QTY))QTY FROM EQR_DMST_PLN A WHERE A.PLN_YRWK = @[yrwk])" ).append("\n"); 
		query.append("WHERE PLN_YRWK = @[pln_yrwk]" ).append("\n"); 
		query.append("AND FM_ECC_CD = (SELECT FM_ECC_CD FROM EQR_DMST_PERF A WHERE DMST_RTO = (SELECT MAX(DMST_RTO)DMST_RTO FROM EQR_DMST_PERF))" ).append("\n"); 
		query.append("AND TO_ECC_CD = (SELECT TO_ECC_CD FROM EQR_DMST_PERF A WHERE DMST_RTO = (SELECT MAX(DMST_RTO)DMST_RTO FROM EQR_DMST_PERF))" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = (SELECT CNTR_TPSZ_CD FROM EQR_DMST_PERF A WHERE DMST_RTO = (SELECT MAX(DMST_RTO)DMST_RTO FROM EQR_DMST_PERF))" ).append("\n"); 

	}
}