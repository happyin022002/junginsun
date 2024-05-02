/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAORsltFicGuidelineRateForAddOnTariffVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.06
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.12.06 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltFicGuidelineRateForAddOnTariffVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * adsf 
	  * </pre>
	  */
	public RFARateProposalDBDAORsltFicGuidelineRateForAddOnTariffVORSQL(){
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
		params.put("in_org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltFicGuidelineRateForAddOnTariffVORSQL").append("\n"); 
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
		query.append("SELECT H_SEQ" ).append("\n"); 
		query.append(", ROUT_DP_SEQ" ).append("\n"); 
		query.append(", CMDT_DP_SEQ" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 1) FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 2) FIC_ROUT_CMB_TP_CD" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 3) OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 4) GROUP_NO" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 5) DR_20FT_AMT" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 6) RF_20FT_AMT" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 7) DG_20FT_AMT" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 8) DR_40FT_AMT" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 9) RF_40FT_AMT" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 10) DG_40FT_AMT" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 11) LOC_CURR_CD" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 12) DR_LOC_20FT_AMT" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 13) RF_LOC_20FT_AMT" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 14) DG_LOC_20FT_AMT" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 15) DR_LOC_40FT_AMT" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 16) RF_LOC_40FT_AMT" ).append("\n"); 
		query.append(", REGEXP_SUBSTR(FIC_RT_RSLT, '[^|]+', 1, 17) DG_LOC_40FT_AMT" ).append("\n"); 
		query.append(", '' AS BASE_PORT_LIST" ).append("\n"); 
		query.append(", cmdt_dp_seq || '|' || rout_dp_seq AS cmdt_rout" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#if (${in_org_dest_tp_cd} == 'D' )" ).append("\n"); 
		query.append("	#foreach( ${route} in ${route_list}) " ).append("\n"); 
		query.append("		#if($velocityCount != 1 ) " ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			'$route.getHSeq()' AS h_seq" ).append("\n"); 
		query.append("			,'$route.getDestRoutPntLocDefCd()' AS rout_pnt_loc_def_cd" ).append("\n"); 
		query.append("			,'$route.getDestRoutViaPortDefCd()' AS rout_via_port_def_cd" ).append("\n"); 
		query.append("			,'$route.getRoutDpSeq()' AS rout_dp_seq" ).append("\n"); 
		query.append("			,'$route.getCmdtDpSeq()' AS cmdt_dp_seq" ).append("\n"); 
		query.append("			,'$route.getDestPrcTrspModNm()' AS prc_trsp_mod_cd" ).append("\n"); 
		query.append("			,'$route.getDestRcvDeTermNm()' AS rcv_de_term_cd" ).append("\n"); 
		query.append("			, PRI_ADDON_RATE_CALCULATE_PKG.PRI_getFICRouteGroup_FNC(@[eff_dt], @[svc_scp_cd], @[in_org_dest_tp_cd], '$route.getDestRoutPntLocDefCd()', '$route.getDestRoutViaPortDefCd()','$route.getDestRcvDeTermNm()', '$route.getDestPrcTrspModNm()') AS FIC_RT_RSLT" ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#foreach( ${route} in ${route_list}) " ).append("\n"); 
		query.append("		#if($velocityCount != 1 ) " ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			'$route.getHSeq()' AS h_seq" ).append("\n"); 
		query.append("			,'$route.getOrgRoutPntLocDefCd()' AS rout_pnt_loc_def_cd" ).append("\n"); 
		query.append("			,'$route.getOrgRoutViaPortDefCd()' AS rout_via_port_def_cd" ).append("\n"); 
		query.append("			,'$route.getRoutDpSeq()' AS rout_dp_seq" ).append("\n"); 
		query.append("			,'$route.getCmdtDpSeq()' AS cmdt_dp_seq" ).append("\n"); 
		query.append("			,'$route.getOrgPrcTrspModNm()' AS prc_trsp_mod_cd" ).append("\n"); 
		query.append("			,'$route.getOrgRcvDeTermNm()' AS rcv_de_term_cd" ).append("\n"); 
		query.append("			, PRI_ADDON_RATE_CALCULATE_PKG.PRI_getFICRouteGroup_FNC(@[eff_dt], @[svc_scp_cd], @[in_org_dest_tp_cd], '$route.getOrgRoutPntLocDefCd()', '$route.getOrgRoutViaPortDefCd()','$route.getOrgRcvDeTermNm()', '$route.getOrgPrcTrspModNm()') AS FIC_RT_RSLT" ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}