/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtCmdtRoutCopyToProposalCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.06 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtCmdtRoutCopyToProposalCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriSpScpRtCmdtRoutCopyToProposal
	  * * 2015.04.06 송호진 [CHM-201534007] Fixed index 개발
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtCmdtRoutCopyToProposalCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_spcl_rt_tp_cd_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtCmdtRoutCopyToProposalCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_RT_CMDT_ROUT (" ).append("\n"); 
		query.append("      PROP_NO" ).append("\n"); 
		query.append("    , AMDT_SEQ" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("    , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    , ROUT_SEQ" ).append("\n"); 
		query.append("    , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("    , NOTE_DP_SEQ" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , FX_RT_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH CMDT_HDR AS (" ).append("\n"); 
		query.append("    SELECT A.QTTN_NO" ).append("\n"); 
		query.append("         , A.QTTN_VER_NO" ).append("\n"); 
		query.append("         , A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("         , A.CMDT_HDR_SEQ AS OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY A.QTTN_NO, A.QTTN_VER_NO, A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                              ORDER BY A.QTTN_NO, A.QTTN_VER_NO, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ) AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    FROM PRI_SQ_RT_CMDT_HDR A" ).append("\n"); 
		query.append("    WHERE A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("    AND   A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("#if (${gen_spcl_rt_tp_cd_from} != '')" ).append("\n"); 
		query.append("	AND	  A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd_from]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND   (" ).append("\n"); 
		query.append("        EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SQ_RT_CMDT B" ).append("\n"); 
		query.append("            WHERE B.QTTN_NO = A.QTTN_NO" ).append("\n"); 
		query.append("            AND B.QTTN_VER_NO = A.QTTN_VER_NO" ).append("\n"); 
		query.append("            AND B.GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_SQ_RT_CMDT_ROUT E" ).append("\n"); 
		query.append("            WHERE E.QTTN_NO = A.QTTN_NO" ).append("\n"); 
		query.append("            AND   E.QTTN_VER_NO = A.QTTN_VER_NO" ).append("\n"); 
		query.append("            AND   E.GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            AND   E.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   (" ).append("\n"); 
		query.append("                EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SQ_RT_ROUT_PNT F" ).append("\n"); 
		query.append("                    WHERE F.QTTN_NO = E.QTTN_NO" ).append("\n"); 
		query.append("                    AND F.QTTN_VER_NO = E.QTTN_VER_NO" ).append("\n"); 
		query.append("                    AND F.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND F.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND F.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SQ_RT_ROUT_VIA G" ).append("\n"); 
		query.append("                    WHERE G.QTTN_NO = E.QTTN_NO" ).append("\n"); 
		query.append("                    AND G.QTTN_VER_NO = E.QTTN_VER_NO" ).append("\n"); 
		query.append("                    AND G.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND G.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND G.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("               OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_SQ_RT J" ).append("\n"); 
		query.append("                    WHERE J.QTTN_NO = E.QTTN_NO" ).append("\n"); 
		query.append("                    AND J.QTTN_VER_NO = E.QTTN_VER_NO" ).append("\n"); 
		query.append("                    AND J.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                    AND J.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND J.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("     , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("     , Z.SVC_SCP_CD" ).append("\n"); 
		query.append("     , L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("     , K.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER (PARTITION BY L.QTTN_NO, L.QTTN_VER_NO, L.GEN_SPCL_RT_TP_CD, K.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                          ORDER BY L.QTTN_NO, L.QTTN_VER_NO, L.GEN_SPCL_RT_TP_CD, K.OLD_CMDT_HDR_SEQ, L.ROUT_SEQ) AS ROUT_SEQ" ).append("\n"); 
		query.append("     , 0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , NULL" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , 'N' AS FX_RT_FLG" ).append("\n"); 
		query.append("FROM CMDT_HDR K" ).append("\n"); 
		query.append("    ,PRI_SQ_RT_CMDT_ROUT L" ).append("\n"); 
		query.append("    ,PRI_SQ_MN Z	" ).append("\n"); 
		query.append("WHERE L.QTTN_NO = K.QTTN_NO" ).append("\n"); 
		query.append("AND   L.QTTN_VER_NO = K.QTTN_VER_NO" ).append("\n"); 
		query.append("AND   L.GEN_SPCL_RT_TP_CD = K.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND   L.CMDT_HDR_SEQ = K.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   L.QTTN_NO = Z.QTTN_NO" ).append("\n"); 
		query.append("AND   L.QTTN_VER_NO = Z.QTTN_VER_NO	" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("    EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_SQ_RT_ROUT_PNT M" ).append("\n"); 
		query.append("        WHERE M.QTTN_NO = L.QTTN_NO" ).append("\n"); 
		query.append("        AND M.QTTN_VER_NO = L.QTTN_VER_NO" ).append("\n"); 
		query.append("        AND M.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND M.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND M.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    OR EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_SQ_RT_ROUT_VIA G" ).append("\n"); 
		query.append("        WHERE G.QTTN_NO = L.QTTN_NO" ).append("\n"); 
		query.append("        AND G.QTTN_VER_NO = L.QTTN_VER_NO" ).append("\n"); 
		query.append("        AND G.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND G.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND G.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    OR EXISTS (" ).append("\n"); 
		query.append("        SELECT 'X'" ).append("\n"); 
		query.append("        FROM PRI_SQ_RT J" ).append("\n"); 
		query.append("        WHERE J.QTTN_NO = L.QTTN_NO" ).append("\n"); 
		query.append("        AND J.QTTN_VER_NO = L.QTTN_VER_NO" ).append("\n"); 
		query.append("        AND J.GEN_SPCL_RT_TP_CD = L.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND J.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND J.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}