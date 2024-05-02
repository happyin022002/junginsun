/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DMTCommonDBDAOSearchUserInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.18
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.04.18 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchUserInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자의 정보를 조회한다.
	  * </pre>
	  */
	public DMTCommonDBDAOSearchUserInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchUserInfoRSQL").append("\n"); 
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
		query.append("SELECT	OFC_N3RD_LVL_CD AS CNG_RHQ_OFC_CD," ).append("\n"); 
		query.append("        LST_LGIN_OFC_CD AS LST_LGIN_OFC_CD" ).append("\n"); 
		query.append("FROM 	COM_USER T1, DMT_OFC_LVL_V T2" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND     T1.LST_LGIN_OFC_CD = T2.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("AND     T1.USR_ID          = @[usr_id]" ).append("\n"); 

	}
}