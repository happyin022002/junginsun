/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpScpMnPrsCalcFlgOnRtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpScpMnPrsCalcFlgOnRtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate수정시 Scope Main테이블의 PrsCalc.컬럼업데이트
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpScpMnPrsCalcFlgOnRtUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpScpMnPrsCalcFlgOnRtUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_MN M" ).append("\n"); 
		query.append("   SET PRS_GEN_RT_CMPB_CALC_FLG  = NVL((SELECT DECODE(COUNT(*)" ).append("\n"); 
		query.append("                                                    ,0" ).append("\n"); 
		query.append("                                                    ,'N'" ).append("\n"); 
		query.append("                                                    ,M.PRS_GEN_RT_CMPB_CALC_FLG)" ).append("\n"); 
		query.append("                                         FROM PRI_SP_SCP_RT R" ).append("\n"); 
		query.append("                                        WHERE R.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("                                          AND R.AMDT_SEQ = M.AMDT_SEQ" ).append("\n"); 
		query.append("                                          AND R.SVC_SCP_CD = M.SVC_SCP_CD" ).append("\n"); 
		query.append("                                          AND R.GEN_SPCL_RT_TP_CD = 'G'" ).append("\n"); 
		query.append("                                          AND R.AMDT_SEQ =" ).append("\n"); 
		query.append("                                              R.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                                          AND R.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                                        GROUP BY R.PROP_NO" ).append("\n"); 
		query.append("                                                ,R.AMDT_SEQ" ).append("\n"); 
		query.append("                                                ,R.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                ,R.GEN_SPCL_RT_TP_CD)" ).append("\n"); 
		query.append("                                      ,'N')" ).append("\n"); 
		query.append("      ,PRS_SPCL_RT_CMPB_CALC_FLG = NVL((SELECT DECODE(COUNT(*)" ).append("\n"); 
		query.append("                                                    ,0" ).append("\n"); 
		query.append("                                                    ,'N'" ).append("\n"); 
		query.append("                                                    ,M.PRS_SPCL_RT_CMPB_CALC_FLG)" ).append("\n"); 
		query.append("                                         FROM PRI_SP_SCP_RT R" ).append("\n"); 
		query.append("                                        WHERE R.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("                                          AND R.AMDT_SEQ = M.AMDT_SEQ" ).append("\n"); 
		query.append("                                          AND R.SVC_SCP_CD = M.SVC_SCP_CD" ).append("\n"); 
		query.append("                                          AND R.GEN_SPCL_RT_TP_CD = 'S'" ).append("\n"); 
		query.append("                                          AND R.AMDT_SEQ =" ).append("\n"); 
		query.append("                                              R.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                                          AND R.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                                        GROUP BY R.PROP_NO" ).append("\n"); 
		query.append("                                                ,R.AMDT_SEQ" ).append("\n"); 
		query.append("                                                ,R.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                ,R.GEN_SPCL_RT_TP_CD)" ).append("\n"); 
		query.append("                                      ,'N')" ).append("\n"); 
		query.append(" WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 

	}
}