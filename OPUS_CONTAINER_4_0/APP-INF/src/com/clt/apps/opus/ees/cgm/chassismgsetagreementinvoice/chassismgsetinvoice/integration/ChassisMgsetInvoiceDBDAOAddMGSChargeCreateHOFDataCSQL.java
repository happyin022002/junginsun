/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOAddMGSChargeCreateHOFDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOAddMGSChargeCreateHOFDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.AddMGSChargeCreateHOFData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOAddMGSChargeCreateHOFDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOAddMGSChargeCreateHOFDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    AGMT_SEQ," ).append("\n"); 
		query.append("    AGMT_VER_NO," ).append("\n"); 
		query.append("    COST_YRMON," ).append("\n"); 
		query.append("    EQ_NO," ).append("\n"); 
		query.append("    CHG_CD," ).append("\n"); 
		query.append("    CHG_SEQ," ).append("\n"); 
		query.append("    EQ_KND_CD," ).append("\n"); 
		query.append("    LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("    LSE_USE_DYS," ).append("\n"); 
		query.append("    LSE_RT_AMT," ).append("\n"); 
		query.append("    LSE_CHG_AMT," ).append("\n"); 
		query.append("    EQ_ONH_DT," ).append("\n"); 
		query.append("    EQ_ONH_LOC_CD," ).append("\n"); 
		query.append("    EQ_OFFH_DT," ).append("\n"); 
		query.append("    EQ_OFFH_LOC_CD," ).append("\n"); 
		query.append("    EQ_BIL_ST_DT," ).append("\n"); 
		query.append("    EQ_BIL_END_DT," ).append("\n"); 
		query.append("	PAY_LSE_CHG_STS_CD," ).append("\n"); 
		query.append("	COST_CD," ).append("\n"); 
		query.append("	ACCT_CD," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    A.AGMT_SEQ," ).append("\n"); 
		query.append("    MAX(A.AGMT_VER_NO) AS AGMT_VER_NO," ).append("\n"); 
		query.append("    MIN(A.COST_YRMON) AS COST_YRMON," ).append("\n"); 
		query.append("    A.EQ_NO," ).append("\n"); 
		query.append("    MIN(A.CH7_CD) AS CH7_CD," ).append("\n"); 
		query.append("    MIN(A.CHG_SEQ) AS CHG_SEQ," ).append("\n"); 
		query.append("    MIN(A.EQ_KND_CD) AS EQ_KND_CD, " ).append("\n"); 
		query.append("    MIN(A.LSE_CHG_AUD_STS_CD) AS LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("    SUM(LSE_USE_DAYS) AS LSE_USE_DAYS," ).append("\n"); 
		query.append("    MAX(LSE_RT_AMT) AS LSE_RT_AMT," ).append("\n"); 
		query.append("    SUM(LSE_CHG_AMT) AS LSE_CHG_AMT," ).append("\n"); 
		query.append("  MAX(A.STS_EVNT_DT) AS EQ_ONH_DT," ).append("\n"); 
		query.append("  MAX(A.STS_EVNT_LOC_CD) AS EQ_ONH_LOC_CD," ).append("\n"); 
		query.append("  MAX(A.STS_EVNT_DT) AS EQ_OFFH_DT," ).append("\n"); 
		query.append("  MAX(A.STS_EVNT_LOC_CD) AS EQ_OFFH_LOC_CD," ).append("\n"); 
		query.append("  MAX(A.STS_EVNT_DT) AS EQ_BIL_ST_DT," ).append("\n"); 
		query.append("  MAX(A.STS_EVNT_DT)  AS EQ_BIL_END_DT," ).append("\n"); 
		query.append("  MAX(A.PAY_LSE_CHG_STS_CD) AS PAY_LSE_CHG_STS_CD," ).append("\n"); 
		query.append("  MAX(A.COST_CD) AS COST_CD," ).append("\n"); 
		query.append("  MAX(A.ACCT_CD) AS ACCT_CD," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT T1.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("                T1.AGMT_SEQ," ).append("\n"); 
		query.append("( SELECT AGMT_VER_NO FROM CGM_AGREEMENT A WHERE A.AGMT_OFC_CTY_CD = T1.AGMT_OFC_CTY_CD  " ).append("\n"); 
		query.append("                                          AND A.AGMT_SEQ = T1.AGMT_SEQ" ).append("\n"); 
		query.append("                                          AND A.LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("                                          ) AGMT_VER_NO," ).append("\n"); 
		query.append("                T1.EFF_DT," ).append("\n"); 
		query.append("                T1.EXP_DT," ).append("\n"); 
		query.append("                @[cost_yrmon] AS COST_YRMON," ).append("\n"); 
		query.append("                T2.EQ_NO," ).append("\n"); 
		query.append("                'HOF' AS CH7_CD," ).append("\n"); 
		query.append("                1 AS CHG_SEQ," ).append("\n"); 
		query.append("                'G' AS EQ_KND_CD," ).append("\n"); 
		query.append("                'H' AS LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("				'H' AS PAY_LSE_CHG_STS_CD," ).append("\n"); 
		query.append("                1 AS LSE_USE_DAYS," ).append("\n"); 
		query.append("                T1.OFFH_HNDL_RT_AMT AS LSE_RT_AMT," ).append("\n"); 
		query.append("                T1.OFFH_HNDL_RT_AMT AS LSE_CHG_AMT," ).append("\n"); 
		query.append("                T2.EQ_ASET_STS_CD," ).append("\n"); 
		query.append("                T2.STS_EVNT_DT," ).append("\n"); 
		query.append("      T2.STS_EVNT_LOC_CD," ).append("\n"); 
		query.append("                T2.EQ_STS_SEQ," ).append("\n"); 
		query.append("--      MAX(T1.OFFH_HNDL_RT_AMT) KEEP (DENSE_RANK LAST" ).append("\n"); 
		query.append("--        ORDER BY T1.AGMT_OFC_CTY_CD, T1.AGMT_SEQ, T2.EQ_NO, T1.AGMT_VER_NO) over (partition by T1.AGMT_OFC_CTY_CD, T1.AGMT_SEQ, T2.EQ_NO) AS LSE_RT_AMT2," ).append("\n"); 
		query.append("				'EQCGLT' AS COST_CD," ).append("\n"); 
		query.append("				'510845' AS ACCT_CD" ).append("\n"); 
		query.append("    FROM CGM_AGREEMENT T1 ," ).append("\n"); 
		query.append("      CGM_EQ_STS_HIS T2" ).append("\n"); 
		query.append("        WHERE   T1.AGMT_OFC_CTY_CD = T2.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND T1.AGMT_SEQ = T2.AGMT_SEQ" ).append("\n"); 
		query.append("                AND T1.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("                AND T2.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("                AND T1.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("                AND T1.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("                AND T2.TERM_CNG_SEQ IS NULL" ).append("\n"); 
		query.append("                AND T2.EQ_ASET_STS_CD = 'LSO'" ).append("\n"); 
		query.append("                AND T2.STS_EVNT_DT >= TO_DATE (@[cost_yrmon] || '01', 'YYYYMMDD')" ).append("\n"); 
		query.append("                AND T2.STS_EVNT_DT < ADD_MONTHS (TO_DATE (@[cost_yrmon], 'YYYYMM'), 1)" ).append("\n"); 
		query.append("                AND T2.STS_EVNT_DT BETWEEN T1.EFF_DT AND T1.EXP_DT + 0.99999" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("GROUP BY A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("  A.AGMT_SEQ,A.EQ_NO" ).append("\n"); 

	}
}