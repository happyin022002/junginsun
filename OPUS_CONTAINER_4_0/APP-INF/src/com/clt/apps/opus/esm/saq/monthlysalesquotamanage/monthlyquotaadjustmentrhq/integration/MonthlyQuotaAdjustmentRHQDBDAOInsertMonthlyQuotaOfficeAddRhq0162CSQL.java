/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddRhq0162CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.27 이상용
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

public class MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddRhq0162CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DAOCSQL
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddRhq0162CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddRhq0162CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_RHQ (" ).append("\n"); 
		query.append("                 MQTA_STEP_CD, BSE_YR         , BSE_QTR_CD  , TRD_CD         ," ).append("\n"); 
		query.append("                 DIR_CD      , MQTA_VER_NO    , RLANE_CD    , SPRT_GRP_CD    ," ).append("\n"); 
		query.append("                 BSA_GRP_CD  , CTRT_RGN_OFC_CD, BSE_MON     , SUB_TRD_CD     ," ).append("\n"); 
		query.append("                 CTRT_RHQ_CD , CTRT_AQ_CD     , LOD_QTY     , GRS_RPB_REV    ," ).append("\n"); 
		query.append("                 CM_UC_AMT   , OPFIT_UC_AMT   , RA_CM_UC_AMT, RA_OPFIT_UC_AMT," ).append("\n"); 
		query.append("                 OFC_ADD_FLG , CRE_USR_ID     , CRE_DT      , UPD_USR_ID     ," ).append("\n"); 
		query.append("                 UPD_DT )" ).append("\n"); 
		query.append(" WITH INPUT_PARAMS AS (" ).append("\n"); 
		query.append("                    SELECT @[mqta_step_cd] AS MQTA_STEP_CD," ).append("\n"); 
		query.append("                           @[bse_yr] AS BSE_YR      ," ).append("\n"); 
		query.append("                           @[bse_qtr_cd] AS BSE_QTR_CD  ," ).append("\n"); 
		query.append("                           @[trd_cd] AS TRD_CD      ," ).append("\n"); 
		query.append("                           @[dir_cd] AS DIR_CD      ," ).append("\n"); 
		query.append("                           @[mqta_ver_no] AS MQTA_VER_NO ," ).append("\n"); 
		query.append("                           @[rhq_cd] AS RHQ_CD      ," ).append("\n"); 
		query.append("                           @[rlane_cd] AS RLANE_CD    ," ).append("\n"); 
		query.append("                           @[rgn_ofc_cd] AS RGN_OFC_CD  ," ).append("\n"); 
		query.append("                           @[aq_cd] AS AQ_CD       ," ).append("\n"); 
		query.append("                           @[sub_trd_cd] AS SUB_TRD_CD" ).append("\n"); 
		query.append("                    FROM DUAL )" ).append("\n"); 
		query.append("   SELECT C.MQTA_STEP_CD, C.BSE_YR    , C.BSE_QTR_CD , C.TRD_CD    , C.DIR_CD    ," ).append("\n"); 
		query.append("          C.MQTA_VER_NO , C.RLANE_CD  , C.SPRT_GRP_CD, C.BSA_GRP_CD, C.RGN_OFC_CD," ).append("\n"); 
		query.append("          C.BSE_MON     , B.SUB_TRD_CD, B.RHQ_CD     , B.AQ_CD     ," ).append("\n"); 
		query.append("          0 AS LOD_QTY, 0 AS GRS_RPB_REV," ).append("\n"); 
		query.append("          DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * CM_UC_AMT)       / SUM(LOD_QTY)) AS CM_UC_AMT      ," ).append("\n"); 
		query.append("          DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * OPFIT_UC_AMT)    / SUM(LOD_QTY)) AS OPFIT_UC_AMT   ," ).append("\n"); 
		query.append("          DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * RA_CM_UC_AMT)    / SUM(LOD_QTY)) AS RA_CM_UC_AMT   ," ).append("\n"); 
		query.append("          DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * RA_OPFIT_UC_AMT) / SUM(LOD_QTY)) AS RA_OPFIT_UC_AMT," ).append("\n"); 
		query.append("          'Y' AS OFC_ADD_FLG, @[cre_usr_id] AS CRE_USR_ID, SYSDATE, @[upd_usr_id] AS UPD_USR_ID, SYSDATE" ).append("\n"); 
		query.append("     FROM SAQ_MON_QTA_OFC_ADD_MIX A," ).append("\n"); 
		query.append("          INPUT_PARAMS            B," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("				   --전체 경우의 수" ).append("\n"); 
		query.append("            SELECT A.MQTA_STEP_CD, A.BSE_YR     , A.BSE_QTR_CD, A.TRD_CD     ," ).append("\n"); 
		query.append("                   A.DIR_CD      , C.MQTA_VER_NO, A.RLANE_CD  , C.SPRT_GRP_CD," ).append("\n"); 
		query.append("                   C.BSA_GRP_CD  , B.RGN_OFC_CD , A.BSE_MON" ).append("\n"); 
		query.append("              FROM SAQ_MON_QTA_RHQ A," ).append("\n"); 
		query.append("                   INPUT_PARAMS    B," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                     SELECT DISTINCT SPRT_GRP_CD, BSA_GRP_CD, BSE_MON, C.MQTA_VER_NO" ).append("\n"); 
		query.append("                       FROM SAQ_MON_QTA_RHQ A," ).append("\n"); 
		query.append("                            INPUT_PARAMS    B," ).append("\n"); 
		query.append("									-- 해당 Version을 모두 가져오는 로직" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                              SELECT A.MQTA_VER_NO" ).append("\n"); 
		query.append("                                FROM SAQ_MON_QTA_STEP_VER A," ).append("\n"); 
		query.append("                                     INPUT_PARAMS         B" ).append("\n"); 
		query.append("                               WHERE A.MQTA_STEP_CD = B.MQTA_STEP_CD" ).append("\n"); 
		query.append("                                 AND A.BSE_YR       = B.BSE_YR" ).append("\n"); 
		query.append("                                 AND A.BSE_QTR_CD   = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                                 AND A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("                                 AND A.DIR_CD       = B.DIR_CD" ).append("\n"); 
		query.append("                                 AND A.CRE_OFC_CD   = B.RHQ_CD  ) C" ).append("\n"); 
		query.append("                        WHERE A.MQTA_STEP_CD = B.MQTA_STEP_CD" ).append("\n"); 
		query.append("                          AND A.BSE_YR       = B.BSE_YR" ).append("\n"); 
		query.append("                          AND A.BSE_QTR_CD   = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                          AND A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("                          AND A.DIR_CD       = B.DIR_CD" ).append("\n"); 
		query.append("                          AND A.MQTA_VER_NO  = C.MQTA_VER_NO" ).append("\n"); 
		query.append("                          AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("                     GROUP BY A.MQTA_STEP_CD, A.BSE_YR, A.BSE_QTR_CD, A.TRD_CD, A.DIR_CD, C.MQTA_VER_NO," ).append("\n"); 
		query.append("                              A.RLANE_CD, SPRT_GRP_CD, BSA_GRP_CD, CTRT_RGN_OFC_CD, BSE_MON ) C" ).append("\n"); 
		query.append("             WHERE A.MQTA_STEP_CD    = B.MQTA_STEP_CD" ).append("\n"); 
		query.append("               AND A.BSE_YR          = B.BSE_YR" ).append("\n"); 
		query.append("               AND A.BSE_QTR_CD      = B.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND A.TRD_CD          = B.TRD_CD" ).append("\n"); 
		query.append("               AND A.DIR_CD          = B.DIR_CD" ).append("\n"); 
		query.append("               AND A.MQTA_VER_NO     = C.MQTA_VER_NO" ).append("\n"); 
		query.append("               AND A.RLANE_CD        = B.RLANE_CD" ).append("\n"); 
		query.append("               AND A.BSE_MON         = C.BSE_MON" ).append("\n"); 
		query.append("          GROUP BY A.MQTA_STEP_CD, A.BSE_YR, A.BSE_QTR_CD, A.TRD_CD, A.DIR_CD, C.MQTA_VER_NO," ).append("\n"); 
		query.append("                   A.RLANE_CD, C.SPRT_GRP_CD, C.BSA_GRP_CD, B.RGN_OFC_CD, A.BSE_MON" ).append("\n"); 
		query.append("				   -- 현재 존재하는 경우의 수" ).append("\n"); 
		query.append("             MINUS" ).append("\n"); 
		query.append("            SELECT A.MQTA_STEP_CD, A.BSE_YR     , A.BSE_QTR_CD, A.TRD_CD     ," ).append("\n"); 
		query.append("                   A.DIR_CD      , A.MQTA_VER_NO, A.RLANE_CD  , C.SPRT_GRP_CD," ).append("\n"); 
		query.append("                   C.BSA_GRP_CD  , B.RGN_OFC_CD , A.BSE_MON" ).append("\n"); 
		query.append("              FROM SAQ_MON_QTA_RHQ A," ).append("\n"); 
		query.append("                   INPUT_PARAMS    B," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                     SELECT DISTINCT SPRT_GRP_CD, BSA_GRP_CD, BSE_MON, C.MQTA_VER_NO" ).append("\n"); 
		query.append("                       FROM SAQ_MON_QTA_RHQ A," ).append("\n"); 
		query.append("                            INPUT_PARAMS    B," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                              SELECT A.MQTA_VER_NO" ).append("\n"); 
		query.append("                                FROM SAQ_MON_QTA_STEP_VER A," ).append("\n"); 
		query.append("                                     INPUT_PARAMS         B" ).append("\n"); 
		query.append("                               WHERE A.MQTA_STEP_CD = B.MQTA_STEP_CD" ).append("\n"); 
		query.append("                                 AND A.BSE_YR       = B.BSE_YR" ).append("\n"); 
		query.append("                                 AND A.BSE_QTR_CD   = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                                 AND A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("                                 AND A.DIR_CD       = B.DIR_CD" ).append("\n"); 
		query.append("                                 AND A.CRE_OFC_CD   = B.RHQ_CD  ) C" ).append("\n"); 
		query.append("                      WHERE A.MQTA_STEP_CD = B.MQTA_STEP_CD" ).append("\n"); 
		query.append("                        AND A.BSE_YR       = B.BSE_YR" ).append("\n"); 
		query.append("                        AND A.BSE_QTR_CD   = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                        AND A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("                        AND A.DIR_CD       = B.DIR_CD" ).append("\n"); 
		query.append("                        AND A.MQTA_VER_NO  = C.MQTA_VER_NO" ).append("\n"); 
		query.append("                        AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("                   GROUP BY A.MQTA_STEP_CD, A.BSE_YR, A.BSE_QTR_CD, A.TRD_CD, A.DIR_CD, C.MQTA_VER_NO," ).append("\n"); 
		query.append("                            A.RLANE_CD, SPRT_GRP_CD, BSA_GRP_CD, CTRT_RGN_OFC_CD, BSE_MON ) C" ).append("\n"); 
		query.append("             WHERE A.MQTA_STEP_CD    = B.MQTA_STEP_CD" ).append("\n"); 
		query.append("               AND A.BSE_YR          = B.BSE_YR" ).append("\n"); 
		query.append("               AND A.BSE_QTR_CD      = B.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND A.TRD_CD          = B.TRD_CD" ).append("\n"); 
		query.append("               AND A.DIR_CD          = B.DIR_CD" ).append("\n"); 
		query.append("               AND A.MQTA_VER_NO     = C.MQTA_VER_NO" ).append("\n"); 
		query.append("               AND A.RLANE_CD        = B.RLANE_CD" ).append("\n"); 
		query.append("               AND A.CTRT_RGN_OFC_CD = B.RGN_OFC_CD" ).append("\n"); 
		query.append("               AND A.BSA_GRP_CD      = C.BSA_GRP_CD" ).append("\n"); 
		query.append("               AND A.SPRT_GRP_CD     = C.SPRT_GRP_CD" ).append("\n"); 
		query.append("          GROUP BY A.MQTA_STEP_CD, A.BSE_YR, A.BSE_QTR_CD, A.TRD_CD, A.DIR_CD, A.MQTA_VER_NO," ).append("\n"); 
		query.append("                   A.RLANE_CD, C.SPRT_GRP_CD, C.BSA_GRP_CD, B.RGN_OFC_CD, A.BSE_MON ) C" ).append("\n"); 
		query.append("    WHERE A.BSE_YR          = C.BSE_YR" ).append("\n"); 
		query.append("      AND A.BSE_QTR_CD      = C.BSE_QTR_CD" ).append("\n"); 
		query.append("      AND A.TRD_CD          = C.TRD_CD" ).append("\n"); 
		query.append("      AND A.DIR_CD          = C.DIR_CD" ).append("\n"); 
		query.append("      AND A.RLANE_CD        = C.RLANE_CD" ).append("\n"); 
		query.append("      AND A.CTRT_RGN_OFC_CD = B.RGN_OFC_CD" ).append("\n"); 
		query.append(" GROUP BY C.MQTA_STEP_CD, C.BSE_YR, C.BSE_QTR_CD, C.TRD_CD, C.DIR_CD, C.MQTA_VER_NO," ).append("\n"); 
		query.append("          C.RLANE_CD, C.SPRT_GRP_CD, C.BSA_GRP_CD, C.RGN_OFC_CD, C.BSE_MON" ).append("\n"); 

	}
}