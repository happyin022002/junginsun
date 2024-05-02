/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByPayerRSQL.java
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

public class InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByPayerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByPayerRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByPayerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payercd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shttppp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByPayerRSQL").append("\n"); 
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
		query.append("select  decode(H.ACT_PAYR_CNT_CD, '00', '', H.ACT_PAYR_CNT_CD) || lpad(H.ACT_PAYR_SEQ, 6, '0')" ).append("\n"); 
		query.append("													as INVNOO" ).append("\n"); 
		query.append("	   ,H.DMDT_SND_DOC_TP_CD						as SHTYPE" ).append("\n"); 
		query.append("	   ,decode(H.DMDT_FAX_EML_SND_TP_CD, 'F', H.DMDT_PAYR_FAX_NO, H.DMDT_PAYR_EML)	" ).append("\n"); 
		query.append("													as FAXEML" ).append("\n"); 
		query.append("	   ,decode(H.DMDT_FAX_EML_SND_TP_CD, 'E', (" ).append("\n"); 
		query.append("													select  decode(EML_PROC_STS_CD, 3, 'Sent Successfully', '')" ).append("\n"); 
		query.append("													  from  COM_EML_SND_INFO" ).append("\n"); 
		query.append("													 where  EML_SND_NO = H.FAX_EML_SND_NO" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("											 , (" ).append("\n"); 
		query.append("													select  nvl(XPT_ERR_MSG , FAX_ERR_MSG)" ).append("\n"); 
		query.append("													  from  COM_FAX_SND_INFO" ).append("\n"); 
		query.append("													 where  RD_SUB_SYS_CD = 'DMT'" ).append("\n"); 
		query.append("													   and  FAX_SND_NO    = H.FAX_EML_SND_NO" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("		) 											as RSTMSG" ).append("\n"); 
		query.append("	   ,to_char(H.CRE_DT, 'YYYY-MM-DD HH24:mi') 	as SNDDAT" ).append("\n"); 
		query.append("	   ,H.CRE_OFC_CD                          		as SNDOFF" ).append("\n"); 
		query.append("	   ,H.CRE_USR_ID                          		as SNDRID	" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  USR_NM " ).append("\n"); 
		query.append("			  from  COM_USER " ).append("\n"); 
		query.append("			 where  USR_ID = H.CRE_USR_ID" ).append("\n"); 
		query.append("		)                                   		as SNDRNM" ).append("\n"); 
		query.append("  from  DMT_FAX_EML_SND_HIS H" ).append("\n"); 
		query.append(" where  ACT_PAYR_CNT_CD = decode(length(@[payercd]), 8, nvl(substr(@[payercd], 1, 2), H.ACT_PAYR_CNT_CD), 6, H.ACT_PAYR_CNT_CD, H.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("   and  ACT_PAYR_SEQ    = decode(length(@[payercd]), 8, nvl(substr(@[payercd], 3, 6), H.ACT_PAYR_SEQ),    6, @[payercd],        H.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${shttppp} != 'A' )" ).append("\n"); 
		query.append("   and  DMDT_SND_DOC_TP_CD = @[shttppp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("group by  decode(H.ACT_PAYR_CNT_CD, '00', '', H.ACT_PAYR_CNT_CD) || lpad(H.ACT_PAYR_SEQ, 6, '0') " ).append("\n"); 
		query.append("         ,H.DMDT_SND_DOC_TP_CD" ).append("\n"); 
		query.append("         ,H.DMDT_PAYR_FAX_NO" ).append("\n"); 
		query.append("         ,H.DMDT_PAYR_EML" ).append("\n"); 
		query.append("         ,H.FAX_EML_SND_RSLT_MSG" ).append("\n"); 
		query.append("         ,H.CRE_DT" ).append("\n"); 
		query.append("         ,H.CRE_OFC_CD" ).append("\n"); 
		query.append("         ,H.CRE_USR_ID" ).append("\n"); 
		query.append("         ,H.FAX_EML_SND_NO" ).append("\n"); 
		query.append("         ,H.DMDT_FAX_EML_SND_TP_CD" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("order by H.CRE_DT desc" ).append("\n"); 

	}
}