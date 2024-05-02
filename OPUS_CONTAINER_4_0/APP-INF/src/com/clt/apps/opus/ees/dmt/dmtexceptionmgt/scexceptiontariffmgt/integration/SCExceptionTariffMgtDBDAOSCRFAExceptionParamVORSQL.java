/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSCRFAExceptionParamVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.03 
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

public class SCExceptionTariffMgtDBDAOSCRFAExceptionParamVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C & RFA Exception Inquiry 조회 정보를 입출력시 사용될 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSCRFAExceptionParamVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSCRFAExceptionParamVORSQL").append("\n"); 
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
		query.append("SELECT	'' VER_STS_CD" ).append("\n"); 
		query.append(",	'' RQST_STS_CD" ).append("\n"); 
		query.append(",	'' TARIFF" ).append("\n"); 
		query.append(",	'' OFC_CD" ).append("\n"); 
		query.append(",	'' FM_DT" ).append("\n"); 
		query.append(",	'' TO_DT" ).append("\n"); 
		query.append(",	'' CNT_CD" ).append("\n"); 
		query.append(",	'' RGN_CD" ).append("\n"); 
		query.append(",	'' STE_CD" ).append("\n"); 
		query.append(",	'' LOC_CD" ).append("\n"); 
		query.append(",	'' SC_NO" ).append("\n"); 
		query.append(",	'' RFA_NO" ).append("\n"); 
		query.append(",	'' PROP_NO" ).append("\n"); 
		query.append(",	'' DAR_NO" ).append("\n"); 
		query.append(",	'' APVL_NO" ).append("\n"); 
		query.append(",	'' TYPE" ).append("\n"); 
		query.append(",	'' COND_TP" ).append("\n"); 
		query.append(",	'' CUST_TP" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	'' ACT_CUST_CD" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}