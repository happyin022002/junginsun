/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOGemOfficeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.01 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.integration.DAO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOGemOfficeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GemOfficeVO 관련VO 조회
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOGemOfficeVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("OFC_CD" ).append("\n"); 
		query.append(",	OFC_ENG_NM" ).append("\n"); 
		query.append(",	OFC_KRN_NM" ).append("\n"); 
		query.append(",	CTR_CD" ).append("\n"); 
		query.append(",	AP_CTRL_OFC_CD" ).append("\n"); 
		query.append(",	LOCL_CURR_CD" ).append("\n"); 
		query.append(",	RQST_UT_VAL" ).append("\n"); 
		query.append(",	GEN_EXPN_OFC_LVL" ).append("\n"); 
		query.append(",	PRNT_OFC_CD" ).append("\n"); 
		query.append(",	OFC_CO_DIV_CD" ).append("\n"); 
		query.append(",	RGN_OFC_FLG" ).append("\n"); 
		query.append(",	SLS_OFC_FLG" ).append("\n"); 
		query.append(",	RQST_AUTH_FLG" ).append("\n"); 
		query.append(",	RHQ_AUTH_FLG" ).append("\n"); 
		query.append(",	TIC_AUTH_FLG" ).append("\n"); 
		query.append(",	CMIT_AUTH_FLG" ).append("\n"); 
		query.append(",	EXPN_SMRY_OFC_CD" ).append("\n"); 
		query.append(",	EXPN_SMRY_YRMON" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(", 	'' OFC_HIS_CNT" ).append("\n"); 
		query.append("FROM GEM_OFFICE" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOGemOfficeVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}