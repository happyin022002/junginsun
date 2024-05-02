/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HolidayMgtDBDAOSearchWeekendTypeByCountryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.01 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungHoon, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HolidayMgtDBDAOSearchWeekendTypeByCountryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Country 에 해당되는 주말 타입정보를 조회하는 쿼리
	  * </pre>
	  */
	public HolidayMgtDBDAOSearchWeekendTypeByCountryRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT 	WKND_TP_CD" ).append("\n"); 
		query.append("FROM	DMT_WEEKEND" ).append("\n"); 
		query.append("WHERE	CNT_CD = @[cnt_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration").append("\n"); 
		query.append("FileName : HolidayMgtDBDAOSearchWeekendTypeByCountryRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}