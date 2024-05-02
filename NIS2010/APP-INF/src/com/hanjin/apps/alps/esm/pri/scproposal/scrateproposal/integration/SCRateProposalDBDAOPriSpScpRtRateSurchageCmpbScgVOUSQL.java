/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtRateSurchageCmpbScgVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 김효정
*@LastVersion : 1.0
* 2010.04.14 김효정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtRateSurchageCmpbScgVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtRateSurchageCmpbScgVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtRateSurchageCmpbScgVOUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_SP_SCP_RT RT" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT SUM(ADJ_SCG_USD_AMT)  AS ADJ_SCG_AMT" ).append("\n"); 
		query.append("                ,PROP_NO ,AMDT_SEQ ,SVC_SCP_CD ,GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ ,ROUT_SEQ ,RT_SEQ" ).append("\n"); 
		query.append("        FROM PRI_SP_SCP_RT_SCG" ).append("\n"); 
		query.append("        WHERE   PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("            AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("            AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("            AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("#if (${UPDATE_LEVEL} == '1') " ).append("\n"); 
		query.append("-- 모든 route에 대해 수행함" ).append("\n"); 
		query.append("#elseif (${UPDATE_LEVEL} == '2') " ).append("\n"); 
		query.append("            AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("            AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("            AND RT_SEQ = @[rt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY PROP_NO ,AMDT_SEQ ,SVC_SCP_CD ,GEN_SPCL_RT_TP_CD ,CMDT_HDR_SEQ ,ROUT_SEQ ,RT_SEQ" ).append("\n"); 
		query.append(") SCG" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("        RT.PROP_NO               = SCG.PROP_NO(+)" ).append("\n"); 
		query.append("        AND RT.AMDT_SEQ          = SCG.AMDT_SEQ(+)" ).append("\n"); 
		query.append("        AND RT.SVC_SCP_CD        = SCG.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("        AND RT.GEN_SPCL_RT_TP_CD = SCG.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("        AND RT.CMDT_HDR_SEQ      = SCG.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("        AND RT.ROUT_SEQ          = SCG.ROUT_SEQ(+)" ).append("\n"); 
		query.append("        AND RT.RT_SEQ            = SCG.RT_SEQ(+)" ).append("\n"); 
		query.append("		AND RT.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND RT.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("        AND RT.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND RT.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("#if (${UPDATE_LEVEL} == '1') " ).append("\n"); 
		query.append("-- 모든 route에 대해 수행함" ).append("\n"); 
		query.append("#elseif (${UPDATE_LEVEL} == '2') " ).append("\n"); 
		query.append("        AND RT.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("        AND RT.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("        AND RT.RT_SEQ = @[rt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE SET " ).append("\n"); 
		query.append("                  RT.PRS_SCG_AMT        =  SCG.ADJ_SCG_AMT" ).append("\n"); 
		query.append("                , RT.PRS_RESPB_CMPB_AMT =  SCG.ADJ_SCG_AMT + DECODE(RT.PRC_PROG_STS_CD, 'R', RT.COFFR_FRT_RT_AMT, RT.PROP_FRT_RT_AMT) - RT.PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append("                , RT.PRS_PFIT_CMPB_AMT  =  SCG.ADJ_SCG_AMT + DECODE(RT.PRC_PROG_STS_CD, 'R', RT.COFFR_FRT_RT_AMT, RT.PROP_FRT_RT_AMT) - RT.PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append("                , RT.PRS_RESPB_OPB_AMT  =  SCG.ADJ_SCG_AMT + DECODE(RT.PRC_PROG_STS_CD, 'R', RT.COFFR_FRT_RT_AMT, RT.PROP_FRT_RT_AMT) - RT.PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append("                , RT.UPD_USR_ID            =  @[upd_usr_id]" ).append("\n"); 
		query.append("                , RT.UPD_DT                =  SYSDATE" ).append("\n"); 

	}
}