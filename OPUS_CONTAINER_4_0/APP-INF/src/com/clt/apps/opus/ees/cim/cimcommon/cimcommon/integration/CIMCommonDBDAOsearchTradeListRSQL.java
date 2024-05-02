/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CIMCommonDBDAOsearchTradeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.02.01 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOsearchTradeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTradeList combo
	  * </pre>
	  */
	public CIMCommonDBDAOsearchTradeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOsearchTradeListRSQL").append("\n"); 
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
		query.append("SELECT 	TRD_CD||'|'||TRD_NM" ).append("\n"); 
		query.append("  FROM 	MDM_TRADE" ).append("\n"); 
		query.append(" WHERE 	DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND 	VSL_TP_CD = 'C'          -- Container 선" ).append("\n"); 
		query.append("   AND 	FM_CONTI_CD IS NOT NULL  -- Common 제거" ).append("\n"); 
		query.append(" ORDER BY 1" ).append("\n"); 

	}
}