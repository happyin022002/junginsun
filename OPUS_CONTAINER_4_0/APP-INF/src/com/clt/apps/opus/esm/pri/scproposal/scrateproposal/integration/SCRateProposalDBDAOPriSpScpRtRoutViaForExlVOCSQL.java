/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtRoutViaForExlVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtRoutViaForExlVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * create PRI_SP_SCP_RT_ROUT_VIA
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtRoutViaForExlVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_cmnc_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("src_info_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_via_port_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_via_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_via_port_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtRoutViaForExlVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_RT_ROUT_VIA (" ).append("\n"); 
		query.append("	PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",	CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",	ROUT_SEQ" ).append("\n"); 
		query.append(",	ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",	ROUT_VIA_SEQ" ).append("\n"); 
		query.append(",	ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",	ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",	PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",	SRC_INFO_CD" ).append("\n"); 
		query.append(",	N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",	CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",	ROUT_SEQ" ).append("\n"); 
		query.append(",	ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",   NVL(ROUT_VIA_SEQ, (B.MAX_ROUT_VIA_SEQ + 1)) AS ROUT_VIA_SEQ" ).append("\n"); 
		query.append(",	ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",	ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",	PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",	SRC_INFO_CD" ).append("\n"); 
		query.append(",	N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	@[prop_no] AS PROP_NO" ).append("\n"); 
		query.append(",	@[amdt_seq] AS AMDT_SEQ" ).append("\n"); 
		query.append(",	@[svc_scp_cd] AS SVC_SCP_CD" ).append("\n"); 
		query.append(",	@[gen_spcl_rt_tp_cd] AS GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",	@[cmdt_hdr_seq] AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",   @[rout_seq] AS ROUT_SEQ" ).append("\n"); 
		query.append(",	@[org_dest_tp_cd] AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",	@[rout_via_seq] AS ROUT_VIA_SEQ" ).append("\n"); 
		query.append(",	@[rout_via_port_tp_cd] AS ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append(",	@[rout_via_port_def_cd] AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append(",	@[prc_prog_sts_cd] AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",	@[src_info_cd] AS SRC_INFO_CD" ).append("\n"); 
		query.append(",   @[n1st_cmnc_amdt_seq] AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",	@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",	DECODE(NVL(@[cre_dt],'1'),'1',SYSDATE,TO_DATE(REPLACE(@[cre_dt],'.0',''),'YYYY-MM-DD HH24:MI:SS')) AS CRE_DT" ).append("\n"); 
		query.append(",	@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(",	DECODE(NVL(@[upd_dt],'1'),'1',SYSDATE,TO_DATE(REPLACE(@[upd_dt],'.0',''),'YYYY-MM-DD HH24:MI:SS')) AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL) A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL((SELECT /*+ INDEX_DESC(A XPKPRI_SP_SCP_RT_ROUT_VIA) */" ).append("\n"); 
		query.append("                  ROUT_VIA_SEQ" ).append("\n"); 
		query.append("             FROM PRI_SP_SCP_RT_ROUT_VIA A" ).append("\n"); 
		query.append("            WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("              AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("              AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("              AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("              AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("              AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("              AND ROWNUM = 1)" ).append("\n"); 
		query.append("          ,0) AS MAX_ROUT_VIA_SEQ" ).append("\n"); 
		query.append("  FROM DUAL) B" ).append("\n"); 

	}
}