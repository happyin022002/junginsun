/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchCustomerDailyExchangeRateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearchCustomerDailyExchangeRateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV_CUST_AND_DLY_XCH_RT 테이블에서 조회조건으로 select 한다.
	  * 
	  * Customer 환율('I'), Daily('D'), China  Daily('C')  
	  * Daily('D'), China  Daily('C') 인 경우는 CUST_CNT_CD='XX' and CUST_SEQ=0으로 한다.
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchCustomerDailyExchangeRateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchCustomerDailyExchangeRateListRSQL").append("\n"); 
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
		query.append("SELECT A.AR_OFC_CD," ).append("\n"); 
		query.append("  A.CUST_CNT_CD||'-'||LPAD(A.CUST_SEQ, 6, '0') CUST_SEQ," ).append("\n"); 
		query.append("  DECODE(A.IO_BND_CD, 'O' , 'O/B', 'I', 'I/B') IO_BND_CD," ).append("\n"); 
		query.append("  A.FM_DT," ).append("\n"); 
		query.append("  A.TO_DT," ).append("\n"); 
		query.append("  A.CHG_CURR_CD," ).append("\n"); 
		query.append("  A.LOCL_CURR_CD," ).append("\n"); 
		query.append("  DECODE(B.XCH_RT_RVS_FLG, 'Y', A.IVS_XCH_RT, A.INV_XCH_RT) INV_XCH_RT," ).append("\n"); 
		query.append("  DECODE(B.XCH_RT_RVS_FLG, 'Y', A.INV_XCH_RT, A.IVS_XCH_RT) IVS_XCH_RT" ).append("\n"); 
		query.append("FROM INV_CUST_AND_DLY_XCH_RT A," ).append("\n"); 
		query.append("  INV_AR_STUP_OFC B" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("  AND A.XCH_RT_TP_CD = @[xch_rt_tp_cd]" ).append("\n"); 
		query.append("  AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("  AND FM_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#if (${chg_curr_cd} != '')" ).append("\n"); 
		query.append("  AND CHG_CURR_CD = @[chg_curr_cd] -- CHARGE CUR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${locl_curr_cd} != '')" ).append("\n"); 
		query.append("  AND LOCL_CURR_CD = @[locl_curr_cd] -- LOCAL CUR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${io_bnd_cd} != 'ALL') &&(${io_bnd_cd} != ''))" ).append("\n"); 
		query.append("  AND IO_BND_CD = @[io_bnd_cd] -- BOUND" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${ar_ofc_cd} != 'ALL') &&(${ar_ofc_cd} != ''))" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = @[ar_ofc_cd] -- AR OFFICE" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}