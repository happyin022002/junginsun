/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchPropNoByDARApprovalNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.30 
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

public class RFAExceptionTariffMgtDBDAOSearchPropNoByDARApprovalNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA(Before Booking Request) 에서 DAR No. 나 Approval No. 로 Proposal No. 를 조회하기 위한 쿼리.
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchPropNoByDARApprovalNoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchPropNoByDARApprovalNoRSQL").append("\n"); 
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
		query.append("SELECT  PROP_NO, RFA_EXPT_DAR_NO, RFA_EXPT_APRO_NO, RFA_NO" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  ROWNUM IDX, A.PROP_NO, A.RFA_EXPT_DAR_NO, A.RFA_EXPT_APRO_NO, B.RFA_NO" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF A, PRI_RP_HDR B" ).append("\n"); 
		query.append("WHERE   A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("#if(${rfa_expt_dar_no} != '')" ).append("\n"); 
		query.append("AND A.RFA_EXPT_DAR_NO = @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rfa_expt_apro_no} != '')" ).append("\n"); 
		query.append("AND A.RFA_EXPT_APRO_NO = @[rfa_expt_apro_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${is_temp} == 'N')" ).append("\n"); 
		query.append("AND A.DMDT_EXPT_RQST_STS_CD <> 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE IDX = 1" ).append("\n"); 

	}
}