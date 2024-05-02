/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchVERByApprovalNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.24 
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

public class RFAExceptionTariffMgtDBDAOSearchVERByApprovalNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approval No. 에 해당되는 Version Seq. 를 조회하기 위한 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchVERByApprovalNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchVERByApprovalNoRSQL").append("\n"); 
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
		query.append("SELECT	LPAD(RFA_EXPT_VER_SEQ, 3, '0') RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_TRF" ).append("\n"); 
		query.append("WHERE	RFA_EXPT_APRO_NO = @[rfa_expt_apro_no]" ).append("\n"); 

	}
}