/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManagementDBDAOSearchAddressListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.23
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.05.23 박찬민
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

public class CustomerInfoManagementDBDAOSearchAddressListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAddressListVO
	  * </pre>
	  */
	public CustomerInfoManagementDBDAOSearchAddressListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration ").append("\n"); 
		query.append("FileName : CustomerInfoManagementDBDAOSearchAddressListVORSQL").append("\n"); 
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
		query.append("SELECT '' ADDR_SEQ" ).append("\n"); 
		query.append(", '' PRMRY_CHK_FLG" ).append("\n"); 
		query.append(", '' ADDR_TP_CD" ).append("\n"); 
		query.append(", '' DEL_FLG" ).append("\n"); 
		query.append(", '' BZET_ADDR" ).append("\n"); 
		query.append(", '' CT_CD" ).append("\n"); 
		query.append(", '' STE_CD" ).append("\n"); 
		query.append(", '' CTY_NM" ).append("\n"); 
		query.append(", '' ZIP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}