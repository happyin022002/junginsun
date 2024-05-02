/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RFAProposalMainDBDAOSearchProposalRequestIhcRateCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOSearchProposalRequestIhcRateCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate - Request시 
	  *  Rate탭에 Guide 값이 0이 존재하는지 여부 체크
	  * </pre>
	  */
	public RFAProposalMainDBDAOSearchProposalRequestIhcRateCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOSearchProposalRequestIhcRateCheckRSQL").append("\n"); 
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
		query.append("SELECT TRS_JOIN_FNC(CURSOR (SELECT DISTINCT A.SVC_SCP_CD || '-'||'Bullet No.'||H.BLET_DP_SEQ||'-'" ).append("\n"); 
		query.append("                                   ||CASE WHEN NVL(A.FIC_ORG_PROP_RT_AMT, 0) = 0 AND R.ORG_CY_DOR_RT_TP_CD = 'D' THEN 'Origin'" ).append("\n"); 
		query.append("                                          WHEN NVL(A.FIC_DEST_PROP_RT_AMT, 0) = 0 AND R.DEST_CY_DOR_RT_TP_CD = 'D' THEN 'Destination'" ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                       FROM PRI_RP_SCP_RT           A," ).append("\n"); 
		query.append("                            PRI_RP_SCP_RT_CMDT_HDR  H," ).append("\n"); 
		query.append("                            PRI_RP_SCP_RT_CMDT_ROUT R" ).append("\n"); 
		query.append("                      WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                        AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                        AND A.N1ST_CMNC_AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND A.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("                        AND A.AMDT_SEQ = R.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND A.SVC_SCP_CD = R.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND A.CMDT_HDR_SEQ = R.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        AND A.ROUT_SEQ = R.ROUT_SEQ" ).append("\n"); 
		query.append("                        AND A.PROP_NO = H.PROP_NO" ).append("\n"); 
		query.append("                        AND A.AMDT_SEQ = H.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND A.SVC_SCP_CD = H.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND H.FIC_RT_TP_CD = 'A'" ).append("\n"); 
		query.append("                        AND NVL(A.FIC_PROP_RT_AMT, 0) = 0" ).append("\n"); 
		query.append("                        AND ((NVL(A.FIC_ORG_PROP_RT_AMT, 0) = 0 AND" ).append("\n"); 
		query.append("                            R.ORG_CY_DOR_RT_TP_CD = 'D') OR" ).append("\n"); 
		query.append("                            (NVL(A.FIC_DEST_PROP_RT_AMT, 0) = 0 AND" ).append("\n"); 
		query.append("                            R.DEST_CY_DOR_RT_TP_CD = 'D')))) RSLT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}