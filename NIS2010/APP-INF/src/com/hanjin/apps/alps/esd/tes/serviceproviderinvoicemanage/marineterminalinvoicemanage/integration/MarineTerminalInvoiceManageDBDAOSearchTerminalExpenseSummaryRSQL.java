/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalExpenseSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
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

public class MarineTerminalInvoiceManageDBDAOSearchTerminalExpenseSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalExpenseSummary
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalExpenseSummaryRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalExpenseSummaryRSQL").append("\n"); 
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
		query.append("SELECT	HQ_OFC_CD," ).append("\n"); 
		query.append("		RHQ_OFC_CD," ).append("\n"); 
		query.append("		INV_OFC_CD," ).append("\n"); 
		query.append("		COST_OFC_CD," ).append("\n"); 
		query.append("		YD_CD," ).append("\n"); 
		query.append("		VNDR_SEQ," ).append("\n"); 
		query.append("		VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("		CURR_CD," ).append("\n"); 
		query.append("		INV_AMT," ).append("\n"); 
		query.append("		VAT_AMT," ).append("\n"); 
		query.append("		WHLD_TAX_AMT," ).append("\n"); 
		query.append("		TTL_INV_AMT," ).append("\n"); 
		query.append("		USD_AMT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("	SELECT 'SELHQ' HQ_OFC_CD,    " ).append("\n"); 
		query.append("		-- 2015-08-03 그룹사 조직 코드 변경 (HAMUR->HAMRU,NYCNA->NYCRA)                                                                  				" ).append("\n"); 
		query.append("	    DECODE(O.OFC_CD, 'DURBA', O.AR_HD_QTR_OFC_CD, DECODE(L.CONTI_CD, 'F', 'HAMRU', 'E', 'HAMRU', 'M', 'NYCRA', 'A', O.AR_HD_QTR_OFC_CD)) RHQ_OFC_CD,       				" ).append("\n"); 
		query.append("	    H.INV_OFC_CD,                                                                           				" ).append("\n"); 
		query.append("	    H.COST_OFC_CD,                                                                          				" ).append("\n"); 
		query.append("	    H.YD_CD,                                                                                				" ).append("\n"); 
		query.append("	    LPAD(H.VNDR_SEQ, 6, '0') VNDR_SEQ,                                                        				" ).append("\n"); 
		query.append("	    DECODE(V.VNDR_CNT_CD,'KR',V.VNDR_LOCL_LANG_NM,V.VNDR_LGL_ENG_NM) VNDR_LGL_ENG_NM,         				" ).append("\n"); 
		query.append("	    H.CURR_CD,                                                                              				" ).append("\n"); 
		query.append("	    SUM(NVL(D.INV_AMT,0)) INV_AMT,                                                      					" ).append("\n"); 
		query.append("	    SUM(NVL(D.INV_AMT*H.VAT_AMT/H.TTL_INV_AMT,0)) VAT_AMT," ).append("\n"); 
		query.append("	    SUM(NVL(D.INV_AMT*H.WHLD_TAX_AMT/H.TTL_INV_AMT,0)) WHLD_TAX_AMT," ).append("\n"); 
		query.append("	    SUM(NVL(D.INV_AMT,0))+SUM(NVL(D.INV_AMT*H.VAT_AMT/H.TTL_INV_AMT,0))" ).append("\n"); 
		query.append("				-SUM(NVL(D.INV_AMT*H.WHLD_TAX_AMT/H.TTL_INV_AMT,0)) TTL_INV_AMT," ).append("\n"); 
		query.append("	    NVL(ROUND(SUM(D.INV_AMT/G.USD_LOCL_XCH_RT),2),0)" ).append("\n"); 
		query.append("	     +NVL(ROUND(SUM(D.INV_AMT*H.VAT_AMT/H.TTL_INV_AMT/G.USD_LOCL_XCH_RT),2),0)" ).append("\n"); 
		query.append("	     -NVL(ROUND(SUM(D.INV_AMT*H.WHLD_TAX_AMT/H.TTL_INV_AMT/G.USD_LOCL_XCH_RT),2),0) USD_AMT" ).append("\n"); 
		query.append("	    , ROW_NUMBER() OVER (ORDER BY H.INV_OFC_CD, H.COST_OFC_CD, H.YD_CD, H.VNDR_SEQ) AS NO" ).append("\n"); 
		query.append("	FROM TES_TML_SO_HDR H, TES_TML_SO_DTL D, MDM_ORGANIZATION O, MDM_LOCATION L, GL_MON_XCH_RT G, MDM_VENDOR V	" ).append("\n"); 
		query.append("	WHERE H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD                                             				" ).append("\n"); 
		query.append("	AND H.TML_SO_SEQ = D.TML_SO_SEQ                                                             				" ).append("\n"); 
		query.append("	AND H.DELT_FLG IS NULL                                                                      				" ).append("\n"); 
		query.append("	AND H.TML_INV_STS_CD <> 'R'                                                                  				" ).append("\n"); 
		query.append("	AND H.TML_INV_RJCT_STS_CD <>'RJ'" ).append("\n"); 
		query.append("	--AND H.TTL_INV_AMT <> 0 --2011.04.12 김승미대리 요청" ).append("\n"); 
		query.append("	#if (${yd_cd} != '') " ).append("\n"); 
		query.append("	and h.yd_cd = @[yd_cd]" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("	and h.vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${cost_ofc_cd} != '') " ).append("\n"); 
		query.append("	and cost_ofc_cd in (" ).append("\n"); 
		query.append("	#foreach($cost_ofc_cd_num IN ${cost_ofc_cd})" ).append("\n"); 
		query.append("		#if($velocityCount < $cost_ofc_cd.size()) " ).append("\n"); 
		query.append("		'$cost_ofc_cd_num', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("		'$cost_ofc_cd_num' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${inv_ofc_cd} != '') " ).append("\n"); 
		query.append("	AND H.INV_OFC_CD IN (" ).append("\n"); 
		query.append("	#foreach($inv_ofc_cd_num IN ${inv_ofc_cd})" ).append("\n"); 
		query.append("		#if($velocityCount < $inv_ofc_cd.size()) " ).append("\n"); 
		query.append("		'$inv_ofc_cd_num', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("		'$inv_ofc_cd_num' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${inv_date_type} == 'I') " ).append("\n"); 
		query.append("				AND h.iss_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#elseif (${inv_date_type} == 'R') " ).append("\n"); 
		query.append("				AND H.rcv_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#elseif (${inv_date_type} == 'P') " ).append("\n"); 
		query.append("				AND h.locl_upd_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#elseif (${inv_date_type} == 'A') " ).append("\n"); 
		query.append("				AND d.atb_dt BETWEEN TO_DATE(REPLACE(@[fm_prd_dt],'-'),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt],'-'),'YYYYMMDD')+0.99999 " ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${vvd} != '') " ).append("\n"); 
		query.append("	AND D.vsl_cd = SUBSTR(@[vvd],1,4)    " ).append("\n"); 
		query.append("	AND D.skd_voy_no = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND D.skd_dir_cd = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	AND H.VNDR_SEQ = V.VNDR_SEQ                                                                   				" ).append("\n"); 
		query.append("	AND H.CURR_CD = G.CURR_CD                                                                   				" ).append("\n"); 
		query.append("	AND G.ACCT_XCH_RT_YRMON = TO_CHAR(H.ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("	AND G.ACCT_XCH_RT_LVL = 1                                                                   				" ).append("\n"); 
		query.append("	AND H.INV_OFC_CD = O.OFC_CD(+)                                                              				" ).append("\n"); 
		query.append("	AND O.LOC_CD     = L.LOC_CD(+)                                                              				" ).append("\n"); 
		query.append("	GROUP BY H.INV_OFC_CD, H.COST_OFC_CD, H.YD_CD, H.CURR_CD, H.VNDR_SEQ, L.CONTI_CD, O.AR_HD_QTR_OFC_CD		" ).append("\n"); 
		query.append("	        , V.VNDR_LGL_ENG_NM, V.VNDR_CNT_CD , V.VNDR_LOCL_LANG_NM, O.OFC_CD	                                   		" ).append("\n"); 
		query.append("	ORDER BY H.INV_OFC_CD, H.COST_OFC_CD, H.YD_CD, H.VNDR_SEQ" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("WHERE	NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}