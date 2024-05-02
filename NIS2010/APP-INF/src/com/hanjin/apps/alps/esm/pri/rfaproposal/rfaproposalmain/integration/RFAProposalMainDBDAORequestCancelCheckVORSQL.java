/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAProposalMainDBDAORequestCancelCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.03.24 공백진
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

public class RFAProposalMainDBDAORequestCancelCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAProposalMainDBDAORequestCancelCheckVORSQL
	  * </pre>
	  */
	public RFAProposalMainDBDAORequestCancelCheckVORSQL(){
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
		query.append("FileName : RFAProposalMainDBDAORequestCancelCheckVORSQL").append("\n"); 
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
		query.append("SELECT SUM(CNT) CNT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_AFIL" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_GRP_CMDT_DTL" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT " ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD  IN  ('A','R')" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_ACT_CUST" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_CMDT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_TRSP_ADD_CHG " ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD  IN  ('A','R')" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("#if (${amdt_seq} != '0')" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_DUR" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_SCP_DUR" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_DMDT" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND   PRC_PROG_STS_CD ='A'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}