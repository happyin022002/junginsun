/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOVerifyEqNoMgSetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.04.14 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOVerifyEqNoMgSetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Genset verify
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOVerifyEqNoMgSetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOVerifyEqNoMgSetRSQL").append("\n"); 
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
		query.append("SELECT eq_no" ).append("\n"); 
		query.append("FROM cgm_equipment" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND eq_knd_cd = 'G'  --Equipment Kind Code : G(MGSet)" ).append("\n"); 
		query.append("AND eq_no IN (" ).append("\n"); 
		query.append("#foreach(${key} in ${eq_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}