/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSearchInvEdiRcvSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.28 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceEdiHitDBDAOSearchInvEdiRcvSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice EDI Receive Sequence 채번
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSearchInvEdiRcvSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSearchInvEdiRcvSeqRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE,'YYYYMMDD')||LPAD(TRS_INV_EDI_RCV_SEQ.NEXTVAL,4,'0') EDI_RCV_SEQ" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}