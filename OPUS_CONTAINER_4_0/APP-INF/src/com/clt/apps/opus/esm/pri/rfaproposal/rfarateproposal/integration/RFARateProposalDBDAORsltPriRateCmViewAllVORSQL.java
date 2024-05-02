/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RFARateProposalDBDAORsltPriRateCmViewAllVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2011.02.28 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltPriRateCmViewAllVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    S/C Quotation/Proposal 시점, CM/OP View All 팝업 화면
	  * </pre>
	  */
	public RFARateProposalDBDAORsltPriRateCmViewAllVORSQL(){
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
		query.append("FileName : RFARateProposalDBDAORsltPriRateCmViewAllVORSQL").append("\n"); 
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
		query.append("WITH VW_PRI_RP_SCP_RT_CMDT  AS (" ).append("\n"); 
		query.append("	SELECT 	 CMDT.PROP_NO,CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("		,CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("		,CMDT.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("		,SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD , '; ')),3) AS PRC_CMDT_DEF_CD " ).append("\n"); 
		query.append("		,SUBSTR(MAX(SYS_CONNECT_BY_PATH(REPLACE(PRC_CMDT_DEF_NM,';',':') , '; ')),3) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD" ).append("\n"); 
		query.append("			 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,CMDT_SEQ,PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("            ,DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                ,'G'" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                        SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                        FROM PRI_RP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("                        WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                        AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                        AND ROWNUM = 1" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("                ,'R'" ).append("\n"); 
		query.append("                ,(      SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("                        FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("                        WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                        AND ROWNUM = 1" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                ,'C'" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                        SELECT CMDT_NM" ).append("\n"); 
		query.append("                        FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                        WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                        AND ROWNUM = 1" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            ) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("						ORDER BY PRC_CMDT_TP_CD DESC,PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,CMDT_SEQ) AS RN" ).append("\n"); 
		query.append("		FROM PRI_RP_SCP_RT_CMDT A" ).append("\n"); 
		query.append("		WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	) CMDT" ).append("\n"); 
		query.append("	START WITH RN = 1 " ).append("\n"); 
		query.append("	CONNECT BY PRIOR CMDT.CMDT_HDR_SEQ = CMDT.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("		AND PRIOR  CMDT.RN = CMDT.RN - 1" ).append("\n"); 
		query.append("	GROUP BY CMDT.PROP_NO" ).append("\n"); 
		query.append("		,CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("		,CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("		,CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_RP_SCP_RT_ACT_CUST  AS (" ).append("\n"); 
		query.append("	SELECT 	 ACT_CUST.PROP_NO,ACT_CUST.AMDT_SEQ" ).append("\n"); 
		query.append("		,ACT_CUST.SVC_SCP_CD " ).append("\n"); 
		query.append("		,ACT_CUST.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("		,SUBSTR(MAX(SYS_CONNECT_BY_PATH(CUST_CD , '; ')),3) AS CUST_CD " ).append("\n"); 
		query.append("		,SUBSTR(MAX(SYS_CONNECT_BY_PATH(REPLACE(CUST_NM,';',':') , '; ')),3) AS CUST_NM" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ACT_CUST_SEQ" ).append("\n"); 
		query.append("            ,CUST_CNT_CD || TO_CHAR(CUST_SEQ,'FM0000000') AS CUST_CD" ).append("\n"); 
		query.append("	        ,(" ).append("\n"); 
		query.append("                SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("        	) AS CUST_NM" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("						ORDER BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ACT_CUST_SEQ) AS RN" ).append("\n"); 
		query.append("		FROM PRI_RP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("		WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	) ACT_CUST" ).append("\n"); 
		query.append("	START WITH RN = 1 " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ACT_CUST.CMDT_HDR_SEQ = ACT_CUST.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("		AND PRIOR  ACT_CUST.RN = ACT_CUST.RN - 1" ).append("\n"); 
		query.append("	GROUP BY ACT_CUST.PROP_NO" ).append("\n"); 
		query.append("		,ACT_CUST.AMDT_SEQ" ).append("\n"); 
		query.append("		,ACT_CUST.SVC_SCP_CD" ).append("\n"); 
		query.append("		,ACT_CUST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_RP_SCP_RT_ROUT_PNT_ORI AS (" ).append("\n"); 
		query.append(" 	SELECT  ROUT_PNT.PROP_NO,ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.SVC_SCP_CD " ).append("\n"); 
		query.append("		,ROUT_PNT.CMDT_HDR_SEQ, ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		, SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || DECODE(TERM_NM,'','','(' || TERM_NM || ')') , '; ')),3) AS ROUT_PNT_LOC_DEF_CD " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO,AMDT_SEQ	,SVC_SCP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_SEQ" ).append("\n"); 
		query.append("							,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("						ORDER BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_PNT_SEQ) AS RN" ).append("\n"); 
		query.append("			,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM " ).append("\n"); 
		query.append("		FROM PRI_RP_SCP_RT_ROUT_PNT " ).append("\n"); 
		query.append("		WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("	) ROUT_PNT" ).append("\n"); 
		query.append("	START WITH RN = 1 " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROUT_PNT.ROUT_SEQ = ROUT_PNT.ROUT_SEQ " ).append("\n"); 
		query.append("		AND PRIOR ROUT_PNT.ORG_DEST_TP_CD = ROUT_PNT.ORG_DEST_TP_CD " ).append("\n"); 
		query.append("		AND PRIOR ROUT_PNT.CMDT_HDR_SEQ = ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		AND PRIOR  ROUT_PNT.RN = ROUT_PNT.RN - 1" ).append("\n"); 
		query.append("	GROUP BY ROUT_PNT.PROP_NO" ).append("\n"); 
		query.append("		,ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.SVC_SCP_CD" ).append("\n"); 
		query.append("		,ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(" )," ).append("\n"); 
		query.append(" VW_PRI_RP_SCP_RT_ROUT_PNT_DEST AS (" ).append("\n"); 
		query.append(" 	SELECT  ROUT_PNT.PROP_NO,ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.SVC_SCP_CD " ).append("\n"); 
		query.append("		,ROUT_PNT.CMDT_HDR_SEQ, ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		, SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || DECODE(TERM_NM,'','','(' || TERM_NM || ')') , '; ')),3) AS ROUT_PNT_LOC_DEF_CD " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO,AMDT_SEQ	,SVC_SCP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_SEQ" ).append("\n"); 
		query.append("							,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("						ORDER BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_PNT_SEQ) AS RN" ).append("\n"); 
		query.append("			,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM " ).append("\n"); 
		query.append("		FROM PRI_RP_SCP_RT_ROUT_PNT " ).append("\n"); 
		query.append("		WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("	) ROUT_PNT" ).append("\n"); 
		query.append("	START WITH RN = 1 " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROUT_PNT.ROUT_SEQ = ROUT_PNT.ROUT_SEQ " ).append("\n"); 
		query.append("		AND PRIOR ROUT_PNT.ORG_DEST_TP_CD = ROUT_PNT.ORG_DEST_TP_CD " ).append("\n"); 
		query.append("		AND PRIOR ROUT_PNT.CMDT_HDR_SEQ = ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		AND PRIOR  ROUT_PNT.RN = ROUT_PNT.RN - 1" ).append("\n"); 
		query.append("	GROUP BY ROUT_PNT.PROP_NO" ).append("\n"); 
		query.append("		,ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.SVC_SCP_CD" ).append("\n"); 
		query.append("		,ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_RP_SCP_RT_ROUT_VIA_ORI AS (" ).append("\n"); 
		query.append("	SELECT 	 ROUT_VIA.PROP_NO,ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.SVC_SCP_CD " ).append("\n"); 
		query.append("		,ROUT_VIA.CMDT_HDR_SEQ, ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD , '; ')),3) AS ROUT_VIA_PORT_DEF_CD " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_SEQ" ).append("\n"); 
		query.append("							,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("						ORDER BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_VIA_SEQ) AS RN" ).append("\n"); 
		query.append("		FROM PRI_RP_SCP_RT_ROUT_VIA " ).append("\n"); 
		query.append("		WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("	) ROUT_VIA" ).append("\n"); 
		query.append("	START WITH RN = 1 " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROUT_VIA.ROUT_SEQ = ROUT_VIA.ROUT_SEQ " ).append("\n"); 
		query.append("		AND PRIOR ROUT_VIA.ORG_DEST_TP_CD = ROUT_VIA.ORG_DEST_TP_CD " ).append("\n"); 
		query.append("		AND PRIOR ROUT_VIA.CMDT_HDR_SEQ = ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		AND PRIOR  ROUT_VIA.RN = ROUT_VIA.RN - 1" ).append("\n"); 
		query.append("	GROUP BY ROUT_VIA.PROP_NO" ).append("\n"); 
		query.append("		,ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.SVC_SCP_CD" ).append("\n"); 
		query.append("		,ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_RP_SCP_RT_ROUT_VIA_DEST AS (" ).append("\n"); 
		query.append("	SELECT 	 ROUT_VIA.PROP_NO,ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.SVC_SCP_CD " ).append("\n"); 
		query.append("		,ROUT_VIA.CMDT_HDR_SEQ, ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD , '; ')),3) AS ROUT_VIA_PORT_DEF_CD " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_SEQ" ).append("\n"); 
		query.append("							,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("						ORDER BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_VIA_SEQ) AS RN" ).append("\n"); 
		query.append("		FROM PRI_RP_SCP_RT_ROUT_VIA " ).append("\n"); 
		query.append("		WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("	) ROUT_VIA" ).append("\n"); 
		query.append("	START WITH RN = 1 " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROUT_VIA.ROUT_SEQ = ROUT_VIA.ROUT_SEQ " ).append("\n"); 
		query.append("		AND PRIOR ROUT_VIA.ORG_DEST_TP_CD = ROUT_VIA.ORG_DEST_TP_CD " ).append("\n"); 
		query.append("		AND PRIOR ROUT_VIA.CMDT_HDR_SEQ = ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		AND PRIOR  ROUT_VIA.RN = ROUT_VIA.RN - 1" ).append("\n"); 
		query.append("	GROUP BY ROUT_VIA.PROP_NO" ).append("\n"); 
		query.append("		,ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.SVC_SCP_CD" ).append("\n"); 
		query.append("		,ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_ROUT AS (" ).append("\n"); 
		query.append("	SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD,CMDT_HDR_SEQ,ROUT_SEQ" ).append("\n"); 
		query.append("		,	MAX(DECODE(TP_CD,1,DEF_CD,NULL))  AS ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("		,	MAX(DECODE(TP_CD,2,DEF_CD,NULL))  AS DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("		,	MAX(DECODE(TP_CD,3,DEF_CD,NULL))  AS ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("		,	MAX(DECODE(TP_CD,4,DEF_CD,NULL))  AS DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			PROP_NO" ).append("\n"); 
		query.append("			,AMDT_SEQ" ).append("\n"); 
		query.append("			,SVC_SCP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROUT_PNT_LOC_DEF_CD AS DEF_CD" ).append("\n"); 
		query.append("			, 1 AS TP_CD" ).append("\n"); 
		query.append("		FROM 	VW_PRI_RP_SCP_RT_ROUT_PNT_ORI" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			PROP_NO" ).append("\n"); 
		query.append("			,AMDT_SEQ" ).append("\n"); 
		query.append("			,SVC_SCP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("			, 2 AS TP_CD" ).append("\n"); 
		query.append("		FROM 	VW_PRI_RP_SCP_RT_ROUT_PNT_DEST" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			PROP_NO" ).append("\n"); 
		query.append("			,AMDT_SEQ" ).append("\n"); 
		query.append("			,SVC_SCP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			, 3 AS TP_CD" ).append("\n"); 
		query.append("		FROM 	VW_PRI_RP_SCP_RT_ROUT_VIA_ORI" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			PROP_NO" ).append("\n"); 
		query.append("			,AMDT_SEQ" ).append("\n"); 
		query.append("			,SVC_SCP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			, 4 AS TP_CD" ).append("\n"); 
		query.append("		FROM 	VW_PRI_RP_SCP_RT_ROUT_VIA_DEST" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	GROUP BY PROP_NO,AMDT_SEQ,SVC_SCP_CD,CMDT_HDR_SEQ,ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD,CMDT_HDR_SEQ,ROUT_SEQ" ).append("\n"); 
		query.append("#if (${by_view} == 'CMDT') " ).append("\n"); 
		query.append("	,DECODE(GID,1,'Sub-Total',3,'Total',PRC_CMDT_DEF_CD) AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("	,CUST_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	,PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("	,DECODE(GID,1,'Sub-Total',3,'Total',NVL(CUST_CD,' ')) AS CUST_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("	,CUST_NM" ).append("\n"); 
		query.append("	,ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	,DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	,ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,PRS_PRE_LOD_QTY --Previous - PFMC" ).append("\n"); 
		query.append("	,DECODE(TOT_PRE_TOT_QTY,0,100.00, TO_CHAR(ROUND(PRS_PRE_LOD_QTY / TOT_PRE_TOT_QTY * 100,2),'990.99')) || '%'  AS PRE_SHARE  --Previous - Share(%) - 해당 Route Performance의 전체 Performance대비 Share" ).append("\n"); 
		query.append("	,PRS_PRE_RESPB_CMPB_AMT -- Previous - CMPB" ).append("\n"); 
		query.append("	,PRS_PRE_LOD_QTY * PRS_PRE_RESPB_CMPB_AMT AS PRE_CM-- Previous - CM - PRS_PRE_LOD_QTY * PRS_PRE_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("	,PRS_ESTM_LOD_QTY -- Estimate - PFMC" ).append("\n"); 
		query.append("	,DECODE(TOT_ESTM_TOT_QTY,0,100.00,TO_CHAR(ROUND(PRS_ESTM_LOD_QTY / TOT_ESTM_TOT_QTY * 100 ,2),'990.99')) || '%' AS ESTM_SHARE -- Estimate - Share(%)  -- 해당 Route Performance의 전체 Performance대비 Share" ).append("\n"); 
		query.append("	,PRS_ESTM_RESPB_CMPB_AMT -- Estimate - CMPB" ).append("\n"); 
		query.append("	,PRS_ESTM_LOD_QTY * PRS_ESTM_RESPB_CMPB_AMT  AS ESTM_CM -- Estimate - CM  -- PRS_ESTM_LOD_QTY * PRS_ESTM_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("	,PRS_PRE_RESPB_OPB_AMT -- Previous - OPB" ).append("\n"); 
		query.append("	,PRS_PRE_LOD_QTY *  PRS_PRE_RESPB_OPB_AMT AS PRE_OP-- Previous - OP  -- PRS_PRE_LOD_QTY * PRS_PRE_RESPB_OPB_AMT" ).append("\n"); 
		query.append("	,PRS_ESTM_LOD_QTY   -- Estimate - PFMC" ).append("\n"); 
		query.append("	,PRS_ESTM_RESPB_CMPB_AMT  -- Estimate - CMPB" ).append("\n"); 
		query.append("	,PRS_ESTM_RESPB_OPB_AMT -- Estimate - OPB" ).append("\n"); 
		query.append("	,PRS_ESTM_LOD_QTY *  PRS_ESTM_RESPB_OPB_AMT AS ESTM_OP -- Estimate - OP -- PRS_ESTM_LOD_QTY * PRS_ESTM_RESPB_OPB_AMT" ).append("\n"); 
		query.append("	,PRS_RAT_UT_CD" ).append("\n"); 
		query.append("	,CNTR_SZ_CD" ).append("\n"); 
		query.append("	,PRS_ESTM_LOD_QTY AS ORI_PRS_ESTM_LOD_QTY " ).append("\n"); 
		query.append("	,'' AS pfmc_unit " ).append("\n"); 
		query.append("	,'' AS by_view" ).append("\n"); 
		query.append("	,GID" ).append("\n"); 
		query.append("	,DECODE(GID,3,TO_NUMBER(''),SEQ_NUM) AS SEQ_NUM " ).append("\n"); 
		query.append("	, ORI_PRS_ESTM_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("         SELECT   MN.PROP_NO,MN.AMDT_SEQ,MN.SVC_SCP_CD,MN.CMDT_HDR_SEQ,MN.ROUT_SEQ" ).append("\n"); 
		query.append("                ,MN.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("				,MN.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                ,MN.CUST_CD" ).append("\n"); 
		query.append("				,MN.CUST_NM" ).append("\n"); 
		query.append("                ,MN.ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                ,MN.DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                ,MN.ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                ,MN.DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                ,SUM(MN.PRS_PRE_LOD_QTY) AS PRS_PRE_LOD_QTY--Previous - PFMC" ).append("\n"); 
		query.append("                ,DECODE(SUM(MN.PRS_PRE_LOD_QTY),0,0,SUM(MN.PRS_PRE_RESPB_CMPB_AMT*MN.PRS_PRE_LOD_QTY) / SUM(MN.PRS_PRE_LOD_QTY)) AS PRS_PRE_RESPB_CMPB_AMT-- Previous - CMPB" ).append("\n"); 
		query.append("                ,SUM(MN.PRS_ESTM_LOD_QTY) AS PRS_ESTM_LOD_QTY -- Estimate - PFMC" ).append("\n"); 
		query.append("                ,DECODE(SUM(MN.PRS_PRE_LOD_QTY),0,0,SUM(MN.PRS_PRE_RESPB_OPB_AMT*MN.PRS_PRE_LOD_QTY) / SUM(MN.PRS_PRE_LOD_QTY)) AS PRS_PRE_RESPB_OPB_AMT -- Previous - OPB" ).append("\n"); 
		query.append("                ,SUM(MN.TOT_PRE_TOT_QTY) AS TOT_PRE_TOT_QTY" ).append("\n"); 
		query.append("                ,SUM(MN.TOT_ESTM_TOT_QTY) AS TOT_ESTM_TOT_QTY" ).append("\n"); 
		query.append("                ,MN.PRS_RAT_UT_CD" ).append("\n"); 
		query.append("                ,MN.CNTR_SZ_CD" ).append("\n"); 
		query.append("                ,DECODE(SUM(MN.PRS_ESTM_LOD_QTY),0,0, SUM(MN.PRS_ESTM_RESPB_CMPB_AMT * MN.PRS_ESTM_LOD_QTY )/SUM(MN.PRS_ESTM_LOD_QTY)) AS PRS_ESTM_RESPB_CMPB_AMT-- Estimate - CMPB" ).append("\n"); 
		query.append("                ,DECODE(SUM(MN.PRS_ESTM_LOD_QTY),0,0, SUM(MN.PRS_ESTM_RESPB_OPB_AMT * MN.PRS_ESTM_LOD_QTY)/SUM(MN.PRS_ESTM_LOD_QTY)) AS PRS_ESTM_RESPB_OPB_AMT-- Estimate - CMPB" ).append("\n"); 
		query.append("				, SUM(MN.PRS_ESTM_RESPB_CMPB_AMT) as ORI_PRS_ESTM_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("#if (${by_view} == 'CMDT') " ).append("\n"); 
		query.append("				, GROUPING_ID( MN.PRC_CMDT_DEF_CD,MN.PROP_NO) AS GID" ).append("\n"); 
		query.append("				,DENSE_RANK() OVER(  ORDER BY MN.PRC_CMDT_DEF_CD ) AS SEQ_NUM" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("				, GROUPING_ID( MN.CUST_CD,MN.PROP_NO) AS GID" ).append("\n"); 
		query.append("				,DENSE_RANK() OVER(  ORDER BY MN.CUST_CD ) AS SEQ_NUM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                SELECT CR.PROP_NO,CR.AMDT_SEQ,CR.SVC_SCP_CD,CR.CMDT_HDR_SEQ,CR.ROUT_SEQ" ).append("\n"); 
		query.append("                        ,C.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                        ,C.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                        ,ACT_CUST.CUST_CD" ).append("\n"); 
		query.append("                        ,ACT_CUST.CUST_NM" ).append("\n"); 
		query.append("                        ,ROUT.ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                        ,ROUT.DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                        ,ROUT.ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                        ,ROUT.DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                        ,  0 PRS_PRE_LOD_QTY--Previous - PFMC" ).append("\n"); 
		query.append("                        ,  0 PRS_PRE_RESPB_CMPB_AMT-- Previous - CMPB" ).append("\n"); 
		query.append("                        ,  0 PRS_ESTM_LOD_QTY-- Estimate - PFMC" ).append("\n"); 
		query.append("                        ,  0 PRS_ESTM_RESPB_CMPB_AMT-- Estimate - CMPB" ).append("\n"); 
		query.append("                        ,  0 PRS_PRE_RESPB_OPB_AMT-- Previous - OPB" ).append("\n"); 
		query.append("                        ,  0 PRS_ESTM_RESPB_OPB_AMT-- Estimate - OPB" ).append("\n"); 
		query.append("                        ,  0 TOT_PRE_TOT_QTY" ).append("\n"); 
		query.append("                        ,  0 TOT_ESTM_TOT_QTY" ).append("\n"); 
		query.append("                        ,'' PRS_RAT_UT_CD" ).append("\n"); 
		query.append("                        ,'' CNTR_SZ_CD" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("                FROM PRI_RP_SCP_RT_CMDT_HDR H" ).append("\n"); 
		query.append("                        , VW_PRI_RP_SCP_RT_CMDT C" ).append("\n"); 
		query.append("                        , VW_PRI_RP_SCP_RT_ACT_CUST ACT_CUST" ).append("\n"); 
		query.append("                        , VW_PRI_ROUT ROUT" ).append("\n"); 
		query.append("                        , PRI_RP_SCP_RT_CMDT_ROUT CR" ).append("\n"); 
		query.append("                WHERE H.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("                        AND H.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND H.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND H.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        AND H.PROP_NO = ACT_CUST.PROP_NO(+)" ).append("\n"); 
		query.append("                        AND H.AMDT_SEQ = ACT_CUST.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                        AND H.SVC_SCP_CD = ACT_CUST.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                        AND H.CMDT_HDR_SEQ = ACT_CUST.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                        AND H.PROP_NO = ROUT.PROP_NO" ).append("\n"); 
		query.append("                        AND H.AMDT_SEQ = ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND H.SVC_SCP_CD = ROUT.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND H.CMDT_HDR_SEQ = ROUT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        AND ROUT.PROP_NO = CR.PROP_NO(+)" ).append("\n"); 
		query.append("                        AND ROUT.AMDT_SEQ = CR.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                        AND ROUT.SVC_SCP_CD = CR.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                        AND ROUT.CMDT_HDR_SEQ = CR.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                        AND ROUT.ROUT_SEQ = CR.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                        AND H.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                        AND H.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                        AND H.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("         ) MN" ).append("\n"); 
		query.append("         GROUP BY GROUPING SETS" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        ()" ).append("\n"); 
		query.append("                        ,(" ).append("\n"); 
		query.append("                                MN.PROP_NO,MN.AMDT_SEQ,MN.SVC_SCP_CD,MN.CMDT_HDR_SEQ,MN.ROUT_SEQ" ).append("\n"); 
		query.append("                                ,MN.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("				,MN.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                                ,MN.CUST_CD" ).append("\n"); 
		query.append("				,MN.CUST_NM" ).append("\n"); 
		query.append("                                ,MN.ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                ,MN.DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                ,MN.ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                ,MN.DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                ,MN.PRS_RAT_UT_CD" ).append("\n"); 
		query.append("                                ,MN.CNTR_SZ_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                        ,(" ).append("\n"); 
		query.append("#if (${by_view} == 'CMDT') " ).append("\n"); 
		query.append("                                MN.PRC_CMDT_DEF_CD,PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("								MN.CUST_CD,MN.CUST_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                 " ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY SEQ_NUM, GID, CUST_CD NULLS FIRST,CUST_CD" ).append("\n"); 

	}
}