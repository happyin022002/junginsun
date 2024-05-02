/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsCommonMgtDBDAOCstmsPckTpConvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsCommonMgtDBDAOCstmsPckTpConvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CstmsPckTpConv
	  * </pre>
	  */
	public CustomsCommonMgtDBDAOCstmsPckTpConvRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo").append("\n"); 
		query.append("FileName : CustomsCommonMgtDBDAOCstmsPckTpConvRSQL").append("\n"); 
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
		query.append("       '' pck_tp_cd," ).append("\n"); 
		query.append("       '' cstms_pck_tp_cd," ).append("\n"); 
		query.append("       '' pck_cd_desc," ).append("\n"); 
		query.append("	   '' cre_usr_id," ).append("\n"); 
		query.append("	   '' cre_dt," ).append("\n"); 
		query.append("	   '' upd_usr_id," ).append("\n"); 
		query.append("	   '' upd_dt," ).append("\n"); 
		query.append("	   '' user_id," ).append("\n"); 
		query.append("	   '' frm_cnt_cd," ).append("\n"); 
		query.append("	   '' frm_pck_tp_cd," ).append("\n"); 
		query.append("	   '' frm_cstms_pck_tp_cd," ).append("\n"); 
		query.append("	   '' chk_cnt_cd," ).append("\n"); 
		query.append("	   '' chk_pck_tp_cd," ).append("\n"); 
		query.append("	   '' chk_cstms_pck_tp_cd" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}