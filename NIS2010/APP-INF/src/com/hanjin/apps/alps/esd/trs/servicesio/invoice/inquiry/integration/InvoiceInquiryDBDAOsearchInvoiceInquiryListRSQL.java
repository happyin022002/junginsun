/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceInquiryDBDAOsearchInvoiceInquiryListRSQL.java
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

public class InvoiceInquiryDBDAOsearchInvoiceInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Inquiry 조회 한다.
	  * </pre>
	  */
	public InvoiceInquiryDBDAOsearchInvoiceInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryDBDAOsearchInvoiceInquiryListRSQL").append("\n"); 
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
		query.append("SELECT inv_no" ).append("\n"); 
		query.append(" 	,inv_curr_cd" ).append("\n"); 
		query.append(" 	,inv_ttl_amt" ).append("\n"); 
		query.append(" 	,inv_iss_dt" ).append("\n"); 
		query.append(" 	,inv_rcv_dt" ).append("\n"); 
		query.append(" 	,inv_rjct_flg" ).append("\n"); 
		query.append(" 	,status" ).append("\n"); 
		query.append(" 	,to_char(paidDate,'YYYY-MM-DD') paidDate" ).append("\n"); 
		query.append(" 	,paymentMethod" ).append("\n"); 
		query.append(" 	,checkTTNumber" ).append("\n"); 
		query.append(" 	,inv_vndr_seq" ).append("\n"); 
		query.append(" 	,if_sys_knd_name" ).append("\n"); 
		query.append(" 	,(select sp_inv_rmk" ).append("\n"); 
		query.append(" 	    from trs_trsp_svc_ord" ).append("\n"); 
		query.append(" 	   where inv_no = A.inv_no" ).append("\n"); 
		query.append(" 	     and INV_VNDR_SEQ = A.INV_VNDR_SEQ" ).append("\n"); 
		query.append(" 	     and NVL(delt_flg,'E') != 'Y'" ).append("\n"); 
		query.append(" 	     and sp_inv_rmk is not null" ).append("\n"); 
		query.append(" 	     and rownum < 2	) sp_inv_rmk" ).append("\n"); 
		query.append("	,'' inv_edi_rslt_cd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("	INV.inv_no," ).append("\n"); 
		query.append("	INV.inv_curr_cd," ).append("\n"); 
		query.append("	INV.inv_vndr_seq," ).append("\n"); 
		query.append("	NVL(INV.inv_bzc_amt, 0.0) inv_ttl_amt," ).append("\n"); 
		query.append("	TO_CHAR(INV.inv_iss_dt, 'YYYY-MM-DD') inv_iss_dt," ).append("\n"); 
		query.append("	TO_CHAR(INV.inv_rcv_dt, 'YYYY-MM-DD') inv_rcv_dt," ).append("\n"); 
		query.append("	INV.trsp_inv_aud_sts_cd status," ).append("\n"); 
		query.append("	NVL(INV.inv_rjct_flg,'E') inv_rjct_flg," ).append("\n"); 
		query.append("	(select intg_cd_val_dp_desc" ).append("\n"); 
		query.append("	 from com_intg_cd_dtl" ).append("\n"); 
		query.append("	 where intg_cd_id = 'CD00824'" ).append("\n"); 
		query.append("	 and intg_cd_val_ctnt = INV.trsp_inv_aud_sts_cd) status_nm," ).append("\n"); 
		query.append("	INV.pay_dt paidDate," ).append("\n"); 
		query.append("	INV.inv_pay_mzd_cd paymentMethod," ).append("\n"); 
		query.append("	INV.inv_chk_trns_no checkTTNumber" ).append("\n"); 
		query.append("	,DECODE(INV.IF_SYS_KND_CD,'I','EDI','E','Paper','WEB') if_sys_knd_name" ).append("\n"); 
		query.append("FROM trs_trsp_inv_wrk INV, trs_trsp_svc_ord SVC" ).append("\n"); 
		query.append("WHERE INV.inv_no IS NOT NULL" ).append("\n"); 
		query.append("	AND INV.inv_no = SVC.inv_no" ).append("\n"); 
		query.append("	AND NVL(INV.delt_flg, 'E') <> 'Y'" ).append("\n"); 
		query.append("#if(${vndr_dvsn} == 'S' || (${vndr_dvsn} == 'M' && ${period_type} != ''))" ).append("\n"); 
		query.append("	#if ($sp_cd.size() == 1)" ).append("\n"); 
		query.append("		AND INV.inv_vndr_seq = (select prnt_vndr_seq from mdm_vendor where vndr_seq = @[vndr_seq])" ).append("\n"); 
		query.append("	#elseif ($sp_cd.size() > 1)" ).append("\n"); 
		query.append(" 		AND INV.inv_vndr_seq in (select distinct(prnt_vndr_seq) from mdm_vendor where (1,vndr_seq) in (" ).append("\n"); 
		query.append("			#foreach($sp_cd_key in ${sp_cd}) " ).append("\n"); 
		query.append("				#if($velocityCount < $sp_cd.size()) " ).append("\n"); 
		query.append("					(1,'$sp_cd_key')," ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					(1,'$sp_cd_key')" ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		))" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${period_type} == 'ID')" ).append("\n"); 
		query.append("	AND TO_CHAR(INV.inv_iss_dt, 'YYYYMMDD') BETWEEN @[dt_fr] AND @[dt_to]" ).append("\n"); 
		query.append("#elseif (${period_type} == 'SD')" ).append("\n"); 
		query.append("	AND TO_CHAR(INV.inv_rcv_dt, 'YYYYMMDD') BETWEEN @[dt_fr] AND @[dt_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($trsp_inv_aud_sts_cd.size() > 0)" ).append("\n"); 
		query.append("	AND (1,INV.trsp_inv_aud_sts_cd) in (" ).append("\n"); 
		query.append("	#foreach($trsp_inv_aud_sts_cd_key IN ${trsp_inv_aud_sts_cd})" ).append("\n"); 
		query.append("		#if($velocityCount < $trsp_inv_aud_sts_cd.size())" ).append("\n"); 
		query.append("			(1,'$trsp_inv_aud_sts_cd_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$trsp_inv_aud_sts_cd_key')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($inv_no.size() > 0)" ).append("\n"); 
		query.append("    AND  (1,INV.inv_no) in ( " ).append("\n"); 
		query.append("	#foreach($inv_no_key IN ${inv_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $inv_no.size()) " ).append("\n"); 
		query.append("			(1,'$inv_no_key') ," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$inv_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($wo_no.size() > 0) " ).append("\n"); 
		query.append("    AND (SVC.trsp_wo_ofc_cty_cd,SVC.trsp_wo_seq) in (" ).append("\n"); 
		query.append("	#foreach($wonoKey in ${wo_no}) " ).append("\n"); 
		query.append("		#if($velocityCount < $wo_no.size()) " ).append("\n"); 
		query.append("			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($eq_no.size() > 0)" ).append("\n"); 
		query.append("    AND  (1,SVC.eq_no) in ( " ).append("\n"); 
		query.append("	#foreach($eq_no_key IN ${eq_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $eq_no.size()) " ).append("\n"); 
		query.append("			(1,'$eq_no_key') ," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$eq_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY inv_rcv_dt DESC" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("EDI.INV_NO," ).append("\n"); 
		query.append("EDI.INV_CURR_CD," ).append("\n"); 
		query.append("EDI.INV_AMT," ).append("\n"); 
		query.append("TO_CHAR(EDI.INV_ISS_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("TO_CHAR(EDI.CRE_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("'Y'," ).append("\n"); 
		query.append("'EF'," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("SVC2.VNDR_SEQ," ).append("\n"); 
		query.append("'EDI'," ).append("\n"); 
		query.append("EDI.INV_RMK," ).append("\n"); 
		query.append("EDI.INV_EDI_RSLT_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_EDI EDI, TRS_TRSP_SVC_ORD SVC2" ).append("\n"); 
		query.append("WHERE EDI.TRSP_WO_OFC_CTY_CD = SVC2.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND EDI.TRSP_WO_SEQ = SVC2.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND EDI.TRSP_SO_OFC_CTY_CD = SVC2.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND EDI.TRSP_SO_SEQ = SVC2.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND EDI.EQ_NO = SVC2.EQ_NO" ).append("\n"); 
		query.append("#if(${period_type} == 'ID')" ).append("\n"); 
		query.append("    AND TO_CHAR(EDI.INV_ISS_DT, 'YYYYMMDD') BETWEEN @[dt_fr] AND @[dt_to]" ).append("\n"); 
		query.append("#elseif (${period_type} == 'SD')" ).append("\n"); 
		query.append("	AND TO_CHAR(EDI.CRE_DT, 'YYYYMMDD') BETWEEN @[dt_fr] AND @[dt_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($inv_no.size() > 0)" ).append("\n"); 
		query.append("AND (1,EDI.INV_NO) in (" ).append("\n"); 
		query.append("    #foreach($inv_no_key IN ${inv_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $inv_no.size()) " ).append("\n"); 
		query.append("			(1,'$inv_no_key') ," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$inv_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($wo_no.size() > 0)" ).append("\n"); 
		query.append("    AND (EDI.TRSP_WO_OFC_CTY_CD,EDI.TRSP_WO_SEQ) in (" ).append("\n"); 
		query.append("    #foreach($wonoKey in ${wo_no}) " ).append("\n"); 
		query.append("		#if($velocityCount < $wo_no.size()) " ).append("\n"); 
		query.append("			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($eq_no.size() > 0)" ).append("\n"); 
		query.append("    AND (1,EDI.EQ_NO) in (" ).append("\n"); 
		query.append("    #foreach($eq_no_key IN ${eq_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $eq_no.size()) " ).append("\n"); 
		query.append("			(1,'$eq_no_key') ," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$eq_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vndr_dvsn} == 'S' || (${vndr_dvsn} == 'M' && ${period_type} != ''))" ).append("\n"); 
		query.append("	#if ($sp_cd.size() == 1)" ).append("\n"); 
		query.append("		AND ((SVC2.VNDR_SEQ = @[vndr_seq]) " ).append("\n"); 
		query.append("		OR SVC2.VNDR_SEQ = (select prnt_vndr_seq from mdm_vendor where vndr_seq = @[vndr_seq]))" ).append("\n"); 
		query.append("	#elseif ($sp_cd.size() > 1)" ).append("\n"); 
		query.append(" 		AND (SVC2.VNDR_SEQ in (select distinct(vndr_seq) from mdm_vendor where (1,vndr_seq) in (" ).append("\n"); 
		query.append("			#foreach($sp_cd_key in ${sp_cd}) " ).append("\n"); 
		query.append("				#if($velocityCount < $sp_cd.size()) " ).append("\n"); 
		query.append("					(1,'$sp_cd_key')," ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					(1,'$sp_cd_key')" ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		))" ).append("\n"); 
		query.append("		OR SVC2.VNDR_SEQ in (select distinct(prnt_vndr_seq) from mdm_vendor where (1,vndr_seq) in (" ).append("\n"); 
		query.append("			#foreach($sp_cd_key in ${sp_cd}) " ).append("\n"); 
		query.append("				#if($velocityCount < $sp_cd.size()) " ).append("\n"); 
		query.append("					(1,'$sp_cd_key')," ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					(1,'$sp_cd_key')" ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		)))" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SVC2.INV_NO IS NULL" ).append("\n"); 
		query.append("AND EDI.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("AND EDI.INV_EDI_RSLT_CD = 'D'" ).append("\n"); 
		query.append("#if ($trsp_inv_aud_sts_cd.size() > 0)" ).append("\n"); 
		query.append("	AND (1,'EF') in (" ).append("\n"); 
		query.append("	#foreach($trsp_inv_aud_sts_cd_key IN ${trsp_inv_aud_sts_cd})" ).append("\n"); 
		query.append("		#if($velocityCount < $trsp_inv_aud_sts_cd.size())" ).append("\n"); 
		query.append("			(1,'$trsp_inv_aud_sts_cd_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$trsp_inv_aud_sts_cd_key')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY inv_rcv_dt DESC" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}