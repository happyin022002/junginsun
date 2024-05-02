/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAProposalMainDBDAORequestCheckForCalculationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.28 
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

public class RFAProposalMainDBDAORequestCheckForCalculationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request 시 check할 Terms를 조회한다.
	  * * History
	  * M/B 활성화를 위해 해당 scope의 calculate 여부를 가져온다.
	  * </pre>
	  */
	public RFAProposalMainDBDAORequestCheckForCalculationVORSQL(){
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORequestCheckForCalculationVORSQL").append("\n"); 
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
		query.append("SELECT   PROP_NO, AMDT_SEQ ,SVC_SCP_CD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("          SELECT   MN.PROP_NO,MN.AMDT_SEQ ,MN.SVC_SCP_CD " ).append("\n"); 
		query.append("          FROM     PRI_RP_SCP_MN MN" ).append("\n"); 
		query.append("          WHERE    MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("      		  AND  MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			  AND  MN.PRS_RT_CMPB_CALC_FLG = 'N'" ).append("\n"); 
		query.append("#if (${is_calc_chk} == '')" ).append("\n"); 
		query.append("			  AND  EXISTS (SELECT   1" ).append("\n"); 
		query.append("                           FROM     PRI_RP_SCP_RT RT" ).append("\n"); 
		query.append("                           WHERE    RT.PROP_NO        = MN.PROP_NO" ).append("\n"); 
		query.append("                                AND RT.AMDT_SEQ       = MN.AMDT_SEQ " ).append("\n"); 
		query.append("                                AND RT.SVC_SCP_CD     = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("								AND N1ST_CMNC_AMDT_SEQ = MN.AMDT_SEQ " ).append("\n"); 
		query.append("								AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("								AND PRC_PROG_STS_CD IN ('I','R')" ).append("\n"); 
		query.append("                                AND ROWNUM = 1" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${is_calc_chk} != '' && ${is_calc_chk} == 'Y')" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SVC_SCP_CD" ).append("\n"); 

	}
}