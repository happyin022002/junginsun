/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchOffhireInvoiceListSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.10.07 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchOffhireInvoiceListSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchOffhireInvoiceListSumRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchOffhireInvoiceListSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchOffhireInvoiceListSumRSQL").append("\n"); 
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
		query.append("SELECT CURR_CD," ).append("\n"); 
		query.append("INV_AMT," ).append("\n"); 
		query.append("CURR_CD2," ).append("\n"); 
		query.append("INV_AMT2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  CURR_CD," ).append("\n"); 
		query.append("CASE WHEN CURR_CD = 'KRW' OR CURR_CD = 'JPY' OR CURR_CD = 'PAB' THEN" ).append("\n"); 
		query.append("TO_CHAR(SUM(INV_AMT),'999,999,999,999,999,999')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("TO_CHAR(SUM(INV_AMT),'999,999,999,999,999,999.00')" ).append("\n"); 
		query.append("END INV_AMT," ).append("\n"); 
		query.append("CURR_CD2," ).append("\n"); 
		query.append("CASE WHEN CURR_CD2 = 'KRW' OR CURR_CD2 = 'JPY' OR CURR_CD2 = 'PAB' THEN" ).append("\n"); 
		query.append("TO_CHAR(SUM(INV_AMT2),'999,999,999,999,999,999')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("TO_CHAR(SUM(INV_AMT2),'999,999,999,999,999,999.00')" ).append("\n"); 
		query.append("END INV_AMT2," ).append("\n"); 
		query.append("MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(FD.FLET_CURR_CHK_CD,'F',FD.CURR_CD,NULL) CURR_CD," ).append("\n"); 
		query.append("DECODE(FD.FLET_CURR_CHK_CD,'F',FD.INV_AMT,NULL) INV_AMT," ).append("\n"); 
		query.append("DECODE(FD.FLET_CURR_CHK_CD,'S',FD.CURR_CD,NULL) CURR_CD2," ).append("\n"); 
		query.append("DECODE(FD.FLET_CURR_CHK_CD,'S',FD.INV_AMT,NULL) INV_AMT2," ).append("\n"); 
		query.append("FD.ACCT_CD" ).append("\n"); 
		query.append("FROM FMS_INVOICE FI, FMS_INV_DTL FD, FMS_ACCT_ITM FA" ).append("\n"); 
		query.append("WHERE FI.FLET_CTRT_NO = FD.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND FI.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FI.INV_SEQ = DECODE(@[inv_seq],NULL,(SELECT MAX(INV_SEQ) FROM FMS_INVOICE WHERE FLET_CTRT_NO = @[flet_ctrt_no] AND FLET_ISS_TP_CD = 'OFF'),@[inv_seq])" ).append("\n"); 
		query.append("AND FI.FLET_ISS_TP_CD = 'OFF'" ).append("\n"); 
		query.append("AND FI.INV_SEQ = FD.INV_SEQ" ).append("\n"); 
		query.append("AND FI.FLET_ISS_TP_CD = FD.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("AND FD.ACCT_CD = FA.ACCT_CD" ).append("\n"); 
		query.append("AND FD.ACCT_ITM_SEQ = FA.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND FD.ACCT_CD != '512641'" ).append("\n"); 
		query.append(") GROUP BY CURR_CD, CURR_CD2" ).append("\n"); 
		query.append(") ORDER BY ACCT_CD" ).append("\n"); 

	}
}