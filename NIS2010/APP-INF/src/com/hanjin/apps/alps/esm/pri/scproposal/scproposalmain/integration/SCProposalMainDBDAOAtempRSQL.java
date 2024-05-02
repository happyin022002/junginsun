/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAOAtempRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.05.07 공백진
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

public class SCProposalMainDBDAOAtempRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * temp query 추후 삭제
	  * </pre>
	  */
	public SCProposalMainDBDAOAtempRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOAtempRSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("SELECT   PROP_NO" ).append("\n"); 
		query.append("        ,AMDT_SEQ" ).append("\n"); 
		query.append("        ,EFF_DT" ).append("\n"); 
		query.append("        ,EXP_DT" ).append("\n"); 
		query.append("        ,FILE_DT" ).append("\n"); 
		query.append("        ,PROP_SREP_CD" ).append("\n"); 
		query.append("        ,PROP_OFC_CD" ).append("\n"); 
		query.append("        ,PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("        ,PROP_APRO_DT" ).append("\n"); 
		query.append("        ,PROP_STS_CD" ).append("\n"); 
		query.append("        ,RESPB_SREP_CD" ).append("\n"); 
		query.append("        ,RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("        ,REAL_CUST_CNT_CD" ).append("\n"); 
		query.append("        ,REAL_CUST_SEQ" ).append("\n"); 
		query.append("        ,REAL_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("        ,REAL_CUST_TP_CD" ).append("\n"); 
		query.append("        ,REAL_CUST_SREP_CD" ).append("\n"); 
		query.append("        ,REAL_CUST_SLS_OFC_CD" ).append("\n"); 
		query.append("        ,SLS_LD_NO" ).append("\n"); 
		query.append("        ,RF_FLG" ).append("\n"); 
		query.append("        ,GAMT_FLG" ).append("\n"); 
		query.append("        ,BLPL_HDR_SEQ" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("        ,'' eff_dt_chg" ).append("\n"); 
		query.append("		,PROP_OFC_CD" ).append("\n"); 
		query.append("	,'' LAST_FILE_DT" ).append("\n"); 
		query.append("FROM     PRI_SP_MN" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("/* CstPriSpMnFileVO*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '' SSC_NO" ).append("\n"); 
		query.append("	  ,'' SPROP_NO" ).append("\n"); 
		query.append("	  ,'' SPROP_OFC_CD" ).append("\n"); 
		query.append("	  ,'' SPROP_SREP_CD" ).append("\n"); 
		query.append("	  ,'' SPROP_APRO_OFC_CD" ).append("\n"); 
		query.append("	  ,'' SPROP_STS_CD" ).append("\n"); 
		query.append("	  ,'' SCUST_CNT_CD" ).append("\n"); 
		query.append("	  ,'' SCUST_SEQ" ).append("\n"); 
		query.append("	  ,'' SCRE_DT1" ).append("\n"); 
		query.append("	  ,'' SCRE_DT2" ).append("\n"); 
		query.append("	  ,'' SEFF_DT1" ).append("\n"); 
		query.append("	  ,'' SEFF_DT2" ).append("\n"); 
		query.append("	  ,'' SPROP_MQC_QTY" ).append("\n"); 
		query.append("	  ,'' smqc_sign_cd" ).append("\n"); 
		query.append("	  ,'' ssc_type_cd" ).append("\n"); 
		query.append("	  ,'' SMQC_SIGN_NM" ).append("\n"); 
		query.append("	  ,'' sprc_ctrt_cust_tp_cd" ).append("\n"); 
		query.append("FROM DUAL	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*CstShInqVO*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT '' PROP_NO, '' AMDT_SEQ, '' SVC_SCP_CD, '' TERM_TYPE_CD 	  ,'' CONV_FLG, '' LGCY_IF_FLG FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("/* CstShHistVO */" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("select '' OFC_CD, '' SVC_SCP_CD ,'' EX_FLG, '' SC_NO,'' PRE_FIX FROM DUAL " ).append("\n"); 
		query.append("CstPriSpHdrVO" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("/* select '' delCnt from dual */" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT '' CUST_CNT_CD" ).append("\n"); 
		query.append("	  ,'' CUST_SEQ" ).append("\n"); 
		query.append("	  ,'' ctrt_cust_srep_cd" ).append("\n"); 
		query.append("	  ,'' REAL_CUST_CNT_CD" ).append("\n"); 
		query.append("	  ,'' REAL_CUST_SEQ" ).append("\n"); 
		query.append("	  ,'' REAL_CUST_SREP_CD" ).append("\n"); 
		query.append("	  ,'' PROP_NO" ).append("\n"); 
		query.append("	  ,'' AMDT_SEQ" ).append("\n"); 
		query.append("	  ,'' FIRST_SW" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("/* SchSaleLeadVO*/" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT '' PROP_OFC_CD" ).append("\n"); 
		query.append("	  ,'' CUST_CNT_CD" ).append("\n"); 
		query.append("	  ,'' CUST_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("/* SchCustVO */" ).append("\n"); 

	}
}