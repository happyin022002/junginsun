/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAProposalMainDBDAOApprovalCancelCheckChildrenRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.23 
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

public class RFAProposalMainDBDAOApprovalCancelCheckChildrenRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA에서 Approval Cancel 시 자식 Basic이 있는지 여부 체크 합니다.
	  * </pre>
	  */
	public RFAProposalMainDBDAOApprovalCancelCheckChildrenRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOApprovalCancelCheckChildrenRSQL").append("\n"); 
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
		query.append("WITH INPUT_PARAMS AS (" ).append("\n"); 
		query.append("    SELECT MN.PROP_NO, MN.AMDT_SEQ" ).append("\n"); 
		query.append("      FROM PRI_RP_MN MN, PRI_RP_HDR HDR" ).append("\n"); 
		query.append("     WHERE MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("       AND MN.RFA_CTRT_TP_CD = 'B'" ).append("\n"); 
		query.append("       AND MST_RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("       AND ORG_PROP_NO = @[prop_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT 'X' AS PROP_NO" ).append("\n"); 
		query.append("  FROM PRI_RFA_NOTE_CONV A, INPUT_PARAMS B" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND MST_RFA_ROUT_ID LIKE @[rfa_no] ||'_'|| LPAD(@[amdt_seq], 3, '0') ||'_%'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'X' AS PROP_NO" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT A, INPUT_PARAMS B" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND MST_RFA_ROUT_ID LIKE @[rfa_no] ||'_'|| LPAD(@[amdt_seq], 3, '0') ||'_%'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}