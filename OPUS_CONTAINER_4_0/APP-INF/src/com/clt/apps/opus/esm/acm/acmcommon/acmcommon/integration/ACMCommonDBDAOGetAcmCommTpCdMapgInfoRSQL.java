/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ACMCommonDBDAOGetAcmCommTpCdMapgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCommonDBDAOGetAcmCommTpCdMapgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ACMCommonDBDAOGetAcmCommTpCdMapgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration").append("\n"); 
		query.append("FileName : ACMCommonDBDAOGetAcmCommTpCdMapgInfoRSQL").append("\n"); 
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
		query.append("SELECT COMM_STND_COST_CD AS VALUE0" ).append("\n"); 
		query.append("     , DECODE( COMM_STND_COST_CD, 512691, 'Other Commission', 512692, 'Dem/Det Collection', 512693, 'Vessel Operation', 512694, 'Cost Markup',512695,'DOC SERVICE FEE') AS VALUE1" ).append("\n"); 
		query.append("FROM ACM_COMM_TP_CD_MAPG" ).append("\n"); 
		query.append("WHERE AC_TP_CD = 'T'" ).append("\n"); 

	}
}