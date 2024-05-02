/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOAddCfmTgtVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.18 
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

public class QtaAdjustmentDBDAOAddCfmTgtVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * QTA Adjustment by VVD 화면의 정보를 추가 한다
	  * 
	  * * 2015.02.27 이혜민 SLS_YRMON 추가
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2015.09.09 김용습 [CHM-201537818] QTA Adjustment by VVD, QTA Adjustment by VVD for IAS Sector 두 화면내 칼럼 수정
	  * </pre>
	  */
	public QtaAdjustmentDBDAOAddCfmTgtVvdCSQL(){
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
		params.put("mas_grs_rev",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mas_bse_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mas_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qta_rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mas_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOAddCfmTgtVvdCSQL").append("\n"); 
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
		query.append("	  ,SLS_YRMON" ).append("\n"); 
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
		query.append("SELECT @[qta_rlse_ver_no]       AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,@[bse_tp_cd]             AS BSE_TP_CD" ).append("\n"); 
		query.append("      ,@[bse_yr]                AS BSE_YR" ).append("\n"); 
		query.append("      ,@[bse_qtr_cd]            AS BSE_QTR_CD" ).append("\n"); 
		query.append("      ,@[qta_tgt_cd]            AS QTA_TGT_CD" ).append("\n"); 
		query.append("      ,@[trd_cd]                AS TRD_CD" ).append("\n"); 
		query.append("      ,@[rlane_cd]              AS RLANE_CD" ).append("\n"); 
		query.append("      ,@[dir_cd]                AS DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(@[mas_vvd], 1, 4) AS VSL_CD" ).append("\n"); 
		query.append("      ,SUBSTR(@[mas_vvd], 5, 4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SUBSTR(@[mas_vvd], 9, 1) AS SKD_DIR_CD" ).append("\n"); 
		query.append("      ,@[mas_bse_mon]           AS BSE_MON" ).append("\n"); 
		query.append("      ,@[mas_bse_wk]            AS BSE_WK" ).append("\n"); 
		query.append("	  ,@[mas_cost_yrmon]			AS SLS_YRMON" ).append("\n"); 
		query.append("      ,NVL((SELECT CONV_DIR_CD" ).append("\n"); 
		query.append("              FROM SQM_DIR_CONV" ).append("\n"); 
		query.append("             WHERE BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("               AND BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("               AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("               AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("               AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("               AND DIR_CD     = @[dir_cd]), @[dir_cd]) AS CONV_DIR_CD" ).append("\n"); 
		query.append("      ,@[sub_trd_cd]        AS SUB_TRD_CD" ).append("\n"); 
		query.append("      ,@[ioc_cd]            AS IOC_CD" ).append("\n"); 
		query.append("      ,@[mas_fnl_bsa_capa]  AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,@[mas_lod_qty]       AS LOD_QTY" ).append("\n"); 
		query.append("      ,@[mas_grs_rev]       AS GRS_REV" ).append("\n"); 
		query.append("      ,@[usr_id]            AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE              AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id]            AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE              AS UPD_DT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}