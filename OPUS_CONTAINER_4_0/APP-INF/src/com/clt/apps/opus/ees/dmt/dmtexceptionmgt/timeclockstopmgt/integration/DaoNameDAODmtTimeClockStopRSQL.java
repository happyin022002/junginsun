/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODmtTimeClockStopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.10 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAODmtTimeClockStopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DmtTimeClockStopVO
	  * </pre>
	  */
	public DaoNameDAODmtTimeClockStopRSQL(){
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
		query.append("'' clk_stop_no" ).append("\n"); 
		query.append(",'' clk_stop_fm_dt" ).append("\n"); 
		query.append(",'' upd_usr_id" ).append("\n"); 
		query.append(",'' clk_stop_to_dt" ).append("\n"); 
		query.append(",'' upd_dt" ).append("\n"); 
		query.append(",'' stop_days" ).append("\n"); 
		query.append(",'' dmdt_trf_cd" ).append("\n"); 
		query.append(",'' cxl_flg" ).append("\n"); 
		query.append(",'' cre_dt" ).append("\n"); 
		query.append(",'' upd_ofc_cd" ).append("\n"); 
		query.append(",'' cre_usr_id" ).append("\n"); 
		query.append(",'' clk_stop_rmk" ).append("\n"); 
		query.append(",'' clk_stop_ofc_cd" ).append("\n"); 
		query.append(",'' cre_ofc_cd" ).append("\n"); 
		query.append(",'' seq" ).append("\n"); 
		query.append(",'' dmdt_trf_nm" ).append("\n"); 
		query.append(",'' clk_stop_ofc_nm" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ").append("\n"); 
		query.append("FileName : DaoNameDAODmtTimeClockStopRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}