/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAORsltRtCmdtHdrListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.16
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.06.16 이은섭
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

public class RFARateProposalDBDAORsltRtCmdtHdrListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate Commodity 조회 History------------------------------------
	  * 2010.05.26 이행지 [CHM-201111048-01] ALPS Error 처리요청 - SYS_CONNECT_BY_PATH 사용으로 길이가 길어지는 문제 PRI_UTILS_PKG.JOIN_ROWS_CLOB_FUNC로 해결
	  * </pre>
	  */
	public RFARateProposalDBDAORsltRtCmdtHdrListVORSQL(){
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
		params.put("fic_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltRtCmdtHdrListVORSQL").append("\n"); 
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
		query.append("      ,B.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0) +" ).append("\n"); 
		query.append("              NVL(I.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS PRC_CMDT_DEF_NM_PROP" ).append("\n"); 
		query.append("      ,REPLACE(C.CUST_LGL_ENG_NM, '^|^', ' / ') AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0) +" ).append("\n"); 
		query.append("              NVL(I.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS CUST_LGL_ENG_NM_PROP" ).append("\n"); 
		query.append("      ,REPLACE(D.NOTE_CTNT, '^|^', CHR(13)) AS NOTE_CTNT" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0) +" ).append("\n"); 
		query.append("              NVL(I.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') AS NOTE_CTNT_PROP" ).append("\n"); 
		query.append("      ,REPLACE(D.NOTE_CTNT, '^|^', CHR(13) || CHR(13)) AS NOTE_CTNT_TOOLTIP" ).append("\n"); 
		query.append("      ,(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0) +" ).append("\n"); 
		query.append("       NVL(I.ND_CNT, 0)) AS ND_CNT" ).append("\n"); 
		query.append("      ,(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) + NVL(H.NA_CNT, 0) +" ).append("\n"); 
		query.append("       NVL(I.NA_CNT, 0)) AS NA_CNT" ).append("\n"); 
		query.append("      ,(NVL(B.AC_CNT, 0) + NVL(C.AC_CNT, 0) + NVL(D.AC_CNT, 0) + NVL(E.AC_CNT, 0) + NVL(F.AC_CNT, 0) + NVL(H.AC_CNT, 0) +" ).append("\n"); 
		query.append("       NVL(I.AC_CNT, 0)) AS AC_CNT" ).append("\n"); 
		query.append("      ,(NVL(B.UP_CNT, 0) + NVL(C.UP_CNT, 0) + NVL(D.UP_CNT, 0) + NVL(E.UP_CNT, 0) + NVL(F.UP_CNT, 0) +" ).append("\n"); 
		query.append("       NVL(H.UP_CNT, 0) + NVL(I.UP_CNT, 0)) AS UP_CNT" ).append("\n"); 
		query.append("      ,DECODE(A.AMDT_SEQ" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,DECODE(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) +" ).append("\n"); 
		query.append("                     NVL(H.NA_CNT, 0) + NVL(I.NA_CNT, 0)" ).append("\n"); 
		query.append("                    ,0" ).append("\n"); 
		query.append("                    ,'color:blue;'" ).append("\n"); 
		query.append("                    ,'')" ).append("\n"); 
		query.append("             ,DECODE(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) +" ).append("\n"); 
		query.append("                     NVL(H.NA_CNT, 0) + NVL(I.NA_CNT, 0)" ).append("\n"); 
		query.append("                    ,0" ).append("\n"); 
		query.append("                    ,DECODE(NVL(B.UP_CNT, 0) + NVL(C.UP_CNT, 0) + NVL(D.UP_CNT, 0) + NVL(E.UP_CNT, 0) + NVL(F.UP_CNT, 0) +" ).append("\n"); 
		query.append("                            NVL(H.UP_CNT, 0) + NVL(I.UP_CNT, 0)" ).append("\n"); 
		query.append("                           ,0" ).append("\n"); 
		query.append("                           ,''" ).append("\n"); 
		query.append("                           ,'color:blue;')" ).append("\n"); 
		query.append("                    ,'color:red;')) AS ROW_PROPERTIES" ).append("\n"); 
		query.append("      ,A.BLET_DP_SEQ" ).append("\n"); 
		query.append("      ,DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) + NVL(H.ND_CNT, 0) +" ).append("\n"); 
		query.append("              NVL(I.ND_CNT, 0)" ).append("\n"); 
		query.append("             ,0" ).append("\n"); 
		query.append("             ,'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("             ,'') || DECODE((SELECT PROP_STS_CD" ).append("\n"); 
		query.append("                              FROM PRI_RP_MN" ).append("\n"); 
		query.append("                             WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                               AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("                           ,'I'" ).append("\n"); 
		query.append("                           ,DECODE(A.AMDT_SEQ, A.N1ST_CMNC_AMDT_SEQ, 'edit:true;', 'edit:false;')" ).append("\n"); 
		query.append("                           ,'edit:false;') AS BLET_DP_SEQ_PROP" ).append("\n"); 
		query.append("      ,A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.N1ST_CMNC_AMDT_SEQ AS ORG_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("	  ,NVL(A.FIC_RT_TP_CD, 'G') FIC_RT_TP_CD" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_CMDT_HDR A" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 1, 0)) AS AC_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM, ' / ')), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                             ,'G'" ).append("\n"); 
		query.append("                             ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                                FROM PRI_RP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("                               WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                                 AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                                 AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                 AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'R'" ).append("\n"); 
		query.append("                             ,(SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("                               WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'C'" ).append("\n"); 
		query.append("                             ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                               WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, DECODE(PRC_CMDT_TP_CD, 'G', 1, 'R', 2, 'C', 3, 99), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_CMDT A" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd])" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ) B" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 1, 0)) AS AC_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(CUST_LGL_ENG_NM, '^|^')), 4) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                          FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                         WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                           AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ACT_CUST_SEQ) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd])" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ) C" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 1, 0)) AS AC_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("              --,SUBSTR(MAX(SYS_CONNECT_BY_PATH(NOTE_CTNT, '^|^')), 4) AS NOTE_CTNT" ).append("\n"); 
		query.append("              ,PRI_UTILS_PKG.JOIN_ROWS_CLOB_FUNC( CURSOR( SELECT A.NOTE_CTNT" ).append("\n"); 
		query.append("                                                            FROM PRI_RP_SCP_RT_CNOTE A" ).append("\n"); 
		query.append("                                                           WHERE A.PROP_NO      = K.PROP_NO" ).append("\n"); 
		query.append("                                                             AND A.AMDT_SEQ     = K.AMDT_SEQ" ).append("\n"); 
		query.append("                                                             AND A.SVC_SCP_CD   = K.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                             AND A.CMDT_HDR_SEQ = K.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                                           ORDER BY A.CMDT_NOTE_SEQ" ).append("\n"); 
		query.append("                                                         ),'^|^' ) AS NOTE_CTNT" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,NOTE_CTNT" ).append("\n"); 
		query.append("                      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                      ,SRC_INFO_CD" ).append("\n"); 
		query.append("                      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, CMDT_NOTE_SEQ) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]) K" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,CMDT_HDR_SEQ) D" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 1, 0)) AS AC_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ) E" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 1, 0)) AS AC_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ) F" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 1, 0)) AS AC_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ) H" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 1, 0)) AS AC_CNT" ).append("\n"); 
		query.append("              ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ) I" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = B.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = H.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = H.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = H.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = H.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = I.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = I.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = I.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = I.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${IS_STYLE} == 'Y' && ${cmdt_hdr_seq} != '') " ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND NVL(A.FIC_RT_TP_CD, 'G') = NVL(@[fic_rt_tp_cd],'G')" ).append("\n"); 
		query.append(" ORDER BY A.BLET_DP_SEQ" ).append("\n"); 

	}
}