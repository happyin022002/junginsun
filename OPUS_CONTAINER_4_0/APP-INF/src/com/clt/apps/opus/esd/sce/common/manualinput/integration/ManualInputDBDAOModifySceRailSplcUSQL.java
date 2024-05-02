/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ManualInputDBDAOModifySceRailSplcUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.03.13 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualInputDBDAOModifySceRailSplcUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifySceRailSplc
	  * </pre>
	  */
	public ManualInputDBDAOModifySceRailSplcUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splc_vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splc_abbr_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splc_dflt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cuty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splc_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.manualinput.integration").append("\n"); 
		query.append("FileName : ManualInputDBDAOModifySceRailSplcUSQL").append("\n"); 
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
		query.append("UPDATE SCE_RAIL_SPLC" ).append("\n"); 
		query.append("   SET SPLC_CD = @[splc_cd]" ).append("\n"); 
		query.append("      ,SPLC_VNDR_NM = @[splc_vndr_nm]" ).append("\n"); 
		query.append("      ,YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("      ,SPLC_ABBR_LOC_NM = @[splc_abbr_loc_nm]" ).append("\n"); 
		query.append("      ,STE_CD = @[ste_cd]" ).append("\n"); 
		query.append("      ,CUTY_NM = @[cuty_nm]" ).append("\n"); 
		query.append("      ,SPLC_LOC_NM = @[splc_loc_nm]" ).append("\n"); 
		query.append("      ,SPLC_DFLT_FLG = @[splc_dflt_flg]" ).append("\n"); 
		query.append("      ,LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT = sysdate" ).append("\n"); 
		query.append(" WHERE SPLC_CD = @[splc_cd]" ).append("\n"); 
		query.append("   AND SPLC_VNDR_NM = @[splc_vndr_nm]" ).append("\n"); 
		query.append("   AND YD_CD        = @[yd_cd]" ).append("\n"); 

	}
}