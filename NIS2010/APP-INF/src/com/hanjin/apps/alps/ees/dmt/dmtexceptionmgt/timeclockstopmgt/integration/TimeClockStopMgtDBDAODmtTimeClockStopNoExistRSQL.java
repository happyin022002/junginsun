/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeClockStopMgtDBDAODmtTimeClockStopNoExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.17 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TimeClockStopMgtDBDAODmtTimeClockStopNoExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DmtTimeClockStopNoExist
	  * </pre>
	  */
	public TimeClockStopMgtDBDAODmtTimeClockStopNoExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clk_stop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration").append("\n"); 
		query.append("FileName : TimeClockStopMgtDBDAODmtTimeClockStopNoExistRSQL").append("\n"); 
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
		query.append("SELECT 'A' AS exist" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM dmt_tm_clk_stop_no" ).append("\n"); 
		query.append("WHERE clk_stop_ofc_cd = @[clk_stop_ofc_cd]" ).append("\n"); 
		query.append("AND clk_stop_yrmon_no = TO_CHAR ( NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE), 'rrmm')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}