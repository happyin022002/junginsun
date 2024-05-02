/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOAgentByVesselVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.19 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author saeil kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOAgentByVesselVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_INV_0081 retrive
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOAgentByVesselVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("A.VSL_CD VSL_CD" ).append("\n"); 
		query.append(",	A.AGN_CD AGN_CD" ).append("\n"); 
		query.append(",	A.AR_OFC_CD AR_OFC_CD" ).append("\n"); 
		query.append(",	A.CUST_CNT_CD CUST_CNT_CD" ).append("\n"); 
		query.append(",	lpad(A.CUST_SEQ,6,0) CUST_SEQ" ).append("\n"); 
		query.append(",	A.VNDR_CNT_CD VNDR_CNT_CD" ).append("\n"); 
		query.append(",	lpad(A.VNDR_SEQ,6,0) VNDR_SEQ" ).append("\n"); 
		query.append(",   B.CUST_LGL_ENG_NM CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM INV_VSL_AGN_CUST_CD A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("AND VSL_CD = @[vsl_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOAgentByVesselVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}