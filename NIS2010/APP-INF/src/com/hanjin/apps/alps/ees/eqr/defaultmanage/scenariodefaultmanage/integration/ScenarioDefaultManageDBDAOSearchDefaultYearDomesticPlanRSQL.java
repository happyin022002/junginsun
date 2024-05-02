/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchDefaultYearDomesticPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.02.19 채창호
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

public class ScenarioDefaultManageDBDAOSearchDefaultYearDomesticPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Domestic 조회
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchDefaultYearDomesticPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchDefaultYearDomesticPlanRSQL").append("\n"); 
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
		query.append("SELECT MAX (DECODE (PLN_MON, 01, CNTR_VOL_QTY)) S1_1_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 02, CNTR_VOL_QTY)) S1_2_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 03, CNTR_VOL_QTY)) S1_3_CNTR_VOL_QTY," ).append("\n"); 
		query.append("'' QTY1," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 04, CNTR_VOL_QTY)) S1_4_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 05, CNTR_VOL_QTY)) S1_5_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 06, CNTR_VOL_QTY)) S1_6_CNTR_VOL_QTY," ).append("\n"); 
		query.append("'' QTY2," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 07, CNTR_VOL_QTY)) S1_7_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 08, CNTR_VOL_QTY)) S1_8_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 09, CNTR_VOL_QTY)) S1_9_CNTR_VOL_QTY," ).append("\n"); 
		query.append("'' QTY3," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 10, CNTR_VOL_QTY)) S1_10_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 11, CNTR_VOL_QTY)) S1_11_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 12, CNTR_VOL_QTY)) S1_12_CNTR_VOL_QTY," ).append("\n"); 
		query.append("'1' FLAG" ).append("\n"); 
		query.append("FROM (SELECT B.PLN_MON," ).append("\n"); 
		query.append("SUM (A.CNTR_VOL_QTY) CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM EQR_DMST_PLN A, EQR_WK_PRD B" ).append("\n"); 
		query.append("WHERE A.PLN_YRWK = B.PLN_YR || B.PLN_WK" ).append("\n"); 
		query.append("AND SUBSTR(A.PLN_YRWK,1,4) = @[pln_yr]" ).append("\n"); 
		query.append("GROUP BY B.PLN_MON" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}