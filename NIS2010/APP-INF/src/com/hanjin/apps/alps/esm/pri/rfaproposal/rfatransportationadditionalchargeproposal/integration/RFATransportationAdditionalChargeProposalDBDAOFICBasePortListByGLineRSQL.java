/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAOFICBasePortListByGLineRSQL.java
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

public class RFATransportationAdditionalChargeProposalDBDAOFICBasePortListByGLineRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guide Line을 이용하여 FIC Base Port List를 조회한다.
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAOFICBasePortListByGLineRSQL(){
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAOFICBasePortListByGLineRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("#if(${add_on_flag} == 'Y')" ).append("\n"); 
		query.append("	PRI_ADDON_RATE_CALCULATE_PKG.PRI_getBasePortList_FNC(REPLACE(@[eff_dt], '-', ''), @[svc_scp_cd], @[org_dest_tp_cd], @[rout_pnt_loc_def_cd], @[rcv_de_term_cd], NULL, 'Y') BSE_PORT_DEF_CD	" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	PRI_FIC_RATE_CALCULATE_PKG.PRI_getBasePortList_FNC(REPLACE(@[eff_dt], '-', ''), @[svc_scp_cd], @[rout_pnt_loc_def_cd], @[rcv_de_term_cd], NULL, 'Y') BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}