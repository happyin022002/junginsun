/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFAProposalMainDBDAOCheckRfaContractTpActCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.12
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.11.12 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOCheckRfaContractTpActCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Type이 Contract 일때 마지막으로 actual customer가 commodity 별로 같은지 check
	  * [CHM-201432702] 로직 변경 요청 - CY only / include IHC 를 구부하지 않고 각 scope별로 contract rfa의 cmdt 그룹내 a/customer는 모두 같아야 함, 개수상관없음. 동일고객(인원수 제약없음)
	  * </pre>
	  */
	public RFAProposalMainDBDAOCheckRfaContractTpActCustRSQL(){
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
		query.append("FileName : RFAProposalMainDBDAOCheckRfaContractTpActCustRSQL").append("\n"); 
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
		query.append("SELECT CASE" ).append("\n"); 
		query.append("		 WHEN MAX(ACT_CUST_BY_SVC_SCP_CNT) = 1 OR MAX(ACT_CUST_BY_SVC_SCP_CNT) IS NULL THEN '0'" ).append("\n"); 
		query.append("         ELSE '1'" ).append("\n"); 
		query.append("       END AS ACT_CUST_CNT_BY_SVC_SCP" ).append("\n"); 
		query.append("  FROM (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("             , COUNT(ACT_CUST) AS ACT_CUST_BY_SVC_SCP_CNT" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , PRI_UTILS_PKG.JOIN_ROWS_VAR_FUNC (CURSOR(SELECT DISTINCT ACT_CUST.CUST_CNT_CD||LPAD(TO_CHAR(ACT_CUST.CUST_SEQ),6,'0')" ).append("\n"); 
		query.append("                                  FROM PRI_RP_SCP_RT_ACT_CUST ACT_CUST" ).append("\n"); 
		query.append("                                 WHERE ACT_CUST.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                                   AND ACT_CUST.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                                   AND ACT_CUST.SVC_SCP_CD = A.SVC_SCP_CD ) , '/') AS ACT_CUST" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("							 )" ).append("\n"); 
		query.append("         GROUP BY SVC_SCP_CD " ).append("\n"); 
		query.append("        ) " ).append("\n"); 

	}
}