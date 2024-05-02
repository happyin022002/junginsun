/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchMGSChargeCreationResultDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.02.08 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchMGSChargeCreationResultDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchMGSChargeCreationResultData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchMGSChargeCreationResultDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchMGSChargeCreationResultDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(A.LSE_CHG_STS_CD) AS LSE_CHG_STS_CD," ).append("\n"); 
		query.append("SUM(B.LSE_CHG_AMT) AS LSE_CHG_SMRY_AMT," ).append("\n"); 
		query.append("SUM(" ).append("\n"); 
		query.append("CASE WHEN B.LSE_CHG_AUD_STS_CD IS NOT NULL THEN NVL( B.INV_LSE_CHG_AMT,0) + NVL(B.INV_TAX_AMT,0) - ABS(NVL(B.INV_CR_AMT,0))" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")  INV_SMRY_AMT ," ).append("\n"); 
		query.append("SUM( NVL(B.INV_TAX_AMT,0) ) AS INV_TAX_AMT_DTL," ).append("\n"); 
		query.append("SUM( NVL(B.INV_CR_AMT ,0) ) AS INV_CR_AMT_DTL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUM (CASE WHEN B.PAY_LSE_CHG_STS_CD = 'C' AND A.LSE_CHG_STS_CD IN ('S','C')  THEN" ).append("\n"); 
		query.append("NVL( B.PAY_LSE_CHG_AMT,0) + NVL(B.PAY_TAX_AMT,0) - ABS(NVL(B.PAY_CR_AMT,0))" ).append("\n"); 
		query.append("ELSE 0 END   ) PAY_LSE_CHG_AMT," ).append("\n"); 
		query.append("SUM (CASE WHEN B.PAY_LSE_CHG_STS_CD = 'C' AND A.LSE_CHG_STS_CD IN ('S','C') THEN" ).append("\n"); 
		query.append("NVL( B.PAY_LSE_CHG_AMT,0)" ).append("\n"); 
		query.append("ELSE 0 END   ) DEBIT_AMT," ).append("\n"); 
		query.append("SUM (CASE WHEN B.PAY_LSE_CHG_STS_CD = 'C' AND A.LSE_CHG_STS_CD IN ('S','C') THEN" ).append("\n"); 
		query.append("ABS(NVL(B.PAY_CR_AMT,0))" ).append("\n"); 
		query.append("ELSE 0 END   ) CR_SMRY_AMT," ).append("\n"); 
		query.append("SUM (CASE WHEN B.PAY_LSE_CHG_STS_CD = 'C' AND A.LSE_CHG_STS_CD IN ('S','C') THEN" ).append("\n"); 
		query.append("NVL(B.PAY_TAX_AMT,0)" ).append("\n"); 
		query.append("ELSE 0 END   ) TAX_SMRY_AMT," ).append("\n"); 
		query.append("MAX(A.CRE_OFC_CD) AS CRE_OFC_CD," ).append("\n"); 
		query.append("MAX(A.CRE_USR_ID) AS CRE_USR_ID," ).append("\n"); 
		query.append("MAX(TO_CHAR(A.CRE_DT, 'YYYY-MM-DD')) AS CRE_DT," ).append("\n"); 
		query.append("MAX(A.CHG_CRE_SEQ)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM CGM_LSE_CHG_HDR A , CGM_LSE_CHG_DTL B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND A.CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.CHG_CRE_SEQ" ).append("\n"); 

	}
}