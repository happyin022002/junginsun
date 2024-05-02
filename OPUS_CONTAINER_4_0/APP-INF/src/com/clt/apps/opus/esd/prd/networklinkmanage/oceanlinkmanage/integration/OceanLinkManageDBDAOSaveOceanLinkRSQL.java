/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanLinkManageDBDAOSaveOceanLinkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.15 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkManageDBDAOSaveOceanLinkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SaveOceanLink
	  * </pre>
	  */
	public OceanLinkManageDBDAOSaveOceanLinkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration ").append("\n"); 
		query.append("FileName : OceanLinkManageDBDAOSaveOceanLinkRSQL").append("\n"); 
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
		query.append("'' cre_ofc_cd" ).append("\n"); 
		query.append(",'' cre_usr_id" ).append("\n"); 
		query.append(",'' upd_usr_id" ).append("\n"); 
		query.append(",'' delcombo" ).append("\n"); 
		query.append(",'' rseq" ).append("\n"); 
		query.append(",'' lanecd" ).append("\n"); 
		query.append(",'' dircd" ).append("\n"); 
		query.append(",'' polprot" ).append("\n"); 
		query.append(",'' poletb" ).append("\n"); 
		query.append(",'' poletd" ).append("\n"); 
		query.append(",'' podprot" ).append("\n"); 
		query.append(",'' podetb" ).append("\n"); 
		query.append(",'' podetd" ).append("\n"); 
		query.append(",'' fmt_tztm_hrs" ).append("\n"); 
		query.append(",'' remark" ).append("\n"); 
		query.append(",'' ocn_lnk_mnl_flg" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("dual" ).append("\n"); 

	}
}