/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UserDAOComUserVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2010.03.16 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.user.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kyungbum kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserDAOComUserVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public UserDAOComUserVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_auth_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_locl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gmt_tmzn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtn_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dflt_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_dt_fmt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lang_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_no_fmt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_pwd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mphn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.user.integration").append("\n"); 
		query.append("FileName : UserDAOComUserVOUSQL").append("\n"); 
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
		query.append("UPDATE com_user SET                                                   " ).append("\n"); 
		query.append(" usr_nm              = @[usr_nm] ,                                            " ).append("\n"); 
		query.append(" usr_pwd             = @[usr_pwd] ,                                            " ).append("\n"); 
		query.append(" use_flg             = @[use_flg] ,                                            " ).append("\n"); 
		query.append(" mphn_no             = @[mphn_no] ,    " ).append("\n"); 
		query.append(" fax_no					= @[fax_no] ,            " ).append("\n"); 
		query.append(" usr_eml             = @[usr_eml] ,                                            " ).append("\n"); 
		query.append(" cnt_cd              = @[cnt_cd] ,                                            " ).append("\n"); 
		query.append(" lang_tp_cd          = @[lang_tp_cd] ,                                            " ).append("\n"); 
		query.append(" gmt_tmzn_cd         = @[gmt_tmzn_cd] ,                                            " ).append("\n"); 
		query.append(" cnt_dt_fmt_cd       = @[cnt_dt_fmt_cd] ,                                            " ).append("\n"); 
		query.append(" cnt_no_fmt_cd       = @[cnt_no_fmt_cd] ,                                            " ).append("\n"); 
		query.append(" xtn_phn_no          = @[xtn_phn_no] ,                                            " ).append("\n"); 
		query.append(" dflt_eml			 = @[dflt_eml]," ).append("\n"); 
		query.append(" upd_usr_id          = @[upd_usr_id] ,                                            " ).append("\n"); 
		query.append(" upd_dt              =sysdate,                                      " ).append("\n"); 
		query.append(" usr_locl_nm         = @[usr_locl_nm] ,                                            " ).append("\n"); 
		query.append(" usr_auth_tp_cd      = @[usr_auth_tp_cd] ,                                            " ).append("\n"); 
		query.append(" ofc_cd              = @[ofc_cd]                                              " ).append("\n"); 
		query.append("WHERE usr_id = @[usr_id]" ).append("\n"); 

	}
}