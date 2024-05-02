/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchExpMapgOfcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.11.05 이중환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOSearchExpMapgOfcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select mapgofcList
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchExpMapgOfcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchExpMapgOfcListRSQL").append("\n"); 
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
		query.append("select OFC_CD f_ofc_cd, MAPG_OFC_CD f_mapg_ofc_cd, MAPG_OFC_ENG_NM f_mapg_ofc_nm, LOC_CD f_loc_cd, CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT,'YYYY/MM/DD HH24:MI:SS') CRE_DT, DELT_FLG" ).append("\n"); 
		query.append("FROM SCE_EXPT_OFC_MAPG_INFO" ).append("\n"); 
		query.append("WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("ORDER BY OFC_CLSS_ID" ).append("\n"); 

	}
}