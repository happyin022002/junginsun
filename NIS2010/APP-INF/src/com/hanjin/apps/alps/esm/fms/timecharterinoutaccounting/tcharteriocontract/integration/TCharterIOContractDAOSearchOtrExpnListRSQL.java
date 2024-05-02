/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.04.23 정인선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration ;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGINSUN
 * @see 
 * @since J2EE 1.4
 */

public class TCharterIOContractDAOSearchOtrExpnListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOSearchOtrExpnListRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOSearchOtrExpnListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("fo.flet_ctrt_no," ).append("\n"); 
		query.append("(select" ).append("\n"); 
		query.append("mi.acct_itm_nm" ).append("\n"); 
		query.append("from fms_acct_cate mc, fms_acct_itm mi" ).append("\n"); 
		query.append("where mc.flet_acct_cate_cd = 'OT'" ).append("\n"); 
		query.append("and mc.acct_cd = mi.acct_cd" ).append("\n"); 
		query.append("and mc.acct_itm_seq = mi.acct_itm_seq" ).append("\n"); 
		query.append("and mc.acct_cd = fo.acct_cd" ).append("\n"); 
		query.append("and rownum =1) acct_itm_nm," ).append("\n"); 
		query.append("fo.acct_cd," ).append("\n"); 
		query.append("fo.acct_itm_seq," ).append("\n"); 
		query.append("fo.acct_cd ori_acct_cd," ).append("\n"); 
		query.append("fo.acct_itm_seq ori_acct_itm_seq," ).append("\n"); 
		query.append("fa.acct_itm_nm," ).append("\n"); 
		query.append("to_char(fo.eff_dt,'YYYYMMDD') eff_dt," ).append("\n"); 
		query.append("to_char(fo.exp_dt,'YYYYMMDD') exp_dt," ).append("\n"); 
		query.append("to_char(fo.eff_dt,'YYYYMMDD') ori_eff_dt," ).append("\n"); 
		query.append("to_char(fo.exp_dt,'YYYYMMDD') ori_exp_dt," ).append("\n"); 
		query.append("fo.curr_cd," ).append("\n"); 
		query.append("fo.otr_expn_amt" ).append("\n"); 
		query.append("from  fms_otr_expn fo, fms_acct_itm fa" ).append("\n"); 
		query.append("where  fo.flet_ctrt_no = @[flet_ctrt_no]" ).append("\n"); 
		query.append("and  fo.acct_cd = fa.acct_cd" ).append("\n"); 
		query.append("and  fo.acct_itm_seq = fa.acct_itm_seq" ).append("\n"); 
		query.append("order  by fa.acct_itm_nm asc, fo.eff_dt asc, fo.exp_dt desc" ).append("\n"); 

	}
}