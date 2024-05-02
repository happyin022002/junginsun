/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeDBDAOUpdateMonthlyAdjustmentTradeAll0048USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentTradeDBDAOUpdateMonthlyAdjustmentTradeAll0048USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 01 step Load, RPB copy to 03 Step.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeDBDAOUpdateMonthlyAdjustmentTradeAll0048USQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mQtaVerNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentTradeDBDAOUpdateMonthlyAdjustmentTradeAll0048USQL").append("\n"); 
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
		query.append("UPDATE  SAQ_MON_QTA_TRD DES" ).append("\n"); 
		query.append("   SET  (LOD_QTY, GRS_RPB_REV, UPD_USR_ID, UPD_DT) = (SELECT  LOD_QTY, GRS_RPB_REV, @[upd_usr_id], SYSDATE" ).append("\n"); 
		query.append("                                                        FROM  SAQ_MON_QTA_TRD ORI" ).append("\n"); 
		query.append("                                                             ,SAQ_MON_QTA_STEP_VER VER" ).append("\n"); 
		query.append("                                                       WHERE  1 = 1" ).append("\n"); 
		query.append("                                                         AND  ORI.MQTA_STEP_CD = VER.MQTA_STEP_CD" ).append("\n"); 
		query.append("                                                         AND  ORI.BSE_YR       = VER.BSE_YR" ).append("\n"); 
		query.append("                                                         AND  ORI.BSE_QTR_CD   = VER.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                         AND  ORI.TRD_CD       = VER.TRD_CD" ).append("\n"); 
		query.append("                                                         AND  ORI.DIR_CD       = VER.DIR_CD" ).append("\n"); 
		query.append("                                                         AND  ORI.MQTA_VER_NO  = VER.MQTA_VER_NO" ).append("\n"); 
		query.append("                                                         AND  VER.MQTA_STEP_CD = '01'" ).append("\n"); 
		query.append("                                                         AND  VER.SAQ_STS_CD   = 'DR'" ).append("\n"); 
		query.append("                                                         AND  ORI.BSE_YR       = DES.BSE_YR" ).append("\n"); 
		query.append("                                                         AND  ORI.BSE_QTR_CD   = DES.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                         AND  ORI.TRD_CD       = DES.TRD_CD" ).append("\n"); 
		query.append("                                                         AND  ORI.DIR_CD       = DES.DIR_CD" ).append("\n"); 
		query.append("                                                         AND  ORI.RLANE_CD     = DES.RLANE_CD" ).append("\n"); 
		query.append("                                                         AND  ORI.SPRT_GRP_CD  = DES.SPRT_GRP_CD" ).append("\n"); 
		query.append("                                                         AND  ORI.BSA_GRP_CD   = DES.BSA_GRP_CD" ).append("\n"); 
		query.append("                                                         AND  ORI.CTRT_RHQ_CD  = DES.CTRT_RHQ_CD" ).append("\n"); 
		query.append("                                                         AND  ORI.BSE_MON      = DES.BSE_MON" ).append("\n"); 
		query.append("                                                         AND  ORI.SUB_TRD_CD   = DES.SUB_TRD_CD" ).append("\n"); 
		query.append("                                                     )" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  DES.MQTA_STEP_CD = @[mQtaStepCd]" ).append("\n"); 
		query.append("   AND  DES.BSE_YR       = @[year]" ).append("\n"); 
		query.append("   AND  DES.BSE_QTR_CD   = @[bse_quarter]" ).append("\n"); 
		query.append("   AND  DES.TRD_CD       = @[trade]" ).append("\n"); 
		query.append("   AND  DES.DIR_CD       = @[bound]" ).append("\n"); 
		query.append("   AND  DES.MQTA_VER_NO  = @[mQtaVerNo]" ).append("\n"); 
		query.append("   AND  EXISTS (SELECT  1" ).append("\n"); 
		query.append("                  FROM  SAQ_MON_QTA_TRD ORI" ).append("\n"); 
		query.append("                       ,SAQ_MON_QTA_STEP_VER VER" ).append("\n"); 
		query.append("                 WHERE  1 = 1" ).append("\n"); 
		query.append("                   AND  ORI.MQTA_STEP_CD = VER.MQTA_STEP_CD" ).append("\n"); 
		query.append("                   AND  ORI.BSE_YR       = VER.BSE_YR" ).append("\n"); 
		query.append("                   AND  ORI.BSE_QTR_CD   = VER.BSE_QTR_CD" ).append("\n"); 
		query.append("                   AND  ORI.TRD_CD       = VER.TRD_CD" ).append("\n"); 
		query.append("                   AND  ORI.DIR_CD       = VER.DIR_CD" ).append("\n"); 
		query.append("                   AND  ORI.MQTA_VER_NO  = VER.MQTA_VER_NO" ).append("\n"); 
		query.append("                   AND  VER.MQTA_STEP_CD = '01'" ).append("\n"); 
		query.append("                   AND  VER.SAQ_STS_CD   = 'DR'" ).append("\n"); 
		query.append("                   AND  ORI.BSE_YR       = DES.BSE_YR" ).append("\n"); 
		query.append("                   AND  ORI.BSE_QTR_CD   = DES.BSE_QTR_CD" ).append("\n"); 
		query.append("                   AND  ORI.TRD_CD       = DES.TRD_CD" ).append("\n"); 
		query.append("                   AND  ORI.DIR_CD       = DES.DIR_CD" ).append("\n"); 
		query.append("                   AND  ORI.RLANE_CD     = DES.RLANE_CD" ).append("\n"); 
		query.append("                   AND  ORI.SPRT_GRP_CD  = DES.SPRT_GRP_CD" ).append("\n"); 
		query.append("                   AND  ORI.BSA_GRP_CD   = DES.BSA_GRP_CD" ).append("\n"); 
		query.append("                   AND  ORI.CTRT_RHQ_CD  = DES.CTRT_RHQ_CD" ).append("\n"); 
		query.append("                   AND  ORI.BSE_MON      = DES.BSE_MON" ).append("\n"); 
		query.append("                   AND  ORI.SUB_TRD_CD   = DES.SUB_TRD_CD" ).append("\n"); 
		query.append("               )" ).append("\n"); 

	}
}