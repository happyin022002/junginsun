/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ActualCostCalcManageDBDAOCreateActCostCalcTpSzCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.actualcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCostCalcManageDBDAOCreateActCostCalcTpSzCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACT COST CALC TPSZ DATA 저장
	  * </pre>
	  */
	public ActualCostCalcManageDBDAOCreateActCostCalcTpSzCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_awk_cgo_trf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_ga_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_act_cost_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.actualcostmanage.integration").append("\n"); 
		query.append("FileName : ActualCostCalcManageDBDAOCreateActCostCalcTpSzCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_ACT_COST_TP_SZ (" ).append("\n"); 
		query.append("TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append(", FM_YD_CD" ).append("\n"); 
		query.append(", TO_YD_CD" ).append("\n"); 
		query.append(", TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", IO_GA_CD" ).append("\n"); 
		query.append(", TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", CNTR_SZ_CD" ).append("\n"); 
		query.append(", LOCL_CURR_CD" ).append("\n"); 
		query.append(", LOCL_CURR_AMT" ).append("\n"); 
		query.append(", USD_AMT" ).append("\n"); 
		query.append(", USD_XCH_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[trsp_act_cost_seq] --TRSP_ACT_COST_SEQ" ).append("\n"); 
		query.append(", @[fm_yd_cd] --FM_YD_CD" ).append("\n"); 
		query.append(", @[to_yd_cd] --TO_YD_CD" ).append("\n"); 
		query.append(", @[trsp_awk_cgo_trf_tp_cd] --TRSP_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append(", @[io_ga_cd] --IO_GA_CD" ).append("\n"); 
		query.append(", @[trsp_crr_mod_cd] --TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", @[cntr_sz_cd] --CNTR_SZ_CD" ).append("\n"); 
		query.append(", @[locl_curr_cd] --LOCL_CURR_CD" ).append("\n"); 
		query.append(", @[locl_curr_amt] --LOCL_CURR_AMT" ).append("\n"); 
		query.append(", @[usd_amt] --USD_AMT" ).append("\n"); 
		query.append(", @[usd_xch_dt] --USD_XCH_DT" ).append("\n"); 
		query.append(", 'SYSTEM' --CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", 'SYSTEM' --UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}