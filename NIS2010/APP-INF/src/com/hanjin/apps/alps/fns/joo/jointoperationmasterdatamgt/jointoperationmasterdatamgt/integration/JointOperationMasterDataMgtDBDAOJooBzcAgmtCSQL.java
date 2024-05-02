/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOJooBzcAgmtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOJooBzcAgmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.06.01 : 김상근[CHM-201218057-01]
	  * Discription : Column Add   
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOJooBzcAgmtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rf_gnte_ocn_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_45ft_rnd_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_45ft_ovr_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_aloc_adj_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_45ft_und_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_40ft_gnte_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_40ft_rnd_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bkg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_20ft_rnd_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rf_gnte_inter_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_20ft_gnte_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ton_wgt_rnd_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_40ft_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_ton_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_20ft_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ton_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_aloc_adj_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_aloc_adj_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_45ft_gnte_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOJooBzcAgmtCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_BZC_AGMT (" ).append("\n"); 
		query.append(" JO_REF_NO  " ).append("\n"); 
		query.append(",JO_REF_SEQ " ).append("\n"); 
		query.append(",OFC_CD     " ).append("\n"); 
		query.append(",RE_DIVR_CD " ).append("\n"); 
		query.append(",JO_CRR_CD  " ).append("\n"); 
		query.append(",TRD_CD     " ).append("\n"); 
		query.append(",RLANE_CD   " ).append("\n"); 
		query.append(",JO_SRC_CD  " ).append("\n"); 
		query.append(",BSA_CAPA   " ).append("\n"); 
		query.append(",JO_TON_TEU_QTY" ).append("\n"); 
		query.append(",CGO_TON_WGT" ).append("\n"); 
		query.append(",JO_TON_WGT_RND_RT" ).append("\n"); 
		query.append(",JO_40FT_GNTE_QTY" ).append("\n"); 
		query.append(",JO_40FT_TEU_QTY" ).append("\n"); 
		query.append(",JO_40FT_RND_RT" ).append("\n"); 
		query.append(",JO_20FT_GNTE_QTY" ).append("\n"); 
		query.append(",JO_20FT_TEU_QTY" ).append("\n"); 
		query.append(",JO_20FT_RND_RT" ).append("\n"); 
		query.append(",JO_45FT_GNTE_QTY" ).append("\n"); 
		query.append(",JO_45FT_OVR_TEU_QTY" ).append("\n"); 
		query.append(",JO_45FT_UND_TEU_QTY" ).append("\n"); 
		query.append(",JO_45FT_RND_RT" ).append("\n"); 
		query.append(",JO_RF_GNTE_OCN_QTY" ).append("\n"); 
		query.append(",JO_RF_GNTE_INTER_QTY" ).append("\n"); 
		query.append(",JO_BKG_TP_CD" ).append("\n"); 
		query.append(",AGMT_EFF_DT" ).append("\n"); 
		query.append(",AGMT_EXP_DT" ).append("\n"); 
		query.append(",DELT_FLG   " ).append("\n"); 
		query.append(",CRE_DT     " ).append("\n"); 
		query.append(",CRE_USR_ID " ).append("\n"); 
		query.append(",UPD_DT     " ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",JO_ALOC_ADJ_RMK" ).append("\n"); 
		query.append(",JO_ALOC_ADJ_TEU_QTY" ).append("\n"); 
		query.append(",JO_ALOC_ADJ_WGT" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append(" @[jo_ref_no] " ).append("\n"); 
		query.append(",@[jo_ref_seq]" ).append("\n"); 
		query.append(",@[ofc_cd]" ).append("\n"); 
		query.append(",@[re_divr_cd]" ).append("\n"); 
		query.append(",@[jo_crr_cd]" ).append("\n"); 
		query.append(",@[trd_cd]" ).append("\n"); 
		query.append(",@[rlane_cd]" ).append("\n"); 
		query.append(",@[jo_src_cd]" ).append("\n"); 
		query.append(",NVL(@[bsa_capa], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_ton_teu_qty], 0)" ).append("\n"); 
		query.append(",NVL(@[cgo_ton_wgt], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_ton_wgt_rnd_rt], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_40ft_gnte_qty], 0) " ).append("\n"); 
		query.append(",NVL(@[jo_40ft_teu_qty], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_40ft_rnd_rt], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_20ft_gnte_qty], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_20ft_teu_qty], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_20ft_rnd_rt], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_45ft_gnte_qty], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_45ft_ovr_teu_qty], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_45ft_und_teu_qty], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_45ft_rnd_rt], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_rf_gnte_ocn_qty], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_rf_gnte_inter_qty], 0)" ).append("\n"); 
		query.append(",@[jo_bkg_tp_cd]" ).append("\n"); 
		query.append(",REPLACE(@[agmt_eff_dt],'-','')" ).append("\n"); 
		query.append(",REPLACE(@[agmt_exp_dt],'-','')" ).append("\n"); 
		query.append(",NVL(@[delt_flg],'N')" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",@[jo_aloc_adj_rmk]" ).append("\n"); 
		query.append(",NVL(@[jo_aloc_adj_teu_qty], 0)" ).append("\n"); 
		query.append(",NVL(@[jo_aloc_adj_wgt], 0)" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}