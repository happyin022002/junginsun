/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeDBDAOCreateSaqMonQtaOfcModMix0048CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.27 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentTradeDBDAOCreateSaqMonQtaOfcModMix0048CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MON_QTA_OFC_MOD_MIX 특정 조건의 데이터를 Version을 바꿔 Copy한다.(추가)
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeDBDAOCreateSaqMonQtaOfcModMix0048CSQL(){
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
		params.put("ctrtOfcCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("newStepCd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentTradeDBDAOCreateSaqMonQtaOfcModMix0048CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_OFC_MOD_MIX(" ).append("\n"); 
		query.append("         MQTA_STEP_CD," ).append("\n"); 
		query.append("         MQTA_VER_NO," ).append("\n"); 
		query.append("         BSE_YR," ).append("\n"); 
		query.append("         BSE_QTR_CD," ).append("\n"); 
		query.append("         TRD_CD," ).append("\n"); 
		query.append("         DIR_CD," ).append("\n"); 
		query.append("         RLANE_CD," ).append("\n"); 
		query.append("         SPRT_GRP_CD," ).append("\n"); 
		query.append("         BSA_GRP_CD," ).append("\n"); 
		query.append("         CTRT_RHQ_CD," ).append("\n"); 
		query.append("         BSE_MON," ).append("\n"); 
		query.append("         SAQ_SVC_MOD_CD," ).append("\n"); 
		query.append("         MOD_MIX_RTO," ).append("\n"); 
		query.append("         SUB_TRD_CD," ).append("\n"); 
		query.append("         SVC_MOD_ADJ_AVAL_FLG," ).append("\n"); 
		query.append("         CRE_USR_ID," ).append("\n"); 
		query.append("         CRE_DT," ).append("\n"); 
		query.append("         UPD_USR_ID," ).append("\n"); 
		query.append("         UPD_DT" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    	 @[newStepCd]," ).append("\n"); 
		query.append("    	 @[newVersion]," ).append("\n"); 
		query.append("         BSE_YR," ).append("\n"); 
		query.append("         BSE_QTR_CD," ).append("\n"); 
		query.append("         TRD_CD," ).append("\n"); 
		query.append("         DIR_CD," ).append("\n"); 
		query.append("         RLANE_CD," ).append("\n"); 
		query.append("         SPRT_GRP_CD," ).append("\n"); 
		query.append("         BSA_GRP_CD," ).append("\n"); 
		query.append("         CTRT_RHQ_CD," ).append("\n"); 
		query.append("         BSE_MON," ).append("\n"); 
		query.append("         SAQ_SVC_MOD_CD," ).append("\n"); 
		query.append("         MOD_MIX_RTO," ).append("\n"); 
		query.append("         SUB_TRD_CD," ).append("\n"); 
		query.append("         SVC_MOD_ADJ_AVAL_FLG," ).append("\n"); 
		query.append("         @[userId]," ).append("\n"); 
		query.append("         SYSDATE," ).append("\n"); 
		query.append("         @[userId]," ).append("\n"); 
		query.append("         SYSDATE" ).append("\n"); 
		query.append("FROM   SAQ_MON_QTA_OFC_MOD_MIX" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    MQTA_STEP_CD = @[mQtaStepCd] AND" ).append("\n"); 
		query.append("    BSE_YR = @[year] AND" ).append("\n"); 
		query.append("    BSE_QTR_CD = @[bse_quarter] AND" ).append("\n"); 
		query.append("    TRD_CD = @[trade] AND" ).append("\n"); 
		query.append("    DIR_CD = @[bound] AND" ).append("\n"); 
		query.append("    MQTA_VER_NO = @[mQtaVerNo]  AND" ).append("\n"); 
		query.append("    CTRT_RHQ_CD = DECODE(@[ctrtOfcCd], NULL , CTRT_RHQ_CD, @[ctrtOfcCd])" ).append("\n"); 

	}
}