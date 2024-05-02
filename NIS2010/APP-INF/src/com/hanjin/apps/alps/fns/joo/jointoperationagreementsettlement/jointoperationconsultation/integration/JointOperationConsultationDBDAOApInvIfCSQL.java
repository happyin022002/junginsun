/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationDBDAOApInvIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.25 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOApInvIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_INV_IF에 INSERT한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOApInvIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_ftu_n1st_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_inv_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_rcv_err_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_imp_err_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("row_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_err_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_inv_term_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_ppd_gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_err_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_pay_mzd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_coa_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_pay_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_tp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_row_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_coa_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_tax_curr_xch_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_cate_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_csr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_pay_grp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_ftu_n2nd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_coa_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_act_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_csr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_ppay_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftu_use_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftu_use_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftu_use_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftu_use_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftu_use_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_src_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt17",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_if_err_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt18",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_tax_decl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_coa_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_rcv_err_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_tj_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_sctr_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_ftu_use_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_ftu_use_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tax_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_ftu_use_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_ftu_use_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_ftu_use_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_glo_attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_vndr_term_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_ppd_dtrb_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_ppd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_cate_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_imp_err_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_coa_ftu_n1st_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_coa_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_csr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_coa_ftu_n2nd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_ppd_aply_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_attr_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOApInvIfCSQL").append("\n"); 
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
		query.append("INSERT INTO AP_INV_IF(" ).append("\n"); 
		query.append("AP_PGM_NO" ).append("\n"); 
		query.append(",INV_SEQ" ).append("\n"); 
		query.append(",TTL_ROW_KNT" ).append("\n"); 
		query.append(",ROW_KNT" ).append("\n"); 
		query.append(",HDR_CSR_NO" ).append("\n"); 
		query.append(",HDR_CSR_TP_CD" ).append("\n"); 
		query.append(",HDR_INV_DT" ).append("\n"); 
		query.append(",HDR_INV_TERM_DT" ).append("\n"); 
		query.append(",HDR_GL_DT" ).append("\n"); 
		query.append(",HDR_VNDR_NO" ).append("\n"); 
		query.append(",HDR_CSR_AMT" ).append("\n"); 
		query.append(",HDR_PAY_AMT" ).append("\n"); 
		query.append(",HDR_PAY_DT" ).append("\n"); 
		query.append(",HDR_CSR_CURR_CD" ).append("\n"); 
		query.append(",HDR_VNDR_TERM_NM" ).append("\n"); 
		query.append(",HDR_INV_DESC" ).append("\n"); 
		query.append(",HDR_ATTR_CATE_NM" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT1" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT2" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT3" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT4" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT5" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT6" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT7" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT8" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT9" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT10" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT11" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT12" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT13" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT14" ).append("\n"); 
		query.append(",HDR_ATTR_CTNT15" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT1" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT2" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT3" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT4" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT5" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT6" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT7" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT8" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT9" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT10" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT11" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT12" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT13" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT14" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT15" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT16" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT17" ).append("\n"); 
		query.append(",HDR_GLO_ATTR_CTNT18" ).append("\n"); 
		query.append(",HDR_SRC_CTNT" ).append("\n"); 
		query.append(",HDR_PAY_MZD_LU_CD" ).append("\n"); 
		query.append(",HDR_PAY_GRP_LU_CD" ).append("\n"); 
		query.append(",HDR_COA_CO_CD" ).append("\n"); 
		query.append(",HDR_COA_RGN_CD" ).append("\n"); 
		query.append(",HDR_COA_CTR_CD" ).append("\n"); 
		query.append(",HDR_COA_ACCT_CD" ).append("\n"); 
		query.append(",HDR_COA_VVD_CD" ).append("\n"); 
		query.append(",HDR_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",HDR_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(",HDR_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(",HDR_PPD_NO" ).append("\n"); 
		query.append(",HDR_PPD_DTRB_NO" ).append("\n"); 
		query.append(",HDR_PPD_APLY_AMT" ).append("\n"); 
		query.append(",HDR_PPD_GL_DT" ).append("\n"); 
		query.append(",HDR_APRO_FLG" ).append("\n"); 
		query.append(",HDR_TAX_DECL_FLG" ).append("\n"); 
		query.append(",HDR_ERR_CSR_NO" ).append("\n"); 
		query.append(",HDR_IF_FLG" ).append("\n"); 
		query.append(",HDR_IF_DT" ).append("\n"); 
		query.append(",HDR_IF_ERR_RSN" ).append("\n"); 
		query.append(",HDR_PPAY_APLY_FLG" ).append("\n"); 
		query.append(",HDR_TJ_OFC_CD" ).append("\n"); 
		query.append(",HDR_ACT_XCH_RT" ).append("\n"); 
		query.append(",HDR_IMP_ERR_FLG" ).append("\n"); 
		query.append(",HDR_RCV_ERR_FLG" ).append("\n"); 
		query.append(",HDR_TAX_CURR_XCH_FLG" ).append("\n"); 
		query.append(",HDR_USR_EML" ).append("\n"); 
		query.append(",HDR_IMP_ERR_RSN" ).append("\n"); 
		query.append(",HDR_RCV_ERR_RSN" ).append("\n"); 
		query.append(",HDR_FTU_USE_CTNT1" ).append("\n"); 
		query.append(",HDR_FTU_USE_CTNT2" ).append("\n"); 
		query.append(",HDR_FTU_USE_CTNT3" ).append("\n"); 
		query.append(",HDR_FTU_USE_CTNT4" ).append("\n"); 
		query.append(",HDR_FTU_USE_CTNT5" ).append("\n"); 
		query.append(",CSR_NO" ).append("\n"); 
		query.append(",LINE_SEQ" ).append("\n"); 
		query.append(",LINE_NO" ).append("\n"); 
		query.append(",LINE_TP_LU_CD" ).append("\n"); 
		query.append(",INV_AMT" ).append("\n"); 
		query.append(",INV_DESC" ).append("\n"); 
		query.append(",INV_TAX_CD" ).append("\n"); 
		query.append(",DTRB_COA_CO_CD" ).append("\n"); 
		query.append(",DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(",DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(",DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(",DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(",DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",DTRB_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(",DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(",ATTR_CATE_NM" ).append("\n"); 
		query.append(",ATTR_CTNT1" ).append("\n"); 
		query.append(",ATTR_CTNT2" ).append("\n"); 
		query.append(",ATTR_CTNT3" ).append("\n"); 
		query.append(",ATTR_CTNT4" ).append("\n"); 
		query.append(",ATTR_CTNT5" ).append("\n"); 
		query.append(",ATTR_CTNT6" ).append("\n"); 
		query.append(",ATTR_CTNT7" ).append("\n"); 
		query.append(",ATTR_CTNT8" ).append("\n"); 
		query.append(",ATTR_CTNT9" ).append("\n"); 
		query.append(",ATTR_CTNT10" ).append("\n"); 
		query.append(",ATTR_CTNT11" ).append("\n"); 
		query.append(",ATTR_CTNT12" ).append("\n"); 
		query.append(",ATTR_CTNT13" ).append("\n"); 
		query.append(",ATTR_CTNT14" ).append("\n"); 
		query.append(",ATTR_CTNT15" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",ACT_VVD_CD" ).append("\n"); 
		query.append(",PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append(",SO_CRR_CD" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",FTU_USE_CTNT1" ).append("\n"); 
		query.append(",FTU_USE_CTNT2" ).append("\n"); 
		query.append(",FTU_USE_CTNT3" ).append("\n"); 
		query.append(",FTU_USE_CTNT4" ).append("\n"); 
		query.append(",FTU_USE_CTNT5" ).append("\n"); 
		query.append(",SND_FLG" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",EAI_EVNT_DT" ).append("\n"); 
		query.append(",ESTM_ERR_RSN" ).append("\n"); 
		query.append(",TRSP_SO_TP_CD" ).append("\n"); 
		query.append(",SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",SO_SEQ" ).append("\n"); 
		query.append(",CGO_TP_CD" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("'ESDJOOXXX'||TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append(",NVL((SELECT /*+INDEX_DESC(A XPKAP_INV_IF)*/ A.INV_SEQ+1 FROM AP_INV_IF A WHERE A.AP_PGM_NO = 'ESDJOOXXX'||TO_CHAR(SYSDATE,'YYYYMMDD') AND ROWNUM = 1),1)" ).append("\n"); 
		query.append(",@[ttl_row_knt]" ).append("\n"); 
		query.append(",@[row_knt]" ).append("\n"); 
		query.append(",@[hdr_csr_no]" ).append("\n"); 
		query.append(",@[hdr_csr_tp_cd]" ).append("\n"); 
		query.append(",@[hdr_inv_dt]" ).append("\n"); 
		query.append(",@[hdr_inv_term_dt]" ).append("\n"); 
		query.append(",@[hdr_gl_dt]" ).append("\n"); 
		query.append(",@[hdr_vndr_no]" ).append("\n"); 
		query.append(",@[hdr_csr_amt]" ).append("\n"); 
		query.append(",@[hdr_pay_amt]" ).append("\n"); 
		query.append(",@[hdr_pay_dt]" ).append("\n"); 
		query.append(",@[hdr_csr_curr_cd]" ).append("\n"); 
		query.append(",@[hdr_vndr_term_nm]" ).append("\n"); 
		query.append(",@[hdr_inv_desc]" ).append("\n"); 
		query.append(",@[hdr_attr_cate_nm]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt1]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt2]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt3]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt4]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt5]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt6]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt7]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt8]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt9]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt10]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt11]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt12]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt13]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt14]" ).append("\n"); 
		query.append(",@[hdr_attr_ctnt15]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt1]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt2]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt3]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt4]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt5]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt6]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt7]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt8]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt9]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt10]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt11]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt12]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt13]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt14]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt15]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt16]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt17]" ).append("\n"); 
		query.append(",@[hdr_glo_attr_ctnt18]" ).append("\n"); 
		query.append(",@[hdr_src_ctnt]" ).append("\n"); 
		query.append(",@[hdr_pay_mzd_lu_cd]" ).append("\n"); 
		query.append(",@[hdr_pay_grp_lu_cd]" ).append("\n"); 
		query.append(",@[hdr_coa_co_cd]" ).append("\n"); 
		query.append(",@[hdr_coa_rgn_cd]" ).append("\n"); 
		query.append(",@[hdr_coa_ctr_cd]" ).append("\n"); 
		query.append(",@[hdr_coa_acct_cd]" ).append("\n"); 
		query.append(",@[hdr_coa_vvd_cd]" ).append("\n"); 
		query.append(",@[hdr_coa_inter_co_cd]" ).append("\n"); 
		query.append(",@[hdr_coa_ftu_n1st_cd]" ).append("\n"); 
		query.append(",@[hdr_coa_ftu_n2nd_cd]" ).append("\n"); 
		query.append(",@[hdr_ppd_no]" ).append("\n"); 
		query.append(",@[hdr_ppd_dtrb_no]" ).append("\n"); 
		query.append(",@[hdr_ppd_aply_amt]" ).append("\n"); 
		query.append(",@[hdr_ppd_gl_dt]" ).append("\n"); 
		query.append(",@[hdr_apro_flg]" ).append("\n"); 
		query.append(",@[hdr_tax_decl_flg]" ).append("\n"); 
		query.append(",@[hdr_err_csr_no]" ).append("\n"); 
		query.append(",@[hdr_if_flg]" ).append("\n"); 
		query.append(",@[hdr_if_dt]" ).append("\n"); 
		query.append(",@[hdr_if_err_rsn]" ).append("\n"); 
		query.append(",@[hdr_ppay_aply_flg]" ).append("\n"); 
		query.append(",@[hdr_tj_ofc_cd]" ).append("\n"); 
		query.append(",@[hdr_act_xch_rt]" ).append("\n"); 
		query.append(",@[hdr_imp_err_flg]" ).append("\n"); 
		query.append(",@[hdr_rcv_err_flg]" ).append("\n"); 
		query.append(",@[hdr_tax_curr_xch_flg]" ).append("\n"); 
		query.append(",@[hdr_usr_eml]" ).append("\n"); 
		query.append(",@[hdr_imp_err_rsn]" ).append("\n"); 
		query.append(",@[hdr_rcv_err_rsn]" ).append("\n"); 
		query.append(",@[hdr_ftu_use_ctnt1]" ).append("\n"); 
		query.append(",@[hdr_ftu_use_ctnt2]" ).append("\n"); 
		query.append(",@[hdr_ftu_use_ctnt3]" ).append("\n"); 
		query.append(",@[hdr_ftu_use_ctnt4]" ).append("\n"); 
		query.append(",@[hdr_ftu_use_ctnt5]" ).append("\n"); 
		query.append(",@[csr_no]" ).append("\n"); 
		query.append(",@[line_seq]" ).append("\n"); 
		query.append(",@[line_no]" ).append("\n"); 
		query.append(",@[line_tp_lu_cd]" ).append("\n"); 
		query.append(",@[inv_amt]" ).append("\n"); 
		query.append(",@[inv_desc]" ).append("\n"); 
		query.append(",@[inv_tax_cd]" ).append("\n"); 
		query.append(",@[dtrb_coa_co_cd]" ).append("\n"); 
		query.append(",@[dtrb_coa_rgn_cd]" ).append("\n"); 
		query.append(",@[dtrb_coa_ctr_cd]" ).append("\n"); 
		query.append(",@[dtrb_coa_acct_cd]" ).append("\n"); 
		query.append(",@[dtrb_coa_vvd_cd]" ).append("\n"); 
		query.append(",@[dtrb_coa_inter_co_cd]" ).append("\n"); 
		query.append(",@[dtrb_coa_ftu_n1st_cd]" ).append("\n"); 
		query.append(",@[dtrb_coa_ftu_n2nd_cd]" ).append("\n"); 
		query.append(",@[attr_cate_nm]" ).append("\n"); 
		query.append(",@[attr_ctnt1]" ).append("\n"); 
		query.append(",@[attr_ctnt2]" ).append("\n"); 
		query.append(",@[attr_ctnt3]" ).append("\n"); 
		query.append(",@[attr_ctnt4]" ).append("\n"); 
		query.append(",@[attr_ctnt5]" ).append("\n"); 
		query.append(",@[attr_ctnt6]" ).append("\n"); 
		query.append(",@[attr_ctnt7]" ).append("\n"); 
		query.append(",@[attr_ctnt8]" ).append("\n"); 
		query.append(",@[attr_ctnt9]" ).append("\n"); 
		query.append(",@[attr_ctnt10]" ).append("\n"); 
		query.append(",@[attr_ctnt11]" ).append("\n"); 
		query.append(",@[attr_ctnt12]" ).append("\n"); 
		query.append(",@[attr_ctnt13]" ).append("\n"); 
		query.append(",@[attr_ctnt14]" ).append("\n"); 
		query.append(",@[attr_ctnt15]" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",@[act_vvd_cd]" ).append("\n"); 
		query.append(",@[pln_sctr_div_cd]" ).append("\n"); 
		query.append(",@[so_crr_cd]" ).append("\n"); 
		query.append(",@[yd_cd]" ).append("\n"); 
		query.append(",@[ftu_use_ctnt1]" ).append("\n"); 
		query.append(",@[ftu_use_ctnt2]" ).append("\n"); 
		query.append(",@[ftu_use_ctnt3]" ).append("\n"); 
		query.append(",@[ftu_use_ctnt4]" ).append("\n"); 
		query.append(",@[ftu_use_ctnt5]" ).append("\n"); 
		query.append(",@[snd_flg]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",@[eai_evnt_dt]" ).append("\n"); 
		query.append(",@[estm_err_rsn]" ).append("\n"); 
		query.append(",@[trsp_so_tp_cd]" ).append("\n"); 
		query.append(",@[so_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[so_seq]" ).append("\n"); 
		query.append(",@[cgo_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}