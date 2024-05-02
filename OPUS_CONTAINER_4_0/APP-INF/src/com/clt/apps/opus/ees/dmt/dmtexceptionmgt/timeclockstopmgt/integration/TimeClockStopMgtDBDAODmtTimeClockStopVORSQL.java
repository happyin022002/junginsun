/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TimeClockStopMgtDBDAODmtTimeClockStopVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.23
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.11.23 김태균
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

public class TimeClockStopMgtDBDAODmtTimeClockStopVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Time Clok Stop Retrieve
	  * </pre>
	  */
	public TimeClockStopMgtDBDAODmtTimeClockStopVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clk_stop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration").append("\n"); 
		query.append("FileName : TimeClockStopMgtDBDAODmtTimeClockStopVORSQL").append("\n"); 
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
		query.append("SELECT clk_stop_no," ).append("\n"); 
		query.append("       DECODE (cxl_flg, 'N', 'Live', 'Y', 'Cancelled') AS cxl_flg," ).append("\n"); 
		query.append("       dmdt_trf_cd," ).append("\n"); 
		query.append("       (SELECT dmdt_trf_nm" ).append("\n"); 
		query.append("          FROM dmt_trf_tp" ).append("\n"); 
		query.append("         WHERE dmt_trf_tp.dmdt_trf_cd = dmt_tm_clk_stop.dmdt_trf_cd)" ).append("\n"); 
		query.append("                                                               AS dmdt_trf_nm," ).append("\n"); 
		query.append("       clk_stop_ofc_cd," ).append("\n"); 
		query.append("       (SELECT ofc_eng_nm" ).append("\n"); 
		query.append("          FROM mdm_organization" ).append("\n"); 
		query.append("         WHERE mdm_organization.ofc_cd = dmt_tm_clk_stop.clk_stop_ofc_cd)" ).append("\n"); 
		query.append("                                                           AS clk_stop_ofc_nm," ).append("\n"); 
		query.append("       TO_CHAR(clk_stop_fm_dt,'YYYY-MM-DD') AS clk_stop_fm_dt," ).append("\n"); 
		query.append("       TO_CHAR(clk_stop_to_dt,'YYYY-MM-DD') AS clk_stop_to_dt," ).append("\n"); 
		query.append("	   CEIL((TO_DATE (TO_CHAR (clk_stop_to_dt, 'rrrrmmdd'),'rrrrmmdd')+ .99999) -" ).append("\n"); 
		query.append("		(TO_DATE (TO_CHAR (clk_stop_fm_dt, 'rrrrmmdd'),'rrrrmmdd')+ .00001)) AS stop_days," ).append("\n"); 
		query.append("       clk_stop_rmk," ).append("\n"); 
		query.append("       cre_usr_id," ).append("\n"); 
		query.append("       TO_CHAR (cre_dt, 'yyyy-mm-dd') AS cre_dt," ).append("\n"); 
		query.append("       cre_ofc_cd," ).append("\n"); 
		query.append("       (SELECT usr_nm" ).append("\n"); 
		query.append("          FROM com_user" ).append("\n"); 
		query.append("         WHERE com_user.usr_id = dmt_tm_clk_stop.upd_usr_id) AS upd_usr_id," ).append("\n"); 
		query.append("       TO_CHAR (upd_dt, 'yyyy-mm-dd') AS upd_dt," ).append("\n"); 
		query.append("       upd_ofc_cd," ).append("\n"); 
		query.append("       all_yd_flg" ).append("\n"); 
		query.append("  FROM dmt_tm_clk_stop" ).append("\n"); 
		query.append(" WHERE clk_stop_no = @[clk_stop_no]" ).append("\n"); 

	}
}