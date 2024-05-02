/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOSearchCanalAgencyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.03.21 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMasterDataDBDAOSearchCanalAgencyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCanalAgencyList
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOSearchCanalAgencyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOSearchCanalAgencyListRSQL").append("\n"); 
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
		query.append("SELECT	TO_CHAR(VNDR_SEQ, '000000') AS VNDR_SEQ" ).append("\n"); 
		query.append("		, VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("		, VNDR_ABBR_NM" ).append("\n"); 
		query.append("FROM	MDM_VENDOR" ).append("\n"); 
		query.append("WHERE	DELT_FLG	= 'N'  -- DELETE 되지 않은 VENDOR CODE" ).append("\n"); 
		query.append("AND		CNL_AGN_FLG	= 'Y'  -- 운하 대리점인 VENDOR CODE" ).append("\n"); 

	}
}