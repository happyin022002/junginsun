/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchCharterInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27 
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

public class TCharterIOInvoiceDAOSearchCharterInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchCharterInvoiceListRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchCharterInvoiceListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchCharterInvoiceListRSQL").append("\n"); 
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
		query.append("       FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("       ,FI.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("       ,FI.INV_SEQ" ).append("\n"); 
		query.append("       ,FI.INV_DTL_SEQ" ).append("\n"); 
		query.append("       ,FA.ACCT_ITM_NM" ).append("\n"); 
		query.append("       ,FI.ACCT_CD" ).append("\n"); 
		query.append("       ,FI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("       ,FI.CURR_CD" ).append("\n"); 
		query.append("       ,FI.INV_AMT" ).append("\n"); 
		query.append("       ,FI.CHTR_INV_DT" ).append("\n"); 
		query.append("       ,FI.INV_DESC" ).append("\n"); 
		query.append("       ,FI.TO_INV_NO" ).append("\n"); 
		query.append("       ,FI.VSL_CD||FI.SKD_VOY_NO||FI.SKD_DIR_CD||FI.REV_DIR_CD BUNKER_VVD" ).append("\n"); 
		query.append("       ,FI.SDMS_NO" ).append("\n"); 
		query.append("       ,DECODE(FI.SLP_TP_CD, NULL, 'N', 'Y') SLP_TP_CD" ).append("\n"); 
		query.append("  FROM FMS_INV_DTL FI, FMS_ACCT_ITM FA" ).append("\n"); 
		query.append(" WHERE FI.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   AND FI.FLET_ISS_TP_CD = 'CHT'" ).append("\n"); 
		query.append("   AND FI.CHTR_PAY_RCV_CD = @[chtr_pay_rcv_cd]" ).append("\n"); 
		query.append("#if(${from_chtr_inv_dt} != '')" ).append("\n"); 
		query.append("   AND FI.CHTR_INV_DT BETWEEN REPLACE(@[from_chtr_inv_dt],'-','') AND REPLACE(@[to_chtr_inv_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${acct_cd} != '')" ).append("\n"); 
		query.append("   AND FI.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("   AND FI.ACCT_ITM_SEQ = @[acct_itm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND FI.ACCT_CD = FA.ACCT_CD" ).append("\n"); 
		query.append("   AND FI.ACCT_ITM_SEQ = FA.ACCT_ITM_SEQ" ).append("\n"); 
		query.append(" ORDER BY FI.INV_DTL_SEQ" ).append("\n"); 

	}
}