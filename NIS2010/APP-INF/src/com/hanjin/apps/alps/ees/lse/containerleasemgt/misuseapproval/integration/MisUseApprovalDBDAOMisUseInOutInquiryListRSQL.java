/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MisUseApprovalDBDAOMisUseInOutInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.01.04 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MisUseApprovalDBDAOMisUseInOutInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 자사 및 타사장비의 Miss Use된 장비의 현황을 조회한다.
	  * </pre>
	  */
	public MisUseApprovalDBDAOMisUseInOutInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mss_rqst_io_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.integration").append("\n"); 
		query.append("FileName : MisUseApprovalDBDAOMisUseInOutInquiryListRSQL").append("\n"); 
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
		query.append("SELECT  AA.RQST_NO, AA.APRO_NO, AA.RQST_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(AA.RQST_DT,'YYYYMMDD') AS RQST_DT, AA.MSS_RQST_IO_MOD_CD," ).append("\n"); 
		query.append("REGEXP_REPLACE(AA.N1ST_REF_OFC_CD||','||AA.N2ND_REF_OFC_CD" ).append("\n"); 
		query.append("||','||AA.N3RD_REF_OFC_CD||','||AA.N4TH_REF_OFC_CD," ).append("\n"); 
		query.append("'^,|(,){2}|,$','') AS REF_OFC_CD," ).append("\n"); 
		query.append("AA.N1ST_REF_OFC_CD, AA.N2ND_REF_OFC_CD, AA.N3RD_REF_OFC_CD, AA.N4TH_REF_OFC_CD," ).append("\n"); 
		query.append("AA.RQST_USR_ID, AA.DIFF_RMK, AA.CURR_CD, AA.APRO_OFC_CD, AA.APRO_USR_ID, AA.APRO_RMK," ).append("\n"); 
		query.append("AA.CNTR_NO, AA.AGMT_CTY_CD, AA.AGMT_SEQ, AA.CNTR_TPSZ_CD, AA.LSTM_CD," ).append("\n"); 
		query.append("TO_CHAR(AA.MSS_USD_DT,'YYYYMMDD') AS MSS_USD_DT, AA.MSS_USD_FM_NM," ).append("\n"); 
		query.append("AA.MSS_USE_PLC_NM, AA.PD_CHG_RT_AMT, AA.LFT_CHG_RT_AMT, AA.LIBOR_PTY_NM," ).append("\n"); 
		query.append("DECODE(AA.MSS_USD_APRO_MOD_CD, 'A','APP','R','REJ','C','CNL','REQ') AS MSS_USD_APRO_MOD_CD," ).append("\n"); 
		query.append("AA.RQST_LOC_NM, AA.APRO_AGMT_CTY_CD, AA.APRO_AGMT_SEQ," ).append("\n"); 
		query.append("AA.APRO_AGMT_CTY_CD||LPAD(AA.APRO_AGMT_SEQ, 6, '0') AS APRO_AGMT_NO," ).append("\n"); 
		query.append("AA.RQST_FILE_SAV_ID, AA.RQST_RSN_DESC," ).append("\n"); 
		query.append("DECODE(AA.RQST_DELT_FLG, 'N',AA.RQST_FILE_SAV_NM,NULL) AS RQST_FILE_SAV_NM," ).append("\n"); 
		query.append("AA.APRO_FILE_SAV_ID, AA.APRO_RSN_DESC," ).append("\n"); 
		query.append("DECODE(AA.APRO_DELT_FLG, 'N',AA.APRO_FILE_SAV_NM,NULL) AS APRO_FILE_SAV_NM," ).append("\n"); 
		query.append("AA.CXL_FILE_SAV_ID,  AA.CXL_RSN_DESC," ).append("\n"); 
		query.append("DECODE(AA.CXL_DELT_FLG, 'N',AA.CXL_FILE_SAV_NM,NULL) AS CXL_FILE_SAV_NM" ).append("\n"); 
		query.append("FROM   (SELECT  A.RQST_NO, A.APRO_NO, A.RQST_OFC_CD, A.RQST_DT, A.MSS_RQST_IO_MOD_CD," ).append("\n"); 
		query.append("A.N1ST_REF_OFC_CD, A.N2ND_REF_OFC_CD, A.N3RD_REF_OFC_CD, A.N4TH_REF_OFC_CD," ).append("\n"); 
		query.append("A.RQST_USR_ID, A.DIFF_RMK, A.CURR_CD, B.APRO_OFC_CD, B.APRO_USR_ID, B.APRO_RMK," ).append("\n"); 
		query.append("C.CNTR_NO, C.AGMT_CTY_CD, C.AGMT_SEQ, C.CNTR_TPSZ_CD, C.LSTM_CD," ).append("\n"); 
		query.append("C.MSS_USD_DT, C.MSS_USD_FM_NM, C.MSS_USE_PLC_NM, C.PD_CHG_RT_AMT," ).append("\n"); 
		query.append("C.LFT_CHG_RT_AMT, C.LIBOR_PTY_NM, C.MSS_USD_APRO_MOD_CD, C.RQST_LOC_NM," ).append("\n"); 
		query.append("C.APRO_AGMT_CTY_CD, C.APRO_AGMT_SEQ, C.MVMT_STS_CD, C.POD_CD, C.POL_CD," ).append("\n"); 
		query.append("D.FILE_SAV_ID AS RQST_FILE_SAV_ID, D.FILE_UPLD_NM AS RQST_FILE_SAV_NM, C.RQST_RSN_DESC," ).append("\n"); 
		query.append("E.FILE_SAV_ID AS APRO_FILE_SAV_ID, E.FILE_UPLD_NM AS APRO_FILE_SAV_NM, C.APRO_RSN_DESC," ).append("\n"); 
		query.append("F.FILE_SAV_ID AS CXL_FILE_SAV_ID, F.FILE_UPLD_NM AS CXL_FILE_SAV_NM, C.CXL_RSN_DESC," ).append("\n"); 
		query.append("D.DELT_FLG AS RQST_DELT_FLG, E.DELT_FLG AS APRO_DELT_FLG, F.DELT_FLG AS CXL_DELT_FLG" ).append("\n"); 
		query.append("FROM    LSE_MSS_USD_RQST A," ).append("\n"); 
		query.append("LSE_MSS_USD_APRO B," ).append("\n"); 
		query.append("LSE_MSS_USD_CNTR C," ).append("\n"); 
		query.append("COM_UPLD_FILE D," ).append("\n"); 
		query.append("COM_UPLD_FILE E," ).append("\n"); 
		query.append("COM_UPLD_FILE F" ).append("\n"); 
		query.append("WHERE   A.APRO_NO = B.APRO_NO(+)" ).append("\n"); 
		query.append("AND     A.RQST_NO = C.RQST_NO" ).append("\n"); 
		query.append("AND     C.RQST_FILE_SAV_ID = D.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("AND     C.APRO_FILE_SAV_ID = E.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("AND     C.CXL_FILE_SAV_ID  = F.FILE_SAV_ID(+)" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${rqst_ofc_cd} != \"\")" ).append("\n"); 
		query.append("AND     AA.RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mss_rqst_io_mod_cd} != \"\")" ).append("\n"); 
		query.append("AND     AA.MSS_RQST_IO_MOD_CD = @[mss_rqst_io_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${str_rqst_dt} != \"\")" ).append("\n"); 
		query.append("AND     AA.RQST_DT BETWEEN TO_DATE(@[str_rqst_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("AND 	TO_DATE(@[end_rqst_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mss_usd_apro_flag} == \"R\")" ).append("\n"); 
		query.append("AND     AA.MSS_USD_APRO_MOD_CD IS NULL" ).append("\n"); 
		query.append("#elseif (${mss_usd_apro_flag} == \"A\")" ).append("\n"); 
		query.append("AND     AA.MSS_USD_APRO_MOD_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY AA.RQST_NO, AA.APRO_NO, AA.CNTR_NO, DECODE(AA.MSS_USD_APRO_MOD_CD, 'A',1,'R',2,'C',4,3)" ).append("\n"); 

	}
}