/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAORsltRtRoutHdrListVO1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2010.01.21 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAORsltRtRoutHdrListVO1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 튜닝 테스트용 쿼리...
	  * </pre>
	  */
	public SCRateProposalDBDAORsltRtRoutHdrListVO1RSQL(){
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
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltRtRoutHdrListVO1RSQL").append("\n"); 
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
		query.append("SELECT /*+ LEADING(A) */" ).append("\n"); 
		query.append("A.PROP_NO" ).append("\n"); 
		query.append(",A.AMDT_SEQ" ).append("\n"); 
		query.append(",A.SVC_SCP_CD" ).append("\n"); 
		query.append(",A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",A.ROUT_SEQ" ).append("\n"); 
		query.append(",B.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append(",'') AS ORG_ROUT_PNT_LOC_DEF_CD_PROP" ).append("\n"); 
		query.append(",C.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append(",'') AS ORG_ROUT_VIA_PORT_DEF_CD_PROP" ).append("\n"); 
		query.append(",D.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append(",'') AS DEST_ROUT_VIA_PORT_DEF_CD_PROP" ).append("\n"); 
		query.append(",E.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append(",'') AS DEST_ROUT_PNT_LOC_DEF_CD_PROP" ).append("\n"); 
		query.append(",SUBSTR(REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', GRI') || REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', Surcharge') ||" ).append("\n"); 
		query.append("REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', DEM/DET') || REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', Others')" ).append("\n"); 
		query.append(",3) AS NOTE_CLSS_NM" ).append("\n"); 
		query.append(",DECODE(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append(",'') AS NOTE_CLSS_NM_PROP" ).append("\n"); 
		query.append(",REPLACE(F.NOTE_TOOLTIP, '^|^', CHR(13) || CHR(13)) AS NOTE_CLSS_NM_TOOLTIP" ).append("\n"); 
		query.append(",G.DIR_CALL_FLG" ).append("\n"); 
		query.append(",(NVL(B.ND_CNT, 0) + NVL(C.ND_CNT, 0) + NVL(D.ND_CNT, 0) + NVL(E.ND_CNT, 0) + NVL(F.ND_CNT, 0) +" ).append("\n"); 
		query.append("NVL(DECODE(G.SRC_INFO_CD, NULL, 0, 'AD', 0, 1), 0) + NVL(H.ND_CNT, 0)) AS ND_CNT" ).append("\n"); 
		query.append(",(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) +" ).append("\n"); 
		query.append("NVL(DECODE(G.PRC_PROG_STS_CD, NULL, 0, 'A', 0, DECODE(G.AMDT_SEQ, 0, 0, 1)), 0) + NVL(H.NA_CNT, 0)) AS NA_CNT" ).append("\n"); 
		query.append(",DECODE(A.AMDT_SEQ" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",DECODE(NVL(B.NA_CNT, 0) + NVL(C.NA_CNT, 0) + NVL(D.NA_CNT, 0) + NVL(E.NA_CNT, 0) + NVL(F.NA_CNT, 0) +" ).append("\n"); 
		query.append("NVL(DECODE(G.PRC_PROG_STS_CD, NULL, 0, 'A', 0, DECODE(G.AMDT_SEQ, 0, 0, 1)), 0) + NVL(H.NA_CNT, 0)" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",'color:red;')) AS ROW_PROPERTIES" ).append("\n"); 
		query.append(",A.NOTE_DP_SEQ" ).append("\n"); 
		query.append(",A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",A.N1ST_CMNC_AMDT_SEQ AS ORG_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append(",'1' || '.' || ROW_NUMBER() OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ ORDER BY B.SORT_KEY, E.SORT_KEY, C.SORT_KEY, D.SORT_KEY, G.DIR_CALL_FLG DESC) AS RN" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_CMDT_ROUT A" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ND_CNT" ).append("\n"); 
		query.append(",NA_CNT" ).append("\n"); 
		query.append(",SUBSTR(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', '), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD ||" ).append("\n"); 
		query.append("DECODE(RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",'0'" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",'1'" ).append("\n"); 
		query.append(",'D'" ).append("\n"); 
		query.append(",'2'" ).append("\n"); 
		query.append(",'S'" ).append("\n"); 
		query.append(",'3'" ).append("\n"); 
		query.append(",'T'" ).append("\n"); 
		query.append(",'4'" ).append("\n"); 
		query.append(",'I'" ).append("\n"); 
		query.append(",'5'" ).append("\n"); 
		query.append(",'L'" ).append("\n"); 
		query.append(",'6'" ).append("\n"); 
		query.append(",'O'" ).append("\n"); 
		query.append(",'7'" ).append("\n"); 
		query.append(",'U'" ).append("\n"); 
		query.append(",'8')" ).append("\n"); 
		query.append(",'|') AS SORT_KEY" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",SRC_INFO_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append(",COUNT(*) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) CNT" ).append("\n"); 
		query.append(",SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) ND_CNT" ).append("\n"); 
		query.append(",SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) NA_CNT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("WHERE LEVEL = CNT" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1) B" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ND_CNT" ).append("\n"); 
		query.append(",NA_CNT" ).append("\n"); 
		query.append(",SUBSTR(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', '), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|') AS SORT_KEY" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",SRC_INFO_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append(",COUNT(*) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) CNT" ).append("\n"); 
		query.append(",SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) ND_CNT" ).append("\n"); 
		query.append(",SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) NA_CNT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("WHERE LEVEL = CNT" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1) C" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ND_CNT" ).append("\n"); 
		query.append(",NA_CNT" ).append("\n"); 
		query.append(",SUBSTR(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', '), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|') AS SORT_KEY" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",SRC_INFO_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append(",COUNT(*) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) CNT" ).append("\n"); 
		query.append(",SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) ND_CNT" ).append("\n"); 
		query.append(",SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) NA_CNT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("WHERE LEVEL = CNT" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1) D" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ND_CNT" ).append("\n"); 
		query.append(",NA_CNT" ).append("\n"); 
		query.append(",SUBSTR(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', '), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD ||" ).append("\n"); 
		query.append("DECODE(RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",'0'" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",'1'" ).append("\n"); 
		query.append(",'D'" ).append("\n"); 
		query.append(",'2'" ).append("\n"); 
		query.append(",'S'" ).append("\n"); 
		query.append(",'3'" ).append("\n"); 
		query.append(",'T'" ).append("\n"); 
		query.append(",'4'" ).append("\n"); 
		query.append(",'I'" ).append("\n"); 
		query.append(",'5'" ).append("\n"); 
		query.append(",'L'" ).append("\n"); 
		query.append(",'6'" ).append("\n"); 
		query.append(",'O'" ).append("\n"); 
		query.append(",'7'" ).append("\n"); 
		query.append(",'U'" ).append("\n"); 
		query.append(",'8')" ).append("\n"); 
		query.append(",'|') AS SORT_KEY" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",SRC_INFO_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append(",COUNT(*) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) CNT" ).append("\n"); 
		query.append(",SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) ND_CNT" ).append("\n"); 
		query.append(",SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) NA_CNT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("WHERE LEVEL = CNT" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1) E" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ND_CNT" ).append("\n"); 
		query.append(",NA_CNT" ).append("\n"); 
		query.append(",SYS_CONNECT_BY_PATH(NOTE_CLSS_NM, ', ') AS NOTE_CLSS_NM" ).append("\n"); 
		query.append(",SUBSTR(SYS_CONNECT_BY_PATH(NOTE_TOOLTIP, '^|^'), 4) AS NOTE_TOOLTIP" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01711'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = NOTE_CLSS_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS NOTE_CLSS_NM" ).append("\n"); 
		query.append(",'<' || (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01711'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = NOTE_CLSS_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) || '>' || CHR(13) || NOTE_CTNT AS NOTE_TOOLTIP" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",SRC_INFO_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY DECODE(NOTE_CLSS_CD, 'G', '1', 'S', '2', 'D', '3', 'O', '4')) AS RN" ).append("\n"); 
		query.append(",COUNT(*) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ) CNT" ).append("\n"); 
		query.append(",SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ) ND_CNT" ).append("\n"); 
		query.append(",SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ) NA_CNT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq])" ).append("\n"); 
		query.append("WHERE LEVEL = CNT" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1) F" ).append("\n"); 
		query.append(",PRI_SP_SCP_RT_ROUT_DIR G" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append(",SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ) H" ).append("\n"); 
		query.append("WHERE A.PROP_NO = B.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = B.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = C.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = C.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = D.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = E.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = F.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = G.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = G.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = G.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = G.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = G.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = H.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = H.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = H.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = H.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = H.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = H.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("ORDER BY B.SORT_KEY, E.SORT_KEY, C.SORT_KEY, D.SORT_KEY, G.DIR_CALL_FLG DESC" ).append("\n"); 

	}
}