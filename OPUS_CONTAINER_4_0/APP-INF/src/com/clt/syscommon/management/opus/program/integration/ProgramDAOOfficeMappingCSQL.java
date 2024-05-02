/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProgramDAOOfficeMappingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2010.03.15 김경범
* 1.0 Creation
=========================================================*/
package com.clt.syscommon.management.opus.program.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kyungbum kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProgramDAOOfficeMappingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * program office mapping insert all
	  * </pre>
	  */
	public ProgramDAOOfficeMappingCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.syscommon.management.opus.program.integration").append("\n"); 
		query.append("FileName : ProgramDAOOfficeMappingCSQL").append("\n"); 
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
		query.append("insert into com_ofc_pgm_mtch" ).append("\n"); 
		query.append("select ofc_cd, @[pgm_no] pgm_no, 'SYSTEM' cre_usr_id, sysdate cre_dt, 'SYSTEM' upd_usr_id, sysdate upd_dt" ).append("\n"); 
		query.append("FROM mdm_organization                                                 " ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'                                                  " ).append("\n"); 
		query.append("CONNECT BY PRIOR ofc_cd = prnt_ofc_cd                                 " ).append("\n"); 
		query.append("START WITH prnt_ofc_cd IS NULL    " ).append("\n"); 

	}
}