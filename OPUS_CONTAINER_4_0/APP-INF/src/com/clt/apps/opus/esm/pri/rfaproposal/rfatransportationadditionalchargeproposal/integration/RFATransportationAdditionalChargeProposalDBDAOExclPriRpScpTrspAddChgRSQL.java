/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAOExclPriRpScpTrspAddChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.13 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAOExclPriRpScpTrspAddChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * excel upload시 PRI_RP_SCP_TRSP_ADD_CHG 테이블 조회
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAOExclPriRpScpTrspAddChgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAOExclPriRpScpTrspAddChgRSQL").append("\n"); 
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
		query.append("PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	ADD_CHG_TP_CD" ).append("\n"); 
		query.append(",	ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",	ADD_CHG_SEQ" ).append("\n"); 
		query.append(",	ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",	ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",	BSE_PORT_TP_CD" ).append("\n"); 
		query.append(",	BSE_PORT_DEF_CD" ).append("\n"); 
		query.append(",	RAT_UT_CD" ).append("\n"); 
		query.append(",	PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",	MIN_CGO_WGT" ).append("\n"); 
		query.append(",	MAX_CGO_WGT" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",	PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("AND	ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("ORDER BY ADD_CHG_SEQ" ).append("\n"); 

	}
}