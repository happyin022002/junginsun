/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAOPropCpPriSpScpRtRoutViaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.12
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2010.07.12 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPropCpPriSpScpRtRoutViaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Scope Copy PRI_SP_SCP_RT_ROUT_VIA Insert
	  * </pre>
	  */
	public SCRateProposalDBDAOPropCpPriSpScpRtRoutViaCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("grate_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPropCpPriSpScpRtRoutViaCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_RT_ROUT_VIA (" ).append("\n"); 
		query.append("      PROP_NO" ).append("\n"); 
		query.append("    , AMDT_SEQ" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    , ROUT_SEQ" ).append("\n"); 
		query.append("    , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("    , ROUT_VIA_SEQ" ).append("\n"); 
		query.append("    , ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("    , ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("    , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("    , SRC_INFO_CD" ).append("\n"); 
		query.append("    , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
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
		query.append("            AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   B.GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_ACT_CUST C" ).append("\n"); 
		query.append("            WHERE C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("            AND   C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   C.GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   C.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   C.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_CNOTE D" ).append("\n"); 
		query.append("            WHERE D.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("            AND   D.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   D.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   D.GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   D.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   D.SRC_INFO_CD <> 'AD'" ).append("\n"); 
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
		query.append("                    AND   F.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND   F.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND   F.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND   F.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   F.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND   F.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SP_SCP_RT_ROUT_VIA G" ).append("\n"); 
		query.append("                    WHERE G.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND   G.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND   G.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND   G.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND   G.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   G.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND   G.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SP_SCP_RT_ROUT_DIR H" ).append("\n"); 
		query.append("                    WHERE H.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND   H.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND   H.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND   H.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND   H.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   H.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND   H.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SP_SCP_RT_CMDT_RNOTE I" ).append("\n"); 
		query.append("                    WHERE I.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND   I.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND   I.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND   I.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND   I.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   I.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND   I.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SP_SCP_RT J" ).append("\n"); 
		query.append("                    WHERE J.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND   J.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND   J.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND   J.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND   J.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   J.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND   J.SRC_INFO_CD <> 'AD'" ).append("\n"); 
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
		query.append("            FROM PRI_SP_SCP_RT_ROUT_PNT F" ).append("\n"); 
		query.append("            WHERE F.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   F.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   F.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   F.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   F.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   F.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   F.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_ROUT_VIA G" ).append("\n"); 
		query.append("            WHERE G.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   G.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   G.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   G.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   G.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   G.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   G.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_ROUT_DIR H" ).append("\n"); 
		query.append("            WHERE H.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   H.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   H.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   H.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   H.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   H.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   H.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_CMDT_RNOTE I" ).append("\n"); 
		query.append("            WHERE I.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   I.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   I.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   I.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   I.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   I.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   I.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT J" ).append("\n"); 
		query.append("            WHERE J.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   J.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   J.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   J.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   J.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   J.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   J.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("     , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("     , S.SVC_SCP_CD" ).append("\n"); 
		query.append("     , S.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("     , R.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , R.ROUT_SEQ" ).append("\n"); 
		query.append("     , S.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (PARTITION BY S.PROP_NO, S.AMDT_SEQ, S.SVC_SCP_CD, S.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                     , S.CMDT_HDR_SEQ, S.ROUT_SEQ, S.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                          ORDER BY S.PROP_NO, S.AMDT_SEQ, S.SVC_SCP_CD, S.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                 , S.CMDT_HDR_SEQ, S.ROUT_SEQ, S.ORG_DEST_TP_CD, S.ROUT_VIA_SEQ) AS ROUT_VIA_SEQ" ).append("\n"); 
		query.append("     , S.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("     , S.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("     , 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , 'PC' AS SRC_INFO_CD" ).append("\n"); 
		query.append("     , 0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM CMDT_ROUT R" ).append("\n"); 
		query.append("    ,PRI_SP_SCP_RT_ROUT_VIA S" ).append("\n"); 
		query.append("WHERE S.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("AND   S.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("AND   S.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   S.GEN_SPCL_RT_TP_CD = R.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND   S.CMDT_HDR_SEQ = R.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   S.ROUT_SEQ = R.OLD_ROUT_SEQ" ).append("\n"); 
		query.append("AND   S.SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}