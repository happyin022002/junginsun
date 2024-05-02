/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchVskVslSkdByVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.11 
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

public class VesselScheduleMgtDBDAOSearchVskVslSkdByVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vsk_vsl_skd조회
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchVskVslSkdByVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchVskVslSkdByVVDRSQL").append("\n"); 
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
		query.append("SELECT ACT_CRR_CD" ).append("\n"); 
		query.append(",BLCK_BKG_FLG" ).append("\n"); 
		query.append(",CO_CD" ).append("\n"); 
		query.append(",TO_CHAR(CRE_DT,'YYYYMMDDHH24MI') CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",DLS_EDI_SND_TGT_FLG" ).append("\n"); 
		query.append(",TO_CHAR(EDW_UPD_DT,'YYYYMMDDHH24MI') EDW_UPD_DT" ).append("\n"); 
		query.append(",TO_CHAR(N1ST_PORT_BRTH_DT,'YYYYMMDDHH24MI') N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append(",PF_SKD_TP_CD" ).append("\n"); 
		query.append(",PSDO_VVD_CD" ).append("\n"); 
		query.append(",RUSE_PROHI_FLG" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",SKD_RMK" ).append("\n"); 
		query.append(",SKD_STS_CD" ).append("\n"); 
		query.append(",SKD_STS_MNL_FLG" ).append("\n"); 
		query.append(",SKD_USD_IND_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_VOY_TP_CD" ).append("\n"); 
		query.append(",ST_PORT_CD" ).append("\n"); 
		query.append(",TO_CHAR(UPD_DT,'YYYYMMDDHH24MI') UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",VSL_NM_XTER_HIDE_FLG" ).append("\n"); 
		query.append(",VSL_SLAN_CD " ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 

	}
}