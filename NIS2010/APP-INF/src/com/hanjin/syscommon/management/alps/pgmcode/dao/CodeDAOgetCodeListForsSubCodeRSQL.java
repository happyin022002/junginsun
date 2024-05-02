/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CodeDAOgetCodeListForsSubCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.pgmcode.dao;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeDAOgetCodeListForsSubCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getCodeListForsSubCode
	  * </pre>
	  */
	public CodeDAOgetCodeListForsSubCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_appl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.pgmcode.dao").append("\n"); 
		query.append("FileName : CodeDAOgetCodeListForsSubCodeRSQL").append("\n"); 
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
		query.append("SELECT (100000 +(rownum * 10) ) as sortKey," ).append("\n"); 
		query.append("                pgm_sub_sys_cd as code,              " ).append("\n"); 
		query.append("           		pgm_sub_sys_cd as name,              " ).append("\n"); 
		query.append("           		pgm_sub_sys_nm as pgmSubSysNm,                      " ).append("\n"); 
		query.append("           		pgm_appl_cd as pgmApplCd                          " ).append("\n"); 
		query.append("                FROM com_pgm_sub_sys	                  " ).append("\n"); 
		query.append("                WHERE pgm_appl_cd = @[pgm_appl_cd]                      " ).append("\n"); 
		query.append("      #if(${sort_key} > 0)" ).append("\n"); 
		query.append("            ORDER BY sortKey" ).append("\n"); 
		query.append("      #end" ).append("\n"); 

	}
}