/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CMSummaryDBDAOInPrsProposalSummarySimulationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.28 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMSummaryDBDAOInPrsProposalSummarySimulationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_PRI_6032 화면의 조회 조건을 저장하기 위한 VO를 만들기 위한 쿼리
	  * </pre>
	  */
	public CMSummaryDBDAOInPrsProposalSummarySimulationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration").append("\n"); 
		query.append("FileName : CMSummaryDBDAOInPrsProposalSummarySimulationVORSQL").append("\n"); 
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
		query.append("		'' AS APR_OFC_CD" ).append("\n"); 
		query.append("		,'' AS APPLICATION" ).append("\n"); 
		query.append("		,'' AS CUST_TP_CD" ).append("\n"); 
		query.append("		,'' AS CALC_TP_CD" ).append("\n"); 
		query.append("		,'' AS ORI_ROUT_CD" ).append("\n"); 
		query.append("		,'' AS ORI_LOC_TP" ).append("\n"); 
		query.append("		,'' AS DEST_ROUT_CD" ).append("\n"); 
		query.append("		,'' AS DEST_LOC_TP" ).append("\n"); 
		query.append("		,'' AS AMOUNT" ).append("\n"); 
		query.append("		,'' AS EFF_DT" ).append("\n"); 
		query.append("		,'' AS EXP_DT" ).append("\n"); 
		query.append("		,'' AS CHG_CD" ).append("\n"); 
		query.append("		,'' AS SVC_SCP_CD" ).append("\n"); 
		query.append("		,'' AS PROP_NO_LIST" ).append("\n"); 
		query.append("		,'' AS SCORE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}