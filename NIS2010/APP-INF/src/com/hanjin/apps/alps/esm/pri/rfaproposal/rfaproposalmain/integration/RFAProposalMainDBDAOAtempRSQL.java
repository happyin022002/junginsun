/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAProposalMainDBDAOAtempRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.01.19 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOAtempRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * temp query 추후 삭제
	  * </pre>
	  */
	public RFAProposalMainDBDAOAtempRSQL(){
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
		params.put("nw_prop_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOAtempRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("PROP_NO, AMDT_SEQ, EFF_DT, EXP_DT, FILE_DT, CTRT_CUST_CNT_CD, CTRT_CUST_SEQ," ).append("\n"); 
		query.append("      PRC_CTRT_CUST_TP_CD, CTRT_CUST_VAL_SGM_CD, PROP_SREP_CD, PROP_OFC_CD," ).append("\n"); 
		query.append("      PROP_APRO_OFC_CD, PROP_APRO_DT, PROP_STS_CD, RESPB_SREP_CD," ).append("\n"); 
		query.append("      RESPB_SLS_OFC_CD, SLS_LD_NO, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT," ).append("\n"); 
		query.append("      CNTR_LOD_UT_CD, TGT_MVC_QTY, '' NEW_DUR_FLG" ).append("\n"); 
		query.append("FROM PRI_RP_MN" ).append("\n"); 
		query.append("/*CstPriRpAmendVO*/" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      ''  SRFA_NO" ).append("\n"); 
		query.append("      ,''  SPROP_NO" ).append("\n"); 
		query.append("      ,''  SEFF_DT" ).append("\n"); 
		query.append("	  ,''  SPROP_STS_CD" ).append("\n"); 
		query.append("      ,''  SSVC_SCP_CD" ).append("\n"); 
		query.append("      ,''  SPROP_OFC_CD" ).append("\n"); 
		query.append("      ,''  SCUST_CNT_CD" ).append("\n"); 
		query.append("      ,''  SCUST_SEQ" ).append("\n"); 
		query.append("	  ,''  sprop_srep_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("/* CstShRInqVO  */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("select '' exp_dt ,'' upd_usr_id ,'' prop_no, '' amdt_seq,'' svc_scp_cd , ''mn_exp_dt" ).append("\n"); 
		query.append("from dual" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("--CstPriSpScpMnDurVO" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("select '' OFC_CD, '' SVC_SCP_CD ,'' EX_FLG, '' SC_NO,'' PRE_FIX FROM DUAL " ).append("\n"); 
		query.append("--CstPriSpHdrVO" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	@[nw_prop_no]" ).append("\n"); 
		query.append(",	0" ).append("\n"); 
		query.append(",	@[svc_scp_cd]" ).append("\n"); 
		query.append(",	CTRT_EFF_DT" ).append("\n"); 
		query.append(",	CTRT_EXP_DT" ).append("\n"); 
		query.append(",	PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",	SRC_INFO_CD" ).append("\n"); 
		query.append(",	N1ST_CMNC_DT" ).append("\n"); 
		query.append(",	ACPT_USR_ID" ).append("\n"); 
		query.append(",	ACPT_OFC_CD" ).append("\n"); 
		query.append(",	ACPT_DT" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_DUR" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("--select '' delCnt from dual" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT '' CUST_CNT_CD" ).append("\n"); 
		query.append("	  ,'' CUST_SEQ" ).append("\n"); 
		query.append("	  ,'' PROP_NO" ).append("\n"); 
		query.append("	  ,'' AMDT_SEQ" ).append("\n"); 
		query.append("	  ,'' FIRST_SW" ).append("\n"); 
		query.append("	  , '' respb_srep_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("/* SchSaleLeadRfaVO*/" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT '' EFF_DT" ).append("\n"); 
		query.append("	   ,'' EXP_DT" ).append("\n"); 
		query.append("	   ,'' RFA_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("8?" ).append("\n"); 
		query.append("/* CstApprovalVO */" ).append("\n"); 

	}
}