/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSCExceptionCoverageVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.29 
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

public class SCExceptionTariffMgtDBDAOSCExceptionCoverageVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C별 DEM/DET 등록된 특별 계약 내용 중 Multi Coverage 정보데이터를 저장하는 VO
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSCExceptionCoverageVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSCExceptionCoverageVORSQL").append("\n"); 
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
		query.append(",	SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",	CVRG_SEQ" ).append("\n"); 
		query.append(",	CNT_CD" ).append("\n"); 
		query.append(",	'' RGN_ALL_CD" ).append("\n"); 
		query.append(",	'' RGN_ALL_NM" ).append("\n"); 
		query.append(",	RGN_CD" ).append("\n"); 
		query.append(",	'' STE_ALL_CD" ).append("\n"); 
		query.append(",	'' STE_ALL_NM" ).append("\n"); 
		query.append(",	STE_CD" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	'' CRE_OFC_CD" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	'' UPD_OFC_CD" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM DMT_SC_EXPT_CVRG" ).append("\n"); 

	}
}