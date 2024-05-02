/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchEdiPHILSBkgBlDocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOsearchEdiPHILSBkgBlDocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiPHILSBkgBlDoc
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchEdiPHILSBkgBlDocRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchEdiPHILSBkgBlDocRSQL").append("\n"); 
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
		query.append("PCK_QTY, " ).append("\n"); 
		query.append("PCK_TP_CD, " ).append("\n"); 
		query.append("ACT_WGT, " ).append("\n"); 
		query.append("WGT_UT_CD, " ).append("\n"); 
		query.append("MEAS_QTY, " ).append("\n"); 
		query.append("MEAS_UT_CD " ).append("\n"); 
		query.append("FROM BKG_BL_DOC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}