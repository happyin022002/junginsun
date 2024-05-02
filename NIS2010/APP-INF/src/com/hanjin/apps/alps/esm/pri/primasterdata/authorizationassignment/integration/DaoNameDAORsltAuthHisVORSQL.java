/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DaoNameDAORsltAuthHisVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAORsltAuthHisVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltAuthHisVO 생성용
	  * </pre>
	  */
	public DaoNameDAORsltAuthHisVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration").append("\n"); 
		query.append("FileName : DaoNameDAORsltAuthHisVORSQL").append("\n"); 
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
		query.append("  '' AUTH_APRO_HIS_SEQ" ).append("\n"); 
		query.append(", '' PRC_CTRT_TP_CD" ).append("\n"); 
		query.append(", '' PRC_USR_AUTH_TP_CD" ).append("\n"); 
		query.append(", '' PRC_OFC_AUTH_TP_CD" ).append("\n"); 
		query.append(", '' AUTH_APRO_USR_ID" ).append("\n"); 
		query.append(", '' AUTH_APRO_USR_NM" ).append("\n"); 
		query.append(", '' AUTH_APRO_USR_OFC_CD" ).append("\n"); 
		query.append(", '' AUTH_APRO_OFC_CD" ).append("\n"); 
		query.append(", '' AUTH_APRO_OFC_NM" ).append("\n"); 
		query.append(", '' AUTH_APRO_DESC" ).append("\n"); 
		query.append(", '' AUTH_APRO_USE_FLG" ).append("\n"); 
		query.append(", '' PROG_USR_ID" ).append("\n"); 
		query.append(", '' PROG_USR_NM" ).append("\n"); 
		query.append(", '' PROG_OFC_CD" ).append("\n"); 
		query.append(", '' PROG_GDT" ).append("\n"); 
		query.append(", '' CRE_USR_ID" ).append("\n"); 
		query.append(", '' CRE_DT" ).append("\n"); 
		query.append(", '' UPD_USR_ID" ).append("\n"); 
		query.append(", '' UPD_DT" ).append("\n"); 
		query.append("FROM  PRI_AUTH_APRO_USR_HIS" ).append("\n"); 

	}
}