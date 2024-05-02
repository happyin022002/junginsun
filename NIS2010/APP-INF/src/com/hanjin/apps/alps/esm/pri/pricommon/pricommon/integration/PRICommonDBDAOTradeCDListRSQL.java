/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRICommonDBDAOTradeCDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOTradeCDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade 별 Service Scope 가져오는 코드
	  * </pre>
	  */
	public PRICommonDBDAOTradeCDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration ").append("\n"); 
		query.append("FileName : PRICommonDBDAOTradeCDListRSQL").append("\n"); 
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
		query.append("SELECT TRD_CD AS CD" ).append("\n"); 
		query.append("	  ,WM_CONCAT(SVC_SCP_CD) AS NM" ).append("\n"); 
		query.append("	  ,'' AS ETC1" ).append("\n"); 
		query.append("      ,'' AS ETC2" ).append("\n"); 
		query.append("      ,'' AS ETC3" ).append("\n"); 
		query.append("      ,'' AS ETC4" ).append("\n"); 
		query.append("      ,'' AS ETC5" ).append("\n"); 
		query.append("FROM PRI_SCG_TRD_SVC_SCP_MAPG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("GROUP BY TRD_CD" ).append("\n"); 

	}
}