/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchBeforeDARListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.18 
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

public class RFAExceptionTariffMgtDBDAOSearchBeforeDARListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal No. 에 해당되는 모든 DAR 정보를 조회하는 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchBeforeDARListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchBeforeDARListRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT RFA_EXPT_DAR_NO, APRO_OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_TRF" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#if(${apro_ofc_cd} == 'init')" ).append("\n"); 
		query.append("AND APRO_OFC_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	APRO_OFC_CD" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  APRO_OFC_CD" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF" ).append("\n"); 
		query.append("WHERE   PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("ORDER BY RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif(${apro_ofc_cd} != '')" ).append("\n"); 
		query.append("AND	APRO_OFC_CD = @[apro_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RFA_EXPT_DAR_NO" ).append("\n"); 

	}
}