/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchTmnl301RcvIdForManualSendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.26 
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

public class GeneralBookingSearchDBDAOSearchTmnl301RcvIdForManualSendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * manual 전송시 수신 대상 ID를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchTmnl301RcvIdForManualSendRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOSearchTmnl301RcvIdForManualSendRSQL").append("\n"); 
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
		query.append("       (SELECT CASE WHEN MIN(KIND) LIKE MIN(SUBSTR(KIND,0,LENGTH(KIND)-2))||'%'" ).append("\n"); 
		query.append("                    THEN SUBSTR(MIN(KIND),LENGTHB(MIN(KIND))-1,LENGTHB(MIN(KIND)))" ).append("\n"); 
		query.append("                    END AS NTC_KND_CD" ).append("\n"); 
		query.append("			 , EDI_RCV_ID" ).append("\n"); 
		query.append("    		 , EDI_REF_CD" ).append("\n"); 
		query.append("          FROM " ).append("\n"); 
		query.append("               (--BKG CONFIRM" ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("					   EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("                     , EY.PRNR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("                     , EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("                     , CD.INTG_CD_VAL_DP_SEQ||CD.INTG_CD_VAL_CTNT AS KIND" ).append("\n"); 
		query.append("            		 , EY.PRNR_SUB_LNK_CD AS EDI_REF_CD" ).append("\n"); 
		query.append("                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("                     , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("                     , BKG_VVD VVD" ).append("\n"); 
		query.append("                     , BKG_BOOKING BK" ).append("\n"); 
		query.append("                     , COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.BKG_NO   = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("				   AND MSG.MSG_TP_DESC		  = '1'" ).append("\n"); 
		query.append("                   AND MSG.EDI_MSG_TP_ID      = '301'" ).append("\n"); 
		query.append("--                   and EY.TRD_PRNR_SUB_LNK_SEQ in " ).append("\n"); 
		query.append("--                        (select TRD_PRNR_SUB_LNK_SEQ from BKG_EDI_SUB_LNK_MSG where EDI_MSG_IND_CD ='2') --2:manual" ).append("\n"); 
		query.append("                   AND (   (EY.PRNR_SUB_LNK_CD = BK.POL_NOD_CD AND MSG.EDI_MSG_IND_CD IN ('1', '2')) --입력된 찾아진 pol과 같거나" ).append("\n"); 
		query.append("                        OR (EY.PRNR_SUB_LNK_CD = VVD.POL_YD_CD AND VVD.VSL_PRE_PST_CD <> 'U' AND MSG.EDI_MSG_IND_CD = '6') --pre t/s port 지정 건이나" ).append("\n"); 
		query.append("                        OR (EY.PRNR_SUB_LNK_CD = VVD.POL_YD_CD AND VVD.VSL_PRE_PST_CD =  'U' AND MSG.EDI_MSG_IND_CD = '7') --post t/s port 지정 건" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                   AND 'CD01552' = CD.INTG_CD_ID" ).append("\n"); 
		query.append("                   AND 'BT' = CD.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                 --EMPTY RELEASE ORDER 대상" ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("                	   EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("                	 , EY.PRNR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("                     , EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("                     , CD.INTG_CD_VAL_DP_SEQ||CD.INTG_CD_VAL_CTNT AS KIND" ).append("\n"); 
		query.append("            		 , EY.PRNR_SUB_LNK_CD AS EDI_REF_CD" ).append("\n"); 
		query.append("                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("                	 , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("                	 , BKG_BOOKING BK" ).append("\n"); 
		query.append("                     , COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("                     , MDM_LOCATION ML    " ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND 1 = 2 -- Manual 전송은 MTY 를 보내지 않는다" ).append("\n"); 
		query.append("                   AND BK.MTY_PKUP_YD_CD = EY.PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                   AND EDI_MSG_IND_CD 	 = '5'" ).append("\n"); 
		query.append("				   AND MSG.MSG_TP_DESC	 = '1'" ).append("\n"); 
		query.append("                   AND MSG.EDI_MSG_TP_ID = '301'" ).append("\n"); 
		query.append("                   AND SUBSTR(BK.MTY_PKUP_YD_CD,1,5) = ML.LOC_CD       ----------" ).append("\n"); 
		query.append("                   AND ML.CONTI_CD||RCV_TERM_CD <> 'ED'" ).append("\n"); 
		query.append("--                   and EY.TRD_PRNR_SUB_LNK_SEQ in " ).append("\n"); 
		query.append("--                        (select TRD_PRNR_SUB_LNK_SEQ from BKG_EDI_SUB_LNK_MSG where EDI_MSG_IND_CD ='2') --2:manual" ).append("\n"); 
		query.append("                   AND 'CD01552' = CD.INTG_CD_ID" ).append("\n"); 
		query.append("                   AND 'CN' = CD.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                --FULL RELEASE ORDER 대상   " ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("					   EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("                	 , EY.PRNR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("                     , EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("                     , CD.INTG_CD_VAL_DP_SEQ||CD.INTG_CD_VAL_CTNT AS KIND" ).append("\n"); 
		query.append("            		 , EY.PRNR_SUB_LNK_CD AS EDI_REF_CD" ).append("\n"); 
		query.append("                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("                	 , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("                	 , BKG_BOOKING BK" ).append("\n"); 
		query.append("                     , COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("                     , MDM_LOCATION ML        " ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.FULL_RTN_YD_CD = EY.PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                   AND MSG.EDI_MSG_TP_ID 	= '301'" ).append("\n"); 
		query.append("				   AND MSG.MSG_TP_DESC	 	= '1'" ).append("\n"); 
		query.append("                   --AND EY.RCVR_TRD_PRNR_ID  = 'CN'" ).append("\n"); 
		query.append("                   AND SUBSTR(BK.FULL_RTN_YD_CD,1,5) = ML.LOC_CD       ----------" ).append("\n"); 
		query.append("                   AND ML.CONTI_CD = 'E'  " ).append("\n"); 
		query.append("                   AND EDI_MSG_IND_CD 	 = '4'                            ----------" ).append("\n"); 
		query.append("                   AND NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                                   FROM BKG_EDI_SUB_LNK_MSG MSG, BKG_EDI_TRD_PRNR_SUB_LNK LNK" ).append("\n"); 
		query.append("                                   WHERE EDI_MSG_IND_CD ='1' " ).append("\n"); 
		query.append("                                   AND MSG.TRD_PRNR_SUB_LNK_SEQ = LNK.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                                   AND LNK.PRNR_SUB_LNK_CD = BK.POL_NOD_CD" ).append("\n"); 
		query.append("                                   AND BK.POL_NOD_CD = BK.FULL_RTN_YD_CD)" ).append("\n"); 
		query.append("--                   and EY.TRD_PRNR_SUB_LNK_SEQ in " ).append("\n"); 
		query.append("--                        (select TRD_PRNR_SUB_LNK_SEQ from BKG_EDI_SUB_LNK_MSG where EDI_MSG_IND_CD ='1') --1:auto" ).append("\n"); 
		query.append("                   AND 'CD01552' = CD.INTG_CD_ID" ).append("\n"); 
		query.append("                   AND 'FC' = CD.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("       GROUP BY EDI_RCV_ID, EDI_REF_CD)" ).append("\n"); 
		query.append("#if(${brac}=='M')" ).append("\n"); 
		query.append(", SENT_ID AS (SELECT /*+INDEX_DESC(BKG_NTC_HIS XPKBKG_NTC_HIS)*/NTC_KND_CD, EDI_ID AS EDI_RCV_ID, TML_NTC_SND_STS_CD--TYPE, ID별 마지막 전송 기록" ).append("\n"); 
		query.append("                FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("       	       WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("                 AND NTC_VIA_CD  = 'E'" ).append("\n"); 
		query.append("                 AND NTC_KND_CD  IN ('BT','CN','FC')" ).append("\n"); 
		query.append("				 AND ROWNUM      = 1)" ).append("\n"); 
		query.append("--0702 화면에서 전송시 새로 보낼 곳이 기존에 보낸적이 없으면 New로 전송, 보낸적이 있으면 UPDATE로 전송" ).append("\n"); 
		query.append("SELECT NTC_KND_CD AS KIND, EDI_RCV_ID, '' AS EDI_REF_CD, 'R' BRAC_CD--CANCEL로 전송" ).append("\n"); 
		query.append("  FROM (SELECT NTC_KND_CD, EDI_RCV_ID--기존 전송처가 " ).append("\n"); 
		query.append("          FROM SENT_ID " ).append("\n"); 
		query.append("         WHERE SENT_ID.TML_NTC_SND_STS_CD <> 'R'     --기존 전송처가 CANCE이면 제외" ).append("\n"); 
		query.append("		   AND SENT_ID.TML_NTC_SND_STS_CD IS NOT NULL--기존 전송처의 STATUS가 불분명할 때도 제외" ).append("\n"); 
		query.append("         MINUS" ).append("\n"); 
		query.append("        SELECT NTC_KND_CD, EDI_RCV_ID--새 전송처에 없을 경우" ).append("\n"); 
		query.append("          FROM RCV_ID)" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT NTC_KND_CD AS KIND, EDI_RCV_ID, '' AS EDI_REF_CD, 'N' BRAC_CD--NEW로 전송" ).append("\n"); 
		query.append("  FROM (SELECT NTC_KND_CD, EDI_RCV_ID--새 전송처가 " ).append("\n"); 
		query.append("          FROM RCV_ID" ).append("\n"); 
		query.append("         MINUS" ).append("\n"); 
		query.append("        SELECT NTC_KND_CD, EDI_RCV_ID--기존 전송처에 없을 경우" ).append("\n"); 
		query.append("          FROM SENT_ID)        " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT RCV_ID.NTC_KND_CD AS KIND, RCV_ID.EDI_RCV_ID, RCV_ID.EDI_REF_CD, DECODE(SENT_ID.TML_NTC_SND_STS_CD, 'R', 'N', 'M', 'U', @[brac]) BRAC_CD --마지막 전송이 R일 경우 'N', 아니면 U나 B로 전송" ).append("\n"); 
		query.append("  FROM RCV_ID, SENT_ID" ).append("\n"); 
		query.append(" WHERE RCV_ID.NTC_KND_CD = SENT_ID.NTC_KND_CD--기존 전송처에" ).append("\n"); 
		query.append("   AND RCV_ID.EDI_RCV_ID = SENT_ID.EDI_RCV_ID--재전송을 경우" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--0616 화면에서 전송시 전달 받은 값으로 전송  " ).append("\n"); 
		query.append("SELECT NTC_KND_CD AS KIND_CD, EDI_RCV_ID, EDI_REF_CD, @[brac] BRAC_CD" ).append("\n"); 
		query.append("  FROM RCV_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}