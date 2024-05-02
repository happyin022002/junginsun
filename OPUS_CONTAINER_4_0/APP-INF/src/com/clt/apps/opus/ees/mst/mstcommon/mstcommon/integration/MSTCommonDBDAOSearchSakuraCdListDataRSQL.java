/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MSTCommonDBDAOSearchSakuraCdListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MSTCommonDBDAOSearchSakuraCdListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sakura List
	  * </pre>
	  */
	public MSTCommonDBDAOSearchSakuraCdListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration ").append("\n"); 
		query.append("FileName : MSTCommonDBDAOSearchSakuraCdListDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	MODI_ACCT_CD SAKRA_ACCT_CD" ).append("\n"); 
		query.append("	, ACCT_CD OPUS_ACCT_CD" ).append("\n"); 
		query.append("	, ACCT_ENG_NM ACCT_NM" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	MDM_ACCOUNT MA" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	MODI_ACCT_CD IS NOT NULL" ).append("\n"); 
		query.append("	AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                  FROM LSE_RNTL_COST_ACCT_ORD ACT" ).append("\n"); 
		query.append("                  WHERE MA.ACCT_CD = ACT.ACCT_CD)" ).append("\n"); 
		query.append("ORDER BY 1, 2, 3" ).append("\n"); 

	}
}