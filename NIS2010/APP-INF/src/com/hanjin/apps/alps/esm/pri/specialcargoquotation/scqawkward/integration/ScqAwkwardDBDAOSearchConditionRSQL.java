/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOSearchConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.04
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.03.04 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOSearchConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * test
	  * </pre>
	  */
	public ScqAwkwardDBDAOSearchConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration ").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOSearchConditionRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("''	pol_cont_cd" ).append("\n"); 
		query.append(",''	pol_cnty_cd" ).append("\n"); 
		query.append(",''	pol_port_cd" ).append("\n"); 
		query.append(",''	pod_cont_cd" ).append("\n"); 
		query.append(",''	pod_cnty_cd" ).append("\n"); 
		query.append(",''	pod_port_cd" ).append("\n"); 
		query.append(",''	tnk_lane_cd" ).append("\n"); 
		query.append(",''	ts_port_cd" ).append("\n"); 
		query.append(",''	ts_lane_cd" ).append("\n"); 
		query.append(",''	ts_type" ).append("\n"); 
		query.append(",''	stay_time" ).append("\n"); 
		query.append(",''	i_del_flag" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}