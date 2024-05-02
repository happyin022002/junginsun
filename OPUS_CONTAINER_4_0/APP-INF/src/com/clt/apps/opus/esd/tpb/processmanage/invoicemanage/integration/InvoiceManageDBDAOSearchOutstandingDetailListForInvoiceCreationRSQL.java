/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchOutstandingDetailListForInvoiceCreationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchOutstandingDetailListForInvoiceCreationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOutstandingDetailListForInvoiceCreation
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchOutstandingDetailListForInvoiceCreationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_from_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchOutstandingDetailListForInvoiceCreationRSQL").append("\n"); 
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
		query.append("SELECT a.n3pty_no" ).append("\n"); 
		query.append("    ,a.n3pty_bil_tp_cd" ).append("\n"); 
		query.append("    ,TPB_GET_N3PTY_BIL_TP_NM_FNC(a.n3pty_bil_tp_cd) AS n3pty_bil_tp_nm" ).append("\n"); 
		query.append("    ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01132',a.eq_knd_cd)  eq_knd_nm" ).append("\n"); 
		query.append("    ,a.eq_no" ).append("\n"); 
		query.append("    ,a.eq_tpsz_cd" ).append("\n"); 
		query.append("    ,a.bkg_no	bkg_no_all" ).append("\n"); 
		query.append("    ,a.bl_no	bl_no_all" ).append("\n"); 
		query.append("    ,a.vsl_cd||a.skd_voy_no||substr(a.finc_dir_cd,1,1)	vvd" ).append("\n"); 
		query.append("    ,a.vvd_cd" ).append("\n"); 
		query.append("    ,'' mgset_no" ).append("\n"); 
		query.append("    ,a.yd_cd" ).append("\n"); 
		query.append("    ,DECODE(a.fm_nod_cd,NULL,'',a.fm_nod_cd||'-'||a.via_nod_cd||'-'||a.to_nod_cd||'-'||a.dor_nod_cd) route" ).append("\n"); 
		query.append("    ,'' new_eq_no" ).append("\n"); 
		query.append("    ,'' new_cntr_seal_no" ).append("\n"); 
		query.append("    ,'' cita_no" ).append("\n"); 
		query.append("    ,'' cntr_wgt" ).append("\n"); 
		query.append("    ,'' n3pty_cntr_wgt_ut_cd" ).append("\n"); 
		query.append("    ,'' wt_hrs" ).append("\n"); 
		query.append("    ,'' new_vsl_cd" ).append("\n"); 
		query.append("    ,'' new_vvd" ).append("\n"); 
		query.append("    ,'' new_bkg_no" ).append("\n"); 
		query.append("    ,'' damage_dt" ).append("\n"); 
		query.append("    ,'' repair_location" ).append("\n"); 
		query.append("    ,'' last_free_dt" ).append("\n"); 
		query.append("    ,'' pkup_dt" ).append("\n"); 
		query.append("    ,'' ft_ovr_dys" ).append("\n"); 
		query.append("    ,a.csr_no" ).append("\n"); 
		query.append("    ,a.gl_dt" ).append("\n"); 
		query.append("#if (${s_from_curr_cd} != '' && ${s_curr_cd} != '') " ).append("\n"); 
		query.append("	,TPB_GET_INV_CURR_CHG_FNC(@[s_from_curr_cd],@[s_curr_cd],a.ots_amt, SYSDATE) AS ots_amt" ).append("\n"); 
		query.append("	,TPB_GET_INV_CURR_CHG_FNC(@[s_from_curr_cd],@[s_curr_cd],a.ots_amt, SYSDATE) AS inv_dtl_amt" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	,a.ots_amt" ).append("\n"); 
		query.append("	,a.ots_amt inv_dtl_amt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,a.eq_knd_cd" ).append("\n"); 
		query.append("    ,a.fm_nod_cd" ).append("\n"); 
		query.append("    ,a.via_nod_cd" ).append("\n"); 
		query.append("    ,a.to_nod_cd" ).append("\n"); 
		query.append("    ,a.dor_nod_cd" ).append("\n"); 
		query.append("    ,a.bkg_no" ).append("\n"); 
		query.append("    ,a.bl_no" ).append("\n"); 
		query.append("    ,a.vsl_cd" ).append("\n"); 
		query.append("    ,a.skd_voy_no" ).append("\n"); 
		query.append("    ,substr(a.finc_dir_cd,1,1) skd_dir_cd" ).append("\n"); 
		query.append("    ,a.estm_sys_area_grp_id estm_svr_id" ).append("\n"); 
		query.append("     ,a.ots_amt	original_inv_dtl_amt" ).append("\n"); 
		query.append("    ,0 so_if_seq" ).append("\n"); 
		query.append("    ,a.lgs_cost_cd" ).append("\n"); 
		query.append("    ,a.acct_cd" ).append("\n"); 
		query.append("    ,a.so_no" ).append("\n"); 
		query.append("    ,a.finc_dir_cd" ).append("\n"); 
		query.append("    ,a.rev_amt" ).append("\n"); 
		query.append("    ,a.ots_dtl_seq" ).append("\n"); 
		query.append("	,a.n3pty_expn_tp_cd" ).append("\n"); 
		query.append("	,a.n3pty_if_tp_cd" ).append("\n"); 
		query.append("	,a.estm_seq_no" ).append("\n"); 
		query.append("	,a.estm_rvis_no" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL a, TPB_OTS_GRP b" ).append("\n"); 
		query.append("WHERE a.n3pty_no = b.n3pty_no" ).append("\n"); 
		query.append("AND	  a.n3pty_no IN ( NULL" ).append("\n"); 
		query.append("#if (${s_dao_n3pty_no} != '') " ).append("\n"); 
		query.append("	, $s_dao_n3pty_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND a.vndr_cust_div_cd IN ('V','C') " ).append("\n"); 
		query.append("AND a.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("      SELECT n3pty_no" ).append("\n"); 
		query.append("      FROM tpb_ots_grp_sts c" ).append("\n"); 
		query.append("      WHERE c.n3pty_no = a.n3pty_no" ).append("\n"); 
		query.append("        AND c.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("        AND c.ots_sts_cd IN ('O','M','J') " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("AND ( B.n3pty_inv_no IS NULL" ).append("\n"); 
		query.append("    OR" ).append("\n"); 
		query.append("    NOT EXISTS (" ).append("\n"); 
		query.append("          SELECT n3pty_inv_no" ).append("\n"); 
		query.append("          FROM tpb_invoice v" ).append("\n"); 
		query.append("          WHERE v.n3pty_inv_no = B.n3pty_inv_no" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )    " ).append("\n"); 
		query.append("ORDER BY a.n3pty_bil_tp_cd    " ).append("\n"); 

	}
}