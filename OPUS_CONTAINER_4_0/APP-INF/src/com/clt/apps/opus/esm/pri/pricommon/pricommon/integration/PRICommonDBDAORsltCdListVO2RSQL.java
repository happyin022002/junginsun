/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAORsltCdListVO2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltCdListVO2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltCdListVO 생성을 위한 DUMMY SQL
	  * </pre>
	  */
	public PRICommonDBDAORsltCdListVO2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltCdListVO2RSQL").append("\n"); 
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
		query.append("SELECT  '' AS AMDT_SEQ," ).append("\n"); 
		query.append("	'' AS SVC_SCP_CD," ).append("\n"); 
		query.append("	'' AS GLINE_SEQ," ).append("\n"); 
		query.append("    '' AS PRC_CUST_TP_CD," ).append("\n"); 
		query.append("	'' AS ETC1," ).append("\n"); 
		query.append("	'' AS ETC3," ).append("\n"); 
		query.append("	'' AS ETC2," ).append("\n"); 
		query.append("	'' AS ETC4," ).append("\n"); 
		query.append("	'' AS ETC5," ).append("\n"); 
		query.append("	'' AS PROP_NO," ).append("\n"); 
		query.append("	'' AS CD," ).append("\n"); 
		query.append("	'' AS NM," ).append("\n"); 
		query.append("	'' AS CRE_OFC_CD," ).append("\n"); 
		query.append("	'' AS QTTN_NO," ).append("\n"); 
		query.append("	'' AS QTTN_VER_NO" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}