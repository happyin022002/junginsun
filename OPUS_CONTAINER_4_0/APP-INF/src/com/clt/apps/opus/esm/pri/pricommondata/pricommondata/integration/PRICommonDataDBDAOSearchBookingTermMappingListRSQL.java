/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PRICommonDataDBDAOSearchBookingTermMappingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.23 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-Sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDataDBDAOSearchBookingTermMappingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Query for ESM_PRI_5001
	  * </pre>
	  */
	public PRICommonDataDBDAOSearchBookingTermMappingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration").append("\n"); 
		query.append("FileName : PRICommonDataDBDAOSearchBookingTermMappingListRSQL").append("\n"); 
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
		query.append("SELECT 	PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("		,REP_SVC_SCP_CD" ).append("\n"); 
		query.append("		,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		,BKG_RCV_DE_TERM_CD" ).append("\n"); 
		query.append("		,CTRT_RCV_DE_TERM_CD" ).append("\n"); 
		query.append("FROM PRI_RCV_DE_TERM_MAPG" ).append("\n"); 

	}
}