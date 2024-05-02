/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UserRoleApprovalDBDAOSearchRoleAuthAproRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserRoleApprovalDBDAOSearchRoleAuthAproRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reqeust한 Role을 search 한다.
	  * </pre>
	  */
	public UserRoleApprovalDBDAOSearchRoleAuthAproRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.role.integration").append("\n"); 
		query.append("FileName : UserRoleApprovalDBDAOSearchRoleAuthAproRSQL").append("\n"); 
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
		query.append("select a.apro_rqst_no," ).append("\n"); 
		query.append("a.rqst_usr_id," ).append("\n"); 
		query.append("(select b.usr_nm from com_user b where b.usr_id = a.rqst_usr_id and rownum=1 ) rqst_usr_nm," ).append("\n"); 
		query.append("(select b.usr_eml from com_user b where b.usr_id = a.rqst_usr_id and rownum=1 ) rqst_usr_eml," ).append("\n"); 
		query.append("a.rqst_ofc_cd," ).append("\n"); 
		query.append("a.rqst_st_dt," ).append("\n"); 
		query.append("a.rqst_st_dt_hr," ).append("\n"); 
		query.append("a.role_module," ).append("\n"); 
		query.append("a.usr_role_cd," ).append("\n"); 
		query.append("a.usr_role_nm," ).append("\n"); 
		query.append("a.rqst_rmk," ).append("\n"); 
		query.append("a.apro_rqst_seq," ).append("\n"); 
		query.append("a.apsts_cd," ).append("\n"); 
		query.append("a.apro_rmk" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("    select hdr.apro_rqst_no," ).append("\n"); 
		query.append("      hdr.rqst_usr_id," ).append("\n"); 
		query.append("      hdr.rqst_ofc_cd," ).append("\n"); 
		query.append("      to_char(hdr.rqst_st_dt, 'YYYY-MM-DD') as rqst_st_dt," ).append("\n"); 
		query.append("      to_char(hdr.rqst_st_dt, 'YYYY/MM/DD HH24:mi:ss') as rqst_st_dt_hr," ).append("\n"); 
		query.append("      substr(dtl.usr_role_cd, 1, 3) as role_module," ).append("\n"); 
		query.append("      dtl.usr_role_cd," ).append("\n"); 
		query.append("      urole.usr_role_nm," ).append("\n"); 
		query.append("      hdr.rqst_rmk," ).append("\n"); 
		query.append("      rout.apro_rqst_seq," ).append("\n"); 
		query.append("      rout.apsts_cd," ).append("\n"); 
		query.append("      rout.apro_rmk" ).append("\n"); 
		query.append("    from com_apro_role_rqst_hdr hdr," ).append("\n"); 
		query.append("      com_apro_role_dtl dtl," ).append("\n"); 
		query.append("      com_apro_role_rqst_rout rout," ).append("\n"); 
		query.append("      com_usr_role urole" ).append("\n"); 
		query.append("    where 1 =1" ).append("\n"); 
		query.append("      and hdr.apro_rqst_no = dtl.apro_rqst_no" ).append("\n"); 
		query.append("      and dtl.apro_rqst_no = rout.apro_rqst_no" ).append("\n"); 
		query.append("      and dtl.usr_role_cd = urole.usr_role_cd" ).append("\n"); 
		query.append("      and rout.apsts_cd = 'P'" ).append("\n"); 
		query.append("    order by rout.apro_rqst_no desc, rout.apro_rqst_seq desc ) a" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("#if(${usr_auth_tp_cd} != 'A') " ).append("\n"); 
		query.append("and role_module in (" ).append("\n"); 
		query.append("    select role_module" ).append("\n"); 
		query.append("    from (" ).append("\n"); 
		query.append("        select distinct substr(b.pgm_no, 0, 3) role_module" ).append("\n"); 
		query.append("        from com_user a," ).append("\n"); 
		query.append("          com_usr_pgm_mtch b" ).append("\n"); 
		query.append("        where a.usr_id = b.usr_id" ).append("\n"); 
		query.append("          and a.usr_auth_tp_cd = 'S'" ).append("\n"); 
		query.append("          and NVL(a.use_flg, 'Y') = 'Y'" ).append("\n"); 
		query.append("          and length(b.pgm_no) = 3" ).append("\n"); 
		query.append("          and a.usr_id = @[usr_id]" ).append("\n"); 
		query.append("        )a" ).append("\n"); 
		query.append("    group by a.role_module)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${apro_rqst_no} != '')" ).append("\n"); 
		query.append("and apro_rqst_no in (" ).append("\n"); 
		query.append("#foreach($rqst_no IN ${apro_rqst_no})" ).append("\n"); 
		query.append("	#if($velocityCount < $apro_rqst_no.size())" ).append("\n"); 
		query.append("		'$rqst_no', " ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		'$rqst_no' " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("order by a.role_module" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}