/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOModifyMovementFromBkgForPreVLUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOModifyMovementFromBkgForPreVLUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG에 제공.. PRE VL Update
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOModifyMovementFromBkgForPreVLUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOModifyMovementFromBkgForPreVLUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MOVEMENT" ).append("\n"); 
		query.append("   SET PRE_STS_FLG = 'N'," ).append("\n"); 
		query.append("       CRNT_VSL_CD = @[crnt_vsl_cd]," ).append("\n"); 
		query.append("       CRNT_SKD_VOY_NO = @[crnt_skd_voy_no]," ).append("\n"); 
		query.append("       CRNT_SKD_DIR_CD = @[crnt_skd_dir_cd]," ).append("\n"); 
		query.append("       TRNK_VSL_CD = @[trnk_vsl_cd]," ).append("\n"); 
		query.append("       TRNK_SKD_VOY_NO = @[trnk_skd_voy_no]," ).append("\n"); 
		query.append("       TRNK_SKD_DIR_CD = @[trnk_skd_dir_cd]," ).append("\n"); 
		query.append("       BKG_NO = @[bkg_no]," ).append("\n"); 
		query.append("       BL_NO = @[bl_no]," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE," ).append("\n"); 
		query.append("       UPD_LOCL_DT = GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (ORG_YD_CD, 0, 5 ))," ).append("\n"); 
		query.append("       CNMV_RMK = 'BKG updated by system'" ).append("\n"); 
		query.append(" WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("   AND CNMV_ID_NO = @[cnmv_id_no]" ).append("\n"); 
		query.append("   AND PRE_STS_FLG = 'Y'" ).append("\n"); 
		query.append("   AND MVMT_STS_CD = 'VL'" ).append("\n"); 

	}
}