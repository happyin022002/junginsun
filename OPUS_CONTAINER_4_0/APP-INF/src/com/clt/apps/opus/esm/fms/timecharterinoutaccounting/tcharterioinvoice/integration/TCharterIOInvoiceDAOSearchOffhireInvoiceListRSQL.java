/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT FA.ACCT_ITM_NM, " ).append("\n"); 
		query.append("       FD.ACCT_CD, " ).append("\n"); 
		query.append("       FD.ACCT_ITM_SEQ, " ).append("\n"); 
		query.append("       DECODE(FD.FLET_CURR_CHK_CD,'F',FD.CURR_CD,NULL) CURR_CD, " ).append("\n"); 
		query.append("       TRIM(DECODE(FD.FLET_CURR_CHK_CD,'F',TO_CHAR(FD.INV_AMT,'999,999,999,999,999,990.00'),NULL)) INV_AMT," ).append("\n"); 
		query.append("       TRIM(DECODE(FD.FLET_CURR_CHK_CD,'F',TO_CHAR(FD.INV_AMT,'999,999,999,999,999,990.00'),NULL)) ORI_INV_AMT," ).append("\n"); 
		query.append("       TRIM(DECODE(FD.FLET_CURR_CHK_CD,'F',TO_CHAR(FD.INV_AMT,'999,999,999,999,999,990.00'),NULL)) FIR_INV_AMT," ).append("\n"); 
		query.append("       DECODE(FD.FLET_CURR_CHK_CD,'S',FD.CURR_CD,NULL) CURR_CD2, " ).append("\n"); 
		query.append("       TRIM(DECODE(FD.FLET_CURR_CHK_CD,'S',TO_CHAR(FD.INV_AMT,'999,999,999,999,999,990.00'),NULL)) INV_AMT2," ).append("\n"); 
		query.append("       TRIM(DECODE(FD.FLET_CURR_CHK_CD,'S',TO_CHAR(FD.INV_AMT,'999,999,999,999,999,990.00'),NULL)) ORI_INV_AMT2," ).append("\n"); 
		query.append("       TRIM(DECODE(FD.FLET_CURR_CHK_CD,'S',TO_CHAR(FD.INV_AMT,'999,999,999,999,999,990.00'),NULL)) FIR_INV_AMT2," ).append("\n"); 
		query.append("       FD.INV_DESC," ).append("\n"); 
		query.append("       FD.FLET_CTRT_NO," ).append("\n"); 
		query.append("       FD.FLET_ISS_TP_CD," ).append("\n"); 
		query.append("       FD.INV_SEQ," ).append("\n"); 
		query.append("       FD.INV_DTL_SEQ," ).append("\n"); 
		query.append("       DECODE(FD.SLP_TP_CD, NULL, 'N', 'Y') SLP_TP_CD" ).append("\n"); 
		query.append("  FROM FMS_INVOICE FI, FMS_INV_DTL FD, FMS_ACCT_ITM FA" ).append("\n"); 
		query.append(" WHERE FI.FLET_CTRT_NO = FD.FLET_CTRT_NO" ).append("\n"); 
		query.append("   AND FI.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   AND FI.INV_SEQ = DECODE(@[inv_seq],NULL,(SELECT MAX(INV_SEQ) FROM FMS_INVOICE WHERE FLET_CTRT_NO = @[flet_ctrt_no] AND FLET_ISS_TP_CD = 'OFF'),@[inv_seq])" ).append("\n"); 
		query.append("   AND FI.FLET_ISS_TP_CD = 'OFF'" ).append("\n"); 
		query.append("   AND FI.INV_SEQ = FD.INV_SEQ" ).append("\n"); 
		query.append("   AND FI.FLET_ISS_TP_CD = FD.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("   AND FD.ACCT_CD = FA.ACCT_CD" ).append("\n"); 
		query.append("   AND FD.ACCT_ITM_SEQ = FA.ACCT_ITM_SEQ" ).append("\n"); 
		query.append(" ORDER BY FD.INV_DTL_SEQ, FD.ACCT_CD" ).append("\n"); 

	}
}