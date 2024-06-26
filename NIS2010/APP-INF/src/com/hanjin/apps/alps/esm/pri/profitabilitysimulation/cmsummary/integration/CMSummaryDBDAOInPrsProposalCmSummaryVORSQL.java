/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CMSummaryDBDAOInPrsProposalCmSummaryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.06 송민석
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

public class CMSummaryDBDAOInPrsProposalCmSummaryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_PRI_6024 화면의 조회 조건을 저장하기 위한 VO를 만들기 위한 쿼리
	  * </pre>
	  */
	public CMSummaryDBDAOInPrsProposalCmSummaryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration").append("\n"); 
		query.append("FileName : CMSummaryDBDAOInPrsProposalCmSummaryVORSQL").append("\n"); 
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
		query.append("	 '' AS FRM_CONTRACT_TYPE" ).append("\n"); 
		query.append("	,'' AS FRM_PFMC_UNIT" ).append("\n"); 
		query.append("	,'' AS FRM_STATUS" ).append("\n"); 
		query.append("	,'' AS FRM_PROFIT_VIEW" ).append("\n"); 
		query.append("	,'' AS FRM_PROFIT_LEVEL" ).append("\n"); 
		query.append("	,'' AS FRM_SUMMARY_ITEMS" ).append("\n"); 
		query.append("	,'' AS FRM_SVC_SCP_CD" ).append("\n"); 
		query.append("	,'' AS FRM_CTRT_EFF_DT" ).append("\n"); 
		query.append("	,'' AS FRM_CTRT_EXP_DT" ).append("\n"); 
		query.append("	,'' AS FRM_PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("	,'' AS FRM_PROP_OFC_CD" ).append("\n"); 
		query.append("	,'' AS FRM_PROP_SREP_CD" ).append("\n"); 
		query.append("	,'' AS FRM_PROP_SREP_NM" ).append("\n"); 
		query.append("	,'' AS FRM_CUSTOMER_TYPE" ).append("\n"); 
		query.append("	,'' AS FRM_CUSTOMER_SM" ).append("\n"); 
		query.append("	,'' AS FRM_CUSTOMER_SM_CD" ).append("\n"); 
		query.append("	,'' AS FRM_CRG_TP_DRY" ).append("\n"); 
		query.append("	,'' AS FRM_CRG_TP_DG" ).append("\n"); 
		query.append("	,'' AS FRM_CRG_TP_RF" ).append("\n"); 
		query.append("	,'' AS FRM_CRG_TP_AK" ).append("\n"); 
		query.append("	,'' AS FRM_CRG_TP_BB" ).append("\n"); 
		query.append("	,'' AS FRM_CUST_LIST" ).append("\n"); 
		query.append("	,'' as FRM_PROP_NO_LIST" ).append("\n"); 
		query.append("	,'' as FRM_RFA_PROP_NO_LIST" ).append("\n"); 
		query.append("	,'' AS NEW_DATA_COL" ).append("\n"); 
		query.append("	,'' AS PREV_DATA_COL" ).append("\n"); 
		query.append("	,'' AS RANK_ORDER" ).append("\n"); 
		query.append("	,'' AS GRP_CODE" ).append("\n"); 
		query.append("	,'' AS RANGE_VAL" ).append("\n"); 
		query.append("	,'' AS FRM_CONTRACT_TYPE_S" ).append("\n"); 
		query.append("	,'' AS FRM_CONTRACT_TYPE_R" ).append("\n"); 
		query.append("	,'' AS FRM_CONTRACT_TYPE_T" ).append("\n"); 
		query.append("	,'' AS FRM_ORI_ROUT_CD" ).append("\n"); 
		query.append("	,'' AS FRM_DEST_ROUT_CD" ).append("\n"); 
		query.append("	,'' AS FRM_ORI_LOC_TP" ).append("\n"); 
		query.append("	,'' AS FRM_DEST_LOC_TP" ).append("\n"); 
		query.append("	,'' AS FRM_SLANE_CD" ).append("\n"); 
		query.append("	,'' AS CNT_CD" ).append("\n"); 
		query.append("	,'' AS RGN_CD" ).append("\n"); 
		query.append("	,'' AS LOC_TP_CD" ).append("\n"); 
		query.append("	,'' AS ORI_DEST_CD" ).append("\n"); 
		query.append("	,'' AS SVC_SCP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}