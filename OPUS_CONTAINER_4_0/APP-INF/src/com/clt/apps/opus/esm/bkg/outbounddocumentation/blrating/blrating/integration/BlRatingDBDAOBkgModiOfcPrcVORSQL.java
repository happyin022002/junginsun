/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOBkgModiOfcPrcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOBkgModiOfcPrcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgModiOfcPrcVO
	  * 2010.11.22 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
	  * </pre>
	  */
	public BlRatingDBDAOBkgModiOfcPrcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOBkgModiOfcPrcVORSQL").append("\n"); 
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
		query.append("SELECT '' AS IN_BKG_NO" ).append("\n"); 
		query.append("      ,'' AS IN_CA_FLG" ).append("\n"); 
		query.append("      ,'' AS IN_PPD_FLG" ).append("\n"); 
		query.append("      ,'' AS IN_CCT_FLG" ).append("\n"); 
		query.append("      ,'' AS OUT_RESULT" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}