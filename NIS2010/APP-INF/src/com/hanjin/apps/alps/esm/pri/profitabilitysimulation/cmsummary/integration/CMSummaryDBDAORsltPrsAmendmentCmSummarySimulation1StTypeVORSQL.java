/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMSummaryDBDAORsltPrsAmendmentCmSummarySimulation1StTypeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.12.21 송민석
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

public class CMSummaryDBDAORsltPrsAmendmentCmSummarySimulation1StTypeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CMSummaryDBDAORsltPrsAmendmentCmSummarySimulation1StTypeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_pfmc_unit",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration").append("\n"); 
		query.append("FileName : CMSummaryDBDAORsltPrsAmendmentCmSummarySimulation1StTypeVORSQL").append("\n"); 
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
		query.append(", LOAD" ).append("\n"); 
		query.append(", G_REV" ).append("\n"); 
		query.append(", COST_CM_OFFICE AS  COST_OFFICE" ).append("\n"); 
		query.append(", COST_CM_TRADE AS  COST_TRADE" ).append("\n"); 
		query.append(", COST_OP_OFFICE" ).append("\n"); 
		query.append(", CM_OFFICE" ).append("\n"); 
		query.append(", CM_TRADE" ).append("\n"); 
		query.append(", OP AS OP_OFFICE" ).append("\n"); 
		query.append(", CM_OFFICE / DECODE(LOAD,0,1,LOAD) AS CMPB_OFFICE" ).append("\n"); 
		query.append(", CM_TRADE /  DECODE(LOAD,0,1,LOAD) AS CMPB_TRADE" ).append("\n"); 
		query.append(", OP /  DECODE(LOAD,0,1,LOAD) AS OPB_OFFICE" ).append("\n"); 
		query.append(", UPD_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  SR_CST_DTL.PRC_CTRT_NO" ).append("\n"); 
		query.append(", SUM(SR_CST_DTL.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1) )      AS LOAD            -- Load(Previous)" ).append("\n"); 
		query.append(", SUM(SR_CST_DTL.PRS_RESPB_CM_UC_AMT * SR_CST_DTL.PRS_CRNT_LOD_QTY)   AS COST_CM_OFFICE  -- Office Profit/ CM -- Cost(Previous)" ).append("\n"); 
		query.append(", SUM(SR_CST_DTL.PRS_PFIT_CM_UC_AMT * SR_CST_DTL.PRS_CRNT_LOD_QTY)    AS COST_CM_TRADE   --Trade Profit/ CM   -- Cost(Previous)" ).append("\n"); 
		query.append(", SUM(SR_CST_DTL.PRS_RESPB_OPFIT_UC_AMT * SR_CST_DTL.PRS_CRNT_LOD_QTY) AS COST_OP_OFFICE -- Office Profit/ OP -- Cost(Previous)" ).append("\n"); 
		query.append(", SUM(SR_CST_DTL.TEU_FRT_REV  * SR_CST_DTL.PRS_CRNT_LOD_QTY)         AS G_REV            -- Gross Revenue(Previous)" ).append("\n"); 
		query.append(", SUM(SR_CST_DTL.PRS_CRNT_LOD_QTY   *  ( SR_CST_DTL.TEU_FRT_REV  - SR_CST_DTL.PRS_RESPB_CM_UC_AMT ) ) AS CM_OFFICE" ).append("\n"); 
		query.append(", SUM(SR_CST_DTL.PRS_CRNT_LOD_QTY   *  ( SR_CST_DTL.TEU_FRT_REV  - SR_CST_DTL.PRS_PFIT_CM_UC_AMT ) ) AS CM_TRADE" ).append("\n"); 
		query.append(", SUM(SR_CST_DTL.PRS_CRNT_LOD_QTY   *  ( SR_CST_DTL.TEU_FRT_REV  - SR_CST_DTL.PRS_RESPB_OPFIT_UC_AMT - SR_CST_DTL.PRS_RESPB_CM_UC_AMT ) ) AS OP" ).append("\n"); 
		query.append(", MAX(SR_CST_DTL.UPD_USR_ID) AS UPD_FLG" ).append("\n"); 
		query.append("FROM  PRI_PRS_CTRT_SMRY_COST_TMP SR_CST_DTL" ).append("\n"); 
		query.append("GROUP BY SR_CST_DTL.PRC_CTRT_NO" ).append("\n"); 
		query.append(") MN" ).append("\n"); 
		query.append("WHERE UPD_FLG = 'Y'" ).append("\n"); 

	}
}