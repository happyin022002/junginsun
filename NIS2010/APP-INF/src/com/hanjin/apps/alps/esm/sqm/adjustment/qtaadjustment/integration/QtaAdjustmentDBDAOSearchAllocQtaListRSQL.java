/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchAllocQtaListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOSearchAllocQtaListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Allocation = QTA Setting]을 [조회] 합니다.
	  * 
	  * * 2014.12.26 [CHM-201433310] SPC에서 I/F시 최초 Load를 사후에도 조회할수 있도록 ORG_LOD_QTY 컬럼 추가, 
	  *                                               확정데이터 Load를 조회할 수 있도록 CFM_LOD_QTY 컬럼 추가. 
	  * * 2015.01.22 [CHM-201533664] Planned Load 기준을 Apply 전에는 CFM_QTA테이블의 LOD_QTY 기준으로 
	  *                                               Apply 후에는 ALOC_QTA테이블의 CFM_LOD_QTY 기준으로 수정
	  * * 2015.02.12 [CHM-201534142] Trade Direction도 조회되도록 COA_LANE_RGST 테이블과 join시킴
	  * * 2015.06.15 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2015.08.26 [CHM-201537723] [CSR 전환건] Allocation = QTA Adjustment 화면 내 신규 칼럼 추가
	  * * 2015.08.31 [CHM-201537765] [CSR 전환건] Allocation = QTA Adjustment 데이터 정렬 문제
	  * * 2015.10.05 [CHM-201537934] [CSR 전환건] Allocation = QTA의 "SPC Alloc Apply" 로직 수정
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchAllocQtaListRSQL(){
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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_active_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchAllocQtaListRSQL").append("\n"); 
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
		query.append("#if (${f_active_flg} != '' && ${f_active_flg} != 'All')" ).append("\n"); 
		query.append("SELECT * FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BSE_YR" ).append("\n"); 
		query.append(",BSE_MON" ).append("\n"); 
		query.append(",BSE_WK" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",HUL_BND_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 
		query.append(",RGN_OFC_CD" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",APLY_CNT" ).append("\n"); 
		query.append(",CFM_LOD_QTY" ).append("\n"); 
		query.append(",ORG_LOD_QTY" ).append("\n"); 
		query.append(",LOD_QTY" ).append("\n"); 
		query.append(",FNL_BSA_CAPA" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",APLY_FLG" ).append("\n"); 
		query.append(",D_MINUS_ONE_DATE" ).append("\n"); 
		query.append(",SQM_ACT_FLG" ).append("\n"); 
		query.append(",QUARTER" ).append("\n"); 
		query.append(",(CASE WHEN BSE_YR||QUARTER||RHQ_CD||CONV_DIR_CD " ).append("\n"); 
		query.append("    IN (select DISTINCT RLT.BSE_YR||RLT.BSE_QTR_CD||RLT.RHQ_CD||RLT.CONV_DIR_CD from SQM_DAT_RLT RLT" ).append("\n"); 
		query.append("        WHERE RLT.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("        AND RLT.BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("        AND RLT.OFC_VW_CD = 'L') " ).append("\n"); 
		query.append("    THEN 'VALID' " ).append("\n"); 
		query.append("    ELSE BSE_YR||'-'||QUARTER||'-'||DIR_CD||'-'||RHQ_CD||' pair is invalid. Please check Basic Data Relation Setting.' END) AS PAIR_CHECK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_MON" ).append("\n"); 
		query.append("      ,A1.BSE_WK" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      , NVL( (SELECT DISTINCT CONV_DIR_CD " ).append("\n"); 
		query.append("        FROM SQM_DIR_CONV CONV" ).append("\n"); 
		query.append("        WHERE CONV.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("         AND CONV.BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("         AND CONV.BSE_QTR_CD = CASE WHEN A1.BSE_MON = '01' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN A1.BSE_MON = '02' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN A1.BSE_MON = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                WHEN A1.BSE_MON = '04' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN A1.BSE_MON = '05' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN A1.BSE_MON = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                WHEN A1.BSE_MON = '07' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN A1.BSE_MON = '08' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN A1.BSE_MON = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                WHEN A1.BSE_MON = '10' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN A1.BSE_MON = '11' THEN '4Q'" ).append("\n"); 
		query.append("                                WHEN A1.BSE_MON = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("         AND CONV.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("         AND CONV.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("         AND CONV.DIR_CD = A1.DIR_CD ), A1.DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("	  ,DECODE(A3.HUL_BND_CD,'BH','B/H','H/H') HUL_BND_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,SUM(DECODE(A1.APLY_FLG,'Y',1,0)) OVER (PARTITION BY A1.TRD_CD" ).append("\n"); 
		query.append("                          ,A1.RLANE_CD" ).append("\n"); 
		query.append("                          ,A1.DIR_CD" ).append("\n"); 
		query.append("                          ,A1.VSL_CD" ).append("\n"); 
		query.append("                          ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                          ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("                          ,A1.VSL_CD" ).append("\n"); 
		query.append("                          ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                          ,A1.SKD_DIR_CD ) AS APLY_CNT" ).append("\n"); 
		query.append("--VVD중 하나라도 Apply가 되면 Apply가 되지않은 Office도 ALOC_QTA 테이블의  CFM_LOD_QTY를 보여줌. 그렇지 않으면 계속 0으로 나오기 때문." ).append("\n"); 
		query.append("      ,CASE WHEN (SUM(DECODE(A1.APLY_FLG,'Y',1,0)) OVER (PARTITION BY A1.TRD_CD" ).append("\n"); 
		query.append("                          ,A1.RLANE_CD" ).append("\n"); 
		query.append("                          ,A1.DIR_CD" ).append("\n"); 
		query.append("                          ,A1.VSL_CD" ).append("\n"); 
		query.append("                          ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                          ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("                          ,A1.VSL_CD" ).append("\n"); 
		query.append("                          ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                          ,A1.SKD_DIR_CD )) > 0 " ).append("\n"); 
		query.append("            THEN A1.CFM_LOD_QTY " ).append("\n"); 
		query.append("            ELSE NVL(A2.LOD_QTY,0)" ).append("\n"); 
		query.append("            END CFM_LOD_QTY" ).append("\n"); 
		query.append("      ,A1.ORG_LOD_QTY" ).append("\n"); 
		query.append("      ,A1.LOD_QTY" ).append("\n"); 
		query.append("      ,A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.APLY_FLG" ).append("\n"); 
		query.append("      ,TO_CHAR(VSK2.VPS_ETB_DT - 1, 'YYYY-MM-DD') AS D_MINUS_ONE_DATE" ).append("\n"); 
		query.append("      ,NVL((SELECT DISTINCT A4.SQM_ACT_FLG" ).append("\n"); 
		query.append("            FROM SQM_QTA_LANE_OFC A4" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("             AND A4.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("             AND A4.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("             AND A4.BSE_QTR_CD = (CASE WHEN A1.BSE_MON = '01' THEN '1Q'" ).append("\n"); 
		query.append("                            WHEN A1.BSE_MON = '02' THEN '1Q'" ).append("\n"); 
		query.append("                            WHEN A1.BSE_MON = '03' THEN '1Q'" ).append("\n"); 
		query.append("                            WHEN A1.BSE_MON = '04' THEN '2Q'" ).append("\n"); 
		query.append("                            WHEN A1.BSE_MON = '05' THEN '2Q'" ).append("\n"); 
		query.append("                            WHEN A1.BSE_MON = '06' THEN '2Q'" ).append("\n"); 
		query.append("                            WHEN A1.BSE_MON = '07' THEN '3Q'" ).append("\n"); 
		query.append("                            WHEN A1.BSE_MON = '08' THEN '3Q'" ).append("\n"); 
		query.append("                            WHEN A1.BSE_MON = '09' THEN '3Q'" ).append("\n"); 
		query.append("                            WHEN A1.BSE_MON = '10' THEN '4Q'" ).append("\n"); 
		query.append("                            WHEN A1.BSE_MON = '11' THEN '4Q'" ).append("\n"); 
		query.append("                            WHEN A1.BSE_MON = '12' THEN '4Q'" ).append("\n"); 
		query.append("                            END)" ).append("\n"); 
		query.append("             AND A4.OFC_VW_CD = 'L'" ).append("\n"); 
		query.append("             AND A4.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("             AND A4.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("             AND A4.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("             AND A4.RGN_OFC_CD = A1.RGN_OFC_CD" ).append("\n"); 
		query.append("          ), 'X') AS SQM_ACT_FLG" ).append("\n"); 
		query.append("          ,CASE WHEN A1.BSE_MON = '01' THEN '1Q'" ).append("\n"); 
		query.append("            WHEN A1.BSE_MON = '02' THEN '1Q'" ).append("\n"); 
		query.append("            WHEN A1.BSE_MON = '03' THEN '1Q'" ).append("\n"); 
		query.append("            WHEN A1.BSE_MON = '04' THEN '2Q'" ).append("\n"); 
		query.append("            WHEN A1.BSE_MON = '05' THEN '2Q'" ).append("\n"); 
		query.append("            WHEN A1.BSE_MON = '06' THEN '2Q'" ).append("\n"); 
		query.append("            WHEN A1.BSE_MON = '07' THEN '3Q'" ).append("\n"); 
		query.append("            WHEN A1.BSE_MON = '08' THEN '3Q'" ).append("\n"); 
		query.append("            WHEN A1.BSE_MON = '09' THEN '3Q'" ).append("\n"); 
		query.append("            WHEN A1.BSE_MON = '10' THEN '4Q'" ).append("\n"); 
		query.append("            WHEN A1.BSE_MON = '11' THEN '4Q'" ).append("\n"); 
		query.append("            WHEN A1.BSE_MON = '12' THEN '4Q' END AS QUARTER" ).append("\n"); 
		query.append(" FROM SQM_ALOC_QTA A1, SQM_CFM_QTA A2, MAS_LANE_RGST A3, vsk_vsl_skd VSK1, vsk_vsl_port_skd VSK2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND A1.BSE_YR      = A2.BSE_YR(+)" ).append("\n"); 
		query.append(" AND A1.TRD_CD      = A2.TRD_CD(+)" ).append("\n"); 
		query.append(" AND A1.RLANE_CD    = A2.RLANE_CD(+)" ).append("\n"); 
		query.append(" AND A1.DIR_CD      = A2.DIR_CD(+)" ).append("\n"); 
		query.append(" AND A1.VSL_CD      = A2.VSL_CD(+)" ).append("\n"); 
		query.append(" AND A1.SKD_VOY_NO  = A2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append(" AND A1.SKD_DIR_CD  = A2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append(" AND A1.RGN_OFC_CD  = A2.RGN_OFC_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" AND A1.TRD_CD      = A3.TRD_CD" ).append("\n"); 
		query.append(" AND A1.RLANE_CD    = A3.RLANE_CD" ).append("\n"); 
		query.append(" AND A1.DIR_CD      = A3.DIR_CD" ).append("\n"); 
		query.append(" AND A1.SUB_TRD_CD  = A3.SUB_TRD_CD" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" AND A1.VSL_CD      = VSK1.VSL_CD" ).append("\n"); 
		query.append(" AND A1.SKD_VOY_NO  = VSK1.SKD_VOY_NO" ).append("\n"); 
		query.append(" AND A1.SKD_DIR_CD  = VSK1.SKD_DIR_CD" ).append("\n"); 
		query.append(" AND VSK1.VSL_CD    = VSK2.VSL_CD" ).append("\n"); 
		query.append(" AND VSK1.SKD_VOY_NO = VSK2.SKD_VOY_NO" ).append("\n"); 
		query.append(" AND VSK1.SKD_DIR_CD = VSK2.SKD_DIR_CD" ).append("\n"); 
		query.append(" AND VSK1.ST_PORT_CD = VSK2.VPS_PORT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" AND A1.BSE_YR                        = @[f_bse_yr]" ).append("\n"); 
		query.append(" AND A2.BSE_TP_CD(+)                  = 'Q'" ).append("\n"); 
		query.append(" AND A2.OFC_VW_CD(+)                  = 'L'" ).append("\n"); 
		query.append(" AND A2.QTA_TGT_CD(+)                 = 'D'" ).append("\n"); 
		query.append(" AND SUBSTR(A2.QTA_RLSE_VER_NO(+),-2) = '02'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.TRD_CD                     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD                   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RHQ_CD                     = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD                 = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_to_mon} != '' && ${f_to_mon} != 'All')" ).append("\n"); 
		query.append("   AND A1.BSE_MON                    = @[f_to_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_to_wk} != '' && ${f_to_wk} != 'All')" ).append("\n"); 
		query.append("   AND A1.BSE_WK                     = @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '' )" ).append("\n"); 
		query.append("   AND A1.VSL_CD                     = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '' )" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO                 = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_dir_cd} != '' )" ).append("\n"); 
		query.append("   AND A1.SKD_DIR_CD                 = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_aply_flg} != '' && ${f_aply_flg} != 'All')" ).append("\n"); 
		query.append("   AND A1.APLY_FLG                  = @[f_aply_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A3.HUL_BND_CD  = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY BSE_YR" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",HUL_BND_CD" ).append("\n"); 
		query.append(",BSE_MON" ).append("\n"); 
		query.append(",BSE_WK" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 
		query.append(",FNL_BSA_CAPA" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",RGN_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_active_flg} != '' && ${f_active_flg} != 'All')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SQM_ACT_FLG                  = @[f_active_flg]" ).append("\n"); 
		query.append("ORDER BY BSE_YR" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",HUL_BND_CD" ).append("\n"); 
		query.append(",BSE_MON" ).append("\n"); 
		query.append(",BSE_WK" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 
		query.append(",FNL_BSA_CAPA" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}