/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalUStimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrusarail.cntrforecastprecisionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * - CHM-201537079, 2015-08-10, 신용찬, 표준코드 변환
	  * </pre>
	  */
	public CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalUStimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrusarail.cntrforecastprecisionmanage.integration").append("\n"); 
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
		query.append("SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('LGBSC') ,'YYYY-MM-DD') CURRENT_TIME -- LGBBB -->LGBSC" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}