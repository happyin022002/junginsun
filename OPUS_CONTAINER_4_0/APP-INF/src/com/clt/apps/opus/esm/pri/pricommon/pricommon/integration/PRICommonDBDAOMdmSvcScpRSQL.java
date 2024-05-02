/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PRICommonDBDAOMdmSvcScpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.25 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-Sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOMdmSvcScpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_SVC_SCP 테의블의 SVC_SCP_CD와 SVC_SCP_NM을 가져오는 query (ESM_PRI_5001)
	  * </pre>
	  */
	public PRICommonDBDAOMdmSvcScpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOMdmSvcScpRSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD AS CD" ).append("\n"); 
		query.append("     , SVC_SCP_NM AS NM" ).append("\n"); 
		query.append("  FROM MDM_SVC_SCP" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY SVC_SCP_CD" ).append("\n"); 

	}
}