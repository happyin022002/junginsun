/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualEmailSettingDBDAOSendTestAccrualEmailSettingRSQL.java
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.18
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.18 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualEmailSettingDBDAOSendTestAccrualEmailSettingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccrualEmailSettingDBDAOSendTestAccrualEmailSettingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration").append("\n"); 
		query.append("FileName : AccrualEmailSettingDBDAOSendTestAccrualEmailSettingRSQL").append("\n"); 
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
		
	}
}