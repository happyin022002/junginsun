/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchInvoiceBlMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.23 
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

public class AccountReceivableEDISendDBDAOSearchInvoiceBlMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceBlMain
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchInvoiceBlMainRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchInvoiceBlMainRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT  " ).append("\n"); 
		query.append("       'INV_TP:'|| DECODE(INV.REV_TP_CD, 'M', '02', DECODE(INV.INV_DELT_DIV_CD, 'N', '01', '03')) || CHR(10) || " ).append("\n"); 
		query.append("       'INV_STATUS:'|| DECODE(INV.INV_DELT_DIV_CD,'X','Cancelled','Confirmed') || CHR(10) || " ).append("\n"); 
		query.append("       'BL_NO:' || INV.BL_SRC_NO ||CHR(10) || " ).append("\n"); 
		query.append("       'POR_TRAFFIC_MD:' || DECODE(BK.RCV_TERM_CD,'S','LCL','FCL') ||CHR(10) || " ).append("\n"); 
		query.append("       'POD_TRAFFIC_MD:' || DECODE(BK.DE_TERM_CD,'S','LCL','FCL')  ||CHR(10) || " ).append("\n"); 
		query.append("       'PAY_DUE_DT:' || INV.DUE_DT || CHR(10) || " ).append("\n"); 
		query.append("       'SAILING_ARR_DT:' || INV.SAIL_ARR_DT||CHR(10) ||" ).append("\n"); 
		query.append("       'INV_CURR:' || NVL(INV.INV_CURR_CD, INV.LOCL_CURR_CD) ||CHR(10) || " ).append("\n"); 
		query.append("       'INV_CURR_TTL:' || (SELECT SUM(ROUND(CHG_AMT * NVL(ISS_XCH_RT, INV_XCH_RT), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = NVL(INV.INV_CURR_CD, INV.LOCL_CURR_CD))))" ).append("\n"); 
		query.append("                           FROM INV_AR_CHG" ).append("\n"); 
		query.append("                           WHERE AR_IF_NO = INV.AR_IF_NO) ||CHR(10) || " ).append("\n"); 
		query.append("       'LOCAL_CURR:'  || INV.LOCL_CURR_CD ||CHR(10) || " ).append("\n"); 
		query.append("       'LOCAL_CURR_TTL:' || INV.INV_TTL_LOCL_AMT ||CHR(10) || " ).append("\n"); 
		query.append("       'INV_EX_RATE:' || INV.USD_XCH_RT || CHR(10) || " ).append("\n"); 
		query.append("       'INV_PAYTERM_CLUS:' || INV.CR_TERM_DYS ||CHR(10) || " ).append("\n"); 
		query.append("       'REMARK:' || INV.INV_RMK ||CHR(10) || " ).append("\n"); 
		query.append("       'APP_DT:' || (SELECT TO_CHAR(RT_APLY_DT ,'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') " ).append("\n"); 
		query.append("				    FROM BKG_RATE" ).append("\n"); 
		query.append("					WHERE BKG_NO = BK.BKG_NO ) ||CHR(10)" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, INV_AR_MN INV" ).append("\n"); 
		query.append("WHERE BK.BKG_NO(+) = INV.BKG_NO" ).append("\n"); 
		query.append("AND INV.AR_IF_NO = @[ar_if_no]" ).append("\n"); 

	}
}