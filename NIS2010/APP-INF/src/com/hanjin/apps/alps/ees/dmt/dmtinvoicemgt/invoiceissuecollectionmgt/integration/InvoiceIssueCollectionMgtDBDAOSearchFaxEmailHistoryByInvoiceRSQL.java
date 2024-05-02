/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
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

public class InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByInvoiceRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shttppp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByInvoiceRSQL").append("\n"); 
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
		query.append("select  T2.DMDT_INV_NO 								as INVNOO" ).append("\n"); 
		query.append("	   ,T2.DMDT_SND_DOC_TP_CD						as SHTYPE" ).append("\n"); 
		query.append("	   ,decode(T2.DMDT_FAX_EML_SND_TP_CD, 'F', T2.DMDT_PAYR_FAX_NO, T2.DMDT_PAYR_EML)	" ).append("\n"); 
		query.append("													as FAXEML" ).append("\n"); 
		query.append("	   ,decode(T2.DMDT_FAX_EML_SND_TP_CD, 'E', (" ).append("\n"); 
		query.append("													select  decode(EML_PROC_STS_CD, 3, 'Sent Successfully', '')" ).append("\n"); 
		query.append("													  from  COM_EML_SND_INFO" ).append("\n"); 
		query.append("													 where  EML_SND_NO = T2.FAX_EML_SND_NO" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("											 , (" ).append("\n"); 
		query.append("													select  nvl(XPT_ERR_MSG , FAX_ERR_MSG)" ).append("\n"); 
		query.append("													  from  COM_FAX_SND_INFO" ).append("\n"); 
		query.append("													 where  RD_SUB_SYS_CD = 'DMT'" ).append("\n"); 
		query.append("													   and  FAX_SND_NO    = T2.FAX_EML_SND_NO" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("		) 											as RSTMSG" ).append("\n"); 
		query.append("	   ,to_char(T2.CRE_DT, 'YYYY-MM-DD HH24:mi') 	as SNDDAT" ).append("\n"); 
		query.append("	   ,T2.CRE_OFC_CD                          		as SNDOFF" ).append("\n"); 
		query.append("	   ,T2.CRE_USR_ID                          		as SNDRID	" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  USR_NM " ).append("\n"); 
		query.append("			  from  COM_USER " ).append("\n"); 
		query.append("			 where  USR_ID = T2.CRE_USR_ID" ).append("\n"); 
		query.append("		)											as SNDRNM" ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
		query.append("			select  T1.DMDT_INV_NO" ).append("\n"); 
		query.append("			  from  DMT_INV_MN  T1" ).append("\n"); 
		query.append("			 where  T1.DMDT_INV_NO in" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						#foreach( $dmdt_inv_no_p in ${tempINVOICEList}) " ).append("\n"); 
		query.append("							#if($velocityCount < $tempINVOICEList.size()) " ).append("\n"); 
		query.append("							   '$dmdt_inv_no_p', " ).append("\n"); 
		query.append("							#else " ).append("\n"); 
		query.append("							   '$dmdt_inv_no_p' " ).append("\n"); 
		query.append("							#end " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("						   " ).append("\n"); 
		query.append("			union all" ).append("\n"); 
		query.append("						   " ).append("\n"); 
		query.append("			select  DMDT_INV_NO" ).append("\n"); 
		query.append("			  from  (" ).append("\n"); 
		query.append("						select  T1.DMDT_INV_NO" ).append("\n"); 
		query.append("							   ,row_number() over (order by T1.UPD_DT desc) as VT_INV_SEQ" ).append("\n"); 
		query.append("						  from  DMT_INV_MN  T1" ).append("\n"); 
		query.append("						 where  (T1.DMDT_INV_NO, T1.CRE_OFC_CD) in" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									 select  DMDT_INV_NO, CRE_OFC_CD" ).append("\n"); 
		query.append("									   from  DMT_INV_DTL" ).append("\n"); 
		query.append("									  where  (SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) in" ).append("\n"); 
		query.append("											 (" ).append("\n"); 
		query.append("												 select  SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ" ).append("\n"); 
		query.append("												   from  DMT_INV_DTL" ).append("\n"); 
		query.append("												  where  DMDT_INV_NO in" ).append("\n"); 
		query.append("														(" ).append("\n"); 
		query.append("															#foreach( $dmdt_inv_no_p in ${tempINVOICEList}) " ).append("\n"); 
		query.append("																#if($velocityCount < $tempINVOICEList.size()) " ).append("\n"); 
		query.append("																   '$dmdt_inv_no_p', " ).append("\n"); 
		query.append("																#else " ).append("\n"); 
		query.append("																   '$dmdt_inv_no_p' " ).append("\n"); 
		query.append("																#end " ).append("\n"); 
		query.append("															#end" ).append("\n"); 
		query.append("														)												  " ).append("\n"); 
		query.append("											 )" ).append("\n"); 
		query.append("								 ) " ).append("\n"); 
		query.append("						   and  T1.DMDT_INV_NO not in" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									#foreach( $dmdt_inv_no_p in ${tempINVOICEList}) " ).append("\n"); 
		query.append("										#if($velocityCount < $tempINVOICEList.size()) " ).append("\n"); 
		query.append("										   '$dmdt_inv_no_p', " ).append("\n"); 
		query.append("										#else " ).append("\n"); 
		query.append("										   '$dmdt_inv_no_p' " ).append("\n"); 
		query.append("										#end " ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								)						   " ).append("\n"); 
		query.append("						   and  T1.DMDT_INV_STS_CD     = 'X'" ).append("\n"); 
		query.append("						   and  T1.DMDT_VT_INV_STS_CD  = 'I'" ).append("\n"); 
		query.append("						   and  exists" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									select  1" ).append("\n"); 
		query.append("									  from  DMT_FAX_EML_SND_HIS" ).append("\n"); 
		query.append("									 where  DMDT_INV_NO = T1.DMDT_INV_NO" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			 where  VT_INV_SEQ = 1" ).append("\n"); 
		query.append("		) 						T1" ).append("\n"); 
		query.append("	   ,DMT_FAX_EML_SND_HIS 	T2" ).append("\n"); 
		query.append(" where  T1.DMDT_INV_NO = T2.DMDT_INV_NO   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${shttppp} != 'A')" ).append("\n"); 
		query.append("   and  T2.DMDT_SND_DOC_TP_CD = @[shttppp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("group by T2.DMDT_INV_NO" ).append("\n"); 
		query.append("        ,T2.DMDT_SND_DOC_TP_CD" ).append("\n"); 
		query.append("        ,T2.DMDT_PAYR_FAX_NO" ).append("\n"); 
		query.append("        ,T2.DMDT_PAYR_EML" ).append("\n"); 
		query.append("        ,T2.FAX_EML_SND_RSLT_MSG" ).append("\n"); 
		query.append("        ,T2.CRE_DT" ).append("\n"); 
		query.append("        ,T2.CRE_OFC_CD" ).append("\n"); 
		query.append("        ,T2.CRE_USR_ID" ).append("\n"); 
		query.append("        ,T2.FAX_EML_SND_NO" ).append("\n"); 
		query.append("        ,T2.DMDT_FAX_EML_SND_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("order by T2.DMDT_INV_NO desc, T2.CRE_DT desc" ).append("\n"); 

	}
}