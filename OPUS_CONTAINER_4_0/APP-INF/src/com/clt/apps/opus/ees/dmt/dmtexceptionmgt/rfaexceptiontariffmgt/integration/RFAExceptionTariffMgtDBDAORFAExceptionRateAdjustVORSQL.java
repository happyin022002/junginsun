/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAORFAExceptionRateAdjustVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.10 
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

public class RFAExceptionTariffMgtDBDAORFAExceptionRateAdjustVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA별 DEM/DET 등록된 특별 계약 내용 중 Rate Adjustment 정보데이터를 저장하는 VO
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAORFAExceptionRateAdjustVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append(",	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	CVRG_CMB_SEQ" ).append("\n"); 
		query.append(",	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",	RFA_EXPT_RT_SEQ" ).append("\n"); 
		query.append(",	FT_OVR_DYS" ).append("\n"); 
		query.append(",	FT_UND_DYS" ).append("\n"); 
		query.append(",	CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append(",	CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append(",	CNTR_HC_RT_AMT" ).append("\n"); 
		query.append(",	CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append(",	N1ST_CMNC_VER_SEQ" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append("FROM DMT_RFA_EXPT_RT" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAORFAExceptionRateAdjustVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}