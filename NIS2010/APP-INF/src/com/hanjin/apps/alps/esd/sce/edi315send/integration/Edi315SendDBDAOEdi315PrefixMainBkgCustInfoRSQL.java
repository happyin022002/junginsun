/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315PrefixMainBkgCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315PrefixMainBkgCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for subVo - BkgCustInfo
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315PrefixMainBkgCustInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315PrefixMainBkgCustInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("''shprcode," ).append("\n"); 
		query.append("''shpr1," ).append("\n"); 
		query.append("''shpr2," ).append("\n"); 
		query.append("''shpr3," ).append("\n"); 
		query.append("''shpr4," ).append("\n"); 
		query.append("''shpr5," ).append("\n"); 
		query.append("''shpr_city_nm, " ).append("\n"); 
		query.append("''shpr_stat_cd," ).append("\n"); 
		query.append("''shpr_zip_cd," ).append("\n"); 
		query.append("''shpr_cnt_cd," ).append("\n"); 
		query.append("''cneecode," ).append("\n"); 
		query.append("''cnee1," ).append("\n"); 
		query.append("''cnee2," ).append("\n"); 
		query.append("''cnee3," ).append("\n"); 
		query.append("''cnee4," ).append("\n"); 
		query.append("''cnee5," ).append("\n"); 
		query.append("''cnee_city_nm," ).append("\n"); 
		query.append("''cnee_stat_cd," ).append("\n"); 
		query.append("''cnee_zip_cd," ).append("\n"); 
		query.append("''cnee_cnt_cd," ).append("\n"); 
		query.append("''ntfycode," ).append("\n"); 
		query.append("''ntfy1," ).append("\n"); 
		query.append("''ntfy2," ).append("\n"); 
		query.append("''ntfy3," ).append("\n"); 
		query.append("''ntfy4," ).append("\n"); 
		query.append("''ntfy5," ).append("\n"); 
		query.append("''ntfy_city_nm," ).append("\n"); 
		query.append("''ntfy_stat_cd," ).append("\n"); 
		query.append("''ntfy_zip_cd," ).append("\n"); 
		query.append("''ntfy_cnt_cd," ).append("\n"); 
		query.append("''antfycode" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}