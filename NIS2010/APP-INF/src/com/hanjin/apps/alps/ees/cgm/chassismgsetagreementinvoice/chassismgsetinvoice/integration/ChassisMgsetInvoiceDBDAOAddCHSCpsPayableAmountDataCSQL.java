/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOAddCHSCpsPayableAmountDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOAddCHSCpsPayableAmountDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * -- 2015.05.13 Chang Young Kim -------------------------------------------------------------------------------------------------------
	  * [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정
	  *  : ChassisMgsetInvoiceDBDAOSearchCHSCpsInvoiceListDataRSQL 에서 SELOPB, NYCRA 인경우엔 cost_ofc_cd 조건을 걸지 않음
	  *    따라서 PHXSA에서 Payable Charge Confirm한 후 Invoice Creation 하기 위하여 COST_OFC_CD Sub-Query를 변경함.
	  * -------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOAddCHSCpsPayableAmountDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("parent_cost_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOAddCHSCpsPayableAmountDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_PAY_INV" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	PAY_INV_SEQ," ).append("\n"); 
		query.append("	INV_NO," ).append("\n"); 
		query.append("	EQ_KND_CD," ).append("\n"); 
		query.append("	CHSS_MGST_INV_KND_CD," ).append("\n"); 
		query.append("	CHSS_MGST_INV_STS_CD," ).append("\n"); 
		query.append("	VNDR_SEQ," ).append("\n"); 
		query.append("	CURR_CD," ).append("\n"); 
		query.append("	COST_YRMON," ).append("\n"); 
		query.append("	COST_OFC_CD," ).append("\n"); 
		query.append("	ISS_OFC_CD," ).append("\n"); 
		query.append("	REV_VSL_CD," ).append("\n"); 
		query.append("	REV_SKD_VOY_NO," ).append("\n"); 
		query.append("	REV_SKD_DIR_CD," ).append("\n"); 
		query.append("	REV_DIR_CD," ).append("\n"); 
		query.append("	AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("	AGMT_SEQ," ).append("\n"); 
		query.append("	AGMT_VER_NO," ).append("\n"); 
		query.append("	CHG_SMRY_AMT," ).append("\n"); 
		query.append("	INV_SMRY_AMT," ).append("\n"); 
		query.append("	INV_DT," ).append("\n"); 
		query.append("	INV_USR_ID," ).append("\n"); 
		query.append("	CHG_CRE_SEQ," ).append("\n"); 
		query.append("	CHSS_POOL_CD," ).append("\n"); 
		query.append("	INV_CR_SMRY_AMT," ).append("\n"); 
		query.append("	INV_TAX_SMRY_AMT," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    CGM_PAY_INV_SEQ.NEXTVAL," ).append("\n"); 
		query.append("    T.INV_NO," ).append("\n"); 
		query.append("    T.EQ_KND_CD," ).append("\n"); 
		query.append("    T.CHSS_MGST_INV_KND_CD," ).append("\n"); 
		query.append("    T.CHSS_MGST_INV_STS_CD," ).append("\n"); 
		query.append("    T.VNDR_SEQ," ).append("\n"); 
		query.append("    T.CURR_CD," ).append("\n"); 
		query.append("    T.COST_YRMON," ).append("\n"); 
		query.append("    T.COST_OFC_CD," ).append("\n"); 
		query.append("    T.ISS_OFC_CD," ).append("\n"); 
		query.append("    T.REV_VSL_CD," ).append("\n"); 
		query.append("    T.REV_SKD_VOY_NO," ).append("\n"); 
		query.append("    T.REV_SKD_DIR_CD," ).append("\n"); 
		query.append("    T.REV_DIR_CD," ).append("\n"); 
		query.append("    T.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    T.AGMT_SEQ," ).append("\n"); 
		query.append("    T.AGMT_VER_NO," ).append("\n"); 
		query.append("    T.CHG_SMRY_AMT," ).append("\n"); 
		query.append("    T.INV_SMRY_AMT," ).append("\n"); 
		query.append("    T.INV_DT," ).append("\n"); 
		query.append("    T.INV_USR_ID," ).append("\n"); 
		query.append("    T.CHG_CRE_SEQ," ).append("\n"); 
		query.append("	T.CHSS_POOL_CD," ).append("\n"); 
		query.append("	T.INV_CR_SMRY_AMT," ).append("\n"); 
		query.append("	T.INV_TAX_SMRY_AMT," ).append("\n"); 
		query.append("    T.CRE_USR_ID," ).append("\n"); 
		query.append("    T.CRE_DT," ).append("\n"); 
		query.append("    T.UPD_USR_ID," ).append("\n"); 
		query.append("    T.UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    	B.INV_NO," ).append("\n"); 
		query.append("    	@[eq_knd_cd] AS EQ_KND_CD," ).append("\n"); 
		query.append("    	'ZP' AS CHSS_MGST_INV_KND_CD," ).append("\n"); 
		query.append("    	'S' AS CHSS_MGST_INV_STS_CD," ).append("\n"); 
		query.append("    	MIN(C.VNDR_SEQ) AS VNDR_SEQ," ).append("\n"); 
		query.append("    	MIN(A.CURR_CD) AS CURR_CD," ).append("\n"); 
		query.append("    	MIN(A.COST_YRMON) AS COST_YRMON," ).append("\n"); 
		query.append("--      2015.05.13 Chang-Young Kim [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정" ).append("\n"); 
		query.append("--    	(" ).append("\n"); 
		query.append("--    	    SELECT DECODE(B.CNT_CD, 'US', 'NYCRA', A.OFC_CD) AS OFC_CD " ).append("\n"); 
		query.append("--            FROM " ).append("\n"); 
		query.append("--                MDM_ORGANIZATION A, " ).append("\n"); 
		query.append("--                MDM_LOCATION B " ).append("\n"); 
		query.append("--            WHERE " ).append("\n"); 
		query.append("--                A.OFC_CD = [cost_ofc_cd]" ).append("\n"); 
		query.append("--                AND A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("--        ) AS COST_OFC_CD," ).append("\n"); 
		query.append("    	@[cost_ofc_cd] AS COST_OFC_CD," ).append("\n"); 
		query.append("    	@[iss_ofc_cd] AS ISS_OFC_CD," ).append("\n"); 
		query.append("    	'CNTC' REV_VSL_CD," ).append("\n"); 
		query.append("    	SUBSTR(MIN(A.COST_YRMON),3,6) AS REV_SKD_VOY_NO," ).append("\n"); 
		query.append("    	'M' AS REV_SKD_DIR_CD," ).append("\n"); 
		query.append("    	'M' AS REV_DIR_CD," ).append("\n"); 
		query.append("    	MIN(B.AGMT_OFC_CTY_CD) AS AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    	MIN(B.AGMT_SEQ) AS AGMT_SEQ," ).append("\n"); 
		query.append("    	MIN(B.AGMT_VER_NO) AS AGMT_VER_NO," ).append("\n"); 
		query.append("    	NVL(SUM(B.PAY_LSE_CHG_AMT),0) + NVL(SUM(B.PAY_TAX_AMT),0) - ABS(NVL(SUM(B.PAY_CR_AMT),0)) AS CHG_SMRY_AMT," ).append("\n"); 
		query.append("    	NVL(SUM(B.PAY_LSE_CHG_AMT),0) + NVL(SUM(B.PAY_TAX_AMT),0) - ABS(NVL(SUM(B.PAY_CR_AMT),0)) AS INV_SMRY_AMT," ).append("\n"); 
		query.append("    	TO_DATE(@[inv_dt],'YYYYMMDD') AS INV_DT," ).append("\n"); 
		query.append("    	@[inv_usr_id] AS INV_USR_ID," ).append("\n"); 
		query.append("    	@[chg_cre_seq] AS CHG_CRE_SEQ," ).append("\n"); 
		query.append("		MIN(C.CHSS_POOL_CD) AS CHSS_POOL_CD," ).append("\n"); 
		query.append("		NVL(SUM(B.PAY_CR_AMT),0) AS INV_CR_SMRY_AMT," ).append("\n"); 
		query.append("		NVL(SUM(B.PAY_TAX_AMT),0) AS INV_TAX_SMRY_AMT," ).append("\n"); 
		query.append("    	@[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("    	SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("    	@[upd_usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("    	SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("    FROM CGM_LSE_CHG_HDR A, CGM_LSE_CHG_DTL B, CGM_AGREEMENT C" ).append("\n"); 
		query.append("    WHERE A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("          AND A.AGMT_VER_NO = B.AGMT_VER_NO -- ADD Chang-Young Kim, 20150424" ).append("\n"); 
		query.append("          AND A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("          AND A.COST_YRMON_SEQ = B.COST_YRMON_SEQ -- ADD Chang-Young Kim, 20150424" ).append("\n"); 
		query.append("          AND A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("          AND A.COST_YRMON_SEQ = @[parent_cost_yrmon_seq] -- ADD YONGCHAN SHIN, 20140324" ).append("\n"); 
		query.append("          AND A.CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("          AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("          AND B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("          AND B.PAY_LSE_CHG_STS_CD = 'C'" ).append("\n"); 
		query.append("          AND A.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("          AND A.AGMT_VER_NO = C.AGMT_VER_NO" ).append("\n"); 
		query.append("          AND C.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("    GROUP BY B.INV_NO" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}