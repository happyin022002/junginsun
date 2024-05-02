/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WebGateDBDAOCheckDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.11
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2009.10.11 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.newwebgate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WebGateDBDAOCheckDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Date를 체크한다.
	  * </pre>
	  */
	public WebGateDBDAOCheckDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.servicesio.newwebgate.integration").append("\n"); 
		query.append("FileName : WebGateDBDAOCheckDateRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN SYSDATE+0.125 < TO_DATE(@[act_dt], 'YYYYMMDDHH24MI') THEN 1" ).append("\n"); 
		query.append("WHEN SYSDATE-7 > TO_DATE(@[act_dt], 'YYYYMMDDHH24MI') THEN -1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END STS_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}