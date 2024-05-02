/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserRoleApprovalDBDAOMenuListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.17 
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

public class UserRoleApprovalDBDAOMenuListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대메뉴를 가져온다
	  * </pre>
	  */
	public UserRoleApprovalDBDAOMenuListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnt_pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_level",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.role.integration").append("\n"); 
		query.append("FileName : UserRoleApprovalDBDAOMenuListRSQL").append("\n"); 
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
		query.append("select substr(regexp_substr(scbp, '#[^#]*', 1, 1), 2) as menu_nm," ).append("\n"); 
		query.append("  substr(regexp_substr(scbp, '#[^#]*', 1, 2), 2) as sub_menu_nm," ).append("\n"); 
		query.append("  substr(pgm_no, 5, 3) sub_sys_cd," ).append("\n"); 
		query.append("  a.pgm_no," ).append("\n"); 
		query.append("  a.prnt_pgm_no," ).append("\n"); 
		query.append("  a.pgm_level" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("    select sys_connect_by_path(b.pgm_nm, '#') scbp ," ).append("\n"); 
		query.append("      a.prnt_pgm_no," ).append("\n"); 
		query.append("      b.pgm_no," ).append("\n"); 
		query.append("      level pgm_level" ).append("\n"); 
		query.append("    from com_mnu_cfg a," ).append("\n"); 
		query.append("      com_program b" ).append("\n"); 
		query.append("    where a.chd_pgm_no = b.pgm_no " ).append("\n"); 
		query.append("    start with a.prnt_pgm_no = '000_000_M000' " ).append("\n"); 
		query.append("    connect by prior a.chd_pgm_no = a.prnt_pgm_no" ).append("\n"); 
		query.append("      and level < 3" ).append("\n"); 
		query.append("    order siblings by a.dp_seq ) a" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and a.pgm_level = @[pgm_level] " ).append("\n"); 
		query.append("#if(${pgm_level}==1)" ).append("\n"); 
		query.append("and a.pgm_no not in ('ADM_000_M000')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and a.pgm_no not in ('ESM_COA_M001', 'EES_SPP_M001')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${prnt_pgm_no} != '')" ).append("\n"); 
		query.append("and a.prnt_pgm_no = @[prnt_pgm_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${prnt_pgm_no} == 'SVM_000_M000')" ).append("\n"); 
		query.append("and a.pgm_no not in ('ESD_LEA_M001')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}