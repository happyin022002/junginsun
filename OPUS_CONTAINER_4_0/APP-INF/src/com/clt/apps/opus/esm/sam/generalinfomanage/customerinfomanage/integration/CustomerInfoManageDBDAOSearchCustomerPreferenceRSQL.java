/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustomerPreferenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.08
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.08.08 박찬민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK CHAN MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustomerPreferenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomerPreference
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustomerPreferenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchCustomerPreferenceRSQL").append("\n"); 
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
		query.append("SELECT CUST_PRF_SEQ" ).append("\n"); 
		query.append("     , PRF_CATE_CD" ).append("\n"); 
		query.append("     , PRF_MOD_CD" ).append("\n"); 
		query.append("     , PRF_FM_LOC_CD" ).append("\n"); 
		query.append("     , PRF_TO_LOC_CD" ).append("\n"); 
		query.append("     , VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , PRF_VNDR_SEQ" ).append("\n"); 
		query.append("	 , CUST_CNT_CD" ).append("\n"); 
		query.append("	 , CUST_SEQ" ).append("\n"); 
		query.append("FROM SAM_CUST_PRF_INFO, MDM_VENDOR" ).append("\n"); 
		query.append("WHERE SAM_CUST_PRF_INFO.PRF_VNDR_SEQ = MDM_VENDOR.VNDR_SEQ" ).append("\n"); 
		query.append("AND CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("ORDER BY CUST_PRF_SEQ" ).append("\n"); 

	}
}