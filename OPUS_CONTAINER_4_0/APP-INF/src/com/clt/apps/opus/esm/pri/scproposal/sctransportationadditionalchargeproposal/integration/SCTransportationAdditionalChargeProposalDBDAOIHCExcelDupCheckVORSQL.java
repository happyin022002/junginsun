/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAOIHCExcelDupCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.03.11 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCTransportationAdditionalChargeProposalDBDAOIHCExcelDupCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * load excel시 기존 데이터와의 중복 체크를 위하여 기존에 입력되어 있는 데이터를 조회한다.
	  * </pre>
	  */
	public SCTransportationAdditionalChargeProposalDBDAOIHCExcelDupCheckVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : SCTransportationAdditionalChargeProposalDBDAOIHCExcelDupCheckVORSQL").append("\n"); 
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
		query.append("SELECT   ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("        ,PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("        ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("        ,BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("        ,RAT_UT_CD" ).append("\n"); 
		query.append("        ,PRC_CGO_TP_CD" ).append("\n"); 
		query.append("        ,CURR_CD" ).append("\n"); 
		query.append("FROM     PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("     AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("     AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("     AND ADD_CHG_TP_CD = 'I'" ).append("\n"); 
		query.append("     AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("     AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("     AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}