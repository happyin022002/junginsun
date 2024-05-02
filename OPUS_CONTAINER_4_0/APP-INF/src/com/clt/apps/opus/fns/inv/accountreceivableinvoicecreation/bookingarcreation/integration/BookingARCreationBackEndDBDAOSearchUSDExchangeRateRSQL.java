/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationBackEndDBDAOSearchUSDExchangeRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationBackEndDBDAOSearchUSDExchangeRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search USD Exchange Rate
	  * </pre>
	  */
	public BookingARCreationBackEndDBDAOSearchUSDExchangeRateRSQL(){
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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationBackEndDBDAOSearchUSDExchangeRateRSQL").append("\n"); 
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
		query.append("#if (${chg_curr_cd} == 'USD')" ).append("\n"); 
		query.append("    SELECT NVL(ROUND(DECODE(@[inv_xch_rt], 0, 0, 1/@[inv_xch_rt]), 6), 0) USD_XCH_RT" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${xch_rt_tp_cd} == 'V')" ).append("\n"); 
		query.append("        SELECT NVL(ROUND(DECODE(INV_XCH_RT, 0, 0, @[inv_xch_rt]/INV_XCH_RT), 6), 0) USD_XCH_RT" ).append("\n"); 
		query.append("        FROM INV_VVD_XCH_RT" ).append("\n"); 
		query.append("        WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("        AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("        AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("        AND AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("        AND LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("        AND CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("    #elseif (${xch_rt_tp_cd} == 'I')" ).append("\n"); 
		query.append("        SELECT NVL(ROUND(DECODE(INV_XCH_RT, 0, 0, @[inv_xch_rt]/INV_XCH_RT), 6), 0) USD_XCH_RT" ).append("\n"); 
		query.append("        FROM INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append("        WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("        AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("        AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("        AND FM_DT = REPLACE(@[fm_dt],'-','')" ).append("\n"); 
		query.append("        AND TO_DT = REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("        AND LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("        AND CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("    #elseif (${xch_rt_tp_cd} == 'D')" ).append("\n"); 
		query.append("        SELECT NVL(ROUND(DECODE(INV_XCH_RT, 0, 0, @[inv_xch_rt]/INV_XCH_RT), 6), 0) USD_XCH_RT" ).append("\n"); 
		query.append("        FROM INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append("        WHERE CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("        AND CUST_SEQ = 0" ).append("\n"); 
		query.append("        AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("        AND FM_DT = REPLACE(@[fm_dt],'-','')" ).append("\n"); 
		query.append("        AND TO_DT = REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("        AND LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("        AND CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("		AND AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}