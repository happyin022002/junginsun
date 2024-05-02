/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCGInternalFinderDBDAOSearchImdgAmdtMstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGInternalFinderDBDAOSearchImdgAmdtMstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public SCGInternalFinderDBDAOSearchImdgAmdtMstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration").append("\n"); 
		query.append("FileName : SCGInternalFinderDBDAOSearchImdgAmdtMstListRSQL").append("\n"); 
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
		query.append("SELECT IMDG_AMDT_NO ," ).append("\n"); 
		query.append("       IMDG_AMDT_STND_FLG ," ).append("\n"); 
		query.append("       EFF_FM_DT ," ).append("\n"); 
		query.append("       EFF_TO_DT ," ).append("\n"); 
		query.append("       IMDG_AMDT_DESC ," ).append("\n"); 
		query.append("       ACT_FLG ," ).append("\n"); 
		query.append("       CRE_USR_ID ," ).append("\n"); 
		query.append("       CRE_DT ," ).append("\n"); 
		query.append("       UPD_USR_ID ," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("  FROM (SELECT IMDG_AMDT_NO ," ).append("\n"); 
		query.append("               IMDG_AMDT_STND_FLG ," ).append("\n"); 
		query.append("               EFF_FM_DT ," ).append("\n"); 
		query.append("               EFF_TO_DT ," ).append("\n"); 
		query.append("               IMDG_AMDT_DESC ," ).append("\n"); 
		query.append("               ACT_FLG ," ).append("\n"); 
		query.append("               CRE_USR_ID ," ).append("\n"); 
		query.append("               CRE_DT ," ).append("\n"); 
		query.append("               UPD_USR_ID ," ).append("\n"); 
		query.append("               UPD_DT" ).append("\n"); 
		query.append("          FROM SCG_IMDG_AMDT_MST X" ).append("\n"); 
		query.append("         ORDER BY DECODE(X.IMDG_AMDT_STND_FLG, 'Y', '1', X.IMDG_AMDT_STND_FLG, 'N', '2', '9') ASC " ).append("\n"); 
		query.append("		) XX" ).append("\n"); 

	}
}