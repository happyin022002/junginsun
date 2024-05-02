/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOCPRTListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOCPRTListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOCPRTListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOCPRTListVORSQL").append("\n"); 
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
		query.append("SELECT	A.AR_OFC_CD" ).append("\n"); 
		query.append("		,A.CUST_RPT_ID" ).append("\n"); 
		query.append("		,TO_CHAR(A.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("		,A.RPT_TMPLT_NM" ).append("\n"); 
		query.append("		,A.CRE_USR_ID" ).append("\n"); 
		query.append("FROM	INV_CPRT_HIS A" ).append("\n"); 
		query.append("WHERE	SUBSTR(A.CUST_RPT_ID,4,8) >= REPLACE(@[from_cre_dt],'-','')" ).append("\n"); 
		query.append("AND		SUBSTR(A.CUST_RPT_ID,4,8) <= REPLACE(@[to_cre_dt],'-','')" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '')     " ).append("\n"); 
		query.append("AND		A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '') " ).append("\n"); 
		query.append("AND 	A.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.AR_OFC_CD" ).append("\n"); 
		query.append(",A.CUST_RPT_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.RPT_TMPLT_NM" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append("ORDER BY A.CUST_RPT_ID" ).append("\n"); 

	}
}