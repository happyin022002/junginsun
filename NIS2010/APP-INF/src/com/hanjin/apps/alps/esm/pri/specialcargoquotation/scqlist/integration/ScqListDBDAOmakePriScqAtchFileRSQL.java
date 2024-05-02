/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqListDBDAOmakePriScqAtchFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.08
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.04.08 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqListDBDAOmakePriScqAtchFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * makePriScqAtchFile
	  * </pre>
	  */
	public ScqListDBDAOmakePriScqAtchFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration").append("\n"); 
		query.append("FileName : ScqListDBDAOmakePriScqAtchFileRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append(" '' SCQ_RQST_NO" ).append("\n"); 
		query.append(",'' SPCL_CGO_TP_CD" ).append("\n"); 
		query.append(",'' FILE_SAV_ID" ).append("\n"); 
		query.append(",'' ORG_FILE_NM" ).append("\n"); 
		query.append(",'' SAV_FILE_NM" ).append("\n"); 
		query.append(",'' SAV_PATH_NM" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' FILE_SIZE" ).append("\n"); 
		query.append(",'' PRE_SCQ_RQST_NO" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}