/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchSLaneComboListRSQL.java
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

public class CommonDBDAOSearchSLaneComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search lane code from EQR_CTRL_TRADE_LANE_V VIEW
	  * </pre>
	  */
	public CommonDBDAOSearchSLaneComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSLaneComboListRSQL").append("\n"); 
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
		query.append("/* Search Lane List, CommonDBDAOSearchSLaneComboListRSQL  */" ).append("\n"); 
		query.append("SELECT DISTINCT V.TRD_CD" ).append("\n"); 
		query.append("      ,V.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,V.VSL_SLAN_CD LANE_CD" ).append("\n"); 
		query.append("      ,V.VSL_SLAN_NM LANE_NM" ).append("\n"); 
		query.append("      ,V.TRD_CD||V.SUB_TRD_CD||V.VSL_SLAN_CD VAL_CD" ).append("\n"); 
		query.append("  FROM EQR_CTRL_TRADE_LANE_V V" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${locSubTrdCd} != '')" ).append("\n"); 
		query.append("   AND  (" ).append("\n"); 
		query.append("	#foreach($key IN ${arrSubTrdCd}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("			(V.TRD_CD = SUBSTR('$key',1,3) AND V.SUB_TRD_CD = SUBSTR('$key',4,2))" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			OR (V.TRD_CD = SUBSTR('$key',1,3) AND V.SUB_TRD_CD = SUBSTR('$key',4,2))" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY V.TRD_CD" ).append("\n"); 
		query.append("         ,V.SUB_TRD_CD" ).append("\n"); 
		query.append("         ,V.VSL_SLAN_CD" ).append("\n"); 

	}
}