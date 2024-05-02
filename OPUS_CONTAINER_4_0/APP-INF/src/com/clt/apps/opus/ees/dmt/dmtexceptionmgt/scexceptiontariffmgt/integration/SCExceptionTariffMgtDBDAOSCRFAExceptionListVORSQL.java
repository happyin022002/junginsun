/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSCRFAExceptionListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.23 
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

public class SCExceptionTariffMgtDBDAOSCRFAExceptionListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C & RFA Exception Inquiry 조회된 결과를 입출력하기 위해서 사용될 VO 객체를 생성시키는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSCRFAExceptionListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSCRFAExceptionListVORSQL").append("\n"); 
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
		query.append("'' PROP_NO" ).append("\n"); 
		query.append(",	'' SC_NO" ).append("\n"); 
		query.append(",	'' VER_SEQ" ).append("\n"); 
		query.append(",	'' CVRG_SEQ" ).append("\n"); 
		query.append(",	'' RFA_NO" ).append("\n"); 
		query.append(",	'' DMDT_EXPT_VER_STS_CD" ).append("\n"); 
		query.append(",	'' DMDT_EXPT_VER_STS_TXT" ).append("\n"); 
		query.append(",	'' STATUS" ).append("\n"); 
		query.append(",	'' TARIFF" ).append("\n"); 
		query.append(",	'' EFF_DT" ).append("\n"); 
		query.append(",	'' EXP_DT" ).append("\n"); 
		query.append(",	'' CNTRCGO" ).append("\n"); 
		query.append(",	'' CNT_CD" ).append("\n"); 
		query.append(",	'' RGN_CD" ).append("\n"); 
		query.append(",	'' LOC_CD" ).append("\n"); 
		query.append(",	'' FT_TIR" ).append("\n"); 
		query.append(",	'' FT_ADD_DYS" ).append("\n"); 
		query.append(",	'' FT_TOT_DYS" ).append("\n"); 
		query.append(",	'' XCLD_SAT_FLG" ).append("\n"); 
		query.append(",	'' XCLD_SUN_FLG" ).append("\n"); 
		query.append(",	'' XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	'' CURR_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_MULTI" ).append("\n"); 
		query.append(",	'' ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_STE_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(",	'' FNL_DEST_CNT_CD" ).append("\n"); 
		query.append(",	'' FNL_DEST_RGN_CD" ).append("\n"); 
		query.append(",	'' FNL_DEST_STE_CD" ).append("\n"); 
		query.append(",	'' FNL_DEST_LOC_CD" ).append("\n"); 
		query.append(",	'' RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",	'' RT_FLG" ).append("\n"); 
		query.append(",	'' REP_CMDT_FLG" ).append("\n"); 
		query.append(",	'' ACT_CUST_FLG" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	'' CUST_NM" ).append("\n"); 
		query.append(",	'' ACT_CUST_CD" ).append("\n"); 
		query.append(",	'' ACT_CUST_NM" ).append("\n"); 
		query.append(",	'' DAR_NO" ).append("\n"); 
		query.append(",	'' APVL_NO" ).append("\n"); 
		query.append(",	'' GRP_SEQ" ).append("\n"); 
		query.append(",	'' AMDT_SEQ" ).append("\n"); 
		query.append(",	'' RQST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}