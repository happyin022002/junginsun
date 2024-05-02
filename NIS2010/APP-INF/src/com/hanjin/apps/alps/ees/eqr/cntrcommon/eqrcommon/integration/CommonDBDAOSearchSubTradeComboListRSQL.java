/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonDBDAOSearchSubTradeComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSubTradeComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SUB TRADE
	  * </pre>
	  */
	public CommonDBDAOSearchSubTradeComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSubTradeComboListRSQL").append("\n"); 
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
		query.append("/* Search Sub Trade List, CommonDBDAOSearchTradeComboListRSQL  */" ).append("\n"); 
		query.append("SELECT DISTINCT V.TRD_CD" ).append("\n"); 
		query.append(",V.SUB_TRD_CD" ).append("\n"); 
		query.append(",V.SUB_TRD_NM" ).append("\n"); 
		query.append(",V.TRD_CD||V.SUB_TRD_CD VAL_CD" ).append("\n"); 
		query.append("FROM EQR_CTRL_TRADE_LANE_V V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${trdCd} != '')" ).append("\n"); 
		query.append("AND V.TRD_CD IN ($trdCd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${subTrdCd} != '')" ).append("\n"); 
		query.append("AND V.SUB_TRD_CD   IN (${subtrdcd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY V.TRD_CD" ).append("\n"); 
		query.append(",V.SUB_TRD_CD" ).append("\n"); 

	}
}