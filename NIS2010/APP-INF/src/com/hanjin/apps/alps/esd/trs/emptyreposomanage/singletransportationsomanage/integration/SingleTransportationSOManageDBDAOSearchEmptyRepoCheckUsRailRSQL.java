/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchEmptyRepoCheckUsRailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchEmptyRepoCheckUsRailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력받은 From Node가 US Rail인지 확인하고
	  * US Rail일 경우 에러 메시지를 보낸다
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchEmptyRepoCheckUsRailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchEmptyRepoCheckUsRailRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(*) = 0 THEN 'N'" ).append("\n"); 
		query.append("            ELSE 'Y'" ).append("\n"); 
		query.append("        END AS CHK_US_RAIL" ).append("\n"); 
		query.append("  FROM MDM_COUNTRY CNTY " ).append("\n"); 
		query.append("      ,MDM_LOCATION LOC" ).append("\n"); 
		query.append(" WHERE LOC.CNT_CD = CNTY.CNT_CD" ).append("\n"); 
		query.append("   AND CNTY.CNT_CD != 'MX' " ).append("\n"); 
		query.append("   AND LOC.CONTI_CD = 'M'" ).append("\n"); 
		query.append("   AND 'R' = @[trsp_mod_cd]" ).append("\n"); 
		query.append("   AND LOC.LOC_CD = @[fm_loc_cd]" ).append("\n"); 

	}
}