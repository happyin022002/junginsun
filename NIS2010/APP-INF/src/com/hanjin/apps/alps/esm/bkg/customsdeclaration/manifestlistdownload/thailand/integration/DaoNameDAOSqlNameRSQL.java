/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DaoNameDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.02 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOSqlNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 111
	  * </pre>
	  */
	public DaoNameDAOSqlNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.integration").append("\n"); 
		query.append("FileName : DaoNameDAOSqlNameRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("'' BKG_NO," ).append("\n"); 
		query.append("'' CNTR_NO," ).append("\n"); 
		query.append("'' CNTR_TPSZ_CD," ).append("\n"); 
		query.append("'' TP_CD," ).append("\n"); 
		query.append("'' CNTR_TPSZ_RMK," ).append("\n"); 
		query.append("'' CONSIGNEE," ).append("\n"); 
		query.append("'' CNTR_WGT," ).append("\n"); 
		query.append("'' WGT_UT_CD," ).append("\n"); 
		query.append("'' STATUS," ).append("\n"); 
		query.append("'' POL_CD," ).append("\n"); 
		query.append("'' POSITON," ).append("\n"); 
		query.append("'' CDO_TEMP," ).append("\n"); 
		query.append("'' IMDG_CLSS_CD," ).append("\n"); 
		query.append("'' IMDG_UN_NO," ).append("\n"); 
		query.append("'' CNTR_TPSZ_CD," ).append("\n"); 
		query.append("'' RC_FLG," ).append("\n"); 
		query.append("'' DCGO_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}