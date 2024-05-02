/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOcheckYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementValidationDBDAOcheckYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard CD Check
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOcheckYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration").append("\n"); 
		query.append("FileName : ContainerMovementValidationDBDAOcheckYardRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR (YD_CD, 6, 2) YD_S, SUBSTR (YD_CD, 0, 5) YD_M, YD_NM" ).append("\n"); 
		query.append("FROM MDM_YARD" ).append("\n"); 
		query.append("#if (${p_yard1} != '')" ).append("\n"); 
		query.append("WHERE SUBSTR (YD_CD, 0, 5) = SUBSTR(@[p_yard1], 0, 5)" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY YD_S, YD_M" ).append("\n"); 

	}
}