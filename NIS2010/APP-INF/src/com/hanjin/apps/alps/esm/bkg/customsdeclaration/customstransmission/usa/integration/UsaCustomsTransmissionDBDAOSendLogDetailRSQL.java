/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOSendLogDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.17 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOSendLogDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, SendLogDetailVO 생성용.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOSendLogDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOSendLogDetailRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' seq," ).append("\n"); 
		query.append("'' vvd," ).append("\n"); 
		query.append("'' pol," ).append("\n"); 
		query.append("'' pod," ).append("\n"); 
		query.append("'' del," ).append("\n"); 
		query.append("'' pos," ).append("\n"); 
		query.append("'' cntr_no," ).append("\n"); 
		query.append("'' lastpol," ).append("\n"); 
		query.append("'' ofc_cd," ).append("\n"); 
		query.append("'' usr_id," ).append("\n"); 
		query.append("'' tmp1," ).append("\n"); 
		query.append("'' tmp2," ).append("\n"); 
		query.append("'' tmp3" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}