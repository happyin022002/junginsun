/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPSearchDBDAOSearchBookingAllDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.09.08 오현경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchBookingAllDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking info
	  * </pre>
	  */
	public COPSearchDBDAOSearchBookingAllDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchBookingAllDetailRSQL").append("\n"); 
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
		query.append("SELECT bl_no" ).append("\n"); 
		query.append(",(SELECT cust_ref_no_ctnt" ).append("\n"); 
		query.append("FROM bkg_reference" ).append("\n"); 
		query.append("WHERE bkg_ref_tp_cd = 'EBRF' AND bkg_no = 	b.bkg_no) AS ref_no" ).append("\n"); 
		query.append(", vsl_cd" ).append("\n"); 
		query.append(", skd_voy_no --skd_voyage_no," ).append("\n"); 
		query.append(", skd_dir_cd" ).append("\n"); 
		query.append(", b.por_cd --por_loc ," ).append("\n"); 
		query.append(", b.pol_cd --pol_loc," ).append("\n"); 
		query.append(", b.pod_cd --pod_loc," ).append("\n"); 
		query.append(", b.del_cd --del_loc," ).append("\n"); 
		query.append(", rcv_term_cd --bkg_rcv_term," ).append("\n"); 
		query.append(", de_term_cd --bkg_dlv_term," ).append("\n"); 
		query.append(", doc.meas_qty AS bkg_meas_qty --bkg_mea_qty,	 --삭제" ).append("\n"); 
		query.append(", doc.meas_ut_cd AS bkg_meas_tp_cd --bkg_mea_tp,	  --삭제" ).append("\n"); 
		query.append(", doc.act_wgt AS act_bkg_wgt --bkg_actwgt_qty,	No-Match!" ).append("\n"); 
		query.append(", doc.wgt_ut_cd AS act_bkg_wgt_tp_cd --bkg_actwgt_tp,	--삭제" ).append("\n"); 
		query.append(", hot_de_flg AS bkg_hot_de_flg --bkg_hot,  	--삭제" ).append("\n"); 
		query.append(", dcgo_flg--, spcl_dg_cgo_fl --bkg_spe_dg," ).append("\n"); 
		query.append(", rc_flg--, spcl_rc_flg --bkg_spe_rf," ).append("\n"); 
		query.append(", awk_cgo_flg--, b.spcl_awk_cgo_flg --bkg_spe_ak," ).append("\n"); 
		query.append(", bb_cgo_flg--, spcl_bb_cgo_flg --bkg_spe_bb," ).append("\n"); 
		query.append(", rd_cgo_flg--, spcl_rd_cgo_flg --bkg_spe_rd," ).append("\n"); 
		query.append(", b.bkg_ofc_cd --bkg_ofc," ).append("\n"); 
		query.append(", ob_sls_ofc_cd--, bkg_sls_ofc_cd --sal_ofc," ).append("\n"); 
		query.append(", doc_usr_id--, bkg_doc_usr_id --bkg_stf," ).append("\n"); 
		query.append(", ob_srep_cd--, sl_rep_cd --srep_cd," ).append("\n"); 
		query.append(", b.rep_cmdt_cd --rep_cmdt_desc," ).append("\n"); 
		query.append(", sh.cust_cnt_cd as sh_cust_cnt_cd" ).append("\n"); 
		query.append(", lpad(sh.cust_seq, 6, '0') as sh_cust_seq" ).append("\n"); 
		query.append(", sh.cust_nm as sh_cust_nm" ).append("\n"); 
		query.append(", cn.cust_cnt_cd as cn_cust_cnt_cd" ).append("\n"); 
		query.append(", lpad(cn.cust_seq, 6, '0') as cn_cust_seq" ).append("\n"); 
		query.append(", cn.cust_nm as cn_cust_nm" ).append("\n"); 
		query.append(", nf.cust_cnt_cd as nf_cust_cnt_cd" ).append("\n"); 
		query.append(", lpad(nf.cust_seq, 6, '0') as nf_cust_seq" ).append("\n"); 
		query.append(", nf.cust_nm as nf_cust_nm" ).append("\n"); 
		query.append(", to_char(bkg_cre_dt,'yyyy-mm-dd') as bkg_cre_dt" ).append("\n"); 
		query.append(", cntr_tpsz_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  bkg_booking b, bkg_customer sh, bkg_customer cn, bkg_customer nf, sce_cop_hdr c" ).append("\n"); 
		query.append(",bkg_bl_doc doc" ).append("\n"); 
		query.append("WHERE  b.bkg_no = sh.bkg_no" ).append("\n"); 
		query.append("AND  b.bkg_no = cn.bkg_no" ).append("\n"); 
		query.append("AND  b.bkg_no = nf.bkg_no" ).append("\n"); 
		query.append("AND  b.bkg_no = doc.bkg_no" ).append("\n"); 
		query.append("AND  sh.bkg_cust_tp_cd = 'S'" ).append("\n"); 
		query.append("AND  cn.bkg_cust_tp_cd = 'C'" ).append("\n"); 
		query.append("AND  nf.bkg_cust_tp_cd = 'N'" ).append("\n"); 
		query.append("AND  B.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#if (${cop_no} != '')" ).append("\n"); 
		query.append("AND c.cop_no =  @[cop_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}