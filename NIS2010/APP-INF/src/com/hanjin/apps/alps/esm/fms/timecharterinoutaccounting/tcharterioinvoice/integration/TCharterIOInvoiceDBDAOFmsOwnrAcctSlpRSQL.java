/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOFmsOwnrAcctSlpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.25 
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

public class TCharterIOInvoiceDBDAOFmsOwnrAcctSlpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Owner’s Account Select
	  * 1. 2013.01.24 이수진 [CHM-201322477] OWNERS ACCOUNT 접수확인 항목 개발 요청
	  *     - FLET_RCT_FLG 항목 추가
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOFmsOwnrAcctSlpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOFmsOwnrAcctSlpRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("decode(stl_flg,'Y','1','N','0') stl_flg," ).append("\n"); 
		query.append("'' stl_flg1," ).append("\n"); 
		query.append("flet_ppay_rlt_cd," ).append("\n"); 
		query.append("acct_cd," ).append("\n"); 
		query.append("ctr_cd," ).append("\n"); 
		query.append("eff_dt," ).append("\n"); 
		query.append("n1st_curr_cd," ).append("\n"); 
		query.append("n1st_amt," ).append("\n"); 
		query.append("n1st_amt n1st_amt1," ).append("\n"); 
		query.append("n2nd_curr_cd," ).append("\n"); 
		query.append("n2nd_amt," ).append("\n"); 
		query.append("locl_xch_rt_amt act_xch_rt_amt," ).append("\n"); 
		query.append("csr_slp_flg apro_flg," ).append("\n"); 
		query.append("ap_desc," ).append("\n"); 
		query.append("ap_desc ap_desc1," ).append("\n"); 
		query.append("ap_desc ap_desc2," ).append("\n"); 
		query.append("ap_desc ap_desc3," ).append("\n"); 
		query.append("ap_desc ap_desc4," ).append("\n"); 
		query.append("ap_desc ap_desc5," ).append("\n"); 
		query.append("(vsl_cd || skd_voy_no || skd_dir_cd || rev_dir_cd) vvd_cd," ).append("\n"); 
		query.append("(vsl_cd || skd_voy_no || skd_dir_cd || rev_dir_cd) vvd_cd1," ).append("\n"); 
		query.append("(slp_tp_cd || slp_func_cd || slp_ofc_cd || slp_iss_dt || slp_ser_no || slp_seq_no) org_slp_no," ).append("\n"); 
		query.append("(slp_tp_cd || slp_func_cd || slp_ofc_cd || slp_iss_dt || slp_ser_no || slp_seq_no) org_slp_no1," ).append("\n"); 
		query.append("man_hr_flg," ).append("\n"); 
		query.append("slp_tp_cd," ).append("\n"); 
		query.append("slp_func_cd," ).append("\n"); 
		query.append("slp_ofc_cd slp_team_cd," ).append("\n"); 
		query.append("slp_iss_dt," ).append("\n"); 
		query.append("slp_ser_no," ).append("\n"); 
		query.append("slp_seq_no," ).append("\n"); 
		query.append("vsl_cd," ).append("\n"); 
		query.append("skd_voy_no," ).append("\n"); 
		query.append("skd_dir_cd," ).append("\n"); 
		query.append("rev_dir_cd," ).append("\n"); 
		query.append("nvl(flet_rct_flg, 'N') flet_rct_flg" ).append("\n"); 
		query.append("from fms_ownr_acct_slp" ).append("\n"); 
		query.append("where acct_cd = '111071'" ).append("\n"); 
		query.append("and eff_dt >= @[eff_dt1]" ).append("\n"); 
		query.append("and eff_dt <= @[eff_dt2]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${apro_flg} != \"\")" ).append("\n"); 
		query.append("and csr_slp_flg = @[apro_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${stl_flg} != \"\")" ).append("\n"); 
		query.append("and stl_flg = @[stl_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != \"\")" ).append("\n"); 
		query.append("and vsl_cd = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != \"\")" ).append("\n"); 
		query.append("and slp_ofc_cd like substr(@[loc_cd],3,3) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sheet_no} == \"1\")" ).append("\n"); 
		query.append("and n1st_amt >= 0" ).append("\n"); 
		query.append("#elseif (${sheet_no} == \"2\")" ).append("\n"); 
		query.append("and n1st_amt < 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rct_flg} != \"\")" ).append("\n"); 
		query.append("and nvl(flet_rct_flg,'N') = @[rct_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("order by slp_tp_cd, slp_func_cd, slp_ofc_cd, slp_iss_dt, slp_ser_no, slp_seq_no" ).append("\n"); 

	}
}