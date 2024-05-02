/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostStructureDBDAOMultiSoCodeSrcAcctCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOMultiSoCodeSrcAcctCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_COST_SRC_ACCT 테이블등록 (Register Cost Items)
	  *  2012.05.07 전윤주 [CHM-201217633] Hinterland Project 
	  *                  - TRS cost table 생성 시 사용되는 계정 분리를 위해 Flag 추가
	  *                   (inlnd_expn_use_flg, inlnd_tml_expn_calc_flg, ocn_fdr_expn_use_flg)
	  * </pre>
	  */
	public CostStructureDBDAOMultiSoCodeSrcAcctCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_vol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_full_soc_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_expn_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_tml_expn_calc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgrp_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocn_fdr_expn_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_dg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_src_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ut_amt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_cost_src_prt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_bb_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_vol_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_cost_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_awk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rev_mcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_mcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_cost_src_cd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ass_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOMultiSoCodeSrcAcctCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_COST_SRC_ACCT A " ).append("\n"); 
		query.append("  USING (SELECT @[coa_cost_src_cd] AS COA_COST_SRC_CD " ).append("\n"); 
		query.append("            ,@[cost_ass_bse_cd] AS COST_ASS_BSE_CD " ).append("\n"); 
		query.append("            ,@[stnd_cost_cd] AS STND_COST_CD " ).append("\n"); 
		query.append("            ,@[sgrp_cost_cd] AS SGRP_COST_CD " ).append("\n"); 
		query.append("            ,@[coa_cost_src_prt_cd] AS COA_COST_SRC_PRT_CD " ).append("\n"); 
		query.append("            ,@[cost_src_sys_cd] AS COST_SRC_SYS_CD " ).append("\n"); 
		query.append("            ,@[cost_vol_cd] AS COST_VOL_CD " ).append("\n"); 
		query.append("            ,@[cost_vol_cd1] AS COST_VOL_CD1 " ).append("\n"); 
		query.append("            ,@[full_mty_cd] AS FULL_MTY_CD " ).append("\n"); 
		query.append("            ,@[cost_src_mon] AS COST_SRC_MON " ).append("\n"); 
		query.append("            ,@[coa_cost_src_cd_nm] AS COA_COST_SRC_CD_NM " ).append("\n"); 
		query.append("            ,@[cost_ut_amt_cd] AS COST_UT_AMT_CD " ).append("\n"); 
		query.append("            ,@[bkg_full_soc_cgo_flg] AS BKG_FULL_SOC_CGO_FLG " ).append("\n"); 
		query.append("            ,@[bkg_mcgo_flg] AS BKG_MCGO_FLG " ).append("\n"); 
		query.append("            ,@[bkg_rev_mcgo_flg] AS BKG_REV_MCGO_FLG " ).append("\n"); 
		query.append("            ,@[spcl_cgo_dg_flg] AS SPCL_CGO_DG_FLG " ).append("\n"); 
		query.append("            ,@[spcl_cgo_bb_flg] AS SPCL_CGO_BB_FLG " ).append("\n"); 
		query.append("            ,@[spcl_cgo_awk_flg] AS SPCL_CGO_AWK_FLG " ).append("\n"); 
		query.append("            ,@[spcl_cgo_rf_flg] AS SPCL_CGO_RF_FLG " ).append("\n"); 
		query.append("            ,@[inlnd_expn_use_flg] AS INLND_EXPN_USE_FLG " ).append("\n"); 
		query.append("            ,@[inlnd_tml_expn_calc_flg] AS INLND_TML_EXPN_CALC_FLG " ).append("\n"); 
		query.append("            ,@[ocn_fdr_expn_use_flg] AS OCN_FDR_EXPN_USE_FLG " ).append("\n"); 
		query.append("            ,@[user_id] AS CRE_USR_ID " ).append("\n"); 
		query.append("            ,SYSDATE AS CRE_DT " ).append("\n"); 
		query.append("            ,@[user_id] AS UPD_USR_ID " ).append("\n"); 
		query.append("            ,SYSDATE AS UPD_DT " ).append("\n"); 
		query.append("            ,@[delt_flg] AS DELT_FLG " ).append("\n"); 
		query.append("          FROM DUAL) B " ).append("\n"); 
		query.append("  ON (A.COA_COST_SRC_CD = B.COA_COST_SRC_CD) " ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT (A.COA_COST_SRC_CD" ).append("\n"); 
		query.append("          ,A.COST_ASS_BSE_CD" ).append("\n"); 
		query.append("          ,A.STND_COST_CD" ).append("\n"); 
		query.append("          ,A.SGRP_COST_CD" ).append("\n"); 
		query.append("          ,A.COA_COST_SRC_PRT_CD " ).append("\n"); 
		query.append("          ,A.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("          ,A.COST_VOL_CD" ).append("\n"); 
		query.append("          ,A.COST_VOL_CD1" ).append("\n"); 
		query.append("          ,A.FULL_MTY_CD" ).append("\n"); 
		query.append("          ,A.COST_SRC_MON" ).append("\n"); 
		query.append("          ,A.COA_COST_SRC_CD_NM " ).append("\n"); 
		query.append("          ,A.COST_UT_AMT_CD" ).append("\n"); 
		query.append("          ,A.BKG_FULL_SOC_CGO_FLG" ).append("\n"); 
		query.append("          ,A.BKG_MCGO_FLG" ).append("\n"); 
		query.append("          ,A.BKG_REV_MCGO_FLG " ).append("\n"); 
		query.append("          ,A.SPCL_CGO_DG_FLG" ).append("\n"); 
		query.append("          ,A.SPCL_CGO_BB_FLG" ).append("\n"); 
		query.append("          ,A.SPCL_CGO_AWK_FLG" ).append("\n"); 
		query.append("          ,A.SPCL_CGO_RF_FLG" ).append("\n"); 
		query.append("          ,A.INLND_EXPN_USE_FLG" ).append("\n"); 
		query.append("          ,A.INLND_TML_EXPN_CALC_FLG" ).append("\n"); 
		query.append("          ,A.OCN_FDR_EXPN_USE_FLG" ).append("\n"); 
		query.append("          ,A.CRE_USR_ID" ).append("\n"); 
		query.append("          ,A.CRE_DT" ).append("\n"); 
		query.append("          ,A.UPD_USR_ID" ).append("\n"); 
		query.append("          ,A.UPD_DT" ).append("\n"); 
		query.append("          ,A.DELT_FLG) " ).append("\n"); 
		query.append("    VALUES (B.COA_COST_SRC_CD" ).append("\n"); 
		query.append("          ,B.COST_ASS_BSE_CD" ).append("\n"); 
		query.append("          ,B.STND_COST_CD" ).append("\n"); 
		query.append("          ,B.SGRP_COST_CD" ).append("\n"); 
		query.append("          ,B.COA_COST_SRC_PRT_CD " ).append("\n"); 
		query.append("          ,B.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("          ,B.COST_VOL_CD" ).append("\n"); 
		query.append("          ,B.COST_VOL_CD1" ).append("\n"); 
		query.append("          ,B.FULL_MTY_CD" ).append("\n"); 
		query.append("          ,B.COST_SRC_MON" ).append("\n"); 
		query.append("          ,B.COA_COST_SRC_CD_NM " ).append("\n"); 
		query.append("          ,B.COST_UT_AMT_CD" ).append("\n"); 
		query.append("          ,B.BKG_FULL_SOC_CGO_FLG" ).append("\n"); 
		query.append("          ,B.BKG_MCGO_FLG" ).append("\n"); 
		query.append("          ,B.BKG_REV_MCGO_FLG " ).append("\n"); 
		query.append("          ,B.SPCL_CGO_DG_FLG" ).append("\n"); 
		query.append("          ,B.SPCL_CGO_BB_FLG" ).append("\n"); 
		query.append("          ,B.SPCL_CGO_AWK_FLG" ).append("\n"); 
		query.append("          ,B.SPCL_CGO_RF_FLG " ).append("\n"); 
		query.append("          ,B.INLND_EXPN_USE_FLG" ).append("\n"); 
		query.append("          ,B.INLND_TML_EXPN_CALC_FLG" ).append("\n"); 
		query.append("          ,B.OCN_FDR_EXPN_USE_FLG" ).append("\n"); 
		query.append("          ,B.CRE_USR_ID" ).append("\n"); 
		query.append("          ,B.CRE_DT" ).append("\n"); 
		query.append("          ,B.UPD_USR_ID" ).append("\n"); 
		query.append("          ,B.UPD_DT" ).append("\n"); 
		query.append("          ,B.DELT_FLG) " ).append("\n"); 
		query.append("  WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("      SET A.COST_ASS_BSE_CD          = B.COST_ASS_BSE_CD" ).append("\n"); 
		query.append("          ,A.STND_COST_CD            = B.STND_COST_CD" ).append("\n"); 
		query.append("          ,A.SGRP_COST_CD            = B.SGRP_COST_CD " ).append("\n"); 
		query.append("          ,A.COA_COST_SRC_PRT_CD     = B.COA_COST_SRC_PRT_CD " ).append("\n"); 
		query.append("          ,A.COST_SRC_SYS_CD         = B.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("          ,A.COST_VOL_CD             = B.COST_VOL_CD" ).append("\n"); 
		query.append("          ,A.COST_VOL_CD1            = B.COST_VOL_CD1 " ).append("\n"); 
		query.append("          ,A.FULL_MTY_CD             = B.FULL_MTY_CD" ).append("\n"); 
		query.append("          ,A.COST_SRC_MON            = B.COST_SRC_MON" ).append("\n"); 
		query.append("          ,A.COA_COST_SRC_CD_NM      = B.COA_COST_SRC_CD_NM " ).append("\n"); 
		query.append("          ,A.COST_UT_AMT_CD          = B.COST_UT_AMT_CD          " ).append("\n"); 
		query.append("          ,A.BKG_FULL_SOC_CGO_FLG    = B.BKG_FULL_SOC_CGO_FLG" ).append("\n"); 
		query.append("          ,A.BKG_MCGO_FLG            = B.BKG_MCGO_FLG " ).append("\n"); 
		query.append("          ,A.BKG_REV_MCGO_FLG        = B.BKG_REV_MCGO_FLG" ).append("\n"); 
		query.append("          ,A.SPCL_CGO_DG_FLG         = B.SPCL_CGO_DG_FLG " ).append("\n"); 
		query.append("          ,A.SPCL_CGO_BB_FLG         = B.SPCL_CGO_BB_FLG" ).append("\n"); 
		query.append("          ,A.SPCL_CGO_AWK_FLG        = B.SPCL_CGO_AWK_FLG " ).append("\n"); 
		query.append("          ,A.SPCL_CGO_RF_FLG         = B.SPCL_CGO_RF_FLG" ).append("\n"); 
		query.append("          ,A.INLND_EXPN_USE_FLG      = B.INLND_EXPN_USE_FLG" ).append("\n"); 
		query.append("          ,A.INLND_TML_EXPN_CALC_FLG = B.INLND_TML_EXPN_CALC_FLG" ).append("\n"); 
		query.append("          ,A.OCN_FDR_EXPN_USE_FLG    = B.OCN_FDR_EXPN_USE_FLG" ).append("\n"); 
		query.append("          ,A.UPD_USR_ID              = B.UPD_USR_ID " ).append("\n"); 
		query.append("          ,A.UPD_DT                  = B.UPD_DT" ).append("\n"); 
		query.append("          ,A.DELT_FLG                = B.DELT_FLG" ).append("\n"); 

	}
}