/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchKeyManVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.18
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.05.18 박찬민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Chan Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchKeyManVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchKeyManVO
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchKeyManVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration ").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchKeyManVORSQL").append("\n"); 
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
		query.append("SELECT '' CUST_KMAN_SEQ" ).append("\n"); 
		query.append(", '' KMAN_N1ST_NM" ).append("\n"); 
		query.append(", '' KMAN_LST_NM" ).append("\n"); 
		query.append(", '' KMAN_MARR_FLG" ).append("\n"); 
		query.append(", '' JB_TIT_RMK" ).append("\n"); 
		query.append(", '' INTL_PHN_NO" ).append("\n"); 
		query.append(", '' KMAN_OFC_PHN_NO" ).append("\n"); 
		query.append(", '' KMAN_OFC_FAX_NO" ).append("\n"); 
		query.append(", '' KMAN_EML" ).append("\n"); 
		query.append(", '' CUSTOMER_CODE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}