/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOChargeCalculationParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.28 최성환
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

public class DaoNameDAOChargeCalculationParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public DaoNameDAOChargeCalculationParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOChargeCalculationParmVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' SVR_ID" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CNTR_CYC_NO" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' FM_MVMT_DT" ).append("\n"); 
		query.append(",'' FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",'' FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",'' TO_MVMT_DT" ).append("\n"); 
		query.append(",'' TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",'' TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD				-- dtt_code" ).append("\n"); 
		query.append(",'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' IO_BND_CD" ).append("\n"); 
		query.append(",'' CUST_CNT_CD" ).append("\n"); 
		query.append(",'' CUST_SEQ" ).append("\n"); 
		query.append(",'' ACT_CNT_CD" ).append("\n"); 
		query.append(",'' ACT_CUST_SEQ" ).append("\n"); 
		query.append(",'' DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",'' CHG_SEQ" ).append("\n"); 
		query.append(",'' DMDT_TRF_APLY_TP_CD  	-- dcc_appl_rate" ).append("\n"); 
		query.append(",'' BZC_TRF_SEQ				-- dtn_seq" ).append("\n"); 
		query.append(",'' BZC_TRF_GRP_SEQ			-- grp_id" ).append("\n"); 
		query.append(",'' OVR_DYS					-- over_day" ).append("\n"); 
		query.append(",'' DIV_OVR_DYS				-- div_over_day" ).append("\n"); 
		query.append(",'' CUR_CD					-- cur_cd" ).append("\n"); 
		query.append(",'' RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",'' RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",'' RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",'' SC_NO" ).append("\n"); 
		query.append(",'' SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",'' SUTH_CHN_USE_FLG" ).append("\n"); 
		query.append(",'' RUN_DATE" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}