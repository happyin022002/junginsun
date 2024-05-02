/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOsearchSVATNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOsearchSVATNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SVATNo Select Query
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOsearchSVATNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("custSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("custCntCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svatRgstNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOsearchSVATNoRSQL").append("\n"); 
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
		query.append("SELECT	A.CUST_CNT_CD" ).append("\n"); 
		query.append("		, A.CUST_SEQ" ).append("\n"); 
		query.append("		, A.CUST_CNT_CD || '-' || A.CUST_SEQ AS CUST_CD" ).append("\n"); 
		query.append("		, A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("		, A.CUST_RGST_NO" ).append("\n"); 
		query.append("		, B.SPND_VAT_RGST_NO" ).append("\n"); 
		query.append("        , B.UPD_USR_ID" ).append("\n"); 
		query.append("        , TO_CHAR(B.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("FROM	MDM_CUSTOMER A" ).append("\n"); 
		query.append("		, INV_AR_SPND_VAT_RGST_NO B" ).append("\n"); 
		query.append("WHERE	A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND		A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND		A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#if(${gubun} =='2')" ).append("\n"); 
		query.append("AND    B.SPND_VAT_RGST_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${custCntCd} != '')" ).append("\n"); 
		query.append("AND    A.CUST_CNT_CD = @[custCntCd]" ).append("\n"); 
		query.append("    #if(${custSeq} != '')" ).append("\n"); 
		query.append("    AND     A.CUST_SEQ = @[custSeq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${svatRgstNo} != '')" ).append("\n"); 
		query.append("AND    B.SPND_VAT_RGST_NO = @[svatRgstNo]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND		A.CUST_RGST_NO IS NOT NULL --(2011.10.13) 삭제" ).append("\n"); 

	}
}