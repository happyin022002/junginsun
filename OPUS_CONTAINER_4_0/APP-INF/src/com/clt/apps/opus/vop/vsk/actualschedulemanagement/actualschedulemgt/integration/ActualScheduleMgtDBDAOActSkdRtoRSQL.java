/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOActSkdRtoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOActSkdRtoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOActSkdRtoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOActSkdRtoRSQL").append("\n"); 
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
		query.append("		'' AS VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("		, '' AS SLS_OFC_CD" ).append("\n"); 
		query.append("		, '' AS VPS_PORT_CD" ).append("\n"); 
		query.append("		, '' AS FM_DT" ).append("\n"); 
		query.append("		, '' AS TO_DT" ).append("\n"); 
		query.append("		, '' AS VSL_SVC_TP_CD" ).append("\n"); 
		query.append("		, '0' AS OPT_HRS" ).append("\n"); 
		query.append("        , '' AS VSL_CD" ).append("\n"); 
		query.append(" 		, '' AS SKD_VOY_NO" ).append("\n"); 
		query.append("        , '' AS SKD_DIR_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}