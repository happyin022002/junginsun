/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOCheckChassisCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.05.11 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementValidationDBDAOCheckChassisCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 샤시코드 검증
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOCheckChassisCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chassis_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.integration").append("\n"); 
		query.append("FileName : ContainerMovementValidationDBDAOCheckChassisCdRSQL").append("\n"); 
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
		query.append("SELECT 'OK' FIND FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("WHERE EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND ACIAC_DIV_CD ='A'" ).append("\n"); 
		query.append("AND EQ_NO = @[chassis_cd]" ).append("\n"); 

	}
}