/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DMTCommonDBDAOSearchUserSysAreaGrpIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.04 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimTaeKyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchUserSysAreaGrpIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ofc_cd로  sys_area_grp_id 조회 하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOSearchUserSysAreaGrpIdRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchUserSysAreaGrpIdRSQL").append("\n"); 
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
		query.append("SELECT	B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM	MDM_COUNTRY A" ).append("\n"); 
		query.append("	,	COM_SYS_AREA_GRP_ID B" ).append("\n"); 
		query.append("WHERE	A.CNT_CD 	= (SELECT SUBSTR(LOC_CD,0,2) " ).append("\n"); 
		query.append("                       FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                       WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("AND A.CNT_CD 	= B.CNT_CD" ).append("\n"); 
		query.append("AND B.CO_IND_CD = 'H'" ).append("\n"); 

	}
}