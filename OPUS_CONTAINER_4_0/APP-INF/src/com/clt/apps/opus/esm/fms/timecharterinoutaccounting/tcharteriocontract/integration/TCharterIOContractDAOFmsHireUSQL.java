/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.04.27 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGINSUN
 * @see 
 * @since J2EE 1.4
 */

public class TCharterIOContractDAOFmsHireUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOFmsHireUSQL
	  * </pre>
	  */
	public TCharterIOContractDAOFmsHireUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hir_curr_n1st_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hir_curr_n2nd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hir_rt_n2nd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hir_rt_n1st_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("update fms_hire set" ).append("\n"); 
		query.append("flet_ctrt_no = @[flet_ctrt_no]," ).append("\n"); 
		query.append("eff_dt = TO_DATE(@[eff_dt],'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("exp_dt = TO_DATE(@[exp_dt],'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("hir_rt_n1st_amt = @[hir_rt_n1st_amt]," ).append("\n"); 
		query.append("hir_curr_n1st_cd = @[hir_curr_n1st_cd]," ).append("\n"); 
		query.append("hir_rt_n2nd_amt = @[hir_rt_n2nd_amt]," ).append("\n"); 
		query.append("hir_curr_n2nd_cd = @[hir_curr_n2nd_cd]," ).append("\n"); 
		query.append("upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt = sysdate" ).append("\n"); 
		query.append("where flet_ctrt_no = @[flet_ctrt_no]" ).append("\n"); 
		query.append("and eff_dt = decode(@[ori_eff_dt],null,TO_DATE(@[eff_dt],'YYYYMMDDHH24MI'),TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI'))" ).append("\n"); 
		query.append("and exp_dt = decode(@[ori_exp_dt],null,TO_DATE(@[exp_dt],'YYYYMMDDHH24MI'),TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI'))" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDAOFmsHireUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}