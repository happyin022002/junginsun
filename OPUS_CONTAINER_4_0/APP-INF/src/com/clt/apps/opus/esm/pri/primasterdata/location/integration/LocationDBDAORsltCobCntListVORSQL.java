/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationDBDAORsltCobCntListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.07 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAORsltCobCntListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 국가 콤보 조회
	  * </pre>
	  */
	public LocationDBDAORsltCobCntListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAORsltCobCntListVORSQL").append("\n"); 
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
		query.append("SELECT CNT_CD CD" ).append("\n"); 
		query.append(", CNT_NM NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY CNT_CD ASC" ).append("\n"); 

	}
}