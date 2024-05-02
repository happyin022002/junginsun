/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchTmnl301RcvIdForAutoSendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchTmnl301RcvIdForAutoSendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vender 301 자동 전송시 rcv_id를 별도로 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchTmnl301RcvIdForAutoSendRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brac",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchTmnl301RcvIdForAutoSendRSQL").append("\n"); 
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
		query.append("WITH RCV_ID AS " ).append("\n"); 
		query.append("       (SELECT DISTINCT SUBSTR(KIND,LENGTHB(KIND)-1,LENGTHB(KIND)) AS NTC_KND_CD" ).append("\n"); 
		query.append("				--CASE WHEN MIN(KIND) LIKE MIN(SUBSTR(KIND,0,LENGTH(KIND)-2))||'%'" ).append("\n"); 
		query.append("                --    THEN SUBSTR(MIN(KIND),LENGTHB(MIN(KIND))-1,LENGTHB(MIN(KIND)))" ).append("\n"); 
		query.append("                --    END AS NTC_KND_CD" ).append("\n"); 
		query.append("             , EDI_RCV_ID" ).append("\n"); 
		query.append("             , EDI_SNDR_ID" ).append("\n"); 
		query.append("             , EDI_REF_CD" ).append("\n"); 
		query.append("          FROM " ).append("\n"); 
		query.append("               (--BKG CONFIRM" ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("					   EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("                     , EY.SNDR_TRD_PRNR_ID AS EDI_SNDR_ID" ).append("\n"); 
		query.append("                     , EY.PRNR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("                     , EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("                     , CD.INTG_CD_VAL_DP_SEQ||CD.INTG_CD_VAL_CTNT AS KIND" ).append("\n"); 
		query.append("            		 , EY.PRNR_SUB_LNK_CD AS EDI_REF_CD" ).append("\n"); 
		query.append("                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("                     , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("                     , BKG_VVD VVD" ).append("\n"); 
		query.append("                     , BKG_BOOKING BK" ).append("\n"); 
		query.append("                     , COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("                     , MDM_LOCATION ML   " ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.BKG_NO   = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("				   AND MSG.MSG_TP_DESC		  = '1'" ).append("\n"); 
		query.append("                   AND MSG.EDI_MSG_TP_ID      = '301'" ).append("\n"); 
		query.append("                   AND BK.POL_CD = ML.LOC_CD" ).append("\n"); 
		query.append("                   AND EY.TRD_PRNR_SUB_LNK_SEQ IN " ).append("\n"); 
		query.append("                        (SELECT TRD_PRNR_SUB_LNK_SEQ FROM BKG_EDI_SUB_LNK_MSG WHERE EDI_MSG_IND_CD ='1') --1:AUTO" ).append("\n"); 
		query.append("                   AND (   (EY.PRNR_SUB_LNK_CD = BK.POL_NOD_CD AND MSG.EDI_MSG_IND_CD IN ('1')) --입력된 찾아진 POL과 같거나" ).append("\n"); 
		query.append("                        OR (EY.PRNR_SUB_LNK_CD = VVD.POL_YD_CD AND VVD.VSL_PRE_PST_CD <> 'U' AND MSG.EDI_MSG_IND_CD = '6') --PRE T/S PORT 지정 건이나" ).append("\n"); 
		query.append("                        OR (EY.PRNR_SUB_LNK_CD = VVD.POL_YD_CD AND VVD.VSL_PRE_PST_CD =  'U' AND MSG.EDI_MSG_IND_CD = '7') --POST T/S PORT 지정 건" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                   AND ((NOT EXISTS (SELECT 'X' FROM BKG_DG_CGO DG WHERE BK.BKG_NO = DG.BKG_NO " ).append("\n"); 
		query.append("                                                                   AND ML.CONTI_CD = 'E'" ).append("\n"); 
		query.append("                                                                   AND NVL(DG.SPCL_CGO_APRO_CD,'N') IN ('N', 'R', 'P')" ).append("\n"); 
		query.append("                                                                   AND BK.POL_NOD_CD NOT IN (SELECT BHCC.ATTR_CTNT1" ).append("\n"); 
		query.append("                                                                                             FROM BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("                                                                                             WHERE BHCC.HRD_CDG_ID = 'SPECIAL_VENDOR_301')" ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("                        AND CASE WHEN ML.CONTI_CD||BK.DCGO_FLG = 'EY' THEN (SELECT COUNT(*) FROM BKG_DG_CGO DG WHERE BK.BKG_NO = DG.BKG_NO)" ).append("\n"); 
		query.append("                            ELSE 1 END > 0" ).append("\n"); 
		query.append("                        AND CASE WHEN ML.CONTI_CD||BK.DCGO_FLG = 'EY' THEN (SELECT COUNT(*) FROM BKG_CONTAINER BC WHERE BC.BKG_NO = BK.BKG_NO) " ).append("\n"); 
		query.append("                            ELSE 1 END > 0" ).append("\n"); 
		query.append("						AND NOT EXISTS (SELECT 'X' FROM BKG_DG_CGO DG WHERE BK.BKG_NO = DG.BKG_NO " ).append("\n"); 
		query.append("                                                                   AND ML.CONTI_CD = 'E' AND DG.CNTR_NO IS NULL)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                        OR EXISTS (SELECT 'X' FROM BKG_NTC_HIS BNH WHERE BNH.BKG_NO = BK.BKG_NO AND BNH.NTC_VIA_CD = 'E' AND BNH.NTC_KND_CD = 'BT')     " ).append("\n"); 
		query.append("                       ) " ).append("\n"); 
		query.append("                   AND CASE WHEN ML.CONTI_CD||BK.RCV_TERM_CD = 'ED' THEN " ).append("\n"); 
		query.append("                          (SELECT COUNT(*) FROM BKG_NTC_HIS BNH WHERE BNH.BKG_NO = BK.BKG_NO AND BNH.NTC_VIA_CD = 'E' AND BNH.NTC_KND_CD = 'BT')" ).append("\n"); 
		query.append("                          +(SELECT COUNT(*) FROM BKG_CONTAINER BC WHERE BC.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("                       ELSE 1 END > 0" ).append("\n"); 
		query.append("                   AND 'CD01552' = CD.INTG_CD_ID" ).append("\n"); 
		query.append("                   AND 'BT' = CD.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                UNION ALL                     " ).append("\n"); 
		query.append("                 --EMPTY RELEASE ORDER 대상" ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("                	   EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("                     , EY.SNDR_TRD_PRNR_ID AS EDI_SNDR_ID" ).append("\n"); 
		query.append("                	 , EY.PRNR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("                     , EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("                     , CD.INTG_CD_VAL_DP_SEQ||CD.INTG_CD_VAL_CTNT AS KIND" ).append("\n"); 
		query.append("            		 , EY.PRNR_SUB_LNK_CD AS EDI_REF_CD" ).append("\n"); 
		query.append("                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("                	 , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("                	 , BKG_BOOKING BK" ).append("\n"); 
		query.append("                     , COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("                     , MDM_LOCATION ML                                ----------" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.MTY_PKUP_YD_CD = EY.PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                   AND EDI_MSG_IND_CD 	 = '5'" ).append("\n"); 
		query.append("				   AND MSG.MSG_TP_DESC	 = '1'" ).append("\n"); 
		query.append("                   AND MSG.EDI_MSG_TP_ID = '301'" ).append("\n"); 
		query.append("                   AND SUBSTR(BK.MTY_PKUP_YD_CD,1,5) = ML.LOC_CD       ----------" ).append("\n"); 
		query.append("                   AND NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                                   FROM BKG_EDI_SUB_LNK_MSG MSG, BKG_EDI_TRD_PRNR_SUB_LNK LNK" ).append("\n"); 
		query.append("                                   WHERE EDI_MSG_IND_CD ='1' " ).append("\n"); 
		query.append("                                   AND MSG.TRD_PRNR_SUB_LNK_SEQ = LNK.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                                   AND LNK.PRNR_SUB_LNK_CD = BK.POL_NOD_CD" ).append("\n"); 
		query.append("                                   AND BK.POL_NOD_CD = BK.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("                                   AND ML.CONTI_CD <> 'E'" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                   AND CASE WHEN ML.CONTI_CD||BK.RCV_TERM_CD = 'ED' THEN (SELECT COUNT(*) FROM BKG_NTC_HIS BNH WHERE BNH.BKG_NO = BK.BKG_NO AND BNH.NTC_VIA_CD = 'E' AND BNH.NTC_KND_CD = 'CN')" ).append("\n"); 
		query.append("                       ELSE 1 END > 0" ).append("\n"); 
		query.append("--                   AND EY.TRD_PRNR_SUB_LNK_SEQ IN " ).append("\n"); 
		query.append("--                        (SELECT TRD_PRNR_SUB_LNK_SEQ FROM BKG_EDI_SUB_LNK_MSG WHERE EDI_MSG_IND_CD ='1') --1:AUTO" ).append("\n"); 
		query.append("                   AND 'CD01552' = CD.INTG_CD_ID" ).append("\n"); 
		query.append("                   AND 'CN' = CD.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                UNION ALL                                     " ).append("\n"); 
		query.append("                --FULL RELEASE ORDER 대상   " ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("					   EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("                     , EY.SNDR_TRD_PRNR_ID AS EDI_SNDR_ID" ).append("\n"); 
		query.append("                	 , EY.PRNR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("                     , EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("                     , CD.INTG_CD_VAL_DP_SEQ||CD.INTG_CD_VAL_CTNT AS KIND" ).append("\n"); 
		query.append("            		 , EY.PRNR_SUB_LNK_CD AS EDI_REF_CD" ).append("\n"); 
		query.append("                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("                	 , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("                	 , BKG_BOOKING BK" ).append("\n"); 
		query.append("                     , COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("                     , MDM_LOCATION ML                                ----------" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.FULL_RTN_YD_CD = EY.PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                   AND MSG.EDI_MSG_TP_ID 	= '301'" ).append("\n"); 
		query.append("				   AND MSG.MSG_TP_DESC	 	= '1'" ).append("\n"); 
		query.append("                   AND EDI_MSG_IND_CD 	 = '4'                            ----------" ).append("\n"); 
		query.append("                   AND NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                                   FROM BKG_EDI_SUB_LNK_MSG MSG, BKG_EDI_TRD_PRNR_SUB_LNK LNK" ).append("\n"); 
		query.append("                                   WHERE EDI_MSG_IND_CD ='1' " ).append("\n"); 
		query.append("                                   AND MSG.TRD_PRNR_SUB_LNK_SEQ = LNK.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                                   AND LNK.PRNR_SUB_LNK_CD = BK.POL_NOD_CD" ).append("\n"); 
		query.append("                                   AND BK.POL_NOD_CD = BK.FULL_RTN_YD_CD)" ).append("\n"); 
		query.append("                   --AND EY.RCVR_TRD_PRNR_ID  = 'CN'" ).append("\n"); 
		query.append("                   AND ((SUBSTR(BK.FULL_RTN_YD_CD,1,5) = ML.LOC_CD       ----------" ).append("\n"); 
		query.append("                       AND ML.CONTI_CD||BK.RCV_TERM_CD = 'ED'" ).append("\n"); 
		query.append("                       AND NOT EXISTS (SELECT 'X' FROM BKG_DG_CGO DG WHERE BK.BKG_NO = DG.BKG_NO " ).append("\n"); 
		query.append("                                                                 AND NVL(DG.SPCL_CGO_APRO_CD,'N') IN ('N', 'R', 'P')" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                       AND CASE WHEN ML.CONTI_CD||BK.DCGO_FLG = 'EY' THEN (SELECT COUNT(*) FROM BKG_DG_CGO DG WHERE BK.BKG_NO = DG.BKG_NO)" ).append("\n"); 
		query.append("                           ELSE 1 END > 0" ).append("\n"); 
		query.append("                       AND CASE WHEN ML.CONTI_CD||BK.RCV_TERM_CD = 'ED' THEN (SELECT COUNT(*) FROM BKG_NTC_HIS BNH WHERE BNH.BKG_NO = BK.BKG_NO AND BNH.NTC_VIA_CD = 'E' AND BNH.NTC_KND_CD = 'FC')" ).append("\n"); 
		query.append("                           ELSE 1 END > 0)" ).append("\n"); 
		query.append("                       OR EY.RCVR_TRD_PRNR_ID IN (SELECT BHCC.ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT BHCC WHERE BHCC.HRD_CDG_ID = 'VENDOR_301_FC')" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("--                   AND EY.TRD_PRNR_SUB_LNK_SEQ IN " ).append("\n"); 
		query.append("--                        (SELECT TRD_PRNR_SUB_LNK_SEQ FROM BKG_EDI_SUB_LNK_MSG WHERE EDI_MSG_IND_CD ='1') --1:AUTO" ).append("\n"); 
		query.append("                   AND 'CD01552' = CD.INTG_CD_ID" ).append("\n"); 
		query.append("                   AND 'FC' = CD.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("         -- GROUP BY EDI_RCV_ID, EDI_REF_CD, EDI_SNDR_ID" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(", SENT_ID AS (SELECT NTC_KND_CD, EDI_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("                     , SND_ID AS EDI_SNDR_ID" ).append("\n"); 
		query.append("                     , TML_NTC_SND_STS_CD, HIS_SEQ--TYPE, ID별 마지막 전송 기록" ).append("\n"); 
		query.append("                FROM BKG_NTC_HIS A" ).append("\n"); 
		query.append("                WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("                 AND NTC_VIA_CD  = 'E'" ).append("\n"); 
		query.append("                 AND NTC_KND_CD  IN ('BT','CN','FC')" ).append("\n"); 
		query.append("                 AND HIS_SEQ = (SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                                  FROM BKG_NTC_HIS HIS" ).append("\n"); 
		query.append("                                 WHERE A.BKG_NO = HIS.BKG_NO" ).append("\n"); 
		query.append("                                   AND HIS.NTC_VIA_CD = 'E'" ).append("\n"); 
		query.append("                                   AND A.NTC_KND_CD = HIS.NTC_KND_CD" ).append("\n"); 
		query.append("                                   AND A.EDI_ID = HIS.EDI_ID))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT NTC_KND_CD AS KIND, EDI_RCV_ID" ).append("\n"); 
		query.append("       , EDI_SNDR_ID" ).append("\n"); 
		query.append("       , '' AS EDI_REF_CD" ).append("\n"); 
		query.append("       , 'R' BRAC_CD   --CANCEL로 전송 한다" ).append("\n"); 
		query.append("  FROM (SELECT SENT_ID.NTC_KND_CD, SENT_ID.EDI_RCV_ID--기존 전송처가 " ).append("\n"); 
		query.append("               ,SENT_ID.EDI_SNDR_ID" ).append("\n"); 
		query.append("          FROM SENT_ID --, RCV_ID" ).append("\n"); 
		query.append("                , BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("                , BKG_EDI_SUB_LNK_MSG      MSG" ).append("\n"); 
		query.append("         WHERE SENT_ID.TML_NTC_SND_STS_CD <> 'R'     --기존 전송처가 CANCE이면 제외" ).append("\n"); 
		query.append("		   AND SENT_ID.TML_NTC_SND_STS_CD IS NOT NULL--기존 전송처의 STATUS가 불분명할 때도 제외" ).append("\n"); 
		query.append("		   AND SENT_ID.EDI_RCV_ID = EY.RCVR_TRD_PRNR_ID--자동 전송처의 경우에만 cancel도 다시 전송" ).append("\n"); 
		query.append("		   and EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("           AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("		   AND MSG.MSG_TP_DESC		  = '1'" ).append("\n"); 
		query.append("           AND MSG.EDI_MSG_TP_ID      = '301'" ).append("\n"); 
		query.append("           AND ((msg.EDI_MSG_IND_CD     IN ( '1','5')" ).append("\n"); 
		query.append("                 AND SENT_ID.NTC_KND_CD     IN ( 'BT', 'CN'))" ).append("\n"); 
		query.append("               OR " ).append("\n"); 
		query.append("               (msg.EDI_MSG_IND_CD = '4' AND SENT_ID.NTC_KND_CD = 'FC' " ).append("\n"); 
		query.append("                 AND SENT_ID.EDI_RCV_ID IN (SELECT BHCC.ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT BHCC WHERE BHCC.HRD_CDG_ID = 'VENDOR_301_FC')" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("		   AND @[brac] <> 'R' --CANCEL일 때는 제외" ).append("\n"); 
		query.append("         MINUS" ).append("\n"); 
		query.append("        SELECT NTC_KND_CD, EDI_RCV_ID--새 전송처에 없을 경우" ).append("\n"); 
		query.append("               ,EDI_SNDR_ID" ).append("\n"); 
		query.append("          FROM RCV_ID)" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT NTC_KND_CD AS KIND, EDI_RCV_ID" ).append("\n"); 
		query.append("	   , EDI_SNDR_ID" ).append("\n"); 
		query.append("       , (SELECT DECODE(NTC_KND_CD,'BT',BB.POL_NOD_CD, 'FC',BB.FULL_RTN_YD_CD , 'CN', MTY_PKUP_YD_CD, '')" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BB WHERE BB.BKG_NO = @[bkg_no]) AS EDI_REF_CD" ).append("\n"); 
		query.append("       , 'N' BRAC_CD--NEW로 전송" ).append("\n"); 
		query.append("  FROM (SELECT NTC_KND_CD, EDI_RCV_ID--새 전송처가 " ).append("\n"); 
		query.append("               ,EDI_SNDR_ID" ).append("\n"); 
		query.append("          FROM RCV_ID" ).append("\n"); 
		query.append("		 WHERE nvl(@[brac],'U') <> 'R'        --CANCEL일 때는 제외" ).append("\n"); 
		query.append("         MINUS" ).append("\n"); 
		query.append("        SELECT NTC_KND_CD, EDI_RCV_ID--기존 전송처에 없을 경우" ).append("\n"); 
		query.append("               ,EDI_SNDR_ID" ).append("\n"); 
		query.append("          FROM SENT_ID)        " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT RCV_ID.NTC_KND_CD AS KIND, RCV_ID.EDI_RCV_ID" ).append("\n"); 
		query.append("       , RCV_ID.EDI_SNDR_ID" ).append("\n"); 
		query.append("       , RCV_ID.EDI_REF_CD, DECODE(SENT_ID.TML_NTC_SND_STS_CD, 'R', 'N', @[brac]) --마지막 전송이 R일 경우 'N', 아니면 U나 B로 전송" ).append("\n"); 
		query.append("  FROM RCV_ID, SENT_ID" ).append("\n"); 
		query.append(" WHERE RCV_ID.NTC_KND_CD = SENT_ID.NTC_KND_CD--기존 전송처에" ).append("\n"); 
		query.append("   AND RCV_ID.EDI_RCV_ID = SENT_ID.EDI_RCV_ID--재전송을 경우" ).append("\n"); 

	}
}