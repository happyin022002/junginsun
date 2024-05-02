/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CodeManageDBDAOMultiCodeUSQL.java
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

public class CodeManageDBDAOMultiCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiCode
	  * </pre>
	  */
	public CodeManageDBDAOMultiCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_expt_cs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_tp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cml_sys_if_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.integration").append("\n"); 
		query.append("FileName : CodeManageDBDAOMultiCodeUSQL").append("\n"); 
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
		query.append("UPDATE tpb_n3rd_pty_bil_tp" ).append("\n"); 
		query.append("   SET n3pty_expn_tp_cd = @[n3pty_expn_tp_cd]" ).append("\n"); 
		query.append("      ,n3pty_bil_tp_nm = @[n3pty_bil_tp_nm]" ).append("\n"); 
		query.append("      ,n3pty_bil_tp_desc = @[n3pty_bil_tp_desc]" ).append("\n"); 
		query.append("	  ,cop_expt_cs_cd =@[cop_expt_cs_cd]" ).append("\n"); 
		query.append("	  ,cml_sys_if_cd = @[cml_sys_if_cd]" ).append("\n"); 
		query.append("	  ,act_flg = 'Y'" ).append("\n"); 
		query.append("	  ,upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append("	  ,upd_dt = SYSDATE" ).append("\n"); 
		query.append("	  ,n3pty_if_tp_cd = 'S'" ).append("\n"); 
		query.append("	  ,ar_acct_cd = @[ar_acct_cd]" ).append("\n"); 
		query.append(" WHERE n3pty_bil_tp_cd = @[n3pty_bil_tp_cd]" ).append("\n"); 

	}
}