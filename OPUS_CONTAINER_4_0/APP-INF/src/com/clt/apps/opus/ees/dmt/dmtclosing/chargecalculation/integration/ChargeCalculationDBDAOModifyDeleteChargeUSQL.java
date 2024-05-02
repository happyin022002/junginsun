/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOModifyDeleteChargeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOModifyDeleteChargeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOModifyDeleteChargeUSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOModifyDeleteChargeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_delt_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOModifyDeleteChargeUSQL").append("\n"); 
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
		query.append("UPDATE DMT_CHG_CALC" ).append("\n"); 
		query.append("   SET DMDT_CHG_STS_CD = 'D'," ).append("\n"); 
		query.append("       DMDT_PRE_CHG_STS_CD =" ).append("\n"); 
		query.append("          (SELECT DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("             FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("            WHERE SYS_AREA_GRP_ID	= @[svr_id]			" ).append("\n"); 
		query.append("			AND	CNTR_NO				= @[cntr_no]" ).append("\n"); 
		query.append("			AND	CNTR_CYC_NO 		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("			AND	DMDT_TRF_CD 		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("			AND	DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("			AND	CHG_SEQ				= @[chg_seq]" ).append("\n"); 
		query.append("			)," ).append("\n"); 
		query.append("       DMDT_CHG_DELT_RSN_CD = @[dmdt_chg_delt_rsn_cd]," ).append("\n"); 
		query.append("       CORR_RMK		= @[corr_rmk]," ).append("\n"); 
		query.append("       UPD_DT		= SYSDATE," ).append("\n"); 
		query.append("       UPD_USR_ID	= @[usr_id]," ).append("\n"); 
		query.append("       UPD_OFC_CD	= @[ofc_cd]" ).append("\n"); 
		query.append(" WHERE	SYS_AREA_GRP_ID		= @[svr_id]" ).append("\n"); 
		query.append("	AND	CNTR_NO				= @[cntr_no]" ).append("\n"); 
		query.append("	AND	CNTR_CYC_NO 		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("	AND	DMDT_TRF_CD 		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("	AND	DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("	AND	CHG_SEQ				= @[chg_seq]" ).append("\n"); 
		query.append("	AND DMDT_CHG_STS_CD 	NOT IN ( 'I', 'D')" ).append("\n"); 

	}
}