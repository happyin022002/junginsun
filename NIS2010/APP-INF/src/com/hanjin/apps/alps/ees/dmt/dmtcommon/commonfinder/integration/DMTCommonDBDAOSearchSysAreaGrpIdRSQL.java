/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCommonDBDAOSearchSysAreaGrpIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.04.20 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchSysAreaGrpIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OFC에 해당하는 SYS_AREA_GRP_ID(SVR_ID) 를 구한다.
	  * </pre>
	  */
	public DMTCommonDBDAOSearchSysAreaGrpIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchSysAreaGrpIdRSQL").append("\n"); 
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
		query.append("SELECT SYS_AREA_GRP_ID SVR_ID" ).append("\n"); 
		query.append("FROM   COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE  CNT_CD = (SELECT CNT_CD" ).append("\n"); 
		query.append("        FROM   MDM_LOCATION" ).append("\n"); 
		query.append("        WHERE  LOC_CD = (SELECT LOC_CD" ).append("\n"); 
		query.append("                FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("                WHERE  OFC_CD = SUBSTR(@[ofc_cd], 0, 5)))" ).append("\n"); 
		query.append("AND    CO_IND_CD = 'H'" ).append("\n"); 

	}
}