/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityDBDAOCmdtParaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.21 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.commodity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityDBDAOCmdtParaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * commodity parameter 생성
	  * </pre>
	  */
	public CommodityDBDAOCmdtParaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.commodity.integration").append("\n"); 
		query.append("FileName : CommodityDBDAOCmdtParaRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS GRP_CD," ).append("\n"); 
		query.append("'' AS SVC_SCP_CD," ).append("\n"); 
		query.append("'' AS CHG_CD," ).append("\n"); 
		query.append("'' AS GLINE_SEQ," ).append("\n"); 
		query.append("'' AS PRC_CUST_TP_CD," ).append("\n"); 
		query.append("'' AS PROP_NO," ).append("\n"); 
		query.append("'' AS AMDT_SEQ," ).append("\n"); 
		query.append("'' AS GRP_CMDT_SEQ," ).append("\n"); 
		query.append("'' AS CMDT_CD," ).append("\n"); 
		query.append("'' AS CMDT_NM," ).append("\n"); 
		query.append("'' AS REP_CMDT_CD," ).append("\n"); 
		query.append("'' AS REP_CMDT_NM," ).append("\n"); 
		query.append("'' AS CRE_OFC_CD," ).append("\n"); 
		query.append("'' AS QTTN_NO," ).append("\n"); 
		query.append("'' AS QTTN_VER_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}