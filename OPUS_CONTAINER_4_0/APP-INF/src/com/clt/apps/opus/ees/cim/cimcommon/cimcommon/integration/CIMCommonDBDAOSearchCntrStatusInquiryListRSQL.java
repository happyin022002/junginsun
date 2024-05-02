/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CIMCommonDBDAOSearchCntrStatusInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOSearchCntrStatusInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Status Inquiry 조회
	  * </pre>
	  */
	public CIMCommonDBDAOSearchCntrStatusInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOSearchCntrStatusInquiryListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       A.CNTR_NO," ).append("\n"); 
		query.append("       SUBSTR(A.CNTR_NO,11) CHK_DGT," ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       A.LSTM_CD," ).append("\n"); 
		query.append("       A.CRNT_YD_CD," ).append("\n"); 
		query.append("       A.CNTR_USE_CO_CD," ).append("\n"); 
		query.append("       C.CNTR_STS_CD," ).append("\n"); 
		query.append("       TO_CHAR(C.CNTR_STS_EVNT_DT,'YYYY-MM-DD') AS CNTR_STS_EVNT_DT," ).append("\n"); 
		query.append("       C.YD_CD," ).append("\n"); 
		query.append("	   MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(C.AGMT_CTY_CD, C.AGMT_SEQ) AGMT_NO," ).append("\n"); 
		query.append("       G.REF_NO," ).append("\n"); 
		query.append("	   CASE WHEN C.CNTR_STS_CD IN ('SLD') " ).append("\n"); 
		query.append("	        THEN DECODE(NVL(C.CUST_CNT_CD,'0'), '0', '', C.CUST_CNT_CD||C.CUST_SEQ)" ).append("\n"); 
		query.append("	   ELSE MST_COMMON_PKG.MST_VNDR_SEQ_CONV_FNC(G.VNDR_SEQ) END VNDR_SEQ," ).append("\n"); 
		query.append("	   CASE WHEN C.CNTR_STS_CD IN ('SLD') " ).append("\n"); 
		query.append("	        THEN DECODE(NVL(C.CUST_CNT_CD,'0'), '0', C.CUST_NM, (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = C.CUST_CNT_CD AND CUST_SEQ = C.CUST_SEQ))" ).append("\n"); 
		query.append("	   ELSE H.VNDR_LGL_ENG_NM END VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       H.VNDR_ABBR_NM," ).append("\n"); 
		query.append("       DECODE(C.CNTR_FULL_FLG, 'Y', 'F', 'N', 'M', '') AS CNTR_FULL_FLG," ).append("\n"); 
		query.append("       C.CNMV_STS_CD," ).append("\n"); 
		query.append("       CASE WHEN C.CNTR_DRFF_CR_AMT > 0 THEN" ).append("\n"); 
		query.append("          C.CNTR_DRFF_CR_AMT " ).append("\n"); 
		query.append("       ELSE  0 END CNTR_DRFF_AMT," ).append("\n"); 
		query.append("       CASE WHEN C.CNTR_DRFF_CR_AMT < 0 THEN" ).append("\n"); 
		query.append("          C.CNTR_DRFF_CR_AMT * (-1)" ).append("\n"); 
		query.append("       ELSE 0 END CNTR_DRFF_CR_AMT,   " ).append("\n"); 
		query.append("       C.CNTR_LFT_CHG_AMT," ).append("\n"); 
		query.append("       C.CNTR_DIR_ITCHG_FEE_AMT," ).append("\n"); 
		query.append("       C.RNTL_CHG_FREE_DYS," ).append("\n"); 
		query.append("       CASE WHEN C.CNTR_PKUP_CHG_AMT > 0 THEN" ).append("\n"); 
		query.append("          C.CNTR_PKUP_CHG_AMT " ).append("\n"); 
		query.append("       ELSE  0 END CNTR_PKUP_CHG_AMT," ).append("\n"); 
		query.append("       CASE WHEN C.CNTR_PKUP_CHG_AMT < 0 THEN" ).append("\n"); 
		query.append("          C.CNTR_PKUP_CHG_AMT * (-1)" ).append("\n"); 
		query.append("       ELSE 0 END CNTR_PKUP_CHG_CR_AMT, " ).append("\n"); 
		query.append("       C.CRE_USR_ID," ).append("\n"); 
		query.append("       C.UPD_USR_ID," ).append("\n"); 
		query.append("       C.CNTR_STS_RMK," ).append("\n"); 
		query.append("       C.CNMV_STS_CD," ).append("\n"); 
		query.append("       C.CURR_CD," ).append("\n"); 
		query.append("       TO_CHAR(C.CRE_DT, 'YYYY-MM-DD HH24:MI') CRE_DT," ).append("\n"); 
		query.append("       TO_CHAR(C.UPD_DT, 'YYYY-MM-DD HH24:MI') UPD_DT," ).append("\n"); 
		query.append("       '' EVNT_DT1," ).append("\n"); 
		query.append("       '' LOC_CD1," ).append("\n"); 
		query.append("       '' EVNT_DT2," ).append("\n"); 
		query.append("       '' LOC_CD2," ).append("\n"); 
		query.append("       '' STAY_DAYS," ).append("\n"); 
		query.append("       C.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("FROM MST_CONTAINER A, " ).append("\n"); 
		query.append("     MST_CNTR_STS_HIS C," ).append("\n"); 
		query.append("     LSE_AGREEMENT G," ).append("\n"); 
		query.append("     MDM_VENDOR H" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND	A.CNTR_NO = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[p_cntr_no])" ).append("\n"); 
		query.append("AND C.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND G.AGMT_CTY_CD(+) = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND G.AGMT_SEQ(+) = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND G.VNDR_SEQ = H.VNDR_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY C.CNTR_STS_EVNT_DT, C.CNTR_STS_SEQ" ).append("\n"); 

	}
}