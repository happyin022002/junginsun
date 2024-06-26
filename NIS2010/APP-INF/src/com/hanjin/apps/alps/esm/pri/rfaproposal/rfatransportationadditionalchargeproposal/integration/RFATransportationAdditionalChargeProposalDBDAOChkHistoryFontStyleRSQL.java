/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAOChkHistoryFontStyleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.28 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAOChkHistoryFontStyleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Amend History Font Style 조회
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAOChkHistoryFontStyleRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration ").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAOChkHistoryFontStyleRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN ORG_AMDT_CNT > 0 AND ORG_AMDT_CNT = ORG_ACPT_CNT THEN 'blue'" ).append("\n"); 
		query.append("ELSE 'nothing'" ).append("\n"); 
		query.append("END AS ORG_FONT_STYLE" ).append("\n"); 
		query.append(", CASE WHEN DEST_AMDT_CNT > 0 AND DEST_AMDT_CNT = DEST_ACPT_CNT THEN 'blue'" ).append("\n"); 
		query.append("ELSE 'nothing'" ).append("\n"); 
		query.append("END AS DEST_FONT_STYLE" ).append("\n"); 
		query.append(", ORG_ALL_CNT" ).append("\n"); 
		query.append(", DEST_ALL_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ORG_ALL_CNT, ORG_AMDT_CNT, ORG_ACPT_CNT, DEST_ALL_CNT, DEST_AMDT_CNT, DEST_ACPT_CNT, @[amdt_seq] AS AMDT_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT COUNT(*) AS ORG_ALL_CNT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT COUNT(*) AS ORG_AMDT_CNT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT COUNT(*) AS ORG_ACPT_CNT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("AND PRC_PROG_STS_CD = 'A'" ).append("\n"); 
		query.append("AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT COUNT(*) AS DEST_ALL_CNT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT COUNT(*) AS DEST_AMDT_CNT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT COUNT(*) AS DEST_ACPT_CNT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND PRC_PROG_STS_CD = 'A'" ).append("\n"); 
		query.append("AND N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}