/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchQtaAdjustmentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOSearchQtaAdjustmentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * QTA Adjustment by VVD 정보를 조회합니다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchQtaAdjustmentListRSQL(){
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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_portion_link",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchQtaAdjustmentListRSQL").append("\n"); 
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
		query.append("SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD " ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,IOC_CD" ).append("\n"); 
		query.append("        ,BSE_MON" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,DECODE(NVL(CSQ_CNG_TP_CD, 'I'), 'I', 'Y', 'N') AS POTN_LNK" ).append("\n"); 
		query.append("        ,CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,LOD_QTY" ).append("\n"); 
		query.append("        ,GRS_REV" ).append("\n"); 
		query.append("        ,COA_BSE_MON" ).append("\n"); 
		query.append("        ,COA_BSE_WK" ).append("\n"); 
		query.append("        ,COA_VVD" ).append("\n"); 
		query.append("        ,COA_FNL_BSA_CAPA" ).append("\n"); 
		query.append("--        ,DECODE(FLAG, 'U', LOD_QTY, NULL) AS COA_LOD_QTY" ).append("\n"); 
		query.append("--        ,DECODE(FLAG, 'U', GRS_REV, NULL) AS COA_GRS_REV" ).append("\n"); 
		query.append("        -- BSA가 변경되었을 때 이전의 L/F를 구해서 변경된 BSA 곱해서 변경되어야 하는 물량과 REV를 보여준다." ).append("\n"); 
		query.append("        ,DECODE(FLAG, 'U', DECODE(COA_FNL_BSA_CAPA, FNL_BSA_CAPA, LOD_QTY" ).append("\n"); 
		query.append("                                                                , DECODE(NVL(CSQ_CNG_TP_CD, 'I'), 'I', round(COA_FNL_BSA_CAPA * round(decode(FNL_BSA_CAPA, 0, 0, LOD_QTY/FNL_BSA_CAPA),4)), LOD_QTY)" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                         , NULL) AS COA_LOD_QTY" ).append("\n"); 
		query.append("        ,DECODE(FLAG, 'U', DECODE(COA_FNL_BSA_CAPA, FNL_BSA_CAPA, GRS_REV" ).append("\n"); 
		query.append("                                                                ,DECODE(NVL(CSQ_CNG_TP_CD, 'I'), 'I', round(COA_FNL_BSA_CAPA * round(decode(FNL_BSA_CAPA, 0, 0, LOD_QTY/FNL_BSA_CAPA),4))* round(decode(LOD_QTY, 0, 0, GRS_REV/LOD_QTY)), GRS_REV)" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                         , NULL) AS COA_GRS_REV" ).append("\n"); 
		query.append("        ,CASE" ).append("\n"); 
		query.append("              -- BSA 변경 부분을 제일 먼저 체크되어야 함" ).append("\n"); 
		query.append("              -- BSA 변경시  PORTION 이 끊어지고 BSA가 0인 경우를 제외하고 상태를 R로 함(즉 단순 스케줄 업데이트만 가능하도록 함)" ).append("\n"); 
		query.append("              WHEN FLAG = 'U' AND FNL_BSA_CAPA <> COA_FNL_BSA_CAPA THEN DECODE(NVL(CSQ_CNG_TP_CD, 'I'), 'I', 'B', DECODE(COA_FNL_BSA_CAPA, 0, 'B','R')) " ).append("\n"); 
		query.append("              WHEN FLAG = 'U' AND BSE_MON      <> COA_BSE_MON      THEN 'M'" ).append("\n"); 
		query.append("              WHEN FLAG = 'U' AND BSE_WK       <> COA_BSE_WK       THEN 'W'" ).append("\n"); 
		query.append("                                                                   ELSE FLAG" ).append("\n"); 
		query.append("         END AS STS_FLAG" ).append("\n"); 
		query.append("         -- BSA가 0으로 되는 경우는 상태를 R로 변경하여 단순 스케줄 업데이트를 막고" ).append("\n"); 
		query.append("         -- 화면에서 VVD SELECT를 통하여 처리할 수 있도록 함" ).append("\n"); 
		query.append("        ,DECODE(FLAG, 'U', DECODE(COA_FNL_BSA_CAPA, 0, 'R', FLAG), FLAG) AS FLAG" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("           SELECT O_QTA_RLSE_VER_NO  AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                 ,O_TRD_CD           AS TRD_CD" ).append("\n"); 
		query.append("                 ,O_RLANE_CD         AS RLANE_CD" ).append("\n"); 
		query.append("                 ,O_SUB_TRD_CD       AS SUB_TRD_CD" ).append("\n"); 
		query.append("                 ,O_DIR_CD           AS DIR_CD" ).append("\n"); 
		query.append("                 ,O_IOC_CD           AS IOC_CD" ).append("\n"); 
		query.append("                 ,O_VVD" ).append("\n"); 
		query.append("                 ,MAX(BSE_MON)       AS BSE_MON" ).append("\n"); 
		query.append("                 ,MAX(BSE_WK)        AS BSE_WK" ).append("\n"); 
		query.append("                 ,MAX(VVD)           AS VVD" ).append("\n"); 
		query.append("                 ,MAX(CSQ_CNG_TP_CD) AS CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("                 ,MAX(FNL_BSA_CAPA)  AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("                 ,MAX(LOD_QTY)       AS LOD_QTY" ).append("\n"); 
		query.append("                 ,MAX(GRS_REV)       AS GRS_REV" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(CSQ_INFO, '*') = NVL(COA_INFO, '*') THEN '' ELSE SLS_MON                END) AS COA_BSE_MON" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(CSQ_INFO, '*') = NVL(COA_INFO, '*') THEN '' ELSE COST_WK                END) AS COA_BSE_WK" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(CSQ_INFO, '*') = NVL(COA_INFO, '*') THEN '' ELSE COA_VVD                END) AS COA_VVD" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(CSQ_INFO, '*') = NVL(COA_INFO, '*') THEN '' ELSE FNL_CO_BSA_CAPA || '' END) AS COA_FNL_BSA_CAPA" ).append("\n"); 
		query.append("                 ,CASE WHEN MAX(CSQ_INFO) = MAX(COA_INFO) THEN 'R'" ).append("\n"); 
		query.append("                       WHEN NVL(MAX(CSQ_INFO), '*') = '*' THEN 'I'" ).append("\n"); 
		query.append("                       WHEN NVL(MAX(COA_INFO), '*') = '*' THEN 'D'" ).append("\n"); 
		query.append("                                                          ELSE 'U'" ).append("\n"); 
		query.append("                  END AS FLAG" ).append("\n"); 
		query.append("                 ,MAX(CSQ_INFO) AS CSQ_INFO" ).append("\n"); 
		query.append("                 ,MAX(COA_INFO) AS COA_INFO" ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("                     SELECT B1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                           ,B1.TRD_CD" ).append("\n"); 
		query.append("                           ,B1.DIR_CD" ).append("\n"); 
		query.append("                           ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("                           ,B1.RLANE_CD" ).append("\n"); 
		query.append("                           ,B1.BSE_MON" ).append("\n"); 
		query.append("                           ,B1.BSE_WK" ).append("\n"); 
		query.append("                           ,B1.VSL_CD || B1.SKD_VOY_NO || B1.DIR_CD AS VVD" ).append("\n"); 
		query.append("                           ,B1.CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("                           ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                           ,B1.LOD_QTY" ).append("\n"); 
		query.append("                           ,B1.GRS_REV" ).append("\n"); 
		query.append("                           ,SUBSTR(B2.SLS_YRMON, -2) AS SLS_MON" ).append("\n"); 
		query.append("                           ,B2.COST_WK" ).append("\n"); 
		query.append("                           ,B2.VSL_CD || B2.SKD_VOY_NO || B2.DIR_CD AS COA_VVD" ).append("\n"); 
		query.append("                           ,B2.FNL_CO_BSA_CAPA" ).append("\n"); 
		query.append("                           ,B1.TRD_CD || B1.SUB_TRD_CD || B1.RLANE_CD || B1.DIR_CD || B1.VSL_CD || B1.SKD_VOY_NO || B1.DIR_CD || B1.BSE_MON || B1.BSE_WK || B1.FNL_BSA_CAPA AS CSQ_INFO" ).append("\n"); 
		query.append("                           ,B2.TRD_CD || B2.SUB_TRD_CD || B2.RLANE_CD || B2.DIR_CD || B2.VSL_CD || B2.SKD_VOY_NO || B2.DIR_CD || SUBSTR(B2.SLS_YRMON,-2) || B2.COST_WK || B2.FNL_CO_BSA_CAPA AS COA_INFO" ).append("\n"); 
		query.append("                           ,NVL(B1.QTA_RLSE_VER_NO, B2.QTA_RLSE_VER_NO)       AS O_QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                           ,NVL(B1.TRD_CD         , B2.TRD_CD)                AS O_TRD_CD" ).append("\n"); 
		query.append("                           ,NVL(B1.RLANE_CD       , B2.RLANE_CD)              AS O_RLANE_CD" ).append("\n"); 
		query.append("                           ,NVL(B1.SUB_TRD_CD     , B2.SUB_TRD_CD)            AS O_SUB_TRD_CD" ).append("\n"); 
		query.append("                           ,NVL(B1.IOC_CD         , B2.IOC_CD)                AS O_IOC_CD" ).append("\n"); 
		query.append("                           ,NVL(B1.DIR_CD         , B2.DIR_CD)                AS O_DIR_CD" ).append("\n"); 
		query.append("                           ,NVL(B1.BSE_MON        , SUBSTR(B2.SLS_YRMON, -2)) AS O_BSE_MON" ).append("\n"); 
		query.append("                           ,NVL(B1.BSE_WK         , B2.COST_WK)               AS O_BSE_WK" ).append("\n"); 
		query.append("                           ,NVL(B1.VSL_CD || B1.SKD_VOY_NO || B1.DIR_CD, B2.VSL_CD || B2.SKD_VOY_NO || B2.DIR_CD) AS O_VVD" ).append("\n"); 
		query.append("                       FROM (" ).append("\n"); 
		query.append("                              SELECT " ).append("\n"); 
		query.append("                                     V.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                    ,V.TRD_CD" ).append("\n"); 
		query.append("                                    ,V.DIR_CD" ).append("\n"); 
		query.append("                                    ,V.SUB_TRD_CD" ).append("\n"); 
		query.append("                                    ,V.RLANE_CD" ).append("\n"); 
		query.append("                                    ,V.BSE_MON" ).append("\n"); 
		query.append("                                    ,V.BSE_WK" ).append("\n"); 
		query.append("                                    ,V.VSL_CD" ).append("\n"); 
		query.append("                                    ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    ,V.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                                    ,Q.LOD_QTY" ).append("\n"); 
		query.append("                                    ,Q.GRS_REV" ).append("\n"); 
		query.append("                                    ,V.IOC_CD" ).append("\n"); 
		query.append("                                    ,Q.CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("                                FROM CSQ_CFM_TGT_VVD V" ).append("\n"); 
		query.append("                                    ,(" ).append("\n"); 
		query.append("                                      SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                            ,TRD_CD" ).append("\n"); 
		query.append("                                            ,RLANE_CD" ).append("\n"); 
		query.append("                                            ,DIR_CD" ).append("\n"); 
		query.append("                                            ,VSL_CD" ).append("\n"); 
		query.append("                                            ,SKD_VOY_NO" ).append("\n"); 
		query.append("                                            ,SKD_DIR_CD" ).append("\n"); 
		query.append("                                            ,CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("                                            ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("                                            ,ROUND(SUM(LOD_QTY*GRS_RPB_REV)) AS GRS_REV" ).append("\n"); 
		query.append("                                        FROM CSQ_CFM_QTA" ).append("\n"); 
		query.append("                                       WHERE 1=1" ).append("\n"); 
		query.append("                                         AND QTA_RLSE_VER_NO = ( SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                                                   FROM CSQ_QTA_RLSE_VER" ).append("\n"); 
		query.append("                                                                  WHERE BSE_TP_CD      = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                                                    AND BSE_YR         = @[f_bse_yr]" ).append("\n"); 
		query.append("                                                                    AND BSE_QTR_CD     = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("                                                                    AND CSQ_VER_STS_CD = 'R' )" ).append("\n"); 
		query.append("                                         AND OFC_VW_CD       = 'L'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                                         AND TRD_CD          = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                         AND RLANE_CD        = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                         AND DIR_CD          = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                       GROUP BY QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                               ,TRD_CD" ).append("\n"); 
		query.append("                                               ,RLANE_CD" ).append("\n"); 
		query.append("                                               ,DIR_CD" ).append("\n"); 
		query.append("                                               ,VSL_CD" ).append("\n"); 
		query.append("                                               ,SKD_VOY_NO" ).append("\n"); 
		query.append("                                               ,SKD_DIR_CD" ).append("\n"); 
		query.append("                                               ,CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("                                     ) Q" ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("                                 AND V.QTA_RLSE_VER_NO = Q.QTA_RLSE_VER_NO(+)" ).append("\n"); 
		query.append("                                 AND V.TRD_CD          = Q.TRD_CD(+)" ).append("\n"); 
		query.append("                                 AND V.RLANE_CD        = Q.RLANE_CD(+)" ).append("\n"); 
		query.append("                                 AND V.DIR_CD          = Q.DIR_CD(+)" ).append("\n"); 
		query.append("                                 AND V.VSL_CD          = Q.VSL_CD(+)" ).append("\n"); 
		query.append("                                 AND V.SKD_VOY_NO      = Q.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                                 AND V.SKD_DIR_CD      = Q.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                 AND V.QTA_RLSE_VER_NO = SUBSTR(@[f_bse_yr],-2) ||@[f_bse_qtr_cd]||'02'" ).append("\n"); 
		query.append("                                 AND V.BSE_TP_CD       = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                 AND V.BSE_YR          = @[f_bse_yr]" ).append("\n"); 
		query.append("                                 AND V.BSE_QTR_CD      = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#if (${f_bse_wk} != '')" ).append("\n"); 
		query.append("                                 AND V.BSE_WK          = @[f_bse_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                                 AND V.TRD_CD          = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                 AND V.RLANE_CD        = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                 AND V.DIR_CD          = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            ) B1" ).append("\n"); 
		query.append("                            FULL OUTER JOIN" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                              SELECT " ).append("\n"); 
		query.append("                                     A3.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                    ,A1.TRD_CD" ).append("\n"); 
		query.append("                                    ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                                    ,A1.RLANE_CD" ).append("\n"); 
		query.append("                                    ,A1.DIR_CD" ).append("\n"); 
		query.append("                                    ,A1.VSL_CD" ).append("\n"); 
		query.append("                                    ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    ,A1.SLS_YRMON" ).append("\n"); 
		query.append("                                    ,A1.COST_WK" ).append("\n"); 
		query.append("                                    ,A1.IOC_CD" ).append("\n"); 
		query.append("                                    ,ROUND(NVL(A2.FNL_CO_BSA_CAPA, 0)) AS FNL_CO_BSA_CAPA" ).append("\n"); 
		query.append("                                FROM COA_MON_VVD       A1" ).append("\n"); 
		query.append("                                    ,BSA_VVD_MST       A2" ).append("\n"); 
		query.append("                                    ,(" ).append("\n"); 
		query.append("                                       SELECT DISTINCT" ).append("\n"); 
		query.append("                                              S1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                             ,S2.BSE_TP_CD" ).append("\n"); 
		query.append("                                             ,S2.BSE_YR" ).append("\n"); 
		query.append("                                             ,S2.BSE_QTR_CD" ).append("\n"); 
		query.append("                                             ,S2.TRD_CD" ).append("\n"); 
		query.append("                                             ,S2.RLANE_CD" ).append("\n"); 
		query.append("                                             ,S2.DIR_CD" ).append("\n"); 
		query.append("                                         FROM CSQ_QTA_RLSE_VER S1" ).append("\n"); 
		query.append("                                              -- 해당 분기의 SETTING 한 LANE의 정보를 걸어준다" ).append("\n"); 
		query.append("                                             ,(" ).append("\n"); 
		query.append("                                                SELECT " ).append("\n"); 
		query.append("                                                       A1.BSE_TP_CD" ).append("\n"); 
		query.append("                                                      ,A1.BSE_YR" ).append("\n"); 
		query.append("                                                      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                      ,A1.TRD_CD" ).append("\n"); 
		query.append("                                                      ,A1.RLANE_CD" ).append("\n"); 
		query.append("                                                      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                                                      ,NVL(A1.LANE_DIR_CD, A2.VSL_SLAN_DIR_CD) DIR_CD" ).append("\n"); 
		query.append("                                                FROM CSQ_QTA_LANE_MGMT A1, MDM_VSL_SVC_LANE_DIR A2" ).append("\n"); 
		query.append("                                                WHERE 1=1" ).append("\n"); 
		query.append("                                                AND A1.BSE_TP_CD            = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                                AND A1.BSE_YR               = @[f_bse_yr]" ).append("\n"); 
		query.append("                                                AND A1.BSE_QTR_CD           = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("                                                AND A1.CSQ_ACT_FLG          = 'Y'  -- FIX" ).append("\n"); 
		query.append("                                                AND A1.IAS_SCTR_FLG         = 'N'  -- Overall:N / Sector:Y" ).append("\n"); 
		query.append("                                                AND A2.DELT_FLG             = 'N'  -- FIX" ).append("\n"); 
		query.append("                                                AND SUBSTR(A1.RLANE_CD,0,3) = A2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                AND A2.VSL_SLAN_DIR_CD      = NVL(A1.LANE_DIR_CD, A2.VSL_SLAN_DIR_CD)" ).append("\n"); 
		query.append("                                              ) S2" ).append("\n"); 
		query.append("                                        WHERE 1=1" ).append("\n"); 
		query.append("                                          AND S1.BSE_TP_CD      = S2.BSE_TP_CD" ).append("\n"); 
		query.append("                                          AND S1.BSE_YR         = S2.BSE_YR" ).append("\n"); 
		query.append("                                          AND S1.BSE_QTR_CD     = S2.BSE_QTR_CD" ).append("\n"); 
		query.append("                                          AND S1.CSQ_VER_STS_CD = 'R'  -- FIX" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                                          AND S2.TRD_CD         = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                          AND S2.RLANE_CD       = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                          AND S2.DIR_CD         = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("								 ) A3" ).append("\n"); 
		query.append("                               WHERE A1.TRD_CD         = A2.TRD_CD     (+)" ).append("\n"); 
		query.append("                                 AND A1.RLANE_CD       = A2.RLANE_CD   (+)" ).append("\n"); 
		query.append("                                 AND A1.VSL_CD         = A2.VSL_CD     (+)" ).append("\n"); 
		query.append("                                 AND A1.SKD_VOY_NO     = A2.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("                                 AND A1.DIR_CD         = A2.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("                                 AND A1.IOC_CD         = A2.IOC_CD     (+)" ).append("\n"); 
		query.append("                                 AND A1.TRD_CD         = A3.TRD_CD" ).append("\n"); 
		query.append("                                 AND A1.RLANE_CD       = A3.RLANE_CD" ).append("\n"); 
		query.append("                                 AND A1.DIR_CD         = A3.DIR_CD" ).append("\n"); 
		query.append("#if (${f_bse_wk} != '')" ).append("\n"); 
		query.append("                                 AND A1.COST_WK        = @[f_bse_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                 AND A1.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                                 AND A1.IOC_CD         = DECODE(A1.RLANE_CD, 'RBCCO', 'I', A1.IOC_CD) -- RBCCO 노선은 IOC_CD = 'I' 인것만" ).append("\n"); 
		query.append("                                 AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN @[f_bse_yr]||@[f_fm_wk] AND @[f_bse_yr]||@[f_to_wk] " ).append("\n"); 
		query.append("                                 AND NOT EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                                                    FROM CSQ_QTA_TGT_VVD S1" ).append("\n"); 
		query.append("                                                   WHERE S1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                                     AND S1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                                                     AND S1.BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("                                                     AND S1.DELT_FLG   = 'Y'" ).append("\n"); 
		query.append("                                                     AND A1.TRD_CD     = S1.TRD_CD" ).append("\n"); 
		query.append("                                                     AND A1.RLANE_CD   = S1.RLANE_CD" ).append("\n"); 
		query.append("                                                     AND A1.VSL_CD     = S1.VSL_CD" ).append("\n"); 
		query.append("                                                     AND A1.SKD_VOY_NO = S1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                     AND A1.DIR_CD     = S1.DIR_CD" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                            ) B2" ).append("\n"); 
		query.append("                         ON B1.QTA_RLSE_VER_NO = B2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                        AND B1.TRD_CD          = B2.TRD_CD" ).append("\n"); 
		query.append("                        AND B1.SUB_TRD_CD      = B2.SUB_TRD_CD" ).append("\n"); 
		query.append("                        AND B1.DIR_CD          = B2.DIR_CD" ).append("\n"); 
		query.append("                        AND B1.RLANE_CD        = B2.RLANE_CD" ).append("\n"); 
		query.append("                        AND B1.IOC_CD          = B2.IOC_CD" ).append("\n"); 
		query.append("                        AND B1.VSL_CD          = B2.VSL_CD" ).append("\n"); 
		query.append("                        AND B1.SKD_VOY_NO      = B2.SKD_VOY_NO" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("         GROUP BY O_QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                 ,O_TRD_CD" ).append("\n"); 
		query.append("                 ,O_RLANE_CD" ).append("\n"); 
		query.append("                 ,O_SUB_TRD_CD" ).append("\n"); 
		query.append("                 ,O_DIR_CD" ).append("\n"); 
		query.append("                 ,O_IOC_CD" ).append("\n"); 
		query.append("                 ,O_VVD" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#if (${f_portion_link} != '' && ${f_portion_link} != 'All')" ).append("\n"); 
		query.append("   WHERE DECODE(CSQ_CNG_TP_CD, 'I', 'Y', 'N') = @[f_portion_link]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD " ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,NVL(COA_BSE_MON, BSE_MON)" ).append("\n"); 
		query.append("        ,NVL(BSE_WK, COA_BSE_WK)" ).append("\n"); 

	}
}