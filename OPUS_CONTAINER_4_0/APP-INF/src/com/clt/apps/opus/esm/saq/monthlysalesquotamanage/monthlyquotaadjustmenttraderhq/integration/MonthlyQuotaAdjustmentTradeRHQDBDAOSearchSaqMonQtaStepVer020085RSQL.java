/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeRHQDBDAOSearchSaqMonQtaStepVer020085RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.26 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentTradeRHQDBDAOSearchSaqMonQtaStepVer020085RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSAQ_MON_QTA_STEP_VER_02 데이타 모델에 해당되는 값을 불러온다.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeRHQDBDAOSearchSaqMonQtaStepVer020085RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_quarter",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mQtaStepCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glineVerNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentTradeRHQDBDAOSearchSaqMonQtaStepVer020085RSQL").append("\n"); 
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
		query.append("   	MQTA_STEP_CD,BSE_YR,BSE_QTR_CD,TRD_CD,DIR_CD,MQTA_VER_NO" ).append("\n"); 
		query.append("   	,SAQ_STS_CD,GLINE_VER_NO" ).append("\n"); 
		query.append(" FROM  	SAQ_MON_QTA_STEP_VER" ).append("\n"); 
		query.append(" WHERE  	MQTA_STEP_CD = @[mQtaStepCd]" ).append("\n"); 
		query.append(" 	  AND BSE_YR = @[year]" ).append("\n"); 
		query.append(" 	  AND BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append(" 	  AND TRD_CD = @[trade]" ).append("\n"); 
		query.append(" 	  AND DIR_CD = @[bound]" ).append("\n"); 
		query.append("#if (${loginOfcCd} != '') " ).append("\n"); 
		query.append("	AND CRE_OFC_CD  = ${loginOfcCd}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND SAQ_STS_CD IN ('DN')" ).append("\n"); 
		query.append("    AND GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 

	}
}