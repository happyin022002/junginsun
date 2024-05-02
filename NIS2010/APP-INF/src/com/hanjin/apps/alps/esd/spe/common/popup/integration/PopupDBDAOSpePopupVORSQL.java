/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PopupDBDAOSpePopupVORSQL.java
*@FileTitle : Evaluator Inquiry Choice
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.04 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.popup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PopupDBDAOSpePopupVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 팝업에서 사용되는 VO 생성
	  * </pre>
	  */
	public PopupDBDAOSpePopupVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.common.popup.integration").append("\n"); 
		query.append("FileName : PopupDBDAOSpePopupVORSQL").append("\n"); 
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
		query.append(" '' AS EV_SVC_CATE_CD" ).append("\n"); 
		query.append(",'' AS CNT_CD" ).append("\n"); 
		query.append(",'' AS OFC_CD" ).append("\n"); 
		query.append(",'' AS EG_OFC_CD" ).append("\n"); 
		query.append(",'' AS SLEVEL" ).append("\n"); 
		query.append(",'' AS EFPT_OFC_CD" ).append("\n"); 
		query.append(",'' AS VNDR_NM_ENG" ).append("\n"); 
		query.append(",'' AS PTS_VNDR_CD" ).append("\n"); 
		query.append(",'' AS VNDR_CD" ).append("\n"); 
		query.append(",'' AS LGS_FLG" ).append("\n"); 
		query.append(",'' AS VNDR_SEQ" ).append("\n"); 
		query.append(",'' AS OFC_CD" ).append("\n"); 
		query.append(",'' AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",'' AS VNDR_ABBR_NM" ).append("\n"); 
		query.append(",'' AS PRNT_VNDR_SEQ" ).append("\n"); 
		query.append(",'' AS VNDR_CNT_CD" ).append("\n"); 
		query.append(",'' AS ORG_VNDR_SEQ" ).append("\n"); 
		query.append(",'' AS ENG_ADDR" ).append("\n"); 
		query.append(",'' AS EG_ID" ).append("\n"); 
		query.append(",'' AS EG_NM" ).append("\n"); 
		query.append(",'' AS SEARCH_TYPE" ).append("\n"); 
		query.append(",'' AS S_EG_RHQ_CD" ).append("\n"); 
		query.append(",'' AS S_EG_OFC_CD" ).append("\n"); 
		query.append(",'' AS S_EV_SVC_CATE_CD" ).append("\n"); 
		query.append(",'' AS S_EV_YR" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}