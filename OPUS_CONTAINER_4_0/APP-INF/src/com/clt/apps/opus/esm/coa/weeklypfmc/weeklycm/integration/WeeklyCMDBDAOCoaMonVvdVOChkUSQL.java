/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WeeklyCMDBDAOCoaMonVvdVOChkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.21 박수훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOCoaMonVvdVOChkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  COA_MON_VVD Check List 수정   
	  * </pre>
	  */
	public WeeklyCMDBDAOCoaMonVvdVOChkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wky_mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOCoaMonVvdVOChkUSQL").append("\n"); 
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
		query.append("UPDATE COA_MON_VVD" ).append("\n"); 
		query.append("SET WKY_MNL_FLG = NVL2(@[wky_mnl_flg], 'M', 'P')" ).append("\n"); 
		query.append(",WKY_TGT_FLG  = 'Y'" ).append("\n"); 
		query.append(",COST_YRMON   = @[cost_yrmon]" ).append("\n"); 
		query.append(",SLS_YRMON    = @[sls_yrmon]" ).append("\n"); 
		query.append(",COST_WK      = @[cost_wk]" ).append("\n"); 
		query.append(",UPD_USR_ID   = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TRD_CD     IN (CASE" ).append("\n"); 
		query.append("WHEN @[trd_cd] = 'AES'" ).append("\n"); 
		query.append("THEN 'IES'" ).append("\n"); 
		query.append("WHEN @[trd_cd] = 'IES'" ).append("\n"); 
		query.append("THEN 'AES'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(",@[trd_cd])" ).append("\n"); 
		query.append("AND RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("AND VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND DIR_CD       = @[dir_cd]" ).append("\n"); 

	}
}