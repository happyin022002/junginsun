/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAOChkFontStyleVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.03.31 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCTransportationAdditionalChargeProposalDBDAOChkFontStyleVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ORIGIN과 DESTINATION의 글자폰트 스타일을 확인한다.
	  * </pre>
	  */
	public SCTransportationAdditionalChargeProposalDBDAOChkFontStyleVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : SCTransportationAdditionalChargeProposalDBDAOChkFontStyleVORSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN ORG_AMDT_CNT > 0 AND ORG_AMDT_CNT = ORG_ACPT_CNT AND LGCY_IF_FLG = 'N' THEN 'blue'" ).append("\n"); 
		query.append("            WHEN ORG_AMDT_CNT > 0 AND ORG_AMDT_CNT <> ORG_ACPT_CNT AND AMDT_SEQ > 0 AND LGCY_IF_FLG = 'N' THEN 'red'" ).append("\n"); 
		query.append("            WHEN ORG_ALL_CNT > 0 THEN 'bold'" ).append("\n"); 
		query.append("            ELSE 'nothing'" ).append("\n"); 
		query.append("       END AS ORG_FONT_STYLE" ).append("\n"); 
		query.append("     , CASE WHEN DEST_AMDT_CNT > 0 AND DEST_AMDT_CNT = DEST_ACPT_CNT AND LGCY_IF_FLG = 'N' THEN 'blue'" ).append("\n"); 
		query.append("            WHEN DEST_AMDT_CNT > 0 AND DEST_AMDT_CNT <> DEST_ACPT_CNT AND AMDT_SEQ > 0 AND LGCY_IF_FLG = 'N' THEN 'red'" ).append("\n"); 
		query.append("            WHEN DEST_ALL_CNT > 0 THEN 'bold'" ).append("\n"); 
		query.append("            ELSE 'nothing'" ).append("\n"); 
		query.append("       END AS DEST_FONT_STYLE" ).append("\n"); 
		query.append("	 , ORG_ALL_CNT" ).append("\n"); 
		query.append("	 , DEST_ALL_CNT" ).append("\n"); 
		query.append("  FROM (      " ).append("\n"); 
		query.append("        SELECT ORG_ALL_CNT, ORG_AMDT_CNT, ORG_ACPT_CNT, DEST_ALL_CNT, DEST_AMDT_CNT, DEST_ACPT_CNT, @[amdt_seq] AS AMDT_SEQ, LGCY_IF_FLG" ).append("\n"); 
		query.append("          FROM (SELECT COUNT(*) AS ORG_ALL_CNT" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("             , (SELECT COUNT(*) AS ORG_AMDT_CNT" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                   AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq])" ).append("\n"); 
		query.append("             , (SELECT COUNT(*) AS ORG_ACPT_CNT" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                   AND PRC_PROG_STS_CD = 'A'" ).append("\n"); 
		query.append("                   AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq])" ).append("\n"); 
		query.append("             , (SELECT COUNT(*) AS DEST_ALL_CNT" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("             , (SELECT COUNT(*) AS DEST_AMDT_CNT" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                   AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]) " ).append("\n"); 
		query.append("             , (SELECT COUNT(*) AS DEST_ACPT_CNT" ).append("\n"); 
		query.append("                  FROM PRI_SP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                   AND PRC_PROG_STS_CD = 'A'" ).append("\n"); 
		query.append("                   AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq])" ).append("\n"); 
		query.append("             , (SELECT LGCY_IF_FLG FROM PRI_SP_MN TMP WHERE TMP.PROP_NO = @[prop_no] AND TMP.AMDT_SEQ = @[amdt_seq])" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}