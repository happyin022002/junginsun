/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchSlipInqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchSlipInqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP 에서 I/F 받은 전표 정보 조회
	  * 2011.01.31 이준범[CHM-201108626-01]
	  * 요청사항 : SELPLL- >SELLIC  관련 문제 연관 해소
	  * 보완내역 : 조직 변경으로 인한 조직 코드 변경시 과거 데이터를 조회 할 수 있도록
	  *                History Table(GEM_OFC_HIS) 검색하도록 SQL 수정  
	  * 2011-02-23 이준범 [CHM-201108800-01]
	  * 제목: Split 01-ERP에서 ALPS>GEM으로 AP slip data 송신 시 추가정보 요청
	  * 보완: upplier code, Supplier Name, Credit card user name 항목 추가
	  * 2011-03-11 이준범 [CHM-201108800-01]
	  * 제목: ERP I/F DATA 추가 요청
	  * 보완: 1. 법인카드 가맹점 정보 추가 I/F
	  *         2. GEM 수신 메뉴
	  *         - INQUIRY > SLIP INQUIRY
	  *         - 화면상 보이지 않고 DOWNLOAD 시 VANDER NAME 옆에 다운로드
	  * 
	  * 2012.12.14 Ticket ID : CHM-201221037
	  * 설계자 : 강환, 개발자 : 원종규
	  * Title : 일부 법인 비용주관팀 로직 변경에 따른 조회(inquiry/Report) 기능 보완 요청
	  * Description : SELPLI에서 승인하는 비용항목 조회시 SELPLI의 산하 조직이 조회되도록 수정 
	  * 
	  * 2014.10.23 이준범 [CHM-201432508-01]
	  * 요청사항: [GEM] 결산작업을 위한 데이터 업데이트 지원
	  * 보완: SELPLI 하드코딩 부분 삭제 
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchSlipInqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_rslt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_expense_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cur",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_expense_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_rslt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_co_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_expense_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_tic_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchSlipInqRSQL").append("\n"); 
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
		query.append("SELECT SLP_TJ_NO" ).append("\n"); 
		query.append("      ,SLP_TJ_NO1" ).append("\n"); 
		query.append("      ,SLP_SEQ_NO" ).append("\n"); 
		query.append("      ,SLP_SEQ_NO1" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,SUB_OFC_CD" ).append("\n"); 
		query.append("      ,OFC_CO_DIV_CD" ).append("\n"); 
		query.append("      ,GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,ABBR_NM" ).append("\n"); 
		query.append("      ,SUB_GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,SUB_ABBR_NM" ).append("\n"); 
		query.append("      ,TIC_CD" ).append("\n"); 
		query.append("      ,TIC_CD1" ).append("\n"); 
		query.append("      ,SLP_CURR_CD" ).append("\n"); 
		query.append("      ,SLP_CURR_CD1" ).append("\n"); 
		query.append("      ,GL_EFF_DT" ).append("\n"); 
		query.append("      ,GL_EFF_DT1" ).append("\n"); 
		query.append("      ,SLP_AMT" ).append("\n"); 
		query.append("      ,SLP_AMT1" ).append("\n"); 
		query.append("      ,GEN_EXPN_FNL_LOCL_AMT" ).append("\n"); 
		query.append("      ,SLP_PERF_AMT" ).append("\n"); 
		query.append("      ,SLP_DESC" ).append("\n"); 
		query.append("      ,SLP_DESC1" ).append("\n"); 
		query.append("      ,RATIO" ).append("\n"); 
		query.append("      ,RATIO1" ).append("\n"); 
		query.append("      ,TOTAL" ).append("\n"); 
		query.append("      ,ROW_NUM" ).append("\n"); 
		query.append("      ,SLP_VNDR_CD" ).append("\n"); 
		query.append("      ,ACCT_CD" ).append("\n"); 
		query.append("      ,SLP_SPLR_CD" ).append("\n"); 
		query.append("      ,SLP_SPLR_NM" ).append("\n"); 
		query.append("      ,CR_CRD_USR_NM" ).append("\n"); 
		query.append("      ,CRD_SHOP_NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("         SELECT A.SLP_TJ_NO" ).append("\n"); 
		query.append("               ,A.SLP_TJ_NO AS SLP_TJ_NO1" ).append("\n"); 
		query.append("               ,A.SLP_SEQ_NO" ).append("\n"); 
		query.append("               ,A.SLP_SEQ_NO AS SLP_SEQ_NO1" ).append("\n"); 
		query.append("               ,A.OFC_CD" ).append("\n"); 
		query.append("               ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("               ,D.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("               ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("               #if (${sch_lang} == 'E')" ).append("\n"); 
		query.append("               ,B.ENG_ABBR_NM AS ABBR_NM" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${sch_lang} == 'K')" ).append("\n"); 
		query.append("               ,B.KRN_ABBR_NM AS ABBR_NM" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${sch_lang} == '')" ).append("\n"); 
		query.append("               ,'' AS ABBR_NM" ).append("\n"); 
		query.append("               #end " ).append("\n"); 
		query.append("               ,A.SUB_GEN_EXPN_CD" ).append("\n"); 
		query.append("               ,(" ).append("\n"); 
		query.append("                 SELECT #if (${sch_lang} == 'E')" ).append("\n"); 
		query.append("                        ENG_ABBR_NM ABBR_NM " ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${sch_lang} == 'K')" ).append("\n"); 
		query.append("                        KRN_ABBR_NM ABBR_NM " ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${sch_lang} == '')" ).append("\n"); 
		query.append("                        ''" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    FROM GEM_EXPENSE " ).append("\n"); 
		query.append("                   WHERE GEN_EXPN_CD = A.SUB_GEN_EXPN_CD " ).append("\n"); 
		query.append("                ) AS SUB_ABBR_NM" ).append("\n"); 
		query.append("               ,B.TIC_CD" ).append("\n"); 
		query.append("               ,B.TIC_CD AS TIC_CD1" ).append("\n"); 
		query.append("               ,DECODE(@[ofc_cur], 'Slip', A.SLP_CURR_CD, 'USD', 'USD', 'KRW', 'KRW' ) AS SLP_CURR_CD" ).append("\n"); 
		query.append("               ,DECODE(@[ofc_cur], 'Slip', A.SLP_CURR_CD, 'USD', 'USD', 'KRW', 'KRW' ) AS SLP_CURR_CD1" ).append("\n"); 
		query.append("               ,A.GL_EFF_DT" ).append("\n"); 
		query.append("               ,A.GL_EFF_DT AS GL_EFF_DT1" ).append("\n"); 
		query.append("               ,DECODE(@[ofc_cur], 'Slip', A.SLP_AMT, 'USD', ( " ).append("\n"); 
		query.append("                                                               SELECT A.SLP_AMT/USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                                                 FROM GEM_XCH_RT " ).append("\n"); 
		query.append("                                                                WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON " ).append("\n"); 
		query.append("                                                                  AND GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("                                                                  AND CURR_CD = A.SLP_CURR_CD" ).append("\n"); 
		query.append("                                                             ), " ).append("\n"); 
		query.append("                                                      'KRW', (" ).append("\n"); 
		query.append("                                                               SELECT (A.SLP_AMT/USD_LOCL_XCH_RT)*USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                                                 FROM GEM_XCH_RT " ).append("\n"); 
		query.append("                                                                WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON " ).append("\n"); 
		query.append("                                                                  AND GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("                                                                  AND CURR_CD = A.SLP_CURR_CD " ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("                ) AS SLP_AMT" ).append("\n"); 
		query.append("               ,DECODE(@[ofc_cur], 'Slip', A.SLP_AMT, 'USD', (" ).append("\n"); 
		query.append("                                                               SELECT A.SLP_AMT/USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                                                 FROM GEM_XCH_RT " ).append("\n"); 
		query.append("                                                                WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON " ).append("\n"); 
		query.append("                                                                  AND GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("                                                                  AND CURR_CD = A.SLP_CURR_CD" ).append("\n"); 
		query.append("                                                             )," ).append("\n"); 
		query.append("                                                      'KRW', (" ).append("\n"); 
		query.append("                                                               SELECT (A.SLP_AMT/USD_LOCL_XCH_RT)*USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                                                 FROM GEM_XCH_RT " ).append("\n"); 
		query.append("                                                                WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON " ).append("\n"); 
		query.append("                                                                  AND GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("                                                                  AND CURR_CD = A.SLP_CURR_CD" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("                ) AS SLP_AMT1" ).append("\n"); 
		query.append("               ,DECODE(@[ofc_cur], 'Slip', A.GEN_EXPN_FNL_LOCL_AMT, 'USD', ( " ).append("\n"); 
		query.append("                                                                             SELECT A.GEN_EXPN_FNL_LOCL_AMT/USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                                                               FROM GEM_XCH_RT " ).append("\n"); 
		query.append("                                                                              WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON " ).append("\n"); 
		query.append("                                                                                AND GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("                                                                                AND CURR_CD = A.SLP_CURR_CD" ).append("\n"); 
		query.append("                                                                           )," ).append("\n"); 
		query.append("                                                                    'KRW', (" ).append("\n"); 
		query.append("                                                                             SELECT (A.GEN_EXPN_FNL_LOCL_AMT/USD_LOCL_XCH_RT)*USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                                                               FROM GEM_XCH_RT " ).append("\n"); 
		query.append("                                                                              WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON " ).append("\n"); 
		query.append("                                                                                AND GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("                                                                                AND CURR_CD = A.SLP_CURR_CD" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("                ) AS GEN_EXPN_FNL_LOCL_AMT" ).append("\n"); 
		query.append("               ,DECODE(@[ofc_cur], 'Slip', A.SLP_PERF_AMT, 'USD', (" ).append("\n"); 
		query.append("                                                                    SELECT A.SLP_PERF_AMT/USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                                                      FROM GEM_XCH_RT " ).append("\n"); 
		query.append("                                                                     WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON " ).append("\n"); 
		query.append("                                                                       AND GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("                                                                       AND CURR_CD = A.SLP_CURR_CD" ).append("\n"); 
		query.append("                                                                  ), " ).append("\n"); 
		query.append("                                                           'KRW', (" ).append("\n"); 
		query.append("                                                                    SELECT (A.SLP_PERF_AMT/USD_LOCL_XCH_RT)*USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                                                      FROM GEM_XCH_RT " ).append("\n"); 
		query.append("                                                                     WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON " ).append("\n"); 
		query.append("                                                                       AND GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("                                                                       AND CURR_CD = A.SLP_CURR_CD" ).append("\n"); 
		query.append("                                                                  )" ).append("\n"); 
		query.append("                ) AS SLP_PERF_AMT" ).append("\n"); 
		query.append("               ,A.SLP_DESC" ).append("\n"); 
		query.append("               ,A.SLP_DESC AS SLP_DESC1" ).append("\n"); 
		query.append("               ,TO_NUMBER(ROUND(DECODE(A.GEN_EXPN_FNL_LOCL_AMT,NULL,0,0,0,A.SLP_PERF_AMT/A.GEN_EXPN_FNL_LOCL_AMT)*100,2)) AS RATIO" ).append("\n"); 
		query.append("               ,TO_NUMBER(ROUND(DECODE(A.GEN_EXPN_FNL_LOCL_AMT,NULL,0,0,0,A.SLP_PERF_AMT/A.GEN_EXPN_FNL_LOCL_AMT)*100,2)) AS RATIO1" ).append("\n"); 
		query.append("               ,ROW_NUMBER() OVER(ORDER BY A.SLP_TJ_NO, A.SLP_SEQ_NO, A.OFC_CD, A.SUB_OFC_CD, A.GEN_EXPN_CD, A.SUB_GEN_EXPN_CD) AS ROW_NUM" ).append("\n"); 
		query.append("               ,COUNT(*) OVER() TOTAL" ).append("\n"); 
		query.append("               ,A.ACCT_CD" ).append("\n"); 
		query.append("               ,A.SLP_VNDR_CD" ).append("\n"); 
		query.append("               ,A.SLP_SPLR_CD" ).append("\n"); 
		query.append("               ,A.SLP_SPLR_NM" ).append("\n"); 
		query.append("               ,A.CR_CRD_USR_NM" ).append("\n"); 
		query.append("			   ,A.CRD_SHOP_NM" ).append("\n"); 
		query.append("           FROM GEM_SLP_PERF A" ).append("\n"); 
		query.append("               ,GEM_EXPENSE B" ).append("\n"); 
		query.append("               ,GEM_EXPN_GRP_V C" ).append("\n"); 
		query.append("               ,GEM_OFFICE D" ).append("\n"); 
		query.append("          WHERE A.GEN_EXPN_CD = B.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("            AND A.GEN_EXPN_CD = C.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("            AND A.OFC_CD      = D.OFC_CD(+)" ).append("\n"); 
		query.append("            #if (${ofc_co_div_cd} != '')  " ).append("\n"); 
		query.append("            AND D.OFC_CO_DIV_CD = @[ofc_co_div_cd]    " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${slp_tj_no} != '') " ).append("\n"); 
		query.append("            AND A.SLP_TJ_NO = @[slp_tj_no]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${sch_expense_group} != '') " ).append("\n"); 
		query.append("            AND C.GEM_EXPN_GRP_CD1 = @[sch_expense_group]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            AND A.GEN_EXPN_CD BETWEEN DECODE (NVL(@[sch_expense_from], ''), '', '111111', @[sch_expense_from]) AND DECODE (NVL(@[sch_expense_to], ''), '', '999999', @[sch_expense_to])" ).append("\n"); 
		query.append("            #if(${sch_tic_cd} != '')" ).append("\n"); 
		query.append("	    	AND B.TIC_CD = @[sch_tic_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            AND A.RSLT_YRMON BETWEEN @[from_rslt_yrmon] AND @[to_rslt_yrmon]" ).append("\n"); 
		query.append("            #if(${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("            AND ( A.OFC_CD IN (" ).append("\n"); 
		query.append("                                SELECT OFC_CD      " ).append("\n"); 
		query.append("                                  FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                            START WITH OFC_CD IN (@[login_office])" ).append("\n"); 
		query.append("                           CONNECT BY PRIOR OFC_CD = BFR_OFC_CD " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                 OR C.TIC_CD = @[login_office] " ).append("\n"); 
		query.append("                )   " ).append("\n"); 
		query.append("            #elseif(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("             AND ( A.OFC_CD IN ( SELECT OFC_CD      " ).append("\n"); 
		query.append("                                        FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                                  START WITH OFC_CD IN  ( SELECT L_4 " ).append("\n"); 
		query.append("                                                            FROM GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("                                                           WHERE L_3 = @[login_office] )" ).append("\n"); 
		query.append("                       CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) " ).append("\n"); 
		query.append("                      OR C.TIC_CD = @[login_office] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sls_ofc_div_cd} != '' || ${ofc_expn_cd} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CD in (" ).append("\n"); 
		query.append("	SELECT OFC_CD      " ).append("\n"); 
		query.append("  	FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("	START WITH OFC_CD IN (    " ).append("\n"); 
		query.append("        SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("          FROM GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("		   #if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("           AND RGN_OFC_FLG LIKE @[sls_ofc_div_cd]||'%'" ).append("\n"); 
		query.append("		   #end		" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} != '') " ).append("\n"); 
		query.append("		   AND L_4 LIKE @[ofc_lvl3]||'%' " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   AND L_3 LIKE @[ofc_lvl2]||'%' " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} == '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   AND L_2 LIKE @[ofc_lvl1]||'%' " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("           #if (${ofc_expn_cd} != '') " ).append("\n"); 
		query.append("		   AND L_4 LIKE @[ofc_expn_cd]||'%' " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${start_page} != '') " ).append("\n"); 
		query.append("WHERE ROW_NUM BETWEEN ${start_page} AND ${end_page}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}