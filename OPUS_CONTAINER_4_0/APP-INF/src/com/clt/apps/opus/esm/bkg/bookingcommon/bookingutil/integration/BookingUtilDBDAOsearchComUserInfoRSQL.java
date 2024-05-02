/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOsearchComUserInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.30
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.07.30 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjeong Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchComUserInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * user id로 사용자정보 검색
	  * </pre>
	  */
	public BookingUtilDBDAOsearchComUserInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchComUserInfoRSQL").append("\n"); 
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
		query.append("SELECT USR_ID" ).append("\n"); 
		query.append("      ,USR_NM" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,USR_EML " ).append("\n"); 
		query.append("      ,DFLT_EML" ).append("\n"); 
		query.append("  FROM COM_USER" ).append("\n"); 
		query.append(" WHERE USR_ID = @[usr_id] " ).append("\n"); 
		query.append("   AND USE_FLG = 'Y'" ).append("\n"); 

	}
}