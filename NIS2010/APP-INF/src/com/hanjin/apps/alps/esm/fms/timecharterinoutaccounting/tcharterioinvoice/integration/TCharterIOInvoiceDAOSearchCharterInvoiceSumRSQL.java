/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchCharterInvoiceSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchCharterInvoiceSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchCharterInvoiceSumRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchCharterInvoiceSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_chtr_inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_chtr_inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chtr_pay_rcv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchCharterInvoiceSumRSQL").append("\n"); 
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
		query.append("SELECT CURR_CD" ).append("\n"); 
		query.append(",INV_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT CURR_CD," ).append("\n"); 
		query.append("CASE WHEN CURR_CD = 'KRW' OR CURR_CD = 'JPY' OR CURR_CD = 'PAB' THEN" ).append("\n"); 
		query.append("TO_CHAR(SUM(INV_AMT),'999,999,999,999,999,990')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("TO_CHAR(SUM(INV_AMT),'999,999,999,999,999,990.00')" ).append("\n"); 
		query.append("END INV_AMT," ).append("\n"); 
		query.append("MIN(INV_DTL_SEQ) INV_DTL_SEQ" ).append("\n"); 
		query.append("FROM FMS_INV_DTL" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FLET_ISS_TP_CD = 'CHT'" ).append("\n"); 
		query.append("AND CHTR_PAY_RCV_CD = @[chtr_pay_rcv_cd]" ).append("\n"); 
		query.append("#if(${from_chtr_inv_dt} != '')" ).append("\n"); 
		query.append("AND CHTR_INV_DT BETWEEN REPLACE(@[from_chtr_inv_dt],'-','') AND REPLACE(@[to_chtr_inv_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${acct_cd} != '')" ).append("\n"); 
		query.append("AND ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("AND ACCT_ITM_SEQ = @[acct_itm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY CURR_CD" ).append("\n"); 
		query.append(") ORDER BY INV_DTL_SEQ" ).append("\n"); 

	}
}