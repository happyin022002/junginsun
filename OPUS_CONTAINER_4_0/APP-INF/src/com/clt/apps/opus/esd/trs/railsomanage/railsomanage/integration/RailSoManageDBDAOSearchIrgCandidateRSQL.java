/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailSoManageDBDAOSearchIrgCandidateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearchIrgCandidateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IRG ADJUST  DETAIL 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearchIrgCandidateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearchIrgCandidateRSQL").append("\n"); 
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
		query.append("#set(${cgo_tp_cd}=${cgo_tp_cd})" ).append("\n"); 
		query.append("#set(${rout_seq}=${rout_seq})" ).append("\n"); 
		query.append("#set(${trsp_bnd_cd}=${trsp_bnd_cd})" ).append("\n"); 
		query.append("#set(${bkg_rcvde_term_cd}=${bkg_rcvde_term_cd})" ).append("\n"); 
		query.append("#set(${key_org}=${key_org})" ).append("\n"); 
		query.append("#set(${key_dest}=${key_dest})" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach(${key} IN ${arr_size})" ).append("\n"); 
		query.append("    #if(${cgo_tp_cd.get($key)} == \"'M'\")" ).append("\n"); 
		query.append("       #if($velocityCount == 1)" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                  ${rout_seq.get($key)} KEY_SEQ," ).append("\n"); 
		query.append("                  RANK() OVER (ORDER BY ROUT_SEQ) ALT_SUB_SEQ ," ).append("\n"); 
		query.append("                  PRIO_SEQ," ).append("\n"); 
		query.append("                  INLND_ROUT_RMK," ).append("\n"); 
		query.append("                  ROUT_PLN_CD," ).append("\n"); 
		query.append("                  ROUT_SEQ," ).append("\n"); 
		query.append("                  ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                  ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                  RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("                  SUBSTR( REF_NO, 1, LENGTH(REF_NO)-2 ) REF_NO," ).append("\n"); 
		query.append("                  IRG1 || IRG2 || IRG3 || IRG4 || IRG5 || IRG6 || IRG7 || IRG8 IRG ," ).append("\n"); 
		query.append("                  FM_NOD ," ).append("\n"); 
		query.append("                  TO_NOD ," ).append("\n"); 
		query.append("                  IC_1 ," ).append("\n"); 
		query.append("                  IC_2 ," ).append("\n"); 
		query.append("                  CASE WHEN TRSP_MOD LIKE '%RD%TD%RD%' THEN 'RTR' WHEN TRSP_MOD NOT LIKE '%RD%' THEN 'NRD' ELSE '' END RTR" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                  SELECT" ).append("\n"); 
		query.append("                        A.PRIO_SEQ," ).append("\n"); 
		query.append("                        A.INLND_ROUT_RMK INLND_ROUT_RMK," ).append("\n"); 
		query.append("                        A.ROUT_PLN_CD ROUT_PLN_CD," ).append("\n"); 
		query.append("                        A.ROUT_SEQ," ).append("\n"); 
		query.append("                        A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                        A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                        '' IRG," ).append("\n"); 
		query.append("                        MAX(A. INLND_ROUT_INV_BIL_PATT_CD) RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 1, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 2, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 3, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 4, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 5, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 6, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 7, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 8, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) REF_NO," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 1, B.LNK_ORG_NOD_CD||'-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG1," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 2, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG2," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 3, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG3," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 4, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG4," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 5, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG5," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 6, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG6," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 7, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG7," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 8, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG8 ," ).append("\n"); 
		query.append("                        SUBSTR(MIN( DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_ORG_NOD_CD ) ) , 3) FM_NOD ," ).append("\n"); 
		query.append("                        SUBSTR(MAX( DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_DEST_NOD_CD) ), 3) TO_NOD ," ).append("\n"); 
		query.append("                        SUBSTR(MIN( DECODE( SUBSTR(A.INLND_ROUT_INV_BIL_PATT_CD , 2, 1) , 1, '' , DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_DEST_NOD_CD)) ), 3) IC_1 ," ).append("\n"); 
		query.append("                        SUBSTR(MAX( DECODE( SUBSTR(A.INLND_ROUT_INV_BIL_PATT_CD , 2, 1) , 1, '' , 2, '', DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_ORG_NOD_CD)) ), 3) IC_2 ," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 1, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 2, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 3, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 4, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 5, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 6, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 7, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 8, B.TRSP_MOD_CD)) TRSP_MOD" ).append("\n"); 
		query.append("                  FROM" ).append("\n"); 
		query.append("                        PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("                        PRD_INLND_ROUT_DTL B," ).append("\n"); 
		query.append("                        MDM_VENDOR C," ).append("\n"); 
		query.append("                        PRD_NODE ORG ," ).append("\n"); 
		query.append("                        PRD_NODE DEST," ).append("\n"); 
		query.append("                        TRS_AGMT_HDR AGMT ," ).append("\n"); 
		query.append("                       (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                              A.ROUT_ORG_NOD_CD ," ).append("\n"); 
		query.append("                              A.ROUT_DEST_NOD_CD ," ).append("\n"); 
		query.append("                              A.ROUT_SEQ ," ).append("\n"); 
		query.append("                              C.MIN_SEQ MIN_SEQ," ).append("\n"); 
		query.append("                              ROUT_DTL_SEQ MAX_SEQ" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                              PRD_INLND_ROUT_DTL A," ).append("\n"); 
		query.append("                             (" ).append("\n"); 
		query.append("                              SELECT" ).append("\n"); 
		query.append("                                    ROUT_ORG_NOD_CD ," ).append("\n"); 
		query.append("                                    ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                                    ROUT_SEQ ," ).append("\n"); 
		query.append("                                    ROUT_DTL_SEQ MIN_SEQ" ).append("\n"); 
		query.append("                              FROM" ).append("\n"); 
		query.append("                                    PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("                              WHERE LNK_ORG_NOD_CD = ${key_org.get($key)}" ).append("\n"); 
		query.append("                              AND 	TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("                             ) C" ).append("\n"); 
		query.append("                        WHERE LNK_DEST_NOD_CD = ${key_dest.get($key)}" ).append("\n"); 
		query.append("                        AND   A.ROUT_ORG_NOD_CD = C.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                        AND   A.ROUT_DEST_NOD_CD = C.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                        AND   A.ROUT_SEQ = C.ROUT_SEQ" ).append("\n"); 
		query.append("                        AND   TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("                       ) D" ).append("\n"); 
		query.append("                  WHERE A.ROUT_ORG_NOD_CD LIKE ${key_org.get($key)}||'%'" ).append("\n"); 
		query.append("                  AND   A.ROUT_DEST_NOD_CD LIKE ${key_dest.get($key)}||'%'" ).append("\n"); 
		query.append("                  AND   A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                  AND   A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                  AND   A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("                  AND   B.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                  AND   B.TRSP_AGMT_SEQ =AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                  AND   NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                  AND   A.PCTL_IO_BND_CD = 'M'" ).append("\n"); 
		query.append("                  AND   B.TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("                  AND   B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("                  AND   B.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                  AND   B.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                  AND   B.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("                  AND   B.ROUT_DTL_SEQ >= D.MIN_SEQ" ).append("\n"); 
		query.append("                  AND   B.ROUT_DTL_SEQ <= D.MAX_SEQ" ).append("\n"); 
		query.append("                  AND   A.ROUT_ORG_NOD_CD = ORG.NOD_CD" ).append("\n"); 
		query.append("                  AND   A.ROUT_DEST_NOD_CD = DEST.NOD_CD" ).append("\n"); 
		query.append("                  AND   ORG.NOD_CD <> 'Z'" ).append("\n"); 
		query.append("                  AND   DEST.NOD_CD <> 'Z'" ).append("\n"); 
		query.append("                  GROUP BY A.PRIO_SEQ, A.INLND_ROUT_RMK, A.ROUT_PLN_CD, A.ROUT_SEQ, B.TRSP_MOD_CD, A.ROUT_ORG_NOD_CD, A.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            UNION" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                  ${rout_seq.get($key)} KEY_SEQ," ).append("\n"); 
		query.append("                  RANK() OVER (ORDER BY ROUT_SEQ) ALT_SUB_SEQ ," ).append("\n"); 
		query.append("                  PRIO_SEQ," ).append("\n"); 
		query.append("                  INLND_ROUT_RMK," ).append("\n"); 
		query.append("                  ROUT_PLN_CD," ).append("\n"); 
		query.append("                  ROUT_SEQ," ).append("\n"); 
		query.append("                  ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                  ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                  RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("                  SUBSTR( REF_NO, 1, LENGTH(REF_NO)-2 ) REF_NO," ).append("\n"); 
		query.append("                  IRG1 || IRG2 || IRG3 || IRG4 || IRG5 || IRG6 || IRG7 || IRG8 IRG ," ).append("\n"); 
		query.append("                  FM_NOD ," ).append("\n"); 
		query.append("                  TO_NOD ," ).append("\n"); 
		query.append("                  IC_1 ," ).append("\n"); 
		query.append("                  IC_2 ," ).append("\n"); 
		query.append("                  CASE WHEN TRSP_MOD LIKE '%RD%TD%RD%' THEN 'RTR' WHEN TRSP_MOD NOT LIKE '%RD%' THEN 'NRD' ELSE '' END RTR" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                  SELECT" ).append("\n"); 
		query.append("                        A.PRIO_SEQ," ).append("\n"); 
		query.append("                        A.INLND_ROUT_RMK INLND_ROUT_RMK," ).append("\n"); 
		query.append("                        A.ROUT_PLN_CD ROUT_PLN_CD," ).append("\n"); 
		query.append("                        A.ROUT_SEQ," ).append("\n"); 
		query.append("                        A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                        A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                        '' IRG," ).append("\n"); 
		query.append("                        MAX(A. INLND_ROUT_INV_BIL_PATT_CD) RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 1, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 2, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 3, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 4, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 5, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 6, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 7, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 8, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) REF_NO," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 1, B.LNK_ORG_NOD_CD||'-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG1," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 2, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG2," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 3, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG3," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 4, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG4," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 5, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG5," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 6, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG6," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 7, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG7," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 8, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG8 ," ).append("\n"); 
		query.append("                        SUBSTR(MIN( DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_ORG_NOD_CD ) ) , 3) FM_NOD ," ).append("\n"); 
		query.append("                        SUBSTR(MAX( DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_DEST_NOD_CD) ), 3) TO_NOD ," ).append("\n"); 
		query.append("                        SUBSTR(MIN( DECODE( SUBSTR(A.INLND_ROUT_INV_BIL_PATT_CD , 2, 1) , 1, '' , DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_DEST_NOD_CD)) ), 3) IC_1 ," ).append("\n"); 
		query.append("                        SUBSTR(MAX( DECODE( SUBSTR(A.INLND_ROUT_INV_BIL_PATT_CD , 2, 1) , 1, '' , 2, '', DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_ORG_NOD_CD)) ), 3) IC_2 ," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 1, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 2, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 3, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 4, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 5, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 6, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 7, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 8, B.TRSP_MOD_CD)) TRSP_MOD" ).append("\n"); 
		query.append("                  FROM" ).append("\n"); 
		query.append("                       PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("                       PRD_INLND_ROUT_DTL B," ).append("\n"); 
		query.append("                       MDM_VENDOR C," ).append("\n"); 
		query.append("                       PRD_NODE ORG ," ).append("\n"); 
		query.append("                       PRD_NODE DEST," ).append("\n"); 
		query.append("                       TRS_AGMT_HDR AGMT ," ).append("\n"); 
		query.append("                      (" ).append("\n"); 
		query.append("                       SELECT" ).append("\n"); 
		query.append("                             A.ROUT_ORG_NOD_CD ," ).append("\n"); 
		query.append("                             A.ROUT_DEST_NOD_CD ," ).append("\n"); 
		query.append("                             A.ROUT_SEQ ," ).append("\n"); 
		query.append("                             C.MIN_SEQ MIN_SEQ," ).append("\n"); 
		query.append("                             ROUT_DTL_SEQ MAX_SEQ" ).append("\n"); 
		query.append("                       FROM" ).append("\n"); 
		query.append("                             PRD_INLND_ROUT_DTL A," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                             SELECT" ).append("\n"); 
		query.append("                                   ROUT_ORG_NOD_CD ," ).append("\n"); 
		query.append("                                   ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                                   ROUT_SEQ ," ).append("\n"); 
		query.append("                                   ROUT_DTL_SEQ MIN_SEQ" ).append("\n"); 
		query.append("                             FROM" ).append("\n"); 
		query.append("                                   PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("                             WHERE LNK_ORG_NOD_CD = ${key_org.get($key)}" ).append("\n"); 
		query.append("                             AND 	TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("                            ) C" ).append("\n"); 
		query.append("                       WHERE LNK_DEST_NOD_CD = ${key_dest.get($key)}" ).append("\n"); 
		query.append("                       AND   A.ROUT_ORG_NOD_CD = C.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                       AND   A.ROUT_DEST_NOD_CD = C.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                       AND   A.ROUT_SEQ = C.ROUT_SEQ" ).append("\n"); 
		query.append("                       AND   TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("                      ) D" ).append("\n"); 
		query.append("                  WHERE A.ROUT_ORG_NOD_CD LIKE ${key_org.get($key)}||'%'" ).append("\n"); 
		query.append("                  AND   A.ROUT_DEST_NOD_CD LIKE ${key_dest.get($key)}||'%'" ).append("\n"); 
		query.append("                  AND   A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                  AND   A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                  AND   A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("                  AND   B.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                  AND   B.TRSP_AGMT_SEQ =AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                  AND   NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                  AND   A.PCTL_IO_BND_CD = 'M'" ).append("\n"); 
		query.append("                  AND   B.TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("                  AND   B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("                  AND   B.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                  AND   B.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                  AND   B.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("                  AND   B.ROUT_DTL_SEQ >= D.MIN_SEQ" ).append("\n"); 
		query.append("                  AND   B.ROUT_DTL_SEQ <= D.MAX_SEQ" ).append("\n"); 
		query.append("                  AND   A.ROUT_ORG_NOD_CD = ORG.NOD_CD" ).append("\n"); 
		query.append("                  AND   A.ROUT_DEST_NOD_CD = DEST.NOD_CD" ).append("\n"); 
		query.append("                  AND   ORG.NOD_CD <> 'Z'" ).append("\n"); 
		query.append("                  AND   DEST.NOD_CD <> 'Z'" ).append("\n"); 
		query.append("                  GROUP BY A.PRIO_SEQ, A.INLND_ROUT_RMK, A.ROUT_PLN_CD, A.ROUT_SEQ, B.TRSP_MOD_CD, A.ROUT_ORG_NOD_CD, A.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("       #if($velocityCount == 1)" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                  ${rout_seq.get($key)} KEY_SEQ," ).append("\n"); 
		query.append("                  RANK() OVER (ORDER BY ROUT_SEQ) ALT_SUB_SEQ ," ).append("\n"); 
		query.append("                  PRIO_SEQ," ).append("\n"); 
		query.append("                  INLND_ROUT_RMK," ).append("\n"); 
		query.append("                  ROUT_PLN_CD," ).append("\n"); 
		query.append("                  ROUT_SEQ," ).append("\n"); 
		query.append("                  ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                  ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                  RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("                  SUBSTR( REF_NO, 1, LENGTH(REF_NO)-2 ) REF_NO," ).append("\n"); 
		query.append("                  IRG1 || IRG2 || IRG3 || IRG4 || IRG5 || IRG6 || IRG7 || IRG8 IRG ," ).append("\n"); 
		query.append("                  FM_NOD ," ).append("\n"); 
		query.append("                  TO_NOD ," ).append("\n"); 
		query.append("                  IC_1 ," ).append("\n"); 
		query.append("                  IC_2 ," ).append("\n"); 
		query.append("                  CASE WHEN TRSP_MOD LIKE '%RD%TD%RD%' THEN 'RTR' WHEN TRSP_MOD NOT LIKE '%RD%' THEN 'NRD' ELSE '' END RTR" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                  SELECT" ).append("\n"); 
		query.append("                        A.PRIO_SEQ," ).append("\n"); 
		query.append("                        A.INLND_ROUT_RMK INLND_ROUT_RMK," ).append("\n"); 
		query.append("                        A.ROUT_PLN_CD ROUT_PLN_CD," ).append("\n"); 
		query.append("                        A.ROUT_SEQ," ).append("\n"); 
		query.append("                        A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                        A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                        '' IRG," ).append("\n"); 
		query.append("                        MAX(A. INLND_ROUT_INV_BIL_PATT_CD) RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 1, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 2, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 3, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 4, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 5, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 6, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 7, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 8, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) REF_NO," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 1, B.LNK_ORG_NOD_CD||'-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG1," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 2, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG2," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 3, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG3," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 4, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG4," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 5, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG5," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 6, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG6," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 7, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG7," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 8, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG8 ," ).append("\n"); 
		query.append("                        SUBSTR(MIN( DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_ORG_NOD_CD ) ) , 3) FM_NOD ," ).append("\n"); 
		query.append("                        SUBSTR(MAX( DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_DEST_NOD_CD) ), 3) TO_NOD ," ).append("\n"); 
		query.append("                        SUBSTR(MIN( DECODE( SUBSTR(A.INLND_ROUT_INV_BIL_PATT_CD , 2, 1) , 1, '' , DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_DEST_NOD_CD)) ), 3) IC_1 ," ).append("\n"); 
		query.append("                        SUBSTR(MAX( DECODE( SUBSTR(A.INLND_ROUT_INV_BIL_PATT_CD , 2, 1) , 1, '' , 2, '', DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_ORG_NOD_CD)) ), 3) IC_2 ," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 1, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 2, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 3, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 4, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 5, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 6, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 7, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 8, B.TRSP_MOD_CD)) TRSP_MOD" ).append("\n"); 
		query.append("                  FROM" ).append("\n"); 
		query.append("                        PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("                        PRD_INLND_ROUT_DTL B," ).append("\n"); 
		query.append("                        MDM_VENDOR C ," ).append("\n"); 
		query.append("                        PRD_NODE N ," ).append("\n"); 
		query.append("                        TRS_AGMT_HDR AGMT" ).append("\n"); 
		query.append("                  WHERE A.ROUT_ORG_NOD_CD LIKE" ).append("\n"); 
		query.append("                  #if($trsp_bnd_cd.get($key) == \"'I'\") " ).append("\n"); 
		query.append("                        ${key_org.get($key)}||'%'" ).append("\n"); 
		query.append("                  #else" ).append("\n"); 
		query.append("                        SUBSTR(${key_org.get($key)}, 0, 5)||'%'" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  AND   A.ROUT_DEST_NOD_CD LIKE" ).append("\n"); 
		query.append("                  #if($trsp_bnd_cd.get($key) == \"'O'\") " ).append("\n"); 
		query.append("                        ${key_dest.get($key)}||'%'" ).append("\n"); 
		query.append("                  #else" ).append("\n"); 
		query.append("                        SUBSTR(${key_dest.get($key)}, 0, 5)||'%'" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  AND   A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                  AND   A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                  AND   A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("                  AND   B.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                  AND   B.TRSP_AGMT_SEQ =AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                  AND   NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                  AND   A.PCTL_IO_BND_CD <> 'M'" ).append("\n"); 
		query.append("                  AND   B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("                  AND   DECODE( ${trsp_bnd_cd.get($key)} , 'O', A.ROUT_ORG_NOD_CD , A.ROUT_DEST_NOD_CD ) = N.NOD_CD" ).append("\n"); 
		query.append("                  #if($bkg_rcvde_term_cd.get($key) == \"'DOOR'\")" ).append("\n"); 
		query.append("                  AND   N.NOD_TP_CD = 'Z'" ).append("\n"); 
		query.append("                  #else" ).append("\n"); 
		query.append("                  AND   N.NOD_TP_CD <> 'Z'" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  GROUP BY A.PRIO_SEQ, A.INLND_ROUT_RMK, A.ROUT_PLN_CD, A.ROUT_SEQ, A.ROUT_ORG_NOD_CD, A.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            UNION" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                  ${rout_seq.get($key)} KEY_SEQ," ).append("\n"); 
		query.append("                  RANK() OVER (ORDER BY ROUT_SEQ) ALT_SUB_SEQ ," ).append("\n"); 
		query.append("                  PRIO_SEQ," ).append("\n"); 
		query.append("                  INLND_ROUT_RMK," ).append("\n"); 
		query.append("                  ROUT_PLN_CD," ).append("\n"); 
		query.append("                  ROUT_SEQ," ).append("\n"); 
		query.append("                  ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                  ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                  RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("                  SUBSTR( REF_NO, 1, LENGTH(REF_NO)-2 ) REF_NO," ).append("\n"); 
		query.append("                  IRG1 || IRG2 || IRG3 || IRG4 || IRG5 || IRG6 || IRG7 || IRG8 IRG ," ).append("\n"); 
		query.append("                  FM_NOD ," ).append("\n"); 
		query.append("                  TO_NOD ," ).append("\n"); 
		query.append("                  IC_1 ," ).append("\n"); 
		query.append("                  IC_2 ," ).append("\n"); 
		query.append("                  CASE WHEN TRSP_MOD LIKE '%RD%TD%RD%' THEN 'RTR' WHEN TRSP_MOD NOT LIKE '%RD%' THEN 'NRD' ELSE '' END RTR" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                  SELECT" ).append("\n"); 
		query.append("                        A.PRIO_SEQ," ).append("\n"); 
		query.append("                        A.INLND_ROUT_RMK INLND_ROUT_RMK," ).append("\n"); 
		query.append("                        A.ROUT_PLN_CD ROUT_PLN_CD," ).append("\n"); 
		query.append("                        A.ROUT_SEQ," ).append("\n"); 
		query.append("                        A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                        A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                        '' IRG," ).append("\n"); 
		query.append("                        MAX(A. INLND_ROUT_INV_BIL_PATT_CD) RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 1, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 2, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 3, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 4, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 5, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 6, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 7, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) ||" ).append("\n"); 
		query.append("                        MAX( DECODE( B.TRSP_MOD_CD, 'RD', DECODE( B.ROUT_DTL_SEQ, 8, NVL( AGMT.AGMT_REF_NO, 'N/A')||' / ' ) ) ) REF_NO," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 1, B.LNK_ORG_NOD_CD||'-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG1," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 2, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG2," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 3, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG3," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 4, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG4," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 5, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG5," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 6, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG6," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 7, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG7," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 8, '-('||B.TRSP_MOD_CD||'/'||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD)) IRG8 ," ).append("\n"); 
		query.append("                        SUBSTR(MIN( DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_ORG_NOD_CD ) ) , 3) FM_NOD ," ).append("\n"); 
		query.append("                        SUBSTR(MAX( DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_DEST_NOD_CD) ), 3) TO_NOD ," ).append("\n"); 
		query.append("                        SUBSTR(MIN( DECODE( SUBSTR(A.INLND_ROUT_INV_BIL_PATT_CD , 2, 1) , 1, '' , DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_DEST_NOD_CD)) ), 3) IC_1 ," ).append("\n"); 
		query.append("                        SUBSTR(MAX( DECODE( SUBSTR(A.INLND_ROUT_INV_BIL_PATT_CD , 2, 1) , 1, '' , 2, '', DECODE( B.TRSP_MOD_CD, 'RD', LPAD(B.ROUT_DTL_SEQ, 2 ) ||B.LNK_ORG_NOD_CD)) ), 3) IC_2 ," ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 1, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 2, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 3, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 4, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 5, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 6, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 7, B.TRSP_MOD_CD))||" ).append("\n"); 
		query.append("                        MAX(DECODE(B.ROUT_DTL_SEQ, 8, B.TRSP_MOD_CD)) TRSP_MOD" ).append("\n"); 
		query.append("                  FROM" ).append("\n"); 
		query.append("                        PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("                        PRD_INLND_ROUT_DTL B," ).append("\n"); 
		query.append("                        MDM_VENDOR C ," ).append("\n"); 
		query.append("                        PRD_NODE N ," ).append("\n"); 
		query.append("                        TRS_AGMT_HDR AGMT                " ).append("\n"); 
		query.append("                  WHERE A.ROUT_ORG_NOD_CD LIKE" ).append("\n"); 
		query.append("                  #if($trsp_bnd_cd.get($key) == \"'I'\") " ).append("\n"); 
		query.append("                        ${key_org.get($key)}||'%'" ).append("\n"); 
		query.append("                  #else" ).append("\n"); 
		query.append("                        SUBSTR(${key_org.get($key)}, 0, 5)||'%'" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  AND   A.ROUT_DEST_NOD_CD LIKE " ).append("\n"); 
		query.append("                  #if($trsp_bnd_cd.get($key) == \"'O'\") " ).append("\n"); 
		query.append("                        ${key_dest.get($key)}||'%'" ).append("\n"); 
		query.append("                  #else" ).append("\n"); 
		query.append("                        SUBSTR(${key_dest.get($key)}, 0, 5)||'%'" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  AND   A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                  AND   A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                  AND   A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("                  AND   B.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                  AND   B.TRSP_AGMT_SEQ =AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                  AND   NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                  AND   A.PCTL_IO_BND_CD <> 'M'" ).append("\n"); 
		query.append("                  AND   B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("                  AND   DECODE( ${trsp_bnd_cd.get($key)} , 'O', A.ROUT_ORG_NOD_CD , A.ROUT_DEST_NOD_CD ) = N.NOD_CD" ).append("\n"); 
		query.append("                  #if($bkg_rcvde_term_cd.get($key) == \"'DOOR'\")" ).append("\n"); 
		query.append("                  AND   N.NOD_TP_CD = 'Z'" ).append("\n"); 
		query.append("                  #else" ).append("\n"); 
		query.append("                  AND   N.NOD_TP_CD <> 'Z'" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                GROUP BY A.PRIO_SEQ, A.INLND_ROUT_RMK, A.ROUT_PLN_CD, A.ROUT_SEQ, A.ROUT_ORG_NOD_CD, A.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}