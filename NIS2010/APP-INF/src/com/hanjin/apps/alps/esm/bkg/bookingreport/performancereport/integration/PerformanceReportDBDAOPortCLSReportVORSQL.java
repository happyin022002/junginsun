/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOPortCLSReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.15 
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

public class PerformanceReportDBDAOPortCLSReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PCT (Port Closing Time)내 Rating 현황 Report 산출 메뉴
	  * </pre>
	  */
	public PerformanceReportDBDAOPortCLSReportVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rows_per_page",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gso",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_conti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_stf",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate_check",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brh_cfm_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_page",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOPortCLSReportVORSQL").append("\n"); 
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
		query.append("#if (${report_type} != 'VO')" ).append("\n"); 
		query.append("WITH TEMP_T AS ( " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("SELECT ROWNUM  AS RNUM" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append(",       BK.BKG_NO              							    BKG_NO              --예약 번호" ).append("\n"); 
		query.append(",       BK.BL_NO                         							 BL_NO               --B/L 번호" ).append("\n"); 
		query.append(",       BK.SHPR_CD                                                   --Shipper" ).append("\n"); 
		query.append(",       BK.SHPR_NM                                           SHPR_NM             --Shipper" ).append("\n"); 
		query.append(",       BK.POR_CD" ).append("\n"); 
		query.append(",       BK.POL_CD                                                    POL_CD              --Port of Loading (선적항)" ).append("\n"); 
		query.append(",       BK.POD_CD" ).append("\n"); 
		query.append(",       BK.DEL_CD" ).append("\n"); 
		query.append(",       BK.BRH_CFM_IND  							                 BRH_CFM_IND     --Rating STS" ).append("\n"); 
		query.append(",		CASE WHEN BK.BRH_CFM_IND = 'F' THEN 'Charged' ELSE 'Non-Charged' END BRH_CFM_IND_NM" ).append("\n"); 
		query.append(",       TO_CHAR(BK.PORT_CLZ_DT,'YYYY-MM-DD')                        PCT                 --Port Closing Time" ).append("\n"); 
		query.append(",       TO_CHAR(BK.ACT_DEP_DT,'YYYY-MM-DD')                         ATD                 --출항일 (Actual Departure Date)" ).append("\n"); 
		query.append(",       TO_CHAR(BK.VPS_ETD_DT,'YYYY-MM-DD')                         ETD                 --출항예정일 (Estimated Departure date)" ).append("\n"); 
		query.append(",       TO_CHAR(BK.VPS_ETB_DT,'YYYY-MM-DD')                         ETB                 --선박이 Port에 접안할 예상 날짜( ESTIMATED BERTHING DATE )" ).append("\n"); 
		query.append(",       TO_CHAR(BK.BKG_CRE_DT,'YYYY-MM-DD')                         BKG_DATE" ).append("\n"); 
		query.append(",       VVD_CD              --Vessel / Voyage / Direction" ).append("\n"); 
		query.append(",		BK.VPS_SLAN_CD												 BKG_LANE" ).append("\n"); 
		query.append(",		BK.REV_STATUS												LANE_IND" ).append("\n"); 
		query.append(",       BK.BKG_STS_CD                                                BKG_STS_CD          --예약 현황" ).append("\n"); 
		query.append(",       BK.SI_FLG                             						 SI_FLG              --S/R 접수 여부" ).append("\n"); 
		query.append(",		BK.OB_SLS_OFC_CD											 OB_SLS_OFC_CD" ).append("\n"); 
		query.append(",       BK.OB_SREP_CD                                                OB_SREP_CD          --Sales Rep Code " ).append("\n"); 
		query.append(",		BK.CTRT_OFC_CD												 CTRT_OFC_CD" ).append("\n"); 
		query.append(",		BK.CTRT_SREP_CD												 CTRT_SREP_CD" ).append("\n"); 
		query.append(",		DECODE(BK.INDIV_PSON_FLG,'Y',NVL(BK.CNEE_CD,'Individual'),BK.CNEE_CD) CNEE_CD" ).append("\n"); 
		query.append(",       DECODE(BK.INDIV_PSON_FLG,'Y',NVL(BK.CNEE_NM,BK.INDIV_CUST_NM),BK.CNEE_NM)  CNEE_NM" ).append("\n"); 
		query.append(",       BK.BKG_OFC_CD                                                BKG_OFC_CD          --예약 점소" ).append("\n"); 
		query.append(",		BK.GSO                                                      GSO" ).append("\n"); 
		query.append(",       BK.DOC_USR_ID                                                BKG_STF             --예약 담당자 (아이디)" ).append("\n"); 
		query.append(",       BK.CTRT_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* 2015.06.01  [CHM-201536166]downexcel에 Contract party code & name 추가 */" ).append("\n"); 
		query.append(", BK.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append(", BK.CTRT_CUST_SEQ  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",       CASE WHEN INSTR(BK.CTRT_NO,'DUM') > 0 THEN 'Y' ELSE 'N' END DUMMY_FLAG" ).append("\n"); 
		query.append(",       BKG_DOC_PROC_TP_CD AS CNTR_CFM_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",       BK.SC_NO" ).append("\n"); 
		query.append(",       BK.RFA_NO" ).append("\n"); 
		query.append(",		BK.TAA_NO" ).append("\n"); 
		query.append(",		BK.CMDT_CD" ).append("\n"); 
		query.append(",		BK.CMDT_NM" ).append("\n"); 
		query.append(",		BK.RATE_CHECK" ).append("\n"); 
		query.append(",	    '' RHQ_CD" ).append("\n"); 
		query.append(",		'' ROWS_PER_PAGE" ).append("\n"); 
		query.append(",		'' CURR_PAGE" ).append("\n"); 
		query.append(",       NON_RT_STS_CD " ).append("\n"); 
		query.append(",       NON_RT_STS_CD  AS NO_RT_STS     " ).append("\n"); 
		query.append(",       BK.RTRO_KND_CD /* 2015.01.20 추가  CHM-201433206 Retroactive OFT 적용 및 변경시 모니터링 시스템 개발 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* 2015.03.30 Port Closing Status Report에 Rates by ID, Cntr confirm by ID 추가 */" ).append("\n"); 
		query.append(",       ( SELECT UPD_USR_ID " ).append("\n"); 
		query.append("			FROM BKG_CHG_RT BCR" ).append("\n"); 
		query.append("		   WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("			 AND AUTO_RAT_CD <> 'I'" ).append("\n"); 
		query.append("			 AND RT_SEQ = ( SELECT MAX(RT_SEQ) FROM BKG_CHG_RT BCR_T WHERE BCR_T.BKG_NO = BCR.BKG_NO AND BCR_T.AUTO_RAT_CD <> 'I')" ).append("\n"); 
		query.append("		 ) AS RT_BY_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",       ( SELECT EVNT_USR_ID " ).append("\n"); 
		query.append("			FROM BKG_DOC_PROC_SKD TT1" ).append("\n"); 
		query.append("		   WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		     AND BKG_DOC_PROC_TP_CD = 'CNTCFM'" ).append("\n"); 
		query.append("			 AND DOC_PERF_DELT_FLG = 'N'  " ).append("\n"); 
		query.append("             AND ROWNUM =1 /* 최근 것이 아니면 모두 N 이나 에러 방지를 위해서 체크 함 */" ).append("\n"); 
		query.append("		) AS CNTR_CFM_BY_ID" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("               #if (${dt_type} == 'ETD') " ).append("\n"); 
		query.append("					/*+ LEADING(VPS VVD BK LVL) */  /* TG TUNING 1 2015.11.10 */" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                BK.*" ).append("\n"); 
		query.append("        ,VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("        ,      (SELECT ACT_DEP_DT FROM VSK_ACT_PORT_SKD VAP" ).append("\n"); 
		query.append("					WHERE 1=1" ).append("\n"); 
		query.append("					AND VPS.VSL_CD = VAP.VSL_CD" ).append("\n"); 
		query.append("					AND VPS.SKD_VOY_NO = VAP.SKD_VOY_NO" ).append("\n"); 
		query.append("					AND VPS.SKD_DIR_CD = VAP.SKD_DIR_CD" ).append("\n"); 
		query.append("					AND VPS.VPS_PORT_CD = VAP.VPS_PORT_CD" ).append("\n"); 
		query.append("					AND VPS.CLPT_IND_SEQ = VAP.CLPT_IND_SEQ" ).append("\n"); 
		query.append("					AND ROWNUM = 1" ).append("\n"); 
		query.append("				) ACT_DEP_DT" ).append("\n"); 
		query.append("        ,       VPS.VPS_ETD_DT" ).append("\n"); 
		query.append("        ,       VPS.VPS_ETB_DT" ).append("\n"); 
		query.append("        ,       VPS.SLAN_CD AS  VPS_SLAN_CD" ).append("\n"); 
		query.append("        ,       BKG_RATE_RESULT_FNC(BK.BKG_NO)  							 BRH_CFM_IND" ).append("\n"); 
		query.append("        ,       CASE WHEN BK.SC_NO IS NULL AND BK.RFA_NO IS NULL  THEN BK.TAA_NO" ).append("\n"); 
		query.append("                WHEN BK.SC_NO IS NULL THEN BK.RFA_NO" ).append("\n"); 
		query.append("                ELSE BK.SC_NO" ).append("\n"); 
		query.append("                END CTRT_NO" ).append("\n"); 
		query.append("                ,		NVL((SELECT DECODE(K.BKG_DOC_PROC_TP_CD,'CNTCFM','Y','N')" ).append("\n"); 
		query.append("                FROM BKG_DOC_PROC_SKD K" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND   K.DOC_PERF_DELT_FLG ='N'" ).append("\n"); 
		query.append("                AND   K.BKG_DOC_PROC_TP_CD IN ('CNTCFM','CNTRLS')" ).append("\n"); 
		query.append("                and   k.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("                AND     K.DOC_PROC_SEQ = (SELECT MAX(DOC_PROC_SEQ)" ).append("\n"); 
		query.append("                FROM BKG_DOC_PROC_SKD Y" ).append("\n"); 
		query.append("                WHERE K.BKG_NO = Y.BKG_NO" ).append("\n"); 
		query.append("                AND Y.BKG_DOC_PROC_TP_CD IN ('CNTCFM','CNTRLS')" ).append("\n"); 
		query.append("                AND Y.DOC_PERF_DELT_FLG ='N'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                ),'N') BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,       TRIM(SC.CUST_CNT_CD)||TRIM(TO_CHAR(SC.CUST_SEQ, '000000'))   SHPR_CD             --Shipper" ).append("\n"); 
		query.append("        ,       SC.CUST_LGL_ENG_NM                                           SHPR_NM             --Shipper" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,       ( SELECT TRIM(MC.CUST_CNT_CD)||TRIM(TO_CHAR(MC.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("                    FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                     AND DECODE(BK.CUST_TO_ORD_FLG,'Y',N.CUST_CNT_CD,C.CUST_CNT_CD) =   MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND DECODE(BK.CUST_TO_ORD_FLG,'Y',N.CUST_SEQ,C.CUST_SEQ) =   MC.CUST_SEQ " ).append("\n"); 
		query.append("                 ) CNEE_CD" ).append("\n"); 
		query.append("        ,       ( SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                    FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                     AND DECODE(BK.CUST_TO_ORD_FLG,'Y',N.CUST_CNT_CD,C.CUST_CNT_CD) =   MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND DECODE(BK.CUST_TO_ORD_FLG,'Y',N.CUST_SEQ,C.CUST_SEQ) =   MC.CUST_SEQ " ).append("\n"); 
		query.append("                 ) CNEE_NM" ).append("\n"); 
		query.append("        ,       C.CUST_NM INDIV_CUST_NM" ).append("\n"); 
		query.append("        ,       NVL(( SELECT 'Y'" ).append("\n"); 
		query.append("                FROM MDM_DTL_REV_LANE" ).append("\n"); 
		query.append("                WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND BK.SLAN_CD = SUBSTR(RLANE_CD, 1, 3)" ).append("\n"); 
		query.append("                AND ROWNUM = 1 ),'N') REV_STATUS" ).append("\n"); 
		query.append("        ,       LVL.GSO" ).append("\n"); 
		query.append("        ,       M.CMDT_NM" ).append("\n"); 
		query.append("        ,       CASE WHEN BK.CRE_DT >= TO_DATE('20141125','YYYYMMDD') THEN BR.OFT_MSS_FLG " ).append("\n"); 
		query.append("                     WHEN SUBSTR(BK.SC_NO,1,3) = 'DUM' OR SUBSTR(BK.RFA_NO,1,3) = 'DUM' OR SUBSTR(BK.TAA_NO,1,3) = 'DUM' THEN 'Y'" ).append("\n"); 
		query.append("                     WHEN BR.OFT_MSS_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("					 WHEN BR.OFT_MSS_FLG = 'Y' THEN NVL((SELECT 'N' " ).append("\n"); 
		query.append("														 FROM BKG_CHG_RT RT " ).append("\n"); 
		query.append("														 WHERE RT.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("														 AND ROWNUM = 1), 'Y') " ).append("\n"); 
		query.append("                END AS RATE_CHECK" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("        FROM    BKG_BOOKING BK" ).append("\n"); 
		query.append("        ,       BKG_VVD         VVD" ).append("\n"); 
		query.append("        ,       VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("        ,       BKG_CUSTOMER    S" ).append("\n"); 
		query.append("        ,       BKG_RATE        BR" ).append("\n"); 
		query.append("        ,       MDM_CUSTOMER    SC" ).append("\n"); 
		query.append("        ,       BKG_CUSTOMER    C" ).append("\n"); 
		query.append("        ,       BKG_CUSTOMER    N" ).append("\n"); 
		query.append("        ,       MDM_LOCATION    L" ).append("\n"); 
		query.append("        ,       MDM_COMMODITY   M" ).append("\n"); 
		query.append("        ,       ( SELECT  /*+ NO_MERGE */ LVL.* /* TG TUNING 2 2015.11.10 */" ).append("\n"); 
		query.append("					FROM BKG_OFC_LVL_V  LVL " ).append("\n"); 
		query.append("				   WHERE 1=1" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')  " ).append("\n"); 
		query.append("					 AND LVL.REGION = @[rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gso} != '')  " ).append("\n"); 
		query.append(" 					 AND LVL.GSO      =   @[gso]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				)    LVL" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')  " ).append("\n"); 
		query.append(" 		AND    BK.BKG_OFC_CD      =   @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '')  " ).append("\n"); 
		query.append("		 /* ob_ofc_cd, l_ofc_cd_sub */" ).append("\n"); 
		query.append("			#if(${l_ofc_cd_sub} != '')" ).append("\n"); 
		query.append("				 AND	BK.OB_SLS_OFC_CD   IN ( SELECT OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("															 FROM   DMT_OFC_LVL_V /* BKG BST(0103)REPORT와 체크 조건을 동일하게 하기 위해 DMT 뷰를 사용함.*/" ).append("\n"); 
		query.append("															 WHERE @[ob_sls_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("																						OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD)" ).append("\n"); 
		query.append("														 )" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("		 		AND    BK.OB_SLS_OFC_CD  =   @[ob_sls_ofc_cd]  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '')  " ).append("\n"); 
		query.append(" 		AND    BK.OB_SREP_CD      =   @[ob_srep_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '')  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 /* ctrt_ofc_cd, c_ofc_cd_sub */" ).append("\n"); 
		query.append("			#if(${c_ofc_cd_sub} != '')" ).append("\n"); 
		query.append("				 AND	BK.CTRT_OFC_CD   IN ( SELECT OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("															 FROM   DMT_OFC_LVL_V /* BKG BST(0103)REPORT와 체크 조건을 동일하게 하기 위해 DMT 뷰를 사용함.*/" ).append("\n"); 
		query.append("															 WHERE @[ctrt_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("																													OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD)" ).append("\n"); 
		query.append("														 )" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("		 		AND    BK.CTRT_OFC_CD      =   @[ctrt_ofc_cd]  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ctrt_srep_cd} != '')  " ).append("\n"); 
		query.append(" 		AND    BK.CTRT_SREP_CD      =   @[ctrt_srep_cd]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if (${dt_type} == 'ETD') " ).append("\n"); 
		query.append("	#if (${atd} != '')     " ).append("\n"); 
		query.append("	     AND    VPS.VPS_ETD_DT      >=  TO_DATE(@[atd],'yyyy-mm-dd')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${etd} != '') " ).append("\n"); 
		query.append("	     AND    VPS.VPS_ETD_DT      <=  TO_DATE(@[etd],'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("	#end   " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	#if (${atd} != '')     " ).append("\n"); 
		query.append("	     AND    BK.PORT_CLZ_DT      >=  TO_DATE(@[atd],'yyyy-mm-dd')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${etd} != '') " ).append("\n"); 
		query.append("	     AND    BK.PORT_CLZ_DT      <=  TO_DATE(@[etd],'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("	#end   " ).append("\n"); 
		query.append("#end	    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("	     AND	VVD.VSL_CD          =   SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("	     AND    VVD.SKD_VOY_NO      =   SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("   	     AND    VVD.SKD_DIR_CD      =   SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_stf} != '') " ).append("\n"); 
		query.append(" 		AND    UPPER(BK.DOC_USR_ID)       =   UPPER(@[bkg_stf])" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnee_cd} != '') " ).append("\n"); 
		query.append(" 	AND   ( SELECT TRIM(MC.CUST_CNT_CD)||TRIM(TO_CHAR(MC.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("                    FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                     AND DECODE(BK.CUST_TO_ORD_FLG,'Y',N.CUST_CNT_CD,C.CUST_CNT_CD) =   MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND DECODE(BK.CUST_TO_ORD_FLG,'Y',N.CUST_SEQ,C.CUST_SEQ) =   MC.CUST_SEQ " ).append("\n"); 
		query.append("                 ) LIKE   @[cnee_cd] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '') " ).append("\n"); 
		query.append(" AND     BK.BKG_STS_CD       =  @[bkg_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append(" AND	VVD.POL_CD         =   @[pol_cd]" ).append("\n"); 
		query.append(" AND    VPS.VPS_PORT_CD     =  @[pol_cd]" ).append("\n"); 
		query.append(" AND    BK.POL_CD		   =   @[pol_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" AND     BK.POL_CD		        =  VVD.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${no_rt_sts} == 'R') " ).append("\n"); 
		query.append(" AND BK.NON_RT_STS_CD = 'R'" ).append("\n"); 
		query.append("#elseif (${no_rt_sts} == 'F') " ).append("\n"); 
		query.append(" AND BK.NON_RT_STS_CD = 'F'" ).append("\n"); 
		query.append("#elseif (${no_rt_sts} == 'P') " ).append("\n"); 
		query.append(" AND BK.NON_RT_STS_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${spot_gid_rfa_cd} == 'Y') " ).append("\n"); 
		query.append(" AND SUBSTR(RFA_NO,6,1) = 'G' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* 2015.01.20 추가  CHM-201433206 Retroactive OFT 적용 및 변경시 모니터링 시스템 개발 */" ).append("\n"); 
		query.append("#if (${rtro_knd_cd} != '') " ).append("\n"); 
		query.append(" AND BK.RTRO_KND_CD IN (${rtro_knd_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_conti} != '')" ).append("\n"); 
		query.append(" AND L.CONTI_CD = @[del_conti]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${aloc_sts_cd} != '')" ).append("\n"); 
		query.append("  AND BK.ALOC_STS_CD = @[aloc_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND BK.DEL_CD = L.LOC_CD(+)" ).append("\n"); 
		query.append("        AND BK.CMDT_CD = M.CMDT_CD(+)" ).append("\n"); 
		query.append("        AND     BK.BKG_NO           =   VVD.BKG_NO" ).append("\n"); 
		query.append("        AND     VPS.VSL_CD          =   VVD.VSL_CD" ).append("\n"); 
		query.append("        AND     VPS.SKD_VOY_NO      =   VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     VPS.SKD_DIR_CD      =   VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     VPS.CLPT_IND_SEQ    =    VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND	    VPS.VPS_PORT_CD     =   VVD.POL_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        AND     BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("        AND     BK.BKG_STS_CD      <>  'X'" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("        AND     BK.BKG_NO           =   S.BKG_NO" ).append("\n"); 
		query.append("        AND     S.BKG_CUST_TP_CD    =   'S'" ).append("\n"); 
		query.append("        AND     S.CUST_CNT_CD          =   SC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("        AND     S.CUST_SEQ             =   SC.CUST_SEQ(+)" ).append("\n"); 
		query.append("        AND     BK.BKG_NO              =   C.BKG_NO" ).append("\n"); 
		query.append("        AND     C.BKG_CUST_TP_CD   =   'C'" ).append("\n"); 
		query.append("        AND     BK.BKG_NO           =   N.BKG_NO" ).append("\n"); 
		query.append("        AND     N.BKG_CUST_TP_CD    =   'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		/* 2015.05.13 ofc_tp_cd 추가  */" ).append("\n"); 
		query.append("		#if(${ofc_tp_cd} == 'B')" ).append("\n"); 
		query.append("			AND     BK.BKG_OFC_CD = LVL.OFC_CD" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND     BK.CTRT_OFC_CD = LVL.OFC_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND     BK.BKG_NO = BR.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    /* TG TUNING 2 2015.11.10 */" ).append("\n"); 
		query.append("	#if (${rate_check} != '')" ).append("\n"); 
		query.append("        AND  CASE WHEN BK.CRE_DT >= TO_DATE('20141125','YYYYMMDD') THEN BR.OFT_MSS_FLG " ).append("\n"); 
		query.append("                  WHEN SUBSTR(BK.SC_NO,1,3) = 'DUM' OR SUBSTR(BK.RFA_NO,1,3) = 'DUM' OR SUBSTR(BK.TAA_NO,1,3) = 'DUM' THEN 'Y'" ).append("\n"); 
		query.append("                  WHEN BR.OFT_MSS_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("				  WHEN BR.OFT_MSS_FLG = 'Y' THEN NVL( ( SELECT 'N' " ).append("\n"); 
		query.append("														FROM  BKG_CHG_RT  RT " ).append("\n"); 
		query.append("														WHERE RT.BKG_NO  = BK.BKG_NO " ).append("\n"); 
		query.append("														AND ROWNUM = 1), 'Y')  end = @[rate_check]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND		ROWNUM < 70000" ).append("\n"); 
		query.append("        ORDER BY BK.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") BK      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${brh_cfm_ind} != '' && ${brh_cfm_ind} == 'F')" ).append("\n"); 
		query.append(" AND   BK.BRH_CFM_IND =  @[brh_cfm_ind]" ).append("\n"); 
		query.append("#elseif(${brh_cfm_ind} != '' && ${brh_cfm_ind} == 'N') " ).append("\n"); 
		query.append("  AND  BK.BRH_CFM_IND =  @[brh_cfm_ind]	" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ctrt_no} != '') " ).append("\n"); 
		query.append(" AND	BK.CTRT_NO LIKE @[ctrt_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_cfm_flg} != '') " ).append("\n"); 
		query.append(" AND	BK.BKG_DOC_PROC_TP_CD = @[cntr_cfm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != 'All')" ).append("\n"); 
		query.append("AND	BK.VPS_SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${report_type} == '') " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("SELECT T.*," ).append("\n"); 
		query.append("      /* 2015.06.01  Contract party code & name 추가*/" ).append("\n"); 
		query.append("       NVL(T.CTRT_CUST_CNT_CD,'00')||TRIM(TO_CHAR(T.CTRT_CUST_SEQ,'000000')) CTRT_CUST_CD" ).append("\n"); 
		query.append("      , ( SELECT CTRT.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("            FROM MDM_CUSTOMER CTRT" ).append("\n"); 
		query.append("           WHERE CTRT.CUST_CNT_CD = T.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("             AND CTRT.CUST_SEQ    = T.CTRT_CUST_SEQ " ).append("\n"); 
		query.append("         ) AS CTRT_CUST_NM " ).append("\n"); 
		query.append("FROM TEMP_T T " ).append("\n"); 
		query.append("WHERE RNUM BETWEEN NVL(@[rows_per_page],50) * (NVL(@[curr_page],1) - 1) + 1" ).append("\n"); 
		query.append("           AND     NVL(@[rows_per_page],50) *  NVL(@[curr_page],1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${report_type} == 'SUM') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   TRIM(TO_CHAR(T2.TOTAL_CNT, '999,999,999')) AS NO_RT_TOT_CNT" ).append("\n"); 
		query.append(",  TRIM(TO_CHAR(T2.TOTAL_CNT-T2.NO_RT_CNT, '999,999,999'))  AS NO_RT_FRM_CNT" ).append("\n"); 
		query.append(",  TRIM(TO_CHAR(T2.NO_RT_CNT, '999,999,999'))  AS NO_RT_CNT" ).append("\n"); 
		query.append(",  DECODE(T2.TOTAL_CNT,0,'0',TRIM(TO_CHAR(NVL(T2.NO_RT_CNT / T2.TOTAL_CNT * 100,0),'99990.99'))) || '%'  AS NO_RT_PERCENT" ).append("\n"); 
		query.append(",  T2.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	  1 AS  RNUM	" ).append("\n"); 
		query.append(",	  nvl(COUNT(BKG_NO),0) AS TOTAL_CNT" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(COUNT(BKG_NO),0), '999,999,999')) AS BK_TOT_CNT" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(COUNT(BKG_NO),0), '999,999,999')) AS RT_TOT_CNT" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(COUNT(BKG_NO),0), '999,999,999')) AS CNTR_TOT_CNT" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(COUNT(BKG_NO),0), '999,999,999')) AS CN_TOT_CNT" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(COUNT(BKG_NO),0), '999,999,999')) AS CONT_TOT_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(SUM(DECODE(BKG_STS_CD,'W',0,1)),0), '999,999,999')) AS BK_CHARGE_CNT" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(SUM(DECODE(BRH_CFM_IND,'F',1,0)),0), '999,999,999'))  AS RT_FIRM_CNT" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(SUM(DECODE(CNTR_CFM_FLG,'Y',1,0)),0), '999,999,999'))  AS CNTR_FIRM_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(SUM(DECODE(NVL(CNEE_CD,' '),' ',0,1)),0), '999,999,999'))  AS CN_CODE_CNT" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(SUM(CASE WHEN NVL(CTRT_NO,' ') <> ' ' AND DUMMY_FLAG != 'Y' THEN 1 ELSE 0 END),0), '999,999,999'))  AS CONT_ACT_CNT" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(SUM(CASE WHEN DUMMY_FLAG = 'Y' THEN 1 ELSE 0 END),0), '999,999,999'))  AS CONT_DUMMY_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",     NVL(SUM(CASE WHEN NVL(NON_RT_STS_CD,'F' ) = 'R' THEN 1 ELSE 0 END),0)  AS NO_RT_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*cntr_tot_cnt - cntr_firm_cnt;*/" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(COUNT(BKG_NO) - SUM(DECODE(CNTR_CFM_FLG,'Y',1,0)),0), '999,999,999')) AS CNTR_BALANCE_CNT" ).append("\n"); 
		query.append("/*cn_tot_cnt - cn_code_cnt;*/" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(COUNT(BKG_NO) - SUM(DECODE(NVL(CNEE_CD,' '),' ',0,1)),0), '999,999,999')) AS  CN_BALANCE_CNT" ).append("\n"); 
		query.append("/*cont_tot_cnt - cont_act_cnt - cont_dummy_cnt;*/" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(COUNT(BKG_NO) - SUM(CASE WHEN NVL(CTRT_NO,' ') <> ' ' AND DUMMY_FLAG != 'Y' THEN 1 ELSE 0 END) - SUM(CASE WHEN DUMMY_FLAG = 'Y' THEN 1 ELSE 0 END),0), '999,999,999')) AS  CONT_BALANCE_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*bk_tot_cnt -bk_charge_cnt*/" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(COUNT(BKG_NO) - SUM(DECODE(BKG_STS_CD,'W',0,1)),0), '999,999,999')) AS BK_NON_CHARGE_CNT" ).append("\n"); 
		query.append("/*rt_tot_cnt -rt_charge_cnt*/" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl(COUNT(BKG_NO) - SUM(DECODE(BRH_CFM_IND,'F',1,0)),0), '999,999,999')) AS RT_NON_CHARGE_CNT" ).append("\n"); 
		query.append("/*ComRound(bk_non_charge_cnt/bk_tot_cnt*100)+'%';*/" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl((COUNT(BKG_NO) - SUM(DECODE(BKG_STS_CD,'W',0,1))) / COUNT(BKG_NO) * 100,0),'99990.99')) || '%' AS  BK_PERCENT" ).append("\n"); 
		query.append("/*ComRound(rt_non_charge_cnt/rt_tot_cnt*100)+'%';*/" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl((COUNT(BKG_NO) - SUM(DECODE(BRH_CFM_IND,'F',1,0))) / COUNT(BKG_NO) * 100,0),'99990.99')) || '%'  AS  RT_PERCENT" ).append("\n"); 
		query.append("/*ComRound(cntr_balance_cnt/cntr_tot_cnt*100)+'%';*/" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl((COUNT(BKG_NO) - SUM(DECODE(CNTR_CFM_FLG,'Y',1,0))) / COUNT(BKG_NO) * 100,0),'99990.99')) || '%' AS CNTR_PERCENT" ).append("\n"); 
		query.append("/*ComRound(cn_balance_cnt/cn_tot_cnt*100)+'%';	*/" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl((COUNT(BKG_NO) - SUM(DECODE(NVL(CNEE_CD,' '),' ',0,1))) / COUNT(BKG_NO) * 100,0),'99990.99')) || '%'  AS CN_PERCENT" ).append("\n"); 
		query.append("/*ComRound(cont_balance_cnt/cont_tot_cnt*100)+'%';*/" ).append("\n"); 
		query.append(",     TRIM(TO_CHAR(nvl((COUNT(BKG_NO) -  SUM(CASE WHEN NVL(CTRT_NO,' ') <> ' ' AND DUMMY_FLAG != 'Y' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("		- SUM(CASE WHEN DUMMY_FLAG = 'Y' THEN 1 ELSE 0 END)) / COUNT(BKG_NO) * 100,0),'99990.99')) || '%'  AS CONT_PERCENT" ).append("\n"); 
		query.append("FROM TEMP_T T " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* 2014.10.28 No Rate 추가*/" ).append("\n"); 
		query.append(") T2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-----------------------------------------------------------------------------------" ).append("\n"); 
		query.append("#elseif (${report_type} == 'VO') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 	' ' RNUM" ).append("\n"); 
		query.append(",	' ' BKG_NO" ).append("\n"); 
		query.append(",	' ' BL_NO" ).append("\n"); 
		query.append(",	' ' SHPR_CD" ).append("\n"); 
		query.append(",	' ' SHPR_NM" ).append("\n"); 
		query.append(",	' ' POL_CD" ).append("\n"); 
		query.append(",	' ' BRH_CFM_IND" ).append("\n"); 
		query.append(",	' ' BRH_CFM_IND_NM" ).append("\n"); 
		query.append(",	' ' PCT" ).append("\n"); 
		query.append(",	' ' ATD" ).append("\n"); 
		query.append(",	' ' ETD" ).append("\n"); 
		query.append(",	' ' BKG_DATE" ).append("\n"); 
		query.append(",	' ' VVD_CD" ).append("\n"); 
		query.append(",	' ' BKG_LANE" ).append("\n"); 
		query.append(",	' ' LANE_IND" ).append("\n"); 
		query.append(",	' ' BKG_STS_CD" ).append("\n"); 
		query.append(",	' ' SI_FLG" ).append("\n"); 
		query.append(",	' ' CNEE_CD" ).append("\n"); 
		query.append(",	' ' CNEE_NM" ).append("\n"); 
		query.append(",	' ' BKG_OFC_CD" ).append("\n"); 
		query.append(",   ' ' MDM_OFC_CD" ).append("\n"); 
		query.append(",	' ' BKG_STF" ).append("\n"); 
		query.append(",	' ' CTRT_NO" ).append("\n"); 
		query.append(",	' ' DUMMY_FLAG" ).append("\n"); 
		query.append(",	' ' CNTR_CFM_FLG" ).append("\n"); 
		query.append(",	' ' SC_NO" ).append("\n"); 
		query.append(",	' ' RFA_NO" ).append("\n"); 
		query.append(",	' ' TAA_NO" ).append("\n"); 
		query.append(",	' ' RHQ_CD" ).append("\n"); 
		query.append(",	' ' ROWS_PER_PAGE" ).append("\n"); 
		query.append(",	' ' CURR_PAGE" ).append("\n"); 
		query.append(",	' ' TOTAL_CNT" ).append("\n"); 
		query.append(",	' ' TOT_CNT " ).append("\n"); 
		query.append(",	' ' TOTAL_CNT" ).append("\n"); 
		query.append(",   ' ' BK_TOT_CNT   " ).append("\n"); 
		query.append(",   ' ' RT_TOT_CNT  " ).append("\n"); 
		query.append(",   ' ' CNTR_TOT_CNT   " ).append("\n"); 
		query.append(",   ' ' CN_TOT_CNT " ).append("\n"); 
		query.append(",   ' ' CONT_TOT_CNT " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(",	' ' BK_CHARGE_CNT" ).append("\n"); 
		query.append(",	' ' RT_FIRM_CNT" ).append("\n"); 
		query.append(",	' ' CNTR_FIRM_CNT" ).append("\n"); 
		query.append(",	' ' CN_CODE_CNT" ).append("\n"); 
		query.append(",	' ' CONT_ACT_CNT" ).append("\n"); 
		query.append(",	' ' CONT_DUMMY_CNT" ).append("\n"); 
		query.append(",	' ' CNTR_BALANCE_CNT" ).append("\n"); 
		query.append(",	' ' CN_BALANCE_CNT" ).append("\n"); 
		query.append(",	' ' CONT_BALANCE_CNT" ).append("\n"); 
		query.append(",	' ' BK_NON_CHARGE_CNT" ).append("\n"); 
		query.append(",	' ' RT_NON_CHARGE_CNT" ).append("\n"); 
		query.append(",	' ' BK_PERCENT" ).append("\n"); 
		query.append(",	' ' RT_PERCENT " ).append("\n"); 
		query.append(",	' ' CNTR_PERCENT" ).append("\n"); 
		query.append(",	' ' CN_PERCENT" ).append("\n"); 
		query.append(",	' ' CONT_PERCENT" ).append("\n"); 
		query.append(",	' ' REPORT_TYPE" ).append("\n"); 
		query.append(",	' ' DT_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",  ' '  AS NO_RT_TOT_CNT" ).append("\n"); 
		query.append(",  ' '  AS NO_RT_FRM_CNT" ).append("\n"); 
		query.append(",  ' '  AS NO_RT_CNT" ).append("\n"); 
		query.append(",  ' ' AS NO_RT_PERCENT" ).append("\n"); 
		query.append("FROM 	DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}