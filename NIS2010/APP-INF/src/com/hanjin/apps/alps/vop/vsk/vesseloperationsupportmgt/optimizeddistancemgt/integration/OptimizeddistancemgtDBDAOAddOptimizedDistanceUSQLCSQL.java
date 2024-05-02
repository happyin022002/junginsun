/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OptimizeddistancemgtDBDAOAddOptimizedDistanceUSQLCSQL.java
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

public class OptimizeddistancemgtDBDAOAddOptimizedDistanceUSQLCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 데이터를 저장한다.
	  * </pre>
	  */
	public OptimizeddistancemgtDBDAOAddOptimizedDistanceUSQLCSQL(){
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
		params.put("sheet_to_yd_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration").append("\n"); 
		query.append("FileName : OptimizeddistancemgtDBDAOAddOptimizedDistanceUSQLCSQL").append("\n"); 
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
		query.append("MERGE INTO VSK_PORT_OPMZ_DIST H" ).append("\n"); 
		query.append("USING " ).append("\n"); 
		query.append("      (    " ).append("\n"); 
		query.append("        SELECT   @[sheet_fm_port_cd]  AS FM_YD_CD" ).append("\n"); 
		query.append("               , @[sheet_fm_yd_grp_cd] AS FM_YD_GRP_ID" ).append("\n"); 
		query.append("               , @[sheet_to_port_cd]  AS TO_YD_CD" ).append("\n"); 
		query.append("               , @[sheet_to_yd_grp_cd] AS TO_YD_GRP_ID " ).append("\n"); 
		query.append("        FROM     DUAL" ).append("\n"); 
		query.append("      )   X" ).append("\n"); 
		query.append("ON    (" ).append("\n"); 
		query.append("        H.FM_YD_CD        = X.FM_YD_CD" ).append("\n"); 
		query.append("AND     H.TO_YD_CD        = X.TO_YD_CD" ).append("\n"); 
		query.append("AND     H.FM_YD_GRP_ID    = X.FM_YD_GRP_ID" ).append("\n"); 
		query.append("AND     H.TO_YD_GRP_ID    = X.TO_YD_GRP_ID" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("  UPDATE SET " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	  OPMZ_DIST    = @[opmz_dist]" ).append("\n"); 
		query.append("	, RNG_MIN_DIST = @[rng_min_dist]" ).append("\n"); 
		query.append("    , RNG_MAX_DIST = @[rng_max_dist]" ).append("\n"); 
		query.append("    , UPD_USR_ID   = @[usr_id]  " ).append("\n"); 
		query.append("    , UPD_DT       = sysdate" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("      FM_YD_CD" ).append("\n"); 
		query.append("    , TO_YD_CD" ).append("\n"); 
		query.append("    , OPMZ_DIST" ).append("\n"); 
		query.append("    , RNG_MIN_DIST" ).append("\n"); 
		query.append("    , RNG_MAX_DIST" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , FM_YD_GRP_ID " ).append("\n"); 
		query.append("    , TO_YD_GRP_ID " ).append("\n"); 
		query.append("    , FILE_NM" ).append("\n"); 
		query.append("	, FILE_SAV_ID" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  VALUES" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("	  @[sheet_fm_port_cd]" ).append("\n"); 
		query.append("	, @[sheet_to_port_cd]" ).append("\n"); 
		query.append("	, @[opmz_dist]" ).append("\n"); 
		query.append("	, @[rng_min_dist]" ).append("\n"); 
		query.append("	, @[rng_max_dist]" ).append("\n"); 
		query.append("	, @[usr_id]" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("	, @[usr_id]" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("	, @[sheet_fm_yd_grp_cd]" ).append("\n"); 
		query.append("	, @[sheet_to_yd_grp_cd]" ).append("\n"); 
		query.append("	, @[file_nm]" ).append("\n"); 
		query.append("    , @[file_sav_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}