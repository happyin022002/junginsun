/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOLocationByBoundParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.23 최성환
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

public class DaoNameDAOLocationByBoundParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public DaoNameDAOLocationByBoundParmVORSQL(){
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
		query.append("'' io_bnd" ).append("\n"); 
		query.append(",'' pol_cnt_cd" ).append("\n"); 
		query.append(",'' pol_rgn_cd" ).append("\n"); 
		query.append(",'' pol_state_cd" ).append("\n"); 
		query.append(",'' pol_loc_cd" ).append("\n"); 
		query.append(",'' por_cnt_cd" ).append("\n"); 
		query.append(",'' por_rgn_cd" ).append("\n"); 
		query.append(",'' por_state_cd" ).append("\n"); 
		query.append(",'' por_loc_cd" ).append("\n"); 
		query.append(",'' del_cnt_cd" ).append("\n"); 
		query.append(",'' del_rgn_cd" ).append("\n"); 
		query.append(",'' del_state_cd" ).append("\n"); 
		query.append(",'' del_loc_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOLocationByBoundParmVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}