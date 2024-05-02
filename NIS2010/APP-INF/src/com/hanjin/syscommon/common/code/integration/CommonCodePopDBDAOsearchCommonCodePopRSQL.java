/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonCodePopDBDAOsearchCommonCodePopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.common.code.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodePopDBDAOsearchCommonCodePopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCommonCodePop
	  * </pre>
	  */
	public CommonCodePopDBDAOsearchCommonCodePopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.common.code.integration").append("\n"); 
		query.append("FileName : CommonCodePopDBDAOsearchCommonCodePopRSQL").append("\n"); 
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
		query.append("	select                                          " ).append("\n"); 
		query.append("			   intg_cd_id          ,                         " ).append("\n"); 
		query.append("			   intg_cd_val_ctnt    ,                         " ).append("\n"); 
		query.append("			   intg_cd_val_dp_desc ,                        " ).append("\n"); 
		query.append("			   intg_cd_val_desc                           " ).append("\n"); 
		query.append("			 from com_intg_cd_dtl                           " ).append("\n"); 
		query.append("			 where INTG_CD_ID = @[INTG_CD_ID]                      " ).append("\n"); 
		query.append("			 order by INTG_CD_VAL_DP_SEQ                   " ).append("\n"); 

	}
}