/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementRailScgDBDAOUpdateRailFixScgAgmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.27 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRailScgDBDAOUpdateRailFixScgAgmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 저장( Update 시)
	  * </pre>
	  */
	public AgreementRailScgDBDAOUpdateRailFixScgAgmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cost_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fx_scg_20ft_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fx_scg_45ft_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lbs_ovr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_scg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fx_scg_40ft_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_scg_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_def_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fx_scg_all_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_scg_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementRailScgDBDAOUpdateRailFixScgAgmtUSQL").append("\n"); 
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
		query.append("UPDATE TRS_AGMT_RAIL_SCG_RT" ).append("\n"); 
		query.append("	SET LBS_OVR_WGT = @[lbs_ovr_wgt]," ).append("\n"); 
		query.append("		CURR_CD = @[curr_cd]," ).append("\n"); 
		query.append("		FX_SCG_ALL_RT = @[fx_scg_all_rt]," ).append("\n"); 
		query.append("		FX_SCG_20FT_RT = @[fx_scg_20ft_rt]," ).append("\n"); 
		query.append("		FX_SCG_40FT_RT = @[fx_scg_40ft_rt]," ).append("\n"); 
		query.append("		FX_SCG_45FT_RT = @[fx_scg_45ft_rt]," ).append("\n"); 
		query.append("		EFF_FM_DT = TO_DATE(@[eff_fm_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("		EFF_TO_DT = TO_DATE(@[eff_to_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("		FUEL_SCG_APLY_FLG = @[fuel_scg_aply_flg]," ).append("\n"); 
		query.append("		DELT_FLG = @[delt_flg]," ).append("\n"); 
		query.append("		UPD_USR_ID = '${sUsrId}'," ).append("\n"); 
		query.append("		UPD_DT = SYSDATE," ).append("\n"); 
		query.append("		LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('${sctrlOfcCd}')," ).append("\n"); 
		query.append("        COM_SCG_APLY_FLG = @[com_scg_aply_flg]," ).append("\n"); 
		query.append("        WO_APLY_FLG = @[wo_aply_flg]," ).append("\n"); 
		query.append("        USR_DEF_RMK = @[usr_def_rmk]," ).append("\n"); 
		query.append("        SPCL_CGO_CNTR_TP_CD = @[spcl_cgo_cntr_tp_cd]," ).append("\n"); 
		query.append("        AGMT_COST_FLG = @[agmt_cost_flg]" ).append("\n"); 
		query.append("WHERE	TRSP_AGMT_SCG_SEQ = @[trsp_agmt_scg_seq]" ).append("\n"); 

	}
}