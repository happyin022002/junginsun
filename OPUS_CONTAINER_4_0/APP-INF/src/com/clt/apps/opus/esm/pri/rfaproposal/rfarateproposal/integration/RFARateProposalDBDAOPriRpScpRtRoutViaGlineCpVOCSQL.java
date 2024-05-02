/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtRoutViaGlineCpVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPriRpScpRtRoutViaGlineCpVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Route Via 입력
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtRoutViaGlineCpVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtRoutViaGlineCpVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_ROUT_VIA" ).append("\n"); 
		query.append("  (PROP_NO" ).append("\n"); 
		query.append("  ,AMDT_SEQ" ).append("\n"); 
		query.append("  ,SVC_SCP_CD" ).append("\n"); 
		query.append("  ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("  ,ROUT_SEQ" ).append("\n"); 
		query.append("  ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("  ,ROUT_VIA_SEQ" ).append("\n"); 
		query.append("  ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("  ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("  ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("  ,SRC_INFO_CD" ).append("\n"); 
		query.append("  ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT)" ).append("\n"); 
		query.append("  SELECT @[prop_no]" ).append("\n"); 
		query.append("        ,@[amdt_seq]" ).append("\n"); 
		query.append("        ,@[svc_scp_cd]" ).append("\n"); 
		query.append("        ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        ,ROUT_SEQ" ).append("\n"); 
		query.append("        ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("        ,ROUT_VIA_SEQ" ).append("\n"); 
		query.append("        ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("        ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("        ,'I'" ).append("\n"); 
		query.append("        ,'GC'" ).append("\n"); 
		query.append("        ,@[amdt_seq]" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[upd_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("    FROM (SELECT DENSE_RANK() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ ORDER BY CMDT_HDR_SEQ) AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                ,DENSE_RANK() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ ORDER BY ROUT_SEQ) AS ROUT_SEQ" ).append("\n"); 
		query.append("                ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                ,DENSE_RANK() OVER(PARTITION BY SVC_SCP_CD, GLINE_SEQ, CMDT_HDR_SEQ, ROUT_SEQ, ORG_DEST_TP_CD ORDER BY ROUT_VIA_SEQ) AS ROUT_VIA_SEQ" ).append("\n"); 
		query.append("                ,ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("            FROM (SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append("                        ,B.GLINE_SEQ" ).append("\n"); 
		query.append("                        ,B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        ,C.ROUT_SEQ" ).append("\n"); 
		query.append("                        ,D.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                        ,D.ROUT_VIA_SEQ" ).append("\n"); 
		query.append("                        ,D.ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                        ,D.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                    FROM (SELECT T.SVC_SCP_CD, T.GLINE_SEQ, RANK() OVER(PARTITION BY SVC_SCP_CD ORDER BY EFF_DT DESC) AS RNK" ).append("\n"); 
		query.append("                            FROM PRI_RG_MN T" ).append("\n"); 
		query.append("                           WHERE T.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN T.EFF_DT AND T.EXP_DT" ).append("\n"); 
		query.append("                             AND T.CFM_FLG = 'Y') A" ).append("\n"); 
		query.append("                        ,PRI_RG_RT_CMDT_HDR B" ).append("\n"); 
		query.append("                        ,PRI_RG_RT_CMDT_ROUT C" ).append("\n"); 
		query.append("                        ,PRI_RG_RT_ROUT_VIA D" ).append("\n"); 
		query.append("                   WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("                     AND B.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND B.GLINE_SEQ = C.GLINE_SEQ" ).append("\n"); 
		query.append("                     AND B.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND C.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                     AND C.GLINE_SEQ = D.GLINE_SEQ(+)" ).append("\n"); 
		query.append("                     AND C.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                     AND C.ROUT_SEQ = D.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                     AND A.RNK = 1" ).append("\n"); 
		query.append("                     AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN B.EFF_DT AND B.EXP_DT) T)" ).append("\n"); 
		query.append("   WHERE ROUT_VIA_PORT_DEF_CD IS NOT NULL" ).append("\n"); 

	}
}