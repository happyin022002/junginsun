/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStatusList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.05.12 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLStatusList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLStatusList2RSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStatusList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("b_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStatusList2RSQL").append("\n"); 
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
		query.append("''''||BKG_JOIN_FNC( cursor(SELECT OFC_CD FROM   BKG_OFC_LVL_V" ).append("\n"); 
		query.append("           WHERE @[b_ofc_cd] IN (OFC_CD ,OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD, OFC_N5TH_LVL_CD,OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD) )" ).append("\n"); 
		query.append("        ,''',''')||'''' AS B_OFC_CD_SUB" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}