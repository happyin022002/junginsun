/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateGuidelineDBDAOGlineCopyRtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.15 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateGuidelineDBDAOGlineCopyRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Guideline Rate Copy
	  * </pre>
	  */
	public RFARateGuidelineDBDAOGlineCopyRtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trgt_svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trgt_gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.integration").append("\n"); 
		query.append("FileName : RFARateGuidelineDBDAOGlineCopyRtCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RG_RT (" ).append("\n"); 
		query.append("SVC_SCP_CD" ).append("\n"); 
		query.append(",	GLINE_SEQ" ).append("\n"); 
		query.append(",	CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",	ROUT_SEQ" ).append("\n"); 
		query.append(",	RT_SEQ" ).append("\n"); 
		query.append(",	MQC_RNG_FM_QTY" ).append("\n"); 
		query.append(",	MQC_RNG_TO_QTY" ).append("\n"); 
		query.append(",	RAT_UT_CD" ).append("\n"); 
		query.append(",	PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	FRT_RT_AMT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH CMDT_HDR AS (" ).append("\n"); 
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append(", A.GLINE_SEQ" ).append("\n"); 
		query.append(", A.CMDT_HDR_SEQ AS OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY A.SVC_SCP_CD, A.GLINE_SEQ" ).append("\n"); 
		query.append("ORDER BY A.SVC_SCP_CD, A.GLINE_SEQ, A.CMDT_HDR_SEQ) AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_HDR A" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND   EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_ROUT B" ).append("\n"); 
		query.append(", PRI_RG_RT C" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   B.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   C.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   C.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND   C.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   C.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CMDT_ROUT AS (" ).append("\n"); 
		query.append("SELECT D.SVC_SCP_CD" ).append("\n"); 
		query.append(", D.GLINE_SEQ" ).append("\n"); 
		query.append(", E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY E.SVC_SCP_CD, E.GLINE_SEQ, E.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("ORDER BY E.SVC_SCP_CD, E.GLINE_SEQ, E.CMDT_HDR_SEQ, D.ROUT_SEQ) AS ROUT_SEQ" ).append("\n"); 
		query.append(", E.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", D.ROUT_SEQ AS OLD_ROUT_SEQ" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_ROUT D" ).append("\n"); 
		query.append(", CMDT_HDR E" ).append("\n"); 
		query.append("WHERE D.SVC_SCP_CD = E.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   D.GLINE_SEQ = E.GLINE_SEQ" ).append("\n"); 
		query.append("AND   D.CMDT_HDR_SEQ = E.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[trgt_svc_scp_cd] AS SVC_SCP_CD" ).append("\n"); 
		query.append(", @[trgt_gline_seq] AS GLINE_SEQ" ).append("\n"); 
		query.append(", G.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", G.ROUT_SEQ" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY G.SVC_SCP_CD, G.GLINE_SEQ, G.CMDT_HDR_SEQ, G.ROUT_SEQ" ).append("\n"); 
		query.append("ORDER BY G.SVC_SCP_CD, G.GLINE_SEQ, G.CMDT_HDR_SEQ, G.ROUT_SEQ, F.RT_SEQ) AS RT_SEQ" ).append("\n"); 
		query.append(", F.MQC_RNG_FM_QTY" ).append("\n"); 
		query.append(", F.MQC_RNG_TO_QTY" ).append("\n"); 
		query.append(", F.RAT_UT_CD" ).append("\n"); 
		query.append(", F.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(", F.CURR_CD" ).append("\n"); 
		query.append(", F.FRT_RT_AMT" ).append("\n"); 
		query.append(", @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM PRI_RG_RT F" ).append("\n"); 
		query.append(", CMDT_ROUT G" ).append("\n"); 
		query.append("WHERE F.SVC_SCP_CD = G.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   F.GLINE_SEQ = G.GLINE_SEQ" ).append("\n"); 
		query.append("AND   F.CMDT_HDR_SEQ = G.OLD_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   F.ROUT_SEQ = G.OLD_ROUT_SEQ" ).append("\n"); 

	}
}