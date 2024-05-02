/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315PrefixIrgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2009.11.17 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315PrefixIrgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for Edi315PrefixIrgInfo
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315PrefixIrgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315PrefixIrgInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("''\"MODE\"," ).append("\n"); 
		query.append("''VENDOR," ).append("\n"); 
		query.append("''FROM_LOC," ).append("\n"); 
		query.append("''FROM_ARV_DT," ).append("\n"); 
		query.append("''FROM_ARV_DT_GMT," ).append("\n"); 
		query.append("''FROM_DPT_DT," ).append("\n"); 
		query.append("''FROM_DPT_DT_GMT," ).append("\n"); 
		query.append("''TO_LOC," ).append("\n"); 
		query.append("''TO_ARV_DT," ).append("\n"); 
		query.append("''TO_ARV_DT_GMT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}