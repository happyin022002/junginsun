/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchCntrRepoExecutionPlanEstablishRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.20 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOSearchCntrRepoExecutionPlanEstablishRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Scenario VesselResidualCapa 데이터 검색
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchCntrRepoExecutionPlanEstablishRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frWeek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toWeek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchCntrRepoExecutionPlanEstablishRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", ECC ECC_CD" ).append("\n"); 
		query.append(", VSL_LANE_CD" ).append("\n"); 
		query.append(", VVD" ).append("\n"); 
		query.append("--  , SUM(VSL_BSA_SPC), SUM(VSL_BSA_WGT)" ).append("\n"); 
		query.append(", SUM(VSL_BSA_SPC) vsl_bsa_spc" ).append("\n"); 
		query.append("--  , SUM(VSL_FULL_SPC),SUM(VSL_FULL_WGT)" ).append("\n"); 
		query.append(", SUM(VSL_FULL_SPC)	vsl_full_spc" ).append("\n"); 
		query.append(", SUM(VSL_DEAD_SPC) vsl_dead_spc" ).append("\n"); 
		query.append("--  , SUM(VSL_RSDL_SPC),SUM(VSL_RSDL_WGT)" ).append("\n"); 
		query.append(", SUM(VSL_RSDL_SPC)	vsl_rsdl_spc" ).append("\n"); 
		query.append(", SUM(VSL_SPC) vsl_spc" ).append("\n"); 
		query.append("--  , SUM(TTL_RSDL_SPC),SUM(TTL_RSDL_WGT)" ).append("\n"); 
		query.append(", SUM(TTL_RSDL_SPC)	ttl_rsdl_spc" ).append("\n"); 
		query.append(", MAX(SCNR_ID)  scnr_id_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if(${TypeBy} == 'R')" ).append("\n"); 
		query.append("rcc_cd -- By RCC" ).append("\n"); 
		query.append("#elseif(${TypeBy} == 'C')" ).append("\n"); 
		query.append("cnt_cd -- BY Country" ).append("\n"); 
		query.append("#elseif(${TypeBy} == 'L')" ).append("\n"); 
		query.append("lcc_cd -- BY LCC" ).append("\n"); 
		query.append("#elseif(${TypeBy} == 'E' || ${TypeBy} == '')" ).append("\n"); 
		query.append("ecc_cd -- BY ECC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CA.ecc_cd = ecc_cd" ).append("\n"); 
		query.append(") ECC" ).append("\n"); 
		query.append(", VSL_LANE_CD" ).append("\n"); 
		query.append(", VSL_CD|| SKD_VOY_NO||SKD_DIR_CD  VVD" ).append("\n"); 
		query.append(", VSL_BSA_SPC" ).append("\n"); 
		query.append("--		, VSL_BSA_WGT" ).append("\n"); 
		query.append(", VSL_FULL_SPC" ).append("\n"); 
		query.append("--	 	, VSL_FULL_WGT" ).append("\n"); 
		query.append(", VSL_DEAD_SPC" ).append("\n"); 
		query.append(", VSL_BSA_SPC - ( VSL_FULL_SPC + VSL_DEAD_SPC )  VSL_RSDL_SPC" ).append("\n"); 
		query.append("-- 		, VSL_BSA_WGT - VSL_FULL_WGT   VSL_RSDL_WGT" ).append("\n"); 
		query.append(", VSL_SPC" ).append("\n"); 
		query.append("--		, VSL_WGT" ).append("\n"); 
		query.append(", VSL_BSA_SPC - ( VSL_FULL_SPC + VSL_DEAD_SPC ) TTL_RSDL_SPC" ).append("\n"); 
		query.append("--		, VSL_BSA_WGT - VSL_FULL_WGT TTL_RSDL_WGT" ).append("\n"); 
		query.append(", SCNR_ID    -- key : hidden" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_VSL_RSDL_CAPA CA" ).append("\n"); 
		query.append(", EQR_ECC_MST EM" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CA.ECC_CD = EM.ECC_CD" ).append("\n"); 
		query.append("AND SCNR_ID = @[scnrId]" ).append("\n"); 
		query.append("AND CA.FCAST_YRWK BETWEEN @[frWeek] AND @[toWeek]" ).append("\n"); 
		query.append("-- LOC Type" ).append("\n"); 
		query.append("#if(${locCd} == 'R')" ).append("\n"); 
		query.append("-- RCC" ).append("\n"); 
		query.append("AND EM.RCC_CD IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrLocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrLocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif(${locCd} == 'L')" ).append("\n"); 
		query.append("-- LCC" ).append("\n"); 
		query.append("AND EM.LCC_CD IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrLocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrLocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif(${locCd} == 'E')" ).append("\n"); 
		query.append("-- ECC" ).append("\n"); 
		query.append("AND EM.ECC_CD IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrLocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrLocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${lane} != '')" ).append("\n"); 
		query.append("AND CA.VSL_LANE_CD IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrLane})" ).append("\n"); 
		query.append("#if($velocityCount < $arrLane.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vvd} != '')" ).append("\n"); 
		query.append("AND CA.VSL_CD||CA.SKD_VOY_NO||CA.SKD_DIR_CD IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrVvd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrVvd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Company---------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", ECC,VSL_LANE_CD" ).append("\n"); 
		query.append(", VVD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(",ECC" ).append("\n"); 
		query.append(",VSL_LANE_CD" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 

	}
}