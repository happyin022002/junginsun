/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOCalculationParmVORSQL.java
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

public class DaoNameDAOCalculationParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public DaoNameDAOCalculationParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOCalculationParmVORSQL").append("\n"); 
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
		query.append(",'' dmdt_trf_cd" ).append("\n"); 
		query.append(",'' trf_seq" ).append("\n"); 
		query.append(",'' trf_grp_seq" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' prop_no" ).append("\n"); 
		query.append(",'' sc_ver_seq" ).append("\n"); 
		query.append(",'' grp_seq" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' dar_no" ).append("\n"); 
		query.append(",'' mapg_seq" ).append("\n"); 
		query.append(",'' ver_seq" ).append("\n"); 
		query.append(",'' dtl_seq" ).append("\n"); 
		query.append(",'' cmb_seq" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' cntrts" ).append("\n"); 
		query.append(",'' over_day" ).append("\n"); 
		query.append(",'' div_over_day" ).append("\n"); 
		query.append(",'' dc_appl_rate" ).append("\n"); 
		query.append(",'' cur_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}