/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSamCustHistVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.16 
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

public class CustomerInfoManageDBDAOSamCustHistVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SamCustHistVO
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSamCustHistVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSamCustHistVORSQL").append("\n"); 
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
		query.append("SELECT '' CUST_HIS_SEQ" ).append("\n"); 
		query.append("     , '' CNG_ITM_CD" ).append("\n"); 
		query.append("     , '' OLD_VAL_DESC" ).append("\n"); 
		query.append("     , '' NEW_VAL_DESC" ).append("\n"); 
		query.append("     , '' UPD_DT" ).append("\n"); 
		query.append("	 , '' USER_ID" ).append("\n"); 
		query.append("	 , '' A_OLD_VAL_DESC" ).append("\n"); 
		query.append("	 , '' A_NEW_VAL_DESC" ).append("\n"); 
		query.append("	 , '' A_CNG_ITM_CD" ).append("\n"); 
		query.append("	 , '' CUST_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}