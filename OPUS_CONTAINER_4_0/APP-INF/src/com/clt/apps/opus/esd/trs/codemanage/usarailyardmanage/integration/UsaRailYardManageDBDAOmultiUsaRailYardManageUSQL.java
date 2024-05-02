/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaRailYardManageDBDAOmultiUsaRailYardManageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaRailYardManageDBDAOmultiUsaRailYardManageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA Rail Yard 관리 -update
	  * </pre>
	  */
	public UsaRailYardManageDBDAOmultiUsaRailYardManageUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_ctrl_ofc_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_loc_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_loc_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_ctrl_ofc_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_ctrl_ofc_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_ctrl_ofc_zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.integration").append("\n"); 
		query.append("FileName : UsaRailYardManageDBDAOmultiUsaRailYardManageUSQL").append("\n"); 
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
		query.append("UPDATE MDM_YARD" ).append("\n"); 
		query.append("SET YD_LOC_CTY_NM = @[yd_loc_cty_nm]," ).append("\n"); 
		query.append("YD_LOC_STE_CD = @[yd_loc_ste_cd]," ).append("\n"); 
		query.append("YD_CTRL_OFC_ADDR = @[yd_ctrl_ofc_addr]," ).append("\n"); 
		query.append("YD_CTRL_OFC_CTY_NM = @[yd_ctrl_ofc_cty_nm]," ).append("\n"); 
		query.append("YD_CTRL_OFC_STE_CD = @[yd_ctrl_ofc_ste_cd]," ).append("\n"); 
		query.append("YD_CTRL_OFC_ZIP_CD = @[yd_ctrl_ofc_zip_cd]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 

	}
}