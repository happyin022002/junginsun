/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchCodeExistForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.02.01 김상수
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

public class ContainerMovementMgtDBDAOSearchCodeExistForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Value, Column, Table을 Param으로 받아서 Value가 존재하는지 Check
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchCodeExistForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchCodeExistForGateNewRSQL").append("\n"); 
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
		query.append("SELECT 1" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (SELECT 1" ).append("\n"); 
		query.append("FROM ${table_nm}" ).append("\n"); 
		query.append("WHERE ${column_nm} = '${code_value}'" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 

	}
}