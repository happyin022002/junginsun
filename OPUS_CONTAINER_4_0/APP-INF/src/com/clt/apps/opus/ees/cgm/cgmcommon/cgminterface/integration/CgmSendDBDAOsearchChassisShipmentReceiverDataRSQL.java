/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CgmSendDBDAOsearchChassisShipmentReceiverDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmSendDBDAOsearchChassisShipmentReceiverDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CgmSendDBDAOsearchChassisShipmentReceiverDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.integration").append("\n"); 
		query.append("FileName : CgmSendDBDAOsearchChassisShipmentReceiverDataRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT EDI_ID AS FW_CD, CHSS_POOL_CD AS FW_NM" ).append("\n"); 
		query.append("  FROM CGM_POOL_CHSS_LOC" ).append("\n"); 
		query.append(" ORDER BY 1,2" ).append("\n"); 

	}
}