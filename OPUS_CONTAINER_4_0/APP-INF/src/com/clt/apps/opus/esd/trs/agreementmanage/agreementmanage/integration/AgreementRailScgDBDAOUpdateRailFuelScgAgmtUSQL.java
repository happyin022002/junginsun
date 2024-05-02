/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementRailScgDBDAOUpdateRailFuelScgAgmtUSQL.java
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

public class AgreementRailScgDBDAOUpdateRailFuelScgAgmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 저장( Update 시)
	  * </pre>
	  */
	public AgreementRailScgDBDAOUpdateRailFuelScgAgmtUSQL(){
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
		params.put("fm_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AgreementRailScgDBDAOUpdateRailFuelScgAgmtUSQL").append("\n"); 
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
		query.append("	SET AGMT_ROUT_ALL_FLG = @[agmt_rout_all_flg]," ).append("\n"); 
		query.append("        FM_NOD_CD = @[fm_nod_cd]||@[fm_nod_yard]," ).append("\n"); 
		query.append("        TO_NOD_CD = @[to_nod_cd]||@[to_nod_yard]," ).append("\n"); 
		query.append("        CGO_TP_CD = @[cgo_tp_cd]," ).append("\n"); 
		query.append("        TRSP_RAIL_RTO = NVL(@[trsp_rail_rto], 0)," ).append("\n"); 
		query.append("		EFF_FM_DT = TO_DATE(@[eff_fm_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("		EFF_TO_DT = TO_DATE(@[eff_to_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("		RAIL_RTO_NO = @[rail_rto_no]," ).append("\n"); 
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