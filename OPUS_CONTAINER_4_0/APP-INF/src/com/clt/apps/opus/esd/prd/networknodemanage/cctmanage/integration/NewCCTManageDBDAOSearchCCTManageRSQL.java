/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewCCTManageDBDAOSearchCCTManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewCCTManageDBDAOSearchCCTManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCCTManage
	  * </pre>
	  */
	public NewCCTManageDBDAOSearchCCTManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration").append("\n"); 
		query.append("FileName : NewCCTManageDBDAOSearchCCTManageRSQL").append("\n"); 
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
		query.append("SELECT LOC_CD AS LOCATION_CODE " ).append("\n"); 
		query.append("     , CCT.YD_CD AS YARD_CODE " ).append("\n"); 
		query.append("     , CCT.VSL_SLAN_CD AS LANE_CODE " ).append("\n"); 
		query.append("     , CCT.VSL_SLAN_DIR_CD AS LANE_DIR_CODE " ).append("\n"); 
		query.append("     , CCT.CGO_TP_CD AS CARGO_TYPE " ).append("\n"); 
		query.append("     , CCT.CCT_TP_CD AS CCT_TYPE " ).append("\n"); 
		query.append("     , CASE WHEN CCT.CCT_TP_CD IN ('ETB', 'ETD') THEN LPAD(NVL(CCT.CCT_HR, 0), 2, '0') END CCT_HOUR " ).append("\n"); 
		query.append("     , CCT.CCT_FILE_FLG " ).append("\n"); 
		query.append("     , CCT.YD_BSE_CALC_FLG " ).append("\n"); 
		query.append("     , DECODE(CCT.CCT_DY_CD, 'CMN','OneDayBeforeETB',CCT.CCT_DY_CD) AS CCT_DAY " ).append("\n"); 
		query.append("     , CCT.CCT_HRMNT AS CCT_TIME " ).append("\n"); 
		query.append("     , '0' AS DELETE_FLAG " ).append("\n"); 
		query.append("     , DECODE(CCT.DELT_FLG,'Y','1','0') AS ORG_DELETE_FLAG " ).append("\n"); 
		query.append("     , CCT.XCLD_HOL_FRI_FLG AS FRI_FLAG " ).append("\n"); 
		query.append("     , CCT.XCLD_HOL_SAT_FLG AS SAT_FLAG " ).append("\n"); 
		query.append("     , CCT.XCLD_HOL_SUN_FLG AS SUN_FLAG " ).append("\n"); 
		query.append("     , CCT.XCLD_HOL_HOL_FLG AS HOLI_FLAG " ).append("\n"); 
		query.append("     , CCT.CCT_TP_CD AS CCT_OLD_TYPE " ).append("\n"); 
		query.append("     , CCT.VGM_CLZ_TP_CD " ).append("\n"); 
		query.append("     , CASE WHEN CCT.VGM_CLZ_TP_CD IN ('ETB', 'ETD') THEN LPAD(NVL(CCT.VGM_CLZ_HR, 0), 2, '0') END VGM_CLZ_HR " ).append("\n"); 
		query.append("     , CCT.VGM_CLZ_FILE_FLG " ).append("\n"); 
		query.append("     , CCT.VGM_YD_BSE_CALC_FLG " ).append("\n"); 
		query.append("     , DECODE(CCT.VGM_CLZ_DY_CD, 'CMN','OneDayBeforeETB',CCT.VGM_CLZ_DY_CD) AS VGM_CLZ_DY_CD " ).append("\n"); 
		query.append("     , CCT.VGM_CLZ_HRMNT " ).append("\n"); 
		query.append("     , CCT.VGM_XCLD_HOL_FRI_FLG " ).append("\n"); 
		query.append("     , CCT.VGM_XCLD_HOL_SAT_FLG " ).append("\n"); 
		query.append("     , CCT.VGM_XCLD_HOL_SUN_FLG " ).append("\n"); 
		query.append("     , CCT.VGM_XCLD_HOL_HOL_FLG " ).append("\n"); 
		query.append("	  ,'0' vgm_his_pop" ).append("\n"); 
		query.append("	  ,'0' cct_his_pop" ).append("\n"); 
		query.append("  FROM PRD_TML_CCT_MGMT CCT " ).append("\n"); 
		query.append("     , MDM_YARD MY " ).append("\n"); 
		query.append("     , MDM_VSL_SVC_LANE MVL " ).append("\n"); 
		query.append("WHERE CCT.YD_CD LIKE @[country_code] || '%' " ).append("\n"); 
		query.append("       AND CCT.YD_CD LIKE @[location_code] || '%' " ).append("\n"); 
		query.append("       AND CCT.YD_CD LIKE @[yard_code] || '%' " ).append("\n"); 
		query.append("       AND CCT.DELT_FLG LIKE DECODE (@[status_code], 'N', 'N', 'Y', 'Y', '%') " ).append("\n"); 
		query.append("       AND MY.YD_CD = CCT.YD_CD " ).append("\n"); 
		query.append("       AND NVL (MY.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("       AND CCT.VSL_SLAN_CD = MVL.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("       AND NVL(MVL.DELT_FLG(+), 'N') <> 'Y' " ).append("\n"); 
		query.append("       AND CCT.VSL_SLAN_CD LIKE @[lane_code] || '%'" ).append("\n"); 

	}
}