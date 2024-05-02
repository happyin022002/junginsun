/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : StatusReportDBDAOsearchOutBdMovementStsNtcListSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOsearchOutBdMovementStsNtcListSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD별로 CCT 를 기준으로 하여 위 LIST를 대상으로 BKG의 BKG CONTACT 정보상의 E MAIL 주소로 일괄 화물 CCT 미도착 메일 발송하기 위한 정보 Summary
	  * </pre>
	  */
	public StatusReportDBDAOsearchOutBdMovementStsNtcListSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_gi_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_exp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trns_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOsearchOutBdMovementStsNtcListSumRSQL").append("\n"); 
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
		query.append("SELECT NVL(CNTR_TPSZ_CD, 'TOTAL') CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       COUNT(CNTR_TPSZ_CD) SUM_CNTR," ).append("\n"); 
		query.append("       SUM(CNT_MVMT_OP) SUM_MVMT_OP," ).append("\n"); 
		query.append("       SUM(CNT_MVMT_OC) SUM_MVMT_OC," ).append("\n"); 
		query.append("       SUM(CNT_MVMT_ENTN) SUM_MVMT_ENTN," ).append("\n"); 
		query.append("       SUM(CNT_MVMT_VL) SUM_MVMT_VL,     " ).append("\n"); 
		query.append("       SUM(CNT_MVMT_MTY) SUM_MVMT_MTY," ).append("\n"); 
		query.append("       SUM(CNT_MVMT_OTHR) SUM_MVMT_OTHR," ).append("\n"); 
		query.append("       SUM(CNT_TRNS_ST) SUM_TRNS_ST," ).append("\n"); 
		query.append("       SUM(CNT_TRNS_HJT) SUM_TRNS_HJT," ).append("\n"); 
		query.append("       SUM(CNT_TRNS_SHUT) SUM_TRNS_SHUT," ).append("\n"); 
		query.append("       SUM(EML_SND) SUM_EML_SNT," ).append("\n"); 
		query.append("       SUM(EML_USND) SUM_EML_UNSNT," ).append("\n"); 
		query.append("       SUM(SMS_SND) SUM_SNS_SNT," ).append("\n"); 
		query.append("       SUM(SMS_USND) SUM_SNS_UNSNT" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', '20','40') CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       DECODE(CNMV_STS_CD, 'OP', 1, 0) cnt_mvmt_op," ).append("\n"); 
		query.append("       DECODE(CNMV_STS_CD, 'OC', 1, 0) cnt_mvmt_oc," ).append("\n"); 
		query.append("       DECODE(CNMV_STS_CD, 'EN', 1,'TN','1', 0) cnt_mvmt_entn," ).append("\n"); 
		query.append("       DECODE(CNMV_STS_CD, 'VL', 1, 0) cnt_mvmt_vl,     " ).append("\n"); 
		query.append("       DECODE(CNMV_STS_CD, 'MT', 1, 0) cnt_mvmt_mty," ).append("\n"); 
		query.append("       DECODE(CNMV_STS_CD, 'OP', 0, 'OC', 0 ,'EN',0,'TN',0, 'VL',0 , 'MT', 0 ,1) cnt_mvmt_othr," ).append("\n"); 
		query.append("       DECODE(TRNS_MODE, 'S/TRK', 1, 0) cnt_trns_st," ).append("\n"); 
		query.append("       DECODE(TRNS_MODE, 'HJT', 1, 0) cnt_trns_hjt," ).append("\n"); 
		query.append("       DECODE(TRNS_MODE, 'SHUTTLE', 1, 0) cnt_trns_shut," ).append("\n"); 
		query.append("       DECODE(EML_SND_FLG, 'Y', 1, 0) EML_SND," ).append("\n"); 
		query.append("       DECODE(SMS_SND_FLG, 'Y', 1, 0) SMS_SND," ).append("\n"); 
		query.append("       DECODE(EML_SND_FLG, 'N', 1, 0) EML_USND," ).append("\n"); 
		query.append("       DECODE(SMS_SND_FLG, 'N', 1, 0) SMS_USND" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM (SELECT CNTR_TPSZ_CD, CNMV_STS_CD, TRNS_MODE, NTC_EXP, EML_SND_FLG, SMS_SND_FLG," ).append("\n"); 
		query.append("             DECODE(NTC_EXP, 'SHUTTLE', 'N', TML_GI_STS) TML_GI_STS" ).append("\n"); 
		query.append("      FROM(" ).append("\n"); 
		query.append("            SELECT CNTR_TPSZ_CD, CNMV_STS_CD," ).append("\n"); 
		query.append("                   CASE WHEN CNMV_STS_CD = 'OC' AND POL_YD_CD <> ORG_YD_CD THEN 'SHUTTLE'" ).append("\n"); 
		query.append("                        ELSE NVL((SELECT DECODE(OWNR_TRK_FLG,'Y','S/TRK','HJT')" ).append("\n"); 
		query.append("                              FROM BKG_TRO H, BKG_TRO_DTL D" ).append("\n"); 
		query.append("                              WHERE H.BKG_NO = O.BKG_NO " ).append("\n"); 
		query.append("                              AND H.CXL_FLG = 'N' " ).append("\n"); 
		query.append("                              AND H.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("                              AND D.CNTR_TPSZ_CD = O.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              AND ROWNUM = 1),'HJT')" ).append("\n"); 
		query.append("                   END TRNS_MODE," ).append("\n"); 
		query.append("                   CASE WHEN RCV_TERM_CD = 'I' THEN 'FREE IN'" ).append("\n"); 
		query.append("                        WHEN RCV_TERM_CD = 'T' THEN 'TACKLE'" ).append("\n"); 
		query.append("                        WHEN RCV_TERM_CD = 'S' THEN 'CFS'" ).append("\n"); 
		query.append("                        WHEN (SELECT COUNT(BKG_NO) FROM BKG_DG_CGO WHERE BKG_NO = O.BKG_NO AND CNTR_NO = O.CNTR_NO " ).append("\n"); 
		query.append("                              AND (IMDG_CLSS_CD LIKE '1%' OR IMDG_CLSS_CD LIKE '2%' OR IMDG_CLSS_CD LIKE '7%'))>0   THEN 'DG DIRECT'" ).append("\n"); 
		query.append("                        ELSE NULL" ).append("\n"); 
		query.append("                        END NTC_EXP,  " ).append("\n"); 
		query.append("                   CASE WHEN (SELECT 'Y' " ).append("\n"); 
		query.append("                               FROM SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append("                               WHERE H.BKG_NO = O.BKG_NO" ).append("\n"); 
		query.append("                               AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                               AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("                               AND H.CNTR_NO = O.CNTR_NO" ).append("\n"); 
		query.append("                               AND D.ACT_CD IN ('FOTMAD', 'FTTMAD')" ).append("\n"); 
		query.append("                               AND D.ACT_DT IS NOT NULL" ).append("\n"); 
		query.append("                               AND D.NOD_CD = POL_YD_CD" ).append("\n"); 
		query.append("						       AND ROWNUM = 1" ).append("\n"); 
		query.append("                               ) = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                        WHEN (SELECT 'Y'" ).append("\n"); 
		query.append("                                  FROM CTM_MOVEMENT AA" ).append("\n"); 
		query.append("                                 WHERE CNTR_NO = O.CNTR_NO" ).append("\n"); 
		query.append("                                   AND CNMV_YR = O.CNMV_YR" ).append("\n"); 
		query.append("                                   AND CNMV_CYC_NO = O.CNMV_CYC_NO" ).append("\n"); 
		query.append("                                   AND MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("                                   AND ORG_YD_CD = O.POL_YD_CD" ).append("\n"); 
		query.append("                                   AND ROWNUM =1 ) ='Y' THEN 'Y'  " ).append("\n"); 
		query.append("                         ELSE 'N'" ).append("\n"); 
		query.append("                         END TML_GI_STS," ).append("\n"); 
		query.append("               DECODE((SELECT TO_CHAR(MAX(CRE_DT),'YYYY-MM-DD HH24:MI') FROM BKG_NTC_HIS WHERE BKG_NO = O.BKG_NO AND NTC_KND_CD = 'DM'), NULL, 'N', 'Y') EML_SND_FLG, " ).append("\n"); 
		query.append("               DECODE((SELECT TO_CHAR(MAX(CRE_DT),'YYYY-MM-DD HH24:MI') FROM BKG_NTC_HIS WHERE BKG_NO = O.BKG_NO AND NTC_KND_CD = 'DS'), NULL, 'N', 'Y') SMS_SND_FLG" ).append("\n"); 
		query.append("        FROM ( SELECT MIN(BV.BKG_NO) BKG_NO, BC.CNTR_NO," ).append("\n"); 
		query.append("                       BC.CNTR_TPSZ_CD, BC.RCV_TERM_CD, CM.MVMT_STS_CD CNMV_STS_CD, CM.ORG_YD_CD," ).append("\n"); 
		query.append("                       BV.POL_YD_CD, CM.CNMV_YR, CM.CNMV_CYC_NO, CM.CNMV_ID_NO" ).append("\n"); 
		query.append("                FROM BKG_VVD BV, BKG_CGO_CLZ_TM_STUP BS, BKG_BOOKING BB, BKG_CONTAINER BC, CTM_MOVEMENT CM," ).append("\n"); 
		query.append("                     (SELECT   V.TRD_CD" ).append("\n"); 
		query.append("                             , V.SUB_TRD_CD" ).append("\n"); 
		query.append("                             , RD.FM_CONTI_CD" ).append("\n"); 
		query.append("                             , RD.TO_CONTI_CD" ).append("\n"); 
		query.append("                       FROM    MDM_REV_LANE RL, MDM_DTL_REV_LANE RD" ).append("\n"); 
		query.append("                             , MAS_MON_VVD V" ).append("\n"); 
		query.append("                       WHERE   RL.RLANE_CD = V.RLANE_CD" ).append("\n"); 
		query.append("                       AND     V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND RL.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                       AND V.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                       AND V.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                       AND V.DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                       AND RD.RLANE_CD = RL.RLANE_CD" ).append("\n"); 
		query.append("                       AND RD.VSL_SLAN_DIR_CD = V.DIR_CD" ).append("\n"); 
		query.append("                       AND RD.TRD_CD = V.TRD_CD" ).append("\n"); 
		query.append("                       AND RD.SUB_TRD_CD = V.SUB_TRD_CD" ).append("\n"); 
		query.append("                       AND RD.DELT_FLG = 'N')RL" ).append("\n"); 
		query.append("                WHERE BV.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                AND BV.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                AND BV.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                AND BV.POL_CD = BS.POL_CD" ).append("\n"); 
		query.append("                AND BV.POL_CD = BB.POL_CD" ).append("\n"); 
		query.append("                AND BV.SLAN_CD = BS.LANE_CD" ).append("\n"); 
		query.append("                AND BV.SKD_DIR_CD = BS.DIR_CD" ).append("\n"); 
		query.append("                AND BV.POL_CD = NVL(@[pol_cd], BV.POL_CD)" ).append("\n"); 
		query.append("                AND BV.POL_YD_CD = DECODE(LENGTH(@[pol_cd]||@[pol_yd_cd]),7 , @[pol_cd]||@[pol_yd_cd], BV.POL_YD_CD)" ).append("\n"); 
		query.append("                AND RL.FM_CONTI_CD = ( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, BV.SLAN_CD, BV.SKD_DIR_CD) FROM MDM_LOCATION L WHERE L.LOC_CD = BV.POL_CD )" ).append("\n"); 
		query.append("                AND RL.TO_CONTI_CD = ( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, BV.SLAN_CD, BV.SKD_DIR_CD) FROM MDM_LOCATION L WHERE L.LOC_CD = BV.POD_CD )" ).append("\n"); 
		query.append("                AND BC.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                AND BB.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                AND BB.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("                --AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                AND BB.BKG_CGO_TP_CD = DECODE(@[bkg_cgo_tp_cd],'ALL', BB.BKG_CGO_TP_CD,@[bkg_cgo_tp_cd])" ).append("\n"); 
		query.append("                AND BC.RCV_TERM_CD = NVL(@[rcv_term_cd], BC.RCV_TERM_CD)" ).append("\n"); 
		query.append("                AND BC.DE_TERM_CD = NVL(@[de_term_cd], BC.DE_TERM_CD)" ).append("\n"); 
		query.append("                AND BC.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("                AND CM.CNMV_YR = DECODE(BC.CNMV_CYC_NO, 9999, (SELECT MAX(CNMV_YR) FROM CTM_MOVEMENT  WHERE CNTR_NO = BC.CNTR_NO), BC.CNMV_YR)" ).append("\n"); 
		query.append("                AND CM.CNMV_ID_NO = DECODE(BC.CNMV_CYC_NO, 9999, CM.CNMV_ID_NO, BC.CNMV_ID_NO)" ).append("\n"); 
		query.append("                AND CM.CNMV_CYC_NO = DECODE(BC.CNMV_CYC_NO, 9999, (SELECT MAX(CNMV_CYC_NO)" ).append("\n"); 
		query.append("                                                                   FROM CTM_MOVEMENT  WHERE CNTR_NO = BC.CNTR_NO), BC.CNMV_CYC_NO)" ).append("\n"); 
		query.append("                AND CM.CNMV_SEQ = (SELECT MAX(CNMV_SEQ)" ).append("\n"); 
		query.append("                               FROM CTM_MOVEMENT  " ).append("\n"); 
		query.append("                               WHERE CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                               AND CNMV_YR = DECODE(BC.CNMV_CYC_NO, 9999, (SELECT MAX(CNMV_YR) FROM CTM_MOVEMENT  WHERE CNTR_NO = BC.CNTR_NO), BC.CNMV_YR)" ).append("\n"); 
		query.append("                               AND CNMV_CYC_NO = DECODE(BC.CNMV_CYC_NO, 9999, (SELECT MAX(CNMV_CYC_NO)FROM CTM_MOVEMENT  WHERE CNTR_NO = BC.CNTR_NO), BC.CNMV_CYC_NO))" ).append("\n"); 
		query.append("                GROUP BY BC.CNTR_NO, " ).append("\n"); 
		query.append("                       BC.CNTR_TPSZ_CD, BC.RCV_TERM_CD, CM.MVMT_STS_CD, CM.ORG_YD_CD, " ).append("\n"); 
		query.append("                       BV.POL_YD_CD, CM.CNMV_YR, CM.CNMV_CYC_NO, CM.CNMV_ID_NO" ).append("\n"); 
		query.append("            ) O " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND NVL(TRNS_MODE,'X') = DECODE(@[trns_mode],'ALL', NVL(TRNS_MODE,'X'),@[trns_mode])" ).append("\n"); 
		query.append("    AND NVL(NTC_EXP,'X') = DECODE(@[ntc_exp],'ALL', NVL(NTC_EXP,'X'),@[ntc_exp])" ).append("\n"); 
		query.append("    AND TML_GI_STS = DECODE(@[tml_gi_sts],'ALL', TML_GI_STS,@[tml_gi_sts])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY ROLLUP(CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("order by CNTR_TPSZ_CD" ).append("\n"); 

	}
}