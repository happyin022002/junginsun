/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchWebServiceProcessTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchWebServiceProcessTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Job Type, BKG Block Flag, Manual Flag 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchWebServiceProcessTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchWebServiceProcessTypeRSQL").append("\n"); 
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
		query.append("SELECT JOB_TP," ).append("\n"); 
		query.append("       BKG_BLCK_FLG," ).append("\n"); 
		query.append("       MANUAL_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT JOB_TP," ).append("\n"); 
		query.append("               BKG_BLCK_FLG," ).append("\n"); 
		query.append("               CASE WHEN CCT_FLG = 'Y'      OR SI_FLG = 'Y'         OR SPCL_FLG = 'Y' OR " ).append("\n"); 
		query.append("                         OB_SO_FLG = 'Y'    OR RAIL_SO_FLG = 'Y'    OR MTDT_FLG = 'Y' OR " ).append("\n"); 
		query.append("                         TRO_FLG = 'Y'      OR EUR_TRO_FLG = 'Y'    OR BKG_BLCK_FLG = 'Y' OR" ).append("\n"); 
		query.append("                         PND_FLG = 'Y'      OR TRO_CFM_FLG = 'Y'    OR EUR_TRO_CFM_FLG = 'Y' OR" ).append("\n"); 
		query.append("                         BKG_STS_FLG = 'Y'  OR SOC_QTY_FLG = 'Y'    OR CMDT_CD_FLG = 'Y' OR" ).append("\n"); 
		query.append("                         NON_DG_CHM_FLG = 'Y' OR US_BLCK_FLG = 'Y'  OR NG_BLCK_FLG = 'Y' OR " ).append("\n"); 
		query.append("						 SREP_CD ='Y'" ).append("\n"); 
		query.append("                    THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("               END MANUAL_FLG" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT NVL((SELECT 'U' " ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("                            WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("                            AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("                            AND XTER_RQST_SEQ < M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                            AND BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("                            AND ROWNUM = 1), 'C' )  JOB_TP,  -- 접수된 BKG Request가 Creation/Update 대상인지 판단" ).append("\n"); 
		query.append("                       DECODE(B.BKG_STS_CD,'W','Y','X','Y','N') BKG_STS_FLG," ).append("\n"); 
		query.append("                       NVL((SELECT 'Y' " ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("                            WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("                            AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("                            AND XTER_RQST_SEQ < M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                            AND BKG_UPLD_STS_CD = 'P'" ).append("\n"); 
		query.append("                            AND ROWNUM = 1), 'N') PND_FLG," ).append("\n"); 
		query.append("                        NVL((SELECT CASE WHEN SYS_SET_DT < M.RQST_DT THEN 'Y'" ).append("\n"); 
		query.append("                                         ELSE 'N'" ).append("\n"); 
		query.append("                                    END RSLT" ).append("\n"); 
		query.append("                             FROM BKG_CLZ_TM" ).append("\n"); 
		query.append("                             WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                             AND CLZ_TP_CD = 'T'), 'N') CCT_FLG,  -- CCT가 지나서 접수된 BKG" ).append("\n"); 
		query.append("                        NVL(CASE WHEN B.MTY_PKUP_DT < M.RQST_DT THEN 'Y'" ).append("\n"); 
		query.append("                                 ELSE 'N'" ).append("\n"); 
		query.append("                            END, 'N') MTDT_FLG,                   -- MT Pickup" ).append("\n"); 
		query.append("                        NVL(B.SI_FLG, 'N') SI_FLG,                -- SI 진행한 BKG" ).append("\n"); 
		query.append("                        CASE WHEN B.DCGO_FLG = 'Y' OR B.RC_FLG = 'Y' OR B.AWK_CGO_FLG = 'Y' OR B.BB_CGO_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                             ELSE 'N'" ).append("\n"); 
		query.append("                        END SPCL_FLG,                             -- Special Cargo가 포함된 BKG" ).append("\n"); 
		query.append("                        (SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END AS RSLT" ).append("\n"); 
		query.append("                         FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                         WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                         AND NVL(TRSP_FRST_FLG, 'X') <> 'Y'" ).append("\n"); 
		query.append("                         AND TRSP_BND_CD  = 'O'" ).append("\n"); 
		query.append("                         AND TRSP_SO_TP_CD = 'Y') OB_SO_FLG,      -- SO가 발행된 BKG" ).append("\n"); 
		query.append("                        (SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END AS RSLT" ).append("\n"); 
		query.append("                         FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("                         WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                         AND NVL(TRSP_FRST_FLG, 'X') <> 'Y') RAIL_SO_FLG, -- SO가 발행된 BKG" ).append("\n"); 
		query.append("                        (SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END AS RSLT" ).append("\n"); 
		query.append("                         FROM BKG_TRO" ).append("\n"); 
		query.append("                         WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                         AND CXL_FLG = 'Y') TRO_FLG,                   -- HJS Staff이 TRO Cancel한 경우" ).append("\n"); 
		query.append("                        (SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END AS RSLT" ).append("\n"); 
		query.append("                         FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("                         WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                         AND CXL_FLG = 'Y') EUR_TRO_FLG,                 -- HJS Staff이 TRO Cancel한 경우" ).append("\n"); 
		query.append("                        (SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END AS RSLT" ).append("\n"); 
		query.append("                         FROM BKG_TRO" ).append("\n"); 
		query.append("                         WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                         AND CFM_FLG = 'Y') TRO_CFM_FLG,                   -- HJS Staff이 TRO Confirm한 경우" ).append("\n"); 
		query.append("                        (SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END AS RSLT" ).append("\n"); 
		query.append("                         FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("                         WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                         AND CFM_FLG = 'Y') EUR_TRO_CFM_FLG,                 -- HJS Staff이 TRO Confirm한 경우" ).append("\n"); 
		query.append("                        (SELECT CASE WHEN SUM(SOC_QTY) = 0  THEN 'N'" ).append("\n"); 
		query.append("                                     WHEN SUM(CNTR_QTY) <> SUM(SOC_QTY) THEN 'Y'" ).append("\n"); 
		query.append("                                     ELSE 'N' " ).append("\n"); 
		query.append("                                END RESULT" ).append("\n"); 
		query.append("                         FROM BKG_XTER_QTY Q" ).append("\n"); 
		query.append("                         WHERE Q.XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("                         AND Q.XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("                         AND Q.XTER_RQST_SEQ = M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                        ) SOC_QTY_FLG," ).append("\n"); 
		query.append("                        (SELECT CASE WHEN  COUNT(1) > 0 THEN 'Y' ELSE 'N' END AS RESULT" ).append("\n"); 
		query.append("                         FROM BKG_HRD_CDG_CTNT H" ).append("\n"); 
		query.append("                         WHERE H.HRD_CDG_ID = 'WEB_BKG_BLOCK'" ).append("\n"); 
		query.append("                         AND H.ATTR_CTNT1 = 'NON_DG_CHM'" ).append("\n"); 
		query.append("                         AND H.ATTR_CTNT2 = M.CMDT_CD" ).append("\n"); 
		query.append("                        ) NON_DG_CHM_FLG," ).append("\n"); 
		query.append("                       CASE WHEN ( M.POR_CD LIKE 'US%' OR (M.POR_CD LIKE 'CA%' AND M.BKG_OFC_CD IN ('NYCSC','ATLSC','PHXSA','SEASC'))) " ).append("\n"); 
		query.append("							  AND ( M.BKG_OFC_CD NOT IN ('NYCSC','ATLSC','PHXSA','SEASC')                                    " ).append("\n"); 
		query.append("                                    OR (M.BKG_OFC_CD IN ('ATLSC','PHXSA','SEASC') AND M.RCV_TERM_CD <>'Y') " ).append("\n"); 
		query.append("                                    OR (M.BKG_OFC_CD ='NYCSC' AND M.RCV_TERM_CD = 'D')) " ).append("\n"); 
		query.append("                                     THEN 'Y'" ).append("\n"); 
		query.append("                              ELSE 'N'" ).append("\n"); 
		query.append("                        END US_BLCK_FLG," ).append("\n"); 
		query.append("						 CASE WHEN ( M.POD_CD LIKE 'NG%' OR M.POD_CD = 'LAGOS' )" ).append("\n"); 
		query.append("                                     THEN 'Y'" ).append("\n"); 
		query.append("                              ELSE 'N'" ).append("\n"); 
		query.append("                         END NG_BLCK_FLG, -- POD : 나이지리아, LAGOS 인 경우" ).append("\n"); 
		query.append("                        NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                             FROM BKG_SYS_UPLD_BLCK_STUP S" ).append("\n"); 
		query.append("                             WHERE S.BKG_OFC_CD = M.BKG_OFC_CD" ).append("\n"); 
		query.append("                             AND S.DELT_FLG = 'N'    -- 셋업에 VVD나 Lane이 입력된 경우에는 Departure Date로 접수된 BKG 을 Block 시킴" ).append("\n"); 
		query.append("                             AND (V.VSL_SLAN_CD IS NULL OR NVL(S.VSL_SLAN_CD, V.VSL_SLAN_CD) = V.VSL_SLAN_CD)" ).append("\n"); 
		query.append("                             AND (V.VSL_SLAN_CD IS NULL OR NVL(S.LODG_DIR_CD, M.SKD_DIR_CD) = M.SKD_DIR_CD)" ).append("\n"); 
		query.append("                             AND (M.VSL_CD IS NULL OR NVL(S.VSL_CD, M.VSL_CD) = M.VSL_CD)" ).append("\n"); 
		query.append("                             AND (M.SKD_VOY_NO IS NULL OR NVL(S.SKD_VOY_NO, M.SKD_VOY_NO) = M.SKD_VOY_NO)" ).append("\n"); 
		query.append("                             AND (M.SKD_DIR_CD IS NULL OR NVL(S.DIR_CD, M.SKD_DIR_CD) = M.SKD_DIR_CD)" ).append("\n"); 
		query.append("                             AND NVL(S.CUST_CNT_CD, C.CNT_CD) = C.CNT_CD" ).append("\n"); 
		query.append("                             AND NVL(S.CUST_SEQ, C.CUST_SEQ) = C.CUST_SEQ " ).append("\n"); 
		query.append("                             AND NVL(S.POL_CNT_CD, SUBSTR(M.POL_CD,1,2)) = SUBSTR(M.POL_CD,1,2)" ).append("\n"); 
		query.append("                             AND NVL(S.POL_CD, M.POL_CD) = M.POL_CD" ).append("\n"); 
		query.append("                             AND (M.POD_CD IS NULL OR NVL(S.POD_CNT_CD, SUBSTR(M.POD_CD,1,2)) = SUBSTR(M.POD_CD,1,2))" ).append("\n"); 
		query.append("                             AND (M.POD_CD IS NULL OR NVL(S.POD_CD, M.POD_CD) = M.POD_CD)" ).append("\n"); 
		query.append("                             AND ( " ).append("\n"); 
		query.append("                                   S.XTER_RMK IS NULL" ).append("\n"); 
		query.append("                                   OR " ).append("\n"); 
		query.append("                                   INSTR(UPPER(M.XTER_BKG_RMK1), UPPER(S.XTER_RMK)) > 0" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                                AND ROWNUM = 1" ).append("\n"); 
		query.append("                         ), 'N') BKG_BLCK_FLG                      -- Setup 테이블에 의해 Block 시킴" ).append("\n"); 
		query.append("						, CASE WHEN M.CMDT_CD IS NULL THEN 'Y' ELSE 'N' END AS CMDT_CD_FLG" ).append("\n"); 
		query.append("						, NVL((SELECT 'N'" ).append("\n"); 
		query.append("                                  FROM (SELECT RESPB_SREP_CD" ).append("\n"); 
		query.append("                                          FROM (SELECT /*+ INDEX DESC (B XAK3BKG_BOOKING) */" ).append("\n"); 
		query.append("                                                  1 rank," ).append("\n"); 
		query.append("                                                       B.OB_SREP_CD RESPB_SREP_CD," ).append("\n"); 
		query.append("                                                       B.OB_SLS_OFC_CD RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("                                                  FROM BKG_XTER_RQST_MST X," ).append("\n"); 
		query.append("                                                       BKG_XTER_CUST XC," ).append("\n"); 
		query.append("                                                       BKG_BOOKING B," ).append("\n"); 
		query.append("                                                       BKG_CUSTOMER C" ).append("\n"); 
		query.append("                                                 WHERE X.XTER_SNDR_ID =@[xter_sndr_id]" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                   AND X.XTER_SNDR_ID = XC.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_NO = XC.XTER_RQST_NO" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_SEQ = XC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                                   AND B.BKG_CRE_DT > SYSDATE -30" ).append("\n"); 
		query.append("                                                   AND B.DCGO_FLG = X.DCGO_FLG" ).append("\n"); 
		query.append("                                                   AND B.RC_FLG = X.RC_FLG" ).append("\n"); 
		query.append("                                                   AND B.AWK_CGO_FLG = X.AWK_CGO_FLG" ).append("\n"); 
		query.append("                                                   AND B.BB_CGO_FLG = X.BB_CGO_FLG" ).append("\n"); 
		query.append("                                                   AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                                                   AND B.POR_CD = X.POR_CD" ).append("\n"); 
		query.append("                                                   AND B.DEL_CD = X.DEL_CD" ).append("\n"); 
		query.append("                                                   AND (B.SC_NO = X.CTRT_NO" ).append("\n"); 
		query.append("                                                            OR B.RFA_NO = X.CTRT_NO" ).append("\n"); 
		query.append("                                                            OR B.TAA_NO = X.CTRT_NO)" ).append("\n"); 
		query.append("                                                   AND ( C.BKG_CUST_TP_CD = XC.XTER_CUST_TP_CD" ).append("\n"); 
		query.append("                                                           AND C.CUST_CNT_CD = XC.CNT_CD" ).append("\n"); 
		query.append("                                                           AND C.CUST_SEQ = XC.CUST_SEQ)" ).append("\n"); 
		query.append("                                                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                 UNION ALL" ).append("\n"); 
		query.append("                                                 SELECT /*+ INDEX DESC (B XAK3BKG_BOOKING) */" ).append("\n"); 
		query.append("                                                  2 rank," ).append("\n"); 
		query.append("                                                       B.OB_SREP_CD RESPB_SREP_CD," ).append("\n"); 
		query.append("                                                       B.OB_SLS_OFC_CD RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("                                                  FROM BKG_XTER_RQST_MST X," ).append("\n"); 
		query.append("                                                       BKG_XTER_CUST XC," ).append("\n"); 
		query.append("                                                       BKG_BOOKING B," ).append("\n"); 
		query.append("                                                       BKG_CUSTOMER C" ).append("\n"); 
		query.append("                                                 WHERE X.XTER_SNDR_ID =@[xter_sndr_id]" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                   AND X.XTER_SNDR_ID = XC.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_NO = XC.XTER_RQST_NO" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_SEQ = XC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                                   AND B.BKG_CRE_DT > SYSDATE -30" ).append("\n"); 
		query.append("                                                   AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                                                   AND B.POR_CD = X.POR_CD" ).append("\n"); 
		query.append("                                                   AND B.DEL_CD = X.DEL_CD" ).append("\n"); 
		query.append("                                                   AND (B.SC_NO = X.CTRT_NO" ).append("\n"); 
		query.append("                                                            OR B.RFA_NO = X.CTRT_NO" ).append("\n"); 
		query.append("                                                            OR B.TAA_NO = X.CTRT_NO)" ).append("\n"); 
		query.append("                                                   AND ( C.BKG_CUST_TP_CD = XC.XTER_CUST_TP_CD" ).append("\n"); 
		query.append("                                                           AND C.CUST_CNT_CD = XC.CNT_CD" ).append("\n"); 
		query.append("                                                           AND C.CUST_SEQ = XC.CUST_SEQ)" ).append("\n"); 
		query.append("                                                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                 UNION ALL" ).append("\n"); 
		query.append("                                                 SELECT 2.5 rank," ).append("\n"); 
		query.append("                                                       'USA0X' RESPB_SREP_CD ," ).append("\n"); 
		query.append("                                                       'NYCMW' RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("                                                  FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("                                                       BKG_HNDL_OFC_STUP HOS," ).append("\n"); 
		query.append("                                                       BKG_XTER_CUST CUST" ).append("\n"); 
		query.append("                                                 WHERE MST.XTER_SNDR_ID =@[xter_sndr_id]" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                   AND MST.XTER_SNDR_ID = CUST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_NO = CUST.XTER_RQST_NO" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_SEQ = CUST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                                   AND CUST.XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                                                   AND CUST.CNT_CD||LPAD(CUST.CUST_SEQ, 6, 0) !='US063664'" ).append("\n"); 
		query.append("                                                   AND upper(MST.CMDT_DESC) LIKE '%'||HOS.CMDT_NM||'%'" ).append("\n"); 
		query.append("                                                   AND HOS.CMDT_NM NOT LIKE '%'||'WASTE'||'%'" ).append("\n"); 
		query.append("                                                   AND HOS.CMDT_NM IS NOT NULL" ).append("\n"); 
		query.append("                                                   AND MST.POL_CD LIKE 'US%'" ).append("\n"); 
		query.append("                                                 UNION ALL" ).append("\n"); 
		query.append("                                                 SELECT 2.6 rank," ).append("\n"); 
		query.append("                                                       'USA0F' RESPB_SREP_CD ," ).append("\n"); 
		query.append("                                                       'NYCWP' RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("                                                  FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("                                                       BKG_HNDL_OFC_STUP HOS," ).append("\n"); 
		query.append("                                                       BKG_XTER_CUST CUST" ).append("\n"); 
		query.append("                                                 WHERE MST.XTER_SNDR_ID =@[xter_sndr_id]" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                   AND MST.XTER_SNDR_ID = CUST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_NO = CUST.XTER_RQST_NO" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_SEQ = CUST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                                   AND CUST.XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                                                   AND CUST.CNT_CD||LPAD(CUST.CUST_SEQ, 6, 0) !='US063664'" ).append("\n"); 
		query.append("                                                   AND upper(MST.CMDT_DESC) LIKE '%'||HOS.CMDT_NM||'%'" ).append("\n"); 
		query.append("                                                   AND HOS.CMDT_NM LIKE '%'||'WASTE'||'%'" ).append("\n"); 
		query.append("                                                   AND HOS.CMDT_NM IS NOT NULL" ).append("\n"); 
		query.append("                                                   AND MST.POL_CD LIKE 'US%'" ).append("\n"); 
		query.append("                                                 UNION ALL" ).append("\n"); 
		query.append("                                                 SELECT 3 rank," ).append("\n"); 
		query.append("                                                       SREP.SREP_CD RESPB_SREP_CD," ).append("\n"); 
		query.append("                                                       OFC_CD RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("                                                  FROM PRI_SP_HDR SH," ).append("\n"); 
		query.append("                                                       PRI_SP_MN SM," ).append("\n"); 
		query.append("                                                       BKG_XTER_RQST_MST X," ).append("\n"); 
		query.append("                                                       VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("                                                       (SELECT SLS.OFC_CD," ).append("\n"); 
		query.append("                                                               CUST.SREP_CD" ).append("\n"); 
		query.append("                                                          FROM BKG_XTER_CUST XTER," ).append("\n"); 
		query.append("                                                               MDM_CUSTOMER CUST," ).append("\n"); 
		query.append("                                                               MDM_SLS_REP SLS" ).append("\n"); 
		query.append("                                                         WHERE XTER.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                                                           AND CUST.SREP_CD = SLS.SREP_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_CNT_CD = XTER.CNT_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_SEQ = XTER.CUST_SEQ" ).append("\n"); 
		query.append("                                                           AND CUST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                           AND SLS.SREP_STS_CD = 'N'" ).append("\n"); 
		query.append("                                                         UNION ALL" ).append("\n"); 
		query.append("                                                         SELECT SLS.OFC_CD," ).append("\n"); 
		query.append("                                                               CUST.SREP_CD" ).append("\n"); 
		query.append("                                                          FROM BKG_XTER_CUST XTER," ).append("\n"); 
		query.append("                                                               BKG_CUST_SLS_REP CUST," ).append("\n"); 
		query.append("                                                               MDM_SLS_REP SLS," ).append("\n"); 
		query.append("                                                               MDM_CUSTOMER MDM_CUST" ).append("\n"); 
		query.append("                                                         WHERE XTER.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_CNT_CD = XTER.CNT_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_SEQ = XTER.CUST_SEQ" ).append("\n"); 
		query.append("                                                           AND CUST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_CNT_CD = MDM_CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_SEQ = MDM_CUST.CUST_SEQ" ).append("\n"); 
		query.append("                                                           AND CUST.SREP_CD <> MDM_CUST.SREP_CD" ).append("\n"); 
		query.append("                                                           AND CUST.SREP_CD = SLS.SREP_CD" ).append("\n"); 
		query.append("                                                           AND MDM_CUST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                           AND SLS.SREP_STS_CD = 'N') SREP" ).append("\n"); 
		query.append("                                                 WHERE SH.SC_NO = X.CTRT_NO" ).append("\n"); 
		query.append("                                                   AND SH.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("                                                   AND SM.EFF_DT <= NVL(X.RQST_DEP_DT, VPS_ETD_DT)" ).append("\n"); 
		query.append("                                                   AND SM.EXP_DT >= NVL(X.RQST_DEP_DT, VPS_ETD_DT)" ).append("\n"); 
		query.append("                                                   AND X.XTER_SNDR_ID =@[xter_sndr_id]" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                   AND X.VSL_CD = V.VSL_CD(+)" ).append("\n"); 
		query.append("                                                   AND X.SKD_VOY_NO = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                                                   AND X.SKD_DIR_CD = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                                   AND X.POL_CD = V.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                                                   AND SM.RESPB_SREP_CD = SREP.SREP_CD" ).append("\n"); 
		query.append("                                                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                 UNION" ).append("\n"); 
		query.append("                                                 SELECT 3 rank," ).append("\n"); 
		query.append("                                                       SREP.SREP_CD RESPB_SREP_CD," ).append("\n"); 
		query.append("                                                       OFC_CD RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("                                                  FROM PRI_RP_HDR RH," ).append("\n"); 
		query.append("                                                       PRI_RP_MN RM," ).append("\n"); 
		query.append("                                                       BKG_XTER_RQST_MST X," ).append("\n"); 
		query.append("                                                       VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("                                                       (SELECT SLS.OFC_CD," ).append("\n"); 
		query.append("                                                               CUST.SREP_CD" ).append("\n"); 
		query.append("                                                          FROM BKG_XTER_CUST XTER," ).append("\n"); 
		query.append("                                                               MDM_CUSTOMER CUST," ).append("\n"); 
		query.append("                                                               MDM_SLS_REP SLS" ).append("\n"); 
		query.append("                                                         WHERE XTER.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                                                           AND CUST.SREP_CD = SLS.SREP_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_CNT_CD = XTER.CNT_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_SEQ = XTER.CUST_SEQ" ).append("\n"); 
		query.append("                                                           AND CUST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                           AND SLS.SREP_STS_CD = 'N'" ).append("\n"); 
		query.append("                                                         UNION ALL" ).append("\n"); 
		query.append("                                                         SELECT SLS.OFC_CD," ).append("\n"); 
		query.append("                                                               CUST.SREP_CD" ).append("\n"); 
		query.append("                                                          FROM BKG_XTER_CUST XTER," ).append("\n"); 
		query.append("                                                               BKG_CUST_SLS_REP CUST," ).append("\n"); 
		query.append("                                                               MDM_SLS_REP SLS," ).append("\n"); 
		query.append("                                                               MDM_CUSTOMER MDM_CUST" ).append("\n"); 
		query.append("                                                         WHERE XTER.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_CNT_CD = XTER.CNT_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_SEQ = XTER.CUST_SEQ" ).append("\n"); 
		query.append("                                                           AND CUST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_CNT_CD = MDM_CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_SEQ = MDM_CUST.CUST_SEQ" ).append("\n"); 
		query.append("                                                           AND CUST.SREP_CD <> MDM_CUST.SREP_CD" ).append("\n"); 
		query.append("                                                           AND CUST.SREP_CD = SLS.SREP_CD" ).append("\n"); 
		query.append("                                                           AND MDM_CUST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                           AND SLS.SREP_STS_CD = 'N') SREP" ).append("\n"); 
		query.append("                                                 WHERE RH.RFA_NO = X.CTRT_NO" ).append("\n"); 
		query.append("                                                   AND RH.PROP_NO = RM.PROP_NO" ).append("\n"); 
		query.append("                                                   AND RM.EFF_DT <= NVL(X.RQST_DEP_DT, VPS_ETD_DT)" ).append("\n"); 
		query.append("                                                   AND RM.EXP_DT >= NVL(X.RQST_DEP_DT, VPS_ETD_DT)" ).append("\n"); 
		query.append("                                                   AND X.XTER_SNDR_ID =@[xter_sndr_id]" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                   AND X.VSL_CD = V.VSL_CD(+)" ).append("\n"); 
		query.append("                                                   AND X.SKD_VOY_NO = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                                                   AND X.SKD_DIR_CD = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                                   AND X.POL_CD = V.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                                                   AND RM.RESPB_SREP_CD = SREP.SREP_CD" ).append("\n"); 
		query.append("                                                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                 UNION" ).append("\n"); 
		query.append("                                                 SELECT 3 rank," ).append("\n"); 
		query.append("                                                       SREP.SREP_CD RESPB_SREP_CD," ).append("\n"); 
		query.append("                                                       OFC_CD RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("                                                  FROM PRI_TAA_HDR TH," ).append("\n"); 
		query.append("                                                       PRI_TAA_MN TM," ).append("\n"); 
		query.append("                                                       BKG_XTER_RQST_MST X," ).append("\n"); 
		query.append("                                                       VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("                                                       (SELECT SLS.OFC_CD," ).append("\n"); 
		query.append("                                                               CUST.SREP_CD" ).append("\n"); 
		query.append("                                                          FROM BKG_XTER_CUST XTER," ).append("\n"); 
		query.append("                                                               MDM_CUSTOMER CUST," ).append("\n"); 
		query.append("                                                               MDM_SLS_REP SLS" ).append("\n"); 
		query.append("                                                         WHERE XTER.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                                                           AND CUST.SREP_CD = SLS.SREP_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_CNT_CD = XTER.CNT_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_SEQ = XTER.CUST_SEQ" ).append("\n"); 
		query.append("                                                           AND CUST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                           AND SLS.SREP_STS_CD = 'N'" ).append("\n"); 
		query.append("                                                         UNION ALL" ).append("\n"); 
		query.append("                                                         SELECT SLS.OFC_CD," ).append("\n"); 
		query.append("                                                               CUST.SREP_CD" ).append("\n"); 
		query.append("                                                          FROM BKG_XTER_CUST XTER," ).append("\n"); 
		query.append("                                                               BKG_CUST_SLS_REP CUST," ).append("\n"); 
		query.append("                                                               MDM_SLS_REP SLS," ).append("\n"); 
		query.append("                                                               MDM_CUSTOMER MDM_CUST" ).append("\n"); 
		query.append("                                                         WHERE XTER.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                           AND XTER.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_CNT_CD = XTER.CNT_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_SEQ = XTER.CUST_SEQ" ).append("\n"); 
		query.append("                                                           AND CUST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_CNT_CD = MDM_CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                           AND CUST.CUST_SEQ = MDM_CUST.CUST_SEQ" ).append("\n"); 
		query.append("                                                           AND CUST.SREP_CD <> MDM_CUST.SREP_CD" ).append("\n"); 
		query.append("                                                           AND CUST.SREP_CD = SLS.SREP_CD" ).append("\n"); 
		query.append("                                                           AND MDM_CUST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                           AND SLS.SREP_STS_CD = 'N') SREP" ).append("\n"); 
		query.append("                                                 WHERE TH.TAA_NO = X.CTRT_NO" ).append("\n"); 
		query.append("                                                   AND TH.TAA_PROP_NO = TM.TAA_PROP_NO" ).append("\n"); 
		query.append("                                                   AND TM.EFF_DT <= NVL(X.RQST_DEP_DT, VPS_ETD_DT)" ).append("\n"); 
		query.append("                                                   AND TM.EXP_DT >= NVL(X.RQST_DEP_DT, VPS_ETD_DT)" ).append("\n"); 
		query.append("                                                   AND X.XTER_SNDR_ID =@[xter_sndr_id]" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                   AND X.VSL_CD = V.VSL_CD(+)" ).append("\n"); 
		query.append("                                                   AND X.SKD_VOY_NO = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                                                   AND X.SKD_DIR_CD = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                                   AND X.POL_CD = V.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                                                   AND TM.RESPB_SREP_CD = SREP.SREP_CD" ).append("\n"); 
		query.append("                                                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                 UNION ALL" ).append("\n"); 
		query.append("                                                 SELECT 4 RANK," ).append("\n"); 
		query.append("                                                       MC.SREP_CD," ).append("\n"); 
		query.append("                                                       MR.OFC_CD" ).append("\n"); 
		query.append("                                                  FROM BKG_XTER_RQST_MST X," ).append("\n"); 
		query.append("                                                       BKG_XTER_CUST C," ).append("\n"); 
		query.append("                                                       MDM_CUSTOMER MC," ).append("\n"); 
		query.append("                                                       MDM_SLS_REP MR" ).append("\n"); 
		query.append("                                                 where X.XTER_SNDR_ID =@[xter_sndr_id]" ).append("\n"); 
		query.append("                                                   and X.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                                                   and X.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                                                   AND X.XTER_SNDR_ID = C.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_NO = C.XTER_RQST_NO" ).append("\n"); 
		query.append("                                                   AND X.XTER_RQST_SEQ = C.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                                   ANd C.XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                                                   AND MC.SREP_CD = MR.SREP_CD" ).append("\n"); 
		query.append("                                                   AND MC.CUST_CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("                                                   AND MC.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("                                                   AND MC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                   AND MR.SREP_STS_CD = 'N')" ).append("\n"); 
		query.append("                                         WHERE ROWNUM = 1" ).append("\n"); 
		query.append("                                         ORDER BY RANK) ) , 'Y') SREP_CD" ).append("\n"); 
		query.append("                FROM BKG_XTER_RQST_MST M, " ).append("\n"); 
		query.append("                     BKG_XTER_CUST C," ).append("\n"); 
		query.append("                     BKG_BOOKING B," ).append("\n"); 
		query.append("                     VSK_VSL_SKD V" ).append("\n"); 
		query.append("                WHERE M.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                AND M.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                AND M.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                AND M.XTER_SNDR_ID = C.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("                AND M.XTER_RQST_NO = C.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("                AND M.XTER_RQST_SEQ = C.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                AND M.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("                AND M.VSL_CD = V.VSL_CD(+)" ).append("\n"); 
		query.append("                AND M.SKD_VOY_NO = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND M.SKD_DIR_CD = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("        ORDER BY CASE WHEN CCT_FLG = 'Y'      OR SI_FLG = 'Y'         OR SPCL_FLG = 'Y' OR " ).append("\n"); 
		query.append("                         OB_SO_FLG = 'Y'    OR RAIL_SO_FLG = 'Y'    OR MTDT_FLG = 'Y' OR " ).append("\n"); 
		query.append("                         TRO_FLG = 'Y'      OR EUR_TRO_FLG = 'Y'    OR BKG_BLCK_FLG = 'Y' OR" ).append("\n"); 
		query.append("                         PND_FLG = 'Y'      OR TRO_CFM_FLG = 'Y'    OR EUR_TRO_CFM_FLG = 'Y' OR" ).append("\n"); 
		query.append("                         BKG_STS_FLG = 'Y'  OR SOC_QTY_FLG = 'Y'    OR CMDT_CD_FLG = 'Y' OR" ).append("\n"); 
		query.append("                         NON_DG_CHM_FLG = 'Y' OR US_BLCK_FLG = 'Y' " ).append("\n"); 
		query.append("                    THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("               END DESC," ).append("\n"); 
		query.append("               BKG_BLCK_FLG DESC" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}