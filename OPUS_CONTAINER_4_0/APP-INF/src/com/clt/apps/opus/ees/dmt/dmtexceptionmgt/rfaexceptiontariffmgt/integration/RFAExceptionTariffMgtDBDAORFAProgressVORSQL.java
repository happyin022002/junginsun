/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAORFAProgressVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAORFAProgressVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 및 Cancel, Approval, Counter Offer, Reject 요청을 처리하기 위해서 필요한 정보를 입출력하는데 사용되는 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAORFAProgressVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAORFAProgressVORSQL").append("\n"); 
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
		query.append("RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	'' RFA_EXPT_HIST_DAR_NO" ).append("\n"); 
		query.append(",	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	'' RFA_EXPT_HIST_MAPG_SEQ" ).append("\n"); 
		query.append(",	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	'' RFA_EXPT_HIST_VER_SEQ" ).append("\n"); 
		query.append(",	'' RFA_EXPT_PREV_VER_SEQ" ).append("\n"); 
		query.append(",	'' RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",	PROP_NO" ).append("\n"); 
		query.append(",	'' AMDT_SEQ" ).append("\n"); 
		query.append(",	'' RFA_NO" ).append("\n"); 
		query.append(",	DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append(",	'' PROG_SEQ" ).append("\n"); 
		query.append(",	'' DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append(",	'' DMDT_EXPT_RQST_STS_DESC" ).append("\n"); 
		query.append(",	'' PROG_RMK" ).append("\n"); 
		query.append(",	'' PROG_DT" ).append("\n"); 
		query.append(",	'' PROG_USR_ID" ).append("\n"); 
		query.append(",	'' PROG_USR_NM" ).append("\n"); 
		query.append(",	'' PROG_OFC_CD" ).append("\n"); 
		query.append(",	BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	'' CUST_NM" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	RQST_OFC_CD" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append(",	RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append(",	APRO_USR_ID" ).append("\n"); 
		query.append(",	APRO_DT" ).append("\n"); 
		query.append(",	APRO_OFC_CD" ).append("\n"); 
		query.append(",	MSG_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	'' IS_TEMP" ).append("\n"); 
		query.append(",	'' RHQ_OFC_CD" ).append("\n"); 
		query.append(",	'' USR_ROLE_CD" ).append("\n"); 
		query.append(",	'' PGM_NO" ).append("\n"); 
		query.append(",	'' USR_ID" ).append("\n"); 
		query.append(",	'' CODE1" ).append("\n"); 
		query.append(",	'' CODE2" ).append("\n"); 
		query.append(",	'' FNL_DEST_CNT_CD" ).append("\n"); 
		query.append(",	'' FNL_DEST_RGN_CD" ).append("\n"); 
		query.append(",	'' FNL_DEST_STE_CD" ).append("\n"); 
		query.append(",	'' FNL_DEST_LOC_CD" ).append("\n"); 
		query.append(",	'' CVRG_CNT_CD" ).append("\n"); 
		query.append(",	'' CVRG_RGN_CD" ).append("\n"); 
		query.append(",	'' CVRG_STE_CD" ).append("\n"); 
		query.append(",	'' CVRG_LOC_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_STE_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(",	'' ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",	'' ACT_CUST_SEQ" ).append("\n"); 
		query.append(",	'' COVERAGE_LIST" ).append("\n"); 
		query.append(",	'' EFF_DT" ).append("\n"); 
		query.append(",	'' EXP_DT" ).append("\n"); 
		query.append(",	'' DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",	'' DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",	'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",	'' POPUP_FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DMT_RFA_EXPT_TRF" ).append("\n"); 

	}
}