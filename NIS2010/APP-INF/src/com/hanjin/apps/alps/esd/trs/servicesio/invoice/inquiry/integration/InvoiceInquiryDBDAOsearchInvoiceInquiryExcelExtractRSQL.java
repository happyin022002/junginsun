/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceInquiryDBDAOsearchInvoiceInquiryExcelExtractRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2014.11.14 윤권영
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

public class InvoiceInquiryDBDAOsearchInvoiceInquiryExcelExtractRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Invoice Inquiry Excel Extract
	  * </pre>
	  */
	public InvoiceInquiryDBDAOsearchInvoiceInquiryExcelExtractRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryDBDAOsearchInvoiceInquiryExcelExtractRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM, C.* FROM (" ).append("\n"); 
		query.append("    SELECT   inv_no" ).append("\n"); 
		query.append("    		,wo_no" ).append("\n"); 
		query.append("    		,so_no" ).append("\n"); 
		query.append("    		,eq_no" ).append("\n"); 
		query.append("    		,vndr_nm" ).append("\n"); 
		query.append("    		,inv_curr_cd" ).append("\n"); 
		query.append("    		,inv_iss_dt" ).append("\n"); 
		query.append("    		,inv_rcv_dt" ).append("\n"); 
		query.append("    		,inv_rjct_flg" ).append("\n"); 
		query.append("    		,status" ).append("\n"); 
		query.append("    		,paidDate" ).append("\n"); 
		query.append("    		,paymentMethod" ).append("\n"); 
		query.append("    		,checkTTNumber" ).append("\n"); 
		query.append("    		,(A.inv_bzc_amt + A.inv_surcharge ) inv_ttl_amt" ).append("\n"); 
		query.append("    		,if_sys_knd_name" ).append("\n"); 
		query.append("    		,trsp_kind_nm" ).append("\n"); 
		query.append("    		,trsp_mode_nm" ).append("\n"); 
		query.append("    		,trsp_type_nm" ).append("\n"); 
		query.append("    		,fm_nod_cd" ).append("\n"); 
		query.append("    		,to_nod_cd" ).append("\n"); 
		query.append("    		,eq_tpsz_cd" ).append("\n"); 
		query.append("    		,sp_inv_rmk" ).append("\n"); 
		query.append("			,'' INV_EDI_RSLT_CD" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("    		SELECT DISTINCT" ).append("\n"); 
		query.append("    				INV.inv_no," ).append("\n"); 
		query.append("    				SVC.trsp_wo_ofc_cty_cd || SVC.trsp_wo_seq wo_no," ).append("\n"); 
		query.append("    				SVC.trsp_so_ofc_cty_cd || SVC.trsp_so_seq so_no," ).append("\n"); 
		query.append("    				NVL(SVC.eq_no,'') eq_no," ).append("\n"); 
		query.append("    				(	select vndr_lgl_eng_nm" ).append("\n"); 
		query.append("    				from mdm_vendor" ).append("\n"); 
		query.append("    				where vndr_seq = INV.inv_vndr_seq" ).append("\n"); 
		query.append("    				and rownum =1	) 			vndr_nm," ).append("\n"); 
		query.append("    				INV.inv_curr_cd," ).append("\n"); 
		query.append("    				NVL(SVC.inv_bzc_amt, 0.0) inv_bzc_amt," ).append("\n"); 
		query.append("    				(	select nvl(sum(inv_scg_amt),0.0) inv_surcharge" ).append("\n"); 
		query.append("    				from trs_trsp_scg_dtl" ).append("\n"); 
		query.append("    				where (trsp_so_ofc_cty_cd = SVC.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("    				and trsp_so_seq = SVC.trsp_so_seq)		) inv_surcharge," ).append("\n"); 
		query.append("    				TO_CHAR(INV.inv_iss_dt, 'YYYY-MM-DD') inv_iss_dt," ).append("\n"); 
		query.append("    				TO_CHAR(INV.inv_rcv_dt, 'YYYY-MM-DD') inv_rcv_dt," ).append("\n"); 
		query.append("    				INV.trsp_inv_aud_sts_cd status," ).append("\n"); 
		query.append("    				NVL(INV.inv_rjct_flg,'E') inv_rjct_flg," ).append("\n"); 
		query.append("    				(	select intg_cd_val_dp_desc" ).append("\n"); 
		query.append("    		 			  from com_intg_cd_dtl" ).append("\n"); 
		query.append("    		 			 where intg_cd_id = 'CD00824'" ).append("\n"); 
		query.append("    		 			   and intg_cd_val_ctnt = INV.trsp_inv_aud_sts_cd		) status_nm," ).append("\n"); 
		query.append("    				TO_CHAR(INV.pay_dt, 'YYYY-MM-DD') paidDate," ).append("\n"); 
		query.append("    				INV.inv_pay_mzd_cd paymentMethod," ).append("\n"); 
		query.append("    				INV.inv_chk_trns_no checkTTNumber" ).append("\n"); 
		query.append("    				,DECODE(INV.IF_SYS_KND_CD,'I','EDI','WEB') if_sys_knd_name" ).append("\n"); 
		query.append("    				,SVC.sp_inv_rmk" ).append("\n"); 
		query.append("    				,(select intg_cd_val_dp_desc	from com_intg_cd_dtl" ).append("\n"); 
		query.append("    				where intg_cd_id = 'CD00958'" ).append("\n"); 
		query.append("    				and intg_cd_val_ctnt = SVC.trsp_cost_dtl_mod_cd) trsp_kind_nm" ).append("\n"); 
		query.append("    				,(select intg_cd_val_dp_desc	from com_intg_cd_dtl" ).append("\n"); 
		query.append("    				where intg_cd_id = 'CD00283'" ).append("\n"); 
		query.append("    				and intg_cd_val_ctnt = SVC.trsp_crr_mod_cd) trsp_mode_nm" ).append("\n"); 
		query.append("    				,decode(WRK.wo_fmt_tp_cd,'CC','Combined Case 1'," ).append("\n"); 
		query.append("    				'CM','Combined Case 2','CY','Combined Case 2','IB','Combined Case 2'," ).append("\n"); 
		query.append("    				'NC','Normal','MM','Empty' ) trsp_type_nm" ).append("\n"); 
		query.append("    				,SVC.fm_nod_cd" ).append("\n"); 
		query.append("    				,SVC.to_nod_cd" ).append("\n"); 
		query.append("    				,SVC.eq_tpsz_cd" ).append("\n"); 
		query.append("					,''" ).append("\n"); 
		query.append("    		 FROM trs_trsp_inv_wrk INV, trs_trsp_svc_ord SVC" ).append("\n"); 
		query.append("    			 ,trs_trsp_wrk_ord wrk" ).append("\n"); 
		query.append("    		WHERE INV.inv_no IS NOT NULL" ).append("\n"); 
		query.append("    		  AND INV.inv_no = SVC.inv_no" ).append("\n"); 
		query.append("    		  AND inv.INV_VNDR_SEQ = svc.INV_VNDR_SEQ" ).append("\n"); 
		query.append("    		  AND NVL(SVC.delt_flg,'E') != 'Y'" ).append("\n"); 
		query.append("    		  AND NVL(INV.delt_flg, 'E') <> 'Y'" ).append("\n"); 
		query.append("    #if(${vndr_dvsn} == 'S')" ).append("\n"); 
		query.append("    	AND INV.inv_vndr_seq = (select prnt_vndr_seq from mdm_vendor where vndr_seq = @[vndr_seq])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    		#if ($inv_no.size() > 0)" ).append("\n"); 
		query.append("    		AND  (1,INV.inv_no) in (" ).append("\n"); 
		query.append("    			#foreach($inv_no_key IN ${inv_no})" ).append("\n"); 
		query.append("    				#if($velocityCount < $inv_no.size())" ).append("\n"); 
		query.append("    					(1,'$inv_no_key') ," ).append("\n"); 
		query.append("    				#else" ).append("\n"); 
		query.append("    					(1,'$inv_no_key')" ).append("\n"); 
		query.append("    				#end" ).append("\n"); 
		query.append("    			#end" ).append("\n"); 
		query.append("    			)" ).append("\n"); 
		query.append("    		#else" ).append("\n"); 
		query.append("    			AND 1=2" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    		 AND WRK.TRSP_WO_OFC_CTY_CD = SVC.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("    		 AND WRK.TRSP_WO_SEQ = SVC.TRSP_WO_SEQ" ).append("\n"); 
		query.append("    		 AND NVL(WRK.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("    		ORDER BY inv_rcv_dt DESC" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    UNION" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT   inv_no" ).append("\n"); 
		query.append("    		,wo_no" ).append("\n"); 
		query.append("    		,so_no" ).append("\n"); 
		query.append("    		,eq_no" ).append("\n"); 
		query.append("    		,vndr_nm" ).append("\n"); 
		query.append("    		,inv_curr_cd" ).append("\n"); 
		query.append("    		,inv_iss_dt" ).append("\n"); 
		query.append("    		,inv_rcv_dt" ).append("\n"); 
		query.append("    		,inv_rjct_flg" ).append("\n"); 
		query.append("    		,status" ).append("\n"); 
		query.append("    		,paidDate" ).append("\n"); 
		query.append("    		,paymentMethod" ).append("\n"); 
		query.append("    		,checkTTNumber" ).append("\n"); 
		query.append("    		,inv_amt" ).append("\n"); 
		query.append("    		,if_sys_knd_name" ).append("\n"); 
		query.append("    		,trsp_kind_nm" ).append("\n"); 
		query.append("    		,trsp_mode_nm" ).append("\n"); 
		query.append("    		,trsp_type_nm" ).append("\n"); 
		query.append("    		,fm_nod_cd" ).append("\n"); 
		query.append("    		,to_nod_cd" ).append("\n"); 
		query.append("    		,eq_tpsz_cd" ).append("\n"); 
		query.append("    		,inv_rmk" ).append("\n"); 
		query.append("			,INV_EDI_RSLT_CD" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("    		SELECT DISTINCT" ).append("\n"); 
		query.append("    				EDI.inv_no," ).append("\n"); 
		query.append("    				EDI.trsp_wo_ofc_cty_cd || EDI.trsp_wo_seq wo_no," ).append("\n"); 
		query.append("    				EDI.trsp_so_ofc_cty_cd || EDI.trsp_so_seq so_no," ).append("\n"); 
		query.append("    				NVL(EDI.eq_no,'') eq_no," ).append("\n"); 
		query.append("    				(	select vndr_lgl_eng_nm" ).append("\n"); 
		query.append("    				from mdm_vendor" ).append("\n"); 
		query.append("    				where vndr_seq = SVC2.vndr_seq" ).append("\n"); 
		query.append("    				and rownum =1	) 			vndr_nm," ).append("\n"); 
		query.append("    				EDI.inv_curr_cd," ).append("\n"); 
		query.append("    				EDI.inv_amt," ).append("\n"); 
		query.append("    				(	select nvl(sum(inv_scg_amt),0.0) inv_surcharge" ).append("\n"); 
		query.append("    				from trs_trsp_scg_dtl" ).append("\n"); 
		query.append("    				where (trsp_so_ofc_cty_cd = EDI.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("    				and trsp_so_seq = EDI.trsp_so_seq)		) inv_surcharge," ).append("\n"); 
		query.append("    				TO_CHAR(EDI.inv_iss_dt, 'YYYY-MM-DD') inv_iss_dt," ).append("\n"); 
		query.append("    				TO_CHAR(EDI.CRE_dt, 'YYYY-MM-DD') inv_rcv_dt," ).append("\n"); 
		query.append("    				'EF' status," ).append("\n"); 
		query.append("    				'Y' inv_rjct_flg," ).append("\n"); 
		query.append("    				'EDI transmission failed' status_nm," ).append("\n"); 
		query.append("    				TO_CHAR('', 'YYYY-MM-DD') paidDate," ).append("\n"); 
		query.append("    				'' paymentMethod," ).append("\n"); 
		query.append("    				'' checkTTNumber" ).append("\n"); 
		query.append("    				,'EDI' if_sys_knd_name" ).append("\n"); 
		query.append("    				,EDI.inv_rmk" ).append("\n"); 
		query.append("    				,(select intg_cd_val_dp_desc	from com_intg_cd_dtl" ).append("\n"); 
		query.append("    				where intg_cd_id = 'CD00958'" ).append("\n"); 
		query.append("    				and intg_cd_val_ctnt = SVC2.trsp_cost_dtl_mod_cd) trsp_kind_nm" ).append("\n"); 
		query.append("    				,(select intg_cd_val_dp_desc	from com_intg_cd_dtl" ).append("\n"); 
		query.append("    				where intg_cd_id = 'CD00283'" ).append("\n"); 
		query.append("    				and intg_cd_val_ctnt = SVC2.trsp_crr_mod_cd) trsp_mode_nm" ).append("\n"); 
		query.append("    				,decode(WRK2.wo_fmt_tp_cd,'CC','Combined Case 1'," ).append("\n"); 
		query.append("    				'CM','Combined Case 2','CY','Combined Case 2','IB','Combined Case 2'," ).append("\n"); 
		query.append("    				'NC','Normal','MM','Empty' ) trsp_type_nm" ).append("\n"); 
		query.append("    				,SVC2.fm_nod_cd" ).append("\n"); 
		query.append("    				,SVC2.to_nod_cd" ).append("\n"); 
		query.append("    				,SVC2.eq_tpsz_cd" ).append("\n"); 
		query.append("					,EDI.INV_EDI_RSLT_CD" ).append("\n"); 
		query.append("    		 FROM trs_trsp_inv_EDI EDI, trs_trsp_svc_ord SVC2,trs_trsp_wrk_ord wrk2" ).append("\n"); 
		query.append("    		WHERE EDI.inv_no IS NOT NULL" ).append("\n"); 
		query.append("			  AND SVC2.INV_NO IS NULL" ).append("\n"); 
		query.append("    		  AND NVL(SVC2.delt_flg,'E') != 'Y'" ).append("\n"); 
		query.append("    		  AND ((SVC2.VNDR_SEQ = @[vndr_seq]) OR SVC2.VNDR_SEQ = (select prnt_vndr_seq from mdm_vendor where vndr_seq = @[vndr_seq]))" ).append("\n"); 
		query.append("    		#if ($inv_no.size() > 0)" ).append("\n"); 
		query.append("    		AND  (1,EDI.inv_no) in (" ).append("\n"); 
		query.append("    			#foreach($inv_no_key IN ${inv_no})" ).append("\n"); 
		query.append("    				#if($velocityCount < $inv_no.size())" ).append("\n"); 
		query.append("    					(1,'$inv_no_key') ," ).append("\n"); 
		query.append("    				#else" ).append("\n"); 
		query.append("    					(1,'$inv_no_key')" ).append("\n"); 
		query.append("    				#end" ).append("\n"); 
		query.append("    			#end" ).append("\n"); 
		query.append("    			)" ).append("\n"); 
		query.append("    		#else" ).append("\n"); 
		query.append("    			AND 1=2" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    		 AND WRK2.TRSP_WO_OFC_CTY_CD = SVC2.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("    		 AND WRK2.TRSP_WO_SEQ = SVC2.TRSP_WO_SEQ" ).append("\n"); 
		query.append("    		 AND EDI.TRSP_WO_OFC_CTY_CD = SVC2.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("             AND EDI.TRSP_WO_SEQ = SVC2.TRSP_WO_SEQ" ).append("\n"); 
		query.append("             AND EDI.TRSP_SO_OFC_CTY_CD = SVC2.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("             AND EDI.TRSP_SO_SEQ = SVC2.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			 AND EDI.EQ_NO = SVC2.EQ_NO" ).append("\n"); 
		query.append("    		 AND NVL(WRK2.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("ORDER BY inv_rcv_dt DESC" ).append("\n"); 
		query.append(")C" ).append("\n"); 

	}
}