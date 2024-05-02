/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByERPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.04.26 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByERPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByERPRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByERPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByERPRSQL").append("\n"); 
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
		query.append("select  A.DMDT_INV_NO" ).append("\n"); 
		query.append("       ,INV_PAY_OFC_CD" ).append("\n"); 
		query.append("       ,A.BKG_NO" ).append("\n"); 
		query.append("       ,A.BL_NO" ).append("\n"); 
		query.append("       ,A.INV_CURR_CD" ).append("\n"); 
		query.append("       ,decode(DMDT_INV_PAY_TP_CD, 'M', INV_PAY_AMT)   	as INV_AMT" ).append("\n"); 
		query.append("	   ,decode(DMDT_INV_PAY_TP_CD, 'V', INV_PAY_AMT)   	as TAX_AMT" ).append("\n"); 
		query.append("       ,to_char(INV_PAY_LOCL_DT, 'YYYY-MM-DD HH24:MI')		as INV_PAY_DT" ).append("\n"); 
		query.append("       ,to_char(UPD_LOCL_DT, 'YYYY-MM-DD HH24:MI')	as IF_DT" ).append("\n"); 
		query.append("       ,case " ).append("\n"); 
		query.append("			when INV_PAY_RCV_SEQ < 2000000 then null" ).append("\n"); 
		query.append("			else INV_PAY_RCV_SEQ" ).append("\n"); 
		query.append("	    end												as IF_NO" ).append("\n"); 
		query.append("	   ,B.DMDT_TRF_CD " ).append("\n"); 
		query.append("	   ,B.AR_IF_OFC_CD									AS DMDT_OFC_CD" ).append("\n"); 
		query.append("       , CASE WHEN ACT_PAYR_CNT_CD IN ('00', 'TB') THEN LPAD(ACT_PAYR_SEQ, 6, 0) ELSE ACT_PAYR_CNT_CD || LPAD(ACT_PAYR_SEQ, 6, 0) END PAYER_CD" ).append("\n"); 
		query.append("       , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = ACT_PAYR_CNT_CD AND CUST_SEQ = ACT_PAYR_SEQ AND ROWNUM = 1) PAYER_NM" ).append("\n"); 
		query.append("  from  DMT_INV_OTS_PAY_RCV A, DMT_INV_MN B" ).append("\n"); 
		query.append("  where 1 = 1   " ).append("\n"); 
		query.append("  AND  A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("   #if(${invoice_no} != '')" ).append("\n"); 
		query.append("   and  A.DMDT_INV_NO in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			#foreach( $invoice_no in ${invoice_no_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $invoice_no_list.size()) '$invoice_no', #else '$invoice_no' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${ofc_cd} != '')" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if(${erp_ofc} != 'coll')" ).append("\n"); 
		query.append("   and  B.AR_IF_OFC_CD in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   and  A.INV_PAY_OFC_CD in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${bkg_no} != '')" ).append("\n"); 
		query.append("   and  A.BKG_NO in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			#foreach( $bkg_no in ${bkg_no_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $bkg_no_list.size()) '$bkg_no', #else '$bkg_no' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("	#if(${dmdt_trf_cd_t3} != '')" ).append("\n"); 
		query.append("   and  B.DMDT_TRF_CD in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			#foreach( $trf_cd in ${dmdt_trf_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${erp_dt} != 'if')" ).append("\n"); 
		query.append("        AND A.INV_PAY_LOCL_DT BETWEEN to_date(@[fm_if_dt], 'YYYY-MM-DD') AND to_date(@[to_if_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   	    AND A.UPD_LOCL_DT BETWEEN to_date(@[fm_if_dt], 'YYYY-MM-DD') AND to_date(@[to_if_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("order by A.UPD_DT desc" ).append("\n"); 

	}
}