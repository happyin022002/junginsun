/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAOFICRouteByGlineRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.26
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.26 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAOFICRouteByGlineRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline을 이용한 Add-on, IHC, Combine Route의 Base Port 및 기본 Trans Mode를 조회한다.
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAOFICRouteByGlineRSQL(){
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAOFICRouteByGlineRSQL").append("\n"); 
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
		query.append("SELECT @[eff_dt] EFF_DT" ).append("\n"); 
		query.append("     , @[svc_scp_cd] SVC_SCP_CD" ).append("\n"); 
		query.append("     , @[rout_pnt_loc_def_cd] ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , @[bse_port_def_cd] BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , @[rcv_de_term_cd] RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , TRIM(REGEXP_SUBSTR(DATA, '[^|]+', 1, 2)) PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("	#if(${add_on_flag} == 'Y')" ).append("\n"); 
		query.append("		PRI_ADDON_RATE_CALCULATE_PKG.PRI_getFICArbTransByRoute_FNC(@[eff_dt], @[svc_scp_cd], @[org_dest_tp_cd], @[rout_pnt_loc_def_cd], @[bse_port_def_cd], @[rcv_de_term_cd]) DATA" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		PRI_FIC_RATE_CALCULATE_PKG.PRI_getFICArbTransByRoute_FNC(@[eff_dt], @[svc_scp_cd], @[rout_pnt_loc_def_cd], @[bse_port_def_cd], @[rcv_de_term_cd]) DATA" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("      FROM   DUAL)" ).append("\n"); 

	}
}