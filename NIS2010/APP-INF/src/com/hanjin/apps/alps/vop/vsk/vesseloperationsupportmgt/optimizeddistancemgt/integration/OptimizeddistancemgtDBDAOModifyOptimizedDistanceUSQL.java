/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OptimizeddistancemgtDBDAOModifyOptimizedDistanceUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OptimizeddistancemgtDBDAOModifyOptimizedDistanceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * User가 Input한 Optimized Distance를 저장합니다.
	  * </pre>
	  */
	public OptimizeddistancemgtDBDAOModifyOptimizedDistanceUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rng_max_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rng_min_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opmz_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_sheet_to_yd_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_fm_yd_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_sheet_fm_yd_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_to_yd_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration").append("\n"); 
		query.append("FileName : OptimizeddistancemgtDBDAOModifyOptimizedDistanceUSQL").append("\n"); 
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
		query.append("UPDATE VSK_PORT_OPMZ_DIST" ).append("\n"); 
		query.append("  SET" ).append("\n"); 
		query.append("	  FM_YD_GRP_ID = @[sheet_fm_yd_grp_cd]" ).append("\n"); 
		query.append("	, TO_YD_CD 	   = @[sheet_to_port_cd]" ).append("\n"); 
		query.append("    , TO_YD_GRP_ID = @[sheet_to_yd_grp_cd]  " ).append("\n"); 
		query.append("	, OPMZ_DIST    = @[opmz_dist]" ).append("\n"); 
		query.append("	, RNG_MIN_DIST = @[rng_min_dist]" ).append("\n"); 
		query.append("    , RNG_MAX_DIST = @[rng_max_dist]" ).append("\n"); 
		query.append("    , UPD_USR_ID   = @[usr_id]" ).append("\n"); 
		query.append("    , UPD_DT       = sysdate" ).append("\n"); 
		query.append("	, FILE_NM	   = @[file_nm]" ).append("\n"); 
		query.append("    , FILE_SAV_ID  = @[file_sav_id]" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("    AND FM_YD_CD = @[sheet_fm_port_cd]	" ).append("\n"); 
		query.append("	AND FM_YD_GRP_ID = @[pre_sheet_fm_yd_grp_cd]" ).append("\n"); 
		query.append("    AND TO_YD_CD = @[sheet_to_port_cd] " ).append("\n"); 
		query.append("	AND TO_YD_GRP_ID = @[pre_sheet_to_yd_grp_cd]" ).append("\n"); 

	}
}