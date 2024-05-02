/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StandardWordingDBDAOPriScStndWdgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.20 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.standardwording.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StandardWordingDBDAOPriScStndWdgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public StandardWordingDBDAOPriScStndWdgVORSQL(){
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
		query.append("SELECT" ).append("\n"); 
		query.append("STND_WDG_SEQ" ).append("\n"); 
		query.append(",	STND_WDG_CTNT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SC_STND_WDG" ).append("\n"); 
		query.append("ORDER BY STND_WDG_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.standardwording.integration").append("\n"); 
		query.append("FileName : StandardWordingDBDAOPriScStndWdgVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}