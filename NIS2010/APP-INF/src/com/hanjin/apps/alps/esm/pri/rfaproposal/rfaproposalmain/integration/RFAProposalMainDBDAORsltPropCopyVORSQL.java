/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltPropCopyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.04.22 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltPropCopyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Proposal Copy
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltPropCopyVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltPropCopyVORSQL").append("\n"); 
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
		query.append("WITH CMDT_HDR AS (" ).append("\n"); 
		query.append("    SELECT A.PROP_NO" ).append("\n"); 
		query.append("         , A.AMDT_SEQ" ).append("\n"); 
		query.append("         , A.SVC_SCP_CD" ).append("\n"); 
		query.append("         , A.CMDT_HDR_SEQ AS OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD" ).append("\n"); 
		query.append("                              ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.BLET_DP_SEQ, A.CMDT_HDR_SEQ) AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_RT_CMDT_HDR A" ).append("\n"); 
		query.append("    WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   (" ).append("\n"); 
		query.append("        EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT_CMDT B" ).append("\n"); 
		query.append("            WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("            AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT_ACT_CUST C" ).append("\n"); 
		query.append("            WHERE C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("            AND   C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   C.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   C.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT_CNOTE D" ).append("\n"); 
		query.append("            WHERE D.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("            AND   D.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   D.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   D.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   D.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT_CMDT_ROUT E" ).append("\n"); 
		query.append("            WHERE E.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("            AND   E.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   E.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   E.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   (" ).append("\n"); 
		query.append("                EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_RP_SCP_RT_ROUT_PNT F" ).append("\n"); 
		query.append("                    WHERE F.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND   F.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND   F.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND   F.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   F.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND   F.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_RP_SCP_RT_ROUT_VIA G" ).append("\n"); 
		query.append("                    WHERE G.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND   G.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND   G.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND   G.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   G.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND   G.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_RP_SCP_RT_CMDT_RNOTE I" ).append("\n"); 
		query.append("                    WHERE I.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND   I.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND   I.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND   I.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   I.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND   I.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                OR EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM PRI_RP_SCP_RT J" ).append("\n"); 
		query.append("                    WHERE J.PROP_NO = E.PROP_NO" ).append("\n"); 
		query.append("                    AND   J.AMDT_SEQ = E.AMDT_SEQ" ).append("\n"); 
		query.append("                    AND   J.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND   J.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    AND   J.ROUT_SEQ = E.ROUT_SEQ" ).append("\n"); 
		query.append("                    AND   J.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CMDT_ROUT AS (" ).append("\n"); 
		query.append("    SELECT L.PROP_NO" ).append("\n"); 
		query.append("         , L.AMDT_SEQ" ).append("\n"); 
		query.append("         , L.SVC_SCP_CD" ).append("\n"); 
		query.append("         , K.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , K.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("         , L.ROUT_SEQ AS OLD_ROUT_SEQ" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER (PARTITION BY L.PROP_NO, L.AMDT_SEQ, L.SVC_SCP_CD, K.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                              ORDER BY L.PROP_NO, L.AMDT_SEQ, L.SVC_SCP_CD, K.OLD_CMDT_HDR_SEQ, L.ROUT_SEQ) AS ROUT_SEQ" ).append("\n"); 
		query.append("    FROM CMDT_HDR K" ).append("\n"); 
		query.append("        ,PRI_RP_SCP_RT_CMDT_ROUT L" ).append("\n"); 
		query.append("    WHERE L.PROP_NO = K.PROP_NO" ).append("\n"); 
		query.append("    AND   L.AMDT_SEQ = K.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   L.SVC_SCP_CD = K.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   L.CMDT_HDR_SEQ = K.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND   (" ).append("\n"); 
		query.append("        EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT_ROUT_PNT F" ).append("\n"); 
		query.append("            WHERE F.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   F.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   F.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   F.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   F.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   F.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT_ROUT_VIA G" ).append("\n"); 
		query.append("            WHERE G.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   G.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   G.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   G.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   G.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   G.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT_CMDT_RNOTE I" ).append("\n"); 
		query.append("            WHERE I.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   I.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   I.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   I.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   I.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   I.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT J" ).append("\n"); 
		query.append("            WHERE J.PROP_NO = L.PROP_NO" ).append("\n"); 
		query.append("            AND   J.AMDT_SEQ = L.AMDT_SEQ" ).append("\n"); 
		query.append("            AND   J.SVC_SCP_CD = L.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   J.CMDT_HDR_SEQ = L.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   J.ROUT_SEQ = L.ROUT_SEQ" ).append("\n"); 
		query.append("            AND   J.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", RATE_CMDT AS ( -- RATE COMMODITY" ).append("\n"); 
		query.append("    SELECT B.PROP_NO" ).append("\n"); 
		query.append("         , B.AMDT_SEQ" ).append("\n"); 
		query.append("         , B.SVC_SCP_CD" ).append("\n"); 
		query.append("         , B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("    FROM CMDT_HDR A" ).append("\n"); 
		query.append("        ,PRI_RP_SCP_RT_CMDT B" ).append("\n"); 
		query.append("    WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("    AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   B.CMDT_HDR_SEQ = A.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND   B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", RATE_LOC_PNT AS ( -- RATE LOCATION POINT" ).append("\n"); 
		query.append("    SELECT S.PROP_NO" ).append("\n"); 
		query.append("         , S.AMDT_SEQ" ).append("\n"); 
		query.append("         , S.SVC_SCP_CD" ).append("\n"); 
		query.append("         , S.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("    FROM CMDT_ROUT R" ).append("\n"); 
		query.append("        ,PRI_RP_SCP_RT_ROUT_PNT S" ).append("\n"); 
		query.append("    WHERE S.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("    AND   S.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   S.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   S.CMDT_HDR_SEQ = R.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND   S.ROUT_SEQ = R.OLD_ROUT_SEQ" ).append("\n"); 
		query.append("    AND   S.SRC_INFO_CD <> 'AD' " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", RATE_LOC_VIA AS ( -- RATE LOCATION VIA" ).append("\n"); 
		query.append("    SELECT S.PROP_NO" ).append("\n"); 
		query.append("         , S.AMDT_SEQ" ).append("\n"); 
		query.append("         , S.SVC_SCP_CD" ).append("\n"); 
		query.append("         , S.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("    FROM CMDT_ROUT R" ).append("\n"); 
		query.append("        ,PRI_RP_SCP_RT_ROUT_VIA S" ).append("\n"); 
		query.append("    WHERE S.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("    AND   S.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   S.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   S.CMDT_HDR_SEQ = R.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND   S.ROUT_SEQ = R.OLD_ROUT_SEQ" ).append("\n"); 
		query.append("    AND   S.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("     , MN.AMDT_SEQ" ).append("\n"); 
		query.append("     , MN.SVC_SCP_CD" ).append("\n"); 
		query.append("     , SIGN(NVL(LO_CNT,0)+NVL(CO_CNT,0)" ).append("\n"); 
		query.append("           +NVL(AO_CNT,0)+NVL(AD_CNT,0)" ).append("\n"); 
		query.append("           +NVL(RT_CNT,0)+NVL(SN_CNT,0)) AS SCP_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(LO_CNT,0)) AS LOCA_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(CO_CNT,0)) AS CMDT_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(AO_CNT,0)) AS AROR_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(AD_CNT,0)) AS ARDE_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(RT_CNT,0)) AS RATE_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(SN_CNT,0)) AS SPNT_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(RC.CNT,0)) AS RT_CMDT_CNT" ).append("\n"); 
		query.append("     , SIGN(NVL(RP.CNT,0) + NVL(RV.CNT,0)) AS RT_LOC_CNT" ).append("\n"); 
		query.append("     , SIGN(NVL(AL.AOL_CNT,0)) AS AO_LOC_CNT" ).append("\n"); 
		query.append("     , SIGN(NVL(AL.ADL_CNT,0)) AS AD_LOC_CNT" ).append("\n"); 
		query.append("     , '' AS RFA_NO" ).append("\n"); 
		query.append("     , '' AS NEW_PROP_NO" ).append("\n"); 
		query.append("     , 0 AS AFIL_CHK" ).append("\n"); 
		query.append("     , '' AS CRE_USR_ID" ).append("\n"); 
		query.append("     , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("     , '' AS OFC_CD" ).append("\n"); 
		query.append("     , '' AS SREP_CD" ).append("\n"); 
		query.append("     , '' AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , '' AS ADD_CHG_TP_CD" ).append("\n"); 
		query.append("     , '' AS NOTE_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    -- SCP_MAIN" ).append("\n"); 
		query.append("    SELECT PROP_NO" ).append("\n"); 
		query.append("         , AMDT_SEQ" ).append("\n"); 
		query.append("         , SVC_SCP_CD" ).append("\n"); 
		query.append("         , CRE_DT" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(") MN" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- LOCATION" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(GRP_LOC_SEQ) AS LO_CNT" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_GRP_LOC" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") LO" ).append("\n"); 
		query.append("ON LO.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- COMMODITY" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(GRP_CMDT_SEQ) AS CO_CNT" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") CO" ).append("\n"); 
		query.append("ON CO.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- ARBITRARY ORIGIN" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(ADD_CHG_SEQ) AS AO_CNT" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("    AND   ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") AO" ).append("\n"); 
		query.append("ON AO.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- ARBITRARY DEST" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(ADD_CHG_SEQ) AS AD_CNT" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("    AND   ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") AD" ).append("\n"); 
		query.append("ON AD.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- RATE" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(RT_SEQ) AS RT_CNT" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_RT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") RT" ).append("\n"); 
		query.append("ON RT.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- SPECIAL NOTE" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,COUNT(NOTE_SEQ) AS SN_CNT" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_NOTE" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("    GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append(") SN" ).append("\n"); 
		query.append("ON SN.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("( -- RATE COMMODITY EXIST COUNT" ).append("\n"); 
		query.append("    SELECT B.PROP_NO" ).append("\n"); 
		query.append("         , B.AMDT_SEQ" ).append("\n"); 
		query.append("         , B.SVC_SCP_CD" ).append("\n"); 
		query.append("         , COUNT(B.PROP_NO) AS CNT" ).append("\n"); 
		query.append("    FROM RATE_CMDT A" ).append("\n"); 
		query.append("        ,PRI_RP_SCP_GRP_CMDT B" ).append("\n"); 
		query.append("    WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("    AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   B.PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("    GROUP BY B.PROP_NO, B.AMDT_SEQ, B.SVC_SCP_CD" ).append("\n"); 
		query.append(") RC" ).append("\n"); 
		query.append("ON RC.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("( -- RATE LOCATION POINT EXIST COUNT" ).append("\n"); 
		query.append("    SELECT S.PROP_NO" ).append("\n"); 
		query.append("         , S.AMDT_SEQ" ).append("\n"); 
		query.append("         , S.SVC_SCP_CD" ).append("\n"); 
		query.append("         , COUNT(S.PROP_NO) AS CNT" ).append("\n"); 
		query.append("    FROM RATE_LOC_PNT R" ).append("\n"); 
		query.append("        ,PRI_RP_SCP_GRP_LOC S" ).append("\n"); 
		query.append("    WHERE S.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("    AND   S.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   S.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   S.PRC_GRP_LOC_CD = R.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("    GROUP BY S.PROP_NO, S.AMDT_SEQ, S.SVC_SCP_CD" ).append("\n"); 
		query.append(") RP" ).append("\n"); 
		query.append("ON RP.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("( -- RATE LOCATION VIA EXIST COUNT" ).append("\n"); 
		query.append("    SELECT S.PROP_NO" ).append("\n"); 
		query.append("         , S.AMDT_SEQ" ).append("\n"); 
		query.append("         , S.SVC_SCP_CD" ).append("\n"); 
		query.append("         , COUNT(S.PROP_NO) AS CNT" ).append("\n"); 
		query.append("    FROM RATE_LOC_VIA R" ).append("\n"); 
		query.append("        ,PRI_RP_SCP_GRP_LOC S" ).append("\n"); 
		query.append("    WHERE S.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("    AND   S.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   S.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   S.PRC_GRP_LOC_CD = R.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("    GROUP BY S.PROP_NO, S.AMDT_SEQ, S.SVC_SCP_CD" ).append("\n"); 
		query.append(") RV" ).append("\n"); 
		query.append("ON RV.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   --- ARBITRARY LOC EXIST CHECK" ).append("\n"); 
		query.append("    SELECT A.PROP_NO" ).append("\n"); 
		query.append("         , A.AMDT_SEQ" ).append("\n"); 
		query.append("         , A.SVC_SCP_CD" ).append("\n"); 
		query.append("         , SUM(NVL((SELECT 1" ).append("\n"); 
		query.append("		            FROM PRI_RP_SCP_GRP_LOC B" ).append("\n"); 
		query.append("		            WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("		            AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("		            AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("		            AND   B.PRC_GRP_LOC_CD = A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("					AND   A.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("           ),0)) AS AOL_CNT" ).append("\n"); 
		query.append("         , SUM(NVL((SELECT 1" ).append("\n"); 
		query.append("		            FROM PRI_RP_SCP_GRP_LOC B" ).append("\n"); 
		query.append("		            WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("		            AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("		            AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("		            AND   B.PRC_GRP_LOC_CD = A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("					AND   A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("           ),0)) AS ADL_CNT" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_TRSP_ADD_CHG A" ).append("\n"); 
		query.append("    WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   A.ADD_CHG_TP_CD = 'A'" ).append("\n"); 
		query.append("    GROUP BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD" ).append("\n"); 
		query.append(") AL" ).append("\n"); 
		query.append("ON AL.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("ORDER BY MN.CRE_DT, MN.SVC_SCP_CD" ).append("\n"); 

	}
}