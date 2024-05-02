/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCRateProposalDBDAORsltPriRateHorizontalExcelChkVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAORsltPriRateHorizontalExcelChkVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * check the Excel Info
	  * </pre>
	  */
	public SCRateProposalDBDAORsltPriRateHorizontalExcelChkVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_rout_pnt_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_cmdt_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_rcv_de_term_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_rout_pnt_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_prc_trsp_mod_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_rout_via_port_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_rout_via_port_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_rcv_de_term_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_prc_trsp_mod_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAORsltPriRateHorizontalExcelChkVORSQL").append("\n"); 
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
		query.append("WITH TMP AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       @[prc_cmdt_def_cd] AS CMDT_CD" ).append("\n"); 
		query.append("     , (SELECT COUNT(COLUMN_VALUE) AS COL_CNT FROM(TABLE(BKG_SPLIT_FNC(@[prc_cmdt_def_cd],';')))) AS CMDT_CNT" ).append("\n"); 
		query.append("     , @[cust_seq] AS CUST_CD " ).append("\n"); 
		query.append("     , (SELECT COUNT(COLUMN_VALUE) AS COL_CNT FROM(TABLE(BKG_SPLIT_FNC(@[cust_seq],';')))) AS CUST_CNT" ).append("\n"); 
		query.append("     , @[org_rout_pnt_loc_def_cd] AS ORG_LOC_CD " ).append("\n"); 
		query.append("     , (SELECT COUNT(COLUMN_VALUE) AS COL_CNT FROM(TABLE(BKG_SPLIT_FNC(@[org_rout_pnt_loc_def_cd],';')))) AS ORG_LOC_CNT" ).append("\n"); 
		query.append("     , @[dest_rout_pnt_loc_def_cd] AS DEST_LOC_CD " ).append("\n"); 
		query.append("     , (SELECT COUNT(COLUMN_VALUE) AS COL_CNT FROM(TABLE(BKG_SPLIT_FNC(@[dest_rout_pnt_loc_def_cd],';')))) AS DEST_LOC_CNT" ).append("\n"); 
		query.append("     , @[org_rout_via_port_def_cd] AS ORG_VIA_LOC_CD " ).append("\n"); 
		query.append("     , (SELECT COUNT(COLUMN_VALUE) AS COL_CNT FROM(TABLE(BKG_SPLIT_FNC(@[org_rout_via_port_def_cd],';')))) AS ORG_VIA_LOC_CNT" ).append("\n"); 
		query.append("     , @[dest_rout_via_port_def_cd] AS DEST_VIA_LOC_CD " ).append("\n"); 
		query.append("     , (SELECT COUNT(COLUMN_VALUE) AS COL_CNT FROM(TABLE(BKG_SPLIT_FNC(@[dest_rout_via_port_def_cd],';')))) AS DEST_VIA_LOC_CNT" ).append("\n"); 
		query.append("     , @[org_rcv_de_term_nm] AS ORG_TERM_CD " ).append("\n"); 
		query.append("     , (SELECT COUNT(COLUMN_VALUE) AS COL_CNT FROM(TABLE(BKG_SPLIT_FNC(@[org_rcv_de_term_nm],';')))) AS ORG_TERM_CNT" ).append("\n"); 
		query.append("     , @[org_prc_trsp_mod_nm] AS ORG_TRSP_CD " ).append("\n"); 
		query.append("     , (SELECT COUNT(COLUMN_VALUE) AS COL_CNT FROM(TABLE(BKG_SPLIT_FNC(@[org_prc_trsp_mod_nm],';')))) AS ORG_TRSP_CNT" ).append("\n"); 
		query.append("     , @[dest_rcv_de_term_nm] AS DEST_TERM_CD " ).append("\n"); 
		query.append("     , (SELECT COUNT(COLUMN_VALUE) AS COL_CNT FROM(TABLE(BKG_SPLIT_FNC(@[dest_rcv_de_term_nm],';')))) AS DEST_TERM_CNT" ).append("\n"); 
		query.append("     , @[dest_prc_trsp_mod_nm] AS DEST_TRSP_CD " ).append("\n"); 
		query.append("     , (SELECT COUNT(COLUMN_VALUE) AS COL_CNT FROM(TABLE(BKG_SPLIT_FNC(@[dest_prc_trsp_mod_nm],';')))) AS DEST_TRSP_CNT" ).append("\n"); 
		query.append("     , @[cmdt_hdr_seq] AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , @[rout_seq] AS ROUT_SEQ" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       T_CMDT.CHK_PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("#if (${type} != 'U') " ).append("\n"); 
		query.append("     , T_CUST.CHK_CUST_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	 , 'T' AS CHK_CUST_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     , T_ORG_LOC.CHK_ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , T_DEST_LOC.CHK_DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , T_ORG_VIA_LOC.CHK_ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("     , T_DEST_VIA_LOC.CHK_DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("     , T_ORG_TERM.CHK_ORG_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("     , T_ORG_TRSP.CHK_ORG_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("     , T_DEST_TERM.CHK_DEST_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("     , T_DEST_TRSP.CHK_DEST_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("     , 0 AS CHK_PRC_CMDT_DEF_DUP" ).append("\n"); 
		query.append("     , 0 AS CHK_ORG_DEST_DUP" ).append("\n"); 
		query.append("     , T_CMDT_HDR.CHK_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , T_ROUT.CHK_ROUT_SEQ" ).append("\n"); 
		query.append("     , T_CHK_ORG_SEMI.CHK_ORG_SEMI" ).append("\n"); 
		query.append("     , T_CHK_DEST_SEMI.CHK_DEST_SEMI" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN (SELECT CMDT_CNT FROM TMP) = 0" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            WHEN PRC_CMDT_DEF_CD_CNT = (SELECT CMDT_CNT FROM TMP)" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("        END CHK_PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(CD) AS PRC_CMDT_DEF_CD_CNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.PRC_GRP_CMDT_CD    AS CD" ).append("\n"); 
		query.append("              ,A.PRC_GRP_CMDT_DESC  AS NM" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_GRP_CMDT A" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND PRC_GRP_CMDT_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT CMDT_CD FROM TMP),';')))WHERE LENGTH(COLUMN_VALUE) = 5)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT CMDT_CD AS CD" ).append("\n"); 
		query.append("              ,CMDT_NM AS NM" ).append("\n"); 
		query.append("          FROM MDM_COMMODITY" ).append("\n"); 
		query.append("         WHERE CMDT_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT CMDT_CD FROM TMP),';')))WHERE LENGTH(COLUMN_VALUE) = 6)" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append(")) T_CMDT," ).append("\n"); 
		query.append("#if (${type} != 'U') " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN (SELECT CUST_CNT FROM TMP) = 0" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            WHEN CUST_SEQ_CNT = (SELECT CUST_CNT FROM TMP)" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("        END CHK_CUST_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(CD) AS CUST_SEQ_CNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') AS CD" ).append("\n"); 
		query.append("      ,CUST_LGL_ENG_NM AS NM" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER" ).append("\n"); 
		query.append(" WHERE (CUST_CNT_CD,CUST_SEQ) IN (SELECT SUBSTR(COLUMN_VALUE,1,2) AS CUST_CNT_CD, SUBSTR(COLUMN_VALUE,3) AS CUST_SEQ FROM(TABLE(BKG_SPLIT_FNC((SELECT CUST_CD FROM TMP),';'))) )" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND CNTR_DIV_FLG = 'Y' ) )" ).append("\n"); 
		query.append(") T_CUST," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN (SELECT ORG_LOC_CNT FROM TMP) = 0" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            WHEN ORG_ROUT_PNT_LOC_DEF_CD_CNT = (SELECT ORG_LOC_CNT FROM TMP)" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("        END CHK_ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(CD) AS ORG_ROUT_PNT_LOC_DEF_CD_CNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT G.PRC_GRP_LOC_CD     AS CD" ).append("\n"); 
		query.append("             , G.PRC_GRP_LOC_DESC   AS NM" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_GRP_LOC G" ).append("\n"); 
		query.append("         WHERE G.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND G.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND G.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND G.PRC_GRP_LOC_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT ORG_LOC_CD FROM TMP),';'))) WHERE LENGTH(COLUMN_VALUE) = 4) " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT M.LOC_CD AS CD" ).append("\n"); 
		query.append("             , M.LOC_NM AS NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION M" ).append("\n"); 
		query.append("             , MDM_SVC_SCP_LMT L" ).append("\n"); 
		query.append("         WHERE L.SVC_SCP_CD  = @[svc_scp_cd] " ).append("\n"); 
		query.append("           AND L.ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("           AND L.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("           AND L.RGN_CD      = M.RGN_CD" ).append("\n"); 
		query.append("           AND M.LOC_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT ORG_LOC_CD FROM TMP),';'))) WHERE LENGTH(COLUMN_VALUE) = 5)" ).append("\n"); 
		query.append("		))  " ).append("\n"); 
		query.append(") T_ORG_LOC," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN (SELECT DEST_LOC_CNT FROM TMP) = 0" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            WHEN DEST_ROUT_PNT_LOC_DEF_CD_CNT = (SELECT DEST_LOC_CNT FROM TMP)" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("        END CHK_DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(CD) AS DEST_ROUT_PNT_LOC_DEF_CD_CNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT G.PRC_GRP_LOC_CD     AS CD" ).append("\n"); 
		query.append("             , G.PRC_GRP_LOC_DESC   AS NM" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_GRP_LOC G" ).append("\n"); 
		query.append("         WHERE G.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND G.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND G.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND G.PRC_GRP_LOC_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT DEST_LOC_CD FROM TMP),';'))) WHERE LENGTH(COLUMN_VALUE) = 4) " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT M.LOC_CD AS CD" ).append("\n"); 
		query.append("             , M.LOC_NM AS NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION M" ).append("\n"); 
		query.append("             , MDM_SVC_SCP_LMT L" ).append("\n"); 
		query.append("         WHERE L.SVC_SCP_CD  = @[svc_scp_cd] " ).append("\n"); 
		query.append("           AND L.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("           AND L.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("           AND L.RGN_CD      = M.RGN_CD" ).append("\n"); 
		query.append("           AND M.LOC_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT DEST_LOC_CD FROM TMP),';'))) WHERE LENGTH(COLUMN_VALUE) = 5)" ).append("\n"); 
		query.append("		))" ).append("\n"); 
		query.append(") T_DEST_LOC," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN (SELECT ORG_VIA_LOC_CNT FROM TMP) = 0" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            WHEN ORG_ROUT_VIA_PORT_DEF_CD_CNT = (SELECT  ORG_VIA_LOC_CNT FROM TMP)" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("        END CHK_ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(CD) AS ORG_ROUT_VIA_PORT_DEF_CD_CNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT G.PRC_GRP_LOC_CD     AS CD" ).append("\n"); 
		query.append("             , G.PRC_GRP_LOC_DESC   AS NM" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_GRP_LOC G" ).append("\n"); 
		query.append("         WHERE G.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND G.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND G.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND G.PRC_GRP_LOC_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT ORG_VIA_LOC_CD FROM TMP),';'))) WHERE LENGTH(COLUMN_VALUE) = 4) " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT M.LOC_CD AS CD" ).append("\n"); 
		query.append("             , M.LOC_NM AS NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION M" ).append("\n"); 
		query.append("         WHERE M.LOC_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT ORG_VIA_LOC_CD FROM TMP),';'))) WHERE LENGTH(COLUMN_VALUE) = 5)" ).append("\n"); 
		query.append("		))" ).append("\n"); 
		query.append(") T_ORG_VIA_LOC," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN (SELECT DEST_VIA_LOC_CNT FROM TMP) = 0" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            WHEN DEST_ROUT_VIA_PORT_DEF_CD_CNT = (SELECT  DEST_VIA_LOC_CNT FROM TMP)" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("        END CHK_DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(CD) AS DEST_ROUT_VIA_PORT_DEF_CD_CNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT G.PRC_GRP_LOC_CD     AS CD" ).append("\n"); 
		query.append("             , G.PRC_GRP_LOC_DESC   AS NM" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_GRP_LOC G" ).append("\n"); 
		query.append("         WHERE G.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND G.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND G.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND G.PRC_GRP_LOC_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT DEST_VIA_LOC_CD FROM TMP),';'))) WHERE LENGTH(COLUMN_VALUE) = 4) " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT M.LOC_CD AS CD" ).append("\n"); 
		query.append("             , M.LOC_NM AS NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION M" ).append("\n"); 
		query.append("         WHERE M.LOC_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT DEST_VIA_LOC_CD FROM TMP),';'))) WHERE LENGTH(COLUMN_VALUE) = 5)" ).append("\n"); 
		query.append("		)) " ).append("\n"); 
		query.append(") T_DEST_VIA_LOC," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN (SELECT ORG_TERM_CNT FROM TMP) = 0" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            WHEN ORG_TERM_CD_CNT = (SELECT ORG_TERM_CNT FROM TMP)" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("        END CHK_ORG_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(INTG_CD_VAL_DP_DESC) AS ORG_TERM_CD_CNT" ).append("\n"); 
		query.append("  FROM COM_INTG_CD_DTL b" ).append("\n"); 
		query.append(" WHERE INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("   AND INTG_CD_VAL_DP_DESC IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT ORG_TERM_CD FROM TMP),';')))) )" ).append("\n"); 
		query.append(") T_ORG_TERM," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN (SELECT ORG_TRSP_CNT FROM TMP) = 0" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            WHEN ORG_TRSP_CD_CNT = (SELECT ORG_TRSP_CNT FROM TMP)" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("        END CHK_ORG_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(INTG_CD_VAL_DP_DESC) AS ORG_TRSP_CD_CNT" ).append("\n"); 
		query.append("  FROM COM_INTG_CD_DTL b" ).append("\n"); 
		query.append(" WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("   AND INTG_CD_VAL_DP_DESC IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT ORG_TRSP_CD FROM TMP),';')))) )" ).append("\n"); 
		query.append(") T_ORG_TRSP," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN (SELECT DEST_TERM_CNT FROM TMP) = 0" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            WHEN DEST_TERM_CD_CNT = (SELECT DEST_TERM_CNT FROM TMP)" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("        END CHK_DEST_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(INTG_CD_VAL_DP_DESC) AS DEST_TERM_CD_CNT" ).append("\n"); 
		query.append("  FROM COM_INTG_CD_DTL b" ).append("\n"); 
		query.append(" WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("   AND INTG_CD_VAL_DP_DESC IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT DEST_TERM_CD FROM TMP),';')))) )" ).append("\n"); 
		query.append(") T_DEST_TERM," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN (SELECT DEST_TRSP_CNT FROM TMP) = 0" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            WHEN DEST_TRSP_CD_CNT = (SELECT DEST_TRSP_CNT FROM TMP)" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("        END CHK_DEST_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(INTG_CD_VAL_DP_DESC) AS DEST_TRSP_CD_CNT" ).append("\n"); 
		query.append("  FROM COM_INTG_CD_DTL b" ).append("\n"); 
		query.append(" WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("   AND INTG_CD_VAL_DP_DESC IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT DEST_TRSP_CD FROM TMP),';')))) )" ).append("\n"); 
		query.append(") T_DEST_TRSP," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("        DECODE(@[cmdt_hdr_seq],NULL,'T',DECODE(CMDT_HDR_SEQ_CNT,0,'F','T')) AS CHK_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("       COUNT(CMDT_HDR_SEQ) AS CMDT_HDR_SEQ_CNT" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_RT_CMDT_HDR" ).append("\n"); 
		query.append(" WHERE PROP_NO           = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ          = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD        = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("   AND CMDT_HDR_SEQ      = @[cmdt_hdr_seq] ) ) T_CMDT_HDR," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("        DECODE(@[rout_seq],NULL,'T',DECODE(ROUT_SEQ_CNT,0,'F','T')) AS CHK_ROUT_SEQ" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("       COUNT(ROUT_SEQ) AS ROUT_SEQ_CNT" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_RT_CMDT_ROUT" ).append("\n"); 
		query.append(" WHERE PROP_NO           = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ          = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD        = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("   AND CMDT_HDR_SEQ      = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("   AND ROUT_SEQ          = @[rout_seq] ) ) T_ROUT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN ( ((TERM_CNT > 0) OR (TRSP_CNT > 0)) AND ((DB_LOC_CNT <> CUR_DB_LOC_CNT) OR (CUR_CNT <> CUR_DB_LOC_CNT)) )" ).append("\n"); 
		query.append("                 THEN 'F'" ).append("\n"); 
		query.append("            ELSE 'T'" ).append("\n"); 
		query.append("         END CHK_ORG_SEMI        " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(DISTINCT A.ROUT_PNT_LOC_DEF_CD) AS DB_LOC_CNT" ).append("\n"); 
		query.append("     , MAX(E.ORG_LOC_CNT) AS CUR_CNT" ).append("\n"); 
		query.append("     , MAX(B.LOC_CNT) AS CUR_DB_LOC_CNT" ).append("\n"); 
		query.append("     , MAX(C.TERM_CNT) AS TERM_CNT" ).append("\n"); 
		query.append("     , MAX(D.TRSP_CNT) AS TRSP_CNT   " ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_RT_ROUT_PNT A" ).append("\n"); 
		query.append("     , (SELECT" ).append("\n"); 
		query.append("               COUNT(DISTINCT ROUT_PNT_LOC_DEF_CD) AS LOC_CNT" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("         WHERE PROP_NO           = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ          = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD        = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ      = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("           AND ROUT_SEQ          = @[rout_seq]" ).append("\n"); 
		query.append("           AND ROUT_PNT_LOC_DEF_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT ORG_LOC_CD FROM TMP),';')))) " ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD    = 'O')  B" ).append("\n"); 
		query.append("     , (SELECT NVL(INSTR(ORG_TERM_CD,';'),0) AS TERM_CNT FROM TMP ) C" ).append("\n"); 
		query.append("     , (SELECT NVL(INSTR(ORG_TRSP_CD,';'),0) AS TRSP_CNT FROM TMP ) D" ).append("\n"); 
		query.append("     , (SELECT ORG_LOC_CNT FROM TMP) E" ).append("\n"); 
		query.append(" WHERE PROP_NO           = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ          = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD        = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("   AND CMDT_HDR_SEQ      = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("   AND ROUT_SEQ          = @[rout_seq]" ).append("\n"); 
		query.append("   AND ORG_DEST_TP_CD = 'O' )) T_CHK_ORG_SEMI," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN ( ((TERM_CNT > 0) OR (TRSP_CNT > 0)) AND ((DB_LOC_CNT <> CUR_DB_LOC_CNT) OR (CUR_CNT <> CUR_DB_LOC_CNT)) )" ).append("\n"); 
		query.append("                 THEN 'F'" ).append("\n"); 
		query.append("            ELSE 'T'" ).append("\n"); 
		query.append("         END CHK_DEST_SEMI        " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       COUNT(DISTINCT A.ROUT_PNT_LOC_DEF_CD) AS DB_LOC_CNT" ).append("\n"); 
		query.append("     , MAX(E.DEST_LOC_CNT) AS CUR_CNT" ).append("\n"); 
		query.append("     , MAX(B.LOC_CNT) AS CUR_DB_LOC_CNT" ).append("\n"); 
		query.append("     , MAX(C.TERM_CNT) AS TERM_CNT" ).append("\n"); 
		query.append("     , MAX(D.TRSP_CNT) AS TRSP_CNT   " ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_RT_ROUT_PNT A" ).append("\n"); 
		query.append("     , (SELECT" ).append("\n"); 
		query.append("               COUNT(DISTINCT ROUT_PNT_LOC_DEF_CD) AS LOC_CNT" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("         WHERE PROP_NO           = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ          = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD        = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ      = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("           AND ROUT_SEQ          = @[rout_seq]" ).append("\n"); 
		query.append("           AND ROUT_PNT_LOC_DEF_CD IN (SELECT COLUMN_VALUE FROM(TABLE(BKG_SPLIT_FNC((SELECT DEST_LOC_CD FROM TMP),';')))) " ).append("\n"); 
		query.append("           AND ORG_DEST_TP_CD    = 'D')  B" ).append("\n"); 
		query.append("     , (SELECT NVL(INSTR(DEST_TERM_CD,';'),0) AS TERM_CNT FROM TMP ) C" ).append("\n"); 
		query.append("     , (SELECT NVL(INSTR(DEST_TRSP_CD,';'),0) AS TRSP_CNT FROM TMP ) D" ).append("\n"); 
		query.append("     , (SELECT DEST_LOC_CNT FROM TMP) E" ).append("\n"); 
		query.append(" WHERE PROP_NO           = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ          = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD        = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("   AND CMDT_HDR_SEQ      = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("   AND ROUT_SEQ          = @[rout_seq]" ).append("\n"); 
		query.append("   AND ORG_DEST_TP_CD = 'D' )) T_CHK_DEST_SEMI" ).append("\n"); 

	}
}