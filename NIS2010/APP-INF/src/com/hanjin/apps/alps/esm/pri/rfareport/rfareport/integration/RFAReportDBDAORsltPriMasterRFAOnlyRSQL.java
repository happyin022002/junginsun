/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAReportDBDAORsltPriMasterRFAOnlyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAReportDBDAORsltPriMasterRFAOnlyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltPriMasterRFAOnly
	  * </pre>
	  */
	public RFAReportDBDAORsltPriMasterRFAOnlyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_req_rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_m_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_req_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_scp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_o_via",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_d_via",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_org",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sts",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration").append("\n"); 
		query.append("FileName : RFAReportDBDAORsltPriMasterRFAOnlyRSQL").append("\n"); 
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
		query.append("SELECT RFA.SVC_SCP_CD                               --Scope " ).append("\n"); 
		query.append("     , RFA.RHQ_CD                                   --RHQ" ).append("\n"); 
		query.append("     , RFA.OFC_CD                                   --Office" ).append("\n"); 
		query.append("     , RFA.EFF_DT                                   --EFF      " ).append("\n"); 
		query.append("     , RFA.EXP_DT                                   --EXP      " ).append("\n"); 
		query.append("     , RFA.PROP_NO                                  --PROP_No" ).append("\n"); 
		query.append("     , RFA.MST_RFA_NO                               --MST_RFA_No     " ).append("\n"); 
		query.append("     , RFA.AMDT_SEQ                                 --AMDT_SEQ    " ).append("\n"); 
		query.append("     , RFA.MST_ROUT_ID                              --MST_ROUT_ID      " ).append("\n"); 
		query.append("     , RFA.ORG_PNT_LOC_DEF_CD                       --Origin  " ).append("\n"); 
		query.append(" 	 , RFA.RCV_TERM_CD                              --R Term                   " ).append("\n"); 
		query.append("     , RFA.ORG_VIA_PORT_DEF_CD                      --O.Via       " ).append("\n"); 
		query.append("     , RFA.DEST_VIA_PORT_DEF_CD                     --D.Via       " ).append("\n"); 
		query.append("     , RFA.DEST_PNT_LOC_DEF_CD                      --Dest   " ).append("\n"); 
		query.append("	 , RFA.DE_TERM_CD                               --D Term    " ).append("\n"); 
		query.append("     , RFA.PROP_FRT_D2_RT_AMT                       --Current. Rate D2 " ).append("\n"); 
		query.append("     , RFA.PROP_FRT_D4_RT_AMT                       --Current. Rate D4 " ).append("\n"); 
		query.append("     , RFA.PROP_FRT_D5_RT_AMT                       --Current. Rate D5" ).append("\n"); 
		query.append("     , CASE WHEN WM_CONCAT(DISTINCT NOTE_CONV_RULE_CD) IS NULL THEN WM_CONCAT(DISTINCT NOTE_CONV_CHG_CD) " ).append("\n"); 
		query.append("       		WHEN WM_CONCAT(DISTINCT NOTE_CONV_CHG_CD) IS NULL THEN WM_CONCAT(DISTINCT NOTE_CONV_RULE_CD)" ).append("\n"); 
		query.append("			ELSE WM_CONCAT(DISTINCT NOTE_CONV_RULE_CD) ||','|| WM_CONCAT(DISTINCT NOTE_CONV_CHG_CD) " ).append("\n"); 
		query.append("	 		END AS NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("     ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', NOTE_CONV.BKG_DIR_CALL_FLG, '')) AS BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("     ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', NOTE_CONV.BKG_TS_PORT_DEF_CD, '')) AS BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("     ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', NOTE_CONV.BKG_SLAN_CD, '')) AS BKG_SLAN_CD" ).append("\n"); 
		query.append("     ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', (NOTE_CONV.BKG_VSL_CD || NOTE_CONV.BKG_SKD_VOY_NO || NOTE_CONV.BKG_SKD_DIR_CD), '')) AS BKG_VVD_CD" ).append("\n"); 
		query.append("     ,MAX(DECODE(NOTE_CONV_RULE_CD, 'APP', NOTE_CONV.NOTE_CONV_SEQ, '')) AS NOTE_CONV_SEQ" ).append("\n"); 
		query.append("     , RFA.PRC_CMDT_DEF_CD                           --CMDT                         " ).append("\n"); 
		query.append("     , RFA.PROP_STS_CD AS PROP_STS_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (SELECT RFA.*" ).append("\n"); 
		query.append("          , NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("            (SELECT SCP_MN.PROP_NO                      AS PROP_NO" ).append("\n"); 
		query.append("                 , SCP_MN.AMDT_SEQ                      AS AMDT_SEQ" ).append("\n"); 
		query.append("                 , SCP_MN.SVC_SCP_CD                    AS SVC_SCP_CD" ).append("\n"); 
		query.append("                 , CMDT.CMDT_HDR_SEQ                    AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                 , ROUT.ROUT_SEQ                        AS ROUT_SEQ" ).append("\n"); 
		query.append("                 , MAS.OFC_N3RD_LVL_CD                  AS RHQ_CD" ).append("\n"); 
		query.append("                 , MN.PROP_OFC_CD                       AS OFC_CD                       " ).append("\n"); 
		query.append("                 , TO_CHAR(SCP_MN.EFF_DT, 'YYYY-MM-DD') AS EFF_DT      " ).append("\n"); 
		query.append("                 , TO_CHAR(SCP_MN.EXP_DT, 'YYYY-MM-DD') AS EXP_DT      " ).append("\n"); 
		query.append("                 , HDR.RFA_NO                           AS MST_RFA_NO                      " ).append("\n"); 
		query.append("                 , ROUT.MST_ROUT_ID                     AS MST_ROUT_ID                " ).append("\n"); 
		query.append("                 , ROUT_ORG.ROUT_PNT_LOC_DEF_CD         AS ORG_PNT_LOC_DEF_CD       --ORG     " ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                 , ROUT_ORG.RCV_DE_TERM_CD              AS RCV_TERM_CD              --R TERM                  " ).append("\n"); 
		query.append("                 , ROUT_ORG_VIA.ROUT_VIA_PORT_DEF_CD    AS ORG_VIA_PORT_DEF_CD      --O.Via       " ).append("\n"); 
		query.append("                 , ROUT_DEST_VIA.ROUT_VIA_PORT_DEF_CD   AS DEST_VIA_PORT_DEF_CD     --D.Via       " ).append("\n"); 
		query.append("                 , ROUT_DEST.ROUT_PNT_LOC_DEF_CD        AS DEST_PNT_LOC_DEF_CD      --DEST  " ).append("\n"); 
		query.append("                 , ROUT_DEST.RCV_DE_TERM_CD             AS DE_TERM_CD               --D TERM    " ).append("\n"); 
		query.append("                 , RT_D2.PROP_FRT_RT_AMT                AS PROP_FRT_D2_RT_AMT       --Current. Rate D2 " ).append("\n"); 
		query.append("                 , RT_D4.PROP_FRT_RT_AMT                AS PROP_FRT_D4_RT_AMT       --Current. Rate D4 " ).append("\n"); 
		query.append("                 , RT_D5.PROP_FRT_RT_AMT                AS PROP_FRT_D5_RT_AMT       --Current. Rate D5 " ).append("\n"); 
		query.append("                 , (SELECT CMDT_NM FROM MDM_COMMODITY MM WHERE  MM.CMDT_CD  = CMDT.PRC_CMDT_DEF_CD)     AS PRC_CMDT_DEF_CD --CMDT                         " ).append("\n"); 
		query.append("                 , MN.PROP_STS_CD                       AS PROP_STS_CD" ).append("\n"); 
		query.append("            FROM  PRI_RP_HDR                HDR" ).append("\n"); 
		query.append("                , PRI_RP_MN                 MN" ).append("\n"); 
		query.append("                , PRI_RP_SCP_MN             SCP_MN" ).append("\n"); 
		query.append("                , PRI_RP_SCP_RT_CMDT_HDR    CMDT_HDR " ).append("\n"); 
		query.append("                , PRI_RP_SCP_RT_CMDT        CMDT" ).append("\n"); 
		query.append("                , PRI_RP_SCP_RT_CMDT_ROUT   ROUT" ).append("\n"); 
		query.append("                , PRI_RP_SCP_RT_ROUT_PNT    ROUT_ORG" ).append("\n"); 
		query.append("                , PRI_RP_SCP_RT_ROUT_VIA    ROUT_ORG_VIA" ).append("\n"); 
		query.append("                , PRI_RP_SCP_RT_ROUT_VIA    ROUT_DEST_VIA" ).append("\n"); 
		query.append("                , PRI_RP_SCP_RT_ROUT_PNT    ROUT_DEST" ).append("\n"); 
		query.append("                , PRI_RP_SCP_RT             RT_D2" ).append("\n"); 
		query.append("                , PRI_RP_SCP_RT             RT_D4" ).append("\n"); 
		query.append("                , PRI_RP_SCP_RT             RT_D5" ).append("\n"); 
		query.append("				, MAS_OFC_LVL               MAS" ).append("\n"); 
		query.append("            WHERE 1 = 1" ).append("\n"); 
		query.append("             AND HDR.PROP_NO    = MN.PROP_NO" ).append("\n"); 
		query.append("             ---------------------------------------" ).append("\n"); 
		query.append("             AND MN.PROP_NO     = SCP_MN.PROP_NO" ).append("\n"); 
		query.append("             AND MN.AMDT_SEQ    = SCP_MN.AMDT_SEQ" ).append("\n"); 
		query.append("             ---------------------------------------" ).append("\n"); 
		query.append("             AND SCP_MN.PROP_NO         = CMDT_HDR.PROP_NO" ).append("\n"); 
		query.append("             AND SCP_MN.AMDT_SEQ        = CMDT_HDR.AMDT_SEQ" ).append("\n"); 
		query.append("             AND SCP_MN.SVC_SCP_CD      = CMDT_HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("             ---------------------------------------" ).append("\n"); 
		query.append("             AND CMDT_HDR.PROP_NO           = CMDT.PROP_NO" ).append("\n"); 
		query.append("             AND CMDT_HDR.AMDT_SEQ          = CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("             AND CMDT_HDR.SVC_SCP_CD        = CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("             AND CMDT_HDR.CMDT_HDR_SEQ      = CMDT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             ---------------------------------------" ).append("\n"); 
		query.append("             AND CMDT_HDR.PROP_NO           = ROUT.PROP_NO" ).append("\n"); 
		query.append("             AND CMDT_HDR.AMDT_SEQ          = ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("             AND CMDT_HDR.SVC_SCP_CD        = ROUT.SVC_SCP_CD" ).append("\n"); 
		query.append("             AND CMDT_HDR.CMDT_HDR_SEQ      = ROUT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             ---------------------------------------" ).append("\n"); 
		query.append("             AND ROUT.PROP_NO           = ROUT_ORG.PROP_NO" ).append("\n"); 
		query.append("             AND ROUT.AMDT_SEQ          = ROUT_ORG.AMDT_SEQ" ).append("\n"); 
		query.append("             AND ROUT.SVC_SCP_CD        = ROUT_ORG.SVC_SCP_CD" ).append("\n"); 
		query.append("             AND ROUT.CMDT_HDR_SEQ      = ROUT_ORG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             AND ROUT.ROUT_SEQ          = ROUT_ORG.ROUT_SEQ" ).append("\n"); 
		query.append("             AND 'O'                    = ROUT_ORG.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("             --------------------------------------- " ).append("\n"); 
		query.append("             AND ROUT.PROP_NO           = ROUT_ORG_VIA.PROP_NO(+)" ).append("\n"); 
		query.append("             AND ROUT.AMDT_SEQ          = ROUT_ORG_VIA.AMDT_SEQ(+)" ).append("\n"); 
		query.append("             AND ROUT.SVC_SCP_CD        = ROUT_ORG_VIA.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("             AND ROUT.CMDT_HDR_SEQ      = ROUT_ORG_VIA.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("             AND ROUT.ROUT_SEQ          = ROUT_ORG_VIA.ROUT_SEQ(+)" ).append("\n"); 
		query.append("             AND 'O'                    = ROUT_ORG_VIA.ORG_DEST_TP_CD(+)" ).append("\n"); 
		query.append("             --------------------------------------- " ).append("\n"); 
		query.append("             AND ROUT.PROP_NO           = ROUT_DEST_VIA.PROP_NO(+)" ).append("\n"); 
		query.append("             AND ROUT.AMDT_SEQ          = ROUT_DEST_VIA.AMDT_SEQ(+)" ).append("\n"); 
		query.append("             AND ROUT.SVC_SCP_CD        = ROUT_DEST_VIA.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("             AND ROUT.CMDT_HDR_SEQ      = ROUT_DEST_VIA.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("             AND ROUT.ROUT_SEQ          = ROUT_DEST_VIA.ROUT_SEQ(+)" ).append("\n"); 
		query.append("             AND 'D'                    = ROUT_DEST_VIA.ORG_DEST_TP_CD(+)" ).append("\n"); 
		query.append("             --------------------------------------- " ).append("\n"); 
		query.append("             AND ROUT.PROP_NO           = ROUT_DEST.PROP_NO" ).append("\n"); 
		query.append("             AND ROUT.AMDT_SEQ          = ROUT_DEST.AMDT_SEQ" ).append("\n"); 
		query.append("             AND ROUT.SVC_SCP_CD        = ROUT_DEST.SVC_SCP_CD" ).append("\n"); 
		query.append("             AND ROUT.CMDT_HDR_SEQ      = ROUT_DEST.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             AND ROUT.ROUT_SEQ          = ROUT_DEST.ROUT_SEQ" ).append("\n"); 
		query.append("             AND 'D'                    = ROUT_DEST.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("             --------------------------------------- " ).append("\n"); 
		query.append("             AND ROUT.PROP_NO           = RT_D2.PROP_NO(+)" ).append("\n"); 
		query.append("             AND ROUT.AMDT_SEQ          = RT_D2.AMDT_SEQ(+)" ).append("\n"); 
		query.append("             AND ROUT.SVC_SCP_CD        = RT_D2.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("             AND ROUT.CMDT_HDR_SEQ      = RT_D2.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("             AND ROUT.ROUT_SEQ          = RT_D2.ROUT_SEQ(+)" ).append("\n"); 
		query.append("             AND 'D2'                   = RT_D2.RAT_UT_CD(+)" ).append("\n"); 
		query.append("              --------------------------------------- " ).append("\n"); 
		query.append("             AND ROUT.PROP_NO           = RT_D4.PROP_NO(+)" ).append("\n"); 
		query.append("             AND ROUT.AMDT_SEQ          = RT_D4.AMDT_SEQ(+)" ).append("\n"); 
		query.append("             AND ROUT.SVC_SCP_CD        = RT_D4.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("             AND ROUT.CMDT_HDR_SEQ      = RT_D4.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("             AND ROUT.ROUT_SEQ          = RT_D4.ROUT_SEQ(+)" ).append("\n"); 
		query.append("             AND 'D4'                   = RT_D4.RAT_UT_CD(+)" ).append("\n"); 
		query.append("              --------------------------------------- " ).append("\n"); 
		query.append("             AND ROUT.PROP_NO           = RT_D5.PROP_NO(+)" ).append("\n"); 
		query.append("             AND ROUT.AMDT_SEQ          = RT_D5.AMDT_SEQ(+)" ).append("\n"); 
		query.append("             AND ROUT.SVC_SCP_CD        = RT_D5.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("             AND ROUT.CMDT_HDR_SEQ      = RT_D5.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("             AND ROUT.ROUT_SEQ          = RT_D5.ROUT_SEQ(+)" ).append("\n"); 
		query.append("             AND 'D5'                   = RT_D5.RAT_UT_CD(+)" ).append("\n"); 
		query.append("             --------------------------------------- " ).append("\n"); 
		query.append(" 			 AND SCP_MN.PROP_SCP_OFC_CD = MAS.OFC_CD(+) " ).append("\n"); 
		query.append("             AND SCP_MN.EXP_DT <= TO_DATE(MAS.OFC_APLY_TO_YRMON(+),'YYYYMM')" ).append("\n"); 
		query.append("             AND SCP_MN.EFF_DT >= TO_DATE(MAS.OFC_APLY_FM_YRMON(+),'YYYYMM')" ).append("\n"); 
		query.append("             --------------------------------------- " ).append("\n"); 
		query.append("             AND MN.RFA_CTRT_TP_CD = 'M'" ).append("\n"); 
		query.append("             AND CMDT.PRC_CMDT_DEF_CD = '000000'         -- CMDT를 'FAK'로 고정" ).append("\n"); 
		query.append(" 			AND SCP_MN.EFF_DT <= TO_DATE(@[f_exp_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(" 			AND SCP_MN.EXP_DT >= TO_DATE(@[f_eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("			#if( ${f_m_rfa_no} != '')" ).append("\n"); 
		query.append(" 			AND HDR.RFA_NO = @[f_m_rfa_no]" ).append("\n"); 
		query.append(" 			#end" ).append("\n"); 
		query.append("			#if( ${f_req_ofc} != '')" ).append("\n"); 
		query.append(" 			AND MN.PROP_OFC_CD = @[f_req_ofc]" ).append("\n"); 
		query.append(" 			#elseif( ${f_req_rhq} != '')" ).append("\n"); 
		query.append(" 			AND MAS.OFC_N3RD_LVL_CD = @[f_req_rhq]" ).append("\n"); 
		query.append(" 			#end" ).append("\n"); 
		query.append(" 			#if( ${f_scp} != '')" ).append("\n"); 
		query.append(" 			AND SCP_MN.SVC_SCP_CD = @[f_scp]" ).append("\n"); 
		query.append(" 			#end" ).append("\n"); 
		query.append("			#if( ${f_org} != '')" ).append("\n"); 
		query.append(" 			AND ROUT_ORG.ROUT_PNT_LOC_DEF_CD  LIKE @[f_org]||'%'" ).append("\n"); 
		query.append(" 			#end" ).append("\n"); 
		query.append("			#if( ${f_o_via} != '')" ).append("\n"); 
		query.append(" 			AND ROUT_ORG_VIA.ROUT_VIA_PORT_DEF_CD LIKE @[f_o_via]||'%'" ).append("\n"); 
		query.append(" 			#end" ).append("\n"); 
		query.append("			#if( ${f_d_via} != '')" ).append("\n"); 
		query.append(" 			AND ROUT_DEST_VIA.ROUT_VIA_PORT_DEF_CD LIKE @[f_d_via]||'%'" ).append("\n"); 
		query.append(" 			#end" ).append("\n"); 
		query.append("			#if( ${f_dest} != '')" ).append("\n"); 
		query.append(" 			AND ROUT_DEST.ROUT_PNT_LOC_DEF_CD LIKE @[f_dest]||'%'" ).append("\n"); 
		query.append(" 			#end" ).append("\n"); 
		query.append("			#if( ${f_sts} != '')" ).append("\n"); 
		query.append(" 			AND MN.PROP_STS_CD  = @[f_sts]" ).append("\n"); 
		query.append(" 			#end" ).append("\n"); 
		query.append("             ) RFA" ).append("\n"); 
		query.append("           , PRI_RP_SCP_RT_CMDT_RNOTE RNOTE" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("     AND RFA.PROP_NO           = RNOTE.PROP_NO(+)" ).append("\n"); 
		query.append("     AND RFA.AMDT_SEQ          = RNOTE.AMDT_SEQ(+)" ).append("\n"); 
		query.append("     AND RFA.SVC_SCP_CD        = RNOTE.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("     AND RFA.CMDT_HDR_SEQ      = RNOTE.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("     AND RFA.ROUT_SEQ          = RNOTE.ROUT_SEQ(+)" ).append("\n"); 
		query.append("     )                      RFA" ).append("\n"); 
		query.append("     , PRI_RFA_NOTE_CONV    NOTE_CONV" ).append("\n"); 
		query.append(" WHERE RFA.NOTE_CONV_MAPG_ID = NOTE_CONV.NOTE_CONV_MAPG_ID(+)" ).append("\n"); 
		query.append(" GROUP BY  RFA.SVC_SCP_CD  " ).append("\n"); 
		query.append("     , RFA.RHQ_CD" ).append("\n"); 
		query.append("     , RFA.OFC_CD " ).append("\n"); 
		query.append("     , RFA.EFF_DT " ).append("\n"); 
		query.append("     , RFA.EXP_DT " ).append("\n"); 
		query.append("     , RFA.PROP_NO" ).append("\n"); 
		query.append("     , RFA.MST_RFA_NO " ).append("\n"); 
		query.append("     , RFA.AMDT_SEQ " ).append("\n"); 
		query.append("     , RFA.MST_ROUT_ID" ).append("\n"); 
		query.append("     , RFA.ORG_PNT_LOC_DEF_CD " ).append("\n"); 
		query.append(" 	 , RFA.RCV_TERM_CD       " ).append("\n"); 
		query.append("     , RFA.ORG_VIA_PORT_DEF_CD " ).append("\n"); 
		query.append("     , RFA.DEST_VIA_PORT_DEF_CD " ).append("\n"); 
		query.append("     , RFA.DEST_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	 , RFA.DE_TERM_CD " ).append("\n"); 
		query.append("     , RFA.PROP_FRT_D2_RT_AMT " ).append("\n"); 
		query.append("     , RFA.PROP_FRT_D4_RT_AMT" ).append("\n"); 
		query.append("     , RFA.PROP_FRT_D5_RT_AMT" ).append("\n"); 
		query.append("     , RFA.PRC_CMDT_DEF_CD                     " ).append("\n"); 
		query.append("     , RFA.PROP_STS_CD" ).append("\n"); 

	}
}