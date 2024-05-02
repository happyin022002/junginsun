/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : RFATransportationAdditionalChargeProposalDBDAOCopyGuidelineArbitraryChargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.08.21 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAOCopyGuidelineArbitraryChargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * guideline copy
	  * 2014.06.12 전윤주 [CHM-201430680] Guideline Copy 시 Arbitrary Copy 가 되지 않는 현상 수정
	  * (MAX Seq. 찾아오는 쿼리 로직 수정)
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAOCopyGuidelineArbitraryChargeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAOCopyGuidelineArbitraryChargeCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_TRSP_ADD_CHG (" ).append("\n"); 
		query.append("	   PROP_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("     , ADD_CHG_TP_CD" ).append("\n"); 
		query.append("     , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , ADD_CHG_SEQ" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , BSE_PORT_TP_CD" ).append("\n"); 
		query.append("     , BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , RAT_UT_CD" ).append("\n"); 
		query.append("     , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("	 , MIN_CGO_WGT" ).append("\n"); 
		query.append("	 , MAX_CGO_WGT" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , SRC_INFO_CD" ).append("\n"); 
		query.append("     , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("	 , FIC_GLINE_RT_AMT" ).append("\n"); 
		query.append("     , FIC_GLINE_UPD_DT" ).append("\n"); 
		query.append("     , OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("     , FIC_ROUT_CMB_TP_CD" ).append("\n"); 
		query.append("     , FIC_RT_USE_STS_CD " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT @[prop_no] AS PROP_NO" ).append("\n"); 
		query.append("	 , @[amdt_seq] AS AMDT_SEQ" ).append("\n"); 
		query.append("	 , SVC_SCP_CD" ).append("\n"); 
		query.append("	 , 'A' AS ADD_CHG_TP_CD" ).append("\n"); 
		query.append("	 , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("	 , DENSE_RANK() OVER (PARTITION BY SVC_SCP_CD, GLINE_SEQ, ORG_DEST_TP_CD" ).append("\n"); 
		query.append("          ORDER BY SVC_SCP_CD, GLINE_SEQ, ORG_DEST_TP_CD, ARB_SEQ) AS ADD_CHG_SEQ" ).append("\n"); 
		query.append("	 , ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("	 , ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	 , BSE_PORT_TP_CD" ).append("\n"); 
		query.append("	 , BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("	 , RAT_UT_CD" ).append("\n"); 
		query.append("	 , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	 , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("	 , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("	 , MIN_CGO_WGT" ).append("\n"); 
		query.append("	 , MAX_CGO_WGT" ).append("\n"); 
		query.append("	 , CURR_CD" ).append("\n"); 
		query.append("	 , FRT_RT_AMT" ).append("\n"); 
		query.append("	 , 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append("	 , 'GC' AS SRC_INFO_CD" ).append("\n"); 
		query.append("     , @[amdt_seq] AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("	 , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("	 , FIC_GLINE_RT_AMT" ).append("\n"); 
		query.append("     , FIC_GLINE_UPD_DT" ).append("\n"); 
		query.append("     , OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("     , FIC_ROUT_CMB_TP_CD" ).append("\n"); 
		query.append("     , FIC_RT_USE_STS_CD " ).append("\n"); 
		query.append("  FROM PRI_RG_ARB" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND GLINE_SEQ = (SELECT MAX(GLINE_SEQ) AS GLINE_SEQ" ).append("\n"); 
		query.append("                      FROM PRI_RG_MN " ).append("\n"); 
		query.append("                     WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("                       AND TO_DATE(REPLACE(@[eff_dt],'-',''),'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("                       AND CFM_FLG = 'Y')" ).append("\n"); 

	}
}