/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SurplusAreaDBDAOCheckPortSurplusAreaAuthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurplusAreaDBDAOCheckPortSurplusAreaAuthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surplus Area - Port 의 수정권한을 체크한다.
	  * - CHM-201428796, SELCTY --> SELCOE 로 변경, 신용찬
	  * - CHM-201537079, 2015-08-10, 신용찬, 표준코드 변환
	  * </pre>
	  */
	public SurplusAreaDBDAOCheckPortSurplusAreaAuthRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.integration").append("\n"); 
		query.append("FileName : SurplusAreaDBDAOCheckPortSurplusAreaAuthRSQL").append("\n"); 
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
		query.append("SELECT CASE " ).append("\n"); 
		query.append("       WHEN EXISTS ( SELECT OFC_CD" ).append("\n"); 
		query.append("                     FROM   MDM_ORGANIZATION M" ).append("\n"); 
		query.append("                     WHERE  1 = 1" ).append("\n"); 
		query.append("                     AND    M.OFC_CD = UPPER(TRIM(@[ofc_cd]))  " ).append("\n"); 
		query.append("                     --AND    OFC_CD IN ('SELCOE','NYCNSG','NYCNOG','ATLSC','PHXSC','HAMUOG','SINWOG','PKGSC')  " ).append("\n"); 
		query.append("                     AND    OFC_CD IN ('SELCTY','NYCRAS','NYCRAO','ATLSA','PHXSA','HAMRUO','SINRSO','PKGSA')   " ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("       THEN 'Y'" ).append("\n"); 
		query.append("       ELSE 'N'" ).append("\n"); 
		query.append("       END  AUTH_CHK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}