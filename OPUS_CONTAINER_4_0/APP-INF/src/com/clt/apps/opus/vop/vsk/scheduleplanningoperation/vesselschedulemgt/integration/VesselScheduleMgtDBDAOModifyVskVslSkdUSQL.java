/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOModifyVskVslSkdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
	  * DESC Enter..
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
		params.put("skd_usd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
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
		query.append("UPDATE 		VSK_VSL_SKD 			X" ).append("\n"); 
		query.append("SET			X.SKD_STS_CD 			= NVL(@[skd_sts_cd]		, X.SKD_STS_CD)" ).append("\n"); 
		query.append("		,	X.SKD_VOY_TP_CD 		= NVL(@[skd_voy_tp_cd]	, X.SKD_VOY_TP_CD)" ).append("\n"); 
		query.append("		,	X.SKD_USD_IND_CD		= NVL(@[skd_usd_ind_cd] , X.SKD_USD_IND_CD)" ).append("\n"); 
		query.append("		,	X.PF_SKD_TP_CD 			= NVL(@[pf_skd_tp_cd]	, X.PF_SKD_TP_CD)" ).append("\n"); 
		query.append("		,	X.ST_PORT_CD 			= NVL(@[st_port_cd]		, X.ST_PORT_CD)" ).append("\n"); 
		query.append("		,	X.N1ST_PORT_BRTH_DT 	= NVL(TO_DATE(@[n1st_port_brth_dt],'YYYYMMDDHH24MI'), X.N1ST_PORT_BRTH_DT)" ).append("\n"); 
		query.append("		,	X.PSDO_VVD_CD 			= NVL(@[psdo_vvd_cd]	, X.PSDO_VVD_CD)" ).append("\n"); 
		query.append("		,	X.CO_CD 				= NVL(@[co_cd]			, X.CO_CD)" ).append("\n"); 
		query.append("		,	X.SKD_RMK 				= LTRIM(NVL(@[skd_rmk]	, X.SKD_RMK))" ).append("\n"); 
		query.append("		,	X.UPD_USR_ID 			= @[upd_usr_id]" ).append("\n"); 
		query.append("		,	X.UPD_DT 				= SYSDATE" ).append("\n"); 
		query.append("		,	X.ACT_CRR_CD 			= CASE	WHEN X.ACT_CRR_CD IS NULL THEN (SELECT MC.CRR_CD FROM MDM_VSL_CNTR MC WHERE MC.VSL_CD = X.VSL_CD)" ).append("\n"); 
		query.append("											ELSE X.ACT_CRR_CD" ).append("\n"); 
		query.append("									  END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										--NVL([act_crr_cd], ACT_CRR_CD)" ).append("\n"); 
		query.append("WHERE		X.VSL_CD 				= @[vsl_cd]" ).append("\n"); 
		query.append("AND			X.SKD_VOY_NO 			= @[skd_voy_no]" ).append("\n"); 
		query.append("AND			X.SKD_DIR_CD 			= @[skd_dir_cd]" ).append("\n"); 

	}
}