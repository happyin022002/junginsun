/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.10
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.11.10 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFlatFileKleinSchmitRailBillDetail
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("strsp_edi_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDetailRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_NO AS EQ_NO" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD AS EQ_TPSZ" ).append("\n"); 
		query.append("      ,DECODE(A.CGO_TP_CD, 'M', 'E', A.CGO_TP_CD) AS EQ_STS" ).append("\n"); 
		query.append("      ,(NVL((ROUND(CASE A.TRSP_BND_CD WHEN 'O' THEN DECODE(A.WGT_MEAS_UT_CD, 'KGS', TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC('KGS', NVL(A.CNTR_WGT, 0)), NVL(A.CNTR_WGT, 0))" ).append("\n"); 
		query.append("                          		 	  WHEN 'I' THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC('KGS', NVL(BL.BL_WGT, 0))" ).append("\n"); 
		query.append("        END)),0) + ROUND(TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC('KGS', NVL(MST_SPEC_FNC('TARE', A.EQ_NO), 0)))) AS GROSS_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,ROUND(TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC('KGS', NVL(MST_SPEC_FNC('TARE', A.EQ_NO), 0))) AS TARE_WGT" ).append("\n"); 
		query.append("      ,NVL((ROUND(CASE A.TRSP_BND_CD WHEN 'O' THEN DECODE(A.WGT_MEAS_UT_CD, 'KGS', TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC('KGS', NVL(A.CNTR_WGT, 0)), NVL(A.CNTR_WGT, 0))" ).append("\n"); 
		query.append("                                     WHEN 'I' THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC('KGS', NVL(BL.BL_WGT, 0))" ).append("\n"); 
		query.append("       END)), 0) AS CARGO_WGT" ).append("\n"); 
		query.append("      ,'LBS' WGT_UNIT" ).append("\n"); 
		query.append("      ,CASE WHEN K.YD_LOC_CTY_NM IS NULL THEN ''" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("          NVL((SELECT NT.EDI_NTFY_NM" ).append("\n"); 
		query.append("                FROM TRS_TRSP_NTFY_SET NT" ).append("\n"); 
		query.append("               WHERE UPPER(NT.NTFY_YD_CTY_NM) = UPPER(K.YD_LOC_CTY_NM)" ).append("\n"); 
		query.append("                 AND NT.NTFY_BND_CD = DECODE(A.BKG_CGO_TP_CD, 'F', A.TRSP_BND_CD, 'E')" ).append("\n"); 
		query.append("                 AND ROWNUM =1" ).append("\n"); 
		query.append("                 )," ).append("\n"); 
		query.append("              NVL((SELECT NT.EDI_NTFY_NM" ).append("\n"); 
		query.append("                    FROM TRS_TRSP_NTFY_SET NT" ).append("\n"); 
		query.append("                   WHERE UPPER(NT.NTFY_YD_CTY_NM) = UPPER(K.YD_LOC_CTY_NM)" ).append("\n"); 
		query.append("                     AND NT.NTFY_BND_CD = 'A'" ).append("\n"); 
		query.append("                     AND ROWNUM =1" ).append("\n"); 
		query.append("                     )," ).append("\n"); 
		query.append("                  (SELECT NT.EDI_NTFY_NM" ).append("\n"); 
		query.append("                     FROM TRS_TRSP_NTFY_SET NT" ).append("\n"); 
		query.append("                    WHERE NT.NTFY_YD_CTY_NM = 'ALL'" ).append("\n"); 
		query.append("                      AND NT.NTFY_BND_CD = 'A'" ).append("\n"); 
		query.append("                      AND ROWNUM =1)))" ).append("\n"); 
		query.append("       END AS NTFY_NM" ).append("\n"); 
		query.append("      ,CASE WHEN K.YD_LOC_CTY_NM IS NULL THEN ''" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("          NVL((SELECT NT.EDI_NTFY_INFO_CTNT" ).append("\n"); 
		query.append("                FROM TRS_TRSP_NTFY_SET NT" ).append("\n"); 
		query.append("               WHERE UPPER(NT.NTFY_YD_CTY_NM) = UPPER(K.YD_LOC_CTY_NM)" ).append("\n"); 
		query.append("                 AND NT.NTFY_BND_CD = DECODE(A.BKG_CGO_TP_CD, 'F', A.TRSP_BND_CD, 'E')" ).append("\n"); 
		query.append("                 AND ROWNUM =1" ).append("\n"); 
		query.append("                 )," ).append("\n"); 
		query.append("              NVL((SELECT NT.EDI_NTFY_INFO_CTNT" ).append("\n"); 
		query.append("                    FROM TRS_TRSP_NTFY_SET NT" ).append("\n"); 
		query.append("                   WHERE UPPER(NT.NTFY_YD_CTY_NM) = UPPER(K.YD_LOC_CTY_NM)" ).append("\n"); 
		query.append("                     AND NT.NTFY_BND_CD = 'A'" ).append("\n"); 
		query.append("                     AND ROWNUM=1)," ).append("\n"); 
		query.append("                  (SELECT NT.EDI_NTFY_INFO_CTNT" ).append("\n"); 
		query.append("                     FROM TRS_TRSP_NTFY_SET NT" ).append("\n"); 
		query.append("                    WHERE NT.NTFY_YD_CTY_NM = 'ALL'" ).append("\n"); 
		query.append("                      AND NT.NTFY_BND_CD = 'A'" ).append("\n"); 
		query.append("                      AND ROWNUM=1)))" ).append("\n"); 
		query.append("       END AS NTFY_TE" ).append("\n"); 
		query.append("      ,K.FAX_NO AS NTFY_FX" ).append("\n"); 
		query.append("      ,'' AS DOMESTIC_NM" ).append("\n"); 
		query.append("      ,DECODE(A.CGO_TP_CD, 'M', '4221130', A.STCC_CD) STCC_CD" ).append("\n"); 
		query.append("      ,DECODE(A.CGO_TP_CD, 'M', 'EMPTY',  A.STCC_DESC) STCC_DESC" ).append("\n"); 
		query.append("      ,DECODE(A.CGO_TP_CD, 'M', 'EMPTY REPO', O.BKG_NO) BKG_NO" ).append("\n"); 
		query.append("      ,A.BL_NO AS BL_NO" ).append("\n"); 
		query.append("      ,'' AS DOMESTIC_BKG_NO" ).append("\n"); 
		query.append("	  ,A.POL_NOD_CD AS POL_YD    				--ADD" ).append("\n"); 
		query.append("	  ,(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = A.POL_NOD_CD) AS POL_NM --ADD" ).append("\n"); 
		query.append("	  ,A.POD_NOD_CD AS POD_YD                     --ADD" ).append("\n"); 
		query.append("	  ,(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = A.POD_NOD_CD) AS POD_NM --ADD  " ).append("\n"); 
		query.append("      ,DECODE(A.CGO_TP_CD, 'M', '', A.VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("      ,DECODE(A.CGO_TP_CD, 'M', '',(SELECT VSL_ENG_NM FROM BKG_VVD V ,MDM_VSL_CNTR C WHERE V.VSL_CD = C.VSL_CD AND A.BKG_NO = V.BKG_NO AND DECODE(A.TRSP_BND_CD, 'I', V.POD_YD_CD, V.POL_YD_CD) = DECODE(A.TRSP_BND_CD, 'I', A.POD_NOD_CD, A.POL_NOD_CD) AND ROWNUM = 1)) AS VSL_NM" ).append("\n"); 
		query.append("      ,DECODE(A.CGO_TP_CD, 'M', '', (A.SKD_VOY_NO || A.SKD_DIR_CD)) AS VSL_VOY" ).append("\n"); 
		query.append("      ,DECODE(A.CGO_TP_CD, 'M', 'E', DECODE(A.BKG_NO, NULL, 'M', 'L')) AS STATUS" ).append("\n"); 
		query.append("      ,LPAD(O.BIL_EDI_CTRL_SEQ, 9, '0') AS TRANS_NO" ).append("\n"); 
		query.append("      ,DECODE(A.CGO_TP_CD, 'M', '', DECODE(A.TRSP_BND_CD, 'O', 'E', 'I')) AS IMEX" ).append("\n"); 
		query.append("      ,AI.IBD_TRSP_TP_CD AS INBOND_TP" ).append("\n"); 
		query.append("      ,AI.IBD_TRSP_NO AS IT_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(O.BIL_EDI_SNT_DT, 'YYYYMMDDHH24MI') AS RAILBILL_DT" ).append("\n"); 
		query.append("      ,A.REF_ID AS MT_PLAN_NO" ).append("\n"); 
		query.append("      ,DECODE(BK.RC_FLG, 'Y', M.FDO_TEMP, '') TEMP" ).append("\n"); 
		query.append("      ,DECODE(BK.RC_FLG, 'Y', 'FA', '') AS TEMP_UNIT" ).append("\n"); 
		query.append("      ,'' AS PROTECT" ).append("\n"); 
		query.append("      ,DECODE(A.TRSP_BND_CD, 'O', DECODE(TM.SYS_SET_DT, NULL, '', TO_CHAR(TM.SYS_SET_DT, 'YYYYMMDDHH24MI')), '') AS VSL_CUTOVER_DT" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(VSK.VPS_ETA_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("         FROM BKG_BOOKING      BKG" ).append("\n"); 
		query.append("             ,VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("        WHERE BKG.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("          AND BKG.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND BKG.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND BKG.POD_NOD_CD = VSK.YD_CD" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("		  AND ROWNUM = 1) AS ETA " ).append("\n"); 
		query.append("      ,REGEXP_REPLACE(A.CNTR_SEAL_NO || NVL2(A.CNTR_SEAL_NO, ',', '') || (SELECT WM_CONCAT(CNTR_SEAL_NO) FROM BKG_CNTR_SEAL_NO SE WHERE SE.BKG_NO = D.BKG_NO AND SE.CNTR_NO = D.CNTR_NO AND SE.CNTR_SEAL_NO <> A.CNTR_SEAL_NO), ',$', '') AS SEAL" ).append("\n"); 
		query.append("  FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("      ,BKG_CONTAINER D" ).append("\n"); 
		query.append("      ,MDM_YARD I" ).append("\n"); 
		query.append("      ,BKG_RF_CGO M" ).append("\n"); 
		query.append("      ,MDM_YARD K" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_IBD AI" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL CND" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION OFC" ).append("\n"); 
		query.append("      ,BKG_BOOKING BK" ).append("\n"); 
		query.append("      ,TRS_TRSP_RAIL_OFC_EXPT ROFC" ).append("\n"); 
		query.append("      ,BKG_CLZ_TM TM" ).append("\n"); 
		query.append("      ,(SELECT A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("              ,MIN(DECODE(A.SUB_RAIL_SEQ, 1, A.VNDR_SEQ)) VNDR_SEQ" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, B.USA_EDI_CD, '')) ROUTCARR" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, DECODE(SUBSTR(C.RAIL_CMB_THRU_TP_CD, 3), 'T', 'S', 'C', 'S', 'R'), '')) ROUTSEQ" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, PRD.INLND_ROUT_JUNC_NM, '')) ROUTCITY" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, MST.ROUT_PLN_CD, '')) INTMOSVR" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'X'), '')) TRANSTP" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, A.TO_NOD_CD, '')) TO_YARD_CD" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, AGMT.AGMT_REF_NO)) AGMT_REF_NO" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 2, B.USA_EDI_CD, '')) ROUTCARR2" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 2, '1', '')) ROUTSEQ2" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 2, PRD.INLND_ROUT_JUNC_NM, '')) ROUTCITY2" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 2, MST.ROUT_PLN_CD, '')) INTMOSVR2" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 2, DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'X'), '')) TRANSTP2" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 2, A.TO_NOD_CD, '')) TO_YARD_CD2" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 2, AGMT.AGMT_REF_NO)) AGMT_REF_NO2" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 3, B.USA_EDI_CD, '')) ROUTCARR3" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 3, '2', '')) ROUTSEQ3" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 3, PRD.INLND_ROUT_JUNC_NM, '')) ROUTCITY3" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 3, MST.ROUT_PLN_CD, '')) INTMOSVR3" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 3, DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'X'), '')) TRANSTP3" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 3, A.TO_NOD_CD, '')) TO_YARD_CD3" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 3, AGMT.AGMT_REF_NO)) AGMT_REF_NO3" ).append("\n"); 
		query.append("              ,MAX(EDI.BIL_EDI_CTRL_SEQ) BIL_EDI_CTRL_SEQ" ).append("\n"); 
		query.append("              ,MAX(EDI.BKG_NO) BKG_NO" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'CN', 'T', 'CC'))) EQDESC_C" ).append("\n"); 
		query.append("              ,MAX(C.FM_NOD_CD) FM_NOD_CD" ).append("\n"); 
		query.append("              ,MAX(C.TO_NOD_CD) TO_NOD_CD" ).append("\n"); 
		query.append("              ,MAX(EDI.BIL_EDI_SNT_DT) BIL_EDI_SNT_DT" ).append("\n"); 
		query.append("          FROM TRS_TRSP_RAIL_BIL_VNDR_SET A" ).append("\n"); 
		query.append("              ,MDM_VENDOR                 B" ).append("\n"); 
		query.append("              ,TRS_TRSP_RAIL_BIL_ORD      C" ).append("\n"); 
		query.append("              ,TRS_TRSP_EDI_TMP           TMP" ).append("\n"); 
		query.append("              ,TRS_TRSP_EDI_RAIL_ORD      EDI" ).append("\n"); 
		query.append("              ,TRS_AGMT_HDR               AGMT" ).append("\n"); 
		query.append("              ,PRD_INLND_ROUT_DTL         PRD" ).append("\n"); 
		query.append("              ,PRD_INLND_ROUT_MST         MST" ).append("\n"); 
		query.append("         WHERE TMP.TRSP_EDI_SND_NO = @[strsp_edi_snd_no]" ).append("\n"); 
		query.append("           AND A.TRSP_SO_OFC_CTY_CD = TMP.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_SO_SEQ = TMP.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("           AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND C.ROUT_ORG_NOD_CD = PRD.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("           AND C.ROUT_DEST_NOD_CD = PRD.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("           AND C.ROUT_SEQ = PRD.ROUT_SEQ" ).append("\n"); 
		query.append("           AND A.ROUT_DTL_SEQ = PRD.ROUT_DTL_SEQ" ).append("\n"); 
		query.append("           AND MST.ROUT_ORG_NOD_CD = PRD.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("           AND MST.ROUT_DEST_NOD_CD = PRD.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("           AND MST.ROUT_SEQ = PRD.ROUT_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_SO_OFC_CTY_CD = EDI.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_SO_SEQ = EDI.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ = AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("           AND C.RAIL_CMB_THRU_TP_CD IN ('C1T', 'C2T', 'C3T', 'C2R', 'C3R', 'C2C', 'C3S')" ).append("\n"); 
		query.append("           AND EDI.BIL_ISS_KNT = (SELECT MAX(BIL_ISS_KNT)" ).append("\n"); 
		query.append("                                    FROM TRS_TRSP_EDI_RAIL_ORD E" ).append("\n"); 
		query.append("                                   WHERE EDI.TRSP_SO_OFC_CTY_CD = E.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                     AND EDI.TRSP_SO_SEQ = E.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("         GROUP BY A.TRSP_SO_OFC_CTY_CD ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("              ,A.VNDR_SEQ" ).append("\n"); 
		query.append("              ,B.USA_EDI_CD ROUTCARR" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, DECODE(SUBSTR(C.RAIL_CMB_THRU_TP_CD, 3), 'T', 'S', 'C', 'S', 'R'), 2, 1, 3, 2)) ROUTSEQ" ).append("\n"); 
		query.append("              ,PRD.INLND_ROUT_JUNC_NM ROUTCITY" ).append("\n"); 
		query.append("              ,MST.ROUT_PLN_CD INTMOSVR" ).append("\n"); 
		query.append("              ,DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'X') TRANSTP" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, A.TO_NOD_CD, '')) TO_YARD_CD" ).append("\n"); 
		query.append("              ,MAX(AGMT.AGMT_REF_NO) AGMT_REF_NO" ).append("\n"); 
		query.append("              ,'' ROUTCARR2" ).append("\n"); 
		query.append("              ,'' ROUTSEQ2" ).append("\n"); 
		query.append("              ,'' ROUTCITY2" ).append("\n"); 
		query.append("              ,'' INTMOSVR2" ).append("\n"); 
		query.append("              ,'' TRANSTP2" ).append("\n"); 
		query.append("              ,'' TO_YARD_CD2" ).append("\n"); 
		query.append("              ,'' AGMT_REF_NO2" ).append("\n"); 
		query.append("              ,'' ROUTCARR3" ).append("\n"); 
		query.append("              ,'' ROUTSEQ3" ).append("\n"); 
		query.append("              ,'' ROUTCITY3" ).append("\n"); 
		query.append("              ,'' INTMOSVR3" ).append("\n"); 
		query.append("              ,'' TRANSTP3" ).append("\n"); 
		query.append("              ,'' TO_YARD_CD3" ).append("\n"); 
		query.append("              ,'' AGMT_REF_NO3" ).append("\n"); 
		query.append("              ,MAX(EDI.BIL_EDI_CTRL_SEQ) BIL_EDI_CTRL_SEQ" ).append("\n"); 
		query.append("              ,MAX(EDI.BKG_NO) BKG_NO" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.SUB_RAIL_SEQ, 1, DECODE(SUBSTR(A.RAIL_CRR_TP_CD, 1, 1), 'C', 'CN', 'T', 'CC'))) EQDESC_C" ).append("\n"); 
		query.append("              ,MAX(A.FM_NOD_CD) FM_NOD_CD" ).append("\n"); 
		query.append("              ,MAX(A.TO_NOD_CD) TO_NOD_CD" ).append("\n"); 
		query.append("              ,MAX(EDI.BIL_EDI_SNT_DT) BIL_EDI_SNT_DT" ).append("\n"); 
		query.append("          FROM TRS_TRSP_RAIL_BIL_VNDR_SET A" ).append("\n"); 
		query.append("              ,MDM_VENDOR                 B" ).append("\n"); 
		query.append("              ,TRS_TRSP_RAIL_BIL_ORD      C" ).append("\n"); 
		query.append("              ,TRS_TRSP_EDI_TMP           TMP" ).append("\n"); 
		query.append("              ,TRS_TRSP_EDI_RAIL_ORD      EDI" ).append("\n"); 
		query.append("              ,TRS_AGMT_HDR               AGMT" ).append("\n"); 
		query.append("              ,PRD_INLND_ROUT_DTL         PRD" ).append("\n"); 
		query.append("              ,PRD_INLND_ROUT_MST         MST" ).append("\n"); 
		query.append("         WHERE TMP.TRSP_EDI_SND_NO = @[strsp_edi_snd_no]" ).append("\n"); 
		query.append("           AND A.TRSP_SO_OFC_CTY_CD = TMP.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_SO_SEQ = TMP.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("           AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND C.ROUT_ORG_NOD_CD = PRD.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("           AND C.ROUT_DEST_NOD_CD = PRD.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("           AND C.ROUT_SEQ = PRD.ROUT_SEQ" ).append("\n"); 
		query.append("           AND A.ROUT_DTL_SEQ = PRD.ROUT_DTL_SEQ" ).append("\n"); 
		query.append("           AND MST.ROUT_ORG_NOD_CD = PRD.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("           AND MST.ROUT_DEST_NOD_CD = PRD.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("           AND MST.ROUT_SEQ = PRD.ROUT_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_SO_OFC_CTY_CD = EDI.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.TRSP_SO_SEQ = EDI.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND A.TRSP_AGMT_SEQ = AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("           AND B.VNDR_SEQ = EDI.VNDR_SEQ" ).append("\n"); 
		query.append("           AND C.RAIL_CMB_THRU_TP_CD IN ('S2R', 'S3R')" ).append("\n"); 
		query.append("           AND EDI.BIL_ISS_KNT = (SELECT MAX(BIL_ISS_KNT)" ).append("\n"); 
		query.append("                                    FROM TRS_TRSP_EDI_RAIL_ORD E" ).append("\n"); 
		query.append("                                   WHERE EDI.TRSP_SO_OFC_CTY_CD = E.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                     AND EDI.TRSP_SO_SEQ = E.TRSP_SO_SEQ)" ).append("\n"); 
		query.append("         GROUP BY A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                 ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                 ,A.VNDR_SEQ" ).append("\n"); 
		query.append("                 ,B.USA_EDI_CD" ).append("\n"); 
		query.append("                 ,A.TO_NOD_CD" ).append("\n"); 
		query.append("                 ,PRD.INLND_ROUT_JUNC_NM" ).append("\n"); 
		query.append("                 ,MST.ROUT_PLN_CD" ).append("\n"); 
		query.append("                 ,A.RAIL_CRR_TP_CD) O," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("            SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, SUM(NVL(WGT, 0)) BL_WGT" ).append("\n"); 
		query.append("              FROM (SELECT /*+ LEADING(STMP) USE_NL(A) USE_NL(BC B B1)*/" ).append("\n"); 
		query.append("                 STMP.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                ,STMP.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                ,DECODE(BC.WGT_UT_CD,'KGS', NVL(BC.CNTR_WGT, 0), TRS_COMMON_PKG.GET_CONV_WGT_TO_KGS_FNC(BC.WGT_UT_CD, BC.CNTR_WGT)) WGT" ).append("\n"); 
		query.append("                  FROM BKG_CONTAINER         BC" ).append("\n"); 
		query.append("                    ,BKG_BOOKING           B" ).append("\n"); 
		query.append("                    ,BKG_BOOKING           B1" ).append("\n"); 
		query.append("                    ,TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("                    ,TRS_TRSP_EDI_TMP      STMP" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND STMP.TRSP_EDI_SND_NO = @[strsp_edi_snd_no]" ).append("\n"); 
		query.append("                   AND A.TRSP_SO_OFC_CTY_CD = STMP.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND A.TRSP_SO_SEQ = STMP.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_RAIL_BIL_ORD O, SCE_COP_HDR M, SCE_COP_HDR S" ).append("\n"); 
		query.append("                     WHERE O.TRSP_SO_OFC_CTY_CD = STMP.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                       AND O.TRSP_SO_SEQ = STMP.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                       AND O.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                       AND NVL(O.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                       AND S.COP_NO = O.COP_NO" ).append("\n"); 
		query.append("                       AND S.MST_COP_NO = M.COP_NO" ).append("\n"); 
		query.append("                       AND M.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                       AND ROWNUM = 1)" ).append("\n"); 
		query.append("                   AND B.BKG_NO <> B1.BKG_NO" ).append("\n"); 
		query.append("                   AND B.VSL_CD = B1.VSL_CD" ).append("\n"); 
		query.append("                   AND B.SKD_VOY_NO = B1.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND B.SKD_DIR_CD = B1.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND B1.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                   AND BC.CNTR_NO = A.EQ_NO" ).append("\n"); 
		query.append("                   AND B1.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                   AND (B1.BKG_STS_CD = 'W' OR B1.BKG_STS_CD = 'F')" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT /*+ LEADING(STMP) USE_NL(O) USE_NL(BC)*/" ).append("\n"); 
		query.append("                 STMP.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                ,STMP.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                ,DECODE(BC.WGT_UT_CD,'KGS', NVL(BC.CNTR_WGT, 0),TRS_COMMON_PKG.GET_CONV_WGT_TO_KGS_FNC(BC.WGT_UT_CD, BC.CNTR_WGT)) WGT" ).append("\n"); 
		query.append("                  FROM TRS_TRSP_RAIL_BIL_ORD O, TRS_TRSP_EDI_TMP STMP, BKG_CONTAINER BC" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND STMP.TRSP_EDI_SND_NO = @[strsp_edi_snd_no]" ).append("\n"); 
		query.append("                   AND STMP.TRSP_SO_OFC_CTY_CD = O.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND STMP.TRSP_SO_SEQ = O.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                   AND O.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                   AND NVL(O.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                   AND O.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                   AND O.EQ_NO = BC.CNTR_NO)" ).append("\n"); 
		query.append("             GROUP BY TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ" ).append("\n"); 
		query.append("          ) BL" ).append("\n"); 
		query.append(" WHERE A.TRSP_SO_OFC_CTY_CD = O.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ = O.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND A.TRSP_SO_OFC_CTY_CD = BL.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ = BL.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.EQ_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND A.BL_NO = AI.BL_NO(+)" ).append("\n"); 
		query.append("   AND 'US' = AI.CNT_CD(+)" ).append("\n"); 
		query.append("   AND O.FM_NOD_CD = I.YD_CD" ).append("\n"); 
		query.append("   AND O.TO_NOD_CD = K.YD_CD" ).append("\n"); 
		query.append("   AND A.BKG_NO = M.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.EQ_NO = M.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.BL_NO = CND.BL_NO(+)" ).append("\n"); 
		query.append("   AND K.OFC_CD = ROFC.OFC_CD(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = TM.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.POL_NOD_CD = TM.CLZ_YD_CD(+)" ).append("\n"); 
		query.append("   AND TM.CLZ_TP_CD(+) = 'T'" ).append("\n"); 
		query.append("   AND DECODE(K.OFC_CD, ROFC.OFC_CD, ROFC.CTRL_OFC_CD, K.OFC_CD) = OFC.OFC_CD" ).append("\n"); 
		query.append("   AND DECODE(A.TRSP_BND_CD, 'I', DECODE(SUBSTR(A.TO_NOD_CD, 1, 2), 'US', 'US', 'CA', 'CA', ''), 'O', DECODE(SUBSTR(A.FM_NOD_CD, 1, 2), 'US', 'US', 'CA', 'CA', ''), '') = CND.CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("   AND A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 

	}
}