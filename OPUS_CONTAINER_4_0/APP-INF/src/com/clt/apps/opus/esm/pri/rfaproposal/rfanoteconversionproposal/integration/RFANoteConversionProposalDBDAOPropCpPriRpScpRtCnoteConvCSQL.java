/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFANoteConversionProposalDBDAOPropCpPriRpScpRtCnoteConvCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteConversionProposalDBDAOPropCpPriRpScpRtCnoteConvCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_RP_SCP_RT_CNOTE Conversion Copy
	  * </pre>
	  */
	public RFANoteConversionProposalDBDAOPropCpPriRpScpRtCnoteConvCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration").append("\n"); 
		query.append("FileName : RFANoteConversionProposalDBDAOPropCpPriRpScpRtCnoteConvCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RFA_NOTE_CONV (" ).append("\n"); 
		query.append("      NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("    , NOTE_CONV_SEQ" ).append("\n"); 
		query.append("    , NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , PROP_NO" ).append("\n"); 
		query.append("    , AMDT_SEQ" ).append("\n"); 
		query.append("    , CHG_RULE_TP_CD" ).append("\n"); 
		query.append("    , NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("    , NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("    , EFF_DT" ).append("\n"); 
		query.append("    , EXP_DT" ).append("\n"); 
		query.append("    , RT_APPL_TP_CD" ).append("\n"); 
		query.append("    , RT_OP_CD" ).append("\n"); 
		query.append("    , CURR_CD" ).append("\n"); 
		query.append("    , FRT_RT_AMT" ).append("\n"); 
		query.append("    , PAY_TERM_CD" ).append("\n"); 
		query.append("    , BKG_RAT_UT_CD" ).append("\n"); 
		query.append("    , BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("    , BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("    , BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("    , BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("    , BKG_POR_TP_CD" ).append("\n"); 
		query.append("    , BKG_POR_DEF_CD" ).append("\n"); 
		query.append("    , BKG_POL_TP_CD" ).append("\n"); 
		query.append("    , BKG_POL_DEF_CD" ).append("\n"); 
		query.append("    , BKG_POD_TP_CD" ).append("\n"); 
		query.append("    , BKG_POD_DEF_CD" ).append("\n"); 
		query.append("    , BKG_DEL_TP_CD" ).append("\n"); 
		query.append("    , BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("    , BKG_SLAN_CD" ).append("\n"); 
		query.append("    , BKG_VSL_CD" ).append("\n"); 
		query.append("    , BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("    , BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("    , BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("    , BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("    , BKG_SOC_FLG" ).append("\n"); 
		query.append("    , BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("    , BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("    , BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("    , BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , BKG_YD_CD" ).append("\n"); 
		query.append("    , BKG_ESVC_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH CMDT_HDR AS (" ).append("\n"); 
		query.append("    SELECT A.PROP_NO" ).append("\n"); 
		query.append("         , A.AMDT_SEQ" ).append("\n"); 
		query.append("         , A.SVC_SCP_CD" ).append("\n"); 
		query.append("         , A.CMDT_HDR_SEQ AS OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD" ).append("\n"); 
		query.append("                              ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.BLET_DP_SEQ, A.CMDT_HDR_SEQ) AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_RT_CMDT_HDR A" ).append("\n"); 
		query.append("    WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND   (" ).append("\n"); 
		query.append("        EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT_CMDT B" ).append("\n"); 
		query.append("            WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("            AND B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("            AND B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("              FROM PRI_RP_SCP_RT_ACT_CUST C" ).append("\n"); 
		query.append("             WHERE C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("               AND C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("               AND C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("               AND C.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND C.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("              FROM PRI_RP_SCP_RT_CNOTE D" ).append("\n"); 
		query.append("             WHERE D.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("               AND D.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("               AND D.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("               AND D.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND D.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT_CMDT_ROUT E" ).append("\n"); 
		query.append("            WHERE E.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("            AND   E.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   E.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   E.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   (" ).append("\n"); 
		query.append("                EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_RP_SCP_RT_ROUT_PNT F" ).append("\n"); 
		query.append("                    WHERE F.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND F.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND F.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND F.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND F.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND F.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_RP_SCP_RT_ROUT_VIA G" ).append("\n"); 
		query.append("                    WHERE G.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND G.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND G.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND G.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND G.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND G.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_RP_SCP_RT_CMDT_RNOTE I" ).append("\n"); 
		query.append("                    WHERE I.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND I.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND I.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND I.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND I.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND I.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_RP_SCP_RT J" ).append("\n"); 
		query.append("                    WHERE J.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND J.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND J.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND J.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND J.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND J.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", PRE_CONV AS (" ).append("\n"); 
		query.append("    SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("         , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("         , B.SVC_SCP_CD" ).append("\n"); 
		query.append("         , A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY B.PROP_NO, B.AMDT_SEQ, B.SVC_SCP_CD, B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ORDER BY B.PROP_NO, B.AMDT_SEQ, B.SVC_SCP_CD, B.CMDT_HDR_SEQ, B.CMDT_NOTE_SEQ) AS CMDT_NOTE_SEQ" ).append("\n"); 
		query.append("         , B.NOTE_CTNT" ).append("\n"); 
		query.append("         , B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("         , B.NOTE_CHG_TP_CD" ).append("\n"); 
		query.append("         , 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append("         , 'PC' AS SRC_INFO_CD" ).append("\n"); 
		query.append("         , 0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("         , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("         , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("         , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("         , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("    FROM CMDT_HDR A" ).append("\n"); 
		query.append("        ,PRI_RP_SCP_RT_CNOTE B" ).append("\n"); 
		query.append("    WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("    AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   B.CMDT_HDR_SEQ = A.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND   B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", NEW_CONV AS (" ).append("\n"); 
		query.append("    SELECT C.PROP_NO" ).append("\n"); 
		query.append("         , C.AMDT_SEQ" ).append("\n"); 
		query.append("         , C.SVC_SCP_CD" ).append("\n"); 
		query.append("         , C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , C.CMDT_NOTE_SEQ" ).append("\n"); 
		query.append("         , C.NOTE_CONV_MAPG_ID AS OLD_CONV_MAPG_ID" ).append("\n"); 
		query.append("         , D.NOTE_CONV_MAPG_ID AS NEW_CONV_MAPG_ID" ).append("\n"); 
		query.append("    FROM PRE_CONV C" ).append("\n"); 
		query.append("       , PRI_RP_SCP_RT_CNOTE D" ).append("\n"); 
		query.append("    WHERE D.PROP_NO           = C.PROP_NO" ).append("\n"); 
		query.append("    AND   D.AMDT_SEQ          = C.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   D.SVC_SCP_CD        = C.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   D.CMDT_HDR_SEQ      = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND   D.CMDT_NOTE_SEQ     = C.CMDT_NOTE_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT B.NEW_CONV_MAPG_ID AS NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (PARTITION BY A.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                          ORDER BY A.NOTE_CONV_MAPG_ID, A.NOTE_CONV_SEQ) AS NOTE_CONV_SEQ" ).append("\n"); 
		query.append("     , A.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("     , B.SVC_SCP_CD" ).append("\n"); 
		query.append("     , B.PROP_NO" ).append("\n"); 
		query.append("     , B.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.CHG_RULE_TP_CD" ).append("\n"); 
		query.append("     , A.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("     , A.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("     , TO_DATE('99991231', 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_DATE('99991231', 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("     , A.RT_APPL_TP_CD" ).append("\n"); 
		query.append("     , A.RT_OP_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.FRT_RT_AMT" ).append("\n"); 
		query.append("     , A.PAY_TERM_CD" ).append("\n"); 
		query.append("     , A.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("     , A.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , A.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , A.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("     , A.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , A.BKG_POR_TP_CD" ).append("\n"); 
		query.append("     , A.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("     , A.BKG_POL_TP_CD" ).append("\n"); 
		query.append("     , A.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("     , A.BKG_POD_TP_CD" ).append("\n"); 
		query.append("     , A.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("     , A.BKG_DEL_TP_CD" ).append("\n"); 
		query.append("     , A.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("     , A.BKG_SLAN_CD" ).append("\n"); 
		query.append("     , A.BKG_VSL_CD" ).append("\n"); 
		query.append("     , A.BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("     , A.BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("     , A.BKG_SOC_FLG" ).append("\n"); 
		query.append("     , A.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("     , A.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("     , A.BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , A.BKG_YD_CD" ).append("\n"); 
		query.append("     , A.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("FROM PRI_RFA_NOTE_CONV A" ).append("\n"); 
		query.append("   , NEW_CONV B" ).append("\n"); 
		query.append("WHERE A.NOTE_CONV_MAPG_ID = B.OLD_CONV_MAPG_ID" ).append("\n"); 

	}
}