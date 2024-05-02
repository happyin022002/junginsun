/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InvoiceInquiryDBDAOsearchInvoiceEquipmentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.17
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2013.12.17 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yun kwon-young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryDBDAOsearchInvoiceEquipmentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Invoice Equipment List
	  * </pre>
	  */
	public InvoiceInquiryDBDAOsearchInvoiceEquipmentListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryDBDAOsearchInvoiceEquipmentListRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM," ).append("\n"); 
		query.append("INV.trsp_inv_aud_sts_cd status," ).append("\n"); 
		query.append("SVC.trsp_wo_ofc_cty_cd || SVC.trsp_wo_seq wo_no," ).append("\n"); 
		query.append("SVC.trsp_cost_dtl_mod_cd," ).append("\n"); 
		query.append("SVC.eq_knd_cd," ).append("\n"); 
		query.append("SVC.eq_no," ).append("\n"); 
		query.append("SVC.eq_tpsz_cd," ).append("\n"); 
		query.append("SVC.bkg_no," ).append("\n"); 
		query.append("SVC.bl_no," ).append("\n"); 
		query.append("SVC.vndr_seq," ).append("\n"); 
		query.append("to_char(SVC.apnt_dt,'YYYY-MM-DD') apnt_dt," ).append("\n"); 
		query.append("to_char(SVC.de_dt,'YYYY-MM-DD') de_dt," ).append("\n"); 
		query.append("SVC.trsp_so_ofc_cty_cd || SVC.trsp_so_seq so_no," ).append("\n"); 
		query.append("SVC.trsp_so_sts_cd," ).append("\n"); 
		query.append("SVC.trsp_so_tp_cd," ).append("\n"); 
		query.append("SVC.inv_no," ).append("\n"); 
		query.append("SVC.trsp_inv_act_sts_cd" ).append("\n"); 
		query.append("FROM trs_trsp_inv_wrk INV, trs_trsp_svc_ord SVC" ).append("\n"); 
		query.append("WHERE INV.inv_no IS NOT NULL" ).append("\n"); 
		query.append("AND INV.inv_no = SVC.inv_no" ).append("\n"); 
		query.append("AND INV.delt_flg = 'N'" ).append("\n"); 
		query.append("AND INV.inv_no = TRIM(@[inv_no])" ).append("\n"); 
		query.append("AND INV.wo_vndr_seq IS NOT NULL" ).append("\n"); 
		query.append("AND INV.inv_vndr_seq = (select prnt_vndr_seq from mdm_vendor where vndr_seq = @[wo_vndr_seq])" ).append("\n"); 
		query.append("#if ($sp_cd.size() == 1)" ).append("\n"); 
		query.append("AND INV.inv_vndr_seq = (select prnt_vndr_seq from mdm_vendor where vndr_seq = @[wo_vndr_seq])" ).append("\n"); 
		query.append("#elseif ($sp_cd.size() > 1)" ).append("\n"); 
		query.append("AND INV.inv_vndr_seq in (select distinct(prnt_vndr_seq) from mdm_vendor where (1,vndr_seq) in (" ).append("\n"); 
		query.append("#foreach($sp_cd_key in ${sp_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $sp_cd.size())" ).append("\n"); 
		query.append("(1,'$sp_cd_key')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(1,'$sp_cd_key')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY wo_no, eq_no" ).append("\n"); 

	}
}