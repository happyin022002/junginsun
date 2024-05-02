/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetChgInfo2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.10 
* 1.0 Creation
* 
* 2014.04.10 박다은 [CHM-201429712] FRT_INCL_XCLD_DIV_CD 로직 추가 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetChgInfo2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetChgInfo2
	  * 2014.04.10 박다은 [CHM-201429712] FRT_INCL_XCLD_DIV_CD 로직 추가 추가 요청
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetChgInfo2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOGetChgInfo2RSQL").append("\n"); 
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
		query.append("    SUM(HO) AS HO," ).append("\n"); 
		query.append("    SUM(HD) AS HD," ).append("\n"); 
		query.append("    SUM(FO) AS FO," ).append("\n"); 
		query.append("    SUM(FD) AS FD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           CASE WHEN A.CHG_CD = 'OIH' THEN 1 ELSE 0 END  AS HO," ).append("\n"); 
		query.append("           CASE WHEN A.CHG_CD = 'DIH' THEN 1 ELSE 0 END  AS HD," ).append("\n"); 
		query.append("           CASE WHEN A.CHG_CD = 'OAR' THEN 1 ELSE 0 END  AS FO," ).append("\n"); 
		query.append("           CASE WHEN A.CHG_CD = 'DAR' THEN 1 ELSE 0 END  AS FD" ).append("\n"); 
		query.append("      FROM BKG_CHG_RT A" ).append("\n"); 
		query.append("     WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND A.CHG_CD IN ( 'OIH' , 'DIH' , 'OAR', 'DAR' )" ).append("\n"); 
		query.append("       AND A.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}