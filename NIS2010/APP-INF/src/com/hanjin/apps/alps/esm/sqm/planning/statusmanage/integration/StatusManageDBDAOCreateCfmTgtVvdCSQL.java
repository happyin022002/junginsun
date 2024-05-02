/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusManageDBDAOCreateCfmTgtVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.06.23 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusManageDBDAOCreateCfmTgtVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Freezing 시 Confirm TGT VVVD 생성
	  * IAS Sector Sales 관련 TARGET VVD 제외로직 추가
	  * 
	  * * 2015.02.27 이혜민 SLS_YRMON 추가/ 처음에는 COST_YRMON을 넣고 나중에 조정
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public StatusManageDBDAOCreateCfmTgtVvdCSQL(){
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
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOCreateCfmTgtVvdCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_CFM_TGT_VVD (" ).append("\n"); 
		query.append("       QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,QTA_TGT_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,BSE_MON" ).append("\n"); 
		query.append("      ,BSE_WK" ).append("\n"); 
		query.append("      ,SLS_YRMON" ).append("\n"); 
		query.append("      ,CONV_DIR_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,IOC_CD" ).append("\n"); 
		query.append("      ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,LOD_QTY" ).append("\n"); 
		query.append("      ,GRS_REV" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SUBSTR(@[f_bse_yr], 3, 2) || A1.BSE_QTR_CD || DECODE(CPY_NO, 0, '01', '02') AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,'D' AS QTA_TGT_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.BSE_MON" ).append("\n"); 
		query.append("      ,A1.BSE_WK" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("      ,A5.COST_YRMON" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,(SELECT TV.BSE_YR||TV.BSE_MON FROM SQM_QTA_TGT_VVD TV" ).append("\n"); 
		query.append("         WHERE A1.TRD_CD     = TV.TRD_CD" ).append("\n"); 
		query.append("           AND A1.RLANE_CD   = TV.RLANE_CD" ).append("\n"); 
		query.append("           AND A1.IOC_CD     = TV.IOC_CD" ).append("\n"); 
		query.append("           AND A1.DIR_CD     = TV.DIR_CD" ).append("\n"); 
		query.append("           AND A1.VSL_CD     = TV.VSL_CD" ).append("\n"); 
		query.append("           AND A1.SKD_VOY_NO = TV.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND ROWNUM < 2) COST_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,A2.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.IOC_CD" ).append("\n"); 
		query.append("      ,NVL(DECODE(A1.SUB_TRD_CD, 'IP', 0, A1.FNL_BSA_CAPA), 0) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,ROUND(DECODE(A2.SUB_TRD_CD,'IP', A2.LOD_QTY, A2.FNL_BSA_CAPA * A2.LDF_RTO / 100), 0) AS LOD_QTY" ).append("\n"); 
		query.append("      ,NVL(A2.GRS_RPB_REV * ROUND(DECODE(A2.SUB_TRD_CD,'IP', A2.LOD_QTY, A2.FNL_BSA_CAPA * A2.LDF_RTO / 100), 0), 0) AS GRS_REV" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM SQM_QTA_TGT_VVD A1" ).append("\n"); 
		query.append("      ,SQM_QTA_LOD_REV A2" ).append("\n"); 
		query.append("      ,COM_CPY_NO      A3" ).append("\n"); 
		query.append("      ,SQM_QTA_LANE_MGMT A4" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("      ,MAS_MON_VVD A5" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE A1.BSE_TP_CD  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD     = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD     = A2.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.SKD_DIR_CD = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.TRD_CD     = A4.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = A4.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("   AND A1.TRD_CD     = A5.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = A5.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.IOC_CD     = A5.IOC_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = A5.DIR_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD     = A5.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO = A5.SKD_VOY_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = NVL(A4.LANE_DIR_CD, A1.DIR_CD)" ).append("\n"); 
		query.append("--   AND A4.IAS_SCTR_FLG IS NULL" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.RLANE_CD  <> 'RBCCO'" ).append("\n"); 
		query.append("   AND A1.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("   AND A3.CPY_NO     < 2" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT SUBSTR(@[f_bse_yr], 3, 2) || A1.BSE_QTR_CD || DECODE(CPY_NO, 0, '01', '02') AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,'D' AS QTA_TGT_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.BSE_MON" ).append("\n"); 
		query.append("      ,A1.BSE_WK" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("      ,A3.COST_YRMON" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,(SELECT TV.BSE_YR||TV.BSE_MON FROM SQM_QTA_TGT_VVD TV" ).append("\n"); 
		query.append("         WHERE A1.TRD_CD     = TV.TRD_CD" ).append("\n"); 
		query.append("           AND A1.RLANE_CD   = TV.RLANE_CD" ).append("\n"); 
		query.append("           AND A1.IOC_CD     = TV.IOC_CD" ).append("\n"); 
		query.append("           AND A1.DIR_CD     = TV.DIR_CD" ).append("\n"); 
		query.append("           AND A1.VSL_CD     = TV.VSL_CD" ).append("\n"); 
		query.append("           AND A1.SKD_VOY_NO = TV.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND ROWNUM < 2) COST_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.IOC_CD" ).append("\n"); 
		query.append("      ,NVL(A1.FNL_BSA_CAPA, 0) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,0 AS LOD_QTY" ).append("\n"); 
		query.append("      ,0 AS GRS_REV" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM SQM_QTA_TGT_VVD A1" ).append("\n"); 
		query.append("      ,COM_CPY_NO      A2" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("      ,MAS_MON_VVD 	   A3" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE A1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = 'RBCCO'" ).append("\n"); 
		query.append("   AND A1.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("   AND A2.CPY_NO     < 2" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("   AND A1.TRD_CD     = A3.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = A3.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.IOC_CD     = A3.IOC_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = A3.DIR_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD     = A3.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}