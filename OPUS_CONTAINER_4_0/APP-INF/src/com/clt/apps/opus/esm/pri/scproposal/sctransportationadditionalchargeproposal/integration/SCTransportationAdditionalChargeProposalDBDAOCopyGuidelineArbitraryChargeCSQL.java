/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAOCopyGuidelineArbitraryChargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.02
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2015.06.02 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kmy(Kyeongmi) Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCTransportationAdditionalChargeProposalDBDAOCopyGuidelineArbitraryChargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * guideline copy
	  * </pre>
	  */
	public SCTransportationAdditionalChargeProposalDBDAOCopyGuidelineArbitraryChargeCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : SCTransportationAdditionalChargeProposalDBDAOCopyGuidelineArbitraryChargeCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_TRSP_ADD_CHG (" ).append("\n"); 
		query.append("   	   PROP_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("     , ADD_CHG_TP_CD" ).append("\n"); 
		query.append("     , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , ADD_CHG_SEQ" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , BSE_PORT_TP_CD" ).append("\n"); 
		query.append("     , BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , VIA_PORT_TP_CD" ).append("\n"); 
		query.append("     , VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("     , DIR_CALL_FLG" ).append("\n"); 
		query.append("     , RAT_UT_CD" ).append("\n"); 
		query.append("     , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("	 , GRI_APPL_TP_CD" ).append("\n"); 
		query.append("	 , GRI_APPL_AMT" ).append("\n"); 
		query.append("     , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , SRC_INFO_CD" ).append("\n"); 
		query.append("     , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[prop_no] AS PROP_NO " ).append("\n"); 
		query.append("     , @[amdt_seq] AS AMDT_SEQ" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("	 , DECODE (RCV_DE_TERM_CD, 'D', 'I', 'A') AS ADD_CHG_TP_CD" ).append("\n"); 
		query.append("	 , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("	 , DENSE_RANK() OVER (PARTITION BY SVC_SCP_CD, GLINE_SEQ, ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     	ORDER BY SVC_SCP_CD, GLINE_SEQ, ORG_DEST_TP_CD, ARB_SEQ) AS ADD_CHG_SEQ" ).append("\n"); 
		query.append("	 , ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("	 , ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	 , BSE_PORT_TP_CD" ).append("\n"); 
		query.append("	 , BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("	 , VIA_PORT_TP_CD" ).append("\n"); 
		query.append("	 , VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	 , DIR_CALL_FLG" ).append("\n"); 
		query.append("	 , RAT_UT_CD" ).append("\n"); 
		query.append("	 , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	 , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("	 , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("	 , CURR_CD" ).append("\n"); 
		query.append("	 , FRT_RT_AMT" ).append("\n"); 
		query.append("	 , 'N'" ).append("\n"); 
		query.append("	 , 0" ).append("\n"); 
		query.append("	 , 'I' AS SRC_INFO_CD" ).append("\n"); 
		query.append("	 , 'GC' AS SRC_INFO_CD" ).append("\n"); 
		query.append("     , @[amdt_seq] AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM PRI_SG_ARB" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND GLINE_SEQ = (SELECT MAX(GLINE_SEQ) AS GLINE_SEQ" ).append("\n"); 
		query.append("                      FROM PRI_SG_MN " ).append("\n"); 
		query.append("                     WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("                       AND TO_DATE(REPLACE(@[eff_dt],'-',''),'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("                       AND CFM_FLG = 'Y')" ).append("\n"); 

	}
}