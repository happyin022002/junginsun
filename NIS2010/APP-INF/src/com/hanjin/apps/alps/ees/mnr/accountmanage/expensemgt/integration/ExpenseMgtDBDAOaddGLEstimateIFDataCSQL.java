/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ExpenseMgtDBDAOaddGLEstimateIFDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOaddGLEstimateIFDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --------------------------------------------------------
	  * History
	  * 2012.02.07 김상수 [CSR선처리] Equipment Management > M&R > Guideline & PFMC > Estimate expense 수정
	  *                            - 연차가 바뀔시에 새로 생성되게하는 쿼리 수정
	  * 2012.02.21 김상수 [CHM-201216302-01] 추정비용실적 산출 SQL 문 변경
	  *                            - 추정비용실적 산출 SQL 문 변경
	  *                            - 2011년도 W/O 생성된 데이터 누락으로 인한 로직 수정
	  * 2012.03.7 김민수 [CHM-201216635-01] 추정비용실적 산출 SQL 문 변경
	  *                            - 추정비용실적 산출 SQL 문 변경
	  *                            - 추정비용실적 조건문 추가
	  * 2015.03.11 Chang Young Kim [CHM-201534563] 장비 수리비 추정 실적 로직 검토 의뢰
	  *                            - 당해 1월 1일 부터 => 전해 1월 1일 부터
	  * </pre>
	  */
	public ExpenseMgtDBDAOaddGLEstimateIFDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOaddGLEstimateIFDataCSQL").append("\n"); 
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
		query.append("INSERT INTO GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("            (EXE_YRMON," ).append("\n"); 
		query.append("             SYS_SRC_ID," ).append("\n"); 
		query.append("             REV_YRMON," ).append("\n"); 
		query.append("             ACCT_CD," ).append("\n"); 
		query.append("             ESTM_SEQ_NO," ).append("\n"); 
		query.append("             AGMT_NO," ).append("\n"); 
		query.append("             WO_NO," ).append("\n"); 
		query.append("             BIZ_UT_ID," ).append("\n"); 
		query.append("             LOC_CD," ).append("\n"); 
		query.append("             VSL_CD," ).append("\n"); 
		query.append("             SKD_VOY_NO," ).append("\n"); 
		query.append("             SKD_DIR_CD," ).append("\n"); 
		query.append("             REV_DIR_CD," ).append("\n"); 
		query.append("             CNTR_TPSZ_CD," ).append("\n"); 
		query.append("             CNTR_QTY," ).append("\n"); 
		query.append("             BSA_SLT_QTY," ).append("\n"); 
		query.append("             CRR_CD," ).append("\n"); 
		query.append("             SLT_COST_AMT," ).append("\n"); 
		query.append("             CUST_CNT_CD," ).append("\n"); 
		query.append("             CUST_SEQ," ).append("\n"); 
		query.append("             VVD_DUR_NO," ).append("\n"); 
		query.append("             HIR_DT_AMT," ).append("\n"); 
		query.append("             ESTM_AMT," ).append("\n"); 
		query.append("             ACT_AMT," ).append("\n"); 
		query.append("             ACCL_AMT," ).append("\n"); 
		query.append("             ESTM_VVD_TP_CD," ).append("\n"); 
		query.append("             ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("             ESTM_VVD_HDR_ID," ).append("\n"); 
		query.append("             ESTM_BC_DIV_CD," ).append("\n"); 
		query.append("             OP_LSE_DIV_FLG," ).append("\n"); 
		query.append("             TTL_TRF_AMT," ).append("\n"); 
		query.append("             CRE_USR_ID," ).append("\n"); 
		query.append("             CRE_DT," ).append("\n"); 
		query.append("             UPD_USR_ID," ).append("\n"); 
		query.append("             UPD_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      SELECT EXE_YRMON," ).append("\n"); 
		query.append("             SYS_SRC_ID," ).append("\n"); 
		query.append("             REV_YRMON," ).append("\n"); 
		query.append("             ACCT_CD," ).append("\n"); 
		query.append("             ROWNUM AS ESTM_SEQ_NO," ).append("\n"); 
		query.append("             '' AS AGMT_NO," ).append("\n"); 
		query.append("             WO_NO," ).append("\n"); 
		query.append("             BIZ_UT_ID," ).append("\n"); 
		query.append("             LOC_CD," ).append("\n"); 
		query.append("             VSL_CD," ).append("\n"); 
		query.append("             SKD_VOY_NO," ).append("\n"); 
		query.append("             SKD_DIR_CD," ).append("\n"); 
		query.append("             REV_DIR_CD," ).append("\n"); 
		query.append("             CNTR_TPSZ_CD," ).append("\n"); 
		query.append("             CNTR_QTY," ).append("\n"); 
		query.append("             '' AS BSA_SLT_QTY," ).append("\n"); 
		query.append("             '' AS CRR_CD," ).append("\n"); 
		query.append("             '' AS SLT_COST_AMT," ).append("\n"); 
		query.append("             '' AS CUST_CNT_CD," ).append("\n"); 
		query.append("             '' AS CUST_SEQ," ).append("\n"); 
		query.append("             '' AS VVD_DUR_NO," ).append("\n"); 
		query.append("             '' AS HIR_DT_AMT," ).append("\n"); 
		query.append("             TO_NUMBER(DECODE(SIGN(ACCL_AMT), -1, ACTU_AMT, ESTM_AMT)) AS ESTM_AMT," ).append("\n"); 
		query.append("             TO_NUMBER(ACTU_AMT) AS ACTU_AMT," ).append("\n"); 
		query.append("             TO_NUMBER(DECODE(SIGN(ACCL_AMT), -1, 0, ACCL_AMT)) AS ACCL_AMT," ).append("\n"); 
		query.append("             ESTM_VVD_TP_CD," ).append("\n"); 
		query.append("             ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("             '' AS ESTM_VVD_HDR_ID," ).append("\n"); 
		query.append("             ESTM_BC_DIV_CD," ).append("\n"); 
		query.append("             '' AS OP_LSE_DIV_FLG," ).append("\n"); 
		query.append("             '' AS TTL_TRF_AMT," ).append("\n"); 
		query.append("             'SYSTEM'," ).append("\n"); 
		query.append("             SYSDATE," ).append("\n"); 
		query.append("             'SYSTEM'," ).append("\n"); 
		query.append("             SYSDATE" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              SELECT EST.EXE_YRMON," ).append("\n"); 
		query.append("                     EST.SYS_SRC_ID," ).append("\n"); 
		query.append("                     MAX(EST.REV_YRMON) AS REV_YRMON," ).append("\n"); 
		query.append("                     EST.ACCT_CD," ).append("\n"); 
		query.append("                     EST.BIZ_UT_ID," ).append("\n"); 
		query.append("                     EST.LOC_CD," ).append("\n"); 
		query.append("                     EST.VSL_CD," ).append("\n"); 
		query.append("                     MAX(EST.SKD_VOY_NO) AS SKD_VOY_NO," ).append("\n"); 
		query.append("                     EST.SKD_DIR_CD," ).append("\n"); 
		query.append("                     EST.REV_DIR_CD," ).append("\n"); 
		query.append("                     EST.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                     1 AS CNTR_QTY," ).append("\n"); 
		query.append("                     SUM(ESTM_AMT) AS ESTM_AMT," ).append("\n"); 
		query.append("                     SUM(ACTU_AMT) AS ACTU_AMT," ).append("\n"); 
		query.append("                     SUM(ESTM_AMT) - SUM(ACTU_AMT) AS ACCL_AMT," ).append("\n"); 
		query.append("                     MAX(EST.ESTM_VVD_TP_CD) AS ESTM_VVD_TP_CD," ).append("\n"); 
		query.append("                     MAX(EST.ESTM_IOC_DIV_CD) AS ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("                     MAX(EST.ESTM_BC_DIV_CD) AS ESTM_BC_DIV_CD," ).append("\n"); 
		query.append("                     MAX(EST.WO_NO) AS WO_NO" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       SELECT REPLACE(@[exe_month], '-', '') AS EXE_YRMON," ).append("\n"); 
		query.append("                             'MNR' AS SYS_SRC_ID," ).append("\n"); 
		query.append("                             TO_CHAR(OH.CRE_DT, 'YYYYMM') AS REV_YRMON," ).append("\n"); 
		query.append("                             OD.ACCT_CD AS ACCT_CD," ).append("\n"); 
		query.append("                             'CNTR' AS BIZ_UT_ID," ).append("\n"); 
		query.append("                             MO.LOC_CD AS LOC_CD," ).append("\n"); 
		query.append("                             'CNTC' AS VSL_CD," ).append("\n"); 
		query.append("                             SUBSTR(TO_CHAR(OH.CRE_DT, 'YYYYMM'), 3, 4) AS SKD_VOY_NO," ).append("\n"); 
		query.append("                             'M' AS SKD_DIR_CD," ).append("\n"); 
		query.append("                             'M' AS REV_DIR_CD," ).append("\n"); 
		query.append("                             NVL(OD.EQ_TPSZ_CD, 'XX') AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                             SUM(OD.RPR_QTY) AS CNTR_QTY," ).append("\n"); 
		query.append("                             NVL(TO_NUMBER(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT, 3))), 0) AS ESTM_AMT," ).append("\n"); 
		query.append("                             0 AS ACTU_AMT," ).append("\n"); 
		query.append("                             0 AS ACCL_AMT," ).append("\n"); 
		query.append("                             'RV' AS ESTM_VVD_TP_CD," ).append("\n"); 
		query.append("                             'XX' AS ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("                             'M' AS ESTM_BC_DIV_CD," ).append("\n"); 
		query.append("                             '' AS WO_NO" ).append("\n"); 
		query.append("                        FROM MNR_ORD_HDR OH," ).append("\n"); 
		query.append("                             MNR_ORD_DTL OD," ).append("\n"); 
		query.append("                             MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                       WHERE OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                         AND OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                         -- 2015.03.11 Chang Young Kim 전년도 1월 1일 부터" ).append("\n"); 
		query.append("                         AND OH.CRE_DT BETWEEN TO_DATE(SUBSTR(@[month], 1, 4) - 1 ||'0101', 'YYYYMMDD')" ).append("\n"); 
		query.append("                                           AND TO_DATE(@[month], 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("                         AND OD.ACCT_CD != '512125'" ).append("\n"); 
		query.append("                         AND OD.ACCT_CD IS NOT NULL" ).append("\n"); 
		query.append("                         AND OH.COST_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("                         AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                           FROM MNR_PAY_INV_WRK MPIW," ).append("\n"); 
		query.append("                                                AP_PAY_INV API," ).append("\n"); 
		query.append("                                                AP_INV_HDR AIH" ).append("\n"); 
		query.append("                                          WHERE OD.PAY_INV_SEQ = MPIW.PAY_INV_SEQ" ).append("\n"); 
		query.append("                                            AND MPIW.INV_RGST_NO = API.INV_RGST_NO" ).append("\n"); 
		query.append("                                            AND API.CSR_NO = AIH.CSR_NO" ).append("\n"); 
		query.append("                                            AND AIH.IF_FLG = 'Y'" ).append("\n"); 
		query.append("                                            AND NVL(AIH.RCV_ERR_FLG, 'N') <> 'E')" ).append("\n"); 
		query.append("                      GROUP BY TO_CHAR(OH.CRE_DT, 'YYYYMM')," ).append("\n"); 
		query.append("                               OD.ACCT_CD," ).append("\n"); 
		query.append("                               MO.LOC_CD," ).append("\n"); 
		query.append("                               OD.EQ_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      SELECT REPLACE(@[exe_month], '-', '') AS EXE_YRMON," ).append("\n"); 
		query.append("                             'MNR' AS SYS_SRC_ID," ).append("\n"); 
		query.append("                             '20'||SUBSTR(DTRB_COA_VVD_CD, 5, 4) AS REV_YRMON," ).append("\n"); 
		query.append("                             DTRB_COA_ACCT_CD AS ACCT_CD," ).append("\n"); 
		query.append("                             'CNTR' AS BIZ_UT_ID," ).append("\n"); 
		query.append("                             MO.LOC_CD AS LOC_CD," ).append("\n"); 
		query.append("                             'CNTC' AS VSL_CD," ).append("\n"); 
		query.append("                             SUBSTR(DTRB_COA_VVD_CD, 5, 4) AS SKD_VOY_NO," ).append("\n"); 
		query.append("                             'M' AS SKD_DIR_CD," ).append("\n"); 
		query.append("                             'M' AS REV_DIR_CD," ).append("\n"); 
		query.append("                             NVL(CNTR_TPSZ_CD, 'XX') AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                             1 AS CNTR_QTY," ).append("\n"); 
		query.append("                             SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(AIH.GL_DT, 1, 6), CSR_CURR_CD, 'USD', AID.INV_AMT, 3)) AS ESTM_AMT," ).append("\n"); 
		query.append("                             SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(AIH.GL_DT, 1, 6), CSR_CURR_CD, 'USD', AID.INV_AMT, 3)) AS ACTU_AMT," ).append("\n"); 
		query.append("                             0 AS ACCL_AMT," ).append("\n"); 
		query.append("                             'RV' AS ESTM_VVD_TP_CD," ).append("\n"); 
		query.append("                             'XX' AS ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("                             'M' AS ESTM_BC_DIV_CD," ).append("\n"); 
		query.append("                             '' AS WO_NO" ).append("\n"); 
		query.append("                        FROM AP_INV_DTRB AID," ).append("\n"); 
		query.append("                             AP_INV_HDR AIH," ).append("\n"); 
		query.append("                             MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                       WHERE AID.CSR_NO = AIH.CSR_NO" ).append("\n"); 
		query.append("                         -- 2015.03.11 Chang Young Kim 전년도 1월 1일 부터" ).append("\n"); 
		query.append("                         AND AIH.GL_DT BETWEEN SUBSTR(@[month], 1, 4) - 1||'0101'" ).append("\n"); 
		query.append("                                       AND @[month]" ).append("\n"); 
		query.append("                         AND AIH.TJ_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("                         AND SRC_CTNT = 'SO_M&R'" ).append("\n"); 
		query.append("                         -- 2015.03.11 Chang Young Kim DTRB_COA_VVD_CD가 'CNTC[전년도두자리]'도 가져오도록" ).append("\n"); 
		query.append("                         AND (DTRB_COA_VVD_CD LIKE 'CNTC'||SUBSTR(@[month], 3, 2)||'%' or DTRB_COA_VVD_CD LIKE 'CNTC'||TO_CHAR(SUBSTR(@[month], 3, 2) - 1) ||'%')" ).append("\n"); 
		query.append("                         AND RTRIM(DTRB_COA_ACCT_CD) IN ('511511', '511521', '511531', '511541', '511551', '511561')" ).append("\n"); 
		query.append("                         AND AIH.IF_FLG = 'Y'" ).append("\n"); 
		query.append("                         AND DECODE(SUBSTR(DTRB_COA_VVD_CD, 5, 4)," ).append("\n"); 
		query.append("                                    -- 2015.03.11 Chang Young Kim DTRB_COA_VVD_CD가 전전년도 12월이 아닌경우에 RCV_ERR_FLG가 'E'가 아닌 데이터" ).append("\n"); 
		query.append("                                    SUBSTR(@[month], 3, 2) - 2||'12', 'X', NVL(RCV_ERR_FLG, 'N')) <> 'E'" ).append("\n"); 
		query.append("                       GROUP BY SUBSTR(DTRB_COA_VVD_CD, 5, 4)," ).append("\n"); 
		query.append("                                MO.LOC_CD," ).append("\n"); 
		query.append("                                DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("                                NVL(CNTR_TPSZ_CD, 'XX')," ).append("\n"); 
		query.append("                                AID.ATTR_CTNT1) EST" ).append("\n"); 
		query.append("              GROUP BY EST.EXE_YRMON," ).append("\n"); 
		query.append("                       EST.SYS_SRC_ID," ).append("\n"); 
		query.append("                       EST.REV_YRMON," ).append("\n"); 
		query.append("                       EST.ACCT_CD," ).append("\n"); 
		query.append("                       EST.BIZ_UT_ID," ).append("\n"); 
		query.append("                       EST.LOC_CD," ).append("\n"); 
		query.append("                       EST.VSL_CD," ).append("\n"); 
		query.append("                       EST.SKD_VOY_NO," ).append("\n"); 
		query.append("                       EST.SKD_DIR_CD," ).append("\n"); 
		query.append("                       EST.REV_DIR_CD," ).append("\n"); 
		query.append("                       EST.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ORDER BY EST.EXE_YRMON," ).append("\n"); 
		query.append("                       EST.SYS_SRC_ID," ).append("\n"); 
		query.append("                       EST.REV_YRMON," ).append("\n"); 
		query.append("                       EST.ACCT_CD," ).append("\n"); 
		query.append("                       EST.BIZ_UT_ID," ).append("\n"); 
		query.append("                       EST.LOC_CD," ).append("\n"); 
		query.append("                       EST.VSL_CD," ).append("\n"); 
		query.append("                       EST.SKD_VOY_NO," ).append("\n"); 
		query.append("                       EST.SKD_DIR_CD," ).append("\n"); 
		query.append("                       EST.REV_DIR_CD," ).append("\n"); 
		query.append("                       EST.CNTR_TPSZ_CD)A" ).append("\n"); 
		query.append("			  WHERE A.EXE_YRMON >= A.REV_YRMON" ).append("\n"); 

	}
}