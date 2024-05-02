/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchDwellNotifyLMTDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.08
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.01.08 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchDwellNotifyLMTDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dwell Notification에서 조회조건을 LMT로 사용하게 되므로, 해당 요건을 만족하기 위해 시스템 일자에 대한 NYC일자를 조회한다.
	  * 
	  * * History
	  * 2013.01.08 선조치  이혜민 [ESD-SCE] 미주 Dwell Notification Batch시간 조정에 따른 화면 수정
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchDwellNotifyLMTDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchDwellNotifyLMTDateRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'USNYC') , 'YYYYMMDD') DFLT_EML_SND_DT" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'USNYC')  -1, 'YYYYMM') || '01' DFLT_FM_SND_DT" ).append("\n"); 
		query.append(", TO_CHAR(LAST_DAY(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'USNYC') -1), 'YYYYMMDD')  DFLT_TO_SND_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}