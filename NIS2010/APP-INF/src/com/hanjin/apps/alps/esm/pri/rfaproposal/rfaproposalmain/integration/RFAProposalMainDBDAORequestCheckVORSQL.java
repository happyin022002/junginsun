/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAProposalMainDBDAORequestCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.04.19 공백진
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

public class RFAProposalMainDBDAORequestCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request 시 check할 Terms를 조회한다.
	  * </pre>
	  */
	public RFAProposalMainDBDAORequestCheckVORSQL(){
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
		query.append("FileName : RFAProposalMainDBDAORequestCheckVORSQL").append("\n"); 
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
		query.append("SELECT 'AMEND' TERMS" ).append("\n"); 
		query.append("       ,SUM(CNT) CNT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT FROM PRI_RP_AMDT_SMRY" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(*) FROM PRI_RP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   '[' || B.SVC_SCP_CD || '] RATE' TERMS" ).append("\n"); 
		query.append("        ,COUNT (A.SVC_SCP_CD) CNT" ).append("\n"); 
		query.append("FROM     PRI_RP_SCP_RT A" ).append("\n"); 
		query.append("        ,(SELECT SVC_SCP_CD,PROP_NO,AMDT_SEQ" ).append("\n"); 
		query.append("          FROM   PRI_RP_SCP_MN" ).append("\n"); 
		query.append("          WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("          AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("         ) B " ).append("\n"); 
		query.append("WHERE    B.PROP_NO = A.PROP_NO(+) " ).append("\n"); 
		query.append("AND      B.AMDT_SEQ = A.AMDT_SEQ(+) " ).append("\n"); 
		query.append("AND      B.SVC_SCP_CD = A.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND 	 A.SRC_INFO_CD (+) <> 'AD'" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '[' || SVC_SCP_CD || '] Rate Commodity Group Detail'" ).append("\n"); 
		query.append("          ,DECODE (COUNT (*), 0, 1, 0)" ).append("\n"); 
		query.append("FROM   (                                         --Rate Commodity Group Detail" ).append("\n"); 
		query.append("        SELECT DISTINCT SVC_SCP_CD,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        FROM   PRI_RP_SCP_RT_CMDT" ).append("\n"); 
		query.append("        WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("		AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        MINUS" ).append("\n"); 
		query.append("        SELECT DISTINCT SVC_SCP_CD" ).append("\n"); 
		query.append("                           ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        FROM   PRI_RP_SCP_RT_ROUT_PNT" ).append("\n"); 
		query.append("        WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("		AND    SRC_INFO_CD <> 'AD')" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD" ).append("\n"); 

	}
}