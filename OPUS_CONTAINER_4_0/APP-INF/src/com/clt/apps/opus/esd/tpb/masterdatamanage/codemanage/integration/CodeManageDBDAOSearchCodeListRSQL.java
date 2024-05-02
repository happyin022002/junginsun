/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CodeManageDBDAOSearchCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeManageDBDAOSearchCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCodeList
	  * </pre>
	  */
	public CodeManageDBDAOSearchCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_billing_case_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.integration").append("\n"); 
		query.append("FileName : CodeManageDBDAOSearchCodeListRSQL").append("\n"); 
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
		query.append("SELECT n3pty_if_tp_cd" ).append("\n"); 
		query.append("      ,n3pty_expn_tp_cd" ).append("\n"); 
		query.append("      ,n3pty_bil_tp_cd" ).append("\n"); 
		query.append("      ,n3pty_bil_tp_nm" ).append("\n"); 
		query.append("      ,n3pty_bil_tp_desc" ).append("\n"); 
		query.append("      ,cop_expt_cs_cd" ).append("\n"); 
		query.append("      ,cml_sys_if_cd" ).append("\n"); 
		query.append("      ,act_flg" ).append("\n"); 
		query.append("      ,cre_usr_id" ).append("\n"); 
		query.append("	  ,'A' AS ibflag" ).append("\n"); 
		query.append("	  ,ar_acct_cd" ).append("\n"); 
		query.append("#if (${cre_dt} != '')" ).append("\n"); 
		query.append("--       ,TO_CHAR(TPB_GET_LCL_DATE_FNC(cre_dt,@[cre_dt]),'YYYY-MM-DD') AS cre_dt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,upd_usr_id" ).append("\n"); 
		query.append("#if (${upd_dt} != '') " ).append("\n"); 
		query.append("--      ,TO_CHAR(TPB_GET_LCL_DATE_FNC(upd_dt,@[upd_dt]),'YYYY-MM-DD') AS upd_dt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM tpb_n3rd_pty_bil_tp" ).append("\n"); 
		query.append(" WHERE act_flg = 'Y'" ).append("\n"); 
		query.append("#if (${s_billing_case_cd} != '') " ).append("\n"); 
		query.append("   AND n3pty_bil_tp_cd LIKE @[s_billing_case_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}