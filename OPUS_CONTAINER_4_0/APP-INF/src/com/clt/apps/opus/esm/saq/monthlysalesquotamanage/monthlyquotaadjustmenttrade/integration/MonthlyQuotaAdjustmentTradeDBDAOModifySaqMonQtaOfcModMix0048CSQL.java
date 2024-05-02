/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeDBDAOModifySaqMonQtaOfcModMix0048CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.26 이상용
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

public class MonthlyQuotaAdjustmentTradeDBDAOModifySaqMonQtaOfcModMix0048CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifySAQ_MON_STEP_VER_02
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeDBDAOModifySaqMonQtaOfcModMix0048CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("saq_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("currMqtaStepCd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentTradeDBDAOModifySaqMonQtaOfcModMix0048CSQL").append("\n"); 
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
		query.append("MERGE INTO SAQ_MON_QTA_OFC_MOD_MIX UPD" ).append("\n"); 
		query.append(" USING (" ).append("\n"); 
		query.append("   SELECT MIX.MQTA_STEP_CD" ).append("\n"); 
		query.append("     ,MIX.BSE_YR" ).append("\n"); 
		query.append("     ,MIX.BSE_QTR_CD" ).append("\n"); 
		query.append("     ,MIX.TRD_CD" ).append("\n"); 
		query.append("     ,MIX.DIR_CD" ).append("\n"); 
		query.append("     ,MIX.MQTA_VER_NO" ).append("\n"); 
		query.append("     ,MIX.RLANE_CD" ).append("\n"); 
		query.append("     ,MIX.SPRT_GRP_CD" ).append("\n"); 
		query.append("     ,MIX.BSA_GRP_CD" ).append("\n"); 
		query.append("     ,MIX.SUB_TRD_CD" ).append("\n"); 
		query.append("     ,MIX.CTRT_RHQ_CD" ).append("\n"); 
		query.append("     ,MIX.BSE_MON" ).append("\n"); 
		query.append("     ,MIX.SAQ_SVC_MOD_CD" ).append("\n"); 
		query.append("     ,MIX_D.MOD_MIX_RTO" ).append("\n"); 
		query.append("   FROM   SAQ_MON_QTA_OFC_MOD_MIX MIX" ).append("\n"); 
		query.append(" 	 ,SAQ_MON_QTA_OFC_MOD_MIX MIX_D" ).append("\n"); 
		query.append(" 	       ,SAQ_MON_QTA_STEP_VER VER" ).append("\n"); 
		query.append(" 	WHERE" ).append("\n"); 
		query.append(" 	      VER.MQTA_STEP_CD = @[mQtaStepCd]" ).append("\n"); 
		query.append(" 	  AND VER.BSE_YR = @[year]" ).append("\n"); 
		query.append(" 	  AND VER.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append(" 	  AND VER.TRD_CD = @[trade]" ).append("\n"); 
		query.append(" 	  AND VER.DIR_CD = @[bound]" ).append("\n"); 
		query.append(" 	    AND VER.SAQ_STS_CD = @[saq_sts_cd]" ).append("\n"); 
		query.append(" 	    AND GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 
		query.append(" 	    AND MIX.MQTA_STEP_CD = VER.MQTA_STEP_CD" ).append("\n"); 
		query.append(" 	    AND MIX.BSE_YR = VER.BSE_YR" ).append("\n"); 
		query.append(" 	    AND MIX.BSE_QTR_CD = VER.BSE_QTR_CD" ).append("\n"); 
		query.append(" 	    AND MIX.TRD_CD = VER.TRD_CD" ).append("\n"); 
		query.append(" 	    AND MIX.DIR_CD = VER.DIR_CD" ).append("\n"); 
		query.append(" 	    AND MIX.MQTA_VER_NO = VER.MQTA_VER_NO" ).append("\n"); 
		query.append(" 	    AND MIX_D.MQTA_STEP_CD = @[currMqtaStepCd]" ).append("\n"); 
		query.append(" 	    AND MIX.BSE_YR = MIX_D.BSE_YR" ).append("\n"); 
		query.append(" 	    AND MIX.BSE_QTR_CD = MIX_D.BSE_QTR_CD" ).append("\n"); 
		query.append(" 	    AND MIX.TRD_CD = MIX_D.TRD_CD" ).append("\n"); 
		query.append(" 	    AND MIX.DIR_CD = MIX_D.DIR_CD" ).append("\n"); 
		query.append(" 	    AND MIX_D.MQTA_VER_NO = @[version]" ).append("\n"); 
		query.append(" 	    AND MIX.RLANE_CD = MIX_D.RLANE_CD" ).append("\n"); 
		query.append(" 	    AND MIX.CTRT_RHQ_CD = MIX_D.CTRT_RHQ_CD" ).append("\n"); 
		query.append(" 	    AND MIX.BSE_MON = MIX_D.BSE_MON" ).append("\n"); 
		query.append(" 	    AND MIX.SAQ_SVC_MOD_CD = MIX_D.SAQ_SVC_MOD_CD" ).append("\n"); 
		query.append("       AND MIX.SPRT_GRP_CD = MIX_D.SPRT_GRP_CD" ).append("\n"); 
		query.append("       AND MIX.BSA_GRP_CD = MIX_D.BSA_GRP_CD" ).append("\n"); 
		query.append(" ) SEL" ).append("\n"); 
		query.append(" ON (" ).append("\n"); 
		query.append("       UPD.MQTA_STEP_CD = @[mQtaStepCd]" ).append("\n"); 
		query.append("       AND SEL.BSE_YR = UPD.BSE_YR" ).append("\n"); 
		query.append("       AND SEL.BSE_QTR_CD = UPD.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND SEL.TRD_CD = UPD.TRD_CD" ).append("\n"); 
		query.append("       AND SEL.DIR_CD = UPD.DIR_CD" ).append("\n"); 
		query.append("       AND SEL.MQTA_VER_NO = UPD.MQTA_VER_NO" ).append("\n"); 
		query.append("       AND SEL.RLANE_CD = UPD.RLANE_CD" ).append("\n"); 
		query.append("       AND SEL.SPRT_GRP_CD = UPD.SPRT_GRP_CD" ).append("\n"); 
		query.append("       AND SEL.BSA_GRP_CD = UPD.BSA_GRP_CD" ).append("\n"); 
		query.append("       AND SEL.CTRT_RHQ_CD = UPD.CTRT_RHQ_CD" ).append("\n"); 
		query.append("       AND SEL.SUB_TRD_CD = UPD.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND SEL.BSE_MON = UPD.BSE_MON" ).append("\n"); 
		query.append("       AND SEL.SAQ_SVC_MOD_CD = UPD.SAQ_SVC_MOD_CD" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN UPDATE SET" ).append("\n"); 
		query.append(" 	 UPD.MOD_MIX_RTO = SEL.MOD_MIX_RTO" ).append("\n"); 
		query.append(" 	 ,UPD.UPD_USR_ID = @[userId]" ).append("\n"); 
		query.append(" 	 ,UPD_DT = SYSDATE" ).append("\n"); 

	}
}