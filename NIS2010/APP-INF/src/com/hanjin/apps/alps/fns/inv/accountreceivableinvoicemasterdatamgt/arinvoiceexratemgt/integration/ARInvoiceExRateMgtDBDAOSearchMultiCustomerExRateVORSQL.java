/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchMultiCustomerExRateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearchMultiCustomerExRateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multi환율 중복조회
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchMultiCustomerExRateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchMultiCustomerExRateVORSQL").append("\n"); 
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
		query.append("	CUST_CNT_CD" ).append("\n"); 
		query.append(",	LPAD(CUST_SEQ, 6, '0') CUST_SEQ" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",   substr(FM_DT,0,4) || '-' ||substr(FM_DT,5,2) || '-' ||substr(FM_DT,7,2) FM_DT" ).append("\n"); 
		query.append(",	substr(TO_DT,0,4) || '-' ||substr(TO_DT,5,2) || '-' ||substr(TO_DT,7,2) TO_DT" ).append("\n"); 
		query.append(",	CHG_CURR_CD" ).append("\n"); 
		query.append(",	LOCL_CURR_CD" ).append("\n"); 
		query.append(",	XCH_RT_TP_CD" ).append("\n"); 
		query.append(",	AR_OFC_CD" ).append("\n"); 
		query.append(",	INV_XCH_RT" ).append("\n"); 
		query.append(",	IVS_XCH_RT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append("WHERE	cust_cnt_cd = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND	cust_seq = @[cust_seq]" ).append("\n"); 
		query.append("AND	io_bnd_cd = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND fm_dt <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("AND to_dt >= REPLACE(@[fm_dt],'-','')" ).append("\n"); 
		query.append("AND	chg_curr_cd = @[chg_curr_cd]" ).append("\n"); 
		query.append("AND	locl_curr_cd = @[locl_curr_cd]" ).append("\n"); 
		query.append("AND	xch_rt_tp_cd = @[xch_rt_tp_cd]" ).append("\n"); 

	}
}