/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOCondSearchInterfaceStatusVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.03 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOCondSearchInterfaceStatusVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Interface Status
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOCondSearchInterfaceStatusVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOCondSearchInterfaceStatusVORSQL").append("\n"); 
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
		query.append("SELECT  '' SLP_OFC_CD," ).append("\n"); 
		query.append("'' CONDITION," ).append("\n"); 
		query.append("'' SEARCH_CSR_NO," ).append("\n"); 
		query.append("'' FR_DURATION," ).append("\n"); 
		query.append("'' TO_DURATION" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}