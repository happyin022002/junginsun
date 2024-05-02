/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOEDIVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOEDIVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI 로 전송할 데이터와 전송 후 이력을 쌓기 위한 정보를 저장하고 있는 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public ChargeCalculationDBDAOEDIVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOEDIVORSQL").append("\n"); 
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
		query.append("SELECT	'' AS BKG_NO" ).append("\n"); 
		query.append(",	SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_CYC_NO" ).append("\n"); 
		query.append(",	DMDT_EDI_HIS_SEQ" ).append("\n"); 
		query.append(",	EDI_ISS_DT" ).append("\n"); 
		query.append(",	EDI_ISS_USR_ID" ).append("\n"); 
		query.append(",	DEM_FT_END_DT" ).append("\n"); 
		query.append(",	DET_FT_END_DT" ).append("\n"); 
		query.append(",	DET_FT_OVR_DYS" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_EDI_HIS" ).append("\n"); 

	}
}