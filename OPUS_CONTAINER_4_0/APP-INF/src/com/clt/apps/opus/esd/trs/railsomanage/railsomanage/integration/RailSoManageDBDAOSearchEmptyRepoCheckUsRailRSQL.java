/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailSoManageDBDAOSearchEmptyRepoCheckUsRailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.16
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.12.16 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearchEmptyRepoCheckUsRailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * From node가 US Rail인지 체크한다
	  * </pre>
	  */
	public RailSoManageDBDAOSearchEmptyRepoCheckUsRailRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearchEmptyRepoCheckUsRailRSQL").append("\n"); 
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
		query.append("   AND CNTY.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND LOC.CONTI_CD = 'M'" ).append("\n"); 
		query.append("   AND 'R' = @[trsp_mod_cd]" ).append("\n"); 
		query.append("   AND LOC.LOC_CD = @[fm_loc_cd]" ).append("\n"); 

	}
}