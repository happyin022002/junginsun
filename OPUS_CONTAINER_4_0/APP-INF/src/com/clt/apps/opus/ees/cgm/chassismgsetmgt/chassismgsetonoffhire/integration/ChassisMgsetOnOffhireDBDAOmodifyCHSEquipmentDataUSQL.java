/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOmodifyCHSEquipmentDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.21 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOmodifyCHSEquipmentDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOmodifyCHSEquipmentDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_prd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_tare_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_als_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_chss_als_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_tit_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_lic_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_veh_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOmodifyCHSEquipmentDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_EQUIPMENT" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("EQ_KND_CD = @[eq_knd_cd]," ).append("\n"); 
		query.append("CHSS_RGST_LIC_NO = @[chss_rgst_lic_no]," ).append("\n"); 
		query.append("CHSS_VEH_ID_NO = @[chss_veh_id_no]," ).append("\n"); 
		query.append("EQ_TPSZ_CD = @[eq_tpsz_cd]," ).append("\n"); 
		query.append("MFT_DT = TO_DATE(@[mft_dt],'YYYY-MM-DD')," ).append("\n"); 
		query.append("CHSS_TARE_WGT = @[chss_tare_wgt]," ).append("\n"); 
		query.append("CHSS_RGST_STE_CD = @[chss_rgst_ste_cd]," ).append("\n"); 
		query.append("CHSS_RGST_YR = @[chss_rgst_yr]," ).append("\n"); 
		query.append("CHSS_RGST_PRD_CD = @[chss_rgst_prd_cd]," ).append("\n"); 
		query.append("CHSS_RGST_EXP_DT = TO_DATE(@[chss_rgst_exp_dt],'YYYY-MM-DD')," ).append("\n"); 
		query.append("CHSS_TIT_NO = @[chss_tit_no]," ).append("\n"); 
		query.append("CHSS_ALS_NO = @[chss_als_no]," ).append("\n"); 
		query.append("N2ND_CHSS_ALS_NO = @[n2nd_chss_als_no]," ).append("\n"); 
		query.append("ONH_YD_CD = @[onh_yd_cd]," ).append("\n"); 
		query.append("CHSS_RGST_UPD_OFC_CD = @[chss_rgst_upd_ofc_cd]," ).append("\n"); 
		query.append("CHSS_RGST_UPD_DT = SYSDATE," ).append("\n"); 
		query.append("CHSS_RGST_UPD_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 

	}
}