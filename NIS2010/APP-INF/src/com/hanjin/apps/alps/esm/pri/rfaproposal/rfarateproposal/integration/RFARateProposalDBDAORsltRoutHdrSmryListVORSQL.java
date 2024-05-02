/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : RFARateProposalDBDAORsltRoutHdrSmryListVORSQL.java
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

public class RFARateProposalDBDAORsltRoutHdrSmryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA의 Route & Summary 정보를 조회합니다.
	  * </pre>
	  */
	public RFARateProposalDBDAORsltRoutHdrSmryListVORSQL(){
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
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltRoutHdrSmryListVORSQL").append("\n"); 
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
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append("      , A.AMDT_SEQ" ).append("\n"); 
		query.append("      , A.SVC_SCP_CD" ).append("\n"); 
		query.append("      , A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      , A.ROUT_SEQ" ).append("\n"); 
		query.append("      , B.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("              ,0" ).append("\n"); 
		query.append("              ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("              ,'')" ).append("\n"); 
		query.append("     || DECODE((SELECT PROP_STS_CD" ).append("\n"); 
		query.append("                              FROM PRI_RP_MN" ).append("\n"); 
		query.append("                             WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                               AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("                           ,'I'" ).append("\n"); 
		query.append("                           ,DECODE(A.AMDT_SEQ, A.N1ST_CMNC_AMDT_SEQ, 'edit:true;', 'edit:false;')" ).append("\n"); 
		query.append("                           ,'edit:false;')" ).append("\n"); 
		query.append("        AS ORG_ROUT_PNT_LOC_DEF_CD_PROP" ).append("\n"); 
		query.append("      , B.RCV_DE_TERM_CD AS RCV_DE_TERM_CD_ORI" ).append("\n"); 
		query.append("      , C.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("              ,0" ).append("\n"); 
		query.append("              ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("              ,'')" ).append("\n"); 
		query.append("     || DECODE((SELECT PROP_STS_CD" ).append("\n"); 
		query.append("                              FROM PRI_RP_MN" ).append("\n"); 
		query.append("                             WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                               AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("                           ,'I'" ).append("\n"); 
		query.append("                           ,DECODE(A.AMDT_SEQ, A.N1ST_CMNC_AMDT_SEQ, 'edit:true;', 'edit:false;')" ).append("\n"); 
		query.append("                           ,'edit:false;')" ).append("\n"); 
		query.append("        AS ORG_ROUT_VIA_PORT_DEF_CD_PROP" ).append("\n"); 
		query.append("      , D.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("              ,0" ).append("\n"); 
		query.append("              ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("              ,'')" ).append("\n"); 
		query.append("     || DECODE((SELECT PROP_STS_CD" ).append("\n"); 
		query.append("                              FROM PRI_RP_MN" ).append("\n"); 
		query.append("                             WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                               AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("                           ,'I'" ).append("\n"); 
		query.append("                           ,DECODE(A.AMDT_SEQ, A.N1ST_CMNC_AMDT_SEQ, 'edit:true;', 'edit:false;')" ).append("\n"); 
		query.append("                           ,'edit:false;')" ).append("\n"); 
		query.append("        AS DEST_ROUT_VIA_PORT_DEF_CD_PROP" ).append("\n"); 
		query.append("      , E.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("              ,0" ).append("\n"); 
		query.append("              ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("              ,'')" ).append("\n"); 
		query.append("     || DECODE((SELECT PROP_STS_CD" ).append("\n"); 
		query.append("                              FROM PRI_RP_MN" ).append("\n"); 
		query.append("                             WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                               AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("                           ,'I'" ).append("\n"); 
		query.append("                           ,DECODE(A.AMDT_SEQ, A.N1ST_CMNC_AMDT_SEQ, 'edit:true;', 'edit:false;')" ).append("\n"); 
		query.append("                           ,'edit:false;')" ).append("\n"); 
		query.append("        AS DEST_ROUT_PNT_LOC_DEF_CD_PROP" ).append("\n"); 
		query.append("      , E.RCV_DE_TERM_CD AS RCV_DE_TERM_CD_DEST" ).append("\n"); 
		query.append("		-- App Note Conversion" ).append("\n"); 
		query.append("      , NOTE_CONV_SEQ" ).append("\n"); 
		query.append("      , F.EFF_DT" ).append("\n"); 
		query.append("      , F.EXP_DT" ).append("\n"); 
		query.append("      , BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("      , BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("      , BKG_SLAN_CD" ).append("\n"); 
		query.append("      , BKG_VVD_CD" ).append("\n"); 
		query.append("      , CASE WHEN NOTE_CONV_CHG_CD IS NULL" ).append("\n"); 
		query.append("             THEN NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("             WHEN NOTE_CONV_RULE_CD IS NULL" ).append("\n"); 
		query.append("             THEN NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("        ELSE NOTE_CONV_RULE_CD ||','|| NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("         END AS NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("      ,(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0)) AS ND_CNT" ).append("\n"); 
		query.append("      ,(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) + NVL(H.NA_CNT, 0)) AS NA_CNT" ).append("\n"); 
		query.append("      ,(NVL(B.AC_CNT, 0) + NVL(C.AC_CNT, 0) + NVL(D.AC_CNT, 0) + NVL(E.AC_CNT, 0) + NVL(F.AC_CNT, 0) + NVL(H.AC_CNT, 0)) AS AC_CNT" ).append("\n"); 
		query.append("      ,(NVL(B.UP_CNT, 0) + NVL(C.UP_CNT, 0) + NVL(D.UP_CNT, 0) + NVL(E.UP_CNT, 0) + NVL(F.UP_CNT, 0) + NVL(H.UP_CNT, 0)) AS UP_CNT" ).append("\n"); 
		query.append("      -- Row의 색상 설정" ).append("\n"); 
		query.append("      ,DECODE(A.AMDT_SEQ" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,DECODE(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) + NVL(H.NA_CNT, 0)" ).append("\n"); 
		query.append("                    ,0" ).append("\n"); 
		query.append("                    ,'color:blue;'" ).append("\n"); 
		query.append("                    ,'')" ).append("\n"); 
		query.append("             ,DECODE(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) + NVL(H.NA_CNT, 0)" ).append("\n"); 
		query.append("                    ,0" ).append("\n"); 
		query.append("                    ,DECODE(NVL(B.UP_CNT, 0) + NVL(C.UP_CNT, 0) + NVL(D.UP_CNT, 0) + NVL(E.UP_CNT, 0) + NVL(F.UP_CNT, 0) + NVL(H.UP_CNT, 0)" ).append("\n"); 
		query.append("                           ,0" ).append("\n"); 
		query.append("                           ,''" ).append("\n"); 
		query.append("                           ,'color:blue;')" ).append("\n"); 
		query.append("                    ,'color:red;')" ).append("\n"); 
		query.append("        ) AS ROW_PROPERTIES" ).append("\n"); 
		query.append("      -- Row의 편집 가능여부 설정" ).append("\n"); 
		query.append("      ,DECODE((SELECT PROP_STS_CD" ).append("\n"); 
		query.append("                              FROM PRI_RP_MN" ).append("\n"); 
		query.append("                             WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                               AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("                           ,'I'" ).append("\n"); 
		query.append("                           ,DECODE(A.AMDT_SEQ, A.N1ST_CMNC_AMDT_SEQ, 'edit:true;', 'edit:false;')" ).append("\n"); 
		query.append("                           ,'edit:false;')" ).append("\n"); 
		query.append("        AS ROUT_SEQ_PROP" ).append("\n"); 
		query.append("      , A.NOTE_DP_SEQ" ).append("\n"); 
		query.append("      , DECODE(PREV_D2, 0, '', PREV_D2) AS PREV_D2" ).append("\n"); 
		query.append("      , DECODE(PREV_D4, 0, '', PREV_D4) AS PREV_D4" ).append("\n"); 
		query.append("      , DECODE(PREV_D5, 0, '', PREV_D5) AS PREV_D5" ).append("\n"); 
		query.append("      , DECODE(CURR_D2, 0, '', CURR_D2) AS CURR_D2" ).append("\n"); 
		query.append("      , DECODE(CURR_D4, 0, '', CURR_D4) AS CURR_D4" ).append("\n"); 
		query.append("      , DECODE(CURR_D5, 0, '', CURR_D5) AS CURR_D5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , DECODE(PREV_D2_DG, 0, '', PREV_D2_DG) AS PREV_D2_DG" ).append("\n"); 
		query.append("      , DECODE(PREV_D4_DG, 0, '', PREV_D4_DG) AS PREV_D4_DG" ).append("\n"); 
		query.append("      , DECODE(PREV_D5_DG, 0, '', PREV_D5_DG) AS PREV_D5_DG" ).append("\n"); 
		query.append("      , DECODE(CURR_D2_DG, 0, '', CURR_D2_DG) AS CURR_D2_DG" ).append("\n"); 
		query.append("      , DECODE(CURR_D4_DG, 0, '', CURR_D4_DG) AS CURR_D4_DG" ).append("\n"); 
		query.append("      , DECODE(CURR_D5_DG, 0, '', CURR_D5_DG) AS CURR_D5_DG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      , A.N1ST_CMNC_AMDT_SEQ AS ORG_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      , A.CRE_USR_ID" ).append("\n"); 
		query.append("      , A.CRE_DT" ).append("\n"); 
		query.append("      , A.UPD_USR_ID" ).append("\n"); 
		query.append("      , A.UPD_DT" ).append("\n"); 
		query.append("      , '' as FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append("      , A.ORG_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("      , A.DEST_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("      , B.BSE_PORT_LOC_CD ORG_BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("      , E.BSE_PORT_LOC_CD DEST_BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("      -- COPY 용으로 사용하기 위한 컬럼" ).append("\n"); 
		query.append("      , (SELECT RFA_NO FROM PRI_RP_HDR WHERE PROP_NO = @[prop_no] AND ROWNUM = 1) AS MST_RFA_NO" ).append("\n"); 
		query.append("      , A.MST_ROUT_ID" ).append("\n"); 
		query.append("      , '' AS NEW_PROP_NO" ).append("\n"); 
		query.append("		, '' AS NEW_AMDT_SEQ" ).append("\n"); 
		query.append("      , '' AS OFC_CD" ).append("\n"); 
		query.append("	  , '' AS IS_EXISTS" ).append("\n"); 
		query.append("	  , '' AS NEW_ROUT_SEQ" ).append("\n"); 
		query.append("	  , '' AS MST_RFA_NO" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_CMDT_ROUT A" ).append("\n"); 
		query.append("       -- Origin" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("              ,DECODE(SRC_INFO_CD, 'AD', 0, 1) AS ND_CNT" ).append("\n"); 
		query.append("              ,DECODE(PRC_PROG_STS_CD, 'A', 0, 1) AS NA_CNT" ).append("\n"); 
		query.append("              ,DECODE(PRC_PROG_STS_CD, 'A', 1, 0) AS AC_CNT" ).append("\n"); 
		query.append("              ,DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0) AS UP_CNT" ).append("\n"); 
		query.append("              ,ROUT_PNT_LOC_DEF_CD          " ).append("\n"); 
		query.append("			  ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = '1'" ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD = 'O') B" ).append("\n"); 
		query.append("       -- Origin Via." ).append("\n"); 
		query.append("     , (SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,DECODE(SRC_INFO_CD, 'AD', 0, 1) AS ND_CNT" ).append("\n"); 
		query.append("              ,DECODE(PRC_PROG_STS_CD, 'A', 0, 1) AS NA_CNT" ).append("\n"); 
		query.append("              ,DECODE(PRC_PROG_STS_CD, 'A', 1, 0) AS AC_CNT" ).append("\n"); 
		query.append("              ,DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0) AS UP_CNT" ).append("\n"); 
		query.append("              ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = '1'" ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD = 'O') C" ).append("\n"); 
		query.append("       -- Dest Via." ).append("\n"); 
		query.append("     , (SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,DECODE(SRC_INFO_CD, 'AD', 0, 1) AS ND_CNT" ).append("\n"); 
		query.append("              ,DECODE(PRC_PROG_STS_CD, 'A', 0, 1) AS NA_CNT" ).append("\n"); 
		query.append("              ,DECODE(PRC_PROG_STS_CD, 'A', 1, 0) AS AC_CNT" ).append("\n"); 
		query.append("              ,DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0) AS UP_CNT" ).append("\n"); 
		query.append("              ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = '1'" ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD = 'D') D" ).append("\n"); 
		query.append("       -- Dest" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("              ,DECODE(SRC_INFO_CD, 'AD', 0, 1) AS ND_CNT" ).append("\n"); 
		query.append("              ,DECODE(PRC_PROG_STS_CD, 'A', 0, 1) AS NA_CNT" ).append("\n"); 
		query.append("              ,DECODE(PRC_PROG_STS_CD, 'A', 1, 0) AS AC_CNT" ).append("\n"); 
		query.append("              ,DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0) AS UP_CNT" ).append("\n"); 
		query.append("              ,ROUT_PNT_LOC_DEF_CD          " ).append("\n"); 
		query.append("			  ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = '1'" ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD = 'D') E" ).append("\n"); 
		query.append("     ,(SELECT A.PROP_NO" ).append("\n"); 
		query.append("             ,A.AMDT_SEQ" ).append("\n"); 
		query.append("             ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("             ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             ,A.ROUT_SEQ" ).append("\n"); 
		query.append("             ,WM_CONCAT(DISTINCT(NOTE_CONV_CHG_CD)) AS NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("             ,WM_CONCAT(DISTINCT(NOTE_CONV_RULE_CD)) AS NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("             -- Summary" ).append("\n"); 
		query.append("             ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', B.BKG_DIR_CALL_FLG, '')) AS BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("             ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', B.BKG_TS_PORT_DEF_CD, '')) AS BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("             ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', B.BKG_SLAN_CD, '')) AS BKG_SLAN_CD" ).append("\n"); 
		query.append("             ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', (B.BKG_VSL_CD || B.BKG_SKD_VOY_NO || B.BKG_SKD_DIR_CD), '')) AS BKG_VVD_CD" ).append("\n"); 
		query.append("             ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', B.NOTE_CONV_SEQ, '')) AS NOTE_CONV_SEQ" ).append("\n"); 
		query.append("             ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', EFF_DT, '')) AS EFF_DT" ).append("\n"); 
		query.append("             ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', EXP_DT, '')) AS EXP_DT" ).append("\n"); 
		query.append("             -- Status" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.PRC_PROG_STS_CD, 'A', 1, 0)) AS AC_CNT" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.AMDT_SEQ, A.N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("         FROM PRI_RP_SCP_RT_CMDT_RNOTE A, PRI_RFA_NOTE_CONV B" ).append("\n"); 
		query.append("        WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("          AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("          AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("          AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("          AND A.NOTE_CONV_MAPG_ID = B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("        GROUP BY A.PROP_NO" ).append("\n"); 
		query.append("                ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                ,A.ROUT_SEQ) F" ).append("\n"); 
		query.append("     ,(SELECT PROP_NO" ).append("\n"); 
		query.append("             ,AMDT_SEQ" ).append("\n"); 
		query.append("             ,SVC_SCP_CD" ).append("\n"); 
		query.append("             ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             ,ROUT_SEQ" ).append("\n"); 
		query.append("             ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("             ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("             ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 1, 0)) AS AC_CNT" ).append("\n"); 
		query.append("             ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("         FROM PRI_RP_SCP_RT" ).append("\n"); 
		query.append("        WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("          AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("          AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("          AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("        GROUP BY PROP_NO" ).append("\n"); 
		query.append("                ,AMDT_SEQ" ).append("\n"); 
		query.append("                ,SVC_SCP_CD" ).append("\n"); 
		query.append("                ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                ,ROUT_SEQ) H" ).append("\n"); 
		query.append("     ,(SELECT PROP_NO" ).append("\n"); 
		query.append("             ,@[amdt_seq] AS AMDT_SEQ" ).append("\n"); 
		query.append("             ,SVC_SCP_CD" ).append("\n"); 
		query.append("             ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             ,ROUT_SEQ" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq]-1 AND RAT_UT_CD = 'D2' AND PRC_CGO_TP_CD = 'DR' THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D2" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq]-1 AND RAT_UT_CD = 'D4' AND PRC_CGO_TP_CD = 'DR'  THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D4" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq]-1 AND RAT_UT_CD = 'D5' AND PRC_CGO_TP_CD = 'DR'  THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D5" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq] AND RAT_UT_CD = 'D2' AND PRC_CGO_TP_CD = 'DR'  THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D2" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq] AND RAT_UT_CD = 'D4' AND PRC_CGO_TP_CD = 'DR'  THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D4" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq] AND RAT_UT_CD = 'D5' AND PRC_CGO_TP_CD = 'DR'  THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq]-1 AND RAT_UT_CD = 'D2' AND PRC_CGO_TP_CD = 'DG'  THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D2_DG" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq]-1 AND RAT_UT_CD = 'D4' AND PRC_CGO_TP_CD = 'DG'   THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D4_DG" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq]-1 AND RAT_UT_CD = 'D5' AND PRC_CGO_TP_CD = 'DG'   THEN PROP_FRT_RT_AMT ELSE 0 END) AS PREV_D5_DG" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq] AND RAT_UT_CD = 'D2' AND PRC_CGO_TP_CD = 'DG'    THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D2_DG" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq] AND RAT_UT_CD = 'D4' AND PRC_CGO_TP_CD = 'DG'   THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D4_DG" ).append("\n"); 
		query.append("             ,SUM(CASE WHEN AMDT_SEQ = @[amdt_seq] AND RAT_UT_CD = 'D5' AND PRC_CGO_TP_CD = 'DG'   THEN PROP_FRT_RT_AMT ELSE 0 END) AS CURR_D5_DG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         FROM PRI_RP_SCP_RT" ).append("\n"); 
		query.append("        WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("          AND (AMDT_SEQ = @[amdt_seq] OR" ).append("\n"); 
		query.append("              (AMDT_SEQ = @[amdt_seq] - 1 AND" ).append("\n"); 
		query.append("              SRC_INFO_CD IN ('NW', 'PC', 'PM', 'GC', 'GM', 'AM')))" ).append("\n"); 
		query.append("          AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("          AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("          AND RAT_UT_CD IN ('D2', 'D4', 'D5')" ).append("\n"); 
		query.append("        GROUP BY PROP_NO" ).append("\n"); 
		query.append("                ,SVC_SCP_CD" ).append("\n"); 
		query.append("                ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                ,ROUT_SEQ) I" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = B.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = B.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = C.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = E.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = H.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = H.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = H.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = H.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = H.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = I.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = I.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = I.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = I.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = I.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append(" ORDER BY ROUT_SEQ" ).append("\n"); 

	}
}