/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateProposalDBDAORsltPriSurchargeViewAllVORSQL.java
*@FileTitle : RFA Proposal/Amendment Surcharge View All
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.21 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltPriSurchargeViewAllVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    S/C Proposal/Amendment Surcharge View All
	  * </pre>
	  */
	public RFARateProposalDBDAORsltPriSurchargeViewAllVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltPriSurchargeViewAllVORSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("	A.PROP_NO" ).append("\n"); 
		query.append("	,A.AMDT_SEQ" ).append("\n"); 
		query.append("	,A.SVC_SCP_CD" ).append("\n"); 
		query.append("	,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,A.ROUT_SEQ" ).append("\n"); 
		query.append("	,RT.RT_SEQ" ).append("\n"); 
		query.append("	,I.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("	,NVL(ACT_CUST.CUST_LGL_ENG_NM,' ') AS ACT_CUST_NM" ).append("\n"); 
		query.append("	,NVL(B.ROUT_PNT_LOC_DEF_CD ,' ') AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	,NVL(C.ROUT_VIA_PORT_DEF_CD ,' ') AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,NVL(D.ROUT_VIA_PORT_DEF_CD ,' ') AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,NVL(E.ROUT_PNT_LOC_DEF_CD ,' ') AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,NVL(REPLACE(F.NOTE_CTNT      , '^|^', '' ) ,' ')   AS RNOTE_CTNT       " ).append("\n"); 
		query.append("	,NVL(REPLACE(H.NOTE_CTNT      , '^|^', '' ) ,' ')   AS CNOTE_CTNT       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,RT.RAT_UT_CD" ).append("\n"); 
		query.append("	,RT.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	,RT.CURR_CD AS RATE_CURR_CD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,DECODE(RT.PRC_PROG_STS_CD, 'R', RT.COFFR_FRT_RT_AMT, RT.PROP_FRT_RT_AMT) AS  FRT_RT_AMT" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	, NVL( SCG.POR_CD ,' ') AS POR_CD" ).append("\n"); 
		query.append("	, NVL( SCG.POL_CD ,' ') AS POL_CD" ).append("\n"); 
		query.append("	, NVL( SCG.POD_CD ,' ') AS POD_CD" ).append("\n"); 
		query.append("	, NVL( SCG.DEL_CD ,' ') AS DEL_CD" ).append("\n"); 
		query.append("	, SCG.TOT_SURCHARGE" ).append("\n"); 
		query.append("	, SCG.CRE_YMD " ).append("\n"); 
		query.append("	, SCG.CHG_CD " ).append("\n"); 
		query.append("	, SCG.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("	, SCG.CURR_CD AS SURCHARGE_CURR_CD" ).append("\n"); 
		query.append("	, SCG.TRF_SCG_AMT" ).append("\n"); 
		query.append("	, SCG.ADJ_SCG_AMT" ).append("\n"); 
		query.append("	, SCG.ADJ_SCG_USD_AMT" ).append("\n"); 
		query.append("	,A.NOTE_DP_SEQ" ).append("\n"); 
		query.append("	,A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("	,A.N1ST_CMNC_AMDT_SEQ AS ORG_N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("	,A.CRE_USR_ID" ).append("\n"); 
		query.append("	,A.CRE_DT" ).append("\n"); 
		query.append("	,A.UPD_USR_ID" ).append("\n"); 
		query.append("	,A.UPD_DT" ).append("\n"); 
		query.append("	, DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.CMDT_HDR_SEQ ) AS SEQ" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_CMDT_ROUT A" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("		SELECT PROP_NO" ).append("\n"); 
		query.append("		      ,AMDT_SEQ" ).append("\n"); 
		query.append("		      ,SVC_SCP_CD" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,ROUT_SEQ" ).append("\n"); 
		query.append("		      ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(PRC_PROG_STS_CD, 'A', DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0), 0)) AS UP_AC_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("		      ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD ||  DECODE(RCV_DE_TERM_CD, NULL,'', '(' || TERM_NM || ')' ), ', ')), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("		      ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("		  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("			      ,AMDT_SEQ" ).append("\n"); 
		query.append("			      ,SVC_SCP_CD" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,ROUT_SEQ" ).append("\n"); 
		query.append("			      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			      ,ROUT_PNT_LOC_DEF_CD " ).append("\n"); 
		query.append("			      ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("			      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("			      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("			      ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM " ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("			 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			   AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY PROP_NO" ).append("\n"); 
		query.append("			 ,AMDT_SEQ" ).append("\n"); 
		query.append("			 ,SVC_SCP_CD" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			 ,ROUT_SEQ" ).append("\n"); 
		query.append("			 ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("	) B" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("		SELECT PROP_NO" ).append("\n"); 
		query.append("		      ,AMDT_SEQ" ).append("\n"); 
		query.append("		      ,SVC_SCP_CD" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,ROUT_SEQ" ).append("\n"); 
		query.append("		      ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(PRC_PROG_STS_CD, 'A', DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0), 0)) AS UP_AC_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("		      ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("		      ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("		  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("			      ,AMDT_SEQ" ).append("\n"); 
		query.append("			      ,SVC_SCP_CD" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,ROUT_SEQ" ).append("\n"); 
		query.append("			      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			      ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("			      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("			 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			   AND SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append("			   AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY PROP_NO" ).append("\n"); 
		query.append("			 ,AMDT_SEQ" ).append("\n"); 
		query.append("			 ,SVC_SCP_CD" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			 ,ROUT_SEQ" ).append("\n"); 
		query.append("			 ,ORG_DEST_TP_CD	" ).append("\n"); 
		query.append("	) C" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("		SELECT PROP_NO" ).append("\n"); 
		query.append("		      ,AMDT_SEQ" ).append("\n"); 
		query.append("		      ,SVC_SCP_CD" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,ROUT_SEQ" ).append("\n"); 
		query.append("		      ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(PRC_PROG_STS_CD, 'A', DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0), 0)) AS UP_AC_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("		      ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD  , ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("		      ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("		  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("			      ,AMDT_SEQ" ).append("\n"); 
		query.append("			      ,SVC_SCP_CD" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,ROUT_SEQ" ).append("\n"); 
		query.append("			      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			      ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("			      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("			 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			   AND SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append("			   AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY PROP_NO" ).append("\n"); 
		query.append("			 ,AMDT_SEQ" ).append("\n"); 
		query.append("			 ,SVC_SCP_CD" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			 ,ROUT_SEQ" ).append("\n"); 
		query.append("			 ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("	) D" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("	      SELECT PROP_NO" ).append("\n"); 
		query.append("		      ,AMDT_SEQ" ).append("\n"); 
		query.append("		      ,SVC_SCP_CD" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,ROUT_SEQ" ).append("\n"); 
		query.append("		      ,SUM(DECODE(SRC_INFO_CD, 'AD', 0, 1)) AS ND_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(PRC_PROG_STS_CD, 'A', 0, 1)) AS NA_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(PRC_PROG_STS_CD, 'A', DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0), 0)) AS UP_AC_CNT" ).append("\n"); 
		query.append("		      ,SUM(DECODE(AMDT_SEQ, N1ST_CMNC_AMDT_SEQ, 1, 0)) AS UP_CNT" ).append("\n"); 
		query.append("		      ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD ||  DECODE(RCV_DE_TERM_CD, NULL,'', '(' || TERM_NM || ')' ) , ', ')), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("		      ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("		  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("			      ,AMDT_SEQ" ).append("\n"); 
		query.append("			      ,SVC_SCP_CD" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,ROUT_SEQ" ).append("\n"); 
		query.append("			      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			      ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("			      ,ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("			      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("			      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("			       ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM " ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("			 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			   AND SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append("			   AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY PROP_NO" ).append("\n"); 
		query.append("			 ,AMDT_SEQ" ).append("\n"); 
		query.append("			 ,SVC_SCP_CD" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			 ,ROUT_SEQ" ).append("\n"); 
		query.append("			 ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("	) E" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("		SELECT PROP_NO" ).append("\n"); 
		query.append("		      ,AMDT_SEQ" ).append("\n"); 
		query.append("		      ,SVC_SCP_CD" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,ROUT_SEQ" ).append("\n"); 
		query.append("		      , SUBSTR( MAX(SYS_CONNECT_BY_PATH(NOTE_CTNT, '^|^')), 4)   AS NOTE_CTNT" ).append("\n"); 
		query.append("		  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("			      ,AMDT_SEQ" ).append("\n"); 
		query.append("			      ,SVC_SCP_CD" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,ROUT_SEQ" ).append("\n"); 
		query.append("			      --,SUBSTRB(NOTE_CTNT,0,497)|| CHR(13) || CASE WHEN LENGTHB(NOTE_CTNT)<497 THEN '' ELSE '...' END AS NOTE_CTNT" ).append("\n"); 
		query.append("			      ,NOTE_CTNT || CHR(13)  AS NOTE_CTNT" ).append("\n"); 
		query.append("			      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ROUT_SEQ ) AS RN" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("			 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			   AND SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY PROP_NO" ).append("\n"); 
		query.append("			 ,AMDT_SEQ" ).append("\n"); 
		query.append("			 ,SVC_SCP_CD" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			 ,ROUT_SEQ" ).append("\n"); 
		query.append("	) F" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("		SELECT PROP_NO" ).append("\n"); 
		query.append("		      ,AMDT_SEQ" ).append("\n"); 
		query.append("		      ,SVC_SCP_CD" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      , SUBSTR( MAX(SYS_CONNECT_BY_PATH(NOTE_CTNT, '^|^')), 4)   AS NOTE_CTNT" ).append("\n"); 
		query.append("		  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("			      ,AMDT_SEQ" ).append("\n"); 
		query.append("			      ,SVC_SCP_CD" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			       --,SUBSTRB(NOTE_CTNT,0,497)|| CHR(13) || CASE WHEN LENGTHB(NOTE_CTNT)<497 THEN '' ELSE '...' END AS NOTE_CTNT" ).append("\n"); 
		query.append("			      ,NOTE_CTNT || CHR(13)  AS NOTE_CTNT" ).append("\n"); 
		query.append("			      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ  ) AS RN" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("			 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY PROP_NO" ).append("\n"); 
		query.append("			 ,AMDT_SEQ" ).append("\n"); 
		query.append("			 ,SVC_SCP_CD" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	) H" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("		SELECT PROP_NO" ).append("\n"); 
		query.append("		      ,AMDT_SEQ" ).append("\n"); 
		query.append("		      ,SVC_SCP_CD" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM, ' / ')), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("		  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("			      ,AMDT_SEQ" ).append("\n"); 
		query.append("			      ,SVC_SCP_CD" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("				     ,'G'" ).append("\n"); 
		query.append("				     ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("					FROM PRI_RP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("				       WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("					 AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("					 AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("					 AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("					 AND ROWNUM = 1)" ).append("\n"); 
		query.append("				     ,'R'" ).append("\n"); 
		query.append("				     ,(SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("					FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("				       WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("					 AND ROWNUM = 1)" ).append("\n"); 
		query.append("				     ,'C'" ).append("\n"); 
		query.append("				     ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("					FROM MDM_COMMODITY" ).append("\n"); 
		query.append("				       WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("					 AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("			      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, DECODE(PRC_CMDT_TP_CD, 'G', '1', 'C', '2'), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_CMDT A" ).append("\n"); 
		query.append("			 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			   AND SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY PROP_NO" ).append("\n"); 
		query.append("			 ,AMDT_SEQ" ).append("\n"); 
		query.append("			 ,SVC_SCP_CD" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ) I" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("		SELECT 	PRI_ROUT.PROP_NO, PRI_ROUT.AMDT_SEQ, PRI_ROUT.SVC_SCP_CD" ).append("\n"); 
		query.append("			, PRI_ROUT.CMDT_HDR_SEQ, PRI_ROUT.ROUT_SEQ, PRI_ROUT.RT_SEQ" ).append("\n"); 
		query.append("			, PRI_ROUT.POR_CD, PRI_ROUT.POL_CD, PRI_ROUT.POD_CD, PRI_ROUT.DEL_CD" ).append("\n"); 
		query.append("			, TO_CHAR(PRI_ROUT.CRE_DT,'YYYY-MM-DD') CRE_YMD " ).append("\n"); 
		query.append("			, PRI_SCG.CHG_CD " ).append("\n"); 
		query.append("			, PRI_SCG.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("			, PRI_SCG.CURR_CD" ).append("\n"); 
		query.append("			, PRI_SCG.TRF_SCG_AMT" ).append("\n"); 
		query.append("			, PRI_SCG.ADJ_SCG_AMT" ).append("\n"); 
		query.append("			, PRI_SCG.ADJ_SCG_USD_AMT" ).append("\n"); 
		query.append("			, SUM( PRI_SCG.ADJ_SCG_USD_AMT ) OVER( PARTITION BY PRI_ROUT.PROP_NO, PRI_ROUT.AMDT_SEQ, PRI_ROUT.SVC_SCP_CD, PRI_ROUT.CMDT_HDR_SEQ, PRI_ROUT.ROUT_SEQ, PRI_ROUT.RT_SEQ ) AS TOT_SURCHARGE" ).append("\n"); 
		query.append("		FROM PRI_RP_SCP_RT_SCG_ROUT PRI_ROUT" ).append("\n"); 
		query.append("			, PRI_RP_SCP_RT_SCG PRI_SCG" ).append("\n"); 
		query.append("		WHERE" ).append("\n"); 
		query.append("			PRI_ROUT.PROP_NO = PRI_SCG.PROP_NO" ).append("\n"); 
		query.append("			AND PRI_ROUT.AMDT_SEQ = PRI_SCG.AMDT_SEQ" ).append("\n"); 
		query.append("			AND PRI_ROUT.SVC_SCP_CD = PRI_SCG.SVC_SCP_CD" ).append("\n"); 
		query.append("			AND PRI_ROUT.CMDT_HDR_SEQ = PRI_SCG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			AND PRI_ROUT.ROUT_SEQ = PRI_SCG.ROUT_SEQ" ).append("\n"); 
		query.append("			AND PRI_ROUT.RT_SEQ = PRI_SCG.RT_SEQ" ).append("\n"); 
		query.append("			AND PRI_ROUT.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND PRI_ROUT.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND PRI_ROUT.SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ) SCG" ).append("\n"); 
		query.append("      , (      " ).append("\n"); 
		query.append("		SELECT PROP_NO" ).append("\n"); 
		query.append("		      ,AMDT_SEQ" ).append("\n"); 
		query.append("		      ,SVC_SCP_CD" ).append("\n"); 
		query.append("		      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		      ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(CUST_LGL_ENG_NM, '^|^')), 4) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("		  FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("			      ,AMDT_SEQ" ).append("\n"); 
		query.append("			      ,SVC_SCP_CD" ).append("\n"); 
		query.append("			      ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			      ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("				  FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("				 WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("				   AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("				   AND ROWNUM = 1) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("			      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("			      ,SRC_INFO_CD" ).append("\n"); 
		query.append("			      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("			      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, CMDT_HDR_SEQ, ACT_CUST_SEQ) AS RN" ).append("\n"); 
		query.append("			  FROM PRI_RP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("			 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			   AND SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		 START WITH RN = 1" ).append("\n"); 
		query.append("		CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		 GROUP BY PROP_NO" ).append("\n"); 
		query.append("			 ,AMDT_SEQ" ).append("\n"); 
		query.append("			 ,SVC_SCP_CD" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ) ACT_CUST" ).append("\n"); 
		query.append("      , PRI_RP_SCP_RT RT" ).append("\n"); 
		query.append(" WHERE  I.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("	AND I.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("	AND I.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND I.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	AND A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.PROP_NO = RT.PROP_NO" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = RT.AMDT_SEQ" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	AND A.ROUT_SEQ = RT.ROUT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND RT.PROP_NO = SCG.PROP_NO(+)" ).append("\n"); 
		query.append("	AND RT.AMDT_SEQ = SCG.AMDT_SEQ(+)" ).append("\n"); 
		query.append("	AND RT.SVC_SCP_CD = SCG.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	AND RT.CMDT_HDR_SEQ = SCG.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	AND RT.ROUT_SEQ = SCG.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	AND RT.RT_SEQ = SCG.RT_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND I.PROP_NO = ACT_CUST.PROP_NO(+)" ).append("\n"); 
		query.append("	AND I.AMDT_SEQ = ACT_CUST.AMDT_SEQ(+)" ).append("\n"); 
		query.append("	AND I.SVC_SCP_CD = ACT_CUST.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	AND I.CMDT_HDR_SEQ = ACT_CUST.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	AND A.ROUT_SEQ = C.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	AND A.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	AND A.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	AND A.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("	AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	AND A.ROUT_SEQ = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("	AND A.PROP_NO = H.PROP_NO(+)" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = H.AMDT_SEQ(+)" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD = H.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("	AND A.CMDT_HDR_SEQ = H.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("	AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	AND A.SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append(" ORDER BY  A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,I.PRC_CMDT_DEF_NM || A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,B.ROUT_PNT_LOC_DEF_CD || A.ROUT_SEQ" ).append("\n"); 
		query.append("	,C.ROUT_VIA_PORT_DEF_CD || A.ROUT_SEQ" ).append("\n"); 
		query.append("	,D.ROUT_VIA_PORT_DEF_CD || A.ROUT_SEQ" ).append("\n"); 
		query.append("	,E.ROUT_PNT_LOC_DEF_CD  || A.ROUT_SEQ" ).append("\n"); 
		query.append("	,RT.RAT_UT_CD    || RT.RT_SEQ" ).append("\n"); 
		query.append("	,RT.PRC_CGO_TP_CD || RT.RT_SEQ" ).append("\n"); 
		query.append("	,RT.CURR_CD       || RT.RT_SEQ" ).append("\n"); 
		query.append("	, SCG.POR_CD" ).append("\n"); 
		query.append("	, SCG.POL_CD" ).append("\n"); 
		query.append("	, SCG.POD_CD" ).append("\n"); 
		query.append("	, SCG.DEL_CD" ).append("\n"); 
		query.append("	, SCG.CHG_CD" ).append("\n"); 

	}
}