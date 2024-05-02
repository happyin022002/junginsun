/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOBeforeExceptionVersionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.15 
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

public class RFAExceptionTariffMgtDBDAOBeforeExceptionVersionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Exception Tariff Version 정보를 입출력하기 위해서 사용하는 VO 객체 생성용 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOBeforeExceptionVersionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOBeforeExceptionVersionVORSQL").append("\n"); 
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
		query.append("RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	PROP_NO" ).append("\n"); 
		query.append(",	DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append(",	'' PROG_RMK" ).append("\n"); 
		query.append(",	BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	RQST_OFC_CD" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append(",	RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append(",	APRO_USR_ID" ).append("\n"); 
		query.append(",	APRO_DT" ).append("\n"); 
		query.append(",	APRO_OFC_CD" ).append("\n"); 
		query.append(",	MSG_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append("FROM DMT_RFA_EXPT_TRF" ).append("\n"); 

	}
}