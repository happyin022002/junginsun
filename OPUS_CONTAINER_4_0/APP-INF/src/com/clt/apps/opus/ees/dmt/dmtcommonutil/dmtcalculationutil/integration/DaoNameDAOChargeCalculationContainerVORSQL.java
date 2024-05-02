/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DaoNameDAOChargeCalculationContainerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.01.05 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOChargeCalculationContainerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationContainerVO
	  * </pre>
	  */
	public DaoNameDAOChargeCalculationContainerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOChargeCalculationContainerVORSQL").append("\n"); 
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
		query.append("'' CNTR_TP" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' BRH_SC_NO" ).append("\n"); 
		query.append(",'' BRH_RFA_NO" ).append("\n"); 
		query.append(",'' CMDT_CD" ).append("\n"); 
		query.append(",'' REP_CMDT_CD" ).append("\n"); 
		query.append(",'' DCGO_FLG" ).append("\n"); 
		query.append(",'' RC_FLG" ).append("\n"); 
		query.append(",'' AWK_CGO_FLG" ).append("\n"); 
		query.append(",'' RD_CGO_FLG" ).append("\n"); 
		query.append(",'' BB_CGO_FLG" ).append("\n"); 
		query.append(",'' SOC_FLG" ).append("\n"); 
		query.append(",'' CNTR_PRT_FLG" ).append("\n"); 
		query.append(",'' ADV_SHTG_CD" ).append("\n"); 
		query.append(",'' POR_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' DEL_CD" ).append("\n"); 
		query.append(",'' SAL_OFC" ).append("\n"); 
		query.append(",'' SAL_RHQ" ).append("\n"); 
		query.append(",'' DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",'' BKG_QTY" ).append("\n"); 
		query.append(",'' VSL_CD" ).append("\n"); 
		query.append(",'' SKD_VOY_NO" ).append("\n"); 
		query.append(",'' SKD_DIR_CD" ).append("\n"); 
		query.append(",'' VPS_ETA_DT" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' OFC_RHQ" ).append("\n"); 
		query.append(",'' BB_RCV_TERM_CD" ).append("\n"); 
		query.append(",'' BB_DE_TERM_CD" ).append("\n"); 
		query.append(",'' FT_DYS" ).append("\n"); 
		query.append(",'' FT_CMNC_DT" ).append("\n"); 
		query.append(",'' FT_END_DT" ).append("\n"); 
		query.append(",'' FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' ORG_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' SC_RFA_EXPT_OVR_DYS" ).append("\n"); 
		query.append(",'' AFT_EXPT_OVR_DYS" ).append("\n"); 
		query.append(",'' BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",'' DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append(",'' ORG_CHG_AMT" ).append("\n"); 
		query.append(",'' SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append(",'' AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",'' BIL_AMT" ).append("\n"); 
		query.append(",'' DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",'' SC_RFA_AMT" ).append("\n"); 
		query.append(",'' AFT_EXPT_AMT" ).append("\n"); 
		query.append(",'' BZC_TRF_SEQ" ).append("\n"); 
		query.append(",'' BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",'' RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append(",'' RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",'' RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",'' RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",'' CVRG_CMB_SEQ" ).append("\n"); 
		query.append(",'' AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append(",'' AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append(",'' AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append(",'' SC_NO" ).append("\n"); 
		query.append(",'' SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",'' CMDT_CD_C" ).append("\n"); 
		query.append(",'' CMDT_TRF_SEQ" ).append("\n"); 
		query.append(",'' CMDT_OVR_DYS" ).append("\n"); 
		query.append(",'' CMDT_EXPT_AMT" ).append("\n"); 
		query.append(",'' TO_MVMT_DT" ).append("\n"); 
		query.append(",'' TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",'' TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",'' CSTOP_IDX" ).append("\n"); 
		query.append(",'' CSTOP_NO" ).append("\n"); 
		query.append(",'' BZC_TRF_APLY_DT" ).append("\n"); 
		query.append(",'' CMDT_EXPT_APLY_DT" ).append("\n"); 
		query.append(",'' SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append(",'' MT_DATE" ).append("\n"); 
		query.append(",'' MSG_CD" ).append("\n"); 
		query.append(",'' MSG_DESC" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}