/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CMSummaryDBDAORsltPrsAmendmentCmSummarySimulation2NdTypeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.11 송민석
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

public class CMSummaryDBDAORsltPrsAmendmentCmSummarySimulation2NdTypeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CMSummaryDBDAORsltPrsAmendmentCmSummarySimulation2NdTypeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration").append("\n"); 
		query.append("FileName : CMSummaryDBDAORsltPrsAmendmentCmSummarySimulation2NdTypeVORSQL").append("\n"); 
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
		query.append("SELECT  PRC_CTRT_NO AS SC_NO" ).append("\n"); 
		query.append("			, LOAD" ).append("\n"); 
		query.append("			, G_REV" ).append("\n"); 
		query.append("			, COST_CM_OFFICE AS  COST_OFFICE" ).append("\n"); 
		query.append("			, COST_CM_TRADE AS  COST_TRADE" ).append("\n"); 
		query.append("			, COST_OP_OFFICE" ).append("\n"); 
		query.append("			, CM_OFFICE" ).append("\n"); 
		query.append("			, CM_TRADE" ).append("\n"); 
		query.append("			, OP AS OP_OFFICE" ).append("\n"); 
		query.append("			, CM_OFFICE / DECODE(LOAD,0,1,LOAD) AS CMPB_OFFICE" ).append("\n"); 
		query.append("			, CM_TRADE /  DECODE(LOAD,0,1,LOAD) AS CMPB_TRADE" ).append("\n"); 
		query.append("			, OP /  DECODE(LOAD,0,1,LOAD) AS OPB_OFFICE" ).append("\n"); 
		query.append("			, DECODE(UPD_FLG,'Y','Y',DECODE(SCG_UPD_FLG,'Y','Y','N')) AS UPD_FLG" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			SELECT  PRC_CTRT_NO " ).append("\n"); 
		query.append("				, SUM(LOAD  / DECODE('TEU','FEU',2,'TEU',1) )      AS LOAD            -- Load(Previous)" ).append("\n"); 
		query.append("				, SUM(LOAD   * COST_CM_OFFICE)   AS COST_CM_OFFICE  -- Office Profit/ CM -- Cost(Previous)" ).append("\n"); 
		query.append("				, SUM(LOAD   * COST_CM_TRADE)    AS COST_CM_TRADE   --Trade Profit/ CM   -- Cost(Previous)" ).append("\n"); 
		query.append("				, SUM(LOAD   * COST_OP_OFFICE) AS COST_OP_OFFICE -- Office Profit/ OP -- Cost(Previous)" ).append("\n"); 
		query.append("				, SUM(LOAD   * ( RATE/LOAD + SURCHAGE/LOAD) )         AS G_REV            -- Gross Revenue(Previous)" ).append("\n"); 
		query.append("				, SUM(LOAD   *  ( RATE/LOAD + SURCHAGE/LOAD  - COST_CM_OFFICE ) ) AS CM_OFFICE" ).append("\n"); 
		query.append("				, SUM(LOAD   *  ( RATE/LOAD + SURCHAGE/LOAD  - COST_CM_TRADE ) ) AS CM_TRADE" ).append("\n"); 
		query.append("				, SUM(LOAD   *  ( RATE/LOAD + SURCHAGE/LOAD  - COST_OP_OFFICE - COST_CM_OFFICE ) ) AS OP" ).append("\n"); 
		query.append("				, MAX(UPD_FLG) AS UPD_FLG" ).append("\n"); 
		query.append("				, MAX(SCG_UPD_FLG) AS SCG_UPD_FLG" ).append("\n"); 
		query.append("			FROM (" ).append("\n"); 
		query.append("				SELECT SR_CST_DTL.PRS_YRMON       " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.PRS_WK          " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.PRC_CTRT_TP_CD  " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.PRC_CTRT_NO     " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.SVC_SCP_CD      " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.VSL_SLAN_DIR_CD " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.TRD_CD          " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.SUB_TRD_CD      " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.RLANE_CD        " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.PRC_CGO_TP_CD   " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.ORG_LOC_TP_CD   " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.ORG_LOC_DEF_CD  " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.DEST_LOC_TP_CD  " ).append("\n"); 
		query.append("				       ,SR_CST_DTL.DEST_LOC_DEF_CD " ).append("\n"); 
		query.append("					, MAX(SR_CST_DTL.PRS_CRNT_LOD_QTY  )      AS LOAD            -- Load(Previous)" ).append("\n"); 
		query.append("					, MAX(SR_CST_DTL.PRS_RESPB_CM_UC_AMT)   AS COST_CM_OFFICE  -- Office Profit/ CM -- Cost(Previous)" ).append("\n"); 
		query.append("					, MAX(SR_CST_DTL.PRS_PFIT_CM_UC_AMT)    AS COST_CM_TRADE   --Trade Profit/ CM   -- Cost(Previous)" ).append("\n"); 
		query.append("					, MAX(SR_CST_DTL.PRS_RESPB_OPFIT_UC_AMT) AS COST_OP_OFFICE -- Office Profit/ OP -- Cost(Previous)" ).append("\n"); 
		query.append("					, SUM( DECODE(SR_SCG.CHG_CD,'OFT',SR_SCG.SCG_AMT*SR_CST_DTL.PRS_CRNT_LOD_QTY,0) ) AS RATE" ).append("\n"); 
		query.append("					, SUM( DECODE(SR_SCG.CHG_CD,'OFT',0,SR_SCG.SCG_AMT*SR_CST_DTL.PRS_CRNT_LOD_QTY) ) AS SURCHAGE" ).append("\n"); 
		query.append("					, MAX(SR_CST_DTL.UPD_USR_ID) AS UPD_FLG" ).append("\n"); 
		query.append("					, MAX(SR_SCG.UPD_USR_ID) AS SCG_UPD_FLG" ).append("\n"); 
		query.append("				FROM  PRI_PRS_CTRT_SMRY_COST_TMP SR_CST_DTL" ).append("\n"); 
		query.append("					, PRI_PRS_CTRT_SMRY_SCG_TMP SR_SCG" ).append("\n"); 
		query.append("				WHERE " ).append("\n"); 
		query.append("					    SR_CST_DTL.PRS_YRMON        = SR_SCG.PRS_YRMON      " ).append("\n"); 
		query.append("					AND SR_CST_DTL.PRS_WK           = SR_SCG.PRS_WK         " ).append("\n"); 
		query.append("					AND SR_CST_DTL.PRC_CTRT_TP_CD   = SR_SCG.PRC_CTRT_TP_CD " ).append("\n"); 
		query.append("					AND SR_CST_DTL.PRC_CTRT_NO      = SR_SCG.PRC_CTRT_NO    " ).append("\n"); 
		query.append("					AND SR_CST_DTL.SVC_SCP_CD       = SR_SCG.SVC_SCP_CD     " ).append("\n"); 
		query.append("					AND SR_CST_DTL.VSL_SLAN_DIR_CD  = SR_SCG.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("					AND SR_CST_DTL.TRD_CD           = SR_SCG.TRD_CD         " ).append("\n"); 
		query.append("					AND SR_CST_DTL.SUB_TRD_CD       = SR_SCG.SUB_TRD_CD     " ).append("\n"); 
		query.append("					AND SR_CST_DTL.RLANE_CD         = SR_SCG.RLANE_CD       " ).append("\n"); 
		query.append("					AND SR_CST_DTL.PRC_CGO_TP_CD    = SR_SCG.PRC_CGO_TP_CD  " ).append("\n"); 
		query.append("					AND SR_CST_DTL.ORG_LOC_TP_CD    = SR_SCG.ORG_LOC_TP_CD  " ).append("\n"); 
		query.append("					AND SR_CST_DTL.ORG_LOC_DEF_CD   = SR_SCG.ORG_LOC_DEF_CD " ).append("\n"); 
		query.append("					AND SR_CST_DTL.DEST_LOC_TP_CD   = SR_SCG.DEST_LOC_TP_CD " ).append("\n"); 
		query.append("					AND SR_CST_DTL.DEST_LOC_DEF_CD  = SR_SCG.DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("				GROUP BY SR_CST_DTL.PRS_YRMON       " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.PRS_WK          " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.PRC_CTRT_TP_CD  " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.PRC_CTRT_NO     " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.SVC_SCP_CD      " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.VSL_SLAN_DIR_CD " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.TRD_CD          " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.SUB_TRD_CD      " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.RLANE_CD        " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.PRC_CGO_TP_CD   " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.ORG_LOC_TP_CD   " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.ORG_LOC_DEF_CD  " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.DEST_LOC_TP_CD  " ).append("\n"); 
		query.append("					 ,SR_CST_DTL.DEST_LOC_DEF_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("			GROUP BY PRC_CTRT_NO " ).append("\n"); 
		query.append("		) MN" ).append("\n"); 
		query.append("		WHERE DECODE(UPD_FLG,'Y','Y',DECODE(SCG_UPD_FLG,'Y','Y','N')) = 'Y'" ).append("\n"); 

	}
}