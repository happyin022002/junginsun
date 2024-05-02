/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOsearchMdmOrzByOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchMdmOrzByOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ofc cd를 이용하여 mdm organization 정보를 조회한다.
	  * </pre>
	  */
	public BookingUtilDBDAOsearchMdmOrzByOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchMdmOrzByOfcCdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	sub_agn_flg" ).append("\n"); 
		query.append(",	rep_cust_cnt_cd" ).append("\n"); 
		query.append(",	rep_cust_seq" ).append("\n"); 
		query.append(",	inv_pfx_cd" ).append("\n"); 
		query.append(",	ap_ofc_cd" ).append("\n"); 
		query.append(",	ap_ctrl_ofc_cd" ).append("\n"); 
		query.append(",	ap_ho_acct_cd" ).append("\n"); 
		query.append(",	ap_ctr_cd" ).append("\n"); 
		query.append(",	ar_agn_stl_cd" ).append("\n"); 
		query.append(",	fx_curr_rt" ).append("\n"); 
		query.append(",	ap_euro_curr_use_flg" ).append("\n"); 
		query.append(",	usa_brk_brnc_rqst_ctrl_ofc_cd" ).append("\n"); 
		query.append(",	asa_cr_term_dys" ).append("\n"); 
		query.append(",	so_if_cd" ).append("\n"); 
		query.append(",	sls_ofc_use_flg" ).append("\n"); 
		query.append(",	sls_ofc_div_cd" ).append("\n"); 
		query.append(",	ofc_tax_id" ).append("\n"); 
		query.append(",	ofc_rfa_sc_use_flg" ).append("\n"); 
		query.append(",	comm_if_ind_cd" ).append("\n"); 
		query.append(",	fax_ip" ).append("\n"); 
		query.append(",	bfr_ofc_cd" ).append("\n"); 
		query.append(",	modi_ofc_cd" ).append("\n"); 
		query.append(",	ofc_cmmc_cd" ).append("\n"); 
		query.append(",	ofc_tp_cd" ).append("\n"); 
		query.append(",	prc_ofc_cd" ).append("\n"); 
		query.append(",	ofc_url" ).append("\n"); 
		query.append(",	ofc_rep_eml" ).append("\n"); 
		query.append(",	bkg_svr_srch_rout_cd" ).append("\n"); 
		query.append(",	ofc_sls_delt_flg" ).append("\n"); 
		query.append(",	doc_rcvr_hide_flg" ).append("\n"); 
		query.append(",	finc_hide_flg" ).append("\n"); 
		query.append(",	finc_psdo_ofc_flg" ).append("\n"); 
		query.append(",	subs_co_flg" ).append("\n"); 
		query.append(",	gl_ctr_cd" ).append("\n"); 
		query.append(",	team_mgr_nm" ).append("\n"); 
		query.append(",	team_fax_no" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append(",	delt_flg" ).append("\n"); 
		query.append(",	eai_evnt_dt" ).append("\n"); 
		query.append(",	ofc_cd" ).append("\n"); 
		query.append(",	ofc_eng_nm" ).append("\n"); 
		query.append(",	ofc_krn_nm" ).append("\n"); 
		query.append(",	ofc_addr" ).append("\n"); 
		query.append(",	ofc_zip_cd" ).append("\n"); 
		query.append(",	ofc_knd_cd" ).append("\n"); 
		query.append(",	agn_knd_cd" ).append("\n"); 
		query.append(",	vndr_cnt_cd" ).append("\n"); 
		query.append(",	vndr_seq" ).append("\n"); 
		query.append(",	intl_phn_no" ).append("\n"); 
		query.append(",	ofc_phn_no" ).append("\n"); 
		query.append(",	intl_fax_no" ).append("\n"); 
		query.append(",	ofc_fax_no" ).append("\n"); 
		query.append(",	ofc_pson_knt" ).append("\n"); 
		query.append(",	ofc_rmk" ).append("\n"); 
		query.append(",	loc_cd" ).append("\n"); 
		query.append(",	bil_curr_cd" ).append("\n"); 
		query.append(",	ar_curr_cd" ).append("\n"); 
		query.append(",	ar_ctr_cd" ).append("\n"); 
		query.append(",	prnt_ofc_cd" ).append("\n"); 
		query.append(",	opn_dt" ).append("\n"); 
		query.append(",	clz_dt" ).append("\n"); 
		query.append(",	finc_rgn_cd" ).append("\n"); 
		query.append(",	ar_ofc_cd" ).append("\n"); 
		query.append(",	ar_ctrl_ofc_cd" ).append("\n"); 
		query.append(",	ar_hd_qtr_ofc_cd" ).append("\n"); 
		query.append(",	ib_cr_term_dys" ).append("\n"); 
		query.append(",	ob_cr_term_dys" ).append("\n"); 
		query.append("FROM mdm_organization" ).append("\n"); 
		query.append("WHERE	ofc_cd = @[ofc_cd]" ).append("\n"); 
		query.append("AND DELT_FLG ='N'" ).append("\n"); 

	}
}