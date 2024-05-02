/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SceAdminManageDBDAOGetSceAdminObjRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.01.04 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOGetSceAdminObjRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESD_SCE_6000 에서 사용할 검색조건 용 VO 를 생성한다
	  * </pre>
	  */
	public SceAdminManageDBDAOGetSceAdminObjRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOGetSceAdminObjRSQL").append("\n"); 
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
		query.append("'' as tml_fm_dt," ).append("\n"); 
		query.append("'' as tml_to_dt," ).append("\n"); 
		query.append("'' as rpln_fm_dt," ).append("\n"); 
		query.append("'' as rpln_to_dt," ).append("\n"); 
		query.append("'' as mst_fm_dt," ).append("\n"); 
		query.append("'' as mst_to_dt," ).append("\n"); 
		query.append("'' as rpln_bkg_no," ).append("\n"); 
		query.append("'' as rpln_bl_no," ).append("\n"); 
		query.append("'' as rpln_cntr_no," ).append("\n"); 
		query.append("'' as rpln_cop_no," ).append("\n"); 
		query.append("'' as cdiff_bkg_no," ).append("\n"); 
		query.append("'' as cdiff_bl_no," ).append("\n"); 
		query.append("'' as cdiff_cop_no," ).append("\n"); 
		query.append("'' as cdiff_fm_dt," ).append("\n"); 
		query.append("'' as cdiff_to_dt," ).append("\n"); 
		query.append("'' as act_fm_dt," ).append("\n"); 
		query.append("'' as act_to_dt," ).append("\n"); 
		query.append("'' as act_bkg_no," ).append("\n"); 
		query.append("'' as act_cntr_no," ).append("\n"); 
		query.append("'' as act_bl_no," ).append("\n"); 
		query.append("'' as act_cop_no," ).append("\n"); 
		query.append("'' as act_umch_tp_cd," ).append("\n"); 
		query.append("'' as act_rcv_tp_cd" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("dual" ).append("\n"); 

	}
}