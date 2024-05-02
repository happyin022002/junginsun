/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsCustomsTransmissionDBDAOsearchMsgDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.06 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsCustomsTransmissionDBDAOsearchMsgDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS (ROTTERDAM) 세관 Manifest 신고용 msgDt 를 조회한다.
	  * </pre>
	  */
	public RocsCustomsTransmissionDBDAOsearchMsgDtRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT TO_CHAR(SYSDATE,'yyyymmddhh24miss')   msg_dt" ).append("\n"); 
		query.append("FROM 	 DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration").append("\n"); 
		query.append("FileName : RocsCustomsTransmissionDBDAOsearchMsgDtRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}