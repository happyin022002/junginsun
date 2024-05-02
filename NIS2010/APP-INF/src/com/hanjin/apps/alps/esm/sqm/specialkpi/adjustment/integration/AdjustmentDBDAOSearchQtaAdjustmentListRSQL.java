/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AdjustmentDBDAOSearchQtaAdjustmentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.18 
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

public class AdjustmentDBDAOSearchQtaAdjustmentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SKD Adjustment by VVD 정보를 조회합니다.
	  * 
	  * * History
	  * 2014.01.02 이혜민 [CHM-201328060-01] SQM 데이터 조회시 현재날짜와 조건날짜 비교하여 다른 테이블에서 조회되도록 수정
	  * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2015.11.06 김용습 [CHM-201538494] [CSR 전환건] SKD Adjustment by VVD 화면 보완 (Trade Direction, Adjusting VVD Select, BSA Flag 칼럼 추가) 
	  * </pre>
	  */
	public AdjustmentDBDAOSearchQtaAdjustmentListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOSearchQtaAdjustmentListRSQL").append("\n"); 
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
		query.append("SELECT A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,DECODE(MAS.HUL_BND_CD,'BH','B/H','H/H') HUL_BND_CD" ).append("\n"); 
		query.append("      ,A1.IOC_CD" ).append("\n"); 
		query.append("      ,A1.BSE_MON" ).append("\n"); 
		query.append("      ,A1.BSE_WK" ).append("\n"); 
		query.append("      ,A1.VVD" ).append("\n"); 
		query.append("      ,A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,A1.MAS_BSE_MON" ).append("\n"); 
		query.append("      ,A1.MAS_BSE_WK" ).append("\n"); 
		query.append("      ,A1.MAS_VVD" ).append("\n"); 
		query.append("      ,A1.MAS_FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,CASE" ).append("\n"); 
		query.append("            WHEN A1.FLAG = 'U' AND A1.FNL_BSA_CAPA <> A1.MAS_FNL_BSA_CAPA THEN 'B'" ).append("\n"); 
		query.append("            WHEN A1.FLAG = 'U' AND A1.BSE_MON      <> A1.MAS_BSE_MON      THEN 'M'" ).append("\n"); 
		query.append("            WHEN A1.FLAG = 'U' AND A1.BSE_WK       <> A1.MAS_BSE_WK       THEN 'W'" ).append("\n"); 
		query.append("                                                                 ELSE A1.FLAG" ).append("\n"); 
		query.append("       END AS STS_FLAG" ).append("\n"); 
		query.append("      ,A1.FLAG" ).append("\n"); 
		query.append("      ,DECODE((SELECT MAS_MON_VVD.BSA_ZR_FLG " ).append("\n"); 
		query.append("            FROM MAS_MON_VVD " ).append("\n"); 
		query.append("            WHERE MAS_MON_VVD.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("                AND MAS_MON_VVD.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("                AND MAS_MON_VVD.SUB_TRD_CD = A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                AND MAS_MON_VVD.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("                AND MAS_MON_VVD.IOC_CD = A1.IOC_CD" ).append("\n"); 
		query.append("--                AND MAS_MON_VVD.COST_YRMON = NVL(MAS_COST_YRMON, A1.SLS_YRMON) " ).append("\n"); 
		query.append("                AND MAS_MON_VVD.VSL_CD||MAS_MON_VVD.SKD_VOY_NO||MAS_MON_VVD.DIR_CD = NVL(MAS_VVD,VVD)), 'Y', 'Y', 'N', '', '') AS BSA_ZR_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("           SELECT O_TRD_CD          AS TRD_CD" ).append("\n"); 
		query.append("                 ,O_RLANE_CD        AS RLANE_CD" ).append("\n"); 
		query.append("                 ,O_SUB_TRD_CD      AS SUB_TRD_CD" ).append("\n"); 
		query.append("                 ,O_DIR_CD          AS DIR_CD" ).append("\n"); 
		query.append("                 ,O_IOC_CD          AS IOC_CD" ).append("\n"); 
		query.append("                 ,O_VVD" ).append("\n"); 
		query.append("                 ,MAX(BSE_MON)      AS BSE_MON" ).append("\n"); 
		query.append("                 ,MAX(BSE_WK)       AS BSE_WK" ).append("\n"); 
		query.append("                 ,MAX(VVD)          AS VVD" ).append("\n"); 
		query.append("                 ,MAX(FNL_BSA_CAPA) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(SQM_INFO, '*') = NVL(MAS_INFO, '*') THEN '' ELSE SLS_MON                END) AS MAS_BSE_MON" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(SQM_INFO, '*') = NVL(MAS_INFO, '*') THEN '' ELSE COST_WK                END) AS MAS_BSE_WK" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(SQM_INFO, '*') = NVL(MAS_INFO, '*') THEN '' ELSE MAS_VVD                END) AS MAS_VVD" ).append("\n"); 
		query.append("                 ,MAX(CASE WHEN NVL(SQM_INFO, '*') = NVL(MAS_INFO, '*') THEN '' ELSE FNL_HJS_BSA_CAPA || '' END) AS MAS_FNL_BSA_CAPA" ).append("\n"); 
		query.append("                 ,CASE WHEN MAX(SQM_INFO) = MAX(MAS_INFO) THEN 'R'" ).append("\n"); 
		query.append("                       WHEN NVL(MAX(SQM_INFO), '*') = '*' THEN 'I'" ).append("\n"); 
		query.append("                       WHEN NVL(MAX(MAS_INFO), '*') = '*' THEN 'D'" ).append("\n"); 
		query.append("                                                          ELSE 'U'" ).append("\n"); 
		query.append("                  END AS FLAG" ).append("\n"); 
		query.append("                 ,MAX(SQM_INFO) AS SQM_INFO" ).append("\n"); 
		query.append("                 ,MAX(MAS_INFO) AS MAS_INFO" ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("                     SELECT B1.TRD_CD" ).append("\n"); 
		query.append("                           ,B1.DIR_CD" ).append("\n"); 
		query.append("                           ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("                           ,B1.RLANE_CD" ).append("\n"); 
		query.append("                           ,B1.BSE_MON" ).append("\n"); 
		query.append("                           ,B1.BSE_WK" ).append("\n"); 
		query.append("                           ,B1.VSL_CD || B1.SKD_VOY_NO || B1.DIR_CD AS VVD" ).append("\n"); 
		query.append("                           ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                           ,SUBSTR(B2.SLS_YRMON, -2) AS SLS_MON" ).append("\n"); 
		query.append("                           ,B2.COST_WK" ).append("\n"); 
		query.append("                           ,B2.VSL_CD || B2.SKD_VOY_NO || B2.DIR_CD AS MAS_VVD" ).append("\n"); 
		query.append("                           ,B2.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("                           ,B1.TRD_CD || B1.SUB_TRD_CD || B1.RLANE_CD || B1.DIR_CD || B1.VSL_CD || B1.SKD_VOY_NO || B1.DIR_CD || B1.BSE_MON || B1.BSE_WK || B1.FNL_BSA_CAPA AS SQM_INFO" ).append("\n"); 
		query.append("                           ,B2.TRD_CD || B2.SUB_TRD_CD || B2.RLANE_CD || B2.DIR_CD || B2.VSL_CD || B2.SKD_VOY_NO || B2.DIR_CD || SUBSTR(B2.SLS_YRMON,-2) || B2.COST_WK || B2.FNL_HJS_BSA_CAPA AS MAS_INFO" ).append("\n"); 
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
		query.append("                                     TRD_CD" ).append("\n"); 
		query.append("                                    ,DIR_CD" ).append("\n"); 
		query.append("                                    ,SUB_TRD_CD" ).append("\n"); 
		query.append("                                    ,RLANE_CD" ).append("\n"); 
		query.append("                                    ,BSE_MON" ).append("\n"); 
		query.append("                                    ,BSE_WK" ).append("\n"); 
		query.append("                                    ,VSL_CD" ).append("\n"); 
		query.append("                                    ,SKD_VOY_NO" ).append("\n"); 
		query.append("                                    ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("                                    ,IOC_CD" ).append("\n"); 
		query.append("                                FROM SQM_SPCL_TGT_VVD" ).append("\n"); 
		query.append("                               WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                 AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                                 AND BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                                 AND TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                 AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                 AND DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                            ) B1" ).append("\n"); 
		query.append("                            FULL OUTER JOIN" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                              SELECT " ).append("\n"); 
		query.append("                                     A1.TRD_CD" ).append("\n"); 
		query.append("                                    ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                                    ,A1.RLANE_CD" ).append("\n"); 
		query.append("                                    ,A1.DIR_CD" ).append("\n"); 
		query.append("                                    ,A1.VSL_CD" ).append("\n"); 
		query.append("                                    ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    ,A1.SLS_YRMON" ).append("\n"); 
		query.append("                                    ,A1.COST_WK" ).append("\n"); 
		query.append("                                    ,A1.IOC_CD" ).append("\n"); 
		query.append("                                    ,NVL(A2.FNL_HJS_BSA_CAPA, 0) AS FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("                                FROM MAS_MON_VVD       A1" ).append("\n"); 
		query.append("                                    ,BSA_VVD_MST       A2" ).append("\n"); 
		query.append("                                    ,(" ).append("\n"); 
		query.append("                                       SELECT DISTINCT" ).append("\n"); 
		query.append("                                              BSE_TP_CD" ).append("\n"); 
		query.append("                                             ,BSE_YR" ).append("\n"); 
		query.append("                                             ,BSE_QTR_CD" ).append("\n"); 
		query.append("                                             ,TRD_CD" ).append("\n"); 
		query.append("                                             ,RLANE_CD" ).append("\n"); 
		query.append("                                             ,DIR_CD" ).append("\n"); 
		query.append("#if (${f_cond_tp} == '1')" ).append("\n"); 
		query.append("                                       -- 해당 분기의 LANE-OFFICE RELATION SETTING 한 노선의 정보를 걸어준다" ).append("\n"); 
		query.append("                                       -- (2013년간 데이터를 제외한 모든 분기를 걸어주면됨 현재는 현재 분기와 미래 판매목표만 걸어주고 있음)" ).append("\n"); 
		query.append("                                         FROM SQM_QTA_LANE_OFC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                       -- 2013년도 데이터는  LANE-OFFICE RELATION SETTING 정보가 없기 때문에 TARGET VVD 정보를 걸어서 노선정보를 가져온다." ).append("\n"); 
		query.append("                                         FROM SQM_SPCL_TGT_VVD" ).append("\n"); 
		query.append("#end                                             " ).append("\n"); 
		query.append("                                        WHERE 1=1" ).append("\n"); 
		query.append("                                          AND BSE_TP_CD      = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                          AND BSE_YR         = @[f_bse_yr]" ).append("\n"); 
		query.append("                                          AND BSE_QTR_CD     = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#if (${f_cond_tp} == '1')" ).append("\n"); 
		query.append("                                          AND OFC_VW_CD      = 'L'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                                          AND TRD_CD         = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                          AND RLANE_CD       = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                          AND DIR_CD         = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                       ) A3" ).append("\n"); 
		query.append("                               WHERE A1.TRD_CD      = A2.TRD_CD     (+)" ).append("\n"); 
		query.append("                                 AND A1.RLANE_CD    = A2.RLANE_CD   (+)" ).append("\n"); 
		query.append("                                 AND A1.VSL_CD      = A2.VSL_CD     (+)" ).append("\n"); 
		query.append("                                 AND A1.SKD_VOY_NO  = A2.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("                                 AND A1.DIR_CD      = A2.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("                                 AND A1.IOC_CD      = A2.IOC_CD     (+)" ).append("\n"); 
		query.append("                                 AND A1.TRD_CD      = A3.TRD_CD" ).append("\n"); 
		query.append("                                 AND A1.RLANE_CD    = A3.RLANE_CD" ).append("\n"); 
		query.append("                                 AND A1.DIR_CD      = A3.DIR_CD" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                                 AND A1.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                 AND A1.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                 AND A1.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                 AND A1.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                                 AND A1.IOC_CD      = DECODE(A1.RLANE_CD, 'RBCCO', 'I', A1.IOC_CD) -- RBCCO 노선은 IOC_CD = 'I' 인것만" ).append("\n"); 
		query.append("                                 -- 2013년 SLS_YRMON 이후는 Week로 걸어준다(2013년도는 SAQ 이행데이터로 기준이 월로 되어 있기 때문)" ).append("\n"); 
		query.append("                                 AND CASE WHEN '2013' = A3.BSE_YR THEN A1.SLS_YRMON ELSE SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK END " ).append("\n"); 
		query.append("                                     BETWEEN CASE WHEN '2013' = A3.BSE_YR THEN @[f_bse_yr]||DECODE(@[f_bse_qtr_cd],'1Q','01','2Q','04','3Q','07','4Q','10') ELSE @[f_bse_yr]||@[f_fm_wk] END " ).append("\n"); 
		query.append("                                         AND CASE WHEN '2013' = A3.BSE_YR THEN @[f_bse_yr]||DECODE(@[f_bse_qtr_cd],'1Q','03','2Q','06','3Q','09','4Q','12') ELSE @[f_bse_yr]||@[f_to_wk] END " ).append("\n"); 
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
		query.append("                            ) B2" ).append("\n"); 
		query.append("                         ON B1.TRD_CD          = B2.TRD_CD" ).append("\n"); 
		query.append("                        AND B1.SUB_TRD_CD      = B2.SUB_TRD_CD" ).append("\n"); 
		query.append("                        AND B1.DIR_CD          = B2.DIR_CD" ).append("\n"); 
		query.append("                        AND B1.RLANE_CD        = B2.RLANE_CD" ).append("\n"); 
		query.append("                        AND B1.IOC_CD          = B2.IOC_CD" ).append("\n"); 
		query.append("                        AND B1.VSL_CD          = B2.VSL_CD" ).append("\n"); 
		query.append("                        AND B1.SKD_VOY_NO      = B2.SKD_VOY_NO" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("         GROUP BY O_TRD_CD" ).append("\n"); 
		query.append("                 ,O_RLANE_CD" ).append("\n"); 
		query.append("                 ,O_SUB_TRD_CD" ).append("\n"); 
		query.append("                 ,O_DIR_CD" ).append("\n"); 
		query.append("                 ,O_IOC_CD" ).append("\n"); 
		query.append("                 ,O_VVD" ).append("\n"); 
		query.append("         ) A1, MAS_LANE_RGST MAS" ).append("\n"); 
		query.append("WHERE A1.TRD_CD         = MAS.TRD_CD" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD       = MAS.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD         = MAS.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD           = MAS.DIR_CD" ).append("\n"); 
		query.append("AND A1.IOC_CD           = MAS.IOC_CD" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("AND MAS.HUL_BND_CD       = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,NVL(MAS_BSE_MON, BSE_MON)" ).append("\n"); 
		query.append("        ,NVL(BSE_WK, MAS_BSE_WK)" ).append("\n"); 

	}
}