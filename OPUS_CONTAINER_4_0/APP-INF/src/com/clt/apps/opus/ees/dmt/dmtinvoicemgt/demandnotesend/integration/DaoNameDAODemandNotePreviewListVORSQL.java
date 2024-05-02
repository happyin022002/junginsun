/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODemandNotePreviewListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.23 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAODemandNotePreviewListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemandNotePreviewListVO
	  * </pre>
	  */
	public DaoNameDAODemandNotePreviewListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DaoNameDAODemandNotePreviewListVORSQL").append("\n"); 
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
		query.append("SELECT '' VVD_CD" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' LOC" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' FM_MVMT_DT" ).append("\n"); 
		query.append(",'' TO_MVMT_DT" ).append("\n"); 
		query.append(",'' FT_CMNC_DT" ).append("\n"); 
		query.append(",'' FT_END_DT" ).append("\n"); 
		query.append(",'' FT_DYS" ).append("\n"); 
		query.append(",'' FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",'' ORG_CHG_AMT" ).append("\n"); 
		query.append(",'' EXPT_AMT" ).append("\n"); 
		query.append(",'' AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",'' BIL_AMT" ).append("\n"); 
		query.append(",'' GB" ).append("\n"); 
		query.append(",'' SVR_ID" ).append("\n"); 
		query.append(",'' CNTR_CYC_NO" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",'' CHG_SEQ" ).append("\n"); 
		query.append(",'' BZC_TRF_SEQ" ).append("\n"); 
		query.append(",'' BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",'' DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",'' ACT_CNT_CD" ).append("\n"); 
		query.append(",'' ACT_CUST_SEQ" ).append("\n"); 
		query.append(",'' FT_OVR_UND_DYS" ).append("\n"); 
		query.append(",'' RT_AMT" ).append("\n"); 
		query.append(",'' RT_AMOUNT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}