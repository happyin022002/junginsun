/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchTradeComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.04.01 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchTradeComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search trade code in EQR_CTRL_TRADE_LANE_V
	  * </pre>
	  */
	public CommonDBDAOSearchTradeComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchTradeComboListRSQL").append("\n"); 
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
		query.append("/* Search Trade code, CommonDBDAOSearchTradeComboListRSQL */" ).append("\n"); 
		query.append("SELECT DISTINCT V.TRD_CD" ).append("\n"); 
		query.append("      ,M.TRD_NM" ).append("\n"); 
		query.append("  FROM EQR_CTRL_TRADE_LANE_V V" ).append("\n"); 
		query.append("      ,MDM_TRADE M" ).append("\n"); 
		query.append(" WHERE V.TRD_CD = M.TRD_CD(+)" ).append("\n"); 
		query.append(" ORDER BY V.TRD_CD" ).append("\n"); 

	}
}