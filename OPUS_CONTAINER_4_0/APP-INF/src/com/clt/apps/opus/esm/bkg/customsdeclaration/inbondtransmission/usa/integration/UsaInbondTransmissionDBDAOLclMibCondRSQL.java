/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOLclMibCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.20 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOLclMibCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim LclMibCondVO작성용
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOLclMibCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOLclMibCondRSQL").append("\n"); 
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
		query.append("SELECT '' VVD, '' POD, '' HUB, '' DEL, '' PMIB, '' BL_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}