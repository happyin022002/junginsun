/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchQtaAdjustmentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.06.28 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
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
	  * 
	  * * History
	  * 2016.02.25 최성민 [CHM-201640193] QTA Adjustment bu VVD와 QTA Adjustment by VVD for IAS Sector 에서 Target VVD 바라보는 것을 잠시 끊을 수 있도록 하는 로직 수정
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * 2016.06.28 [CHM-201642357] QTA Adjustment by VVD - Portion Connected 로직 수정
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
		params.put("f_dis_mas",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
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
		query.append("SELECT QTA_RLSE_VER_NO   " ).append("\n"); 
		query.append("        ,A2.TRD_CD" ).append("\n"); 
		query.append("        ,A2.RLANE_CD" ).append("\n"); 
		query.append("        ,A2.SUB_TRD_CD " ).append("\n"); 
		query.append("        ,A2.DIR_CD " ).append("\n"); 
		query.append("        ,DECODE(A1.HUL_BND_CD,'BH','B/H','H/H') HUL_BND_CD" ).append("\n"); 
		query.append("        ,A2.IOC_CD" ).append("\n"); 
		query.append("        ,BSE_MON" ).append("\n"); 
		query.append("        ,DECODE(BSE_MON,'','',20||SUBSTR(QTA_RLSE_VER_NO,0,2)||BSE_MON) BSE_YRMON" ).append("\n"); 
		query.append("        ,@[f_bse_yr]||@[f_bse_qtr_cd] AS REVENUE_QUARTER" ).append("\n"); 
		query.append("        ,A2.SLS_YR" ).append("\n"); 
		query.append("        ,A2.SLS_YRMON" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,DECODE(NVL(SQM_CNG_TP_CD, 'I'), 'I', 'Y', SQM_CNG_TP_CD) AS POTN_LNK" ).append("\n"); 
		query.append("        ,SQM_CNG_TP_CD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,LOD_QTY" ).append("\n"); 
		query.append("        ,GRS_REV" ).append("\n"); 
		query.append("        ,MAS_BSE_MON" ).append("\n"); 
		query.append("        ,DECODE(MAS_BSE_MON,'','',20||SUBSTR(QTA_RLSE_VER_NO,0,2)||MAS_BSE_MON) MAS_BSE_YRMON" ).append("\n"); 
		query.append("        ,MAS_COST_YR" ).append("\n"); 
		query.append("        ,MAS_COST_YRMON" ).append("\n"); 
		query.append("        ,MAS_BSE_WK" ).append("\n"); 
		query.append("        ,MAS_VVD" ).append("\n"); 
		query.append("        ,MAS_FNL_BSA_CAPA" ).append("\n"); 
		query.append("--        ,DECODE(FLAG, 'U', LOD_QTY, NULL) AS COA_LOD_QTY" ).append("\n"); 
		query.append("--        ,DECODE(FLAG, 'U', GRS_REV, NULL) AS COA_GRS_REV" ).append("\n"); 
		query.append("        -- BSA가 변경되었을 때 이전의 L/F를 구해서 변경된 BSA 곱해서 변경되어야 하는 물량과 REV를 보여준다." ).append("\n"); 
		query.append("        ,DECODE(FLAG, 'U', DECODE(MAS_FNL_BSA_CAPA, FNL_BSA_CAPA, LOD_QTY" ).append("\n"); 
		query.append("                                                                , DECODE(NVL(SQM_CNG_TP_CD, 'I'), 'I', round(MAS_FNL_BSA_CAPA * round(decode(FNL_BSA_CAPA, 0, 0, LOD_QTY/FNL_BSA_CAPA),4)), LOD_QTY)" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                         , NULL) AS MAS_LOD_QTY" ).append("\n"); 
		query.append("        ,DECODE(FLAG, 'U', DECODE(MAS_FNL_BSA_CAPA, FNL_BSA_CAPA, GRS_REV" ).append("\n"); 
		query.append("                                                                ,DECODE(NVL(SQM_CNG_TP_CD, 'I'), 'I', round(MAS_FNL_BSA_CAPA * round(decode(FNL_BSA_CAPA, 0, 0, LOD_QTY/FNL_BSA_CAPA),4))* round(decode(LOD_QTY, 0, 0, GRS_REV/LOD_QTY)), GRS_REV)" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                         , NULL) AS MAS_GRS_REV" ).append("\n"); 
		query.append("        ,CASE" ).append("\n"); 
		query.append("              -- BSA 변경 부분을 제일 먼저 체크되어야 함" ).append("\n"); 
		query.append("              -- BSA 변경시  PORTION 이 끊어지고 BSA가 0인 경우를 제외하고 상태를 R로 함(즉 단순 스케줄 업데이트만 가능하도록 함)" ).append("\n"); 
		query.append("              WHEN FLAG = 'U' AND FNL_BSA_CAPA <> MAS_FNL_BSA_CAPA THEN DECODE(NVL(SQM_CNG_TP_CD, 'I'), 'I', 'B', DECODE(MAS_FNL_BSA_CAPA, 0, 'B','R')) " ).append("\n"); 
		query.append("              WHEN FLAG = 'U' AND BSE_MON      <> MAS_BSE_MON      THEN 'M'" ).append("\n"); 
		query.append("              WHEN FLAG = 'U' AND BSE_WK       <> MAS_BSE_WK       THEN 'W'" ).append("\n"); 
		query.append("              WHEN FLAG = 'U' AND A2.SLS_YRMON    <> MAS_COST_YRMON THEN 'Y'" ).append("\n"); 
		query.append("                                                                   ELSE FLAG" ).append("\n"); 
		query.append("         END AS STS_FLAG" ).append("\n"); 
		query.append("         -- BSA가 0으로 되는 경우는 상태를 R로 변경하여 단순 스케줄 업데이트를 막고" ).append("\n"); 
		query.append("         -- 화면에서 VVD SELECT를 통하여 처리할 수 있도록 함" ).append("\n"); 
		query.append("        ,DECODE(FLAG, 'U', DECODE(MAS_FNL_BSA_CAPA, 0, 'R', FLAG), FLAG) AS FLAG" ).append("\n"); 
		query.append("        ,DECODE((SELECT MAS_MON_VVD.BSA_ZR_FLG " ).append("\n"); 
		query.append("            FROM MAS_MON_VVD " ).append("\n"); 
		query.append("            WHERE MAS_MON_VVD.TRD_CD = A2.TRD_CD" ).append("\n"); 
		query.append("                AND MAS_MON_VVD.RLANE_CD = A2.RLANE_CD" ).append("\n"); 
		query.append("                AND MAS_MON_VVD.SUB_TRD_CD = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("                AND MAS_MON_VVD.DIR_CD = A2.DIR_CD" ).append("\n"); 
		query.append("                AND MAS_MON_VVD.IOC_CD = A2.IOC_CD" ).append("\n"); 
		query.append("                AND MAS_MON_VVD.COST_YRMON = NVL(MAS_COST_YRMON,A2.SLS_YRMON) " ).append("\n"); 
		query.append("                AND MAS_MON_VVD.VSL_CD||MAS_MON_VVD.SKD_VOY_NO||MAS_MON_VVD.DIR_CD = NVL(MAS_VVD,VVD)), 'Y', 'Y', 'N', '', '') AS BSA_ZR_FLG" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    FROM MAS_LANE_RGST A1, " ).append("\n"); 
		query.append("		 (" ).append("\n"); 
		query.append("           SELECT O_QTA_RLSE_VER_NO  AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                 ,O_TRD_CD           AS TRD_CD" ).append("\n"); 
		query.append("                 ,O_RLANE_CD         AS RLANE_CD" ).append("\n"); 
		query.append("                 ,O_SUB_TRD_CD       AS SUB_TRD_CD" ).append("\n"); 
		query.append("                 ,O_DIR_CD           AS DIR_CD" ).append("\n"); 
		query.append("                 ,O_IOC_CD           AS IOC_CD" ).append("\n"); 
		query.append("                 ,O_VVD" ).append("\n"); 
		query.append("                 ,MAX(SLS_YR)        AS SLS_YR" ).append("\n"); 
		query.append("                 ,MAX(SLS_YRMON)     AS SLS_YRMON" ).append("\n"); 
		query.append("                 ,MAX(BSE_YR)        AS BSE_YR" ).append("\n"); 
		query.append("                 ,MAX(BSE_MON)       AS BSE_MON" ).append("\n"); 
		query.append("                 ,MAX(BSE_WK)        AS BSE_WK" ).append("\n"); 
		query.append("                 ,MAX(VVD)           AS VVD" ).append("\n"); 
		query.append("                 ,MAX(SQM_CNG_TP_CD) AS SQM_CNG_TP_CD" ).append("\n"); 
		query.append("                 ,MAX(FNL_BSA_CAPA)  AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("                 ,MAX(LOD_QTY)       AS LOD_QTY" ).append("\n"); 
		query.append("                 ,MAX(GRS_REV)       AS GRS_REV" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(SQM_INFO, '*') = NVL(MAS_INFO, '*') OR @[f_dis_mas] = 'Y' THEN '' ELSE MAS_COST_YR             END) AS MAS_COST_YR" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(SQM_INFO, '*') = NVL(MAS_INFO, '*') OR @[f_dis_mas] = 'Y' THEN '' ELSE MAS_COST_YRMON          END) AS MAS_COST_YRMON" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(SQM_INFO, '*') = NVL(MAS_INFO, '*') OR @[f_dis_mas] = 'Y' THEN '' ELSE MAS_MON                END) AS MAS_BSE_MON" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(SQM_INFO, '*') = NVL(MAS_INFO, '*') OR @[f_dis_mas] = 'Y' THEN '' ELSE COST_WK                END) AS MAS_BSE_WK" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(SQM_INFO, '*') = NVL(MAS_INFO, '*') OR @[f_dis_mas] = 'Y' THEN '' ELSE MAS_VVD                END) AS MAS_VVD" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(SQM_INFO, '*') = NVL(MAS_INFO, '*') OR @[f_dis_mas] = 'Y' THEN '' ELSE FNL_HJS_BSA_CAPA || '' END) AS MAS_FNL_BSA_CAPA" ).append("\n"); 
		query.append("                 ,CASE WHEN @[f_dis_mas] = 'Y' THEN 'R'" ).append("\n"); 
		query.append("                       WHEN MAX(SQM_INFO) = MAX(MAS_INFO) THEN 'R'" ).append("\n"); 
		query.append("                       WHEN NVL(MAX(SQM_INFO), '*') = '*' THEN 'I'" ).append("\n"); 
		query.append("                       WHEN NVL(MAX(MAS_INFO), '*') = '*' THEN 'D'" ).append("\n"); 
		query.append("                                                          ELSE 'U'" ).append("\n"); 
		query.append("                  END AS FLAG" ).append("\n"); 
		query.append("                 ,MAX(SQM_INFO) AS SQM_INFO" ).append("\n"); 
		query.append("                 ,MAX(MAS_INFO) AS MAS_INFO" ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("                     SELECT B1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                           ,B1.TRD_CD" ).append("\n"); 
		query.append("                           ,B1.DIR_CD" ).append("\n"); 
		query.append("                           ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("                           ,B1.RLANE_CD" ).append("\n"); 
		query.append("                           ,B1.BSE_YR" ).append("\n"); 
		query.append("                           ,B1.BSE_MON" ).append("\n"); 
		query.append("                           ,B1.BSE_WK" ).append("\n"); 
		query.append("                           ,B1.SLS_YRMON" ).append("\n"); 
		query.append("                           ,SUBSTR(B1.SLS_YRMON,0,4) AS SLS_YR" ).append("\n"); 
		query.append("                           ,B1.VSL_CD || B1.SKD_VOY_NO || B1.DIR_CD AS VVD" ).append("\n"); 
		query.append("                           ,B1.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("                           ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                           ,B1.LOD_QTY" ).append("\n"); 
		query.append("                           ,B1.GRS_REV" ).append("\n"); 
		query.append("                           ,B2.COST_YRMON AS MAS_COST_YRMON" ).append("\n"); 
		query.append("                           ,SUBSTR(B2.COST_YRMON,0,4) AS MAS_COST_YR" ).append("\n"); 
		query.append("                           ,SUBSTR(B2.YRMON, -2) AS MAS_MON" ).append("\n"); 
		query.append("                           ,B2.COST_WK" ).append("\n"); 
		query.append("                           ,B2.VSL_CD || B2.SKD_VOY_NO || B2.DIR_CD AS MAS_VVD" ).append("\n"); 
		query.append("                           ,B2.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("                           ,B1.TRD_CD || B1.SUB_TRD_CD || B1.RLANE_CD || B1.DIR_CD || B1.VSL_CD || B1.SKD_VOY_NO || B1.DIR_CD || B1.BSE_WK || B1.FNL_BSA_CAPA || B1.SLS_YRMON AS SQM_INFO" ).append("\n"); 
		query.append("                           ,B2.TRD_CD || B2.SUB_TRD_CD || B2.RLANE_CD || B2.DIR_CD || B2.VSL_CD || B2.SKD_VOY_NO || B2.DIR_CD || B2.COST_WK || B2.FNL_HJS_BSA_CAPA || B2.COST_YRMON AS MAS_INFO" ).append("\n"); 
		query.append("                           ,NVL(B1.QTA_RLSE_VER_NO, B2.QTA_RLSE_VER_NO)       AS O_QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                           ,NVL(B1.TRD_CD         , B2.TRD_CD)                AS O_TRD_CD" ).append("\n"); 
		query.append("                           ,NVL(B1.RLANE_CD       , B2.RLANE_CD)              AS O_RLANE_CD" ).append("\n"); 
		query.append("                           ,NVL(B1.SUB_TRD_CD     , B2.SUB_TRD_CD)            AS O_SUB_TRD_CD" ).append("\n"); 
		query.append("                           ,NVL(B1.IOC_CD         , B2.IOC_CD)                AS O_IOC_CD" ).append("\n"); 
		query.append("                           ,NVL(B1.DIR_CD         , B2.DIR_CD)                AS O_DIR_CD" ).append("\n"); 
		query.append("                           ,NVL(B1.BSE_MON        , SUBSTR(B2.YRMON, -2))     AS O_BSE_MON" ).append("\n"); 
		query.append("                           ,NVL(B1.BSE_WK         , B2.COST_WK)               AS O_BSE_WK" ).append("\n"); 
		query.append("                           ,NVL(B1.VSL_CD || B1.SKD_VOY_NO || B1.DIR_CD, B2.VSL_CD || B2.SKD_VOY_NO || B2.DIR_CD) AS O_VVD" ).append("\n"); 
		query.append("                       FROM (" ).append("\n"); 
		query.append("                              SELECT " ).append("\n"); 
		query.append("                                     V.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                    ,V.TRD_CD" ).append("\n"); 
		query.append("                                    ,V.DIR_CD" ).append("\n"); 
		query.append("                                    ,V.SUB_TRD_CD" ).append("\n"); 
		query.append("                                    ,V.RLANE_CD" ).append("\n"); 
		query.append("                                    ,V.BSE_YR" ).append("\n"); 
		query.append("                                    ,V.BSE_MON" ).append("\n"); 
		query.append("                                    ,V.BSE_WK" ).append("\n"); 
		query.append("                                    ,V.SLS_YRMON" ).append("\n"); 
		query.append("                                    ,V.VSL_CD" ).append("\n"); 
		query.append("                                    ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    ,V.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                                    ,Q.LOD_QTY" ).append("\n"); 
		query.append("                                    ,Q.GRS_REV" ).append("\n"); 
		query.append("                                    ,V.IOC_CD" ).append("\n"); 
		query.append("                                    ,Q.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("                                FROM SQM_CFM_TGT_VVD V" ).append("\n"); 
		query.append("                                    ,(" ).append("\n"); 
		query.append("                                      SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                            ,TRD_CD" ).append("\n"); 
		query.append("                                            ,RLANE_CD" ).append("\n"); 
		query.append("                                            ,DIR_CD" ).append("\n"); 
		query.append("                                            ,VSL_CD" ).append("\n"); 
		query.append("                                            ,SKD_VOY_NO" ).append("\n"); 
		query.append("                                            ,SKD_DIR_CD" ).append("\n"); 
		query.append("                                            ,SQM_CNG_TP_CD" ).append("\n"); 
		query.append("                                            ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("                                            ,ROUND(SUM(LOD_QTY*GRS_RPB_REV)) AS GRS_REV" ).append("\n"); 
		query.append("                                        FROM SQM_CFM_QTA" ).append("\n"); 
		query.append("                                       WHERE 1=1" ).append("\n"); 
		query.append("                                         AND QTA_RLSE_VER_NO = ( SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                                                   FROM SQM_QTA_RLSE_VER" ).append("\n"); 
		query.append("                                                                  WHERE BSE_TP_CD      = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                                                    AND BSE_YR         = @[f_bse_yr]" ).append("\n"); 
		query.append("                                                                    AND BSE_QTR_CD     = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("                                                                    AND SQM_VER_STS_CD = 'R' )" ).append("\n"); 
		query.append("                                         AND OFC_VW_CD       = 'L'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                                         AND TRD_CD          = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                         AND RLANE_CD        = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                         AND DIR_CD          = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                       GROUP BY QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                               ,TRD_CD" ).append("\n"); 
		query.append("                                               ,RLANE_CD" ).append("\n"); 
		query.append("                                               ,DIR_CD" ).append("\n"); 
		query.append("                                               ,VSL_CD" ).append("\n"); 
		query.append("                                               ,SKD_VOY_NO" ).append("\n"); 
		query.append("                                               ,SKD_DIR_CD" ).append("\n"); 
		query.append("                                               ,SQM_CNG_TP_CD" ).append("\n"); 
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
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                 AND V.DIR_CD          = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--    	                         AND 1 = CASE WHEN V.BSE_YR || v.BSE_QTR_CD > '20142Q'" ).append("\n"); 
		query.append("--                                                   THEN (SELECT NVL((" ).append("\n"); 
		query.append("--                                                                    SELECT DISTINCT 0" ).append("\n"); 
		query.append("--                                                                      FROM SQM_SCTR_PAIR_MGMT S1" ).append("\n"); 
		query.append("--                                                                     WHERE 1=1" ).append("\n"); 
		query.append("--                                                                       AND S1.BSE_TP_CD  = V.BSE_TP_CD" ).append("\n"); 
		query.append("--                                                                       AND S1.BSE_YR     = V.BSE_YR" ).append("\n"); 
		query.append("--                                                                       AND S1.BSE_QTR_CD = V.BSE_QTR_CD" ).append("\n"); 
		query.append("--                                                                       AND S1.TRD_CD     = V.TRD_CD" ).append("\n"); 
		query.append("--                                                                       AND S1.RLANE_CD   = V.RLANE_CD" ).append("\n"); 
		query.append("--                                                                       AND S1.DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("--                                                                    ),1)" ).append("\n"); 
		query.append("--                                                        FROM DUAL)" ).append("\n"); 
		query.append("--                                              ELSE 1" ).append("\n"); 
		query.append("--                                         END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            ) B1" ).append("\n"); 
		query.append("#if (${f_dis_mas} == 'Y')" ).append("\n"); 
		query.append("                            LEFT OUTER JOIN" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                            FULL OUTER JOIN" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                              SELECT " ).append("\n"); 
		query.append("                                     A3.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                    ,A1.TRD_CD" ).append("\n"); 
		query.append("                                    ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                                    ,A1.RLANE_CD" ).append("\n"); 
		query.append("                                    ,A1.DIR_CD" ).append("\n"); 
		query.append("                                    ,A1.VSL_CD" ).append("\n"); 
		query.append("                                    ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    ,A1.COST_YRMON" ).append("\n"); 
		query.append("                                    ,A1.COST_YRMON AS YRMON" ).append("\n"); 
		query.append("                                    ,A1.COST_WK" ).append("\n"); 
		query.append("                                    ,A1.IOC_CD" ).append("\n"); 
		query.append("                                    ,ROUND(NVL(A2.FNL_HJS_BSA_CAPA, 0)) AS FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("                                FROM MAS_MON_VVD       A1" ).append("\n"); 
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
		query.append("                                         FROM SQM_QTA_RLSE_VER S1" ).append("\n"); 
		query.append("#if (${f_cond_tp} == '1')" ).append("\n"); 
		query.append("                                              -- 해당 분기의 LANE-OFFICE RELATION SETTING 한 노선의 정보를 걸어준다" ).append("\n"); 
		query.append("                                              -- (2013년간 데이터를 제외한 모든 분기를 걸어주면됨 현재는 현재 분기와 미래 판매목표만 걸어주고 있음)" ).append("\n"); 
		query.append("                                             ,SQM_QTA_LANE_OFC S2" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                              -- 2013년도 데이터는  LANE-OFFICE RELATION SETTING 정보가 없기 때문에 TARGET VVD 정보를 걸어서 노선정보를 가져온다." ).append("\n"); 
		query.append("                                             ,SQM_CFM_TGT_VVD S2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                        WHERE 1=1" ).append("\n"); 
		query.append("                                          AND S1.BSE_TP_CD      = S2.BSE_TP_CD" ).append("\n"); 
		query.append("                                          AND S1.BSE_YR         = S2.BSE_YR" ).append("\n"); 
		query.append("                                          AND S1.BSE_QTR_CD     = S2.BSE_QTR_CD" ).append("\n"); 
		query.append("                                          AND S1.SQM_VER_STS_CD = 'R'" ).append("\n"); 
		query.append("                                          AND S2.BSE_TP_CD      = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                          AND S2.BSE_YR         = @[f_bse_yr]" ).append("\n"); 
		query.append("                                          AND S2.BSE_QTR_CD     = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#if (${f_cond_tp} == '1')" ).append("\n"); 
		query.append("                                          AND S2.OFC_VW_CD      = 'L'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                                          AND S2.TRD_CD         = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                          AND S2.RLANE_CD       = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                          AND S2.DIR_CD         = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--    	                                  AND 1 = CASE WHEN S2.BSE_YR || S2.BSE_QTR_CD > '20142Q'" ).append("\n"); 
		query.append("--                                                            THEN (SELECT NVL((" ).append("\n"); 
		query.append("--                                                                             SELECT 0" ).append("\n"); 
		query.append("--                                                                               FROM SQM_SCTR_PAIR_MGMT X1" ).append("\n"); 
		query.append("--                                                                              WHERE 1=1" ).append("\n"); 
		query.append("--                                                                                AND X1.BSE_TP_CD  = S2.BSE_TP_CD" ).append("\n"); 
		query.append("--                                                                                AND X1.BSE_YR     = S2.BSE_YR" ).append("\n"); 
		query.append("--                                                                                AND X1.BSE_QTR_CD = S2.BSE_QTR_CD" ).append("\n"); 
		query.append("--                                                                                AND X1.TRD_CD     = S2.TRD_CD" ).append("\n"); 
		query.append("--                                                                                AND X1.RLANE_CD   = S2.RLANE_CD" ).append("\n"); 
		query.append("--                                                                                AND X1.DIR_CD     = S2.DIR_CD" ).append("\n"); 
		query.append("--                                                                             ),1)" ).append("\n"); 
		query.append("--                                                                 FROM DUAL)" ).append("\n"); 
		query.append("--                                                       ELSE 1" ).append("\n"); 
		query.append("--                                                  END" ).append("\n"); 
		query.append("                                      ) A3" ).append("\n"); 
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
		query.append("                           		 -- 2013년 : SLS_YRMON / 2014년 : Week / 2015년~ : COST_YRMON (COA 이행 데이터 기준이 다름)" ).append("\n"); 
		query.append("                                 AND CASE WHEN '2013' = A3.BSE_YR THEN A1.COST_YRMON WHEN '2014' = A3.BSE_YR THEN SUBSTR(A1.COST_YRMON, 1, 4)||A1.COST_WK ELSE A1.COST_YRMON END " ).append("\n"); 
		query.append("                                     BETWEEN CASE WHEN '2014' = A3.BSE_YR THEN @[f_bse_yr]||@[f_fm_wk] ELSE @[f_bse_yr]||DECODE(@[f_bse_qtr_cd],'1Q','01','2Q','04','3Q','07','4Q','10') END " ).append("\n"); 
		query.append("                                         AND CASE WHEN '2014' = A3.BSE_YR THEN @[f_bse_yr]||@[f_to_wk] ELSE @[f_bse_yr]||DECODE(@[f_bse_qtr_cd],'1Q','03','2Q','06','3Q','09','4Q','12') END " ).append("\n"); 
		query.append("                                 AND NOT EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                                                    FROM SQM_QTA_TGT_VVD S1" ).append("\n"); 
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
		query.append("" ).append("\n"); 
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
		query.append("         )A2" ).append("\n"); 
		query.append("WHERE A1.TRD_CD         = A2.TRD_CD" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD       = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD         = A2.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD           = A2.DIR_CD" ).append("\n"); 
		query.append("AND A1.IOC_CD           = A2.IOC_CD" ).append("\n"); 
		query.append("#if (${f_portion_link} != '' && ${f_portion_link} != 'All')" ).append("\n"); 
		query.append("AND DECODE(SQM_CNG_TP_CD, 'I', 'Y', 'N') = @[f_portion_link]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.HUL_BND_CD               		 = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A2.TRD_CD" ).append("\n"); 
		query.append("        ,A2.RLANE_CD" ).append("\n"); 
		query.append("        ,A2.DIR_CD" ).append("\n"); 
		query.append("        ,NVL(SLS_YR,NVL(MAS_COST_YR, BSE_YR))" ).append("\n"); 
		query.append("        ,NVL(MAS_BSE_MON, BSE_MON)" ).append("\n"); 
		query.append("        ,NVL(MAS_BSE_WK, BSE_WK)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("History" ).append("\n"); 
		query.append("2013.12.27 이혜민 선조치 SQM 데이터 조회시 현재날짜와 조건날짜 비교하여 다른 테이블에서 조회되도록 수정" ).append("\n"); 
		query.append("2014.01.06 박은주 [CHM-201428374] QTA Adjustment by VVD 화면내 신규 칼럼 추가 및 Creation 로직 수정" ).append("\n"); 
		query.append("2014.06.19 박은주 확정데이터에 존재하지 않을경우 VVD가 누락되는경우 발생" ).append("\n"); 
		query.append("2014.07.10 이혜민 target vvd엔 데이터 존재하나 cfm_qta에 없을경우 데이터 누락되어 cfm_qta에 아우터조인걸어줌" ).append("\n"); 
		query.append("2015.02.06 이혜민 [CHM-201533807] COA 기준데이터를 2013년 : SLS_YRMON / 2014년 : Week / 2015년~ : COST_YRMON 로 수정 / 조회시 기준은 SLS_YR기준으로" ).append("\n"); 
		query.append("2015.02.17 이혜민 [CHM-201533941] VVD Adjust 관련 두 화면 내 Trade Direction 추가 " ).append("\n"); 
		query.append("2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청" ).append("\n"); 
		query.append("2015.08.13 김용습 [CHM-201537586] QTA Adjustment by VVD 화면내 BSA Flag 칼럼 추가" ).append("\n"); 
		query.append("2015.09.09 김용습 [CHM-201537818] QTA Adjustment by VVD, QTA Adjustment by VVD for IAS Sector 두 화면내 칼럼 수정" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}