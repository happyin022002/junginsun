/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOContractDAOFmsHireCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOContractDAOFmsHireCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOFmsHireCSQL
	  * </pre>
	  */
	public TCharterIOContractDAOFmsHireCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hir_curr_n1st_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hir_curr_n2nd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hir_rt_n2nd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hir_rt_n1st_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDAOFmsHireCSQL").append("\n"); 
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
		query.append("insert into fms_hire (" ).append("\n"); 
		query.append("	flet_ctrt_no," ).append("\n"); 
		query.append("	eff_dt," ).append("\n"); 
		query.append("	exp_dt," ).append("\n"); 
		query.append("	hir_rt_n1st_amt," ).append("\n"); 
		query.append("	hir_curr_n1st_cd," ).append("\n"); 
		query.append("	hir_rt_n2nd_amt," ).append("\n"); 
		query.append("	hir_curr_n2nd_cd," ).append("\n"); 
		query.append("	cre_usr_id," ).append("\n"); 
		query.append("	cre_dt," ).append("\n"); 
		query.append("	upd_usr_id," ).append("\n"); 
		query.append("	upd_dt" ).append("\n"); 
		query.append(") values( " ).append("\n"); 
		query.append("	@[flet_ctrt_no]," ).append("\n"); 
		query.append("	TO_DATE(@[eff_dt],'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("	TO_DATE(@[exp_dt],'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("	@[hir_rt_n1st_amt]," ).append("\n"); 
		query.append("	@[hir_curr_n1st_cd]," ).append("\n"); 
		query.append("	@[hir_rt_n2nd_amt]," ).append("\n"); 
		query.append("	@[hir_curr_n2nd_cd]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	sysdate," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}