/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRPTDBDAOSearchInqSrcDtAcct0035ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.26
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.05.26 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jinhwan, Son
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchInqSrcDtAcct0035ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry by Source Data
	  * 2012.01.03 [CHM-201114896-01] 이석준  CM2(Own Feeder) 비용 반영
	  * 2012.01.03 [SRM-201224324]김종준 특수문자 에러 ,REPLACE(A2.SHPR_NM ,CHR(29),' ')   AS BL_SHPR_NM  처리
	  * 2012.07.18 [CHM-201219034] 이석준 [COA] Inquiry by source data 계정 추가
	  * 2014.01.16 [CHM-201428540] 김수정 [COA] Inquiry by Source Data 정보 추가 요청
	  * 2014.06.03 [CHM-201430312] 최덕우 [COA] G.Customer Display 관련 일부 화면 로직 보완 수정
	  * 2015.02.03 [CHM-201533978] 이윤정 COA 기능 추가 요청 CSR - RFA Type 추가
	  * 2015.05.14 [CHM-201535771] 손진환 [COA] CGO RCV DT를 부킹 모듈 상에서 OC Status 발생 date를 바로 바라볼 수 있도록 로직 수정
	  * 2015.05.14 [CHM-201535424] 손진환 [COA] COA 상 Fixed Rate 반영
	  * 2015.05.21 [CHM-201536029] 손진환 [COA] COA 상 Fixed Rate 반영 요청 CSR
	  * </pre>
	  */
	public SalesRPTDBDAOSearchInqSrcDtAcct0035ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usa_bkg_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_shpr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rev_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rev_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchInqSrcDtAcct0035ListRSQL").append("\n"); 
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
		query.append("#if(${f_excel} =='Y')" ).append("\n"); 
		query.append("  SELECT   'R.MONTH'  COST_YRMON" ).append("\n"); 
		query.append("    , 'S.MONTH' SLS_YRMON " ).append("\n"); 
		query.append("    , 'WEEK'  COST_WK" ).append("\n"); 
		query.append("    , 'BKG NO'  BKG_NO" ).append("\n"); 
		query.append("	, 'F_Index'  FX_RT_FLG" ).append("\n"); 
		query.append("    , 'BL NO'  BL_NO" ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("	, 'TS MON' TS_MON" ).append("\n"); 
		query.append("    , 'TS WEEK' TS_WK" ).append("\n"); 
		query.append("	, 'TS TRADE' TS_TRD_CD" ).append("\n"); 
		query.append("	, 'TS LANE' TS_RLANE_CD" ).append("\n"); 
		query.append("    , 'T/S BND'  TS_BND" ).append("\n"); 
		query.append("    , 'T/S VVD'  TS_VVD" ).append("\n"); 
		query.append("	, 'T/S TRADE DIR.' TS_TRD_DIR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , 'TRADE'  TRD_CD" ).append("\n"); 
		query.append("    , 'SUB TRADE' SUB_TRD_CD" ).append("\n"); 
		query.append("    , 'R.LANE'  RLANE_CD" ).append("\n"); 
		query.append("    , 'IOC'  IOC_CD" ).append("\n"); 
		query.append("    , 'REV VVD'  R_VVD" ).append("\n"); 
		query.append("    , 'STATUS' STATUS" ).append("\n"); 
		query.append("    , 'DIR'  DIR_CD" ).append("\n"); 
		query.append("	, 'Trade Dir.' HUL_BND_CD" ).append("\n"); 
		query.append("    , 'C.RHQ'  C_RHQ" ).append("\n"); 
		query.append("    , 'C.AD'  C_AD " ).append("\n"); 
		query.append("    , 'C.OFC'  C_OFC" ).append("\n"); 
		query.append("    , 'C.Region OFC'  C_RGN_OFC" ).append("\n"); 
		query.append("    , 'C.S.REP'  CSREP_CD" ).append("\n"); 
		query.append("    , 'L.RHQ'  L_RHQ" ).append("\n"); 
		query.append("    , 'L.AD'  L_AD" ).append("\n"); 
		query.append("    , 'L.OFC'  L_OFC" ).append("\n"); 
		query.append("    , 'L.Region OFC'  L_RGN_OFC" ).append("\n"); 
		query.append("    , 'L.REP'  LREP_CD" ).append("\n"); 
		query.append("    , 'BKG OFC'  BKG_OFC_CD" ).append("\n"); 
		query.append("    , 'BKG STS'  BKG_STS_CD" ).append("\n"); 
		query.append("    , 'USA MODE'  USA_MODE" ).append("\n"); 
		query.append("	, 'TRUNK POL' TRNK_POL" ).append("\n"); 
		query.append("	, 'TRUNK POD' TRNK_POD" ).append("\n"); 
		query.append("    , 'BKG POR'  BKG_POR_CD" ).append("\n"); 
		query.append("    , 'BKG POL'  BKG_POL_CD" ).append("\n"); 
		query.append("    , 'BKG POD'  BKG_POD_CD" ).append("\n"); 
		query.append("    , 'BKG DEL'  BKG_DEL_CD" ).append("\n"); 
		query.append("    , 'RCV TERM'  BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("    , 'DEL TERM'  BKG_DE_TERM_CD" ).append("\n"); 
		query.append("    , 'Customs Desc'  CSTMS_DESC" ).append("\n"); 
		query.append("    , 'REP CMDT CD'  REP_CMDT_CD" ).append("\n"); 
		query.append("    , 'REP CMDT DESC'  REP_CMDT_NM" ).append("\n"); 
		query.append("    , 'CMDT CD'  CMDT_CD" ).append("\n"); 
		query.append("    , 'CMDT DESC'  CMDT_NM" ).append("\n"); 
		query.append("    , 'IAS REGION' IAS_RGN_CD" ).append("\n"); 
		query.append("    , 'TRADE1'  N1ST_TRD_CD" ).append("\n"); 
		query.append("    , 'TRADE2'  N2ND_TRD_CD" ).append("\n"); 
		query.append("    , 'TRADE3'  N3RD_TRD_CD" ).append("\n"); 
		query.append("    , 'TRADE4'  N4TH_TRD_CD" ).append("\n"); 
		query.append("    , 'TRADE5'  N5TH_TRD_CD" ).append("\n"); 
		query.append("    , 'LANE1'  N1ST_RLANE_CD" ).append("\n"); 
		query.append("    , 'LANE2'  N2ND_RLANE_CD" ).append("\n"); 
		query.append("    , 'LANE3'  N3RD_RLANE_CD" ).append("\n"); 
		query.append("    , 'LANE4'  N4TH_RLANE_CD" ).append("\n"); 
		query.append("    , 'LANE5'  N5TH_RLANE_CD" ).append("\n"); 
		query.append("    , 'VVD1'  N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("    , 'VVD2'  N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("    , 'VVD3'  N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("    , 'VVD4'  N4TH_FINC_VVD_CD" ).append("\n"); 
		query.append("    , 'VVD5'  N5TH_FINC_VVD_CD" ).append("\n"); 
		query.append("	, 'T/S PORT' TS_PORT" ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y')" ).append("\n"); 
		query.append("    , 'T/S POL'  TS_POL" ).append("\n"); 
		query.append("    , 'T/S POD'  TS_POD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , 'POL1'  N1ST_POL_CD" ).append("\n"); 
		query.append("    , 'POL2'  N2ND_POL_CD" ).append("\n"); 
		query.append("    , 'POL3'  N3RD_POL_CD" ).append("\n"); 
		query.append("    , 'POL4'  N4TH_POL_CD" ).append("\n"); 
		query.append("    , 'POL5'  N5TH_POL_CD" ).append("\n"); 
		query.append("    , 'POD1'  N1ST_POD_CD" ).append("\n"); 
		query.append("    , 'POD2'  N2ND_POD_CD" ).append("\n"); 
		query.append("    , 'POD3'  N3RD_POD_CD" ).append("\n"); 
		query.append("    , 'POD4'  N4TH_POD_CD" ).append("\n"); 
		query.append("    , 'POD5'  N5TH_POD_CD" ).append("\n"); 
		query.append("    , 'SC NO'  SC_NO" ).append("\n"); 
		query.append("    , 'RFA NO'  RFA_NO" ).append("\n"); 
		query.append("    , 'RFA TYPE'RFA_TP" ).append("\n"); 
		query.append("    , 'NVOCC'  NVOCC" ).append("\n"); 
		query.append("    , 'CUST TP'  CUST_TP" ).append("\n"); 
		query.append("    , 'SC/RFC CUST CD'  SC_CUST_CD" ).append("\n"); 
		query.append("    , 'SC/RFC CUST NM'  SC_CUST_NM" ).append("\n"); 
		query.append("	, 'G/Customer Code(Shipper)' SHPR_CUST_ID" ).append("\n"); 
		query.append("	, 'G/Customer Name(Shipper)' SHIPPER_NAME" ).append("\n"); 
		query.append("    , 'G/Customer Code(C.Customer)' AGMT_CUST_ID" ).append("\n"); 
		query.append("	, 'G/Customer Name(C.Customer)' AGMT_NAME" ).append("\n"); 
		query.append("	, 'A/Customer Code' ACT_CUST_ID" ).append("\n"); 
		query.append("	, 'A/Customer Name' ACT_CUST_NM" ).append("\n"); 
		query.append("    , 'BKG SHPR_CD'  SHPR_CD" ).append("\n"); 
		query.append("    , 'BKG SHPR_NM'  SHPR_NM" ).append("\n"); 
		query.append("    , 'B/L SHPR NM'  BL_SHPR_NM" ).append("\n"); 
		query.append("    , 'CNEE CD'  CNEE_CD" ).append("\n"); 
		query.append("    , 'CNEE NM'  CNEE_NM" ).append("\n"); 
		query.append("    , 'NOTIFY CD'  NTFY_CD" ).append("\n"); 
		query.append("    , 'NOTIFY NM'  NTFY_NM" ).append("\n"); 
		query.append("    , 'PRD CCT'  PPD_CCT" ).append("\n"); 
		query.append("    , 'BL ON BOARD DT'  BL_ONBOARD_DT" ).append("\n"); 
		query.append("    , 'CGO RCV DT'  CGO_RCV_DT" ).append("\n"); 
		query.append("    , 'SOC'  SOC" ).append("\n"); 
		query.append("    , 'REV MT'  REV_MT" ).append("\n"); 
		query.append("    , 'DG'  DG" ).append("\n"); 
		query.append("    , 'BB'  BB" ).append("\n"); 
		query.append("    , 'AK'  AK" ).append("\n"); 
		query.append("    , 'WEIGHT'  WEIGHT" ).append("\n"); 
		query.append("    , 'UNIT' UNIT" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,'FR_$key' REV_$key" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    ,'FR_REV_TTL' TOT_FR_REV_TPSZ" ).append("\n"); 
		query.append("    ,'MISC_REV_TTL' TOT_MISC_REV_TPSZ" ).append("\n"); 
		query.append("    ,'REV_TTL' TOT_REV_TPSZ" ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,'LOAD_$key' QTY_$key" ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    ,'LOAD_TTL(TEU)' TOT_QTY" ).append("\n"); 
		query.append("    ,'Freight Revenue' FREIGTH_REV" ).append("\n"); 
		query.append("    ,'Misc Operation Revenue' MISC_REV" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O')      " ).append("\n"); 
		query.append("    ,'CNTR DEM/DET' DMDT_COST" ).append("\n"); 
		query.append("	#end		" ).append("\n"); 
		query.append("    ,'Basic Stevedorage' BASIC_STEVEDORAGE" ).append("\n"); 
		query.append("    ,'Other CY Expense' OTHER_CY_EXPENSE" ).append("\n"); 
		query.append("    ,'T/S Stevedorage' TS_STEVEDORAGE" ).append("\n"); 
		query.append("    ,'On Dock CY Expense' ON_DOCK_CY_EXPENSE" ).append("\n"); 
		query.append("    ,'Cargo Handling Expense' CARGO_HANDLING_EXPENSE" ).append("\n"); 
		query.append("    ,'Storage' STORAGE" ).append("\n"); 
		query.append("    ,'Misc Cargo Handling Expense' MISC_CARGO_HANDLING_EXPENSE" ).append("\n"); 
		query.append("    ,'Exclusive Terminal Additional Cost' EXCLUSIVE_TERMINAL_ADD_COST" ).append("\n"); 
		query.append("    ,'Cargo Variable Volume Discount' CARGO_VARIABLE_VOLUME_DISCOUNT" ).append("\n"); 
		query.append("    ,'Rail Direct' RAIL_DIRECT" ).append("\n"); 
		query.append("    ,'Rail Truck' RAIL_TRUCK" ).append("\n"); 
		query.append("    ,'Truck Direct' TRUCK_DIRCET" ).append("\n"); 
		query.append("    ,'Water Direct' WATER_DIRECT" ).append("\n"); 
		query.append("    ,'Water Rail' WATER_RAIL" ).append("\n"); 
		query.append("    ,'Water Truck' WATER_TRUCK" ).append("\n"); 
		query.append("    ,'Other Transport Expense' OTHER_TRANSPORT_EXPENSE" ).append("\n"); 
		query.append("    ,'Carriers Haulage Service Charge ' CARRIERS_HAULAGE_SVG_CHG" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  #if(${f_pro_vw} =='R')" ).append("\n"); 
		query.append("    ,'Internal EQ Rental(EMU)_MT Repo Cost' INTERNAL_EQ_RENTAL_BASE" ).append("\n"); 
		query.append("    ,'Internal EQ Rental(EMU)_EMU Credit' INTERNAL_EQ_RENTAL_MT_SIM" ).append("\n"); 
		query.append("  #elseif (${f_pro_vw} =='P')" ).append("\n"); 
		query.append("    ,'Empty Terminal Expense' EMPTH_TERMINAL_EXPENSE" ).append("\n"); 
		query.append("    ,'Empty Transport Expense' EMPTY_TRANSPORT_EXPENSE" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("    ,'Agent Commission' AGENT_COMMISSION" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='M') -- CM2		" ).append("\n"); 
		query.append("    #if(${f_pro_vw} =='P')" ).append("\n"); 
		query.append("      ,'CM Cost Total' CM_COST_TOTAL" ).append("\n"); 
		query.append("      ,'CM Total' CM" ).append("\n"); 
		query.append("      ,'Own Feeder' OWN_FDR" ).append("\n"); 
		query.append("      ,'CM2 Cost Total' CM2_COST_TOTAL" ).append("\n"); 
		query.append("      ,'CM2 Total' CM2" ).append("\n"); 
		query.append("    #elseif (${f_pro_vw} =='R')" ).append("\n"); 
		query.append("      ,'BKG CM Cost Total' CM_COST_TOTAL" ).append("\n"); 
		query.append("      ,'BKG CM Total' CM" ).append("\n"); 
		query.append("      ,'Own Feeder' OWN_FDR" ).append("\n"); 
		query.append("      ,'BKG CM2 Cost Total' CM2_COST_TOTAL" ).append("\n"); 
		query.append("      ,'BKG CM2 Total' CM2" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    #if(${f_pro_vw} =='P')" ).append("\n"); 
		query.append("      ,'CM Cost Total' CM_COST_TOTAL" ).append("\n"); 
		query.append("      ,'CM Total' CM" ).append("\n"); 
		query.append("    #elseif (${f_pro_vw} =='R')" ).append("\n"); 
		query.append("      ,'BKG CM Cost Total' CM_COST_TOTAL" ).append("\n"); 
		query.append("      ,'BKG CM Total' CM" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O' && ${f_pro_vw} =='R' )" ).append("\n"); 
		query.append("    ,'US Domestic Saving Credit' US_DOMESTIC_SAV_CREDIT" ).append("\n"); 
		query.append("    ,'CNTR Fixed Cost' CNTR_FX_AMT" ).append("\n"); 
		query.append("    ,'Chasses fixed Cost' CHSS_FX_AMT" ).append("\n"); 
		query.append("    ,'Own-Vol Activity Cost' ONW_VOL_ACTIVITY_COST" ).append("\n"); 
		query.append("    ,'Activity Cost for STP Expense'  OTH_VOL_ACTIVITY_COST" ).append("\n"); 
		query.append("    ,'Internal Slot Rental(SMU Cost)' INTERNAL_SLOT_RENTAL_BASE" ).append("\n"); 
		query.append("    ,'OP COST Total' OP_COST_TOTAL" ).append("\n"); 
		query.append("    ,'BKG OP Total' OP_TOTAL" ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O' && ${f_pro_vw} =='P' )			" ).append("\n"); 
		query.append("    ,'US Domestic Saving Credit' US_DOMESTIC_SAV_CREDIT" ).append("\n"); 
		query.append("    ,'CNTR Long Term EQ Rental' CNTR_LONG_TERM_EQ_RENTAL" ).append("\n"); 
		query.append("    ,'CNTR Short Term EQ Rental' CNTR_SHORT_TERM_EQ_RENTAL" ).append("\n"); 
		query.append("    ,'CNTR M&R Charge' CNTR_MR_CHARGE" ).append("\n"); 
		query.append("    ,'CNTR Depreciation' CNTR_DEPRECIATION" ).append("\n"); 
		query.append("    ,'CNTR Insurance' CNTR_INSURANCE" ).append("\n"); 
		query.append("    ,'Chassis Short Term EQ Rental' CHASSIS_SHORT_TERM_EG_RENTAL" ).append("\n"); 
		query.append("    ,'Chassis Long Term EQ Rental' CHASSIS_LONG_TERM_EQ_RENTAL" ).append("\n"); 
		query.append("    ,'Chassis M&R Charge' SHASSIS_MR_CHARGE" ).append("\n"); 
		query.append("    ,'Chassis Depreciation' CHASSIS_DEPRECIATION" ).append("\n"); 
		query.append("    ,'Chassis Drayage' CHASSIS_DRAYAGE" ).append("\n"); 
		query.append("    ,'Chassis Insurance' CHASSIS_INSURANCE" ).append("\n"); 
		query.append("    ,'Business Activity Cost' BUSINESS_ACTIVITY_COST" ).append("\n"); 
		query.append("  #end				" ).append("\n"); 
		query.append("  FROM DUAL " ).append("\n"); 
		query.append("  UNION ALL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("   COST_YRMON  " ).append("\n"); 
		query.append("  ,SLS_YRMON  " ).append("\n"); 
		query.append("  ,COST_WK  " ).append("\n"); 
		query.append("  ,BKG_NO" ).append("\n"); 
		query.append("  ,FX_RT_FLG" ).append("\n"); 
		query.append("  ,BL_NO " ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("  ,TS_YRMON" ).append("\n"); 
		query.append("  ,TS_WK" ).append("\n"); 
		query.append("  ,TS_TRD_CD" ).append("\n"); 
		query.append("  ,TS_RLANE_CD " ).append("\n"); 
		query.append("  ,TS_BND" ).append("\n"); 
		query.append("  ,TS_VVD" ).append("\n"); 
		query.append("  ,TS_TRD_DIR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ,TRD_CD  " ).append("\n"); 
		query.append("  ,SUB_TRD_CD" ).append("\n"); 
		query.append("  ,RLANE_CD  " ).append("\n"); 
		query.append("  ,IOC_CD  " ).append("\n"); 
		query.append("  ,R_VVD" ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y' && ${f_rlane_cd} == 'RBCCO' )" ).append("\n"); 
		query.append("  ,CASE WHEN @[f_trd_cd]||@[f_rlane_cd] = TRD_CD||RLANE_CD AND MON_VVD = TRD_CD||RLANE_CD||R_VVD" ).append("\n"); 
		query.append("	   THEN 'L/C'" ).append("\n"); 
		query.append("       ELSE 'T/S'" ).append("\n"); 
		query.append("       END STATUS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  ,CASE WHEN MON_VVD = TRD_CD||RLANE_CD||R_VVD" ).append("\n"); 
		query.append("       THEN 'L/C'" ).append("\n"); 
		query.append("       ELSE 'T/S'" ).append("\n"); 
		query.append("       END STATUS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ,DIR_CD" ).append("\n"); 
		query.append("  ,HUL_BND_CD" ).append("\n"); 
		query.append("  ,C_RHQ " ).append("\n"); 
		query.append("  ,C_AD " ).append("\n"); 
		query.append("  ,C_OFC " ).append("\n"); 
		query.append("  ,C_RGN_OFC" ).append("\n"); 
		query.append("  ,CSREP_CD " ).append("\n"); 
		query.append("  ,L_RHQ " ).append("\n"); 
		query.append("  ,L_AD " ).append("\n"); 
		query.append("  ,L_OFC " ).append("\n"); 
		query.append("  ,L_RGN_OFC" ).append("\n"); 
		query.append("  ,LREP_CD  " ).append("\n"); 
		query.append("  ,BKG_OFC_CD  " ).append("\n"); 
		query.append("  ,BKG_STS_CD  " ).append("\n"); 
		query.append("  ,USA_MODE" ).append("\n"); 
		query.append("  ,TRNK_POL_CD" ).append("\n"); 
		query.append("  ,TRNK_POD_CD " ).append("\n"); 
		query.append("  ,BKG_POR_CD  " ).append("\n"); 
		query.append("  ,BKG_POL_CD  " ).append("\n"); 
		query.append("  ,BKG_POD_CD  " ).append("\n"); 
		query.append("  ,BKG_DEL_CD  " ).append("\n"); 
		query.append("  ,BKG_RCV_TERM_CD  " ).append("\n"); 
		query.append("  ,BKG_DE_TERM_CD  " ).append("\n"); 
		query.append("  ,CSTMS_DESC" ).append("\n"); 
		query.append("  ,REP_CMDT_CD  " ).append("\n"); 
		query.append("  ,REP_CMDT_NM     " ).append("\n"); 
		query.append("  ,CMDT_CD " ).append("\n"); 
		query.append("  ,CMDT_NM    " ).append("\n"); 
		query.append("  ,COA_GET_CD_NM_FNC('CD03218', IAS_RGN_CD) IAS_RGN_CD" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,1,3) N1ST_TRD_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,29,3) N2ND_TRD_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,57,3) N3RD_TRD_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,85,3) N4TH_TRD_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,113,3) N5TH_TRD_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,5,5) N1ST_RLANE_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,33,5) N2ND_RLANE_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,61,5) N3RD_RLANE_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,89,5) N4TH_RLANE_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,117,5) N5TH_RLANE_CD" ).append("\n"); 
		query.append("  , DECODE(SUBSTR(VVD_INFO,10,9),'XXXXXXXXX','',SUBSTR(VVD_INFO,10,9)) N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("  , DECODE(SUBSTR(VVD_INFO,38,9),'XXXXXXXXX','',SUBSTR(VVD_INFO,38,9)) N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("  , DECODE(SUBSTR(VVD_INFO,66,9),'XXXXXXXXX','',SUBSTR(VVD_INFO,66,9)) N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("  , DECODE(SUBSTR(VVD_INFO,94,9),'XXXXXXXXX','',SUBSTR(VVD_INFO,94,9)) N4TH_FINC_VVD_CD" ).append("\n"); 
		query.append("  , DECODE(SUBSTR(VVD_INFO,122,9),'XXXXXXXXX','',SUBSTR(VVD_INFO,122,9)) N5TH_FINC_VVD_CD" ).append("\n"); 
		query.append("#if(${f_include_ts} == 'Y')" ).append("\n"); 
		query.append("  , CASE WHEN SUBSTR(VVD_INFO,33,5) IS NULL THEN ''" ).append("\n"); 
		query.append("	ELSE DECODE(@[f_rlane_cd], SUBSTR(VVD_INFO,5,5), SUBSTR(VVD_INFO,24,5), SUBSTR(VVD_INFO,33,5), SUBSTR(VVD_INFO,47,5), SUBSTR(VVD_INFO,61,5), SUBSTR(VVD_INFO,75,5), SUBSTR(VVD_INFO,89,5), SUBSTR(VVD_INFO,103,5), SUBSTR(VVD_INFO,117,5),SUBSTR(VVD_INFO,131,5))" ).append("\n"); 
		query.append("	END TS_PORT" ).append("\n"); 
		query.append("  , DECODE(@[f_rlane_cd], SUBSTR(VVD_INFO,5,5), SUBSTR(VVD_INFO,19,5), SUBSTR(VVD_INFO,33,5), SUBSTR(VVD_INFO,47,5), " ).append("\n"); 
		query.append("                          SUBSTR(VVD_INFO,61,5), SUBSTR(VVD_INFO,75,5), SUBSTR(VVD_INFO,89,5), SUBSTR(VVD_INFO,103,5), " ).append("\n"); 
		query.append("                          SUBSTR(VVD_INFO,117,5),SUBSTR(VVD_INFO,131,5)) TS_POL" ).append("\n"); 
		query.append("  , DECODE(@[f_rlane_cd], SUBSTR(VVD_INFO,5,5), SUBSTR(VVD_INFO,24,5), SUBSTR(VVD_INFO,33,5), SUBSTR(VVD_INFO,52,5), " ).append("\n"); 
		query.append("                          SUBSTR(VVD_INFO,61,5), SUBSTR(VVD_INFO,80,5), SUBSTR(VVD_INFO,89,5), SUBSTR(VVD_INFO,108,5), " ).append("\n"); 
		query.append("                          SUBSTR(VVD_INFO,117,5),SUBSTR(VVD_INFO,136,5)) TS_POD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  , '' TS_PORT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,19,5) N1ST_POL_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,47,5) N2ND_POL_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,75,5) N3RD_POL_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,103,5) N4TH_POL_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,131,5) N5TH_POL_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,24,5) N1ST_POD_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,52,5) N2ND_POD_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,80,5) N3RD_POD_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,108,5) N4TH_POD_CD" ).append("\n"); 
		query.append("  , SUBSTR(VVD_INFO,136,5) N5TH_POD_CD	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,SC_NO  " ).append("\n"); 
		query.append("  ,RFA_NO" ).append("\n"); 
		query.append("  ,RFA_TP" ).append("\n"); 
		query.append("  ,NVOCC " ).append("\n"); 
		query.append("  ,CUST_TP  " ).append("\n"); 
		query.append("  ,SC_CUST_CD  " ).append("\n"); 
		query.append("  ,SC_CUST_NM" ).append("\n"); 
		query.append("  --,CUST_GRP_ID" ).append("\n"); 
		query.append("  --,CUST_GRP_NM" ).append("\n"); 
		query.append("  ,SHPR_CUST_ID -- SHIPPER" ).append("\n"); 
		query.append("  ,SHIPPER_NAME -- SHIPPER" ).append("\n"); 
		query.append("  ,AGMT_CUST_ID -- CONTRACT CUSTOMER" ).append("\n"); 
		query.append("  ,AGMT_NAME    -- CONTRACT CUSTOMER" ).append("\n"); 
		query.append("  ,ACT_CUST_ID" ).append("\n"); 
		query.append("  ,ACT_CUST_NM" ).append("\n"); 
		query.append("  ,SHPR_CD   " ).append("\n"); 
		query.append("  ,SHPR_NM   " ).append("\n"); 
		query.append("  ,BL_SHPR_NM" ).append("\n"); 
		query.append("  ,CNEE_CD  " ).append("\n"); 
		query.append("  ,CNEE_NM" ).append("\n"); 
		query.append("  ,NTFY_CD " ).append("\n"); 
		query.append("  ,NTFY_NM" ).append("\n"); 
		query.append("  ,PPD_CCT " ).append("\n"); 
		query.append("  ,BL_ONBOARD_DT  " ).append("\n"); 
		query.append("  ,CGO_RCV_DT  " ).append("\n"); 
		query.append("  ,SOC " ).append("\n"); 
		query.append("  ,REV_MT " ).append("\n"); 
		query.append("  ,DG " ).append("\n"); 
		query.append("  ,BB  " ).append("\n"); 
		query.append("  ,AK " ).append("\n"); 
		query.append("  ,WEIGHT " ).append("\n"); 
		query.append("  ,UNIT " ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,REV_$key" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  ,TOT_FR_REV_TPSZ " ).append("\n"); 
		query.append("  ,TOT_MISC_REV_TPSZ " ).append("\n"); 
		query.append("  ,TOT_REV_TPSZ " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,QTY_$key" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  ,TOT_QTY " ).append("\n"); 
		query.append("  ,FREIGTH_REV " ).append("\n"); 
		query.append("  ,MISC_REV " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O')" ).append("\n"); 
		query.append("    ,DMDT_COST " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,BASIC_STEVEDORAGE " ).append("\n"); 
		query.append("  ,OTHER_CY_EXPENSE " ).append("\n"); 
		query.append("  ,TS_STEVEDORAGE " ).append("\n"); 
		query.append("  ,ON_DOCK_CY_EXPENSE " ).append("\n"); 
		query.append("  ,CARGO_HANDLING_EXPENSE " ).append("\n"); 
		query.append("  ,STORAGE " ).append("\n"); 
		query.append("  ,MISC_CARGO_HANDLING_EXPENSE " ).append("\n"); 
		query.append("  ,EXCLUSIVE_TERMINAL_ADD_COST " ).append("\n"); 
		query.append("  ,CARGO_VARIABLE_VOLUME_DISCOUNT " ).append("\n"); 
		query.append("  ,RAIL_DIRECT " ).append("\n"); 
		query.append("  ,RAIL_TRUCK " ).append("\n"); 
		query.append("  ,TRUCK_DIRCET " ).append("\n"); 
		query.append("  ,WATER_DIRECT " ).append("\n"); 
		query.append("  ,WATER_RAIL " ).append("\n"); 
		query.append("  ,WATER_TRUCK " ).append("\n"); 
		query.append("  ,OTHER_TRANSPORT_EXPENSE " ).append("\n"); 
		query.append("  ,CARRIERS_HAULAGE_SVG_CHG" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  #if(${f_pro_vw} =='R')" ).append("\n"); 
		query.append("    ,INTERNAL_EQ_RENTAL_BASE " ).append("\n"); 
		query.append("    ,INTERNAL_EQ_RENTAL_MT_SIM " ).append("\n"); 
		query.append("  #elseif (${f_pro_vw} =='P')" ).append("\n"); 
		query.append("    ,EMPTH_TERMINAL_EXPENSE " ).append("\n"); 
		query.append("    ,EMPTY_TRANSPORT_EXPENSE " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  ,AGENT_COMMISSION " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='M') -- CM2  " ).append("\n"); 
		query.append("  ,CM_COST_TOTAL " ).append("\n"); 
		query.append("  ,CM " ).append("\n"); 
		query.append("  ,OWN_FDR_AMT" ).append("\n"); 
		query.append("  ,CM2_COST_TOTAL " ).append("\n"); 
		query.append("  ,CM2 " ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("  ,CM_COST_TOTAL " ).append("\n"); 
		query.append("  ,CM " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O' && ${f_pro_vw} =='R' )" ).append("\n"); 
		query.append("    ,US_DOMESTIC_SAV_CREDIT" ).append("\n"); 
		query.append("    ,CNTR_FX_AMT " ).append("\n"); 
		query.append("    ,CHSS_FX_AMT " ).append("\n"); 
		query.append("    ,ONW_VOL_ACTIVITY_COST " ).append("\n"); 
		query.append("    ,OTH_VOL_ACTIVITY_COST " ).append("\n"); 
		query.append("    ,INTERNAL_SLOT_RENTAL_BASE " ).append("\n"); 
		query.append("    ,OP_COST_TOTAL  " ).append("\n"); 
		query.append("    ,OP_TOTAL   " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O' && ${f_pro_vw} =='P' )" ).append("\n"); 
		query.append("    ,US_DOMESTIC_SAV_CREDIT" ).append("\n"); 
		query.append("    ,CNTR_LONG_TERM_EQ_RENTAL " ).append("\n"); 
		query.append("    ,CNTR_SHORT_TERM_EQ_RENTAL " ).append("\n"); 
		query.append("    ,CNTR_MR_CHARGE " ).append("\n"); 
		query.append("    ,CNTR_DEPRECIATION " ).append("\n"); 
		query.append("    ,CNTR_INSURANCE " ).append("\n"); 
		query.append("    ,CHASSIS_SHORT_TERM_EG_RENTAL " ).append("\n"); 
		query.append("    ,CHASSIS_LONG_TERM_EQ_RENTAL " ).append("\n"); 
		query.append("    ,SHASSIS_MR_CHARGE " ).append("\n"); 
		query.append("    ,CHASSIS_DEPRECIATION " ).append("\n"); 
		query.append("    ,CHASSIS_DRAYAGE " ).append("\n"); 
		query.append("    ,CHASSIS_INSURANCE " ).append("\n"); 
		query.append("    ,BUSINESS_ACTIVITY_COST " ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("FROM (	" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("   A2.COST_YRMON  " ).append("\n"); 
		query.append("  ,A2.SLS_YRMON  " ).append("\n"); 
		query.append("  ,A2.COST_WK  " ).append("\n"); 
		query.append("  ,A2.BKG_NO              AS BKG_NO  " ).append("\n"); 
		query.append("  ,NVL(CRB.FX_RT_FLG, 'N' ) AS FX_RT_FLG" ).append("\n"); 
		query.append("  ,DECODE(SUBSTR(A2.BL_NO, 1, 4), 'KOSA', 'K' || A2.BKG_NO, A2.BL_NO || A2.BL_NO_TP || A2.BL_NO_CHK) AS BL_NO  " ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("  ,V.COST_YRMON AS TS_YRMON" ).append("\n"); 
		query.append("  ,V.COST_WK AS TS_WK" ).append("\n"); 
		query.append("  ,V.TRD_CD AS TS_TRD_CD" ).append("\n"); 
		query.append("  ,V.RLANE_CD AS TS_RLANE_CD" ).append("\n"); 
		query.append("  ,V.DIR_CD AS TS_BND" ).append("\n"); 
		query.append("  ,V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD AS TS_VVD" ).append("\n"); 
		query.append("  ,COA_GET_CD_NM_FNC('CD03217',(SELECT HUL_BND_CD FROM COA_LANE_RGST" ).append("\n"); 
		query.append("	WHERE RLANE_CD = V.RLANE_CD" ).append("\n"); 
		query.append("		AND TRD_CD = V.TRD_CD" ).append("\n"); 
		query.append("		AND DIR_CD = V.DIR_CD" ).append("\n"); 
		query.append("		AND IOC_CD = V.IOC_CD" ).append("\n"); 
		query.append("   )) AS TS_TRD_DIR " ).append("\n"); 
		query.append("--  ,COA_GET_CD_NM_FNC('CD03217', R.HUL_BND_CD) AS TS_TRD_DIR" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  ,'' TS_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ,A2.TRD_CD  " ).append("\n"); 
		query.append("  ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("  ,A2.RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.IOC_CD  " ).append("\n"); 
		query.append("  ,A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD  AS R_VVD  " ).append("\n"); 
		query.append("  ,A2.DIR_CD" ).append("\n"); 
		query.append("  ,COA_GET_CD_NM_FNC('CD03217', R.HUL_BND_CD) AS HUL_BND_CD  " ).append("\n"); 
		query.append("  ,A2.CTRT_HQ_OFC_CD                        AS C_RHQ " ).append("\n"); 
		query.append("  ,A2.CTRT_RGN_OFC_CD                       AS C_AD " ).append("\n"); 
		query.append("  ,A2.CTRT_OFC_CD                           AS C_OFC " ).append("\n"); 
		query.append("  ,(SELECT OFC_N5TH_LVL_CD FROM COA_OFC_LVL" ).append("\n"); 
		query.append("	WHERE OFC_CD = A2.CTRT_OFC_CD" ).append("\n"); 
		query.append("		AND A2.COST_YRMON BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("	) AS C_RGN_OFC " ).append("\n"); 
		query.append("  ,A2.CTRT_SREP_CD                          AS CSREP_CD " ).append("\n"); 
		query.append("  ,A2.RHQ_CD                                AS L_RHQ " ).append("\n"); 
		query.append("  ,A2.RGN_OFC_CD                            AS L_AD " ).append("\n"); 
		query.append("  ,A2.SLS_OFC_CD                            AS L_OFC " ).append("\n"); 
		query.append("  ,(SELECT OFC_N5TH_LVL_CD FROM COA_OFC_LVL" ).append("\n"); 
		query.append("	WHERE OFC_CD = A2.SLS_OFC_CD" ).append("\n"); 
		query.append("		AND A2.COST_YRMON BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("	) AS L_RGN_OFC " ).append("\n"); 
		query.append("  ,A2.SREP_CD                               AS LREP_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_OFC_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_STS_CD  " ).append("\n"); 
		query.append("  ,A2.USA_BKG_MOD_CD                        AS USA_MODE" ).append("\n"); 
		query.append("  ,A2.TRNK_POL_CD" ).append("\n"); 
		query.append("  ,A2.TRNK_POD_CD " ).append("\n"); 
		query.append("  ,A2.BKG_POR_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_POL_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_POD_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_DEL_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_RCV_TERM_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_DE_TERM_CD              " ).append("\n"); 
		query.append("  , ( SELECT CSTMS_DESC" ).append("\n"); 
		query.append("        FROM BKG_BL_DOC" ).append("\n"); 
		query.append("       WHERE BKG_NO = A2.BKG_NO) CSTMS_DESC    " ).append("\n"); 
		query.append("  ,A2.REP_CMDT_CD  " ).append("\n"); 
		query.append("  ,A5.REP_CMDT_NM     " ).append("\n"); 
		query.append("  ,A2.CMDT_CD " ).append("\n"); 
		query.append("  ,A3.CMDT_NM  " ).append("\n"); 
		query.append("  ,R.IAS_RGN_CD " ).append("\n"); 
		query.append("  ,A2.N1ST_TRD_CD  " ).append("\n"); 
		query.append("  ,A2.N2ND_TRD_CD  " ).append("\n"); 
		query.append("  ,A2.N3RD_TRD_CD  " ).append("\n"); 
		query.append("  ,A2.N4TH_TRD_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_RLANE_CD " ).append("\n"); 
		query.append("  ,A2.N2ND_RLANE_CD " ).append("\n"); 
		query.append("  ,A2.N3RD_RLANE_CD " ).append("\n"); 
		query.append("  ,A2.N4TH_RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_FINC_VVD_CD " ).append("\n"); 
		query.append("  ,A2.N2ND_FINC_VVD_CD " ).append("\n"); 
		query.append("  ,A2.N3RD_FINC_VVD_CD " ).append("\n"); 
		query.append("  ,A2.N4TH_FINC_VVD_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_POL_CD " ).append("\n"); 
		query.append("  ,A2.N2ND_POL_CD " ).append("\n"); 
		query.append("  ,A2.N3RD_POL_CD " ).append("\n"); 
		query.append("  ,A2.N4TH_POL_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_POD_CD " ).append("\n"); 
		query.append("  ,A2.N2ND_POD_CD " ).append("\n"); 
		query.append("  ,A2.N3RD_POD_CD " ).append("\n"); 
		query.append("  ,A2.N4TH_POD_CD  " ).append("\n"); 
		query.append("  ,A2.SC_NO  " ).append("\n"); 
		query.append("  ,A2.RFA_NO  " ).append("\n"); 
		query.append("  ,(" ).append("\n"); 
		query.append("	SELECT (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03264' AND INTG_CD_VAL_CTNT = MN.RFA_CTRT_TP_CD) AS RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("	FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("		,COM_INTG_CD_DTL CUST_TP" ).append("\n"); 
		query.append("		,COM_INTG_CD_DTL STS" ).append("\n"); 
		query.append("		,PRI_RP_MN MN" ).append("\n"); 
		query.append("		,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("	WHERE MN.CTRT_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("	AND MN.CTRT_CUST_SEQ    = CUST.CUST_SEQ" ).append("\n"); 
		query.append("	AND CUST.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("	AND CNTR_DIV_FLG 		= 'Y' " ).append("\n"); 
		query.append("	AND MN.RFA_CTRT_TP_CD IN ('C','S')" ).append("\n"); 
		query.append("	AND CUST_TP.INTG_CD_ID  = 'CD00697'" ).append("\n"); 
		query.append("	AND CUST_TP.INTG_CD_VAL_CTNT    = CUST.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("	AND MN.PROP_STS_CD 		= STS.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("	AND STS.INTG_CD_ID 		= 'CD01722'" ).append("\n"); 
		query.append("	AND HDR.PROP_NO 	 	= MN.PROP_NO" ).append("\n"); 
		query.append("	AND MN.AMDT_SEQ = ( SELECT /*+ INDEX_DESC(A XPKPRI_RP_MN)*/ AMDT_SEQ FROM PRI_RP_MN A WHERE MN.PROP_NO = PROP_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("	AND HDR.RFA_NO = A2.RFA_NO" ).append("\n"); 
		query.append("	AND ROWNUM = 1" ).append("\n"); 
		query.append("  )RFA_TP" ).append("\n"); 
		query.append("  ,A2.CUST_TP_CD                                           AS NVOCC " ).append("\n"); 
		query.append("  ,A2.AGMT_CUST_TP_CD                                      AS CUST_TP  " ).append("\n"); 
		query.append("  ,A2.AGMT_CNT_CD || TO_CHAR(LPAD(DECODE(A2.AGMT_CUST_SEQ,0,'',A2.AGMT_CUST_SEQ),6,'0'))  AS SC_CUST_CD  " ).append("\n"); 
		query.append("  ,(   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.AGMT_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.AGMT_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  ) AS SC_CUST_NM" ).append("\n"); 
		query.append("  --,A2.CUST_GRP_ID" ).append("\n"); 
		query.append("  --,A2.CUST_GRP_NM " ).append("\n"); 
		query.append(" ,(SELECT NVL(B1.CUST_GRP_ID, A2.SHPR_CNT_CD||A2.SHPR_CUST_SEQ) FROM MDM_CUSTOMER B1		-- SHIPPER" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("			AND A2.SHPR_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("			AND A2.SHPR_CNT_CD = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("	) AS SHPR_CUST_ID" ).append("\n"); 
		query.append("  ,(SELECT NVL(B2.CUST_GRP_NM, B1.CUST_LGL_ENG_NM) FROM MDM_CUSTOMER B1, MDM_CUST_PERF_GRP B2		-- SHIPPER" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("			AND A2.SHPR_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("			AND A2.SHPR_CNT_CD = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("			AND B1.CUST_GRP_ID = B2.CUST_GRP_ID(+)" ).append("\n"); 
		query.append("	) AS SHIPPER_NAME" ).append("\n"); 
		query.append("  ,(SELECT NVL(B1.CUST_GRP_ID, A2.AGMT_CNT_CD||A2.AGMT_CUST_SEQ) FROM MDM_CUSTOMER B1		-- CONTRACT CUSTOMER" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("			AND A2.AGMT_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("			AND A2.AGMT_CNT_CD = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("	) AS AGMT_CUST_ID" ).append("\n"); 
		query.append("  ,(SELECT NVL(B2.CUST_GRP_NM, B1.CUST_LGL_ENG_NM) FROM MDM_CUSTOMER B1, MDM_CUST_PERF_GRP B2			-- CONTRACT CUSTOMER" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("			AND A2.AGMT_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("			AND A2.AGMT_CNT_CD = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("			AND B1.CUST_GRP_ID = B2.CUST_GRP_ID(+)" ).append("\n"); 
		query.append("	) AS AGMT_NAME" ).append("\n"); 
		query.append("  ,A2.AGMT_ACT_CNT_CD || TO_CHAR(LPAD(DECODE(A2.AGMT_ACT_CUST_SEQ,0,'',A2.AGMT_ACT_CUST_SEQ),6,'0')) AS ACT_CUST_ID" ).append("\n"); 
		query.append("  ,A2.ACT_CUST_NM AS ACT_CUST_NM " ).append("\n"); 
		query.append("  ,A2.SHPR_CNT_CD || TO_CHAR(LPAD(DECODE(A2.SHPR_CUST_SEQ,0,'',A2.SHPR_CUST_SEQ),6,'0'))      AS SHPR_CD   " ).append("\n"); 
		query.append("  ,(   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.SHPR_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.SHPR_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  ) AS SHPR_NM   " ).append("\n"); 
		query.append("  ,TRANSLATE(A2.SHPR_NM, CHR(29)||CHR(31)||CHR(30),' ')     AS BL_SHPR_NM  /* CHR(29)만 공백 나머지는 삭제 */" ).append("\n"); 
		query.append("  ,A2.CNEE_CNT_CD || TO_CHAR(LPAD(DECODE(A2.CNEE_CUST_SEQ,0,'',A2.CNEE_CUST_SEQ),6,'0')) AS CNEE_CD  " ).append("\n"); 
		query.append("  ,(   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.CNEE_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.CNEE_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  ) AS CNEE_NM  /*CNEE   */" ).append("\n"); 
		query.append("  ,A2.NTFY_CNT_CD || TO_CHAR(LPAD(DECODE(A2.NTFY_CUST_SEQ,0,'',A2.NTFY_CUST_SEQ),6,'0')) AS NTFY_CD " ).append("\n"); 
		query.append("  ,(   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.NTFY_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.NTFY_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  ) AS NTFY_NM   /*NTFY*/   " ).append("\n"); 
		query.append("  ,A2.OFT_TP_CD                                            AS PPD_CCT " ).append("\n"); 
		query.append("  ,TO_CHAR(A2.OBRD_DT,'YYYY-MM-DD')                        AS BL_ONBOARD_DT  " ).append("\n"); 
		query.append("  ,TO_CHAR(MAX(C.CGO_RCV_DT),'YYYY-MM-DD')                    AS CGO_RCV_DT  " ).append("\n"); 
		query.append("  ,A2.SOC_FLG                                              AS SOC " ).append("\n"); 
		query.append("  ,DECODE(A2.BKG_CGO_TP_CD, 'R', 'Y', 'N')                 AS REV_MT " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_DG_CGO_FLG, 'N')                            AS DG " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_BB_CGO_FLG, 'N')                            AS BB  " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_AWK_CGO_FLG, 'N')                           AS AK " ).append("\n"); 
		query.append("  ,TO_CHAR(A2.BKG_CGO_WGT)                                 AS WEIGHT " ).append("\n"); 
		query.append("  ,A2.BKG_WGT_TP_CD                                        AS UNIT " ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key',  A2.BKG_REV+A2.BKG_OFT_REV)))      AS REV_$key" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV))                                   AS TOT_FR_REV_TPSZ " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_MISC_REV+A2.SCR_CHG_REV))                              AS TOT_MISC_REV_TPSZ " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV))    AS TOT_REV_TPSZ " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key',  A2.BKG_QTY)))                     AS QTY_$key" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(DECODE(SUBSTR(A2.SPCL_CNTR_TPSZ_CD,-1),'2',A2.BKG_QTY, '3',A2.BKG_QTY, A2.BKG_QTY*2))) AS TOT_QTY " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV))                                   AS FREIGTH_REV " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_MISC_REV+A2.SCR_CHG_REV))                              AS MISC_REV " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O')" ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.DMDT_COM_AMT))                                             AS DMDT_COST " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BZC_STVG_COM_AMT))            AS BASIC_STEVEDORAGE " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OTR_CY_HNDL_COM_AMT))      AS OTHER_CY_EXPENSE " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.TS_STVG_COM_AMT))              AS TS_STEVEDORAGE " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.DCK_CY_HNDL_COM_AMT))      AS ON_DOCK_CY_EXPENSE " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.CGO_HNDL_COM_AMT))            AS CARGO_HANDLING_EXPENSE " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.FCNTR_STO_COM_AMT))          AS STORAGE " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.MISC_CGO_HNDL_COM_AMT))  AS MISC_CARGO_HANDLING_EXPENSE " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.TML_COM_AMT))                      AS EXCLUSIVE_TERMINAL_ADD_COST " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.CGO_VAR_VOL_DC_AMT))        AS CARGO_VARIABLE_VOLUME_DISCOUNT " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.FULL_RAIL_DIR_COM_AMT))  AS RAIL_DIRECT " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.FULL_RAIL_TRK_COM_AMT))  AS RAIL_TRUCK " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.FULL_TRK_DIR_COM_AMT))    AS TRUCK_DIRCET " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.FULL_WTR_DIR_COM_AMT))    AS WATER_DIRECT " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.FULL_WTR_RAIL_COM_AMT))  AS WATER_RAIL " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.FULL_WTR_TRK_COM_AMT))    AS WATER_TRUCK " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.FULL_TRSP_COM_AMT))          AS OTHER_TRANSPORT_EXPENSE " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.CRR_HLG_SVC_CHG_AMT))       AS CARRIERS_HAULAGE_SVG_CHG" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  #if(${f_pro_vw} =='R')" ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.INTER_EQ_RNTL_BSE_AMT))                                    AS INTERNAL_EQ_RENTAL_BASE " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.MTY_SIM_AMT))                                              AS INTERNAL_EQ_RENTAL_MT_SIM " ).append("\n"); 
		query.append("  #elseif (${f_pro_vw} =='P')" ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.MTY_STVG_PA_AMT))              AS EMPTH_TERMINAL_EXPENSE " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.MTY_TRSP_PA_AMT))              AS EMPTY_TRANSPORT_EXPENSE " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.AC_COM_AMT))                                               AS AGENT_COMMISSION " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='M') -- CM2  " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(DECODE(@[f_pro_vw],'P',A2.PA_CM_COST_TTL_AMT,'R',A2.RA_CM_COST_TTL_AMT)))   AS CM_COST_TOTAL " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV) " ).append("\n"); 
		query.append("    - SUM(DECODE(@[f_pro_vw],'P',A2.PA_CM_COST_TTL_AMT,'R',A2.RA_CM_COST_TTL_AMT)))       AS CM " ).append("\n"); 
		query.append("  ,TO_CHAR(NVL(SUM(A2.OWN_FDR_AMT),0))  AS OWN_FDR_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(DECODE(@[f_pro_vw],'P',(A2.PA_CM_COST_TTL_AMT + NVL(A2.OWN_FDR_AMT,0)),'R',(A2.RA_CM_COST_TTL_AMT + NVL(A2.OWN_FDR_AMT,0)))))   AS CM2_COST_TOTAL " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV) " ).append("\n"); 
		query.append("    - SUM(DECODE(@[f_pro_vw],'P',(A2.PA_CM_COST_TTL_AMT+NVL(A2.OWN_FDR_AMT,0)),'R',(A2.RA_CM_COST_TTL_AMT + NVL(A2.OWN_FDR_AMT,0) ))))       AS CM2 " ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(DECODE(@[f_pro_vw],'P',A2.PA_CM_COST_TTL_AMT,'R',A2.RA_CM_COST_TTL_AMT)))   AS CM_COST_TOTAL " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV) " ).append("\n"); 
		query.append("    - SUM(DECODE(@[f_pro_vw],'P',A2.PA_CM_COST_TTL_AMT,'R',A2.RA_CM_COST_TTL_AMT)))       AS CM " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O' && ${f_pro_vw} =='R' )" ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.USA_DMST_SAV_CR_AMT))       							   AS US_DOMESTIC_SAV_CREDIT" ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CNTR_FX_AMT))                                              AS CNTR_FX_AMT " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CHSS_FX_AMT))                                              AS CHSS_FX_AMT " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.OWN_VOL_ACT_AMT))                                          AS ONW_VOL_ACTIVITY_COST " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.OTR_VOL_ACT_AMT))                                          AS OTH_VOL_ACTIVITY_COST " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.OP_INTER_SLT_RNTL_BSE_AMT))                                AS INTERNAL_SLOT_RENTAL_BASE " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(NVL(A2.RA_OP_COST_TTL_AMT+A2.DMDT_COM_AMT, 0)))               AS OP_COST_TOTAL  " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV) - SUM(NVL(A2.RA_CM_COST_TTL_AMT,0)) - SUM(NVL(A2.RA_OP_COST_TTL_AMT, 0))  )   AS OP_TOTAL   " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O' && ${f_pro_vw} =='P' )" ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.USA_DMST_SAV_CR_AMT))       							   AS US_DOMESTIC_SAV_CREDIT" ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CNTR_LTERM_PA_AMT))                                        AS CNTR_LONG_TERM_EQ_RENTAL " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CNTR_STERM_PA_AMT))                                        AS CNTR_SHORT_TERM_EQ_RENTAL " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CNTR_MNR_CHG_PA_AMT))                                      AS CNTR_MR_CHARGE " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CNTR_DPC_PA_AMT))                                          AS CNTR_DEPRECIATION " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CNTR_INSUR_PA_AMT))                                        AS CNTR_INSURANCE " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CHSS_STERM_PA_AMT))                                        AS CHASSIS_SHORT_TERM_EG_RENTAL " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CHSS_LTERM_PA_AMT))                                        AS CHASSIS_LONG_TERM_EQ_RENTAL " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CHSS_MNR_CHG_PA_AMT))                                      AS SHASSIS_MR_CHARGE " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CHSS_DPC_PA_AMT))                                          AS CHASSIS_DEPRECIATION " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CHSS_DRYG_PA_AMT))                                         AS CHASSIS_DRAYAGE " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.CHSS_INSUR_PA_AMT))                                        AS CHASSIS_INSURANCE " ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.BIZ_ACT_PA_AMT))                                           AS BUSINESS_ACTIVITY_COST " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO' )" ).append("\n"); 
		query.append("  , V.TRD_CD||V.RLANE_CD||V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD AS MON_VVD" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("  , A2.TRD_CD||A2.RLANE_CD||A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD AS MON_VVD	" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,COA_PSG_TS_ARRAY_FNC(a2.n1st_trd_cd," ).append("\n"); 
		query.append("                              DECODE (COA_SLAN_CONTI_CONV_FNC(A2.n1st_finc_vvd_cd,substr(A2.N1ST_RLANE_CD,1,3),SUBSTR (A2.n1st_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,COA_SLAN_CONTI_CONV_FNC(A2.n1st_finc_vvd_cd,substr(A2.N1ST_RLANE_CD,1,3),SUBSTR (A2.n1st_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n1st_rlane_cd, SUBSTR (A2.n1st_finc_vvd_cd, 1, 9), A2.n1st_pol_cd, A2.n1st_pod_cd, --1" ).append("\n"); 
		query.append("                              a2.n2nd_trd_cd," ).append("\n"); 
		query.append("                              DECODE (COA_SLAN_CONTI_CONV_FNC(A2.n2nd_finc_vvd_cd,substr(A2.N2nd_RLANE_CD,1,3),SUBSTR (A2.n2nd_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,COA_SLAN_CONTI_CONV_FNC(A2.n2nd_finc_vvd_cd,substr(A2.n2nd_RLANE_CD,1,3),SUBSTR (A2.n2nd_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n2nd_rlane_cd, SUBSTR (A2.n2nd_finc_vvd_cd, 1, 9), A2.n2nd_pol_cd, A2.n2nd_pod_cd, --2" ).append("\n"); 
		query.append("                              a2.n3rd_trd_cd," ).append("\n"); 
		query.append("                              DECODE (COA_SLAN_CONTI_CONV_FNC(A2.n3rd_finc_vvd_cd,substr(A2.n3rd_RLANE_CD,1,3),SUBSTR (A2.n3rd_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,COA_SLAN_CONTI_CONV_FNC(A2.n3rd_finc_vvd_cd,substr(A2.n3rd_RLANE_CD,1,3),SUBSTR (A2.n3rd_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n3rd_rlane_cd, SUBSTR (A2.n3rd_finc_vvd_cd, 1, 9), A2.n3rd_pol_cd, A2.n3rd_pod_cd, --3" ).append("\n"); 
		query.append("                              a2.n4th_trd_cd," ).append("\n"); 
		query.append("                              DECODE (COA_SLAN_CONTI_CONV_FNC(A2.n4th_finc_vvd_cd,substr(A2.n4th_RLANE_CD,1,3),SUBSTR (A2.n4th_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,COA_SLAN_CONTI_CONV_FNC(A2.n4th_finc_vvd_cd,substr(A2.n4th_RLANE_CD,1,3),SUBSTR (A2.n4th_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n4th_rlane_cd, SUBSTR (A2.n4th_finc_vvd_cd, 1, 9), A2.n4th_pol_cd, A2.n4th_pod_cd --4" ).append("\n"); 
		query.append("                             ) vvd_info" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("   #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("    COA_BKG_EXPN_DTL A2" ).append("\n"); 
		query.append("   #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("    COA_BKG_EXPN_DTL_WK A2 " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("   , COA_MON_VVD V, BKG_VVD B" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   , COA_RGST_BKG CRB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,COA_OFC_LVL A4 " ).append("\n"); 
		query.append("  ,MDM_COMMODITY A3    " ).append("\n"); 
		query.append("  ,MDM_REP_CMDT A5" ).append("\n"); 
		query.append("  ,COA_LANE_RGST R" ).append("\n"); 
		query.append("  ,( SELECT BKG_NO, MAX(CGO_RCV_DT) AS CGO_RCV_DT  " ).append("\n"); 
		query.append("                FROM BKG_CONTAINER GROUP BY BKG_NO ) C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  #if(${f_include_ts} =='Y' && ${f_chkprd} =='M' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("    AND V.COST_YRMON  = @[f_year]||@[f_mon]" ).append("\n"); 
		query.append("    AND A2.COST_YRMON  BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("    AND NVL(V.delt_flg,'N')   = 'N'" ).append("\n"); 
		query.append("    AND V.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("    AND V.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND V.DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND B.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("  #elseif(${f_include_ts} =='Y' && ${f_chkprd} =='W' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("    AND SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("    AND NVL(V.delt_flg,'N')   = 'N'" ).append("\n"); 
		query.append("    AND V.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("    AND V.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND V.DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND B.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("   #if(${f_sls_mon} !='')" ).append("\n"); 
		query.append("    	AND V.SLS_YRMON = @[f_year]||@[f_sls_mon]    " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("   AND A2.SLS_YRMON     BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("  #elseif((${f_include_ts} !='Y' && ${f_chkprd} =='M') || (${f_include_ts} =='Y' && ${f_chkprd} =='M' && ${f_rlane_cd} == 'RBCCO'))    " ).append("\n"); 
		query.append("    AND A2.COST_YRMON  = @[f_year]||@[f_mon] " ).append("\n"); 
		query.append("    AND A2.COST_YRMON  BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("  #elseif ((${f_include_ts} !='Y' && ${f_chkprd} =='W') || (${f_include_ts} =='Y' && ${f_chkprd} =='W' && ${f_rlane_cd} == 'RBCCO'))  " ).append("\n"); 
		query.append("	AND SUBSTR(A2.SLS_YRMON,1,4)||A2.COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("    	  " ).append("\n"); 
		query.append("    #if(${f_sls_mon} !='')" ).append("\n"); 
		query.append("    	AND A2.SLS_YRMON = @[f_year]||@[f_sls_mon]    " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND A2.SLS_YRMON     BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND CRB.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_fixed_rate} == 'Y')" ).append("\n"); 
		query.append("	AND CRB.FX_RT_FLG = 'Y'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_ofc_vw} =='C')	" ).append("\n"); 
		query.append("	AND A2.AGMT_SGN_OFC_CD = A4.OFC_CD" ).append("\n"); 
		query.append("  #elseif (${f_ofc_vw} =='L')	" ).append("\n"); 
		query.append("	AND A2.SLS_OFC_CD = A4.OFC_CD" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("	AND 1 = 0" ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  AND A2.CMDT_CD       = A3.CMDT_CD(+)  " ).append("\n"); 
		query.append("  AND A2.REP_CMDT_CD   = A5.REP_CMDT_CD(+) " ).append("\n"); 
		query.append("  AND NVL(A2.DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("  AND A2.BKG_STS_CD    IN ('F','S',DECODE(@[f_bkg_sts],'Y', 'W')) " ).append("\n"); 
		query.append("  AND A2.BKG_CGO_TP_CD <> 'P' " ).append("\n"); 
		query.append("  AND A2.BL_NO_TP      IN ('M','0')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND A2.RLANE_CD = R.RLANE_CD" ).append("\n"); 
		query.append("  AND A2.DIR_CD = R.DIR_CD" ).append("\n"); 
		query.append("  AND A2.IOC_CD = R.IOC_CD" ).append("\n"); 
		query.append("  AND A2.TRD_CD = R.TRD_CD" ).append("\n"); 
		query.append("  AND R.DELT_FLG = 'N' 	  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND A2.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_ofc_cd} !='')" ).append("\n"); 
		query.append("    #if(${f_excl_sts} =='')" ).append("\n"); 
		query.append("      AND DECODE(@[f_ofc_lvl],'1',A4.OFC_N1ST_LVL_CD,'2',A4.OFC_N2ND_LVL_CD,'3',A4.OFC_N3RD_LVL_CD,'4',A4.OFC_N4TH_LVL_CD,'5',A4.OFC_N5TH_LVL_CD,'6',A4.OFC_N6TH_LVL_CD,'7',A4.OFC_N7TH_LVL_CD) = @[f_ofc_cd] " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("      AND A4.OFC_CD = @[f_ofc_cd] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_ofc_lvl}=='6' || ${f_ofc_lvl}=='7')" ).append("\n"); 
		query.append("    AND A4.OFC_LVL = @[f_ofc_lvl]" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    AND A4.OFC_LVL < '9'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_include_ts} == 'Y' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("  #if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("    AND V.VSL_CD  = @[f_vsl_cd] " ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("  #if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("    AND V.SKD_VOY_NO     = @[f_skd_voy_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("    AND V.DIR_CD         = @[f_skd_dir_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_trd_cd} !='')" ).append("\n"); 
		query.append("    AND V.TRD_CD         = @[f_trd_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("    AND V.RLANE_CD       = @[f_rlane_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_ioc_cd} !='')" ).append("\n"); 
		query.append("    AND V.IOC_CD         = @[f_ioc_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("    AND V.DIR_CD         = @[f_dir_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#elseif(${f_include_ts} == 'Y' && ${f_rlane_cd} == 'RBCCO')" ).append("\n"); 
		query.append("	#if(${f_trd_cd} !='' && ${f_rlane_cd} !='')" ).append("\n"); 
		query.append("    AND @[f_trd_cd]||@[f_rlane_cd] IN (A2.N1ST_TRD_CD||A2.N1ST_RLANE_CD, A2.N2ND_TRD_CD||A2.N2ND_RLANE_CD, A2.N3RD_TRD_CD||A2.N3RD_RLANE_CD, A2.N4TH_TRD_CD||A2.N4TH_RLANE_CD)" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  #if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("    AND A2.VSL_CD  = @[f_vsl_cd] " ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("  #if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("    AND A2.SKD_VOY_NO     = @[f_skd_voy_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("    AND A2.DIR_CD         = @[f_skd_dir_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_trd_cd} !='')" ).append("\n"); 
		query.append("    AND A2.TRD_CD         = @[f_trd_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("    AND A2.RLANE_CD       = @[f_rlane_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_ioc_cd} !='')" ).append("\n"); 
		query.append("    AND A2.IOC_CD         = @[f_ioc_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("    AND A2.DIR_CD         = @[f_dir_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_bkg_por_cd} !='')" ).append("\n"); 
		query.append("    AND A2.BKG_POR_CD     LIKE @[f_bkg_por_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rev_pol_cd} !='')" ).append("\n"); 
		query.append("    AND A2.REV_POL_CD     LIKE @[f_rev_pol_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rev_pod_cd} !='')" ).append("\n"); 
		query.append("    AND A2.REV_POD_CD     LIKE @[f_rev_pod_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_bkg_del_cd} !='')" ).append("\n"); 
		query.append("    AND A2.BKG_DEL_CD     LIKE @[f_bkg_del_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_shpr_cd} !='')" ).append("\n"); 
		query.append("    AND A2.SHPR_CNT_CD||A2.SHPR_CUST_SEQ = @[f_shpr_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_sc_no} !='')" ).append("\n"); 
		query.append("    AND A2.SC_NO          = @[f_sc_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rfa_no} !='')" ).append("\n"); 
		query.append("    AND A2.RFA_NO         = @[f_rfa_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_taa_no} !='')" ).append("\n"); 
		query.append("    AND A2.TAA_NO         = @[f_taa_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rep_cmdt_cd} !='')" ).append("\n"); 
		query.append("    AND A2.REP_CMDT_CD    = @[f_rep_cmdt_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_usa_bkg_mod_cd} !='')" ).append("\n"); 
		query.append("    AND A2.USA_BKG_MOD_CD = @[f_usa_bkg_mod_cd] " ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_cntr_tpsz_cd} !='')" ).append("\n"); 
		query.append("    AND A2.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_hul_bnd_cd} !='')" ).append("\n"); 
		query.append("	AND R.HUL_BND_CD = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("   A2.COST_YRMON " ).append("\n"); 
		query.append("  ,A2.SLS_YRMON  " ).append("\n"); 
		query.append("  ,A2.COST_WK " ).append("\n"); 
		query.append("  ,A2.BKG_NO " ).append("\n"); 
		query.append("  ,CRB.FX_RT_FLG" ).append("\n"); 
		query.append("  ,DECODE(SUBSTR(A2.BL_NO, 1, 4), 'KOSA', 'K' || A2.BKG_NO, A2.BL_NO || A2.BL_NO_TP || A2.BL_NO_CHK)   " ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO')	" ).append("\n"); 
		query.append("  ,V.COST_YRMON" ).append("\n"); 
		query.append("  ,V.COST_WK" ).append("\n"); 
		query.append("  ,V.TRD_CD" ).append("\n"); 
		query.append("  ,V.RLANE_CD" ).append("\n"); 
		query.append("  ,V.DIR_CD" ).append("\n"); 
		query.append("  ,V.VSL_CD" ).append("\n"); 
		query.append("  ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("  ,V.IOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ,A2.TRD_CD  " ).append("\n"); 
		query.append("  ,A2.SUB_TRD_CD " ).append("\n"); 
		query.append("  ,A2.RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.IOC_CD  " ).append("\n"); 
		query.append("  ,A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD  " ).append("\n"); 
		query.append("  ,A2.DIR_CD" ).append("\n"); 
		query.append("  ,COA_GET_CD_NM_FNC('CD03217', R.HUL_BND_CD)" ).append("\n"); 
		query.append("  ,A2.CTRT_HQ_OFC_CD  " ).append("\n"); 
		query.append("  ,A2.CTRT_RGN_OFC_CD  " ).append("\n"); 
		query.append("  ,A2.CTRT_OFC_CD " ).append("\n"); 
		query.append("  ,A2.CTRT_SREP_CD  " ).append("\n"); 
		query.append("  ,A2.RHQ_CD  " ).append("\n"); 
		query.append("  ,A2.RGN_OFC_CD  " ).append("\n"); 
		query.append("  ,A2.SLS_OFC_CD  " ).append("\n"); 
		query.append("  ,A2.SREP_CD " ).append("\n"); 
		query.append("  ,A2.BKG_OFC_CD   " ).append("\n"); 
		query.append("  ,A2.BKG_STS_CD   " ).append("\n"); 
		query.append("  ,A2.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("  ,A2.TRNK_POL_CD" ).append("\n"); 
		query.append("  ,A2.TRNK_POD_CD " ).append("\n"); 
		query.append("  ,A2.BKG_POR_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_POL_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_POD_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_DEL_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_RCV_TERM_CD  " ).append("\n"); 
		query.append("  ,A2.BKG_DE_TERM_CD  " ).append("\n"); 
		query.append("  ,A2.REP_CMDT_CD /*4400*/  " ).append("\n"); 
		query.append("  ,A5.REP_CMDT_NM  " ).append("\n"); 
		query.append("  ,A2.CMDT_CD /*440906  */" ).append("\n"); 
		query.append("  ,A3.CMDT_NM  " ).append("\n"); 
		query.append("  ,R.IAS_RGN_CD " ).append("\n"); 
		query.append("  ,A2.N1ST_TRD_CD   " ).append("\n"); 
		query.append("  ,A2.N2ND_TRD_CD   " ).append("\n"); 
		query.append("  ,A2.N3RD_TRD_CD   " ).append("\n"); 
		query.append("  ,A2.N4TH_TRD_CD   " ).append("\n"); 
		query.append("  ,A2.N1ST_RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.N2ND_RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.N3RD_RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.N4TH_RLANE_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_FINC_VVD_CD  " ).append("\n"); 
		query.append("  ,A2.N2ND_FINC_VVD_CD  " ).append("\n"); 
		query.append("  ,A2.N3RD_FINC_VVD_CD  " ).append("\n"); 
		query.append("  ,A2.N4TH_FINC_VVD_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_POL_CD  " ).append("\n"); 
		query.append("  ,A2.N2ND_POL_CD  " ).append("\n"); 
		query.append("  ,A2.N3RD_POL_CD  " ).append("\n"); 
		query.append("  ,A2.N4TH_POL_CD  " ).append("\n"); 
		query.append("  ,A2.N1ST_POD_CD  " ).append("\n"); 
		query.append("  ,A2.N2ND_POD_CD  " ).append("\n"); 
		query.append("  ,A2.N3RD_POD_CD  " ).append("\n"); 
		query.append("  ,A2.N4TH_POD_CD   " ).append("\n"); 
		query.append("  ,A2.SC_NO " ).append("\n"); 
		query.append("  ,A2.RFA_NO " ).append("\n"); 
		query.append("  ,A2.CUST_TP_CD  " ).append("\n"); 
		query.append("  ,A2.AGMT_CUST_TP_CD  " ).append("\n"); 
		query.append("  ,A2.AGMT_CNT_CD || TO_CHAR(LPAD(DECODE(A2.AGMT_CUST_SEQ,0,'',A2.AGMT_CUST_SEQ),6,'0'))   /* SC_CUSTOMER CD*/  " ).append("\n"); 
		query.append("  ,A2.AGMT_CNT_CD   " ).append("\n"); 
		query.append("  ,A2.AGMT_CUST_SEQ   " ).append("\n"); 
		query.append("  ,A2.CUST_GRP_ID" ).append("\n"); 
		query.append("  --,A2.CUST_GRP_NM " ).append("\n"); 
		query.append("  ,A2.AGMT_CUST_SEQ -- C.CUSTOMER" ).append("\n"); 
		query.append("  ,A2.AGMT_CNT_CD   -- C.CUSTOMER  " ).append("\n"); 
		query.append("  ,A2.AGMT_ACT_CNT_CD || TO_CHAR(LPAD(DECODE(A2.AGMT_ACT_CUST_SEQ,0,'',A2.AGMT_ACT_CUST_SEQ),6,'0')) /*ACT_CUSTOMER_CD */" ).append("\n"); 
		query.append("  ,A2.ACT_CUST_NM" ).append("\n"); 
		query.append("  ,A2.SHPR_CNT_CD || TO_CHAR(LPAD(DECODE(A2.SHPR_CUST_SEQ,0,'',A2.SHPR_CUST_SEQ),6,'0')) /* SHPR_CD*/" ).append("\n"); 
		query.append("  ,A2.SHPR_CNT_CD   " ).append("\n"); 
		query.append("  ,A2.SHPR_CUST_SEQ   " ).append("\n"); 
		query.append("  ,A2.SHPR_NM /* BL_SHPR_NM*/ " ).append("\n"); 
		query.append("  ,A2.CNEE_CNT_CD || TO_CHAR(LPAD(DECODE(A2.CNEE_CUST_SEQ,0,'',A2.CNEE_CUST_SEQ),6,'0')) /* CNEE_CD*/" ).append("\n"); 
		query.append("  ,A2.CNEE_CNT_CD   " ).append("\n"); 
		query.append("  ,A2.CNEE_CUST_SEQ  " ).append("\n"); 
		query.append("  ,A2.NTFY_CNT_CD || TO_CHAR(LPAD(DECODE(A2.NTFY_CUST_SEQ,0,'',A2.NTFY_CUST_SEQ),6,'0')) /* NTFY_CD */" ).append("\n"); 
		query.append("  ,A2.NTFY_CNT_CD   " ).append("\n"); 
		query.append("  ,A2.NTFY_CUST_SEQ   " ).append("\n"); 
		query.append("  ,A2.OFT_TP_CD  /* PPD_CCT*/" ).append("\n"); 
		query.append("  ,TO_CHAR(A2.OBRD_DT,'YYYY-MM-DD') /*BL_ONBOARD_DT */" ).append("\n"); 
		query.append("  ,TO_CHAR(C.CGO_RCV_DT,'YYYY-MM-DD') /*CGO_RCV_DT */" ).append("\n"); 
		query.append("  ,A2.SOC_FLG  " ).append("\n"); 
		query.append("  ,DECODE(A2.BKG_CGO_TP_CD, 'R', 'Y', 'N')  " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_DG_CGO_FLG, 'N') " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_BB_CGO_FLG, 'N') " ).append("\n"); 
		query.append("  ,NVL(A2.SPCL_AWK_CGO_FLG, 'N')  " ).append("\n"); 
		query.append("  ,TO_CHAR(A2.BKG_CGO_WGT) " ).append("\n"); 
		query.append("  ,A2.BKG_WGT_TP_CD" ).append("\n"); 
		query.append("  #if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO' )" ).append("\n"); 
		query.append("  , V.TRD_CD||V.RLANE_CD||V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("  , A2.TRD_CD||A2.RLANE_CD||A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  ,COA_PSG_TS_ARRAY_FNC(a2.n1st_trd_cd," ).append("\n"); 
		query.append("                              DECODE (COA_SLAN_CONTI_CONV_FNC(A2.n1st_finc_vvd_cd,substr(A2.N1ST_RLANE_CD,1,3),SUBSTR (A2.n1st_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,COA_SLAN_CONTI_CONV_FNC(A2.n1st_finc_vvd_cd,substr(A2.N1ST_RLANE_CD,1,3),SUBSTR (A2.n1st_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n1st_rlane_cd, SUBSTR (A2.n1st_finc_vvd_cd, 1, 9), A2.n1st_pol_cd, A2.n1st_pod_cd, --1" ).append("\n"); 
		query.append("                              a2.n2nd_trd_cd," ).append("\n"); 
		query.append("                              DECODE (COA_SLAN_CONTI_CONV_FNC(A2.n2nd_finc_vvd_cd,substr(A2.N2nd_RLANE_CD,1,3),SUBSTR (A2.n2nd_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,COA_SLAN_CONTI_CONV_FNC(A2.n2nd_finc_vvd_cd,substr(A2.n2nd_RLANE_CD,1,3),SUBSTR (A2.n2nd_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n2nd_rlane_cd, SUBSTR (A2.n2nd_finc_vvd_cd, 1, 9), A2.n2nd_pol_cd, A2.n2nd_pod_cd, --2" ).append("\n"); 
		query.append("                              a2.n3rd_trd_cd," ).append("\n"); 
		query.append("                              DECODE (COA_SLAN_CONTI_CONV_FNC(A2.n3rd_finc_vvd_cd,substr(A2.n3rd_RLANE_CD,1,3),SUBSTR (A2.n3rd_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,COA_SLAN_CONTI_CONV_FNC(A2.n3rd_finc_vvd_cd,substr(A2.n3rd_RLANE_CD,1,3),SUBSTR (A2.n3rd_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n3rd_rlane_cd, SUBSTR (A2.n3rd_finc_vvd_cd, 1, 9), A2.n3rd_pol_cd, A2.n3rd_pod_cd, --3" ).append("\n"); 
		query.append("                              a2.n4th_trd_cd," ).append("\n"); 
		query.append("                              DECODE (COA_SLAN_CONTI_CONV_FNC(A2.n4th_finc_vvd_cd,substr(A2.n4th_RLANE_CD,1,3),SUBSTR (A2.n4th_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,COA_SLAN_CONTI_CONV_FNC(A2.n4th_finc_vvd_cd,substr(A2.n4th_RLANE_CD,1,3),SUBSTR (A2.n4th_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n4th_rlane_cd, SUBSTR (A2.n4th_finc_vvd_cd, 1, 9), A2.n4th_pol_cd, A2.n4th_pod_cd --4" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("  ,A4.OFC_APLY_FM_YRMON" ).append("\n"); 
		query.append("  ,A4.OFC_APLY_TO_YRMON         " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y')" ).append("\n"); 
		query.append("  AND @[f_trd_cd]||@[f_rlane_cd] IN ((SUBSTR(VVD_INFO,1,3)||SUBSTR(VVD_INFO,5,5)), (SUBSTR(VVD_INFO,29,3)||SUBSTR(VVD_INFO,33,5)), (SUBSTR(VVD_INFO,57,3)||SUBSTR(VVD_INFO,61,5)), (SUBSTR(VVD_INFO,85,3)||SUBSTR(VVD_INFO,89,5)), (SUBSTR(VVD_INFO,113,3)||SUBSTR(VVD_INFO,117,5)))" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}