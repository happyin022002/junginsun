/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAProposalMainDBDAOApprovedMstInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19 
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

public class RFAProposalMainDBDAOApprovedMstInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic RFA Amend 시 승인된 Max Amdt Seq Master RFA 정보를 조회한다.
	  * </pre>
	  */
	public RFAProposalMainDBDAOApprovedMstInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOApprovedMstInfoRSQL").append("\n"); 
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
		query.append("    SELECT MN.PROP_NO" ).append("\n"); 
		query.append("         , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("    FROM PRI_RP_MN MN" ).append("\n"); 
		query.append("       , PRI_RP_HDR HDR" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND   MN.RFA_CTRT_TP_CD = 'M'" ).append("\n"); 
		query.append("    AND   HDR.RFA_NO = @[mst_rfa_no]" ).append("\n"); 
		query.append("    AND   HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("    AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("    GROUP BY MN.PROP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,DUR.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(MN.EFF_DT, 'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(DUR.CTRT_EXP_DT, 'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("FROM   PRI_RP_MN MN" ).append("\n"); 
		query.append("      ,PRI_RP_SCP_DUR DUR" ).append("\n"); 
		query.append("      ,INPUT_PARAMS INP" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = INP.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = INP.AMDT_SEQ" ).append("\n"); 
		query.append("AND    DUR.PROP_NO = MN.PROP_NO " ).append("\n"); 
		query.append("AND    DUR.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 

	}
}