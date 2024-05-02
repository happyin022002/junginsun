/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ExpenseMgtDBDAOaddGLEstimateIFDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.10 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author MyoungSinPark
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
	  * addGLEstimateIFData
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
		query.append("Path : com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO GL_ESTM_IF_ERP ( EXE_YRMON , SYS_SRC_ID , REV_YRMON , ACCT_CD , ESTM_SEQ_NO , AGMT_NO , WO_NO , BIZ_UT_ID , LOC_CD , VSL_CD , SKD_VOY_NO , SKD_DIR_CD , REV_DIR_CD , CNTR_TPSZ_CD , CNTR_QTY , BSA_SLT_QTY , CRR_CD , SLT_COST_AMT , CUST_CNT_CD , CUST_SEQ , VVD_DUR_NO , HIR_DT_AMT , ESTM_AMT , ACT_AMT , ACCL_AMT , ESTM_VVD_TP_CD , ESTM_IOC_DIV_CD , ESTM_VVD_HDR_ID , ESTM_BC_DIV_CD , OP_LSE_DIV_FLG , TTL_TRF_AMT , CRE_USR_ID , CRE_DT , UPD_USR_ID , UPD_DT )" ).append("\n"); 
		query.append("SELECT A.EXE_YRMON ," ).append("\n"); 
		query.append("A.SYS_SRC_ID ," ).append("\n"); 
		query.append("A.REV_YRMON ," ).append("\n"); 
		query.append("ACCT_CD ," ).append("\n"); 
		query.append("ROWNUM AS ESTM_SEQ_NO ," ).append("\n"); 
		query.append("'' AS AGMT_NO ," ).append("\n"); 
		query.append("WO_NO AS WO_NO ," ).append("\n"); 
		query.append("A.BIZ_UT_ID ," ).append("\n"); 
		query.append("A.LOC_CD ," ).append("\n"); 
		query.append("A.VSL_CD ," ).append("\n"); 
		query.append("A.SKD_VOY_NO ," ).append("\n"); 
		query.append("A.SKD_DIR_CD ," ).append("\n"); 
		query.append("A.REV_DIR_CD ," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("A.CNTR_QTY ," ).append("\n"); 
		query.append("'' AS BSA_SLT_QTY ," ).append("\n"); 
		query.append("'' AS CRR_CD ," ).append("\n"); 
		query.append("'' AS SLT_COST_AMT ," ).append("\n"); 
		query.append("'' AS CUST_CNT_CD ," ).append("\n"); 
		query.append("'' AS CUST_SEQ ," ).append("\n"); 
		query.append("'' AS VVD_DUR_NO ," ).append("\n"); 
		query.append("'' AS HIR_DT_AMT ," ).append("\n"); 
		query.append("TO_NUMBER(DECODE(SIGN(A.ACCL_AMT), -1, A.ACTU_AMT, A.ESTM_AMT)) ESTM_AMT ," ).append("\n"); 
		query.append("TO_NUMBER(A.ACTU_AMT) ACTU_AMT ," ).append("\n"); 
		query.append("TO_NUMBER(DECODE(SIGN(A.ACCL_AMT), -1, 0, A.ACCL_AMT)) ACCL_AMT ," ).append("\n"); 
		query.append("A.ESTM_VVD_TP_CD ," ).append("\n"); 
		query.append("A.ESTM_IOC_DIV_CD ," ).append("\n"); 
		query.append("'' AS ESTM_VVD_HDR_ID ," ).append("\n"); 
		query.append("A.ESTM_BC_DIV_CD ," ).append("\n"); 
		query.append("'' AS OP_LSE_DIV_FLG ," ).append("\n"); 
		query.append("'' AS TTL_TRF_AMT ," ).append("\n"); 
		query.append("'SYSTEM' ," ).append("\n"); 
		query.append("SYSDATE ," ).append("\n"); 
		query.append("'SYSTEM' ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT EST.EXE_YRMON," ).append("\n"); 
		query.append("EST.SYS_SRC_ID," ).append("\n"); 
		query.append("EST.REV_YRMON," ).append("\n"); 
		query.append("EST.ACCT_CD," ).append("\n"); 
		query.append("EST.BIZ_UT_ID," ).append("\n"); 
		query.append("EST.LOC_CD," ).append("\n"); 
		query.append("EST.VSL_CD," ).append("\n"); 
		query.append("EST.SKD_VOY_NO," ).append("\n"); 
		query.append("EST.SKD_DIR_CD," ).append("\n"); 
		query.append("EST.REV_DIR_CD," ).append("\n"); 
		query.append("EST.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("1 CNTR_QTY," ).append("\n"); 
		query.append("SUM(ESTM_AMT) ESTM_AMT," ).append("\n"); 
		query.append("SUM(ACTU_AMT) ACTU_AMT," ).append("\n"); 
		query.append("SUM(ESTM_AMT) - SUM(ACTU_AMT) ACCL_AMT," ).append("\n"); 
		query.append("MAX(EST.ESTM_VVD_TP_CD) ESTM_VVD_TP_CD," ).append("\n"); 
		query.append("MAX(EST.ESTM_IOC_DIV_CD) ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("MAX(EST.ESTM_BC_DIV_CD) ESTM_BC_DIV_CD," ).append("\n"); 
		query.append("MAX(EST.WO_NO) WO_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT REPLACE (@[exe_month], '-', '') EXE_YRMON ," ).append("\n"); 
		query.append("'MNR' SYS_SRC_ID ," ).append("\n"); 
		query.append("TO_CHAR(OH.CRE_DT, 'YYYYMM') REV_YRMON ," ).append("\n"); 
		query.append("OD.ACCT_CD ACCT_CD ," ).append("\n"); 
		query.append("'CNTR' BIZ_UT_ID ," ).append("\n"); 
		query.append("MO.LOC_CD LOC_CD ," ).append("\n"); 
		query.append("'CNTC' VSL_CD ," ).append("\n"); 
		query.append("SUBSTR(TO_CHAR(OH.CRE_DT, 'YYYYMM'), 3, 4) SKD_VOY_NO ," ).append("\n"); 
		query.append("'M' SKD_DIR_CD ," ).append("\n"); 
		query.append("'M' REV_DIR_CD ," ).append("\n"); 
		query.append("NVL(OD.EQ_TPSZ_CD, 'XX') CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("SUM(OD.RPR_QTY) CNTR_QTY ," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT, 3))), 0) ESTM_AMT ," ).append("\n"); 
		query.append("0 ACTU_AMT ," ).append("\n"); 
		query.append("0 ACCL_AMT ," ).append("\n"); 
		query.append("'RV' ESTM_VVD_TP_CD ," ).append("\n"); 
		query.append("'XX' ESTM_IOC_DIV_CD ," ).append("\n"); 
		query.append("'M' ESTM_BC_DIV_CD ," ).append("\n"); 
		query.append("'' WO_NO" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR OH," ).append("\n"); 
		query.append("MNR_ORD_DTL OD," ).append("\n"); 
		query.append("MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND OH.CRE_DT BETWEEN TO_DATE(substr(@[month], 1, 4)||'0101', 'yyyymmdd') AND TO_DATE(@[month], 'yyyymmdd')" ).append("\n"); 
		query.append("AND OD.ACCT_CD != '512125'" ).append("\n"); 
		query.append("AND OD.ACCT_CD IS NOT NULL" ).append("\n"); 
		query.append("AND OH.COST_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM MNR_PAY_INV_WRK MPIW," ).append("\n"); 
		query.append("AP_PAY_INV API," ).append("\n"); 
		query.append("AP_INV_HDR AIH" ).append("\n"); 
		query.append("WHERE OD.PAY_INV_SEQ = MPIW.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND MPIW.INV_RGST_NO = API.INV_RGST_NO" ).append("\n"); 
		query.append("AND API.CSR_NO = AIH.CSR_NO" ).append("\n"); 
		query.append("AND AIH.IF_FLG = 'Y'" ).append("\n"); 
		query.append("AND NVL(AIH.RCV_ERR_FLG, 'N') <> 'E' )" ).append("\n"); 
		query.append("GROUP BY TO_CHAR(OH.CRE_DT," ).append("\n"); 
		query.append("'YYYYMM'), OD.ACCT_CD, MO.LOC_CD, OD.EQ_TPSZ_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT REPLACE (@[exe_month], '-', '') EXE_YRMON ," ).append("\n"); 
		query.append("'MNR' SYS_SRC_ID ," ).append("\n"); 
		query.append("'20'||SUBSTR(DTRB_COA_VVD_CD, 5, 4) REV_YRMON ," ).append("\n"); 
		query.append("DTRB_COA_ACCT_CD ACCT_CD ," ).append("\n"); 
		query.append("'CNTR' BIZ_UT_ID ," ).append("\n"); 
		query.append("MO.LOC_CD LOC_CD ," ).append("\n"); 
		query.append("'CNTC' VSL_CD ," ).append("\n"); 
		query.append("SUBSTR(DTRB_COA_VVD_CD, 5, 4) SKD_VOY_NO ," ).append("\n"); 
		query.append("'M' SKD_DIR_CD ," ).append("\n"); 
		query.append("'M' REV_DIR_CD ," ).append("\n"); 
		query.append("NVL(CNTR_TPSZ_CD, 'XX') CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("1 CNTR_QTY ," ).append("\n"); 
		query.append("SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(AIH.GL_DT, 1, 6), CSR_CURR_CD, 'USD', AID.INV_AMT, 3)) ESTM_AMT ," ).append("\n"); 
		query.append("SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(AIH.GL_DT, 1, 6), CSR_CURR_CD, 'USD', AID.INV_AMT, 3)) ACTU_AMT ," ).append("\n"); 
		query.append("0 ACCL_AMT ," ).append("\n"); 
		query.append("'RV' ESTM_VVD_TP_CD ," ).append("\n"); 
		query.append("'XX' ESTM_IOC_DIV_CD ," ).append("\n"); 
		query.append("'M' ESTM_BC_DIV_CD ," ).append("\n"); 
		query.append("'' WO_NO" ).append("\n"); 
		query.append("from AP_INV_DTRB AID," ).append("\n"); 
		query.append("AP_INV_HDR AIH," ).append("\n"); 
		query.append("MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE AID.CSR_NO = AIH.CSR_NO" ).append("\n"); 
		query.append("AND AIH.GL_DT BETWEEN substr(@[month], 1, 4)||'0101' AND @[month] -- form은 해당 년도의 1월1일 To는EXE_YRMON 의 전달 마지막 날" ).append("\n"); 
		query.append("AND AIH.TJ_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND SRC_CTNT = 'SO_M&R'" ).append("\n"); 
		query.append("AND DTRB_COA_VVD_CD LIKE 'CNTC'||substr(@[month], 3, 2)||'%'" ).append("\n"); 
		query.append("AND RTRIM(DTRB_COA_ACCT_CD) IN ( '511511'," ).append("\n"); 
		query.append("'511521'," ).append("\n"); 
		query.append("'511531'," ).append("\n"); 
		query.append("'511541'," ).append("\n"); 
		query.append("'511551'," ).append("\n"); 
		query.append("'511561')" ).append("\n"); 
		query.append("AND AIH.IF_FLG = 'Y'" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(DTRB_COA_VVD_CD, 5, 4), '1101', 'X', NVL(RCV_ERR_FLG, 'N')) <> 'E'" ).append("\n"); 
		query.append("GROUP BY SUBSTR(DTRB_COA_VVD_CD, 5, 4), MO.LOC_CD, DTRB_COA_ACCT_CD, NVL(CNTR_TPSZ_CD, 'XX')" ).append("\n"); 
		query.append(") EST" ).append("\n"); 
		query.append("GROUP BY EST.EXE_YRMON, EST.SYS_SRC_ID, EST.REV_YRMON, EST.ACCT_CD, EST.BIZ_UT_ID, EST.LOC_CD, EST.VSL_CD, EST.SKD_VOY_NO, EST.SKD_DIR_CD, EST.REV_DIR_CD, EST.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY EST.EXE_YRMON, EST.SYS_SRC_ID, EST.REV_YRMON, EST.ACCT_CD, EST.BIZ_UT_ID, EST.LOC_CD, EST.VSL_CD, EST.SKD_VOY_NO, EST.SKD_DIR_CD, EST.REV_DIR_CD, EST.CNTR_TPSZ_CD ) A" ).append("\n"); 

	}
}