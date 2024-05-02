/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PerformanceReportDBDAOsearchFrontOfficeFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.21
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.12.21 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOsearchFrontOfficeFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 BKG이 Front Office Type으로 접수된 적이 있는지 조회한다.
	  * </pre>
	  */
	public PerformanceReportDBDAOsearchFrontOfficeFlagRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOsearchFrontOfficeFlagRSQL").append("\n"); 
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
		query.append("SELECT NVL(BL_FNT_OFC_FLG,'N') BL_FNT_OFC_FLG" ).append("\n"); 
		query.append("  FROM BKG_SR_CRNT_RQST R" ).append("\n"); 
		query.append(" WHERE R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND R.SR_AMD_SEQ = (SELECT MAX(SR_AMD_SEQ)" ).append("\n"); 
		query.append("                         FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                        WHERE BKG_NO = R.BKG_NO)" ).append("\n"); 

	}
}