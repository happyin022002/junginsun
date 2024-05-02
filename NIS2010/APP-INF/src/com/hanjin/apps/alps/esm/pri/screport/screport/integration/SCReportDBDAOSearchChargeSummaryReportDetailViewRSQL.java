/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAOSearchChargeSummaryReportDetailViewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOSearchChargeSummaryReportDetailViewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge Summary Report - Detail View Tab을 조회한다.
	  * 2013.06.24 송호진 [CHM-201324516] MDM_CHARGE 에 새로 추가된 MDT_RAT_FLG 적용
	  * 2014.02.26 전윤주 [CHM-201429075] Charge Summary Report_Detail view 조회 기능 추가
	  * 2014.06.02 최성환 [CHM-201430519]Charge Summary Report 로직 보완 요청
	  * 2015.06.30 최성환 [CHM-201536493] Split03-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public SCReportDBDAOSearchChargeSummaryReportDetailViewRSQL(){
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
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAOSearchChargeSummaryReportDetailViewRSQL").append("\n"); 
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
		query.append("SELECT C1.CHG_CD" ).append("\n"); 
		query.append("      ,C1.MDTR_CD " ).append("\n"); 
		query.append("      ,C1.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append("      ,C1.RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '' )	" ).append("\n"); 
		query.append("      ,C1.BKG_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '' )" ).append("\n"); 
		query.append("      ,C1.POR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '' )" ).append("\n"); 
		query.append("      ,C1.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '' )" ).append("\n"); 
		query.append("      ,C1.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '' )" ).append("\n"); 
		query.append("      ,C1.DEL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${per_cd} != '' )" ).append("\n"); 
		query.append("      ,DECODE(C1.PER_CD, 'OT', 'Other', C1.PER_CD) PER_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_cate_cd} != '' )" ).append("\n"); 
		query.append("      ,C1.CGO_CATE_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,SUM(C1.RAT_USD_CHG_AMT) RAT_USD_CHG_AMT" ).append("\n"); 
		query.append("      ,SUM(C1.TRF_USD_CHG_AMT) TRF_USD_CHG_AMT" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(C1.TRF_USD_CHG_AMT), 0, 0" ).append("\n"); 
		query.append("             ,SUM(C1.RAT_USD_CHG_AMT)/SUM(C1.TRF_USD_CHG_AMT)*100)" ).append("\n"); 
		query.append("            ,2) CLT_RATIO" ).append("\n"); 
		query.append("	  ,COUNT(C1.BKG_NO) BKG_COUNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT CHG_CD " ).append("\n"); 
		query.append("              ,MDTR_CD" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append("    		  ,RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,BKG_OFC_CD" ).append("\n"); 
		query.append("              ,POR_CD" ).append("\n"); 
		query.append("              ,POL_CD" ).append("\n"); 
		query.append("              ,POD_CD" ).append("\n"); 
		query.append("              ,DEL_CD" ).append("\n"); 
		query.append("              ,PER_CD" ).append("\n"); 
		query.append("              ,CGO_CATE_CD         " ).append("\n"); 
		query.append("              ,BKG_NO" ).append("\n"); 
		query.append("              ,SUM(B1.TRF_USD_CHG_AMT) TRF_USD_CHG_AMT" ).append("\n"); 
		query.append("              ,(SELECT SUM(MAS_CONV_CURR_USD_FNC(CURR_CD, NVL(CHG_AMT, 0),TO_CHAR(SYSDATE, 'YYYYMM')))" ).append("\n"); 
		query.append("                 FROM BKG_CHG_RT B2" ).append("\n"); 
		query.append("                WHERE B2.BKG_NO = B1.BKG_NO" ).append("\n"); 
		query.append("                  AND B2.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("                  AND B2.CGO_CATE_CD = B1.CGO_CATE_CD" ).append("\n"); 
		query.append("				  --RAT UT CODE를 PER 기준으로 환산하여 join 함" ).append("\n"); 
		query.append("                  AND (DECODE((SELECT DECODE(RAT_UT_CD, 'BX', 'BX', 'BL', 'BL', CNTR_SZ_CD)" ).append("\n"); 
		query.append("                                FROM PRI_RAT_UT" ).append("\n"); 
		query.append("                               WHERE RAT_UT_CD(+) = B2.RAT_UT_CD) " ).append("\n"); 
		query.append("                             ,'2', '20'" ).append("\n"); 
		query.append("                             ,'4', '40'" ).append("\n"); 
		query.append("                             ,'7', '45'" ).append("\n"); 
		query.append("                             ,'BX','BX'" ).append("\n"); 
		query.append("                             ,'BL','BL' " ).append("\n"); 
		query.append("                             ,'OT') = B1.PER_CD" ).append("\n"); 
		query.append("						 OR B1.PER_CD  IN ( 'BX', 'BL' )" ).append("\n"); 
		query.append("                	   )" ).append("\n"); 
		query.append("                  AND B2.FRT_INCL_XCLD_DIV_CD <> 'I'                  " ).append("\n"); 
		query.append("                ) RAT_USD_CHG_AMT              " ).append("\n"); 
		query.append("         FROM ( " ).append("\n"); 
		query.append("               SELECT  A1.CHG_CD " ).append("\n"); 
		query.append("                      ,A2.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append("                      ,@[rhq_cd] RHQ_CD -- RHQ 조건이 들어올 때만" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                      ,A2.BKG_OFC_CD" ).append("\n"); 
		query.append("                      ,A2.POR_CD" ).append("\n"); 
		query.append("                      ,A2.POL_CD" ).append("\n"); 
		query.append("                      ,A2.POD_CD" ).append("\n"); 
		query.append("                      ,A2.DEL_CD" ).append("\n"); 
		query.append("                      ,A1.RAT_UT_CD" ).append("\n"); 
		query.append("					   --20, 40, 45, BX, BL, OT 6가지 CODE로 GROUP BY " ).append("\n"); 
		query.append("                      ,DECODE((SELECT DECODE(RAT_UT_CD, 'BX', 'BX', 'BL', 'BL', CNTR_SZ_CD)" ).append("\n"); 
		query.append("                                 FROM PRI_RAT_UT" ).append("\n"); 
		query.append("                                WHERE RAT_UT_CD(+) = A1.RAT_UT_CD) " ).append("\n"); 
		query.append("                             ,'2', '20'" ).append("\n"); 
		query.append("                             ,'4', '40'" ).append("\n"); 
		query.append("                             ,'7', '45'" ).append("\n"); 
		query.append("                             ,'BX','BX'" ).append("\n"); 
		query.append("                             ,'BL','BL'" ).append("\n"); 
		query.append("                             ,'OT') PER_CD" ).append("\n"); 
		query.append("                      ,A1.CGO_CATE_CD         " ).append("\n"); 
		query.append("                      ,DECODE ( A3.MDT_RAT_FLG, 'Y','YES','N','NO' ) AS MDTR_CD" ).append("\n"); 
		query.append("                      ,A1.BKG_NO" ).append("\n"); 
		query.append("                      ,MAS_CONV_CURR_USD_FNC(A1.CURR_CD, NVL(A1.CHG_AMT, 0),TO_CHAR(SYSDATE, 'YYYYMM')) TRF_USD_CHG_AMT            " ).append("\n"); 
		query.append("                FROM  " ).append("\n"); 
		query.append("                     BKG_BOOKING A2" ).append("\n"); 
		query.append("                    ,BKG_TRF_SCG_RT A1      " ).append("\n"); 
		query.append("                    ,MDM_CHARGE A3    " ).append("\n"); 
		query.append("#if (${rhq_cd} != '' )" ).append("\n"); 
		query.append("-- RHQ 조건이 들어올 때만 조인됨" ).append("\n"); 
		query.append("                    ,(" ).append("\n"); 
		query.append("                      SELECT OFC_CD " ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                       WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      START WITH A.OFC_CD  = @[rhq_cd]" ).append("\n"); 
		query.append("                      CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("                      ) A4" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("                  AND A1.CHG_CD = A3.CHG_CD" ).append("\n"); 
		query.append("                  AND A2.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                  AND A2.BKG_CGO_TP_CD <> 'P'                " ).append("\n"); 
		query.append("#if(${gubun} == '1')" ).append("\n"); 
		query.append("                  -- WEEK 로 조건이 들어올 때" ).append("\n"); 
		query.append("                  AND EXISTS ( SELECT BKG_NO" ).append("\n"); 
		query.append("                                FROM MAS_BKG_EXPN_DTL_WK" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("	#if(${f_sls_mon} == '' )" ).append("\n"); 
		query.append("                                -- Year, Week만 들어올 때" ).append("\n"); 
		query.append("                                AND SUBSTR(SLS_YRMON,1,4)||COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if(${f_sls_mon} != '' )" ).append("\n"); 
		query.append("                                 -- Year, Month ,Week 들어올 때" ).append("\n"); 
		query.append("                                AND  SUBSTR(SLS_YRMON,5,2) = @[f_sls_mon]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                AND BKG_NO = A2.BKG_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gubun} == '2' )" ).append("\n"); 
		query.append("                  -- MONTH 로 조건이 들어올 때" ).append("\n"); 
		query.append("                  AND EXISTS (SELECT  /*+ INDEX (MAS_BKG_EXPN_DTL, XAK3MAS_BKG_EXPN_DTL) */  " ).append("\n"); 
		query.append("                                   BKG_NO" ).append("\n"); 
		query.append("                              FROM MAS_BKG_EXPN_DTL" ).append("\n"); 
		query.append("                              WHERE COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("                              AND BKG_NO = A2.BKG_NO)          " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gubun} == '3' )" ).append("\n"); 
		query.append("                  -- Appl 로 조건이 들어올때" ).append("\n"); 
		query.append("                  AND EXISTS (SELECT BKG_NO" ).append("\n"); 
		query.append("                              FROM BKG_RATE" ).append("\n"); 
		query.append("                              WHERE RT_APLY_DT >= TO_DATE(@[start_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                              AND RT_APLY_DT <= TO_DATE(@[end_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                              AND BKG_NO = A2.BKG_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq_cd} != '' )" ).append("\n"); 
		query.append("                  AND A2.CTRT_OFC_CD =A4.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '' )                     " ).append("\n"); 
		query.append("                  AND A1.CHG_CD IN (${chg_cd}) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.SVC_SCP_CD  IN (${svc_scp_cd})" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.POR_CD like @[por_cd]||'%' --POR 조건" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.POL_CD like @[pol_cd]||'%' -- POL 조건" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.POD_CD like @[pod_cd]||'%' -- POD 조건" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.DEL_CD like @[del_cd]||'%' --DEL 조건 " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                  AND A2.BKG_OFC_CD IN (${bkg_ofc_cd}) -- B.OFC 조건" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cgo_cate_cd} != '')" ).append("\n"); 
		query.append("                  AND A1.CGO_CATE_CD IN (${cgo_cate_cd}) --cgo_cate_cd조건 " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${mdtr_cd} != 'A')" ).append("\n"); 
		query.append("                  AND A3.MDT_RAT_FLG = @[mdtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				 ) B1" ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("#if (${per_cd} != '' )" ).append("\n"); 
		query.append("        AND PER_CD IN (${per_cd}) --PER 조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY CHG_CD " ).append("\n"); 
		query.append("            ,MDTR_CD" ).append("\n"); 
		query.append("            ,SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append("        	,RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            ,BKG_OFC_CD" ).append("\n"); 
		query.append("            ,POR_CD" ).append("\n"); 
		query.append("            ,POL_CD" ).append("\n"); 
		query.append("            ,POD_CD" ).append("\n"); 
		query.append("            ,DEL_CD" ).append("\n"); 
		query.append("            ,PER_CD" ).append("\n"); 
		query.append("            ,CGO_CATE_CD         " ).append("\n"); 
		query.append("            ,BKG_NO" ).append("\n"); 
		query.append(")C1" ).append("\n"); 
		query.append("GROUP BY C1.CHG_CD " ).append("\n"); 
		query.append("      ,C1.MDTR_CD" ).append("\n"); 
		query.append("      ,C1.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append("      ,C1.RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("      ,C1.BKG_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("      ,C1.POR_CD" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("      ,C1.POL_CD" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("      ,C1.POD_CD" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("      ,C1.DEL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${per_cd} != '' )" ).append("\n"); 
		query.append("      ,C1.PER_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_cate_cd} != '')" ).append("\n"); 
		query.append("      ,C1.CGO_CATE_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}