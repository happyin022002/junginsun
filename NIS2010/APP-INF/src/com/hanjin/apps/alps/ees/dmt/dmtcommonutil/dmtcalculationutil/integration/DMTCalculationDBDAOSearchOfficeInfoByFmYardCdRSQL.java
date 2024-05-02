/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchOfficeInfoByFmYardCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.20
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.09.20 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchOfficeInfoByFmYardCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfficeInfoByFmYardCd
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchOfficeInfoByFmYardCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchOfficeInfoByFmYardCdRSQL").append("\n"); 
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
		query.append("SELECT YY.DMDT_OFC_CD       OFC_CD" ).append("\n"); 
		query.append("#if ( ${io_bnd} == 'I') " ).append("\n"); 
		query.append("	  ,YY.DEM_IB_CLT_FLG 	COLLECT_YN" ).append("\n"); 
		query.append("#elseif (${io_bnd} == 'O')" ).append("\n"); 
		query.append("	  ,YY.DEM_OB_CLT_FLG 	COLLECT_YN" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,''	COLLECT_YN" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,OV.OFC_N3RD_LVL_CD   OFC_RHQ" ).append("\n"); 
		query.append("  FROM MDM_YARD YY" ).append("\n"); 
		query.append("      ,DMT_OFC_LVL_V OV" ).append("\n"); 
		query.append(" WHERE YY.YD_CD = @[fm_yd_cd] " ).append("\n"); 
		query.append("   AND YY.DMDT_OFC_CD = OV.OFC_N8TH_LVL_CD(+)" ).append("\n"); 

	}
}