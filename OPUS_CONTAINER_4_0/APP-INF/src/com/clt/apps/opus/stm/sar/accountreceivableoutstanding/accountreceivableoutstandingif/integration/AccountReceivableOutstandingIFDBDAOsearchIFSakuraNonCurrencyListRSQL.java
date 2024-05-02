/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingIFDBDAOsearchIFSakuraNonCurrencyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingIFDBDAOsearchIFSakuraNonCurrencyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIFSakuraNonCurrencyList
	  * </pre>
	  */
	public AccountReceivableOutstandingIFDBDAOsearchIFSakuraNonCurrencyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingIFDBDAOsearchIFSakuraNonCurrencyListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SODT.OTS_DTRB_SEQ AS OTS_DTRB_SEQ" ).append("\n"); 
		query.append("    FROM SAR_OTS_HDR SOH" ).append("\n"); 
		query.append("     , SAR_OTS_DTL SOD" ).append("\n"); 
		query.append("     , SAR_OTS_CHG SOC" ).append("\n"); 
		query.append("     , SAR_OTS_HIS SOHI" ).append("\n"); 
		query.append("     , SAR_OTS_DTRB SODT" ).append("\n"); 
		query.append("WHERE SOH.RHQ_CD = SOD.RHQ_CD" ).append("\n"); 
		query.append("   AND SOH.OTS_OFC_CD = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("   AND SOH.BL_NO = SOD.BL_NO" ).append("\n"); 
		query.append("   AND SOH.INV_NO = SOD.INV_NO" ).append("\n"); 
		query.append("   AND SOD.RHQ_CD = SOC.RHQ_CD" ).append("\n"); 
		query.append("   AND SOD.OTS_OFC_CD = SOC.OTS_OFC_CD" ).append("\n"); 
		query.append("   AND SOD.BL_NO = SOC.BL_NO" ).append("\n"); 
		query.append("   AND SOD.INV_NO = SOC.INV_NO" ).append("\n"); 
		query.append("   AND SOD.CHG_TP_CD = SOC.CHG_TP_CD" ).append("\n"); 
		query.append("   AND SOD.BL_CURR_CD = SOC.BL_CURR_CD" ).append("\n"); 
		query.append("   AND SOC.RHQ_CD = SOHI.RHQ_CD" ).append("\n"); 
		query.append("   AND SOC.OTS_OFC_CD = SOHI.OTS_OFC_CD" ).append("\n"); 
		query.append("   AND SOC.BL_NO = SOHI.BL_NO" ).append("\n"); 
		query.append("   AND SOC.INV_NO = SOHI.INV_NO" ).append("\n"); 
		query.append("   AND SOHI.OTS_HIS_SEQ = SODT.OTS_HIS_SEQ" ).append("\n"); 
		query.append("   AND SOC.OTS_HIS_SEQ = SODT.OTS_HIS_SEQ" ).append("\n"); 
		query.append("   AND SOC.CHG_TP_CD = SODT.CHG_TP_CD" ).append("\n"); 
		query.append("   AND SOHI.IF_NO = @[check_if_no]" ).append("\n"); 
		query.append("   AND EXISTS (" ).append("\n"); 
		query.append("        SELECT 'Y'" ).append("\n"); 
		query.append("            FROM SAR_OTS_HDR SOH" ).append("\n"); 
		query.append("             , SAR_OTS_DTL SOD" ).append("\n"); 
		query.append("             , SAR_OTS_CHG SOC" ).append("\n"); 
		query.append("             , SAR_OTS_HIS SOHI" ).append("\n"); 
		query.append("             , SAR_OTS_DTRB SODT" ).append("\n"); 
		query.append("        WHERE SOH.RHQ_CD = SOD.RHQ_CD" ).append("\n"); 
		query.append("           AND SOH.OTS_OFC_CD = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("           AND SOH.BL_NO = SOD.BL_NO" ).append("\n"); 
		query.append("           AND SOH.INV_NO = SOD.INV_NO" ).append("\n"); 
		query.append("           AND SOD.RHQ_CD = SOC.RHQ_CD" ).append("\n"); 
		query.append("           AND SOD.OTS_OFC_CD = SOC.OTS_OFC_CD" ).append("\n"); 
		query.append("           AND SOD.BL_NO = SOC.BL_NO" ).append("\n"); 
		query.append("           AND SOD.INV_NO = SOC.INV_NO" ).append("\n"); 
		query.append("           AND SOD.CHG_TP_CD = SOC.CHG_TP_CD" ).append("\n"); 
		query.append("           AND SOD.BL_CURR_CD = SOC.BL_CURR_CD" ).append("\n"); 
		query.append("           AND SOC.RHQ_CD = SOHI.RHQ_CD" ).append("\n"); 
		query.append("           AND SOC.OTS_OFC_CD = SOHI.OTS_OFC_CD" ).append("\n"); 
		query.append("           AND SOC.BL_NO = SOHI.BL_NO" ).append("\n"); 
		query.append("           AND SOC.INV_NO = SOHI.INV_NO" ).append("\n"); 
		query.append("           AND SOHI.OTS_HIS_SEQ = SODT.OTS_HIS_SEQ" ).append("\n"); 
		query.append("           AND SOC.OTS_HIS_SEQ = SODT.OTS_HIS_SEQ" ).append("\n"); 
		query.append("           AND SOC.CHG_TP_CD = SODT.CHG_TP_CD" ).append("\n"); 
		query.append("           AND SOHI.IF_NO = @[check_if_no]" ).append("\n"); 
		query.append("           AND (SOHI.LOCL_XCH_RT IS NULL OR SOHI.LOCL_XCH_RT = 0)" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}