/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustActvityListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.08
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.06.08 박찬민
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

public class CustomerInfoManageDBDAOSearchCustActvityListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustActvityListVO
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustActvityListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchCustActvityListVORSQL").append("\n"); 
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
		query.append("SELECT '' SLS_ACT_SEQ" ).append("\n"); 
		query.append(", '' SREP_CMT_DESC" ).append("\n"); 
		query.append(", '' KEYMAN_NM" ).append("\n"); 
		query.append(", '' SLS_ACT_TP_CD" ).append("\n"); 
		query.append(", '' SLS_ACT_SUB_TP_CD" ).append("\n"); 
		query.append(", '' ACT_PLN_DT" ).append("\n"); 
		query.append(", '' SLS_ACT_ACT_DT" ).append("\n"); 
		query.append(", '' SLS_STS" ).append("\n"); 
		query.append(", '' USER_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}