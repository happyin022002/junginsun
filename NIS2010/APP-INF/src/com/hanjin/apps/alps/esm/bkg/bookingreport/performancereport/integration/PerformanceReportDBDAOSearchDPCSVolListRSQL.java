/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchDPCSVolListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.01 
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

public class PerformanceReportDBDAOSearchDPCSVolListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchDPCSVolListRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchDPCSVolListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_part_eu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_part_ot",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_part_cn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pic_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpcs_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_mt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_part_jp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pfm_by_queue_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_part",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_part_sw",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchDPCSVolListRSQL").append("\n"); 
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
		query.append("select (I_PNT+R_PNT+Q_PNT+F_PNT+BAS_PNT+RI_PNT+H_PNT+CN_PNT+CM_PNT+RFA_PNT+TAA_PNT+SC_PNT+SELF_PNT+PRE_PNT) tot_pnt" ).append("\n"); 
		query.append("       , COUNT( DISTINCT user_group||CRE_USR_ID) OVER() AS tot_staffs" ).append("\n"); 
		query.append("       , COUNT( DISTINCT SI_NO) OVER()  AS tot_sr_vol" ).append("\n"); 
		query.append("       , COUNT( DISTINCT SI_NO) OVER()  AS tot_sr_kind" ).append("\n"); 
		query.append("       , COUNT( DISTINCT BKG_NO) OVER() AS tot_bkg_vol" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(DPCS_WRK_GRP_CD,'I',SR_STS_CD||CRE_USR_ID)) OVER()  AS tot_staffs_inputter" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(DPCS_WRK_GRP_CD,'R',SR_STS_CD||CRE_USR_ID)) OVER()  AS tot_staffs_rater" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(DPCS_WRK_GRP_CD,'A',SR_STS_CD||CRE_USR_ID)) OVER()  AS tot_staffs_auditor" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(DPCS_WRK_GRP_CD,'F',SR_STS_CD||CRE_USR_ID)) OVER()  AS tot_staffs_fofc" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(DPCS_WRK_GRP_CD,'I',SI_NO)) OVER()  AS tot_sr_vol_inputter" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(DPCS_WRK_GRP_CD,'R',SI_NO)) OVER()  AS tot_sr_vol_rater" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(DPCS_WRK_GRP_CD,'A',SI_NO)) OVER()  AS tot_sr_vol_auditor" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(DPCS_WRK_GRP_CD,'F',SI_NO)) OVER()  AS tot_sr_vol_fofc" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(SR_AMD_TP_CD,'N',SI_NO)) OVER()  AS tot_sr_kind_new" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(SR_AMD_TP_CD,'A',SI_NO)) OVER()  AS tot_sr_kind_amend" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(SR_AMD_TP_CD,'B',SI_NO)) OVER()  AS tot_sr_kind_bl_cnfm" ).append("\n"); 
		query.append("       , COUNT( DISTINCT DECODE(SR_AMD_TP_CD,'T',SI_NO)) OVER()  AS tot_sr_kind_addition" ).append("\n"); 
		query.append("       ,tt.*  " ).append("\n"); 
		query.append("from ( " ).append("\n"); 
		query.append("    SELECT --H.*, R.*" ).append("\n"); 
		query.append("         H.CRE_USR_ID" ).append("\n"); 
		query.append("         ,(SELECT  USR_NM FROM COM_USER WHERE USR_ID = H.CRE_USR_ID) NAME" ).append("\n"); 
		query.append("         ,SR_STS_CD" ).append("\n"); 
		query.append("         ,BKG_COM_INTG_CD_NM_FNC('CD02100',G.DPCS_WRK_GRP_CD) AS user_group" ).append("\n"); 
		query.append("         ,G.DPCS_WRK_GRP_CD" ).append("\n"); 
		query.append("         ,nvl(BKG_COM_INTG_CD_NM_FNC('CD01577',R.SR_AMD_TP_CD),'Original') AS SI_KIND" ).append("\n"); 
		query.append("         ,B.BKG_OFC_CD" ).append("\n"); 
		query.append("          ,BKG_JOIN_FNC(CURSOR(SELECT DISTINCT INTG_CD_VAL_DESC " ).append("\n"); 
		query.append("                               FROM   COM_INTG_CD_DTL COM, BKG_EML_ACCT_STUP S " ).append("\n"); 
		query.append("                               WHERE  1=1 " ).append("\n"); 
		query.append("                               AND    COM.INTG_CD_ID ='CD01603'" ).append("\n"); 
		query.append("                               AND    COM.INTG_CD_VAL_CTNT = DECODE(S.RGN_OFC_CD,'E','DE','J','JP','K','KR','N')" ).append("\n"); 
		query.append("                               AND    S.BKG_OFC_CD = B.BKG_OFC_CD" ).append("\n"); 
		query.append("                   ),'') AS REGION" ).append("\n"); 
		query.append("         ,R.BKG_NO, SR_HIS_SEQ" ).append("\n"); 
		query.append("         ,R.SR_NO as SI_NO" ).append("\n"); 
		query.append("         ,R.SR_AMD_TP_CD" ).append("\n"); 
		query.append("         ,SR_URG_CD AS urgent" ).append("\n"); 
		query.append("         ,R.SR_KND_CD" ).append("\n"); 
		query.append("         ,BKG_COM_INTG_CD_NM_FNC('CD01581',R.SR_KND_CD) AS src" ).append("\n"); 
		query.append("         ,(SELECT COUNT(*) FROM BKG_SR_HIS WHERE SR_STS_CD = 'RR' AND SR_KND_CD = R.SR_KND_CD" ).append("\n"); 
		query.append("                 AND   SR_NO = R.SR_NO" ).append("\n"); 
		query.append("                 AND   BKG_NO  = R.BKG_NO ) AS RTN_FREQ" ).append("\n"); 
		query.append("         ,(SELECT COUNT(*) FROM BKG_SR_HIS WHERE SR_STS_CD = 'ST' AND SR_KND_CD = R.SR_KND_CD" ).append("\n"); 
		query.append("             AND   SR_NO = R.SR_NO" ).append("\n"); 
		query.append("             AND   BKG_NO  = R.BKG_NO ) AS AMEND_FREQ" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("         ,B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("         ,B.POL_CD" ).append("\n"); 
		query.append("         ,B.DEL_CD" ).append("\n"); 
		query.append("         ,(SELECT BKG_RIDER_YN_FNC(R.BKG_NO, '', '1', '1', '') FROM DUAL ) AS RIDER_COUNT" ).append("\n"); 
		query.append("         ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("             FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("            WHERE BKG_NO = B.BKG_NO) AS CM_COUNT" ).append("\n"); 
		query.append("         ,(SELECT  COUNT(*) FROM BKG_CONTAINER WHERE BKG_NO = B.BKG_NO) AS CNTR_CNT" ).append("\n"); 
		query.append("         ,BR.BKG_CTRT_TP_CD --((R : RFA, S : S/C, T : TARIFF))" ).append("\n"); 
		query.append("         ,DECODE(DECODE(SUBSTR(B.RFA_NO,0,3),'DUM',NULL,B.RFA_NO),NULL,DECODE(SC_NO,NULL,DECODE(TAA_NO,NULL,NULL,'TAA'),'S/C'),'RFA') AS RATE_TYPE  --DUMMY 제외 해주세요" ).append("\n"); 
		query.append("         ,(SELECT DECODE(AUD_STS_CD,'Y',1, 0) FROM BKG_RATE WHERE BKG_NO = R.BKG_NO) AS SELF_AUDIT" ).append("\n"); 
		query.append("         ,(SELECT COUNT(1) FROM BKG_CHG_RT WHERE BKG_NO = R.BKG_NO) AS PRE_RATE" ).append("\n"); 
		query.append("         ,NVL(R.BL_DOC_INP_FLG,'N') AS I_FLG, NVL(R.BL_RT_FLG,'N') AS R_FLG" ).append("\n"); 
		query.append("         ,NVL(R.BL_AUD_FLG,'N') AS Q_FLG, NVL(R.BL_DRFT_FAX_OUT_FLG,'N') AS F_FLG ,NVL(R.SR_WRK_STS_CD,'N') AS STS" ).append("\n"); 
		query.append("         ,DECODE(NVL(R.BL_DOC_INP_FLG,'N'),'Y',1,0) AS I_PNT,DECODE( NVL(R.BL_RT_FLG,'N'),'Y',1,0) AS R_PNT" ).append("\n"); 
		query.append("         ,DECODE(NVL(R.BL_AUD_FLG,'N'),'Y',1,0) AS Q_PNT,DECODE(NVL(R.BL_DRFT_FAX_OUT_FLG,'N'),'Y',1,0) AS F_PNT " ).append("\n"); 
		query.append("         ,DECODE(NVL(R.SR_WRK_STS_CD,'N'),'Y',1,0) AS STS_PNT" ).append("\n"); 
		query.append("         ,BKG_JOIN_FNC(CURSOR(SELECT  ATTR_CTNT4 FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                               WHERE HRD_CDG_ID ='DPCS_RPT_WGT' AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT2= R.SR_KND_CD AND ATTR_CTNT3 =SR_AMD_TP_CD ),',') AS BKG_HRD_CDG_CTNT_JOIN" ).append("\n"); 
		query.append("         /*" ).append("\n"); 
		query.append("         * ATTR_CTNT1: SUBSTR(SR_STS_CD,0,1)" ).append("\n"); 
		query.append("         *             I: SI, R:RATE" ).append("\n"); 
		query.append("         */" ).append("\n"); 
		query.append("         ,NVL((SELECT  ATTR_CTNT5 " ).append("\n"); 
		query.append("             FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("            WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("              AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) --i,R" ).append("\n"); 
		query.append("              AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("              AND ATTR_CTNT3 = SR_AMD_TP_CD -- " ).append("\n"); 
		query.append("          ),0) AS BAS_PNT --IFA" ).append("\n"); 
		query.append("         -- RIDER COUNT  는 현재 구할수 없어 현재는 RIDER가 있으면 추가점수는 줌 " ).append("\n"); 
		query.append("         ,CASE WHEN (SELECT BKG_RIDER_YN_FNC(R.BKG_NO, '', '1', '1', '') FROM DUAL ) ='Y' THEN " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5)" ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'R' --" ).append("\n"); 
		query.append("                     ) ,0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END AS RI_PNT " ).append("\n"); 
		query.append("         ,( SELECT NVL(MAX(HBL_SEQ),'0') FROM BKG_HBL WHERE BKG_NO = R.BKG_NO) H_SEQ" ).append("\n"); 
		query.append("         ,CASE WHEN ( SELECT NVL(MAX(HBL_SEQ),'0') FROM BKG_HBL WHERE BKG_NO = R.BKG_NO) >= nvl((" ).append("\n"); 
		query.append("                                                                select ATTR_CTNT4 from BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                                                WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                                                AND ATTR_CTNT1 = SUBSTR(h.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                                                AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                                                AND ATTR_CTNT3 = 'H'" ).append("\n"); 
		query.append("                                                                ), '999') " ).append("\n"); 
		query.append("                AND R.SR_AMD_TP_CD = 'O' THEN  --original 조건 추가 " ).append("\n"); 
		query.append("                    (SELECT  TO_NUMBER(ATTR_CTNT5 )" ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'H' --" ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END AS H_PNT  " ).append("\n"); 
		query.append("         ,CASE WHEN (SELECT COUNT(*) FROM BKG_CNTR_MF_DESC WHERE BKG_NO = B.BKG_NO) >=  nvl((" ).append("\n"); 
		query.append("                                                                select ATTR_CTNT4 from BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                                                WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                                                AND ATTR_CTNT1 = SUBSTR(h.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                                                AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                                                AND ATTR_CTNT3 = 'M'" ).append("\n"); 
		query.append("                                                                ), '999') " ).append("\n"); 
		query.append("                AND R.SR_AMD_TP_CD = 'O' THEN  --original 조건 추가 THEN " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'M' --" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END AS CM_PNT " ).append("\n"); 
		query.append("         ,CASE WHEN (SELECT  COUNT(*) FROM BKG_CONTAINER WHERE BKG_NO = B.BKG_NO) >=  nvl((" ).append("\n"); 
		query.append("                                                                select ATTR_CTNT4 from BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                                                WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                                                AND ATTR_CTNT1 = SUBSTR(h.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                                                AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                                                AND ATTR_CTNT3 = 'N'" ).append("\n"); 
		query.append("                                                                ), '999') " ).append("\n"); 
		query.append("                AND R.SR_AMD_TP_CD = 'O' THEN  --original 조건 추가  " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'N' --" ).append("\n"); 
		query.append("--                         AND ATTR_CTNT4 = '5' --" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END AS CN_PNT" ).append("\n"); 
		query.append("         --rater 의  S,X,R,D,P에대한 추가 점수" ).append("\n"); 
		query.append("         ,CASE when 'RFA' = DECODE(DECODE(SUBSTR(B.RFA_NO,0,3),'DUM',NULL,B.RFA_NO),NULL,DECODE(SC_NO,NULL,DECODE(TAA_NO,NULL,NULL,'TAA'),'S/C'),'RFA')" ).append("\n"); 
		query.append("                AND 'R' = SUBSTR(SR_STS_CD,0,1)  THEN  --original 조건 추가  " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'F' --" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END AS RFA_PNT " ).append("\n"); 
		query.append("         ,CASE when 'TAA' = DECODE(DECODE(SUBSTR(B.RFA_NO,0,3),'DUM',NULL,B.RFA_NO),NULL,DECODE(SC_NO,NULL,DECODE(TAA_NO,NULL,NULL,'TAA'),'S/C'),'RFA')" ).append("\n"); 
		query.append("                AND 'R' = SUBSTR(SR_STS_CD,0,1)  THEN  --original 조건 추가  " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'X' --" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END AS TAA_PNT " ).append("\n"); 
		query.append("         ,CASE when 'S/C' = DECODE(DECODE(SUBSTR(B.RFA_NO,0,3),'DUM',NULL,B.RFA_NO),NULL,DECODE(SC_NO,NULL,DECODE(TAA_NO,NULL,NULL,'TAA'),'S/C'),'RFA')" ).append("\n"); 
		query.append("                AND 'R' = SUBSTR(SR_STS_CD,0,1)  THEN  --original 조건 추가  " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'S' --" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END AS SC_PNT      " ).append("\n"); 
		query.append("         ,CASE when (SELECT  AUD_STS_CD  FROM BKG_RATE WHERE BKG_NO = R.BKG_NO) = 'Y'" ).append("\n"); 
		query.append("                AND 'R' = SUBSTR(SR_STS_CD,0,1)  THEN  --original 조건 추가  " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'D' --" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END AS SELF_PNT                  " ).append("\n"); 
		query.append("         ,CASE when (SELECT COUNT(1) FROM BKG_CHG_RT WHERE BKG_NO = R.BKG_NO) > 0 " ).append("\n"); 
		query.append("                AND 'R' = SUBSTR(SR_STS_CD,0,1)  THEN  --original 조건 추가  " ).append("\n"); 
		query.append("                    NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                        FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                         AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                         AND ATTR_CTNT2 = R.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                         AND ATTR_CTNT3 = 'P' --" ).append("\n"); 
		query.append("                     ),0)" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END AS PRE_PNT    " ).append("\n"); 
		query.append("         ,(COUNT(1) OVER (PARTITION BY B.BKG_NO) ) AS BKG_CNT     " ).append("\n"); 
		query.append("         ,BL_DOC_INP_DT AS IC_END" ).append("\n"); 
		query.append("         ,BL_DOC_INP_ST_DT AS IS_START  " ).append("\n"); 
		query.append("         ,BKG_GET_CONV_INTVAL_TIME_FNC(Decode(H.SR_STS_CD,'ID',H.SR_PROC_HRS,null),'') AS INPUT_ELAPSED     " ).append("\n"); 
		query.append("         ,BL_RT_DT" ).append("\n"); 
		query.append("         ,BL_RT_ST_DT" ).append("\n"); 
		query.append("--         ,TRUNC(BL_RT_DT - BL_RT_ST_DT,2) AS RATE_ELAPSED" ).append("\n"); 
		query.append("         ,BKG_GET_CONV_INTVAL_TIME_FNC(Decode(H.SR_STS_CD,'RD',H.SR_PROC_HRS,null),'') AS RATE_ELAPSED    " ).append("\n"); 
		query.append("--         ,TRUNC(BL_AUD_DT - BL_AUD_ST_DT,2)  AS QA_ELAPSED " ).append("\n"); 
		query.append("         ,BKG_GET_CONV_INTVAL_TIME_FNC(Decode(H.SR_STS_CD,'AD',H.SR_PROC_HRS,null),'') AS QA_ELAPSED     " ).append("\n"); 
		query.append("--         ,TRUNC(BL_DOC_INP_DT-BL_DOC_INP_ST_DT,2) +TRUNC(BL_RT_DT - BL_RT_ST_DT,2)" ).append("\n"); 
		query.append("--          +TRUNC(BL_AUD_DT - BL_AUD_ST_DT,2) AS TOT_ELAPSED " ).append("\n"); 
		query.append("         ,BKG_GET_CONV_INTVAL_TIME_FNC( nvl(Decode(H.SR_STS_CD,'ID',H.SR_PROC_HRS,null),0) +" ).append("\n"); 
		query.append("                                        nvl(Decode(H.SR_STS_CD,'RD',H.SR_PROC_HRS,null),0) +  " ).append("\n"); 
		query.append("                                        nvl(Decode(H.SR_STS_CD,'AD',H.SR_PROC_HRS,null),0) ,'') AS TOT_ELAPSED " ).append("\n"); 
		query.append("    FROM BKG_SR_CRNT_RQST R " ).append("\n"); 
		query.append("         ,BKG_SR_HIS H" ).append("\n"); 
		query.append("         ,BKG_BOOKING B" ).append("\n"); 
		query.append("         ,BKG_RATE BR" ).append("\n"); 
		query.append("         ,BKG_DPCS_USR_GRP G" ).append("\n"); 
		query.append("    WHERE 1=1 " ).append("\n"); 
		query.append("      AND R.DPCS_OFC_CD = @[dpcs_ofc_cd]" ).append("\n"); 
		query.append("      AND R.SR_KND_CD =  H.SR_KND_CD" ).append("\n"); 
		query.append("      AND R.SR_NO =  H.SR_NO" ).append("\n"); 
		query.append("      AND R.BKG_NO =  H.BKG_NO" ).append("\n"); 
		query.append("      AND R.BKG_NO= B.BKG_NO" ).append("\n"); 
		query.append("      AND R.BKG_NO= BR.BKG_NO" ).append("\n"); 
		query.append("      --AND R.SR_CRNT_STS_CD in ('ID','RD','AD')  " ).append("\n"); 
		query.append("      AND ST_DT        >= TO_DATE(@[from_dt]||@[from_mt], 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("      AND ST_DT        <= TO_DATE(@[to_dt]||@[to_mt], 'YYYY-MM-DDHH24:MI')  " ).append("\n"); 
		query.append("      AND B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD LIKE  DECODE(@[vvd_cd], '', '' ,@[vvd_cd])|| '%'" ).append("\n"); 
		query.append("      AND B.POL_CD LIKE DECODE(@[pol_cd], '', B.POL_CD ,@[pol_cd])||'%'" ).append("\n"); 
		query.append("      AND B.POD_CD LIKE DECODE(@[pod_cd], '', B.POD_CD ,@[pod_cd])||'%'" ).append("\n"); 
		query.append("      AND H.ATND_USR_ID  = G.USR_ID" ).append("\n"); 
		query.append("      AND G.DPCS_WRK_GRP_CD IN ('I','R','A')" ).append("\n"); 
		query.append("      AND eXISTS (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        SELECT 'Y' FROM DUAL WHERE 'Y' = @[doc_part]            " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Y' " ).append("\n"); 
		query.append("         FROM BKG_SR_FAX" ).append("\n"); 
		query.append("    	WHERE 'Y' = @[doc_part_eu]" ).append("\n"); 
		query.append("    	  and SR_NO = R.SR_NO" ).append("\n"); 
		query.append("    	  AND SR_KND_CD = R.SR_KND_CD " ).append("\n"); 
		query.append("    	  AND RCV_OFC_CD IN ( SELECT BKG_OFC_CD from BKG_EML_ACCT_STUP where RGN_OFC_CD ='E'  " ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("        union all" ).append("\n"); 
		query.append("        SELECT 'Y' " ).append("\n"); 
		query.append("         FROM BKG_SR_FAX" ).append("\n"); 
		query.append("    	WHERE 'Y' = @[doc_part_jp]" ).append("\n"); 
		query.append("    	  and SR_NO = R.SR_NO" ).append("\n"); 
		query.append("    	  AND SR_KND_CD = R.SR_KND_CD" ).append("\n"); 
		query.append("    	  AND RCV_OFC_CD IN ( SELECT BKG_OFC_CD from BKG_EML_ACCT_STUP where RGN_OFC_CD ='J' " ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("    	union all" ).append("\n"); 
		query.append("    	SELECT 'Y' " ).append("\n"); 
		query.append("         FROM BKG_SR_FAX" ).append("\n"); 
		query.append("    	WHERE 'Y' = @[doc_part_sw]" ).append("\n"); 
		query.append("    	  and SR_NO = R.SR_NO" ).append("\n"); 
		query.append("    	  AND SR_KND_CD = R.SR_KND_CD" ).append("\n"); 
		query.append("    	  AND RCV_OFC_CD IN ( SELECT BKG_OFC_CD from BKG_EML_ACCT_STUP where RGN_OFC_CD ='S'  " ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("    	union all" ).append("\n"); 
		query.append("    	SELECT 'Y' " ).append("\n"); 
		query.append("         FROM BKG_SR_FAX" ).append("\n"); 
		query.append("    	WHERE 'Y' = @[doc_part_cn]" ).append("\n"); 
		query.append("    	  and SR_NO = R.SR_NO" ).append("\n"); 
		query.append("    	  AND SR_KND_CD = R.SR_KND_CD" ).append("\n"); 
		query.append("    	  AND RCV_OFC_CD IN ( SELECT BKG_OFC_CD from BKG_EML_ACCT_STUP where RGN_OFC_CD ='C'  " ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("        union all" ).append("\n"); 
		query.append("        SELECT 'Y' " ).append("\n"); 
		query.append("         FROM BKG_SR_FAX" ).append("\n"); 
		query.append("    	WHERE 'Y' = @[doc_part_ot]" ).append("\n"); 
		query.append("    	  and SR_NO = R.SR_NO" ).append("\n"); 
		query.append("    	  AND SR_KND_CD = R.SR_KND_CD" ).append("\n"); 
		query.append("    	  AND RCV_OFC_CD NOT IN ( SELECT BKG_OFC_CD from BKG_EML_ACCT_STUP where RGN_OFC_CD ='O'" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      and h.sr_sts_cd in (" ).append("\n"); 
		query.append("                            DECODE(@[pfm_by_queue_cd], 'S', 'ST','ID')," ).append("\n"); 
		query.append("                            DECODE(@[pfm_by_queue_cd], 'S', 'ST','RD')," ).append("\n"); 
		query.append("                            DECODE(@[pfm_by_queue_cd], 'S', 'ST','AD')" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("       AND G.DPCS_WRK_GRP_CD like ( decode(@[pfm_by_queue_cd], '%', G.DPCS_WRK_GRP_CD," ).append("\n"); 
		query.append("                                            (select DPCS_WRK_GRP_CD FROM BKG_DPCS_USR_GRP WHERE USR_ID = @[usr_id])" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("                                  )||'%'                 " ).append("\n"); 
		query.append("      AND R.BKG_NO       = decode(@[bkg_no], '',R.BKG_NO, @[bkg_no])" ).append("\n"); 
		query.append("      AND R.SR_AMD_TP_CD  = decode(@[sr_knd_cd], 'L', R.SR_AMD_TP_CD, @[sr_knd_cd])" ).append("\n"); 
		query.append("      and sign(instr(r.BL_DOC_INP_USR_ID||r.BL_RT_USR_ID||r.BL_AUD_USR_ID||r.BL_DRFT_FAX_OUT_USR_ID||r.CRE_USR_ID ," ).append("\n"); 
		query.append("                decode(@[pic_cd], '',r.BL_DOC_INP_USR_ID||r.BL_RT_USR_ID||r.BL_AUD_USR_ID||r.BL_DRFT_FAX_OUT_USR_ID||r.CRE_USR_ID" ).append("\n"); 
		query.append("                                  ,@[pic_cd]))" ).append("\n"); 
		query.append("              ) >0 " ).append("\n"); 
		query.append(") tt" ).append("\n"); 

	}
}