/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : TRIProposalDBDAORsltTriPropInquiryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.02
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.01.02 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAORsltTriPropInquiryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tri Proposal Inquiry List
	  * </pre>
	  */
	public TRIProposalDBDAORsltTriPropInquiryListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("srch_rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("srch_org_rout_via_port_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("srch_dest_rout_via_port_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_acs_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("srch_tri_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("srch_taa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAORsltTriPropInquiryListVORSQL").append("\n"); 
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
		query.append("     , A.TRF_PFX_CD" ).append("\n"); 
		query.append("     , A.TRF_NO" ).append("\n"); 
		query.append("     , NVL2(A.TRI_NO, SUBSTR(A.TRI_NO, 1, 6) || '-' || SUBSTR(A.TRI_NO, 7, 4) || '-' || SUBSTR(A.TRI_NO, 11), NULL) AS TRI_NO" ).append("\n"); 
		query.append("     , F.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.CMDT_CD" ).append("\n"); 
		query.append("     , (SELECT CMDT_NM" ).append("\n"); 
		query.append("          FROM MDM_COMMODITY" ).append("\n"); 
		query.append("         WHERE CMDT_CD = A.CMDT_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS CMDT_NM" ).append("\n"); 
		query.append("     , B.ROUT_PNT_LOC_NM AS ORG_ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("     , C.ROUT_VIA_PORT_NM AS ORG_ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("     , D.ROUT_VIA_PORT_NM AS DEST_ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("     , E.ROUT_PNT_LOC_NM AS DEST_ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("     , F.RAT_UT_CD" ).append("\n"); 
		query.append("     , F.CURR_CD" ).append("\n"); 
		query.append("     , F.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("     , F.NOTE_CTNT || CHR(13) NOTE_CTNT" ).append("\n"); 
		query.append("     , TO_CHAR(F.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(F.EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("     , G.TAA_NO" ).append("\n"); 
		query.append("  FROM PRI_TRI_MN A" ).append("\n"); 
		query.append("     , (SELECT TRI_PROP_NO, REPLACE(ROUT_PNT_LOC_NM, '|||', CHR(13)) AS ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                     , SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CD || NVL2(RCV_DE_TERM_NM, '(' || RCV_DE_TERM_NM || ')', '') ||" ).append("\n"); 
		query.append("                                                      NVL2(PRC_TRSP_MOD_NM, '(' || PRC_TRSP_MOD_NM || ')', '')" ).append("\n"); 
		query.append("                                                     ,'|||'))" ).append("\n"); 
		query.append("                             ,4) AS ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("                  FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                             , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                             , ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                             , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                             , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                 WHERE INTG_CD_ID = 'CD02070'" ).append("\n"); 
		query.append("                                   AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                             , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                             , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                 WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("                                   AND INTG_CD_VAL_CTNT = PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1) AS PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_PNT_LOC_CD) AS RN" ).append("\n"); 
		query.append("                        FROM PRI_TRI_RT_ROUT_PNT" ).append("\n"); 
		query.append("                       WHERE ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("                 START WITH RN = 1" ).append("\n"); 
		query.append("                CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("                   AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("                GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD)" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("     , (SELECT TRI_PROP_NO, REPLACE(ROUT_VIA_PORT_NM, '|||', CHR(13)) AS ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO, SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_CD, '|||')), 4) AS ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("		          FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("		                     , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		                     , ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("		                     , ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_VIA_PORT_CD) AS RN" ).append("\n"); 
		query.append("		                  FROM PRI_TRI_RT_ROUT_VIA" ).append("\n"); 
		query.append("		                 WHERE ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("		         START WITH RN = 1" ).append("\n"); 
		query.append("		        CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("		               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		         GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD)" ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append("     , (SELECT TRI_PROP_NO, REPLACE(ROUT_VIA_PORT_CD, '|||', CHR(13)) AS ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO, SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_CD, '|||')), 4) AS ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                  FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                             , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                             , ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_VIA_PORT_CD) AS RN" ).append("\n"); 
		query.append("                          FROM PRI_TRI_RT_ROUT_VIA" ).append("\n"); 
		query.append("                         WHERE ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("                 START WITH RN = 1" ).append("\n"); 
		query.append("                CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("                       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("                 GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD)" ).append("\n"); 
		query.append("       ) D" ).append("\n"); 
		query.append("     , (SELECT TRI_PROP_NO, REPLACE(ROUT_PNT_LOC_NM, '|||', CHR(13)) AS ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("          FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                     , SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_CD || NVL2(RCV_DE_TERM_NM, '(' || RCV_DE_TERM_NM || ')', '') ||" ).append("\n"); 
		query.append("                                                      NVL2(PRC_TRSP_MOD_NM, '(' || PRC_TRSP_MOD_NM || ')', '')" ).append("\n"); 
		query.append("                                                     ,'|||'))" ).append("\n"); 
		query.append("                             ,4) AS ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("                  FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                             , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                             , ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append("                             , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                             , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                 WHERE INTG_CD_ID = 'CD02071'" ).append("\n"); 
		query.append("                                   AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                             , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                             , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                 WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("                                   AND INTG_CD_VAL_CTNT = PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1) AS PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO, ORG_DEST_TP_CD ORDER BY TRI_PROP_NO, ORG_DEST_TP_CD, ROUT_PNT_LOC_CD) AS RN" ).append("\n"); 
		query.append("                          FROM PRI_TRI_RT_ROUT_PNT" ).append("\n"); 
		query.append("                         WHERE ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("                 START WITH RN = 1" ).append("\n"); 
		query.append("                CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("                       AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("                 GROUP BY TRI_PROP_NO, ORG_DEST_TP_CD)" ).append("\n"); 
		query.append("       ) E" ).append("\n"); 
		query.append("     , (SELECT T.TRI_PROP_NO" ).append("\n"); 
		query.append("             , T.AMDT_SEQ" ).append("\n"); 
		query.append("             , T.EFF_DT" ).append("\n"); 
		query.append("             , T.EXP_DT" ).append("\n"); 
		query.append("             , T.PUB_DT" ).append("\n"); 
		query.append("             , T.TRI_RQST_OFC_CD" ).append("\n"); 
		query.append("             , T.TRI_RQST_USR_ID" ).append("\n"); 
		query.append("             , T.TRI_APRO_OFC_CD" ).append("\n"); 
		query.append("             , T.TRI_APRO_USR_ID" ).append("\n"); 
		query.append("             , T.PROP_STS_CD" ).append("\n"); 
		query.append("             , T.RAT_UT_CD" ).append("\n"); 
		query.append("             , T.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("             , T.CURR_CD" ).append("\n"); 
		query.append("             , T.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("             , T.COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append("             , T.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("             , T.NOTE_CTNT" ).append("\n"); 
		query.append("             , T.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("             , T.GRI_APPL_TP_CD" ).append("\n"); 
		query.append("             , T.GRI_APPL_AMT" ).append("\n"); 
		query.append("          FROM PRI_TRI_RT T, (SELECT TRI_PROP_NO, AMDT_SEQ FROM PRI_TRI_RT GROUP BY TRI_PROP_NO, AMDT_SEQ) S" ).append("\n"); 
		query.append("         WHERE T.TRI_PROP_NO = S.TRI_PROP_NO" ).append("\n"); 
		query.append("           AND T.AMDT_SEQ = S.AMDT_SEQ" ).append("\n"); 
		query.append("           AND T.PROP_STS_CD = 'F') F" ).append("\n"); 
		query.append("     , (SELECT TRI_PROP_NO, REPLACE(TAA_NO, '|||', ' '||CHR(13)) || CHR(13) AS TAA_NO" ).append("\n"); 
		query.append("         FROM (SELECT TRI_PROP_NO" ).append("\n"); 
		query.append("                    , SUBSTR(MAX(SYS_CONNECT_BY_PATH(TAA_NO, '|||')), 4) AS TAA_NO" ).append("\n"); 
		query.append("                 FROM (SELECT D.TRI_PROP_NO" ).append("\n"); 
		query.append("                            , A.TAA_NO" ).append("\n"); 
		query.append("                            , ROW_NUMBER() OVER(PARTITION BY TRI_PROP_NO ORDER BY TRI_PROP_NO, TAA_NO) AS RN" ).append("\n"); 
		query.append("                         FROM PRI_TAA_HDR A" ).append("\n"); 
		query.append("                            , PRI_TAA_MN B" ).append("\n"); 
		query.append("                            , (SELECT TAA_PROP_NO" ).append("\n"); 
		query.append("                                    , MAX(AMDT_SEQ) AS AMDT_SEQ" ).append("\n"); 
		query.append("                                 FROM PRI_TAA_MN" ).append("\n"); 
		query.append("                                WHERE CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                               GROUP BY TAA_PROP_NO) C" ).append("\n"); 
		query.append("                            , PRI_TAA_TRI_LIST D" ).append("\n"); 
		query.append("                        WHERE (@[srch_taa_no] IS NULL OR A.TAA_NO = @[srch_taa_no])" ).append("\n"); 
		query.append("                          AND A.TAA_PROP_NO = B.TAA_PROP_NO" ).append("\n"); 
		query.append("                          AND B.TAA_PROP_NO = C.TAA_PROP_NO" ).append("\n"); 
		query.append("                          AND B.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("                          AND B.TAA_PROP_NO = D.TAA_PROP_NO" ).append("\n"); 
		query.append("                          AND B.AMDT_SEQ = D.AMDT_SEQ" ).append("\n"); 
		query.append("						  AND exists (select 'f' from PRI_TRI_MN G where G.TRF_PFX_CD = @[srch_trf_pfx_cd] AND G.TRF_NO = @[srch_trf_no] and D.TRI_PROP_NO = G.TRI_PROP_NO)" ).append("\n"); 
		query.append("                       ORDER BY TRI_PROP_NO, A.TAA_NO) " ).append("\n"); 
		query.append("                START WITH RN = 1" ).append("\n"); 
		query.append("               CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("                  AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("               GROUP BY TRI_PROP_NO)" ).append("\n"); 
		query.append("       ) G " ).append("\n"); 
		query.append(" WHERE A.TRI_PROP_NO = B.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = C.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = D.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = E.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = F.TRI_PROP_NO" ).append("\n"); 
		query.append("#if (${srch_taa_no} == '') " ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = G.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A.TRI_PROP_NO = G.TRI_PROP_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.TRF_PFX_CD = @[srch_trf_pfx_cd]" ).append("\n"); 
		query.append("   AND A.TRF_NO = @[srch_trf_no]" ).append("\n"); 
		query.append("   AND A.TRI_NO IS NOT NULL" ).append("\n"); 
		query.append("   AND (@[srch_cmdt_cd] IS NULL OR A.CMDT_CD = @[srch_cmdt_cd])" ).append("\n"); 
		query.append("   AND (@[srch_org_rout_pnt_loc_nm] IS NULL OR B.ROUT_PNT_LOC_NM LIKE '%' || @[srch_org_rout_pnt_loc_nm] || '%')" ).append("\n"); 
		query.append("   AND (@[srch_org_rout_via_port_nm] IS NULL OR C.ROUT_VIA_PORT_NM LIKE '%' || @[srch_org_rout_via_port_nm] || '%')" ).append("\n"); 
		query.append("   AND (@[srch_dest_rout_via_port_nm] IS NULL OR D.ROUT_VIA_PORT_NM LIKE '%' || @[srch_dest_rout_via_port_nm] || '%')" ).append("\n"); 
		query.append("   AND (@[srch_dest_rout_pnt_loc_nm] IS NULL OR E.ROUT_PNT_LOC_NM LIKE '%' || @[srch_dest_rout_pnt_loc_nm] || '%')" ).append("\n"); 
		query.append("   AND (@[srch_tri_no] IS NULL OR A.TRI_NO = REPLACE(@[srch_tri_no], '-'))" ).append("\n"); 
		query.append("   AND (@[srch_rat_ut_cd] IS NULL OR F.RAT_UT_CD = @[srch_rat_ut_cd])" ).append("\n"); 
		query.append("   AND REPLACE(@[srch_acs_dt],'-','') BETWEEN TO_CHAR(F.EFF_DT, 'YYYYMMDD') AND TO_CHAR(F.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append(" ORDER BY A.TRI_NO, A.CMDT_CD" ).append("\n"); 

	}
}