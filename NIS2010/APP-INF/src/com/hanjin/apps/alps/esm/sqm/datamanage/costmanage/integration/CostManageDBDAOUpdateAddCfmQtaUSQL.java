/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CostManageDBDAOUpdateAddCfmQtaUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.08.10 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOUpdateAddCfmQtaUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic CMCB 를 Add Creation 한다.
	  * </pre>
	  */
	public CostManageDBDAOUpdateAddCfmQtaUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOUpdateAddCfmQtaUSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_CFM_QTA QTA USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         SELECT BSE_TP_CD" ).append("\n"); 
		query.append("              , BSE_YR" ).append("\n"); 
		query.append("              , BSE_QTR_CD" ).append("\n"); 
		query.append("              , OFC_VW_CD" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , DECODE(OFC_VW_CD, 'C', CTRT_RGN_OFC, 'L', SLS_RGN_OFC) AS RGN_OFC_CD" ).append("\n"); 
		query.append("              , ROUND(SUM(RA_CM_COST_TTL_AMT) / SUM(LOD_QTY), 5) AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("              , ROUND(SUM(PA_CM_COST_TTL_AMT) / SUM(LOD_QTY), 5) AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                 SELECT S.BSE_TP_CD" ).append("\n"); 
		query.append("                      , S.BSE_YR" ).append("\n"); 
		query.append("                      , S.BSE_QTR_CD" ).append("\n"); 
		query.append("                      , S.OFC_VW_CD" ).append("\n"); 
		query.append("                      , T.TRD_CD" ).append("\n"); 
		query.append("                      , T.RLANE_CD" ).append("\n"); 
		query.append("                      , T.DIR_CD" ).append("\n"); 
		query.append("                      , T.CTRT_RHQ_OFC" ).append("\n"); 
		query.append("                      , T.CTRT_RGN_OFC" ).append("\n"); 
		query.append("                      , T.SLS_RHQ_OFC" ).append("\n"); 
		query.append("                      , T.SLS_RGN_OFC" ).append("\n"); 
		query.append("                      , T.CTRT_OFC_CD" ).append("\n"); 
		query.append("                      , T.SLS_OFC_CD" ).append("\n"); 
		query.append("                      , T.LOD_QTY" ).append("\n"); 
		query.append("                      , T.RA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                      , T.PA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                   FROM (" ).append("\n"); 
		query.append("                        SELECT /*+ NO_MERGE */ TRD_CD" ).append("\n"); 
		query.append("                              , RLANE_CD" ).append("\n"); 
		query.append("                              , DIR_CD" ).append("\n"); 
		query.append("                              , NVL((SELECT N2ND_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = CTRT_OFC_CD)," ).append("\n"); 
		query.append("                                    (SELECT RHQ_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = CTRT_OFC_CD)) AS CTRT_RHQ_OFC" ).append("\n"); 
		query.append("                              , CASE WHEN SLS_OFC_CD = 'NYCMW' OR SLS_OFC_CD = 'NYCME'" ).append("\n"); 
		query.append("                                     THEN (SELECT PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = (SELECT PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD))" ).append("\n"); 
		query.append("                                     ELSE NVL((SELECT N2ND_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD)," ).append("\n"); 
		query.append("                                              (SELECT RHQ_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = SLS_OFC_CD)) END AS SLS_RHQ_OFC" ).append("\n"); 
		query.append("                              , CASE WHEN CTRT_OFC_CD = 'NYCRA' OR CTRT_OFC_CD = 'HAMRU' OR CTRT_OFC_CD = 'SINRS' OR CTRT_OFC_CD = 'SHARC'" ).append("\n"); 
		query.append("                                     THEN SUBSTR(CTRT_OFC_CD, 1, 3)||'SC'" ).append("\n"); 
		query.append("                                     ELSE NVL((SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = CTRT_OFC_CD)," ).append("\n"); 
		query.append("                                              (SELECT RGN_OFC_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = CTRT_OFC_CD)) END AS CTRT_RGN_OFC" ).append("\n"); 
		query.append("                              , CASE WHEN SLS_OFC_CD = 'NYCRA' OR SLS_OFC_CD = 'HAMRU' OR SLS_OFC_CD = 'SINRS' OR SLS_OFC_CD = 'SHARC'" ).append("\n"); 
		query.append("                                     THEN SUBSTR(SLS_OFC_CD, 1, 3)||'SC' WHEN SLS_OFC_CD = 'NYCMW' OR SLS_OFC_CD = 'NYCME'" ).append("\n"); 
		query.append("                                     THEN NVL((SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = (SELECT PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD))," ).append("\n"); 
		query.append("                                              (SELECT RGN_OFC_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = SLS_OFC_CD ))" ).append("\n"); 
		query.append("                                     ELSE NVL((SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD)," ).append("\n"); 
		query.append("                                              (SELECT RGN_OFC_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = SLS_OFC_CD)) END AS SLS_RGN_OFC" ).append("\n"); 
		query.append("                              , CTRT_OFC_CD" ).append("\n"); 
		query.append("                              , SLS_OFC_CD" ).append("\n"); 
		query.append("                              , DECODE(SUBSTR(CNTR_TPSZ_CD, -1), '2', BKG_QTY, BKG_QTY * 2) AS LOD_QTY" ).append("\n"); 
		query.append("                              , (RA_CM_COST_TTL_AMT - DMDT_COM_AMT) AS RA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                              , (PA_CM_COST_TTL_AMT - DMDT_COM_AMT) AS PA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                           FROM MAS_BKG_EXPN_DTL_WK" ).append("\n"); 
		query.append("                          WHERE SUBSTR(SLS_YRMON, 1, 4)||COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                            AND TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                            AND RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                            AND DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                            AND DELT_FLG     = 'N'" ).append("\n"); 
		query.append("                            AND BKG_STS_CD    IN ('F', 'S', 'W')" ).append("\n"); 
		query.append("                            AND BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                            AND BL_NO_TP      IN ('M', '0')" ).append("\n"); 
		query.append("                        ) T" ).append("\n"); 
		query.append("                      , SQM_QTA_LANE_OFC S" ).append("\n"); 
		query.append("                      , SQM_QTA_LANE_OFC_COST C" ).append("\n"); 
		query.append("                  WHERE S.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                    AND S.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                    AND S.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                    AND S.OFC_VW_CD  = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("                    AND S.RHQ_CD     = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("                    AND S.RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                    AND S.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                    AND S.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                    AND S.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    AND T.TRD_CD        = S.TRD_CD" ).append("\n"); 
		query.append("                    AND T.RLANE_CD      = S.RLANE_CD" ).append("\n"); 
		query.append("                    AND T.DIR_CD        = S.DIR_CD" ).append("\n"); 
		query.append("                    AND T.CTRT_RGN_OFC  = DECODE(S.OFC_VW_CD, 'C', S.RGN_OFC_CD, T.CTRT_RGN_OFC)" ).append("\n"); 
		query.append("                    AND T.SLS_RGN_OFC   = DECODE(S.OFC_VW_CD, 'L', S.RGN_OFC_CD, T.SLS_RGN_OFC)" ).append("\n"); 
		query.append("                    AND T.CTRT_RHQ_OFC  = DECODE(S.OFC_VW_CD, 'C', S.RHQ_CD, T.CTRT_RHQ_OFC)" ).append("\n"); 
		query.append("                    AND T.SLS_RHQ_OFC   = DECODE(S.OFC_VW_CD, 'L', S.RHQ_CD, T.SLS_RHQ_OFC)" ).append("\n"); 
		query.append("                    AND T.CTRT_RHQ_OFC IS NOT NULL" ).append("\n"); 
		query.append("                    AND T.SLS_RHQ_OFC  IS NOT NULL" ).append("\n"); 
		query.append("                    AND S.SQM_ACT_FLG   = 'Y'" ).append("\n"); 
		query.append("                    AND S.BSE_TP_CD     = C.BSE_TP_CD" ).append("\n"); 
		query.append("                    AND S.BSE_YR        = C.BSE_YR" ).append("\n"); 
		query.append("                    AND S.BSE_QTR_CD    = C.BSE_QTR_CD" ).append("\n"); 
		query.append("                    AND S.OFC_VW_CD     = C.OFC_VW_CD" ).append("\n"); 
		query.append("                    AND T.TRD_CD        = C.TRD_CD" ).append("\n"); 
		query.append("                    AND T.RLANE_CD      = C.RLANE_CD" ).append("\n"); 
		query.append("                    AND T.DIR_CD        = C.DIR_CD" ).append("\n"); 
		query.append("                    AND T.CTRT_RGN_OFC  = DECODE(S.OFC_VW_CD, 'C', C.RGN_OFC_CD, T.CTRT_RGN_OFC)" ).append("\n"); 
		query.append("                    AND T.SLS_RGN_OFC   = DECODE(S.OFC_VW_CD, 'L', C.RGN_OFC_CD, T.SLS_RGN_OFC)" ).append("\n"); 
		query.append("                    AND T.CTRT_RHQ_OFC  = DECODE(S.OFC_VW_CD, 'C', C.RHQ_CD, T.CTRT_RHQ_OFC)" ).append("\n"); 
		query.append("                    AND T.SLS_RHQ_OFC   = DECODE(S.OFC_VW_CD, 'L', C.RHQ_CD, T.SLS_RHQ_OFC)" ).append("\n"); 
		query.append("                    AND C.PA_CM_UC_AMT  = 0" ).append("\n"); 
		query.append("                    AND C.RA_CM_UC_AMT  = 0" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          WHERE DECODE(OFC_VW_CD, 'C', CTRT_RHQ_OFC, 'L', SLS_RHQ_OFC) IS NOT NULL" ).append("\n"); 
		query.append("       GROUP BY BSE_TP_CD" ).append("\n"); 
		query.append("              , BSE_YR" ).append("\n"); 
		query.append("              , BSE_QTR_CD" ).append("\n"); 
		query.append("              , OFC_VW_CD" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , DECODE(OFC_VW_CD, 'C', CTRT_RGN_OFC, 'L', SLS_RGN_OFC)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")   CST" ).append("\n"); 
		query.append("    ON (   QTA.BSE_TP_CD                  = CST.BSE_TP_CD" ).append("\n"); 
		query.append("       AND QTA.BSE_YR                     = CST.BSE_YR" ).append("\n"); 
		query.append("       AND QTA.BSE_QTR_CD                 = CST.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND QTA.OFC_VW_CD                  = CST.OFC_VW_CD" ).append("\n"); 
		query.append("       AND QTA.TRD_CD                     = CST.TRD_CD" ).append("\n"); 
		query.append("       AND QTA.RLANE_CD                   = CST.RLANE_CD" ).append("\n"); 
		query.append("       AND QTA.DIR_CD                     = CST.DIR_CD" ).append("\n"); 
		query.append("       AND QTA.RGN_OFC_CD                 = CST.RGN_OFC_CD" ).append("\n"); 
		query.append("       AND QTA.QTA_TGT_CD                 = 'D'" ).append("\n"); 
		query.append("       AND SUBSTR(QTA.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("       SET QTA.PA_CM_UC_AMT = CST.PA_CM_UC_AMT" ).append("\n"); 
		query.append("         , QTA.RA_CM_UC_AMT = CST.RA_CM_UC_AMT" ).append("\n"); 
		query.append("         , QTA.UPD_USR_ID   = @[f_usr_id]" ).append("\n"); 
		query.append("         , QTA.UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}