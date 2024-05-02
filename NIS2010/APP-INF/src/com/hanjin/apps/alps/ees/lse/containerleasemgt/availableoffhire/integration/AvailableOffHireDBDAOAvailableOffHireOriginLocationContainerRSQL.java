/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AvailableOffHireDBDAOAvailableOffHireOriginLocationContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOAvailableOffHireOriginLocationContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 지역별 지정된 반납대상 장비의 내역을 조회합니다.
	  * </pre>
	  */
	public AvailableOffHireDBDAOAvailableOffHireOriginLocationContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_estm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_estm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOAvailableOffHireOriginLocationContainerRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO ," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("  LSTM_CD ," ).append("\n"); 
		query.append("  AGMT_NO ," ).append("\n"); 
		query.append("  REF_NO," ).append("\n"); 
		query.append("  VNDR_ABBR_NM ," ).append("\n"); 
		query.append("  VNDR_SEQ ," ).append("\n"); 
		query.append("  CRNT_YD_CD ," ).append("\n"); 
		query.append("  CNMV_STS_CD ," ).append("\n"); 
		query.append("  FULL_FLG ," ).append("\n"); 
		query.append("  CNMV_DT ," ).append("\n"); 
		query.append("  BKG_NO," ).append("\n"); 
		query.append("  LCC_CD," ).append("\n"); 
		query.append("  POR_CD," ).append("\n"); 
		query.append("  POL_CD," ).append("\n"); 
		query.append("  POD_CD," ).append("\n"); 
		query.append("  DEL_CD," ).append("\n"); 
		query.append("  DE_TERM," ).append("\n"); 
		query.append("  DEL_SCC," ).append("\n"); 
		query.append("  MT_RTN_YD," ).append("\n"); 
		query.append("  MT_RTN_SCC," ).append("\n"); 
		query.append("  MAX(DEL_DOL) DEL_DOL," ).append("\n"); 
		query.append("  MAX(MT_RTN_DOL) MT_RTN_DOL," ).append("\n"); 
		query.append("  MAX(CURR_YD_DOL) CURR_YD_DOL," ).append("\n"); 
		query.append("  MAX(SUBSTR(SO_STR, 1, INSTR(SO_STR, '+', 1, 1) - 1)) AS SO_NO" ).append("\n"); 
		query.append("  ,MAX(SUBSTR(SO_STR, INSTR(SO_STR, '+', 1, 1) + 1, INSTR(SO_STR, '+', 1, 2) - INSTR(SO_STR, '+', 1, 1) - 1)) AS WO_NO" ).append("\n"); 
		query.append("  ,MAX(SUBSTR(SO_STR, INSTR(SO_STR, '+', 1, 2) + 1, INSTR(SO_STR, '+', 1, 3) - INSTR(SO_STR, '+', 1, 2) - 1)) AS VNDR_TP" ).append("\n"); 
		query.append("  ,MAX(SUBSTR(SUBSTR(SO_STR, INSTR(SO_STR, '+', 1, 3) + 1), 1, INSTR(SUBSTR(SO_STR, INSTR(SO_STR, '+', 1, 3) + 1), '$', 1, 1) - 1 )) AS VNDR_CD" ).append("\n"); 
		query.append("  ,MAX(SUBSTR(SUBSTR(SO_STR, INSTR(SO_STR, '+', 1, 3) + 1), INSTR(SUBSTR(SO_STR, INSTR(SO_STR, '+', 1, 3) + 1), '$', 1, 1) + 1, " ).append("\n"); 
		query.append("     INSTR(SUBSTR(SO_STR, INSTR(SO_STR, '+', 1, 3) + 1), '$', 1, 2) - INSTR(SUBSTR(SO_STR, INSTR(SO_STR, '+', 1, 3) + 1), '$', 1, 1) - 1)) AS VNDR_NM" ).append("\n"); 
		query.append("  ,POL_ETD," ).append("\n"); 
		query.append("  POD_ETA," ).append("\n"); 
		query.append("  VVD AS VVD_CD" ).append("\n"); 
		query.append("#foreach( $key in ${scc_list_seq}) " ).append("\n"); 
		query.append("  ,MAX(DECODE(DOL, '$key', DOL, '')) DOL$velocityCount" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT CNTR_NO ," ).append("\n"); 
		query.append("      T01.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("      LSTM_CD ," ).append("\n"); 
		query.append("      AGMT_NO ," ).append("\n"); 
		query.append("      REF_NO," ).append("\n"); 
		query.append("      VNDR_ABBR_NM ," ).append("\n"); 
		query.append("      VNDR_SEQ," ).append("\n"); 
		query.append("      CRNT_YD_CD ," ).append("\n"); 
		query.append("      CNMV_STS_CD ," ).append("\n"); 
		query.append("      FULL_FLG ," ).append("\n"); 
		query.append("      CNMV_DT ," ).append("\n"); 
		query.append("      BKG_NO," ).append("\n"); 
		query.append("      LCC_CD," ).append("\n"); 
		query.append("      POR_CD," ).append("\n"); 
		query.append("      POL_CD," ).append("\n"); 
		query.append("      POD_CD," ).append("\n"); 
		query.append("      DEL_CD," ).append("\n"); 
		query.append("      DE_TERM," ).append("\n"); 
		query.append("      MST_LOC_FNC(DEL_CD,'SCC') DEL_SCC" ).append("\n"); 
		query.append("      ,MT_RTN_YD" ).append("\n"); 
		query.append("      ,MST_LOC_FNC(MT_RTN_YD,'SCC') MT_RTN_SCC" ).append("\n"); 
		query.append("      ,DECODE(T02.LOC_CD,MST_LOC_FNC(DEL_CD,'SCC'),'Y','') DEL_DOL" ).append("\n"); 
		query.append("      ,DECODE(T02.LOC_CD,MST_LOC_FNC(MT_RTN_YD,'SCC'),'Y','') MT_RTN_DOL" ).append("\n"); 
		query.append("      ,DECODE(FULL_FLG,'F',' ',DECODE(T02.LOC_CD,MST_LOC_FNC(CRNT_YD_CD,'SCC'),'Y','')) CURR_YD_DOL," ).append("\n"); 
		query.append("      POL_ETD," ).append("\n"); 
		query.append("      POD_ETA," ).append("\n"); 
		query.append("      VVD," ).append("\n"); 
		query.append("      ROW_NUMBER() OVER (PARTITION BY CNTR_NO , T01.CNTR_TPSZ_CD , LSTM_CD , AGMT_NO , REF_NO, VNDR_ABBR_NM , CRNT_YD_CD , CNMV_STS_CD , FULL_FLG , CNMV_DT , BKG_NO, LCC_CD, POR_CD, POL_CD, POD_CD, DEL_CD, MT_RTN_YD, POL_ETD, POD_ETA, VVD" ).append("\n"); 
		query.append("        ORDER BY ROWNUM asc ) rumm ," ).append("\n"); 
		query.append("      T02.LOC_CD DOL," ).append("\n"); 
		query.append("      T02.AGMT_CHG_VAL," ).append("\n"); 
		query.append("--     S/O Data Get 20160201" ).append("\n"); 
		query.append("      DECODE(FULL_FLG,'F',(SELECT (SO.TRSP_SO_OFC_CTY_CD || SO.TRSP_SO_SEQ) || '+' || --AS SO_NO" ).append("\n"); 
		query.append("              (WO.TRSP_WO_OFC_CTY_CD || WO.TRSP_WO_SEQ) || '+' || -- AS WO_NO" ).append("\n"); 
		query.append("              DECODE (SO.CUST_NOMI_TRKR_FLG,'Y', 'CNT','SML') || '+' || --AS VNDR_TP_CD" ).append("\n"); 
		query.append("              (SELECT IVDR.VNDR_SEQ ||'$'|| NVL(IVDR.VNDR_ABBR_NM, ' ') ||'$'||" ).append("\n"); 
		query.append("                        (SELECT PVNDR.VNDR_SEQ ||'$'|| NVL(PVNDR.VNDR_ABBR_NM, ' ')" ).append("\n"); 
		query.append("                          FROM MDM_VENDOR PVNDR" ).append("\n"); 
		query.append("                          WHERE PVNDR.VNDR_SEQ = IVDR.PRNT_VNDR_SEQ )" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR IVDR" ).append("\n"); 
		query.append("                  WHERE IVDR.VNDR_SEQ = CASE WHEN SO.HJL_NO IS NOT NULL " ).append("\n"); 
		query.append("                                             THEN (SELECT HJL_VNDR_SEQ FROM TRS_TRSP_HJL_SVC_ORD " ).append("\n"); 
		query.append("                                                   WHERE TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD AND TRSP_SO_SEQ = SO.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("                                             ELSE SO.VNDR_SEQ" ).append("\n"); 
		query.append("                                        END ) -- AS INV_VNDR_INFO" ).append("\n"); 
		query.append("            FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                ,TRS_TRSP_WRK_ORD WO" ).append("\n"); 
		query.append("           WHERE SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("             AND SO.TRSP_WO_SEQ = WO.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("             AND so.BKG_NO = T01.BKG_NO" ).append("\n"); 
		query.append("             AND so.EQ_NO = T01.CNTR_NO" ).append("\n"); 
		query.append("             AND SO.EQ_KND_CD = 'U'              " ).append("\n"); 
		query.append("             AND SO.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("        ),'') SO_STR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("   SELECT A.CNTR_NO ," ).append("\n"); 
		query.append("          A.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("          A.LSTM_CD ," ).append("\n"); 
		query.append("          A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6, '0') AGMT_NO ," ).append("\n"); 
		query.append("          C.REF_NO," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT X.VNDR_ABBR_NM" ).append("\n"); 
		query.append("            FROM MDM_VENDOR X" ).append("\n"); 
		query.append("            WHERE A.VNDR_SEQ = X.VNDR_SEQ) VNDR_ABBR_NM ," ).append("\n"); 
		query.append("          A.VNDR_SEQ," ).append("\n"); 
		query.append("          A.CRNT_YD_CD ," ).append("\n"); 
		query.append("          A.CNMV_STS_CD ," ).append("\n"); 
		query.append("          DECODE(A.FULL_FLG, 'Y', 'F', 'M') FULL_FLG ," ).append("\n"); 
		query.append("          TO_CHAR(A.CNMV_DT, 'YYYY-MM-DD') CNMV_DT ," ).append("\n"); 
		query.append("          A.BKG_NO," ).append("\n"); 
		query.append("          A.LCC_CD," ).append("\n"); 
		query.append("          B.POR_CD," ).append("\n"); 
		query.append("          B.POL_CD," ).append("\n"); 
		query.append("          B.POD_CD," ).append("\n"); 
		query.append("          B.DEL_CD," ).append("\n"); 
		query.append("          B.DE_TERM_CD DE_TERM," ).append("\n"); 
		query.append("          B.MTY_RTN_YD_CD MT_RTN_YD," ).append("\n"); 
		query.append("          D.VPS_ETD_DT POL_ETD," ).append("\n"); 
		query.append("          D.VPS_ETA_DT POD_ETA," ).append("\n"); 
		query.append("          A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        FROM MST_CONTAINER A," ).append("\n"); 
		query.append("          BKG_BOOKING B," ).append("\n"); 
		query.append("          LSE_AGREEMENT C," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD D" ).append("\n"); 
		query.append("        WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("          AND A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("          AND A.CNTR_USE_CO_CD = 'H'" ).append("\n"); 
		query.append("          AND A.SCC_CD IN (" ).append("\n"); 
		query.append("            SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("            WHERE DECODE(@[loc_tp],'2',SCC_CD, '1',LCC_CD, '0',RCC_CD) = @[loc_cd]" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("          --AND A.SCC_CD ='KRPUS'" ).append("\n"); 
		query.append("          AND A.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("          AND A.VSL_CD = D.VSL_CD(+)" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND A.SCC_CD = D.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("          AND A.FULL_FLG ='N'   -- CONTAINER MT" ).append("\n"); 
		query.append("          AND DECODE(A.LSTM_CD, 'ST', A.ONH_DT + NVL(A.MIN_ONH_DYS,0),  A.ONH_DT ) < SYSDATE" ).append("\n"); 
		query.append("         -- AND DECODE(A.LSTM_CD, 'LT', C.LST_EXP_DT                    , SYSDATE - 1) < SYSDATE" ).append("\n"); 
		query.append("          AND DECODE(A.LSTM_CD, 'LT', DECODE(NVL(A.MIN_ONH_DYS,0), 0, C.LST_EXP_DT, A.ONH_DT + NVL(A.MIN_ONH_DYS,0)),SYSDATE -1) < SYSDATE" ).append("\n"); 
		query.append("          AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("              'CD' ," ).append("\n"); 
		query.append("              'CE' ," ).append("\n"); 
		query.append("              'CI' ," ).append("\n"); 
		query.append("              'CM' ," ).append("\n"); 
		query.append("              'CO' ," ).append("\n"); 
		query.append("              'CP' ," ).append("\n"); 
		query.append("              'CT' ," ).append("\n"); 
		query.append("              'CX' ," ).append("\n"); 
		query.append("              'EN' ," ).append("\n"); 
		query.append("              'MT' ," ).append("\n"); 
		query.append("              'OP' ," ).append("\n"); 
		query.append("              'TN' ," ).append("\n"); 
		query.append("              'IC'," ).append("\n"); 
		query.append("              'ID'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           AND   A.BKG_NO IS NULL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT A.CNTR_NO ," ).append("\n"); 
		query.append("          A.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("          A.LSTM_CD ," ).append("\n"); 
		query.append("          A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6, '0') AGMT_NO ," ).append("\n"); 
		query.append("          C.REF_NO," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT X.VNDR_ABBR_NM" ).append("\n"); 
		query.append("            FROM MDM_VENDOR X" ).append("\n"); 
		query.append("            WHERE A.VNDR_SEQ = X.VNDR_SEQ) VNDR_ABBR_NM ," ).append("\n"); 
		query.append("          A.VNDR_SEQ," ).append("\n"); 
		query.append("          A.CRNT_YD_CD ," ).append("\n"); 
		query.append("          A.CNMV_STS_CD ," ).append("\n"); 
		query.append("          DECODE(A.FULL_FLG, 'Y', 'F', 'M') FULL_FLG ," ).append("\n"); 
		query.append("          TO_CHAR(A.CNMV_DT, 'YYYY-MM-DD') CNMV_DT ," ).append("\n"); 
		query.append("          A.BKG_NO," ).append("\n"); 
		query.append("          A.LCC_CD," ).append("\n"); 
		query.append("          B.POR_CD," ).append("\n"); 
		query.append("          B.POL_CD," ).append("\n"); 
		query.append("          B.POD_CD," ).append("\n"); 
		query.append("          B.DEL_CD," ).append("\n"); 
		query.append("          B.DE_TERM_CD DE_TERM," ).append("\n"); 
		query.append("      --    B.MTY_RTN_YD_CD MT_RTN_YD," ).append("\n"); 
		query.append("          (SELECT NOD_CD FROM SCE_COP_HDR CH, SCE_COP_DTL CD" ).append("\n"); 
		query.append("            WHERE COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("              AND CH.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("              AND A.CNTR_NO = CH.CNTR_NO" ).append("\n"); 
		query.append("              AND CH.COP_NO = CD.COP_NO" ).append("\n"); 
		query.append("              AND CD.ACT_CD = 'MITYAD') MT_RTN_YD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          D.VPS_ETD_DT POL_ETD," ).append("\n"); 
		query.append("          D.VPS_ETA_DT POD_ETA," ).append("\n"); 
		query.append("          A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        FROM MST_CONTAINER A," ).append("\n"); 
		query.append("          BKG_BOOKING B," ).append("\n"); 
		query.append("          LSE_AGREEMENT C," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD D" ).append("\n"); 
		query.append("        WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("          AND A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("          AND A.CNTR_USE_CO_CD = 'H'" ).append("\n"); 
		query.append("          AND A.SCC_CD IN (" ).append("\n"); 
		query.append("            SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("            WHERE DECODE(@[loc_tp],'2',SCC_CD,'1',LCC_CD,'0',RCC_CD) = @[loc_cd]" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("          --AND A.SCC_CD ='KRPUS'" ).append("\n"); 
		query.append("          AND A.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("          AND A.VSL_CD = D.VSL_CD(+)" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND A.SCC_CD = D.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("          AND A.FULL_FLG ='N'   -- CONTAINER MT" ).append("\n"); 
		query.append("          AND DECODE(A.LSTM_CD, 'ST', A.ONH_DT + NVL(A.MIN_ONH_DYS,0),  A.ONH_DT ) < SYSDATE" ).append("\n"); 
		query.append("         -- AND DECODE(A.LSTM_CD, 'LT', C.LST_EXP_DT                    , SYSDATE - 1) < SYSDATE" ).append("\n"); 
		query.append("          AND DECODE(A.LSTM_CD, 'LT', DECODE(NVL(A.MIN_ONH_DYS,0), 0, C.LST_EXP_DT, A.ONH_DT + NVL(A.MIN_ONH_DYS,0)),SYSDATE -1) < SYSDATE" ).append("\n"); 
		query.append("          AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("              'CD' ," ).append("\n"); 
		query.append("              'CE' ," ).append("\n"); 
		query.append("              'CI' ," ).append("\n"); 
		query.append("              'CM' ," ).append("\n"); 
		query.append("              'CO' ," ).append("\n"); 
		query.append("              'CP' ," ).append("\n"); 
		query.append("              'CT' ," ).append("\n"); 
		query.append("              'CX' ," ).append("\n"); 
		query.append("              'EN' ," ).append("\n"); 
		query.append("              'MT' ," ).append("\n"); 
		query.append("              'OP' ," ).append("\n"); 
		query.append("              'TN' ," ).append("\n"); 
		query.append("              'IC'," ).append("\n"); 
		query.append("              'ID'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           AND   A.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND   B.DEL_CD     IN (      " ).append("\n"); 
		query.append("            SELECT LOC_CD" ).append("\n"); 
		query.append("            FROM  MDM_LOCATION" ).append("\n"); 
		query.append("            WHERE SCC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                             WHERE DECODE(@[loc_tp],'2',SCC_CD, '1',LCC_CD, '0',RCC_CD) = @[loc_cd]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL  -- ADD START" ).append("\n"); 
		query.append("        SELECT A.CNTR_NO ," ).append("\n"); 
		query.append("          A.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("          A.LSTM_CD ," ).append("\n"); 
		query.append("          A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6, '0') AGMT_NO ," ).append("\n"); 
		query.append("          C.REF_NO," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT X.VNDR_ABBR_NM" ).append("\n"); 
		query.append("            FROM MDM_VENDOR X" ).append("\n"); 
		query.append("            WHERE A.VNDR_SEQ = X.VNDR_SEQ) VNDR_ABBR_NM ," ).append("\n"); 
		query.append("          A.VNDR_SEQ," ).append("\n"); 
		query.append("          A.CRNT_YD_CD ," ).append("\n"); 
		query.append("          A.CNMV_STS_CD ," ).append("\n"); 
		query.append("          DECODE(A.FULL_FLG, 'Y', 'F', 'M') FULL_FLG ," ).append("\n"); 
		query.append("          TO_CHAR(A.CNMV_DT, 'YYYY-MM-DD') CNMV_DT ," ).append("\n"); 
		query.append("          A.BKG_NO," ).append("\n"); 
		query.append("          A.LCC_CD," ).append("\n"); 
		query.append("          B.POR_CD," ).append("\n"); 
		query.append("          B.POL_CD," ).append("\n"); 
		query.append("          B.POD_CD," ).append("\n"); 
		query.append("          B.DEL_CD," ).append("\n"); 
		query.append("          B.DE_TERM_CD DE_TERM," ).append("\n"); 
		query.append("          (SELECT NOD_CD FROM SCE_COP_HDR CH, SCE_COP_DTL CD" ).append("\n"); 
		query.append("            WHERE COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("              AND CH.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("              AND A.CNTR_NO = CH.CNTR_NO" ).append("\n"); 
		query.append("              AND CH.COP_NO = CD.COP_NO" ).append("\n"); 
		query.append("              AND CD.ACT_CD = 'MITYAD') MT_RTN_YD," ).append("\n"); 
		query.append("          D.VPS_ETD_DT POL_ETD," ).append("\n"); 
		query.append("          D.VPS_ETA_DT POD_ETA," ).append("\n"); 
		query.append("          A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        FROM MST_CONTAINER A," ).append("\n"); 
		query.append("          BKG_BOOKING B," ).append("\n"); 
		query.append("          LSE_AGREEMENT C," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD D" ).append("\n"); 
		query.append("        WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("          AND A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("          AND A.CNTR_USE_CO_CD = 'H'" ).append("\n"); 
		query.append("          AND A.SCC_CD IN (" ).append("\n"); 
		query.append("              MST_LOC_FNC((SELECT substr(NOD_CD,1,5)" ).append("\n"); 
		query.append("              FROM SCE_COP_HDR H, SCE_COP_DTL DT" ).append("\n"); 
		query.append("              WHERE COP_STS_CD <> 'X' " ).append("\n"); 
		query.append("               AND H.BKG_NO = b.BKG_NO" ).append("\n"); 
		query.append("               AND a.CNTR_NO = H.CNTR_NO " ).append("\n"); 
		query.append("               AND H.COP_NO = DT.COP_NO" ).append("\n"); 
		query.append("               AND DT.ACT_CD = 'MITYAD' --'FITZAD'" ).append("\n"); 
		query.append("               AND EXISTS (SELECT 1 FROM SCE_COP_HDR H1, SCE_COP_DTL DT1" ).append("\n"); 
		query.append("                               WHERE COP_STS_CD <> 'X' " ).append("\n"); 
		query.append("                                 AND H1.BKG_NO = b.BKG_NO" ).append("\n"); 
		query.append("                                 AND a.CNTR_NO = H1.CNTR_NO " ).append("\n"); 
		query.append("                                 AND H1.COP_NO = DT1.COP_NO" ).append("\n"); 
		query.append("                                 AND dt1.act_cd = 'FITZAD'))" ).append("\n"); 
		query.append("             ,'SCC')            " ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("          --AND A.SCC_CD ='KRPUS'" ).append("\n"); 
		query.append("          AND A.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("          AND A.VSL_CD = D.VSL_CD(+)" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND A.SCC_CD = D.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("          AND A.FULL_FLG ='N'   -- CONTAINER MT" ).append("\n"); 
		query.append("          AND DECODE(A.LSTM_CD, 'ST', A.ONH_DT + NVL(A.MIN_ONH_DYS,0),  A.ONH_DT ) < SYSDATE" ).append("\n"); 
		query.append("        --  AND DECODE(A.LSTM_CD, 'LT', C.LST_EXP_DT                    , SYSDATE - 1) < SYSDATE" ).append("\n"); 
		query.append("          AND DECODE(A.LSTM_CD, 'LT', DECODE(NVL(A.MIN_ONH_DYS,0), 0, C.LST_EXP_DT, A.ONH_DT + NVL(A.MIN_ONH_DYS,0)),SYSDATE -1) < SYSDATE" ).append("\n"); 
		query.append("          AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("              'CD' ," ).append("\n"); 
		query.append("              'CE' ," ).append("\n"); 
		query.append("              'CI' ," ).append("\n"); 
		query.append("              'CM' ," ).append("\n"); 
		query.append("              'CO' ," ).append("\n"); 
		query.append("              'CP' ," ).append("\n"); 
		query.append("              'CT' ," ).append("\n"); 
		query.append("              'CX' ," ).append("\n"); 
		query.append("              'EN' ," ).append("\n"); 
		query.append("              'MT' ," ).append("\n"); 
		query.append("              'OP' ," ).append("\n"); 
		query.append("              'TN' ," ).append("\n"); 
		query.append("              'IC'," ).append("\n"); 
		query.append("              'ID'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           AND   A.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND   (SELECT Substr(NOD_CD,1,5)" ).append("\n"); 
		query.append("              FROM SCE_COP_HDR H, SCE_COP_DTL DT" ).append("\n"); 
		query.append("              WHERE COP_STS_CD <> 'X' " ).append("\n"); 
		query.append("               AND H.BKG_NO = b.BKG_NO" ).append("\n"); 
		query.append("               AND a.CNTR_NO = H.CNTR_NO " ).append("\n"); 
		query.append("               AND H.COP_NO = DT.COP_NO" ).append("\n"); 
		query.append("               AND DT.ACT_CD = 'MITYAD' --'FITZAD'" ).append("\n"); 
		query.append("               AND EXISTS (SELECT 1 FROM SCE_COP_HDR H1, SCE_COP_DTL DT1" ).append("\n"); 
		query.append("                               WHERE COP_STS_CD <> 'X' " ).append("\n"); 
		query.append("                                 AND H1.BKG_NO = b.BKG_NO" ).append("\n"); 
		query.append("                                 AND a.CNTR_NO = H1.CNTR_NO " ).append("\n"); 
		query.append("                                 AND H1.COP_NO = DT1.COP_NO" ).append("\n"); 
		query.append("                                 AND dt1.act_cd = 'FITZAD')" ).append("\n"); 
		query.append("               ) IN (SELECT LOC_CD" ).append("\n"); 
		query.append("                   FROM  MDM_LOCATION" ).append("\n"); 
		query.append("                   WHERE SCC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                                    WHERE DECODE(@[loc_tp],'2',SCC_CD, '1',LCC_CD, '0',RCC_CD) = @[loc_cd])" ).append("\n"); 
		query.append("         ) -- ADD END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT A.CNTR_NO ," ).append("\n"); 
		query.append("          A.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("          A.LSTM_CD ," ).append("\n"); 
		query.append("          A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6, '0') AGMT_NO ," ).append("\n"); 
		query.append("          C.REF_NO," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT X.VNDR_ABBR_NM" ).append("\n"); 
		query.append("            FROM MDM_VENDOR X" ).append("\n"); 
		query.append("            WHERE A.VNDR_SEQ = X.VNDR_SEQ) VNDR_ABBR_NM ," ).append("\n"); 
		query.append("          A.VNDR_SEQ," ).append("\n"); 
		query.append("          A.CRNT_YD_CD ," ).append("\n"); 
		query.append("          A.CNMV_STS_CD ," ).append("\n"); 
		query.append("          DECODE(A.FULL_FLG, 'Y', 'F', 'M') FULL_FLG ," ).append("\n"); 
		query.append("          TO_CHAR(A.CNMV_DT, 'YYYY-MM-DD') CNMV_DT ," ).append("\n"); 
		query.append("          A.BKG_NO," ).append("\n"); 
		query.append("          Q.LCC_CD," ).append("\n"); 
		query.append("          B.POR_CD," ).append("\n"); 
		query.append("          B.POL_CD," ).append("\n"); 
		query.append("          B.POD_CD," ).append("\n"); 
		query.append("          B.DEL_CD," ).append("\n"); 
		query.append("          B.DE_TERM_CD DE_TERM," ).append("\n"); 
		query.append("          B.MTY_RTN_YD_CD MT_RTN_YD," ).append("\n"); 
		query.append("          D.VPS_ETD_DT POL_ETD," ).append("\n"); 
		query.append("          D.VPS_ETA_DT POD_ETA," ).append("\n"); 
		query.append("          A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        FROM MST_CONTAINER A," ).append("\n"); 
		query.append("          BKG_BOOKING B," ).append("\n"); 
		query.append("          LSE_AGREEMENT C," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD D," ).append("\n"); 
		query.append("          MDM_LOCATION M," ).append("\n"); 
		query.append("          MDM_EQ_ORZ_CHT Q" ).append("\n"); 
		query.append("        WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("          AND A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("          AND A.CNTR_USE_CO_CD = 'H'" ).append("\n"); 
		query.append("          AND B.DEL_CD = M.LOC_CD" ).append("\n"); 
		query.append("          AND M.SCC_CD = Q.SCC_CD" ).append("\n"); 
		query.append("          AND DECODE(@[loc_tp],'2',Q.SCC_CD, '1',Q.LCC_CD, '0',Q.RCC_CD) = @[loc_cd]" ).append("\n"); 
		query.append("          AND A.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("          AND A.VSL_CD = D.VSL_CD(+)" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND A.SCC_CD = D.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("          AND A.FULL_FLG ='Y'  -- CONTAINER FULL" ).append("\n"); 
		query.append("          AND DECODE(A.LSTM_CD, 'ST', A.ONH_DT + NVL(A.MIN_ONH_DYS,0),  A.ONH_DT ) < SYSDATE" ).append("\n"); 
		query.append("         -- AND DECODE(A.LSTM_CD, 'LT', C.LST_EXP_DT                    , SYSDATE - 1) < SYSDATE" ).append("\n"); 
		query.append("          AND DECODE(A.LSTM_CD, 'LT', DECODE(NVL(A.MIN_ONH_DYS,0), 0, C.LST_EXP_DT, A.ONH_DT + NVL(A.MIN_ONH_DYS,0)),SYSDATE -1) < SYSDATE" ).append("\n"); 
		query.append("          AND A.CNMV_STS_CD IN (                        " ).append("\n"); 
		query.append("              'CD' ," ).append("\n"); 
		query.append("              'CE' ," ).append("\n"); 
		query.append("              'CI' ," ).append("\n"); 
		query.append("              'CM' ," ).append("\n"); 
		query.append("              'CO' ," ).append("\n"); 
		query.append("              'CP' ," ).append("\n"); 
		query.append("              'CT' ," ).append("\n"); 
		query.append("              'CX' ," ).append("\n"); 
		query.append("              'EN' ," ).append("\n"); 
		query.append("              'MT' ," ).append("\n"); 
		query.append("              'OP' ," ).append("\n"); 
		query.append("              'TN' ," ).append("\n"); 
		query.append("              'IC'," ).append("\n"); 
		query.append("              'ID'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT A.CNTR_NO ," ).append("\n"); 
		query.append("          A.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("          A.LSTM_CD ," ).append("\n"); 
		query.append("          A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6, '0') AGMT_NO ," ).append("\n"); 
		query.append("          F.REF_NO," ).append("\n"); 
		query.append("          G.VNDR_ABBR_NM ," ).append("\n"); 
		query.append("          G.VNDR_SEQ," ).append("\n"); 
		query.append("          A.CRNT_YD_CD ," ).append("\n"); 
		query.append("          A.CNMV_STS_CD ," ).append("\n"); 
		query.append("          DECODE(A.FULL_FLG, 'Y', 'F', 'M') FULL_FLG ," ).append("\n"); 
		query.append("          TO_CHAR(A.CNMV_DT, 'YYYY-MM-DD') CNMV_DT ," ).append("\n"); 
		query.append("          MAX(B.BKG_NO) ," ).append("\n"); 
		query.append("          Q.LCC_CD," ).append("\n"); 
		query.append("          B.POR_CD," ).append("\n"); 
		query.append("          B.POL_CD," ).append("\n"); 
		query.append("          B.POD_CD," ).append("\n"); 
		query.append("          B.DEL_CD," ).append("\n"); 
		query.append("          B.DE_TERM_CD DE_TERM," ).append("\n"); 
		query.append("          B.MTY_RTN_YD_CD MT_RTN_YD," ).append("\n"); 
		query.append("          E.VPS_ETD_DT POL_ETD," ).append("\n"); 
		query.append("          E.VPS_ETA_DT POD_ETA," ).append("\n"); 
		query.append("          A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        FROM mst_container a," ).append("\n"); 
		query.append("          bkg_booking b," ).append("\n"); 
		query.append("          bkg_vvd c," ).append("\n"); 
		query.append("      --    bkg_container d," ).append("\n"); 
		query.append("          vsk_vsl_port_skd e," ).append("\n"); 
		query.append("          LSE_AGREEMENT F," ).append("\n"); 
		query.append("          MDM_VENDOR G," ).append("\n"); 
		query.append("          MDM_LOCATION M," ).append("\n"); 
		query.append("          MDM_EQ_ORZ_CHT Q" ).append("\n"); 
		query.append("        WHERE b.bkg_no = c.bkg_no" ).append("\n"); 
		query.append("          AND c.bkg_no = a.bkg_no" ).append("\n"); 
		query.append("          AND B.DEL_CD = M.LOC_CD" ).append("\n"); 
		query.append("          AND M.SCC_CD = Q.SCC_CD" ).append("\n"); 
		query.append("          AND DECODE(@[loc_tp],'2',Q.SCC_CD, '1',Q.LCC_CD, '0',Q.RCC_CD) = @[loc_cd]" ).append("\n"); 
		query.append("          AND b.bkg_sts_cd <> 'X'" ).append("\n"); 
		query.append("          AND c.vsl_cd = e.vsl_cd" ).append("\n"); 
		query.append("          AND c.skd_voy_no = e.skd_voy_no" ).append("\n"); 
		query.append("          AND c.skd_dir_cd = e.skd_dir_cd" ).append("\n"); 
		query.append("#if(${str_estm_dt} != '' && ${end_estm_dt} != '')" ).append("\n"); 
		query.append("          AND a.cnmv_DT BETWEEN TO_DATE(@[str_estm_dt],'YYYY-MM-DD') AND TO_DATE(@[end_estm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND a.cnmv_DT BETWEEN TRIM(SYSDATE) AND TRIM(SYSDATE+7)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND c.POD_cd = e.vps_port_cd" ).append("\n"); 
		query.append("          AND a.cnmv_sts_cd in ('VL','OC')" ).append("\n"); 
		query.append("        --  AND a.cntr_no = d.cntr_no" ).append("\n"); 
		query.append("          AND A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("          AND DECODE(A.LSTM_CD, 'ST', A.ONH_DT + NVL(A.MIN_ONH_DYS,0),  A.ONH_DT ) < SYSDATE" ).append("\n"); 
		query.append("         -- AND DECODE(A.LSTM_CD, 'LT', F.LST_EXP_DT                    , SYSDATE - 1) < SYSDATE" ).append("\n"); 
		query.append("          AND DECODE(A.LSTM_CD, 'LT', DECODE(NVL(A.MIN_ONH_DYS,0), 0, F.LST_EXP_DT, A.ONH_DT + NVL(A.MIN_ONH_DYS,0)),SYSDATE -1) < SYSDATE" ).append("\n"); 
		query.append("          AND c.POL_CLPT_IND_SEQ = e.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("          AND A.AGMT_CTY_CD = F.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND A.AGMT_SEQ = F.AGMT_SEQ" ).append("\n"); 
		query.append("          AND A.VNDR_SEQ = G.VNDR_SEQ" ).append("\n"); 
		query.append("        GROUP by A.CNTR_NO , A.CNTR_TPSZ_CD , A.LSTM_CD , A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6, '0') , F.REF_NO, G.VNDR_ABBR_NM, G.VNDR_SEQ, A.CRNT_YD_CD , A.CNMV_STS_CD , DECODE(A.FULL_FLG, 'Y', 'F', 'M') , TO_CHAR(A.CNMV_DT, 'YYYY-MM-DD'), Q.LCC_CD , B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD, B.DE_TERM_CD, B.MTY_RTN_YD_CD, E.VPS_ETD_DT , E.VPS_ETA_DT , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD ) T01 ," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT LSE_RT.LOC_CD," ).append("\n"); 
		query.append("          LPAD(LSE.AGMT_SEQ, 6, '0') AGMT_SEQ," ).append("\n"); 
		query.append("          LSE.AGMT_CTY_CD," ).append("\n"); 
		query.append("          LSE_RT.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("          LSE_RT.AGMT_CHG_VAL" ).append("\n"); 
		query.append("        FROM LSE_AGMT_RT LSE_RT ," ).append("\n"); 
		query.append("          LSE_AGREEMENT LSE" ).append("\n"); 
		query.append("          WHERE LSE_RT.CNTR_RNTL_CHG_TP_CD = 'DOCV'" ).append("\n"); 
		query.append("          AND LSE_RT.AGMT_SEQ = LSE.AGMT_SEQ" ).append("\n"); 
		query.append("          AND LSE_RT.AGMT_CTY_CD = LSE.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND LSE.AGMT_LST_VER_SEQ = NVL(null, LSE.AGMT_LST_VER_SEQ)" ).append("\n"); 
		query.append("#if(${scc_list} != '') " ).append("\n"); 
		query.append("          AND LSE_RT.LOC_CD IN (                        " ).append("\n"); 
		query.append(" #foreach($key IN ${scc_list_seq})" ).append("\n"); 
		query.append("  #if($velocityCount < $scc_list_seq.size())" ).append("\n"); 
		query.append("   '$key'," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("   '$key'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY LSE_RT.LOC_CD, LPAD(LSE.AGMT_SEQ, 6, '0'), LSE.AGMT_CTY_CD, LSE_RT.CNTR_TPSZ_CD, LSE_RT.AGMT_CHG_VAL" ).append("\n"); 
		query.append("        ) T02" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("      AND T01.AGMT_NO = T02.AGMT_CTY_CD || T02.AGMT_SEQ " ).append("\n"); 
		query.append("      AND T01.CNTR_TPSZ_CD = T02.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("        AND     LSTM_CD IN (" ).append("\n"); 
		query.append(" #foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("   #if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("        AND     CNMV_STS_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${cnmv_sts_cd_seq})" ).append("\n"); 
		query.append("      #if($velocityCount < $cnmv_sts_cd_seq.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("    #end                    " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("        AND     VVD           = @[vvd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("        AND     AGMT_NO = 'HHO' || LPAD(@[agmt_seq], 6, '0')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("        AND     VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dol_tp} == 'E')" ).append("\n"); 
		query.append("        AND     (DEL_DOL = 'Y' OR MT_RTN_DOL = 'Y' OR  CURR_YD_DOL = 'Y')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dol_tp} == 'N')" ).append("\n"); 
		query.append("        AND     (NVL(DEL_DOL,'N') = 'N' AND NVL(MT_RTN_DOL,'N') = 'N' AND NVL(CURR_YD_DOL,'N') = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY CNTR_NO , CNTR_TPSZ_CD , LSTM_CD , AGMT_NO , REF_NO, VNDR_ABBR_NM , VNDR_SEQ , CRNT_YD_CD , CNMV_STS_CD , FULL_FLG , CNMV_DT , BKG_NO, LCC_CD, POR_CD, POL_CD, POD_CD, DEL_CD, DE_TERM, DEL_SCC, MT_RTN_YD,MT_RTN_SCC, POL_ETD, POD_ETA, VVD" ).append("\n"); 

	}
}