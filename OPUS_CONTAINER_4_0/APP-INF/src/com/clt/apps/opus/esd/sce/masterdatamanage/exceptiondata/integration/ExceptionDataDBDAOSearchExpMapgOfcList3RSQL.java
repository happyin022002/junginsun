/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchExpMapgOfcList3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOSearchExpMapgOfcList3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select list3
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchExpMapgOfcList3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchExpMapgOfcList3RSQL").append("\n"); 
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
		query.append("select OFC_CD f_ofc_cd, MAPG_OFC_CD f_mapg_ofc_cd, MAPG_OFC_ENG_NM f_mapg_ofc_nm, LOC_CD f_loc_cd, CRE_USR_ID, " ).append("\n"); 
		query.append("	TO_CHAR(CRE_DT,'YYYY/MM/DD HH24:MI:SS') CRE_DT, DELT_FLG" ).append("\n"); 
		query.append("FROM SCE_EXPT_OFC_MAPG_INFO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${mst_ofc_cd} != '')" ).append("\n"); 
		query.append("    WHERE OFC_CD=@[mst_ofc_cd] " ).append("\n"); 
		query.append("	AND DELT_FLG='N' 		           	" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY OFC_CLSS_ID" ).append("\n"); 

	}
}