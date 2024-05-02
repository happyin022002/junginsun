/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchSiAutoSREmlReceivingListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchSiAutoSREmlReceivingListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchSiAutoSREmlReceivingListVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchSiAutoSREmlReceivingListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_if_status_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_mtch_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_urgency_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_log_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("split_bkg_yn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_knd_combo_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchSiAutoSREmlReceivingListVORSQL").append("\n"); 
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
		query.append("SELECT T2.*,R2.XTER_SNDR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	EML.BKG_NO" ).append("\n"); 
		query.append(",	EML.BKG_NO AS ORG_BKG_NO" ).append("\n"); 
		query.append(",	EML.BKG_NO	AS OLD_BKG_NO" ).append("\n"); 
		query.append(",	NVL(EML.BKG_NO_MTCH_STS_CD,'F') BKG_NO_MTCH_STS_CD" ).append("\n"); 
		query.append(",	( SELECT C.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("	FROM  COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("	WHERE C.INTG_CD_ID = 'CD02803' " ).append("\n"); 
		query.append("	AND   C.INTG_CD_VAL_CTNT = NVL(EML.BKG_NO_MTCH_STS_CD,'F') ) AS BKG_NO_MTCH_STS_NM" ).append("\n"); 
		query.append(",	EML.SR_AMD_TP_CD" ).append("\n"); 
		query.append(",	EML.SR_AMD_TP_CD AS OLD_SR_AMD_TP_CD" ).append("\n"); 
		query.append(",	EML.SR_AMD_KND_CD" ).append("\n"); 
		query.append(",	EML.FNT_OFC_EML" ).append("\n"); 
		query.append(",	EML.SR_URG_CD" ).append("\n"); 
		query.append(",	EML.SR_URG_CD AS OLD_SR_URG_CD" ).append("\n"); 
		query.append(",   EML.SPLIT_STS_CD,EML.BL_SPLIT_NO,EML.BL_SPLIT_TTL_KNT --add 2011.08.11" ).append("\n"); 
		query.append(",   EML.SPLIT_STS_CD AS OLD_SPLIT_STS_CD ,EML.BL_SPLIT_NO AS OLD_BL_SPLIT_NO, EML.BL_SPLIT_TTL_KNT AS OLD_BL_SPLIT_TTL_KNT" ).append("\n"); 
		query.append(",	EML.EML_SUBJ_CTNT" ).append("\n"); 
		query.append(",	EML.SR_NO" ).append("\n"); 
		query.append(",	EML.FAX_LOG_REF_NO" ).append("\n"); 
		query.append(",	EML.SR_KND_CD" ).append("\n"); 
		query.append(",	EML.SNDR_FAX_NO_CTNT" ).append("\n"); 
		query.append(",	TO_CHAR(EML.RCV_DT,'YYYY-MM-DD HH24:MI')  RCV_DT" ).append("\n"); 
		query.append(",   GLOBALDATE_PKG.TIME_CONV_FNC((SELECT LOC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = EML.RCV_OFC_CD), EML.RCV_DT, 'GMT') GMT_RCV_DT" ).append("\n"); 
		query.append(",	EML.RCV_GDT" ).append("\n"); 
		query.append(",	EML.RCV_OFC_CD" ).append("\n"); 
		query.append(",	EML.RCV_NM" ).append("\n"); 
		query.append(",	EML.RCV_RMK" ).append("\n"); 
		query.append(",	EML.SR_TRNS_USR_ID" ).append("\n"); 
		query.append(",   (SELECT USR_NM FROM COM_USER WHERE USR_ID = EML.SR_TRNS_USR_ID) SR_TRNS_USR_NM" ).append("\n"); 
		query.append("--,	EML.SR_TRNS_DT" ).append("\n"); 
		query.append(",   TO_CHAR(EML.SR_TRNS_DT,'YYYY-MM-DD HH24:MI') SR_TRNS_DT" ).append("\n"); 
		query.append(",	EML.IMG_FILE_IP" ).append("\n"); 
		query.append(",	EML.IMG_FILE_PATH_CTNT" ).append("\n"); 
		query.append(",	EML.IMG_FILE_NM" ).append("\n"); 
		query.append(",	EML.TTL_PG_KNT" ).append("\n"); 
		query.append(",	EML.SR_FAX_RSLT_CD" ).append("\n"); 
		query.append(",	DECODE(EML.SR_FAX_RSLT_CD,'10','Received Done','Received Error') AS SR_FAX_RSLT_NM" ).append("\n"); 
		query.append(",	NVL(EML.SR_MTCH_STS_CD,'F') SR_MTCH_STS_CD" ).append("\n"); 
		query.append(",	DECODE(EML.SR_MTCH_STS_CD,'A','Wt + Prc','W','Waiting','P','Processing','T','Transferred') AS SR_MTCH_STS_NM" ).append("\n"); 
		query.append(",	EML.MTCH_USR_ID" ).append("\n"); 
		query.append(",   (SELECT USR_NM FROM COM_USER WHERE USR_ID = EML.MTCH_USR_ID) MTCH_USR_NM" ).append("\n"); 
		query.append(",	EML.WRK_TM_NO" ).append("\n"); 
		query.append(",	EML.RTN_FM_STS_CD" ).append("\n"); 
		query.append(",	EML.RTN_FM_USR_ID" ).append("\n"); 
		query.append(",	EML.RTN_DT" ).append("\n"); 
		query.append(",	EML.RTN_GDT" ).append("\n"); 
		query.append(",	EML.SR_RTN_TO_STS_CD" ).append("\n"); 
		query.append(",	EML.RTN_TO_USR_ID" ).append("\n"); 
		query.append(",	EML.RTN_TO_RTN_DT" ).append("\n"); 
		query.append(",	EML.RTN_TO_RTN_GDT" ).append("\n"); 
		query.append(",	EML.RTN_TO_RTN_STS_CD" ).append("\n"); 
		query.append(",	EML.RTN_TO_RTN_USR_ID" ).append("\n"); 
		query.append(",	EML.CRE_USR_ID" ).append("\n"); 
		query.append(",	EML.CRE_DT" ).append("\n"); 
		query.append(",	EML.UPD_USR_ID" ).append("\n"); 
		query.append(",	EML.UPD_DT" ).append("\n"); 
		query.append(",	EML.EML_ORG_SUBJ_CTNT" ).append("\n"); 
		query.append(",	'' FROM_DT" ).append("\n"); 
		query.append(",	'' TO_DT" ).append("\n"); 
		query.append(",	'' IS_EML_RCV_FAIL_FLG" ).append("\n"); 
		query.append(",	'' CHK_EML_RCV_FAIL_FLG" ).append("\n"); 
		query.append(",	'' EML_ORIGIN_SUBJ_CTNT" ).append("\n"); 
		query.append(",	'' OFC_INC_SUB" ).append("\n"); 
		query.append(",	NVL(EML.TTL_PG_KNT,0) ATCH_FILE_KNT" ).append("\n"); 
		query.append(",	CASE WHEN NVL(EML.TTL_PG_KNT,0) > 0 THEN" ).append("\n"); 
		query.append("	 (SELECT ATC.ATCH_FILE_PATH_CTNT " ).append("\n"); 
		query.append("		FROM BKG_SR_EML_ATCH_FILE ATC " ).append("\n"); 
		query.append("		WHERE ATC.SR_NO = EML.SR_NO " ).append("\n"); 
		query.append("		AND ATC.FAX_LOG_REF_NO = EML.FAX_LOG_REF_NO " ).append("\n"); 
		query.append("		AND	ATC.SR_KND_CD = EML.SR_KND_CD" ).append("\n"); 
		query.append("		AND ROWNUM =1 ) ELSE '' END ATCH_FILE_PATH_CTNT " ).append("\n"); 
		query.append(", 		DECODE(TRIM(NVL(R.SR_CRNT_STS_CD,'')),'','ST',R.SR_CRNT_STS_CD ) AS  SR_CRNT_STS_CD    " ).append("\n"); 
		query.append(",		( SELECT DECODE(BKG_NO_MTCH_STS_CD,'S',C.INTG_CD_VAL_DESC)" ).append("\n"); 
		query.append("		FROM  COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("		WHERE C.INTG_CD_ID = 'CD01579' " ).append("\n"); 
		query.append("		AND   C.INTG_CD_VAL_CTNT = DECODE(TRIM(NVL(R.SR_CRNT_STS_CD,'')),'','ST',R.SR_CRNT_STS_CD ) ) AS SR_CRNT_STS_NM" ).append("\n"); 
		query.append(",   NVL((SELECT MAX(t.XTER_RQST_SEQ) FROM BKG_XTER_RQST_MST t WHERE eml.sr_no  = t.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("                                                    AND   eml.FAX_LOG_REF_NO = t.FAX_LOG_REF_NO(+)" ).append("\n"); 
		query.append("                                                    ),'-1') as max_seq" ).append("\n"); 
		query.append(",   nvl(R.SR_AMD_SEQ,'-1') as SR_AMD_SEQ " ).append("\n"); 
		query.append(", EML.SOL_APLY_PHS_NO" ).append("\n"); 
		query.append(",( SELECT C.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("	FROM  COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("	WHERE C.INTG_CD_ID = 'CD02961' " ).append("\n"); 
		query.append("	AND   C.INTG_CD_VAL_CTNT = EML.SI_RQST_CNG_BSE_CD ) AS SI_RQST_CNG_BSE_CD" ).append("\n"); 
		query.append(", DECODE(EML.SI_DOC_READ_SCS_FLG, 'Y','Success','N','Fail') as SI_DOC_READ_SCS_FLG" ).append("\n"); 
		query.append("FROM BKG_SR_FAX EML" ).append("\n"); 
		query.append(",    BKG_SR_CRNT_RQST R" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND   EML.SR_NO  = R.SR_NO(+)" ).append("\n"); 
		query.append("AND   EML.SR_KND_CD = R.SR_KND_CD(+)" ).append("\n"); 
		query.append("AND   EML.FAX_LOG_REF_NO = R.FAX_LOG_REF_NO(+)" ).append("\n"); 
		query.append("----------------------------" ).append("\n"); 
		query.append("/* DPCS email-tab 과 겹치지 않게 하느 조건 */" ).append("\n"); 
		query.append("AND   EML.BKG_NO NOT IN (" ).append("\n"); 
		query.append("            SELECT b.bkg_no  " ).append("\n"); 
		query.append("            FROM   BKG_BOOKING B ,BKG_CUSTOMER S, MDM_LOCATION POD" ).append("\n"); 
		query.append("            WHERE   (" ).append("\n"); 
		query.append("                     SUBSTR(B.BKG_NO, 1, 3) IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("												WHERE HRD_CDG_ID ='DPCS_BKG_PREFIX')" ).append("\n"); 
		query.append("                      /* DPCS Q-List로 포함조건 중 '일본발 S/I'에 대해서는 */                          " ).append("\n"); 
		query.append("                      OR   B.POR_CD IN ('JPTYO','JPOSA','JPUKB','JPYOK','JPKIJ')  " ).append("\n"); 
		query.append("                      /* 남중국 DPCS 처리대상 : BKG Office기준 6개 */" ).append("\n"); 
		query.append("                      OR   B.BKG_OFC_CD IN (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("                                            FROM BKG_HRD_CDG_CTNT H" ).append("\n"); 
		query.append("                                            WHERE H.HRD_CDG_ID = 'CHINA_DPCS')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      )                       " ).append("\n"); 
		query.append("                                             " ).append("\n"); 
		query.append("            AND    B.BKG_NO = eml.BKG_NO" ).append("\n"); 
		query.append("            /* 2011.04. 25 한시적으로 미주 물량을 PKGSC에서 처리 못하는 관계로 아래 물량은 F/O에서 처리토록 예외를 넣어 놓는다 */                                    " ).append("\n"); 
		query.append("            AND  " ).append("\n"); 
		query.append("                 (VSL_CD||SKD_VOY_NO||SKD_DIR_CD||BKG_OFC_CD)  NOT IN  (" ).append("\n"); 
		query.append("                                                                 SELECT DISTINCT ATTR_CTNT1" ).append("\n"); 
		query.append("                                                                 FROM   BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                                                 WHERE  HRD_CDG_ID = 'DPCS' AND HRD_CDG_ID_SEQ < 90000 AND ATTR_CTNT10 = 'N'" ).append("\n"); 
		query.append("                                                                 )" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("            AND  B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("            AND  S.BKG_CUST_TP_CD ='S' " ).append("\n"); 
		query.append("            AND  S.CUST_CNT_CD||S.CUST_SEQ NOT IN (" ).append("\n"); 
		query.append("                                                  SELECT DISTINCT ATTR_CTNT1" ).append("\n"); 
		query.append("                                                  FROM   BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                                  WHERE  HRD_CDG_ID = 'DPCS' AND HRD_CDG_ID_SEQ > 90000 AND ATTR_CTNT10 = 'N'" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("                                                  /*'US23335','US1650','US39899','US6047','US2495'," ).append("\n"); 
		query.append("                                                   'US8557','US4558',\\\\\\\\\\\\\\\\*'US4431',*\\\\\\\\\\\\\\\\'US5016','US546','US625')   */  " ).append("\n"); 
		query.append("            AND  S.CUST_CNT_CD||S.CUST_SEQ NOT IN (" ).append("\n"); 
		query.append("                                                  SELECT DISTINCT ATTR_CTNT1" ).append("\n"); 
		query.append("                                                  FROM   BKG_HRD_CDG_CTNT H, BKG_CUSTOMER F" ).append("\n"); 
		query.append("                                                  WHERE  HRD_CDG_ID = 'DPCS' " ).append("\n"); 
		query.append("                                                  AND HRD_CDG_ID_SEQ > 90000 " ).append("\n"); 
		query.append("                                                  AND ATTR_CTNT10 = 'Y'" ).append("\n"); 
		query.append("                                                  AND ATTR_CTNT9 = 'Y'" ).append("\n"); 
		query.append("                                                  AND F.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("                                                  AND F.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("                                                  AND (" ).append("\n"); 
		query.append("                                                        (F.CUST_CNT_CD = S.CUST_CNT_CD AND F.CUST_SEQ = S.CUST_SEQ)" ).append("\n"); 
		query.append("                                                        OR " ).append("\n"); 
		query.append("                                                        (F.CUST_CNT_CD IS NULL AND F.CUST_SEQ IS NULL)" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("            AND  B.POD_CD = POD.LOC_CD" ).append("\n"); 
		query.append("            AND  POD.CONTI_CD||S.CUST_CNT_CD||S.CUST_SEQ NOT IN (SELECT ATTR_CTNT3||ATTR_CTNT4" ).append("\n"); 
		query.append("                                                  FROM   BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                                  WHERE  HRD_CDG_ID = 'DPCS'" ).append("\n"); 
		query.append("                                                  AND ATTR_CTNT1 IS NULL)" ).append("\n"); 
		query.append(")                                                   " ).append("\n"); 
		query.append("----------------------------" ).append("\n"); 
		query.append("AND	NVL(SR_MTCH_STS_CD,' ') != 'D'" ).append("\n"); 
		query.append("AND nvl(EML.BKG_NO_MTCH_STS_CD,' ') = nvl(@[sr_bkg_sts_cd], nvl(EML.BKG_NO_MTCH_STS_CD,' ')) -- add 2011.08.11" ).append("\n"); 
		query.append("AND nvl(EML.SR_URG_CD,' ') = nvl(@[sr_urgency_cd], nvl(EML.SR_URG_CD,' ')) -- add 2011.08.11" ).append("\n"); 
		query.append("AND nvl(EML.SR_AMD_TP_CD,' ') = nvl(decode(@[sr_knd_combo_cd],'L',nvl(EML.SR_AMD_TP_CD,' '),@[sr_knd_combo_cd]  ), nvl(EML.SR_AMD_TP_CD,' ')) -- add 2011.08.11" ).append("\n"); 
		query.append("AND nvl(EML.SPLIT_STS_CD,' ') = nvl(@[split_bkg_yn], nvl(EML.SPLIT_STS_CD,' ')) -- add 2011.08.11" ).append("\n"); 
		query.append("AND nvl(EML.SR_PROC_TP_CD,' ') = nvl(@[sr_if_status_cd], nvl(EML.SR_PROC_TP_CD,' ')) -- add 2011.08.11" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("	AND EML.BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("#elseif (${from_dt} != '') " ).append("\n"); 
		query.append("	AND	TO_CHAR(RCV_DT,'YYYY-MM-DD') between @[from_dt] and @[to_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_inc_sub} != '' && ${rcv_ofc_cd} != '')  " ).append("\n"); 
		query.append("	AND EML.RCV_OFC_CD IN (" ).append("\n"); 
		query.append("		SELECT 	OFC_CD  " ).append("\n"); 
		query.append("		FROM   	MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("		START 	WITH MO.OFC_CD = @[rcv_ofc_cd]" ).append("\n"); 
		query.append("				CONNECT BY PRIOR MO.OFC_CD = MO.PRNT_OFC_CD)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	#if (${rcv_ofc_cd} != '') " ).append("\n"); 
		query.append("	AND   EML.RCV_OFC_CD = @[rcv_ofc_cd] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sr_no} != '') " ).append("\n"); 
		query.append("AND EML.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fax_log_ref_no} != '') " ).append("\n"); 
		query.append("AND	EML.FAX_LOG_REF_NO  = @[fax_log_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chk_eml_rcv_fail_flg} != '') " ).append("\n"); 
		query.append("AND	(EML.BKG_NO_MTCH_STS_CD = 'F' OR NVL(EML.SR_FAX_RSLT_CD,'11') = '11')" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#if (${sr_mtch_sts_cd} != '' && ${sr_mtch_sts_cd} == 'A')" ).append("\n"); 
		query.append("AND (SR_MTCH_STS_CD = 'W' OR SR_MTCH_STS_CD = 'P')" ).append("\n"); 
		query.append("#elseif (${sr_mtch_sts_cd} != '' && ${sr_mtch_sts_cd} != 'A')" ).append("\n"); 
		query.append("AND SR_MTCH_STS_CD = @[sr_mtch_sts_cd]" ).append("\n"); 
		query.append("#end 	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND EML.SR_KND_CD in('M', 'U')" ).append("\n"); 
		query.append("AND NVL(R.SR_AMD_SEQ,'-1') = NVL((SELECT MAX(R2.SR_AMD_SEQ) FROM BKG_SR_CRNT_RQST R2 WHERE R2.SR_NO  = R.SR_NO" ).append("\n"); 
		query.append("                                            AND   R2.SR_KND_CD = R.SR_KND_CD" ).append("\n"); 
		query.append("                                            AND   R2.FAX_LOG_REF_NO = R.FAX_LOG_REF_NO),'-1')" ).append("\n"); 
		query.append("ORDER BY EML.RCV_DT,EML.SR_NO" ).append("\n"); 
		query.append(")T2,  BKG_XTER_RQST_MST R2" ).append("\n"); 
		query.append("WHERE T2.SR_NO  = R2.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("  AND T2.FAX_LOG_REF_NO = R2.FAX_LOG_REF_NO(+)" ).append("\n"); 
		query.append("  AND T2.max_SEQ  = R2.xter_rqst_seq(+)" ).append("\n"); 

	}
}