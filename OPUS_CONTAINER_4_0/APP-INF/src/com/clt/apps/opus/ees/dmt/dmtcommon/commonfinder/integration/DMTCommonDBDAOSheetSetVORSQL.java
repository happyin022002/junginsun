/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOSheetSetVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSheetSetVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sheet Set 이 있는지 없는지 확인하기 위해서 사용하는 파라미터를 저장할 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOSheetSetVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.dmtcommonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSheetSetVORSQL").append("\n"); 
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
		query.append("SELECT	OFC_CD" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	DMDT_SH_TP_CD" ).append("\n"); 
		query.append("FROM	DMT_SH_SET" ).append("\n"); 

	}
}