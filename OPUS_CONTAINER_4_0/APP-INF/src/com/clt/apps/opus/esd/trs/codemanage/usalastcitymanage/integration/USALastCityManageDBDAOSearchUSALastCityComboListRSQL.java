/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : USALastCityManageDBDAOSearchUSALastCityComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.02
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.06.02 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USALastCityManageDBDAOSearchUSALastCityComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA/CA CY&Door S/O Creation에서 해당하는 node의 usa last city를 가져온다.
	  * </pre>
	  */
	public USALastCityManageDBDAOSearchUSALastCityComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.integration").append("\n"); 
		query.append("FileName : USALastCityManageDBDAOSearchUSALastCityComboListRSQL").append("\n"); 
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
		query.append("SELECT LST_LOC_CD" ).append("\n"); 
		query.append("  FROM TRS_DMST_LST_CTY" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND ORG_LOC_CD = @[org_loc_cd]" ).append("\n"); 
		query.append("   AND DEST_LOC_CD = @[dest_loc_cd]" ).append("\n"); 
		query.append(" ORDER BY UPD_DT DESC" ).append("\n"); 

	}
}