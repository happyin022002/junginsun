/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualEmailSettingDBDAOSearchAccrualEmailSettingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.21
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.21 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualEmailSettingDBDAOSearchAccrualEmailSettingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    Email Setting 정보 조회
	  * </pre>
	  */
	public AccrualEmailSettingDBDAOSearchAccrualEmailSettingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration").append("\n"); 
		query.append("FileName : AccrualEmailSettingDBDAOSearchAccrualEmailSettingRSQL").append("\n"); 
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
		query.append("SELECT PGM_SUB_SYS_CD" ).append("\n"); 
		query.append(",EML_SVR_IP" ).append("\n"); 
		query.append(",PORT_NO" ).append("\n"); 
		query.append(",BAT_FM_EML" ).append("\n"); 
		query.append(",BAT_TO_EML" ).append("\n"); 
		query.append(",BAT_CC_EML" ).append("\n"); 
		query.append(",BAT_SUBJ_NM" ).append("\n"); 
		query.append(",BAT_CTNT" ).append("\n"); 
		query.append(",BAT_SND_FLG" ).append("\n"); 
		query.append(",IF_FM_EML" ).append("\n"); 
		query.append(",IF_TO_EML" ).append("\n"); 
		query.append(",IF_CC_EML" ).append("\n"); 
		query.append(",IF_SUBJ_NM" ).append("\n"); 
		query.append(",IF_CTNT" ).append("\n"); 
		query.append(",IF_SND_FLG" ).append("\n"); 
		query.append("FROM LEA_EML_SET" ).append("\n"); 
		query.append("WHERE PGM_SUB_SYS_CD = 'LEA'" ).append("\n"); 

	}
}