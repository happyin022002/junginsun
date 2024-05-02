/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ManualInputDBDAOSelectSceRailSplcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.04.25 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualInputDBDAOSelectSceRailSplcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectSceRailSplc
	  * </pre>
	  */
	public ManualInputDBDAOSelectSceRailSplcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_splc_vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_splc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.manualinput.integration").append("\n"); 
		query.append("FileName : ManualInputDBDAOSelectSceRailSplcRSQL").append("\n"); 
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
		query.append("SELECT SPLC_CD" ).append("\n"); 
		query.append("      ,SPLC_VNDR_NM" ).append("\n"); 
		query.append("      ,YD_CD" ).append("\n"); 
		query.append("      ,SPLC_ABBR_LOC_NM" ).append("\n"); 
		query.append("      ,STE_CD" ).append("\n"); 
		query.append("      ,CUTY_NM" ).append("\n"); 
		query.append("      ,SPLC_LOC_NM" ).append("\n"); 
		query.append("      ,SPLC_DFLT_FLG" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(" FROM SCE_RAIL_SPLC" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if (${frm_splc_cd} != '') " ).append("\n"); 
		query.append("  AND SPLC_CD = @[frm_splc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_yd_cd} != '') " ).append("\n"); 
		query.append("  AND YD_CD = @[frm_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_splc_vndr_nm} != '') " ).append("\n"); 
		query.append("  AND SPLC_VNDR_NM like @[frm_splc_vndr_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}