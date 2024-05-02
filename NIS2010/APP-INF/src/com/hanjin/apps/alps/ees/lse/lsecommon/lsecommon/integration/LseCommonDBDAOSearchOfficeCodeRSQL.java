/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseCommonDBDAOSearchOfficeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.11.20 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LseCommonDBDAOSearchOfficeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office 코드목록을 조회합니다.
	  * </pre>
	  */
	public LseCommonDBDAOSearchOfficeCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.integration ").append("\n"); 
		query.append("FileName : LseCommonDBDAOSearchOfficeCodeRSQL").append("\n"); 
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
		query.append("SELECT  A.OFC_CD," ).append("\n"); 
		query.append("A.OFC_ENG_NM," ).append("\n"); 
		query.append("A.OFC_KRN_NM" ).append("\n"); 
		query.append("FROM	MDM_ORGANIZATION A" ).append("\n"); 
		query.append("WHERE   A.OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}