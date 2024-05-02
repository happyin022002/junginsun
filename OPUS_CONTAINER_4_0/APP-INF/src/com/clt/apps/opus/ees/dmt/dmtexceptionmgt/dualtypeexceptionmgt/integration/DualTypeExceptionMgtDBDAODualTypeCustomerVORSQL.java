/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAODualTypeCustomerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DualTypeExceptionMgtDBDAODualTypeCustomerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 지역 Calculation Type과 무관하게 Combined Tariff 적용이 필요한 화주 등록 및 조회시 사용될 VO
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAODualTypeCustomerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAODualTypeCustomerVORSQL").append("\n"); 
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
		query.append("SELECT	DUL_EXPT_DELT_FLG" ).append("\n"); 
		query.append(",	'' DUL_EXPT_DELT_DESC" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	'' CUST_NM" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	CUST_EXPT_SEQ" ).append("\n"); 
		query.append(",	DUL_EXPT_EFF_DT" ).append("\n"); 
		query.append(",	DUL_EXPT_EXP_DT" ).append("\n"); 
		query.append(",	'' DUL_EXPT_EFF_FROM_DT" ).append("\n"); 
		query.append(",	'' DUL_EXPT_EFF_TO_DT" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	'' IO_BND_DESC" ).append("\n"); 
		query.append(",	DMDT_CTRT_EXPT_TP_CD" ).append("\n"); 
		query.append(",	CVRG_CNT_CD" ).append("\n"); 
		query.append(",	CVRG_RGN_STE_CD" ).append("\n"); 
		query.append(",	'' CVRG_RGN_STE_ALL_CD" ).append("\n"); 
		query.append(",	'' CVRG_RGN_STE_ALL_NM" ).append("\n"); 
		query.append(",	'' CVRG_RGN_CD" ).append("\n"); 
		query.append(",	'' CVRG_STE_CD" ).append("\n"); 
		query.append(",	CVRG_LOC_CD" ).append("\n"); 
		query.append(",	'' DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append(",	'' DMDT_CNTR_CGO_TP_ALL_CD" ).append("\n"); 
		query.append(",	'' DMDT_CNTR_CGO_TP_ALL_NM" ).append("\n"); 
		query.append(",	DUL_EXPT_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	'' EXP_FLG" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	'' UPD_USR_NM" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	EXP_USR_ID" ).append("\n"); 
		query.append(",	EXP_OFC_CD" ).append("\n"); 
		query.append(",	'' EXP_USR_NM" ).append("\n"); 
		query.append(",	'' EXP_DT" ).append("\n"); 
		query.append(",	'' DEL_OFC_CD" ).append("\n"); 
		query.append(",	'' DEL_USR_NM" ).append("\n"); 
		query.append(",	'' DEL_DT" ).append("\n"); 
		query.append(",	'' CODE1" ).append("\n"); 
		query.append(",	'' CODE2" ).append("\n"); 
		query.append(",	'' INTG_CD_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_DUL_TP_EXPT" ).append("\n"); 

	}
}