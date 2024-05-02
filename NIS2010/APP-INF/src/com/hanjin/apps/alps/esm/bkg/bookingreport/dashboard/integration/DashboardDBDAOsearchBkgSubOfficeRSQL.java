/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardDBDAOsearchBkgSubOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DashboardDBDAOsearchBkgSubOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG OFFICE의 SUB Office 조회
	  * </pre>
	  */
	public DashboardDBDAOsearchBkgSubOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOsearchBkgSubOfficeRSQL").append("\n"); 
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
		query.append("''''||BKG_JOIN_FNC( cursor(SELECT OFC_CD FROM   BKG_OFC_LVL_V" ).append("\n"); 
		query.append("           WHERE @[bkg_ofc_cd] IN (OFC_CD ,OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD, OFC_N5TH_LVL_CD,OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD) )" ).append("\n"); 
		query.append("        ,''',''')||'''' AS B_OFC_CD_SUB" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}