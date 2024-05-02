/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCSumListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCSumListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.04.10 전윤주 [CHM-201324051] SC List sheet에 조회되는 조회 조건과 Summary 항목의 조회 조건 다른 부분 동일하게 수정
	  * 1. contract office 조건 입력 되었을 때 PRI_SUB_OFC_MATCH ( 1, PROP_OFC_CD ) 로 AND 조건 변경
	  * 2. MQC를 Scope의 SUM 이 아닌 Main SC MQC의 Sum 으로 변경
	  * 3. MQC의 합을 sheet와 맞추기 위해 정수로 반올림
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCSumListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gamt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("afil_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("real_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCSumListRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("SC AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT L.SC_NO , " ).append("\n"); 
		query.append("	   L.PROP_NO," ).append("\n"); 
		query.append("       L.AMDT_SEQ," ).append("\n"); 
		query.append("       L.SVC_SCP_CD," ).append("\n"); 
		query.append("       L.FNL_MQC_QTY" ).append("\n"); 
		query.append("  FROM(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SC_NO , " ).append("\n"); 
		query.append("	   PROP_NO ," ).append("\n"); 
		query.append("       AMDT_SEQ," ).append("\n"); 
		query.append("       SVC_SCP_CD," ).append("\n"); 
		query.append("       FNL_MQC_QTY" ).append("\n"); 
		query.append("  FROM(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	SH.SC_NO						," ).append("\n"); 
		query.append("		SM.PROP_NO						," ).append("\n"); 
		query.append("		SM.AMDT_SEQ						," ).append("\n"); 
		query.append("		SS.SVC_SCP_CD					," ).append("\n"); 
		query.append("		DECODE(SQ.CNTR_LOD_UT_CD, 'T', ROUND(SQ.FNL_MQC_QTY / 2, 0), SQ.FNL_MQC_QTY)	FNL_MQC_QTY" ).append("\n"); 
		query.append("		#if (${act_cust_nm} != '')" ).append("\n"); 
		query.append("	  	, NVL(( SELECT 1 FROM PRI_SP_SCP_RT_ACT_CUST SP, MDM_CUSTOMER MC" ).append("\n"); 
		query.append("	      WHERE SP.PROP_NO = SS.PROP_NO" ).append("\n"); 
		query.append("            AND     SP.AMDT_SEQ = SS.AMDT_SEQ" ).append("\n"); 
		query.append("            AND     SP.SVC_SCP_CD = SS.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND     SP.GEN_SPCL_RT_TP_CD = 'S'" ).append("\n"); 
		query.append("            AND     SP.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND     SP.CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("			AND 	SP.SRC_INFO_CD  <>  'AD'" ).append("\n"); 
		query.append("            AND     MC.CUST_LGL_ENG_NM LIKE  '%' || @[act_cust_nm] || '%'" ).append("\n"); 
		query.append("            AND     ROWNUM = 1), 0 ) ACT_CUST_IND " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${real_cust_nm} != '')" ).append("\n"); 
		query.append("		, (SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = SM.REAL_CUST_CNT_CD AND A.CUST_SEQ = SM.REAL_CUST_SEQ) AS REAL_CUST_NM" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("FROM	PRI_SP_HDR					SH	," ).append("\n"); 
		query.append("		PRI_SP_MN					SM	," ).append("\n"); 
		query.append("		PRI_SP_CTRT_PTY			    CP	," ).append("\n"); 
		query.append("		PRI_SP_CTRT_CUST_TP	        CT  ," ).append("\n"); 
		query.append("		PRI_SP_SCP_MN				SS	," ).append("\n"); 
		query.append("		PRI_SP_SCP_DUR			    SD	," ).append("\n"); 
		query.append("--		PRI_SP_SCP_MQC			    SQ  " ).append("\n"); 
		query.append("        PRI_SP_MQC                  SQ" ).append("\n"); 
		query.append(" 	  #if (${afil_nm} != '')" ).append("\n"); 
		query.append("       ,PRI_SP_AFIL         SA" ).append("\n"); 
		query.append("       ,MDM_CUSTOMER        MC" ).append("\n"); 
		query.append(" 	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	SM.PROP_NO				= SH.PROP_NO" ).append("\n"); 
		query.append("AND		SM.PROP_STS_CD			= 'F'" ).append("\n"); 
		query.append("AND		CP.PROP_NO				= SM.PROP_NO" ).append("\n"); 
		query.append("AND		CP.AMDT_SEQ				= SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND		CP.PRC_CTRT_PTY_TP_CD	= 'C'" ).append("\n"); 
		query.append("AND		CT.PROP_NO				= CP.PROP_NO" ).append("\n"); 
		query.append("AND		CT.AMDT_SEQ				= CP.AMDT_SEQ" ).append("\n"); 
		query.append("AND		CT.PRC_CTRT_PTY_TP_CD	= CP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("AND		SS.PROP_NO				= SM.PROP_NO" ).append("\n"); 
		query.append("AND		SS.AMDT_SEQ				= SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND		SD.PROP_NO				= SS.PROP_NO" ).append("\n"); 
		query.append("AND		SD.AMDT_SEQ				= SS.AMDT_SEQ" ).append("\n"); 
		query.append("AND		SD.SVC_SCP_CD			= SS.SVC_SCP_CD" ).append("\n"); 
		query.append("AND		SQ.PROP_NO				= SS.PROP_NO" ).append("\n"); 
		query.append("AND		SQ.AMDT_SEQ				= SS.AMDT_SEQ" ).append("\n"); 
		query.append(" #if (${afil_nm} != '')" ).append("\n"); 
		query.append("AND     SM.PROP_NO            = SA.PROP_NO" ).append("\n"); 
		query.append("AND     SM.AMDT_SEQ           = SA.AMDT_SEQ" ).append("\n"); 
		query.append("AND     SA.CUST_CNT_CD        = MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND     SA.CUST_SEQ           = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--AND		SQ.SVC_SCP_CD			= SS.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${afil_nm} != '')" ).append("\n"); 
		query.append("AND     MC.CUST_LGL_ENG_NM LIKE '%' || @[afil_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sc_no} != '') " ).append("\n"); 
		query.append("AND		SH.SC_NO				LIKE @[sc_no] || '%' -- S/C No" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rf_flg} != '') " ).append("\n"); 
		query.append("AND		SM.RF_FLG				= @[rf_flg]	 -- S/C Type" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gamt_flg} != '') " ).append("\n"); 
		query.append("AND		SM.GAMT_FLG				= @[gamt_flg]	 -- S/C Type" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_apro_ofc_cd} != '') " ).append("\n"); 
		query.append("AND     SM.PROP_APRO_OFC_CD    = @[prop_apro_ofc_cd]    -- Approval Office 추가" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prop_ofc_cd} != '') " ).append("\n"); 
		query.append("AND		PRI_SUB_OFC_MATCH ( 1, PROP_OFC_CD )= @[prop_ofc_cd] -- Contract Office main 쿼리 조건과 동일하게 변경" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_ctrt_cust_tp_cd} != '') " ).append("\n"); 
		query.append("AND		CT.PRC_CTRT_CUST_TP_CD	= @[prc_ctrt_cust_tp_cd]     -- Customer Type" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("AND		SS.SVC_SCP_CD		    = @[svc_scp_cd]		-- SVC Scope" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND   UPPER(CP.CTRT_PTY_NM) LIKE  '%' || @[cust_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND		SS.EFF_DT 				<= TO_DATE(@[exp_dt], 'YYYY-MM-DD')	-- Effective Date(To) or Access Date" ).append("\n"); 
		query.append("AND		SS.EXP_DT				>= TO_DATE(@[eff_dt], 'YYYY-MM-DD')	-- Effective Date(From) or Access Date" ).append("\n"); 
		query.append(") WHERE 1=1" ).append("\n"); 
		query.append(" #if (${act_cust_nm} != '')" ).append("\n"); 
		query.append("AND   ACT_CUST_IND = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${real_cust_nm} != '')" ).append("\n"); 
		query.append("AND   REAL_CUST_NM LIKE '%' || @[real_cust_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")L" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${act_cust_nm} != '' or ${fx_rt_flg} == 'N')" ).append("\n"); 
		query.append("            , PRI_SP_SCP_RT_ACT_CUST SP, MDM_CUSTOMER MC, PRI_SP_SCP_RT_CMDT_HDR SH" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND     L.PROP_NO = SH.PROP_NO" ).append("\n"); 
		query.append("        AND     L.AMDT_SEQ = SH.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     L.SVC_SCP_CD = SH.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     SH.PROP_NO = SP.PROP_NO(+)" ).append("\n"); 
		query.append("        AND     SH.AMDT_SEQ = SP.AMDT_SEQ(+)" ).append("\n"); 
		query.append("        AND     SH.SVC_SCP_CD = SP.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("        AND     SH.GEN_SPCL_RT_TP_CD = SP.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("        AND     SH.CMDT_HDR_SEQ = SP.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("        AND     SP.CUST_CNT_CD = MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("        AND     SP.CUST_SEQ = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("        AND     SP.SRC_INFO_CD(+)  <>  'AD'" ).append("\n"); 
		query.append("		#if (${act_cust_nm} != '')" ).append("\n"); 
		query.append("        AND     MC.CUST_LGL_ENG_NM LIKE '%' || @[act_cust_nm] || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${fx_rt_flg} == 'N')" ).append("\n"); 
		query.append("		AND     SH.FX_RT_FLG = 'Y'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT COUNT(SC_NO) AS SC_NO" ).append("\n"); 
		query.append("      ,SUM(FNL_MQC_QTY) AS FNL_MQC_QTY" ).append("\n"); 
		query.append("  FROM ( SELECT DISTINCT SC_NO, FNL_MQC_QTY" ).append("\n"); 
		query.append("           FROM	SC A" ).append("\n"); 
		query.append("          WHERE	NOT EXISTS (" ).append("\n"); 
		query.append("					         SELECT	'X'" ).append("\n"); 
		query.append("					           FROM	SC B" ).append("\n"); 
		query.append("					          WHERE	B.SC_NO		 = A.SC_NO" ).append("\n"); 
		query.append("					            AND	B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("					            AND	B.AMDT_SEQ	 > A.AMDT_SEQ" ).append("\n"); 
		query.append("				            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}