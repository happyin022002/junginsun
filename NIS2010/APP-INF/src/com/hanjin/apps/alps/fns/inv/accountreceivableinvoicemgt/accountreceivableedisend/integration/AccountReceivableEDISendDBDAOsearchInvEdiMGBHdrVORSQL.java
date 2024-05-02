/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchInvEdiMGBHdrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOsearchInvEdiMGBHdrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvEdiMGBHdrVO
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchInvEdiMGBHdrVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration ").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchInvEdiMGBHdrVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("'' AS  DOC_NO" ).append("\n"); 
		query.append(",'' AS FUNC_CD" ).append("\n"); 
		query.append(",'' AS PAPER_IND" ).append("\n"); 
		query.append(",'' AS DOC_DATE" ).append("\n"); 
		query.append(",'' AS CNTR_NO " ).append("\n"); 
		query.append(",'' AS INV_NO" ).append("\n"); 
		query.append(",'' AS INV_ISSUE_DATE" ).append("\n"); 
		query.append(",'' AS TOT_AMNT" ).append("\n"); 
		query.append(",'' AS INV_CUR" ).append("\n"); 
		query.append(",'' AS PT_CD " ).append("\n"); 
		query.append(",'' AS BL_SRC_NO" ).append("\n"); 
		query.append(",'' AS TTL_TRF_RT_AMT" ).append("\n"); 
		query.append(",'' AS EDI_SND_FLG" ).append("\n"); 
		query.append(",'' AS CRE_USR_ID" ).append("\n"); 
		query.append(",'' AS CRE_DT" ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append(",'' AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}