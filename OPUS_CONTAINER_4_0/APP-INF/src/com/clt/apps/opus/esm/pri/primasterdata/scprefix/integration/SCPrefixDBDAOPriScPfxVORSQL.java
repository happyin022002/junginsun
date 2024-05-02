/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCPrefixDBDAOPriScPfxVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.scprefix.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCPrefixDBDAOPriScPfxVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public SCPrefixDBDAOPriScPfxVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.scprefix.integration").append("\n"); 
		query.append("FileName : SCPrefixDBDAOPriScPfxVORSQL").append("\n"); 
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
		query.append("SELECT SC_PFX_CD" ).append("\n"); 
		query.append("     , SC_PFX_DESC" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SC_PFX" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND SC_PFX_CD NOT IN (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                          FROM PRI_PARA_CD_DTL" ).append("\n"); 
		query.append("                         WHERE HRD_CDG_ID = 'PRICD0003')" ).append("\n"); 
		query.append("ORDER BY SC_PFX_CD" ).append("\n"); 

	}
}