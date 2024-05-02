/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ApplicationDateRuleDBDAORoutLocCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.05.15 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApplicationDateRuleDBDAORoutLocCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RoutLocCdVO를 생성한다.
	  * </pre>
	  */
	public ApplicationDateRuleDBDAORoutLocCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration").append("\n"); 
		query.append("FileName : ApplicationDateRuleDBDAORoutLocCdRSQL").append("\n"); 
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
		query.append("SELECT ''org_loc_cd" ).append("\n"); 
		query.append("     , ''svc_scp_cd" ).append("\n"); 
		query.append("     , ''conv_loc_cd" ).append("\n"); 
		query.append("     , ''scp_cd" ).append("\n"); 
		query.append("     , ''frm_org_loc_cd" ).append("\n"); 
		query.append("     , ''frm_conv_loc_cd" ).append("\n"); 
		query.append("     , ''chk_scp_cd" ).append("\n"); 
		query.append("     , ''chk_org_cd" ).append("\n"); 
		query.append("     , ''chk_conv_cd" ).append("\n"); 
		query.append("	 , ''chk_location" ).append("\n"); 
		query.append("	 , ''chk_flg" ).append("\n"); 
		query.append("     , ''por_appl_flg" ).append("\n"); 
		query.append("     , ''pol_appl_flg" ).append("\n"); 
		query.append("     , ''pod_appl_flg" ).append("\n"); 
		query.append("     , ''del_appl_flg" ).append("\n"); 
		query.append("     , ''pre_rly_port_appl_flg" ).append("\n"); 
		query.append("     , ''pst_rly_port_appl_flg" ).append("\n"); 
		query.append("     , ''cre_usr_id" ).append("\n"); 
		query.append("     , ''cre_dt" ).append("\n"); 
		query.append("     , ''upd_usr_id" ).append("\n"); 
		query.append("     , ''upd_dt" ).append("\n"); 
		query.append("From dual" ).append("\n"); 

	}
}