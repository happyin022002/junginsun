/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RASCommonDBDAORsltCdListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.10.23 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RASCommonDBDAORsltCdListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltCdListVO
	  * </pre>
	  */
	public RASCommonDBDAORsltCdListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.integration ").append("\n"); 
		query.append("FileName : RASCommonDBDAORsltCdListVORSQL").append("\n"); 
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
		query.append(",SVC_SCP_NM AS NM" ).append("\n"); 
		query.append(",'' AS ETC1" ).append("\n"); 
		query.append(",'' AS ETC2" ).append("\n"); 
		query.append(",'' AS ETC3" ).append("\n"); 
		query.append(",'' AS ETC4" ).append("\n"); 
		query.append(",(SVC_SCP_CD || '|' || SVC_SCP_NM) AS ETC5" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY SVC_SCP_CD" ).append("\n"); 

	}
}