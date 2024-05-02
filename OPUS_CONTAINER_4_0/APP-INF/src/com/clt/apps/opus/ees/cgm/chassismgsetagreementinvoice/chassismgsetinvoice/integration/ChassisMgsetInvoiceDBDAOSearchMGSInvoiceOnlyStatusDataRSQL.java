/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchMGSInvoiceOnlyStatusDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.08 조재성
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

public class ChassisMgsetInvoiceDBDAOSearchMGSInvoiceOnlyStatusDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchMGSInvoiceOnlyStatusData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchMGSInvoiceOnlyStatusDataRSQL(){
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
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchMGSInvoiceOnlyStatusDataRSQL").append("\n"); 
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
		query.append("A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ,6,'0') AS AGMT_NO," ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("A.AGMT_VER_NO," ).append("\n"); 
		query.append("C.AGMT_LSTM_CD," ).append("\n"); 
		query.append("C.EQ_TPSZ_CD," ).append("\n"); 
		query.append("B.PAY_LSE_CHG_STS_CD," ).append("\n"); 
		query.append("B.LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("B.INV_CUST_EQ_NO," ).append("\n"); 
		query.append("B.EQ_NO," ).append("\n"); 
		query.append("B.INV_REF_NO," ).append("\n"); 
		query.append("B.INV_NO," ).append("\n"); 
		query.append("B.CHG_CD," ).append("\n"); 
		query.append("B.CHG_SEQ," ).append("\n"); 
		query.append("TO_CHAR(B.INV_BIL_ST_DT,'YYYY-MM-DD') AS INV_BIL_ST_DT," ).append("\n"); 
		query.append("TO_CHAR(B.INV_BIL_END_DT,'YYYY-MM-DD') AS INV_BIL_END_DT," ).append("\n"); 
		query.append("B.INV_EQ_ONH_LOC_NM," ).append("\n"); 
		query.append("B.INV_EQ_OFFH_LOC_NM," ).append("\n"); 
		query.append("B.INV_LSE_USE_DYS," ).append("\n"); 
		query.append("B.INV_LSE_RT_AMT," ).append("\n"); 
		query.append("DECODE(CHG_CD,'CRD', -1 * ABS(B.INV_LSE_CHG_AMT),INV_LSE_CHG_AMT) AS INV_LSE_CHG_AMT," ).append("\n"); 
		query.append("B.INV_TAX_AMT," ).append("\n"); 
		query.append("B.INV_CR_AMT," ).append("\n"); 
		query.append("B.AUD_UMCH_EQ_STS_EVNT_YD_CD," ).append("\n"); 
		query.append("TO_CHAR(B.AUD_UMCH_EQ_STS_EVNT_DT,'YYYY-MM-DD') AS AUD_UMCH_EQ_STS_EVNT_DT," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01942' AND INTG_CD_VAL_CTNT = B.LSE_CHG_AUD_RSLT_RSN_CD) AS INTG_CD_VAL_DP_DESC," ).append("\n"); 
		query.append("B.PAY_CHG_AUD_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_LSE_CHG_HDR A, CGM_LSE_CHG_DTL B, CGM_EQUIPMENT C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("AND B.EQ_NO = C.EQ_NO(+)" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND A.CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("AND B.PAY_LSE_CHG_STS_CD = 'I'" ).append("\n"); 

	}
}