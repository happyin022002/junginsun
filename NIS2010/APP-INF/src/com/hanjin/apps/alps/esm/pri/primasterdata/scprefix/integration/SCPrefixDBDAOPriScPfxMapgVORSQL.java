/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCPrefixDBDAOPriScPfxMapgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.06.01 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCPrefixDBDAOPriScPfxMapgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public SCPrefixDBDAOPriScPfxMapgVORSQL(){
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
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append(",B.SVC_SCP_NM" ).append("\n"); 
		query.append(",A.SCONTI_CD" ).append("\n"); 
		query.append(",C.SCONTI_NM" ).append("\n"); 
		query.append(",A.SC_PFX_CD" ).append("\n"); 
		query.append(",D.SC_PFX_DESC" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SC_PFX_MAPG A" ).append("\n"); 
		query.append(",MDM_SVC_SCP B" ).append("\n"); 
		query.append(",MDM_SUBCONTINENT C" ).append("\n"); 
		query.append(",PRI_SC_PFX D" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   A.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("AND   A.SC_PFX_CD = D.SC_PFX_CD" ).append("\n"); 
		query.append("ORDER BY A.SVC_SCP_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.integration").append("\n"); 
		query.append("FileName : SCPrefixDBDAOPriScPfxMapgVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}