/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : StatusReportDBDAOsearchOutBdMovementStsNtcListRSQL.java
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

public class StatusReportDBDAOsearchOutBdMovementStsNtcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD별로 CCT 를 기준으로 하여 위 LIST를 대상으로 BKG의 BKG CONTACT 정보상의 E MAIL 주소로 일괄 화물 CCT 미도착 메일 발송하기 
	  * 위한 정보들을 조회
	  * </pre>
	  */
	public StatusReportDBDAOsearchOutBdMovementStsNtcListRSQL(){
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
		query.append("FileName : StatusReportDBDAOsearchOutBdMovementStsNtcListRSQL").append("\n"); 
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
		query.append("SELECT TRD_CD, SUB_TRD_CD, SLAN_CD, BKG_NO, CNTR_NO, POR_CD, POD_CD, DEL_CD, CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       RCV_TERM_CD, DE_TERM_CD, CNMV_STS_CD, ORG_YD_CD, CNMV_EVNT_DT, TRNS_MODE, NTC_EXP, " ).append("\n"); 
		query.append("       VVD, DECODE(NTC_EXP,'SHUTTLE','N', TML_GI_STS) TML_GI_STS," ).append("\n"); 
		query.append("       DG_STS, DG_DESC, RF_STS, RF_DESC, AK_STS, AK_DESC, STWG_CD, VSL_PRE_PST_CD, SHPR_NM," ).append("\n"); 
		query.append("       BKG_PIC, BKG_MPHN_NO, BKG_EML, SREP_PIC, SREP_MPHN_NO, SREP_EML," ).append("\n"); 
		query.append("       CNTC_MPHN_NO, CNTC_EML, CTRT_OFC_PHN_NO, MBL_SND_FLG, " ).append("\n"); 
		query.append("       SHPR_NTC_FLG, BKG_PIC_NTC_FLG, SREP_NTC_FLG, OB_PIC_NTC_FLG, SHPR_PIC, SHPR_MPHN_NO, SHPR_EML," ).append("\n"); 
		query.append("       EML_SND_FLG, SMS_SND_FLG, EML_SND_DT, SMS_SND_DT, " ).append("\n"); 
		query.append("       COUNT(CNTR_NO) OVER (PARTITION BY  BKG_NO) - 1 CNTR_CNT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT TRD_CD, SUB_TRD_CD, SLAN_CD, O.BKG_NO, CNTR_NO, POR_CD, POD_CD, DEL_CD, VVD," ).append("\n"); 
		query.append("           CNTR_TPSZ_CD, RCV_TERM_CD, DE_TERM_CD, CNMV_STS_CD, ORG_YD_CD, CNMV_EVNT_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("							   AND ROWNUM = 1" ).append("\n"); 
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
		query.append("                  (  SELECT  K.SPCL_CGO_APRO_CD " ).append("\n"); 
		query.append("                       FROM    BKG_DG_CGO K " ).append("\n"); 
		query.append("                       WHERE   K.BKG_NO = O.BKG_NO" ).append("\n"); 
		query.append("                       AND     K.CNTR_NO = O.CNTR_NO" ).append("\n"); 
		query.append("                       AND     K.DCGO_SEQ = (  SELECT MAX(G.DCGO_SEQ) FROM BKG_DG_CGO G WHERE G.BKG_NO = O.BKG_NO AND G.CNTR_NO = O.CNTR_NO  )" ).append("\n"); 
		query.append("                    )  AS DG_STS" ).append("\n"); 
		query.append("                  , BKG_JOIN_FNC(CURSOR(  SELECT IMDG_UN_NO||'/'||IMDG_CLSS_CD FROM BKG_DG_CGO WHERE BKG_NO = O.BKG_NO AND   CNTR_NO = O.CNTR_NO  )) DG_DESC" ).append("\n"); 
		query.append("                  , (  SELECT  J.SPCL_CGO_APRO_CD " ).append("\n"); 
		query.append("                       FROM    BKG_RF_CGO J " ).append("\n"); 
		query.append("                       WHERE   J.BKG_NO = O.BKG_NO" ).append("\n"); 
		query.append("                       AND     J.RC_SEQ = (  SELECT MAX(S.RC_SEQ) FROM BKG_RF_CGO S WHERE S.BKG_NO = O.BKG_NO AND S.CNTR_NO = O.CNTR_NO  )" ).append("\n"); 
		query.append("                    ) AS RF_STS" ).append("\n"); 
		query.append("                  , BKG_JOIN_FNC(CURSOR(  SELECT CDO_TEMP||'℃'||'/'||VENT_RTO||'%' FROM BKG_RF_CGO WHERE BKG_NO = O.BKG_NO AND CNTR_NO = O.CNTR_NO  ))  RF_DESC" ).append("\n"); 
		query.append("                  , (  SELECT  Y.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("                       FROM    BKG_AWK_CGO Y" ).append("\n"); 
		query.append("                       WHERE   Y.BKG_NO = O.BKG_NO" ).append("\n"); 
		query.append("                       AND     Y.AWK_CGO_SEQ = (  SELECT MAX(Q.AWK_CGO_SEQ) FROM BKG_AWK_CGO Q WHERE Q.BKG_NO = O.BKG_NO AND Q.CNTR_NO = O.CNTR_NO  )" ).append("\n"); 
		query.append("                    ) AS AK_STS" ).append("\n"); 
		query.append("                  , BKG_JOIN_FNC(CURSOR(  SELECT  'L:'||OVR_LF_LEN||' / R:'||OVR_RT_LEN||' / H:'||OVR_HGT" ).append("\n"); 
		query.append("                                          FROM    BKG_AWK_CGO" ).append("\n"); 
		query.append("                                          WHERE   BKG_NO = O.BKG_NO" ).append("\n"); 
		query.append("                                          AND     CNTR_NO = O.CNTR_NO))   AK_DESC," ).append("\n"); 
		query.append("                   (SELECT STWG_CD FROM BKG_BOOKING WHERE BKG_NO = O.BKG_NO) STWG_CD,        " ).append("\n"); 
		query.append("           VSL_PRE_PST_CD, " ).append("\n"); 
		query.append("           SHPR_NM,BKG_PIC, BKG_MPHN_NO, BKG_EML," ).append("\n"); 
		query.append("           SREP_PIC, SREP_MPHN_NO, SREP_EML, CNTC_MPHN_NO, CNTC_EML, CTRT_OFC_PHN_NO," ).append("\n"); 
		query.append("           MBL_SND_FLG,SHPR_NTC_FLG,BKG_PIC_NTC_FLG,SREP_NTC_FLG,OB_PIC_NTC_FLG," ).append("\n"); 
		query.append("		   SP1.CNTC_PSON_NM SHPR_PIC," ).append("\n"); 
		query.append("           SP1.CNTC_PSON_MPHN_NO SHPR_MPHN_NO," ).append("\n"); 
		query.append("           SP1.CNTC_PSON_EML SHPR_EML," ).append("\n"); 
		query.append("           DECODE((SELECT TO_CHAR(MAX(CRE_DT),'YYYY-MM-DD HH24:MI') FROM BKG_NTC_HIS WHERE BKG_NO = O.BKG_NO AND NTC_KND_CD = 'DM'), NULL, 'N', 'Y') EML_SND_FLG, " ).append("\n"); 
		query.append("           DECODE((SELECT TO_CHAR(MAX(CRE_DT),'YYYY-MM-DD HH24:MI') FROM BKG_NTC_HIS WHERE BKG_NO = O.BKG_NO AND NTC_KND_CD = 'DS'), NULL, 'N', 'Y') SMS_SND_FLG," ).append("\n"); 
		query.append("           (SELECT TO_CHAR(MAX(CRE_DT),'YYYY-MM-DD HH24:MI') FROM BKG_NTC_HIS WHERE BKG_NO = O.BKG_NO AND NTC_KND_CD = 'DM') EML_SND_DT," ).append("\n"); 
		query.append("           (SELECT TO_CHAR(MAX(CRE_DT),'YYYY-MM-DD HH24:MI') FROM BKG_NTC_HIS WHERE BKG_NO = O.BKG_NO AND NTC_KND_CD = 'DS') SMS_SND_DT" ).append("\n"); 
		query.append("    FROM ( SELECT RL.TRD_CD, RL.SUB_TRD_CD, BV.SLAN_CD, MIN(BV.BKG_NO) BKG_NO, BC.CNTR_NO, BB.POR_CD, BV.POD_CD, BB.DEL_CD," ).append("\n"); 
		query.append("                   EML_SND_FLG,MBL_SND_FLG,SHPR_NTC_FLG,BKG_PIC_NTC_FLG,SREP_NTC_FLG,OB_PIC_NTC_FLG," ).append("\n"); 
		query.append("                   BC.CNTR_TPSZ_CD, BC.RCV_TERM_CD, BC.DE_TERM_CD, CM.MVMT_STS_CD CNMV_STS_CD, " ).append("\n"); 
		query.append("                   NVL(CM.ORG_YD_CD, BC.ORG_YD_CD) ORG_YD_CD, TO_CHAR(CM.CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI') CNMV_EVNT_DT," ).append("\n"); 
		query.append("                   BV.POL_YD_CD, CM.CNMV_YR, CM.CNMV_CYC_NO, CM.CNMV_ID_NO, BV.POL_CD, BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("                   DECODE(BV.VSL_PRE_PST_CD,'T','TRUNK','U','POST','S','PRE') VSL_PRE_PST_CD," ).append("\n"); 
		query.append("                   NM.CUST_LGL_ENG_NM SHPR_NM," ).append("\n"); 
		query.append("                   BP.USR_NM BKG_PIC," ).append("\n"); 
		query.append("                   BP.MPHN_NO BKG_MPHN_NO," ).append("\n"); 
		query.append("                   BP.USR_EML BKG_EML," ).append("\n"); 
		query.append("                   SR.SREP_NM SREP_PIC," ).append("\n"); 
		query.append("                   SP.MPHN_NO SREP_MPHN_NO," ).append("\n"); 
		query.append("                   SR.SREP_EML," ).append("\n"); 
		query.append("                   BS.CNTC_MPHN_NO," ).append("\n"); 
		query.append("                   BS.CNTC_EML," ).append("\n"); 
		query.append("                   BS.CTRT_OFC_PHN_NO" ).append("\n"); 
		query.append("            FROM BKG_VVD BV, BKG_CGO_CLZ_TM_STUP BS, BKG_BOOKING BB, BKG_CONTAINER BC, BKG_CUSTOMER SH," ).append("\n"); 
		query.append("                 CTM_MOVEMENT CM, COM_USER BP, MDM_SLS_REP SR, COM_USER SP, MDM_CUSTOMER NM," ).append("\n"); 
		query.append("                 (SELECT   V.TRD_CD" ).append("\n"); 
		query.append("                         , V.SUB_TRD_CD" ).append("\n"); 
		query.append("                         , RD.FM_CONTI_CD" ).append("\n"); 
		query.append("                         , RD.TO_CONTI_CD" ).append("\n"); 
		query.append("                   FROM    MDM_REV_LANE RL, MDM_DTL_REV_LANE RD" ).append("\n"); 
		query.append("                         , MAS_MON_VVD V" ).append("\n"); 
		query.append("                   WHERE   RL.RLANE_CD = V.RLANE_CD" ).append("\n"); 
		query.append("                   AND     V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND RL.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                   AND V.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                   AND V.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                   AND V.DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                   AND RD.RLANE_CD = RL.RLANE_CD" ).append("\n"); 
		query.append("                   AND RD.VSL_SLAN_DIR_CD = V.DIR_CD" ).append("\n"); 
		query.append("                   AND RD.TRD_CD = V.TRD_CD" ).append("\n"); 
		query.append("                   AND RD.SUB_TRD_CD = V.SUB_TRD_CD" ).append("\n"); 
		query.append("                   AND RD.DELT_FLG = 'N')RL" ).append("\n"); 
		query.append("            WHERE BV.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("            AND BV.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("            AND BV.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("            AND BV.POL_CD = BS.POL_CD" ).append("\n"); 
		query.append("            AND BV.POL_CD = BB.POL_CD" ).append("\n"); 
		query.append("            AND BV.SLAN_CD = BS.LANE_CD" ).append("\n"); 
		query.append("            AND BV.SKD_DIR_CD = BS.DIR_CD" ).append("\n"); 
		query.append("            AND BV.POL_CD = NVL(@[pol_cd], BV.POL_CD)" ).append("\n"); 
		query.append("            AND BV.POL_YD_CD = DECODE(LENGTH(@[pol_cd]||@[pol_yd_cd]),7 , @[pol_cd]||@[pol_yd_cd], BV.POL_YD_CD)" ).append("\n"); 
		query.append("            AND SH.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("            AND SH.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("            AND SH.CUST_CNT_CD = NM.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND SH.CUST_SEQ = NM.CUST_SEQ" ).append("\n"); 
		query.append("            AND RL.FM_CONTI_CD = ( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, BV.SLAN_CD, BV.SKD_DIR_CD) FROM MDM_LOCATION L WHERE L.LOC_CD = BV.POL_CD )" ).append("\n"); 
		query.append("            AND RL.TO_CONTI_CD = ( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, BV.SLAN_CD, BV.SKD_DIR_CD) FROM MDM_LOCATION L WHERE L.LOC_CD = BV.POD_CD )" ).append("\n"); 
		query.append("            AND BC.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("            AND BB.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("            AND BB.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("            --AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("            AND BB.BKG_CGO_TP_CD = DECODE(@[bkg_cgo_tp_cd],'ALL', BB.BKG_CGO_TP_CD,@[bkg_cgo_tp_cd])" ).append("\n"); 
		query.append("            AND BC.RCV_TERM_CD = NVL(@[rcv_term_cd], BC.RCV_TERM_CD)" ).append("\n"); 
		query.append("            AND BC.DE_TERM_CD = NVL(@[de_term_cd], BC.DE_TERM_CD)" ).append("\n"); 
		query.append("            AND BC.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("            AND CM.CNMV_YR = DECODE(BC.CNMV_CYC_NO, 9999, (SELECT MAX(CNMV_YR) FROM CTM_MOVEMENT  WHERE CNTR_NO = BC.CNTR_NO), BC.CNMV_YR)" ).append("\n"); 
		query.append("            AND CM.CNMV_ID_NO = DECODE(BC.CNMV_CYC_NO, 9999, CM.CNMV_ID_NO, BC.CNMV_ID_NO)" ).append("\n"); 
		query.append("            AND CM.CNMV_CYC_NO = DECODE(BC.CNMV_CYC_NO, 9999, (SELECT MAX(CNMV_CYC_NO)" ).append("\n"); 
		query.append("                                                               FROM CTM_MOVEMENT  WHERE CNTR_NO = BC.CNTR_NO), BC.CNMV_CYC_NO)" ).append("\n"); 
		query.append("            AND CM.CNMV_SEQ = (SELECT MAX(CNMV_SEQ)" ).append("\n"); 
		query.append("                               FROM CTM_MOVEMENT  " ).append("\n"); 
		query.append("                               WHERE CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                               AND CNMV_YR = DECODE(BC.CNMV_CYC_NO, 9999, (SELECT MAX(CNMV_YR) FROM CTM_MOVEMENT  WHERE CNTR_NO = BC.CNTR_NO), BC.CNMV_YR)" ).append("\n"); 
		query.append("                               AND CNMV_CYC_NO = DECODE(BC.CNMV_CYC_NO, 9999, (SELECT MAX(CNMV_CYC_NO)FROM CTM_MOVEMENT  WHERE CNTR_NO = BC.CNTR_NO), BC.CNMV_CYC_NO))" ).append("\n"); 
		query.append("            AND BP.USR_ID(+) = BB.DOC_USR_ID" ).append("\n"); 
		query.append("            AND SR.SREP_CD(+) = BB.OB_SREP_CD" ).append("\n"); 
		query.append("            AND SR.EMPE_CD = SP.USR_ID(+)" ).append("\n"); 
		query.append("            GROUP BY RL.TRD_CD, RL.SUB_TRD_CD, BV.SLAN_CD, BC.CNTR_NO, BB.POR_CD, BV.POD_CD, BB.DEL_CD," ).append("\n"); 
		query.append("                   EML_SND_FLG,MBL_SND_FLG,SHPR_NTC_FLG,BKG_PIC_NTC_FLG,SREP_NTC_FLG,OB_PIC_NTC_FLG," ).append("\n"); 
		query.append("                   BC.CNTR_TPSZ_CD, BC.RCV_TERM_CD, BC.DE_TERM_CD, CM.MVMT_STS_CD , " ).append("\n"); 
		query.append("                   NVL(CM.ORG_YD_CD, BC.ORG_YD_CD), TO_CHAR(CM.CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("                   DECODE(BV.VSL_PRE_PST_CD,'T','TRUNK','U','POST','S','PRE')," ).append("\n"); 
		query.append("                   BV.POL_YD_CD, CM.CNMV_YR, CM.CNMV_CYC_NO, CM.CNMV_ID_NO, BV.POL_CD,BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD," ).append("\n"); 
		query.append("                   NM.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                   BP.USR_NM," ).append("\n"); 
		query.append("                   BP.MPHN_NO," ).append("\n"); 
		query.append("                   BP.USR_EML," ).append("\n"); 
		query.append("                   SR.SREP_NM," ).append("\n"); 
		query.append("                   SP.MPHN_NO," ).append("\n"); 
		query.append("                   SR.SREP_EML," ).append("\n"); 
		query.append("                   BS.CNTC_MPHN_NO," ).append("\n"); 
		query.append("                   BS.CNTC_EML," ).append("\n"); 
		query.append("                   BS.CTRT_OFC_PHN_NO" ).append("\n"); 
		query.append("    ) O , BKG_CNTC_PSON SP1" ).append("\n"); 
		query.append("     WHERE SP1.BKG_NO(+) = O.BKG_NO" ).append("\n"); 
		query.append("       AND SP1.BKG_CNTC_PSON_TP_CD(+) = 'BK'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(TRNS_MODE,'X') = DECODE(@[trns_mode],'ALL', NVL(TRNS_MODE,'X'),@[trns_mode])" ).append("\n"); 
		query.append("AND NVL(NTC_EXP,'X') = DECODE(@[ntc_exp],'ALL', NVL(NTC_EXP,'X'),@[ntc_exp])" ).append("\n"); 
		query.append("AND DECODE(NTC_EXP,'SHUTTLE','N', TML_GI_STS) = DECODE(@[tml_gi_sts],'ALL', DECODE(NTC_EXP,'SHUTTLE','N', TML_GI_STS),@[tml_gi_sts])" ).append("\n"); 
		query.append("ORDER BY TRD_CD,SUB_TRD_CD,BKG_NO,CNTR_NO" ).append("\n"); 

	}
}