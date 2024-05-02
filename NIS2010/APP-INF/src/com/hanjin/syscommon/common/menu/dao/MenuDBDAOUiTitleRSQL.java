/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MenuDBDAOUiTitleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.common.menu.dao;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MenuDBDAOUiTitleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Navigation �젙蹂� 議고쉶
	  * </pre>
	  */
	public MenuDBDAOUiTitleRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rootPgmCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.common.menu.dao").append("\n"); 
		query.append("FileName : MenuDBDAOUiTitleRSQL").append("\n"); 
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
		query.append("SELECT /*+ no_connect_by_filtering */  " ).append("\n"); 
		query.append("	SYS_CONNECT_BY_PATH(PGM_NM, '&nbsp;&gt;&nbsp;') UI_NAVIGATION  " ).append("\n"); 
		query.append("	,PGM_NM UI_TITLE" ).append("\n"); 
		query.append("	,PGM_DESC UI_DESCRIPTION" ).append("\n"); 
		query.append("	,PGM_URL UI_URL" ).append("\n"); 
		query.append("  FROM  (SELECT A.CHD_PGM_NO,A.PRNT_PGM_NO,B.PGM_NM,B.PGM_DESC,B.PGM_URL" ).append("\n"); 
		query.append("          FROM COM_MNU_CFG A," ).append("\n"); 
		query.append("               COM_PROGRAM B" ).append("\n"); 
		query.append("        WHERE A.CHD_PGM_NO = B.PGM_NO)" ).append("\n"); 
		query.append("WHERE CHD_PGM_NO = @[pgm_no]" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#if (${pid} != '') " ).append("\n"); 
		query.append("		AND PRNT_PGM_NO = @[pid]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("START WITH PRNT_PGM_NO = @[rootPgmCd]" ).append("\n"); 
		query.append("CONNECT BY PRIOR CHD_PGM_NO = PRNT_PGM_NO" ).append("\n"); 

	}
}