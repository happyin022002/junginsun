/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSBlDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.14 
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

public class AccountReceivableEDISendDBDAOSearchEdiPHILSBlDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Get Booking Description.
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiPHILSBlDescRSQL(){
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
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSBlDescRSQL").append("\n"); 
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
		query.append("SELECT NVL(REPLACE(BD.CMDT_DESC,chr(13)||chr(10),' '), REPLACE(MC.CMDT_NM,chr(13)||chr(10),' ')) BL_DESC" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK," ).append("\n"); 
		query.append("       BKG_BL_MK_DESC BD," ).append("\n"); 
		query.append("       MDM_COMMODITY MC" ).append("\n"); 
		query.append("WHERE  BK.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("AND    BK.CMDT_CD = MC.CMDT_CD" ).append("\n"); 
		query.append("AND    BK.BKG_NO = @[bkg_no] " ).append("\n"); 

	}
}