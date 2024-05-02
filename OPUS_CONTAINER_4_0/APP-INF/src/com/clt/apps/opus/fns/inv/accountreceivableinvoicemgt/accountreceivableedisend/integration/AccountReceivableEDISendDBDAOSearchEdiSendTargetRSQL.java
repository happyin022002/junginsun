/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiSendTargetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEdiSendTargetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiSendTarget
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiSendTargetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiSendTargetRSQL").append("\n"); 
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
		query.append("SELECT EDI_TP_CD, INV_NO, AR_IF_NO, '' AS CNTR_NO" ).append("\n"); 
		query.append("     , SUBSTR(XMLAGG(XMLELEMENT(X,',', EDI_HDR_SEQ ) ORDER BY EDI_HDR_SEQ).EXTRACT('//text()').GetStringVal(), 2) EDI_HDR_SEQ " ).append("\n"); 
		query.append("     , ACT_CUST_CNT_CD, ACT_CUST_SEQ, INV_DT, BKG_NO " ).append("\n"); 
		query.append("FROM INV_EDI_HDR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND EDI_HDR_SEQ IN (${edi_hdr_seq_list})" ).append("\n"); 
		query.append("AND EDI_TP_CD = 'INV_BL'" ).append("\n"); 
		query.append("GROUP BY EDI_TP_CD, INV_NO, AR_IF_NO, ACT_CUST_CNT_CD, ACT_CUST_SEQ, INV_DT, BKG_NO   " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT EDI_TP_CD, INV_NO, '' AS AR_IF_NO, CNTR_NO" ).append("\n"); 
		query.append("     , SUBSTR(XMLAGG(XMLELEMENT(X,',', EDI_HDR_SEQ ) ORDER BY EDI_HDR_SEQ).EXTRACT('//text()').GetStringVal(), 2) EDI_HDR_SEQ " ).append("\n"); 
		query.append("     , ACT_CUST_CNT_CD, ACT_CUST_SEQ, INV_DT, '' AS BKG_NO  " ).append("\n"); 
		query.append("FROM INV_EDI_HDR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND EDI_HDR_SEQ IN (${edi_hdr_seq_list})" ).append("\n"); 
		query.append("AND EDI_TP_CD = 'INV_CNTR'" ).append("\n"); 
		query.append("GROUP BY EDI_TP_CD, INV_NO, CNTR_NO, ACT_CUST_CNT_CD, ACT_CUST_SEQ, INV_DT" ).append("\n"); 

	}
}