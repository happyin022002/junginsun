/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalUStimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.04.15 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalUStimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미주지역의 시간을 가져오기 (LGBBB) 
	  * LGBBB로 하드 코딩이 되어 있음(2010.04.15 : 남연호 과장 요청으로 추가)
	  * </pre>
	  */
	public CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalUStimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.integration").append("\n"); 
		query.append("FileName : CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalUStimeRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('LGBBB') ,'YYYY-MM-DD') CURRENT_TIME" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}