/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USALastCityManageDBDAOSearchUSALastCityManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.07.24 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USALastCityManageDBDAOSearchUSALastCityManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trucker에게 중간 경유지를 지정해 주기 위한 USA Last City를 조회
	  * </pre>
	  */
	public USALastCityManageDBDAOSearchUSALastCityManageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deltFlg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.integration").append("\n"); 
		query.append("FileName : USALastCityManageDBDAOSearchUSALastCityManageListRSQL").append("\n"); 
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
		query.append("ORG_LOC_CD," ).append("\n"); 
		query.append("DEST_LOC_CD," ).append("\n"); 
		query.append("LST_LOC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_DMST_LST_CTY" ).append("\n"); 
		query.append("WHERE DELT_FLG = @[deltFlg]" ).append("\n"); 

	}
}