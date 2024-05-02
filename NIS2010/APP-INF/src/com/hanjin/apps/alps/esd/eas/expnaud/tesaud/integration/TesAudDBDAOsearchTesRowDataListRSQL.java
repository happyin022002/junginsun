/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAudDBDAOsearchTesRowDataListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAudDBDAOsearchTesRowDataListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTesRowDataList
	  * </pre>
	  */
	public TesAudDBDAOsearchTesRowDataListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lgs_cost_subj_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.tesaud.integration").append("\n"); 
		query.append("FileName : TesAudDBDAOsearchTesRowDataListRSQL").append("\n"); 
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
		query.append("    	RHQ," ).append("\n"); 
		query.append("		INV_OFC_CD," ).append("\n"); 
		query.append("		COST_OFC_CD," ).append("\n"); 
		query.append("		EXE_YRMON," ).append("\n"); 
		query.append("		ACT_VVD_CD," ).append("\n"); 
		query.append("		ATB_DT," ).append("\n"); 
		query.append("		INV_NO," ).append("\n"); 
		query.append("		CRE_USR_NM," ).append("\n"); 
		query.append("		ISS_DT," ).append("\n"); 
		query.append("		RCV_DT," ).append("\n"); 
		query.append("		CRE_DT," ).append("\n"); 
		query.append("		ACCT_CD," ).append("\n"); 
		query.append("		CNT_CD," ).append("\n"); 
		query.append("		N1ST_NOD_CD," ).append("\n"); 
		query.append("		SP_CODE," ).append("\n"); 
		query.append("		SP_NAME," ).append("\n"); 
		query.append("		INVOICE_STATUS,  " ).append("\n"); 
		query.append("		CALC_TYPE,   " ).append("\n"); 
		query.append("		COA_COST_SRC_CD,    " ).append("\n"); 
		query.append("		CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("		IO_BND_CD," ).append("\n"); 
		query.append("		DCGO_IND_CD," ).append("\n"); 
		query.append("		RC_FLG," ).append("\n"); 
		query.append("		TML_WRK_DY_CD," ).append("\n"); 
		query.append("		IOC_CD," ).append("\n"); 
		query.append("    	TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("		LANE_CD," ).append("\n"); 
		query.append("		TIER," ).append("\n"); 
		query.append("		CALC_VOL_QTY," ).append("\n"); 
		query.append("		RVIS_VOL_QTY," ).append("\n"); 
		query.append("		CALC_VOL," ).append("\n"); 
		query.append("		RVIS_VOL," ).append("\n"); 
		query.append("		VOL_TR_UT_CD," ).append("\n"); 
		query.append("		RATE,  " ).append("\n"); 
		query.append("		USD_RATE," ).append("\n"); 
		query.append("		AGMT_CURR," ).append("\n"); 
		query.append("		INV_XCH_RT," ).append("\n"); 
		query.append("		INV_AMT," ).append("\n"); 
		query.append("		AMOUNT," ).append("\n"); 
		query.append("		CALC_RMK," ).append("\n"); 
		query.append("		TML_CRR_CD,  " ).append("\n"); 
		query.append("		N3PTY_FLG," ).append("\n"); 
		query.append(" 		ROW_COUNT" ).append("\n"); 
		query.append(" FROM	(   " ).append("\n"); 
		query.append("      SELECT	DECODE(O.OFC_CD, 'DURBA', O.AR_HD_QTR_OFC_CD, 'DARBA', O.AR_HD_QTR_OFC_CD, 'MBABA', O.AR_HD_QTR_OFC_CD, 'AISBA', O.AR_HD_QTR_OFC_CD, DECODE(L.CONTI_CD, 'F', 'HAMUR', 'E', 'HAMUR', 'M', 'NYCNA', 'A', O.AR_HD_QTR_OFC_CD)) RHQ,  " ).append("\n"); 
		query.append("      		TES.INV_OFC_CD," ).append("\n"); 
		query.append("      		TES.COST_OFC_CD," ).append("\n"); 
		query.append("      		TES.EXE_YRMON," ).append("\n"); 
		query.append("      		TES.VVD ACT_VVD_CD," ).append("\n"); 
		query.append("      		TES.ATB_DT," ).append("\n"); 
		query.append("      		TES.INV_NO," ).append("\n"); 
		query.append("			TES.CRE_USR_NM," ).append("\n"); 
		query.append("      		TES.ISS_DT," ).append("\n"); 
		query.append("      		TES.RCV_DT," ).append("\n"); 
		query.append("      		TES.CRE_DT," ).append("\n"); 
		query.append("      		TES.ACCT_CD," ).append("\n"); 
		query.append("      		TES.CNT_CD," ).append("\n"); 
		query.append("      		TES.YD_CD N1ST_NOD_CD," ).append("\n"); 
		query.append("      		TES.SP_CODE," ).append("\n"); 
		query.append("      		TES.SP_NAME," ).append("\n"); 
		query.append("      		TES.TML_INV_STS_CD INVOICE_STATUS,  " ).append("\n"); 
		query.append("      		TES.CALC_TYPE,   " ).append("\n"); 
		query.append("      		TES.LGS_COST_CD COA_COST_SRC_CD,    " ).append("\n"); 
		query.append("      		TES.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("      		TES.IO_BND_CD," ).append("\n"); 
		query.append("      		TES.DCGO_IND_CD," ).append("\n"); 
		query.append("      		TES.RC_FLG," ).append("\n"); 
		query.append("      		TES.TML_WRK_DY_CD," ).append("\n"); 
		query.append("      		TES.IOC_CD," ).append("\n"); 
		query.append("          	DECODE(TES.TML_TRNS_MOD_CD,'V','Mother','R','Rail','B','Barge','T','Truck','O','Other','S','Same','F','Feeder','') TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("      		TES.LANE_CD," ).append("\n"); 
		query.append("      		TES.TIER," ).append("\n"); 
		query.append("      		TES.CALC_VOL_QTY," ).append("\n"); 
		query.append("      		TES.RVIS_VOL_QTY," ).append("\n"); 
		query.append("      		SUM(TES.CALC_VOL_QTY) CALC_VOL," ).append("\n"); 
		query.append("      		SUM(TES.RVIS_VOL_QTY) RVIS_VOL," ).append("\n"); 
		query.append("      		TES.VOL_TR_UT_CD," ).append("\n"); 
		query.append("      		TES.CTRT_RT RATE,  " ).append("\n"); 
		query.append("      		NVL(ROUND(TES.CTRT_RT/G.USD_LOCL_XCH_RT, 2), 0) USD_RATE," ).append("\n"); 
		query.append("      		TES.CURR_CD AGMT_CURR," ).append("\n"); 
		query.append("      		TES.INV_XCH_RT," ).append("\n"); 
		query.append("      		TES.INV_AMT," ).append("\n"); 
		query.append("      		SUM(NVL(ROUND(TES.INV_AMT / G.USD_LOCL_XCH_RT, 2),0)) AMOUNT," ).append("\n"); 
		query.append("      		TES.CALC_RMK," ).append("\n"); 
		query.append("      		TES.TML_CRR_CD,  " ).append("\n"); 
		query.append("      		TES.N3PTY_FLG," ).append("\n"); 
		query.append("       		ROW_NUMBER() OVER (ORDER BY TES.INV_NO ASC) AS ROW_NUM," ).append("\n"); 
		query.append("		    COUNT(TES.INV_NO) OVER() AS ROW_COUNT" ).append("\n"); 
		query.append("      FROM	(" ).append("\n"); 
		query.append("      		SELECT  DECODE(H.TML_INV_STS_CD,'R','Received','C','Comfirm','A','Approval Request','P','A/P Interfaced','D','Paid','') TML_INV_STS_CD," ).append("\n"); 
		query.append("      				SUBSTR(A.GL_DT, 1, 6) EXE_YRMON," ).append("\n"); 
		query.append("      				DECODE(D.DCGO_IND_CD,'','N',D.DCGO_IND_CD) DCGO_IND_CD," ).append("\n"); 
		query.append("      				D.ACCT_CD," ).append("\n"); 
		query.append("      				SUBSTR(H.YD_CD,0,2) CNT_CD," ).append("\n"); 
		query.append("      				D.TML_WRK_DY_CD," ).append("\n"); 
		query.append("      				D.LGS_COST_CD," ).append("\n"); 
		query.append("      				D.RC_FLG," ).append("\n"); 
		query.append("      				H.INV_OFC_CD, " ).append("\n"); 
		query.append("      				TO_CHAR(D.ATB_DT,'YYYY-MM-DD') ATB_DT," ).append("\n"); 
		query.append("      				TO_CHAR(H.ISS_DT,'YYYY-MM-DD') ISS_DT," ).append("\n"); 
		query.append("      				TO_CHAR(H.RCV_DT,'YYYY-MM-DD') RCV_DT," ).append("\n"); 
		query.append("      				TO_CHAR(H.CRE_DT,'YYYY-MM-DD HH24:MI:SS') CRE_DT," ).append("\n"); 
		query.append("      				D.VOL_TR_UT_CD," ).append("\n"); 
		query.append("      				D.TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("      				D.INV_XCH_RT," ).append("\n"); 
		query.append("      				H.YD_CD," ).append("\n"); 
		query.append("      				D.IOC_CD," ).append("\n"); 
		query.append("      				D.LANE_CD," ).append("\n"); 
		query.append("      				NVL(D.FM_TR_VOL_VAL,'1')||' ~ '||NVL(D.TO_TR_VOL_VAL,'99999')  TIER," ).append("\n"); 
		query.append("      				D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("      				D.N3PTY_FLG," ).append("\n"); 
		query.append("      				H.CSR_NO," ).append("\n"); 
		query.append("      				H.INV_NO," ).append("\n"); 
		query.append("      				D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("      				D.CALC_VOL_QTY," ).append("\n"); 
		query.append("      				H.CURR_CD," ).append("\n"); 
		query.append("      				D.RVIS_VOL_QTY," ).append("\n"); 
		query.append("      				D.TML_CRR_CD,      " ).append("\n"); 
		query.append("      				D.INV_AMT," ).append("\n"); 
		query.append("      				D.CTRT_RT," ).append("\n"); 
		query.append("      				D.CALC_RMK," ).append("\n"); 
		query.append("      				DECODE(D.CALC_TP_CD ,'A','Auto','M','Manual','') CALC_TYPE," ).append("\n"); 
		query.append("      				H.VNDR_SEQ SP_CODE," ).append("\n"); 
		query.append("      				(SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      				FROM MDM_VENDOR" ).append("\n"); 
		query.append("      				WHERE VNDR_SEQ = H.VNDR_SEQ) SP_NAME" ).append("\n"); 
		query.append("      				, H.COST_OFC_CD" ).append("\n"); 
		query.append("      				, D.IO_BND_CD" ).append("\n"); 
		query.append("					, (SELECT USR_NM FROM COM_USER WHERE USR_ID = H.CRE_USR_ID) CRE_USR_NM" ).append("\n"); 
		query.append("      		FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("      				, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("      				, TES_TML_SO_COST SC" ).append("\n"); 
		query.append("      				, TES_LGS_COST LC" ).append("\n"); 
		query.append("      				, AP_INV_HDR A" ).append("\n"); 
		query.append("					, COM_APRO_CSR_DTL C" ).append("\n"); 
		query.append("					, COM_APRO_RQST_HDR R" ).append("\n"); 
		query.append("      		WHERE	1	= 1" ).append("\n"); 
		query.append("      		AND		H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      		AND		H.TML_SO_SEQ		= D.TML_SO_SEQ" ).append("\n"); 
		query.append("      		AND		NVL(H.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      		AND		D.LGS_COST_CD	= LC.LGS_COST_CD" ).append("\n"); 
		query.append("      		AND		D.LGS_COST_CD	= SC.LGS_COST_CD" ).append("\n"); 
		query.append("			--// CHM-201642099 TES Intensive Audit 검색 조건 code 추가 (2016-06-16)" ).append("\n"); 
		query.append("      		AND		H.CSR_NO			= A.CSR_NO(+)" ).append("\n"); 
		query.append("			AND		H.CSR_NO			= C.CSR_NO(+)" ).append("\n"); 
		query.append("			AND		C.APRO_RQST_NO		= R.APRO_RQST_NO(+)" ).append("\n"); 
		query.append("			#if (${inv_date_type} == 'I') 	-- ISSUED DATE" ).append("\n"); 
		query.append("			AND		H.ISS_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("			#elseif (${inv_date_type} == 'R')	-- RECEIVED DATE" ).append("\n"); 
		query.append("			AND		H.RCV_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("			#elseif (${inv_date_type} == 'P')	-- INVOICE UPDATE DATE" ).append("\n"); 
		query.append("			AND		H.LOCL_UPD_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("			#elseif (${inv_date_type} == 'A')	-- ARRROVAL REQUESTED DATE" ).append("\n"); 
		query.append("			AND		( (R.RQST_ST_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 )" ).append("\n"); 
		query.append("			OR		( A.CSR_APRO_STEP_ASGN_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 ) )" ).append("\n"); 
		query.append("			#elseif (${inv_date_type} == 'C')	-- CONFIRMED DATE" ).append("\n"); 
		query.append("			AND		H.INV_CFM_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("			#elseif (${inv_date_type} == 'U')	-- I/F STATUS UPDATED" ).append("\n"); 
		query.append("			AND		A.IF_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --		--// 2. YARD CODE" ).append("\n"); 
		query.append("      		#if ( ${yd_cd} != '' ) " ).append("\n"); 
		query.append("      		AND		H.YD_CD		 = @[yd_cd]" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --		--// 3. S/P CODE" ).append("\n"); 
		query.append("      		#if ( ${vndr_seq} != '' ) " ).append("\n"); 
		query.append("      		AND		H.VNDR_SEQ		 = @[vndr_seq] 	" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --		--// 4. Manual Input Only" ).append("\n"); 
		query.append("      		#if ( ${manual_check} != '' ) " ).append("\n"); 
		query.append("      		AND		D.CALC_TP_CD = 'M' 	-- Check시에 조건 추가" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --		--// 5. VVD" ).append("\n"); 
		query.append("      		#if ( ${vvd} != '' )" ).append("\n"); 
		query.append("      		AND		D.VSL_CD || D.SKD_VOY_NO || D.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --		--// 6. Cost Office" ).append("\n"); 
		query.append("      		#if ( ${cost_ofc_cd} != '' )" ).append("\n"); 
		query.append("      		AND		H.COST_OFC_CD	= @[cost_ofc_cd] " ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --		--// 7. Invoice Office" ).append("\n"); 
		query.append("      		#if ( ${inv_ofc_cd} != '' )" ).append("\n"); 
		query.append("      		AND		H.INV_OFC_CD	= @[inv_ofc_cd]" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --		--// 8. Inv Status" ).append("\n"); 
		query.append("      		#if ( ${tml_inv_sts_cd} != '' )" ).append("\n"); 
		query.append("      		AND		H.TML_INV_STS_CD = @[tml_inv_sts_cd]" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --		--// 9 - 1. Cost Code Type 대분류 1차" ).append("\n"); 
		query.append("      		#if ( ${lgs_cost_subj_cd} != '' )" ).append("\n"); 
		query.append("      		AND		LC.LGS_COST_SUBJ_CD = @[lgs_cost_subj_cd]" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("       -- Cost Code Type 세분류 2차 조회시 (MULTI 리스트로 파라메터 받아 loop문에서 처리)" ).append("\n"); 
		query.append("        	#if ($lgs_cost_dtl_cd.size() > 0)" ).append("\n"); 
		query.append("              		AND   LC.LGS_COST_CD IN (" ).append("\n"); 
		query.append("        		#foreach($key in ${lgs_cost_dtl_cd}) " ).append("\n"); 
		query.append("         			#if($velocityCount < $lgs_cost_dtl_cd.size()) " ).append("\n"); 
		query.append("        				'$key', " ).append("\n"); 
		query.append("        			#else " ).append("\n"); 
		query.append("        				'$key' " ).append("\n"); 
		query.append("        			#end " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        		)" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("      		) TES" ).append("\n"); 
		query.append("      		, GL_MON_XCH_RT G" ).append("\n"); 
		query.append("      		, MDM_ORGANIZATION O" ).append("\n"); 
		query.append("      		, MDM_LOCATION L" ).append("\n"); 
		query.append("      WHERE	TES.CURR_CD = G.CURR_CD" ).append("\n"); 
		query.append("      AND		TES.EXE_YRMON = G.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("      AND		G.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("      AND		TES.INV_OFC_CD = O.OFC_CD(+)" ).append("\n"); 
		query.append("      AND		O.LOC_CD     = L.LOC_CD(+)" ).append("\n"); 
		query.append("      GROUP BY " ).append("\n"); 
		query.append("      		DECODE(O.OFC_CD, 'DURBA', O.AR_HD_QTR_OFC_CD, 'DARBA', O.AR_HD_QTR_OFC_CD, 'MBABA', O.AR_HD_QTR_OFC_CD, 'AISBA', O.AR_HD_QTR_OFC_CD, DECODE(L.CONTI_CD, 'F', 'HAMUR', 'E', 'HAMUR', 'M', 'NYCNA', 'A', O.AR_HD_QTR_OFC_CD))," ).append("\n"); 
		query.append("      		TES.INV_OFC_CD," ).append("\n"); 
		query.append("      		TES.COST_OFC_CD," ).append("\n"); 
		query.append("      		TES.EXE_YRMON," ).append("\n"); 
		query.append("      		TES.VVD," ).append("\n"); 
		query.append("      		TES.ATB_DT," ).append("\n"); 
		query.append("      		TES.INV_NO," ).append("\n"); 
		query.append("			TES.CRE_USR_NM," ).append("\n"); 
		query.append("      		TES.ISS_DT," ).append("\n"); 
		query.append("      		TES.RCV_DT," ).append("\n"); 
		query.append("      		TES.CRE_DT," ).append("\n"); 
		query.append("      		TES.ACCT_CD," ).append("\n"); 
		query.append("      		TES.CNT_CD," ).append("\n"); 
		query.append("      		TES.YD_CD," ).append("\n"); 
		query.append("      		TES.SP_CODE," ).append("\n"); 
		query.append("      		TES.SP_NAME," ).append("\n"); 
		query.append("      		TES.TML_INV_STS_CD,  " ).append("\n"); 
		query.append("      		TES.CALC_TYPE,   " ).append("\n"); 
		query.append("      		TES.LGS_COST_CD,    " ).append("\n"); 
		query.append("      		TES.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("      		TES.IO_BND_CD," ).append("\n"); 
		query.append("      		TES.DCGO_IND_CD," ).append("\n"); 
		query.append("      		TES.RC_FLG," ).append("\n"); 
		query.append("      		TES.TML_WRK_DY_CD," ).append("\n"); 
		query.append("      		TES.IOC_CD," ).append("\n"); 
		query.append("      		DECODE(TES.TML_TRNS_MOD_CD,'V','Mother','R','Rail','B','Barge','T','Truck','O','Other','S','Same','F','Feeder','')," ).append("\n"); 
		query.append("      		TES.LANE_CD," ).append("\n"); 
		query.append("      		TES.TIER," ).append("\n"); 
		query.append("      		TES.CALC_VOL_QTY," ).append("\n"); 
		query.append("      		TES.RVIS_VOL_QTY," ).append("\n"); 
		query.append("      		TES.VOL_TR_UT_CD," ).append("\n"); 
		query.append("      		TES.CTRT_RT,  " ).append("\n"); 
		query.append("      		NVL(ROUND(TES.CTRT_RT/G.USD_LOCL_XCH_RT, 2), 0)," ).append("\n"); 
		query.append("      		TES.CURR_CD," ).append("\n"); 
		query.append("      		TES.INV_XCH_RT," ).append("\n"); 
		query.append("      		TES.INV_AMT," ).append("\n"); 
		query.append("      		TES.CALC_RMK," ).append("\n"); 
		query.append("      		TES.TML_CRR_CD,  " ).append("\n"); 
		query.append("      		TES.N3PTY_FLG" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("  WHERE    ROW_NUM >= (@[pagerows] * (@[page_no] - 1) + 1)" ).append("\n"); 
		query.append("  AND    ROW_NUM <= (@[pagerows] * @[page_no])" ).append("\n"); 

	}
}