/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateProposalDBDAORsltPriRateCmpbViewAllListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.07 송민석
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

public class RFARateProposalDBDAORsltPriRateCmpbViewAllListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    ESM_PRI_6047
	  * </pre>
	  */
	public RFARateProposalDBDAORsltPriRateCmpbViewAllListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltPriRateCmpbViewAllListVORSQL").append("\n"); 
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
		query.append("SELECT 	 CMDT.PROP_NO,CMDT.AMDT_SEQ" ).append("\n"); 
		query.append(",CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD , '; ')),3) AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(REPLACE(PRC_CMDT_DEF_NM,';',':') , '; ')),3) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",CMDT_SEQ,PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",'G'" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",'R'" ).append("\n"); 
		query.append(",(      SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",'C'" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append("ORDER BY PRC_CMDT_TP_CD DESC,PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",CMDT_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_CMDT A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append(") CMDT" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR CMDT.CMDT_HDR_SEQ = CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR  CMDT.RN = CMDT.RN - 1" ).append("\n"); 
		query.append("GROUP BY CMDT.PROP_NO" ).append("\n"); 
		query.append(",CMDT.AMDT_SEQ" ).append("\n"); 
		query.append(",CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("VW_PRI_RP_SCP_RT_ACT_CUST  AS (" ).append("\n"); 
		query.append("SELECT 	 ACT_CUST.PROP_NO,ACT_CUST.AMDT_SEQ" ).append("\n"); 
		query.append(",ACT_CUST.SVC_SCP_CD" ).append("\n"); 
		query.append(",ACT_CUST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(CUST_CD , '; ')),3) AS CUST_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(REPLACE(CUST_NM,';',':') , '; ')),3) AS CUST_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ACT_CUST_SEQ" ).append("\n"); 
		query.append(",CUST_CNT_CD || TO_CHAR(CUST_SEQ,'FM0000000') AS CUST_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") AS CUST_NM" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append("ORDER BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ACT_CUST_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append(") ACT_CUST" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ACT_CUST.CMDT_HDR_SEQ = ACT_CUST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND PRIOR  ACT_CUST.RN = ACT_CUST.RN - 1" ).append("\n"); 
		query.append("GROUP BY ACT_CUST.PROP_NO" ).append("\n"); 
		query.append(",ACT_CUST.AMDT_SEQ" ).append("\n"); 
		query.append(",ACT_CUST.SVC_SCP_CD" ).append("\n"); 
		query.append(",ACT_CUST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_RP_SCP_RT_ROUT_PNT_ORI AS (" ).append("\n"); 
		query.append("SELECT  ROUT_PNT.PROP_NO,ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.SVC_SCP_CD" ).append("\n"); 
		query.append(",ROUT_PNT.CMDT_HDR_SEQ, ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(", SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || DECODE(TERM_NM,'','','(' || TERM_NM || ')') , '; ')),3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT PROP_NO,AMDT_SEQ	,SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT_SEQ) AS RN" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") ROUT_PNT" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_PNT.ROUT_SEQ = ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_PNT.ORG_DEST_TP_CD = ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("AND PRIOR  ROUT_PNT.RN = ROUT_PNT.RN - 1" ).append("\n"); 
		query.append("GROUP BY ROUT_PNT.PROP_NO" ).append("\n"); 
		query.append(",ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.SVC_SCP_CD" ).append("\n"); 
		query.append(",ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_RP_SCP_RT_ROUT_PNT_DEST AS (" ).append("\n"); 
		query.append("SELECT  ROUT_PNT.PROP_NO,ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.SVC_SCP_CD" ).append("\n"); 
		query.append(",ROUT_PNT.CMDT_HDR_SEQ, ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(", SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD || DECODE(TERM_NM,'','','(' || TERM_NM || ')') , '; ')),3) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT PROP_NO,AMDT_SEQ	,SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ ,ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT_SEQ) AS RN" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CODE WHERE CODE.INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) as TERM_NM" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append(") ROUT_PNT" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_PNT.ROUT_SEQ = ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_PNT.ORG_DEST_TP_CD = ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("AND PRIOR  ROUT_PNT.RN = ROUT_PNT.RN - 1" ).append("\n"); 
		query.append("GROUP BY ROUT_PNT.PROP_NO" ).append("\n"); 
		query.append(",ROUT_PNT.AMDT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.SVC_SCP_CD" ).append("\n"); 
		query.append(",ROUT_PNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_PNT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_RP_SCP_RT_ROUT_VIA_ORI AS (" ).append("\n"); 
		query.append("SELECT 	 ROUT_VIA.PROP_NO,ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.SVC_SCP_CD" ).append("\n"); 
		query.append(",ROUT_VIA.CMDT_HDR_SEQ, ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD , '; ')),3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append(") ROUT_VIA" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_VIA.ROUT_SEQ = ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_VIA.ORG_DEST_TP_CD = ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("AND PRIOR  ROUT_VIA.RN = ROUT_VIA.RN - 1" ).append("\n"); 
		query.append("GROUP BY ROUT_VIA.PROP_NO" ).append("\n"); 
		query.append(",ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.SVC_SCP_CD" ).append("\n"); 
		query.append(",ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VW_PRI_RP_SCP_RT_ROUT_VIA_DEST AS (" ).append("\n"); 
		query.append("SELECT 	 ROUT_VIA.PROP_NO,ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.SVC_SCP_CD" ).append("\n"); 
		query.append(",ROUT_VIA.CMDT_HDR_SEQ, ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD , '; ')),3) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append("ORDER BY PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA_SEQ) AS RN" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append(") ROUT_VIA" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT_VIA.ROUT_SEQ = ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append("AND PRIOR ROUT_VIA.ORG_DEST_TP_CD = ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("AND PRIOR  ROUT_VIA.RN = ROUT_VIA.RN - 1" ).append("\n"); 
		query.append("GROUP BY ROUT_VIA.PROP_NO" ).append("\n"); 
		query.append(",ROUT_VIA.AMDT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.SVC_SCP_CD" ).append("\n"); 
		query.append(",ROUT_VIA.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ROUT_SEQ" ).append("\n"); 
		query.append(",ROUT_VIA.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("VW_PRI_ROUT AS (" ).append("\n"); 
		query.append("SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD,CMDT_HDR_SEQ,ROUT_SEQ" ).append("\n"); 
		query.append(",	MAX(DECODE(TP_CD,1,DEF_CD,NULL))  AS ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",	MAX(DECODE(TP_CD,2,DEF_CD,NULL))  AS DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",	MAX(DECODE(TP_CD,3,DEF_CD,NULL))  AS ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",	MAX(DECODE(TP_CD,4,DEF_CD,NULL))  AS DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD AS DEF_CD" ).append("\n"); 
		query.append(", 1 AS TP_CD" ).append("\n"); 
		query.append("FROM 	VW_PRI_RP_SCP_RT_ROUT_PNT_ORI" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(", 2 AS TP_CD" ).append("\n"); 
		query.append("FROM 	VW_PRI_RP_SCP_RT_ROUT_PNT_DEST" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(", 3 AS TP_CD" ).append("\n"); 
		query.append("FROM 	VW_PRI_RP_SCP_RT_ROUT_VIA_ORI" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(", 4 AS TP_CD" ).append("\n"); 
		query.append("FROM 	VW_PRI_RP_SCP_RT_ROUT_VIA_DEST" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY PROP_NO,AMDT_SEQ,SVC_SCP_CD,CMDT_HDR_SEQ,ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT PROP_NO,AMDT_SEQ,SVC_SCP_CD,CMDT_HDR_SEQ,ROUT_SEQ,RT_SEQ" ).append("\n"); 
		query.append(",PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",CUST_CD" ).append("\n"); 
		query.append(",CUST_NM" ).append("\n"); 
		query.append(",ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",RAT_UT_CD, PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",CURR_CD, PROP_FRT_RT_AMT" ).append("\n"); 
		query.append(", PRS_SCG_AMT, PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append(", PRS_RESPB_CMPB_AMT, PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append(", DIFF" ).append("\n"); 
		query.append(", PRS_RESPB_OPFIT_UC_AMT,  PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT RT.PROP_NO,RT.AMDT_SEQ,RT.SVC_SCP_CD,RT.CMDT_HDR_SEQ,RT.ROUT_SEQ,RT.RT_SEQ" ).append("\n"); 
		query.append(",C.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",C.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append(",ACT_CUST.CUST_CD" ).append("\n"); 
		query.append(",ACT_CUST.CUST_NM" ).append("\n"); 
		query.append(",ROUT.ORI_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ROUT.DST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",ROUT.ORI_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",ROUT.DST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",RT.RAT_UT_CD, RT.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",RT.CURR_CD, RT.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append(", RT.PRS_SCG_AMT, RT.PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append(", RT.PRS_RESPB_CMPB_AMT, RT.PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append(", PRS_RESPB_CMPB_AMT - RT.PRS_GID_CMPB_AMT AS DIFF" ).append("\n"); 
		query.append(", RT.PRS_RESPB_OPFIT_UC_AMT, RT. PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT RT" ).append("\n"); 
		query.append(", VW_PRI_RP_SCP_RT_CMDT C" ).append("\n"); 
		query.append(", VW_PRI_RP_SCP_RT_ACT_CUST ACT_CUST" ).append("\n"); 
		query.append(", VW_PRI_ROUT ROUT" ).append("\n"); 
		query.append("WHERE RT.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("AND RT.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("AND RT.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RT.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND RT.PROP_NO = ACT_CUST.PROP_NO(+)" ).append("\n"); 
		query.append("AND RT.AMDT_SEQ = ACT_CUST.AMDT_SEQ(+)" ).append("\n"); 
		query.append("AND RT.SVC_SCP_CD = ACT_CUST.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND RT.CMDT_HDR_SEQ = ACT_CUST.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("AND RT.PROP_NO = ROUT.PROP_NO" ).append("\n"); 
		query.append("AND RT.AMDT_SEQ = ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("AND RT.SVC_SCP_CD = ROUT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RT.CMDT_HDR_SEQ = ROUT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND RT.ROUT_SEQ = ROUT.ROUT_SEQ" ).append("\n"); 
		query.append("AND RT.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND RT.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND RT.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}