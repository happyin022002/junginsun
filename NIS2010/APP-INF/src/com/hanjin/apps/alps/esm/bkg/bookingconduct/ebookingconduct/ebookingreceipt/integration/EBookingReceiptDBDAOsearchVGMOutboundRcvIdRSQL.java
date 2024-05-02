/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchVGMOutboundRcvIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2016.07.18 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchVGMOutboundRcvIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVGMOutboundRcvId
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchVGMOutboundRcvIdRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brac_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchVGMOutboundRcvIdRSQL").append("\n"); 
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
		query.append("       (SELECT SUBSTR(MIN(KIND), 2) NTC_KND_CD, EDI_RCV_ID" ).append("\n"); 
		query.append("          FROM " ).append("\n"); 
		query.append("               (--VERMAS" ).append("\n"); 
		query.append("                SELECT DISTINCT '1VM' KIND, EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("                     , EY.PRNR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("                     , EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("                     , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("                     , BKG_BOOKING BK" ).append("\n"); 
		query.append("                     , BKG_VVD     VVD" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.BKG_NO   = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                   AND MSG.MSG_TP_DESC        = '1'" ).append("\n"); 
		query.append("                   AND MSG.EDI_MSG_TP_ID      = 'VERMAS'" ).append("\n"); 
		query.append("                   AND (   (EY.PRNR_SUB_LNK_CD = BK.POL_NOD_CD  AND MSG.EDI_MSG_IND_CD IN ('13')) --입력된 찾아진 POL과 같거나" ).append("\n"); 
		query.append("                        OR (EY.PRNR_SUB_LNK_CD <> BK.POL_NOD_CD AND EY.PRNR_SUB_LNK_CD = VVD.POL_YD_CD AND MSG.EDI_MSG_IND_CD IN ('14'))" ).append("\n"); 
		query.append("                           -- T/S POL 이거나 " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("          GROUP BY EDI_RCV_ID)" ).append("\n"); 
		query.append(", SENT_ID AS (SELECT NTC_KND_CD, EDI_ID AS EDI_RCV_ID, TML_NTC_SND_STS_CD, HIS_SEQ--TYPE, ID별 마지막 전송 기록" ).append("\n"); 
		query.append("                FROM BKG_NTC_HIS A" ).append("\n"); 
		query.append("                WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("                 AND NTC_VIA_CD  = 'E'" ).append("\n"); 
		query.append("                 AND NTC_KND_CD  IN ('VM')" ).append("\n"); 
		query.append("                 AND HIS_SEQ = (SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                                  FROM BKG_NTC_HIS HIS" ).append("\n"); 
		query.append("                                 WHERE A.BKG_NO = HIS.BKG_NO" ).append("\n"); 
		query.append("                                   AND HIS.NTC_VIA_CD = 'E'" ).append("\n"); 
		query.append("                                   AND A.NTC_KND_CD = HIS.NTC_KND_CD" ).append("\n"); 
		query.append("                                   AND A.EDI_ID = HIS.EDI_ID))" ).append("\n"); 
		query.append("SELECT NTC_KND_CD AS KIND, EDI_RCV_ID, '1' BRAC_CD   --CANCEL로 전송 한다" ).append("\n"); 
		query.append("  FROM (SELECT SENT_ID.NTC_KND_CD, SENT_ID.EDI_RCV_ID--기존 전송처가 " ).append("\n"); 
		query.append("          FROM SENT_ID, RCV_ID" ).append("\n"); 
		query.append("                , BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("                , BKG_EDI_SUB_LNK_MSG      MSG" ).append("\n"); 
		query.append("         WHERE SENT_ID.TML_NTC_SND_STS_CD <> '1'     --기존 전송처가 CANCE이면 제외" ).append("\n"); 
		query.append("                        AND SENT_ID.TML_NTC_SND_STS_CD IS NOT NULL--기존 전송처의 STATUS가 불분명할 때도 제외" ).append("\n"); 
		query.append("                        AND SENT_ID.EDI_RCV_ID = EY.RCVR_TRD_PRNR_ID--자동 전송처의 경우에만 cancel도 다시 전송" ).append("\n"); 
		query.append("                        and EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("           AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                        AND MSG.MSG_TP_DESC                      = '1'" ).append("\n"); 
		query.append("           AND MSG.EDI_MSG_TP_ID      = 'VERMAS'" ).append("\n"); 
		query.append("           AND msg.EDI_MSG_IND_CD     IN ('13','14')" ).append("\n"); 
		query.append("                        AND @[brac_cd] <> '1' --CANCEL일 때는 제외" ).append("\n"); 
		query.append("         MINUS" ).append("\n"); 
		query.append("        SELECT NTC_KND_CD, EDI_RCV_ID--새 전송처에 없을 경우" ).append("\n"); 
		query.append("          FROM RCV_ID)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NTC_KND_CD AS KIND, EDI_RCV_ID, '9' BRAC_CD --NEW로 전송" ).append("\n"); 
		query.append("  FROM (SELECT NTC_KND_CD, EDI_RCV_ID--새 전송처가 " ).append("\n"); 
		query.append("          FROM RCV_ID" ).append("\n"); 
		query.append("                     WHERE @[brac_cd] <> '1'        --CANCEL일 때는 제외" ).append("\n"); 
		query.append("         MINUS" ).append("\n"); 
		query.append("        SELECT NTC_KND_CD, EDI_RCV_ID--기존 전송처에 없을 경우" ).append("\n"); 
		query.append("          FROM SENT_ID)        " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT RCV_ID.NTC_KND_CD AS KIND, RCV_ID.EDI_RCV_ID, DECODE(SENT_ID.TML_NTC_SND_STS_CD, '1', '9', '5') --마지막 전송이 R일 경우 'N'" ).append("\n"); 
		query.append("  FROM RCV_ID, SENT_ID" ).append("\n"); 
		query.append("WHERE RCV_ID.NTC_KND_CD = SENT_ID.NTC_KND_CD--기존 전송처에" ).append("\n"); 
		query.append("   AND RCV_ID.EDI_RCV_ID = SENT_ID.EDI_RCV_ID--재전송을 경우" ).append("\n"); 

	}
}