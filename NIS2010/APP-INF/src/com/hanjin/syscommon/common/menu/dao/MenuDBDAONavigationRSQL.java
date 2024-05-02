/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MenuDBDAONavigationRSQL.java
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

public class MenuDBDAONavigationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Navigation �젙蹂� 議고쉶
	  * </pre>
	  */
	public MenuDBDAONavigationRSQL(){
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
		params.put("rootPgmCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.common.menu.dao").append("\n"); 
		query.append("FileName : MenuDBDAONavigationRSQL").append("\n"); 
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
		query.append("-- UI NAVIGATION" ).append("\n"); 
		query.append("SELECT SYS_CONNECT_BY_PATH(B.PGM_NM, '&nbsp;&gt;&nbsp;') UI_NAVIGATION    " ).append("\n"); 
		query.append("FROM  COM_MNU_CFG A, COM_PROGRAM B    " ).append("\n"); 
		query.append("WHERE A.CHD_PGM_NO = B.PGM_NO    " ).append("\n"); 
		query.append("AND A.CHD_PGM_NO = @[pgm_no]  " ).append("\n"); 
		query.append("START WITH A.PRNT_PGM_NO = @[rootPgmCd]" ).append("\n"); 
		query.append("CONNECT BY PRIOR A.CHD_PGM_NO = A.PRNT_PGM_NO" ).append("\n"); 

	}
}