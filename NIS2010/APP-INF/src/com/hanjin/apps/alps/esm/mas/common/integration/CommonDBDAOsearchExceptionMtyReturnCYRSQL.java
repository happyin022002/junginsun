/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOsearchExceptionMtyReturnCYRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOsearchExceptionMtyReturnCYRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchExceptionMtyReturnCY
	  * </pre>
	  */
	public CommonDBDAOsearchExceptionMtyReturnCYRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pol_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOsearchExceptionMtyReturnCYRSQL").append("\n"); 
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
		query.append("SELECT MTY_PKUP_RTN_YD_CD" ).append("\n"); 
		query.append("FROM PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND  POR_DEL_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND  POL_POD_CD = @[f_pol_pod_cd]" ).append("\n"); 
		query.append("AND  IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND  SPCL_CGO_CD IN (${f_spcl_cgo_cd})" ).append("\n"); 
		query.append("AND  VSL_SLAN_CD = 'ALL'" ).append("\n"); 

	}
}