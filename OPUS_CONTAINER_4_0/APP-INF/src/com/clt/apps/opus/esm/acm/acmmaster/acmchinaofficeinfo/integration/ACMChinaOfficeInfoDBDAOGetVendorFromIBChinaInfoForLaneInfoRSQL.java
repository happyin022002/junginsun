/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ACMChinaOfficeInfoDBDAOGetVendorFromIBChinaInfoForLaneInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.integration").append("\n"); 
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
		query.append("  AND DELT_FLG <> 'Y'" ).append("\n"); 

	}
}