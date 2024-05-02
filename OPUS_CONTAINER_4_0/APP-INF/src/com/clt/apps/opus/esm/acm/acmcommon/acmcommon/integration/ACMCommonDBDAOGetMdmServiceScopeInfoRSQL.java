/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAOGetMdmServiceScopeInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.23
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2012.03.23 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCommonDBDAOGetMdmServiceScopeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * GetMdmServiceScopeInfo
	  * </pre>
	  */
	public ACMCommonDBDAOGetMdmServiceScopeInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration").append("\n");
		query.append("FileName : ACMCommonDBDAOGetMdmServiceScopeInfoRSQL").append("\n");
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
		query.append("    SVC_SCP_CD AS VALUE0," ).append("\n");
		query.append("    SVC_SCP_NM AS VALUE1," ).append("\n");
		query.append("    (SVC_SCP_CD || '\\t' || SVC_SCP_NM) AS VALUE2    " ).append("\n");
		query.append("FROM MDM_SVC_SCP" ).append("\n");
		query.append("WHERE NVL(DELT_FLG, 'N') = 'N'" ).append("\n");
		query.append("ORDER BY SVC_SCP_CD" ).append("\n");

	}
}