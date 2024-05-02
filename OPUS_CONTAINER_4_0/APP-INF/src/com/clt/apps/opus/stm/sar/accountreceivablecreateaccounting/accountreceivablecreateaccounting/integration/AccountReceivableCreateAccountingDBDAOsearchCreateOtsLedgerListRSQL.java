/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCreateAccountingDBDAOsearchCreateOtsLedgerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCreateAccountingDBDAOsearchCreateOtsLedgerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create Ots Ledger List
	  * </pre>
	  */
	public AccountReceivableCreateAccountingDBDAOsearchCreateOtsLedgerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_dmst_dr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.integration").append("\n"); 
		query.append("FileName : AccountReceivableCreateAccountingDBDAOsearchCreateOtsLedgerListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("SLH.EFF_YRMON        EFF_YRMON " ).append("\n"); 
		query.append(",SLH.RHQ_CD           RHQ_CD " ).append("\n"); 
		query.append(",SLD.OTS_OFC_CD       OTS_OFC_CD " ).append("\n"); 
		query.append(",SLD.DMST_DR_ACCT_CD  DMST_DR_ACCT_CD " ).append("\n"); 
		query.append(",SLH.OTS_TP_CD        OTS_TP_CD " ).append("\n"); 
		query.append(",SLD.BL_CURR_CD       BL_CURR_CD" ).append("\n"); 
		query.append(",SAR_GET_CUR_AMT_FNC(SLD.BL_CURR_CD,NVL(SUM(SLD.PRE_BAL_AMT ),0)) AS PRV_BAL  " ).append("\n"); 
		query.append(",SAR_GET_CUR_AMT_FNC(SLD.BL_CURR_CD,NVL(SUM(SLD.THS_MON_AMT),0)) AS THS_AMT " ).append("\n"); 
		query.append(",SAR_GET_CUR_AMT_FNC(SLD.BL_CURR_CD,NVL(SUM(SLD.THS_MON_BAL_AMT),0)) AS THS_BAL " ).append("\n"); 
		query.append(",SAR_GET_CUR_AMT_FNC(SLD.BL_CURR_CD,NVL(SUM(SLD.THS_MON_BAL_AMT),0)) AS ths_bal_ck   " ).append("\n"); 
		query.append(",SAR_GET_CUR_AMT_FNC('JPY',NVL(SUM(SLD.THS_MON_BAL_FUNC_AMT),0)) AS COP_KRW " ).append("\n"); 
		query.append(",SAR_GET_CUR_AMT_FNC('USD',NVL(SUM(SLD.THS_MON_BAL_USD_AMT),0)) AS COP_USD   " ).append("\n"); 
		query.append(",'' END_KRW " ).append("\n"); 
		query.append(",'' END_USD" ).append("\n"); 
		query.append("--       NVL(SUM(SLH.ths_bal_clskrw ), 0) AS END_KRW , " ).append("\n"); 
		query.append("--       NVL(SUM(SLH.ths_bal_clsusd ), 0) AS END_USD" ).append("\n"); 
		query.append(",'' GL_MONTH" ).append("\n"); 
		query.append(",'' THS_BAL_CK" ).append("\n"); 
		query.append(",'' AR_OFC_CD" ).append("\n"); 
		query.append(",'' AR_RHQ_CD" ).append("\n"); 
		query.append(",'' AR_DMST_DR_ACCT_CD" ).append("\n"); 
		query.append(",'' GL_SLDTH" ).append("\n"); 
		query.append(",'' SOURCE" ).append("\n"); 
		query.append(",'' CURR" ).append("\n"); 
		query.append(",'' AR_ACCT_CD " ).append("\n"); 
		query.append(",'' FUNC_CURR " ).append("\n"); 
		query.append("FROM SAR_OTS_LEGR_HDR SLH" ).append("\n"); 
		query.append(" ,   SAR_OTS_LEGR_DTL SLD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND SLH.EFF_YRMON     = SLD.EFF_YRMON" ).append("\n"); 
		query.append("  AND SLH.RHQ_CD        = SLD.RHQ_CD" ).append("\n"); 
		query.append("  AND SLH.OTS_OFC_CD    = SLD.OTS_OFC_CD" ).append("\n"); 
		query.append("  AND SLH.BL_NO         = SLD.BL_NO" ).append("\n"); 
		query.append("  AND SLH.INV_NO        = SLD.INV_NO" ).append("\n"); 
		query.append("  AND    (NVL(SLD.PRE_BAL_AMT, 0)<>0  " ).append("\n"); 
		query.append("        OR     NVL(SLD.THS_MON_AMT , 0)<>0 " ).append("\n"); 
		query.append("        OR     NVL(SLD.THS_MON_BAL_AMT , 0) <>0)" ).append("\n"); 
		query.append("#if (${gl_month} != '' )" ).append("\n"); 
		query.append("	AND SLH.EFF_YRMON = REPLACE( @[gl_month] ,'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ar_rhq_cd} != '' )" ).append("\n"); 
		query.append("	AND SLH.RHQ_CD =  @[ar_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '' )" ).append("\n"); 
		query.append("	AND SLH.OTS_OFC_CD =  @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ar_dmst_dr_acct_cd} != '' )" ).append("\n"); 
		query.append("	AND SLH.AR_DMST_DR_ACCT_CD =  @[ar_dmst_dr_acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${curr} != '' )" ).append("\n"); 
		query.append("	AND SLD.BL_CURR_CD =  @[curr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ar_acct_cd} != '' )" ).append("\n"); 
		query.append("	AND SLD.DMST_DR_ACCT_CD =  @[ar_acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${source} == 'INVAR' )" ).append("\n"); 
		query.append("    AND SLH.OTS_TP_CD = 'INVAR'" ).append("\n"); 
		query.append("#elseif  (${source} == 'BMS' )" ).append("\n"); 
		query.append("    AND SLH.OTS_TP_CD = 'BMS' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif ( ${source} == 'OTHER' )	 	" ).append("\n"); 
		query.append("    AND SLH.OTS_TP_CD = 'OTHER' 	" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("#elseif ( ${source} == 'JOO' ) " ).append("\n"); 
		query.append("    AND SLH.OTS_TP_CD = 'JOO' 		" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("#elseif ( ${source} == 'FMS' )" ).append("\n"); 
		query.append("    AND SLH.OTS_TP_CD = 'FMS' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif ( ${source} == 'STM A%' )" ).append("\n"); 
		query.append("    AND SLH.OTS_TP_CD LIKE 'STM A%'" ).append("\n"); 
		query.append("#elseif  (${source} == 'TPB' )" ).append("\n"); 
		query.append("    AND SLH.OTS_TP_CD = 'TPB' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY SLH.EFF_YRMON , SLH.RHQ_CD , SLD.OTS_OFC_CD, SLD.DMST_DR_ACCT_CD , SLH.OTS_TP_CD , SLD.BL_CURR_CD" ).append("\n"); 

	}
}