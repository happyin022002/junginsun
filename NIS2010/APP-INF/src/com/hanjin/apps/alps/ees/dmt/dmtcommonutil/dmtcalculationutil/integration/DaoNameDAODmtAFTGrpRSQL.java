/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODmtAFTGrpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.22 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAODmtAFTGrpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DmtAFTGrp
	  * </pre>
	  */
	public DaoNameDAODmtAFTGrpRSQL(){
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
		query.append("'' appr_no" ).append("\n"); 
		query.append(",'' dar_no" ).append("\n"); 
		query.append(",'' adj_seq" ).append("\n"); 
		query.append(",'' ftime_mk" ).append("\n"); 
		query.append(",'' add_day" ).append("\n"); 
		query.append(",'' ttl_day" ).append("\n"); 
		query.append(",'' excl_sat" ).append("\n"); 
		query.append(",'' excl_sun" ).append("\n"); 
		query.append(",'' excl_holi" ).append("\n"); 
		query.append(",'' dc_mk" ).append("\n"); 
		query.append(",'' cur_cd" ).append("\n"); 
		query.append(",'' dc_amt" ).append("\n"); 
		query.append(",'' dc_rate" ).append("\n"); 
		query.append(",'' msg_cd" ).append("\n"); 
		query.append(",'' msg_desc" ).append("\n"); 
		query.append("from dual" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAODmtAFTGrpRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}