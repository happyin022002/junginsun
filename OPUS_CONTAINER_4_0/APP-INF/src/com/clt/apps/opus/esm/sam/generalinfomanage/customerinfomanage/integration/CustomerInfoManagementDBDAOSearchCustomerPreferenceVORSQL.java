/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManagementDBDAOSearchCustomerPreferenceVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.13
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.06.13 박찬민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Chan Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManagementDBDAOSearchCustomerPreferenceVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomerPreferenceVO
	  * </pre>
	  */
	public CustomerInfoManagementDBDAOSearchCustomerPreferenceVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManagementDBDAOSearchCustomerPreferenceVORSQL").append("\n"); 
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
		query.append("SELECT '' CUST_PRF_SEQ" ).append("\n"); 
		query.append(", '' PRF_CATE_CD" ).append("\n"); 
		query.append(", '' PRF_MOD_CD" ).append("\n"); 
		query.append(", '' PRF_FM_LOC_CD" ).append("\n"); 
		query.append(", '' PRF_TO_LOC_CD" ).append("\n"); 
		query.append(", '' VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(", '' PRF_VNDR_SEQ" ).append("\n"); 
		query.append(", '' USER_ID" ).append("\n"); 
		query.append(", '' CUST_CD" ).append("\n"); 
		query.append(", '' CUST_CNT_CD" ).append("\n"); 
		query.append(", '' CUST_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}