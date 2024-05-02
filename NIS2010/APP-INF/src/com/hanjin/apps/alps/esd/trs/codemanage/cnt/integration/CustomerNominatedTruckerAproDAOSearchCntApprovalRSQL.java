/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustomerNominatedTruckerAproDAOSearchCntApprovalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerAproDAOSearchCntApprovalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNT(Customer Nominated Trucker) Approval 조회
	  * </pre>
	  */
	public CustomerNominatedTruckerAproDAOSearchCntApprovalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerAproDAOSearchCntApprovalRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM AS SEQ" ).append("\n"); 
		query.append("      ,'' AS SEL" ).append("\n"); 
		query.append("      ,PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("      ,PRC_CTRT_NO" ).append("\n"); 
		query.append("      ,SLS_OFC_CD" ).append("\n"); 
		query.append("      ,CTRT_CUST_SREP_CD " ).append("\n"); 
		query.append("      ,CTRT_CUST_SREP_NM" ).append("\n"); 
		query.append("      ,CTRT_CUST_CNT_CD || LPAD(CTRT_CUST_SEQ, 6, 0) AS CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CTRT_CUST_SEQ" ).append("\n"); 
		query.append("      ,CTRT_CUST_NM      " ).append("\n"); 
		query.append("      ,CTRT_EFF_DT" ).append("\n"); 
		query.append("      ,CTRT_EXP_DT" ).append("\n"); 
		query.append("      ,FNL_MQC_DESC" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,VNDR_NM" ).append("\n"); 
		query.append("      ,USA_EDI_CD" ).append("\n"); 
		query.append("      ,SUBSTR(FM_NODE,1,5) FM_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(FM_NODE,6,2) FM_NOD_YARD" ).append("\n"); 
		query.append("      ,SUBSTR(DOR_NODE,1,5) DOR_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(DOR_NODE,6,2) DOR_NOD_YARD" ).append("\n"); 
		query.append("      ,SUBSTR(TO_NODE,1,5) TO_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(TO_NODE,6,2) TO_NOD_YARD" ).append("\n"); 
		query.append("      ,DECODE(LENGTH(DOR_NODE), 7, (SELECT ZN_NM FROM MDM_ZONE B WHERE B.ZN_CD = DOR_NODE AND B.DELT_FLG = 'N'), (SELECT LOC_NM FROM MDM_LOCATION B WHERE B.LOC_CD = DOR_NODE AND B.DELT_FLG = 'N'))  AS MTY_PKUP_RTN_YD_NM" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_BZC_AMT" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_FUEL_DIV_CD" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_FUEL_RTO" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_FUEL_AMT" ).append("\n"); 
		query.append("      ,RGST_USR_ID" ).append("\n"); 
		query.append("      ,RGST_OFC_CD" ).append("\n"); 
		query.append("      ,COST_DESC" ).append("\n"); 
		query.append("      ,APRO_HIS_DESC" ).append("\n"); 
		query.append("      ,APRO_NO" ).append("\n"); 
		query.append("      ,APRO_NO as APRO_NO2" ).append("\n"); 
		query.append("      ,DISP_STS_CD" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_SAV_DT" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_RQST_DT" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_RJCT_DT" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_APRO_DT   " ).append("\n"); 
		query.append("      ,APRO_OFC_CD" ).append("\n"); 
		query.append("      ,APRO_USR_ID" ).append("\n"); 
		query.append("      ,APRO_USR_NM" ).append("\n"); 
		query.append("      ,CASE WHEN DISP_STS_CD IN ('01','02') THEN SUBSTR(RT, 1, INSTR(RT, '$', 1, 1) -1)" ).append("\n"); 
		query.append("            ELSE HJS_TRKR_AGMT_NO" ).append("\n"); 
		query.append("        END AS HJS_TRKR_AGMT_NO       " ).append("\n"); 
		query.append("      ,CASE WHEN DISP_STS_CD IN ('01','02') THEN TO_NUMBER(SUBSTR(RT, INSTR(RT, '$', 1, 1) + 1, INSTR(RT, '$', 1, 2) - INSTR(RT, '$', 1, 1) - 1))" ).append("\n"); 
		query.append("            ELSE HJS_TRKR_BZC_AMT" ).append("\n"); 
		query.append("        END AS HJS_TRKR_BZC_AMT" ).append("\n"); 
		query.append("      ,CASE WHEN DISP_STS_CD IN ('01','02') THEN TO_NUMBER(SUBSTR(RT, INSTR(RT, '$', 1, 2) + 1, INSTR(RT, '$', 1, 3) - INSTR(RT, '$', 1, 2) - 1))" ).append("\n"); 
		query.append("            ELSE HJS_TRKR_FUEL_AMT" ).append("\n"); 
		query.append("        END AS HJS_TRKR_FUEL_AMT" ).append("\n"); 
		query.append("      ,CASE WHEN DISP_STS_CD IN ('01','02') THEN NVL2(SUBSTR(CNT_RT, 1, INSTR(CNT_RT, '$', 1, 1) -1), 'Y', 'N')" ).append("\n"); 
		query.append("            ELSE NVL2(HJS_CUST_NOMI_TRKR_AGMT_NO, 'Y', 'N')" ).append("\n"); 
		query.append("        END AS HJS_CUST_NOMI_TRKR_AGMT_NO_YN" ).append("\n"); 
		query.append("      ,CASE WHEN DISP_STS_CD IN ('01','02') THEN SUBSTR(CNT_RT, 1, INSTR(CNT_RT, '$', 1, 1) -1)" ).append("\n"); 
		query.append("            ELSE HJS_CUST_NOMI_TRKR_AGMT_NO" ).append("\n"); 
		query.append("        END AS HJS_CUST_NOMI_TRKR_AGMT_NO" ).append("\n"); 
		query.append("      ,CASE WHEN DISP_STS_CD IN ('01','02') THEN SUBSTR(CNT_RT, 1, INSTR(CNT_RT, '$', 1, 1) -1)" ).append("\n"); 
		query.append("            ELSE HJS_CUST_NOMI_TRKR_AGMT_NO" ).append("\n"); 
		query.append("        END AS HJS_TRKR_AGMT_NO" ).append("\n"); 
		query.append("      ,IO_BND_CD" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("      ,ATCH_FILE_LNK_ID AS EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("      ,DECODE(NVL(ATCH_FILE_LNK_ID, '0'), '0', 'N', 'Y') AS ATTACH_FLAG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT A.PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("          ,A.PRC_CTRT_NO" ).append("\n"); 
		query.append("          ,A.SLS_OFC_CD" ).append("\n"); 
		query.append("          ,A.CTRT_CUST_SREP_CD " ).append("\n"); 
		query.append("          ,(SELECT X.SREP_NM FROM MDM_SLS_REP X WHERE X.SREP_CD = A.CTRT_CUST_SREP_CD) AS CTRT_CUST_SREP_NM" ).append("\n"); 
		query.append("          ,A.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("          ,A.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("          ,(SELECT X.CUST_LGL_ENG_NM FROM MDM_CUSTOMER X WHERE X.CUST_CNT_CD = A.CTRT_CUST_CNT_CD AND X.CUST_SEQ = A.CTRT_CUST_SEQ) CTRT_CUST_NM      " ).append("\n"); 
		query.append("          ,A.CTRT_EFF_DT" ).append("\n"); 
		query.append("          ,A.CTRT_EXP_DT" ).append("\n"); 
		query.append("          ,A.FNL_MQC_DESC" ).append("\n"); 
		query.append("          ,A.VNDR_SEQ" ).append("\n"); 
		query.append("          ,(SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("          ,(SELECT X.USA_EDI_CD FROM MDM_VENDOR X WHERE X.VNDR_SEQ = A.VNDR_SEQ) USA_EDI_CD" ).append("\n"); 
		query.append("          ,DECODE(IO_BND_CD, 'I', ORG_NOD_CD, 'O', MTY_PKUP_RTN_YD_CD)  FM_NODE" ).append("\n"); 
		query.append("          ,DECODE(IO_BND_CD, 'I', DEST_NOD_CD, 'O', ORG_NOD_CD)         DOR_NODE" ).append("\n"); 
		query.append("          ,DECODE(IO_BND_CD, 'I', MTY_PKUP_RTN_YD_CD, 'O', DEST_NOD_CD) TO_NODE" ).append("\n"); 
		query.append("--          ,(SELECT X.YD_NM" ).append("\n"); 
		query.append("--              FROM MDM_YARD X" ).append("\n"); 
		query.append("--             WHERE YD_CD = A.MTY_PKUP_RTN_YD_CD)" ).append("\n"); 
		query.append("--         ||(SELECT X.LSE_CO_YD_NM" ).append("\n"); 
		query.append("--              FROM MDM_LSE_CO_YD X" ).append("\n"); 
		query.append("--             WHERE LSE_CO_YD_CD = A.MTY_PKUP_RTN_YD_CD) AS MTY_PKUP_RTN_YD_NM" ).append("\n"); 
		query.append("          ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          ,A.CUST_NOMI_TRKR_BZC_AMT" ).append("\n"); 
		query.append("          ,A.CUST_NOMI_TRKR_FUEL_DIV_CD" ).append("\n"); 
		query.append("          ,A.CUST_NOMI_TRKR_FUEL_RTO" ).append("\n"); 
		query.append("          ,A.CUST_NOMI_TRKR_FUEL_AMT" ).append("\n"); 
		query.append("          ,A.RGST_USR_ID" ).append("\n"); 
		query.append("          ,A.RGST_OFC_CD" ).append("\n"); 
		query.append("          ,A.HJS_TRKR_AGMT_NO" ).append("\n"); 
		query.append("          ,A.HJS_TRKR_BZC_AMT" ).append("\n"); 
		query.append("          ,A.HJS_TRKR_FUEL_AMT" ).append("\n"); 
		query.append("          ,A.COST_DESC" ).append("\n"); 
		query.append("          ,A.APRO_HIS_DESC" ).append("\n"); 
		query.append("          ,A.APRO_NO" ).append("\n"); 
		query.append("          ,A.DISP_STS_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(A.CUST_NOMI_TRKR_SAV_DT, 'YYYYMMDD')  AS CUST_NOMI_TRKR_SAV_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(A.CUST_NOMI_TRKR_RQST_DT, 'YYYYMMDD') AS CUST_NOMI_TRKR_RQST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(A.CUST_NOMI_TRKR_RJCT_DT, 'YYYYMMDD') AS CUST_NOMI_TRKR_RJCT_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(A.CUST_NOMI_TRKR_APRO_DT, 'YYYYMMDD') AS CUST_NOMI_TRKR_APRO_DT" ).append("\n"); 
		query.append("          ,A.APRO_OFC_CD" ).append("\n"); 
		query.append("          ,A.APRO_USR_ID" ).append("\n"); 
		query.append("          ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = A.APRO_USR_ID) APRO_USR_NM" ).append("\n"); 
		query.append("          ,HJS_CUST_NOMI_TRKR_AGMT_NO          " ).append("\n"); 
		query.append("          ,(SELECT TRS_GET_AGMT_TRKR_RATE_FNC(VNDR_SEQ,CNTR_TPSZ_CD,IO_BND_CD,'DR',NULL,NULL," ).append("\n"); 
		query.append("                   DECODE(IO_BND_CD, 'I', ORG_NOD_CD, 'O', MTY_PKUP_RTN_YD_CD), --FM_NODE" ).append("\n"); 
		query.append("                   CASE WHEN LENGTH(DECODE(IO_BND_CD, 'I', DEST_NOD_CD, 'O', ORG_NOD_CD)) = 5       --DOOR_NODE" ).append("\n"); 
		query.append("                        THEN DECODE(IO_BND_CD, 'I', DEST_NOD_CD, 'O', ORG_NOD_CD)||'01'" ).append("\n"); 
		query.append("                        ELSE DECODE(IO_BND_CD, 'I', DEST_NOD_CD, 'O', ORG_NOD_CD)" ).append("\n"); 
		query.append("                   END," ).append("\n"); 
		query.append("                   DECODE(IO_BND_CD, 'I', MTY_PKUP_RTN_YD_CD, 'O', DEST_NOD_CD) --TO_NODE" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("              FROM DUAL" ).append("\n"); 
		query.append("           ) RT" ).append("\n"); 
		query.append("          ,(SELECT TRS_GET_AGMT_TRKR_RATE_FNC(VNDR_SEQ,CNTR_TPSZ_CD,IO_BND_CD,'DR',NULL, NULL," ).append("\n"); 
		query.append("                   DECODE(IO_BND_CD, 'I', ORG_NOD_CD, 'O', MTY_PKUP_RTN_YD_CD), --FM_NODE" ).append("\n"); 
		query.append("                   CASE WHEN LENGTH(DECODE(IO_BND_CD, 'I', DEST_NOD_CD, 'O', ORG_NOD_CD)) = 5       --DOOR_NODE" ).append("\n"); 
		query.append("                        THEN DECODE(IO_BND_CD, 'I', DEST_NOD_CD, 'O', ORG_NOD_CD)||'01'" ).append("\n"); 
		query.append("                        ELSE DECODE(IO_BND_CD, 'I', DEST_NOD_CD, 'O', ORG_NOD_CD)" ).append("\n"); 
		query.append("                   END," ).append("\n"); 
		query.append("                   DECODE(IO_BND_CD, 'I', MTY_PKUP_RTN_YD_CD, 'O', DEST_NOD_CD) --TO_NODE" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("              FROM DUAL" ).append("\n"); 
		query.append("           ) CNT_RT" ).append("\n"); 
		query.append("         ,A.IO_BND_CD" ).append("\n"); 
		query.append("         ,NVL(A.CUST_NOMI_TRKR_IND_CD,'CNT') CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("         ,A.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      FROM TRS_CUST_NOMI_TRKR A" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("--	 AND DISP_STS_CD != '00'" ).append("\n"); 
		query.append("      #if (${s_dt_div_cd} == '00' && ${s_fm_dt} != '' && ${s_to_dt} != '' )" ).append("\n"); 
		query.append("      AND A.CUST_NOMI_TRKR_SAV_DT  BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD')+0.99999 -- Saved Date로 조회시" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${s_dt_div_cd} == '01' && ${s_fm_dt} != '' && ${s_to_dt} != '' )" ).append("\n"); 
		query.append("      AND A.CUST_NOMI_TRKR_RQST_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD')+0.99999 -- Requested Date로 조회시" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${s_dt_div_cd} == '02' && ${s_fm_dt} != '' && ${s_to_dt} != '' )" ).append("\n"); 
		query.append("      AND A.CUST_NOMI_TRKR_RJCT_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD')+0.99999 -- Rejected Date로 조회시" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${s_dt_div_cd} == '03' && ${s_fm_dt} != '' && ${s_to_dt} != '' )" ).append("\n"); 
		query.append("      AND A.CUST_NOMI_TRKR_APRO_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD')+0.99999  -- Approved Date로 조회시" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${s_eff_dt} != '')" ).append("\n"); 
		query.append("      AND TO_DATE(@[s_eff_dt], 'YYYYMMDD') BETWEEN A.CTRT_EFF_DT AND A.CTRT_EXP_DT    -- Effective Date로 조회시" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${s_ctrt_no} != '')" ).append("\n"); 
		query.append("      AND A.PRC_CTRT_NO = @[s_ctrt_no]       -- Contract No로 조회시" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- Status로 조회시 (MULTI 리스트로 파라메터 받아 loop문에서 처리)" ).append("\n"); 
		query.append("        #if ($s_disp_sts_cd.size() > 0)" ).append("\n"); 
		query.append("              AND A.DISP_STS_CD IN (" ).append("\n"); 
		query.append("        	#foreach($key in ${s_disp_sts_cd}) " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        		#if($velocityCount < $s_disp_sts_cd.size()) " ).append("\n"); 
		query.append("        			'$key', " ).append("\n"); 
		query.append("        		#else " ).append("\n"); 
		query.append("        			'$key' " ).append("\n"); 
		query.append("        		#end " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        	)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${s_cust_seq} != '')" ).append("\n"); 
		query.append("      AND (A.CTRT_CUST_CNT_CD, A.CTRT_CUST_SEQ) = ( ( SUBSTR(@[s_cust_seq],1,2), SUBSTR(@[s_cust_seq],3))  )       -- Customer로 조회시" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${s_vndr_seq} != '')" ).append("\n"); 
		query.append("      AND A.VNDR_SEQ = @[s_vndr_seq]  -- Trucker로 조회시" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${s_cnt_tp_cd} != '')" ).append("\n"); 
		query.append("      AND A.CUST_NOMI_TRKR_IND_CD = @[s_cnt_tp_cd]       -- CNT TYPE CODE로 조회시" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${s_dor_nod_cd} != '')" ).append("\n"); 
		query.append("      AND SUBSTR(DECODE(A.IO_BND_CD, 'I', A.DEST_NOD_CD, 'O', A.ORG_NOD_CD), 1, 5) = @[s_dor_nod_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}