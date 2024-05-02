/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriRtGRIApplyVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2010.01.05 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriRtGRIApplyVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Apply
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriRtGRIApplyVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gri_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriRtGRIApplyVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRI_RT" ).append("\n"); 
		query.append("(TRI_PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",EFF_DT" ).append("\n"); 
		query.append(",EXP_DT" ).append("\n"); 
		query.append(",PUB_DT" ).append("\n"); 
		query.append(",TRI_RQST_OFC_CD" ).append("\n"); 
		query.append(",TRI_RQST_USR_ID" ).append("\n"); 
		query.append(",TRI_APRO_OFC_CD" ).append("\n"); 
		query.append(",TRI_APRO_USR_ID" ).append("\n"); 
		query.append(",PROP_STS_CD" ).append("\n"); 
		query.append(",RAT_UT_CD" ).append("\n"); 
		query.append(",PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",PROP_FRT_RT_AMT" ).append("\n"); 
		query.append(",COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append(",FNL_FRT_RT_AMT" ).append("\n"); 
		query.append(",NOTE_CTNT" ).append("\n"); 
		query.append(",NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(",PRS_SCG_AMT" ).append("\n"); 
		query.append(",PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append(",PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append(",PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append(",PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append(",PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append(",PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append(",PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append(",PRS_UPD_DT" ).append("\n"); 
		query.append(",VSL_SLAN_CD" ).append("\n"); 
		query.append(",GRI_APPL_TP_CD" ).append("\n"); 
		query.append(",GRI_APPL_AMT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT)" ).append("\n"); 
		query.append("SELECT TRI_PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ + 1 AS AMDT_SEQ" ).append("\n"); 
		query.append(",TO_DATE(@[gri_eff_dt],'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",EXP_DT" ).append("\n"); 
		query.append(",NULL AS PUB_DT" ).append("\n"); 
		query.append(",@[tri_rqst_ofc_cd] AS TRI_RQST_OFC_CD" ).append("\n"); 
		query.append(",@[tri_rqst_usr_id] AS TRI_RQST_USR_ID" ).append("\n"); 
		query.append(",@[tri_apro_ofc_cd] AS TRI_APRO_OFC_CD" ).append("\n"); 
		query.append(",NULL AS TRI_APRO_USR_ID" ).append("\n"); 
		query.append(",'I' AS PROP_STS_CD" ).append("\n"); 
		query.append(",RAT_UT_CD" ).append("\n"); 
		query.append(",PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",FNL_FRT_RT_AMT + DECODE(FLT_PCT_TP_CD, 'F', GRI_RT_AMT, 'P', GRI_RT_RTO / 100 * FNL_FRT_RT_AMT) AS PROP_FRT_RT_AMT" ).append("\n"); 
		query.append(",NULL AS COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append(",NULL AS FNL_FRT_RT_AMT" ).append("\n"); 
		query.append(",NOTE_CTNT" ).append("\n"); 
		query.append(",SYS_GUID() AS NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(",NULL AS PRS_SCG_AMT" ).append("\n"); 
		query.append(",NULL AS PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append(",NULL AS PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append(",NULL AS PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append("--        ,(FNL_FRT_RT_AMT + DECODE(FLT_PCT_TP_CD, 'F', GRI_RT_AMT, 'P', GRI_RT_RTO / 100 * FNL_FRT_RT_AMT) + PRS_SCG_AMT - PRS_RESPB_CM_UC_AMT) AS PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("--        ,(FNL_FRT_RT_AMT + DECODE(FLT_PCT_TP_CD, 'F', GRI_RT_AMT, 'P', GRI_RT_RTO / 100 * FNL_FRT_RT_AMT) + PRS_SCG_AMT - PRS_PFIT_CM_UC_AMT) AS PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append("--        ,(FNL_FRT_RT_AMT + DECODE(FLT_PCT_TP_CD, 'F', GRI_RT_AMT, 'P', GRI_RT_RTO / 100 * FNL_FRT_RT_AMT) + PRS_SCG_AMT - PRS_RESPB_OPFIT_UC_AMT) AS PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append(",NULL AS PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append(",NULL AS PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append(",NULL AS PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append(",NULL AS PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append(",NULL AS PRS_UPD_DT" ).append("\n"); 
		query.append(",NULL AS VSL_SLAN_CD" ).append("\n"); 
		query.append(",'A' AS GRI_APPL_TP_CD" ).append("\n"); 
		query.append(",DECODE(FLT_PCT_TP_CD, 'F', GRI_RT_AMT, 'P', GRI_RT_RTO / 100 * FNL_FRT_RT_AMT) AS GRI_APPL_AMT" ).append("\n"); 
		query.append(",@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM (SELECT A.TRI_PROP_NO" ).append("\n"); 
		query.append(",G.AMDT_SEQ" ).append("\n"); 
		query.append(",G.EXP_DT" ).append("\n"); 
		query.append(",G.RAT_UT_CD" ).append("\n"); 
		query.append(",G.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",G.CURR_CD" ).append("\n"); 
		query.append(",G.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append(",G.NOTE_CTNT" ).append("\n"); 
		query.append(",G.PRS_SCG_AMT" ).append("\n"); 
		query.append(",G.PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append(",G.PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append(",G.PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append(",X.FLT_PCT_TP_CD" ).append("\n"); 
		query.append(",X.GRI_RT_AMT" ).append("\n"); 
		query.append(",X.GRI_RT_RTO" ).append("\n"); 
		query.append(",I.GRP_CNT" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY A.TRI_PROP_NO ORDER BY NULL) AS RN" ).append("\n"); 
		query.append("FROM PRI_TRI_MN A" ).append("\n"); 
		query.append(",PRI_TRI_RT_ROUT_PNT C" ).append("\n"); 
		query.append(",PRI_TRI_RT_ROUT_VIA D" ).append("\n"); 
		query.append(",PRI_TRI_RT_ROUT_VIA E" ).append("\n"); 
		query.append(",PRI_TRI_RT_ROUT_PNT F" ).append("\n"); 
		query.append(",PRI_TRI_RT G" ).append("\n"); 
		query.append(",(SELECT TRI_PROP_NO, MAX(AMDT_SEQ) AS AMDT_SEQ FROM PRI_TRI_RT GROUP BY TRI_PROP_NO) H" ).append("\n"); 
		query.append(",(SELECT A.TRI_PROP_NO, COUNT(*) AS GRP_CNT" ).append("\n"); 
		query.append("FROM PRI_TRI_MN A, PRI_TRI_RT_ROUT_PNT C, PRI_TRI_RT_ROUT_VIA D, PRI_TRI_RT_ROUT_VIA E, PRI_TRI_RT_ROUT_PNT F" ).append("\n"); 
		query.append("WHERE A.TRI_PROP_NO = C.TRI_PROP_NO" ).append("\n"); 
		query.append("AND A.TRI_PROP_NO = D.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("AND A.TRI_PROP_NO = E.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("AND A.TRI_PROP_NO = F.TRI_PROP_NO" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND A.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND C.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND D.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("AND E.ORG_DEST_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("AND F.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("GROUP BY A.TRI_PROP_NO) I" ).append("\n"); 
		query.append(",(SELECT A.TRF_PFX_CD" ).append("\n"); 
		query.append(",A.TRF_NO" ).append("\n"); 
		query.append(",A.GRI_GRP_SEQ" ).append("\n"); 
		query.append(",A.FLT_PCT_TP_CD" ).append("\n"); 
		query.append(",A.GRI_APPL_DIV_CD" ).append("\n"); 
		query.append(",B.CMDT_CD" ).append("\n"); 
		query.append(",C.ROUT_PNT_LOC_TP_CD AS ORG_ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",C.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",C.RCV_DE_TERM_CD AS ORG_RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",C.PRC_TRSP_MOD_CD AS ORG_PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append(",D.ROUT_VIA_PORT_TP_CD AS ORG_ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",D.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",E.ROUT_VIA_PORT_TP_CD AS DEST_ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",E.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",F.ROUT_PNT_LOC_TP_CD AS DEST_ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",F.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",F.RCV_DE_TERM_CD AS DEST_RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",F.PRC_TRSP_MOD_CD AS DEST_PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append(",G.RAT_UT_CD" ).append("\n"); 
		query.append(",G.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",G.CURR_CD" ).append("\n"); 
		query.append(",G.GRI_RT_AMT" ).append("\n"); 
		query.append(",G.GRI_RT_RTO" ).append("\n"); 
		query.append("FROM PRI_TRI_GRI_GRP      A" ).append("\n"); 
		query.append(",PRI_TRI_GRI_CMDT     B" ).append("\n"); 
		query.append(",PRI_TRI_GRI_ROUT_PNT C" ).append("\n"); 
		query.append(",PRI_TRI_GRI_ROUT_VIA D" ).append("\n"); 
		query.append(",PRI_TRI_GRI_ROUT_VIA E" ).append("\n"); 
		query.append(",PRI_TRI_GRI_ROUT_PNT F" ).append("\n"); 
		query.append(",PRI_TRI_GRI_RT       G" ).append("\n"); 
		query.append("WHERE A.GRI_APPL_DIV_CD = 'I'" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = B.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = B.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = B.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = C.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = C.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = C.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = D.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = D.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = D.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = E.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = E.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = E.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = F.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = F.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = F.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = G.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = G.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = G.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND A.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND C.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("AND D.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("AND E.ORG_DEST_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("AND F.ORG_DEST_TP_CD(+) = 'D') X" ).append("\n"); 
		query.append("WHERE A.TRI_PROP_NO = C.TRI_PROP_NO" ).append("\n"); 
		query.append("AND A.TRI_PROP_NO = D.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("AND A.TRI_PROP_NO = E.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("AND A.TRI_PROP_NO = F.TRI_PROP_NO" ).append("\n"); 
		query.append("AND A.TRI_PROP_NO = G.TRI_PROP_NO" ).append("\n"); 
		query.append("AND G.TRI_PROP_NO = H.TRI_PROP_NO" ).append("\n"); 
		query.append("AND G.AMDT_SEQ = H.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.TRI_PROP_NO = I.TRI_PROP_NO" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND A.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND C.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND D.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("AND E.ORG_DEST_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("AND F.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND G.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("AND G.EFF_DT < TO_DATE(@[gri_eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND G.EXP_DT > TO_DATE(@[gri_eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = X.TRF_PFX_CD" ).append("\n"); 
		query.append("AND A.TRF_NO = X.TRF_NO" ).append("\n"); 
		query.append("AND (X.CMDT_CD IS NULL OR A.CMDT_CD = X.CMDT_CD)" ).append("\n"); 
		query.append("AND (X.ORG_ROUT_PNT_LOC_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("(X.ORG_ROUT_PNT_LOC_TP_CD = 'L' AND C.ROUT_PNT_LOC_CD = X.ORG_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("(X.ORG_ROUT_PNT_LOC_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("(SELECT 'OK'" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CNT_CD = X.ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND LOC_CD = C.ROUT_PNT_LOC_CD)))" ).append("\n"); 
		query.append("AND (X.ORG_RCV_DE_TERM_CD IS NULL OR C.RCV_DE_TERM_CD = X.ORG_RCV_DE_TERM_CD)" ).append("\n"); 
		query.append("AND (X.ORG_PRC_TRSP_MOD_CD IS NULL OR C.PRC_TRSP_MOD_CD = X.ORG_PRC_TRSP_MOD_CD)" ).append("\n"); 
		query.append("AND (X.ORG_ROUT_VIA_PORT_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("(X.ORG_ROUT_VIA_PORT_TP_CD = 'L' AND D.ROUT_VIA_PORT_CD = X.ORG_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("(X.ORG_ROUT_VIA_PORT_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("(SELECT 'OK'" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CNT_CD = X.ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("AND LOC_CD = D.ROUT_VIA_PORT_CD)))" ).append("\n"); 
		query.append("AND (X.DEST_ROUT_VIA_PORT_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("(X.DEST_ROUT_VIA_PORT_TP_CD = 'L' AND E.ROUT_VIA_PORT_CD = X.DEST_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("(X.DEST_ROUT_VIA_PORT_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("(SELECT 'OK'" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CNT_CD = X.DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("AND LOC_CD = E.ROUT_VIA_PORT_CD)))" ).append("\n"); 
		query.append("AND (X.DEST_ROUT_PNT_LOC_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("(X.DEST_ROUT_PNT_LOC_TP_CD = 'L' AND F.ROUT_PNT_LOC_CD = X.DEST_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("(X.DEST_ROUT_PNT_LOC_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("(SELECT 'OK'" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CNT_CD = X.DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND LOC_CD = F.ROUT_PNT_LOC_CD)))" ).append("\n"); 
		query.append("AND (X.DEST_RCV_DE_TERM_CD IS NULL OR F.RCV_DE_TERM_CD = X.DEST_RCV_DE_TERM_CD)" ).append("\n"); 
		query.append("AND (X.DEST_PRC_TRSP_MOD_CD IS NULL OR F.PRC_TRSP_MOD_CD = X.DEST_PRC_TRSP_MOD_CD)" ).append("\n"); 
		query.append("AND G.RAT_UT_CD = X.RAT_UT_CD" ).append("\n"); 
		query.append("AND G.PRC_CGO_TP_CD = X.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("AND G.CURR_CD = X.CURR_CD" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM (SELECT A.TRF_PFX_CD" ).append("\n"); 
		query.append(",A.TRF_NO" ).append("\n"); 
		query.append(",A.GRI_GRP_SEQ" ).append("\n"); 
		query.append(",A.FLT_PCT_TP_CD" ).append("\n"); 
		query.append(",A.GRI_APPL_DIV_CD" ).append("\n"); 
		query.append(",B.CMDT_CD" ).append("\n"); 
		query.append(",C.ROUT_PNT_LOC_TP_CD AS ORG_ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",C.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",C.RCV_DE_TERM_CD AS ORG_RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",C.PRC_TRSP_MOD_CD AS ORG_PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append(",D.ROUT_VIA_PORT_TP_CD AS ORG_ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",D.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",E.ROUT_VIA_PORT_TP_CD AS DEST_ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",E.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",F.ROUT_PNT_LOC_TP_CD AS DEST_ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",F.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",F.RCV_DE_TERM_CD AS DEST_RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",F.PRC_TRSP_MOD_CD AS DEST_PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append(",G.RAT_UT_CD" ).append("\n"); 
		query.append(",G.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",G.CURR_CD" ).append("\n"); 
		query.append(",G.GRI_RT_AMT" ).append("\n"); 
		query.append(",G.GRI_RT_RTO" ).append("\n"); 
		query.append("FROM PRI_TRI_GRI_GRP      A" ).append("\n"); 
		query.append(",PRI_TRI_GRI_CMDT     B" ).append("\n"); 
		query.append(",PRI_TRI_GRI_ROUT_PNT C" ).append("\n"); 
		query.append(",PRI_TRI_GRI_ROUT_VIA D" ).append("\n"); 
		query.append(",PRI_TRI_GRI_ROUT_VIA E" ).append("\n"); 
		query.append(",PRI_TRI_GRI_ROUT_PNT F" ).append("\n"); 
		query.append(",PRI_TRI_GRI_RT       G" ).append("\n"); 
		query.append("WHERE A.GRI_APPL_DIV_CD = 'E'" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = B.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = B.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = B.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = C.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = C.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = C.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = D.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = D.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = D.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = E.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = E.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = E.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = F.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = F.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = F.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = G.TRF_PFX_CD(+)" ).append("\n"); 
		query.append("AND A.TRF_NO = G.TRF_NO(+)" ).append("\n"); 
		query.append("AND A.GRI_GRP_SEQ = G.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND A.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND C.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("AND D.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("AND E.ORG_DEST_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("AND F.ORG_DEST_TP_CD(+) = 'D') Y" ).append("\n"); 
		query.append("WHERE A.TRF_PFX_CD = Y.TRF_PFX_CD" ).append("\n"); 
		query.append("AND A.TRF_NO = Y.TRF_NO" ).append("\n"); 
		query.append("AND (Y.CMDT_CD IS NULL OR A.CMDT_CD = Y.CMDT_CD)" ).append("\n"); 
		query.append("AND (Y.ORG_ROUT_PNT_LOC_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("(Y.ORG_ROUT_PNT_LOC_TP_CD = 'L' AND C.ROUT_PNT_LOC_CD = Y.ORG_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("(Y.ORG_ROUT_PNT_LOC_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("(SELECT 'OK'" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CNT_CD = Y.ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND LOC_CD = C.ROUT_PNT_LOC_CD)))" ).append("\n"); 
		query.append("AND (Y.ORG_RCV_DE_TERM_CD IS NULL OR C.RCV_DE_TERM_CD = Y.ORG_RCV_DE_TERM_CD)" ).append("\n"); 
		query.append("AND (Y.ORG_PRC_TRSP_MOD_CD IS NULL OR C.PRC_TRSP_MOD_CD = Y.ORG_PRC_TRSP_MOD_CD)" ).append("\n"); 
		query.append("AND (Y.ORG_ROUT_VIA_PORT_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("(Y.ORG_ROUT_VIA_PORT_TP_CD = 'L' AND D.ROUT_VIA_PORT_CD = Y.ORG_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("(Y.ORG_ROUT_VIA_PORT_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("(SELECT 'OK'" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CNT_CD = Y.ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("AND LOC_CD = D.ROUT_VIA_PORT_CD)))" ).append("\n"); 
		query.append("AND (Y.DEST_ROUT_VIA_PORT_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("(Y.DEST_ROUT_VIA_PORT_TP_CD = 'L' AND E.ROUT_VIA_PORT_CD = Y.DEST_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("(Y.DEST_ROUT_VIA_PORT_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("(SELECT 'OK'" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CNT_CD = Y.DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("AND LOC_CD = E.ROUT_VIA_PORT_CD)))" ).append("\n"); 
		query.append("AND (Y.DEST_ROUT_PNT_LOC_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("(Y.DEST_ROUT_PNT_LOC_TP_CD = 'L' AND F.ROUT_PNT_LOC_CD = Y.DEST_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("(Y.DEST_ROUT_PNT_LOC_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("(SELECT 'OK'" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CNT_CD = Y.DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND LOC_CD = F.ROUT_PNT_LOC_CD)))" ).append("\n"); 
		query.append("AND (Y.DEST_RCV_DE_TERM_CD IS NULL OR F.RCV_DE_TERM_CD = Y.DEST_RCV_DE_TERM_CD)" ).append("\n"); 
		query.append("AND (Y.DEST_PRC_TRSP_MOD_CD IS NULL OR F.PRC_TRSP_MOD_CD = Y.DEST_PRC_TRSP_MOD_CD)))" ).append("\n"); 
		query.append("WHERE RN = GRP_CNT" ).append("\n"); 

	}
}