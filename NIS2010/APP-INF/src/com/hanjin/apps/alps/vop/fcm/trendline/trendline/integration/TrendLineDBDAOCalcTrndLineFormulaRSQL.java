/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrendLineDBDAOCalcTrndLineFormulaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.04 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.trendline.trendline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrendLineDBDAOCalcTrndLineFormulaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trend Line 수식을 이용하여 결과값을 구한다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * </pre>
	  */
	public TrendLineDBDAOCalcTrndLineFormulaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.trendline.trendline.integration").append("\n"); 
		query.append("FileName : TrendLineDBDAOCalcTrndLineFormulaRSQL").append("\n"); 
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
		query.append("/* CalcTrndLineFormulaVO" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' TRND_LINE_SEQ," ).append("\n"); 
		query.append("'' TRND_LINE_USE_TP_CD," ).append("\n"); 
		query.append("'' TRND_LINE_TP_CD," ).append("\n"); 
		query.append("'' TRND_LINE_CHT_TP_CD," ).append("\n"); 
		query.append("'' VSL_CLSS_CD," ).append("\n"); 
		query.append("'' VSL_CLSS_SUB_CD," ).append("\n"); 
		query.append("'' VSL_SLAN_CD," ).append("\n"); 
		query.append("'' VSL_CD," ).append("\n"); 
		query.append("'' SKD_DIR_CD," ).append("\n"); 
		query.append("'' TRND_LINE_TP_SUB_CD," ).append("\n"); 
		query.append("'' N1ST_COEF_VAL," ).append("\n"); 
		query.append("'' N1ST_VAR_DGR_VAL," ).append("\n"); 
		query.append("'' N2ND_COEF_VAL," ).append("\n"); 
		query.append("'' N2ND_VAR_DGR_VAL," ).append("\n"); 
		query.append("'' TRND_LINE_CONS_VAL," ).append("\n"); 
		query.append("'' COEF_OF_DTMN_VAL," ).append("\n"); 
		query.append("'' IN_VAL," ).append("\n"); 
		query.append("'' OUT_VAL" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TRND_LINE_SEQ," ).append("\n"); 
		query.append("TRND_LINE_USE_TP_CD," ).append("\n"); 
		query.append("TRND_LINE_TP_CD," ).append("\n"); 
		query.append("TRND_LINE_CHT_TP_CD," ).append("\n"); 
		query.append("VSL_CLSS_CD," ).append("\n"); 
		query.append("VSL_CLSS_SUB_CD," ).append("\n"); 
		query.append("VSL_SLAN_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("TRND_LINE_TP_SUB_CD," ).append("\n"); 
		query.append("N1ST_COEF_VAL," ).append("\n"); 
		query.append("N1ST_VAR_DGR_VAL," ).append("\n"); 
		query.append("N2ND_COEF_VAL," ).append("\n"); 
		query.append("N2ND_VAR_DGR_VAL," ).append("\n"); 
		query.append("TRND_LINE_CONS_VAL," ).append("\n"); 
		query.append("COEF_OF_DTMN_VAL," ).append("\n"); 
		query.append("@[in_val] IN_VAL," ).append("\n"); 
		query.append("POWER(TO_NUMBER(@[in_val]), N1ST_VAR_DGR_VAL)*N1ST_COEF_VAL + POWER(TO_NUMBER(@[in_val]), N2ND_VAR_DGR_VAL)*N2ND_COEF_VAL + TRND_LINE_CONS_VAL OUT_VAL" ).append("\n"); 
		query.append("FROM FCM_TRND_LINE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TRND_LINE_SEQ=@[trnd_line_seq]" ).append("\n"); 

	}
}