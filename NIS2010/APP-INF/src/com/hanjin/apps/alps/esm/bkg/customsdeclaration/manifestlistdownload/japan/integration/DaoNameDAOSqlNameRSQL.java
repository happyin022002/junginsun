/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DaoNameDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOSqlNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ddd
	  * </pre>
	  */
	public DaoNameDAOSqlNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : DaoNameDAOSqlNameRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("	'' mf_Rmk," ).append("\n"); 
		query.append("	'' lodg_Wgt," ).append("\n"); 
		query.append("	'' etb_Dt2," ).append("\n"); 
		query.append("	'' eta_Dt2," ).append("\n"); 
		query.append("	'' etb_Dt1," ).append("\n"); 
		query.append("	'' cstms_Mf_Cd," ).append("\n"); 
		query.append("	'' arr_Yd_Cd," ).append("\n"); 
		query.append("	'' in_Vvd_Cd," ).append("\n"); 
		query.append("	'' eta_Dt1," ).append("\n"); 
		query.append("	'' in_Pod_Cd," ).append("\n"); 
		query.append("	'' in_Pod_cd_split" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}