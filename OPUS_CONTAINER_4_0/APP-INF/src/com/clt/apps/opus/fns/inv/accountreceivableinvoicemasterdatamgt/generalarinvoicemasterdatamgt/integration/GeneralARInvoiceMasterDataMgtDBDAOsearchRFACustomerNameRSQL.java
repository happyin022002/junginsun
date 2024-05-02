/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOsearchRFACustomerNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOsearchRFACustomerNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRFACustomerName
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOsearchRFACustomerNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOsearchRFACustomerNameRSQL").append("\n"); 
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
		query.append("SELECT M.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("  FROM PRI_RP_MN A, " ).append("\n"); 
		query.append("       MDM_CUSTOMER M" ).append("\n"); 
		query.append(" WHERE A.CTRT_CUST_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND A.CTRT_CUST_SEQ    = M.CUST_SEQ" ).append("\n"); 
		query.append("   AND (A.PROP_NO, A.AMDT_SEQ) in" ).append("\n"); 
		query.append("     (SELECT C.PROP_NO, " ).append("\n"); 
		query.append("             MAX(C.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("        FROM PRI_RP_MN C, PRI_RP_HDR D" ).append("\n"); 
		query.append("       WHERE C.PROP_NO = D.PROP_NO" ).append("\n"); 
		query.append("         AND D.RFA_NO   = @[rfa_no]" ).append("\n"); 
		query.append("       GROUP BY C.PROP_NO  )" ).append("\n"); 

	}
}