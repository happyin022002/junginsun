/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementRailScgDBDAOInsertRailFuelFixScgAgmtCSQL.java
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

public class AgreementRailScgDBDAOInsertRailFuelFixScgAgmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US RAIL Surcharge 화면의 US RAIL Agreement Surcharge 저장( Insert 시)
	  * </pre>
	  */
	public AgreementRailScgDBDAOInsertRailFuelFixScgAgmtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_rail_scg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rail_rto_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_rail_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_rout_all_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_eq_sz_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementRailScgDBDAOInsertRailFuelFixScgAgmtCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_AGMT_RAIL_SCG_RT (" ).append("\n"); 
		query.append("	TRSP_AGMT_SCG_SEQ," ).append("\n"); 
		query.append("    VNDR_SEQ," ).append("\n"); 
		query.append("    TRSP_RAIL_SCG_CD," ).append("\n"); 
		query.append("	TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("    AGMT_ROUT_ALL_FLG," ).append("\n"); 
		query.append("    FM_NOD_CD," ).append("\n"); 
		query.append("    TO_NOD_CD," ).append("\n"); 
		query.append("    CGO_TP_CD," ).append("\n"); 
		query.append("	AGMT_EQ_SZ_NO," ).append("\n"); 
		query.append("    TRSP_RAIL_RTO," ).append("\n"); 
		query.append("    EFF_FM_DT," ).append("\n"); 
		query.append("    EFF_TO_DT," ).append("\n"); 
		query.append("    RAIL_RTO_NO," ).append("\n"); 
		query.append("    LBS_OVR_WGT," ).append("\n"); 
		query.append("    CURR_CD," ).append("\n"); 
		query.append("    FX_SCG_ALL_RT," ).append("\n"); 
		query.append("    FX_SCG_20FT_RT," ).append("\n"); 
		query.append("    FX_SCG_40FT_RT," ).append("\n"); 
		query.append("    FX_SCG_45FT_RT," ).append("\n"); 
		query.append("    FUEL_SCG_APLY_FLG," ).append("\n"); 
		query.append("    DELT_FLG," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    LOCL_CRE_DT," ).append("\n"); 
		query.append("    LOCL_UPD_DT," ).append("\n"); 
		query.append("    COM_SCG_APLY_FLG," ).append("\n"); 
		query.append("    WO_APLY_FLG," ).append("\n"); 
		query.append("    USR_DEF_RMK," ).append("\n"); 
		query.append("    SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("    AGMT_COST_FLG " ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	@[trsp_agmt_scg_seq]," ).append("\n"); 
		query.append("    @[vndr_seq]," ).append("\n"); 
		query.append("    @[trsp_rail_scg_cd]," ).append("\n"); 
		query.append("    @[trsp_agmt_ofc_cty_cd]," ).append("\n"); 
		query.append("    @[trsp_agmt_seq]," ).append("\n"); 
		query.append("    @[agmt_rout_all_flg]," ).append("\n"); 
		query.append("    @[fm_nod_cd]||@[fm_nod_yard]," ).append("\n"); 
		query.append("    @[to_nod_cd]||@[to_nod_yard]," ).append("\n"); 
		query.append("    @[cgo_tp_cd]," ).append("\n"); 
		query.append("	@[agmt_eq_sz_no]," ).append("\n"); 
		query.append("    NVL(@[trsp_rail_rto], 0)," ).append("\n"); 
		query.append("    TO_DATE(@[eff_fm_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("    TO_DATE(@[eff_to_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("    @[rail_rto_no]," ).append("\n"); 
		query.append("    @[lbs_ovr_wgt]," ).append("\n"); 
		query.append("    @[curr_cd]," ).append("\n"); 
		query.append("    @[fx_scg_all_rt]," ).append("\n"); 
		query.append("    @[fx_scg_20ft_rt]," ).append("\n"); 
		query.append("    @[fx_scg_40ft_rt]," ).append("\n"); 
		query.append("    @[fx_scg_45ft_rt]," ).append("\n"); 
		query.append("    @[fuel_scg_aply_flg]," ).append("\n"); 
		query.append("    @[delt_flg]," ).append("\n"); 
		query.append("	'${sUsrId}'," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    '${sUsrId}'," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('${sctrlOfcCd}')," ).append("\n"); 
		query.append("    GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('${sctrlOfcCd}')," ).append("\n"); 
		query.append("    @[com_scg_aply_flg]," ).append("\n"); 
		query.append("    @[wo_aply_flg]," ).append("\n"); 
		query.append("    @[usr_def_rmk]," ).append("\n"); 
		query.append("    @[spcl_cgo_cntr_tp_cd]," ).append("\n"); 
		query.append("    @[agmt_cost_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}