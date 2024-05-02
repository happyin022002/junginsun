/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMChinaOfficeInfoDBDAOGetVendorFromIBChinaInfoForLaneInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.15 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMChinaOfficeInfoDBDAOGetVendorFromIBChinaInfoForLaneInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ACMChinaOfficeInfoDBDAOGetVendorFromIBChinaInfoForLaneInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.integration").append("\n"); 
		query.append("FileName : ACMChinaOfficeInfoDBDAOGetVendorFromIBChinaInfoForLaneInfoRSQL").append("\n"); 
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
		query.append("SELECT AGN_CD," ).append("\n"); 
		query.append("       VNDR_SEQ" ).append("\n"); 
		query.append("  FROM ACM_AGN_SET_NRTH_CHN_LANE" ).append("\n"); 
		query.append(" WHERE AGN_CD = @[agn_cd]" ).append("\n"); 

	}
}