/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : oMakeDAOSearchChassisCostVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.12.03 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class oMakeDAOSearchChassisCostVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public oMakeDAOSearchChassisCostVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo").append("\n"); 
		query.append("FileName : oMakeDAOSearchChassisCostVORSQL").append("\n"); 
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
		query.append("      	'' AS ON_CHSS_AMT,                  " ).append("\n"); 
		query.append("		'' AS MIG_AMT,                      " ).append("\n"); 
		query.append("		'' AS TO_YEAR,                      " ).append("\n"); 
		query.append("		'' AS COST_TP_NM,                   " ).append("\n"); 
		query.append("		'' AS COST_YR_QTR,                  " ).append("\n"); 
		query.append("		'' AS REV_SHR_AMT,                  " ).append("\n"); 
		query.append("		'' AS COST_TP_CD,                  " ).append("\n"); 
		query.append("		'' AS COST_TP_BX_RT,                " ).append("\n"); 
		query.append("		'' AS COST_QTR_CD,                  " ).append("\n"); 
		query.append("		'' AS EFF_TO_YRMON,                 " ).append("\n"); 
		query.append("		'' AS CNT_CD,                       " ).append("\n"); 
		query.append("		'' AS STND_UT_COST,                 " ).append("\n"); 
		query.append("		'' AS BKG_BX_QTY,                   " ).append("\n"); 
		query.append("		'' AS ON_ST_UT_COST,                " ).append("\n"); 
		query.append("		'' AS UPD_USR_ID,                   " ).append("\n"); 
		query.append("		'' AS COM_UT_COST,                  " ).append("\n"); 
		query.append("		'' AS EFF_FM_YRMON,                 " ).append("\n"); 
		query.append("		'' AS MISC_RE_BIL_AMT,              " ).append("\n"); 
		query.append("		'' AS ON_ST_AMT,                    " ).append("\n"); 
		query.append("		'' AS FR_YEAR,                      " ).append("\n"); 
		query.append("		'' AS COM_TTL_AMT,                  " ).append("\n"); 
		query.append("		'' AS ESTM_AMT,                     " ).append("\n"); 
		query.append("		'' AS COM_SUB_TTL,                  " ).append("\n"); 
		query.append("		'' AS ON_TML_AMT,                   " ).append("\n"); 
		query.append("		'' AS CHSS_DRYG_AMT,                " ).append("\n"); 
		query.append("		'' AS FR_QTR,                       " ).append("\n"); 
		query.append("		'' AS TO_QTR,                       " ).append("\n"); 
		query.append("		'' AS COM_SUB_TTL_AMT,              " ).append("\n"); 
		query.append("		'' AS COST_YR,                      " ).append("\n"); 
		query.append("		'' AS CHSS_RMK,                     " ).append("\n"); 
		query.append("		'' AS CR_MM_AMT,            " ).append("\n"); 
		query.append("		'' AS DEL_CHK," ).append("\n"); 
		query.append("		'' AS ERR_CD," ).append("\n"); 
		query.append("		'' AS ERR_MSG    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}