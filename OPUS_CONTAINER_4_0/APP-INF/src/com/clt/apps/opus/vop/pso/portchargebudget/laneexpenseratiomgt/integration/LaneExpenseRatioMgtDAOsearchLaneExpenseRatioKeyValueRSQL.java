/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneExpenseRatioMgtDAOsearchLaneExpenseRatioKeyValueRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.28 박명종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author myoungjong park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneExpenseRatioMgtDAOsearchLaneExpenseRatioKeyValueRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_PORT_EXPN_DIV 테이블 기준으로 등록된 Service Lane List를 표시한다.
	  * </pre>
	  */
	public LaneExpenseRatioMgtDAOsearchLaneExpenseRatioKeyValueRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT  T2.VSL_SLAN_CD, T2.PF_SVC_TP_CD, T3.PNDLM_FLG" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  DISTINCT SLAN_CD" ).append("\n"); 
		query.append("FROM    PSO_PORT_EXPN_DIV" ).append("\n"); 
		query.append(") T1," ).append("\n"); 
		query.append("VSK_PF_SKD T2, MDM_VSL_SVC_LANE T3" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     T1.SLAN_CD          = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     T2.VSL_SLAN_CD      = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     T2.SLAN_STND_FLG    = 'Y'" ).append("\n"); 
		query.append("AND     T3.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("ORDER BY VSL_SLAN_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.integration").append("\n"); 
		query.append("FileName : LaneExpenseRatioMgtDAOsearchLaneExpenseRatioKeyValueRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}