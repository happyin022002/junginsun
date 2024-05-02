/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchAROfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.12.08 박정진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchAROfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchAROfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchAROfficeRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.AR_OFC_CD," ).append("\n"); 
		query.append("NVL(B.INV_DUP_FLG, 'N') INV_DUP_FLG" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("INV_AR_STUP_OFC B" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = B.AR_OFC_CD(+)" ).append("\n"); 
		query.append("AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}