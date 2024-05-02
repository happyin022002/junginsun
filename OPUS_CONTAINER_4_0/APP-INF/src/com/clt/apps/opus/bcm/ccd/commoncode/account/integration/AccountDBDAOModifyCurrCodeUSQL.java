/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountDBDAOModifyCurrCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.03.14 조인영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.account.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Cho In Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountDBDAOModifyCurrCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.02.21 조인영 Currency Code 정보를 수정한다.
	  * </pre>
	  */
	public AccountDBDAOModifyCurrCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_prcs_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtd_prcs_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.account.integration").append("\n"); 
		query.append("FileName : AccountDBDAOModifyCurrCodeUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CURRENCY SET" ).append("\n"); 
		query.append("  		CURR_NM      = @[curr_nm]     " ).append("\n"); 
		query.append("       ,CURR_DESC    = @[curr_desc]   " ).append("\n"); 
		query.append("       ,CNT_CD       = @[cnt_cd]      " ).append("\n"); 
		query.append("       ,FM_EFF_DT    = TO_DATE(TRIM(REPLACE(@[fm_eff_dt], '-', '')),'YYYYMMDD')   " ).append("\n"); 
		query.append("       ,TO_EFF_DT    = TO_DATE(TRIM(REPLACE(@[to_eff_dt], '-', '')),'YYYYMMDD')   " ).append("\n"); 
		query.append("       ,DP_PRCS_KNT  = @[dp_prcs_knt] " ).append("\n"); 
		query.append("       ,XTD_PRCS_KNT = @[xtd_prcs_knt]" ).append("\n"); 
		query.append("       ,UPD_USR_ID   = @[upd_usr_id]  " ).append("\n"); 
		query.append("       ,UPD_DT       = sysdate        " ).append("\n"); 
		query.append("       ,DELT_FLG     = @[delt_flg]    " ).append("\n"); 
		query.append("       ,EAI_IF_ID    = @[eai_if_id]      " ).append("\n"); 
		query.append("WHERE  CURR_CD       = @[curr_cd]" ).append("\n"); 

	}
}