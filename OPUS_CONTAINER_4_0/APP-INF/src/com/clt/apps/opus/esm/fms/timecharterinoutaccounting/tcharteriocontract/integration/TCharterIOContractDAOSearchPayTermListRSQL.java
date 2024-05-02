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
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration ;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGINSUN
 * @see 
 * @since J2EE 1.4
 */

public class TCharterIOContractDAOSearchPayTermListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOSearchPayTermListRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOSearchPayTermListRSQL(){
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
		query.append("flet_ctrt_no," ).append("\n"); 
		query.append("to_char(eff_dt,'YYYYMMDDHH24MISS') eff_dt," ).append("\n"); 
		query.append("to_char(exp_dt,'YYYYMMDDHH24MISS') exp_dt," ).append("\n"); 
		query.append("to_char(eff_dt,'YYYYMMDDHH24MISS') ori_eff_dt," ).append("\n"); 
		query.append("to_char(exp_dt,'YYYYMMDDHH24MISS') ori_exp_dt," ).append("\n"); 
		query.append("ctrt_pay_term_cd" ).append("\n"); 
		query.append("from fms_pay_term" ).append("\n"); 
		query.append("where flet_ctrt_no = @[flet_ctrt_no]" ).append("\n"); 
		query.append("order by eff_dt asc, exp_dt asc" ).append("\n"); 

	}
}