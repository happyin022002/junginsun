/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchBasicTariffInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.02
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.10.02 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchBasicTariffInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BasicTariff 정보 조회
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchBasicTariffInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchBasicTariffInfoRSQL").append("\n"); 
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
		query.append("SELECT	SYS_AREA_GRP_ID, DMDT_TRF_CD, TRF_SEQ, DMDT_DE_TERM_CD, TRF_GRP_SEQ, " ).append("\n"); 
		query.append("        DECODE(@[dmdt_chg_loc_div_cd], 'TSP', 'N', XCLD_SAT_FLG) XCLD_SAT_FLG," ).append("\n"); 
		query.append("        DECODE(@[dmdt_chg_loc_div_cd], 'TSP', 'N', XCLD_SUN_FLG) XCLD_SUN_FLG," ).append("\n"); 
		query.append("        DECODE(@[dmdt_chg_loc_div_cd], 'TSP', 'N', XCLD_HOL_FLG) XCLD_HOL_FLG," ).append("\n"); 
		query.append("        DMDT_CHG_CMNC_TP_CD, CMNC_HR, CURR_CD, DMDT_TRF_GRP_TP_CD  " ).append("\n"); 
		query.append("FROM	DMT_TRF_GRP" ).append("\n"); 
		query.append("WHERE	SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD		= @[dmdt_trf_cd]	" ).append("\n"); 
		query.append("AND		TRF_SEQ			= @[trf_seq]" ).append("\n"); 
		query.append("AND     DMDT_DE_TERM_CD = @[dmdt_de_term_cd]" ).append("\n"); 
		query.append("AND		TRF_GRP_SEQ		= @[trf_grp_seq]" ).append("\n"); 

	}
}