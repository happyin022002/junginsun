/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOOverdayNDivParmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.11.04 최성환
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

public class DaoNameDAOOverdayNDivParmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OverdayNDivParm
	  * </pre>
	  */
	public DaoNameDAOOverdayNDivParmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOOverdayNDivParmRSQL").append("\n"); 
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
		query.append("'' svr_id" ).append("\n"); 
		query.append(",'' cntr_no" ).append("\n"); 
		query.append(",'' cnmv_cyc_no" ).append("\n"); 
		query.append(",'' dtt_code" ).append("\n"); 
		query.append(",'' loc_div" ).append("\n"); 
		query.append(",'' dcc_seq" ).append("\n"); 
		query.append(",'' dmdt_inv_no" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}