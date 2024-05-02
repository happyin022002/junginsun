/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOChargeBasicFreeTimeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.14 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOChargeBasicFreeTimeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Tariff의 주말, 공휴일 포함 여부를 조회한다
	  * </pre>
	  */
	public ChargeCalculationDBDAOChargeBasicFreeTimeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trf_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trf_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOChargeBasicFreeTimeVORSQL").append("\n"); 
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
		query.append("SELECT	DECODE(@[dmdt_chg_loc_div_cd], 'TSP', 'N', XCLD_SAT_FLG) XCLD_SAT_FLG," ).append("\n"); 
		query.append("DECODE(@[dmdt_chg_loc_div_cd], 'TSP', 'N', XCLD_SUN_FLG) XCLD_SUN_FLG," ).append("\n"); 
		query.append("DECODE(@[dmdt_chg_loc_div_cd], 'TSP', 'N', XCLD_HOL_FLG) XCLD_HOL_FLG" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append(",'' BZC_TRF_APLY_DT" ).append("\n"); 
		query.append(",'' CVRG_CD" ).append("\n"); 
		query.append(",'' FT_DYS" ).append("\n"); 
		query.append(",'' XCLD_SAT_FLG" ).append("\n"); 
		query.append(",'' XCLD_SUN_FLG" ).append("\n"); 
		query.append(",'' XCLD_HOL_FLG" ).append("\n"); 
		query.append(",'' ORG_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' CURR_CD" ).append("\n"); 
		query.append(",'' FT_OVR_UND_DYS" ).append("\n"); 
		query.append(",'' CNTR_FT_RT_AMT" ).append("\n"); 
		query.append(",'' BZC_CHG_CALC" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("FROM	DMT_TRF_GRP" ).append("\n"); 
		query.append("WHERE	SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		TRF_SEQ			= @[trf_seq]" ).append("\n"); 
		query.append("AND		TRF_GRP_SEQ		= @[trf_grp_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}