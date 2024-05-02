/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOsearchEdiPHILSLocationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOsearchEdiPHILSLocationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiPHILSLocationList
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOsearchEdiPHILSLocationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOsearchEdiPHILSLocationListRSQL").append("\n"); 
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
		query.append("A.CUST_CNT_CD" ).append("\n"); 
		query.append(",LPAD(A.CUST_SEQ,6,0) CUST_SEQ" ).append("\n"); 
		query.append(",B.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append(",SUBSTR(C.BZET_ADDR||' '||C.CTY_NM||' '||C.STE_CD,1,400) CUST_ADDR" ).append("\n"); 
		query.append(",A.PHILS_LOC_CD_CTNT" ).append("\n"); 
		query.append(",A.PHILS_LOC_CD_RMK" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append("FROM INV_EDI_PHILS_LOC A," ).append("\n"); 
		query.append("     MDM_CUSTOMER B," ).append("\n"); 
		query.append("     MDM_CUST_ADDR C " ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("AND   A.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("AND   C.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY CUST_CNT_CD, CUST_SEQ ASC" ).append("\n"); 

	}
}