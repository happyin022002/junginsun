/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAORsltRtRoutHdrListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.29
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.11.29 이은섭
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

public class RFARateProposalDBDAORsltRtRoutHdrListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate - Route조회
	  * </pre>
	  */
	public RFARateProposalDBDAORsltRtRoutHdrListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("FileName : RFARateProposalDBDAORsltRtRoutHdrListVORSQL").append("\n"); 
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
		query.append("      ,A.AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ,A.ROUT_SEQ" ).append("\n"); 
		query.append("      ,B.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS ORG_ROUT_PNT_LOC_DEF_CD_PROP" ).append("\n"); 
		query.append("      ,C.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS ORG_ROUT_VIA_PORT_DEF_CD_PROP" ).append("\n"); 
		query.append("      ,D.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS DEST_ROUT_VIA_PORT_DEF_CD_PROP" ).append("\n"); 
		query.append("      ,E.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS DEST_ROUT_PNT_LOC_DEF_CD_PROP" ).append("\n"); 
		query.append("      ,REPLACE(F.NOTE_CTNT, '^|^', CHR(13)) AS NOTE_CTNT" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS NOTE_CTNT_PROP" ).append("\n"); 
		query.append("      ,REPLACE(F.NOTE_CTNT, '^|^', CHR(13) || CHR(13)) AS NOTE_CTNT_TOOLTIP" ).append("\n"); 
		query.append("      ,(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0)) AS ND_CNT" ).append("\n"); 
		query.append("      ,(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) + NVL(H.NA_CNT, 0)) AS NA_CNT" ).append("\n"); 
		query.append("      ,(NVL(B.UP_CNT, 0) + NVL(C.UP_CNT, 0) + NVL(D.UP_CNT, 0) + NVL(E.UP_CNT, 0) + NVL(F.UP_CNT, 0) + NVL(H.UP_CNT, 0)) AS UP_CNT" ).append("\n"); 
		query.append("      ,DECODE(A.AMDT_SEQ" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,DECODE(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) +" ).append("\n"); 
		query.append("                     NVL(H.NA_CNT, 0)" ).append("\n"); 
		query.append("                    ,0" ).append("\n"); 
		query.append("                    ,'color:blue;'" ).append("\n"); 
		query.append("                    ,'')" ).append("\n"); 
		query.append("             ,DECODE(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) +" ).append("\n"); 
		query.append("                     NVL(H.NA_CNT, 0)" ).append("\n"); 
		query.append("                    ,0" ).append("\n"); 
		query.append("                    ,DECODE(NVL(B.UP_CNT, 0) + NVL(C.UP_CNT, 0) + NVL(D.UP_CNT, 0) + NVL(E.UP_CNT, 0) + NVL(F.UP_CNT, 0) +" ).append("\n"); 
		query.append("                            NVL(H.UP_CNT, 0)" ).append("\n"); 
		query.append("                           ,0" ).append("\n"); 
		query.append("                           ,''" ).append("\n"); 
		query.append("                           ,'color:blue;')" ).append("\n"); 
		query.append("                    ,'color:red;')) AS ROW_PROPERTIES" ).append("\n"); 
		query.append("      ,A.NOTE_DP_SEQ" ).append("\n"); 
		query.append("      ,A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.N1ST_CMNC_AMDT_SEQ AS ORG_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("      ,@[note_dp_seq] || '.' || ROW_NUMBER() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.CMDT_HDR_SEQ ORDER BY B.SORT_KEY, E.SORT_KEY, C.SORT_KEY, D.SORT_KEY) AS RN" ).append("\n"); 
		query.append("      , '' as FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append("      , A.ORG_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("      , A.DEST_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("      , B.BSE_PORT_LOC_CD ORG_BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("      , E.BSE_PORT_LOC_CD DEST_BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_CMDT_ROUT A" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_CD              " ).append("\n"); 
		query.append("			  ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(BSE_PORT_LOC_CD, ', ')), 3) AS BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("					  ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) B" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) C" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) D" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("			  ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(BSE_PORT_LOC_CD, ', ')), 3) AS BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("					  ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) E" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(NOTE_CTNT, '^|^')), 4) AS NOTE_CTNT" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,ROUT_SEQ" ).append("\n"); 
		query.append("                      ,SUBSTRB(NOTE_CTNT,0,497)||CASE WHEN LENGTHB(NOTE_CTNT)<497 THEN '' ELSE '...' END AS NOTE_CTNT" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_NOTE_SEQ) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq])" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ) F" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 ,ROUT_SEQ) H" ).append("\n"); 
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
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#if (${IS_STYLE} == 'Y') " ).append("\n"); 
		query.append("   AND A.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY B.SORT_KEY" ).append("\n"); 
		query.append("         ,E.SORT_KEY" ).append("\n"); 
		query.append("         ,C.SORT_KEY" ).append("\n"); 
		query.append("         ,D.SORT_KEY" ).append("\n"); 

	}
}