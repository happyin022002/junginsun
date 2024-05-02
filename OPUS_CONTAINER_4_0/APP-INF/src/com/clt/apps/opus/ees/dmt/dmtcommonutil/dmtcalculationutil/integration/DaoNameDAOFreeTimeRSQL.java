/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOFreeTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.15 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOFreeTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FreeTime
	  * </pre>
	  */
	public DaoNameDAOFreeTimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOFreeTimeRSQL").append("\n"); 
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
		query.append("'' ftime_cmnc" ).append("\n"); 
		query.append(",'' ftime_end" ).append("\n"); 
		query.append(",'' cstop_idx" ).append("\n"); 
		query.append(",'' cstop_no" ).append("\n"); 
		query.append(",'' msg_cd" ).append("\n"); 
		query.append(",'' msg_desc" ).append("\n"); 
		query.append(",'' week_of_day" ).append("\n"); 
		query.append(",'' rtn_ftime_cmnc" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}