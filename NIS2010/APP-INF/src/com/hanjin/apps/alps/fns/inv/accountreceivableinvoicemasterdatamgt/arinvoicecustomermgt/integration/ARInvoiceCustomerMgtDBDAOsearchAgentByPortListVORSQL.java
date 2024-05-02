/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOsearchAgentByPortListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.12.10 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOsearchAgentByPortListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_INV_0090 by pod/lane
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOsearchAgentByPortListVORSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOsearchAgentByPortListVORSQL").append("\n"); 
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
		query.append("SELECT FDR_POD_CD," ).append("\n"); 
		query.append("LANE_CD," ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("AR_OFC_CD," ).append("\n"); 
		query.append("DECODE(CUST_CNT_CD,'','',DECODE(CUST_SEQ,'','',CUST_CNT_CD || '-' || LPAD(CUST_SEQ,6,0))) CUST_CD," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("LPAD(CUST_SEQ,6,0) CUST_SEQ," ).append("\n"); 
		query.append("DECODE(VNDR_CNT_CD,'','',DECODE(VNDR_SEQ,'','',VNDR_CNT_CD || '-' || LPAD(VNDR_SEQ,6,0))) VNDR_CD," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("LPAD(VNDR_SEQ,6,0) VNDR_SEQ," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT," ).append("\n"); 
		query.append("AGN_CD AGN_CD1" ).append("\n"); 
		query.append("FROM INV_FDR_POD_AGN_CUST_CD" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE AR_OFC_CD IN (SELECT A.AR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("(SELECT SUBSTR(LOC_CD,1,2) CNT_CD, AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]) B" ).append("\n"); 
		query.append("WHERE A.AR_HD_QTR_OFC_CD = B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("AND SUBSTR(A.LOC_CD,1,2) = B.CNT_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}