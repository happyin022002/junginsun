/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IMDGCodeMgtDBDAOScgImdgUnNoVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.15
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2014.07.15 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Won, Jong-Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGCodeMgtDBDAOScgImdgUnNoVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UN Number 수정   
	  * </pre>
	  */
	public IMDGCodeMgtDBDAOScgImdgUnNoVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("n2nd_imdg_un_tnk_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_lmt_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hcdg_tnk_rstr_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_sbst_ppt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_pck_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n5th_imdg_pck_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_comp_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n4th_imdg_ibc_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_imdg_ibc_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n4th_imdg_ibc_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flsh_pnt_temp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_imdg_un_tnk_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hcdg_pck_rstr_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n5th_imdg_ibc_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_imdg_pck_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n2nd_imdg_un_tnk_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_pck_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_imdg_tnk_instr_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cfr_dg_wet_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_ht_src_stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n2nd_imdg_pck_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n4th_imdg_pck_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n4th_bom_port_trst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("emer_rspn_gid_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_ibc_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n5th_imdg_pck_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n2nd_imdg_tnk_instr_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_ibc_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_imdg_ibc_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_mrn_polut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n4th_imdg_tnk_instr_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n4th_imdg_ibc_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_imdg_tnk_instr_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n5th_imdg_tnk_instr_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n5th_imdg_ibc_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_imdg_ibc_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_intmd_bc_rstr_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n2nd_bom_port_trst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_emer_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_ibc_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_tnk_instr_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_rspn_gid_chr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_imdg_tnk_instr_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n2nd_imdg_ibc_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_imdg_ibc_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_pck_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_imdg_tnk_instr_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_ibc_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n2nd_imdg_pck_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_imdg_pck_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_lmt_qty_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_ibc_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_imdg_pck_provi_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGCodeMgtDBDAOScgImdgUnNoVOUSQL").append("\n"); 
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
		query.append("UPDATE SCG_IMDG_UN_NO SET  " ).append("\n"); 
		query.append("	N4TH_BOM_PORT_TRST_NO = @[n4th_bom_port_trst_no]" ).append("\n"); 
		query.append(",	PKG_AUTH_NO = @[pkg_auth_no]" ).append("\n"); 
		query.append(",	LK_PORT_AUTH_NO = @[lk_port_auth_no]" ).append("\n"); 
		query.append(",	IMDG_SBST_PPT_DESC = @[imdg_sbst_ppt_desc]" ).append("\n"); 
		query.append(",	CFR_RPT_QTY = @[cfr_rpt_qty]" ).append("\n"); 
		query.append(",	CFR_PSN_INH_ZN_CD = @[cfr_psn_inh_zn_cd]" ).append("\n"); 
		query.append(",	CFR_TOXC_CD = @[cfr_toxc_cd]" ).append("\n"); 
		query.append(",	CFR_DG_WET_CD = @[cfr_dg_wet_cd]" ).append("\n"); 
		query.append(",	CFR_RSTR_PORT_NM = @[cfr_rstr_port_nm]" ).append("\n"); 
		query.append(",	CFR_RSTR_OPR_NM = @[cfr_rstr_opr_nm]" ).append("\n"); 
		query.append(",	CFR_XTD_CLSS_CD = @[cfr_xtd_clss_cd]" ).append("\n"); 
		query.append("#if (${hcdg_flg} == '0')" ).append("\n"); 
		query.append(",	HCDG_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	HCDG_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hcdg_dpnd_qty_flg} == '0')" ).append("\n"); 
		query.append(",	HCDG_DPND_QTY_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	HCDG_DPND_QTY_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	HCDG_RMK = @[hcdg_rmk]" ).append("\n"); 
		query.append(",	N1ST_IMDG_PCK_INSTR_CD = @[n1st_imdg_pck_instr_cd]" ).append("\n"); 
		query.append(",	N2ND_IMDG_PCK_INSTR_CD = @[n2nd_imdg_pck_instr_cd]" ).append("\n"); 
		query.append(",	N3RD_IMDG_PCK_INSTR_CD = @[n3rd_imdg_pck_instr_cd]" ).append("\n"); 
		query.append(",	N1ST_IMDG_PCK_PROVI_CD = @[n1st_imdg_pck_provi_cd]" ).append("\n"); 
		query.append(",	N2ND_IMDG_PCK_PROVI_CD = @[n2nd_imdg_pck_provi_cd]" ).append("\n"); 
		query.append(",	N3RD_IMDG_PCK_PROVI_CD = @[n3rd_imdg_pck_provi_cd]" ).append("\n"); 
		query.append(",	N4TH_IMDG_PCK_PROVI_CD = @[n4th_imdg_pck_provi_cd]" ).append("\n"); 
		query.append(",	N5TH_IMDG_PCK_PROVI_CD = @[n5th_imdg_pck_provi_cd]" ).append("\n"); 
		query.append(",	N1ST_IMDG_IBC_INSTR_CD = @[n1st_imdg_ibc_instr_cd]" ).append("\n"); 
		query.append(",	N2ND_IMDG_IBC_INSTR_CD = @[n2nd_imdg_ibc_instr_cd]" ).append("\n"); 
		query.append(",	N3RD_IMDG_IBC_INSTR_CD = @[n3rd_imdg_ibc_instr_cd]" ).append("\n"); 
		query.append(",	N4TH_IMDG_IBC_INSTR_CD = @[n4th_imdg_ibc_instr_cd]" ).append("\n"); 
		query.append(",	N5TH_IMDG_IBC_INSTR_CD = @[n5th_imdg_ibc_instr_cd]" ).append("\n"); 
		query.append(",	N1ST_IMDG_IBC_PROVI_CD = @[n1st_imdg_ibc_provi_cd]" ).append("\n"); 
		query.append(",	N2ND_IMDG_IBC_PROVI_CD = @[n2nd_imdg_ibc_provi_cd]" ).append("\n"); 
		query.append(",	N3RD_IMDG_IBC_PROVI_CD = @[n3rd_imdg_ibc_provi_cd]" ).append("\n"); 
		query.append(",	N4TH_IMDG_IBC_PROVI_CD = @[n4th_imdg_ibc_provi_cd]" ).append("\n"); 
		query.append(",	N5TH_IMDG_IBC_PROVI_CD = @[n5th_imdg_ibc_provi_cd]" ).append("\n"); 
		query.append(",	N1ST_IMDG_UN_TNK_INSTR_CD = @[n1st_imdg_un_tnk_instr_cd]" ).append("\n"); 
		query.append(",	N2ND_IMDG_UN_TNK_INSTR_CD = @[n2nd_imdg_un_tnk_instr_cd]" ).append("\n"); 
		query.append(",	N1ST_IMDG_TNK_INSTR_PROVI_CD = @[n1st_imdg_tnk_instr_provi_cd]" ).append("\n"); 
		query.append(",	N2ND_IMDG_TNK_INSTR_PROVI_CD = @[n2nd_imdg_tnk_instr_provi_cd]" ).append("\n"); 
		query.append(",	N3RD_IMDG_TNK_INSTR_PROVI_CD = @[n3rd_imdg_tnk_instr_provi_cd]" ).append("\n"); 
		query.append(",	N4TH_IMDG_TNK_INSTR_PROVI_CD = @[n4th_imdg_tnk_instr_provi_cd]" ).append("\n"); 
		query.append(",	N5TH_IMDG_TNK_INSTR_PROVI_CD = @[n5th_imdg_tnk_instr_provi_cd]" ).append("\n"); 
		query.append(",	N1ST_IMDG_PCK_INSTR_SEQ = DECODE(@[n1st_imdg_pck_instr_cd], null, null, NVL(@[n1st_imdg_pck_instr_seq], 2))" ).append("\n"); 
		query.append(",	N2ND_IMDG_PCK_INSTR_SEQ = DECODE(@[n2nd_imdg_pck_instr_cd], null, null, NVL(@[n2nd_imdg_pck_instr_seq], 2))" ).append("\n"); 
		query.append(",	N3RD_IMDG_PCK_INSTR_SEQ = DECODE(@[n3rd_imdg_pck_instr_cd], null, null, NVL(@[n3rd_imdg_pck_instr_seq], 2))" ).append("\n"); 
		query.append(",	N1ST_IMDG_PCK_PROVI_SEQ = DECODE(@[n1st_imdg_pck_provi_cd], null, null, NVL(@[n1st_imdg_pck_provi_seq], 2))" ).append("\n"); 
		query.append(",	N2ND_IMDG_PCK_PROVI_SEQ = DECODE(@[n2nd_imdg_pck_provi_cd], null, null, NVL(@[n2nd_imdg_pck_provi_seq], 2))" ).append("\n"); 
		query.append(",	N3RD_IMDG_PCK_PROVI_SEQ = DECODE(@[n3rd_imdg_pck_provi_cd], null, null, NVL(@[n3rd_imdg_pck_provi_seq], 2))" ).append("\n"); 
		query.append(",	N4TH_IMDG_PCK_PROVI_SEQ = DECODE(@[n4th_imdg_pck_provi_cd], null, null, NVL(@[n4th_imdg_pck_provi_seq], 2))" ).append("\n"); 
		query.append(",	N5TH_IMDG_PCK_PROVI_SEQ = DECODE(@[n5th_imdg_pck_provi_cd], null, null, NVL(@[n5th_imdg_pck_provi_seq], 2))" ).append("\n"); 
		query.append(",	N1ST_IMDG_IBC_INSTR_SEQ = DECODE(@[n1st_imdg_ibc_instr_cd], null, null, NVL(@[n1st_imdg_ibc_instr_seq], 2))" ).append("\n"); 
		query.append(",	N2ND_IMDG_IBC_INSTR_SEQ = DECODE(@[n2nd_imdg_ibc_instr_cd], null, null, NVL(@[n2nd_imdg_ibc_instr_seq], 2))" ).append("\n"); 
		query.append(",	N3RD_IMDG_IBC_INSTR_SEQ = DECODE(@[n3rd_imdg_ibc_instr_cd], null, null, NVL(@[n3rd_imdg_ibc_instr_seq], 2))" ).append("\n"); 
		query.append(",	N4TH_IMDG_IBC_INSTR_SEQ = DECODE(@[n4th_imdg_ibc_instr_cd], null, null, NVL(@[n4th_imdg_ibc_instr_seq], 2))" ).append("\n"); 
		query.append(",	N5TH_IMDG_IBC_INSTR_SEQ = DECODE(@[n5th_imdg_ibc_instr_cd], null, null, NVL(@[n5th_imdg_ibc_instr_seq], 2))" ).append("\n"); 
		query.append(",	N1ST_IMDG_IBC_PROVI_SEQ = DECODE(@[n1st_imdg_ibc_provi_cd], null, null, NVL(@[n1st_imdg_ibc_provi_seq], 2))" ).append("\n"); 
		query.append(",	N2ND_IMDG_IBC_PROVI_SEQ = DECODE(@[n2nd_imdg_ibc_provi_cd], null, null, NVL(@[n2nd_imdg_ibc_provi_seq], 2))" ).append("\n"); 
		query.append(",	N3RD_IMDG_IBC_PROVI_SEQ = DECODE(@[n3rd_imdg_ibc_provi_cd], null, null, NVL(@[n3rd_imdg_ibc_provi_seq], 2))" ).append("\n"); 
		query.append(",	N4TH_IMDG_IBC_PROVI_SEQ = DECODE(@[n4th_imdg_ibc_provi_cd], null, null, NVL(@[n4th_imdg_ibc_provi_seq], 2))" ).append("\n"); 
		query.append(",	N5TH_IMDG_IBC_PROVI_SEQ = DECODE(@[n5th_imdg_ibc_provi_cd], null, null, NVL(@[n5th_imdg_ibc_provi_seq], 2))" ).append("\n"); 
		query.append(",   N1ST_IMDG_UN_TNK_INSTR_SEQ    = DECODE(@[n1st_imdg_un_tnk_instr_cd], null, null, NVL(@[n1st_imdg_un_tnk_instr_seq], 2))" ).append("\n"); 
		query.append(",   N2ND_IMDG_UN_TNK_INSTR_SEQ    = DECODE(@[n2nd_imdg_un_tnk_instr_cd], null, null, NVL(@[n2nd_imdg_un_tnk_instr_seq], 2))" ).append("\n"); 
		query.append(",   N1ST_IMDG_TNK_INSTR_PROVI_SEQ = DECODE(@[n1st_imdg_tnk_instr_provi_cd], null, null, NVL(@[n1st_imdg_tnk_instr_provi_seq], 2))" ).append("\n"); 
		query.append(",   N2ND_IMDG_TNK_INSTR_PROVI_SEQ = DECODE(@[n2nd_imdg_tnk_instr_provi_cd], null, null, NVL(@[n2nd_imdg_tnk_instr_provi_seq], 2))" ).append("\n"); 
		query.append(",   N3RD_IMDG_TNK_INSTR_PROVI_SEQ = DECODE(@[n3rd_imdg_tnk_instr_provi_cd], null, null, NVL(@[n3rd_imdg_tnk_instr_provi_seq], 2))" ).append("\n"); 
		query.append(",   N4TH_IMDG_TNK_INSTR_PROVI_SEQ = DECODE(@[n4th_imdg_tnk_instr_provi_cd], null, null, NVL(@[n4th_imdg_tnk_instr_provi_seq], 2))" ).append("\n"); 
		query.append(",   N5TH_IMDG_TNK_INSTR_PROVI_SEQ = DECODE(@[n5th_imdg_tnk_instr_provi_cd], null, null, NVL(@[n5th_imdg_tnk_instr_provi_seq], 2))" ).append("\n"); 
		query.append(",	HCDG_PCK_RSTR_DESC = @[hcdg_pck_rstr_desc]" ).append("\n"); 
		query.append(",	HCDG_INTMD_BC_RSTR_DESC = @[hcdg_intmd_bc_rstr_desc]" ).append("\n"); 
		query.append(",	HCDG_TNK_RSTR_DESC = @[hcdg_tnk_rstr_desc]" ).append("\n"); 
		query.append(",	SEGR_DESC = @[segr_desc]" ).append("\n"); 
		query.append(",	CLR_LIV_QTR_STWG_FLG = @[clr_liv_qtr_stwg_flg]" ).append("\n"); 
		query.append(",	IMDG_FD_STUF_STWG_CD = @[imdg_fd_stuf_stwg_cd]" ).append("\n"); 
		query.append(",	IMDG_HT_SRC_STWG_CD = @[imdg_ht_src_stwg_cd]" ).append("\n"); 
		query.append("#if (${segr_as_for_imdg_clss_flg} == '0')" ).append("\n"); 
		query.append(",	SEGR_AS_FOR_IMDG_CLSS_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	SEGR_AS_FOR_IMDG_CLSS_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	SEGR_AS_FOR_IMDG_CLSS_CD = @[segr_as_for_imdg_clss_cd]" ).append("\n"); 
		query.append("#if (${away_fm_imdg_clss_flg} == '0')" ).append("\n"); 
		query.append(",	AWAY_FM_IMDG_CLSS_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	AWAY_FM_IMDG_CLSS_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprt_fm_imdg_clss_flg} == '0')" ).append("\n"); 
		query.append(",	SPRT_FM_IMDG_CLSS_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	SPRT_FM_IMDG_CLSS_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprt_hld_fm_imdg_clss_flg} == '0')" ).append("\n"); 
		query.append(",	SPRT_HLD_FM_IMDG_CLSS_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	SPRT_HLD_FM_IMDG_CLSS_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprt_lon_fm_imdg_clss_flg} == '0')" ).append("\n"); 
		query.append(",	SPRT_LON_FM_IMDG_CLSS_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	SPRT_LON_FM_IMDG_CLSS_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${away_fm_imdg_segr_grp_flg} == '0')" ).append("\n"); 
		query.append(",	AWAY_FM_IMDG_SEGR_GRP_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	AWAY_FM_IMDG_SEGR_GRP_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sprt_fm_imdg_segr_grp_flg} == '0')" ).append("\n"); 
		query.append(",	SPRT_FM_IMDG_SEGR_GRP_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	SPRT_FM_IMDG_SEGR_GRP_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	IMDG_TBL_NO = @[imdg_tbl_no]" ).append("\n"); 
		query.append("#if (${imdg_un_no_hld_flg} == '0')" ).append("\n"); 
		query.append(",	IMDG_UN_NO_HLD_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	IMDG_UN_NO_HLD_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append(",   EAI_IF_FLG = ''" ).append("\n"); 
		query.append(",	PRP_SHP_NM = @[prp_shp_nm]" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append(",	IMDG_COMP_GRP_CD = @[imdg_comp_grp_cd]" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_RMK = @[imdg_subs_rsk_lbl_rmk]" ).append("\n"); 
		query.append(",	IMDG_MRN_POLUT_CD = @[imdg_mrn_polut_cd]" ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD = @[imdg_pck_grp_cd]" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY = @[imdg_lmt_qty]" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_MEAS_UT_CD = @[imdg_lmt_qty_meas_ut_cd]" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_DESC = @[imdg_lmt_qty_desc]" ).append("\n"); 
		query.append(",	IMDG_EXPT_QTY_CD = @[imdg_expt_qty_cd]" ).append("\n"); 
		query.append(",	IMDG_EXPT_QTY_DESC = @[imdg_expt_qty_desc]" ).append("\n"); 
		query.append(",	IMDG_EMER_NO = @[imdg_emer_no]" ).append("\n"); 
		query.append(",	IMDG_STWG_CATE_CD = @[imdg_stwg_cate_cd]" ).append("\n"); 
		query.append(",	FLSH_PNT_TEMP_CTNT = @[flsh_pnt_temp_ctnt]" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_NO = @[emer_rspn_gid_no]" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_CHR_NO = @[emer_rspn_gid_chr_no]" ).append("\n"); 
		query.append(",	PSA_NO = @[psa_no]" ).append("\n"); 
		query.append(",	N1ST_BOM_PORT_TRST_NO = @[n1st_bom_port_trst_no]" ).append("\n"); 
		query.append(",	N2ND_BOM_PORT_TRST_NO = @[n2nd_bom_port_trst_no]" ).append("\n"); 
		query.append(",	N3RD_BOM_PORT_TRST_NO = @[n3rd_bom_port_trst_no]" ).append("\n"); 
		query.append("WHERE	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("AND	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 

	}
}