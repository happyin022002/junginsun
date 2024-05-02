/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchLccSccRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.28
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.11.28 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchLccSccRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchLccSccRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchLccSccRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${return_nm} == 'LCC_CD')" ).append("\n"); 
		query.append("       EQ.LCC_CD AS RETURN_NM" ).append("\n"); 
		query.append("#elseif (${return_nm} == 'SCC_CD')" ).append("\n"); 
		query.append("       EQ.SCC_CD AS RETURN_NM" ).append("\n"); 
		query.append("#elseif (${return_nm} == 'RCC_CD')" ).append("\n"); 
		query.append("       EQ.RCC_CD AS RETURN_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM MDM_LOCATION LOC, MDM_EQ_ORZ_CHT EQ" ).append("\n"); 
		query.append(" WHERE LOC.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("   AND LOC.SCC_CD = EQ.SCC_CD" ).append("\n"); 

	}
}