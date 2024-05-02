/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateProposalDBDAOViewAllRatesListTotalCntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.12.28 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOViewAllRatesListTotalCntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ViewAllRates Total Count
	  * </pre>
	  */
	public SCRateProposalDBDAOViewAllRatesListTotalCntVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOViewAllRatesListTotalCntVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(A.PROP_NO) AS CNT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_CMDT_HDR A" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM, '|||')), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",'C'" ).append("\n"); 
		query.append(",(SELECT CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, DECODE(PRC_CMDT_TP_CD, 'G', '1', 'C', '2'), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_CMDT A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ) B" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(CUST_LGL_ENG_NM, '|||')), 4) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("AND CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ACT_CUST_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ) C" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(NOTE_CTNT, '|||')), 4) AS CNOTE_CTNT" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",NOTE_CTNT" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, DECODE(NOTE_CLSS_CD, 'G', '1', 'S', '2', 'D', '3', 'O', '4'), CMDT_NOTE_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ) D" ).append("\n"); 
		query.append(",PRI_SP_SCP_RT_CMDT_ROUT E" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || NVL2(RCV_DE_TERM_CD, '(' || RCV_DE_TERM_CD || ')', ''), '|||')), 4) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CNT_CD, '|||')), 4) AS ROUT_PNT_LOC_CNT_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_STE_CD, '|||')), 4) AS ROUT_PNT_LOC_STE_CD" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",'L'" ).append("\n"); 
		query.append(",(SELECT CNT_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_CNT_CD" ).append("\n"); 
		query.append(",DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",'L'" ).append("\n"); 
		query.append(",(SELECT STE_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = DECODE(SUBSTR(A.ROUT_PNT_LOC_DEF_CD,1,2),'US',A.ROUT_PNT_LOC_DEF_CD,'')" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_STE_CD" ).append("\n"); 
		query.append(",DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_LOC" ).append("\n"); 
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
		query.append("AND ROWNUM = 1) AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ROUT_PNT A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) F" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '|||')), 4) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ROUT_VIA A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) G" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '|||')), 4) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ROUT_VIA A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) H" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || NVL2(RCV_DE_TERM_CD, '(' || RCV_DE_TERM_CD || ')', ''), '|||')), 4) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CNT_CD, '|||')), 4) AS ROUT_PNT_LOC_CNT_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_STE_CD, '|||')), 4) AS ROUT_PNT_LOC_STE_CD" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",'L'" ).append("\n"); 
		query.append(",(SELECT CNT_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_CNT_CD" ).append("\n"); 
		query.append(",DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",'L'" ).append("\n"); 
		query.append(",(SELECT STE_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = DECODE(SUBSTR(A.ROUT_PNT_LOC_DEF_CD,1,2),'US',A.ROUT_PNT_LOC_DEF_CD,'')" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_STE_CD" ).append("\n"); 
		query.append(",DECODE(ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_LOC" ).append("\n"); 
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
		query.append("AND ROWNUM = 1) AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ROUT_PNT A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD) I" ).append("\n"); 
		query.append(",(SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(NOTE_CTNT, '|||')), 4) AS RNOTE_CTNT" ).append("\n"); 
		query.append("FROM (SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",NOTE_CTNT" ).append("\n"); 
		query.append(",PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ, DECODE(NOTE_CLSS_CD, 'G', '1', 'S', '2', 'D', '3', 'O', '4'), ROUT_NOTE_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT_HDR_SEQ = CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, CMDT_HDR_SEQ, ROUT_SEQ) J" ).append("\n"); 
		query.append(",PRI_SP_SCP_RT K" ).append("\n"); 
		query.append("WHERE A.PROP_NO = B.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = C.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = D.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = E.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND E.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("AND E.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND E.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND E.GEN_SPCL_RT_TP_CD = F.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND E.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND E.ROUT_SEQ = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND E.PROP_NO = G.PROP_NO(+)" ).append("\n"); 
		query.append("AND E.AMDT_SEQ = G.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND E.SVC_SCP_CD = G.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND E.GEN_SPCL_RT_TP_CD = G.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND E.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND E.ROUT_SEQ = G.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND E.PROP_NO = H.PROP_NO(+)" ).append("\n"); 
		query.append("AND E.AMDT_SEQ = H.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND E.SVC_SCP_CD = H.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND E.GEN_SPCL_RT_TP_CD = H.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND E.CMDT_HDR_SEQ = H.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND E.ROUT_SEQ = H.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND E.PROP_NO = I.PROP_NO(+)" ).append("\n"); 
		query.append("AND E.AMDT_SEQ = I.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND E.SVC_SCP_CD = I.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND E.GEN_SPCL_RT_TP_CD = I.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND E.CMDT_HDR_SEQ = I.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND E.ROUT_SEQ = I.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND E.PROP_NO = J.PROP_NO(+)" ).append("\n"); 
		query.append("AND E.AMDT_SEQ = J.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND E.SVC_SCP_CD = J.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND E.GEN_SPCL_RT_TP_CD = J.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND E.CMDT_HDR_SEQ = J.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND E.ROUT_SEQ = J.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND E.PROP_NO = K.PROP_NO(+)" ).append("\n"); 
		query.append("AND E.AMDT_SEQ = K.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND E.SVC_SCP_CD = K.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND E.GEN_SPCL_RT_TP_CD = K.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND E.CMDT_HDR_SEQ = K.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND E.ROUT_SEQ = K.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND K.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 

	}
}