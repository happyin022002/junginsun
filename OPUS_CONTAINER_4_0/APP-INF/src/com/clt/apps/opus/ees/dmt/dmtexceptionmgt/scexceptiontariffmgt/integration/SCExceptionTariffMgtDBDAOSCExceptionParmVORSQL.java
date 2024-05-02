/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSCExceptionParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.04 
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

public class SCExceptionTariffMgtDBDAOSCExceptionParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C별 DEM/DET 특별 계약 내용 입력 및 조회를 위한 VO
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSCExceptionParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSCExceptionParmVORSQL").append("\n"); 
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
		query.append(",	'' HIST_PROP_NO" ).append("\n"); 
		query.append(",	'' AMDT_SEQ" ).append("\n"); 
		query.append(",	SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	'' SC_EXPT_PREV_VER_SEQ" ).append("\n"); 
		query.append(",	'' SC_EXPT_HIST_VER_SEQ" ).append("\n"); 
		query.append(",	'' DMDT_EXPT_VER_STS_CD" ).append("\n"); 
		query.append(",	SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	'' PRC_CMDT_TP_CD" ).append("\n"); 
		query.append(",	'' CUST_CNT_CD" ).append("\n"); 
		query.append(",	'' CUST_SEQ" ).append("\n"); 
		query.append(",	'' CHK_CALC_TP_IN" ).append("\n"); 
		query.append(",	'' DMDT_CTRT_EXPT_TP_CD" ).append("\n"); 
		query.append(",	'' CHK_CALC_TP_COMBINED" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EXP_DT" ).append("\n"); 
		query.append(",	DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append(",	'' CNT_CD" ).append("\n"); 
		query.append(",	'' RGN_CD" ).append("\n"); 
		query.append(",	'' STE_CD" ).append("\n"); 
		query.append(",	'' LOC_CD" ).append("\n"); 
		query.append(",	'' SC_NO" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	'' OFC_CD" ).append("\n"); 
		query.append(",	'' CUST_TYPE" ).append("\n"); 
		query.append(",	'' COVERAGE_LIST" ).append("\n"); 
		query.append(",	'' ACT_CUST_LIST" ).append("\n"); 
		query.append(",	'' CMDT_LIST" ).append("\n"); 
		query.append(",	SC_EXPT_FM_CONTI_CD" ).append("\n"); 
		query.append(",	SC_EXPT_FM_CNT_CD" ).append("\n"); 
		query.append(",	SC_EXPT_FM_RGN_CD" ).append("\n"); 
		query.append(",	SC_EXPT_FM_STE_CD" ).append("\n"); 
		query.append(",	SC_EXPT_FM_LOC_CD" ).append("\n"); 
		query.append(",	FNL_DEST_CNT_CD" ).append("\n"); 
		query.append(",	FNL_DEST_RGN_CD" ).append("\n"); 
		query.append(",	FNL_DEST_STE_CD" ).append("\n"); 
		query.append(",	FNL_DEST_LOC_CD" ).append("\n"); 
		query.append(",	RCV_DE_TERM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DMT_SC_EXPT_GRP" ).append("\n"); 

	}
}