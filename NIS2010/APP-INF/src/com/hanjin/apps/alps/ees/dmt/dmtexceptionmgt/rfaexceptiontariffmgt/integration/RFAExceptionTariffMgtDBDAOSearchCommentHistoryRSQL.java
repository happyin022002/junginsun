/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchCommentHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.15 
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

public class RFAExceptionTariffMgtDBDAOSearchCommentHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Adjustment Request - Before Booking Request 의 Comment History 조회를 위한 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchCommentHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchCommentHistoryRSQL").append("\n"); 
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
		query.append("A.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	A.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	A.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	A.PROG_SEQ" ).append("\n"); 
		query.append(",	A.DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append(",	B.INTG_CD_VAL_DP_DESC DMDT_EXPT_RQST_STS_DESC" ).append("\n"); 
		query.append(",	REPLACE(A.PROG_RMK, '@*', chr(13) || chr(10)) PROG_RMK" ).append("\n"); 
		query.append(",	TO_CHAR(A.PROG_DT, 'YYYY-MM-DD') PROG_DT" ).append("\n"); 
		query.append(",	A.PROG_USR_ID" ).append("\n"); 
		query.append(",	NVL(C.USR_NM, '') PROG_USR_NM" ).append("\n"); 
		query.append(",	A.PROG_OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_TRF_PROG A" ).append("\n"); 
		query.append(", 	COM_INTG_CD_DTL B" ).append("\n"); 
		query.append(", 	COM_USER C" ).append("\n"); 
		query.append("WHERE	A.RFA_EXPT_DAR_NO 		= @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("AND	A.RFA_EXPT_MAPG_SEQ 	= @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("AND	A.RFA_EXPT_VER_SEQ 		= @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("AND A.DMDT_EXPT_RQST_STS_CD <> 'T'" ).append("\n"); 
		query.append("AND A.DMDT_EXPT_RQST_STS_CD = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND B.INTG_CD_ID 			= 'CD02069'" ).append("\n"); 
		query.append("AND A.PROG_USR_ID 			= C.USR_ID(+)" ).append("\n"); 
		query.append("ORDER BY A.PROG_SEQ DESC" ).append("\n"); 

	}
}