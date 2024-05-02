/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.23 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01RSQL(){
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
		params.put("targetMonth",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glineVerNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01RSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("     MQTA_STEP_CD ,                                                   " ).append("\n"); 
		query.append("     BSE_YR       ,                                                   " ).append("\n"); 
		query.append("     BSE_QTR_CD   ,                                                   " ).append("\n"); 
		query.append("     TRD_CD       ,                                                   " ).append("\n"); 
		query.append("     DIR_CD       ,                                                   " ).append("\n"); 
		query.append("     MQTA_VER_NO  ,                                                   " ).append("\n"); 
		query.append("     RLANE_CD || '-' || SPRT_GRP_CD || BSA_GRP_CD    AS RLANE_GRP,   " ).append("\n"); 
		query.append("     RLANE_CD     ,                                                   " ).append("\n"); 
		query.append("     SPRT_GRP_CD  ,                                                   " ).append("\n"); 
		query.append("     BSA_GRP_CD   ,                                                   " ).append("\n"); 
		query.append("     CTRT_RGN_OFC_CD  ,   " ).append("\n"); 
		query.append("     '00000' AS POL_CD , " ).append("\n"); 
		query.append("     '00000' AS POD_CD , " ).append("\n"); 
		query.append("     BSE_MON      ,                                                   " ).append("\n"); 
		query.append("     CRE_SEQ      ,                                                   " ).append("\n"); 
		query.append("     SUBJ_CTNT    ,                                                   " ).append("\n"); 
		query.append("     CRE_OFC_CD   ,                                                   " ).append("\n"); 
		query.append("     CMT_CTNT     ,                                                   " ).append("\n"); 
		query.append("     SAQ_STS_CD,    " ).append("\n"); 
		query.append("     RMK_CRE_GDT    , " ).append("\n"); 
		query.append("     RNK " ).append("\n"); 
		query.append(" FROM ( " ).append("\n"); 
		query.append("     SELECT  " ).append("\n"); 
		query.append("         MQTA_STEP_CD ,                                                   " ).append("\n"); 
		query.append("         BSE_YR       ,                                                   " ).append("\n"); 
		query.append("         BSE_QTR_CD   ,                                                   " ).append("\n"); 
		query.append("         TRD_CD       ,                                                   " ).append("\n"); 
		query.append("         DIR_CD       ,                                                   " ).append("\n"); 
		query.append("         MQTA_VER_NO  ,                                                   " ).append("\n"); 
		query.append("         RLANE_CD     ,                                                   " ).append("\n"); 
		query.append("         SPRT_GRP_CD  ,                                                   " ).append("\n"); 
		query.append("         BSA_GRP_CD   ,                                                   " ).append("\n"); 
		query.append("         CTRT_RGN_OFC_CD  ,   " ).append("\n"); 
		query.append("         BSE_MON      ,                                                   " ).append("\n"); 
		query.append("         CRE_SEQ      ,                                                   " ).append("\n"); 
		query.append("         SUBJ_CTNT    ,                                                   " ).append("\n"); 
		query.append("         CRE_OFC_CD   ,                                                   " ).append("\n"); 
		query.append("         CMT_CTNT     ,                                                   " ).append("\n"); 
		query.append("         SAQ_STS_CD,    " ).append("\n"); 
		query.append("         RMK_CRE_GDT    , " ).append("\n"); 
		query.append("         RANK()  OVER ( PARTITION BY RLANE_CD,SPRT_GRP_CD,BSA_GRP_CD,CTRT_RGN_OFC_CD ORDER BY RMK_CRE_GDT DESC) RNK " ).append("\n"); 
		query.append("      FROM ( " ).append("\n"); 
		query.append("         SELECT                                                               " ).append("\n"); 
		query.append("             MQTA_STEP_CD ,                                                   " ).append("\n"); 
		query.append("             BSE_YR       ,                                                   " ).append("\n"); 
		query.append("             BSE_QTR_CD   ,                                                   " ).append("\n"); 
		query.append("             TRD_CD       ,                                                   " ).append("\n"); 
		query.append("             DIR_CD       ,                                                   " ).append("\n"); 
		query.append("             MQTA_VER_NO  ,                                                   " ).append("\n"); 
		query.append("             RLANE_CD     ,                                                   " ).append("\n"); 
		query.append("             SPRT_GRP_CD  ,                                                   " ).append("\n"); 
		query.append("             BSA_GRP_CD   ,                                                   " ).append("\n"); 
		query.append("             CTRT_RGN_OFC_CD  ,   " ).append("\n"); 
		query.append("             BSE_MON      ,                                                   " ).append("\n"); 
		query.append("             CRE_SEQ      ,                                                   " ).append("\n"); 
		query.append("             SUBJ_CTNT    ,                                                   " ).append("\n"); 
		query.append("             CRE_OFC_CD   ,                                                   " ).append("\n"); 
		query.append("             CMT_CTNT     ,                                                   " ).append("\n"); 
		query.append("             TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', RMK_CRE_GDT, @[ofc_cd] ), 'yyyy.mm.dd hh24:mi:ss') AS RMK_CRE_GDT,  " ).append("\n"); 
		query.append("             SAQ_STS_CD                                                       " ).append("\n"); 
		query.append("         FROM   SAQ_MON_QTA_RHQ_RMK                                           " ).append("\n"); 
		query.append("         WHERE MQTA_STEP_CD  = @[mQtaStepCd]                                              " ).append("\n"); 
		query.append("         AND   BSE_YR        = @[year]                                              " ).append("\n"); 
		query.append("         AND   BSE_QTR_CD       = @[bse_quarter]                                             " ).append("\n"); 
		query.append("         AND   TRD_CD        = @[trade]                                              " ).append("\n"); 
		query.append("         AND   DIR_CD        = @[bound]                                              " ).append("\n"); 
		query.append("         AND   MQTA_VER_NO   = @[mQtaVerNo]                                          " ).append("\n"); 
		query.append("         AND   BSE_YR || BSE_MON       = @[targetMonth]                                              " ).append("\n"); 
		query.append("         UNION ALL                                                            " ).append("\n"); 
		query.append("         SELECT                                                               " ).append("\n"); 
		query.append("             RMK.MQTA_STEP_CD ,                                               " ).append("\n"); 
		query.append("             RMK.BSE_YR       ,                                               " ).append("\n"); 
		query.append("             RMK.BSE_QTR_CD   ,                                               " ).append("\n"); 
		query.append("             RMK.TRD_CD       ,                                               " ).append("\n"); 
		query.append("             RMK.DIR_CD       ,                                               " ).append("\n"); 
		query.append("             RMK.MQTA_VER_NO  ,                                               " ).append("\n"); 
		query.append("             RMK.RLANE_CD     ,                                               " ).append("\n"); 
		query.append("             RMK.SPRT_GRP_CD  ,                                               " ).append("\n"); 
		query.append("             RMK.BSA_GRP_CD   ,                                               " ).append("\n"); 
		query.append("             RMK.CTRT_RGN_OFC_CD  ,   " ).append("\n"); 
		query.append("             RMK.BSE_MON      ,                                               " ).append("\n"); 
		query.append("             RMK.CRE_SEQ      ,                                               " ).append("\n"); 
		query.append("             RMK.SUBJ_CTNT    ,                                               " ).append("\n"); 
		query.append("             RMK.CRE_OFC_CD   ,                                               " ).append("\n"); 
		query.append("             RMK.CMT_CTNT     ,                                               " ).append("\n"); 
		query.append("             TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', RMK_CRE_GDT, @[ofc_cd] ), 'yyyy.mm.dd hh24:mi:ss') AS RMK_CRE_GDT, " ).append("\n"); 
		query.append("             RMK.SAQ_STS_CD                                                   " ).append("\n"); 
		query.append("         FROM  SAQ_MON_QTA_STEP_VER VER,                                      " ).append("\n"); 
		query.append("               SAQ_MON_QTA_RHQ_RMK RMK                                        " ).append("\n"); 
		query.append("         WHERE VER.MQTA_STEP_CD  <> @[mQtaStepCd]                                         " ).append("\n"); 
		query.append("         AND   VER.BSE_YR        = @[year]                                          " ).append("\n"); 
		query.append("         AND   VER.BSE_QTR_CD       = @[bse_quarter]                                          " ).append("\n"); 
		query.append("         AND   VER.TRD_CD        = @[trade]                                          " ).append("\n"); 
		query.append("         AND   VER.DIR_CD        = @[bound]                                          " ).append("\n"); 
		query.append("         AND   VER.GLINE_VER_NO  = @[glineVerNo]                                          " ).append("\n"); 
		query.append("         AND   VER.SAQ_STS_CD IN                                              " ).append("\n"); 
		query.append("                         (SELECT A.INTG_CD_VAL_CTNT                           " ).append("\n"); 
		query.append("                          FROM   COM_INTG_CD_DTL A,                           " ).append("\n"); 
		query.append("                                 COM_INTG_CD_DTL B                            " ).append("\n"); 
		query.append("                          WHERE A.INTG_CD_ID = 'CD00926'                      " ).append("\n"); 
		query.append("                          AND   B.INTG_CD_ID = A.INTG_CD_ID                   " ).append("\n"); 
		query.append("                          AND   B.INTG_CD_VAL_CTNT = 'DN'                     " ).append("\n"); 
		query.append("                          AND   A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ) " ).append("\n"); 
		query.append("         AND   RMK.MQTA_STEP_CD  = VER.MQTA_STEP_CD                           " ).append("\n"); 
		query.append("         AND   RMK.BSE_YR        = VER.BSE_YR                                 " ).append("\n"); 
		query.append("         AND   RMK.BSE_QTR_CD       = VER.BSE_QTR_CD                                " ).append("\n"); 
		query.append("         AND   RMK.TRD_CD        = VER.TRD_CD                                 " ).append("\n"); 
		query.append("         AND   RMK.DIR_CD        = VER.DIR_CD                                 " ).append("\n"); 
		query.append("         AND   RMK.MQTA_VER_NO   = VER.MQTA_VER_NO                            " ).append("\n"); 
		query.append("         AND   RMK.BSE_YR || RMK.BSE_MON       = @[targetMonth]                                          " ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append(" )  " ).append("\n"); 
		query.append(" WHERE RNK = 1" ).append("\n"); 

	}
}