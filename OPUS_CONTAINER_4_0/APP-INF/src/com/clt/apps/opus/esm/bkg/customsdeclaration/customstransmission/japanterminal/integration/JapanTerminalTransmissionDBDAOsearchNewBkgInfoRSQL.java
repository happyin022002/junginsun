/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchNewBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchNewBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchNewBkgInfo
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchNewBkgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_tml_vsl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_ntfy_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchNewBkgInfoRSQL").append("\n"); 
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
		query.append("WITH BL_INFO AS" ).append("\n"); 
		query.append("     (SELECT B.BKG_NO," ).append("\n"); 
		query.append("             0 AS BKG_SKD_SEQ," ).append("\n"); 
		query.append("             'N' AS BKG_SKD_DELT_FLG," ).append("\n"); 
		query.append("             DECODE(JB.SNACCS_TML_EDI_STS_CNG_FLG, 'Y', JB.SNACCS_TML_EDI_STS_CD, DECODE(B.BKG_STS_CD, 'X', 'D', NVL2(JB.BKG_NO, 'V', 'R'))) AS SNACCS_TML_EDI_STS_CD," ).append("\n"); 
		query.append("             NULL AS EDI_SND_DT," ).append("\n"); 
		query.append("             NULL AS EDI_SND_OFC_CD," ).append("\n"); 
		query.append("             NULL AS EDI_SND_USR_ID," ).append("\n"); 
		query.append("             V.VSL_CD," ).append("\n"); 
		query.append("             V.SKD_VOY_NO," ).append("\n"); 
		query.append("             V.SKD_DIR_CD," ).append("\n"); 
		query.append("             @[jp_tml_vsl_no] AS JP_TML_VSL_NO," ).append("\n"); 
		query.append("             B.POL_CD," ).append("\n"); 
		query.append("             B.POL_NOD_CD AS POL_YD_CD," ).append("\n"); 
		query.append("             B.POR_CD," ).append("\n"); 
		query.append("             B.POR_NOD_CD AS POR_YD_CD," ).append("\n"); 
		query.append("             @[otr_ntfy_yd_cd] AS OTR_NTFY_YD_CD," ).append("\n"); 
		query.append("             M.CALL_SGN_NO," ).append("\n"); 
		query.append("             BKG_SPCLCHAR_CONV_FNC(NVL(M.VSL_ENG_NM, ' '), 'J') AS VSL_ENG_NM," ).append("\n"); 
		query.append("             TO_CHAR(B.BKG_CRE_DT, 'YYYY/MM/DD HH24:MI:SS') AS BKG_CRE_DT," ).append("\n"); 
		query.append("             TO_CHAR(S.VPS_ETD_DT, 'YYYY/MM/DD HH24:MI:SS') AS ETD_DT," ).append("\n"); 
		query.append("             TO_CHAR(B.BKG_CRE_DT, 'YYYYMMDD') AS BKG_CRE_DT_YMD,    --조원주 변경(FLAT FILE 형식 맞게 수정)" ).append("\n"); 
		query.append("             TO_CHAR(S.VPS_ETD_DT, 'YYYYMMDD') AS ETD_DT_YMD,    --조원주 변경(FLAT FILE 형식 맞게 수정)" ).append("\n"); 
		query.append("             CS.CUST_CNT_CD AS SHPR_CNT_CD," ).append("\n"); 
		query.append("             CS.CUST_SEQ AS SHPR_CUST_SEQ," ).append("\n"); 
		query.append("             REPLACE(REPLACE(BKG_SPCLCHAR_CONV_FNC(NVL(CS.CUST_NM, ' '), 'J'), CHR(13), ''), CHR(10), '') AS SHPR_CUST_NM,    --조원주 변경(계행문자 제거)" ).append("\n"); 
		query.append("             CF.CUST_CNT_CD AS FRT_FWRD_CNT_CD," ).append("\n"); 
		query.append("             CF.CUST_SEQ AS FRT_FWRD_CUST_SEQ," ).append("\n"); 
		query.append("             REPLACE(REPLACE(BKG_SPCLCHAR_CONV_FNC(NVL(CF.CUST_NM, ' '), 'J'), CHR(13), ''), CHR(10), '') AS FRT_FWRD_CUST_NM,    --조원주 변경(계행문자 제거)" ).append("\n"); 
		query.append("             (SELECT COM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                FROM COM_INTG_CD_DTL COM" ).append("\n"); 
		query.append("               WHERE COM.INTG_CD_ID = 'CD03005'" ).append("\n"); 
		query.append("                 AND COM.INTG_CD_VAL_CTNT = B.RCV_TERM_CD) AS SNACCS_TML_EDI_RCV_TERM_CD," ).append("\n"); 
		query.append("             B.RCV_TERM_CD," ).append("\n"); 
		query.append("             B.POD_CD," ).append("\n"); 
		query.append("             B.POD_NOD_CD AS POD_YD_CD," ).append("\n"); 
		query.append("             B.DEL_CD," ).append("\n"); 
		query.append("             (SELECT COM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                FROM COM_INTG_CD_DTL COM" ).append("\n"); 
		query.append("               WHERE COM.INTG_CD_ID = 'CD03009'" ).append("\n"); 
		query.append("                 AND COM.INTG_CD_VAL_CTNT = B.DE_TERM_CD) AS SNACCS_TML_EDI_DE_TERM_CD," ).append("\n"); 
		query.append("             B.DE_TERM_CD," ).append("\n"); 
		query.append("             B.DEL_CD FNL_DEST_CD," ).append("\n"); 
		query.append("             (SELECT SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(UPPER(LOC_NM), ' '), 'J'), 1, 30)" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("               WHERE LOC_CD = B.DEL_CD) AS FNL_DEST_NM," ).append("\n"); 
		query.append("             (SELECT COM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                FROM COM_INTG_CD_DTL COM" ).append("\n"); 
		query.append("               WHERE COM.INTG_CD_ID = 'CD03008'" ).append("\n"); 
		query.append("                 AND COM.INTG_CD_VAL_CTNT = B.RCV_TERM_CD) AS SNACCS_TML_EDI_CGO_TP_CD," ).append("\n"); 
		query.append("             (SELECT COM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                FROM COM_INTG_CD_DTL COM" ).append("\n"); 
		query.append("               WHERE COM.INTG_CD_ID = 'CD03007'" ).append("\n"); 
		query.append("                 AND COM.INTG_CD_VAL_CTNT = B.RCV_TERM_CD) AS SNACCS_TML_EDI_CGO_KND_CD,    --확인 필요!" ).append("\n"); 
		query.append("             (SELECT SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(CMDT_NM, ' '), 'J'), 1, 100)" ).append("\n"); 
		query.append("                FROM MDM_COMMODITY" ).append("\n"); 
		query.append("               WHERE CMDT_CD = B.CMDT_CD) AS CMDT_NM," ).append("\n"); 
		query.append("             REPLACE(REPLACE(BKG_SPCLCHAR_CONV_FNC(NVL(B.VNDR_RMK, ' '), 'J'), CHR(13), ''), CHR(10), '') AS XTER_RMK,    --조원주 변경(계행문자, 특수문자 제거)" ).append("\n"); 
		query.append("--[김종옥 변경 start]" ).append("\n"); 
		query.append("             BBD.PCK_TP_CD," ).append("\n"); 
		query.append("             BBD.PCK_QTY," ).append("\n"); 
		query.append("             BBD.PCK_TP_CD AS TTL_PCK_TP_CD," ).append("\n"); 
		query.append("             BBD.ACT_WGT AS GRS_WGT," ).append("\n"); 
		query.append("             BBD.WGT_UT_CD," ).append("\n"); 
		query.append("             BBD.MEAS_QTY," ).append("\n"); 
		query.append("             BBD.MEAS_UT_CD," ).append("\n"); 
		query.append("--[김종옥 변경 end]" ).append("\n"); 
		query.append("             (SELECT COM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                FROM COM_INTG_CD_DTL COM" ).append("\n"); 
		query.append("               WHERE COM.INTG_CD_ID = 'CD03006'" ).append("\n"); 
		query.append("                 AND COM.INTG_CD_VAL_CTNT = B.BLCK_STWG_CD) AS SNACCS_TML_EDI_STWG_CD," ).append("\n"); 
		query.append("             REPLACE(REPLACE(BKG_SPCLCHAR_CONV_FNC(NVL(B.STWG_RMK, ' '), 'J'), CHR(13), ''), CHR(10), '') AS STWG_RMK," ).append("\n"); 
		query.append("             B.BLCK_STWG_CD," ).append("\n"); 
		query.append("             DECODE(B.RC_FLG, 'N', 'Y', 'N') AS DRY_CGO_FLG," ).append("\n"); 
		query.append("             DECODE(B.BKG_CGO_TP_CD, 'P', 'Y', 'R', 'Y', 'N') AS MCNTR_FLG,    --확인 필요" ).append("\n"); 
		query.append("             B.SOC_FLG," ).append("\n"); 
		query.append("             B.EQ_SUBST_FLG," ).append("\n"); 
		query.append("             -- RF_CNTR_PRE_CLNG_FLG," ).append("\n"); 
		query.append("--[컬럼추가start]---------------------------------------------------------" ).append("\n"); 
		query.append("             MAX(NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                        FROM BKG_DG_CGO DC" ).append("\n"); 
		query.append("                       WHERE DC.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND ROWNUM = 1), 'N')) AS DCGO_FLG," ).append("\n"); 
		query.append("             MAX(NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                        FROM BKG_AWK_CGO AWK" ).append("\n"); 
		query.append("                       WHERE AWK.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND ROWNUM = 1), 'N')) AS AWK_CGO_FLG," ).append("\n"); 
		query.append("             B.BB_CGO_FLG," ).append("\n"); 
		query.append("             MAX(NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                        FROM BKG_RF_CGO RC" ).append("\n"); 
		query.append("                       WHERE RC.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND ROWNUM = 1), 'N')) AS RD_CGO_FLG," ).append("\n"); 
		query.append("--[컬럼추가end]---------------------------------------------------------" ).append("\n"); 
		query.append("             (SELECT COUNT(BKG_NO) R_CNT" ).append("\n"); 
		query.append("                FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("               WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                 AND EDI_SND_DT IS NOT NULL) AS R_STS_CNT," ).append("\n"); 
		query.append("             (SELECT COUNT(BKG_NO) R_CNT" ).append("\n"); 
		query.append("                FROM BKG_TML_EDI_JP_BL JBL" ).append("\n"); 
		query.append("               WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("                 AND JBL.BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 AND JBL.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                 AND JBL.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                 AND JBL.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                 AND JBL.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                 AND JBL.BKG_SKD_SEQ = 0) AS VVD_CHK_STS_CNT," ).append("\n"); 
		query.append("             JB.CNTR_TPSZ_CD1," ).append("\n"); 
		query.append("             JB.CNTR_VOL_QTY1," ).append("\n"); 
		query.append("             JB.CNTR_TPSZ_CD2," ).append("\n"); 
		query.append("             JB.CNTR_VOL_QTY2," ).append("\n"); 
		query.append("             JB.CNTR_TPSZ_CD3," ).append("\n"); 
		query.append("             JB.CNTR_VOL_QTY3," ).append("\n"); 
		query.append("             JB.CNTR_TPSZ_CD4," ).append("\n"); 
		query.append("             JB.CNTR_VOL_QTY4," ).append("\n"); 
		query.append("             JB.CNTR_TPSZ_CD5," ).append("\n"); 
		query.append("             JB.CNTR_VOL_QTY5," ).append("\n"); 
		query.append("             JB.PRT_FLG," ).append("\n"); 
		query.append("             NVL(JB.SNACCS_TML_EDI_STS_CNG_FLG, 'N') AS SNACCS_TML_EDI_STS_CNG_FLG," ).append("\n"); 
		query.append("             B.MTY_PKUP_YD_CD AS MTY_P_YD," ).append("\n"); 
		query.append("             YD.YD_NM AS MTY_P_YD_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM BKG_VVD V," ).append("\n"); 
		query.append("             BKG_BOOKING B," ).append("\n"); 
		query.append("             MDM_VSL_CNTR M," ).append("\n"); 
		query.append("             VSK_VSL_PORT_SKD S," ).append("\n"); 
		query.append("             BKG_CUSTOMER CS," ).append("\n"); 
		query.append("             BKG_CUSTOMER CF," ).append("\n"); 
		query.append("             BKG_CONTAINER BC,    --LCL ONLY" ).append("\n"); 
		query.append("             BKG_TML_EDI_JP_BL JB," ).append("\n"); 
		query.append("             BKG_BL_DOC BBD," ).append("\n"); 
		query.append("             MDM_YARD YD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       WHERE 1 = 1" ).append("\n"); 
		query.append("         AND V.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("         AND V.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("         AND V.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("         AND V.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("         AND B.BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("         AND B.POL_CD = V.POL_CD" ).append("\n"); 
		query.append("#if (${pol_yd_cd} != '')" ).append("\n"); 
		query.append("         AND B.POL_NOD_CD = @[pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND B.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#if (${por_yd_cd} != '')" ).append("\n"); 
		query.append("         AND B.POR_NOD_CD = @[por_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND M.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("         AND S.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("         AND S.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND S.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND S.VPS_PORT_CD = V.POL_CD" ).append("\n"); 
		query.append("         AND S.CLPT_IND_SEQ = V.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("         AND CS.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("         AND CS.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("         AND CF.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("         AND CF.BKG_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("         AND BC.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("         AND BBD.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("         --  AND BC.CNTR_PRT_FLG(+) = 'Y'" ).append("\n"); 
		query.append("         AND JB.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("         AND JB.BKG_SKD_SEQ(+) = 0" ).append("\n"); 
		query.append("         AND YD.YD_CD(+) = B.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       GROUP BY B.BKG_NO," ).append("\n"); 
		query.append("             DECODE(JB.SNACCS_TML_EDI_STS_CNG_FLG, 'Y', JB.SNACCS_TML_EDI_STS_CD, DECODE(B.BKG_STS_CD, 'X', 'D', NVL2(JB.BKG_NO, 'V', 'R'))),    --JAPAN 터미널 EDI 전송상태 코드 R 신규 V 수정 D 삭제" ).append("\n"); 
		query.append("             V.VSL_CD," ).append("\n"); 
		query.append("             V.SKD_VOY_NO," ).append("\n"); 
		query.append("             V.SKD_DIR_CD," ).append("\n"); 
		query.append("             B.POL_CD," ).append("\n"); 
		query.append("             B.POL_NOD_CD," ).append("\n"); 
		query.append("             B.POR_CD," ).append("\n"); 
		query.append("             B.POR_NOD_CD," ).append("\n"); 
		query.append("             @[otr_ntfy_yd_cd]," ).append("\n"); 
		query.append("             M.CALL_SGN_NO," ).append("\n"); 
		query.append("             M.VSL_ENG_NM," ).append("\n"); 
		query.append("             B.BKG_CRE_DT," ).append("\n"); 
		query.append("             S.VPS_ETD_DT," ).append("\n"); 
		query.append("             CS.CUST_CNT_CD," ).append("\n"); 
		query.append("             CS.CUST_SEQ," ).append("\n"); 
		query.append("             CS.CUST_NM," ).append("\n"); 
		query.append("             CF.CUST_CNT_CD," ).append("\n"); 
		query.append("             CF.CUST_SEQ," ).append("\n"); 
		query.append("             CF.CUST_NM," ).append("\n"); 
		query.append("             B.RCV_TERM_CD," ).append("\n"); 
		query.append("             B.POD_CD," ).append("\n"); 
		query.append("             B.POD_NOD_CD," ).append("\n"); 
		query.append("             B.DEL_CD," ).append("\n"); 
		query.append("             B.DE_TERM_CD," ).append("\n"); 
		query.append("             B.POD_CD," ).append("\n"); 
		query.append("             B.CMDT_CD," ).append("\n"); 
		query.append("             B.VNDR_RMK," ).append("\n"); 
		query.append("             BBD.PCK_TP_CD," ).append("\n"); 
		query.append("             BBD.PCK_QTY," ).append("\n"); 
		query.append("             BBD.ACT_WGT," ).append("\n"); 
		query.append("             BBD.WGT_UT_CD," ).append("\n"); 
		query.append("             BBD.MEAS_QTY," ).append("\n"); 
		query.append("             BBD.MEAS_UT_CD," ).append("\n"); 
		query.append("             B.BLCK_STWG_CD," ).append("\n"); 
		query.append("             B.STWG_RMK," ).append("\n"); 
		query.append("             B.BLCK_STWG_CD," ).append("\n"); 
		query.append("             B.RC_FLG," ).append("\n"); 
		query.append("             B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("             B.SOC_FLG," ).append("\n"); 
		query.append("             B.EQ_SUBST_FLG," ).append("\n"); 
		query.append("             -- RF_CNTR_PRE_CLNG_FLG" ).append("\n"); 
		query.append("             B.BB_CGO_FLG," ).append("\n"); 
		query.append("             JB.CNTR_TPSZ_CD1," ).append("\n"); 
		query.append("             JB.CNTR_VOL_QTY1," ).append("\n"); 
		query.append("             JB.CNTR_TPSZ_CD2," ).append("\n"); 
		query.append("             JB.CNTR_VOL_QTY2," ).append("\n"); 
		query.append("             JB.CNTR_TPSZ_CD3," ).append("\n"); 
		query.append("             JB.CNTR_VOL_QTY3," ).append("\n"); 
		query.append("             JB.CNTR_TPSZ_CD4," ).append("\n"); 
		query.append("             JB.CNTR_VOL_QTY4," ).append("\n"); 
		query.append("             JB.CNTR_TPSZ_CD5," ).append("\n"); 
		query.append("             JB.CNTR_VOL_QTY5," ).append("\n"); 
		query.append("             JB.PRT_FLG," ).append("\n"); 
		query.append("             JB.SNACCS_TML_EDI_STS_CNG_FLG," ).append("\n"); 
		query.append("             B.MTY_PKUP_YD_CD," ).append("\n"); 
		query.append("             YD.YD_NM)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT Z.BKG_NO," ).append("\n"); 
		query.append("       X.BKG_SKD_SEQ," ).append("\n"); 
		query.append("       X.BKG_SKD_DELT_FLG," ).append("\n"); 
		query.append("       X.SNACCS_TML_EDI_STS_CD," ).append("\n"); 
		query.append("       X.EDI_SND_DT," ).append("\n"); 
		query.append("       X.EDI_SND_OFC_CD," ).append("\n"); 
		query.append("       X.EDI_SND_USR_ID," ).append("\n"); 
		query.append("       X.VSL_CD," ).append("\n"); 
		query.append("       X.SKD_VOY_NO," ).append("\n"); 
		query.append("       X.SKD_DIR_CD," ).append("\n"); 
		query.append("       X.JP_TML_VSL_NO," ).append("\n"); 
		query.append("       X.POL_CD," ).append("\n"); 
		query.append("       X.POL_YD_CD," ).append("\n"); 
		query.append("       X.POR_CD," ).append("\n"); 
		query.append("       X.POR_YD_CD," ).append("\n"); 
		query.append("       X.OTR_NTFY_YD_CD," ).append("\n"); 
		query.append("       X.CALL_SGN_NO," ).append("\n"); 
		query.append("       X.VSL_ENG_NM," ).append("\n"); 
		query.append("       X.BKG_CRE_DT," ).append("\n"); 
		query.append("       X.ETD_DT," ).append("\n"); 
		query.append("       X.BKG_CRE_DT_YMD," ).append("\n"); 
		query.append("       X.ETD_DT_YMD," ).append("\n"); 
		query.append("       X.SHPR_CNT_CD," ).append("\n"); 
		query.append("       X.SHPR_CUST_SEQ," ).append("\n"); 
		query.append("       X.SHPR_CUST_NM," ).append("\n"); 
		query.append("       X.FRT_FWRD_CNT_CD," ).append("\n"); 
		query.append("       X.FRT_FWRD_CUST_SEQ," ).append("\n"); 
		query.append("       X.FRT_FWRD_CUST_NM," ).append("\n"); 
		query.append("       X.SNACCS_TML_EDI_RCV_TERM_CD," ).append("\n"); 
		query.append("       X.RCV_TERM_CD," ).append("\n"); 
		query.append("       X.POD_CD," ).append("\n"); 
		query.append("       X.POD_YD_CD," ).append("\n"); 
		query.append("       X.DEL_CD," ).append("\n"); 
		query.append("       X.SNACCS_TML_EDI_DE_TERM_CD," ).append("\n"); 
		query.append("       X.DE_TERM_CD," ).append("\n"); 
		query.append("       X.FNL_DEST_CD," ).append("\n"); 
		query.append("       X.FNL_DEST_NM," ).append("\n"); 
		query.append("       X.SNACCS_TML_EDI_CGO_TP_CD," ).append("\n"); 
		query.append("       X.SNACCS_TML_EDI_CGO_KND_CD," ).append("\n"); 
		query.append("       X.PCK_TP_CD," ).append("\n"); 
		query.append("       X.CMDT_NM," ).append("\n"); 
		query.append("       X.XTER_RMK," ).append("\n"); 
		query.append("       X.PCK_QTY," ).append("\n"); 
		query.append("       X.TTL_PCK_TP_CD," ).append("\n"); 
		query.append("       Z.GRS_WGT," ).append("\n"); 
		query.append("       X.WGT_UT_CD," ).append("\n"); 
		query.append("       Z.MEAS_QTY," ).append("\n"); 
		query.append("       X.MEAS_UT_CD," ).append("\n"); 
		query.append("       X.SNACCS_TML_EDI_STWG_CD," ).append("\n"); 
		query.append("       X.STWG_RMK," ).append("\n"); 
		query.append("       X.BLCK_STWG_CD," ).append("\n"); 
		query.append("       X.DRY_CGO_FLG," ).append("\n"); 
		query.append("       X.MCNTR_FLG," ).append("\n"); 
		query.append("       X.SOC_FLG," ).append("\n"); 
		query.append("       X.EQ_SUBST_FLG," ).append("\n"); 
		query.append("       DECODE(X.PRT_FLG, 'Y', X.CNTR_TPSZ_CD1, Y.CNTR_TPSZ_CD1) AS CNTR_TPSZ_CD1," ).append("\n"); 
		query.append("       DECODE(X.PRT_FLG, 'Y', X.CNTR_VOL_QTY1, Y.CNTR_VOL_QTY1) AS CNTR_VOL_QTY1," ).append("\n"); 
		query.append("       DECODE(X.PRT_FLG, 'Y', X.CNTR_TPSZ_CD2, Y.CNTR_TPSZ_CD2) AS CNTR_TPSZ_CD2," ).append("\n"); 
		query.append("       DECODE(X.PRT_FLG, 'Y', X.CNTR_VOL_QTY2, Y.CNTR_VOL_QTY2) AS CNTR_VOL_QTY2," ).append("\n"); 
		query.append("       DECODE(X.PRT_FLG, 'Y', X.CNTR_TPSZ_CD3, Y.CNTR_TPSZ_CD3) AS CNTR_TPSZ_CD3," ).append("\n"); 
		query.append("       DECODE(X.PRT_FLG, 'Y', X.CNTR_VOL_QTY3, Y.CNTR_VOL_QTY3) AS CNTR_VOL_QTY3," ).append("\n"); 
		query.append("       DECODE(X.PRT_FLG, 'Y', X.CNTR_TPSZ_CD4, Y.CNTR_TPSZ_CD4) AS CNTR_TPSZ_CD4," ).append("\n"); 
		query.append("       DECODE(X.PRT_FLG, 'Y', X.CNTR_VOL_QTY4, Y.CNTR_VOL_QTY4) AS CNTR_VOL_QTY4," ).append("\n"); 
		query.append("       DECODE(X.PRT_FLG, 'Y', X.CNTR_TPSZ_CD5, Y.CNTR_TPSZ_CD5) AS CNTR_TPSZ_CD5," ).append("\n"); 
		query.append("       DECODE(X.PRT_FLG, 'Y', X.CNTR_VOL_QTY5, Y.CNTR_VOL_QTY5) AS CNTR_VOL_QTY5," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN TRUNC(Y.CNTR_VOL_QTY_TOT) = Y.CNTR_VOL_QTY_TOT THEN 'N'" ).append("\n"); 
		query.append("         ELSE 'Y'" ).append("\n"); 
		query.append("       END AS PRT_FLG," ).append("\n"); 
		query.append("       X.SNACCS_TML_EDI_STS_CNG_FLG," ).append("\n"); 
		query.append("--[컬럼추가start]---------------------------------------------------------" ).append("\n"); 
		query.append("       X.DCGO_FLG," ).append("\n"); 
		query.append("       X.AWK_CGO_FLG," ).append("\n"); 
		query.append("       X.BB_CGO_FLG," ).append("\n"); 
		query.append("       X.RD_CGO_FLG," ).append("\n"); 
		query.append("--[컬럼추가end]---------------------------------------------------------" ).append("\n"); 
		query.append("       X.R_STS_CNT," ).append("\n"); 
		query.append("       X.VVD_CHK_STS_CNT," ).append("\n"); 
		query.append("       X.MTY_P_YD," ).append("\n"); 
		query.append("       X.MTY_P_YD_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BL_INFO X," ).append("\n"); 
		query.append("--[김종옥 수정 2012-04-04 start]---------------------------------------------------------" ).append("\n"); 
		query.append("       (SELECT BKG_NO," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN, 5), 1, CNTR_TPSZ_CD, '')) AS CNTR_TPSZ_CD1," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN, 5), 1, CNTR_VOL_QTY, '')) AS CNTR_VOL_QTY1," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN, 5), 2, CNTR_TPSZ_CD, '')) AS CNTR_TPSZ_CD2," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN, 5), 2, CNTR_VOL_QTY, '')) AS CNTR_VOL_QTY2," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN, 5), 3, CNTR_TPSZ_CD, '')) AS CNTR_TPSZ_CD3," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN, 5), 3, CNTR_VOL_QTY, '')) AS CNTR_VOL_QTY3," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN, 5), 4, CNTR_TPSZ_CD, '')) AS CNTR_TPSZ_CD4," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN, 5), 4, CNTR_VOL_QTY, '')) AS CNTR_VOL_QTY4," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN, 5), 0, CNTR_TPSZ_CD, '')) AS CNTR_TPSZ_CD5," ).append("\n"); 
		query.append("               MAX(DECODE(MOD(RN, 5), 0, CNTR_VOL_QTY, '')) AS CNTR_VOL_QTY5," ).append("\n"); 
		query.append("               SUM(NVL(CNTR_VOL_QTY, 0)) AS CNTR_VOL_QTY_TOT --JS추가" ).append("\n"); 
		query.append("          FROM (SELECT BKG_NO," ).append("\n"); 
		query.append("                       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                       SUM(OP_CNTR_QTY) OVER (PARTITION BY BKG_NO, CNTR_TPSZ_CD) AS CNTR_VOL_QTY," ).append("\n"); 
		query.append("                       RANK() OVER (PARTITION BY BKG_NO ORDER BY CNTR_TPSZ_CD) AS RN" ).append("\n"); 
		query.append("                  FROM (SELECT BKG_NO," ).append("\n"); 
		query.append("                               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                               SUM(OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("                          FROM (SELECT (SELECT MIN(BKG_NO)" ).append("\n"); 
		query.append("                                          FROM BL_INFO" ).append("\n"); 
		query.append("                                         WHERE BKG_NO LIKE SUBSTR(Q.BKG_NO, 1, 10)||'%') AS BKG_NO," ).append("\n"); 
		query.append("                                       Q.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                       Q.OP_CNTR_QTY" ).append("\n"); 
		query.append("                                  FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                                 WHERE Q.BKG_NO IN (SELECT BKG_NO FROM BL_INFO))" ).append("\n"); 
		query.append("                         GROUP BY BKG_NO," ).append("\n"); 
		query.append("                                  CNTR_TPSZ_CD))" ).append("\n"); 
		query.append("         GROUP BY BKG_NO) Y," ).append("\n"); 
		query.append("--[김종옥 수정 2012-04-04 end]---------------------------------------------------------" ).append("\n"); 
		query.append("       (SELECT MIN(BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("               SUM(GRS_WGT) AS GRS_WGT," ).append("\n"); 
		query.append("               SUM(MEAS_QTY) AS MEAS_QTY" ).append("\n"); 
		query.append("          FROM BL_INFO" ).append("\n"); 
		query.append("         GROUP BY SUBSTR(BKG_NO, 1, 10)) Z" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE X.BKG_NO = Y.BKG_NO(+)" ).append("\n"); 
		query.append("   AND X.BKG_NO = Z.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY Z.BKG_NO" ).append("\n"); 

	}
}