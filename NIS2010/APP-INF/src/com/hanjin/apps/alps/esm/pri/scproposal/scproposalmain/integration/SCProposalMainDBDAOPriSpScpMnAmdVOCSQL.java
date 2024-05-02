/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpScpMnAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.03 
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

public class SCProposalMainDBDAOPriSpScpMnAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCProposalMainDBDAO PriSpScpMnCpVO
	  * 2012.02.03 이석준[CHM-201215685] CHSS_EXPT_FLG, GRI_APPL_FLG, NEW_SCG_FLG 추가 컬럼 조회 반영
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpScpMnAmdVOCSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpScpMnAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_MN(" ).append("\n"); 
		query.append("    PROP_NO," ).append("\n"); 
		query.append("    AMDT_SEQ," ).append("\n"); 
		query.append("    SVC_SCP_CD," ).append("\n"); 
		query.append("    EFF_DT," ).append("\n"); 
		query.append("    EXP_DT," ).append("\n"); 
		query.append("    PROP_SCP_SREP_CD," ).append("\n"); 
		query.append("    PROP_SCP_OFC_CD," ).append("\n"); 
		query.append("    PROP_SCP_APRO_OFC_CD," ).append("\n"); 
		query.append("    PROP_SCP_STS_CD," ).append("\n"); 
		query.append("    NOTE_HDR_SEQ," ).append("\n"); 
		query.append("    PRS_XCH_RT_YRMON," ).append("\n"); 
		query.append("    CHSS_EXPT_FLG," ).append("\n"); 
		query.append("    GRI_APPL_FLG," ).append("\n"); 
		query.append("    NEW_SCG_FLG, " ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    PROP_NO," ).append("\n"); 
		query.append("    @[amdt_seq]+1," ).append("\n"); 
		query.append("    SVC_SCP_CD,    " ).append("\n"); 
		query.append("	DECODE(TO_DATE(@[eff_dt],'YYYY-MM-DD') - TRUNC(EFF_DT), -1, EFF_DT, TO_DATE(@[eff_dt],'YYYY-MM-DD'))," ).append("\n"); 
		query.append("    EXP_DT," ).append("\n"); 
		query.append("    PROP_SCP_SREP_CD," ).append("\n"); 
		query.append("    PROP_SCP_OFC_CD," ).append("\n"); 
		query.append("    PROP_SCP_APRO_OFC_CD," ).append("\n"); 
		query.append("    PROP_SCP_STS_CD," ).append("\n"); 
		query.append("    NOTE_HDR_SEQ," ).append("\n"); 
		query.append("	PRS_XCH_RT_YRMON," ).append("\n"); 
		query.append("    CHSS_EXPT_FLG," ).append("\n"); 
		query.append("    GRI_APPL_FLG," ).append("\n"); 
		query.append("    NEW_SCG_FLG," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    PRI_SP_SCP_MN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}