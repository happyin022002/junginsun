/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOFmsOwnrAcctSlpUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.21 
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

public class TCharterIOInvoiceDBDAOFmsOwnrAcctSlpUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Owner’s Account Update
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOFmsOwnrAcctSlpUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ppay_rlt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_team_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOFmsOwnrAcctSlpUSQL").append("\n"); 
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
		query.append("update fms_ownr_acct_slp set " ).append("\n"); 
		query.append("	ap_desc = @[ap_desc]," ).append("\n"); 
		query.append("	stl_flg = @[stl_flg]," ).append("\n"); 
		query.append("	flet_ppay_rlt_cd = @[flet_ppay_rlt_cd]," ).append("\n"); 
		query.append("	vsl_cd = substr(@[vvd_cd],1,4)," ).append("\n"); 
		query.append("	skd_voy_no = substr(@[vvd_cd],5,4)," ).append("\n"); 
		query.append("	skd_dir_cd = substr(@[vvd_cd],9,1)," ).append("\n"); 
		query.append("	rev_dir_cd = substr(@[vvd_cd],10,1)," ).append("\n"); 
		query.append("	upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("    upd_dt = sysdate" ).append("\n"); 
		query.append("where	slp_tp_cd = @[slp_tp_cd]" ).append("\n"); 
		query.append("and	slp_func_cd = @[slp_func_cd]" ).append("\n"); 
		query.append("and	slp_ofc_cd = @[slp_team_cd]" ).append("\n"); 
		query.append("and	slp_iss_dt = @[slp_iss_dt]" ).append("\n"); 
		query.append("and	slp_ser_no = @[slp_ser_no]" ).append("\n"); 
		query.append("and	slp_seq_no = @[slp_seq_no]" ).append("\n"); 

	}
}