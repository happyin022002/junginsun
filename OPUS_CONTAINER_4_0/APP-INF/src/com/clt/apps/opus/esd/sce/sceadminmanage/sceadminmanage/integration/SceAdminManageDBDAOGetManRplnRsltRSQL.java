/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SceAdminManageDBDAOGetManRplnRsltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.03
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.01.03 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOGetManRplnRsltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cop replan tab 관련 table vo 항목 조회
	  * </pre>
	  */
	public SceAdminManageDBDAOGetManRplnRsltRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration ").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOGetManRplnRsltRSQL").append("\n"); 
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