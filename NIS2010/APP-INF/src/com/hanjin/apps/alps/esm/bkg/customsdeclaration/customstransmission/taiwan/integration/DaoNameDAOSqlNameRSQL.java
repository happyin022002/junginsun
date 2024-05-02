/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.22 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
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
	  * select
	  * </pre>
	  */
	public DaoNameDAOSqlNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.integration ").append("\n"); 
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
		query.append("'' bl_no," ).append("\n"); 
		query.append("'' vsl_cd," ).append("\n"); 
		query.append("'' skd_voy_no," ).append("\n"); 
		query.append("'' skd_dir_cd," ).append("\n"); 
		query.append("'' user_id," ).append("\n"); 
		query.append("'' ofc_cd," ).append("\n"); 
		query.append("'' pol_cd," ).append("\n"); 
		query.append("'' pod_cd," ).append("\n"); 
		query.append("'' bkg_no," ).append("\n"); 
		query.append("'' amend_bl," ).append("\n"); 
		query.append("'' bkg_qty," ).append("\n"); 
		query.append("'' cntr_no," ).append("\n"); 
		query.append("'' bkgcgotp," ).append("\n"); 
		query.append("'' bkgSpeRf," ).append("\n"); 
		query.append("'' bkgSpeDg," ).append("\n"); 
		query.append("'' bkgSpeAk," ).append("\n"); 
		query.append("'' bkgSpeBb," ).append("\n"); 
		query.append("'' cmdtDesc," ).append("\n"); 
		query.append("'' cmdtCd," ).append("\n"); 
		query.append("'' bkgSpeRd," ).append("\n"); 
		query.append("'' amend_vvd," ).append("\n"); 
		query.append("'' st_9," ).append("\n"); 
		query.append("'' st_10," ).append("\n"); 
		query.append("'' tmpstr4," ).append("\n"); 
		query.append("'' tmpstr5," ).append("\n"); 
		query.append("'' tmpstr7," ).append("\n"); 
		query.append("'' tmpstr8," ).append("\n"); 
		query.append("'' tmpstr9" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}