/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchExRateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.04 
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

public class ARInvoiceExRateMgtDBDAOSearchExRateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchExRateVORSQL(){
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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchExRateVORSQL").append("\n"); 
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
		query.append("select distinct" ).append("\n"); 
		query.append("a.cust_cnt_cd cust_cnt_cd," ).append("\n"); 
		query.append("LPAD(a.cust_seq, 6, '0') cust_seq," ).append("\n"); 
		query.append("decode(substr(c.loc_cd,1,2),'VN','ALL',decode(a.io_bnd_cd,'I','I/B','O','O/B')) io_bnd_cd," ).append("\n"); 
		query.append("a.fm_dt fm_dt," ).append("\n"); 
		query.append("a.to_dt to_dt," ).append("\n"); 
		query.append("b.curr_nm curr_nm," ).append("\n"); 
		query.append("a.chg_curr_cd chg_curr_cd," ).append("\n"); 
		query.append("a.locl_curr_cd locl_curr_cd," ).append("\n"); 
		query.append("a.xch_rt_tp_cd xch_rt_tp_cd," ).append("\n"); 
		query.append("a.ar_ofc_cd ar_ofc_cd," ).append("\n"); 
		query.append("decode(d.xch_rt_rvs_flg,'Y',a.ivs_xch_rt,a.inv_xch_rt) inv_xch_rt," ).append("\n"); 
		query.append("decode(d.xch_rt_rvs_flg,'Y',a.inv_xch_rt,a.ivs_xch_rt) ivs_xch_rt," ).append("\n"); 
		query.append("a.cre_usr_id cre_usr_id," ).append("\n"); 
		query.append("a.cre_dt	cre_dt," ).append("\n"); 
		query.append("a.upd_usr_id upd_usr_id," ).append("\n"); 
		query.append("a.upd_dt upd_dt" ).append("\n"); 
		query.append("from inv_cust_and_dly_xch_rt a, mdm_currency b, mdm_organization c , inv_ar_stup_ofc d" ).append("\n"); 
		query.append("where a.chg_curr_cd = b.curr_cd" ).append("\n"); 
		query.append("and a.ar_ofc_cd = c.ofc_cd" ).append("\n"); 
		query.append("and a.ar_ofc_cd = d.ar_ofc_cd" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("and	a.io_bnd_cd = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND a.fm_dt <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("AND a.to_dt >= REPLACE(@[fm_dt],'-','')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and	a.locl_curr_cd = @[locl_curr_cd]" ).append("\n"); 
		query.append("and a.cust_cnt_cd ='XX'" ).append("\n"); 
		query.append("and a.cust_seq = 0" ).append("\n"); 
		query.append("and a.ar_ofc_cd = d.ar_ofc_cd" ).append("\n"); 
		query.append("and NVL(a.xch_rt_tp_cd,'V') = NVL(@[xch_rt_tp_cd],'V')" ).append("\n"); 
		query.append("order by a.fm_dt,a.to_dt,io_bnd_cd,a.chg_curr_cd" ).append("\n"); 

	}
}