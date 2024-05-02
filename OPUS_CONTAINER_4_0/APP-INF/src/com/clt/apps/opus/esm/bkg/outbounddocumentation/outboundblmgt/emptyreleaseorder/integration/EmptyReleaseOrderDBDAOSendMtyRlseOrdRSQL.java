/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOSendMtyRlseOrdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseOrderDBDAOSendMtyRlseOrdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOSendMtyRlseOrdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration").append("\n"); 
		query.append("FileName : EmptyReleaseOrderDBDAOSendMtyRlseOrdRSQL").append("\n"); 
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
		query.append("select '' sys_cd," ).append("\n"); 
		query.append("'' tmpl_mrd," ).append("\n"); 
		query.append("'' office," ).append("\n"); 
		query.append("'' batch_flg," ).append("\n"); 
		query.append("'' title," ).append("\n"); 
		query.append("'' rcv_info," ).append("\n"); 
		query.append("'' tmpl_param," ).append("\n"); 
		query.append("'' crt_user_id," ).append("\n"); 
		query.append("'' contents," ).append("\n"); 
		query.append("'' snd_nm," ).append("\n"); 
		query.append("'' snd_eml," ).append("\n"); 
		query.append("'' rcv_eml," ).append("\n"); 
		query.append("'' bkg_no," ).append("\n"); 
		query.append("'' ntc_fax_no," ).append("\n"); 
		query.append("'' ntc_eml," ).append("\n"); 
		query.append("'' diff_rmk," ).append("\n"); 
		query.append("'' yard," ).append("\n"); 
		query.append("'' yard_type" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}