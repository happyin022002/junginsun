/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAORsltTriPropListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.21
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2010.12.21 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAORsltTriPropListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRI Proposal List를 조회한다.
	  * </pre>
	  */
	public TRIProposalDBDAORsltTriPropListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_acc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_dest_rout_pnt_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_tri_rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_dest_rout_via_port_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_tri_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_tri_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_gri_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_org_rout_pnt_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_prop_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_is_gri_appl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_org_rout_via_port_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAORsltTriPropListVORSQL").append("\n"); 
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
		query.append("SELECT A.TRI_PROP_NO" ).append("\n"); 
		query.append("      ,A.TRF_PFX_CD || '-' || A.TRF_NO AS TRF_CD" ).append("\n"); 
		query.append("      ,A.TRF_PFX_CD" ).append("\n"); 
		query.append("      ,A.TRF_NO" ).append("\n"); 
		query.append("      ,NVL2(A.TRI_NO, SUBSTR(A.TRI_NO, 1, 6) || '-' || SUBSTR(A.TRI_NO, 7, 4) || '-' || SUBSTR(A.TRI_NO, 11), NULL) AS TRI_NO" ).append("\n"); 
		query.append("      ,F.AMDT_SEQ" ).append("\n"); 
		query.append("      ,DECODE(F.AMDT_SEQ, 0, 'New', 'Amend') AS CUR_STATUS" ).append("\n"); 
		query.append("      ,TO_CHAR(F.PUB_DT, 'YYYY-MM-DD') AS PUB_DT" ).append("\n"); 
		query.append("      ,A.CMDT_CD" ).append("\n"); 
		query.append("      ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("          FROM MDM_COMMODITY" ).append("\n"); 
		query.append("         WHERE CMDT_CD = A.CMDT_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS CMDT_NM" ).append("\n"); 
		query.append("      ,B.ROUT_PNT_LOC_NM AS ORG_ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("      ,REPLACE(B.ROUT_PNT_LOC_NM_SND, '^|^', CHR(13)) AS ORG_ROUT_PNT_LOC_NM_SND" ).append("\n"); 
		query.append("      ,C.ROUT_VIA_PORT_NM AS ORG_ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("      ,REPLACE(C.ROUT_VIA_PORT_NM_SND, '^|^', CHR(13)) AS ORG_ROUT_VIA_PORT_NM_SND" ).append("\n"); 
		query.append("      ,D.ROUT_VIA_PORT_NM AS DEST_ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("      ,REPLACE(D.ROUT_VIA_PORT_NM_SND, '^|^', CHR(13)) AS DEST_ROUT_VIA_PORT_NM_SND" ).append("\n"); 
		query.append("      ,E.ROUT_PNT_LOC_NM AS DEST_ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("      ,REPLACE(E.ROUT_PNT_LOC_NM_SND, '^|^', CHR(13)) AS DEST_ROUT_PNT_LOC_NM_SND" ).append("\n"); 
		query.append("      ,F.RAT_UT_CD" ).append("\n"); 
		query.append("      ,F.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("      ,F.CURR_CD" ).append("\n"); 
		query.append("      ,F.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("      ,F.COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append("      ,F.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("      ,F.NOTE_CTNT" ).append("\n"); 
		query.append("      ,F.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(F.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(F.EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("      ,F.PROP_STS_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD02395'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = F.PROP_STS_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS PROP_STS_NM" ).append("\n"); 
		query.append("      ,F.GRI_APPL_TP_CD" ).append("\n"); 
		query.append("      ,F.GRI_APPL_AMT" ).append("\n"); 
		query.append("      ,F.TRI_RQST_OFC_CD" ).append("\n"); 
		query.append("      ,F.TRI_APRO_OFC_CD" ).append("\n"); 
		query.append("      ,F.TRI_RQST_USR_ID" ).append("\n"); 
		query.append("      ,F.TRI_APRO_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(F.LAST_PUB_DT, 'YYYY-MM-DD') AS LAST_PUB_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(F.EML_SND_DT, 'YYYY-MM-DD') AS EML_SND_DT" ).append("\n"); 
		query.append("      ,A.PRS_RT_CMPB_CALC_FLG" ).append("\n"); 
		query.append("      ,F.TRI_RMK" ).append("\n"); 
		query.append("  FROM PRI_TRI_MN A" ).append("\n"); 
		query.append("      ,(SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CD, ', ')) ,3) AS ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_NM || NVL2(RCV_DE_TERM_NM, '(' || RCV_DE_TERM_NM || ')', '') ||" ).append("\n"); 
		query.append("                                              NVL2(PRC_TRSP_MOD_NM, '(' || PRC_TRSP_MOD_NM || ')', '')" ).append("\n"); 
		query.append("                                             ,'^|^'))" ).append("\n"); 
		query.append("                     ,4) AS ROUT_PNT_LOC_NM_SND" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                      ,(SELECT LOC_NM" ).append("\n"); 
		query.append("                          FROM MDM_LOCATION" ).append("\n"); 
		query.append("                         WHERE LOC_CD = ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("                      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                         WHERE INTG_CD_ID = 'CD02070'" ).append("\n"); 
		query.append("                           AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                      ,PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                         WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("                           AND INTG_CD_VAL_CTNT = PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_PNT_LOC_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_TRI_RT_ROUT_PNT" ).append("\n"); 
		query.append("                 WHERE ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD) B" ).append("\n"); 
		query.append("      ,(SELECT TRI_PROP_NO, SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_CD, ', ')), 3) AS ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_NM, '^|^')), 4) AS ROUT_VIA_PORT_NM_SND" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                      ,(SELECT LOC_NM" ).append("\n"); 
		query.append("                          FROM MDM_LOCATION" ).append("\n"); 
		query.append("                         WHERE LOC_CD = ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_VIA_PORT_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_TRI_RT_ROUT_VIA" ).append("\n"); 
		query.append("                 WHERE ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD) C" ).append("\n"); 
		query.append("      ,(SELECT TRI_PROP_NO, SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_CD, ', ')), 3) AS ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_NM, '^|^')), 4) AS ROUT_VIA_PORT_NM_SND" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                      ,(SELECT LOC_NM" ).append("\n"); 
		query.append("                          FROM MDM_LOCATION" ).append("\n"); 
		query.append("                         WHERE LOC_CD = ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_VIA_PORT_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_TRI_RT_ROUT_VIA" ).append("\n"); 
		query.append("                 WHERE ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD) D" ).append("\n"); 
		query.append("      ,(SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CD, ', ')), 3) AS ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_NM || NVL2(RCV_DE_TERM_NM, '(' || RCV_DE_TERM_NM || ')', '') ||" ).append("\n"); 
		query.append("                                              NVL2(PRC_TRSP_MOD_NM, '(' || PRC_TRSP_MOD_NM || ')', '')" ).append("\n"); 
		query.append("                                             ,'^|^'))" ).append("\n"); 
		query.append("                     ,4) AS ROUT_PNT_LOC_NM_SND" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                      ,(SELECT LOC_NM" ).append("\n"); 
		query.append("                          FROM MDM_LOCATION" ).append("\n"); 
		query.append("                         WHERE LOC_CD = ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("                      ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                         WHERE INTG_CD_ID = 'CD02071'" ).append("\n"); 
		query.append("                           AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                      ,PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                         WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("                           AND INTG_CD_VAL_CTNT = PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_PNT_LOC_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_TRI_RT_ROUT_PNT" ).append("\n"); 
		query.append("                 WHERE ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD) E" ).append("\n"); 
		query.append("      ,(SELECT T.TRI_PROP_NO" ).append("\n"); 
		query.append("              ,T.AMDT_SEQ" ).append("\n"); 
		query.append("              ,T.EFF_DT" ).append("\n"); 
		query.append("              ,T.EXP_DT" ).append("\n"); 
		query.append("              ,T.PUB_DT" ).append("\n"); 
		query.append("              ,(SELECT S1.PUB_DT FROM PRI_TRI_RT S1 WHERE S1.TRI_PROP_NO = T.TRI_PROP_NO AND S1.AMDT_SEQ = T.AMDT_SEQ - 1) AS LAST_PUB_DT" ).append("\n"); 
		query.append("              ,T.TRI_RQST_OFC_CD" ).append("\n"); 
		query.append("              ,T.TRI_RQST_USR_ID" ).append("\n"); 
		query.append("              ,T.TRI_APRO_OFC_CD" ).append("\n"); 
		query.append("              ,T.TRI_APRO_USR_ID" ).append("\n"); 
		query.append("              ,T.PROP_STS_CD" ).append("\n"); 
		query.append("              ,T.RAT_UT_CD" ).append("\n"); 
		query.append("              ,T.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("              ,T.CURR_CD" ).append("\n"); 
		query.append("              ,T.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("              ,T.COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append("              ,T.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("              ,T.NOTE_CTNT" ).append("\n"); 
		query.append("              ,T.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("              ,T.GRI_APPL_TP_CD" ).append("\n"); 
		query.append("              ,T.GRI_APPL_AMT" ).append("\n"); 
		query.append("              ,T.EML_SND_DT" ).append("\n"); 
		query.append("              ,T.TRI_RMK" ).append("\n"); 
		query.append("          FROM PRI_TRI_RT T, (SELECT TRI_PROP_NO, MAX(AMDT_SEQ) AS AMDT_SEQ FROM PRI_TRI_RT GROUP BY TRI_PROP_NO) S" ).append("\n"); 
		query.append("         WHERE T.TRI_PROP_NO = S.TRI_PROP_NO" ).append("\n"); 
		query.append("           AND T.AMDT_SEQ = S.AMDT_SEQ) F" ).append("\n"); 
		query.append(" WHERE A.TRI_PROP_NO = B.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = C.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = D.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = E.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = F.TRI_PROP_NO" ).append("\n"); 
		query.append("   AND A.TRF_PFX_CD = @[srch_trf_pfx_cd]" ).append("\n"); 
		query.append("   AND A.TRF_NO = @[srch_trf_no]" ).append("\n"); 
		query.append("   AND (@[srch_cmdt_cd] IS NULL OR A.CMDT_CD = @[srch_cmdt_cd])" ).append("\n"); 
		query.append("   AND (@[srch_org_rout_pnt_loc_nm] IS NULL OR B.ROUT_PNT_LOC_NM LIKE '%' || @[srch_org_rout_pnt_loc_nm] || '%')" ).append("\n"); 
		query.append("   AND (@[srch_org_rout_via_port_nm] IS NULL OR C.ROUT_VIA_PORT_NM LIKE '%' || @[srch_org_rout_via_port_nm] || '%')" ).append("\n"); 
		query.append("   AND (@[srch_dest_rout_via_port_nm] IS NULL OR D.ROUT_VIA_PORT_NM LIKE '%' || @[srch_dest_rout_via_port_nm] || '%')" ).append("\n"); 
		query.append("   AND (@[srch_dest_rout_pnt_loc_nm] IS NULL OR E.ROUT_PNT_LOC_NM LIKE '%' || @[srch_dest_rout_pnt_loc_nm] || '%')" ).append("\n"); 
		query.append("   AND (@[srch_tri_no] IS NULL OR A.TRI_NO = REPLACE(@[srch_tri_no], '-'))" ).append("\n"); 
		query.append("   AND (@[srch_tri_prop_no] IS NULL OR A.TRI_PROP_NO = @[srch_tri_prop_no])" ).append("\n"); 
		query.append("   AND (@[srch_tri_apro_ofc_cd] IS NULL OR F.TRI_APRO_OFC_CD = @[srch_tri_apro_ofc_cd])" ).append("\n"); 
		query.append("   AND (@[srch_tri_rqst_ofc_cd] IS NULL OR F.TRI_RQST_OFC_CD = @[srch_tri_rqst_ofc_cd])" ).append("\n"); 
		query.append("   AND (@[srch_prop_sts_cd] IS NULL OR F.PROP_STS_CD = @[srch_prop_sts_cd])" ).append("\n"); 
		query.append("   AND (@[srch_is_gri_appl] IS NULL OR F.GRI_APPL_TP_CD IN ('A', 'M'))" ).append("\n"); 
		query.append("   AND (@[srch_gri_eff_dt] IS NULL OR TO_CHAR(F.EFF_DT, 'YYYY-MM-DD') = @[srch_gri_eff_dt])" ).append("\n"); 
		query.append("   AND (@[srch_acc_dt] IS NULL OR @[srch_acc_dt] BETWEEN TO_CHAR(F.EFF_DT, 'YYYY-MM-DD') AND TO_CHAR(F.EXP_DT, 'YYYY-MM-DD'))" ).append("\n"); 
		query.append(" ORDER BY A.TRI_NO ASC NULLS FIRST, A.TRI_PROP_NO ASC" ).append("\n"); 

	}
}