/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCRateProposalDBDAORsltRtRoutHdrHistoryListVORSQL.java
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

public class SCRateProposalDBDAORsltRtRoutHdrHistoryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate - Route조회
	  * * 2013.10.25 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
	  * * 2015.04.06 송호진 [CHM-201534007] Fixed index 개발
	  * </pre>
	  */
	public SCRateProposalDBDAORsltRtRoutHdrHistoryListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("note_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltRtRoutHdrHistoryListVORSQL").append("\n"); 
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
		query.append("WITH MN AS (" ).append("\n"); 
		query.append("  SELECT LGCY_IF_FLG FROM PRI_SP_MN WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT /*+ USE_HASH(A B C D E F G H) */" ).append("\n"); 
		query.append("       A.PROP_NO" ).append("\n"); 
		query.append("      ,A.AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("      ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ,A.ROUT_SEQ" ).append("\n"); 
		query.append("      ,B.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("              NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS ORG_ROUT_PNT_LOC_DEF_CD_PROP" ).append("\n"); 
		query.append("      ,C.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("              NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS ORG_ROUT_VIA_PORT_DEF_CD_PROP" ).append("\n"); 
		query.append("      ,D.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("              NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS DEST_ROUT_VIA_PORT_DEF_CD_PROP" ).append("\n"); 
		query.append("      ,E.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("              NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS DEST_ROUT_PNT_LOC_DEF_CD_PROP" ).append("\n"); 
		query.append("      ,SUBSTR(REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', GRI') ||" ).append("\n"); 
		query.append("              REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', Surcharge') ||" ).append("\n"); 
		query.append("              REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', DEM/DET') ||" ).append("\n"); 
		query.append("              REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', Chassis') ||" ).append("\n"); 
		query.append("              REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', Others')" ).append("\n"); 
		query.append("             ,3) AS NOTE_CLSS_NM" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("              NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS NOTE_CLSS_NM_PROP" ).append("\n"); 
		query.append("      ,REPLACE(F.NOTE_TOOLTIP, '^|^', CHR(13) || CHR(13)) AS NOTE_CLSS_NM_TOOLTIP" ).append("\n"); 
		query.append("      ,G.DIR_CALL_FLG" ).append("\n"); 
		query.append("      ,(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) +" ).append("\n"); 
		query.append("       NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("       NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)) AS ND_CNT" ).append("\n"); 
		query.append("      ,(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) +" ).append("\n"); 
		query.append("       NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) +" ).append("\n"); 
		query.append("       NVL(DECODE(G.N1ST_CMNC_AMDT_SEQ, G.AMDT_SEQ, 1, 0), 0) + NVL(H.NA_CNT, 0)) AS NA_CNT" ).append("\n"); 
		query.append("      ,DECODE((SELECT DECODE(LGCY_IF_FLG, 'Y', 0, AMDT_SEQ) AS AMDT_SEQ FROM PRI_SP_MN WHERE PROP_NO = A.PROP_NO AND AMDT_SEQ = A.AMDT_SEQ AND ROWNUM = 1)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,''" ).append("\n"); 
		query.append("             ,DECODE(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) +" ).append("\n"); 
		query.append("                     NVL(DECODE(G.N1ST_CMNC_AMDT_SEQ, G.AMDT_SEQ, 1, 0), 0) + NVL(H.NA_CNT, 0)" ).append("\n"); 
		query.append("                    ,0" ).append("\n"); 
		query.append("                    ,''" ).append("\n"); 
		query.append("                    ,'color:red;')) AS ROW_PROPERTIES" ).append("\n"); 
		query.append("      ,A.NOTE_DP_SEQ" ).append("\n"); 
		query.append("      ,A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("      ,@[note_dp_seq] || '.' || ROW_NUMBER() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ ORDER BY B.SORT_KEY, E.SORT_KEY, C.SORT_KEY, D.SORT_KEY, G.DIR_CALL_FLG DESC) AS RN" ).append("\n"); 
		query.append("      ,DECODE ( A.FX_RT_FLG, 'Y', '1', 'N', '0', '0' ) AS FX_RT_FLG" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_RT_CMDT_ROUT A, MN" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(N1ST_CMNC_AMDT_SEQ, AMDT_SEQ, 1, 0)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_PNT, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(LGCY_IF_FLG, 'Y', 'AD', 'X'))" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) B" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(N1ST_CMNC_AMDT_SEQ, AMDT_SEQ, 1, 0)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_VIA, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(LGCY_IF_FLG, 'Y', 'AD', 'X'))" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) C" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(N1ST_CMNC_AMDT_SEQ, AMDT_SEQ, 1, 0)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_VIA, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(LGCY_IF_FLG, 'Y', 'AD', 'X'))" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) D" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(N1ST_CMNC_AMDT_SEQ, AMDT_SEQ, 1, 0)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_PNT, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(LGCY_IF_FLG, 'Y', 'AD', 'X'))" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) E" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(N1ST_CMNC_AMDT_SEQ, AMDT_SEQ, 1, 0)) AS NA_CNT" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(NOTE_CLSS_NM, ', ')) AS NOTE_CLSS_NM" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(NOTE_TOOLTIP, '^|^')), 4) AS NOTE_TOOLTIP" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                         WHERE INTG_CD_ID = 'CD01711'" ).append("\n"); 
		query.append("                           AND INTG_CD_VAL_CTNT = NOTE_CLSS_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS NOTE_CLSS_NM" ).append("\n"); 
		query.append("                      ,'<' || (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                 FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                WHERE INTG_CD_ID = 'CD01711'" ).append("\n"); 
		query.append("                                  AND INTG_CD_VAL_CTNT = NOTE_CLSS_CD" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1) || '>' || CHR(13) ||" ).append("\n"); 
		query.append("                       NOTE_CTNT AS NOTE_TOOLTIP" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, DECODE(NOTE_CLSS_CD, 'G', '1', 'S', '2', 'D', '3', 'C', '4', 'O', '5')) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_CMDT_RNOTE, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(LGCY_IF_FLG, 'Y', 'AD', 'X'))" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ) F" ).append("\n"); 
		query.append("      ,PRI_SP_SCP_RT_ROUT_DIR G" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(N1ST_CMNC_AMDT_SEQ, AMDT_SEQ, 1, 0)) AS NA_CNT" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_RT, MN" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("           AND SRC_INFO_CD <> DECODE(LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ) H" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("   AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = C.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = C.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = D.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("   AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = F.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = G.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = G.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = G.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = G.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = G.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = H.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = H.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = H.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = H.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = H.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = H.ROUT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#if (${IS_CONVERSION} == 'N') " ).append("\n"); 
		query.append("   AND (EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, 0 AS ROUT_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_CMDT, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(MN.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                 GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, 0 AS ROUT_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ACT_CUST, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(MN.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                 GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, 0 AS ROUT_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_CNOTE, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(MN.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                 GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_PNT, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(MN.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                 GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_VIA, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(MN.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                 GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_DIR, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(MN.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                 GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_CMDT_RNOTE, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(MN.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                 GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT, MN" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> DECODE(MN.LGCY_IF_FLG, 'Y', 'AD', 'X')" ).append("\n"); 
		query.append("                 GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ)" ).append("\n"); 
		query.append("         WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND GEN_SPCL_RT_TP_CD = A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("           AND (ROUT_SEQ = 0 OR ROUT_SEQ = A.ROUT_SEQ))" ).append("\n"); 
		query.append("        OR MN.LGCY_IF_FLG = 'Y')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY B.SORT_KEY" ).append("\n"); 
		query.append("         ,E.SORT_KEY" ).append("\n"); 
		query.append("         ,C.SORT_KEY" ).append("\n"); 
		query.append("         ,D.SORT_KEY" ).append("\n"); 
		query.append("         ,G.DIR_CALL_FLG DESC" ).append("\n"); 

	}
}