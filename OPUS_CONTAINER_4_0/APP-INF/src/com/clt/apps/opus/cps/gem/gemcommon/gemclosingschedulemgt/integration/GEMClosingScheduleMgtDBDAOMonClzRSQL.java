/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMClosingScheduleMgtDBDAOMonClzRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.07.24 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemclosingschedulemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMClosingScheduleMgtDBDAOMonClzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPS_GEM_0006 화며에서 사용하는 Grid용 VO
	  * </pre>
	  */
	public GEMClosingScheduleMgtDBDAOMonClzRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemcommon.gemclosingschedulemgt.integration ").append("\n"); 
		query.append("FileName : GEMClosingScheduleMgtDBDAOMonClzRSQL").append("\n"); 
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
		query.append("SELECT '' IN_CLZ_YRMON" ).append("\n"); 
		query.append(",'' IN_CLZ_DIV_CD" ).append("\n"); 
		query.append(",'' IN_CLZ_DT" ).append("\n"); 
		query.append(",'' IN_CLZ_FLG" ).append("\n"); 
		query.append(",'' IN_GL_IF_FLG" ).append("\n"); 
		query.append(",'' IN_CRE_USR_ID" ).append("\n"); 
		query.append(",'' IN_CRE_DT" ).append("\n"); 
		query.append(",'' IN_UPD_USR_ID" ).append("\n"); 
		query.append(",'' IN_UPD_DT" ).append("\n"); 
		query.append(",'' AT_CLZ_YRMON" ).append("\n"); 
		query.append(",'' AT_CLZ_DIV_CD" ).append("\n"); 
		query.append(",'' AT_CLZ_DT" ).append("\n"); 
		query.append(",'' AT_CLZ_FLG" ).append("\n"); 
		query.append(",'' AT_CRE_USR_ID" ).append("\n"); 
		query.append(",'' AT_CRE_DT" ).append("\n"); 
		query.append(",'' AT_UPD_USR_ID" ).append("\n"); 
		query.append(",'' AT_UPD_DT" ).append("\n"); 
		query.append(",'' GLIF_CLZ_YRMON" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}