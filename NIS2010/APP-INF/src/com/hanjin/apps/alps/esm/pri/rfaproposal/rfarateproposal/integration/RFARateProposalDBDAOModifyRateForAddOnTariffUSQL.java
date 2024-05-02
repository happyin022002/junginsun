/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAOModifyRateForAddOnTariffUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.18
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.18 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOModifyRateForAddOnTariffUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ticket ID : CHM-201220395
	  * Add-on management T/F-UI 개발
	  * </pre>
	  */
	public RFARateProposalDBDAOModifyRateForAddOnTariffUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_dest_gline_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_dest_rt_use_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_pfit_cmpb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_prop_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_optm_trsp_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_gid_cmpb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_fnl_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_dest_coffr_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_optm_trsp_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_dest_fnl_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_coffr_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_pfit_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_cmnc_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coffr_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_info_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_rt_use_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_respb_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_respb_opb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_org_gline_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_respb_opfit_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_respb_cmpb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gri_appl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_dest_prop_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOModifyRateForAddOnTariffUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RP_SCP_RT CMDT SET " ).append("\n"); 
		query.append("#if (${IS_ACCEPT} == 'N') " ).append("\n"); 
		query.append("	#if (${IS_DEL_AMEND} == 'Y') " ).append("\n"); 
		query.append("			PRC_PROG_STS_CD = 'I'" ).append("\n"); 
		query.append("		,	SRC_INFO_CD = 'AD'" ).append("\n"); 
		query.append("		,	N1ST_CMNC_AMDT_SEQ = @[n1st_cmnc_amdt_seq]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("			RAT_UT_CD = @[rat_ut_cd]" ).append("\n"); 
		query.append("		,	PRC_CGO_TP_CD = @[prc_cgo_tp_cd]" ).append("\n"); 
		query.append("		,	CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("		,	PROP_FRT_RT_AMT = @[prop_frt_rt_amt]" ).append("\n"); 
		query.append("		,	FIC_ORG_PROP_RT_AMT = @[fic_org_prop_rt_amt]" ).append("\n"); 
		query.append("		,	FIC_DEST_PROP_RT_AMT = @[fic_dest_prop_rt_amt]" ).append("\n"); 
		query.append("		,	COFFR_FRT_RT_AMT = @[coffr_frt_rt_amt]" ).append("\n"); 
		query.append("		,	FIC_ORG_COFFR_RT_AMT = @[fic_org_coffr_rt_amt]" ).append("\n"); 
		query.append("		,	FIC_DEST_COFFR_RT_AMT = @[fic_dest_coffr_rt_amt]" ).append("\n"); 
		query.append("		,	FNL_FRT_RT_AMT = @[fnl_frt_rt_amt]" ).append("\n"); 
		query.append("		,	FIC_ORG_FNL_RT_AMT = @[fic_org_fnl_rt_amt]" ).append("\n"); 
		query.append("    ,  FIC_DEST_FNL_RT_AMT = @[fic_dest_fnl_rt_amt] " ).append("\n"); 
		query.append("    ,  PRS_SCG_AMT = @[prs_scg_amt]" ).append("\n"); 
		query.append("    ,  PRS_RESPB_CM_UC_AMT = @[prs_respb_cm_uc_amt]" ).append("\n"); 
		query.append("    ,  PRS_PFIT_CM_UC_AMT = @[prs_pfit_cm_uc_amt]" ).append("\n"); 
		query.append("    ,  PRS_RESPB_OPFIT_UC_AMT = @[prs_respb_opfit_uc_amt]" ).append("\n"); 
		query.append("    ,  PRS_RESPB_CMPB_AMT = @[prs_respb_cmpb_amt]" ).append("\n"); 
		query.append("    ,  PRS_RESPB_OPB_AMT = @[prs_respb_opb_amt]" ).append("\n"); 
		query.append("    ,  PRS_PFIT_CMPB_AMT = @[prs_pfit_cmpb_amt]" ).append("\n"); 
		query.append("    ,  PRS_GID_CMPB_AMT = @[prs_gid_cmpb_amt]" ).append("\n"); 
		query.append("    ,  GRI_APPL_TP_CD = NVL(@[gri_appl_tp_cd], 'N')" ).append("\n"); 
		query.append("    ,  GRI_APPL_AMT = NVL2(@[gri_appl_tp_cd], 0, GRI_APPL_AMT)" ).append("\n"); 
		query.append("    ,  PRC_PROG_STS_CD = @[prc_prog_sts_cd]" ).append("\n"); 
		query.append("    ,  SRC_INFO_CD = @[src_info_cd]" ).append("\n"); 
		query.append("    ,  N1ST_CMNC_AMDT_SEQ = @[n1st_cmnc_amdt_seq]" ).append("\n"); 
		query.append("    ,  FIC_ORG_GLINE_UPD_DT = SYSDATE" ).append("\n"); 
		query.append("    ,  FIC_DEST_GLINE_UPD_DT = SYSDATE" ).append("\n"); 
		query.append("    ,  ORG_OPTM_TRSP_MOD_FLG = NVL(@[org_optm_trsp_mod_flg], 'N')" ).append("\n"); 
		query.append("    ,  DEST_OPTM_TRSP_MOD_FLG = NVL(@[dest_optm_trsp_mod_flg], 'N')" ).append("\n"); 
		query.append("    ,  FIC_ORG_RT_USE_STS_CD = NVL(@[fic_org_rt_use_sts_cd], 'X')" ).append("\n"); 
		query.append("    ,  FIC_DEST_RT_USE_STS_CD = NVL(@[fic_dest_rt_use_sts_cd], 'X')" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#elseif (${IS_ACCEPT} == 'Y') " ).append("\n"); 
		query.append("  #if (${CASCADE_LEVEL} == '0') " ).append("\n"); 
		query.append("       FNL_FRT_RT_AMT = DECODE(@[prc_prog_sts_cd], 'A', PROP_FRT_RT_AMT, 'I', NULL)" ).append("\n"); 
		query.append("    ,  FIC_ORG_FNL_RT_AMT = DECODE(@[prc_prog_sts_cd], 'A', FIC_ORG_PROP_RT_AMT, 'I', NULL)" ).append("\n"); 
		query.append("    ,  FIC_DEST_FNL_RT_AMT = DECODE(@[prc_prog_sts_cd], 'A', FIC_DEST_PROP_RT_AMT, 'I', NULL)" ).append("\n"); 
		query.append("    ,  PRC_PROG_STS_CD = DECODE(@[prc_prog_sts_cd], 'I', NVL2(COFFR_FRT_RT_AMT, 'R', 'I'), @[prc_prog_sts_cd])" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("       COFFR_FRT_RT_AMT = @[coffr_frt_rt_amt]" ).append("\n"); 
		query.append("    ,  FIC_ORG_COFFR_RT_AMT = @[fic_org_coffr_rt_amt]" ).append("\n"); 
		query.append("    ,  FIC_DEST_COFFR_RT_AMT = @[fic_dest_coffr_rt_amt]" ).append("\n"); 
		query.append("    ,  FNL_FRT_RT_AMT = @[fnl_frt_rt_amt]" ).append("\n"); 
		query.append("    ,  FIC_ORG_FNL_RT_AMT = @[fic_org_fnl_rt_amt]" ).append("\n"); 
		query.append("    ,  FIC_DEST_FNL_RT_AMT = @[fic_dest_fnl_rt_amt] " ).append("\n"); 
		query.append("    ,  PRC_PROG_STS_CD = @[prc_prog_sts_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  ,  ACPT_USR_ID = @[acpt_usr_id]" ).append("\n"); 
		query.append("  ,  ACPT_OFC_CD = @[acpt_ofc_cd]" ).append("\n"); 
		query.append("  ,  ACPT_DT = TO_DATE(@[acpt_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ,  UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("  ,  UPD_DT = SYSDATE" ).append("\n"); 
		query.append("#if (${fic_org_gline_rt_amt}!='')" ).append("\n"); 
		query.append("  ,   FIC_ORG_GLINE_RT_AMT = DECODE(@[fic_org_gline_rt_amt], 'N/A', NULL, @[fic_org_gline_rt_amt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fic_dest_gline_rt_amt}!='')" ).append("\n"); 
		query.append("  ,   FIC_DEST_GLINE_RT_AMT = DECODE(@[fic_dest_gline_rt_amt], 'N/A', NULL, @[fic_dest_gline_rt_amt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND  AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND  SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} == '0') " ).append("\n"); 
		query.append("#if (${IS_ACCEPT} == 'Y') " ).append("\n"); 
		query.append("AND (PRC_PROG_STS_CD = DECODE(@[prc_prog_sts_cd], 'A', 'I', 'I', 'A')" ).append("\n"); 
		query.append("    OR PRC_PROG_STS_CD = DECODE(@[prc_prog_sts_cd], 'A', 'X', 'I', ''))" ).append("\n"); 
		query.append("AND AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("-- G,A를 구분해서 update한다." ).append("\n"); 
		query.append("AND EXISTS ( " ).append("\n"); 
		query.append("        SELECT 1 FROM  PRI_RP_SCP_RT_CMDT_HDR HDR " ).append("\n"); 
		query.append("            WHERE HDR.PROP_NO = CMDT.PROP_NO " ).append("\n"); 
		query.append("            AND HDR.AMDT_SEQ = CMDT.AMDT_SEQ " ).append("\n"); 
		query.append("            AND HDR.SVC_SCP_CD = CMDT.SVC_SCP_CD " ).append("\n"); 
		query.append("            AND HDR.CMDT_HDR_SEQ = CMDT.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("            AND NVL(FIC_RT_TP_CD, 'G') = NVL(@[fic_rt_tp_cd], 'G'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == '1') " ).append("\n"); 
		query.append("AND  CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == '2') " ).append("\n"); 
		query.append("AND  CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND  ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND  CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND  ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND  RT_SEQ = @[rt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}