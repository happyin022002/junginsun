/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOBeforeAfterStatusInputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.12 
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

public class RFAExceptionTariffMgtDBDAOBeforeAfterStatusInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Adjustment Request & Approval Status 조회를 위해 필요한 파라미터 정보를 저장하기 위한 VO객체 생성용 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOBeforeAfterStatusInputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOBeforeAfterStatusInputVORSQL").append("\n"); 
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
		query.append("SELECT	'' TYPE" ).append("\n"); 
		query.append(",	'' COND_TP" ).append("\n"); 
		query.append(",	'' TAB_TP" ).append("\n"); 
		query.append(",	'' GROUP_BY" ).append("\n"); 
		query.append(",	'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",	'' FM_DT" ).append("\n"); 
		query.append(",	'' TO_DT" ).append("\n"); 
		query.append(",	'' USR_OFC_CD" ).append("\n"); 
		query.append(",	'' USR_OFC_ONLY" ).append("\n"); 
		query.append(",	'' USR_ROLE_CD" ).append("\n"); 
		query.append(",	'' IS_OWNED_ROLE" ).append("\n"); 
		query.append(",	'' LOGIN_OFC_CD" ).append("\n"); 
		query.append(",	'' LOGIN_USR_ID" ).append("\n"); 
		query.append(",	'' TO_CC" ).append("\n"); 
		query.append(",	'' USR_ID" ).append("\n"); 
		query.append(",	'' SC_NO" ).append("\n"); 
		query.append(",	'' RFA_NO" ).append("\n"); 
		query.append(",	'' PROP_NO" ).append("\n"); 
		query.append(",	'' DAR_NO" ).append("\n"); 
		query.append(",	'' APVL_NO" ).append("\n"); 
		query.append(",	'' BKG_NO" ).append("\n"); 
		query.append(",	'' BL_NO" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	'' CUST_CNT_CD" ).append("\n"); 
		query.append(",	'' CUST_SEQ" ).append("\n"); 
		query.append(",	'' IS_TEMP" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}