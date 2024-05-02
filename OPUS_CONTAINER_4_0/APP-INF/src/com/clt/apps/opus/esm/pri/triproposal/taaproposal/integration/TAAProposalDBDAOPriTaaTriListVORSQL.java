/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TAAProposalDBDAOPriTaaTriListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.02.23 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mood Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOPriTaaTriListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TAAProposalDBDAOPriTaaTriListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOPriTaaTriListVORSQL").append("\n"); 
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
		query.append("WITH TRI AS (" ).append("\n"); 
		query.append("    SELECT TD.TAA_NO" ).append("\n"); 
		query.append("         , TA.TAA_PROP_NO" ).append("\n"); 
		query.append("         , TA.AMDT_SEQ" ).append("\n"); 
		query.append("         , TR.TRI_PROP_NO" ).append("\n"); 
		query.append("         , TR.AMDT_SEQ AS TRI_AMDT_SEQ" ).append("\n"); 
		query.append("         , TM.TRF_PFX_CD" ).append("\n"); 
		query.append("         , TM.TRF_NO" ).append("\n"); 
		query.append("         , TM.TRI_NO" ).append("\n"); 
		query.append("         , TM.CMDT_CD" ).append("\n"); 
		query.append("         , (SELECT MC.CMDT_NM" ).append("\n"); 
		query.append("            FROM MDM_COMMODITY MC" ).append("\n"); 
		query.append("            WHERE MC.CMDT_CD = TM.CMDT_CD) AS CMDT_NM" ).append("\n"); 
		query.append("         , TR.RAT_UT_CD" ).append("\n"); 
		query.append("         , TR.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("         , TR.CURR_CD" ).append("\n"); 
		query.append("         , TR.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("         , TR.NOTE_CTNT" ).append("\n"); 
		query.append("         , TR.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("         , TR.EFF_DT" ).append("\n"); 
		query.append("         , TR.EXP_DT" ).append("\n"); 
		query.append("    FROM PRI_TAA_HDR TD" ).append("\n"); 
		query.append("       , PRI_TAA_MN TA" ).append("\n"); 
		query.append("       , PRI_TAA_TRI_LIST TL" ).append("\n"); 
		query.append("       , PRI_TRI_MN TM" ).append("\n"); 
		query.append("       , PRI_TRI_RT TR" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND   TD.TAA_NO = @[taa_no]" ).append("\n"); 
		query.append("#if (${amdt_seq} != '') " ).append("\n"); 
		query.append("    AND   TA.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    AND   TA.AMDT_SEQ = (SELECT MAX(TM.AMDT_SEQ)" ).append("\n"); 
		query.append("                         FROM PRI_TAA_MN TM" ).append("\n"); 
		query.append("                         WHERE TM.TAA_PROP_NO = TA.TAA_PROP_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND   TA.TAA_PROP_NO = TD.TAA_PROP_NO" ).append("\n"); 
		query.append("    AND   TL.TAA_PROP_NO = TA.TAA_PROP_NO" ).append("\n"); 
		query.append("    AND   TL.AMDT_SEQ = TA.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   TM.TRI_PROP_NO = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("    AND   TR.TRI_PROP_NO = TM.TRI_PROP_NO" ).append("\n"); 
		query.append("    AND   TR.AMDT_SEQ = (SELECT MAX(TT.AMDT_SEQ)" ).append("\n"); 
		query.append("                         FROM PRI_TRI_RT TT" ).append("\n"); 
		query.append("                         WHERE TT.TRI_PROP_NO = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("                         AND   TT.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                         AND   CASE WHEN TA.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                    THEN CASE WHEN TT.EFF_DT <= TA.EXP_DT AND TT.EXP_DT >= TA.EFF_DT" ).append("\n"); 
		query.append("                                              THEN 1" ).append("\n"); 
		query.append("                                              ELSE 0" ).append("\n"); 
		query.append("                                         END" ).append("\n"); 
		query.append("                                    ELSE 1" ).append("\n"); 
		query.append("                               END = 1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TA.TAA_PROP_NO" ).append("\n"); 
		query.append("     , TA.TAA_NO" ).append("\n"); 
		query.append("     , TA.AMDT_SEQ" ).append("\n"); 
		query.append("     , TA.TRI_PROP_NO" ).append("\n"); 
		query.append("     , TA.TRI_AMDT_SEQ" ).append("\n"); 
		query.append("     , TA.TRF_PFX_CD" ).append("\n"); 
		query.append("     , TA.TRF_NO" ).append("\n"); 
		query.append("     , TA.TRI_NO" ).append("\n"); 
		query.append("     , TA.CMDT_CD" ).append("\n"); 
		query.append("     , TA.CMDT_NM" ).append("\n"); 
		query.append("     , PO.ORG_PNT_LOC_CD" ).append("\n"); 
		query.append("     , PD.DEST_PNT_LOC_CD" ).append("\n"); 
		query.append("     , VO.ORG_VIA_PORT_CD" ).append("\n"); 
		query.append("     , VD.DEST_VIA_PORT_CD" ).append("\n"); 
		query.append("     , PN.ORG_PNT_LOC_NM" ).append("\n"); 
		query.append("     , PM.DEST_PNT_LOC_NM" ).append("\n"); 
		query.append("     , VN.ORG_VIA_PORT_NM" ).append("\n"); 
		query.append("     , VM.DEST_VIA_PORT_NM" ).append("\n"); 
		query.append("     , TA.RAT_UT_CD" ).append("\n"); 
		query.append("     , TA.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , TA.CURR_CD" ).append("\n"); 
		query.append("     , TA.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("     , TA.NOTE_CTNT" ).append("\n"); 
		query.append("     , TA.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("     , TO_CHAR(TA.EFF_DT, 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(TA.EXP_DT, 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("     , '' AS PUB_DT" ).append("\n"); 
		query.append("     , '' AS TRF_CD" ).append("\n"); 
		query.append("     , '' AS TRF_NM" ).append("\n"); 
		query.append("     , '' AS FRM_TRF_CD" ).append("\n"); 
		query.append("     , '' AS FRM_TRF_NM" ).append("\n"); 
		query.append("     , '' AS FRM_TRF_PFX_CD" ).append("\n"); 
		query.append("     , '' AS FRM_TRF_NO" ).append("\n"); 
		query.append("     , '' AS FRM_TRI_NO" ).append("\n"); 
		query.append("     , '' AS FRM_CMDT_CD" ).append("\n"); 
		query.append("     , '' AS FRM_ORG_PNT_LOC_CD" ).append("\n"); 
		query.append("     , '' AS FRM_DEST_PNT_LOC_CD" ).append("\n"); 
		query.append("     , '' AS FRM_ORG_VIA_PORT_CD" ).append("\n"); 
		query.append("     , '' AS FRM_DEST_VIA_PORT_CD" ).append("\n"); 
		query.append("     , '' AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM TRI TA" ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("        SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("             , SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CD,', ')), 3) AS ORG_PNT_LOC_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT RO.TRI_PROP_NO" ).append("\n"); 
		query.append("                     , RO.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                     , RO.ROUT_PNT_SEQ" ).append("\n"); 
		query.append("                     , RO.ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                     , DENSE_RANK() OVER (PARTITION BY RO.TRI_PROP_NO, RO.ORG_DEST_TP_CD ORDER BY RO.TRI_PROP_NO, RO.ORG_DEST_TP_CD, RO.ROUT_PNT_SEQ, RO.ROUT_PNT_LOC_CD) AS SEQ" ).append("\n"); 
		query.append("                FROM PRI_TRI_RT_ROUT_PNT RO" ).append("\n"); 
		query.append("                   , TRI TR" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND   RO.TRI_PROP_NO = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("                AND   RO.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        START WITH SEQ = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR ORG_DEST_TP_CD = ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               AND PRIOR SEQ = SEQ -1" ).append("\n"); 
		query.append("        GROUP BY TRI_PROP_NO" ).append("\n"); 
		query.append("   ) PO" ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("        SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("             , SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CD,', ')), 3) AS DEST_PNT_LOC_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT RD.TRI_PROP_NO" ).append("\n"); 
		query.append("                     , RD.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                     , RD.ROUT_PNT_SEQ" ).append("\n"); 
		query.append("                     , RD.ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                     , DENSE_RANK() OVER (PARTITION BY RD.TRI_PROP_NO, RD.ORG_DEST_TP_CD ORDER BY RD.TRI_PROP_NO, RD.ORG_DEST_TP_CD, RD.ROUT_PNT_SEQ, RD.ROUT_PNT_LOC_CD) AS SEQ" ).append("\n"); 
		query.append("                FROM PRI_TRI_RT_ROUT_PNT RD" ).append("\n"); 
		query.append("                   , TRI TR" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND   RD.TRI_PROP_NO = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("                AND   RD.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        START WITH SEQ = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR ORG_DEST_TP_CD = ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               AND PRIOR SEQ = SEQ -1" ).append("\n"); 
		query.append("        GROUP BY TRI_PROP_NO" ).append("\n"); 
		query.append("   ) PD" ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("        SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("             , SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_CD,', ')), 3) ORG_VIA_PORT_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT VO.TRI_PROP_NO" ).append("\n"); 
		query.append("                     , VO.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                     , VO.ROUT_VIA_SEQ" ).append("\n"); 
		query.append("                     , VO.ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                     , DENSE_RANK() OVER (PARTITION BY VO.TRI_PROP_NO, VO.ORG_DEST_TP_CD ORDER BY VO.TRI_PROP_NO, VO.ORG_DEST_TP_CD, VO.ROUT_VIA_SEQ, VO.ROUT_VIA_PORT_CD) AS SEQ" ).append("\n"); 
		query.append("                FROM PRI_TRI_RT_ROUT_VIA VO" ).append("\n"); 
		query.append("                   , TRI TR" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND   VO.TRI_PROP_NO = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("                AND   VO.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        START WITH SEQ = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR ORG_DEST_TP_CD = ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               AND PRIOR SEQ = SEQ -1" ).append("\n"); 
		query.append("        GROUP BY TRI_PROP_NO" ).append("\n"); 
		query.append("   ) VO" ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("        SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("             , SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_CD,', ')), 3) DEST_VIA_PORT_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT VD.TRI_PROP_NO" ).append("\n"); 
		query.append("                     , VD.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                     , VD.ROUT_VIA_SEQ" ).append("\n"); 
		query.append("                     , VD.ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                     , DENSE_RANK() OVER (PARTITION BY VD.TRI_PROP_NO, VD.ORG_DEST_TP_CD ORDER BY VD.TRI_PROP_NO, VD.ORG_DEST_TP_CD, VD.ROUT_VIA_SEQ, VD.ROUT_VIA_PORT_CD) AS SEQ" ).append("\n"); 
		query.append("                FROM PRI_TRI_RT_ROUT_VIA VD" ).append("\n"); 
		query.append("                   , TRI TR" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND   VD.TRI_PROP_NO = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("                AND   VD.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        START WITH SEQ = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR ORG_DEST_TP_CD = ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               AND PRIOR SEQ = SEQ -1" ).append("\n"); 
		query.append("        GROUP BY TRI_PROP_NO" ).append("\n"); 
		query.append("   ) VD" ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("        SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("             , SUBSTR(MAX(SYS_CONNECT_BY_PATH(LOC_NM || DECODE(TERM_NM, NULL, '', '(' || TERM_NM || ')') " ).append("\n"); 
		query.append("                                                     || DECODE(TRANS_MODE_NM, NULL, '', '(' || TRANS_MODE_NM || ')'), '|')), 2) AS ORG_PNT_LOC_NM" ).append("\n"); 
		query.append("             -- , SUBSTR(MAX(SYS_CONNECT_BY_PATH(LOC_NM,'|')), 2) AS ORG_PNT_LOC_NM" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT TP.TRI_PROP_NO" ).append("\n"); 
		query.append("                     , TP.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                     , TP.ROUT_PNT_SEQ" ).append("\n"); 
		query.append("                     , TP.ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                     , ML.LOC_NM" ).append("\n"); 
		query.append("                     , (SELECT TM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                        FROM  COM_INTG_CD_DTL TM" ).append("\n"); 
		query.append("                        WHERE TM.INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("                        AND   TM.INTG_CD_VAL_CTNT = TP.RCV_DE_TERM_CD) AS TERM_NM" ).append("\n"); 
		query.append("                     , (SELECT TM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                        FROM  COM_INTG_CD_DTL TM" ).append("\n"); 
		query.append("                        WHERE TM.INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("                        AND   TM.INTG_CD_VAL_CTNT = TP.PRC_TRSP_MOD_CD) AS TRANS_MODE_NM" ).append("\n"); 
		query.append("                     , DENSE_RANK() OVER (PARTITION BY TP.TRI_PROP_NO, TP.ORG_DEST_TP_CD ORDER BY TP.TRI_PROP_NO, TP.ORG_DEST_TP_CD, TP.ROUT_PNT_SEQ, TP.ROUT_PNT_LOC_CD) AS SEQ" ).append("\n"); 
		query.append("                FROM PRI_TRI_RT_ROUT_PNT TP" ).append("\n"); 
		query.append("                   , TRI TR" ).append("\n"); 
		query.append("                   , MDM_LOCATION ML" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND   TP.TRI_PROP_NO = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("                AND   TP.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                AND   ML.LOC_CD = TP.ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        START WITH SEQ = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR ORG_DEST_TP_CD = ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               AND PRIOR SEQ = SEQ - 1" ).append("\n"); 
		query.append("        GROUP BY TRI_PROP_NO" ).append("\n"); 
		query.append("   ) PN" ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("        SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("             , SUBSTR(MAX(SYS_CONNECT_BY_PATH(LOC_NM || DECODE(TERM_NM, NULL, '', '(' || TERM_NM || ')') " ).append("\n"); 
		query.append("                                                     || DECODE(TRANS_MODE_NM, NULL, '', '(' || TRANS_MODE_NM || ')'), '|')), 2) AS DEST_PNT_LOC_NM" ).append("\n"); 
		query.append("--             , SUBSTR(MAX(SYS_CONNECT_BY_PATH(LOC_NM,'|')), 2) AS DEST_PNT_LOC_NM" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT TP.TRI_PROP_NO" ).append("\n"); 
		query.append("                     , TP.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                     , TP.ROUT_PNT_SEQ" ).append("\n"); 
		query.append("                     , TP.ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                     , ML.LOC_NM" ).append("\n"); 
		query.append("                     , (SELECT TM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                        FROM  COM_INTG_CD_DTL TM" ).append("\n"); 
		query.append("                        WHERE TM.INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("                        AND   TM.INTG_CD_VAL_CTNT = TP.RCV_DE_TERM_CD) AS TERM_NM" ).append("\n"); 
		query.append("                     , (SELECT TM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                        FROM  COM_INTG_CD_DTL TM" ).append("\n"); 
		query.append("                        WHERE TM.INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("                        AND   TM.INTG_CD_VAL_CTNT = TP.PRC_TRSP_MOD_CD) AS TRANS_MODE_NM" ).append("\n"); 
		query.append("                     , DENSE_RANK() OVER (PARTITION BY TP.TRI_PROP_NO, TP.ORG_DEST_TP_CD ORDER BY TP.TRI_PROP_NO, TP.ORG_DEST_TP_CD, TP.ROUT_PNT_SEQ, TP.ROUT_PNT_LOC_CD) AS SEQ" ).append("\n"); 
		query.append("                FROM PRI_TRI_RT_ROUT_PNT TP" ).append("\n"); 
		query.append("                   , TRI TR" ).append("\n"); 
		query.append("                   , MDM_LOCATION ML" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND   TP.TRI_PROP_NO = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("                AND   TP.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                AND   ML.LOC_CD = TP.ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        START WITH SEQ = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR ORG_DEST_TP_CD = ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               AND PRIOR SEQ = SEQ - 1" ).append("\n"); 
		query.append("        GROUP BY TRI_PROP_NO" ).append("\n"); 
		query.append("   ) PM" ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("        SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("             , SUBSTR(MAX(SYS_CONNECT_BY_PATH(LOC_NM,'|')), 2) ORG_VIA_PORT_NM" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT VI.TRI_PROP_NO" ).append("\n"); 
		query.append("                     , VI.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                     , VI.ROUT_VIA_SEQ" ).append("\n"); 
		query.append("                     , VI.ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                     , ML.LOC_NM" ).append("\n"); 
		query.append("                     , DENSE_RANK() OVER (PARTITION BY VI.TRI_PROP_NO, VI.ORG_DEST_TP_CD ORDER BY VI.TRI_PROP_NO, VI.ORG_DEST_TP_CD, VI.ROUT_VIA_SEQ, VI.ROUT_VIA_PORT_CD) AS SEQ" ).append("\n"); 
		query.append("                FROM PRI_TRI_RT_ROUT_VIA VI" ).append("\n"); 
		query.append("                   , TRI TR" ).append("\n"); 
		query.append("                   , MDM_LOCATION ML" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND   VI.TRI_PROP_NO = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("                AND   VI.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                AND   ML.LOC_CD = VI.ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        START WITH SEQ = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR ORG_DEST_TP_CD = ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               AND PRIOR SEQ = SEQ -1" ).append("\n"); 
		query.append("        GROUP BY TRI_PROP_NO" ).append("\n"); 
		query.append("   ) VN" ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("        SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("             , SUBSTR(MAX(SYS_CONNECT_BY_PATH(LOC_NM,'|')), 2) DEST_VIA_PORT_NM" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT VI.TRI_PROP_NO" ).append("\n"); 
		query.append("                     , VI.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                     , VI.ROUT_VIA_SEQ" ).append("\n"); 
		query.append("                     , VI.ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                     , ML.LOC_NM" ).append("\n"); 
		query.append("                     , DENSE_RANK() OVER (PARTITION BY VI.TRI_PROP_NO, VI.ORG_DEST_TP_CD ORDER BY VI.TRI_PROP_NO, VI.ORG_DEST_TP_CD, VI.ROUT_VIA_SEQ, VI.ROUT_VIA_PORT_CD) AS SEQ" ).append("\n"); 
		query.append("                FROM PRI_TRI_RT_ROUT_VIA VI" ).append("\n"); 
		query.append("                   , TRI TR" ).append("\n"); 
		query.append("                   , MDM_LOCATION ML" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND   VI.TRI_PROP_NO = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("                AND   VI.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                AND   ML.LOC_CD = VI.ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        START WITH SEQ = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR ORG_DEST_TP_CD = ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               AND PRIOR SEQ = SEQ -1" ).append("\n"); 
		query.append("        GROUP BY TRI_PROP_NO" ).append("\n"); 
		query.append("   ) VM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   PO.TRI_PROP_NO(+) = TA.TRI_PROP_NO" ).append("\n"); 
		query.append("AND   PD.TRI_PROP_NO(+) = TA.TRI_PROP_NO" ).append("\n"); 
		query.append("AND   VO.TRI_PROP_NO(+) = TA.TRI_PROP_NO" ).append("\n"); 
		query.append("AND   VD.TRI_PROP_NO(+) = TA.TRI_PROP_NO" ).append("\n"); 
		query.append("AND   PN.TRI_PROP_NO(+) = TA.TRI_PROP_NO" ).append("\n"); 
		query.append("AND   PM.TRI_PROP_NO(+) = TA.TRI_PROP_NO" ).append("\n"); 
		query.append("AND   VN.TRI_PROP_NO(+) = TA.TRI_PROP_NO" ).append("\n"); 
		query.append("AND   VM.TRI_PROP_NO(+) = TA.TRI_PROP_NO" ).append("\n"); 
		query.append("ORDER BY TA.TRI_NO" ).append("\n"); 

	}
}