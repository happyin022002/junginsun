/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanSplitCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2010.05.10 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN YONGCHAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanSplitCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_BOOKING, BKG_BOOKING 테이블에서  컨테이너-MOVEMENT정보 조회
	  * 
	  * - 20100510 SQL QUERY 수정, 신용찬 수석(신범철 확인)
	  * 1. CNMV_YR, CNMV_ID_NO --> CM.CNMV_YR, CM.CNMV_SEQ, CM.CNMV_SPLIT_NO 으로 변경
	  * 2. XPKCTM_MOVEMENT --> XUK1CTM_MOVEMENT 으로 변경
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanSplitCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanSplitCntrRSQL").append("\n"); 
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
		query.append("SELECT	 MC.CNTR_NO" ).append("\n"); 
		query.append(",MC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CM.MVMT_STS_CD" ).append("\n"); 
		query.append(",@[bkg_pod] POD" ).append("\n"); 
		query.append("FROM	CTM_MOVEMENT  CM," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("WITH CNTR_INFO AS (" ).append("\n"); 
		query.append("SELECT	 MC.CNTR_NO" ).append("\n"); 
		query.append(",MC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",MC.LSTM_CD" ).append("\n"); 
		query.append(",MC.CNMV_STS_CD" ).append("\n"); 
		query.append("FROM	MST_CONTAINER MC, MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE	MC.VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("AND	MC.ACIAC_DIV_CD <> 'I'" ).append("\n"); 
		query.append("AND	MC.CNTR_NO IN (" ).append("\n"); 
		query.append("SELECT	DISTINCT CNTR_NO" ).append("\n"); 
		query.append("FROM	BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE	BKG_NO = '${bkg_no}'" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("AND	CNTR_NO IN ( ${cntrNoText} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT	CNTR_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",LSTM_CD" ).append("\n"); 
		query.append(",CNMV_STS_CD" ).append("\n"); 
		query.append("FROM	CNTR_INFO" ).append("\n"); 
		query.append(") MC" ).append("\n"); 
		query.append("WHERE	CM.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("-- CNMV_YR, CNMV_ID_NO --> CM.CNMV_YR, CM.CNMV_SEQ, CM.CNMV_SPLIT_NO 으로 변경,  20100510 신용찬 수정(신범철 확인)" ).append("\n"); 
		query.append("--AND (CM.CNMV_YR, CM.CNMV_ID_NO) = (" ).append("\n"); 
		query.append("AND (CM.CNMV_YR, CM.CNMV_SEQ, CM.CNMV_SPLIT_NO) =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--SELECT /*+index_desc(a XPKCTM_MOVEMENT) */ CNMV_YR, CNMV_ID_NO" ).append("\n"); 
		query.append("-- 20100510 신용찬 수정(신범철 확인)" ).append("\n"); 
		query.append("-- XPKCTM_MOVEMENT --> XUK1CTM_MOVEMENT 으로 변경" ).append("\n"); 
		query.append("-- CNMV_YR, CNMV_ID_NO --> CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO 으로 변경" ).append("\n"); 
		query.append("SELECT /*+index_desc(a XUK1CTM_MOVEMENT) */ CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO" ).append("\n"); 
		query.append("FROM	CTM_MOVEMENT A" ).append("\n"); 
		query.append("WHERE	A.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}