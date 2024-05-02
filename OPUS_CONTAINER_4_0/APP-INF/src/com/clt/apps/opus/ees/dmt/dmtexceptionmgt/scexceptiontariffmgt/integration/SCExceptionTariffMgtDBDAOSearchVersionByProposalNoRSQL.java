/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchVersionByProposalNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.27 
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

public class SCExceptionTariffMgtDBDAOSearchVersionByProposalNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal No. 에 해당되는 모든 Version 과 Status 정보를 조회하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchVersionByProposalNoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchVersionByProposalNoRSQL").append("\n"); 
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
		query.append("LPAD(A.SC_EXPT_VER_SEQ, 3, '0') SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	A.DMDT_EXPT_VER_STS_CD || ':' || B.INTG_CD_VAL_DP_DESC  DMDT_EXPT_VER_STS_CD" ).append("\n"); 
		query.append("FROM	DMT_SC_EXPT_VER A, COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE	A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.DMDT_EXPT_VER_STS_CD = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND B.INTG_CD_ID = 'CD01972'" ).append("\n"); 
		query.append("ORDER BY A.SC_EXPT_VER_SEQ DESC" ).append("\n"); 

	}
}