/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOBeforeExceptionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOBeforeExceptionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Adjustment Request -  Before Booking Request 에 등록된 조회목록 정보를 저장할 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOBeforeExceptionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOBeforeExceptionVORSQL").append("\n"); 
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
		query.append("FNL_DEST_STE_CD" ).append("\n"); 
		query.append(",	FNL_DEST_LOC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	'' RQST_OFC_CD" ).append("\n"); 
		query.append(",	RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	'' VIEW_VER_SEQ" ).append("\n"); 
		query.append(",	'' DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append(",	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	N1ST_CMNC_VER_SEQ" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EXP_DT" ).append("\n"); 
		query.append(",	DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",	DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",	'' DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append(",	'' DMDT_CNTR_CGO_TP_TXT" ).append("\n"); 
		query.append(",	REP_CMDT_CD" ).append("\n"); 
		query.append(",	FT_USE_FLG" ).append("\n"); 
		query.append(",	ADD_DYS" ).append("\n"); 
		query.append(",	TTL_DYS" ).append("\n"); 
		query.append(",	XCLD_SAT_FLG" ).append("\n"); 
		query.append(",	XCLD_SUN_FLG" ).append("\n"); 
		query.append(",	XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	RT_USE_FLG" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	EXPT_TRF_RMK" ).append("\n"); 
		query.append(",	'' FULL_EXPT_TRF_RMK" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	'' CUST_NM" ).append("\n"); 
		query.append(",	'' CVRG_CMB_SEQ" ).append("\n"); 
		query.append(",	'' VIEW_CVRG_CMB_SEQ" ).append("\n"); 
		query.append(",	'' CVRG_CONTI_CD" ).append("\n"); 
		query.append(",	'' CVRG_CNT_CD" ).append("\n"); 
		query.append(",	'' CVRG_CNT_ALL_CD" ).append("\n"); 
		query.append(",	'' CVRG_CNT_ALL_NM" ).append("\n"); 
		query.append(",	'' CVRG_RGN_CD" ).append("\n"); 
		query.append(",	'' CVRG_RGN_ALL_CD" ).append("\n"); 
		query.append(",	'' CVRG_RGN_ALL_NM" ).append("\n"); 
		query.append(",	'' CVRG_STE_CD" ).append("\n"); 
		query.append(",	'' CVRG_LOC_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_MULTI" ).append("\n"); 
		query.append(",	'' CURR_ORG_DEST_MULTI" ).append("\n"); 
		query.append(",	'' ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_CNT_ALL_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_CNT_ALL_NM" ).append("\n"); 
		query.append(",	'' ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_RGN_ALL_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_RGN_ALL_NM" ).append("\n"); 
		query.append(",	'' ORG_DEST_STE_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(",	FNL_DEST_FLG" ).append("\n"); 
		query.append(",	FNL_DEST_CONTI_CD" ).append("\n"); 
		query.append(",	FNL_DEST_CNT_CD" ).append("\n"); 
		query.append(",	'' FNL_DEST_CNT_ALL_CD" ).append("\n"); 
		query.append(",	'' FNL_DEST_CNT_ALL_NM" ).append("\n"); 
		query.append(",	FNL_DEST_RGN_CD" ).append("\n"); 
		query.append(",	'' FNL_DEST_RGN_ALL_CD" ).append("\n"); 
		query.append(",	'' FNL_DEST_RGN_ALL_NM" ).append("\n"); 
		query.append(",	FNL_DEST_STE_CD" ).append("\n"); 
		query.append(",	FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("rt_chk_flg" ).append("\n"); 
		query.append(",	'' RT_CHK_FLG" ).append("\n"); 
		query.append(",	'' RT_CHK" ).append("\n"); 
		query.append("FROM DMT_RFA_EXPT_TRF_DTL" ).append("\n"); 

	}
}