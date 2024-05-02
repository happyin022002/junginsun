/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltStatusVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.16 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltStatusVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * C/Offer check
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltStatusVORSQL(){
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
		query.append("FileName : RFAProposalMainDBDAORsltStatusVORSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_AFIL                WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_DUR                 WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_DUR             WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_GRP_CMDT_DTL    WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_GRP_LOC_DTL     WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_NOTE_CTNT       WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT              WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_ACT_CUST     WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_CMDT         WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_CMDT_RNOTE   WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_CNOTE        WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_ROUT_PNT     WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_ROUT_VIA     WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1 UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT FROM PRI_RP_SCP_TRSP_ADD_CHG    WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND PRC_PROG_STS_CD = 'I' AND ROWNUM = 1" ).append("\n"); 

	}
}