/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortInformationMgtDBDAOMdmLocCdComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.10 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortInformationMgtDBDAOMdmLocCdComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public PortInformationMgtDBDAOMdmLocCdComboRSQL(){
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
		query.append("ML.LOC_CD AS VAL" ).append("\n"); 
		query.append(",   ML.LOC_CD AS NAME" ).append("\n"); 
		query.append(",   to_char(AA.DF) as df" ).append("\n"); 
		query.append("FROM  MDM_LOCATION ML" ).append("\n"); 
		query.append(",    (SELECT A.LOC_CD FM_PORT" ).append("\n"); 
		query.append(",      B.LOC_CD TO_PORT" ).append("\n"); 
		query.append(",      ((B.GMT_HRS - A.GMT_HRS) / 60) DF" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD  = @[loc_cd]" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE  ML.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    ML.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("AND    ML.LOC_CD = AA.TO_PORT" ).append("\n"); 
		query.append("AND    ML.LOC_CD NOT IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TO_LOC_CD" ).append("\n"); 
		query.append("FROM   VSK_PORT_DIST" ).append("\n"); 
		query.append("WHERE  FM_LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY NAME ASC" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration").append("\n"); 
		query.append("FileName : PortInformationMgtDBDAOMdmLocCdComboRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}