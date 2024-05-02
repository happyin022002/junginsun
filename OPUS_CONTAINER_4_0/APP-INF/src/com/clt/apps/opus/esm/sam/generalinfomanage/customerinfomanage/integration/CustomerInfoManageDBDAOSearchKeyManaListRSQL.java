/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchKeyManaListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.02
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.03.02 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchKeyManaListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchKeyManaList
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchKeyManaListRSQL(){
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
		query.append("FileName : CustomerInfoManageDBDAOSearchKeyManaListRSQL").append("\n"); 
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
		query.append("SELECT CUST_KMAN_SEQ" ).append("\n"); 
		query.append("     , KMAN_N1ST_NM" ).append("\n"); 
		query.append("     , KMAN_LST_NM" ).append("\n"); 
		query.append("     , KMAN_GND_CD" ).append("\n"); 
		query.append("     , JB_TIT_RMK" ).append("\n"); 
		query.append("     , INTL_PHN_NO" ).append("\n"); 
		query.append("     , KMAN_OFC_PHN_NO" ).append("\n"); 
		query.append("     , KMAN_OFC_FAX_NO" ).append("\n"); 
		query.append("     , KMAN_EML" ).append("\n"); 
		query.append("FROM SAM_CUST_KMAN_INFO" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND   CUST_SEQ = SUBSTR(@[cust_cd],3,6)" ).append("\n"); 
		query.append("ORDER BY CUST_KMAN_SEQ" ).append("\n"); 

	}
}