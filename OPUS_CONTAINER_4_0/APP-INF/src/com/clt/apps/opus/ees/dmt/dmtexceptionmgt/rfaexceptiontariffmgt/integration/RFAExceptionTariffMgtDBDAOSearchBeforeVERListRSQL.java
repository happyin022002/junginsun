/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchBeforeVERListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.03 
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

public class RFAExceptionTariffMgtDBDAOSearchBeforeVERListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DAR No. 에 해당되는 모든 VER 정보를 조회하는 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchBeforeVERListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchBeforeVERListRSQL").append("\n"); 
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
		query.append("SELECT 	DISTINCT" ).append("\n"); 
		query.append("LPAD(A.RFA_EXPT_VER_SEQ, 3, '0') AS RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(", 	A.DMDT_EXPT_RQST_STS_CD || ':' || B.INTG_CD_VAL_DP_DESC  || ':' || A.RQST_OFC_CD AS DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_TRF A, COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	A.RFA_EXPT_DAR_NO = @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("#if(${is_temp} == 'N')" ).append("\n"); 
		query.append("AND A.DMDT_EXPT_RQST_STS_CD != 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.DMDT_EXPT_RQST_STS_CD = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND B.INTG_CD_ID = 'CD02069'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY RFA_EXPT_VER_SEQ DESC" ).append("\n"); 

	}
}