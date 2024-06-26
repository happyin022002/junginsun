/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOModifyVskVslSkdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOModifyVskVslSkdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_VSL_SKD의 VVD 정보를 수정합니다.
	  * 
	  * ---------------------------------------------
	  * HISTORY
	  * 2011.10.18 표준희 CHM201113956-01 [VOP-VSK] VVD내 ACTUAL CARRIER 적용 로직 변경
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOModifyVskVslSkdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psdo_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_port_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_usd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_skd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOModifyVskVslSkdUSQL").append("\n"); 
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
		query.append("UPDATE 		VSK_VSL_SKD 	 	X" ).append("\n"); 
		query.append("SET			X.SKD_STS_CD 		= NVL(@[skd_sts_cd]					, SKD_STS_CD	)" ).append("\n"); 
		query.append("		,	X.SKD_VOY_TP_CD 	= NVL(@[skd_voy_tp_cd]				, SKD_VOY_TP_CD	)" ).append("\n"); 
		query.append("		,	X.SKD_USD_IND_CD 	= NVL(@[skd_usd_ind_cd]				, SKD_USD_IND_CD)" ).append("\n"); 
		query.append("		,	X.PF_SKD_TP_CD 		= NVL(@[pf_skd_tp_cd]				, PF_SKD_TP_CD	)" ).append("\n"); 
		query.append("		,	X.ST_PORT_CD 		= NVL(@[st_port_cd]					, ST_PORT_CD	)" ).append("\n"); 
		query.append("		,	X.N1ST_PORT_BRTH_DT = NVL(TO_DATE(@[n1st_port_brth_dt]	,'YYYYMMDDHH24MI'), N1ST_PORT_BRTH_DT)" ).append("\n"); 
		query.append("		,	X.PSDO_VVD_CD 		= NVL(@[psdo_vvd_cd]				, PSDO_VVD_CD	)" ).append("\n"); 
		query.append("		,	X.CO_CD 			= NVL(@[co_cd]						, CO_CD			)" ).append("\n"); 
		query.append("		,	X.SKD_RMK 			= LTRIM(NVL(@[skd_rmk]				, SKD_RMK		))" ).append("\n"); 
		query.append("		,	X.UPD_USR_ID 		= @[upd_usr_id]" ).append("\n"); 
		query.append("		,	X.UPD_DT 			= SYSDATE" ).append("\n"); 
		query.append("		,	X.ACT_CRR_CD 		= NVL((	SELECT 	V.ACT_CRR_CD " ).append("\n"); 
		query.append("										FROM 	VSK_VSL_SKD		V" ).append("\n"); 
		query.append("    				   					WHERE 	V.VSL_CD 		= @[vsl_cd]" ).append("\n"); 
		query.append("										AND 	V.SKD_VOY_NO 	= @[skd_voy_no]" ).append("\n"); 
		query.append("     									AND 	V.SKD_DIR_CD 	= @[skd_dir_cd]), @[act_crr_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		--:: VSL_SLAN_CD = NVL([vsl_slan_cd], VSL_SLAN_CD)::2013-04-09 주석처리 ::--" ).append("\n"); 
		query.append("WHERE		X.VSL_CD 			= @[vsl_cd]" ).append("\n"); 
		query.append("AND			X.SKD_VOY_NO 		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND			X.SKD_DIR_CD 		= @[skd_dir_cd]" ).append("\n"); 

	}
}