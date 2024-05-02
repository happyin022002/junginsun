/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddB0162CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddB0162CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 누락 점소 SAQ_MON_QTA_OFC_ADD, SAQ_MON_QTA_OFC_ADD_MIX에 Insert
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddB0162CSQL(){
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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddB0162CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_OFC_ADD_MIX(" ).append("\n"); 
		query.append("         BSE_YR            , BSE_QTR_CD     , TRD_CD         , DIR_CD          ," ).append("\n"); 
		query.append("         RLANE_CD          , CTRT_RGN_OFC_CD, SLS_RGN_OFC_CD , POL_CD          ," ).append("\n"); 
		query.append("         POD_CD            , SUB_TRD_CD     , CTRT_RHQ_CD    , CTRT_AQ_CD      ," ).append("\n"); 
		query.append("         SLS_RHQ_CD        , SLS_AQ_CD      , LOD_QTY        , CM_UC_AMT       ," ).append("\n"); 
		query.append("         OPFIT_UC_AMT      , RA_CM_UC_AMT   , RA_OPFIT_UC_AMT, FULL_STVG_UC_AMT," ).append("\n"); 
		query.append("         FULL_TRSP_UC_AMT  , MTY_STVG_UC_AMT, MTY_TRSP_UC_AMT, CNTR_FX_UC_AMT  ," ).append("\n"); 
		query.append("         CHSS_FX_UC_AMT    , AGN_COMM_UT_AMT, BIZ_ACT_UC_AMT , SLT_MGMT_UC_AMT ," ).append("\n"); 
		query.append("         OWN_VOL_ACT_UC_AMT, STP_UC_AMT     , EQ_HLD_UC_AMT  , EQ_REPO_UC_AMT  ," ).append("\n"); 
		query.append("         EQ_SIM_UC_AMT     , CRE_USR_ID     , CRE_DT         , UPD_USR_ID      ," ).append("\n"); 
		query.append("         UPD_DT )" ).append("\n"); 
		query.append(" WITH INPUT_PARAMS AS (" ).append("\n"); 
		query.append("                  SELECT @[mqta_step_cd] AS MQTA_STEP_CD," ).append("\n"); 
		query.append("                         @[bse_yr] AS BSE_YR      ," ).append("\n"); 
		query.append("                         @[bse_qtr_cd] AS BSE_QTR_CD  ," ).append("\n"); 
		query.append("                         @[trd_cd] AS TRD_CD      ," ).append("\n"); 
		query.append("                         @[dir_cd] AS DIR_CD      ," ).append("\n"); 
		query.append("                         MIN(CONV_DIR_CD) AS CONV_DIR_CD," ).append("\n"); 
		query.append("                         @[rhq_cd] AS RHQ_CD      ," ).append("\n"); 
		query.append("                         @[rlane_cd] AS RLANE_CD    ," ).append("\n"); 
		query.append("                         @[rgn_ofc_cd] AS RGN_OFC_CD  ," ).append("\n"); 
		query.append("                         @[aq_cd] AS AQ_CD       ," ).append("\n"); 
		query.append("                         @[sub_trd_cd] AS SUB_TRD_CD" ).append("\n"); 
		query.append("                    FROM SAQ_MON_DIR_CONV" ).append("\n"); 
		query.append("                   WHERE BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("                     AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("                     AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("                     AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("                     AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                     AND DIR_CD     = @[dir_cd]   )," ).append("\n"); 
		query.append("      SEL_DATA AS (" ).append("\n"); 
		query.append("                  SELECT CASE WHEN BB.CNT   > 0 THEN 'BB'" ).append("\n"); 
		query.append("                              WHEN LANE.CNT > 0 THEN 'LANE'" ).append("\n"); 
		query.append("                              WHEN SUB.CNT  > 0 THEN 'SUB'" ).append("\n"); 
		query.append("                              WHEN TRD.CNT  > 0 THEN 'TRD'" ).append("\n"); 
		query.append("                          END AS DATA" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                           SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("                             FROM SAQ_AVG_COST_OFC OFC," ).append("\n"); 
		query.append("                                  INPUT_PARAMS     INP," ).append("\n"); 
		query.append("                                  (" ).append("\n"); 
		query.append("                                    SELECT APPL_YR, APPL_MON" ).append("\n"); 
		query.append("                                      FROM SAQ_COST_APPL_BSE A," ).append("\n"); 
		query.append("                                           INPUT_PARAMS      B" ).append("\n"); 
		query.append("                                     WHERE A.BSE_YR     = B.BSE_YR" ).append("\n"); 
		query.append("                                       AND A.BSE_QTR_CD = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                                       AND COST_DIV_CD  = '30'          ) APPL" ).append("\n"); 
		query.append("                            WHERE OFC.BSE_YR          = APPL.APPL_YR" ).append("\n"); 
		query.append("                              AND OFC.BSE_MON         = APPL.APPL_MON" ).append("\n"); 
		query.append("                              AND OFC.TRD_CD          = INP.TRD_CD" ).append("\n"); 
		query.append("                              AND OFC.DIR_CD          = DECODE(INP.CONV_DIR_CD, '', INP.DIR_CD, CONV_DIR_CD)" ).append("\n"); 
		query.append("                              AND OFC.RLANE_CD        = INP.RLANE_CD" ).append("\n"); 
		query.append("                              AND OFC.SLS_RGN_OFC_CD  = DECODE(INP.MQTA_STEP_CD, '08', INP.RGN_OFC_CD     , OFC.SLS_RGN_OFC_CD)" ).append("\n"); 
		query.append("                              AND OFC.CTRT_RGN_OFC_CD = DECODE(INP.MQTA_STEP_CD, '08', OFC.CTRT_RGN_OFC_CD, INP.RGN_OFC_CD    )" ).append("\n"); 
		query.append("                         ) BB," ).append("\n"); 
		query.append("                         (" ).append("\n"); 
		query.append("                           SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("                             FROM SAQ_AVG_COST_OFC OFC," ).append("\n"); 
		query.append("                                  INPUT_PARAMS     INP," ).append("\n"); 
		query.append("                                  (" ).append("\n"); 
		query.append("                                    SELECT APPL_YR, APPL_MON" ).append("\n"); 
		query.append("                                      FROM SAQ_COST_APPL_BSE A," ).append("\n"); 
		query.append("                                           INPUT_PARAMS      B" ).append("\n"); 
		query.append("                                     WHERE A.BSE_YR     = B.BSE_YR" ).append("\n"); 
		query.append("                                       AND A.BSE_QTR_CD = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                                       AND COST_DIV_CD  = '30'          ) APPL" ).append("\n"); 
		query.append("                            WHERE OFC.BSE_YR   = APPL.APPL_YR" ).append("\n"); 
		query.append("                              AND OFC.BSE_MON  = APPL.APPL_MON" ).append("\n"); 
		query.append("                              AND OFC.TRD_CD   = INP.TRD_CD" ).append("\n"); 
		query.append("                              AND OFC.DIR_CD   = DECODE(INP.CONV_DIR_CD, '', INP.DIR_CD, CONV_DIR_CD)" ).append("\n"); 
		query.append("                              AND OFC.RLANE_CD = INP.RLANE_CD" ).append("\n"); 
		query.append("                         ) LANE," ).append("\n"); 
		query.append("                         (" ).append("\n"); 
		query.append("                           SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("                             FROM SAQ_AVG_COST_OFC OFC," ).append("\n"); 
		query.append("                                  INPUT_PARAMS     INP," ).append("\n"); 
		query.append("                                  (" ).append("\n"); 
		query.append("                                    SELECT APPL_YR, APPL_MON" ).append("\n"); 
		query.append("                                      FROM SAQ_COST_APPL_BSE A," ).append("\n"); 
		query.append("                                           INPUT_PARAMS      B" ).append("\n"); 
		query.append("                                     WHERE A.BSE_YR     = B.BSE_YR" ).append("\n"); 
		query.append("                                       AND A.BSE_QTR_CD = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                                       AND COST_DIV_CD  = '30'          ) APPL" ).append("\n"); 
		query.append("                            WHERE OFC.BSE_YR     = APPL.APPL_YR" ).append("\n"); 
		query.append("                              AND OFC.BSE_MON    = APPL.APPL_MON" ).append("\n"); 
		query.append("                              AND OFC.TRD_CD     = INP.TRD_CD" ).append("\n"); 
		query.append("                              AND OFC.DIR_CD     = DECODE(INP.CONV_DIR_CD, '', INP.DIR_CD, CONV_DIR_CD)" ).append("\n"); 
		query.append("                              AND OFC.SUB_TRD_CD = INP.SUB_TRD_CD" ).append("\n"); 
		query.append("                         ) SUB," ).append("\n"); 
		query.append("                         (" ).append("\n"); 
		query.append("                           SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("                             FROM SAQ_AVG_COST_OFC OFC," ).append("\n"); 
		query.append("                                  INPUT_PARAMS     INP," ).append("\n"); 
		query.append("                                  (" ).append("\n"); 
		query.append("                                    SELECT APPL_YR, APPL_MON" ).append("\n"); 
		query.append("                                      FROM SAQ_COST_APPL_BSE A," ).append("\n"); 
		query.append("                                           INPUT_PARAMS      B" ).append("\n"); 
		query.append("                                     WHERE A.BSE_YR     = B.BSE_YR" ).append("\n"); 
		query.append("                                       AND A.BSE_QTR_CD = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                                       AND COST_DIV_CD  = '30'          ) APPL" ).append("\n"); 
		query.append("                            WHERE OFC.BSE_YR  = APPL.APPL_YR" ).append("\n"); 
		query.append("                              AND OFC.BSE_MON = APPL.APPL_MON" ).append("\n"); 
		query.append("                              AND OFC.TRD_CD  = INP.TRD_CD" ).append("\n"); 
		query.append("                              AND OFC.DIR_CD  = DECODE(INP.CONV_DIR_CD, '', INP.DIR_CD, CONV_DIR_CD)" ).append("\n"); 
		query.append("                         ) TRD                             )" ).append("\n"); 
		query.append("#if(${unit_cost_flag} == 'Y')" ).append("\n"); 
		query.append(" SELECT BSE_YR            , BSE_QTR_CD      , TRD_CD         ," ).append("\n"); 
		query.append("        DIR_CD            , RLANE_CD        , CTRT_RGN_OFC_CD," ).append("\n"); 
		query.append("        SLS_RGN_OFC_CD    , POL_CD          , POD_CD         ," ).append("\n"); 
		query.append("        SUB_TRD_CD        , CTRT_RHQ_CD     , CTRT_AQ_CD     ," ).append("\n"); 
		query.append("        SLS_RHQ_CD        , SLS_AQ_CD       , LOD_QTY        ," ).append("\n"); 
		query.append("        CM_UC_AMT       + TML_VOL_INCNT_AMT - MISC_REV_AMT," ).append("\n"); 
		query.append("        OPFIT_UC_AMT      ," ).append("\n"); 
		query.append("        RA_CM_UC_AMT    + TML_VOL_INCNT_AMT - MISC_REV_AMT," ).append("\n"); 
		query.append("        RA_OPFIT_UC_AMT - UC_AMT + TML_VOL_INCNT_AMT - MISC_REV_AMT," ).append("\n"); 
		query.append("        FULL_STVG_UC_AMT  , FULL_TRSP_UC_AMT, MTY_STVG_UC_AMT," ).append("\n"); 
		query.append("        MTY_TRSP_UC_AMT   , CNTR_FX_UC_AMT  , CHSS_FX_UC_AMT ," ).append("\n"); 
		query.append("        AGN_COMM_UT_AMT   , BIZ_ACT_UC_AMT  , SLT_MGMT_UC_AMT," ).append("\n"); 
		query.append("        OWN_VOL_ACT_UC_AMT, STP_UC_AMT      , EQ_HLD_UC_AMT  ," ).append("\n"); 
		query.append("        EQ_REPO_UC_AMT    , EQ_SIM_UC_AMT   , @[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("        SYSDATE           , @[upd_usr_id] AS UPD_USR_ID , SYSDATE" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("          SELECT BSE_YR    , BSE_QTR_CD     , TRD_CD    , DIR_CD," ).append("\n"); 
		query.append("                 RLANE_CD  , CTRT_RGN_OFC_CD, POL_CD    , POD_CD," ).append("\n"); 
		query.append("                 SUB_TRD_CD, CTRT_RHQ_CD    , CTRT_AQ_CD," ).append("\n"); 
		query.append("                 DECODE(SLS_CHK.CHK, 0, SLS_RGN_OFC_CD, CTRT_RGN_OFC_CD   ) AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                 DECODE(SLS_CHK.CHK, 0, INS.SLS_RHQ_CD, SLS_CHK.SLS_RHQ_CD) AS SLS_RHQ_CD    ," ).append("\n"); 
		query.append("                 DECODE(SLS_CHK.CHK, 0, INS.SLS_AQ_CD , SLS_CHK.SLS_AQ_CD ) AS SLS_AQ_CD     ," ).append("\n"); 
		query.append("                 SUM(LOD_QTY)                                                                 AS LOD_QTY           ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * CM_UC_AMT)          / SUM(LOD_QTY)) AS CM_UC_AMT         ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * OPFIT_UC_AMT)       / SUM(LOD_QTY)) AS OPFIT_UC_AMT      ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * RA_CM_UC_AMT)       / SUM(LOD_QTY)) AS RA_CM_UC_AMT      ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * RA_OPFIT_UC_AMT)    / SUM(LOD_QTY)) AS RA_OPFIT_UC_AMT   ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * FULL_STVG_UC_AMT)   / SUM(LOD_QTY)) AS FULL_STVG_UC_AMT  ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * FULL_TRSP_UC_AMT)   / SUM(LOD_QTY)) AS FULL_TRSP_UC_AMT  ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * MTY_STVG_UC_AMT)    / SUM(LOD_QTY)) AS MTY_STVG_UC_AMT   ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * MTY_TRSP_UC_AMT)    / SUM(LOD_QTY)) AS MTY_TRSP_UC_AMT   ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * CNTR_FX_UC_AMT)     / SUM(LOD_QTY)) AS CNTR_FX_UC_AMT    ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * CHSS_FX_UC_AMT)     / SUM(LOD_QTY)) AS CHSS_FX_UC_AMT    ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * AGN_COMM_UT_AMT)    / SUM(LOD_QTY)) AS AGN_COMM_UT_AMT   ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * BIZ_ACT_UC_AMT)     / SUM(LOD_QTY)) AS BIZ_ACT_UC_AMT    ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * SLT_MGMT_UC_AMT)    / SUM(LOD_QTY)) AS SLT_MGMT_UC_AMT   ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * OWN_VOL_ACT_UC_AMT) / SUM(LOD_QTY)) AS OWN_VOL_ACT_UC_AMT," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * STP_UC_AMT)         / SUM(LOD_QTY)) AS STP_UC_AMT        ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * EQ_HLD_UC_AMT)      / SUM(LOD_QTY)) AS EQ_HLD_UC_AMT     ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * EQ_REPO_UC_AMT)     / SUM(LOD_QTY)) AS EQ_REPO_UC_AMT    ," ).append("\n"); 
		query.append("                 DECODE(SUM(LOD_QTY), 0, 0, SUM(LOD_QTY * EQ_SIM_UC_AMT)      / SUM(LOD_QTY)) AS EQ_SIM_UC_AMT     ," ).append("\n"); 
		query.append("                 DMDT_UT_AMT.AMT       AS UC_AMT           ," ).append("\n"); 
		query.append("                 TML_VOL_INCNT_AMT.AMT AS TML_VOL_INCNT_AMT," ).append("\n"); 
		query.append("                 MISC_REV_AMT.AMT      AS MISC_REV_AMT" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                   SELECT INP.BSE_YR             , INP.BSE_QTR_CD      ," ).append("\n"); 
		query.append("                          OFC.TRD_CD             , INP.RLANE_CD        ," ).append("\n"); 
		query.append("                          INP.DIR_CD AS DIR_CD         ," ).append("\n"); 
		query.append("                          DECODE(INP.MQTA_STEP_CD, '08', '000000'      , INP.RGN_OFC_CD     ) AS CTRT_RGN_OFC_CD," ).append("\n"); 
		query.append("                          DECODE(INP.MQTA_STEP_CD, '08', INP.RGN_OFC_CD, OFC.SLS_RGN_OFC_CD ) AS SLS_RGN_OFC_CD ," ).append("\n"); 
		query.append("                          DECODE(INP.MQTA_STEP_CD, '08', '000000'      , RHQ.RHQ_CD         ) AS CTRT_RHQ_CD    ," ).append("\n"); 
		query.append("                          DECODE(INP.MQTA_STEP_CD, '08', '000000'      , INP.AQ_CD          ) AS CTRT_AQ_CD     ," ).append("\n"); 
		query.append("                          DECODE(INP.MQTA_STEP_CD, '08', RHQ.RHQ_CD    , OFC.SLS_RHQ_CD     ) AS SLS_RHQ_CD     ," ).append("\n"); 
		query.append("                          DECODE(INP.MQTA_STEP_CD, '08', INP.AQ_CD     , OFC.SLS_AQ_CD      ) AS SLS_AQ_CD      ," ).append("\n"); 
		query.append("                          OFC.POL_CD             , OFC.POD_CD          , INP.SUB_TRD_CD        ," ).append("\n"); 
		query.append("                          OFC.LOD_QTY            , OFC.CM_UC_AMT       , OFC.OPFIT_UC_AMT      ," ).append("\n"); 
		query.append("                          OFC.RA_CM_UC_AMT       , OFC.RA_OPFIT_UC_AMT , OFC.FULL_STVG_UC_AMT  ," ).append("\n"); 
		query.append("                          OFC.FULL_TRSP_UC_AMT   , OFC.MTY_STVG_UC_AMT , OFC.MTY_TRSP_UC_AMT   ," ).append("\n"); 
		query.append("                          OFC.CNTR_FX_UC_AMT     , OFC.CHSS_FX_UC_AMT  , OFC.AGN_COMM_UT_AMT   ," ).append("\n"); 
		query.append("                          OFC.BIZ_ACT_UC_AMT     , OFC.SLT_MGMT_UC_AMT , OFC.OWN_VOL_ACT_UC_AMT," ).append("\n"); 
		query.append("                          OFC.STP_UC_AMT         , OFC.EQ_HLD_UC_AMT   , OFC.EQ_REPO_UC_AMT    ," ).append("\n"); 
		query.append("                          OFC.EQ_SIM_UC_AMT" ).append("\n"); 
		query.append("                     FROM SAQ_AVG_COST_OFC OFC," ).append("\n"); 
		query.append("                          INPUT_PARAMS     INP," ).append("\n"); 
		query.append("                          SEL_DATA         SEL," ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                            SELECT APPL_YR, APPL_MON" ).append("\n"); 
		query.append("                              FROM SAQ_COST_APPL_BSE A," ).append("\n"); 
		query.append("                                   INPUT_PARAMS      B" ).append("\n"); 
		query.append("                             WHERE A.BSE_YR     = B.BSE_YR" ).append("\n"); 
		query.append("                               AND A.BSE_QTR_CD = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                               AND COST_DIV_CD  = '30'              ) APPL," ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                            SELECT DISTINCT N2ND_PRNT_OFC_CD AS RHQ_CD" ).append("\n"); 
		query.append("                              FROM SAQ_ORGANIZATION_V A," ).append("\n"); 
		query.append("                                   INPUT_PARAMS       B" ).append("\n"); 
		query.append("                             WHERE N4TH_PRNT_OFC_CD = B.RGN_OFC_CD  ) RHQ" ).append("\n"); 
		query.append("                    WHERE OFC.BSE_YR          = APPL.APPL_YR" ).append("\n"); 
		query.append("                      AND OFC.BSE_MON         = APPL.APPL_MON" ).append("\n"); 
		query.append("                      AND OFC.DIR_CD          = DECODE(INP.CONV_DIR_CD, '', INP.DIR_CD, CONV_DIR_CD)" ).append("\n"); 
		query.append("                      AND OFC.RLANE_CD        = DECODE(SEL.DATA, 'BB' , INP.RLANE_CD  , 'LANE', INP.RLANE_CD , OFC.RLANE_CD)" ).append("\n"); 
		query.append("                      AND OFC.SUB_TRD_CD      = DECODE(SEL.DATA, 'SUB', INP.SUB_TRD_CD, OFC.SUB_TRD_CD)" ).append("\n"); 
		query.append("                      AND OFC.TRD_CD          = DECODE(SEL.DATA, 'SUB', OFC.TRD_CD    , INP.TRD_CD    )" ).append("\n"); 
		query.append("                      AND OFC.SLS_RGN_OFC_CD  = DECODE(SEL.DATA, 'BB' , DECODE(INP.MQTA_STEP_CD, '08', INP.RGN_OFC_CD     , OFC.SLS_RGN_OFC_CD), OFC.SLS_RGN_OFC_CD )" ).append("\n"); 
		query.append("                      AND OFC.CTRT_RGN_OFC_CD = DECODE(SEL.DATA, 'BB' , DECODE(INP.MQTA_STEP_CD, '08', OFC.CTRT_RGN_OFC_CD, INP.RGN_OFC_CD    ), OFC.CTRT_RGN_OFC_CD)   ) INS," ).append("\n"); 
		query.append("		-- 04 Step에서 입력한 rgn_ofc_cd가 sls_rgn_ofc_cd에 존재 할 경우를 위한 로직" ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                   SELECT DECODE(MIN(CTRT_RGN_OFC_CD), '000000', 0, COUNT(*)) AS CHK," ).append("\n"); 
		query.append("                          MIN(SLS_RHQ_CD) AS SLS_RHQ_CD," ).append("\n"); 
		query.append("                          MIN(SLS_AQ_CD)  AS SLS_AQ_CD" ).append("\n"); 
		query.append("                     FROM (" ).append("\n"); 
		query.append("                            SELECT DISTINCT DECODE(INP.MQTA_STEP_CD, '08', '000000'      , INP.RGN_OFC_CD    ) AS CTRT_RGN_OFC_CD," ).append("\n"); 
		query.append("                                            DECODE(INP.MQTA_STEP_CD, '08', INP.RGN_OFC_CD, OFC.SLS_RGN_OFC_CD) AS SLS_RGN_OFC_CD ," ).append("\n"); 
		query.append("                                            DECODE(INP.MQTA_STEP_CD, '08', RHQ.RHQ_CD    , OFC.SLS_RHQ_CD    ) AS SLS_RHQ_CD     ," ).append("\n"); 
		query.append("                                            DECODE(INP.MQTA_STEP_CD, '08', INP.AQ_CD     , OFC.SLS_AQ_CD     ) AS SLS_AQ_CD" ).append("\n"); 
		query.append("                              FROM SAQ_AVG_COST_OFC OFC," ).append("\n"); 
		query.append("                                   INPUT_PARAMS     INP," ).append("\n"); 
		query.append("                                   SEL_DATA         SEL," ).append("\n"); 
		query.append("                                   (" ).append("\n"); 
		query.append("                                     SELECT APPL_YR, APPL_MON" ).append("\n"); 
		query.append("                                       FROM SAQ_COST_APPL_BSE A," ).append("\n"); 
		query.append("                                            INPUT_PARAMS      B" ).append("\n"); 
		query.append("                                      WHERE A.BSE_YR     = B.BSE_YR" ).append("\n"); 
		query.append("                                        AND A.BSE_QTR_CD = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                                        AND COST_DIV_CD  = '30'              ) APPL," ).append("\n"); 
		query.append("                                   (" ).append("\n"); 
		query.append("                                     SELECT DISTINCT N2ND_PRNT_OFC_CD AS RHQ_CD" ).append("\n"); 
		query.append("                                       FROM SAQ_ORGANIZATION_V A," ).append("\n"); 
		query.append("                                            INPUT_PARAMS       B" ).append("\n"); 
		query.append("                                      WHERE N4TH_PRNT_OFC_CD = B.RGN_OFC_CD  ) RHQ" ).append("\n"); 
		query.append("                             WHERE OFC.BSE_YR          = APPL.APPL_YR" ).append("\n"); 
		query.append("                               AND OFC.BSE_MON         = APPL.APPL_MON" ).append("\n"); 
		query.append("                               AND OFC.DIR_CD          = INP.DIR_CD" ).append("\n"); 
		query.append("                               AND OFC.RLANE_CD        = DECODE(SEL.DATA, 'BB' , INP.RLANE_CD  , 'LANE', INP.RLANE_CD , OFC.RLANE_CD)" ).append("\n"); 
		query.append("                               AND OFC.SUB_TRD_CD      = DECODE(SEL.DATA, 'SUB', INP.SUB_TRD_CD, OFC.SUB_TRD_CD)" ).append("\n"); 
		query.append("                               AND OFC.TRD_CD          = DECODE(SEL.DATA, 'SUB', OFC.TRD_CD    , INP.TRD_CD    )" ).append("\n"); 
		query.append("                               AND OFC.SLS_RGN_OFC_CD  = DECODE(SEL.DATA, 'BB' , DECODE(INP.MQTA_STEP_CD, '08', INP.RGN_OFC_CD     , OFC.SLS_RGN_OFC_CD), OFC.SLS_RGN_OFC_CD )" ).append("\n"); 
		query.append("                               AND OFC.CTRT_RGN_OFC_CD = DECODE(SEL.DATA, 'BB' , DECODE(INP.MQTA_STEP_CD, '08', OFC.CTRT_RGN_OFC_CD, INP.RGN_OFC_CD    ), OFC.CTRT_RGN_OFC_CD)  )" ).append("\n"); 
		query.append("                    WHERE CTRT_RGN_OFC_CD = DECODE(CTRT_RGN_OFC_CD, '000000', CTRT_RGN_OFC_CD, SLS_RGN_OFC_CD) ) SLS_CHK," ).append("\n"); 
		query.append("		-- DEM/DET amt 구함" ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                   SELECT DECODE(MAX(UC_AMT), '', 0, MAX(UC_AMT)) AS AMT" ).append("\n"); 
		query.append("                     FROM COA_DMDT_N3RD_PTY" ).append("\n"); 
		query.append("                    WHERE STND_COST_CD = '43201011'" ).append("\n"); 
		query.append("                      AND CNTR_TPSZ_CD = 'TEU'" ).append("\n"); 
		query.append("                      AND COST_YRMON   = ( SELECT APPL_YR||APPL_MON" ).append("\n"); 
		query.append("                                             FROM SAQ_COST_APPL_BSE A," ).append("\n"); 
		query.append("                                                  INPUT_PARAMS      B" ).append("\n"); 
		query.append("                                            WHERE A.BSE_YR     = B.BSE_YR" ).append("\n"); 
		query.append("                                              AND A.BSE_QTR_CD = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                                              AND COST_DIV_CD  = '10' )         ) DMDT_UT_AMT," ).append("\n"); 
		query.append("		-- Terminal Volume Incentive amt 구함" ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                   SELECT DECODE(MIN(UC_AMT), '', 0, MIN(UC_AMT)) AS AMT" ).append("\n"); 
		query.append("                     FROM COA_DMDT_N3RD_PTY" ).append("\n"); 
		query.append("                    WHERE STND_COST_CD = '51601011'" ).append("\n"); 
		query.append("                      AND CNTR_TPSZ_CD = 'TEU'" ).append("\n"); 
		query.append("                      AND COST_YRMON   = ( SELECT APPL_YR||APPL_MON" ).append("\n"); 
		query.append("                                             FROM SAQ_COST_APPL_BSE A," ).append("\n"); 
		query.append("                                                  INPUT_PARAMS      B" ).append("\n"); 
		query.append("                                            WHERE A.BSE_YR     = B.BSE_YR" ).append("\n"); 
		query.append("                                              AND A.BSE_QTR_CD = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                                              AND COST_DIV_CD  = '10' )         ) TML_VOL_INCNT_AMT," ).append("\n"); 
		query.append("		-- Misc Rev amt 구함" ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                   SELECT DECODE(MAX(OFC.RLANE_CD), 'RBCCO', 0, DECODE(MAX(SAQ_MISC_REV_AMT), '', 0, MAX(SAQ_MISC_REV_AMT))) AS AMT" ).append("\n"); 
		query.append("                     FROM SAQ_AVG_COST_OFC OFC," ).append("\n"); 
		query.append("                          INPUT_PARAMS     INP," ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                            SELECT APPL_YR, APPL_MON" ).append("\n"); 
		query.append("                              FROM SAQ_COST_APPL_BSE A," ).append("\n"); 
		query.append("                                   INPUT_PARAMS      B" ).append("\n"); 
		query.append("                             WHERE A.BSE_YR     = B.BSE_YR" ).append("\n"); 
		query.append("                               AND A.BSE_QTR_CD = B.BSE_QTR_CD" ).append("\n"); 
		query.append("                               AND COST_DIV_CD  = '30'              ) APPL" ).append("\n"); 
		query.append("                    WHERE OFC.BSE_YR     = APPL.APPL_YR" ).append("\n"); 
		query.append("                      AND OFC.BSE_MON    = APPL.APPL_MON" ).append("\n"); 
		query.append("                      AND OFC.DIR_CD     = DECODE(INP.CONV_DIR_CD, '', INP.DIR_CD, CONV_DIR_CD)" ).append("\n"); 
		query.append("                      AND OFC.RLANE_CD   = INP.RLANE_CD" ).append("\n"); 
		query.append("                      AND OFC.SUB_TRD_CD = INP.SUB_TRD_CD" ).append("\n"); 
		query.append("                      AND OFC.TRD_CD     = INP.TRD_CD                           ) MISC_REV_AMT" ).append("\n"); 
		query.append("        GROUP BY BSE_YR    , BSE_QTR_CD     , TRD_CD    , DIR_CD           ," ).append("\n"); 
		query.append("                 RLANE_CD  , CTRT_RGN_OFC_CD, POL_CD    , POD_CD           ," ).append("\n"); 
		query.append("                 SUB_TRD_CD, CTRT_RHQ_CD    , CTRT_AQ_CD, DMDT_UT_AMT.AMT  ," ).append("\n"); 
		query.append("                 TML_VOL_INCNT_AMT.AMT, MISC_REV_AMT.AMT," ).append("\n"); 
		query.append("                 DECODE(SLS_CHK.CHK, 0, SLS_RGN_OFC_CD, CTRT_RGN_OFC_CD   )," ).append("\n"); 
		query.append("                 DECODE(SLS_CHK.CHK, 0, INS.SLS_RHQ_CD, SLS_CHK.SLS_RHQ_CD)," ).append("\n"); 
		query.append("                 DECODE(SLS_CHK.CHK, 0, INS.SLS_AQ_CD , SLS_CHK.SLS_AQ_CD )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT  BSE_YR" ).append("\n"); 
		query.append("       ,BSE_QTR_CD" ).append("\n"); 
		query.append("       ,TRD_CD" ).append("\n"); 
		query.append("       ,DIR_CD" ).append("\n"); 
		query.append("       ,RLANE_CD" ).append("\n"); 
		query.append("       ,DECODE(MQTA_STEP_CD, '04', RGN_OFC_CD, '000000')" ).append("\n"); 
		query.append("       ,DECODE(MQTA_STEP_CD, '08', RGN_OFC_CD, '000000')" ).append("\n"); 
		query.append("       ,'00000'" ).append("\n"); 
		query.append("       ,'00000'" ).append("\n"); 
		query.append("       ,SUB_TRD_CD" ).append("\n"); 
		query.append("       ,DECODE(MQTA_STEP_CD, '04', RHQ_CD)" ).append("\n"); 
		query.append("       ,DECODE(MQTA_STEP_CD, '04', AQ_CD )" ).append("\n"); 
		query.append("       ,DECODE(MQTA_STEP_CD, '08', RHQ_CD)" ).append("\n"); 
		query.append("       ,DECODE(MQTA_STEP_CD, '08', AQ_CD )" ).append("\n"); 
		query.append("       ,0, 0, 0, 0, 0, 0, 0, 0, 0, 0" ).append("\n"); 
		query.append("       ,0, 0, 0, 0, 0, 0, 0, 0, 0" ).append("\n"); 
		query.append("       ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("       ,@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("  FROM  INPUT_PARAMS INP" ).append("\n"); 
		query.append("       ,SEL_DATA     SEL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}