/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOUpdateYearSubleasePlanUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOUpdateYearSubleasePlanUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_sublease  테이블 데이터 수정
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOUpdateYearSubleasePlanUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsCount",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrWk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rccCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOUpdateYearSubleasePlanUSQL").append("\n"); 
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
		query.append("UPDATE EQR_SUBLEASE" ).append("\n"); 
		query.append("SET CNTR_VOL_QTY = CNTR_VOL_QTY + (" ).append("\n"); 
		query.append("SELECT (@[rsCount]-SUM(CNTR_VOL_QTY))QTY" ).append("\n"); 
		query.append("FROM EQR_SUBLEASE A" ).append("\n"); 
		query.append("WHERE A.PLN_YRWK = @[yrWk]" ).append("\n"); 
		query.append("AND FM_ECC_CD IN (SELECT ECC_CD FROM EQR_ECC_MST WHERE RCC_CD = @[rccCd] )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE PLN_YRWK = @[yrWk]" ).append("\n"); 
		query.append("AND FM_ECC_CD = (" ).append("\n"); 
		query.append("SELECT FM_ECC_CD" ).append("\n"); 
		query.append("FROM EQR_SLSE_PERF A" ).append("\n"); 
		query.append("WHERE SLSE_RTO = (" ).append("\n"); 
		query.append("SELECT MAX(SLSE_RTO)SLSE_RTO" ).append("\n"); 
		query.append("FROM EQR_SLSE_PERF" ).append("\n"); 
		query.append("WHERE FM_ECC_CD IN (SELECT ECC_CD FROM EQR_ECC_MST WHERE RCC_CD = @[rccCd] )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TO_ECC_CD = (" ).append("\n"); 
		query.append("SELECT TO_ECC_CD" ).append("\n"); 
		query.append("FROM EQR_SLSE_PERF A" ).append("\n"); 
		query.append("WHERE SLSE_RTO = (" ).append("\n"); 
		query.append("SELECT MAX(SLSE_RTO)SLSE_RTO" ).append("\n"); 
		query.append("FROM EQR_SLSE_PERF" ).append("\n"); 
		query.append("WHERE FM_ECC_CD IN (SELECT ECC_CD FROM EQR_ECC_MST WHERE RCC_CD = @[rccCd] )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = (" ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM EQR_SLSE_PERF A" ).append("\n"); 
		query.append("WHERE SLSE_RTO = (" ).append("\n"); 
		query.append("SELECT MAX(SLSE_RTO)SLSE_RTO" ).append("\n"); 
		query.append("FROM EQR_SLSE_PERF" ).append("\n"); 
		query.append("WHERE FM_ECC_CD IN (SELECT ECC_CD FROM EQR_ECC_MST WHERE RCC_CD = @[rccCd] )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND FM_ECC_CD IN (SELECT ECC_CD FROM EQR_ECC_MST WHERE RCC_CD = @[rccCd] )" ).append("\n"); 

	}
}