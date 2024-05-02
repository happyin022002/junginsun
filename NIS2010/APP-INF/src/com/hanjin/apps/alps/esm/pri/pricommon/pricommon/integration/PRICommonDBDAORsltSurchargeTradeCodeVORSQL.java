/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRICommonDBDAORsltSurchargeTradeCodeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltSurchargeTradeCodeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltSurchargeTradeCodeVO 조회
	  * </pre>
	  */
	public PRICommonDBDAORsltSurchargeTradeCodeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltSurchargeTradeCodeVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT (SC.TRD_CD) AS CD" ).append("\n"); 
		query.append("     , MT.TRD_NM AS NM" ).append("\n"); 
		query.append("    FROM PRI_SCG_TRD_SVC_SCP_MAPG SC" ).append("\n"); 
		query.append("        ,MDM_TRADE MT" ).append("\n"); 
		query.append("    WHERE SC.TRD_CD = MT.TRD_CD" ).append("\n"); 

	}
}