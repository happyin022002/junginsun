/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODemandNoteRDListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.18 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAODemandNoteRDListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemandNoteRDListVO
	  * </pre>
	  */
	public DaoNameDAODemandNoteRDListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration ").append("\n"); 
		query.append("FileName : DaoNameDAODemandNoteRDListVORSQL").append("\n"); 
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
		query.append("'' AS CNTR_NO" ).append("\n"); 
		query.append(",'' AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' AS FM_MVMT_DT" ).append("\n"); 
		query.append(",'' AS TO_MVMT_DT" ).append("\n"); 
		query.append(",'' AS FT_CMNC_DT" ).append("\n"); 
		query.append(",'' AS FT_END_DT" ).append("\n"); 
		query.append(",'' AS FT_DYS" ).append("\n"); 
		query.append(",'' AS FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",'' AS SVR_ID" ).append("\n"); 
		query.append(",'' AS CNTR_CYC_NO" ).append("\n"); 
		query.append(",'' AS DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",'' AS CHG_SEQ" ).append("\n"); 
		query.append(",'' AS BZC_TRF_SEQ" ).append("\n"); 
		query.append(",'' AS BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",'' AS DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",'' AS RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",'' AS RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",'' AS RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' AS RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",'' AS SC_NO" ).append("\n"); 
		query.append(",'' AS SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' AS SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",'' AS DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append(",'' AS FT_OVER" ).append("\n"); 
		query.append(",'' AS FT_UNDER" ).append("\n"); 
		query.append(",'' AS RT_AMT" ).append("\n"); 
		query.append(",'' AS RT_DAY" ).append("\n"); 
		query.append(",'' AS RT_CHRG_AMT" ).append("\n"); 
		query.append(",'' AS RT_CURR_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}