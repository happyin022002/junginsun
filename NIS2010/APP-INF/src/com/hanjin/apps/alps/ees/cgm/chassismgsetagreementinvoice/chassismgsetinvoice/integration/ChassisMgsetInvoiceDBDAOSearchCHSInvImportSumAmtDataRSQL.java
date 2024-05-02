/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSInvImportSumAmtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.14
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2014.02.14 한종희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jonghee HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSInvImportSumAmtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchCHSInvImportSumAmtData
	  * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * 2014-02-07 JongHee Han Payable Charge Creation 기능 보완 및 오류 해결 CGM_LSE_CHG_HDR Summary시 COST_YRMON_SEQ Where 조건 누락으로 Data 요류 발생 해결
	  * 2014-02-07 YongChan Shin, SQL 조건문 추가 (COST_YRMON_SEQ)
	  * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSInvImportSumAmtDataRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSInvImportSumAmtDataRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX( A XAK1CGM_LSE_CHG_HDR ) */ " ).append("\n"); 
		query.append("    A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    A.AGMT_SEQ," ).append("\n"); 
		query.append("    A.AGMT_VER_NO,    -- 추가된 조건, 2014-02-07, YongChan Shin" ).append("\n"); 
		query.append("    A.COST_YRMON,     -- 추가된 조건, 2014-02-07, YongChan Shin" ).append("\n"); 
		query.append("    A.COST_YRMON_SEQ, -- 추가된 조건, 2014-02-07, YongChan Shin" ).append("\n"); 
		query.append("	@[eq_knd_cd] AS EQ_KND_CD," ).append("\n"); 
		query.append("    NVL(SUM(B.INV_LSE_CHG_AMT),0) + NVL(SUM(B.INV_TAX_AMT),0) - ABS(NVL(SUM(B.INV_CR_AMT),0)) AS INV_SMRY_AMT," ).append("\n"); 
		query.append("    NVL(SUM(B.INV_CR_AMT),0)  AS CR_SMRY_AMT," ).append("\n"); 
		query.append("    NVL(SUM(B.INV_TAX_AMT),0)  AS TAX_SMRY_AMT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	CGM_LSE_CHG_HDR A " ).append("\n"); 
		query.append("	LEFT JOIN CGM_LSE_CHG_DTL B ON ( " ).append("\n"); 
		query.append("                        	    A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                            AND A.AGMT_SEQ        = B.AGMT_SEQ" ).append("\n"); 
		query.append("                            AND A.AGMT_VER_NO     = B.AGMT_VER_NO" ).append("\n"); 
		query.append("                            AND A.COST_YRMON      = B.COST_YRMON" ).append("\n"); 
		query.append("                            AND A.COST_YRMON_SEQ  = B.COST_YRMON_SEQ  -- 추가된 조건문, 2014-02-07, YongChan Shin" ).append("\n"); 
		query.append("                            AND B.EQ_KND_CD       = @[eq_knd_cd]" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("WHERE   " ).append("\n"); 
		query.append("    A.EQ_KND_CD       = @[eq_knd_cd]" ).append("\n"); 
		query.append("    AND A.COST_YRMON  = @[cost_yrmon]" ).append("\n"); 
		query.append("    AND A.CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("    A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    A.AGMT_SEQ," ).append("\n"); 
		query.append("    A.AGMT_VER_NO,    -- 추가된 조건, 2014-02-07, YongChan Shin" ).append("\n"); 
		query.append("    A.COST_YRMON,     -- 추가된 조건, 2014-02-07, YongChan Shin" ).append("\n"); 
		query.append("    A.COST_YRMON_SEQ -- 추가된 조건, 2014-02-07, YongChan Shin" ).append("\n"); 

	}
}