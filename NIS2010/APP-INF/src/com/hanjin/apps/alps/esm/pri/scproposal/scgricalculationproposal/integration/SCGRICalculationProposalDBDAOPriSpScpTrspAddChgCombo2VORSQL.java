/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGRICalculationProposalDBDAOPriSpScpTrspAddChgCombo2VORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 서호열
*@LastVersion : 1.0
* 2009.07.13 서호열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HoYeolSea
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGRICalculationProposalDBDAOPriSpScpTrspAddChgCombo2VORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Calculation - Arbitrary 하단 그리드 콤보데이터조회   
	  * </pre>
	  */
	public SCGRICalculationProposalDBDAOPriSpScpTrspAddChgCombo2VORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.integration").append("\n"); 
		query.append("FileName : SCGRICalculationProposalDBDAOPriSpScpTrspAddChgCombo2VORSQL").append("\n"); 
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
		query.append("SELECT HG.PROP_NO AS PROP_NO" ).append("\n"); 
		query.append(", HG.AMDT_SEQ AS AMDT_SEQ" ).append("\n"); 
		query.append(", HG.SVC_SCP_CD AS SVC_SCP_CD" ).append("\n"); 
		query.append(", HG.ADD_CHG_TP_CD AS ADD_CHG_TP_CD" ).append("\n"); 
		query.append(", HG.ORG_DEST_TP_CD AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append(", HG.RAT_UT_CD AS RAT_UT_CD" ).append("\n"); 
		query.append(", (SELECT RAT_UT_CD||'\\t'||RAT_UT_DESC AS NM" ).append("\n"); 
		query.append("FROM PRI_RAT_UT" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CTRT_USE_ONY_FLG = 'Y'" ).append("\n"); 
		query.append("AND RAT_UT_CD = HG.RAT_UT_CD) AS RAT_UT_CD_NM" ).append("\n"); 
		query.append(", HG.PRC_CGO_TP_CD AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_CTNT||'\\t'||INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02141'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = HG.PRC_CGO_TP_CD) AS PRC_CGO_TP_CD_NM" ).append("\n"); 
		query.append(", HG.CURR_CD AS CURR_CD" ).append("\n"); 
		query.append(", MIN(HG.N1ST_CMNC_DT) AS N1ST_CMNC_DT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_TRSP_ADD_CHG HG" ).append("\n"); 
		query.append("WHERE HG.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND HG.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND HG.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND HG.ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("AND HG.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, ADD_CHG_TP_CD," ).append("\n"); 
		query.append("ORG_DEST_TP_CD, RAT_UT_CD, PRC_CGO_TP_CD, CURR_CD" ).append("\n"); 

	}
}