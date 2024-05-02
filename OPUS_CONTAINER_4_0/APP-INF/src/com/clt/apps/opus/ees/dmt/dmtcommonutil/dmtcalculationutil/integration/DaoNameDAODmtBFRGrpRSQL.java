/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODmtBFRGrpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.17 최성환
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

public class DaoNameDAODmtBFRGrpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DmtBFRGrp
	  * </pre>
	  */
	public DaoNameDAODmtBFRGrpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAODmtBFRGrpRSQL").append("\n"); 
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
		query.append("'' appr_no" ).append("\n"); 
		query.append(",'' dar_no" ).append("\n"); 
		query.append(",'' mapg_seq" ).append("\n"); 
		query.append(",'' ver_seq" ).append("\n"); 
		query.append(",'' dtl_seq" ).append("\n"); 
		query.append(",'' cmb_seq" ).append("\n"); 
		query.append(",'' ftime_mk" ).append("\n"); 
		query.append(",'' add_day" ).append("\n"); 
		query.append(",'' ttl_day" ).append("\n"); 
		query.append(",'' excl_sat" ).append("\n"); 
		query.append(",'' excl_sun" ).append("\n"); 
		query.append(",'' excl_holi" ).append("\n"); 
		query.append(",'' rate_mk" ).append("\n"); 
		query.append(",'' cur_cd" ).append("\n"); 
		query.append(",'' msg_cd" ).append("\n"); 
		query.append(",'' msg_desc" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}