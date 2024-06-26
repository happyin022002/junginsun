/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetCodeValueForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.12
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.02.12 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetCodeValueForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Value, Column, Table을 Param으로 받아서 Value값을 return
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetCodeValueForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetCodeValueForGateNewRSQL").append("\n"); 
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
		query.append("SELECT ${return_nm} AS RETURN_NM" ).append("\n"); 
		query.append("FROM ${table_nm}" ).append("\n"); 
		query.append("WHERE ${column_nm} = @[code_value]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}