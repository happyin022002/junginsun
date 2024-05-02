/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchYearSubleasePlanRSQL.java
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

public class ScenarioDefaultManageDBDAOSearchYearSubleasePlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_sublease 테이블 데이터 조회
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchYearSubleasePlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plnyr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchYearSubleasePlanRSQL").append("\n"); 
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
		query.append("D.INTG_CD_VAL_CTNT S1_RCC_CD," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 01, CNTR_VOL_QTY)) S1_1_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 02, CNTR_VOL_QTY)) S1_2_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 03, CNTR_VOL_QTY)) S1_3_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 04, CNTR_VOL_QTY)) S1_4_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 05, CNTR_VOL_QTY)) S1_5_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 06, CNTR_VOL_QTY)) S1_6_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 07, CNTR_VOL_QTY)) S1_7_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 08, CNTR_VOL_QTY)) S1_8_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 09, CNTR_VOL_QTY)) S1_9_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 10, CNTR_VOL_QTY)) S1_10_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 11, CNTR_VOL_QTY)) S1_11_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 12, CNTR_VOL_QTY)) S1_12_CNTR_VOL_QTY," ).append("\n"); 
		query.append("@[plnyr] S1_PLNYR" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B.PLN_MON," ).append("\n"); 
		query.append("(SELECT RCC_CD FROM EQR_ECC_MST WHERE A.FM_ECC_CD = ECC_CD) RCC_CD," ).append("\n"); 
		query.append("SUM (A.CNTR_VOL_QTY) CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM EQR_SUBLEASE A, EQR_WK_PRD B" ).append("\n"); 
		query.append("WHERE A.PLN_YRWK = B.PLN_YR || B.PLN_WK" ).append("\n"); 
		query.append("AND SUBSTR(a.PLN_YRWK,1,4) = @[plnyr]" ).append("\n"); 
		query.append("GROUP BY A.FM_ECC_CD, B.PLN_MON" ).append("\n"); 
		query.append(") C, COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("WHERE C.RCC_CD(+)  = D.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND D.INTG_CD_ID = 'CD00255'" ).append("\n"); 
		query.append("GROUP BY D.INTG_CD_VAL_CTNT, INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}