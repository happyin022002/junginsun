/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoA0156CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.23 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoA0156CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyQuotaAdjustmentSlsRhq 의 Save As New Version 을 처리한다.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoA0156CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("userId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaStepCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("newVersion",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inclPortFlag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoA0156CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_STEP_VER (" ).append("\n"); 
		query.append("    MQTA_STEP_CD," ).append("\n"); 
		query.append("    BSE_YR," ).append("\n"); 
		query.append("    BSE_QTR_CD," ).append("\n"); 
		query.append("    TRD_CD," ).append("\n"); 
		query.append("    DIR_CD," ).append("\n"); 
		query.append("    MQTA_VER_NO," ).append("\n"); 
		query.append("    SAQ_STS_CD," ).append("\n"); 
		query.append("    GLINE_VER_NO," ).append("\n"); 
		query.append("    INCL_PORT_FLG," ).append("\n"); 
		query.append("    CRE_OFC_CD," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    QTA_MST_VER_NO)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    SVR.MQTA_STEP_CD," ).append("\n"); 
		query.append("    SVR.BSE_YR," ).append("\n"); 
		query.append("    SVR.BSE_QTR_CD," ).append("\n"); 
		query.append("    SVR.TRD_CD," ).append("\n"); 
		query.append("    SVR.DIR_CD," ).append("\n"); 
		query.append("    @[newVersion] AS MQTA_VER_NO," ).append("\n"); 
		query.append("    '00' AS SAQ_STS_CD," ).append("\n"); 
		query.append("    SVR.GLINE_VER_NO," ).append("\n"); 
		query.append("    @[inclPortFlag] AS INCL_PORT_FLG," ).append("\n"); 
		query.append("    @[ofcCd] AS CRE_OFC_CD," ).append("\n"); 
		query.append("    @[userId] AS CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("    @[userId] AS UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT," ).append("\n"); 
		query.append("    SVR.QTA_MST_VER_NO" ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_STEP_VER SVR" ).append("\n"); 
		query.append("WHERE SVR.MQTA_STEP_CD = @[mQtaStepCd]" ).append("\n"); 
		query.append("AND   SVR.BSE_YR = @[year]" ).append("\n"); 
		query.append("AND   SVR.BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND   SVR.TRD_CD = @[trade]" ).append("\n"); 
		query.append("AND   SVR.DIR_CD = @[bound]" ).append("\n"); 
		query.append("AND   SVR.MQTA_VER_NO = @[mQtaVerNo]" ).append("\n"); 

	}
}