/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtScgCpGRICancelCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2010.01.13 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPriRpScpRtScgCpGRICancelCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Cancel시 PriSpScpRtScg 테이블 데이터 복구
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtScgCpGRICancelCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtScgCpGRICancelCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_SCG" ).append("\n"); 
		query.append("(PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",RT_SEQ" ).append("\n"); 
		query.append(",CHG_CD" ).append("\n"); 
		query.append(",BKG_RAT_UT_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",TRF_SCG_AMT" ).append("\n"); 
		query.append(",ADJ_SCG_AMT" ).append("\n"); 
		query.append(",ADJ_SCG_USD_AMT" ).append("\n"); 
		query.append(",TRF_SCG_RMK" ).append("\n"); 
		query.append(",TRF_ADJ_TP_CD" ).append("\n"); 
		query.append(",ADJ_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT)" ).append("\n"); 
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ + 1" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",ROUT_SEQ" ).append("\n"); 
		query.append(",RT_SEQ" ).append("\n"); 
		query.append(",CHG_CD" ).append("\n"); 
		query.append(",BKG_RAT_UT_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",TRF_SCG_AMT" ).append("\n"); 
		query.append(",ADJ_SCG_AMT" ).append("\n"); 
		query.append(",ADJ_SCG_USD_AMT" ).append("\n"); 
		query.append(",TRF_SCG_RMK" ).append("\n"); 
		query.append(",TRF_ADJ_TP_CD" ).append("\n"); 
		query.append(",ADJ_FLG" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_SCG T" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq] - 1" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT A" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND A.GRI_APPL_TP_CD = 'A'" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND A.ROUT_SEQ = T.ROUT_SEQ" ).append("\n"); 
		query.append("AND A.RT_SEQ = T.RT_SEQ)" ).append("\n"); 

	}
}