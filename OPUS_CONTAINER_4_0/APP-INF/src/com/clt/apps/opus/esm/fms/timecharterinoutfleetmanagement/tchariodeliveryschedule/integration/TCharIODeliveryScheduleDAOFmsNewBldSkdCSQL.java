/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODeliveryScheduleDAOFmsNewBldSkdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.09.04 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharIODeliveryScheduleDAOFmsNewBldSkdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NB Delivery Schedule Creation Insert
	  * </pre>
	  */
	public TCharIODeliveryScheduleDAOFmsNewBldSkdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_14ton_vsl_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr_plg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_spd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_dur_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_hus_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shp_bld_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dznd_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_de_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration").append("\n"); 
		query.append("FileName : TCharIODeliveryScheduleDAOFmsNewBldSkdCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_NEW_BLD_SKD (" ).append("\n"); 
		query.append("SHP_DE_SEQ," ).append("\n"); 
		query.append("SHP_NM," ).append("\n"); 
		query.append("SHP_BLD_NM," ).append("\n"); 
		query.append("VSL_DZND_CAPA," ).append("\n"); 
		query.append("BSE_14TON_VSL_CAPA," ).append("\n"); 
		query.append("RF_CNTR_PLG_QTY," ).append("\n"); 
		query.append("SHP_SPD_QTY," ).append("\n"); 
		query.append("FLET_CTRT_DUR_CTNT," ).append("\n"); 
		query.append("TRD_HUS_NM," ).append("\n"); 
		query.append("VSL_DE_DT," ).append("\n"); 
		query.append("YD_SEQ," ).append("\n"); 
		query.append("OWNR_SEQ," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("CRE_USR_ID" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("FMS_SHP_DE_SEQ.nextval," ).append("\n"); 
		query.append("@[shp_nm]," ).append("\n"); 
		query.append("@[shp_bld_nm]," ).append("\n"); 
		query.append("@[vsl_dznd_capa]," ).append("\n"); 
		query.append("@[bse_14ton_vsl_capa]," ).append("\n"); 
		query.append("@[rf_cntr_plg_qty]," ).append("\n"); 
		query.append("@[shp_spd_qty]," ).append("\n"); 
		query.append("@[flet_ctrt_dur_ctnt]," ).append("\n"); 
		query.append("@[trd_hus_nm]," ).append("\n"); 
		query.append("@[vsl_de_dt]," ).append("\n"); 
		query.append("@[yd_seq]," ).append("\n"); 
		query.append("@[ownr_seq]," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("@[cre_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}