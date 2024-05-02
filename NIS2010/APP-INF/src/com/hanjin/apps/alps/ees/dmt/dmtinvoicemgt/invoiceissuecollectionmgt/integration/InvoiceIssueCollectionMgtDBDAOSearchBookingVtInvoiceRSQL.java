/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingVtInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchBookingVtInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchBookingVtInvoiceRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchBookingVtInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingVtInvoiceRSQL").append("\n"); 
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
		query.append("select  T.*" ).append("\n"); 
		query.append("       ,''														as DMDT_INV_STS_NM" ).append("\n"); 
		query.append("	   ,''														as DMDT_AR_IF_CD" ).append("\n"); 
		query.append("	   ,''														as AR_IF_DT" ).append("\n"); 
		query.append("	   ,'' 														as AR_IF_OFC_CD" ).append("\n"); 
		query.append("	   ,'' 														as AR_IF_USR_ID" ).append("\n"); 
		query.append("	   ,'' 														as AR_IF_USR_NM" ).append("\n"); 
		query.append("	   ,''														as CR_INV_NO" ).append("\n"); 
		query.append("	   ,''														as INV_RMK2" ).append("\n"); 
		query.append("	   ,0														as AFT_INV_ADJ_AMT" ).append("\n"); 
		query.append("	   ,1														as INV_XCH_RT" ).append("\n"); 
		query.append("       ,TAX_RTO													as INV_TAX_RTO" ).append("\n"); 
		query.append("       ,case when nvl(TAX_RTO, 0) = 0" ).append("\n"); 
		query.append("			 then 0" ).append("\n"); 
		query.append("             else INV_CHG_AMT/TAX_RTO" ).append("\n"); 
		query.append("        end														as TAX_AMT" ).append("\n"); 
		query.append("       ,case when nvl(TAX_RTO, 0) = 0" ).append("\n"); 
		query.append("             then INV_CHG_AMT" ).append("\n"); 
		query.append("             else INV_CHG_AMT + INV_CHG_AMT/TAX_RTO" ).append("\n"); 
		query.append("        end 													as INV_AMT" ).append("\n"); 
		query.append("	   ,to_char(sysdate, 'YYYYMMDD') 							as ISSUE_DAY" ).append("\n"); 
		query.append("	   ,''														as INV_PRT_FLG" ).append("\n"); 
		query.append("	   ,'' 														as CR_AR_YN" ).append("\n"); 
		query.append("	   ,T.ACT_PAYR_CNT_CD || lpad(T.ACT_PAYR_SEQ, 6, '0') 		as PAYER_CD" ).append("\n"); 
		query.append("	   ,decode" ).append("\n"); 
		query.append("	   (" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				select  DMDT_PAYR_NM                                                                                                                                            " ).append("\n"); 
		query.append("				  from  DMT_PAYR_INFO                                                                                                                                             " ).append("\n"); 
		query.append("				 where  SYS_AREA_GRP_ID  = " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							select  SYS_AREA_GRP_ID                                                                                                               " ).append("\n"); 
		query.append("							  from  COM_SYS_AREA_GRP_ID                                                                                                             " ).append("\n"); 
		query.append("							 where  CNT_CD = " ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("										select  substr(LOC_CD, 1, 2)                                                                                          " ).append("\n"); 
		query.append("										  from  MDM_ORGANIZATION                                                                                                " ).append("\n"); 
		query.append("										 where  OFC_CD = T.CRE_OFC_CD" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("							   and  CO_IND_CD = 'H'" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				   and CUST_CNT_CD = T.ACT_PAYR_CNT_CD                                                                                                                            " ).append("\n"); 
		query.append("				   and CUST_SEQ    = T.ACT_PAYR_SEQ" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			,null" ).append("\n"); 
		query.append("			,(" ).append("\n"); 
		query.append("				decode" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  LOCL_NM                                                                                                                                     " ).append("\n"); 
		query.append("						  from  MDM_CR_CUST                                                                                                                                   " ).append("\n"); 
		query.append("						 where  CUST_CNT_CD = T.ACT_PAYR_CNT_CD                                                                                                              " ).append("\n"); 
		query.append("						   and  CUST_SEQ    = T.ACT_PAYR_SEQ                                                                                                                   " ).append("\n"); 
		query.append("						   and  LOCL_NM is not null" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				   ,null" ).append("\n"); 
		query.append("				  ,(" ).append("\n"); 
		query.append("						select  case when T.ACT_PAYR_CNT_CD = '00' " ).append("\n"); 
		query.append("									then (" ).append("\n"); 
		query.append("											select  VNDR_LGL_ENG_NM                                                                             " ).append("\n"); 
		query.append("											  from  MDM_VendOR                                                                                                 " ).append("\n"); 
		query.append("											 where  VNDR_SEQ = T.ACT_PAYR_SEQ                                                                                 " ).append("\n"); 
		query.append("											   and  VNDR_LGL_ENG_NM is not null" ).append("\n"); 
		query.append("										  )  " ).append("\n"); 
		query.append("								else (" ).append("\n"); 
		query.append("										select  CUST_LGL_ENG_NM                                                                                                                " ).append("\n"); 
		query.append("										  from  MDM_CUSTOMER                                                                                                                     " ).append("\n"); 
		query.append("										 where  CUST_CNT_CD = T.ACT_PAYR_CNT_CD                                                                                                 " ).append("\n"); 
		query.append("										   and  CUST_SEQ    = T.ACT_PAYR_SEQ                                                                                                     " ).append("\n"); 
		query.append("										   and  CUST_LGL_ENG_NM is not null" ).append("\n"); 
		query.append("									  )" ).append("\n"); 
		query.append("								end MDM_NAME                                                                                                                                " ).append("\n"); 
		query.append("						  from  DUAL" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						select  LOCL_NM                                                                                                                                    " ).append("\n"); 
		query.append("						  from  MDM_CR_CUST                                                                                                                                   " ).append("\n"); 
		query.append("						 where  CUST_CNT_CD = T.ACT_PAYR_CNT_CD                                                                                                              " ).append("\n"); 
		query.append("						   and  CUST_SEQ    = T.ACT_PAYR_SEQ                                                                                                                   " ).append("\n"); 
		query.append("						   and  LOCL_NM is not null" ).append("\n"); 
		query.append("					) " ).append("\n"); 
		query.append("				)                                                                                                                                                    " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		   ,(" ).append("\n"); 
		query.append("				select  DMDT_PAYR_NM                                                                                                                                             " ).append("\n"); 
		query.append("				  from  DMT_PAYR_INFO                                                                                                                                              " ).append("\n"); 
		query.append("				 where  SYS_AREA_GRP_ID = " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							select  SYS_AREA_GRP_ID                                                                                                                " ).append("\n"); 
		query.append("							  from  COM_SYS_AREA_GRP_ID                                                                                                               " ).append("\n"); 
		query.append("							 where  CNT_CD = " ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("										select  substr(LOC_CD, 1, 2)                                                                                            " ).append("\n"); 
		query.append("										  from  MDM_ORGANIZATION                                                                                                  " ).append("\n"); 
		query.append("										 where  OFC_CD = T.CRE_OFC_CD" ).append("\n"); 
		query.append("									)                                                                                           " ).append("\n"); 
		query.append("							   and  CO_IND_CD = 'H'" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				   and  CUST_CNT_CD = T.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("				   and  CUST_SEQ    = T.ACT_PAYR_SEQ" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)  								as ACT_PAYR_CUST_NM        -- E-mail Send용 Customer" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
		query.append("			select  T1.DMDT_INV_NO" ).append("\n"); 
		query.append("				   ,to_char(max(T1.CRE_DT), 'YYYY-MM-DD')	    				as CRE_DT" ).append("\n"); 
		query.append("				   ,max(T1.CRE_OFC_CD)                          				as CRE_OFC_CD" ).append("\n"); 
		query.append("				   ,max(T1.DMDT_INV_STS_CD)                     				as DMDT_INV_STS_CD" ).append("\n"); 
		query.append("				   ,max(T1.DMDT_VT_INV_STS_CD)                  				as DMDT_VT_INV_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   ,max(T1.BKG_NO)												as BKG_NO" ).append("\n"); 
		query.append("				   ,max(T1.BL_NO)												as BL_NO" ).append("\n"); 
		query.append("				   ,max(T1.DMDT_TRF_CD)											as DMDT_TRF_CD" ).append("\n"); 
		query.append("				   ,max(T3.SC_NO)												as SC_NO" ).append("\n"); 
		query.append("				   ,max(T3.RFA_NO)												as RFA_NO" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("				   ,max(T1.VSL_CD) || max(T1.SKD_VOY_NO) || max(T1.SKD_DIR_CD)	as VVD_CD" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("				   ,max(T1.POR_CD)												as POR_CD" ).append("\n"); 
		query.append("				   ,max(T1.POL_CD)												as POL_CD" ).append("\n"); 
		query.append("				   ,max(T1.POD_CD)												as POD_CD" ).append("\n"); 
		query.append("				   ,max(T1.DEL_CD)												as DEL_CD" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("				   ,max(T1.ACT_PAYR_CNT_CD)										as ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("				   ,max(T1.ACT_PAYR_SEQ)										as ACT_PAYR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   ,max(T1.BKG_RCV_TERM_CD ) || '/' || max(T1.BKG_DE_TERM_CD)	as RD" ).append("\n"); 
		query.append("				   ,'' 															as PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("				   ,'' 															as PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("				   ,'' 															as PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("				#if (${caller} == '4016')" ).append("\n"); 
		query.append("				   ,max(T1.DMDT_PAYR_CNTC_PNT_NM)								as DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("				   ,lpad(max(T1.VNDR_SEQ), 6, '0') 								as TRUCKER_CD" ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("				   ,'' 															as DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("				   ,lpad(max(T4.VNDR_SEQ), 6, '0')                              as TRUCKER_CD" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   ,max(T1.CUST_CNTC_PNT_SEQ)									as CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   ,max(T4.BZC_TRF_CURR_CD)										as CHG_CURR_CD" ).append("\n"); 
		query.append("				   ,max(T4.BZC_TRF_CURR_CD)										as INV_CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   ,sum(nvl(T4.ORG_CHG_AMT,     0))								as MN_ORG_CHG_AMT" ).append("\n"); 
		query.append("				   ,sum(nvl(T4.SC_RFA_EXPT_AMT, 0)) 							as DMDT_EXPT_AMT" ).append("\n"); 
		query.append("				   ,sum(nvl(T4.AFT_EXPT_DC_AMT, 0))								as CHG_DC_AMT	   " ).append("\n"); 
		query.append("				   ,sum(nvl(T4.BIL_AMT, 		0))								as MN_BIL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   ,COUNT(*)													as CNTR_CNT" ).append("\n"); 
		query.append("				   ,0															as DC_AMT" ).append("\n"); 
		query.append("                   ,sum(nvl(T4.BIL_AMT, 0))										as INV_CHG_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   ,max(T1.INV_REF_NO)											as INV_REF_NO" ).append("\n"); 
		query.append("				   ,max(T2.SYS_AREA_GRP_ID)										as SVR_ID" ).append("\n"); 
		query.append("				   ,max(T1.CXL_RMK)												as INV_RMK1" ).append("\n"); 
		query.append("				   ,max(T1.IDA_EXPN_TAX_RT)										as IDA_EXPN_TAX_RT" ).append("\n"); 
		query.append("				   ,max(T1.IDA_EXPN_TAX)										as IDA_EXPN_TAX" ).append("\n"); 
		query.append("				   ,max(T1.IDA_EDU_TAX_RT)										as IDA_EDU_TAX_RT" ).append("\n"); 
		query.append("				   ,max(T1.IDA_EDU_TAX)											as IDA_EDU_TAX" ).append("\n"); 
		query.append("				   ,max(T1.IDA_HIGH_EDU_TAX_RT)									as IDA_HIGH_EDU_TAX_RT" ).append("\n"); 
		query.append("				   ,max(T1.IDA_HIGH_EDU_TAX)									as IDA_HIGH_EDU_TAX" ).append("\n"); 
		query.append("					   " ).append("\n"); 
		query.append("				   ,max(T1.TAX_RTO)												as TAX_RTO" ).append("\n"); 
		query.append("			  from  DMT_INV_MN 			T1" ).append("\n"); 
		query.append("				   ,DMT_INV_DTL 		T2" ).append("\n"); 
		query.append("				   ,DMT_CHG_BKG_CNTR	T3" ).append("\n"); 
		query.append("				   ,DMT_CHG_CALC    	T4" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			 where  T1.DMDT_INV_NO         = @[s_invoice_no]" ).append("\n"); 
		query.append("			   and  T1.CRE_OFC_CD 	       = @[ofc_cd]" ).append("\n"); 
		query.append("			   and  T1.DMDT_TRF_CD         = @[s_dmdt_trf_cd]" ).append("\n"); 
		query.append("			   and  T1.DMDT_INV_STS_CD     = 'X'" ).append("\n"); 
		query.append("			   and  T1.DMDT_VT_INV_STS_CD  = 'C'" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   and  T1.DMDT_INV_NO 	       = T2.DMDT_INV_NO" ).append("\n"); 
		query.append("			   and  T1.CRE_OFC_CD          = T2.CRE_OFC_CD" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   and  T2.SYS_AREA_GRP_ID     = T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   and  T2.CNTR_NO             = T3.CNTR_NO" ).append("\n"); 
		query.append("			   and  T2.CNTR_CYC_NO         = T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   --and  T1.BKG_NO			   = T3.BKG_NO" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   and  T2.SYS_AREA_GRP_ID     = T4.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   and  T2.CNTR_NO             = T4.CNTR_NO" ).append("\n"); 
		query.append("			   and  T2.CNTR_CYC_NO         = T4.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   and  T2.DMDT_TRF_CD         = T4.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   and  T2.DMDT_CHG_LOC_DIV_CD = T4.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   and  T2.CHG_SEQ 			   = T4.CHG_SEQ" ).append("\n"); 
		query.append("               AND  T4.DMDT_CHG_STS_CD IN ( 'F','C' )" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			group by T1.DMDT_INV_NO" ).append("\n"); 
		query.append("		) T" ).append("\n"); 

	}
}