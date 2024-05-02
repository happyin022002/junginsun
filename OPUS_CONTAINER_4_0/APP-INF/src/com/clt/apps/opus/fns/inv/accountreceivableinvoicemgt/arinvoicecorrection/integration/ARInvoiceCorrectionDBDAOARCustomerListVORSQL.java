/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOARCustomerListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.24 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOARCustomerListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOARCustomerListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOARCustomerListVORSQL").append("\n"); 
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
		query.append("SELECT A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,0) CUST_CD," ).append("\n"); 
		query.append("A.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("C.BZET_ADDR ADDR," ).append("\n"); 
		query.append("C.ZIP_CD," ).append("\n"); 
		query.append("B.CR_CLT_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A," ).append("\n"); 
		query.append("MDM_CR_CUST  B," ).append("\n"); 
		query.append("MDM_CUST_ADDR C" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ    = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ    = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND C.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.CUST_LGL_ENG_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = (SELECT SUBSTR(LOC_CD,1,2)" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 

	}
}