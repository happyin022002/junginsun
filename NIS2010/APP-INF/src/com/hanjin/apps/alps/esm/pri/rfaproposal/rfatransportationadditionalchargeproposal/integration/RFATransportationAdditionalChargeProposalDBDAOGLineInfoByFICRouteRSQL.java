/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAOGLineInfoByFICRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.29
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.11.29 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAOGLineInfoByFICRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Route 정보를 이용하여 Guideline 정보를 조회한다.
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAOGLineInfoByFICRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_pnt_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_port_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAOGLineInfoByFICRouteRSQL").append("\n"); 
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
		query.append("SELECT REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 1) FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 2) FIC_ROUT_CMB_TP_CD" ).append("\n"); 
		query.append("     , REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 3) OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("     , TRIM(REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 4)) FIC_GLINE_RT_AMT" ).append("\n"); 
		query.append("     , TRIM(REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 5)) FIC_LOCL_CURR_CD" ).append("\n"); 
		query.append("     , TRIM(REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 6)) FIC_GLINE_LOCL_RT_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(SYSDATE, 'YYYYMMDD') FIC_GLINE_UPD_DT" ).append("\n"); 
		query.append("	 , '' AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	, '' AS AMDT_SEQ" ).append("\n"); 
		query.append("	, '' AS SVC_SCP_CD" ).append("\n"); 
		query.append("	, '' AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	, '' AS RAT_UT_CD" ).append("\n"); 
		query.append("	, '' AS PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("	, '' AS BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("	, '' AS EFF_DT" ).append("\n"); 
		query.append("	, '' AS TRF_NO" ).append("\n"); 
		query.append("	, '' AS PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("	, '' AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append("	, '' AS EXP_DT " ).append("\n"); 
		query.append("	, '' AS CURR_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("#if(${add_on_flag} == 'Y')" ).append("\n"); 
		query.append("	PRI_ADDON_RATE_CALCULATE_PKG.PRI_getFICArbRateByRoute_FNC(@[eff_dt],@[svc_scp_cd], @[org_dest_tp_cd]," ).append("\n"); 
		query.append("                                                                   @[rout_pnt_loc_def_cd]," ).append("\n"); 
		query.append("                                                                   @[bse_port_def_cd]," ).append("\n"); 
		query.append("                                                                   @[rcv_de_term_cd]," ).append("\n"); 
		query.append("                                                                   @[prc_trsp_mod_cd]," ).append("\n"); 
		query.append("                                                                   NVL(@[rat_ut_cd], 'D2')," ).append("\n"); 
		query.append("                                                                   NVL(@[prc_cgo_tp_cd], 'RF'))  FIC_RT_USE_STS_CD, 'A' AS CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	PRI_FIC_RATE_CALCULATE_PKG.PRI_getFICArbRateByRoute_FNC(@[eff_dt],@[svc_scp_cd]," ).append("\n"); 
		query.append("                                                                   @[rout_pnt_loc_def_cd]," ).append("\n"); 
		query.append("                                                                   @[bse_port_def_cd]," ).append("\n"); 
		query.append("                                                                   @[rcv_de_term_cd]," ).append("\n"); 
		query.append("                                                                   @[prc_trsp_mod_cd]," ).append("\n"); 
		query.append("                                                                   NVL(@[rat_ut_cd], 'D2')," ).append("\n"); 
		query.append("                                                                   NVL(@[prc_cgo_tp_cd], 'RF'))  FIC_RT_USE_STS_CD , 'A' AS CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT '', 'B' " ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CD = 'A'" ).append("\n"); 

	}
}