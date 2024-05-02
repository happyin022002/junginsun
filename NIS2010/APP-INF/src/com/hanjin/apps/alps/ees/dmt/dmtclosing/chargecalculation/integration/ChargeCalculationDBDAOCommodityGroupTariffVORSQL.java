/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOCommodityGroupTariffVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.18 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOCommodityGroupTariffVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commodity Exception Tariff의 Free Time일수 및 주말, 공휴일 포함 여부를 조회한다
	  * </pre>
	  */
	public ChargeCalculationDBDAOCommodityGroupTariffVORSQL(){
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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOCommodityGroupTariffVORSQL").append("\n"); 
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
		query.append("SELECT	CMDT_ADD_DYS AS ADD_DYS" ).append("\n"); 
		query.append(",CMDT_TTL_DYS AS TTL_DYS" ).append("\n"); 
		query.append(",XCLD_SAT_FLG" ).append("\n"); 
		query.append(",XCLD_SUN_FLG" ).append("\n"); 
		query.append(",XCLD_HOL_FLG" ).append("\n"); 
		query.append(",M.REP_CMDT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' CMDT_EXPT_APLY_DT" ).append("\n"); 
		query.append(",'' CMDT_CD" ).append("\n"); 
		query.append(",'' CMDT_OVR_DYS" ).append("\n"); 
		query.append(",'' CURR_CD" ).append("\n"); 
		query.append(",'' CMDT_EXPT_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CMDT_GRP	G," ).append("\n"); 
		query.append("MDM_COMMODITY	M" ).append("\n"); 
		query.append("WHERE	G.SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND     G.DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		G.TRF_SEQ			= @[trf_seq]" ).append("\n"); 
		query.append("AND		G.CMDT_CD			= @[cmdt_cd]" ).append("\n"); 
		query.append("AND		G.CMDT_TRF_SEQ		= @[cmdt_trf_seq]" ).append("\n"); 
		query.append("AND     G.DELT_FLG			= 'N'" ).append("\n"); 
		query.append("AND		G.CMDT_CD			= M.CMDT_CD" ).append("\n"); 

	}
}