/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchBkgCopManageVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.15 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchBkgCopManageVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgCopManageVO 생성
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchBkgCopManageVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchBkgCopManageVORSQL").append("\n"); 
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
		query.append("'' as cop_bnd_cd," ).append("\n"); 
		query.append("'' as pctl_no," ).append("\n"); 
		query.append("'' as bkg_no," ).append("\n"); 
		query.append("'' as cntr_no," ).append("\n"); 
		query.append("'' as vsl_cd," ).append("\n"); 
		query.append("'' as skd_voy_no," ).append("\n"); 
		query.append("'' as skd_dir_cd," ).append("\n"); 
		query.append("'' as cop_no," ).append("\n"); 
		query.append("'' as fm_cop_no," ).append("\n"); 
		query.append("'' as to_cop_no," ).append("\n"); 
		query.append("'' as fm_bkg_no," ).append("\n"); 
		query.append("'' as to_bkg_no," ).append("\n"); 
		query.append("'' as tro_seq," ).append("\n"); 
		query.append("'' as tro_sub_seq," ).append("\n"); 
		query.append("'' as tro_bnd_cd," ).append("\n"); 
		query.append("'' as conti_cd," ).append("\n"); 
		query.append("'' as flg_partial," ).append("\n"); 
		query.append("'' as cntr_tpsz_cd," ).append("\n"); 
		query.append("'' as fm_dt," ).append("\n"); 
		query.append("'' as to_dt," ).append("\n"); 
		query.append("'' as tgt_bkg_nos" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}