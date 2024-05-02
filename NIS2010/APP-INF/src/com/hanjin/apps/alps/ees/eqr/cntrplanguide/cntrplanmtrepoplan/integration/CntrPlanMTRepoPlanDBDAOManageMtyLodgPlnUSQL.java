/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrPlanMTRepoPlanDBDAOManageMtyLodgPlnUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanMTRepoPlanDBDAOManageMtyLodgPlnUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eMtyLodgPln 저장
	  * </pre>
	  */
	public CntrPlanMTRepoPlanDBDAOManageMtyLodgPlnUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_cbf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_lodg_pln_ton_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_lodg_pln_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_rsn_hdr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_cbf_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_rsn_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration").append("\n"); 
		query.append("FileName : CntrPlanMTRepoPlanDBDAOManageMtyLodgPlnUSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_CTRL_MTY_LODG_PLN V" ).append("\n"); 
		query.append("USING  DUAL" ).append("\n"); 
		query.append("ON (    V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("        AND V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND V.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("        POL_YD_CD = @[pol_yd_cd]," ).append("\n"); 
		query.append("        TRD_CD = @[trd_cd]," ).append("\n"); 
		query.append("        SUB_TRD_CD = @[sub_trd_cd]," ).append("\n"); 
		query.append("        VSL_LANE_CD = @[vsl_lane_cd]," ).append("\n"); 
		query.append("        MTY_LODG_PLN_TEU_QTY = @[mty_lodg_pln_teu_qty]," ).append("\n"); 
		query.append("        MTY_LODG_PLN_TON_WGT = @[mty_lodg_pln_ton_wgt]," ).append("\n"); 
		query.append("        PLN_RSN_HDR_CD = @[pln_rsn_hdr_cd]," ).append("\n"); 
		query.append("        PLN_RSN_SUB_CD = @[pln_rsn_sub_cd]," ).append("\n"); 
		query.append("        PLN_RSN_RMK = @[pln_rsn_rmk]," ).append("\n"); 
		query.append("        FNL_CBF_FLG = @[fnl_cbf_flg]," ).append("\n"); 
		query.append("        FNL_CBF_DT = TO_DATE(REPLACE(@[fnl_cbf_dt],':',''),'YYYYMMDD'), -- 요구사항변경 'MM/DD HH24:MI' -> 'YYYY/MM/DD' " ).append("\n"); 
		query.append("        UPD_USR_ID =  @[upd_usr_id]," ).append("\n"); 
		query.append("        UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("        VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        POL_CD," ).append("\n"); 
		query.append("        POL_YD_CD," ).append("\n"); 
		query.append("        TRD_CD," ).append("\n"); 
		query.append("        SUB_TRD_CD," ).append("\n"); 
		query.append("        VSL_LANE_CD," ).append("\n"); 
		query.append("        MTY_LODG_PLN_TEU_QTY," ).append("\n"); 
		query.append("        MTY_LODG_PLN_TON_WGT," ).append("\n"); 
		query.append("        PLN_RSN_HDR_CD," ).append("\n"); 
		query.append("        PLN_RSN_SUB_CD," ).append("\n"); 
		query.append("        PLN_RSN_RMK," ).append("\n"); 
		query.append("        FNL_CBF_FLG," ).append("\n"); 
		query.append("        FNL_CBF_DT," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("    	UPD_USR_ID," ).append("\n"); 
		query.append("    	UPD_DT" ).append("\n"); 
		query.append("	) VALUES (" ).append("\n"); 
		query.append("        @[vsl_cd]," ).append("\n"); 
		query.append("        @[skd_voy_no]," ).append("\n"); 
		query.append("        @[skd_dir_cd]," ).append("\n"); 
		query.append("        @[pol_cd]," ).append("\n"); 
		query.append("        @[pol_yd_cd]," ).append("\n"); 
		query.append("        @[trd_cd]," ).append("\n"); 
		query.append("        @[sub_trd_cd]," ).append("\n"); 
		query.append("        @[vsl_lane_cd]," ).append("\n"); 
		query.append("        @[mty_lodg_pln_teu_qty]," ).append("\n"); 
		query.append("        @[mty_lodg_pln_ton_wgt]," ).append("\n"); 
		query.append("        @[pln_rsn_hdr_cd]," ).append("\n"); 
		query.append("        @[pln_rsn_sub_cd]," ).append("\n"); 
		query.append("        @[pln_rsn_rmk]," ).append("\n"); 
		query.append("        @[fnl_cbf_flg]," ).append("\n"); 
		query.append("        TO_DATE(REPLACE(@[fnl_cbf_dt],':',''),'YYYYMMDD')," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[upd_usr_id]," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}