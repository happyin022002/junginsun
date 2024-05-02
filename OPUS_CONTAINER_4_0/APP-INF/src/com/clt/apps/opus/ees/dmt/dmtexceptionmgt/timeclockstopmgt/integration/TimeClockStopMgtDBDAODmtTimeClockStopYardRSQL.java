/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TimeClockStopMgtDBDAODmtTimeClockStopYardRSQL.java
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

public class TimeClockStopMgtDBDAODmtTimeClockStopYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Time Clock Stop Yard select
	  * </pre>
	  */
	public TimeClockStopMgtDBDAODmtTimeClockStopYardRSQL(){
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
		query.append("FileName : TimeClockStopMgtDBDAODmtTimeClockStopYardRSQL").append("\n"); 
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
		query.append("SELECT A.YD_CD, B.YD_NM" ).append("\n"); 
		query.append("FROM DMT_TM_CLK_STOP_YD A, MDM_YARD B" ).append("\n"); 
		query.append("WHERE A.CLK_STOP_NO = @[clk_stop_no]" ).append("\n"); 
		query.append("AND A.YD_CD = B.YD_CD" ).append("\n"); 

	}
}