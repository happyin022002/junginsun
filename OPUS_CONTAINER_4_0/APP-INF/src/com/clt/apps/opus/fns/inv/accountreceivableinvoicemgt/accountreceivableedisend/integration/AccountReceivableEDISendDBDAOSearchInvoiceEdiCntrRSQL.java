/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrRSQL.java
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

public class AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceEdiCntr
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrRSQL(){
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
		query.append("FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("          '{CNTR_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CNTRNBR:' || BC.CNTR_NO || CHR(10) " ).append("\n"); 
		query.append("       || 'CNTRTYPE:' || BC.CNTR_TPSZ_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'POR_HAUL_CD:' || DECODE(RCV_TERM_CD,'D','C','M') || CHR(10) " ).append("\n"); 
		query.append("       || 'POD_HAUL_CD:' || DECODE(DE_TERM_CD,'D','C','M') || CHR(10) " ).append("\n"); 
		query.append("	   || '{PKG_INFO' || CHR(10) " ).append("\n"); 
		query.append("	   || 'PKG_LVL:' || '1' || CHR(10) " ).append("\n"); 
		query.append("	   || 'PKG_QTY:' || PCK_QTY || CHR(10) " ).append("\n"); 
		query.append("	   || 'PKG_UNIT:' || PCK_TP_CD || CHR(10) " ).append("\n"); 
		query.append("	   || 'PKG_UNIT_DESC:' || (SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD = BC.PCK_TP_CD) || CHR(10) " ).append("\n"); 
		query.append("	   || '}PKG_INFO' || CHR(10) " ).append("\n"); 
		query.append("	   || '{MEA_INFO' || CHR(10) " ).append("\n"); 
		query.append("	   || 'MEA_TP_CD:' ||'GWT'|| CHR(10) " ).append("\n"); 
		query.append("	   || 'MEA_UNIT:' ||WGT_UT_CD ||CHR(10) " ).append("\n"); 
		query.append("	   || 'MEA_QTY:' || CNTR_WGT||CHR(10) " ).append("\n"); 
		query.append("	   || '}MEA_INFO' || CHR(10)" ).append("\n"); 
		query.append("	   || '{MEA_INFO' || CHR(10) " ).append("\n"); 
		query.append("	   || 'MEA_TP_CD:' ||'GVOL'|| CHR(10) " ).append("\n"); 
		query.append("	   || 'MEA_UNIT:' ||MEAS_UT_CD ||CHR(10) " ).append("\n"); 
		query.append("	   || 'MEA_QTY:' || MEAS_QTY||CHR(10) " ).append("\n"); 
		query.append("	   || '}MEA_INFO' || CHR(10) AS BKG_CNTR" ).append("\n"); 
		query.append(",      BC.CNTR_NO" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER BC, INV_EDI_HDR IEH" ).append("\n"); 
		query.append("WHERE BC.BKG_NO(+) = IEH.BKG_NO " ).append("\n"); 
		query.append("AND   BC.CNTR_NO(+) = IEH.CNTR_NO" ).append("\n"); 
		query.append("AND   IEH.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("ORDER BY BC.CNTR_NO" ).append("\n"); 

	}
}