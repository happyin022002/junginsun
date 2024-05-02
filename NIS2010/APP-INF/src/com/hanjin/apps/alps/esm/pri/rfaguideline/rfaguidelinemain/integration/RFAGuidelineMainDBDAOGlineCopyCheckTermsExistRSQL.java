/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAGuidelineMainDBDAOGlineCopyCheckTermsExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.05.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGuidelineMainDBDAOGlineCopyCheckTermsExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terms 데이터 존재여부를 체크한다.
	  * </pre>
	  */
	public RFAGuidelineMainDBDAOGlineCopyCheckTermsExistRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.integration").append("\n"); 
		query.append("FileName : RFAGuidelineMainDBDAOGlineCopyCheckTermsExistRSQL").append("\n"); 
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
		query.append("SELECT RPG.SVC_SCP_CD" ).append("\n"); 
		query.append("     , RPG.GLINE_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(RPG.EFF_DT,'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(RPG.EXP_DT,'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("     , SIGN(NVL(LOC.LOC_CHK,0)) AS LOC_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(CMC.CMDT_CHK,0)) AS CMDT_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(AOC.ARB_ORG_CHK,0)) AS ARB_ORG_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(ADC.ARB_DES_CHK,0)) AS ARB_DES_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(RTC.RATE_CHK,0)) AS RATE_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(RCM.RCM_CNT,0)) AS RT_CMDT_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(RLF.RLF_CNT,0) + NVL(RLS.RLS_CNT,0)) AS RT_LOC_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(ARL.AOBL_CNT,0)) AS ARO_LOC_CHK" ).append("\n"); 
		query.append("     , SIGN(NVL(ARL.ADBL_CNT,0)) AS ARD_LOC_CHK" ).append("\n"); 
		query.append("     , '' TRGT_SVC_SCP_CD" ).append("\n"); 
		query.append("     , '' TRGT_GLINE_SEQ" ).append("\n"); 
		query.append("     , '' TRGT_EFF_DT" ).append("\n"); 
		query.append("     , '' TRGT_EXP_DT" ).append("\n"); 
		query.append("     , '' ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , '' CRE_USR_ID" ).append("\n"); 
		query.append("     , '' CRE_DT" ).append("\n"); 
		query.append("     , '' UPD_USR_ID" ).append("\n"); 
		query.append("     , '' UPD_DT" ).append("\n"); 
		query.append("     , '' USR_ID" ).append("\n"); 
		query.append("FROM (  -- Guideline Main" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,GLINE_SEQ" ).append("\n"); 
		query.append("          ,EFF_DT" ).append("\n"); 
		query.append("          ,EXP_DT" ).append("\n"); 
		query.append("          ,1 AS MN_CHK" ).append("\n"); 
		query.append("    FROM PRI_RG_MN" ).append("\n"); 
		query.append("    WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append(") RPG" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- Group Location" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,1 AS LOC_CHK" ).append("\n"); 
		query.append("    FROM PRI_RG_GRP_LOC" ).append("\n"); 
		query.append("    WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("    AND   ROWNUM = 1" ).append("\n"); 
		query.append(") LOC" ).append("\n"); 
		query.append("ON LOC.SVC_SCP_CD = RPG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- Group Commodity" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,1 AS CMDT_CHK" ).append("\n"); 
		query.append("    FROM PRI_RG_GRP_CMDT" ).append("\n"); 
		query.append("    WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("    AND   ROWNUM = 1" ).append("\n"); 
		query.append(") CMC" ).append("\n"); 
		query.append("ON CMC.SVC_SCP_CD = RPG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- Orgin Arbitrary" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,1 AS ARB_ORG_CHK" ).append("\n"); 
		query.append("    FROM PRI_RG_ARB" ).append("\n"); 
		query.append("    WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("    AND   ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append(") AOC" ).append("\n"); 
		query.append("ON AOC.SVC_SCP_CD = RPG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- Destination Arbitrary" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,1 AS ARB_DES_CHK" ).append("\n"); 
		query.append("    FROM PRI_RG_ARB" ).append("\n"); 
		query.append("    WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND   GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("    AND   ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("    AND   ROWNUM = 1" ).append("\n"); 
		query.append(") ADC" ).append("\n"); 
		query.append("ON ADC.SVC_SCP_CD = RPG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(  -- Rate " ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("          ,1 AS RATE_CHK" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append("             , B.GLINE_SEQ" ).append("\n"); 
		query.append("        FROM PRI_RG_RT_CMDT_HDR B" ).append("\n"); 
		query.append("        WHERE B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND   B.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("        AND   (" ).append("\n"); 
		query.append("            EXISTS (" ).append("\n"); 
		query.append("                SELECT 'X'" ).append("\n"); 
		query.append("                FROM PRI_RG_RT_CMDT C" ).append("\n"); 
		query.append("                WHERE C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND   C.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("                AND   C.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            OR EXISTS (" ).append("\n"); 
		query.append("                SELECT 'X'" ).append("\n"); 
		query.append("                FROM PRI_RG_RT_CMDT_ROUT D" ).append("\n"); 
		query.append("                WHERE D.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND   D.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("                AND   D.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND   (" ).append("\n"); 
		query.append("                    EXISTS (" ).append("\n"); 
		query.append("                        SELECT 'X'" ).append("\n"); 
		query.append("                        FROM PRI_RG_RT_ROUT_PNT E" ).append("\n"); 
		query.append("                        WHERE E.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND   E.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("                        AND   E.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        AND   E.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    OR EXISTS (" ).append("\n"); 
		query.append("                        SELECT 'X'" ).append("\n"); 
		query.append("                        FROM PRI_RG_RT_ROUT_VIA F" ).append("\n"); 
		query.append("                        WHERE F.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND   F.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("                        AND   F.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        AND   F.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    OR EXISTS (" ).append("\n"); 
		query.append("                        SELECT 'X'" ).append("\n"); 
		query.append("                        FROM PRI_RG_RT H" ).append("\n"); 
		query.append("                        WHERE H.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND   H.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("                        AND   H.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        AND   H.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE ROWNUM = 1" ).append("\n"); 
		query.append(") RTC" ).append("\n"); 
		query.append("ON RTC.SVC_SCP_CD = RPG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- RATE CMDT EXIST CHECK" ).append("\n"); 
		query.append("    WITH CMDT_HDR AS (" ).append("\n"); 
		query.append("        SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("             , A.GLINE_SEQ" ).append("\n"); 
		query.append("             , A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        FROM PRI_RG_RT_CMDT_HDR A" ).append("\n"); 
		query.append("        WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND   A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("        AND   EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RG_RT_CMDT_ROUT B" ).append("\n"); 
		query.append("               , PRI_RG_RT C" ).append("\n"); 
		query.append("            WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("            AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   C.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("            AND   C.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   C.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    , RT_CMDT AS (" ).append("\n"); 
		query.append("        SELECT E.SVC_SCP_CD" ).append("\n"); 
		query.append("             , E.GLINE_SEQ" ).append("\n"); 
		query.append("             , E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             , D.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("             , D.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("        FROM PRI_RG_RT_CMDT D" ).append("\n"); 
		query.append("           , CMDT_HDR E" ).append("\n"); 
		query.append("        WHERE D.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   D.GLINE_SEQ = E.GLINE_SEQ" ).append("\n"); 
		query.append("        AND   D.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("         , COUNT(A.PRC_CMDT_DEF_CD) AS RCM_CNT" ).append("\n"); 
		query.append("    FROM RT_CMDT A" ).append("\n"); 
		query.append("       , PRI_RG_GRP_CMDT B" ).append("\n"); 
		query.append("    WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("    AND   B.PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("    GROUP BY A.SVC_SCP_CD" ).append("\n"); 
		query.append(") RCM" ).append("\n"); 
		query.append("ON RCM.SVC_SCP_CD = RPG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- RATE ROUT_LOC EXIST CHECK" ).append("\n"); 
		query.append("    WITH CMDT_HDR AS (" ).append("\n"); 
		query.append("        SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("             , A.GLINE_SEQ" ).append("\n"); 
		query.append("             , A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        FROM PRI_RG_RT_CMDT_HDR A" ).append("\n"); 
		query.append("        WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND   A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("        AND   EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RG_RT_CMDT_ROUT B" ).append("\n"); 
		query.append("               , PRI_RG_RT C" ).append("\n"); 
		query.append("            WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("            AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   C.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("            AND   C.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   C.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    , CMDT_ROUT AS (" ).append("\n"); 
		query.append("        SELECT D.SVC_SCP_CD" ).append("\n"); 
		query.append("             , D.GLINE_SEQ" ).append("\n"); 
		query.append("             , E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             , D.ROUT_SEQ" ).append("\n"); 
		query.append("        FROM PRI_RG_RT_CMDT_ROUT D" ).append("\n"); 
		query.append("           , CMDT_HDR E" ).append("\n"); 
		query.append("        WHERE D.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   D.GLINE_SEQ = E.GLINE_SEQ" ).append("\n"); 
		query.append("        AND   D.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    , RT_LOC AS (" ).append("\n"); 
		query.append("        SELECT G.SVC_SCP_CD" ).append("\n"); 
		query.append("             , G.GLINE_SEQ" ).append("\n"); 
		query.append("             , F.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("             , F.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("        FROM PRI_RG_RT_ROUT_PNT F" ).append("\n"); 
		query.append("           , CMDT_ROUT G" ).append("\n"); 
		query.append("        WHERE F.SVC_SCP_CD = G.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   F.GLINE_SEQ = G.GLINE_SEQ" ).append("\n"); 
		query.append("        AND   F.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   F.ROUT_SEQ = G.ROUT_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("         , COUNT(A.ROUT_PNT_LOC_DEF_CD) AS RLF_CNT" ).append("\n"); 
		query.append("    FROM RT_LOC A" ).append("\n"); 
		query.append("       , PRI_RG_GRP_LOC B" ).append("\n"); 
		query.append("    WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("    AND   B.PRC_GRP_LOC_CD  = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("    GROUP BY A.SVC_SCP_CD" ).append("\n"); 
		query.append(") RLF" ).append("\n"); 
		query.append("ON RLF.SVC_SCP_CD = RPG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   -- RATE VIA_LOC EXIST CHECK" ).append("\n"); 
		query.append("    WITH CMDT_HDR AS (" ).append("\n"); 
		query.append("        SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("             , A.GLINE_SEQ" ).append("\n"); 
		query.append("             , A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        FROM PRI_RG_RT_CMDT_HDR A" ).append("\n"); 
		query.append("        WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND   A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("        AND   EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("            FROM PRI_RG_RT_CMDT_ROUT B" ).append("\n"); 
		query.append("               , PRI_RG_RT C" ).append("\n"); 
		query.append("            WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("            AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND   C.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("            AND   C.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND   C.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    , CMDT_ROUT AS (" ).append("\n"); 
		query.append("        SELECT D.SVC_SCP_CD" ).append("\n"); 
		query.append("             , D.GLINE_SEQ" ).append("\n"); 
		query.append("             , E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             , D.ROUT_SEQ" ).append("\n"); 
		query.append("        FROM PRI_RG_RT_CMDT_ROUT D" ).append("\n"); 
		query.append("           , CMDT_HDR E" ).append("\n"); 
		query.append("        WHERE D.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   D.GLINE_SEQ = E.GLINE_SEQ" ).append("\n"); 
		query.append("        AND   D.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    , RT_LOC AS (" ).append("\n"); 
		query.append("        SELECT G.SVC_SCP_CD" ).append("\n"); 
		query.append("             , G.GLINE_SEQ" ).append("\n"); 
		query.append("             , G.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             , G.ROUT_SEQ" ).append("\n"); 
		query.append("             , F.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("             , F.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("             , F.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("        FROM PRI_RG_RT_ROUT_VIA F" ).append("\n"); 
		query.append("           , CMDT_ROUT G" ).append("\n"); 
		query.append("        WHERE F.SVC_SCP_CD = G.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND   F.GLINE_SEQ = G.GLINE_SEQ" ).append("\n"); 
		query.append("        AND   F.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND   F.ROUT_SEQ = G.ROUT_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("         , COUNT(A.ROUT_VIA_PORT_DEF_CD) AS RLS_CNT" ).append("\n"); 
		query.append("    FROM RT_LOC A" ).append("\n"); 
		query.append("       , PRI_RG_GRP_LOC B" ).append("\n"); 
		query.append("    WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("    AND   B.PRC_GRP_LOC_CD  = A.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("    GROUP BY A.SVC_SCP_CD" ).append("\n"); 
		query.append(") RLS" ).append("\n"); 
		query.append("ON RLS.SVC_SCP_CD = RPG.SVC_SCP_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(   --- ARBITRARY LOC EXIST CHECK" ).append("\n"); 
		query.append("    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("         , SUM(NVL((SELECT 1" ).append("\n"); 
		query.append("		            FROM PRI_RG_GRP_LOC B" ).append("\n"); 
		query.append("		            WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("		            AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("		            AND   B.PRC_GRP_LOC_CD = A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("					AND   A.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("           ),0)) AS AOBL_CNT" ).append("\n"); 
		query.append("         , SUM(NVL((SELECT 1" ).append("\n"); 
		query.append("		            FROM PRI_RG_GRP_LOC B" ).append("\n"); 
		query.append("		            WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("		            AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("		            AND   B.PRC_GRP_LOC_CD = A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("					AND   A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("           ),0)) AS ADBL_CNT" ).append("\n"); 
		query.append("    FROM PRI_RG_ARB A" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND   A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND   A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("    GROUP BY A.SVC_SCP_CD" ).append("\n"); 
		query.append(") ARL" ).append("\n"); 
		query.append("ON ARL.SVC_SCP_CD = RPG.SVC_SCP_CD" ).append("\n"); 

	}
}