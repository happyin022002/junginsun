/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DaoNameDAOTimeClockStopParmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.11.22 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOTimeClockStopParmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TimeClockStopParmVO
	  * </pre>
	  */
	public DaoNameDAOTimeClockStopParmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration").append("\n"); 
		query.append("FileName : DaoNameDAOTimeClockStopParmRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("		'' fm_dt" ).append("\n"); 
		query.append("		,'' to_dt" ).append("\n"); 
		query.append("		,'' clk_stop_no" ).append("\n"); 
		query.append("		,'' dmdt_trf_cd" ).append("\n"); 
		query.append("		,'' office" ).append("\n"); 
		query.append("		,'' cxl_flg" ).append("\n"); 
		query.append("		,'' clk_stop_ofc_cd" ).append("\n"); 
		query.append("		,'' date_period" ).append("\n"); 
		query.append("		,'' clk_stop_yd_cd" ).append("\n"); 
		query.append("		from dual" ).append("\n"); 

	}
}