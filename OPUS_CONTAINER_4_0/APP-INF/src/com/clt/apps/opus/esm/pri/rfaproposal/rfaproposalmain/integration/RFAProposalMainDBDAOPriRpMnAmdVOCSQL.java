/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpMnAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOPriRpMnAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAProposalMainDBDAO PriRpMnAmdVO
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpMnAmdVOCSQL(){
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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriRpMnAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_MN (" ).append("\n"); 
		query.append("	PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EXP_DT" ).append("\n"); 
		query.append(",	CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append(",	CTRT_CUST_SEQ" ).append("\n"); 
		query.append(",	PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append(",	PROP_SREP_CD" ).append("\n"); 
		query.append(",	PROP_OFC_CD" ).append("\n"); 
		query.append(",	PROP_APRO_OFC_CD" ).append("\n"); 
		query.append(",	PROP_APRO_DT" ).append("\n"); 
		query.append(",	PROP_STS_CD" ).append("\n"); 
		query.append(",	RESPB_SREP_CD" ).append("\n"); 
		query.append(",	RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   TGT_MVC_QTY" ).append("\n"); 
		query.append(",   CNTR_LOD_UT_CD" ).append("\n"); 
		query.append(",   TRF_CTRT_FLG" ).append("\n"); 
		query.append(",   CTRT_DUR_TP_CD" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    PROP_NO" ).append("\n"); 
		query.append("    ,@[amdt_seq]+1" ).append("\n"); 
		query.append("    ,TO_DATE(@[eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	,DECODE(@[exp_dt],null,EXP_DT,TO_DATE(@[exp_dt],'YYYY-MM-DD'))" ).append("\n"); 
		query.append("	,CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("	,CTRT_CUST_SEQ" ).append("\n"); 
		query.append("	,PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("    ,PROP_SREP_CD" ).append("\n"); 
		query.append("    ,PROP_OFC_CD" ).append("\n"); 
		query.append("    ,''" ).append("\n"); 
		query.append("    ,''" ).append("\n"); 
		query.append("    ,'I'" ).append("\n"); 
		query.append("    ,RESPB_SREP_CD" ).append("\n"); 
		query.append("    ,RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append(",   TGT_MVC_QTY" ).append("\n"); 
		query.append(",    CNTR_LOD_UT_CD" ).append("\n"); 
		query.append(",   TRF_CTRT_FLG" ).append("\n"); 
		query.append(",   CTRT_DUR_TP_CD" ).append("\n"); 
		query.append("FROM PRI_RP_MN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}