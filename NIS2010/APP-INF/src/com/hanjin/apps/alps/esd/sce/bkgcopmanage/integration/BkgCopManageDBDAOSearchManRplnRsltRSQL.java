/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchManRplnRsltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.11
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.10.11 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchManRplnRsltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * manual replan 결과를 취합
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchManRplnRsltRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchManRplnRsltRSQL").append("\n"); 
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
		query.append("'' as bkg_info," ).append("\n"); 
		query.append("'' as regen_pc," ).append("\n"); 
		query.append("'' as by_preset," ).append("\n"); 
		query.append("'' as cop_no," ).append("\n"); 
		query.append("'' as bkg_no," ).append("\n"); 
		query.append("'' as cntr_no," ).append("\n"); 
		query.append("'' as mst_cop_no," ).append("\n"); 
		query.append("'' as pctl_no," ).append("\n"); 
		query.append("'' as rpln_rslt" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}