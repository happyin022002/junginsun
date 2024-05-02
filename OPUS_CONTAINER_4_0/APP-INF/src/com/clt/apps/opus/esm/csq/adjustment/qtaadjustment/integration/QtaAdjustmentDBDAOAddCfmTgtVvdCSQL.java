/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : QtaAdjustmentDBDAOAddCfmTgtVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.26
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.08.26 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
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
		params.put("coa_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("coa_bse_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_grs_rev",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("coa_bse_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("coa_fnl_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
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
		query.append("INSERT INTO CSQ_CFM_TGT_VVD (" ).append("\n"); 
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
		query.append("      ,SUBSTR(@[coa_vvd], 1, 4) AS VSL_CD" ).append("\n"); 
		query.append("      ,SUBSTR(@[coa_vvd], 5, 4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SUBSTR(@[coa_vvd], 9, 1) AS SKD_DIR_CD" ).append("\n"); 
		query.append("      ,@[coa_bse_mon]           AS BSE_MON" ).append("\n"); 
		query.append("      ,@[coa_bse_wk]            AS BSE_WK" ).append("\n"); 
		query.append("      ,NVL((SELECT CONV_DIR_CD" ).append("\n"); 
		query.append("              FROM CSQ_DIR_CONV" ).append("\n"); 
		query.append("             WHERE BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("               AND BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("               AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("               AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("               AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("               AND DIR_CD     = @[dir_cd]), @[dir_cd]) AS CONV_DIR_CD" ).append("\n"); 
		query.append("      ,@[sub_trd_cd]        AS SUB_TRD_CD" ).append("\n"); 
		query.append("      ,@[ioc_cd]            AS IOC_CD" ).append("\n"); 
		query.append("      ,@[coa_fnl_bsa_capa]  AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,@[coa_lod_qty]       AS LOD_QTY" ).append("\n"); 
		query.append("      ,@[coa_grs_rev]       AS GRS_REV" ).append("\n"); 
		query.append("      ,@[usr_id]            AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE              AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id]            AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE              AS UPD_DT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}