/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : RFARateProposalDBDAOMstRoutSmryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.31
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.08.31 송민석
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

public class RFARateProposalDBDAOMstRoutSmryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic RFA가 상속한 Master RFA가 가지고 있는 Route Summary를 조회한다.
	  * isExists가 Y일때 Basic이 가지고 있는 Mst의 Route를 N일때 Basic이 없는 Mst의 Route를 조회한다.
	  * </pre>
	  */
	public RFARateProposalDBDAOMstRoutSmryListRSQL(){
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
		params.put("mst_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOMstRoutSmryListRSQL").append("\n"); 
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
		query.append("WITH MST_INFO AS (" ).append("\n"); 
		query.append("    SELECT MN.PROP_NO, MAX(MN.AMDT_SEQ) AS AMDT_SEQ, SVC_SCP_CD, HDR.RFA_NO" ).append("\n"); 
		query.append("      FROM PRI_RP_MN MN, PRI_RP_SCP_RT_CMDT_ROUT ROUT, PRI_RP_HDR HDR" ).append("\n"); 
		query.append("     WHERE MN.PROP_NO = (SELECT PROP_NO FROM PRI_RP_HDR WHERE RFA_NO = @[mst_rfa_no]) -- Mst RFA No" ).append("\n"); 
		query.append("       AND MN.PROP_NO = ROUT.PROP_NO" ).append("\n"); 
		query.append("       AND MN.AMDT_SEQ = ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("	AND MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("       AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("     GROUP BY MN.PROP_NO, SVC_SCP_CD,HDR.RFA_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	 SELECT A.PROP_NO" ).append("\n"); 
		query.append("	      , A.AMDT_SEQ" ).append("\n"); 
		query.append("	      , A.SVC_SCP_CD" ).append("\n"); 
		query.append("	      , A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	      , A.ROUT_SEQ" ).append("\n"); 
		query.append("	      , A.MST_ROUT_ID" ).append("\n"); 
		query.append("	      , B.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	      , B.RCV_DE_TERM_CD AS RCV_DE_TERM_CD_ORI" ).append("\n"); 
		query.append("	      , C.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	      , D.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	      , E.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	      , E.RCV_DE_TERM_CD AS RCV_DE_TERM_CD_DEST" ).append("\n"); 
		query.append("	      , BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("	      , BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("	      , BKG_SLAN_CD" ).append("\n"); 
		query.append("	      , BKG_VVD_CD" ).append("\n"); 
		query.append("	      , CASE WHEN NOTE_CONV_CHG_CD IS NULL" ).append("\n"); 
		query.append("		     THEN NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("		     WHEN NOTE_CONV_RULE_CD IS NULL" ).append("\n"); 
		query.append("		     THEN NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("		ELSE NOTE_CONV_RULE_CD ||','|| NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("		 END AS NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("	      , A.NOTE_DP_SEQ" ).append("\n"); 
		query.append("	      , DECODE(PREV_D2, 0, '', PREV_D2) AS PREV_D2" ).append("\n"); 
		query.append("	      , DECODE(PREV_D4, 0, '', PREV_D4) AS PREV_D4" ).append("\n"); 
		query.append("	      , DECODE(PREV_D5, 0, '', PREV_D5) AS PREV_D5" ).append("\n"); 
		query.append("	      , DECODE(CURR_D2, 0, '', CURR_D2) AS CURR_D2" ).append("\n"); 
		query.append("	      , DECODE(CURR_D4, 0, '', CURR_D4) AS CURR_D4" ).append("\n"); 
		query.append("	      , DECODE(CURR_D5, 0, '', CURR_D5) AS CURR_D5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	      , DECODE(PREV_D2_DG, 0, '', PREV_D2_DG) AS PREV_D2_DG" ).append("\n"); 
		query.append("	      , DECODE(PREV_D4_DG, 0, '', PREV_D4_DG) AS PREV_D4_DG" ).append("\n"); 
		query.append("	      , DECODE(PREV_D5_DG, 0, '', PREV_D5_DG) AS PREV_D5_DG" ).append("\n"); 
		query.append("	      , DECODE(CURR_D2_DG, 0, '', CURR_D2_DG) AS CURR_D2_DG" ).append("\n"); 
		query.append("	      , DECODE(CURR_D4_DG, 0, '', CURR_D4_DG) AS CURR_D4_DG" ).append("\n"); 
		query.append("	      , DECODE(CURR_D5_DG, 0, '', CURR_D5_DG) AS CURR_D5_DG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	      , A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("	      , A.N1ST_CMNC_AMDT_SEQ AS ORG_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	      , DECODE((" ).append("\n"); 
		query.append("		    SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("		    FROM PRI_RP_SCP_RT_CMDT_ROUT CMDT_ROUT " ).append("\n"); 
		query.append("		    WHERE CMDT_ROUT.MST_ROUT_ID = A.MST_ROUT_ID " ).append("\n"); 
		query.append("		   AND CMDT_ROUT.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("		   AND CMDT_ROUT.AMDT_SEQ =@[amdt_seq]" ).append("\n"); 
		query.append("		    " ).append("\n"); 
		query.append("		),0,'N','Y') is_exists" ).append("\n"); 
		query.append("		,MST.RFA_NO  AS MST_RFA_NO" ).append("\n"); 
		query.append("	  FROM MST_INFO MST" ).append("\n"); 
		query.append("	     , PRI_RP_SCP_RT_CMDT_ROUT A" ).append("\n"); 
		query.append("	     , PRI_RP_SCP_RT_ROUT_PNT B" ).append("\n"); 
		query.append("	     , PRI_RP_SCP_RT_ROUT_VIA C" ).append("\n"); 
		query.append("	     , PRI_RP_SCP_RT_ROUT_VIA D" ).append("\n"); 
		query.append("	     , PRI_RP_SCP_RT_ROUT_PNT E" ).append("\n"); 
		query.append("	     ,(SELECT A.PROP_NO" ).append("\n"); 
		query.append("		     ,A.AMDT_SEQ" ).append("\n"); 
		query.append("		     ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("		     ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		     ,A.ROUT_SEQ" ).append("\n"); 
		query.append("		     ,WM_CONCAT(DISTINCT(NOTE_CONV_CHG_CD)) AS NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("		     ,WM_CONCAT(DISTINCT(NOTE_CONV_RULE_CD)) AS NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("		     -- Summary" ).append("\n"); 
		query.append("		     ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', B.BKG_DIR_CALL_FLG, '')) AS BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("		     ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', B.BKG_TS_PORT_DEF_CD, '')) AS BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("		     ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', B.BKG_SLAN_CD, '')) AS BKG_SLAN_CD" ).append("\n"); 
		query.append("		     ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', (B.BKG_VSL_CD || B.BKG_SKD_VOY_NO || B.BKG_SKD_DIR_CD), '')) AS BKG_VVD_CD" ).append("\n"); 
		query.append("		     ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', B.NOTE_CONV_SEQ, '')) AS NOTE_CONV_SEQ" ).append("\n"); 
		query.append("		 FROM PRI_RP_SCP_RT_CMDT_RNOTE A, PRI_RFA_NOTE_CONV B, MST_INFO MST" ).append("\n"); 
		query.append("		WHERE A.PROP_NO = MST.PROP_NO" ).append("\n"); 
		query.append("		  AND A.AMDT_SEQ = MST.AMDT_SEQ" ).append("\n"); 
		query.append("		  AND A.SVC_SCP_CD = MST.SVC_SCP_CD" ).append("\n"); 
		query.append("		  AND A.NOTE_CONV_MAPG_ID = B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("		GROUP BY A.PROP_NO" ).append("\n"); 
		query.append("			,A.AMDT_SEQ" ).append("\n"); 
		query.append("			,A.SVC_SCP_CD" ).append("\n"); 
		query.append("			,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,A.ROUT_SEQ) F" ).append("\n"); 
		query.append("	     ,(SELECT RT.PROP_NO" ).append("\n"); 
		query.append("		     ,RT.SVC_SCP_CD" ).append("\n"); 
		query.append("		     ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		     ,ROUT_SEQ" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ -1 AND RAT_UT_CD = 'D2' AND PRC_CGO_TP_CD = 'DR' THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D2" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ -1 AND RAT_UT_CD = 'D4' AND PRC_CGO_TP_CD = 'DR' THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D4" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ -1 AND RAT_UT_CD = 'D5' AND PRC_CGO_TP_CD = 'DR' THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D5" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ AND RAT_UT_CD = 'D2' AND PRC_CGO_TP_CD = 'DR' THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D2" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ AND RAT_UT_CD = 'D4' AND PRC_CGO_TP_CD = 'DR' THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D4" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ AND RAT_UT_CD = 'D5' AND PRC_CGO_TP_CD = 'DR' THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ -1 AND RAT_UT_CD = 'D2' AND PRC_CGO_TP_CD = 'DG' THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D2_DG" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ -1 AND RAT_UT_CD = 'D4' AND PRC_CGO_TP_CD = 'DG' THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D4_DG" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ -1 AND RAT_UT_CD = 'D5' AND PRC_CGO_TP_CD = 'DG' THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D5_DG" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ AND RAT_UT_CD = 'D2' AND PRC_CGO_TP_CD = 'DG' THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D2_DG" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ AND RAT_UT_CD = 'D4' AND PRC_CGO_TP_CD = 'DG' THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D4_DG" ).append("\n"); 
		query.append("		     ,SUM(CASE WHEN RT.AMDT_SEQ = MST.AMDT_SEQ AND RAT_UT_CD = 'D5' AND PRC_CGO_TP_CD = 'DG' THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D5_DG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 FROM PRI_RP_SCP_RT RT, MST_INFO MST" ).append("\n"); 
		query.append("		WHERE RT.PROP_NO = MST.PROP_NO" ).append("\n"); 
		query.append("		  AND (RT.AMDT_SEQ = MST.AMDT_SEQ OR" ).append("\n"); 
		query.append("		      (RT.AMDT_SEQ = MST.AMDT_SEQ - 1 AND" ).append("\n"); 
		query.append("		      SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM')))" ).append("\n"); 
		query.append("		  AND RT.SVC_SCP_CD = MST.SVC_SCP_CD" ).append("\n"); 
		query.append("		  AND RAT_UT_CD IN ('D2', 'D4', 'D5')" ).append("\n"); 
		query.append("		GROUP BY RT.PROP_NO" ).append("\n"); 
		query.append("			,RT.SVC_SCP_CD" ).append("\n"); 
		query.append("			,RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,RT.ROUT_SEQ) I" ).append("\n"); 
		query.append("	 WHERE A.PROP_NO = MST.PROP_NO" ).append("\n"); 
		query.append("	   AND A.AMDT_SEQ = MST.AMDT_SEQ" ).append("\n"); 
		query.append("	   AND A.SVC_SCP_CD = MST.SVC_SCP_CD" ).append("\n"); 
		query.append("	   AND A.PROP_NO = B.PROP_NO(+)" ).append("\n"); 
		query.append("	   AND A.AMDT_SEQ = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	   AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.ROUT_SEQ = B.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("	   AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	   AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.ROUT_SEQ = C.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("	   AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	   AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("	   AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	   AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.ROUT_SEQ = E.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("	   AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	   AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.ROUT_SEQ = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.PROP_NO = I.PROP_NO(+)" ).append("\n"); 
		query.append("	   AND A.SVC_SCP_CD = I.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	   AND A.CMDT_HDR_SEQ = I.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	   AND A.ROUT_SEQ = I.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	   AND B.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("	   AND C.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("	   AND D.ORG_DEST_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("	   AND E.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append(" ) A" ).append("\n"); 
		query.append(" ORDER BY A.IS_EXISTS DESC, A.ROUT_SEQ" ).append("\n"); 

	}
}