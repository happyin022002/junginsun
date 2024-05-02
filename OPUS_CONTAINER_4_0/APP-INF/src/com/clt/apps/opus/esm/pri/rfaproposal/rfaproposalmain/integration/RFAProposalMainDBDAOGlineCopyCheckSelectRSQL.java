/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAOGlineCopyCheckSelectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.10.12 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOGlineCopyCheckSelectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Copy Data Check
	  * </pre>
	  */
	public RFAProposalMainDBDAOGlineCopyCheckSelectRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOGlineCopyCheckSelectRSQL").append("\n"); 
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
		query.append("-- Guideline Copy Check" ).append("\n"); 
		query.append("WITH CMDT_HDR AS (" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_HDR B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("--AND   B.GLINE_SEQ = '2'" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT C" ).append("\n"); 
		query.append("WHERE C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   C.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   C.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_ROUT D" ).append("\n"); 
		query.append("WHERE D.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   D.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   D.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_PNT E" ).append("\n"); 
		query.append("WHERE E.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   E.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND   E.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   E.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_VIA F" ).append("\n"); 
		query.append("WHERE F.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   F.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND   F.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   F.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT H" ).append("\n"); 
		query.append("WHERE H.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   H.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND   H.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   H.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CMDT_ROUT AS (" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", B.ROUT_SEQ" ).append("\n"); 
		query.append("FROM CMDT_HDR A" ).append("\n"); 
		query.append(", PRI_RG_RT_CMDT_ROUT B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_PNT E" ).append("\n"); 
		query.append("WHERE E.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   E.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   E.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   E.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_VIA F" ).append("\n"); 
		query.append("WHERE F.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   F.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   F.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   F.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT H" ).append("\n"); 
		query.append("WHERE H.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   H.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   H.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   H.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", RATE_CMDT AS ( -- RATE COMMODITY" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", B.CMDT_SEQ" ).append("\n"); 
		query.append(", B.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(", B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("FROM CMDT_HDR A" ).append("\n"); 
		query.append(", PRI_RG_RT_CMDT B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", RATE_LOC_PNT AS ( -- RATE LOCATION POINT" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", B.ROUT_SEQ" ).append("\n"); 
		query.append(", B.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(", B.ROUT_PNT_SEQ" ).append("\n"); 
		query.append(", B.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(", B.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("FROM CMDT_ROUT A" ).append("\n"); 
		query.append(", PRI_RG_RT_ROUT_PNT B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   B.ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", RATE_LOC_VIA AS ( -- RATE LOCATION VIA" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", B.ROUT_SEQ" ).append("\n"); 
		query.append(", B.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(", B.ROUT_VIA_SEQ" ).append("\n"); 
		query.append(", B.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(", B.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("FROM CMDT_ROUT A" ).append("\n"); 
		query.append(", PRI_RG_RT_ROUT_VIA B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   B.ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SG.SVC_SCP_CD" ).append("\n"); 
		query.append(", SG.GLINE_SEQ" ).append("\n"); 
		query.append(", DECODE(SIGN(NVL(OL.CNT,0)),1,0,SIGN(NVL(LO.LOC_CHK,0))) AS LOC_CHK" ).append("\n"); 
		query.append(", DECODE(SIGN(NVL(OC.CNT,0)),1,0,SIGN(NVL(CM.CMDT_CHK,0))) AS CMDT_CHK" ).append("\n"); 
		query.append(", DECODE(SIGN(NVL(OO.CNT,0)),1,0,SIGN(NVL(AO.ARB_ORG_CHK,0))) AS ARB_ORG_CHK" ).append("\n"); 
		query.append(", DECODE(SIGN(NVL(OD.CNT,0)),1,0,SIGN(NVL(AD.ARB_DES_CHK,0))) AS ARB_DES_CHK" ).append("\n"); 
		query.append(", DECODE(SIGN(NVL(OT.CNT,0)),1,0,SIGN(NVL(RT.RATE_CHK,0))) AS RATE_CHK" ).append("\n"); 
		query.append(", SIGN(NVL(RC.CNT,0)) AS RT_CMDT_CNT" ).append("\n"); 
		query.append(", SIGN(NVL(RP.CNT,0) + NVL(RV.CNT,0)) AS RT_LOC_CNT" ).append("\n"); 
		query.append(", SIGN(NVL(AL.AOL_CNT,0)) AS AO_LOC_CNT" ).append("\n"); 
		query.append(", SIGN(NVL(AL.ADL_CNT,0)) AS AD_LOC_CNT" ).append("\n"); 
		query.append(", '' AS PROP_NO" ).append("\n"); 
		query.append(", '' AS AMDT_SEQ" ).append("\n"); 
		query.append(", '' AS SVC_SCP_NM" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append("--     , 0 AS MQC_QTY" ).append("\n"); 
		query.append("--     , 0 AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", '' AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append("--     , 0 AS NOTE_HDR_SEQ" ).append("\n"); 
		query.append("--     , 0 AS GRP_CMDT_SEQ" ).append("\n"); 
		query.append("--     , 0 AS GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(", '' AS EFF_DT" ).append("\n"); 
		query.append(", '' AS EXP_DT" ).append("\n"); 
		query.append(", '' AS RFA_NO" ).append("\n"); 
		query.append("FROM (  -- Scope Main" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY B.EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_MN A" ).append("\n"); 
		query.append(",PRI_RG_MN B" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND   A.EFF_DT BETWEEN B.EFF_DT AND B.EXP_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 
		query.append(") SG" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- Grp Location" ).append("\n"); 
		query.append("SELECT C.SVC_SCP_CD" ).append("\n"); 
		query.append(", C.GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(C.SVC_SCP_CD) AS LOC_CHK" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_LOC C" ).append("\n"); 
		query.append(",PRI_RG_GRP_LOC_DTL D" ).append("\n"); 
		query.append("WHERE C.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   D.GLINE_SEQ = C.GLINE_SEQ" ).append("\n"); 
		query.append("AND   D.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   D.GLINE_SEQ = C.GLINE_SEQ" ).append("\n"); 
		query.append("AND   D.GRP_LOC_SEQ = C.GRP_LOC_SEQ" ).append("\n"); 
		query.append("GROUP BY C.SVC_SCP_CD, C.GLINE_SEQ" ).append("\n"); 
		query.append(") LO" ).append("\n"); 
		query.append("ON LO.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND LO.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- Grp Commodity" ).append("\n"); 
		query.append("SELECT E.SVC_SCP_CD" ).append("\n"); 
		query.append(", E.GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(E.SVC_SCP_CD) AS CMDT_CHK" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_CMDT E" ).append("\n"); 
		query.append(",PRI_RG_GRP_CMDT_DTL F" ).append("\n"); 
		query.append("WHERE E.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   F.GLINE_SEQ = E.GLINE_SEQ" ).append("\n"); 
		query.append("AND   F.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   F.GLINE_SEQ = E.GLINE_SEQ" ).append("\n"); 
		query.append("AND   F.GRP_CMDT_SEQ = E.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("GROUP BY E.SVC_SCP_CD, E.GLINE_SEQ" ).append("\n"); 
		query.append(") CM" ).append("\n"); 
		query.append("ON CM.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND CM.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- Orgin Arbitrary" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(SVC_SCP_CD) AS ARB_ORG_CHK" ).append("\n"); 
		query.append("FROM PRI_RG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD,GLINE_SEQ" ).append("\n"); 
		query.append(") AO" ).append("\n"); 
		query.append("ON AO.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND AO.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- Destination Arbitrary" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(SVC_SCP_CD) AS ARB_DES_CHK" ).append("\n"); 
		query.append("FROM PRI_RG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD,GLINE_SEQ" ).append("\n"); 
		query.append(") AD" ).append("\n"); 
		query.append("ON AD.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND AD.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- RATE" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(B.SVC_SCP_CD) AS RATE_CHK" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_HDR B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT C" ).append("\n"); 
		query.append("WHERE C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   C.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   C.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_ROUT D" ).append("\n"); 
		query.append("WHERE D.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   D.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   D.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_PNT E" ).append("\n"); 
		query.append("WHERE E.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   E.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND   E.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   E.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_VIA F" ).append("\n"); 
		query.append("WHERE F.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   F.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND   F.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   F.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT H" ).append("\n"); 
		query.append("WHERE H.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   H.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND   H.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   H.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD,B.GLINE_SEQ" ).append("\n"); 
		query.append(") RT" ).append("\n"); 
		query.append("ON RT.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RT.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- Exist Grp Location" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", COUNT(SVC_SCP_CD) AS CNT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_LOC" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") OL" ).append("\n"); 
		query.append("ON OL.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- EXIST Grp Commodity" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", COUNT(SVC_SCP_CD) AS CNT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") OC" ).append("\n"); 
		query.append("ON OC.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- EXIST Orgin Arbitrary" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", COUNT(SVC_SCP_CD) AS CNT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("AND   ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") OO" ).append("\n"); 
		query.append("ON OO.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- EXIST Destination Arbitrary" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD" ).append("\n"); 
		query.append(", COUNT(SVC_SCP_CD) AS CNT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("AND   ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") OD" ).append("\n"); 
		query.append("ON OD.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- EXIST RATE" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", COUNT(B.SVC_SCP_CD) AS CNT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_CMDT_HDR B" ).append("\n"); 
		query.append("WHERE B.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   B.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_CMDT C" ).append("\n"); 
		query.append("WHERE C.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND   C.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("AND   C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   C.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_CMDT_ROUT D" ).append("\n"); 
		query.append("WHERE D.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND   D.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("AND   D.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   D.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_PNT E" ).append("\n"); 
		query.append("WHERE E.PROP_NO = D.PROP_NO" ).append("\n"); 
		query.append("AND   E.AMDT_SEQ = D.AMDT_SEQ" ).append("\n"); 
		query.append("AND   E.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   E.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   E.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_VIA F" ).append("\n"); 
		query.append("WHERE F.PROP_NO = D.PROP_NO" ).append("\n"); 
		query.append("AND   F.AMDT_SEQ = D.AMDT_SEQ" ).append("\n"); 
		query.append("AND   F.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   F.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   F.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT H" ).append("\n"); 
		query.append("WHERE H.PROP_NO = D.PROP_NO" ).append("\n"); 
		query.append("AND   H.AMDT_SEQ = D.AMDT_SEQ" ).append("\n"); 
		query.append("AND   H.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   H.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   H.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD" ).append("\n"); 
		query.append(") OT" ).append("\n"); 
		query.append("ON OT.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- RATE COMMODITY EXIST COUNT" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(B.SVC_SCP_CD) AS CNT" ).append("\n"); 
		query.append("FROM RATE_CMDT A" ).append("\n"); 
		query.append(", PRI_RG_GRP_CMDT B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD, B.GLINE_SEQ" ).append("\n"); 
		query.append(") RC" ).append("\n"); 
		query.append("ON  RC.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RC.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- RATE LOCATION POINT EXIST COUNT" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(B.SVC_SCP_CD) AS CNT" ).append("\n"); 
		query.append("FROM RATE_LOC_PNT A" ).append("\n"); 
		query.append(",PRI_RG_GRP_LOC B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.PRC_GRP_LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD, B.GLINE_SEQ" ).append("\n"); 
		query.append(") RP" ).append("\n"); 
		query.append("ON  RP.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RP.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- RATE LOCATION VIA EXIST COUNT" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", COUNT(B.SVC_SCP_CD) AS CNT" ).append("\n"); 
		query.append("FROM RATE_LOC_VIA A" ).append("\n"); 
		query.append(",PRI_RG_GRP_LOC B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.PRC_GRP_LOC_CD = A.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD, B.GLINE_SEQ" ).append("\n"); 
		query.append(") RV" ).append("\n"); 
		query.append("ON  RV.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RV.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   --- ARBITRARY LOC EXIST CHECK" ).append("\n"); 
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append(", A.GLINE_SEQ" ).append("\n"); 
		query.append(", SUM(NVL((SELECT 1" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_LOC B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.PRC_GRP_LOC_CD = A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("AND   A.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("),0)) AS AOL_CNT" ).append("\n"); 
		query.append(", SUM(NVL((SELECT 1" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_LOC B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.PRC_GRP_LOC_CD = A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("AND   A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("),0)) AS ADL_CNT" ).append("\n"); 
		query.append("FROM PRI_RG_ARB A" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("GROUP BY A.SVC_SCP_CD, A.GLINE_SEQ" ).append("\n"); 
		query.append(") AL" ).append("\n"); 
		query.append("ON  AL.SVC_SCP_CD = SG.SVC_SCP_CD" ).append("\n"); 
		query.append("AND AL.GLINE_SEQ = SG.GLINE_SEQ" ).append("\n"); 

	}
}