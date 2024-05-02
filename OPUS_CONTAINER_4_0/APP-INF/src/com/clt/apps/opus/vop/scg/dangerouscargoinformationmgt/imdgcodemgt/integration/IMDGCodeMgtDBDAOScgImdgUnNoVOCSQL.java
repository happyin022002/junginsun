/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : IMDGCodeMgtDBDAOScgImdgUnNoVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGCodeMgtDBDAOScgImdgUnNoVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UN Number 입력   
	  * </pre>
	  */
	public IMDGCodeMgtDBDAOScgImdgUnNoVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_pck_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_ibc_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("segr_as_for_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_toxc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkg_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_tnk_instr_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_imdg_pck_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_xtd_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_mrn_polut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_bom_port_trst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_ht_src_stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_tbl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_lmt_qty_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_pck_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_imdg_ibc_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_imdg_ibc_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_pck_rstr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_imdg_pck_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_tnk_instr_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_add_segr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flsh_pnt_temp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_pck_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_imdg_tnk_instr_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_rstr_opr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_ibc_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_imdg_ibc_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_imdg_ibc_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_un_tnk_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_expt_qty_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prp_shp_nm_var_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_imdg_tnk_instr_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_comp_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lk_port_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_stwg_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_bom_port_trst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_expt_qty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clr_liv_qtr_stwg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_imdg_ibc_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_bom_port_trst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_imdg_ibc_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_ibc_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_lmt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_bom_port_trst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_sbst_ppt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_rstr_port_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_lmt_qty_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_emer_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_fd_stuf_stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_pck_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_rspn_gid_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_dg_wet_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_add_segr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_intmd_bc_rstr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_rpt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_imdg_tnk_instr_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_imdg_pck_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_tnk_rstr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_imdg_pck_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_ibc_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_amdt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_psn_inh_zn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_subs_rsk_lbl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_imdg_un_tnk_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("segr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_rspn_gid_chr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGCodeMgtDBDAOScgImdgUnNoVOCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_IMDG_UN_NO (" ).append("\n"); 
		query.append("	N4TH_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append(",	PKG_AUTH_NO" ).append("\n"); 
		query.append(",	LK_PORT_AUTH_NO" ).append("\n"); 
		query.append(",	IMDG_SBST_PPT_DESC" ).append("\n"); 
		query.append(",	CFR_RPT_QTY" ).append("\n"); 
		query.append(",	CFR_PSN_INH_ZN_CD" ).append("\n"); 
		query.append(",	CFR_TOXC_CD" ).append("\n"); 
		query.append(",	CFR_DG_WET_CD" ).append("\n"); 
		query.append(",	CFR_RSTR_PORT_NM" ).append("\n"); 
		query.append(",	CFR_RSTR_OPR_NM" ).append("\n"); 
		query.append(",	CFR_XTD_CLSS_CD" ).append("\n"); 
		query.append(",	HCDG_FLG" ).append("\n"); 
		query.append(",	HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append(",	HCDG_RMK" ).append("\n"); 
		query.append(",	N1ST_IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append(",	N2ND_IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append(",	N3RD_IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append(",	N1ST_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append(",	N2ND_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append(",	N3RD_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append(",	N4TH_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append(",	N5TH_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append(",	N1ST_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append(",	N2ND_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append(",	N3RD_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append(",	N4TH_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append(",	N5TH_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append(",	N1ST_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append(",	N2ND_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append(",	N3RD_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append(",	N4TH_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append(",	N5TH_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append(",	N1ST_IMDG_UN_TNK_INSTR_CD" ).append("\n"); 
		query.append(",	N2ND_IMDG_UN_TNK_INSTR_CD" ).append("\n"); 
		query.append(",	N1ST_IMDG_TNK_INSTR_PROVI_CD" ).append("\n"); 
		query.append(",	N2ND_IMDG_TNK_INSTR_PROVI_CD" ).append("\n"); 
		query.append(",	N3RD_IMDG_TNK_INSTR_PROVI_CD" ).append("\n"); 
		query.append(",	N4TH_IMDG_TNK_INSTR_PROVI_CD" ).append("\n"); 
		query.append(",	N5TH_IMDG_TNK_INSTR_PROVI_CD" ).append("\n"); 
		query.append(",	HCDG_PCK_RSTR_DESC" ).append("\n"); 
		query.append(",	HCDG_INTMD_BC_RSTR_DESC" ).append("\n"); 
		query.append(",	HCDG_TNK_RSTR_DESC" ).append("\n"); 
		query.append(",	SEGR_DESC" ).append("\n"); 
		query.append("--2016-05-27" ).append("\n"); 
		query.append(",   N1ST_ADD_SEGR_DESC" ).append("\n"); 
		query.append(",   N2ND_ADD_SEGR_DESC" ).append("\n"); 
		query.append("--2016-05-27" ).append("\n"); 
		query.append(",	CLR_LIV_QTR_STWG_FLG" ).append("\n"); 
		query.append(",	IMDG_FD_STUF_STWG_CD" ).append("\n"); 
		query.append(",	IMDG_HT_SRC_STWG_CD" ).append("\n"); 
		query.append(",	SEGR_AS_FOR_IMDG_CLSS_FLG" ).append("\n"); 
		query.append(",	SEGR_AS_FOR_IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	AWAY_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append(",	SPRT_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append(",	AWAY_FM_IMDG_SEGR_GRP_FLG" ).append("\n"); 
		query.append(",	SPRT_FM_IMDG_SEGR_GRP_FLG" ).append("\n"); 
		query.append(",	IMDG_TBL_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_HLD_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	IMDG_UN_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	PRP_SHP_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	PRP_SHP_NM_VAR_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_RMK" ).append("\n"); 
		query.append(",	IMDG_MRN_POLUT_CD" ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_MEAS_UT_CD" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_DESC" ).append("\n"); 
		query.append(",	IMDG_EXPT_QTY_CD" ).append("\n"); 
		query.append(",	IMDG_EXPT_QTY_DESC" ).append("\n"); 
		query.append(",	IMDG_EMER_NO" ).append("\n"); 
		query.append(",	IMDG_STWG_CATE_CD" ).append("\n"); 
		query.append(",	FLSH_PNT_TEMP_CTNT" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_NO" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append(",	PSA_NO" ).append("\n"); 
		query.append(",	N1ST_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append(",	N2ND_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append(",	N3RD_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append(",	SPRT_HLD_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append(",	SPRT_LON_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append(",	CFR_FLG" ).append("\n"); 
		query.append(",   IMDG_AMDT_NO" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[n4th_bom_port_trst_no]" ).append("\n"); 
		query.append(",	@[pkg_auth_no]" ).append("\n"); 
		query.append(",	@[lk_port_auth_no]" ).append("\n"); 
		query.append(",	@[imdg_sbst_ppt_desc]" ).append("\n"); 
		query.append(",	@[cfr_rpt_qty]" ).append("\n"); 
		query.append(",	@[cfr_psn_inh_zn_cd]" ).append("\n"); 
		query.append(",	@[cfr_toxc_cd]" ).append("\n"); 
		query.append(",	@[cfr_dg_wet_cd]" ).append("\n"); 
		query.append(",	@[cfr_rstr_port_nm]" ).append("\n"); 
		query.append(",	@[cfr_rstr_opr_nm]" ).append("\n"); 
		query.append(",	@[cfr_xtd_clss_cd]" ).append("\n"); 
		query.append("#if (${hcdg_flg} == '0')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hcdg_dpnd_qty_flg} == '0')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	@[hcdg_rmk]" ).append("\n"); 
		query.append(",	@[n1st_imdg_pck_instr_cd]" ).append("\n"); 
		query.append(",	@[n2nd_imdg_pck_instr_cd]" ).append("\n"); 
		query.append(",	@[n3rd_imdg_pck_instr_cd]" ).append("\n"); 
		query.append(",	@[n1st_imdg_pck_provi_cd]" ).append("\n"); 
		query.append(",	@[n2nd_imdg_pck_provi_cd]" ).append("\n"); 
		query.append(",	@[n3rd_imdg_pck_provi_cd]" ).append("\n"); 
		query.append(",	@[n4th_imdg_pck_provi_cd]" ).append("\n"); 
		query.append(",	@[n5th_imdg_pck_provi_cd]" ).append("\n"); 
		query.append(",	@[n1st_imdg_ibc_instr_cd]" ).append("\n"); 
		query.append(",	@[n2nd_imdg_ibc_instr_cd]" ).append("\n"); 
		query.append(",	@[n3rd_imdg_ibc_instr_cd]" ).append("\n"); 
		query.append(",	@[n4th_imdg_ibc_instr_cd]" ).append("\n"); 
		query.append(",	@[n5th_imdg_ibc_instr_cd]" ).append("\n"); 
		query.append(",	@[n1st_imdg_ibc_provi_cd]" ).append("\n"); 
		query.append(",	@[n2nd_imdg_ibc_provi_cd]" ).append("\n"); 
		query.append(",	@[n3rd_imdg_ibc_provi_cd]" ).append("\n"); 
		query.append(",	@[n4th_imdg_ibc_provi_cd]" ).append("\n"); 
		query.append(",	@[n5th_imdg_ibc_provi_cd]" ).append("\n"); 
		query.append(",	@[n1st_imdg_un_tnk_instr_cd]" ).append("\n"); 
		query.append(",	@[n2nd_imdg_un_tnk_instr_cd]" ).append("\n"); 
		query.append(",	@[n1st_imdg_tnk_instr_provi_cd]" ).append("\n"); 
		query.append(",	@[n2nd_imdg_tnk_instr_provi_cd]" ).append("\n"); 
		query.append(",	@[n3rd_imdg_tnk_instr_provi_cd]" ).append("\n"); 
		query.append(",	@[n4th_imdg_tnk_instr_provi_cd]" ).append("\n"); 
		query.append(",	@[n5th_imdg_tnk_instr_provi_cd]" ).append("\n"); 
		query.append(",	@[hcdg_pck_rstr_desc]" ).append("\n"); 
		query.append(",	@[hcdg_intmd_bc_rstr_desc]" ).append("\n"); 
		query.append(",	@[hcdg_tnk_rstr_desc]" ).append("\n"); 
		query.append(",	@[segr_desc]" ).append("\n"); 
		query.append("--2016-05-27" ).append("\n"); 
		query.append(",   @[n1st_add_segr_desc]" ).append("\n"); 
		query.append(",   @[n2nd_add_segr_desc]   " ).append("\n"); 
		query.append("--2016-05-27" ).append("\n"); 
		query.append(",	@[clr_liv_qtr_stwg_flg]" ).append("\n"); 
		query.append(",	@[imdg_fd_stuf_stwg_cd]" ).append("\n"); 
		query.append(",	@[imdg_ht_src_stwg_cd]" ).append("\n"); 
		query.append("#if (${segr_as_for_imdg_clss_flg} == '0')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	@[segr_as_for_imdg_clss_cd]" ).append("\n"); 
		query.append("#if (${away_fm_imdg_clss_flg} == '0')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprt_fm_imdg_clss_flg} == '0')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${away_fm_imdg_segr_grp_flg} == '0')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprt_fm_imdg_segr_grp_flg} == '0')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	@[imdg_tbl_no]" ).append("\n"); 
		query.append("#if (${imdg_un_no_hld_flg} == '0')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[imdg_un_no]" ).append("\n"); 
		query.append(",	@[imdg_un_no_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	@[prp_shp_nm]" ).append("\n"); 
		query.append(",	@[prp_shp_nm_var_rmk]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	@[imdg_clss_cd]" ).append("\n"); 
		query.append(",	@[imdg_comp_grp_cd]" ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_rmk]" ).append("\n"); 
		query.append(",	@[imdg_mrn_polut_cd]" ).append("\n"); 
		query.append(",	@[imdg_pck_grp_cd]" ).append("\n"); 
		query.append(",	@[imdg_lmt_qty]" ).append("\n"); 
		query.append(",	@[imdg_lmt_qty_meas_ut_cd]" ).append("\n"); 
		query.append(",	@[imdg_lmt_qty_desc]" ).append("\n"); 
		query.append(",	@[imdg_expt_qty_cd]" ).append("\n"); 
		query.append(",	@[imdg_expt_qty_desc]" ).append("\n"); 
		query.append(",	@[imdg_emer_no]" ).append("\n"); 
		query.append(",	@[imdg_stwg_cate_cd]" ).append("\n"); 
		query.append(",	@[flsh_pnt_temp_ctnt]" ).append("\n"); 
		query.append(",	@[emer_rspn_gid_no]" ).append("\n"); 
		query.append(",	@[emer_rspn_gid_chr_no]" ).append("\n"); 
		query.append(",	@[psa_no]" ).append("\n"); 
		query.append(",	@[n1st_bom_port_trst_no]" ).append("\n"); 
		query.append(",	@[n2nd_bom_port_trst_no]" ).append("\n"); 
		query.append(",	@[n3rd_bom_port_trst_no]" ).append("\n"); 
		query.append("#if (${sprt_hld_fm_imdg_clss_flg} == '0')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprt_lon_fm_imdg_clss_flg} == '0')" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cfr_flg} != '') " ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cfr_flg} != '') " ).append("\n"); 
		query.append(", ''" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", @[imdg_amdt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}