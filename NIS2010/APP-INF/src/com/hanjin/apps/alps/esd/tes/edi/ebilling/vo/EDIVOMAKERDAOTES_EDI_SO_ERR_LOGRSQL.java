/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EDIVOMAKERDAOTES_EDI_SO_ERR_LOGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EDIVOMAKERDAOTES_EDI_SO_ERR_LOGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES_EDI_SO_ERR_LOG
	  * </pre>
	  */
	public EDIVOMAKERDAOTES_EDI_SO_ERR_LOGRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.vo").append("\n"); 
		query.append("FileName : EDIVOMAKERDAOTES_EDI_SO_ERR_LOGRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("EDI_SO_ERR_LOG_SEQ" ).append("\n"); 
		query.append(", EDI_MSG" ).append("\n"); 
		query.append(", ERR_LOG_RMK" ).append("\n"); 
		query.append(", TML_INV_EDI_SEQ" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append("FROM TES_EDI_SO_ERR_LOG" ).append("\n"); 

	}
}