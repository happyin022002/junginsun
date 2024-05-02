/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCTradeSubTradeLaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.15 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCTradeSubTradeLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trade, sub trade, lane 콤보 리스트
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCTradeSubTradeLaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCTradeSubTradeLaneListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("DL.TRD_CD	  ," ).append("\n"); 
		query.append("(SELECT TRD_NM FROM MDM_TRADE WHERE TRD_CD = DL.TRD_CD) AS TRD_NM ," ).append("\n"); 
		query.append("DL.SUB_TRD_CD  ," ).append("\n"); 
		query.append("(SELECT SUB_TRD_NM FROM MDM_SUB_TRD WHERE SUB_TRD_CD = DL.SUB_TRD_CD) AS SUB_TRD_NM ," ).append("\n"); 
		query.append("SL.VSL_SLAN_CD ," ).append("\n"); 
		query.append("SL.VSL_SLAN_NM" ).append("\n"); 
		query.append("FROM   MDM_VSL_SVC_LANE	SL ," ).append("\n"); 
		query.append("MDM_REV_LANE		RL ," ).append("\n"); 
		query.append("MDM_DTL_REV_LANE	DL" ).append("\n"); 
		query.append("WHERE  RL.VSL_SLAN_CD = SL.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND	   DL.RLANE_CD	  = RL.RLANE_CD" ).append("\n"); 
		query.append("AND	   SL.VSL_TP_CD	  = 'C'" ).append("\n"); 
		query.append("AND	   SL.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND	   DL.DELT_FLG	  = 'N'" ).append("\n"); 
		query.append("ORDER BY DL.TRD_CD	   ," ).append("\n"); 
		query.append("DL.SUB_TRD_CD ," ).append("\n"); 
		query.append("SL.VSL_SLAN_CD" ).append("\n"); 

	}
}