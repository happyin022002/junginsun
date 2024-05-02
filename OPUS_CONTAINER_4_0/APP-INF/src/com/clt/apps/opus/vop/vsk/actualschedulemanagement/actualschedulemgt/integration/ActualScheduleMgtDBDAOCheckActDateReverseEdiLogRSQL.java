/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOCheckActDateReverseEdiLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOCheckActDateReverseEdiLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Checking Actual Dates are reversed
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOCheckActDateReverseEdiLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOCheckActDateReverseEdiLogRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN TO_DATE(@[act_arr_dt], 'YYYYMMDDHH24MI') >= TO_DATE(@[act_brth_dt],'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("	   	 	 OR  TO_DATE(@[act_arr_dt], 'YYYYMMDDHH24MI')  >= TO_DATE(@[act_dep_dt],'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("			 OR  TO_DATE(@[act_brth_dt],'YYYYMMDDHH24MI')  >= TO_DATE(@[act_dep_dt],'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("             THEN 'N'" ).append("\n"); 
		query.append("             ELSE 'Y'" ).append("\n"); 
		query.append("        END AS REV_CHK_FLG " ).append("\n"); 
		query.append("FROM   DUAL " ).append("\n"); 

	}
}