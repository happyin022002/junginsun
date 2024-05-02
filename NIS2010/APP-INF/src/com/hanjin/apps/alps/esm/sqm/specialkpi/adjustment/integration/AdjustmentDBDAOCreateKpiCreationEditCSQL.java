/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AdjustmentDBDAOCreateKpiCreationEditCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOCreateKpiCreationEditCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateKpiCreationEdit
	  * </pre>
	  */
	public AdjustmentDBDAOCreateKpiCreationEditCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOCreateKpiCreationEditCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SPCL_CFM_QTA (" ).append("\n"); 
		query.append("         BSE_TP_CD" ).append("\n"); 
		query.append("        ,BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,SPCL_TGT_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,AQ_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,LOD_QTY" ).append("\n"); 
		query.append("        ,GRS_RPB_REV" ).append("\n"); 
		query.append("        ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,SQM_CNG_TP_CD" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT C1.BSE_TP_CD" ).append("\n"); 
		query.append("        ,C1.BSE_YR" ).append("\n"); 
		query.append("        ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,C1.SPCL_TGT_CD" ).append("\n"); 
		query.append("        ,C1.TRD_CD" ).append("\n"); 
		query.append("        ,C1.RLANE_CD" ).append("\n"); 
		query.append("        ,C1.DIR_CD" ).append("\n"); 
		query.append("        ,C1.VSL_CD" ).append("\n"); 
		query.append("        ,C1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,C1.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,C1.RGN_OFC_CD" ).append("\n"); 
		query.append("        ,C1.RHQ_CD" ).append("\n"); 
		query.append("        ,C1.AQ_CD" ).append("\n"); 
		query.append("        ,C1.CONV_DIR_CD" ).append("\n"); 
		query.append("        ,DECODE(C1.VVD_RNK, 1, C1.LOD_QTY + C1.DIFF_LOD, C1.LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("        ,RHQ_RPB as REV_RPB" ).append("\n"); 
		query.append("        ,C1.PA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,C1.RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,'I' AS SQM_CNG_TP_CD" ).append("\n"); 
		query.append("        ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE   AS CRE_DT" ).append("\n"); 
		query.append("        ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE   AS UPD_DT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT B2.BSE_TP_CD" ).append("\n"); 
		query.append("                  ,B2.BSE_YR" ).append("\n"); 
		query.append("                 ,B2.BSE_QTR_CD" ).append("\n"); 
		query.append("                  ,B2.SPCL_TGT_CD" ).append("\n"); 
		query.append("                  ,B2.TRD_CD" ).append("\n"); 
		query.append("                  ,B2.RLANE_CD" ).append("\n"); 
		query.append("                  ,B2.DIR_CD" ).append("\n"); 
		query.append("                  ,B1.VSL_CD" ).append("\n"); 
		query.append("                  ,B1.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,B1.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,B2.RGN_OFC_CD" ).append("\n"); 
		query.append("                  ,B2.RHQ_CD" ).append("\n"); 
		query.append("                  ,NVL((SELECT N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                      FROM SQM_ORGANIZATION_V V" ).append("\n"); 
		query.append("                     WHERE V.OFC_CD = B2.RGN_OFC_CD),'') AS AQ_CD" ).append("\n"); 
		query.append("                  ,B2.CONV_DIR_CD" ).append("\n"); 
		query.append("                  ,B1.BSE_WK" ).append("\n"); 
		query.append("                  ,DECODE(LOD_RNK, 1, B2.OFC_LOD + B2.DIFF_LOD, B2.OFC_LOD) AS OFC_LOD" ).append("\n"); 
		query.append("                  ,DECODE(B1.VVD_CNT, 0, 0, FLOOR(DECODE(LOD_RNK, 1, B2.OFC_LOD + B2.DIFF_LOD, B2.OFC_LOD)/B1.VVD_CNT)) AS LOD_QTY" ).append("\n"); 
		query.append("                  ,ROUND(DECODE(B1.VVD_CNT, 0, 0, MOD(DECODE(LOD_RNK, 1, B2.OFC_LOD + B2.DIFF_LOD, B2.OFC_LOD), B1.VVD_CNT))) AS DIFF_LOD" ).append("\n"); 
		query.append("                  ,B2.PA_CM_UC_AMT" ).append("\n"); 
		query.append("                  ,B2.RA_CM_UC_AMT" ).append("\n"); 
		query.append("                  ,B1.VVD_CNT" ).append("\n"); 
		query.append("                  ,B1.VVD_RNK" ).append("\n"); 
		query.append("                  ,B2.OFC_LOD AS OFC_LOD_ORG" ).append("\n"); 
		query.append("                  ,B2.RHQ_LOD" ).append("\n"); 
		query.append("                  ,B2.RHQ_REV" ).append("\n"); 
		query.append("                  ,b2.RHQ_RPB" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                      SELECT BSE_TP_CD" ).append("\n"); 
		query.append("                            ,BSE_YR" ).append("\n"); 
		query.append("                            ,BSE_QTR_CD" ).append("\n"); 
		query.append("                            ,TRD_CD" ).append("\n"); 
		query.append("                            ,RLANE_CD" ).append("\n"); 
		query.append("                            ,DIR_CD" ).append("\n"); 
		query.append("                            ,VSL_CD" ).append("\n"); 
		query.append("                            ,SKD_VOY_NO" ).append("\n"); 
		query.append("                            ,SKD_DIR_CD" ).append("\n"); 
		query.append("                            ,BSE_MON" ).append("\n"); 
		query.append("                            ,BSE_WK" ).append("\n"); 
		query.append("                            ,SUB_TRD_CD" ).append("\n"); 
		query.append("                            ,IOC_CD" ).append("\n"); 
		query.append("                            ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("                            ,COUNT(*) OVER (PARTITION BY BSE_TP_CD,BSE_YR,BSE_QTR_CD,TRD_CD,RLANE_CD,DIR_CD) AS VVD_CNT" ).append("\n"); 
		query.append("                            ,DENSE_RANK() OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, TRD_CD, RLANE_CD, DIR_CD ORDER BY BSE_WK, VSL_CD, SKD_VOY_NO) AS VVD_RNK" ).append("\n"); 
		query.append("                        FROM SQM_SPCL_TGT_VVD" ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                         AND BSE_TP_CD  = @[f_bse_tp_cd]  -- Q, Y 필수" ).append("\n"); 
		query.append("                         AND BSE_YR     = @[f_bse_yr]     -- 필수" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("                         AND BSE_QTR_CD = @[f_bse_qtr_cd] -- Quartely일때 필수" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   ) B1" ).append("\n"); 
		query.append("                  ,(" ).append("\n"); 
		query.append("                      SELECT A2.BSE_TP_CD" ).append("\n"); 
		query.append("                            ,A2.BSE_YR" ).append("\n"); 
		query.append("                            ,A2.BSE_QTR_CD" ).append("\n"); 
		query.append("                            ,A2.SPCL_TGT_CD" ).append("\n"); 
		query.append("                            ,A2.TRD_CD" ).append("\n"); 
		query.append("                            ,A2.RLANE_CD" ).append("\n"); 
		query.append("                            ,A2.DIR_CD" ).append("\n"); 
		query.append("                            ,A2.CONV_DIR_CD" ).append("\n"); 
		query.append("                            ,A2.RGN_OFC_CD" ).append("\n"); 
		query.append("                            ,A2.RHQ_CD" ).append("\n"); 
		query.append("                            ,NVL(ROUND(A1.RHQ_LOD * A2.LOD_POTN_RTO/100),0) AS OFC_LOD" ).append("\n"); 
		query.append("                            ,A2.PA_CM_UC_AMT" ).append("\n"); 
		query.append("                            ,A2.RA_CM_UC_AMT" ).append("\n"); 
		query.append("                            ,A1.RHQ_LOD" ).append("\n"); 
		query.append("                            ,A1.RHQ_REV" ).append("\n"); 
		query.append("                            ,A1.RHQ_RPB" ).append("\n"); 
		query.append("                            ,NVL(A1.RHQ_LOD - SUM(ROUND(A1.RHQ_LOD * A2.LOD_POTN_RTO/100)) OVER (PARTITION BY A2.BSE_TP_CD, A2.BSE_YR, A2.BSE_QTR_CD, A2.TRD_CD, A2.RLANE_CD, A2.DIR_CD, A2.RHQ_CD),0)     AS DIFF_LOD" ).append("\n"); 
		query.append("                            ,ROW_NUMBER() OVER (PARTITION BY A2.BSE_TP_CD, A2.BSE_YR, A2.BSE_QTR_CD, A2.TRD_CD, A2.RLANE_CD, A2.DIR_CD, A2.RHQ_CD ORDER BY A2.LOD_POTN_RTO DESC, A2.RGN_OFC_CD) AS LOD_RNK" ).append("\n"); 
		query.append("                            ,A2.LOD_POTN_RTO/100 AS LOD_POTN_RTO" ).append("\n"); 
		query.append("                            ,A2.REV_POTN_RTO/100 AS REV_POTN_RTO" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                              SELECT BSE_TP_CD" ).append("\n"); 
		query.append("                                    ,BSE_YR" ).append("\n"); 
		query.append("                                    ,BSE_QTR_CD" ).append("\n"); 
		query.append("                                    ,SPCL_TGT_CD" ).append("\n"); 
		query.append("                                    ,TRD_CD" ).append("\n"); 
		query.append("                                    ,RLANE_CD" ).append("\n"); 
		query.append("                                    ,DIR_CD" ).append("\n"); 
		query.append("                                    ,RHQ_CD" ).append("\n"); 
		query.append("                                    ,LOD_QTY AS RHQ_LOD" ).append("\n"); 
		query.append("                                    ,LOD_QTY * GRS_RPB_REV  AS RHQ_REV" ).append("\n"); 
		query.append("                                    ,GRS_RPB_REV AS RHQ_RPB" ).append("\n"); 
		query.append("                                FROM SQM_SPCL_LOD_REV" ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("                                 AND BSE_TP_CD   = @[f_bse_tp_cd]  -- Q, Y 필수" ).append("\n"); 
		query.append("                                 AND BSE_YR      = @[f_bse_yr]     -- 필수" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("                                 AND BSE_QTR_CD  = @[f_bse_qtr_cd]   -- Quartely일때 필수" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                 AND SPCL_TGT_CD = @[f_spcl_tgt_cd]  -- S, R 필수 " ).append("\n"); 
		query.append("                             )  A1" ).append("\n"); 
		query.append("                            ,SQM_SPCL_LANE_OFC_COST A2" ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                         AND A2.BSE_TP_CD   = A1.BSE_TP_CD   (+)" ).append("\n"); 
		query.append("                         AND A2.BSE_YR      = A1.BSE_YR      (+)" ).append("\n"); 
		query.append("                         AND A2.BSE_QTR_CD  = A1.BSE_QTR_CD  (+)" ).append("\n"); 
		query.append("                         AND A2.SPCL_TGT_CD = A1.SPCL_TGT_CD (+)" ).append("\n"); 
		query.append("                         AND A2.TRD_CD      = A1.TRD_CD      (+)" ).append("\n"); 
		query.append("                         AND A2.RLANE_CD    = A1.RLANE_CD    (+)" ).append("\n"); 
		query.append("                         AND A2.DIR_CD      = A1.DIR_CD      (+)" ).append("\n"); 
		query.append("                         AND A2.RHQ_CD      = A1.RHQ_CD      (+)" ).append("\n"); 
		query.append("                         AND A2.BSE_TP_CD   = @[f_bse_tp_cd]  -- Q, Y 필수" ).append("\n"); 
		query.append("                         AND A2.BSE_YR      = @[f_bse_yr]     -- 필수" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("                         AND A2.BSE_QTR_CD  = @[f_bse_qtr_cd]   -- Quartely일때 필수" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         AND A2.SPCL_TGT_CD = @[f_spcl_tgt_cd]  -- S, R 필수" ).append("\n"); 
		query.append("                    ORDER BY BSE_QTR_CD" ).append("\n"); 
		query.append("                            ,TRD_CD" ).append("\n"); 
		query.append("                            ,RLANE_CD" ).append("\n"); 
		query.append("                            ,DIR_CD" ).append("\n"); 
		query.append("                            ,RHQ_CD" ).append("\n"); 
		query.append("                            ,RGN_OFC_CD" ).append("\n"); 
		query.append("                   ) B2" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND B2.BSE_TP_CD  = B1.BSE_TP_CD" ).append("\n"); 
		query.append("               AND B2.BSE_YR     = B1.BSE_YR" ).append("\n"); 
		query.append("               AND B2.BSE_QTR_CD = B1.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND B2.TRD_CD     = B1.TRD_CD" ).append("\n"); 
		query.append("               AND B2.RLANE_CD   = B1.RLANE_CD" ).append("\n"); 
		query.append("               AND B2.DIR_CD     = B1.DIR_CD" ).append("\n"); 
		query.append("         ) C1" ).append("\n"); 
		query.append("ORDER BY BSE_QTR_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 

	}
}