/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOCopyCfmTgtVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
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

public class QtaAdjustmentDBDAOCopyCfmTgtVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Adjustment by VVD] 에서 확정데이터를 [복사] 합니다
	  * 
	  * * 2015.02.27 이혜민 SLS_YRMON 추가
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2015.09.09 김용습 [CHM-201537818] QTA Adjustment by VVD, QTA Adjustment by VVD for IAS Sector 두 화면내 칼럼 수정
	  * 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public QtaAdjustmentDBDAOCopyCfmTgtVvdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("copy_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mas_bse_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mas_bse_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qta_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spl_potn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qta_rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mas_fnl_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mas_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mas_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOCopyCfmTgtVvdCSQL").append("\n"); 
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
		query.append("SELECT A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.QTA_TGT_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(@[mas_vvd], 1, 4) AS VSL_CD" ).append("\n"); 
		query.append("      ,SUBSTR(@[mas_vvd], 5, 4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SUBSTR(@[mas_vvd], 9, 1) AS SKD_DIR_CD" ).append("\n"); 
		query.append("      ,@[mas_bse_mon] AS BSE_MON" ).append("\n"); 
		query.append("      ,@[mas_bse_wk]  AS BSE_WK" ).append("\n"); 
		query.append("      ,@[mas_cost_yrmon] AS SLS_YRMON" ).append("\n"); 
		query.append("      ,A1.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.IOC_CD" ).append("\n"); 
		query.append("      ,@[mas_fnl_bsa_capa] AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,DECODE(@[spl_potn], '1', 0, LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("      ,DECODE(@[spl_potn], '1', 0, GRS_REV) AS GRS_REV" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE   AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE   AS UPD_DT" ).append("\n"); 
		query.append("  FROM SQM_CFM_TGT_VVD A1" ).append("\n"); 
		query.append(" WHERE A1.QTA_RLSE_VER_NO = @[qta_rlse_ver_no]" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD      = @[bse_qtr_cd]" ).append("\n"); 
		query.append("   AND A1.QTA_TGT_CD      = @[qta_tgt_cd]" ).append("\n"); 
		query.append("   AND A1.TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("   AND A1.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("   AND A1.DIR_CD          = @[dir_cd]" ).append("\n"); 
		query.append("   AND A1.VSL_CD          = SUBSTR(@[copy_vvd], 1, 4)" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO      = SUBSTR(@[copy_vvd], 5, 4)" ).append("\n"); 
		query.append("   AND A1.SKD_DIR_CD      = SUBSTR(@[copy_vvd], 9, 1)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND NOT EXISTS (" ).append("\n"); 
		query.append("    SELECT * FROM SQM_CFM_TGT_VVD A1" ).append("\n"); 
		query.append("     WHERE A1.QTA_RLSE_VER_NO = @[qta_rlse_ver_no]" ).append("\n"); 
		query.append("       AND A1.BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("       AND A1.BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("       AND A1.BSE_QTR_CD      = @[bse_qtr_cd]" ).append("\n"); 
		query.append("       AND A1.QTA_TGT_CD      = @[qta_tgt_cd]" ).append("\n"); 
		query.append("       AND A1.TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("       AND A1.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("       AND A1.DIR_CD          = @[dir_cd]" ).append("\n"); 
		query.append("       AND A1.VSL_CD          = SUBSTR(@[mas_vvd], 1, 4)" ).append("\n"); 
		query.append("       AND A1.SKD_VOY_NO      = SUBSTR(@[mas_vvd], 5, 4)" ).append("\n"); 
		query.append("       AND A1.SKD_DIR_CD      = SUBSTR(@[mas_vvd], 9, 1)" ).append("\n"); 
		query.append("   ) -- QTA ADJUSTMENT BY VVD FOR IAS SECTOR에서 추가할 때 중복 에러 나지 않게 하기 위해 NOT EXISTS 조건 추가" ).append("\n"); 

	}
}