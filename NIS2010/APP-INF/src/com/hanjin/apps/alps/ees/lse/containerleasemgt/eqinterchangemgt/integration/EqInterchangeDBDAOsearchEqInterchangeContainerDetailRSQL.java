/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeDBDAOsearchEqInterchangeContainerDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeDBDAOsearchEqInterchangeContainerDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ interchange pick-up/off-hire 장비의 상세내역을 조회합니다.
	  * </pre>
	  */
	public EqInterchangeDBDAOsearchEqInterchangeContainerDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOsearchEqInterchangeContainerDetailRSQL").append("\n"); 
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
		query.append("#if (${cntr_sts_cd} == 'OF')" ).append("\n"); 
		query.append("SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("               ROWNUM seq_no," ).append("\n"); 
		query.append("               B.CNTR_NO," ).append("\n"); 
		query.append("               A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               B.AGMT_CTY_CD||LPAD(B.AGMT_SEQ, 6, '0') AS lsi_agmt_no," ).append("\n"); 
		query.append("               C.REF_NO lsi_ref_no," ).append("\n"); 
		query.append("               A.CNMV_STS_CD," ).append("\n"); 
		query.append("               TO_CHAR(E.CNTR_STS_EVNT_DT,'YYYYMMDD') cntr_sts_evnt_dt," ).append("\n"); 
		query.append("               E.YD_CD," ).append("\n"); 
		query.append("               B.RNTL_CHG_FREE_DYS," ).append("\n"); 
		query.append("               TO_CHAR(B.CNTR_STS_EVNT_DT,'YYYYMMDD') cntr_rtn_evnt_dt," ).append("\n"); 
		query.append("               B.YD_CD rtn_yd_cd," ).append("\n"); 
		query.append("               ROUND(NVL(E.CNTR_STS_EVNT_DT, SYSDATE) - B.CNTR_STS_EVNT_DT) AS TTL_USE_DYS" ).append("\n"); 
		query.append("               ,F.BKG_NO" ).append("\n"); 
		query.append("               ,F.POL_CD" ).append("\n"); 
		query.append("               ,F.POR_CD" ).append("\n"); 
		query.append("               ,F.POD_CD" ).append("\n"); 
		query.append("               ,F.DEL_CD" ).append("\n"); 
		query.append("               ,F.POL_ETD_DT ETD_DT" ).append("\n"); 
		query.append("               ,F.POD_ETA_DT ETA_DT" ).append("\n"); 
		query.append("               ,F.VSL_CD || F.SKD_VOY_NO || F.SKD_DIR_CD VVD   " ).append("\n"); 
		query.append("          FROM MST_CONTAINER A," ).append("\n"); 
		query.append("               MST_CNTR_STS_HIS B," ).append("\n"); 
		query.append("               LSE_AGREEMENT C," ).append("\n"); 
		query.append("               MDM_VENDOR D," ).append("\n"); 
		query.append("               MST_CNTR_STS_HIS E," ).append("\n"); 
		query.append("               (SELECT A.LSE_ITCHG_RQST_NO " ).append("\n"); 
		query.append("                      ,A.LSTM_CD" ).append("\n"); 
		query.append("                      ,B.AGMT_SEQ" ).append("\n"); 
		query.append("                      ,A.LR_VNDR_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT VNDR_LGL_ENG_NM  FROM MDM_VENDOR WHERE VNDR_SEQ = A.LR_VNDR_SEQ) vndr_abbr_nm" ).append("\n"); 
		query.append("                      ,A.RCC_CD" ).append("\n"); 
		query.append("                      ,A.LCC_CD" ).append("\n"); 
		query.append("                      ,A.FM_LOC_CD" ).append("\n"); 
		query.append("                      ,A.LSE_LOC_GRP_CD" ).append("\n"); 
		query.append("                      ,A.TO_LOC_CD " ).append("\n"); 
		query.append("                      ,A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_QTY" ).append("\n"); 
		query.append("                      ,B.LSE_FREE_DYS" ).append("\n"); 
		query.append("                      ,B.PKUP_UT_AMT" ).append("\n"); 
		query.append("                      ,B.PKUP_CR_AMT" ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("                      ,A.LSE_ITCHG_RQST_SEQ" ).append("\n"); 
		query.append("                      ,B.CRE_DT CRE_DT" ).append("\n"); 
		query.append("                FROM LSE_EQ_ITCHG_RQST A, LSE_EQ_ITCHG B" ).append("\n"); 
		query.append("                WHERE A.LSE_ITCHG_AUTH_NO = B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("                AND A.LSE_ITCHG_AUTH_SEQ = B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("                AND B.LSE_ITCHG_AUTH_NO = @[auth_no]" ).append("\n"); 
		query.append("                AND B.LSE_ITCHG_AUTH_SEQ = @[auth_seq]" ).append("\n"); 
		query.append("                AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND A.LSTM_CD ='OF'" ).append("\n"); 
		query.append("                ) G ," ).append("\n"); 
		query.append("                BKG_BOOKING F" ).append("\n"); 
		query.append("         WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("           AND B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND B.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("           AND G.LSE_ITCHG_AUTH_NO = B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("           AND B.CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append("           AND A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("           AND B.CNTR_NO = E.CNTR_NO (+)" ).append("\n"); 
		query.append("           AND B.CNTR_STS_SEQ = E.PRNR_STS_SEQ (+)" ).append("\n"); 
		query.append("           AND C.LSTM_CD = 'OF'" ).append("\n"); 
		query.append("           AND G.LSE_ITCHG_AUTH_SEQ = B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("           AND A.BKG_NO = F.BKG_NO(+)" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} == 'SO')" ).append("\n"); 
		query.append("SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("               ROWNUM seq_no," ).append("\n"); 
		query.append("               B.CNTR_NO," ).append("\n"); 
		query.append("               A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               B.AGMT_CTY_CD||LPAD(B.AGMT_SEQ, 6, '0') AS lsi_agmt_no," ).append("\n"); 
		query.append("               C.REF_NO lsi_ref_no," ).append("\n"); 
		query.append("               A.CNMV_STS_CD," ).append("\n"); 
		query.append("               TO_CHAR(E.CNTR_STS_EVNT_DT,'YYYYMMDD') cntr_sts_evnt_dt," ).append("\n"); 
		query.append("               E.YD_CD," ).append("\n"); 
		query.append("               B.RNTL_CHG_FREE_DYS," ).append("\n"); 
		query.append("               TO_CHAR(B.CNTR_STS_EVNT_DT,'YYYYMMDD') cntr_rtn_evnt_dt," ).append("\n"); 
		query.append("               B.YD_CD rtn_yd_cd," ).append("\n"); 
		query.append("               ROUND(NVL(E.CNTR_STS_EVNT_DT, SYSDATE) - B.CNTR_STS_EVNT_DT) AS TTL_USE_DYS" ).append("\n"); 
		query.append("          FROM MST_CONTAINER A," ).append("\n"); 
		query.append("               MST_CNTR_STS_HIS B," ).append("\n"); 
		query.append("               LSE_AGREEMENT C," ).append("\n"); 
		query.append("               MDM_VENDOR D," ).append("\n"); 
		query.append("               MST_CNTR_STS_HIS E," ).append("\n"); 
		query.append("               (SELECT A.LSE_ITCHG_RQST_NO " ).append("\n"); 
		query.append("                      ,A.LSTM_CD" ).append("\n"); 
		query.append("                      ,B.AGMT_SEQ" ).append("\n"); 
		query.append("                      ,A.LR_VNDR_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT VNDR_LGL_ENG_NM  FROM MDM_VENDOR WHERE VNDR_SEQ = A.LR_VNDR_SEQ) vndr_abbr_nm" ).append("\n"); 
		query.append("                      ,A.RCC_CD" ).append("\n"); 
		query.append("                      ,A.LCC_CD" ).append("\n"); 
		query.append("                      ,A.FM_LOC_CD" ).append("\n"); 
		query.append("                      ,A.LSE_LOC_GRP_CD" ).append("\n"); 
		query.append("                      ,A.TO_LOC_CD " ).append("\n"); 
		query.append("                      ,A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_QTY" ).append("\n"); 
		query.append("                      ,B.LSE_FREE_DYS" ).append("\n"); 
		query.append("                      ,B.PKUP_UT_AMT" ).append("\n"); 
		query.append("                      ,B.PKUP_CR_AMT" ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("                      ,A.LSE_ITCHG_RQST_SEQ" ).append("\n"); 
		query.append("                      ,B.CRE_DT CRE_DT" ).append("\n"); 
		query.append("                FROM LSE_EQ_ITCHG_RQST A, LSE_EQ_ITCHG B" ).append("\n"); 
		query.append("                WHERE A.LSE_ITCHG_AUTH_NO = B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("                AND A.LSE_ITCHG_AUTH_SEQ = B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("                AND B.LSE_ITCHG_AUTH_NO = @[auth_no]" ).append("\n"); 
		query.append("                AND B.LSE_ITCHG_AUTH_SEQ = @[auth_seq]" ).append("\n"); 
		query.append("                AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND A.LSTM_CD ='SO'" ).append("\n"); 
		query.append("                ) G" ).append("\n"); 
		query.append("         WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("           AND B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND B.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("           AND G.LSE_ITCHG_AUTH_NO = B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("           AND B.CNTR_STS_CD = 'SBO'" ).append("\n"); 
		query.append("           AND A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("           AND B.CNTR_NO = E.CNTR_NO (+)" ).append("\n"); 
		query.append("           AND B.CNTR_STS_SEQ = E.PRNR_STS_SEQ (+)" ).append("\n"); 
		query.append("           AND G.LSE_ITCHG_AUTH_SEQ = B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}