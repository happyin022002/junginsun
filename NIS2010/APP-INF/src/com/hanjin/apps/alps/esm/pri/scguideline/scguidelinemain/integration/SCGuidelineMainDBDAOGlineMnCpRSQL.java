/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGuidelineMainDBDAOGlineMnCpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.06.23 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGuidelineMainDBDAOGlineMnCpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Main Copy
	  * </pre>
	  */
	public SCGuidelineMainDBDAOGlineMnCpRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT '' AS SVC_SCP_CD" ).append("\n"); 
		query.append(", '' AS GLINE_SEQ" ).append("\n"); 
		query.append(", '' AS LOC_GRP" ).append("\n"); 
		query.append(", '' AS CMDT_GRP" ).append("\n"); 
		query.append(", '' AS ORG_ARB" ).append("\n"); 
		query.append(", '' AS DEST_ARB" ).append("\n"); 
		query.append(", '' AS RATE" ).append("\n"); 
		query.append(", '' AS GOH" ).append("\n"); 
		query.append(", '' AS TRGT_SVC_SCP_CD" ).append("\n"); 
		query.append(", '' AS TRGT_GLINE_SEQ" ).append("\n"); 
		query.append(", '' AS TRGT_EFF_DT" ).append("\n"); 
		query.append(", '' AS TRGT_EXP_DT" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.integration").append("\n"); 
		query.append("FileName : SCGuidelineMainDBDAOGlineMnCpRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}