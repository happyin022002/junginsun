/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MenuDAOgetSiblingRSQL.java
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

public class MenuDAOgetSiblingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select sibling menu
	  * </pre>
	  */
	public MenuDAOgetSiblingRSQL(){
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
		query.append("Path : com.hanjin.syscommon.common.menu.dao").append("\n"); 
		query.append("FileName : MenuDAOgetSiblingRSQL").append("\n"); 
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
		query.append("SELECT  A.MNU_CFG_CD,A.PRNT_PGM_NO,A.CHD_PGM_NO,A.PGM_LVL_VAL,A.DP_SEQ                    " ).append("\n"); 
		query.append("			,B.PGM_NO,B.PGM_NM,B.PGM_URL,B.PGM_LVL_DIV_CD,B.POPUP_FLG,'Y' AUTH_YN" ).append("\n"); 
		query.append("FROM  COM_MNU_CFG A, COM_PROGRAM B" ).append("\n"); 
		query.append("WHERE A.CHD_PGM_NO = B.PGM_NO" ).append("\n"); 
		query.append("AND A.PRNT_PGM_NO = (SELECT PRNT_PGM_NO " ).append("\n"); 
		query.append("FROM COM_MNU_CFG " ).append("\n"); 
		query.append("WHERE CHD_PGM_NO = @[pgm_no])" ).append("\n"); 

	}
}