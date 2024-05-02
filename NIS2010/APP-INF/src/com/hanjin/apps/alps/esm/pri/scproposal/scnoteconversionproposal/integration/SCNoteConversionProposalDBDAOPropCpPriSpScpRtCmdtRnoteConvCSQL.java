/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SCNoteConversionProposalDBDAOPropCpPriSpScpRtCmdtRnoteConvCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.12.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPropCpPriSpScpRtCmdtRnoteConvCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SP_SCP_RT_CMDT_RNOTE Conversion Copy
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPropCpPriSpScpRtCmdtRnoteConvCSQL(){
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
		params.put("srate_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grate_chk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPropCpPriSpScpRtCmdtRnoteConvCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SC_NOTE_CONV (" ).append("\n"); 
		query.append("	NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(",	NOTE_CONV_SEQ" ).append("\n"); 
		query.append(",	NOTE_CONV_TP_CD" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	NOTE_HDR_SEQ" ).append("\n"); 
		query.append(",	PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	CHG_RULE_TP_CD" ).append("\n"); 
		query.append(",	NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append(",	NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EXP_DT" ).append("\n"); 
		query.append(",	RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append(",	RT_APPL_TP_CD" ).append("\n"); 
		query.append(",	RT_OP_CD" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	FRT_RT_AMT" ).append("\n"); 
		query.append(",	PAY_TERM_CD" ).append("\n"); 
		query.append(",	GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",	BKG_RAT_UT_CD" ).append("\n"); 
		query.append(",	BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	BKG_CMDT_TP_CD" ).append("\n"); 
		query.append(",	BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append(",	BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append(",	BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append(",	BKG_POR_TP_CD" ).append("\n"); 
		query.append(",	BKG_POR_DEF_CD" ).append("\n"); 
		query.append(",	BKG_POL_TP_CD" ).append("\n"); 
		query.append(",	BKG_POL_DEF_CD" ).append("\n"); 
		query.append(",	BKG_POD_TP_CD" ).append("\n"); 
		query.append(",	BKG_POD_DEF_CD" ).append("\n"); 
		query.append(",	BKG_DEL_TP_CD" ).append("\n"); 
		query.append(",	BKG_DEL_DEF_CD" ).append("\n"); 
		query.append(",	BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",	BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",	BKG_SLAN_CD" ).append("\n"); 
		query.append(",	BKG_VSL_CD" ).append("\n"); 
		query.append(",	BKG_SKD_VOY_NO" ).append("\n"); 
		query.append(",	BKG_SKD_DIR_CD" ).append("\n"); 
		query.append(",	BKG_SOC_FLG" ).append("\n"); 
		query.append(",	BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",	BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append(",	BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append(",	BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append(",	BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append(",	BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append(",	CONV_RAT_UT_CD" ).append("\n"); 
		query.append(",	CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	CONV_CMDT_TP_CD" ).append("\n"); 
		query.append(",	CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append(",	CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append(",	CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append(",	CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append(",	CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append(",	CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append(",	CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append(",	CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append(",	CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append(",	CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append(",	CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	BKG_IO_GA_CD" ).append("\n"); 
		query.append(",	BKG_CNL_TZ_CD" ).append("\n"); 
		query.append(",	BKG_ESVC_TP_CD" ).append("\n"); 
		query.append(", 	RULE_APPL_CHG_CD" ).append("\n"); 
		query.append(", 	RT_PATT_TP_CD" ).append("\n"); 
		query.append(", 	IGN_TRF_FLG" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH CMDT_HDR AS (" ).append("\n"); 
		query.append("    SELECT A.PROP_NO" ).append("\n"); 
		query.append("         , A.AMDT_SEQ" ).append("\n"); 
		query.append("         , A.SVC_SCP_CD" ).append("\n"); 
		query.append("         , A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("         , A.CMDT_HDR_SEQ AS OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                              ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.BLET_DP_SEQ, A.CMDT_HDR_SEQ) AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    FROM PRI_SP_SCP_RT_CMDT_HDR A" ).append("\n"); 
		query.append("    WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND ( A.GEN_SPCL_RT_TP_CD = DECODE ( @[grate_chk], '1', 'G', '' )" ).append("\n"); 
		query.append("    OR    A.GEN_SPCL_RT_TP_CD = DECODE ( @[srate_chk], '1', 'S', '' ) )" ).append("\n"); 
		query.append("    AND   (" ).append("\n"); 
		query.append("        EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_CMDT B" ).append("\n"); 
		query.append("            WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("            AND B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("            AND B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND B.GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("              FROM PRI_SP_SCP_RT_ACT_CUST C" ).append("\n"); 
		query.append("             WHERE C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("               AND C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("               AND C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("               AND C.GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("               AND C.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND C.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("              FROM PRI_SP_SCP_RT_CNOTE D" ).append("\n"); 
		query.append("             WHERE D.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("               AND D.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("               AND D.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("               AND D.GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("               AND D.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND D.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_CMDT_ROUT E" ).append("\n"); 
		query.append("            WHERE E.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("            AND   E.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   E.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   E.GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   E.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   (" ).append("\n"); 
		query.append("                EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SP_SCP_RT_ROUT_PNT F" ).append("\n"); 
		query.append("                    WHERE F.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND F.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND F.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND F.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND F.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND F.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND F.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SP_SCP_RT_ROUT_VIA G" ).append("\n"); 
		query.append("                    WHERE G.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND G.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND G.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND G.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND G.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND G.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND G.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SP_SCP_RT_ROUT_DIR H" ).append("\n"); 
		query.append("                    WHERE H.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND H.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND H.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND H.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND H.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND H.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND H.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SP_SCP_RT_CMDT_RNOTE I" ).append("\n"); 
		query.append("                    WHERE I.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND I.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND I.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND I.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND I.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND I.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND I.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SP_SCP_RT J" ).append("\n"); 
		query.append("                    WHERE J.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND J.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND J.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND J.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND J.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND J.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND J.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CMDT_ROUT AS (" ).append("\n"); 
		query.append("    SELECT L.PROP_NO" ).append("\n"); 
		query.append("         , L.AMDT_SEQ" ).append("\n"); 
		query.append("         , L.SVC_SCP_CD" ).append("\n"); 
		query.append("         , L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("         , K.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , K.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , L.ROUT_SEQ AS OLD_ROUT_SEQ" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY L.PROP_NO, L.AMDT_SEQ, L.SVC_SCP_CD, L.GEN_SPCL_RT_TP_CD, K.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ORDER BY L.PROP_NO, L.AMDT_SEQ, L.SVC_SCP_CD, L.GEN_SPCL_RT_TP_CD, K.OLD_CMDT_HDR_SEQ, L.ROUT_SEQ) AS ROUT_SEQ" ).append("\n"); 
		query.append("    FROM CMDT_HDR K" ).append("\n"); 
		query.append("        ,PRI_SP_SCP_RT_CMDT_ROUT L" ).append("\n"); 
		query.append("    WHERE L.PROP_NO = K.PROP_NO" ).append("\n"); 
		query.append("    AND   L.AMDT_SEQ = K.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   L.SVC_SCP_CD = K.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   L.GEN_SPCL_RT_TP_CD = K.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND   L.CMDT_HDR_SEQ = K.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND   (" ).append("\n"); 
		query.append("        EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_ROUT_PNT M" ).append("\n"); 
		query.append("            WHERE M.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   M.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   M.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   M.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   M.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   M.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   M.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_ROUT_VIA N" ).append("\n"); 
		query.append("            WHERE N.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   N.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   N.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   N.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   N.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   N.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   N.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_ROUT_DIR O" ).append("\n"); 
		query.append("            WHERE O.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   O.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   O.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   O.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   O.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   O.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   O.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_CMDT_RNOTE P" ).append("\n"); 
		query.append("            WHERE P.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   P.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   P.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   P.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   P.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   P.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   P.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT Q" ).append("\n"); 
		query.append("            WHERE Q.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   Q.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   Q.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   Q.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   Q.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   Q.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   Q.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", PRE_CONV AS (" ).append("\n"); 
		query.append("    SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("         , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("         , S.SVC_SCP_CD" ).append("\n"); 
		query.append("         , S.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("         , R.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , R.ROUT_SEQ" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY S.PROP_NO, S.AMDT_SEQ, S.SVC_SCP_CD, S.GEN_SPCL_RT_TP_CD, R.CMDT_HDR_SEQ, R.ROUT_SEQ" ).append("\n"); 
		query.append("                              ORDER BY S.PROP_NO, S.AMDT_SEQ, S.SVC_SCP_CD, S.GEN_SPCL_RT_TP_CD, R.CMDT_HDR_SEQ, R.ROUT_SEQ, S.ROUT_NOTE_SEQ) AS ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("         , S.NOTE_CLSS_CD" ).append("\n"); 
		query.append("         , S.CHG_CD" ).append("\n"); 
		query.append("         , S.NOTE_CTNT" ).append("\n"); 
		query.append("         , S.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("    FROM CMDT_ROUT R" ).append("\n"); 
		query.append("        ,PRI_SP_SCP_RT_CMDT_RNOTE S" ).append("\n"); 
		query.append("    WHERE S.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("    AND   S.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   S.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   S.GEN_SPCL_RT_TP_CD = R.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND   S.CMDT_HDR_SEQ = R.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND   S.ROUT_SEQ = R.OLD_ROUT_SEQ" ).append("\n"); 
		query.append("    AND   S.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", NEW_CONV AS (" ).append("\n"); 
		query.append("    SELECT T.PROP_NO" ).append("\n"); 
		query.append("         , T.AMDT_SEQ" ).append("\n"); 
		query.append("         , T.SVC_SCP_CD" ).append("\n"); 
		query.append("         , T.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("         , T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , T.ROUT_SEQ" ).append("\n"); 
		query.append("         , T.NOTE_CONV_MAPG_ID AS OLD_CONV_MAPG_ID" ).append("\n"); 
		query.append("         , U.NOTE_CONV_MAPG_ID AS NEW_CONV_MAPG_ID" ).append("\n"); 
		query.append("    FROM PRE_CONV T" ).append("\n"); 
		query.append("       , PRI_SP_SCP_RT_CMDT_RNOTE U" ).append("\n"); 
		query.append("    WHERE U.PROP_NO           = T.PROP_NO" ).append("\n"); 
		query.append("    AND   U.AMDT_SEQ          = T.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   U.SVC_SCP_CD        = T.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   U.GEN_SPCL_RT_TP_CD = T.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    AND   U.CMDT_HDR_SEQ      = T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND   U.ROUT_SEQ          = T.ROUT_SEQ" ).append("\n"); 
		query.append("    AND   U.ROUT_NOTE_SEQ     = T.ROUT_NOTE_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT W.NEW_CONV_MAPG_ID AS NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (PARTITION BY V.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                          ORDER BY V.NOTE_CONV_MAPG_ID, V.NOTE_CONV_SEQ) AS NOTE_CONV_SEQ" ).append("\n"); 
		query.append("     , V.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("     , W.SVC_SCP_CD" ).append("\n"); 
		query.append("     , V.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("     , W.PROP_NO" ).append("\n"); 
		query.append("     , W.AMDT_SEQ" ).append("\n"); 
		query.append("     , V.CHG_RULE_TP_CD" ).append("\n"); 
		query.append("     , V.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("     , V.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("     , TO_DATE('99991231', 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_DATE('99991231', 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("     , V.RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("     , V.RT_APPL_TP_CD" ).append("\n"); 
		query.append("     , V.RT_OP_CD" ).append("\n"); 
		query.append("     , V.CURR_CD" ).append("\n"); 
		query.append("     , V.FRT_RT_AMT" ).append("\n"); 
		query.append("     , V.PAY_TERM_CD" ).append("\n"); 
		query.append("     , V.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("     , V.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , V.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("     , V.BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("     , V.BKG_POR_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_POL_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_POD_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_DEL_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , V.BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , V.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("     , V.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("     , V.BKG_SLAN_CD" ).append("\n"); 
		query.append("     , V.BKG_VSL_CD" ).append("\n"); 
		query.append("     , V.BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("     , V.BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("     , V.BKG_SOC_FLG" ).append("\n"); 
		query.append("     , V.BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("     , V.BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append("     , V.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("     , V.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("     , V.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("     , V.BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("     , V.CONV_RAT_UT_CD" ).append("\n"); 
		query.append("     , V.CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , V.CONV_CMDT_TP_CD" ).append("\n"); 
		query.append("     , V.CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , V.CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append("     , V.CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("     , V.CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("     , V.CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("     , V.CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("     , V.CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("     , V.CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append("     , V.CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("     , V.CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , V.CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , V.BKG_IO_GA_CD" ).append("\n"); 
		query.append("     , V.BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("     , V.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("	 , V.RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("	 , V.RT_PATT_TP_CD" ).append("\n"); 
		query.append("	 , V.IGN_TRF_FLG" ).append("\n"); 
		query.append("	 , V.BKG_NO" ).append("\n"); 
		query.append("FROM PRI_SC_NOTE_CONV V" ).append("\n"); 
		query.append("   , NEW_CONV W" ).append("\n"); 
		query.append("WHERE V.NOTE_CONV_MAPG_ID = W.OLD_CONV_MAPG_ID" ).append("\n"); 

	}
}