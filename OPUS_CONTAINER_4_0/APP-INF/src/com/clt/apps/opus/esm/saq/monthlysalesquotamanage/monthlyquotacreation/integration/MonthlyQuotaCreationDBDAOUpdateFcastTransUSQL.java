/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOUpdateFcastTransUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOUpdateFcastTransUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline L/f, CM 수정분을 Fcast_Trans 테이블에 반영한다.
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOUpdateFcastTransUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_mdl_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOUpdateFcastTransUSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("1) ADJUSTED 수송량 : supply * guideline L/F" ).append("\n"); 
		query.append("2) 점소별 수송량 : 수송량 계획 물량 * 점소별 점유율" ).append("\n"); 
		query.append("3) Initial CM 생성 : BASE 수송량 * 기존 RPB - 조정된 CPB" ).append("\n"); 
		query.append("3-1) INITIAL CMPB = INITIAL CM / BASE 수송량" ).append("\n"); 
		query.append("4) Guideline CM총액을 기존 Initial CM 총액 비율로 나누어 점소별 CM guideline 생성" ).append("\n"); 
		query.append("5) Rev Gap 계산 : Guideline CM - (Initial CMPB * ADJUSTED 수송량)" ).append("\n"); 
		query.append("6) RPB Factor 계산 : Rev Gap / 점소별 신규 수송량" ).append("\n"); 
		query.append("7) New RPB 생성 : 기존 RPB + RPB Factor" ).append("\n"); 
		query.append("8) New GM = 새로운 수송량 * 새로운 RPB - CPB 하게되면 총액이 cm guideline과 일치" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("MERGE INTO SAQ_MON_FCAST_TRNS A " ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("    (SELECT MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("         , BSE_MON " ).append("\n"); 
		query.append("         , TRD_CD " ).append("\n"); 
		query.append("         , SUB_TRD_CD " ).append("\n"); 
		query.append("         , RLANE_CD " ).append("\n"); 
		query.append("         , DIR_CD " ).append("\n"); 
		query.append("         , CTRT_OFC_CD " ).append("\n"); 
		query.append("         , SLS_OFC_CD " ).append("\n"); 
		query.append("         , CM_UC_AMT " ).append("\n"); 
		query.append("         , ROUND(NEW_LOD_QTY * TEU_RATIO) AS LOD_QTY /* 수송량 계획 물량 * 점소별 점유율 : 점소별 수송량 */ " ).append("\n"); 
		query.append("         , ORG_GRS_RPB_REV " ).append("\n"); 
		query.append("         , CASE WHEN NEW_LOD_QTY * TEU_RATIO > 0 " ).append("\n"); 
		query.append("                  THEN ROUND(ORG_GRS_RPB_REV + ( ((GLINE_CM_AMT * CM_RATIO) - (INIT_CM*NEW_LOD_QTY/OLD_LOD_QTY)) / (NEW_LOD_QTY * TEU_RATIO) ) ) " ).append("\n"); 
		query.append("                  ELSE ORG_GRS_RPB_REV END GRS_RPB_REV /* 기존 RPB + ( (Guideline CM - (Initial CMPB*ADJUSTED 수송량)) / 점소별 신규 수송량) : New RPB */ " ).append("\n"); 
		query.append("         , SLS_FCAST_NO " ).append("\n"); 
		query.append("         , OLD_LOD_QTY " ).append("\n"); 
		query.append("      FROM " ).append("\n"); 
		query.append("           (SELECT MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                , BSE_MON " ).append("\n"); 
		query.append("                , TRD_CD " ).append("\n"); 
		query.append("                , SUB_TRD_CD " ).append("\n"); 
		query.append("                , RLANE_CD " ).append("\n"); 
		query.append("                , DIR_CD " ).append("\n"); 
		query.append("                , CTRT_OFC_CD " ).append("\n"); 
		query.append("                , SLS_OFC_CD " ).append("\n"); 
		query.append("                , MAX(SPL_AMT) * MAX(LDF_RTO) / 100 AS NEW_LOD_QTY /* SUPPLY * L/F : 수송량 계획 */ " ).append("\n"); 
		query.append("                , MAX(OLD_LOD_QTY) AS OLD_LOD_QTY /* Base 수송량 */ " ).append("\n"); 
		query.append("                , RATIO_TO_REPORT(SUM(LOD_QTY)) OVER (PARTITION BY BSE_MON, TRD_CD, SUB_TRD_CD, DIR_CD ) AS TEU_RATIO " ).append("\n"); 
		query.append("                , RATIO_TO_REPORT(SUM((ORG_GRS_RPB_REV - CM_UC_AMT) * LOD_QTY)) OVER (PARTITION BY BSE_MON, TRD_CD, SUB_TRD_CD, DIR_CD ) AS CM_RATIO " ).append("\n"); 
		query.append("                , SUM((ORG_GRS_RPB_REV - CM_UC_AMT) * LOD_QTY) AS INIT_CM /* Initial CM = (Base RPB - Adjust CPB) * Base 수송량 */ " ).append("\n"); 
		query.append("                , MAX(GLINE_CM_AMT) AS GLINE_CM_AMT " ).append("\n"); 
		query.append("                , MAX(ORG_GRS_RPB_REV) AS ORG_GRS_RPB_REV " ).append("\n"); 
		query.append("                , MAX(CM_UC_AMT) AS CM_UC_AMT " ).append("\n"); 
		query.append("                , SLS_FCAST_NO " ).append("\n"); 
		query.append("             FROM " ).append("\n"); 
		query.append("                  (SELECT T2.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                       , T1.BSE_MON " ).append("\n"); 
		query.append("                       , T1.TRD_CD " ).append("\n"); 
		query.append("                       , T1.SUB_TRD_CD " ).append("\n"); 
		query.append("                       , T1.RLANE_CD " ).append("\n"); 
		query.append("                       , T1.DIR_CD " ).append("\n"); 
		query.append("                       , T2.CTRT_OFC_CD " ).append("\n"); 
		query.append("                       , T2.SLS_OFC_CD " ).append("\n"); 
		query.append("                       , T2.LOD_QTY " ).append("\n"); 
		query.append("                       , T2.GRS_RPB_REV AS ORG_GRS_RPB_REV" ).append("\n"); 
		query.append("                       , T3.SPL_AMT " ).append("\n"); 
		query.append("                       , T3.LDF_RTO " ).append("\n"); 
		query.append("                       , T2.CM_UC_AMT " ).append("\n"); 
		query.append("                       , T3.GLINE_CM_AMT " ).append("\n"); 
		query.append("                       , SUM(T2.LOD_QTY) OVER (PARTITION BY T1.BSE_MON, T1.TRD_CD, T1.SUB_TRD_CD, T1.DIR_CD ) AS OLD_LOD_QTY " ).append("\n"); 
		query.append("                       , T2.SLS_FCAST_NO " ).append("\n"); 
		query.append("                    FROM SAQ_MON_TGT_VVD T1 " ).append("\n"); 
		query.append("                       , SAQ_MON_FCAST_TRNS T2 " ).append("\n"); 
		query.append("                       , SAQ_MON_INIT_GLINE T3 " ).append("\n"); 
		query.append("                   WHERE 1=1 " ).append("\n"); 
		query.append("                         AND T1.BSE_YR = SUBSTR(TO_CHAR(T2.ST_DT, 'YYYYMMDD'), 1, 4) " ).append("\n"); 
		query.append("                         AND T1.BSE_MON = SUBSTR(TO_CHAR(T2.ST_DT, 'YYYYMMDD'), 5, 2) " ).append("\n"); 
		query.append("						 AND T1.FNL_BSA_CAPA > 0" ).append("\n"); 
		query.append("                         AND T1.TRD_CD = T2.TRD_CD " ).append("\n"); 
		query.append("                         AND T1.SUB_TRD_CD = T2.SUB_TRD_CD " ).append("\n"); 
		query.append("                         AND T1.RLANE_CD = T2.RLANE_CD " ).append("\n"); 
		query.append("                         AND T1.DIR_CD = T2.DIR_CD " ).append("\n"); 
		query.append("                         AND T1.BSE_YR = T3.BSE_YR " ).append("\n"); 
		query.append("                         AND T1.BSE_MON = T3.BSE_MON " ).append("\n"); 
		query.append("                         AND T1.TRD_CD = T3.TRD_CD " ).append("\n"); 
		query.append("                         AND T1.SUB_TRD_CD = T3.SUB_TRD_CD " ).append("\n"); 
		query.append("                         AND T2.MQTA_MDL_VER_NO = T3.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                         AND T1.DIR_CD = T3.DIR_CD " ).append("\n"); 
		query.append("                         AND T2.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no]" ).append("\n"); 
		query.append("                         AND T1.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                         AND T1.TGT_VVD_STS_CD = 'N' " ).append("\n"); 
		query.append("                         AND T2.FCAST_TRNS_STS_CD = 'N' " ).append("\n"); 
		query.append("                  ) " ).append("\n"); 
		query.append("            GROUP BY MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                , BSE_MON " ).append("\n"); 
		query.append("                , TRD_CD " ).append("\n"); 
		query.append("                , SUB_TRD_CD " ).append("\n"); 
		query.append("                , RLANE_CD " ).append("\n"); 
		query.append("                , DIR_CD " ).append("\n"); 
		query.append("                , CTRT_OFC_CD " ).append("\n"); 
		query.append("                , SLS_OFC_CD " ).append("\n"); 
		query.append("                , SLS_FCAST_NO " ).append("\n"); 
		query.append("           )  " ).append("\n"); 
		query.append("    ) B " ).append("\n"); 
		query.append("ON (B.MQTA_MDL_VER_NO = A.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("      AND B.BSE_MON = SUBSTR(TO_CHAR(A.ST_DT, 'YYYYMMDD'), 5, 2) " ).append("\n"); 
		query.append("      AND B.TRD_CD = A.TRD_CD " ).append("\n"); 
		query.append("      AND B.SUB_TRD_CD = A.SUB_TRD_CD " ).append("\n"); 
		query.append("      AND B.RLANE_CD = A.RLANE_CD " ).append("\n"); 
		query.append("      AND B.DIR_CD = A.DIR_CD " ).append("\n"); 
		query.append("      AND B.CTRT_OFC_CD = A.CTRT_OFC_CD " ).append("\n"); 
		query.append("      AND B.SLS_OFC_CD = A.SLS_OFC_CD " ).append("\n"); 
		query.append("      AND B.SLS_FCAST_NO = A.SLS_FCAST_NO" ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("       UPDATE " ).append("\n"); 
		query.append("              SET A.APLY_LOD_QTY = B.LOD_QTY " ).append("\n"); 
		query.append("            , A.MDL_ALOC_QTY = B.LOD_QTY " ).append("\n"); 
		query.append("            , A.APLY_GRS_RPB_REV = B.GRS_RPB_REV " ).append("\n"); 
		query.append("            , A.APLY_CM_UC_AMT = B.CM_UC_AMT " ).append("\n"); 
		query.append("            , UPD_USR_ID = @[user_id] " ).append("\n"); 
		query.append("            , UPD_DT = SYSDATE" ).append("\n"); 

	}
}