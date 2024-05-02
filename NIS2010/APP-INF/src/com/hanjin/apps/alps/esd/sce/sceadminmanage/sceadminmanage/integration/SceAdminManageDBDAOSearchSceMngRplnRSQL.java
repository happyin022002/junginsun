/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SceAdminManageDBDAOSearchSceMngRplnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOSearchSceMngRplnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert후 SCE_MNG_RPLN Table을 조회한다.
	  * </pre>
	  */
	public SceAdminManageDBDAOSearchSceMngRplnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOSearchSceMngRplnRSQL").append("\n"); 
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
		query.append("COP_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",COA_IF_FLG" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",RPLN_SCS_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",RPLN_JB_TP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_MNL_RPLN A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("COA_IF_FLG = 'Y'" ).append("\n"); 
		query.append("AND CRE_USR_ID = 'LEAACCT'" ).append("\n"); 

	}
}