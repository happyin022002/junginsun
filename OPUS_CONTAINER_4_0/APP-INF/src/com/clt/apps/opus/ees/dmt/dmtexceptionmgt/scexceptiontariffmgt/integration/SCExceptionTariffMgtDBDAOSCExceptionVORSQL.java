/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSCExceptionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSCExceptionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회된 S/C별 DEM/DET 특별 계약 내용을 저장할 VO
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSCExceptionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSCExceptionVORSQL").append("\n"); 
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
		query.append("PROP_NO" ).append("\n"); 
		query.append(",	'' AS SC_NO" ).append("\n"); 
		query.append(",	SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",	'' AS DMDT_EXPT_VER_STS_CD" ).append("\n"); 
		query.append(",	'' AS DMDT_EXPT_VER_STS_DESC" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EXP_DT" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append(",	'' AS CVRG_MULTI" ).append("\n"); 
		query.append(",	'' AS CURR_CVRG_MULTI" ).append("\n"); 
		query.append(",	'' AS CVRG_SEQ" ).append("\n"); 
		query.append(",	'' AS CNT_CD" ).append("\n"); 
		query.append(",	'' AS RGN_ALL_CD" ).append("\n"); 
		query.append(",	'' AS RGN_ALL_NM" ).append("\n"); 
		query.append(",	'' AS RGN_CD" ).append("\n"); 
		query.append(",	'' AS STE_ALL_CD" ).append("\n"); 
		query.append(",	'' AS STE_ALL_NM" ).append("\n"); 
		query.append(",	'' AS STE_CD" ).append("\n"); 
		query.append(",	'' AS LOC_CD" ).append("\n"); 
		query.append(",	FT_FLG" ).append("\n"); 
		query.append(",	'' AS FT_TIR" ).append("\n"); 
		query.append(",	FT_ADD_FLG" ).append("\n"); 
		query.append(",	FT_ADD_DYS" ).append("\n"); 
		query.append(",	'' AS FT_TOT_DYS" ).append("\n"); 
		query.append(",	CMDT_FLG" ).append("\n"); 
		query.append(",	REP_CMDT_CD" ).append("\n"); 
		query.append(",	'' AS REP_CMDT_NM" ).append("\n"); 
		query.append(",	REP_CMDT_FLG" ).append("\n"); 
		query.append(",	ACT_CUST_FLG" ).append("\n"); 
		query.append(",	FM_TO_PAIR_FLG" ).append("\n"); 
		query.append(",	SC_EXPT_FM_CONTI_CD" ).append("\n"); 
		query.append(",	'' AS SC_EXPT_FM_CNT_ALL_CD" ).append("\n"); 
		query.append(",	'' AS SC_EXPT_FM_CNT_ALL_NM" ).append("\n"); 
		query.append(",	SC_EXPT_FM_CNT_CD" ).append("\n"); 
		query.append(",	'' AS SC_EXPT_FM_RGN_ALL_CD" ).append("\n"); 
		query.append(",	'' AS SC_EXPT_FM_RGN_ALL_NM" ).append("\n"); 
		query.append(",	SC_EXPT_FM_RGN_CD" ).append("\n"); 
		query.append(",	'' AS SC_EXPT_FM_STE_ALL_CD" ).append("\n"); 
		query.append(",	'' AS SC_EXPT_FM_STE_ALL_NM" ).append("\n"); 
		query.append(",	SC_EXPT_FM_STE_CD" ).append("\n"); 
		query.append(",	SC_EXPT_FM_LOC_CD" ).append("\n"); 
		query.append(",	FNL_DEST_CNT_CD" ).append("\n"); 
		query.append(",	'' AS FNL_DEST_RGN_ALL_CD" ).append("\n"); 
		query.append(",	'' AS FNL_DEST_RGN_ALL_NM" ).append("\n"); 
		query.append(",	FNL_DEST_RGN_CD" ).append("\n"); 
		query.append(",	'' AS FNL_DEST_STE_ALL_CD" ).append("\n"); 
		query.append(",	'' AS FNL_DEST_STE_ALL_NM" ).append("\n"); 
		query.append(",	FNL_DEST_STE_CD" ).append("\n"); 
		query.append(",	FNL_DEST_LOC_CD" ).append("\n"); 
		query.append(",	RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	FT_FLG" ).append("\n"); 
		query.append(",	XCLD_SAT_FLG" ).append("\n"); 
		query.append(",	XCLD_SUN_FLG" ).append("\n"); 
		query.append(",	XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	DMDT_FT_ADJ_TP_CD" ).append("\n"); 
		query.append(",	FT_ADJ_FLG" ).append("\n"); 
		query.append(",	RT_ADJ_FLG" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	EXPT_TRF_RMK" ).append("\n"); 
		query.append(",	'' AS FULL_EXPT_TRF_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	'' AS REQ_OFC_CD" ).append("\n"); 
		query.append(",	'' AS REQ_USR_NM" ).append("\n"); 
		query.append(",	'' AS REQ_DT" ).append("\n"); 
		query.append(",	'' AS ACCT_OFC_CD" ).append("\n"); 
		query.append(",	'' AS ACCT_USR_NM" ).append("\n"); 
		query.append(",	'' AS ACCT_DT" ).append("\n"); 
		query.append(",	'' AS LIVE_DT" ).append("\n"); 
		query.append(",	'' AS DEL_DT" ).append("\n"); 
		query.append(",	RT_CHK_FLG" ).append("\n"); 
		query.append(",	'' AS RT_CHK" ).append("\n"); 
		query.append("FROM DMT_SC_EXPT_GRP" ).append("\n"); 

	}
}