/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAORsltPriAmdCmViewAllVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.21 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAORsltPriAmdCmViewAllVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    PRS- S/C Amendment CM/OP View All
	  * </pre>
	  */
	public SCRateProposalDBDAORsltPriAmdCmViewAllVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pfmc_unit",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : SCRateProposalDBDAORsltPriAmdCmViewAllVORSQL").append("\n"); 
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
		query.append("/*VO에 pfmc_unit, rate_type 을 추가해야 한다.*/" ).append("\n"); 
		query.append("WITH VW_PRI_SP_SCP_RT_CMDT  AS (" ).append("\n"); 
		query.append("	SELECT 	 CMDT.PROP_NO,CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("		,CMDT.SVC_SCP_CD, CMDT.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("		,CMDT.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("		,SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD , '; ')),3) AS PRC_CMDT_DEF_CD " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD" ).append("\n"); 
		query.append("			,GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,CMDT_SEQ,PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("						ORDER BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,CMDT_SEQ) AS RN" ).append("\n"); 
		query.append("		FROM PRI_SP_SCP_RT_CMDT " ).append("\n"); 
		query.append("		WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${rate_type} != 'B') " ).append("\n"); 
		query.append("			AND GEN_SPCL_RT_TP_CD = @[rate_type]" ).append("\n"); 
		query.append("#end			" ).append("\n"); 
		query.append("	) CMDT" ).append("\n"); 
		query.append("	START WITH RN = 1 " ).append("\n"); 
		query.append("	CONNECT BY PRIOR CMDT.CMDT_HDR_SEQ = CMDT.CMDT_HDR_SEQ " ).append("\n"); 
		query.append("		AND PRIOR CMDT.GEN_SPCL_RT_TP_CD = CMDT.GEN_SPCL_RT_TP_CD  " ).append("\n"); 
		query.append("		AND PRIOR  CMDT.RN = CMDT.RN - 1" ).append("\n"); 
		query.append("	GROUP BY CMDT.PROP_NO" ).append("\n"); 
		query.append("		,CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("		,CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("		,CMDT.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("		,CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_SP_SCP_RT_ROUT_PNT_ORI AS (" ).append("\n"); 
		query.append(" 	SELECT  ROUT_PNT.PROP_NO,ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.SVC_SCP_CD, ROUT_PNT.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("		,ROUT_PNT.CMDT_HDR_SEQ, ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		, SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || DECODE(TERM_NM,'','','(' || TERM_NM || ')'), '; ')),3) AS ROUT_PNT_LOC_DEF_CD " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO,AMDT_SEQ	,SVC_SCP_CD" ).append("\n"); 
		query.append("			,GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_SEQ" ).append("\n"); 
		query.append("							,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("						ORDER BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_PNT_SEQ) AS RN" ).append("\n"); 
		query.append("			,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM   " ).append("\n"); 
		query.append("		FROM PRI_SP_SCP_RT_ROUT_PNT " ).append("\n"); 
		query.append("		WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("#if (${rate_type} != 'B') " ).append("\n"); 
		query.append("			AND GEN_SPCL_RT_TP_CD = @[rate_type]" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("	) ROUT_PNT" ).append("\n"); 
		query.append("	START WITH RN = 1 " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROUT_PNT.ROUT_SEQ = ROUT_PNT.ROUT_SEQ " ).append("\n"); 
		query.append("		AND PRIOR ROUT_PNT.ORG_DEST_TP_CD = ROUT_PNT.ORG_DEST_TP_CD " ).append("\n"); 
		query.append("		AND PRIOR ROUT_PNT.GEN_SPCL_RT_TP_CD = ROUT_PNT.GEN_SPCL_RT_TP_CD  " ).append("\n"); 
		query.append("		AND PRIOR ROUT_PNT.CMDT_HDR_SEQ = ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		AND PRIOR  ROUT_PNT.RN = ROUT_PNT.RN - 1" ).append("\n"); 
		query.append("	GROUP BY ROUT_PNT.PROP_NO" ).append("\n"); 
		query.append("		,ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.SVC_SCP_CD" ).append("\n"); 
		query.append("		,ROUT_PNT.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("		,ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(" )," ).append("\n"); 
		query.append(" VW_PRI_SP_SCP_RT_ROUT_PNT_DEST AS (" ).append("\n"); 
		query.append(" 	SELECT  ROUT_PNT.PROP_NO,ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.SVC_SCP_CD, ROUT_PNT.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("		,ROUT_PNT.CMDT_HDR_SEQ, ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		, SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || DECODE(TERM_NM,'','','(' || TERM_NM || ')'), '; ')),3) AS ROUT_PNT_LOC_DEF_CD " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO,AMDT_SEQ	,SVC_SCP_CD" ).append("\n"); 
		query.append("			,GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_SEQ" ).append("\n"); 
		query.append("							,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("						ORDER BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_PNT_SEQ) AS RN" ).append("\n"); 
		query.append("			,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM " ).append("\n"); 
		query.append("		FROM PRI_SP_SCP_RT_ROUT_PNT " ).append("\n"); 
		query.append("		WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("#if (${rate_type} != 'B') " ).append("\n"); 
		query.append("			AND GEN_SPCL_RT_TP_CD = @[rate_type]" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("	) ROUT_PNT" ).append("\n"); 
		query.append("	START WITH RN = 1 " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROUT_PNT.ROUT_SEQ = ROUT_PNT.ROUT_SEQ " ).append("\n"); 
		query.append("		AND PRIOR ROUT_PNT.ORG_DEST_TP_CD = ROUT_PNT.ORG_DEST_TP_CD " ).append("\n"); 
		query.append("		AND PRIOR ROUT_PNT.GEN_SPCL_RT_TP_CD = ROUT_PNT.GEN_SPCL_RT_TP_CD  " ).append("\n"); 
		query.append("		AND PRIOR ROUT_PNT.CMDT_HDR_SEQ = ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		AND PRIOR  ROUT_PNT.RN = ROUT_PNT.RN - 1" ).append("\n"); 
		query.append("	GROUP BY ROUT_PNT.PROP_NO" ).append("\n"); 
		query.append("		,ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.SVC_SCP_CD" ).append("\n"); 
		query.append("		,ROUT_PNT.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("		,ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_SP_SCP_RT_ROUT_VIA_ORI AS (" ).append("\n"); 
		query.append("	SELECT 	 ROUT_VIA.PROP_NO,ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.SVC_SCP_CD, ROUT_VIA.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("		,ROUT_VIA.CMDT_HDR_SEQ, ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD , '; ')),3) AS ROUT_VIA_PORT_DEF_CD " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD" ).append("\n"); 
		query.append("			,GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_SEQ" ).append("\n"); 
		query.append("							,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("						ORDER BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_VIA_SEQ) AS RN" ).append("\n"); 
		query.append("		FROM PRI_SP_SCP_RT_ROUT_VIA " ).append("\n"); 
		query.append("		WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("#if (${rate_type} != 'B') " ).append("\n"); 
		query.append("			AND GEN_SPCL_RT_TP_CD = @[rate_type]" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("	) ROUT_VIA" ).append("\n"); 
		query.append("	START WITH RN = 1 " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROUT_VIA.ROUT_SEQ = ROUT_VIA.ROUT_SEQ " ).append("\n"); 
		query.append("		AND PRIOR ROUT_VIA.ORG_DEST_TP_CD = ROUT_VIA.ORG_DEST_TP_CD " ).append("\n"); 
		query.append("		AND PRIOR ROUT_VIA.GEN_SPCL_RT_TP_CD = ROUT_VIA.GEN_SPCL_RT_TP_CD  " ).append("\n"); 
		query.append("		AND PRIOR ROUT_VIA.CMDT_HDR_SEQ = ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		AND PRIOR  ROUT_VIA.RN = ROUT_VIA.RN - 1" ).append("\n"); 
		query.append("	GROUP BY ROUT_VIA.PROP_NO" ).append("\n"); 
		query.append("		,ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.SVC_SCP_CD" ).append("\n"); 
		query.append("		,ROUT_VIA.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("		,ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_SP_SCP_RT_ROUT_VIA_DEST AS (" ).append("\n"); 
		query.append("	SELECT 	 ROUT_VIA.PROP_NO,ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.SVC_SCP_CD, ROUT_VIA.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("		,ROUT_VIA.CMDT_HDR_SEQ, ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD , '; ')),3) AS ROUT_VIA_PORT_DEF_CD " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD" ).append("\n"); 
		query.append("			,GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_SEQ" ).append("\n"); 
		query.append("							,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("						ORDER BY PROP_NO" ).append("\n"); 
		query.append("							,AMDT_SEQ" ).append("\n"); 
		query.append("							,SVC_SCP_CD" ).append("\n"); 
		query.append("							,GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("							,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("							,ROUT_VIA_SEQ) AS RN" ).append("\n"); 
		query.append("		FROM PRI_SP_SCP_RT_ROUT_VIA " ).append("\n"); 
		query.append("		WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("#if (${rate_type} != 'B') " ).append("\n"); 
		query.append("			AND GEN_SPCL_RT_TP_CD = @[rate_type]" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("	) ROUT_VIA" ).append("\n"); 
		query.append("	START WITH RN = 1 " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROUT_VIA.ROUT_SEQ = ROUT_VIA.ROUT_SEQ " ).append("\n"); 
		query.append("		AND PRIOR ROUT_VIA.ORG_DEST_TP_CD = ROUT_VIA.ORG_DEST_TP_CD " ).append("\n"); 
		query.append("		AND PRIOR ROUT_VIA.GEN_SPCL_RT_TP_CD = ROUT_VIA.GEN_SPCL_RT_TP_CD  " ).append("\n"); 
		query.append("		AND PRIOR ROUT_VIA.CMDT_HDR_SEQ = ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		AND PRIOR  ROUT_VIA.RN = ROUT_VIA.RN - 1" ).append("\n"); 
		query.append("	GROUP BY ROUT_VIA.PROP_NO" ).append("\n"); 
		query.append("		,ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.SVC_SCP_CD" ).append("\n"); 
		query.append("		,ROUT_VIA.GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("		,ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("		,ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("VW_PRI_ROUT AS (" ).append("\n"); 
		query.append("	SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD,CMDT_HDR_SEQ,ROUT_SEQ" ).append("\n"); 
		query.append("		,	MAX(DECODE(TP_CD,1,DEF_CD,NULL))  AS ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("		,	MAX(DECODE(TP_CD,2,DEF_CD,NULL))  AS DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("		,	MAX(DECODE(TP_CD,3,DEF_CD,NULL))  AS ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("		,	MAX(DECODE(TP_CD,4,DEF_CD,NULL))  AS DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			PROP_NO" ).append("\n"); 
		query.append("			,AMDT_SEQ" ).append("\n"); 
		query.append("			,SVC_SCP_CD" ).append("\n"); 
		query.append("			,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROUT_PNT_LOC_DEF_CD AS DEF_CD" ).append("\n"); 
		query.append("			, 1 AS TP_CD" ).append("\n"); 
		query.append("		FROM 	VW_PRI_SP_SCP_RT_ROUT_PNT_ORI" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			PROP_NO" ).append("\n"); 
		query.append("			,AMDT_SEQ" ).append("\n"); 
		query.append("			,SVC_SCP_CD" ).append("\n"); 
		query.append("			,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("			, 2 AS TP_CD" ).append("\n"); 
		query.append("		FROM 	VW_PRI_SP_SCP_RT_ROUT_PNT_DEST" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			PROP_NO" ).append("\n"); 
		query.append("			,AMDT_SEQ" ).append("\n"); 
		query.append("			,SVC_SCP_CD" ).append("\n"); 
		query.append("			,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			, 3 AS TP_CD" ).append("\n"); 
		query.append("		FROM 	VW_PRI_SP_SCP_RT_ROUT_VIA_ORI" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			PROP_NO" ).append("\n"); 
		query.append("			,AMDT_SEQ" ).append("\n"); 
		query.append("			,SVC_SCP_CD" ).append("\n"); 
		query.append("			,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("			,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("			,ROUT_SEQ" ).append("\n"); 
		query.append("			,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("			,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("			, 4 AS TP_CD" ).append("\n"); 
		query.append("		FROM 	VW_PRI_SP_SCP_RT_ROUT_VIA_DEST" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	GROUP BY PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD,CMDT_HDR_SEQ,ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD,CMDT_HDR_SEQ,ROUT_SEQ" ).append("\n"); 
		query.append("	,PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("	,ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	,DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	,ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,PRS_CRNT_LOD_QTY --ACTUAL - PFMC" ).append("\n"); 
		query.append("	,TO_CHAR(DECODE(TOT_CRNT_LOD_QTY,0,0, ROUND(PRS_CRNT_LOD_QTY / TOT_CRNT_LOD_QTY * 100,2)),'990.99')  || '%' AS CRNT_SHARE  --ACTUAL - Share(%) - 해당 Route Performance의 전체 Performance대비 Share" ).append("\n"); 
		query.append("	,PRS_CRNT_RESPB_CMPB_AMT -- ACTUAL - CMPB" ).append("\n"); 
		query.append("	,PRS_CRNT_LOD_QTY * PRS_CRNT_RESPB_CMPB_AMT AS CRNT_CM-- ACTUAL - CM -  " ).append("\n"); 
		query.append("	,PRS_RMN_LOD_QTY -- Estimate - PFMC" ).append("\n"); 
		query.append("	,TO_CHAR(DECODE(TOT_RMN_LOD_QTY,0,0, ROUND(PRS_RMN_LOD_QTY / TOT_RMN_LOD_QTY * 100,2)),'990.99')  || '%' AS RMN_SHARE -- Estimate - Share(%)  -- 해당 Route Performance의 전체 Performance대비 Share" ).append("\n"); 
		query.append("	,PRS_RMN_RESPB_CMPB_AMT -- Estimate - CMPB" ).append("\n"); 
		query.append("	,PRS_RMN_LOD_QTY * PRS_RMN_RESPB_CMPB_AMT  AS RMN_CM -- Estimate - CM  --  " ).append("\n"); 
		query.append("	,PRS_CRNT_RESPB_OPB_AMT -- -ACTUAL - OPB" ).append("\n"); 
		query.append("	,PRS_CRNT_LOD_QTY *  PRS_CRNT_RESPB_OPB_AMT AS CRNT_OP-- -ACTUAL - OP  --  " ).append("\n"); 
		query.append("	,PRS_RMN_LOD_QTY   -- Estimate - PFMC" ).append("\n"); 
		query.append("	,PRS_RMN_RESPB_CMPB_AMT  -- Estimate - CMPB" ).append("\n"); 
		query.append("	,PRS_RMN_RESPB_OPB_AMT -- Estimate - OPB" ).append("\n"); 
		query.append("	,PRS_RMN_LOD_QTY *  PRS_RMN_RESPB_OPB_AMT AS RMN_OP -- Estimate - OP --  " ).append("\n"); 
		query.append("	,DECODE(GEN_SPCL_RT_TP_CD,'G',1,0) G_RATE_TYPE" ).append("\n"); 
		query.append("	,DECODE(GEN_SPCL_RT_TP_CD,'S',1,0) S_RATE_TYPE" ).append("\n"); 
		query.append("	,PRS_CRNT_LOD_QTY + PRS_RMN_LOD_QTY AS PRS_SUM_LOD_QTY  -- sum pfmc" ).append("\n"); 
		query.append("	,TO_CHAR(DECODE((NVL(TOT_CRNT_LOD_QTY,0)+NVL(TOT_RMN_LOD_QTY,0)),0,0,  ROUND((NVL(PRS_CRNT_LOD_QTY,0) + NVL(PRS_RMN_LOD_QTY,0)) / (NVL(TOT_CRNT_LOD_QTY,0)+NVL(TOT_RMN_LOD_QTY,0)) * 100,2)),'990.99')  || '%' AS SUM_SHARE  -- sum share" ).append("\n"); 
		query.append("	,DECODE((PRS_CRNT_LOD_QTY + PRS_RMN_LOD_QTY),0,0, ((PRS_CRNT_LOD_QTY * PRS_CRNT_RESPB_CMPB_AMT) + (PRS_RMN_LOD_QTY * PRS_RMN_RESPB_CMPB_AMT)) /  (PRS_CRNT_LOD_QTY + PRS_RMN_LOD_QTY)) AS PRS_SUM_CMPB_AMT   -- sum cmpb" ).append("\n"); 
		query.append("	,((PRS_CRNT_LOD_QTY * PRS_CRNT_RESPB_CMPB_AMT) + (PRS_RMN_LOD_QTY * PRS_RMN_RESPB_CMPB_AMT)) AS SUM_CM  -- sum cm" ).append("\n"); 
		query.append("	,DECODE((PRS_CRNT_LOD_QTY + PRS_RMN_LOD_QTY),0,0, ((PRS_CRNT_LOD_QTY *  PRS_CRNT_RESPB_OPB_AMT) + (PRS_RMN_LOD_QTY *  PRS_RMN_RESPB_OPB_AMT)) /  (PRS_CRNT_LOD_QTY + PRS_RMN_LOD_QTY)) AS PRS_SUM_OPB_AMT -- sum opb" ).append("\n"); 
		query.append("	,((PRS_CRNT_LOD_QTY *  PRS_CRNT_RESPB_OPB_AMT) + (PRS_RMN_LOD_QTY *  PRS_RMN_RESPB_OPB_AMT)) AS SUM_OP  -- sum op" ).append("\n"); 
		query.append("	,PRS_RAT_UT_CD" ).append("\n"); 
		query.append("	,CNTR_SZ_CD" ).append("\n"); 
		query.append("	,PRS_RMN_LOD_QTY AS ORI_PRS_RMN_LOD_QTY " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                        SELECT CR.PROP_NO,CR.AMDT_SEQ,CR.SVC_SCP_CD,CR.GEN_SPCL_RT_TP_CD,CR.CMDT_HDR_SEQ,CR.ROUT_SEQ" ).append("\n"); 
		query.append("                                ,C.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                ,ROUT.ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                ,ROUT.DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                ,ROUT.ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                ,ROUT.DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                ,CR.PRS_CRNT_LOD_QTY / DECODE(@[pfmc_unit],'FEU',2,'TEU',1) AS  PRS_CRNT_LOD_QTY--ACTUAL - PFMC" ).append("\n"); 
		query.append("                                ,CR.PRS_CRNT_RESPB_CMPB_AMT * DECODE(@[pfmc_unit],'FEU',2,'TEU',1) AS PRS_CRNT_RESPB_CMPB_AMT-- ACTUAL - CMPB" ).append("\n"); 
		query.append("                                ,CR.PRS_RMN_LOD_QTY / DECODE(@[pfmc_unit],'FEU',2,'TEU',1) AS PRS_RMN_LOD_QTY-- Estimate - PFMC" ).append("\n"); 
		query.append("                                ,CR.PRS_RMN_RESPB_CMPB_AMT * DECODE(@[pfmc_unit],'FEU',2,'TEU',1) AS PRS_RMN_RESPB_CMPB_AMT -- Estimate - CMPB" ).append("\n"); 
		query.append("                                ,CR.PRS_CRNT_RESPB_OPB_AMT * DECODE(@[pfmc_unit],'FEU',2,'TEU',1) AS PRS_CRNT_RESPB_OPB_AMT -- ACTUAL - OPB" ).append("\n"); 
		query.append("                                ,CR.PRS_RMN_RESPB_OPB_AMT * DECODE(@[pfmc_unit],'FEU',2,'TEU',1) AS PRS_RMN_RESPB_OPB_AMT-- Estimate - OPB" ).append("\n"); 
		query.append("                                ,SUM(CR.PRS_CRNT_LOD_QTY/DECODE(@[pfmc_unit],'FEU',2,'TEU',1))  OVER( PARTITION BY CR.PROP_NO,CR.AMDT_SEQ,CR.SVC_SCP_CD) AS TOT_CRNT_LOD_QTY" ).append("\n"); 
		query.append("                                ,SUM(CR.PRS_RMN_LOD_QTY/DECODE(@[pfmc_unit],'FEU',2,'TEU',1)) OVER( PARTITION BY CR.PROP_NO,CR.AMDT_SEQ,CR.SVC_SCP_CD) AS TOT_RMN_LOD_QTY" ).append("\n"); 
		query.append("                                ,CR.PRS_RAT_UT_CD" ).append("\n"); 
		query.append("                                ,U.CNTR_SZ_CD" ).append("\n"); 
		query.append("                        FROM PRI_SP_SCP_RT_CMDT_HDR H" ).append("\n"); 
		query.append("                                , VW_PRI_SP_SCP_RT_CMDT C" ).append("\n"); 
		query.append("                                , VW_PRI_ROUT ROUT" ).append("\n"); 
		query.append("                                , PRI_SP_SCP_RT_CMDT_ROUT CR" ).append("\n"); 
		query.append("                                , PRI_RAT_UT U" ).append("\n"); 
		query.append("                        WHERE H.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("                                AND H.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND H.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND H.GEN_SPCL_RT_TP_CD = C.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                AND H.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                AND H.PROP_NO = ROUT.PROP_NO" ).append("\n"); 
		query.append("                                AND H.AMDT_SEQ = ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND H.SVC_SCP_CD = ROUT.SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND H.GEN_SPCL_RT_TP_CD = ROUT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                AND H.CMDT_HDR_SEQ = ROUT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                AND ROUT.PROP_NO = CR.PROP_NO(+)" ).append("\n"); 
		query.append("                                AND ROUT.AMDT_SEQ = CR.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                                AND ROUT.SVC_SCP_CD = CR.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                                AND ROUT.GEN_SPCL_RT_TP_CD = CR.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("                                AND ROUT.CMDT_HDR_SEQ = CR.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                                AND ROUT.ROUT_SEQ = CR.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                                AND CR.PRS_RAT_UT_CD = U.RAT_UT_CD(+)" ).append("\n"); 
		query.append("                                AND H.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                AND H.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                AND H.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY GEN_SPCL_RT_TP_CD" ).append("\n"); 

	}
}