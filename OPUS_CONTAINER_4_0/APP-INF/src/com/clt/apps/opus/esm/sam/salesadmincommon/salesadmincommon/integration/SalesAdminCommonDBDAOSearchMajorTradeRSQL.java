/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesAdminCommonDBDAOSearchMajorTradeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.28
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.06.28 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesAdminCommonDBDAOSearchMajorTradeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Major Trade 조회용 쿼리
	  * </pre>
	  */
	public SalesAdminCommonDBDAOSearchMajorTradeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration ").append("\n"); 
		query.append("FileName : SalesAdminCommonDBDAOSearchMajorTradeRSQL").append("\n"); 
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
		query.append("SELECT TRD_CD CD" ).append("\n"); 
		query.append("     , TRD_NM CD_DESC" ).append("\n"); 
		query.append("FROM MDM_TRADE" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND FM_CONTI_CD IS NOT NULL" ).append("\n"); 
		query.append("  AND TO_CONTI_CD IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 

	}
}