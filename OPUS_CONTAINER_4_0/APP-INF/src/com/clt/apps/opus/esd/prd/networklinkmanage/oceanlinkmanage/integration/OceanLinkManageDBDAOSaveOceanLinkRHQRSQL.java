/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanLinkManageDBDAOSaveOceanLinkRHQRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.17 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkManageDBDAOSaveOceanLinkRHQRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SaveOceanLinkRHQ
	  * </pre>
	  */
	public OceanLinkManageDBDAOSaveOceanLinkRHQRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration").append("\n"); 
		query.append("FileName : OceanLinkManageDBDAOSaveOceanLinkRHQRSQL").append("\n"); 
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
		query.append("'' s_lane" ).append("\n"); 
		query.append(",'' s_from" ).append("\n"); 
		query.append(",'' s_to" ).append("\n"); 
		query.append(",'' s_t_time" ).append("\n"); 
		query.append(",'' s_fqc" ).append("\n"); 
		query.append(",'' s_bd" ).append("\n"); 
		query.append(",'' s_dr" ).append("\n"); 
		query.append(",'' s_sp_bd" ).append("\n"); 
		query.append(",'' s_sp_bd_name" ).append("\n"); 
		query.append(",'' s_sn" ).append("\n"); 
		query.append(",'' s_mn" ).append("\n"); 
		query.append(",'' s_te" ).append("\n"); 
		query.append(",'' s_wb" ).append("\n"); 
		query.append(",'' s_tu" ).append("\n"); 
		query.append(",'' s_fi" ).append("\n"); 
		query.append(",'' s_st" ).append("\n"); 
		query.append(",'' h_chk_lane_dir_tztm" ).append("\n"); 
		query.append(",'' cre_ofc_cd" ).append("\n"); 
		query.append(",'' cre_usr_id" ).append("\n"); 
		query.append(",'' upd_usr_id" ).append("\n"); 
		query.append(",'' h_lane" ).append("\n"); 
		query.append(",'' h_from" ).append("\n"); 
		query.append(",'' h_to" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}