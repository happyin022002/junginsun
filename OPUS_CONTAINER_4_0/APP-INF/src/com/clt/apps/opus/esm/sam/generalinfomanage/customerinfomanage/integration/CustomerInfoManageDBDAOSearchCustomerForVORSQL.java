/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustomerForVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.06.15 이창원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustomerForVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CustomerInfoManageDBDAOSearchCustomerForVO
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustomerForVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchCustomerForVORSQL").append("\n"); 
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
		query.append("SELECT '' BZET_ADDR" ).append("\n"); 
		query.append(", '' CRE_OFC_CD" ).append("\n"); 
		query.append(", '' CRE_USR_ID" ).append("\n"); 
		query.append(", '' CUST_CD" ).append("\n"); 
		query.append(", '' CUST_CNT_CD" ).append("\n"); 
		query.append(", '' CUST_EML" ).append("\n"); 
		query.append(", '' CUST_GRP_ID" ).append("\n"); 
		query.append(", '' CUST_GRP_NM" ).append("\n"); 
		query.append(", '' CUST_KMAN_SEQ" ).append("\n"); 
		query.append(", '' CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(", '' CUST_NM" ).append("\n"); 
		query.append(", '' CUST_OFFICE" ).append("\n"); 
		query.append(", '' CUST_RGST_NO" ).append("\n"); 
		query.append(", '' CUST_SEQ" ).append("\n"); 
		query.append(", '' CUST_STS_CD" ).append("\n"); 
		query.append(", '' CUST_TOTAL" ).append("\n"); 
		query.append(", '' CUSTOMER_CD" ).append("\n"); 
		query.append(", '' CUSTOMER_CODE" ).append("\n"); 
		query.append(", '' FAX_NO" ).append("\n"); 
		query.append(", '' FLG" ).append("\n"); 
		query.append(", '' INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append(", '' INTL_PHN_NO" ).append("\n"); 
		query.append(", '' JB_TIT_RMK" ).append("\n"); 
		query.append(", '' KEY_ACCT_FLG" ).append("\n"); 
		query.append(", '' KMAN_GND_CD" ).append("\n"); 
		query.append(", '' KMAN_LST_NM" ).append("\n"); 
		query.append(", '' KMAN_NLST_NM" ).append("\n"); 
		query.append(", '' KMAN_N1ST_NM" ).append("\n"); 
		query.append(", '' KMAN_OFC_FAX_NO" ).append("\n"); 
		query.append(", '' LOC_CD" ).append("\n"); 
		query.append(", '' MLT_TRD_ACCT_FLG" ).append("\n"); 
		query.append(", '' OFC_CD" ).append("\n"); 
		query.append(", '' OFC_ENG_NM" ).append("\n"); 
		query.append(", '' PHN_NO" ).append("\n"); 
		query.append(", '' RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append(", '' SALES_REP" ).append("\n"); 
		query.append(", '' SREP_CD" ).append("\n"); 
		query.append(", '' SREP_NM" ).append("\n"); 
		query.append(", '' TEL_NO" ).append("\n"); 
		query.append(", '' USER_ID" ).append("\n"); 
		query.append(", '' USR_NM" ).append("\n"); 
		query.append(", '' ZIP_CD" ).append("\n"); 
		query.append(", '' PRIMARY_SREP_CD" ).append("\n"); 
		query.append(", '' CTS_NO" ).append("\n"); 
		query.append(", '' INTL_FAX_NO" ).append("\n"); 
		query.append(", '' INTL_PHN_NO" ).append("\n"); 
		query.append(", '' CUST_GRP_NAME" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}