/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommRequestDBDAOSearchAGNCommRequestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOSearchAGNCommRequestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AGNCommRequestDBDAOSearchAGNCommRequestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOSearchAGNCommRequestListRSQL").append("\n"); 
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
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       A.IO_BND_CD," ).append("\n"); 
		query.append("       B.REV_VVD_CD," ).append("\n"); 
		query.append("       MAX(DECODE(A.AC_VSL_CD, 'CNTC', '', A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD)) AS COMM_VVD," ).append("\n"); 
		query.append("       A.AC_RLANE_CD," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS SAIL_ARR_DT," ).append("\n"); 
		query.append("       A.AC_OCCR_INFO_CD," ).append("\n"); 
		query.append("       MAX(A.AC_SEQ) AS AC_SEQ," ).append("\n"); 
		query.append("       MAX(C.BKG_STS_CD) AS BKG_STS_CD," ).append("\n"); 
		query.append("        (ACM_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD || 'x' || OP_CNTR_QTY" ).append("\n"); 
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
		query.append("       DECODE(MAX(NVL(A.REV_DIV_CD,'A')),'A',' ',MAX(NVL(A.REV_DIV_CD,'A'))) AS REV_DIV_CD," ).append("\n"); 
		query.append("        B.TRD_CD," ).append("\n"); 
		query.append("    	(SELECT SUB_TRD_CD" ).append("\n"); 
		query.append("        FROM  COA_BKG_EXPN_DTL DW" ).append("\n"); 
		query.append("        WHERE DW.BKG_NO    = A.BKG_NO" ).append("\n"); 
		query.append("        AND ROWNUM = 1) AS SUB_TRD_CD ," ).append("\n"); 
		query.append("       (SELECT NVL(SUM(CRNT_REV_AMT ),0)" ).append("\n"); 
		query.append("        FROM  ACM_AGN_COMM AC " ).append("\n"); 
		query.append("        WHERE AC.BKG_NO    = A.BKG_NO " ).append("\n"); 
		query.append("        AND   AC.AGN_CD    = A.AGN_CD " ).append("\n"); 
		query.append("        AND   AC.IO_BND_CD = A.IO_BND_CD " ).append("\n"); 
		query.append("        AND   AC.AC_SEQ    = A.AC_SEQ AND AC_TP_CD = 'G') AS CRNT_REV_AMT ," ).append("\n"); 
		query.append("       (SELECT NVL(SUM(DDCT_CHG_AMT ),0)" ).append("\n"); 
		query.append("        FROM  ACM_AGN_COMM AC " ).append("\n"); 
		query.append("        WHERE AC.BKG_NO    = A.BKG_NO " ).append("\n"); 
		query.append("        AND   AC.AGN_CD    = A.AGN_CD " ).append("\n"); 
		query.append("        AND   AC.IO_BND_CD = A.IO_BND_CD " ).append("\n"); 
		query.append("        AND   AC.AC_SEQ    = A.AC_SEQ AND AC_TP_CD = 'G') AS DDCT_CHG_AMT ," ).append("\n"); 
		query.append("       (SELECT NVL(SUM(DDCT_TRSP_AMT ),0)" ).append("\n"); 
		query.append("        FROM  ACM_AGN_COMM AC " ).append("\n"); 
		query.append("        WHERE AC.BKG_NO    = A.BKG_NO " ).append("\n"); 
		query.append("        AND   AC.AGN_CD    = A.AGN_CD " ).append("\n"); 
		query.append("        AND   AC.IO_BND_CD = A.IO_BND_CD " ).append("\n"); 
		query.append("        AND   AC.AC_SEQ    = A.AC_SEQ AND AC_TP_CD = 'G') AS DDCT_TRSP_AMT ," ).append("\n"); 
		query.append("       (SELECT NVL(SUM(DDCT_SPCL_CMPN_AMT),0)" ).append("\n"); 
		query.append("        FROM  ACM_AGN_COMM AC " ).append("\n"); 
		query.append("        WHERE AC.BKG_NO    = A.BKG_NO " ).append("\n"); 
		query.append("        AND   AC.AGN_CD    = A.AGN_CD " ).append("\n"); 
		query.append("        AND   AC.IO_BND_CD = A.IO_BND_CD " ).append("\n"); 
		query.append("        AND   AC.AC_SEQ    = A.AC_SEQ AND AC_TP_CD = 'G') AS DDCT_SPCL_CMPN_AMT ," ).append("\n"); 
		query.append("       (SELECT NVL(SUM(CRNT_REV_AMT - DDCT_CHG_AMT - DDCT_TRSP_AMT - DDCT_SPCL_CMPN_AMT),0)" ).append("\n"); 
		query.append("        FROM  ACM_AGN_COMM AC " ).append("\n"); 
		query.append("        WHERE AC.BKG_NO    = A.BKG_NO " ).append("\n"); 
		query.append("        AND   AC.AGN_CD    = A.AGN_CD " ).append("\n"); 
		query.append("        AND   AC.IO_BND_CD = A.IO_BND_CD " ).append("\n"); 
		query.append("        AND   AC.AC_SEQ    = A.AC_SEQ AND AC_TP_CD = 'G') AS POST_REV_AMT ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSCNR', A.AC_TP_CD)), 1, A.PPD_AMT, 0)) AS PPD_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'G', A.IF_AMT, 0)) AS GENERAL_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'K', A.IF_AMT, 0)) AS BROG_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'H', A.IF_AMT, 0)) AS CHF_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'S', A.IF_AMT, 0)) AS TS_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'C', A.IF_AMT, 0)) AS CROSS_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'N', A.IF_AMT, 0)) AS CSF_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'R', A.IF_AMT, 0)) AS RCSF_AMT,   " ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSCNR', A.AC_TP_CD)), 1, A.IF_AMT, 0)) AS USD_AMT," ).append("\n"); 
		query.append("       MAX(PAY_XCH_RT) AS PAY_XCH_RT," ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSCNR', A.AC_TP_CD)), 1, PAY_IF_AMT, 0)) AS PAY_IF_AMT," ).append("\n"); 
		query.append("       A.AC_STS_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') AS CRE_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.CRE_DT, 'HH24:MI') AS CRE_TM," ).append("\n"); 
		query.append("       D.BDR_FLG,       " ).append("\n"); 
		query.append("       CASE WHEN A.AC_STS_CD = 'CE' THEN MAX(A.AC_PROC_DESC)" ).append("\n"); 
		query.append("            ELSE (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_VAL_CTNT = A.AC_STS_CD AND INTG_CD_ID = 'CD03095')" ).append("\n"); 
		query.append("       END AS AC_PROC_DESC," ).append("\n"); 
		query.append("       A.AGN_CD," ).append("\n"); 
		query.append("       A.XCH_RT_APLY_LVL," ).append("\n"); 
		query.append("       MAX(B.POL_CD) AS POL_CD," ).append("\n"); 
		query.append("       MAX(B.POR_CD) AS POR_CD," ).append("\n"); 
		query.append("       MAX(B.POD_CD) AS POD_CD," ).append("\n"); 
		query.append("       MAX(B.DEL_CD) AS DEL_CD" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM A," ).append("\n"); 
		query.append("       ACM_AGN_BKG_INFO B," ).append("\n"); 
		query.append("       BKG_BOOKING C," ).append("\n"); 
		query.append("       BKG_BL_DOC D" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND A.AC_STS_CD <> 'CZ' --> Zero Amt 는  화면에는 보여주지 않는다. " ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("/* Commission Status */" ).append("\n"); 
		query.append("#if (${ac_sts_cd} != 'AL')" ).append("\n"); 
		query.append("   #if (${ac_sts_cd} == 'RR')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD IN ('RR', 'AR', 'PR', 'IC')" ).append("\n"); 
		query.append("   #elseif (${ac_sts_cd} == 'IS')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD = 'IF'" ).append("\n"); 
		query.append("   AND A.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   AND A.AC_STS_CD = @[ac_sts_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* 날짜 조회 기준에 따른 조회 */" ).append("\n"); 
		query.append("#if (${bl_no} == '')" ).append("\n"); 
		query.append("#if (${date_div} == 'BC')" ).append("\n"); 
		query.append("   AND C.CRE_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'SA')" ).append("\n"); 
		query.append("   AND TO_DATE(A.SAIL_ARR_DT,'YYYY-MM-DD')  BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'RQ')" ).append("\n"); 
		query.append("   AND A.RQST_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'AU')" ).append("\n"); 
		query.append("   AND A.AUD_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'AP')" ).append("\n"); 
		query.append("   AND A.APRO_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'IF')" ).append("\n"); 
		query.append("   AND A.IF_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'RJ')" ).append("\n"); 
		query.append("   AND A.UPD_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* VVD */" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("   #if (${vvd_div} == 'CV') -- C.VVD" ).append("\n"); 
		query.append("   AND A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD IN (${vvd_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #elseif (${vvd_div} == 'RV') -- R.VVD" ).append("\n"); 
		query.append("   AND B.REV_VVD_CD IN (${vvd_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* BL_NO */" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("   AND B.BL_NO IN (${bl_no})    --## ${}로 받음" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Display bookings before BDR */" ).append("\n"); 
		query.append("#if (${bdr_flg} != 'Y')" ).append("\n"); 
		query.append("   AND D.BDR_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* Display Advanced Bookings */" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != 'A')" ).append("\n"); 
		query.append("   AND C.BKG_STS_CD <> 'A'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND 1 = (CASE WHEN A.AC_SEQ > 1 AND A.PAY_XCH_RT <> 0 AND A.PAY_IF_AMT = 0" ).append("\n"); 
		query.append("              THEN 0" ).append("\n"); 
		query.append("              ELSE 1" ).append("\n"); 
		query.append("             END)   " ).append("\n"); 
		query.append(" GROUP BY B.BL_NO," ).append("\n"); 
		query.append("          A.BKG_NO," ).append("\n"); 
		query.append("          A.IO_BND_CD," ).append("\n"); 
		query.append("          B.REV_VVD_CD," ).append("\n"); 
		query.append("          A.AC_RLANE_CD," ).append("\n"); 
		query.append("          A.SAIL_ARR_DT," ).append("\n"); 
		query.append("          A.AC_OCCR_INFO_CD," ).append("\n"); 
		query.append("          B.TRD_CD," ).append("\n"); 
		query.append("          A.AC_SEQ," ).append("\n"); 
		query.append("          B.BKG_STS_CD," ).append("\n"); 
		query.append("--          A.REV_DIV_CD," ).append("\n"); 
		query.append("          A.CURR_CD," ).append("\n"); 
		query.append("          A.AC_STS_CD," ).append("\n"); 
		query.append("--          A.CRE_DT," ).append("\n"); 
		query.append("          TO_CHAR(A.CRE_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("          TO_CHAR(A.CRE_DT, 'HH24:MI')," ).append("\n"); 
		query.append("          D.BDR_FLG," ).append("\n"); 
		query.append("--          A.AC_PROC_DESC," ).append("\n"); 
		query.append("          A.AR_OFC_CD," ).append("\n"); 
		query.append("          A.AGN_CD," ).append("\n"); 
		query.append("          A.XCH_RT_APLY_LVL" ).append("\n"); 
		query.append(" ORDER BY 1, 2, 3, 4, 5, 6" ).append("\n"); 

	}
}