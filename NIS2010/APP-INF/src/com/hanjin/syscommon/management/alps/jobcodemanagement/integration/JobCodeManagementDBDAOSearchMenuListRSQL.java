/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAOSearchMenuListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.24
*@LastModifier :허은정 
*@LastVersion : 1.0
* 2013.09.24 허은정
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author heo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JobCodeManagementDBDAOSearchMenuListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JobCodeManagementDBDAOSearchMenuListRSQL(){
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
		params.put("usr_role_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.jobcodemanagement.integration").append("\n"); 
		query.append("FileName : JobCodeManagementDBDAOSearchMenuListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("level," ).append("\n"); 
		query.append("chd_pgm_no pgm_no," ).append("\n"); 
		query.append("pgm_nm," ).append("\n"); 
		query.append("auth" ).append("\n"); 
		query.append("FROM (SELECT a.mnu_cfg_cd,a.prnt_pgm_no,a.chd_pgm_no,a.pgm_lvl_val,a.dp_seq" ).append("\n"); 
		query.append(",b.pgm_no,b.pgm_nm,b.pgm_url,b.pgm_lvl_div_cd,decode(c.prnt_pgm_no, null, '0', '1') auth                                               " ).append("\n"); 
		query.append("FROM com_mnu_cfg a, com_program b," ).append("\n"); 
		query.append("(select distinct A.prnt_pgm_no" ).append("\n"); 
		query.append("from com_mnu_cfg A, com_program B, com_pgm_role C" ).append("\n"); 
		query.append("where A.chd_pgm_no=B.pgm_no" ).append("\n"); 
		query.append("and B.pgm_no=C.pgm_no" ).append("\n"); 
		query.append("and C.usr_role_cd= @[usr_role_cd]       -- 여기엔 role 코드를 Parameter 로 받아서 세팅" ).append("\n"); 
		query.append(") c" ).append("\n"); 
		query.append("WHERE a.chd_pgm_no = b.pgm_no(+)" ).append("\n"); 
		query.append("And a.prnt_pgm_no = c.prnt_pgm_no(+)" ).append("\n"); 
		query.append("AND b.pgm_tp_cd(+) = '00'" ).append("\n"); 
		query.append("AND A.MNU_CFG_CD= '002'" ).append("\n"); 
		query.append("AND b.use_flg(+) = 'Y')" ).append("\n"); 
		query.append("CONNECT BY PRIOR chd_pgm_no = prnt_pgm_no" ).append("\n"); 
		query.append("START WITH PRNT_PGM_NO = @[prnt_pgm_no] AND MNU_CFG_CD= '002'" ).append("\n"); 
		query.append("ORDER SIBLINGS BY dp_seq" ).append("\n"); 

	}
}