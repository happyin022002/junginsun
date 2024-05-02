/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchEdiCustTpIdAftRlseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchEdiCustTpIdAftRlseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOsearchEdiCustTpIdAftRlseRSQL
	  * 
	  * 2016.05.18
	  * [CHM-201641139] GTN 중복 transaction block 처리 (CHM-201006030 처리로직 원복)
	  * 
	  * 2016.06.21
	  * [CHM-201642250] GTN 중복 transaction block 로직 보완
	  * 현재의 “304(SI) 가 GTN으로부터 왔을 때만 TRADIANT 로 전송”을
	  *  “304(SI)가 Offline, E-mail (Simple SI), EDI로 전송되었을 경우 TRADIANT로 전송”으로 변경. 
	  * 즉, “304(SI) 가 Inttra, Cargosmart 등 타 Portal로 접수되었을 경우에만 
	  * TRADIANT 전송을 제한”하는 것으로 변경
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchEdiCustTpIdAftRlseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchEdiCustTpIdAftRlseRSQL").append("\n"); 
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
		query.append("SELECT EDI.BKG_NO " ).append("\n"); 
		query.append("      ,GROUP_ID" ).append("\n"); 
		query.append("      ,RCV_ID" ).append("\n"); 
		query.append("      ,REF_CODE " ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT DISTINCT " ).append("\n"); 
		query.append("          MST.BKG_NO" ).append("\n"); 
		query.append("        , GROUP_EDI_ID GROUP_ID" ).append("\n"); 
		query.append("        , EDI_RECEIVE_ID RCV_ID" ).append("\n"); 
		query.append("        , REF_CODE" ).append("\n"); 
		query.append("      FROM    " ).append("\n"); 
		query.append("        (SELECT BKG_NO" ).append("\n"); 
		query.append("            , MIN(RANK) RANK" ).append("\n"); 
		query.append("            , GROUP_EDI_ID" ).append("\n"); 
		query.append("            , EDI_RECEIVE_ID" ).append("\n"); 
		query.append("            , REF_CODE" ).append("\n"); 
		query.append("          FROM " ).append("\n"); 
		query.append("            (SELECT  BK.BKG_NO" ).append("\n"); 
		query.append("                    , MIN(TP_RANK.RANK) RANK" ).append("\n"); 
		query.append("                    , EDI_BY_CUST.GROUP_EDI_ID" ).append("\n"); 
		query.append("                    , EDI_BY_CUST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                    , 'D' AS REF_CODE" ).append("\n"); 
		query.append("              FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("                    , BKG_BOOKING BK" ).append("\n"); 
		query.append("                    , (SELECT GRP.ESVC_GRP_CD                     GROUP_EDI_ID" ).append("\n"); 
		query.append("                             , GRP.CUST_TRD_PRNR_ID               EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                             , GRP_CUST.CNT_CD   " ).append("\n"); 
		query.append("                             , GRP_CUST.CUST_SEQ" ).append("\n"); 
		query.append("                             , GRP_CUST.BKG_CUST_TP_DESC " ).append("\n"); 
		query.append("                       FROM BKG_EDI_GRP_CUST GRP_CUST, BKG_EDI_GRP GRP" ).append("\n"); 
		query.append("                      WHERE GRP.ESVC_GRP_CD         = GRP_CUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                        AND GRP.CO_CD               = GRP_CUST.CO_CD" ).append("\n"); 
		query.append("                        AND GRP.CO_CD               = 'H'" ).append("\n"); 
		query.append("                        AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                        AND GRP_CUST.CNT_CD         > ' '" ).append("\n"); 
		query.append("                        AND GRP_CUST.CUST_SEQ       > 0" ).append("\n"); 
		query.append("                        AND GRP_CUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                        AND GRP_CUST.BL_DRFT_FLG    = 'Y'       " ).append("\n"); 
		query.append("                        AND GRP_CUST.BL_DRFT_AUTO_FLG = 'Y'" ).append("\n"); 
		query.append("                        AND GRP_CUST.BL_DRFT_AUTO_DYS < 1     " ).append("\n"); 
		query.append("                        AND GRP_CUST.BL_DRFT_AUTO_ONCE_SND_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        ) EDI_BY_CUST               " ).append("\n"); 
		query.append("                    , (SELECT 'S' RCV_TP, '1SH' RANK FROM DUAL " ).append("\n"); 
		query.append("                       UNION SELECT 'C' RCV_TP, '2CN' RANK FROM DUAL " ).append("\n"); 
		query.append("                       UNION SELECT 'N' RCV_TP, '3NF' RANK FROM DUAL " ).append("\n"); 
		query.append("                       UNION SELECT 'F' RCV_TP, '4FF' RANK FROM DUAL " ).append("\n"); 
		query.append("                       UNION SELECT 'A' RCV_TP, '5AN' RANK FROM DUAL " ).append("\n"); 
		query.append("                       UNION SELECT 'E' RCV_TP, '6EX' RANK FROM DUAL) TP_RANK" ).append("\n"); 
		query.append("             WHERE EDI_BY_CUST.CNT_CD   = CUST.CUST_CNT_CD " ).append("\n"); 
		query.append("               AND EDI_BY_CUST.CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("               AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("               AND CUST.BKG_CUST_TP_CD = TP_RANK.RCV_TP" ).append("\n"); 
		query.append("               AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND DECODE(BKG_CUST_TP_DESC,'ALL','ALL',CUST.BKG_CUST_TP_CD)" ).append("\n"); 
		query.append("                                   IN (SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                                         FROM TABLE(BKG_SPLIT_FNC(BKG_CUST_TP_DESC,',')))" ).append("\n"); 
		query.append("             GROUP BY BK.BKG_NO" ).append("\n"); 
		query.append("                    , EDI_BY_CUST.GROUP_EDI_ID" ).append("\n"); 
		query.append("                    , EDI_BY_CUST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                    , EDI_BY_CUST.CNT_CD||EDI_BY_CUST.CUST_SEQ" ).append("\n"); 
		query.append("             UNION" ).append("\n"); 
		query.append("              SELECT BK.BKG_NO" ).append("\n"); 
		query.append("                    , '7SC' RANK" ).append("\n"); 
		query.append("                    , EDI_BY_SC.GROUP_EDI_ID" ).append("\n"); 
		query.append("                    , EDI_BY_SC.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                    , 'D' AS REF_CODE" ).append("\n"); 
		query.append("              FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                    , (SELECT  GRP.ESVC_GRP_CD           GROUP_EDI_ID" ).append("\n"); 
		query.append("                             , GRP.CUST_TRD_PRNR_ID     EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                             , GRP_CUST.SC_NO" ).append("\n"); 
		query.append("                             , GRP_CUST.BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("                       FROM BKG_EDI_GRP GRP, BKG_EDI_GRP_CUST GRP_CUST" ).append("\n"); 
		query.append("                      WHERE GRP.ESVC_GRP_CD         = GRP_CUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                        AND GRP.CO_CD               = GRP_CUST.CO_CD      " ).append("\n"); 
		query.append("                        AND GRP.CO_CD               = 'H'" ).append("\n"); 
		query.append("                        AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                        AND GRP_CUST.SC_NO          > ' '              " ).append("\n"); 
		query.append("                        AND GRP_CUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                        AND GRP_CUST.BL_DRFT_FLG    = 'Y'       " ).append("\n"); 
		query.append("                        AND GRP_CUST.BL_DRFT_AUTO_FLG = 'Y'     " ).append("\n"); 
		query.append("                        AND GRP_CUST.BL_DRFT_AUTO_DYS < 1  " ).append("\n"); 
		query.append("                        AND GRP_CUST.BL_DRFT_AUTO_ONCE_SND_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        ) EDI_BY_SC" ).append("\n"); 
		query.append("             WHERE EDI_BY_SC.SC_NO  = DECODE(EDI_BY_SC.BKG_CTRT_TP_CD, '1', BK.SC_NO, '2', BK.RFA_NO)" ).append("\n"); 
		query.append("               AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         GROUP BY BKG_NO" ).append("\n"); 
		query.append("            , GROUP_EDI_ID" ).append("\n"); 
		query.append("            , EDI_RECEIVE_ID" ).append("\n"); 
		query.append("            , REF_CODE) MST, BKG_BOOKING BK" ).append("\n"); 
		query.append("      WHERE BK.BKG_NO = MST.BKG_NO " ).append("\n"); 
		query.append("        AND 'YES' = CASE WHEN BK.XTER_SI_CD IN ('INT','CSM') AND EDI_RECEIVE_ID = 'TRADIANT' THEN 'NO'" ).append("\n"); 
		query.append("                         WHEN BK.XTER_SI_CD <> 'CSM' AND EDI_RECEIVE_ID = 'CARGOSMART' THEN 'NO' /* 이병동씨 요청 */" ).append("\n"); 
		query.append("                         WHEN BK.XTER_SI_CD <> 'INT' AND (EDI_RECEIVE_ID = 'INTTRA' OR EDI_RECEIVE_ID = 'INTTRANG2') THEN 'NO'" ).append("\n"); 
		query.append("                          /* CARGOSMART 는 DPCS 대상인건의 경우 'QA' 완료일때 전송 이지영과장님 요청 */" ).append("\n"); 
		query.append("                         WHEN BK.BKG_OFC_CD NOT IN ('HKGSC', 'SZPSC', 'XMNSC')" ).append("\n"); 
		query.append("                              AND NVL((SELECT 'Y' FROM BKG_SR_CRNT_RQST WHERE BKG_NO = BK.BKG_NO AND BL_AUD_FLG = 'Y' AND ROWNUM = 1 ),'N') <> 'Y'" ).append("\n"); 
		query.append("                              AND (EDI_RECEIVE_ID = 'CARGOSMART' " ).append("\n"); 
		query.append("                              AND NVL((SELECT 'Y' FROM BKG_SR_CRNT_RQST WHERE BKG_NO = BK.BKG_NO AND SR_AMD_TP_CD = 'O' AND ROWNUM = 1),'N') = 'Y') THEN 'NO' " ).append("\n"); 
		query.append("                         /* CARGOSMART 인 경우라도 'HKGSC', 'SZPSC', 'XMNSC' 경우에는 BKG AUDIT완료되어있으면 전송 황일균부장님 요청 */" ).append("\n"); 
		query.append("                         WHEN EDI_RECEIVE_ID = 'CARGOSMART' " ).append("\n"); 
		query.append("                              AND BK.BKG_OFC_CD IN ('HKGSC', 'SZPSC', 'XMNSC')" ).append("\n"); 
		query.append("                              AND NVL((SELECT AUD_STS_CD FROM BKG_RATE WHERE BKG_NO = BK.BKG_NO),'N') != 'Y' THEN 'NO'" ).append("\n"); 
		query.append("                         ELSE 'YES' END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                      FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("                     WHERE RT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                       AND RT.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("                     UNION	" ).append("\n"); 
		query.append("                     SELECT 'X'" ).append("\n"); 
		query.append("                       FROM BKG_RATE RT" ).append("\n"); 
		query.append("                      WHERE RT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                        AND RT.RT_BL_TP_CD ='C' " ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        FROM BKG_BOOKING " ).append("\n"); 
		query.append("                        WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                          AND PORT_CLZ_DT <= TRUNC(SYSDATE))" ).append("\n"); 
		query.append("        AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                          FROM BKG_BOOKING A, BKG_NTC_HIS NTC" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND A.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                           AND A.PORT_CLZ_DT <= TRUNC(SYSDATE)" ).append("\n"); 
		query.append("                           AND A.BKG_NO = NTC.BKG_NO" ).append("\n"); 
		query.append("                           AND NTC.NTC_VIA_CD ='E'" ).append("\n"); 
		query.append("                           AND NTC.NTC_KND_CD ='BL'" ).append("\n"); 
		query.append("                           AND NTC.SND_USR_ID = 'SYSTEM'" ).append("\n"); 
		query.append("                           AND NTC.EDI_ID = EDI_RECEIVE_ID                " ).append("\n"); 
		query.append("                         ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) EDI" ).append("\n"); 
		query.append("    ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("WHERE ISS.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND ISS.BKG_NO = EDI.BKG_NO" ).append("\n"); 
		query.append("#if (${bl_chg_flg} != 'Y') " ).append("\n"); 
		query.append("  AND ISS.OBL_RLSE_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}