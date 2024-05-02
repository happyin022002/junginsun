/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOLocationByBoundVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.27 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class DaoNameDAOLocationByBoundVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public DaoNameDAOLocationByBoundVORSQL(){
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
		query.append("select" ).append("\n"); 
		query.append("'' bkg_cnt_cd" ).append("\n"); 
		query.append(",'' bkg_rgn_cd" ).append("\n"); 
		query.append(",'' bkg_state_cd" ).append("\n"); 
		query.append(",'' bkg_loc_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ").append("\n"); 
		query.append("FileName : DaoNameDAOLocationByBoundVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}