/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchDateSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.04
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.04 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchDateSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchDateSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchDateSeqRSQL").append("\n"); 
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
		query.append("--SELECT TO_CHAR(NEW_TIME(SYS_EXTRACT_UTC(CURRENT_TIMESTAMP),	'GMT', 'EST'), 'YYMMD') ||LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.nextval,'0000009'),' ') " ).append("\n"); 
		query.append("SELECT TO_CHAR(NEW_TIME(SYS_EXTRACT_UTC(CURRENT_TIMESTAMP), 'GMT', 'EST'), 'YYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}