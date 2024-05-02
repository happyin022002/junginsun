/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LocationDBDAOLocationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOLocationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public LocationDBDAOLocationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOLocationVORSQL").append("\n"); 
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
		query.append("SELECT 'LOC_CD' LOC_CD" ).append("\n"); 
		query.append("	, 'LOC_NM' LOC_NM" ).append("\n"); 
		query.append("	, 'LOC_LOCL_LANG_NM' LOC_LOCL_LANG_NM" ).append("\n"); 
		query.append("	, 'LOC_CHR_CD' LOC_CHR_CD" ).append("\n"); 
		query.append("	, 'CALL_PORT_FLG' CALL_PORT_FLG" ).append("\n"); 
		query.append("	, 'PORT_INLND_CD' PORT_INLND_CD" ).append("\n"); 
		query.append("	, 'LOC_TP_CD' LOC_TP_CD" ).append("\n"); 
		query.append("	, 'CONTI_CD' CONTI_CD" ).append("\n"); 
		query.append("	, 'SCONTI_CD' SCONTI_CD" ).append("\n"); 
		query.append("	, 'CNT_CD' CNT_CD" ).append("\n"); 
		query.append("	, 'RGN_CD' RGN_CD" ).append("\n"); 
		query.append("	, 'STE_CD' STE_CD" ).append("\n"); 
		query.append("	, 'SCC_CD' SCC_CD" ).append("\n"); 
		query.append("	, 'REP_ZN_CD' REP_ZN_CD" ).append("\n"); 
		query.append("	, 'UN_LOC_IND_CD' UN_LOC_IND_CD" ).append("\n"); 
		query.append("	, 'UN_LOC_CD' UN_LOC_CD" ).append("\n"); 
		query.append("	, 'SLS_OFC_CD' SLS_OFC_CD" ).append("\n"); 
		query.append("	, 'EQ_CTRL_OFC_CD' EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("	, 'FINC_CTRL_OFC_CD' FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("	, 'MTY_PKUP_YD_CD' MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("	, 'EQ_RTN_YD_CD' EQ_RTN_YD_CD" ).append("\n"); 
		query.append("	, 'BKG_BL_PFX_CD' BKG_BL_PFX_CD" ).append("\n"); 
		query.append("	, 'HUB_LOC_CD' HUB_LOC_CD" ).append("\n"); 
		query.append("	, 'LOC_GRD_NO' LOC_GRD_NO" ).append("\n"); 
		query.append("	, 'ZIP_CD' ZIP_CD" ).append("\n"); 
		query.append("	, 'GMT_HRS' GMT_HRS" ).append("\n"); 
		query.append("	, 'LOC_AMS_PORT_CD' LOC_AMS_PORT_CD" ).append("\n"); 
		query.append("	, 'CSTMS_CD' CSTMS_CD" ).append("\n"); 
		query.append("	, 'CML_ZN_FLG' CML_ZN_FLG" ).append("\n"); 
		query.append("	, 'LOC_LAT' LOC_LAT" ).append("\n"); 
		query.append("	, 'LAT_UT_CD' LAT_UT_CD" ).append("\n"); 
		query.append("	, 'LOC_LON' LOC_LON" ).append("\n"); 
		query.append("	, 'LON_UT_CD' LON_UT_CD" ).append("\n"); 
		query.append("	, 'DELT_FLG' DELT_FLG" ).append("\n"); 
		query.append("	, 'USR_ID' USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}