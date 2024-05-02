/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOBeforeExceptionListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOBeforeExceptionListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DAR History 목록정보를 저장하기 위한 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOBeforeExceptionListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOBeforeExceptionListVORSQL").append("\n"); 
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
		query.append("SELECT	'' RFA_NO" ).append("\n"); 
		query.append(",	APRO_OFC_CD" ).append("\n"); 
		query.append(",	RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append(",	'' DMDT_EXPT_RQST_STS_DESC" ).append("\n"); 
		query.append(",	'' REQ_OFC_CD" ).append("\n"); 
		query.append(",	'' REQ_USR_NM" ).append("\n"); 
		query.append(",	'' REQ_DT" ).append("\n"); 
		query.append(",	'' APVL_OFC_CD" ).append("\n"); 
		query.append(",	'' APVL_USR_NM" ).append("\n"); 
		query.append(",	'' APVL_DT" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_TRF" ).append("\n"); 

	}
}