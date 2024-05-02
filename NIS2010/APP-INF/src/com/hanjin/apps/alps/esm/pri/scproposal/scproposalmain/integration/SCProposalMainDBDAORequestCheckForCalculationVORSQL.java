/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORequestCheckForCalculationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.04.20 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORequestCheckForCalculationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request 시 Calc Flag를 조회한다.
	  * US 612 는 제외한다.
	  * </pre>
	  */
	public SCProposalMainDBDAORequestCheckForCalculationVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORequestCheckForCalculationVORSQL").append("\n"); 
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
		query.append("SELECT   PROP_NO, AMDT_SEQ ,SVC_SCP_CD, GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("          SELECT   MN.PROP_NO,MN.AMDT_SEQ ,SVC_SCP_CD, 'G' AS GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("          FROM     PRI_SP_SCP_MN MN" ).append("\n"); 
		query.append("          WHERE    MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("      		  AND  MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			  AND  MN.PRS_GEN_RT_CMPB_CALC_FLG = 'N'" ).append("\n"); 
		query.append("			  AND  EXISTS (SELECT   1" ).append("\n"); 
		query.append("                           FROM     PRI_SP_SCP_RT RT" ).append("\n"); 
		query.append("                           WHERE    RT.PROP_NO        = MN.PROP_NO" ).append("\n"); 
		query.append("                                AND RT.AMDT_SEQ       = MN.AMDT_SEQ " ).append("\n"); 
		query.append("                                AND MN.SVC_SCP_CD     = SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND GEN_SPCL_RT_TP_CD = 'G'" ).append("\n"); 
		query.append("								AND N1ST_CMNC_AMDT_SEQ = MN.AMDT_SEQ " ).append("\n"); 
		query.append("								AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("								AND PRC_PROG_STS_CD IN ('I','R')" ).append("\n"); 
		query.append("                                AND ROWNUM = 1" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT   MN.PROP_NO,MN.AMDT_SEQ ,SVC_SCP_CD, 'S' AS GEN_SPCL_RT_TP_CD " ).append("\n"); 
		query.append("          FROM     PRI_SP_SCP_MN MN" ).append("\n"); 
		query.append("          WHERE    MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("      		  AND  MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			  AND  MN.PRS_SPCL_RT_CMPB_CALC_FLG = 'N'" ).append("\n"); 
		query.append("			  AND  EXISTS (SELECT   1" ).append("\n"); 
		query.append("                           FROM     PRI_SP_SCP_RT RT" ).append("\n"); 
		query.append("                           WHERE    RT.PROP_NO        = MN.PROP_NO" ).append("\n"); 
		query.append("                                AND RT.AMDT_SEQ       = MN.AMDT_SEQ " ).append("\n"); 
		query.append("                                AND MN.SVC_SCP_CD     = SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND GEN_SPCL_RT_TP_CD = 'S'" ).append("\n"); 
		query.append("								AND N1ST_CMNC_AMDT_SEQ = MN.AMDT_SEQ " ).append("\n"); 
		query.append("								AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("								AND PRC_PROG_STS_CD IN ('I','R')" ).append("\n"); 
		query.append("                                AND ROWNUM = 1" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NOT EXISTS (" ).append("\n"); 
		query.append("                    SELECT 1 FROM PRI_SP_CTRT_PTY " ).append("\n"); 
		query.append("                    WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                    AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                    AND CUST_CNT_CD ='US'" ).append("\n"); 
		query.append("                    AND CUST_SEQ = 612" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("ORDER BY SVC_SCP_CD, GEN_SPCL_RT_TP_CD" ).append("\n"); 

	}
}