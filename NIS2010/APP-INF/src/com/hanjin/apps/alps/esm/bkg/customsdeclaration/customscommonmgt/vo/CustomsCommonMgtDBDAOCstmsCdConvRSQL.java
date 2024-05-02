/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomsCommonMgtDBDAOCstmsCdConvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.integration.DAO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsCommonMgtDBDAOCstmsCdConvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CstmsCdConv
	  * </pre>
	  */
	public CustomsCommonMgtDBDAOCstmsCdConvRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo").append("\n"); 
		query.append("FileName : CustomsCommonMgtDBDAOCstmsCdConvRSQL").append("\n"); 
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
		query.append("SELECT '' cnt_cd," ).append("\n"); 
		query.append("       '' cstms_div_id," ).append("\n"); 
		query.append("       '' cstms_cd_desc," ).append("\n"); 
		query.append("       '' attr_nm1," ).append("\n"); 
		query.append("       '' attr_nm2," ).append("\n"); 
		query.append("       '' attr_nm3," ).append("\n"); 
		query.append("       '' attr_nm4," ).append("\n"); 
		query.append("       '' attr_nm5," ).append("\n"); 
		query.append("       '' cstms_div_id_seq," ).append("\n"); 
		query.append("       '' attr_ctnt1," ).append("\n"); 
		query.append("       '' attr_ctnt2," ).append("\n"); 
		query.append("       '' attr_ctnt3," ).append("\n"); 
		query.append("       '' attr_ctnt4," ).append("\n"); 
		query.append("       '' attr_ctnt5," ).append("\n"); 
		query.append("	   '' cre_usr_id," ).append("\n"); 
		query.append("	   '' cre_dt," ).append("\n"); 
		query.append("	   '' upd_usr_id," ).append("\n"); 
		query.append("	   '' upd_dt," ).append("\n"); 
		query.append("	   '' user_id," ).append("\n"); 
		query.append("	   '' frm_cnt_cd," ).append("\n"); 
		query.append("	   '' frm_cstms_div_id," ).append("\n"); 
		query.append("	   '' frm_cstms_cd_desc," ).append("\n"); 
		query.append("	   '' chk_cnt_cd," ).append("\n"); 
		query.append("	   '' chk_cstms_div_id," ).append("\n"); 
		query.append("	   '' chk_cnt" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}