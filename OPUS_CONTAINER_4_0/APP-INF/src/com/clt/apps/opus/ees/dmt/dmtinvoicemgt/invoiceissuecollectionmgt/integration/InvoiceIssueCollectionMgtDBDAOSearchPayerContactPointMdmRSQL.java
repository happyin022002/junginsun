/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointMdmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointMdmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Payer Info & Fax/E-mail
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointMdmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointMdmRSQL").append("\n"); 
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
		query.append("#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("SELECT A.CNTC_PSON_NM AS PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",B.PHN_NO AS PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",B.FAX_NO AS PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",B.VNDR_EML AS PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append("FROM MDM_VENDOR A, MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[s_cust_cd]" ).append("\n"); 
		query.append("AND B.VNDR_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2')" ).append("\n"); 
		query.append("SELECT C.CNTC_PSON_NM AS PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",DECODE(C.IB_PHN_NO, NULL, B.PHN_NO, C.IB_PHN_NO) AS PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",DECODE(C.IB_FAX_NO, NULL, B.FAX_NO, C.IB_FAX_NO) AS PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",DECODE(C.IB_EML, NULL, B.CUST_EML, C.IB_EML) AS PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A, MDM_CUST_CNTC_PNT B, MDM_CR_CUST C" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD 	= B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD		= C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ			= C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 		= substr(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("AND B.CUST_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}