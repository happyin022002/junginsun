/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCRateProposalDBDAORsltRtRoutHdrInquiryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAORsltRtRoutHdrInquiryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate - Route조회
	  * </pre>
	  */
	public SCRateProposalDBDAORsltRtRoutHdrInquiryListVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltRtRoutHdrInquiryListVORSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_HASH(A B C D E F G) */" ).append("\n"); 
		query.append("       A.PROP_NO" ).append("\n"); 
		query.append("      ,A.AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("      ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("      ,A.ROUT_SEQ" ).append("\n"); 
		query.append("      ,B.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,C.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,D.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,E.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,SUBSTR(REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', GRI') ||" ).append("\n"); 
		query.append("              REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', Surcharge') ||" ).append("\n"); 
		query.append("              REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', DEM/DET') ||" ).append("\n"); 
		query.append("              REGEXP_SUBSTR(F.NOTE_CLSS_NM, ', Others')" ).append("\n"); 
		query.append("             ,3) AS NOTE_CLSS_NM" ).append("\n"); 
		query.append("      ,REPLACE(F.NOTE_TOOLTIP, '^|^', CHR(13) || CHR(13)) AS NOTE_CLSS_NM_TOOLTIP" ).append("\n"); 
		query.append("      ,G.DIR_CALL_FLG" ).append("\n"); 
		query.append("      ,A.NOTE_DP_SEQ" ).append("\n"); 
		query.append("      ,A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("      ,@[note_dp_seq] || '.' || ROW_NUMBER() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.GEN_SPCL_RT_TP_CD, A.CMDT_HDR_SEQ ORDER BY B.SORT_KEY, E.SORT_KEY, C.SORT_KEY, D.SORT_KEY, G.DIR_CALL_FLG DESC) AS RN" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_RT_CMDT_ROUT A" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("              ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("              ,ROUT_SEQ" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
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
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
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
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
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
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
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
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2') || ROUT_VIA_PORT_DEF_CD, '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
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
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
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
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2') || ROUT_PNT_LOC_DEF_CD || DECODE(RCV_DE_TERM_CD, NULL, '0', 'Y', '1', 'D', '2', 'S', '3', 'T', '4', 'I', '5', 'L', '6', 'O', '7', 'U', '8'), '|')) AS SORT_KEY" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
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
		query.append("                  FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
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
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(NOTE_CLSS_NM, ', ')) AS NOTE_CLSS_NM" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(NOTE_TOOLTIP, '^|^')), 4) AS NOTE_TOOLTIP" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
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
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, DECODE(NOTE_CLSS_CD, 'G', '1', 'S', '2', 'D', '3', 'O', '4')) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("                   AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
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
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("   AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("   AND G.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append(" ORDER BY A.ROUT_SEQ " ).append("\n"); 
		query.append("         ,B.SORT_KEY" ).append("\n"); 
		query.append("         ,E.SORT_KEY" ).append("\n"); 
		query.append("         ,C.SORT_KEY" ).append("\n"); 
		query.append("         ,D.SORT_KEY" ).append("\n"); 
		query.append("         ,G.DIR_CALL_FLG DESC" ).append("\n"); 

	}
}