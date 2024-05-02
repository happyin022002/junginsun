/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrChgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrChgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceEdiCntrChgInfo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrChgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrChgInfoRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_CHARGE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CHARGE_CD:'   || IEC.CHG_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CHARGE_DESC:'    ||(SELECT CHG_NM FROM MDM_CHARGE WHERE CHG_CD = IEC.CHG_CD) || CHR(10) " ).append("\n"); 
		query.append("       || 'CHARGE_TP_NM:' || (SELECT REP_CHG_NM FROM MDM_CHARGE MC, MDM_REP_CHG MR WHERE MC.CHG_CD = IEC.CHG_CD AND MC.REP_CHG_CD = MR.REP_CHG_CD) || CHR(10) " ).append("\n"); 
		query.append("       || 'CHARGE_CURR:' || IEC.CURR_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'CHARGE_AMT:' || IEC.CHG_AMT || CHR(10) " ).append("\n"); 
		query.append("       || 'CHARGE_AMT_USD:' || ROUND(IEC.CHG_AMT * SAR_GET_GL_XCH_RT_FNC('1', SAIL_DT, IEC.CURR_CD, 'USD'), 2) || CHR(10) " ).append("\n"); 
		query.append("       || 'INV_CURR:' || NVL(A.INV_CURR_CD, IEH.LOCL_CURR_CD) || CHR(10) " ).append("\n"); 
		query.append("       || 'INV_CURR_AMT:' || ROUND(IEC.CHG_AMT * (SELECT NVL(ISS_XCH_RT, INV_XCH_RT) FROM INV_AR_CHG WHERE AR_IF_NO = IEH.AR_IF_NO AND CURR_CD = IEC.CURR_CD AND ROWNUM = 1), NVL(C.DP_PRCS_KNT, B.DP_PRCS_KNT)) || CHR(10) " ).append("\n"); 
		query.append("       || 'INV_TAX:' || '0.00' || CHR(10) " ).append("\n"); 
		query.append("       || 'INV_CURR_TTL_AMT:' ||ROUND(IEC.CHG_AMT * (SELECT NVL(ISS_XCH_RT, INV_XCH_RT) FROM INV_AR_CHG WHERE AR_IF_NO = IEH.AR_IF_NO AND CURR_CD = IEC.CURR_CD AND ROWNUM = 1), NVL(C.DP_PRCS_KNT, B.DP_PRCS_KNT))|| CHR(10) " ).append("\n"); 
		query.append("       || 'LOCAL_CURR:' || IEH.LOCL_CURR_CD||CHR(10) " ).append("\n"); 
		query.append("       || 'LOCAL_CURR_AMT:' ||ROUND(IEC.CHG_AMT * (SELECT INV_XCH_RT FROM INV_AR_CHG WHERE AR_IF_NO = IEH.AR_IF_NO AND CURR_CD = IEC.CURR_CD AND ROWNUM = 1), B.DP_PRCS_KNT)|| CHR(10) " ).append("\n"); 
		query.append("       || 'LOCAL_TAX:' || '0.00'||CHR(10) " ).append("\n"); 
		query.append("       || 'LOCAL_CURR_TTL_AMT:' ||ROUND(IEC.CHG_AMT * (SELECT INV_XCH_RT FROM INV_AR_CHG WHERE AR_IF_NO = IEH.AR_IF_NO AND CURR_CD = IEC.CURR_CD AND ROWNUM = 1), B.DP_PRCS_KNT)|| CHR(10) " ).append("\n"); 
		query.append("       || 'FRT_IND:' || DECODE(IEH.IO_BND_CD, 'O', 'P', 'C') || CHR(10) " ).append("\n"); 
		query.append("       || 'RATED_AS:' || IEC.RAT_AS_CNTR_QTY ||CHR(10) " ).append("\n"); 
		query.append("       || 'RATE:' || IEC.TRF_RT_AMT ||CHR(10) " ).append("\n"); 
		query.append("       || 'INV_EX_RATE:' ||(SELECT INV_XCH_RT FROM INV_AR_CHG WHERE AR_IF_NO = IEH.AR_IF_NO AND CURR_CD = IEC.CURR_CD AND ROWNUM = 1)|| CHR(10) " ).append("\n"); 
		query.append("       || 'TAX_RATE:' ||'0.00'|| CHR(10) " ).append("\n"); 
		query.append("       || 'PERTYPE:' || IEC.PER_TP_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'TARIFF:' || NVL(IEH.SC_NO, IEH.RFA_NO)|| CHR(10) " ).append("\n"); 
		query.append("       || '}CNTR_CHARGE_INFO' || CHR(10) AS BKG_CNTR" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("     MDM_CURRENCY B," ).append("\n"); 
		query.append("     MDM_CURRENCY C," ).append("\n"); 
		query.append("     INV_EDI_HDR IEH," ).append("\n"); 
		query.append("     INV_EDI_CHG IEC" ).append("\n"); 
		query.append("WHERE A.LOCL_CURR_CD = B.CURR_CD(+)" ).append("\n"); 
		query.append("AND A.INV_CURR_CD = C.CURR_CD(+)" ).append("\n"); 
		query.append("AND A.AR_IF_NO = IEH.AR_IF_NO" ).append("\n"); 
		query.append("AND IEH.EDI_HDR_SEQ = IEC.EDI_HDR_SEQ" ).append("\n"); 
		query.append("AND IEH.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND IEH.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND IEC.PER_TP_CD NOT IN ('BL','PC')" ).append("\n"); 

	}
}