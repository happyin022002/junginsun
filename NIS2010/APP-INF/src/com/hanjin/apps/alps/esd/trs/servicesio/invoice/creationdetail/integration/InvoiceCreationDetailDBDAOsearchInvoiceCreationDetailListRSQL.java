/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOsearchInvoiceCreationDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.03.19 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDetailDBDAOsearchInvoiceCreationDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation Detail 조회
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOsearchInvoiceCreationDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOsearchInvoiceCreationDetailListRSQL").append("\n"); 
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
		query.append("SELECT 		ROWNUM" ).append("\n"); 
		query.append("			,wo_no" ).append("\n"); 
		query.append("			,eq_no" ).append("\n"); 
		query.append("			,eq_tpsz_nm" ).append("\n"); 
		query.append("			,bkg_no" ).append("\n"); 
		query.append("			,fm_yard_nm" ).append("\n"); 
		query.append("			,via_yard_nm" ).append("\n"); 
		query.append("			,to_yard_nm" ).append("\n"); 
		query.append("			,dor_yard_nm" ).append("\n"); 
		query.append("			,trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("			,eq_knd_cd" ).append("\n"); 
		query.append("			,eq_tp_nm" ).append("\n"); 
		query.append("			,eq_tpsz_cd" ).append("\n"); 
		query.append("			,cntr_tpsz_iso_cd" ).append("\n"); 
		query.append("			,bl_no" ).append("\n"); 
		query.append("			,fm_nod_cd" ).append("\n"); 
		query.append("			,via_nod_cd" ).append("\n"); 
		query.append("			,to_nod_cd" ).append("\n"); 
		query.append("			,dor_nod_cd" ).append("\n"); 
		query.append("			,vndr_seq" ).append("\n"); 
		query.append("			,prnt_vndr_seq" ).append("\n"); 
		query.append("			,apnt_dt" ).append("\n"); 
		query.append("			,de_dt" ).append("\n"); 
		query.append("			,cre_ofc_cd" ).append("\n"); 
		query.append("			,so_no" ).append("\n"); 
		query.append("			,curr_cd" ).append("\n"); 
		query.append("			,bzc_amt" ).append("\n"); 
		query.append("			,nego_amt" ).append("\n"); 
		query.append("			,toll_fee_amt" ).append("\n"); 
		query.append("			,fuel_scg_amt" ).append("\n"); 
		query.append("			,scg_vat_amt" ).append("\n"); 
		query.append("			,ovr_wgt_scg_amt" ).append("\n"); 
		query.append("			,etc_add_amt" ).append("\n"); 
		query.append("			,inv_surcharge" ).append("\n"); 
		query.append("			,inv_bzc_amt" ).append("\n"); 
		query.append("			,sp_inv_rmk" ).append("\n"); 
		query.append("			,cgo_tp_cd" ).append("\n"); 
		query.append("			,trsp_inv_calc_lgc_tp_cd" ).append("\n"); 
		query.append("			,inv_xch_rt" ).append("\n"); 
		query.append("			,inv_vat_amt" ).append("\n"); 
		query.append(" FROM (SELECT" ).append("\n"); 
		query.append("			 SVC.trsp_wo_ofc_cty_cd || SVC.trsp_wo_seq wo_no" ).append("\n"); 
		query.append("			,SVC.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("			,(select intg_cd_val_dp_desc from com_intg_cd_dtl where intg_cd_id = 'CD00594' and intg_cd_val_ctnt = SVC.trsp_cost_dtl_mod_cd) trsp_cost_dtl_mod_nm" ).append("\n"); 
		query.append("			,SVC.trsp_so_ofc_cty_cd || SVC.trsp_so_seq so_no" ).append("\n"); 
		query.append("			,SVC.eq_knd_cd" ).append("\n"); 
		query.append("			,(select intg_cd_val_dp_desc from com_intg_cd_dtl where intg_cd_id = 'CD01132' and intg_cd_val_ctnt = SVC.eq_knd_cd) eq_tp_nm" ).append("\n"); 
		query.append("			,SVC.eq_no" ).append("\n"); 
		query.append("			,SVC.eq_tpsz_cd" ).append("\n"); 
		query.append("			,(select cntr_tpsz_rmk from mdm_cntr_tp_sz where cntr_tpsz_cd = SVC.eq_tpsz_cd) eq_tpsz_nm" ).append("\n"); 
		query.append("			,(select cntr_tpsz_iso_cd from mdm_cntr_tp_sz where cntr_tpsz_cd = SVC.eq_tpsz_cd) cntr_tpsz_iso_cd" ).append("\n"); 
		query.append("			,SVC.bkg_no" ).append("\n"); 
		query.append("			,SVC.bl_no bl_no" ).append("\n"); 
		query.append("			,SVC.fm_nod_cd" ).append("\n"); 
		query.append("			,(select yd_nm from mdm_yard where yd_cd = SVC.fm_nod_cd) fm_yard_nm" ).append("\n"); 
		query.append("			,SVC.via_nod_cd" ).append("\n"); 
		query.append("			,(select yd_nm from mdm_yard where yd_cd = SVC.via_nod_cd) via_yard_nm" ).append("\n"); 
		query.append("			,SVC.to_nod_cd" ).append("\n"); 
		query.append("			,(select yd_nm from mdm_yard where yd_cd = SVC.to_nod_cd) to_yard_nm" ).append("\n"); 
		query.append("			,SVC.dor_nod_cd" ).append("\n"); 
		query.append("			,(select yd_nm from mdm_yard where yd_cd = SVC.dor_nod_cd) dor_yard_nm" ).append("\n"); 
		query.append("			,SVC.vndr_seq" ).append("\n"); 
		query.append("			,(select prnt_vndr_seq from mdm_vendor where vndr_seq = SVC.vndr_seq) prnt_vndr_seq" ).append("\n"); 
		query.append("			,SVC.apnt_dt" ).append("\n"); 
		query.append("			,SVC.de_dt" ).append("\n"); 
		query.append("			,SVC.cre_ofc_cd" ).append("\n"); 
		query.append("			,SVC.curr_cd" ).append("\n"); 
		query.append("			,NVL(SVC.bzc_amt, 0.0) bzc_amt" ).append("\n"); 
		query.append("			,NVL(SVC.fuel_scg_amt, 0.0) fuel_scg_amt" ).append("\n"); 
		query.append("			,NVL(SVC.scg_vat_amt, 0.0) scg_vat_amt" ).append("\n"); 
		query.append("			,NVL(SVC.ovr_wgt_scg_amt, 0.0) ovr_wgt_scg_amt" ).append("\n"); 
		query.append("			,NVL(SVC.etc_add_amt, 0.0) etc_add_amt" ).append("\n"); 
		query.append("			,NVL(SVC.nego_amt, 0.0) nego_amt" ).append("\n"); 
		query.append("			,NVL(SVC.toll_fee_amt, 0.0) toll_fee_amt" ).append("\n"); 
		query.append("			,NVL(SVC.inv_bzc_amt, 0.0) inv_bzc_amt" ).append("\n"); 
		query.append("			,(select nvl(sum(inv_scg_amt),0.0) inv_surcharge from trs_trsp_scg_dtl where (trsp_so_ofc_cty_cd = SVC.trsp_so_ofc_cty_cd and trsp_so_seq = SVC.trsp_so_seq)) inv_surcharge --Invoice Surcharge" ).append("\n"); 
		query.append("			,SVC.sp_inv_rmk" ).append("\n"); 
		query.append("			,NVL(SVC.cgo_tp_cd,'M') cgo_tp_cd" ).append("\n"); 
		query.append("			,SVC.inv_xch_rt" ).append("\n"); 
		query.append("			,SVC.trsp_inv_calc_lgc_tp_cd" ).append("\n"); 
		query.append("			,(select inv_vat_amt from trs_trsp_inv_wrk where inv_no = SVC.inv_no and inv_vndr_seq = SVC.inv_vndr_seq) inv_vat_amt" ).append("\n"); 
		query.append("	FROM trs_trsp_svc_ord SVC" ).append("\n"); 
		query.append("	WHERE SVC.trsp_wo_ofc_cty_cd IS NOT NULL --Work Order OFC Code" ).append("\n"); 
		query.append("	AND SVC.trsp_wo_seq IS NOT NULL --Work Order Seq" ).append("\n"); 
		query.append("	AND LENGTH(SVC.trsp_wo_ofc_cty_cd) = 3 --Work Order Seq" ).append("\n"); 
		query.append("	AND SVC.trsp_so_ofc_cty_cd IS NOT NULL --Service Order OFC Code" ).append("\n"); 
		query.append("	AND SVC.trsp_so_seq IS NOT NULL --Service Order Seq" ).append("\n"); 
		query.append("	AND NVL(SVC.delt_flg, 'E') <> 'Y' --Service Order Delete Flag" ).append("\n"); 
		query.append("	AND SVC.eq_no IS NOT NULL --Equipment No" ).append("\n"); 
		query.append("	AND SVC.vndr_seq IS NOT NULL --Vendor Code" ).append("\n"); 
		query.append("    AND SVC.vndr_seq IN ( SELECT vndr_seq" ).append("\n"); 
		query.append("	                                FROM mdm_vendor" ).append("\n"); 
		query.append("	                               WHERE prnt_vndr_seq = (SELECT prnt_vndr_seq" ).append("\n"); 
		query.append("	                                                         FROM mdm_vendor" ).append("\n"); 
		query.append("	                                                         WHERE 1=1" ).append("\n"); 
		query.append("	                                                        AND vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("	                                                      )" ).append("\n"); 
		query.append("	                           )" ).append("\n"); 
		query.append("#if ($trsp_so_ofc_cty_cd.size() > 0) " ).append("\n"); 
		query.append("    AND (SVC.trsp_so_ofc_cty_cd,SVC.trsp_so_seq) in (" ).append("\n"); 
		query.append("	#foreach($sonoKey in ${trsp_so_ofc_cty_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $trsp_so_ofc_cty_cd.size()) " ).append("\n"); 
		query.append("			(substr('$sonoKey',0,3),to_number(substr('$sonoKey',4,length('$sonoKey'))))," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(substr('$sonoKey',0,3),to_number(substr('$sonoKey',4,length('$sonoKey'))))" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("ORDER BY wo_no, eq_no) A" ).append("\n"); 

	}
}