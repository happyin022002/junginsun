/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAORsltPriSqRtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.25 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateQuotationDBDAORsltPriSqRtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCRateQuotationDBDAORsltPriSqRtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAORsltPriSqRtVORSQL").append("\n"); 
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
		query.append("A.QTTN_NO" ).append("\n"); 
		query.append(",	A.QTTN_VER_NO" ).append("\n"); 
		query.append(",	A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",	A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",	A.ROUT_SEQ" ).append("\n"); 
		query.append(",	A.RT_SEQ" ).append("\n"); 
		query.append(",	A.RAT_UT_CD" ).append("\n"); 
		query.append(",	A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	A.CURR_CD" ).append("\n"); 
		query.append(",	A.PRS_SCG_AMT" ).append("\n"); 
		query.append(",	A.PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append(",	A.PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append(",	A.PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append(",	A.PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append(",	A.PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append(",	A.PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append(",	A.PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append(",	A.QTTN_INIT_RT_AMT" ).append("\n"); 
		query.append(",	A.QTTN_RT_AMT" ).append("\n"); 
		query.append(",	A.SRC_INFO_CD" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",	TO_CHAR(B.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",	TO_CHAR(B.EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append(",	C.QTTN_STS_CD" ).append("\n"); 
		query.append(",   (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE  INTG_CD_ID = 'CD02195'" ).append("\n"); 
		query.append("AND    INTG_CD_VAL_CTNT = C.QTTN_STS_CD) AS QTTN_STS_NM              --QUOTATION 상태명" ).append("\n"); 
		query.append(",   (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("from COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02200'" ).append("\n"); 
		query.append("AND   INTG_CD_VAL_CTNT = A.SRC_INFO_CD) AS SRC_INFO_NM" ).append("\n"); 
		query.append(",	DECODE(A.QTTN_RT_ADJ_TP_CD,'N','',A.QTTN_RT_ADJ_TP_CD) AS QTTN_RT_ADJ_TP_CD" ).append("\n"); 
		query.append(",   (A.QTTN_RT_AMT - A.QTTN_INIT_RT_AMT) AS RATE_ADJUST" ).append("\n"); 
		query.append(",	FIRST_VALUE(DECODE(A.PRC_CGO_TP_CD, 'DR', 1, 'RF', 2, 'DG', 3, 'AK', 4, 99))" ).append("\n"); 
		query.append("OVER(PARTITION BY A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.ROUT_SEQ, RT_SEQ) AS N1ST_ORD_REF" ).append("\n"); 
		query.append(",	FIRST_VALUE(A.RAT_UT_CD)" ).append("\n"); 
		query.append("OVER(PARTITION BY A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.RT_SEQ) AS N2ND_ORD_REF" ).append("\n"); 
		query.append(",   (CASE WHEN PRS_RESPB_CMPB_AMT IS NOT NULL AND PRS_GID_CMPB_AMT IS NOT NULL" ).append("\n"); 
		query.append("THEN PRS_RESPB_CMPB_AMT - PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END) AS DIFF" ).append("\n"); 
		query.append("FROM PRI_SQ_RT A" ).append("\n"); 
		query.append(",	 PRI_SQ_MN B" ).append("\n"); 
		query.append(",	 PRI_SQ_HDR C" ).append("\n"); 
		query.append("WHERE	A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND	A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND	A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("AND	A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND	A.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND	A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("AND	A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("AND	A.QTTN_NO = C.QTTN_NO" ).append("\n"); 
		query.append("ORDER BY N1ST_ORD_REF, N2ND_ORD_REF, A.RT_SEQ" ).append("\n"); 

	}
}