/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOSearchCarrierRegisterHeaderListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.02 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchCarrierRegisterHeaderListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCarrierRegisterHeaderList SELECT
	  * </pre>
	  */
	public BSAManageDBDAOSearchCarrierRegisterHeaderListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchCarrierRegisterHeaderListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("A.CRR_CD," ).append("\n"); 
		query.append("B.CRR_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BSA_CRR_RGST A," ).append("\n"); 
		query.append("MDM_CARRIER  B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CRR_CD= B.CRR_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("CRR_CD" ).append("\n"); 

	}
}