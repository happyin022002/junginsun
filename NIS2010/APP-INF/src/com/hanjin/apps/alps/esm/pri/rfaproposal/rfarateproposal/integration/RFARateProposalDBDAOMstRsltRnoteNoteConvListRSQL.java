/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFARateProposalDBDAOMstRsltRnoteNoteConvListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOMstRsltRnoteNoteConvListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA에서 Conversion 데이터 조회
	  * </pre>
	  */
	public RFARateProposalDBDAOMstRsltRnoteNoteConvListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOMstRsltRnoteNoteConvListRSQL").append("\n"); 
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
		query.append("SELECT A.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("      ,A.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("      ,A.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("      ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,A.PROP_NO" ).append("\n"); 
		query.append("      ,A.AMDT_SEQ" ).append("\n"); 
		query.append("      ,CASE" ).append("\n"); 
		query.append("         WHEN A.CHG_RULE_TP_CD = 'C' THEN" ).append("\n"); 
		query.append("          NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("         WHEN A.CHG_RULE_TP_CD = 'R' THEN" ).append("\n"); 
		query.append("          NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("       END CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("      ,A.CHG_RULE_TP_CD" ).append("\n"); 
		query.append("      ,A.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("      ,A.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(EFF_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("         WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = A.SVC_SCP_CD) AS EFF_DT" ).append("\n"); 
		query.append("      ,(SELECT CASE" ).append("\n"); 
		query.append("                 WHEN M.AMDT_SEQ = A.AMDT_SEQ THEN" ).append("\n"); 
		query.append("                  TO_CHAR(M.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                 WHEN M.EFF_DT <= N.EXP_DT THEN" ).append("\n"); 
		query.append("                  TO_CHAR(M.EFF_DT - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                  TO_CHAR(N.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("               END AS EXP_DT" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_MN M, PRI_RP_SCP_MN N" ).append("\n"); 
		query.append("         WHERE M.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND N.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND M.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND N.AMDT_SEQ = M.AMDT_SEQ - DECODE(@[amdt_seq], A.AMDT_SEQ, 0, 0, 0, 1)" ).append("\n"); 
		query.append("           AND M.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND N.SVC_SCP_CD = A.SVC_SCP_CD) AS EXP_DT" ).append("\n"); 
		query.append("      ,A.RT_APPL_TP_CD" ).append("\n"); 
		query.append("      ,A.RT_OP_CD" ).append("\n"); 
		query.append("      ,A.CURR_CD" ).append("\n"); 
		query.append("      ,A.FRT_RT_AMT" ).append("\n"); 
		query.append("      ,A.PAY_TERM_CD" ).append("\n"); 
		query.append("      ,A.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("      ,A.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("      ,A.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("      ,A.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("      ,A.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("      ,A.BKG_POR_TP_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POR_TP_CD, 'T', SUBSTR(A.BKG_POR_DEF_CD, 3), A.BKG_POR_DEF_CD) BKG_POR_DEF_CD" ).append("\n"); 
		query.append("	  , A.BKG_POL_TP_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POL_TP_CD, 'T', SUBSTR(A.BKG_POL_DEF_CD, 3), A.BKG_POL_DEF_CD) BKG_POL_DEF_CD" ).append("\n"); 
		query.append("	  , A.BKG_POD_TP_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POD_TP_CD, 'T', SUBSTR(A.BKG_POD_DEF_CD, 3), A.BKG_POD_DEF_CD) BKG_POD_DEF_CD" ).append("\n"); 
		query.append("	  , A.BKG_DEL_TP_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_DEL_TP_CD, 'T', SUBSTR(A.BKG_DEL_DEF_CD, 3), A.BKG_DEL_DEF_CD) BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("      ,A.BKG_SLAN_CD" ).append("\n"); 
		query.append("      ,(A.BKG_VSL_CD || A.BKG_SKD_VOY_NO || A.BKG_SKD_DIR_CD) BKG_VVD_CD" ).append("\n"); 
		query.append("      ,A.BKG_VSL_CD" ).append("\n"); 
		query.append("      ,A.BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.BKG_SOC_FLG" ).append("\n"); 
		query.append("      ,A.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("      ,A.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,A.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("      ,A.BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("      ,A.BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("      ,A.BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.UPD_DT, 'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("      ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) USR_NM" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POR_TP_CD, 'T', SUBSTR(A.BKG_POR_DEF_CD, 1, 2), '') BKG_POR_CNT_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POL_TP_CD, 'T', SUBSTR(A.BKG_POL_DEF_CD, 1, 2), '') BKG_POL_CNT_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_POD_TP_CD, 'T', SUBSTR(A.BKG_POD_DEF_CD, 1, 2), '') BKG_POD_CNT_CD" ).append("\n"); 
		query.append("	  , DECODE(A.BKG_DEL_TP_CD, 'T', SUBSTR(A.BKG_DEL_DEF_CD, 1, 2), '') BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("      ,A.BKG_YD_CD" ).append("\n"); 
		query.append("      ,A.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD01719'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = PRC_PROG_STS_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS PRC_PROG_STS_NM" ).append("\n"); 
		query.append("      ,SRC_INFO_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD02198'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = SRC_INFO_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS SRC_INFO_NM" ).append("\n"); 
		query.append("      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("          ,NOTE_CONV_SEQ" ).append("\n"); 
		query.append("          ,NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("          ,SVC_SCP_CD" ).append("\n"); 
		query.append("          ,PROP_NO" ).append("\n"); 
		query.append("          ,AMDT_SEQ" ).append("\n"); 
		query.append("          ,CHG_RULE_TP_CD" ).append("\n"); 
		query.append("          ,NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("          ,NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("          ,EFF_DT" ).append("\n"); 
		query.append("          ,EXP_DT" ).append("\n"); 
		query.append("          ,RT_APPL_TP_CD" ).append("\n"); 
		query.append("          ,RT_OP_CD" ).append("\n"); 
		query.append("          ,CURR_CD" ).append("\n"); 
		query.append("          ,FRT_RT_AMT" ).append("\n"); 
		query.append("          ,PAY_TERM_CD" ).append("\n"); 
		query.append("          ,BKG_RAT_UT_CD" ).append("\n"); 
		query.append("          ,BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("          ,BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("          ,BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("          ,BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("          ,BKG_POR_TP_CD" ).append("\n"); 
		query.append("          ,BKG_POR_DEF_CD" ).append("\n"); 
		query.append("          ,BKG_POL_TP_CD" ).append("\n"); 
		query.append("          ,BKG_POL_DEF_CD" ).append("\n"); 
		query.append("          ,BKG_POD_TP_CD" ).append("\n"); 
		query.append("          ,BKG_POD_DEF_CD" ).append("\n"); 
		query.append("          ,BKG_DEL_TP_CD" ).append("\n"); 
		query.append("          ,BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("          ,BKG_SLAN_CD" ).append("\n"); 
		query.append("          ,BKG_VSL_CD" ).append("\n"); 
		query.append("          ,BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("          ,BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("          ,BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("          ,BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("          ,BKG_SOC_FLG" ).append("\n"); 
		query.append("          ,BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("          ,BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("          ,BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("          ,BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("          ,CRE_USR_ID" ).append("\n"); 
		query.append("          ,CRE_DT" ).append("\n"); 
		query.append("          ,UPD_USR_ID" ).append("\n"); 
		query.append("          ,UPD_DT" ).append("\n"); 
		query.append("          ,BKG_YD_CD" ).append("\n"); 
		query.append("          ,BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("          ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("          ,MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("          ,SRC_INFO_CD" ).append("\n"); 
		query.append("          ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("          ,LEAD(N1ST_CMNC_AMDT_SEQ) OVER(PARTITION BY PROP_NO, SVC_SCP_CD, NOTE_CONV_SEQ ORDER BY AMDT_SEQ) AS NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      FROM PRI_RFA_NOTE_CONV CONV" ).append("\n"); 
		query.append("     WHERE NOTE_CONV_TP_CD = 'R'" ).append("\n"); 
		query.append("       AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("              FROM PRI_RP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("             WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("               AND (AMDT_SEQ = @[amdt_seq] OR" ).append("\n"); 
		query.append("                   (AMDT_SEQ = @[amdt_seq] - 1 AND" ).append("\n"); 
		query.append("                   SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM')))" ).append("\n"); 
		query.append("               AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("               AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("               AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("               AND NOTE_CONV_MAPG_ID = CONV.NOTE_CONV_MAPG_ID))A" ).append("\n"); 
		query.append(" WHERE NEXT_N1ST_CMNC_AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("    OR N1ST_CMNC_AMDT_SEQ <> NEXT_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(" ORDER BY CHG_RULE_DEF_CD, NOTE_CONV_SEQ, AMDT_SEQ" ).append("\n"); 

	}
}