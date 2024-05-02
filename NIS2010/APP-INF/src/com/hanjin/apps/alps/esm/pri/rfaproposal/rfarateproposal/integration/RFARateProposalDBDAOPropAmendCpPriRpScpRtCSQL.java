/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : RFARateProposalDBDAOPropAmendCpPriRpScpRtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.30
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.08.30 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPropAmendCpPriRpScpRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Scope Copy PRI_RP_SCP_RT Insert
	  * </pre>
	  */
	public RFARateProposalDBDAOPropAmendCpPriRpScpRtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("new_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPropAmendCpPriRpScpRtCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT" ).append("\n"); 
		query.append("  (PROP_NO," ).append("\n"); 
		query.append("   AMDT_SEQ," ).append("\n"); 
		query.append("   SVC_SCP_CD," ).append("\n"); 
		query.append("   CMDT_HDR_SEQ," ).append("\n"); 
		query.append("   ROUT_SEQ," ).append("\n"); 
		query.append("   RT_SEQ," ).append("\n"); 
		query.append("   RAT_UT_CD," ).append("\n"); 
		query.append("   PRC_CGO_TP_CD," ).append("\n"); 
		query.append("   CURR_CD," ).append("\n"); 
		query.append("   PROP_FRT_RT_AMT," ).append("\n"); 
		query.append("   BZC_OFRT_RT_AMT," ).append("\n"); 
		query.append("   ORG_ARB_AMT," ).append("\n"); 
		query.append("   RAIL_HUB_LOC_CD," ).append("\n"); 
		query.append("   DEST_ARB_AMT," ).append("\n"); 
		query.append("   DOR_TRKA_AMT," ).append("\n"); 
		query.append("   VSL_SLAN_CD," ).append("\n"); 
		query.append("   GRI_APPL_TP_CD," ).append("\n"); 
		query.append("   GRI_APPL_AMT," ).append("\n"); 
		query.append("   PRC_PROG_STS_CD," ).append("\n"); 
		query.append("   SRC_INFO_CD," ).append("\n"); 
		query.append("   N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT," ).append("\n"); 
		query.append("   FIC_PROP_RT_AMT," ).append("\n"); 
		query.append("   FIC_GLINE_RT_AMT," ).append("\n"); 
		query.append("   FIC_GLINE_UPD_DT," ).append("\n"); 
		query.append("   OPTM_TRSP_MOD_FLG," ).append("\n"); 
		query.append("   FIC_RT_USE_STS_CD,   " ).append("\n"); 
		query.append("   FIC_DEST_RT_USE_STS_CD, " ).append("\n"); 
		query.append("   FIC_DEST_PROP_RT_AMT,   " ).append("\n"); 
		query.append("   FIC_DEST_GLINE_RT_AMT,  " ).append("\n"); 
		query.append("   FIC_DEST_GLINE_UPD_DT,  " ).append("\n"); 
		query.append("   DEST_OPTM_TRSP_MOD_FLG, " ).append("\n"); 
		query.append("   FIC_ORG_RT_USE_STS_CD,  " ).append("\n"); 
		query.append("   FIC_ORG_PROP_RT_AMT,    " ).append("\n"); 
		query.append("   FIC_ORG_GLINE_RT_AMT,   " ).append("\n"); 
		query.append("   FIC_ORG_GLINE_UPD_DT,   " ).append("\n"); 
		query.append("   ORG_OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append(",  MST_RFA_ROUT_ID			--------- RFA 효율화를 위한 요청 (1차) (CHM-201640671) " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WITH CMDT_ROUT AS (" ).append("\n"); 
		query.append("    SELECT L.PROP_NO" ).append("\n"); 
		query.append("         , L.AMDT_SEQ" ).append("\n"); 
		query.append("         , L.SVC_SCP_CD" ).append("\n"); 
		query.append("         , L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , L.ROUT_SEQ " ).append("\n"); 
		query.append("         , L.MST_ROUT_ID" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_RT_CMDT_ROUT L" ).append("\n"); 
		query.append("    WHERE     L.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND   L.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND   L.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	AND   L.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("	AND   L.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("	    AND   (" ).append("\n"); 
		query.append("		EXISTS (" ).append("\n"); 
		query.append("		    SELECT 'X'" ).append("\n"); 
		query.append("		    FROM PRI_RP_SCP_RT_ROUT_PNT F" ).append("\n"); 
		query.append("		    WHERE F.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("		    AND   F.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("		    AND   F.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("		    AND   F.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		    AND   F.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("		    AND   F.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		OR EXISTS (" ).append("\n"); 
		query.append("		    SELECT 'X'" ).append("\n"); 
		query.append("		    FROM PRI_RP_SCP_RT_ROUT_VIA G" ).append("\n"); 
		query.append("		    WHERE G.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("		    AND   G.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("		    AND   G.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("		    AND   G.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		    AND   G.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("		    AND   G.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		OR EXISTS (" ).append("\n"); 
		query.append("		    SELECT 'X'" ).append("\n"); 
		query.append("		    FROM PRI_RP_SCP_RT_CMDT_RNOTE I" ).append("\n"); 
		query.append("		    WHERE I.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("		    AND   I.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("		    AND   I.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("		    AND   I.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		    AND   I.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("		    AND   I.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		OR EXISTS (" ).append("\n"); 
		query.append("		    SELECT 'X'" ).append("\n"); 
		query.append("		    FROM PRI_RP_SCP_RT J" ).append("\n"); 
		query.append("		    WHERE J.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("		    AND   J.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("		    AND   J.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("		    AND   J.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		    AND   J.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("		    AND   J.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO," ).append("\n"); 
		query.append("       @[new_amdt_seq]+1  AS AMDT_SEQ," ).append("\n"); 
		query.append("       S.SVC_SCP_CD," ).append("\n"); 
		query.append("       S.CMDT_HDR_SEQ," ).append("\n"); 
		query.append("       @[new_rout_seq] ROUT_SEQ," ).append("\n"); 
		query.append("       S.RT_SEQ," ).append("\n"); 
		query.append("       S.RAT_UT_CD," ).append("\n"); 
		query.append("       S.PRC_CGO_TP_CD," ).append("\n"); 
		query.append("       S.CURR_CD," ).append("\n"); 
		query.append("       S.FNL_FRT_RT_AMT AS PROP_FRT_RT_AMT," ).append("\n"); 
		query.append("       S.BZC_OFRT_RT_AMT," ).append("\n"); 
		query.append("       S.ORG_ARB_AMT," ).append("\n"); 
		query.append("       S.RAIL_HUB_LOC_CD," ).append("\n"); 
		query.append("       S.DEST_ARB_AMT," ).append("\n"); 
		query.append("       S.DOR_TRKA_AMT," ).append("\n"); 
		query.append("       S.VSL_SLAN_CD," ).append("\n"); 
		query.append("       'N' AS GRI_APPL_TP_CD," ).append("\n"); 
		query.append("       @[new_amdt_seq]+1  AS GRI_APPL_AMT," ).append("\n"); 
		query.append("       'I' AS PRC_PROG_STS_CD," ).append("\n"); 
		query.append("       'NW' AS SRC_INFO_CD," ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("       @[new_amdt_seq]+1 AS N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("       @[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("       SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("       @[upd_usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("       SYSDATE AS UPD_DT," ).append("\n"); 
		query.append("       S.FIC_FNL_RT_AMT  AS FIC_PROP_RT_AMT," ).append("\n"); 
		query.append("       S.FIC_GLINE_RT_AMT," ).append("\n"); 
		query.append("       S.FIC_GLINE_UPD_DT," ).append("\n"); 
		query.append("       S.OPTM_TRSP_MOD_FLG," ).append("\n"); 
		query.append("       S.FIC_RT_USE_STS_CD,       " ).append("\n"); 
		query.append("       S.FIC_DEST_RT_USE_STS_CD, " ).append("\n"); 
		query.append("       S.FIC_DEST_FNL_RT_AMT  AS FIC_DEST_PROP_RT_AMT, " ).append("\n"); 
		query.append("       S.FIC_DEST_GLINE_RT_AMT,  " ).append("\n"); 
		query.append("       S.FIC_DEST_GLINE_UPD_DT,  " ).append("\n"); 
		query.append("       S.DEST_OPTM_TRSP_MOD_FLG, " ).append("\n"); 
		query.append("       S.FIC_ORG_RT_USE_STS_CD,  " ).append("\n"); 
		query.append("       S.FIC_ORG_FNL_RT_AMT AS FIC_ORG_PROP_RT_AMT,  " ).append("\n"); 
		query.append("       S.FIC_ORG_GLINE_RT_AMT,   " ).append("\n"); 
		query.append("       S.FIC_ORG_GLINE_UPD_DT,   " ).append("\n"); 
		query.append("       S.ORG_OPTM_TRSP_MOD_FLG       " ).append("\n"); 
		query.append("	  ,CASE WHEN @[mst_rfa_no] IS NULL THEN S.MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("            ELSE @[mst_rfa_no] ||'_'|| LPAD(@[amdt_seq], 3, '0') ||'_'|| LPAD(MST_ROUT_ID, 3, '0')" ).append("\n"); 
		query.append("       END AS MST_RFA_ROUT_ID         ---------------- RFA 효율화를 위한 요청 (1차) (CHM-201640671) " ).append("\n"); 
		query.append("  FROM CMDT_ROUT     R" ).append("\n"); 
		query.append("	,PRI_RP_SCP_RT S" ).append("\n"); 
		query.append(" WHERE " ).append("\n"); 
		query.append("	 S.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND   S.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND   S.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	AND   S.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("	AND   S.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("	AND   S.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("	AND   S.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("        AND   S.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   S.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   S.CMDT_HDR_SEQ = R.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   S.ROUT_SEQ = R.ROUT_SEQ" ).append("\n"); 

	}
}