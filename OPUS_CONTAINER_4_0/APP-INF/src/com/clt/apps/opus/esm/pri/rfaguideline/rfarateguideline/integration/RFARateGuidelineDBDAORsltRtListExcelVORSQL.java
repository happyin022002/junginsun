/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateGuidelineDBDAORsltRtListExcelVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.08.06 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateGuidelineDBDAORsltRtListExcelVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate 엑셀 조회
	  * </pre>
	  */
	public RFARateGuidelineDBDAORsltRtListExcelVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.integration").append("\n"); 
		query.append("FileName : RFARateGuidelineDBDAORsltRtListExcelVORSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD," ).append("\n"); 
		query.append("A.GLINE_SEQ," ).append("\n"); 
		query.append("A.CMDT_HDR_SEQ," ).append("\n"); 
		query.append("TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') AS EXP_DT," ).append("\n"); 
		query.append("B.CMDT_SEQ," ).append("\n"); 
		query.append("B.PRC_CMDT_DEF_CD," ).append("\n"); 
		query.append("C.ROUT_SEQ," ).append("\n"); 
		query.append("--       C.DIR_CALL_FLG," ).append("\n"); 
		query.append("E.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("F.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("G.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("H.ROUT_PNT_LOC_DEF_CD AS DEST_ORG_ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("D.RT_SEQ," ).append("\n"); 
		query.append("--       D.MQC_RNG_FM_QTY," ).append("\n"); 
		query.append("--       D.MQC_RNG_TO_QTY," ).append("\n"); 
		query.append("D.RAT_UT_CD," ).append("\n"); 
		query.append("D.PRC_CGO_TP_CD," ).append("\n"); 
		query.append("D.CURR_CD," ).append("\n"); 
		query.append("D.FRT_RT_AMT" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_HDR A," ).append("\n"); 
		query.append("PRI_RG_RT_CMDT B," ).append("\n"); 
		query.append("PRI_RG_RT_CMDT_ROUT C," ).append("\n"); 
		query.append("PRI_RG_RT D," ).append("\n"); 
		query.append("(SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ';')), 2) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("FROM (SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("ORG_DEST_TP_CD," ).append("\n"); 
		query.append("ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_PNT_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ) E," ).append("\n"); 
		query.append("(SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ';')), 2) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM (SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("ORG_DEST_TP_CD," ).append("\n"); 
		query.append("ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_VIA_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ) F," ).append("\n"); 
		query.append("(SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ';')), 2) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM (SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("ORG_DEST_TP_CD," ).append("\n"); 
		query.append("ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_VIA_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ) G," ).append("\n"); 
		query.append("(SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ';')), 2) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("FROM (SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("ORG_DEST_TP_CD," ).append("\n"); 
		query.append("ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("ROW_NUMBER() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ROUT_PNT_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD," ).append("\n"); 
		query.append("GLINE_SEQ," ).append("\n"); 
		query.append("CMDT_HDR_SEQ," ).append("\n"); 
		query.append("ROUT_SEQ) H" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = C.GLINE_SEQ" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND C.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND C.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND C.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND C.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("AND C.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("AND C.GLINE_SEQ = E.GLINE_SEQ" ).append("\n"); 
		query.append("AND C.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND C.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("AND C.SVC_SCP_CD = F.SVC_SCP_CD" ).append("\n"); 
		query.append("AND C.GLINE_SEQ = F.GLINE_SEQ" ).append("\n"); 
		query.append("AND C.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND C.ROUT_SEQ = F.ROUT_SEQ" ).append("\n"); 
		query.append("AND C.SVC_SCP_CD = G.SVC_SCP_CD" ).append("\n"); 
		query.append("AND C.GLINE_SEQ = G.GLINE_SEQ" ).append("\n"); 
		query.append("AND C.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND C.ROUT_SEQ = G.ROUT_SEQ" ).append("\n"); 
		query.append("AND C.SVC_SCP_CD = H.SVC_SCP_CD" ).append("\n"); 
		query.append("AND C.GLINE_SEQ = H.GLINE_SEQ" ).append("\n"); 
		query.append("AND C.CMDT_HDR_SEQ = H.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND C.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 

	}
}