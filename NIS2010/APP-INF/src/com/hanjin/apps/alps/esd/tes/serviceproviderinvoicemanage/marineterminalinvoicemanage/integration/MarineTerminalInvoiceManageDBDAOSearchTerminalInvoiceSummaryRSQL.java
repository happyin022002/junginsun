/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalInvoiceSummary
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_rjct_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceSummaryRSQL").append("\n"); 
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
		query.append("SELECT INV_NO, FILE_CHK, VVD,TML_SO_OFC_CTY_CD,TML_SO_SEQ,INV_TP_CD,TML_INV_TP_CD,TML_INV_STS_CD,TML_INV_RJCT_STS_CD,CRE_DT,LOCL_CRE_DT,INV_OFC_CD,INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("	COST_OFC_CD,COST_OFC_DEL_FLG,YD_CD,YD_DEL_FLG,CURR_CD,ISS_DT,RCV_DT,EFF_DT,PAY_DUE_DT,PAY_FLG,HLD_FLG,VNDR_SEQ,VNDR_DEL_FLG, MAX(VAT_AMT) VAT_AMT, MAX(WHLD_TAX_AMT) WHLD_TAX_AMT, MAX(TTL_INV_AMT) TTL_INV_AMT," ).append("\n"); 
		query.append("	DELT_FLG,CSR_NO,CRE_USR_ID,CSR_STATUS,TML_EDI_SO_OFC_CTY_CD,TML_EDI_SO_SEQ,INV_RJCT_RMK,EDI_FLG,RTRO_TML_INV_FLG,SNDR_ID,TML_INV_EDI_SEQ,EDI_RCV_RULE_MN_SEQ," ).append("\n"); 
		query.append("	--// CHM-201537539 Invoice IF Inquiry에서 조건 명칭 추가삭제변경 (조아영D 2015-08-25)" ).append("\n"); 
		query.append("	LOCL_UPD_DT, 	-- INV UPDATED DATE" ).append("\n"); 
		query.append("	INV_CFM_DT,		-- INVOICE CONFIRMED DATE" ).append("\n"); 
		query.append("	IF_DT,			-- AP I/F STATUS UPDATED DATE" ).append("\n"); 
		query.append("	AP_REQ_DT, 		-- APROVAL REQUESTED DATE" ).append("\n"); 
		query.append("	SUM(AUTO_CALC_AMT) AUTO_CALC_AMT ,SUM(SEMI_AUTO_AMT) SEMI_AUTO_AMT,SUM(MANUAL_AMT) MANUAL_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  	/*+ FIRST_ROWS */ H.INV_NO," ).append("\n"); 
		query.append("		  NVL(" ).append("\n"); 
		query.append("          CASE" ).append("\n"); 
		query.append("          WHEN H.EDI_FLG = 'Y'" ).append("\n"); 
		query.append("          THEN  (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                    CASE" ).append("\n"); 
		query.append("                    WHEN F.FILE_SEQ IS NOT NULL AND F.ORG_FILE_NM IS NOT NULL AND F.FILE_SAV_ID IS NOT NULL AND C.FILE_SAV_ID IS NOT NULL" ).append("\n"); 
		query.append("                    THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("                    END FILE_CHK" ).append("\n"); 
		query.append("                FROM TES_EDI_SO_HDR E, TES_EDI_SO_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND E.TML_SO_OFC_CTY_CD = H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND E.TML_SO_SEQ = H.TML_SO_SEQ" ).append("\n"); 
		query.append("                AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                AND ((E.TML_EDI_SO_OFC_CTY_CD = F.TML_EDI_SO_OFC_CTY_CD AND E.TML_EDI_SO_SEQ = F.TML_EDI_SO_SEQ)" ).append("\n"); 
		query.append("					OR" ).append("\n"); 
		query.append("					 (E.TML_SO_OFC_CTY_CD = F.TML_SO_OFC_CTY_CD AND E.TML_SO_SEQ = F.TML_SO_SEQ))" ).append("\n"); 
		query.append("                AND NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 
		query.append("                AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("				AND ROWNUM = 1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          ELSE 'N'" ).append("\n"); 
		query.append("          END,'N') FILE_CHK," ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("           WHEN H.TML_INV_TP_CD IN ('TM')" ).append("\n"); 
		query.append("           THEN TES_GET_VVD_LIST_FNC(H.TML_SO_OFC_CTY_CD,H.TML_SO_SEQ,'N')" ).append("\n"); 
		query.append("           ELSE ''" ).append("\n"); 
		query.append("           END VVD," ).append("\n"); 
		query.append("			H.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("			H.TML_SO_SEQ," ).append("\n"); 
		query.append("			DECODE(H.TML_INV_TP_CD,'TM','MR','ON','RC','OF','OC','ST','MS') INV_TP_CD," ).append("\n"); 
		query.append("			H.TML_INV_TP_CD," ).append("\n"); 
		query.append("			DECODE(H.TML_INV_STS_CD,'R','RC','C','CF','A','AR','P','AP','D','PD') TML_INV_STS_CD," ).append("\n"); 
		query.append("			H.TML_INV_RJCT_STS_CD," ).append("\n"); 
		query.append(" 			TO_CHAR(H.CRE_DT,'YYYYMMDD')		CRE_DT," ).append("\n"); 
		query.append("--		/** ALPS에서 LOCL_CRE_DT를 운영할 때까지만 CRE_DT를 LOCAL시간으로 임의 설정 한다. **/" ).append("\n"); 
		query.append(" 			TO_CHAR(H.LOCL_CRE_DT,'YYYYMMDDHH24MISS') LOCL_CRE_DT," ).append("\n"); 
		query.append("		 	H.INV_OFC_CD," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_ORGANIZATION WHERE OFC_CD = H.INV_OFC_CD)  INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("			H.COST_OFC_CD," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_ORGANIZATION WHERE OFC_CD = H.COST_OFC_CD) COST_OFC_DEL_FLG," ).append("\n"); 
		query.append("			H.YD_CD," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_YARD WHERE YD_CD = H.YD_CD)		YD_DEL_FLG," ).append("\n"); 
		query.append("			H.CURR_CD," ).append("\n"); 
		query.append("			TO_CHAR(H.ISS_DT,'YYYYMMDD')		ISS_DT," ).append("\n"); 
		query.append("			TO_CHAR(H.RCV_DT,'YYYYMMDD')		RCV_DT," ).append("\n"); 
		query.append("		 	TO_CHAR(H.EFF_DT,'YYYYMMDD')		EFF_DT," ).append("\n"); 
		query.append("			TO_CHAR(H.PAY_DUE_DT,'YYYYMMDD')	PAY_DUE_DT," ).append("\n"); 
		query.append("			H.PAY_FLG," ).append("\n"); 
		query.append("			H.HLD_FLG," ).append("\n"); 
		query.append("			LPAD(H.VNDR_SEQ, 6, '0') 	VNDR_SEQ," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_VENDOR WHERE VNDR_SEQ = H.VNDR_SEQ)	VNDR_DEL_FLG," ).append("\n"); 
		query.append("		 	H.VAT_AMT," ).append("\n"); 
		query.append("		 	H.WHLD_TAX_AMT," ).append("\n"); 
		query.append("			H.TTL_INV_AMT," ).append("\n"); 
		query.append("			H.DELT_FLG," ).append("\n"); 
		query.append("			H.CSR_NO," ).append("\n"); 
		query.append("			H.CRE_USR_ID," ).append("\n"); 
		query.append("			-- CHM-201537728 Invoice Summary화면에서 CSR I/F Status 미반영 로직 수정 요청 (조아영D 2015-08-28)" ).append("\n"); 
		query.append("			CASE" ).append("\n"); 
		query.append("				WHEN A.AFT_ACT_FLG = 'X' OR A.AFT_ACT_FLG = 'N' THEN 'Canceled'" ).append("\n"); 
		query.append("				WHEN A.RCV_ERR_FLG = 'E' THEN 'Rejected'" ).append("\n"); 
		query.append("				WHEN A.IF_FLG = 'E' THEN 'I/F Error'" ).append("\n"); 
		query.append("				WHEN A.IF_FLG = 'Y' AND A.RCV_ERR_FLG IS NULL THEN 'I/F Success'" ).append("\n"); 
		query.append("				WHEN H.TML_INV_STS_CD = 'R' THEN 'Processing'" ).append("\n"); 
		query.append("				WHEN H.TML_INV_STS_CD = 'C' AND A.IF_FLG IS NULL THEN 'Processing'" ).append("\n"); 
		query.append("				WHEN H.TML_INV_RJCT_STS_CD = 'RJ' AND A.AFT_ACT_FLG IS NULL THEN 'Disapproved'" ).append("\n"); 
		query.append("				WHEN A.IF_FLG IS NULL AND A.APRO_FLG = 'N' AND A.RQST_APRO_STEP_FLG = 'Y' THEN 'Requesting Approval'" ).append("\n"); 
		query.append("				WHEN A.IF_FLG IS NULL AND A.APRO_FLG <> 'Y' THEN 'Approval Requested'" ).append("\n"); 
		query.append("				ELSE 'ALL'" ).append("\n"); 
		query.append("			END CSR_STATUS," ).append("\n"); 
		query.append("			''  TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("			NULL  TML_EDI_SO_SEQ," ).append("\n"); 
		query.append("			H.INV_RJCT_RMK," ).append("\n"); 
		query.append("			H.EDI_FLG," ).append("\n"); 
		query.append("--//		소급 적용 처리 기능 추가 ( 2009-06-22 이경한 과장 요청 )" ).append("\n"); 
		query.append("			H.RTRO_TML_INV_FLG," ).append("\n"); 
		query.append("			'' SNDR_ID," ).append("\n"); 
		query.append("			'' TML_INV_EDI_SEQ," ).append("\n"); 
		query.append("			'' EDI_RCV_RULE_MN_SEQ," ).append("\n"); 
		query.append("			TO_CHAR(H.LOCL_UPD_DT, 'YYYYMMDD') AS LOCL_UPD_DT, 				-- INV UPDATED DATE" ).append("\n"); 
		query.append("			TO_CHAR(H.INV_CFM_DT, 'YYYYMMDD') AS INV_CFM_DT,				-- INVOICE CONFIRMED DATE" ).append("\n"); 
		query.append("			A.CSR_APRO_TP_CD,												-- AL, GW" ).append("\n"); 
		query.append("			TO_CHAR(R.RQST_ST_DT, 'YYYYMMDD') AS RQST_ST_DT,				-- AL APROVAL REQUESTED DATE" ).append("\n"); 
		query.append("			TO_CHAR(A.CSR_APRO_STEP_ASGN_DT, 'YYYYMMDD') AS CSR_APRO_STEP_ASGN_DT,	-- GW APROVAL REQUESTED DATE" ).append("\n"); 
		query.append("			TO_CHAR(A.IF_DT, 'YYYYMMDD') AS IF_DT,					-- AP I/F STATUS UPDATED DATE" ).append("\n"); 
		query.append("			TO_CHAR(DECODE(NVL(A.CSR_APRO_TP_CD, 'AL'), 'GW', A.CSR_APRO_STEP_ASGN_DT, R.RQST_ST_DT), 'YYYYMMDD') AS AP_REQ_DT, -- APROVAL REQUESTED DATE" ).append("\n"); 
		query.append("  			DECODE(D.CALC_TP_CD,'A',D.INV_AMT,0) AUTO_CALC_AMT," ).append("\n"); 
		query.append("  			DECODE(D.CALC_TP_CD,'M',DECODE(D.SEMI_AUTO_CALC_FLG,'Y',D.INV_AMT),0) SEMI_AUTO_AMT," ).append("\n"); 
		query.append("  			DECODE(D.CALC_TP_CD,'M',DECODE(D.SEMI_AUTO_CALC_FLG,NULL,D.INV_AMT),0) MANUAL_AMT" ).append("\n"); 
		query.append("FROM 		TES_TML_SO_HDR H, AP_INV_HDR A, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("			--// CHM-201537539 Invoice IF Inquiry에서 조건 명칭 추가삭제변경 (조아영D 2015-08-25)" ).append("\n"); 
		query.append("			, COM_APRO_CSR_DTL C, COM_APRO_RQST_HDR R" ).append("\n"); 
		query.append("WHERE 		NVL(H.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND		H.CSR_NO = A.CSR_NO(+)" ).append("\n"); 
		query.append("AND     H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND     H.TML_SO_SEQ = D.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("--// CHM-201537539 Invoice IF Inquiry에서 조건 명칭 추가삭제변경 (조아영D 2015-08-25)" ).append("\n"); 
		query.append("AND		H.CSR_NO		= C.CSR_NO(+)" ).append("\n"); 
		query.append("AND		C.APRO_RQST_NO	= R.APRO_RQST_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--// CHM-201537539 Invoice IF Inquiry에서 조건 명칭 추가삭제변경 (조아영D 2015-08-25)" ).append("\n"); 
		query.append("#if (${inv_date_type} == 'I') 	-- ISSUED DATE" ).append("\n"); 
		query.append("AND		H.ISS_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'R')	-- RECEIVED DATE" ).append("\n"); 
		query.append("AND		H.RCV_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'P')	-- INVOICE UPDATE DATE" ).append("\n"); 
		query.append("AND		H.LOCL_UPD_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'C')	-- CONFIRMED DATE" ).append("\n"); 
		query.append("AND		H.INV_CFM_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'A')	-- ARRROVAL REQUESTED DATE" ).append("\n"); 
		query.append("AND		( (R.RQST_ST_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 )" ).append("\n"); 
		query.append("OR		( A.CSR_APRO_STEP_ASGN_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 ) )" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'U')	-- I/F STATUS UPDATED" ).append("\n"); 
		query.append("AND		A.IF_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${yd_cd} != '') " ).append("\n"); 
		query.append("and	h.yd_cd	 =	@[yd_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_no} != '') " ).append("\n"); 
		query.append("and	h.inv_no	like	'%'||@[inv_no]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/**2013.02.26 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...1년 후 삭제 예정 FDRCIV201301 ~ FDRCIV201312 **/" ).append("\n"); 
		query.append("/**2013.06.03 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...1년 후 삭제 예정..Rebate Invoice 처리 : 2012년 8월 ~ 2013년 12월..APP201208 ~ APP201312 **/" ).append("\n"); 
		query.append("/**2013.06.03 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...2014년 용..APP201401, APP201402, APP201403 **/" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != 'HAMSEL') " ).append("\n"); 
		query.append("and	h.inv_no NOT IN ('FDRCIV201301','FDRCIV201302','FDRCIV201303','FDRCIV201304','FDRCIV201305','FDRCIV201306','FDRCIV201307','FDRCIV201308','FDRCIV201309','FDRCIV201310','FDRCIV201311','FDRCIV201312'," ).append("\n"); 
		query.append("					 'APP201208','APP201209','APP201210','APP201211','APP201212','APP201301','APP201302','APP201303','APP201304','APP201305','APP201306','APP201307','APP201308','APP201309','APP201310','APP201311','APP201312'," ).append("\n"); 
		query.append("					 'APP201401','APP201402','APP201403'" ).append("\n"); 
		query.append("					 ,'BEST201401Q','BEST201402Q','BEST201403Q','BEST201404Q','BEST201501Q','BEST201502Q','BEST201503Q','BEST201504Q' --// 2014-06-18 추가" ).append("\n"); 
		query.append("					 ,'UOM201406-001' --// 2014-07-08 추가" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("and	h.vndr_seq	=	@[vndr_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("	#if($sub_ofc_cd1.size() > 0)" ).append("\n"); 
		query.append("		AND     h.cost_ofc_cd IN (" ).append("\n"); 
		query.append("	#foreach($sub_ofc_cd1_num IN ${sub_ofc_cd1})" ).append("\n"); 
		query.append("		#if($velocityCount < $sub_ofc_cd1.size()) " ).append("\n"); 
		query.append("			'$sub_ofc_cd1_num', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$sub_ofc_cd1_num' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND		h.cost_ofc_cd = @[cost_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_ofc_cd} != '')" ).append("\n"); 
		query.append("	#if($sub_ofc_cd2.size() > 0)" ).append("\n"); 
		query.append("		AND     h.inv_ofc_cd IN (" ).append("\n"); 
		query.append("	#foreach($sub_ofc_cd2_num IN ${sub_ofc_cd2})" ).append("\n"); 
		query.append("		#if($velocityCount < $sub_ofc_cd2.size()) " ).append("\n"); 
		query.append("			'$sub_ofc_cd2_num', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$sub_ofc_cd2_num' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND		h.inv_ofc_cd = @[inv_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tml_inv_sts_cd} != '') " ).append("\n"); 
		query.append("and	h.tml_inv_sts_cd	=	@[tml_inv_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and	h.tml_inv_sts_cd in ('R','C','A','P','D')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${csr_no} != '') " ).append("\n"); 
		query.append("and	h.csr_no like	'%'||@[csr_no]||'%'	" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tml_inv_rjct_sts_cd} != '') " ).append("\n"); 
		query.append("and	h.tml_inv_rjct_sts_cd = @[tml_inv_rjct_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and	h.tml_inv_rjct_sts_cd in ('NL','RJ','RL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${csr_status} == 'AR') " ).append("\n"); 
		query.append("AND	A.IF_FLG IS NULL" ).append("\n"); 
		query.append("AND	H.CSR_NO IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'PC') " ).append("\n"); 
		query.append("AND	( H.TML_INV_STS_CD = 'R' OR (H.TML_INV_STS_CD = 'C' AND A.IF_FLG IS NULL) )" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'IE') " ).append("\n"); 
		query.append("AND	A.IF_FLG = 'E'" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'RJ') " ).append("\n"); 
		query.append("AND	A.RCV_ERR_FLG = 'E'" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'SC') " ).append("\n"); 
		query.append("AND	A.IF_FLG = 'Y'	AND A.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'DA') " ).append("\n"); 
		query.append("AND	 H.TML_INV_STS_CD = 'A' AND H.TML_INV_RJCT_STS_CD = 'RJ'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${hld_flg} == 'Y') -- [CHM-201538036]Hold 검색조건 추가 (조아영D 2015.09.23)" ).append("\n"); 
		query.append("AND NVL(H.HLD_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL                                                                                  		" ).append("\n"); 
		query.append("SELECT  	EH.INV_NO," ).append("\n"); 
		query.append("            NVL((" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                    CASE" ).append("\n"); 
		query.append("                    WHEN F.FILE_SEQ IS NOT NULL AND F.ORG_FILE_NM IS NOT NULL AND F.FILE_SAV_ID IS NOT NULL AND C.FILE_SAV_ID IS NOT NULL" ).append("\n"); 
		query.append("                    THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("                    END FILE_CHK" ).append("\n"); 
		query.append("                FROM TES_EDI_SO_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND F.TML_EDI_SO_OFC_CTY_CD = EH.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND F.TML_EDI_SO_SEQ = EH.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("                AND NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 
		query.append("                AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("				AND ROWNUM = 1" ).append("\n"); 
		query.append("            ),'N') FILE_CHK," ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("           WHEN ((VNDR_SEQ IN ('158002','114776') AND SUBSTR(EH.TML_INV_TP_CD,1,1)='M') OR" ).append("\n"); 
		query.append("                (EH.TML_INV_TP_CD IN ('TM')))" ).append("\n"); 
		query.append("           THEN TES_GET_VVD_LIST_FNC(EH.TML_EDI_SO_OFC_CTY_CD,EH.TML_EDI_SO_SEQ,'E')" ).append("\n"); 
		query.append("           ELSE ''" ).append("\n"); 
		query.append("           END VVD," ).append("\n"); 
		query.append("			'' TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("			0 TML_SO_SEQ," ).append("\n"); 
		query.append("		/**" ).append("\n"); 
		query.append("		 * 부산신항만 eBilling EDI 추가로 인해 분기 추가한다. HIT/YICT(158002/114776) 이외는 기본 INVOICE유형을 취한다." ).append("\n"); 
		query.append("		 **/" ).append("\n"); 
		query.append("			CASE" ).append("\n"); 
		query.append("			WHEN VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("			THEN DECODE(SUBSTR(EH.TML_INV_TP_CD,1,1),'M','MR','S','MS')" ).append("\n"); 
		query.append("			ELSE DECODE(EH.TML_INV_TP_CD,'TM','MR','ON','RC','OF','OC','ST','MS')" ).append("\n"); 
		query.append("			END INV_TP_CD," ).append("\n"); 
		query.append("			EH.TML_INV_TP_CD," ).append("\n"); 
		query.append("			DECODE(EH.TML_INV_STS_CD,'R','ER', '') TML_INV_STS_CD," ).append("\n"); 
		query.append("			EH.TML_INV_RJCT_STS_CD," ).append("\n"); 
		query.append(" 			TO_CHAR(EH.LOCL_CRE_DT,'YYYYMMDD') CRE_DT," ).append("\n"); 
		query.append(" 			TO_CHAR(DECODE(EH.LOCL_CRE_DT,NULL,EH.CRE_DT,EH.LOCL_CRE_DT),'YYYYMMDDHH24MISS') LOCL_CRE_DT," ).append("\n"); 
		query.append("		 	EH.INV_OFC_CD," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_ORGANIZATION WHERE OFC_CD = EH.INV_OFC_CD)  INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("			EH.COST_OFC_CD," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_ORGANIZATION WHERE OFC_CD = EH.COST_OFC_CD) COST_OFC_DEL_FLG," ).append("\n"); 
		query.append("			EH.YD_CD," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_YARD WHERE YD_CD = EH.YD_CD)		YD_DEL_FLG," ).append("\n"); 
		query.append("			EH.CURR_CD," ).append("\n"); 
		query.append("			EH.ISS_DT ISS_DT," ).append("\n"); 
		query.append("			EH.RCV_DT		RCV_DT," ).append("\n"); 
		query.append("		 	'' EFF_DT," ).append("\n"); 
		query.append("			'' PAY_DUE_DT," ).append("\n"); 
		query.append("			'' PAY_FLG," ).append("\n"); 
		query.append("			'' HLD_FLG," ).append("\n"); 
		query.append("			LPAD(EH.VNDR_SEQ, 6, '0') 	VNDR_SEQ," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_VENDOR WHERE VNDR_SEQ = EH.VNDR_SEQ)	VNDR_DEL_FLG," ).append("\n"); 
		query.append("		 	EH.VAT_AMT," ).append("\n"); 
		query.append("		 	EH.WHLD_TAX_AMT," ).append("\n"); 
		query.append("			/** HIT는 TTL AMT에 소수점 두자리가 온다. -> 100으로 나눠서 보여준다. 단, 정규INVOICE로 변환시 자동으로 100나눠 TTL_AMT에 배당되므로 정규 INVOICE쪽은 그대로 둔다. **/			" ).append("\n"); 
		query.append("			NVL(" ).append("\n"); 
		query.append("				CASE" ).append("\n"); 
		query.append("				WHEN EH.VNDR_SEQ IN ('158002','114776') AND EH.TTL_INV_AMT IS NOT NULL AND EH.TTL_INV_AMT <> 0" ).append("\n"); 
		query.append("				THEN EH.TTL_INV_AMT/100" ).append("\n"); 
		query.append("				ELSE EH.TTL_INV_AMT" ).append("\n"); 
		query.append("				END," ).append("\n"); 
		query.append("			0) TTL_INV_AMT," ).append("\n"); 
		query.append("			EH.DELT_FLG," ).append("\n"); 
		query.append("			'' CSR_NO," ).append("\n"); 
		query.append("			EH.CRE_USR_ID," ).append("\n"); 
		query.append("			'' CSR_STATUS," ).append("\n"); 
		query.append("			EH.TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("			EH.TML_EDI_SO_SEQ," ).append("\n"); 
		query.append("			EH.INV_RJCT_RMK," ).append("\n"); 
		query.append("			'Y' EDI_FLG," ).append("\n"); 
		query.append("--//		소급 적용 처리 기능 추가 ( 2009-06-22 이경한 과장 요청 )" ).append("\n"); 
		query.append("			'' RTRO_TML_INV_FLG," ).append("\n"); 
		query.append("			EH.SNDR_ID," ).append("\n"); 
		query.append("			EH.TML_INV_EDI_SEQ||''," ).append("\n"); 
		query.append("			EH.EDI_RCV_RULE_MN_SEQ||''," ).append("\n"); 
		query.append("			'', 		-- INV UPDATED DATE" ).append("\n"); 
		query.append("			'',			-- INVOICE CONFIRMED DATE" ).append("\n"); 
		query.append("			'',			-- AL, GW" ).append("\n"); 
		query.append("			'',			-- AL APROVAL REQUESTED DATE" ).append("\n"); 
		query.append("			'',			-- GW APROVAL REQUESTED DATE" ).append("\n"); 
		query.append("			'',			-- AP I/F STATUS UPDATED DATE" ).append("\n"); 
		query.append("			'', 		-- APROVAL REQUESTED DATE" ).append("\n"); 
		query.append("			0,0,0" ).append("\n"); 
		query.append("FROM	TES_EDI_SO_HDR EH" ).append("\n"); 
		query.append("WHERE	EH.TML_SO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND	EH.TML_SO_SEQ IS NULL" ).append("\n"); 
		query.append("AND	NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_date_type} == 'I') " ).append("\n"); 
		query.append("and	eh.iss_dt between replace(@[fm_prd_dt],'-') and replace(@[to_prd_dt],'-')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'R') " ).append("\n"); 
		query.append("and	eh.rcv_dt between replace(@[fm_prd_dt],'-') and replace(@[to_prd_dt],'-')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'P') " ).append("\n"); 
		query.append("and	eh.locl_upd_dt between to_date(@[fm_prd_dt],'yyyy-mm-dd') and to_date(@[to_prd_dt],'yyyy-mm-dd')+0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${yd_cd} != '') " ).append("\n"); 
		query.append("and	eh.yd_cd				=	@[yd_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_no} != '') " ).append("\n"); 
		query.append("and	eh.inv_no	like	'%'||@[inv_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/**2013.02.26 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...1년 후 삭제 예정 FDRCIV201301 ~ FDRCIV201312 **/" ).append("\n"); 
		query.append("/**2013.06.03 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...1년 후 삭제 예정..Rebate Invoice 처리 : 2012년 8월 ~ 2013년 12월..APP201208 ~ APP201312 **/" ).append("\n"); 
		query.append("/**2013.06.03 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...2014년 용..APP201401, APP201402, APP201403 **/" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != 'HAMSEL') " ).append("\n"); 
		query.append("and	eh.inv_no NOT IN ('FDRCIV201301','FDRCIV201302','FDRCIV201303','FDRCIV201304','FDRCIV201305','FDRCIV201306','FDRCIV201307','FDRCIV201308','FDRCIV201309','FDRCIV201310','FDRCIV201311','FDRCIV201312'," ).append("\n"); 
		query.append("					  'APP201208','APP201209','APP201210','APP201211','APP201212','APP201301','APP201302','APP201303','APP201304','APP201305','APP201306','APP201307','APP201308','APP201309','APP201310','APP201311','APP201312'," ).append("\n"); 
		query.append("					  'APP201401','APP201402','APP201403'" ).append("\n"); 
		query.append("					  ,'BEST201401Q','BEST201402Q','BEST201403Q','BEST201404Q','BEST201501Q','BEST201502Q','BEST201503Q','BEST201504Q' --// 2014-06-18 추가" ).append("\n"); 
		query.append("					  ,'UOM201406-001' --// 2014-07-08 추가" ).append("\n"); 
		query.append("					  )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("and	eh.vndr_seq				=	@[vndr_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("	#if($sub_ofc_cd1.size() > 0)" ).append("\n"); 
		query.append("	AND     eh.cost_ofc_cd IN (" ).append("\n"); 
		query.append("	#foreach($sub_ofc_cd1_num IN ${sub_ofc_cd1})" ).append("\n"); 
		query.append("		#if($velocityCount < $sub_ofc_cd1.size()) " ).append("\n"); 
		query.append("			'$sub_ofc_cd1_num', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$sub_ofc_cd1_num' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND		eh.cost_ofc_cd = @[cost_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_ofc_cd} != '')" ).append("\n"); 
		query.append("	#if($sub_ofc_cd2.size() > 0)" ).append("\n"); 
		query.append("	AND     eh.inv_ofc_cd IN (" ).append("\n"); 
		query.append("	#foreach($sub_ofc_cd2_num IN ${sub_ofc_cd2})" ).append("\n"); 
		query.append("		#if($velocityCount < $sub_ofc_cd2.size()) " ).append("\n"); 
		query.append("			'$sub_ofc_cd2_num', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$sub_ofc_cd2_num' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND		eh.inv_ofc_cd = @[inv_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tml_inv_sts_cd} != '') " ).append("\n"); 
		query.append("and	eh.tml_inv_sts_cd				=	@[tml_inv_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${csr_no} != '') " ).append("\n"); 
		query.append("and	1=2" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tml_inv_rjct_sts_cd} != '' and ${tml_inv_rjct_sts_cd}=='RJ') " ).append("\n"); 
		query.append("and	eh.tml_inv_rjct_sts_cd = 'AJ'" ).append("\n"); 
		query.append("#elseif (${tml_inv_rjct_sts_cd} != '') " ).append("\n"); 
		query.append("and	eh.tml_inv_rjct_sts_cd = @[tml_inv_rjct_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and	eh.tml_inv_rjct_sts_cd in ('NL','AJ')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY LOCL_CRE_DT DESC, VNDR_SEQ DESC, INV_NO DESC)" ).append("\n"); 
		query.append("GROUP BY INV_NO, FILE_CHK, VVD,TML_SO_OFC_CTY_CD,TML_SO_SEQ,INV_TP_CD,TML_INV_TP_CD,TML_INV_STS_CD,TML_INV_RJCT_STS_CD,CRE_DT,LOCL_CRE_DT,INV_OFC_CD,INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("COST_OFC_CD,COST_OFC_DEL_FLG,YD_CD,YD_DEL_FLG,CURR_CD,ISS_DT,RCV_DT,EFF_DT,PAY_DUE_DT,PAY_FLG,HLD_FLG,VNDR_SEQ,VNDR_DEL_FLG, " ).append("\n"); 
		query.append("DELT_FLG,CSR_NO,CRE_USR_ID,CSR_STATUS,TML_EDI_SO_OFC_CTY_CD,TML_EDI_SO_SEQ,INV_RJCT_RMK,EDI_FLG,RTRO_TML_INV_FLG,SNDR_ID,TML_INV_EDI_SEQ,EDI_RCV_RULE_MN_SEQ," ).append("\n"); 
		query.append("LOCL_UPD_DT," ).append("\n"); 
		query.append("INV_CFM_DT," ).append("\n"); 
		query.append("IF_DT,	" ).append("\n"); 
		query.append("AP_REQ_DT" ).append("\n"); 

	}
}