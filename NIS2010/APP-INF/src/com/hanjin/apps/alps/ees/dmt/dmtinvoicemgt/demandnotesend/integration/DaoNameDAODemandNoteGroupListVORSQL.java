/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODemandNoteGroupListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.11.20 최성환
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

public class DaoNameDAODemandNoteGroupListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemandNoteGroupListVO
	  * </pre>
	  */
	public DaoNameDAODemandNoteGroupListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration ").append("\n"); 
		query.append("FileName : DaoNameDAODemandNoteGroupListVORSQL").append("\n"); 
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
		query.append("SELECT   '' VVD_CD" ).append("\n"); 
		query.append(",'' LOC" ).append("\n"); 
		query.append(",'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' FM_MVMT_DT" ).append("\n"); 
		query.append(",'' TO_MVMT_DT" ).append("\n"); 
		query.append(",'' FT_CMNC_DT" ).append("\n"); 
		query.append(",'' FT_END_DT" ).append("\n"); 
		query.append(",'' FM_MVMT_DT_RD" ).append("\n"); 
		query.append(",'' TO_MVMT_DT_RD" ).append("\n"); 
		query.append(",'' FT_CMNC_DT_RD" ).append("\n"); 
		query.append(",'' FT_END_DT_RD" ).append("\n"); 
		query.append(",'' FT_DYS" ).append("\n"); 
		query.append(",'' FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",'' PORT" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' PAYER_CD" ).append("\n"); 
		query.append(",'' PAYER_NM" ).append("\n"); 
		query.append(",'' SHIPPER_CD" ).append("\n"); 
		query.append(",'' SHIPPER_NM" ).append("\n"); 
		query.append(",'' CNEE_CD" ).append("\n"); 
		query.append(",'' CNEE_NM" ).append("\n"); 
		query.append(",'' NTFY_CD" ).append("\n"); 
		query.append(",'' NTFY_NM" ).append("\n"); 
		query.append(",'' AR_ACT_CD" ).append("\n"); 
		query.append(",'' AR_ACT_NM" ).append("\n"); 
		query.append(",'' SVC_PROVDR_CD" ).append("\n"); 
		query.append(",'' SVC_PROVDR_NM" ).append("\n"); 
		query.append(",'' SC_NO" ).append("\n"); 
		query.append(",'' RFA_NO" ).append("\n"); 
		query.append(",'' INV_CURR_CD" ).append("\n"); 
		query.append(",'' INV_CHG_AMT" ).append("\n"); 
		query.append(",'' AS INV_ORG_AMT" ).append("\n"); 
		query.append(",'' AS INV_DC_AMT" ).append("\n"); 
		query.append(",'' ORG_CURR_CD" ).append("\n"); 
		query.append(",'' ORG_CHG_AMT" ).append("\n"); 
		query.append(",'' EXPT_AMT" ).append("\n"); 
		query.append(",'' DC_AMT" ).append("\n"); 
		query.append(",'' BIL_AMT" ).append("\n"); 
		query.append(",'' INV_XCH_RT" ).append("\n"); 
		query.append(",'' SVR_ID" ).append("\n"); 
		query.append(",'' CNTR_CYC_NO" ).append("\n"); 
		query.append(",'' DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",'' CHG_SEQ" ).append("\n"); 
		query.append(",'' DMDT_INV_NO" ).append("\n"); 
		query.append(",'' VSL_CD" ).append("\n"); 
		query.append(",'' SKD_VOY_NO" ).append("\n"); 
		query.append(",'' SKD_DIR_CD" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}