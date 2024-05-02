/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOsearchAgentByVesselListVORSQL.java
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

public class ARInvoiceCustomerMgtDBDAOsearchAgentByVesselListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_INF_0080 by vessel
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOsearchAgentByVesselListVORSQL(){
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
		query.append("FileName : ARInvoiceCustomerMgtDBDAOsearchAgentByVesselListVORSQL").append("\n"); 
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
		query.append("SELECT A.AR_OFC_CD," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("B.VSL_ENG_NM," ).append("\n"); 
		query.append("DECODE(A.CUST_CNT_CD,'','',DECODE(A.CUST_SEQ,'','',A.CUST_CNT_CD || '-' || LPAD(A.CUST_SEQ,6,0))) CUST_CD," ).append("\n"); 
		query.append("A.CUST_CNT_CD CUST_CNT_CD," ).append("\n"); 
		query.append("LPAD(A.CUST_SEQ,6,0) CUST_SEQ," ).append("\n"); 
		query.append("DECODE(A.VNDR_CNT_CD,'','',DECODE(A.VNDR_SEQ,'','',A.VNDR_CNT_CD || '-' || LPAD(A.VNDR_SEQ,6,0))) VNDR_CD," ).append("\n"); 
		query.append("A.VNDR_CNT_CD VNDR_CNT_CD," ).append("\n"); 
		query.append("LPAD(A.VNDR_SEQ,6,0) VNDR_SEQ," ).append("\n"); 
		query.append("TO_CHAR(A.UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT," ).append("\n"); 
		query.append("A.AGN_CD AGN_CD1" ).append("\n"); 
		query.append("FROM INV_VSL_AGN_CUST_CD A, MDM_VSL_CNTR B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.AR_OFC_CD IN (SELECT A.AR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("(SELECT SUBSTR(LOC_CD,1,2) CNT_CD, AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]) B" ).append("\n"); 
		query.append("WHERE A.AR_HD_QTR_OFC_CD = B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("AND SUBSTR(A.LOC_CD,1,2) = B.CNT_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}