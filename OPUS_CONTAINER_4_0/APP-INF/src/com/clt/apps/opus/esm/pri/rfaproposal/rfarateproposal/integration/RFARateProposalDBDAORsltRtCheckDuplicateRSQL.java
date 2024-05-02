/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateProposalDBDAORsltRtCheckDuplicateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.01 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltRtCheckDuplicateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Proposal Rate 중복 확인
	  * </pre>
	  */
	public RFARateProposalDBDAORsltRtCheckDuplicateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltRtCheckDuplicateRSQL").append("\n"); 
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
		query.append("WITH T AS (" ).append("\n"); 
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append(",A.AMDT_SEQ" ).append("\n"); 
		query.append(",A.SVC_SCP_CD" ).append("\n"); 
		query.append(",A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",A.ROUT_SEQ" ).append("\n"); 
		query.append(",A.RT_SEQ" ).append("\n"); 
		query.append(",B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",REPLACE(B.PRC_CMDT_DEF_NM, '|||', ' / ' || CHR(13)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",NVL(C.CUST_LGL_ENG_CD, '||') AS CUST_LGL_ENG_CD" ).append("\n"); 
		query.append(",REPLACE(C.CUST_LGL_ENG_NM, '|||', ' / ' || CHR(13)) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",D.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",REPLACE(D.ROUT_PNT_LOC_DEF_NM, '|||', CHR(13)) AS ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",NVL(E.ROUT_VIA_PORT_DEF_CD, '||') AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",REPLACE(E.ROUT_VIA_PORT_DEF_NM, '|||', CHR(13)) AS ORG_ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append(",NVL(F.ROUT_VIA_PORT_DEF_CD, '||') AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",REPLACE(F.ROUT_VIA_PORT_DEF_NM, '|||', CHR(13)) AS DEST_ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append(",G.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",REPLACE(G.ROUT_PNT_LOC_DEF_NM, '|||', CHR(13)) AS DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",A.RAT_UT_CD" ).append("\n"); 
		query.append(",A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, RT_SEQ, RAT_UT_CD, PRC_CGO_TP_CD, CURR_CD, PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD') A" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD, '||')) AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM, '|||')), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'R'" ).append("\n"); 
		query.append(",(SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'C'" ).append("\n"); 
		query.append(",(SELECT CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, DECODE(PRC_CMDT_TP_CD, 'G', 1, 'R', 2, 'C', 3, 99), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_CMDT A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ) B" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(CUST_CNT_CD || '|' || CUST_SEQ, '||')) AS CUST_LGL_ENG_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(CUST_LGL_ENG_NM, '|||')), 4) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ACT_CUST_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ) C" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || '|' || RCV_DE_TERM_CD, '||')) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_NM || NVL2(RCV_DE_TERM_NM, '(' || RCV_DE_TERM_NM || ')', '')" ).append("\n"); 
		query.append(",'|||'))" ).append("\n"); 
		query.append(",4) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_LOC" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'L'" ).append("\n"); 
		query.append(",(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_PNT A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) D" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '||')) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '|||')), 4) AS ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_VIA A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) E" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '||')) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '|||')), 4) AS ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_VIA A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) F" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || '|' || RCV_DE_TERM_CD, '||')) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_NM || NVL2(RCV_DE_TERM_NM, '(' || RCV_DE_TERM_NM || ')', '')" ).append("\n"); 
		query.append(",'|||'))" ).append("\n"); 
		query.append(",4) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_LOC" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'L'" ).append("\n"); 
		query.append(",(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_PNT A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) G" ).append("\n"); 
		query.append("WHERE A.PROP_NO = B.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = E.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = G.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = G.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = G.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = G.ROUT_SEQ(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append(",A.AMDT_SEQ" ).append("\n"); 
		query.append(",A.SVC_SCP_CD" ).append("\n"); 
		query.append(",A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",A.ROUT_SEQ" ).append("\n"); 
		query.append(",A.RT_SEQ" ).append("\n"); 
		query.append(",A.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",A.ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",A.ORG_ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append(",A.DEST_ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append(",A.DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",A.RAT_UT_CD" ).append("\n"); 
		query.append(",A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append(",DENSE_RANK() OVER(PARTITION BY NULL ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.PRC_CMDT_DEF_CD, A.CUST_LGL_ENG_CD, A.ORG_ROUT_PNT_LOC_DEF_CD, A.ORG_ROUT_VIA_PORT_DEF_CD, A.DEST_ROUT_VIA_PORT_DEF_CD, A.DEST_ROUT_PNT_LOC_DEF_CD, A.RAT_UT_CD, A.PRC_CGO_TP_CD) AS SEQ" ).append("\n"); 
		query.append(",'Show ' || CHR(64 + ROW_NUMBER() OVER(PARTITION BY A.PROP_NO" ).append("\n"); 
		query.append(",A.AMDT_SEQ" ).append("\n"); 
		query.append(",A.SVC_SCP_CD" ).append("\n"); 
		query.append(",A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",A.CUST_LGL_ENG_CD" ).append("\n"); 
		query.append(",A.ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",A.ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",A.DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",A.DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",A.RAT_UT_CD" ).append("\n"); 
		query.append(",A.PRC_CGO_TP_CD ORDER BY A.RT_SEQ)) AS VIEW_TEXT" ).append("\n"); 
		query.append("FROM T A" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",CUST_LGL_ENG_CD" ).append("\n"); 
		query.append(",ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",RAT_UT_CD" ).append("\n"); 
		query.append(",PRC_CGO_TP_CD" ).append("\n"); 
		query.append("FROM T" ).append("\n"); 
		query.append("GROUP BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",CUST_LGL_ENG_CD" ).append("\n"); 
		query.append(",ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",RAT_UT_CD" ).append("\n"); 
		query.append(",PRC_CGO_TP_CD" ).append("\n"); 
		query.append("HAVING COUNT(*) > 1) B" ).append("\n"); 
		query.append("WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.PRC_CMDT_DEF_CD = B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND A.CUST_LGL_ENG_CD = B.CUST_LGL_ENG_CD" ).append("\n"); 
		query.append("AND A.ORG_ROUT_PNT_LOC_DEF_CD = B.ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND A.ORG_ROUT_VIA_PORT_DEF_CD = B.ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("AND A.DEST_ROUT_VIA_PORT_DEF_CD = B.DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("AND A.DEST_ROUT_PNT_LOC_DEF_CD = B.DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND A.RAT_UT_CD = B.RAT_UT_CD" ).append("\n"); 
		query.append("AND A.PRC_CGO_TP_CD = B.PRC_CGO_TP_CD" ).append("\n"); 

	}
}