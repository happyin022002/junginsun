/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommCalculationDBDAOSearchAGNCommMassCalExcelListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommCalculationDBDAOSearchAGNCommMassCalExcelListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agent Commission Mass Calculation List를 조회한다.
	  * </pre>
	  */
	public AGNCommCalculationDBDAOSearchAGNCommMassCalExcelListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.integration").append("\n"); 
		query.append("FileName : AGNCommCalculationDBDAOSearchAGNCommMassCalExcelListRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO," ).append("\n"); 
		query.append("       C.BL_NO," ).append("\n"); 
		query.append("       A.IO_BND_CD," ).append("\n"); 
		query.append("       MAX(A.AC_TP_CD), --Type" ).append("\n"); 
		query.append("       MAX(A.COMM_STND_COST_CD), -- Account" ).append("\n"); 
		query.append("       R.VSL_CD||R.SKD_VOY_NO||R.DIR_CD||R.REV_DIR_CD AS REV_VVD_CD," ).append("\n"); 
		query.append("       (SELECT M.COST_YRMON AS REV_MON" ).append("\n"); 
		query.append("        FROM COA_MON_VVD M , COA_RGST_BKG R" ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("        AND R.BKG_NO     = A.BKG_NO" ).append("\n"); 
		query.append("        AND M.TRD_CD     = R.TRD_CD" ).append("\n"); 
		query.append("        AND M.RLANE_CD   = R.RLANE_CD          " ).append("\n"); 
		query.append("        AND M.IOC_CD     = R.IOC_CD            " ).append("\n"); 
		query.append("        AND M.VSL_CD     = R.VSL_CD            " ).append("\n"); 
		query.append("        AND M.SKD_VOY_NO = R.SKD_VOY_NO        " ).append("\n"); 
		query.append("        AND M.DIR_CD     = R.DIR_CD) AS REV_MON, -- R.Mon" ).append("\n"); 
		query.append("       MAX(DECODE(A.AC_VSL_CD, 'CNTC', '', A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD)) AS COMM_VVD," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS SAIL_ARR_DT," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD || 'x' || OP_CNTR_QTY" ).append("\n"); 
		query.append("                        	   FROM (" ).append("\n"); 
		query.append("                        	   	SELECT BKG_NO, CNTR_TPSZ_CD, SUM(OP_CNTR_QTY) AS OP_CNTR_QTY" ).append("\n"); 
		query.append("                        	   	  FROM ( " ).append("\n"); 
		query.append("                                    SELECT BKG_NO" ).append("\n"); 
		query.append("                                         , CASE WHEN OP_CNTR_QTY = EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN DECODE(SUBSTR(CNTR_TPSZ_CD,1,1), SUBSTR(EQ_SUBST_CNTR_TPSZ_CD,1,1), EQ_SUBST_CNTR_TPSZ_CD, DECODE(SUBSTR(CNTR_TPSZ_CD,1,1), 'R', SUBSTR(CNTR_TPSZ_CD, 1,1)||EQ_SUBST_CNTR_TPSZ_CD, EQ_SUBST_CNTR_TPSZ_CD))" ).append("\n"); 
		query.append("                                                WHEN OP_CNTR_QTY > EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN DECODE(SUBSTR(CNTR_TPSZ_CD,1,1), 'R', DECODE(SUBSTR(EQ_SUBST_CNTR_TPSZ_CD,1,1),'D', SUBSTR(CNTR_TPSZ_CD,1,1)||EQ_SUBST_CNTR_TPSZ_CD, EQ_SUBST_CNTR_TPSZ_CD), EQ_SUBST_CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                                           END AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                         , CASE WHEN OP_CNTR_QTY = EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                WHEN OP_CNTR_QTY > EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN DECODE(EQ_SUBST_CNTR_TPSZ_CD, NULL, OP_CNTR_QTY, EQ_SUBST_CGO_QTY)" ).append("\n"); 
		query.append("                                           END AS OP_CNTR_QTY  " ).append("\n"); 
		query.append("                                      FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND BQ.EQ_SUBST_CGO_QTY > 0" ).append("\n"); 
		query.append("                                     UNION " ).append("\n"); 
		query.append("                                    SELECT BKG_NO" ).append("\n"); 
		query.append("                                         , CASE WHEN OP_CNTR_QTY > EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                WHEN OP_CNTR_QTY = EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN DECODE(SUBSTR(CNTR_TPSZ_CD,1,1), SUBSTR(EQ_SUBST_CNTR_TPSZ_CD,1,1), EQ_SUBST_CNTR_TPSZ_CD, DECODE(SUBSTR(CNTR_TPSZ_CD,1,1), 'R', SUBSTR(CNTR_TPSZ_CD, 1,1)||EQ_SUBST_CNTR_TPSZ_CD, EQ_SUBST_CNTR_TPSZ_CD))" ).append("\n"); 
		query.append("                                           END AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                          ,CASE WHEN OP_CNTR_QTY > EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN OP_CNTR_QTY-EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                WHEN OP_CNTR_QTY = EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                THEN EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                           END AS OP_CNTR_QTY" ).append("\n"); 
		query.append("                                      FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND BQ.EQ_SUBST_CGO_QTY > 0" ).append("\n"); 
		query.append("                                     UNION ALL" ).append("\n"); 
		query.append("                                    SELECT BKG_NO, CNTR_TPSZ_CD, OP_CNTR_QTY" ).append("\n"); 
		query.append("                                      FROM BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND BQ.EQ_SUBST_CGO_QTY = 0" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("                                     GROUP BY BKG_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                    ) Q " ).append("\n"); 
		query.append("                                WHERE Q.BKG_NO = A.BKG_NO  " ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("        ))) CNTR_QTY, -- RD TYPE 구분" ).append("\n"); 
		query.append("       SUM(A.CRNT_REV_AMT) AS CRNT_REV_AMT," ).append("\n"); 
		query.append("       SUM(A.DDCT_CHG_AMT) AS DDCT_CHG_AMT," ).append("\n"); 
		query.append("       SUM(A.DDCT_TRSP_AMT) AS DDCT_TRSP_AMT," ).append("\n"); 
		query.append("       SUM(A.DDCT_SPCL_CMPN_AMT) AS DDCT_SPCL_CMPN_AMT, " ).append("\n"); 
		query.append("       SUM(A.CRNT_REV_AMT - A.DDCT_CHG_AMT - A.DDCT_TRSP_AMT - A.DDCT_SPCL_CMPN_AMT) AS POST_REV_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSCNR', A.AC_TP_CD)), 1, A.PPD_AMT, 0)) AS PPD_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSCNR', A.AC_TP_CD)), 1, A.IF_AMT, 0)) AS USD_AMT," ).append("\n"); 
		query.append("       A.AR_OFC_CD AS RESPB_OFC_CD," ).append("\n"); 
		query.append("       A.AR_OFC_CD," ).append("\n"); 
		query.append("       MAX(A.AP_OFC_CD)," ).append("\n"); 
		query.append("       (SELECT RHQ_CD" ).append("\n"); 
		query.append("       FROM ACM_OFC_INFO" ).append("\n"); 
		query.append("       WHERE AGN_CD = A.AGN_CD AND ROWNUM = 1) AS HQ_OFC_CD," ).append("\n"); 
		query.append("       MAX(A.OFC_CHR_CD)" ).append("\n"); 
		query.append("--       A.SIM_NO" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM A," ).append("\n"); 
		query.append("       COA_RGST_BKG R," ).append("\n"); 
		query.append("       BKG_BOOKING C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.CRE_USR_ID <> 'COST'" ).append("\n"); 
		query.append("   AND C.BKG_NO = A.BKG_NO(+)" ).append("\n"); 
		query.append("   AND C.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("/* 날짜 조회 기준에 따른 조회 */	" ).append("\n"); 
		query.append("#if (${date_fm} != '' && ${date_to} != '')" ).append("\n"); 
		query.append("   #if (${date_div} == 'BC')" ).append("\n"); 
		query.append("   AND C.CRE_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'SA')" ).append("\n"); 
		query.append("   AND TO_DATE(A.SAIL_ARR_DT,'YYYY-MM-DD')  BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'RQ')" ).append("\n"); 
		query.append("   AND A.RQST_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'AU')" ).append("\n"); 
		query.append("   AND A.AUD_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'AP')" ).append("\n"); 
		query.append("   AND A.APRO_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'IF')" ).append("\n"); 
		query.append("   AND A.IF_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #elseif (${date_div} == 'RJ')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD IN ('RR','AR')" ).append("\n"); 
		query.append("   AND A.UPD_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* VVD */" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("   #if (${vvd_div} == 'CV') -- C.VVD" ).append("\n"); 
		query.append("   AND A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD IN (${vvd_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #elseif (${vvd_div} == 'RV') -- R.VVD" ).append("\n"); 
		query.append("   AND R.VSL_CD||R.SKD_VOY_NO||R.DIR_CD||R.REV_DIR_CD IN (${vvd_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Commission Account 작업중 */" ).append("\n"); 
		query.append("#if (${ac_tp_cd} != '')" ).append("\n"); 
		query.append("   AND A.AC_TP_CD IN (${ac_tp_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Agreement Condition */" ).append("\n"); 
		query.append("#if (${agmt_div} == 'A' && ${agmt_no1} != '') --Applied Agreement" ).append("\n"); 
		query.append("       AND A.AGN_AGMT_NO IN (${agmt_no1})    --## ${}로 받음" ).append("\n"); 
		query.append("#elseif (${agmt_div} == 'S' && ${agmt_no2} != '') -- AS Agreement should have been applied" ).append("\n"); 
		query.append("    -- 현재 작업중 추후 적용" ).append("\n"); 
		query.append("       AND A.AGN_AGMT_NO IN (${agmt_no2})    --## ${}로 받음" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Commission Status */" ).append("\n"); 
		query.append("#if (${ac_sts_cd} != '')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD IN (${ac_sts_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ac_sts_cd2} == 'IS')" ).append("\n"); 
		query.append("   AND A.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Office  작업중 */" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("   #if (${ofc_div} == 'A')" ).append("\n"); 
		query.append("   AND A.AGN_CD IN (${ofc_cd}) " ).append("\n"); 
		query.append("   #elseif (${ofc_div} == 'B')" ).append("\n"); 
		query.append("   AND C.BKG_OFC_CD IN (${ofc_cd}) " ).append("\n"); 
		query.append("   #elseif (${ofc_div} == 'F' && ${port_div} == 'POR')" ).append("\n"); 
		query.append("   AND C.POR_CD IN (SELECT L.LOC_CD FROM MDM_LOCATION L WHERE L.FINC_CTRL_OFC_CD IN (${ofc_cd}) )" ).append("\n"); 
		query.append("   #elseif (${ofc_div} == 'F' && ${port_div} == 'POL')" ).append("\n"); 
		query.append("   AND C.POL_CD IN (SELECT L.LOC_CD FROM MDM_LOCATION L WHERE L.FINC_CTRL_OFC_CD IN (${ofc_cd}) )" ).append("\n"); 
		query.append("   #elseif (${ofc_div} == 'F' && ${port_div} == 'POD')" ).append("\n"); 
		query.append("   AND C.POD_CD IN (SELECT L.LOC_CD FROM MDM_LOCATION L WHERE L.FINC_CTRL_OFC_CD IN (${ofc_cd}) )" ).append("\n"); 
		query.append("   #elseif (${ofc_div} == 'F' && ${port_div} == 'DEL')" ).append("\n"); 
		query.append("   AND C.DEL_CD IN (SELECT L.LOC_CD FROM MDM_LOCATION L WHERE L.FINC_CTRL_OFC_CD IN (${ofc_cd}) )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Route (POR : POR, POL : POL, POD : POD, DEL : DEL, T/S Port : TSP) */" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("   #if (${route_div} == 'POR')" ).append("\n"); 
		query.append("   AND C.POR_CD IN (${loc_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #elseif (${route_div} == 'POL')" ).append("\n"); 
		query.append("   AND C.POL_CD IN (${loc_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #elseif (${route_div} == 'POD')" ).append("\n"); 
		query.append("   AND C.POD_CD IN (${loc_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #elseif (${route_div} == 'DEL')" ).append("\n"); 
		query.append("   AND C.DEL_CD IN (${loc_cd})   --## ${}로 받음" ).append("\n"); 
		query.append("   #elseif (${route_div} == 'TSP')" ).append("\n"); 
		query.append("   AND C.BKG_NO IN (SELECT BKG_NO FROM BKG_VVD V WHERE V.BKG_NO = C.BKG_NO AND V.POL_CD <> C.POL_CD AND V.POL_CD IN (${loc_cd}))" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Bound */" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '' && ${io_bnd_cd} != 'A') -- Bound(ALL : A, IN : I, OUT : O) : 공통코드 CD02882" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = (@[io_bnd_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY C.BL_NO," ).append("\n"); 
		query.append("          A.BKG_NO," ).append("\n"); 
		query.append("          A.IO_BND_CD," ).append("\n"); 
		query.append("          R.VSL_CD||R.SKD_VOY_NO||R.DIR_CD||R.REV_DIR_CD," ).append("\n"); 
		query.append("          A.AC_RLANE_CD," ).append("\n"); 
		query.append("          A.SAIL_ARR_DT," ).append("\n"); 
		query.append("          A.LOC_CD," ).append("\n"); 
		query.append("          A.AC_SEQ," ).append("\n"); 
		query.append("          C.BKG_STS_CD," ).append("\n"); 
		query.append("          A.REV_DIV_CD," ).append("\n"); 
		query.append("          A.CURR_CD," ).append("\n"); 
		query.append("          A.AC_STS_CD," ).append("\n"); 
		query.append("          A.CRE_DT," ).append("\n"); 
		query.append("          A.BDR_FLG," ).append("\n"); 
		query.append("          A.AC_PROC_DESC," ).append("\n"); 
		query.append("          A.AR_OFC_CD," ).append("\n"); 
		query.append("          A.AGN_CD" ).append("\n"); 

	}
}