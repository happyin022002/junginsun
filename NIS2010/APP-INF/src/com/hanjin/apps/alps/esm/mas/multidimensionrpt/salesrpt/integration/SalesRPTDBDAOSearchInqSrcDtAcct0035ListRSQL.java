/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : SalesRPTDBDAOSearchInqSrcDtAcct0035ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.31
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * 2012.07.18 [CHM-201219034] 이석준 [MAS] Inquiry by source data 계정 추가
	  * 2014.01.16 [CHM-201428540] 김수정 [MAS] Inquiry by Source Data 정보 추가 요청
	  * 2014.06.03 [CHM-201430312] 최덕우 [MAS] G.Customer Display 관련 일부 화면 로직 보완 수정
	  * 2015.03.20 [CHM-201534153] 김시몬 CM/OP계정 추가 및 변경에 따라 보완
	  * 2015.04.22 [CHM-201534153] 김시몬 OWNWAY SAVING 추가
	  * 2015.05.18 [CHM-201534153] 김시몬 데이터 모델에 따른 컬럼명 변경
	  * 2015.05.27 [CHM-201533978] 이윤정 COA 기능 추가 요청 CSR - RFA Type 추가
	  * 2015.05.14 [CHM-201535771] 손진환 [MAS] MAS RCV DT를 부킹 모듈 상에서 OC Status 발생 date를 바로 바라볼 수 있도록 로직 수정
	  * 2015.05.14 [CHM-201535424] 손진환 [MAS] MAS 상 Fixed Rate 반영
	  * 2015.05.21 [CHM-201536029] 손진환 [MAS] MAS 상 Fixed Rate 반영 요청 CSR
	  * 2015.07.06 [] 김시몬 CM Cost Total에서 DEMDET, MIS REV 제외
	  * 2015.07.20 [CHM-201536959] 손진환 [MAS] Inquiry by Source Data에서 Sub Trade 구분자 삽입 요청 CSR
	  * 2015.09.07 [CHM-201537826] 최덕우 ALPS MAS T.POL/T.POD 로직 수정 요청
	  * 2017.05.04 [CSR-688] 김동호 Customer Name 부분 Hex Code C2A0 Replace
	  * 2017.06.01 [CSR #1026] 김동호 CM(BKG) Total 추가
	  * 2017.08.03 [CSR #1531] 김동호 신규 장비비 계정으로 통합
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
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rev_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_taa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bkg_del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_usa_bkg_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rev_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bkg_por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_sts",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
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
		query.append(" SELECT 'R.MONTH'       AS COST_YRMON" ).append("\n"); 
		query.append("        , 'S.MONTH'     AS SLS_YRMON" ).append("\n"); 
		query.append("        , 'WEEK'        AS COST_WK" ).append("\n"); 
		query.append("        , 'BKG NO'      AS BKG_NO" ).append("\n"); 
		query.append("		, 'F_Index'  FX_RT_FLG" ).append("\n"); 
		query.append("        , 'BL NO'       AS BL_NO" ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("    	, 'TS MON'      AS TS_MON" ).append("\n"); 
		query.append("        , 'TS WEEK'     AS TS_WK" ).append("\n"); 
		query.append("    	, 'TS TRADE'    AS TS_TRD_CD" ).append("\n"); 
		query.append("    	, 'TS LANE'     AS TS_RLANE_CD" ).append("\n"); 
		query.append("        , 'T/S BND'     AS TS_BND" ).append("\n"); 
		query.append("        , 'T/S VVD'     AS TS_VVD" ).append("\n"); 
		query.append("    	, 'T/S TRADE DIR.'  AS TS_TRD_DIR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , 'TRADE'      AS TRD_CD" ).append("\n"); 
		query.append("        , 'SUB TRADE'  AS SUB_TRD_CD" ).append("\n"); 
		query.append("        , 'R.LANE'     AS RLANE_CD" ).append("\n"); 
		query.append("        , 'IOC'        AS IOC_CD" ).append("\n"); 
		query.append("        , 'REV VVD'    AS R_VVD" ).append("\n"); 
		query.append("        , 'STATUS'     AS STATUS" ).append("\n"); 
		query.append("        , 'DIR'        AS DIR_CD" ).append("\n"); 
		query.append("    	, 'Trade Dir.' AS HUL_BND_CD" ).append("\n"); 
		query.append("        , 'C.RHQ'      AS C_RHQ" ).append("\n"); 
		query.append("        , 'C.AD'       AS C_AD " ).append("\n"); 
		query.append("        , 'C.OFC'      AS C_OFC" ).append("\n"); 
		query.append("        , 'C.Region OFC' AS C_RGN_OFC" ).append("\n"); 
		query.append("        , 'C.S.REP'      AS CSREP_CD" ).append("\n"); 
		query.append("        , 'L.RHQ'        AS L_RHQ" ).append("\n"); 
		query.append("        , 'L.AD'         AS L_AD" ).append("\n"); 
		query.append("        , 'L.OFC'        AS L_OFC" ).append("\n"); 
		query.append("        , 'L.Region OFC'   AS L_RGN_OFC" ).append("\n"); 
		query.append("        , 'L.REP'      AS LREP_CD" ).append("\n"); 
		query.append("        , 'BKG OFC'    AS BKG_OFC_CD" ).append("\n"); 
		query.append("        , 'BKG STS'    AS BKG_STS_CD" ).append("\n"); 
		query.append("        , 'USA MODE'   AS USA_MODE" ).append("\n"); 
		query.append("    	, 'TRUNK POL'  AS TRNK_POL" ).append("\n"); 
		query.append("    	, 'TRUNK POD'  AS TRNK_POD" ).append("\n"); 
		query.append("        , 'BKG POR'    AS BKG_POR_CD" ).append("\n"); 
		query.append("        , 'BKG POL'    AS BKG_POL_CD" ).append("\n"); 
		query.append("        , 'BKG POD'    AS BKG_POD_CD" ).append("\n"); 
		query.append("        , 'BKG DEL'    AS BKG_DEL_CD" ).append("\n"); 
		query.append("        , 'RCV TERM'   AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("        , 'DEL TERM'   AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append("        , 'Customs Desc'  AS CSTMS_DESC" ).append("\n"); 
		query.append("        , 'REP CMDT CD'   AS REP_CMDT_CD" ).append("\n"); 
		query.append("        , 'REP CMDT DESC' AS REP_CMDT_NM" ).append("\n"); 
		query.append("        , 'CMDT CD'       AS CMDT_CD" ).append("\n"); 
		query.append("        , 'CMDT DESC'     AS CMDT_NM" ).append("\n"); 
		query.append("        , 'IAS REGION'    AS IAS_RGN_CD" ).append("\n"); 
		query.append("        , 'TRADE1'   AS N1ST_TRD_CD" ).append("\n"); 
		query.append("        , 'TRADE2'   AS N2ND_TRD_CD" ).append("\n"); 
		query.append("        , 'TRADE3'   AS N3RD_TRD_CD" ).append("\n"); 
		query.append("        , 'TRADE4'   AS N4TH_TRD_CD" ).append("\n"); 
		query.append("        , 'TRADE5'   AS N5TH_TRD_CD" ).append("\n"); 
		query.append("        , 'LANE1'    AS N1ST_RLANE_CD" ).append("\n"); 
		query.append("        , 'LANE2'    AS N2ND_RLANE_CD" ).append("\n"); 
		query.append("        , 'LANE3'    AS N3RD_RLANE_CD" ).append("\n"); 
		query.append("        , 'LANE4'    AS N4TH_RLANE_CD" ).append("\n"); 
		query.append("        , 'LANE5'    AS N5TH_RLANE_CD" ).append("\n"); 
		query.append("        , 'VVD1'     AS N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("        , 'VVD2'     AS N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("        , 'VVD3'     AS N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("        , 'VVD4'     AS N4TH_FINC_VVD_CD" ).append("\n"); 
		query.append("        , 'VVD5'     AS N5TH_FINC_VVD_CD" ).append("\n"); 
		query.append("    	, 'T/S PORT'  AS TS_PORT" ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y')" ).append("\n"); 
		query.append("        , 'T/S POL'   AS TS_POL" ).append("\n"); 
		query.append("        , 'T/S POD'   AS TS_POD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , 'POL1'    AS N1ST_POL_CD" ).append("\n"); 
		query.append("        , 'POL2'    AS N2ND_POL_CD" ).append("\n"); 
		query.append("        , 'POL3'    AS N3RD_POL_CD" ).append("\n"); 
		query.append("        , 'POL4'    AS N4TH_POL_CD" ).append("\n"); 
		query.append("        , 'POL5'    AS N5TH_POL_CD" ).append("\n"); 
		query.append("        , 'POD1'    AS N1ST_POD_CD" ).append("\n"); 
		query.append("        , 'POD2'    AS N2ND_POD_CD" ).append("\n"); 
		query.append("        , 'POD3'    AS N3RD_POD_CD" ).append("\n"); 
		query.append("        , 'POD4'    AS N4TH_POD_CD" ).append("\n"); 
		query.append("        , 'POD5'    AS N5TH_POD_CD" ).append("\n"); 
		query.append("        , 'SC NO'   AS SC_NO" ).append("\n"); 
		query.append("        , 'RFA NO'  AS RFA_NO" ).append("\n"); 
		query.append("        , 'RFA TYPE'AS RFA_TP" ).append("\n"); 
		query.append("        , 'Source'  AS MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("        , 'NVOCC'   AS NVOCC" ).append("\n"); 
		query.append("        , 'CUST TP' AS CUST_TP" ).append("\n"); 
		query.append("        , 'SC/RFC CUST CD'   AS SC_CUST_CD" ).append("\n"); 
		query.append("        , 'SC/RFC CUST NM'   AS SC_CUST_NM" ).append("\n"); 
		query.append("    	, 'G/Customer Code(Shipper)'  AS SHPR_CUST_ID" ).append("\n"); 
		query.append("    	, 'G/Customer Name(Shipper)'  AS SHIPPER_NAME" ).append("\n"); 
		query.append("        , 'G/Customer Type(C.Customer)'  AS AGMT_CUST_TP_CD" ).append("\n"); 
		query.append("        , 'G/Customer Code(C.Customer)'  AS AGMT_CUST_ID" ).append("\n"); 
		query.append("    	, 'G/Customer Name(C.Customer)'  AS AGMT_NAME" ).append("\n"); 
		query.append("    	, 'A/Customer Code'  AS ACT_CUST_ID" ).append("\n"); 
		query.append("    	, 'A/Customer Name'  AS ACT_CUST_NM" ).append("\n"); 
		query.append("        , 'BKG SHPR_CD'   AS SHPR_CD" ).append("\n"); 
		query.append("        , 'BKG SHPR_NM'   AS SHPR_NM" ).append("\n"); 
		query.append("        , 'B/L SHPR NM'   AS BL_SHPR_NM" ).append("\n"); 
		query.append("        , 'CNEE CD'     AS CNEE_CD" ).append("\n"); 
		query.append("        , 'CNEE NM'     AS CNEE_NM" ).append("\n"); 
		query.append("        , 'NOTIFY CD'   AS NTFY_CD" ).append("\n"); 
		query.append("        , 'NOTIFY NM'   AS NTFY_NM" ).append("\n"); 
		query.append("        , 'PRD CCT'     AS PPD_CCT" ).append("\n"); 
		query.append("        , 'BL ON BOARD DT' AS BL_ONBOARD_DT" ).append("\n"); 
		query.append("        , 'CGO RCV DT'     AS CGO_RCV_DT" ).append("\n"); 
		query.append("        , 'SOC'     AS SOC" ).append("\n"); 
		query.append("        , 'REV MT'  AS REV_MT" ).append("\n"); 
		query.append("        , 'RF'      AS RF" ).append("\n"); 
		query.append("        , 'DG'      AS DG" ).append("\n"); 
		query.append("        , 'BB'      AS BB" ).append("\n"); 
		query.append("        , 'AK'      AS AK" ).append("\n"); 
		query.append("        , 'WEIGHT'  AS WEIGHT" ).append("\n"); 
		query.append("        , 'UNIT'    AS UNIT" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("        ,'FR_$key'  AS REV_$key" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("        ,'FR_REV_TTL'   AS TOT_FR_REV_TPSZ" ).append("\n"); 
		query.append("        ,'MISC_REV_TTL' AS TOT_MISC_REV_TPSZ" ).append("\n"); 
		query.append("        ,'REV_TTL'      AS TOT_REV_TPSZ" ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("        ,'LOAD_$key' AS QTY_$key" ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("        ,'LOAD_TTL(TEU)'   AS TOT_QTY" ).append("\n"); 
		query.append("        ,'Freight Revenue' AS FREIGTH_REV" ).append("\n"); 
		query.append("        ,'Misc Operation Revenue' AS MISC_REV" ).append("\n"); 
		query.append("        ,'CNTR DEM/DET'    AS DMDT_COST" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,'Basic Stevedorage'      AS BASIC_STEVEDORAGE" ).append("\n"); 
		query.append("        ,'Other CY Expense'       AS OTHER_CY_EXPENSE" ).append("\n"); 
		query.append("        ,'T/S Stevedorage'        AS TS_STEVEDORAGE" ).append("\n"); 
		query.append("        ,'On Dock CY Expense'     AS ON_DOCK_CY_EXPENSE" ).append("\n"); 
		query.append("        ,'Cargo Handling Expense' AS CARGO_HANDLING_EXPENSE" ).append("\n"); 
		query.append("        ,'Storage'                AS STORAGE" ).append("\n"); 
		query.append("        ,'Misc Cargo Handling Expense'        AS MISC_CARGO_HANDLING_EXPENSE" ).append("\n"); 
		query.append("        ,'Exclusive Terminal Additional Cost' AS EXCLUSIVE_TERMINAL_ADD_COST" ).append("\n"); 
		query.append("        ,'Cargo Variable Volume Discount'     AS CARGO_VARIABLE_VOLUME_DISCOUNT" ).append("\n"); 
		query.append("        ,'Rail Direct'   AS RAIL_DIRECT" ).append("\n"); 
		query.append("        ,'Rail Truck'    AS RAIL_TRUCK" ).append("\n"); 
		query.append("        ,'Truck Direct'  AS TRUCK_DIRCET" ).append("\n"); 
		query.append("        ,'Water Direct'  AS WATER_DIRECT" ).append("\n"); 
		query.append("        ,'Water Rail'    AS WATER_RAIL" ).append("\n"); 
		query.append("        ,'Water Truck'   AS WATER_TRUCK" ).append("\n"); 
		query.append("        ,'Other Transport Expense'  AS OTHER_TRANSPORT_EXPENSE" ).append("\n"); 
		query.append("        ,'Carriers Haulage Service Charge '  AS CARRIERS_HAULAGE_SVG_CHG" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  #if(${f_pro_vw} =='R')" ).append("\n"); 
		query.append("        ,'Internal EQ Rental(EMU)_MT Repo Cost' AS INTERNAL_EQ_RENTAL_BASE" ).append("\n"); 
		query.append("        ,'Internal EQ Rental(EMU)_EMU Credit'   AS INTERNAL_EQ_RENTAL_MT_SIM" ).append("\n"); 
		query.append("  #elseif (${f_pro_vw} =='P')" ).append("\n"); 
		query.append("        ,'Empty Terminal Expense'           AS EMPTH_TERMINAL_EXPENSE" ).append("\n"); 
		query.append("        ,'Empty Transport Expense'          AS EMPTY_TRANSPORT_EXPENSE" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,'US Domestic Saving Credit'        AS US_DOMESTIC_SAV_CREDIT" ).append("\n"); 
		query.append("        ,'Ownway Saving'                    AS OWNWAY_SAV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,'Agent Commission'                 AS AGENT_COMMISSION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --,'CNTR Short Term EQ Rental_Sea_MT' AS CNTR_SHORT_TERM_EQ_SEA" ).append("\n"); 
		query.append("        --,'CNTR Long Term EQ Rental_Sea_MT'  AS CNTR_LONG_TERM_EQ_SEA" ).append("\n"); 
		query.append("        --,'CNTR M&R Charge_Sea_MT'           AS CNTR_MR_CHARGE_SEA" ).append("\n"); 
		query.append("        --,'CNTR Depreciation_Sea_MT'         AS CNTR_DEPRECIATION_SEA" ).append("\n"); 
		query.append("        --,'CNTR Insurance_Sea_MT'            AS CNTR_INSURANCE_SEA" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --,'CNTR Short Term EQ Rental_Land'   AS CNTR_SHORT_TERM_EQ_LAND" ).append("\n"); 
		query.append("        --,'CNTR Long Term EQ Rental_Land'    AS CNTR_LONG_TERM_EQ_LAND" ).append("\n"); 
		query.append("        --,'CNTR M&R Charge_Land'             AS CNTR_MR_CHARGE_LAND" ).append("\n"); 
		query.append("        --,'CNTR Depreciation_Land'           AS CNTR_DEPRECIATION_LAND" ).append("\n"); 
		query.append("        --,'CNTR Insurance_Land'              AS CNTR_INSURANCE_LAND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,'CNTR EQ Rental'                   AS CNTR_RNTL_NORM_AMT" ).append("\n"); 
		query.append("        ,'CNTR M&R Charge'                  AS CNTR_MNR_NORM_AMT" ).append("\n"); 
		query.append("        ,'CNTR Depreciation'                AS CNTR_DPC_NORM_AMT" ).append("\n"); 
		query.append("        ,'CNTR Insurance'                   AS CNTR_INSUR_NORM_AMT " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,'Chassis EQ Cost'                  AS CHASS_EQ_COST" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("  #if(${f_pro_vw} =='P')" ).append("\n"); 
		query.append("        ,'CM Cost Total'      AS CM_COST_TOTAL" ).append("\n"); 
		query.append("        ,'CM Total'           AS CM" ).append("\n"); 
		query.append("        --,'CM(BKG) Total'      AS CM_BKG" ).append("\n"); 
		query.append("  #elseif (${f_pro_vw} =='R')" ).append("\n"); 
		query.append("        ,'BKG CM Cost Total'  AS CM_COST_TOTAL" ).append("\n"); 
		query.append("        ,'BKG CM Total'       AS CM" ).append("\n"); 
		query.append("        --,'CM(BKG) Total'      AS CM_BKG" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O')" ).append("\n"); 
		query.append("        ,'Port EXP'                  AS PORT_EXP" ).append("\n"); 
		query.append("        ,'Canal Transit Fee'         AS CANAL_TRANSIT_FEE" ).append("\n"); 
		query.append("        ,'Bunker'                    AS BUNKER" ).append("\n"); 
		query.append("        ,'Crew EXP'                  AS CREW_EXP" ).append("\n"); 
		query.append("        ,'Insurance'                 AS INSURANCE" ).append("\n"); 
		query.append("        ,'Lubricant EXP'             AS LUBRICANT_EXP" ).append("\n"); 
		query.append("        ,'Store Supply EXP'          AS STORE_SUPPLY_EXP" ).append("\n"); 
		query.append("        ,'Vessel M&R'                AS VESSEL_MR" ).append("\n"); 
		query.append("        ,'Depreciations'             AS DEPRECIATIONS" ).append("\n"); 
		query.append("        ,'Telecom EXP'               AS TELECOM_EXP" ).append("\n"); 
		query.append("        ,'Other Operation Fixed Exp' AS OTHER_OPERATION_FIXED_EXP" ).append("\n"); 
		query.append("        ,'Time Charterage'           AS TIME_CHARTERAGE" ).append("\n"); 
		query.append("        ,'Space Charterage'          AS SPACE_CHARTERAGE" ).append("\n"); 
		query.append("        ,'General Expense'           AS GENERAL_EXPENSE" ).append("\n"); 
		query.append("        ,'Vessel Interest'           AS VESSEL_INTEREST	" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,'OP Cost Total' AS OP_COST" ).append("\n"); 
		query.append("        ,'OP Total'      AS OP" ).append("\n"); 
		query.append("  #end				" ).append("\n"); 
		query.append("  FROM  DUAL " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  UNION ALL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("       COST_YRMON  " ).append("\n"); 
		query.append("      ,SLS_YRMON  " ).append("\n"); 
		query.append("      ,COST_WK  " ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("	  ,FX_RT_FLG" ).append("\n"); 
		query.append("      ,BL_NO " ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("      ,TS_YRMON" ).append("\n"); 
		query.append("      ,TS_WK" ).append("\n"); 
		query.append("      ,TS_TRD_CD" ).append("\n"); 
		query.append("      ,TS_RLANE_CD " ).append("\n"); 
		query.append("      ,TS_BND" ).append("\n"); 
		query.append("      ,TS_VVD" ).append("\n"); 
		query.append("      ,TS_TRD_DIR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,TRD_CD  " ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD  " ).append("\n"); 
		query.append("      ,IOC_CD  " ).append("\n"); 
		query.append("      ,R_VVD" ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y' && ${f_rlane_cd} == 'RBCCO' )" ).append("\n"); 
		query.append("      ,CASE WHEN @[f_trd_cd]||@[f_rlane_cd] = TRD_CD||RLANE_CD AND MON_VVD = TRD_CD||RLANE_CD||R_VVD" ).append("\n"); 
		query.append("    	   THEN 'L/C'" ).append("\n"); 
		query.append("           ELSE 'T/S'" ).append("\n"); 
		query.append("           END STATUS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,CASE WHEN MON_VVD = TRD_CD||RLANE_CD||R_VVD" ).append("\n"); 
		query.append("           THEN 'L/C'" ).append("\n"); 
		query.append("           ELSE 'T/S'" ).append("\n"); 
		query.append("           END STATUS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,HUL_BND_CD" ).append("\n"); 
		query.append("      ,C_RHQ " ).append("\n"); 
		query.append("      ,C_AD " ).append("\n"); 
		query.append("      ,C_OFC " ).append("\n"); 
		query.append("      ,C_RGN_OFC" ).append("\n"); 
		query.append("      ,CSREP_CD " ).append("\n"); 
		query.append("      ,L_RHQ " ).append("\n"); 
		query.append("      ,L_AD " ).append("\n"); 
		query.append("      ,L_OFC " ).append("\n"); 
		query.append("      ,L_RGN_OFC" ).append("\n"); 
		query.append("      ,LREP_CD  " ).append("\n"); 
		query.append("      ,BKG_OFC_CD  " ).append("\n"); 
		query.append("      ,BKG_STS_CD  " ).append("\n"); 
		query.append("      ,USA_MODE" ).append("\n"); 
		query.append("      ,TRNK_POL_CD" ).append("\n"); 
		query.append("      ,TRNK_POD_CD " ).append("\n"); 
		query.append("      ,BKG_POR_CD  " ).append("\n"); 
		query.append("      ,BKG_POL_CD  " ).append("\n"); 
		query.append("      ,BKG_POD_CD  " ).append("\n"); 
		query.append("      ,BKG_DEL_CD  " ).append("\n"); 
		query.append("      ,BKG_RCV_TERM_CD  " ).append("\n"); 
		query.append("      ,BKG_DE_TERM_CD  " ).append("\n"); 
		query.append("      ,CSTMS_DESC" ).append("\n"); 
		query.append("      ,REP_CMDT_CD  " ).append("\n"); 
		query.append("      ,REP_CMDT_NM     " ).append("\n"); 
		query.append("      ,CMDT_CD " ).append("\n"); 
		query.append("      ,CMDT_NM    " ).append("\n"); 
		query.append("      ,MAS_GET_CD_NM_FNC('CD03218', IAS_RGN_CD) IAS_RGN_CD" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,1,3) N1ST_TRD_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,29,3) N2ND_TRD_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,57,3) N3RD_TRD_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,85,3) N4TH_TRD_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,113,3) N5TH_TRD_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,5,5) N1ST_RLANE_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,33,5) N2ND_RLANE_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,61,5) N3RD_RLANE_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,89,5) N4TH_RLANE_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,117,5) N5TH_RLANE_CD" ).append("\n"); 
		query.append("      , DECODE(SUBSTR(VVD_INFO,10,9),'XXXXXXXXX','',SUBSTR(VVD_INFO,10,9)) N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("      , DECODE(SUBSTR(VVD_INFO,38,9),'XXXXXXXXX','',SUBSTR(VVD_INFO,38,9)) N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("      , DECODE(SUBSTR(VVD_INFO,66,9),'XXXXXXXXX','',SUBSTR(VVD_INFO,66,9)) N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("      , DECODE(SUBSTR(VVD_INFO,94,9),'XXXXXXXXX','',SUBSTR(VVD_INFO,94,9)) N4TH_FINC_VVD_CD" ).append("\n"); 
		query.append("      , DECODE(SUBSTR(VVD_INFO,122,9),'XXXXXXXXX','',SUBSTR(VVD_INFO,122,9)) N5TH_FINC_VVD_CD" ).append("\n"); 
		query.append("#if(${f_include_ts} == 'Y')" ).append("\n"); 
		query.append("      , CASE WHEN SUBSTR(VVD_INFO,33,5) IS NULL THEN ''" ).append("\n"); 
		query.append("    	ELSE DECODE(@[f_rlane_cd], SUBSTR(VVD_INFO,5,5), SUBSTR(VVD_INFO,24,5), SUBSTR(VVD_INFO,33,5), SUBSTR(VVD_INFO,47,5), SUBSTR(VVD_INFO,61,5), SUBSTR(VVD_INFO,75,5), SUBSTR(VVD_INFO,89,5), SUBSTR(VVD_INFO,103,5), SUBSTR(VVD_INFO,117,5),SUBSTR(VVD_INFO,131,5))" ).append("\n"); 
		query.append("    	END TS_PORT" ).append("\n"); 
		query.append("      , DECODE(@[f_rlane_cd], SUBSTR(VVD_INFO,5,5), SUBSTR(VVD_INFO,19,5), SUBSTR(VVD_INFO,33,5), SUBSTR(VVD_INFO,47,5), " ).append("\n"); 
		query.append("                              SUBSTR(VVD_INFO,61,5), SUBSTR(VVD_INFO,75,5), SUBSTR(VVD_INFO,89,5), SUBSTR(VVD_INFO,103,5), " ).append("\n"); 
		query.append("                              SUBSTR(VVD_INFO,117,5),SUBSTR(VVD_INFO,131,5)) TS_POL" ).append("\n"); 
		query.append("      , DECODE(@[f_rlane_cd], SUBSTR(VVD_INFO,5,5), SUBSTR(VVD_INFO,24,5), SUBSTR(VVD_INFO,33,5), SUBSTR(VVD_INFO,52,5), " ).append("\n"); 
		query.append("                              SUBSTR(VVD_INFO,61,5), SUBSTR(VVD_INFO,80,5), SUBSTR(VVD_INFO,89,5), SUBSTR(VVD_INFO,108,5), " ).append("\n"); 
		query.append("                              SUBSTR(VVD_INFO,117,5),SUBSTR(VVD_INFO,136,5)) TS_POD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    , '' TS_PORT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,19,5) N1ST_POL_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,47,5) N2ND_POL_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,75,5) N3RD_POL_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,103,5) N4TH_POL_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,131,5) N5TH_POL_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,24,5) N1ST_POD_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,52,5) N2ND_POD_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,80,5) N3RD_POD_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,108,5) N4TH_POD_CD" ).append("\n"); 
		query.append("      , SUBSTR(VVD_INFO,136,5) N5TH_POD_CD	" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("      ,SC_NO  " ).append("\n"); 
		query.append("      ,RFA_NO  " ).append("\n"); 
		query.append("      ,RFA_TP" ).append("\n"); 
		query.append("      ,MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("      ,NVOCC" ).append("\n"); 
		query.append("      ,CUST_TP  " ).append("\n"); 
		query.append("      ,SC_CUST_CD  " ).append("\n"); 
		query.append("      ,REPLACE(SC_CUST_NM, CHR(49824), CHR(32)) AS SC_CUST_NM" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,SHPR_CUST_ID -- SHIPPER" ).append("\n"); 
		query.append("      ,REPLACE(SHIPPER_NAME, CHR(49824), CHR(32)) AS SHIPPER_NAME -- SHIPPER" ).append("\n"); 
		query.append("      ,AGMT_CUST_TP_CD" ).append("\n"); 
		query.append("      ,AGMT_CUST_ID -- CONTRACT CUSTOMER" ).append("\n"); 
		query.append("      ,REPLACE(AGMT_NAME, CHR(49824), CHR(32)) AS AGMT_NAME   -- CONTRACT CUSTOMER" ).append("\n"); 
		query.append("      ,ACT_CUST_ID" ).append("\n"); 
		query.append("      ,REPLACE(ACT_CUST_NM, CHR(49824), CHR(32)) AS ACT_CUST_NM" ).append("\n"); 
		query.append("      ,SHPR_CD   " ).append("\n"); 
		query.append("      ,REPLACE(SHPR_NM, CHR(49824), CHR(32)) AS SHPR_NM   " ).append("\n"); 
		query.append("      ,REPLACE(BL_SHPR_NM, CHR(49824), CHR(32)) AS BL_SHPR_NM" ).append("\n"); 
		query.append("      ,CNEE_CD  " ).append("\n"); 
		query.append("      ,REPLACE(CNEE_NM, CHR(49824), CHR(32)) AS CNEE_NM" ).append("\n"); 
		query.append("      ,NTFY_CD " ).append("\n"); 
		query.append("      ,REPLACE(NTFY_NM, CHR(49824), CHR(32)) AS CNEE_NM" ).append("\n"); 
		query.append("      ,PPD_CCT " ).append("\n"); 
		query.append("      ,BL_ONBOARD_DT  " ).append("\n"); 
		query.append("      ,CGO_RCV_DT  " ).append("\n"); 
		query.append("      ,SOC " ).append("\n"); 
		query.append("      ,REV_MT " ).append("\n"); 
		query.append("      ,RF" ).append("\n"); 
		query.append("      ,DG " ).append("\n"); 
		query.append("      ,BB  " ).append("\n"); 
		query.append("      ,AK " ).append("\n"); 
		query.append("      ,WEIGHT " ).append("\n"); 
		query.append("      ,UNIT " ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("      ,REV_$key" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("      ,TOT_FR_REV_TPSZ " ).append("\n"); 
		query.append("      ,TOT_MISC_REV_TPSZ " ).append("\n"); 
		query.append("      ,TOT_REV_TPSZ " ).append("\n"); 
		query.append("    		" ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("      ,QTY_$key" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("      ,TOT_QTY " ).append("\n"); 
		query.append("      ,FREIGTH_REV " ).append("\n"); 
		query.append("      ,MISC_REV " ).append("\n"); 
		query.append("      ,DMDT_COST " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,BASIC_STEVEDORAGE " ).append("\n"); 
		query.append("      ,OTHER_CY_EXPENSE " ).append("\n"); 
		query.append("      ,TS_STEVEDORAGE " ).append("\n"); 
		query.append("      ,ON_DOCK_CY_EXPENSE " ).append("\n"); 
		query.append("      ,CARGO_HANDLING_EXPENSE " ).append("\n"); 
		query.append("      ,STORAGE " ).append("\n"); 
		query.append("      ,MISC_CARGO_HANDLING_EXPENSE " ).append("\n"); 
		query.append("      ,EXCLUSIVE_TERMINAL_ADD_COST " ).append("\n"); 
		query.append("      ,CARGO_VARIABLE_VOLUME_DISCOUNT " ).append("\n"); 
		query.append("      ,RAIL_DIRECT " ).append("\n"); 
		query.append("      ,RAIL_TRUCK " ).append("\n"); 
		query.append("      ,TRUCK_DIRCET " ).append("\n"); 
		query.append("      ,WATER_DIRECT " ).append("\n"); 
		query.append("      ,WATER_RAIL " ).append("\n"); 
		query.append("      ,WATER_TRUCK " ).append("\n"); 
		query.append("      ,OTHER_TRANSPORT_EXPENSE " ).append("\n"); 
		query.append("      ,CARRIERS_HAULAGE_SVG_CHG" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  #if(${f_pro_vw} =='R')" ).append("\n"); 
		query.append("      ,INTERNAL_EQ_RENTAL_BASE " ).append("\n"); 
		query.append("      ,INTERNAL_EQ_RENTAL_MT_SIM " ).append("\n"); 
		query.append("  #elseif (${f_pro_vw} =='P')" ).append("\n"); 
		query.append("      ,EMPTH_TERMINAL_EXPENSE " ).append("\n"); 
		query.append("      ,EMPTY_TRANSPORT_EXPENSE " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,US_DOMESTIC_SAV_CREDIT   " ).append("\n"); 
		query.append("      ,OWNWAY_SAV " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,AGENT_COMMISSION" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --,CNTR_STRM_EQ_SEA_MT	" ).append("\n"); 
		query.append("      --,CNTR_LTRM_EQ_SEA_MT" ).append("\n"); 
		query.append("      --,CNTR_MNR_CHG_SEA_MT" ).append("\n"); 
		query.append("      --,CNTR_DPC_SEA_MT" ).append("\n"); 
		query.append("      --,CNTR_INSUR_SEA_MT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --,CNTR_STRM_EQ_RLND" ).append("\n"); 
		query.append("      --,CNTR_LTRM_EQ_RLND" ).append("\n"); 
		query.append("      --,CNTR_MNR_CHG_LND" ).append("\n"); 
		query.append("      --,CNTR_DPC_LND" ).append("\n"); 
		query.append("      --,CNTR_INSUR_LND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,CNTR_RNTL_NORM_AMT" ).append("\n"); 
		query.append("      ,CNTR_MNR_NORM_AMT" ).append("\n"); 
		query.append("      ,CNTR_DPC_NORM_AMT" ).append("\n"); 
		query.append("      ,CNTR_INSUR_NORM_AMT 	  " ).append("\n"); 
		query.append("      ,CHSS_EQ_COST" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("      ,CM_COST_TOTAL " ).append("\n"); 
		query.append("      ,CM " ).append("\n"); 
		query.append("      --,CM_BKG" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O')" ).append("\n"); 
		query.append("      -- OP계정" ).append("\n"); 
		query.append("      ,PORT_EXPN_AMT" ).append("\n"); 
		query.append("      ,CNL_TZ_AMT" ).append("\n"); 
		query.append("      ,BNK_AMT" ).append("\n"); 
		query.append("      ,CRW_AMT" ).append("\n"); 
		query.append("      ,INSUR_AMT" ).append("\n"); 
		query.append("      ,STO_SPL_EXPN_AMT" ).append("\n"); 
		query.append("      ,LBRC_EXPN_AMT" ).append("\n"); 
		query.append("      ,VSL_MNR_AMT" ).append("\n"); 
		query.append("      ,DPC_AMT" ).append("\n"); 
		query.append("      ,TELCM_AMT" ).append("\n"); 
		query.append("      ,OTR_OP_FX_AMT" ).append("\n"); 
		query.append("      ,TC_AMT" ).append("\n"); 
		query.append("      ,SPC_CHTR_AMT" ).append("\n"); 
		query.append("      ,GEN_EXPN_AMT" ).append("\n"); 
		query.append("      ,VSL_INT_AMT  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("      ,OP_COST_TOTAL  " ).append("\n"); 
		query.append("      ,OP_TOTAL " ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("  FROM (	" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("               A2.COST_YRMON  " ).append("\n"); 
		query.append("              ,A2.SLS_YRMON  " ).append("\n"); 
		query.append("              ,A2.COST_WK  " ).append("\n"); 
		query.append("              ,A2.BKG_NO              AS BKG_NO  " ).append("\n"); 
		query.append("			  ,NVL(MRB.FX_RT_FLG, 'N' ) AS FX_RT_FLG" ).append("\n"); 
		query.append("              ,DECODE(SUBSTR(A2.BL_NO, 1, 4), 'KOSA', 'K' || A2.BKG_NO, A2.BL_NO || A2.BL_NO_TP || A2.BL_NO_CHK) AS BL_NO  " ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("              ,V.COST_YRMON AS TS_YRMON" ).append("\n"); 
		query.append("              ,V.COST_WK AS TS_WK" ).append("\n"); 
		query.append("              ,V.TRD_CD AS TS_TRD_CD" ).append("\n"); 
		query.append("              ,V.RLANE_CD AS TS_RLANE_CD" ).append("\n"); 
		query.append("              ,V.DIR_CD AS TS_BND" ).append("\n"); 
		query.append("              ,V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD AS TS_VVD" ).append("\n"); 
		query.append("              ,MAS_GET_CD_NM_FNC('CD03217',(SELECT HUL_BND_CD FROM MAS_LANE_RGST" ).append("\n"); 
		query.append("            	WHERE RLANE_CD = V.RLANE_CD" ).append("\n"); 
		query.append("            		AND TRD_CD = V.TRD_CD" ).append("\n"); 
		query.append("            		AND DIR_CD = V.DIR_CD" ).append("\n"); 
		query.append("            		AND IOC_CD = V.IOC_CD" ).append("\n"); 
		query.append("               )) AS TS_TRD_DIR " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              ,'' TS_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,A2.TRD_CD  " ).append("\n"); 
		query.append("              ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,A2.RLANE_CD  " ).append("\n"); 
		query.append("              ,A2.IOC_CD  " ).append("\n"); 
		query.append("              ,A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD  AS R_VVD  " ).append("\n"); 
		query.append("              ,A2.DIR_CD" ).append("\n"); 
		query.append("              ,MAS_GET_CD_NM_FNC('CD03217', R.HUL_BND_CD) AS HUL_BND_CD  " ).append("\n"); 
		query.append("              ,A2.CTRT_HQ_OFC_CD                        AS C_RHQ " ).append("\n"); 
		query.append("              ,A2.CTRT_RGN_OFC_CD                       AS C_AD " ).append("\n"); 
		query.append("              ,A2.CTRT_OFC_CD                           AS C_OFC " ).append("\n"); 
		query.append("              ,(SELECT OFC_N5TH_LVL_CD FROM MAS_OFC_LVL" ).append("\n"); 
		query.append("            	WHERE OFC_CD = A2.CTRT_OFC_CD" ).append("\n"); 
		query.append("            		AND A2.COST_YRMON BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("            	) AS C_RGN_OFC " ).append("\n"); 
		query.append("              ,A2.CTRT_SREP_CD                          AS CSREP_CD " ).append("\n"); 
		query.append("              ,A2.RHQ_CD                                AS L_RHQ " ).append("\n"); 
		query.append("              ,A2.RGN_OFC_CD                            AS L_AD " ).append("\n"); 
		query.append("              ,A2.SLS_OFC_CD                            AS L_OFC " ).append("\n"); 
		query.append("              ,(SELECT OFC_N5TH_LVL_CD FROM MAS_OFC_LVL" ).append("\n"); 
		query.append("            	WHERE OFC_CD = A2.SLS_OFC_CD" ).append("\n"); 
		query.append("            		AND A2.COST_YRMON BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("            	) AS L_RGN_OFC " ).append("\n"); 
		query.append("              ,A2.SREP_CD                               AS LREP_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_OFC_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_STS_CD  " ).append("\n"); 
		query.append("              ,A2.USA_BKG_MOD_CD                        AS USA_MODE" ).append("\n"); 
		query.append("              ,A2.REV_POL_CD AS TRNK_POL_CD" ).append("\n"); 
		query.append("              ,A2.REV_POD_CD AS TRNK_POD_CD " ).append("\n"); 
		query.append("              ,A2.BKG_POR_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_POL_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_POD_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_DEL_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_RCV_TERM_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_DE_TERM_CD              " ).append("\n"); 
		query.append("              , ( SELECT CSTMS_DESC" ).append("\n"); 
		query.append("                    FROM BKG_BL_DOC" ).append("\n"); 
		query.append("                   WHERE BKG_NO = A2.BKG_NO) CSTMS_DESC    " ).append("\n"); 
		query.append("              ,A2.REP_CMDT_CD  " ).append("\n"); 
		query.append("              ,A5.REP_CMDT_NM     " ).append("\n"); 
		query.append("              ,A2.CMDT_CD " ).append("\n"); 
		query.append("              ,A3.CMDT_NM  " ).append("\n"); 
		query.append("              ,R.IAS_RGN_CD " ).append("\n"); 
		query.append("              ,A2.N1ST_TRD_CD  " ).append("\n"); 
		query.append("              ,A2.N2ND_TRD_CD  " ).append("\n"); 
		query.append("              ,A2.N3RD_TRD_CD  " ).append("\n"); 
		query.append("              ,A2.N4TH_TRD_CD  " ).append("\n"); 
		query.append("              ,A2.N1ST_RLANE_CD " ).append("\n"); 
		query.append("              ,A2.N2ND_RLANE_CD " ).append("\n"); 
		query.append("              ,A2.N3RD_RLANE_CD " ).append("\n"); 
		query.append("              ,A2.N4TH_RLANE_CD  " ).append("\n"); 
		query.append("              ,A2.N1ST_FINC_VVD_CD " ).append("\n"); 
		query.append("              ,A2.N2ND_FINC_VVD_CD " ).append("\n"); 
		query.append("              ,A2.N3RD_FINC_VVD_CD " ).append("\n"); 
		query.append("              ,A2.N4TH_FINC_VVD_CD  " ).append("\n"); 
		query.append("              ,A2.N1ST_POL_CD " ).append("\n"); 
		query.append("              ,A2.N2ND_POL_CD " ).append("\n"); 
		query.append("              ,A2.N3RD_POL_CD " ).append("\n"); 
		query.append("              ,A2.N4TH_POL_CD  " ).append("\n"); 
		query.append("              ,A2.N1ST_POD_CD " ).append("\n"); 
		query.append("              ,A2.N2ND_POD_CD " ).append("\n"); 
		query.append("              ,A2.N3RD_POD_CD " ).append("\n"); 
		query.append("              ,A2.N4TH_POD_CD  " ).append("\n"); 
		query.append("              ,A2.SC_NO  " ).append("\n"); 
		query.append("              ,A2.RFA_NO  " ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("              	SELECT (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03493' AND INTG_CD_VAL_CTNT = MN.RFA_CTRT_TP_CD) AS RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("              	FROM PRI_RP_MN MN" ).append("\n"); 
		query.append("              		,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("              	WHERE HDR.PROP_NO 	 	= MN.PROP_NO" ).append("\n"); 
		query.append("              	AND MN.AMDT_SEQ = ( SELECT /*+ INDEX_DESC(A XPKPRI_RP_MN)*/ AMDT_SEQ FROM PRI_RP_MN A WHERE MN.PROP_NO = PROP_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("              	AND HDR.RFA_NO = A2.RFA_NO" ).append("\n"); 
		query.append("              	AND ROWNUM = 1" ).append("\n"); 
		query.append("               )RFA_TP" ).append("\n"); 
		query.append("              ,(SELECT MST_RFA_ROUT_ID FROM BKG_RATE WHERE BKG_NO = A2.BKG_NO) AS MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("              ,A2.CUST_TP_CD                                           AS NVOCC " ).append("\n"); 
		query.append("              ,A2.AGMT_CUST_TP_CD                                      AS CUST_TP  " ).append("\n"); 
		query.append("              ,A2.AGMT_CNT_CD || TO_CHAR(LPAD(DECODE(A2.AGMT_CUST_SEQ,0,'',A2.AGMT_CUST_SEQ),6,'0'))  AS SC_CUST_CD  " ).append("\n"); 
		query.append("              ,(   " ).append("\n"); 
		query.append("                SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("                  FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("                 WHERE A2.AGMT_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("                   AND A2.AGMT_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("              ) AS SC_CUST_NM" ).append("\n"); 
		query.append("  --,A2.CUST_GRP_ID" ).append("\n"); 
		query.append("  --,A2.CUST_GRP_NM " ).append("\n"); 
		query.append("             ,(SELECT NVL(B1.CUST_GRP_ID, A2.SHPR_CNT_CD||A2.SHPR_CUST_SEQ) FROM MDM_CUSTOMER B1		-- SHIPPER" ).append("\n"); 
		query.append("            		WHERE 1=1" ).append("\n"); 
		query.append("            			AND A2.SHPR_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("            			AND A2.SHPR_CNT_CD = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("            	) AS SHPR_CUST_ID" ).append("\n"); 
		query.append("              ,(SELECT NVL(B2.CUST_GRP_NM, B1.CUST_LGL_ENG_NM) FROM MDM_CUSTOMER B1, MDM_CUST_PERF_GRP B2		-- SHIPPER" ).append("\n"); 
		query.append("            		WHERE 1=1" ).append("\n"); 
		query.append("            			AND A2.SHPR_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("            			AND A2.SHPR_CNT_CD = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("            			AND B1.CUST_GRP_ID = B2.CUST_GRP_ID(+)" ).append("\n"); 
		query.append("            	) AS SHIPPER_NAME" ).append("\n"); 
		query.append("              ,A2.AGMT_PRC_CTRT_CUST_TP_CD AS AGMT_CUST_TP_CD" ).append("\n"); 
		query.append("              ,(SELECT NVL(B1.CUST_GRP_ID, A2.AGMT_CNT_CD||A2.AGMT_CUST_SEQ) FROM MDM_CUSTOMER B1		-- CONTRACT CUSTOMER" ).append("\n"); 
		query.append("            		WHERE 1=1" ).append("\n"); 
		query.append("            			AND A2.AGMT_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("            			AND A2.AGMT_CNT_CD = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("            	) AS AGMT_CUST_ID" ).append("\n"); 
		query.append("              ,(SELECT NVL(B2.CUST_GRP_NM, B1.CUST_LGL_ENG_NM) FROM MDM_CUSTOMER B1, MDM_CUST_PERF_GRP B2			-- CONTRACT CUSTOMER" ).append("\n"); 
		query.append("            		WHERE 1=1" ).append("\n"); 
		query.append("            			AND A2.AGMT_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("            			AND A2.AGMT_CNT_CD = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("            			AND B1.CUST_GRP_ID = B2.CUST_GRP_ID(+)" ).append("\n"); 
		query.append("            	) AS AGMT_NAME" ).append("\n"); 
		query.append("              ,A2.AGMT_ACT_CNT_CD || TO_CHAR(LPAD(DECODE(A2.AGMT_ACT_CUST_SEQ,0,'',A2.AGMT_ACT_CUST_SEQ),6,'0')) AS ACT_CUST_ID" ).append("\n"); 
		query.append("              ,A2.ACT_CUST_NM AS ACT_CUST_NM " ).append("\n"); 
		query.append("              ,A2.SHPR_CNT_CD || TO_CHAR(LPAD(DECODE(A2.SHPR_CUST_SEQ,0,'',A2.SHPR_CUST_SEQ),6,'0'))      AS SHPR_CD   " ).append("\n"); 
		query.append("              ,(   " ).append("\n"); 
		query.append("                SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("                  FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("                 WHERE A2.SHPR_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("                   AND A2.SHPR_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("              ) AS SHPR_NM   " ).append("\n"); 
		query.append("              ,TRANSLATE(A2.SHPR_NM, CHR(29)||CHR(31)||CHR(30),' ')     AS BL_SHPR_NM  /* CHR(29)만 공백 나머지는 삭제 */" ).append("\n"); 
		query.append("              ,A2.CNEE_CNT_CD || TO_CHAR(LPAD(DECODE(A2.CNEE_CUST_SEQ,0,'',A2.CNEE_CUST_SEQ),6,'0')) AS CNEE_CD  " ).append("\n"); 
		query.append("              ,(   " ).append("\n"); 
		query.append("                SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("                  FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("                 WHERE A2.CNEE_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("                   AND A2.CNEE_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("              ) AS CNEE_NM  /*CNEE   */" ).append("\n"); 
		query.append("              ,A2.NTFY_CNT_CD || TO_CHAR(LPAD(DECODE(A2.NTFY_CUST_SEQ,0,'',A2.NTFY_CUST_SEQ),6,'0')) AS NTFY_CD " ).append("\n"); 
		query.append("              ,(   " ).append("\n"); 
		query.append("                SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("                  FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("                 WHERE A2.NTFY_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("                   AND A2.NTFY_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("              ) AS NTFY_NM   /*NTFY*/   " ).append("\n"); 
		query.append("              ,A2.OFT_TP_CD                                            AS PPD_CCT " ).append("\n"); 
		query.append("              ,TO_CHAR(A2.OBRD_DT,'YYYY-MM-DD')                        AS BL_ONBOARD_DT  " ).append("\n"); 
		query.append("              ,TO_CHAR(MAX(C.CGO_RCV_DT),'YYYY-MM-DD')                    AS CGO_RCV_DT  " ).append("\n"); 
		query.append("              ,A2.SOC_FLG                                              AS SOC " ).append("\n"); 
		query.append("              ,DECODE(A2.BKG_CGO_TP_CD, 'R', 'Y', 'N')                 AS REV_MT " ).append("\n"); 
		query.append("              ,NVL(A2.SPCL_RC_FLG, 'N')                                AS RF" ).append("\n"); 
		query.append("              ,NVL(A2.SPCL_DG_CGO_FLG, 'N')                            AS DG " ).append("\n"); 
		query.append("              ,NVL(A2.SPCL_BB_CGO_FLG, 'N')                            AS BB  " ).append("\n"); 
		query.append("              ,NVL(A2.SPCL_AWK_CGO_FLG, 'N')                           AS AK " ).append("\n"); 
		query.append("              ,TO_CHAR(A2.BKG_CGO_WGT)                                 AS WEIGHT " ).append("\n"); 
		query.append("              ,A2.BKG_WGT_TP_CD                                        AS UNIT " ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key',  A2.BKG_REV+A2.BKG_OFT_REV)))      AS REV_$key" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV))                                   AS TOT_FR_REV_TPSZ " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.BKG_MISC_REV+A2.SCR_CHG_REV))                              AS TOT_MISC_REV_TPSZ " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV))    AS TOT_REV_TPSZ " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  #foreach($key in ${allcols}) " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key',  A2.BKG_QTY)))                     AS QTY_$key" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(DECODE(SUBSTR(A2.SPCL_CNTR_TPSZ_CD,-1),'2',A2.BKG_QTY, '3',A2.BKG_QTY, A2.BKG_QTY*2))) AS TOT_QTY " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV))                                   AS FREIGTH_REV " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.BKG_MISC_REV+A2.SCR_CHG_REV))                              AS MISC_REV " ).append("\n"); 
		query.append("            		" ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.DMDT_COM_AMT))                                             AS DMDT_COST " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.BZC_STVG_COM_AMT))            AS BASIC_STEVEDORAGE " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.OTR_CY_HNDL_COM_AMT))         AS OTHER_CY_EXPENSE " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.TS_STVG_COM_AMT))             AS TS_STEVEDORAGE " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.DCK_CY_HNDL_COM_AMT))         AS ON_DOCK_CY_EXPENSE " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.CGO_HNDL_COM_AMT))            AS CARGO_HANDLING_EXPENSE " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.FCNTR_STO_COM_AMT))           AS STORAGE " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.MISC_CGO_HNDL_COM_AMT))       AS MISC_CARGO_HANDLING_EXPENSE " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.TML_COM_AMT))                 AS EXCLUSIVE_TERMINAL_ADD_COST " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.CGO_VAR_VOL_DC_AMT))          AS CARGO_VARIABLE_VOLUME_DISCOUNT " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.FULL_RAIL_DIR_COM_AMT))       AS RAIL_DIRECT " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.FULL_RAIL_TRK_COM_AMT))       AS RAIL_TRUCK " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.FULL_TRK_DIR_COM_AMT))        AS TRUCK_DIRCET " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.FULL_WTR_DIR_COM_AMT))        AS WATER_DIRECT " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.FULL_WTR_RAIL_COM_AMT))       AS WATER_RAIL " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.FULL_WTR_TRK_COM_AMT))        AS WATER_TRUCK " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.FULL_TRSP_COM_AMT))           AS OTHER_TRANSPORT_EXPENSE " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.CRR_HLG_SVC_CHG_AMT))         AS CARRIERS_HAULAGE_SVG_CHG" ).append("\n"); 
		query.append("            		" ).append("\n"); 
		query.append("  #if(${f_pro_vw} =='R')" ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.INTER_EQ_RNTL_BSE_AMT))       AS INTERNAL_EQ_RENTAL_BASE " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.MTY_SIM_AMT))                 AS INTERNAL_EQ_RENTAL_MT_SIM " ).append("\n"); 
		query.append("  #elseif (${f_pro_vw} =='P')" ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.MTY_STVG_PA_AMT))             AS EMPTH_TERMINAL_EXPENSE " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.MTY_TRSP_PA_AMT))             AS EMPTY_TRANSPORT_EXPENSE " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.AC_COM_AMT))                  AS AGENT_COMMISSION    " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              --,TO_CHAR(SUM(A2.CNTR_LTERM_RNTL_LAND_AMT))    AS CNTR_LTRM_EQ_RLND" ).append("\n"); 
		query.append("              --,TO_CHAR(SUM(A2.CNTR_STERM_RNTL_LAND_AMT))    AS CNTR_STRM_EQ_RLND" ).append("\n"); 
		query.append("              --,TO_CHAR(SUM(A2.CNTR_MNR_LAND_AMT))           AS CNTR_MNR_CHG_LND" ).append("\n"); 
		query.append("              --,TO_CHAR(SUM(A2.CNTR_DPC_LAND_AMT))           AS CNTR_DPC_LND" ).append("\n"); 
		query.append("              --,TO_CHAR(SUM(A2.CNTR_INSUR_LAND_AMT))         AS CNTR_INSUR_LND" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("              --,TO_CHAR(SUM(A2.CNTR_LTERM_RNTL_OTR_AMT))     AS CNTR_LTRM_EQ_SEA_MT" ).append("\n"); 
		query.append("              --,TO_CHAR(SUM(A2.CNTR_STERM_RNTL_OTR_AMT))     AS CNTR_STRM_EQ_SEA_MT" ).append("\n"); 
		query.append("              --,TO_CHAR(SUM(A2.CNTR_MNR_OTR_AMT))            AS CNTR_MNR_CHG_SEA_MT" ).append("\n"); 
		query.append("              --,TO_CHAR(SUM(A2.CNTR_DPC_OTR_AMT))            AS CNTR_DPC_SEA_MT" ).append("\n"); 
		query.append("              --,TO_CHAR(SUM(A2.CNTR_INSUR_OTR_AMT))          AS CNTR_INSUR_SEA_MT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.CNTR_LTERM_RNTL_LAND_AMT " ).append("\n"); 
		query.append("                            + A2.CNTR_STERM_RNTL_LAND_AMT " ).append("\n"); 
		query.append("                            + A2.CNTR_LTERM_RNTL_OTR_AMT " ).append("\n"); 
		query.append("                            + A2.CNTR_STERM_RNTL_OTR_AMT" ).append("\n"); 
		query.append("                            + A2.CNTR_RNTL_NORM_AMT))       AS CNTR_RNTL_NORM_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.CNTR_MNR_LAND_AMT " ).append("\n"); 
		query.append("                            + A2.CNTR_MNR_OTR_AMT " ).append("\n"); 
		query.append("                            + A2.CNTR_MNR_NORM_AMT))        AS CNTR_MNR_NORM_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.CNTR_DPC_NORM_AMT" ).append("\n"); 
		query.append("                            + A2.CNTR_DPC_LAND_AMT" ).append("\n"); 
		query.append("                            + A2.CNTR_DPC_OTR_AMT))         AS CNTR_DPC_NORM_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.CNTR_INSUR_NORM_AMT" ).append("\n"); 
		query.append("                            + A2.CNTR_INSUR_LAND_AMT" ).append("\n"); 
		query.append("                            + A2.CNTR_INSUR_OTR_AMT))       AS CNTR_INSUR_NORM_AMT" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.CHSS_AMT))                    AS CHSS_EQ_COST" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.USA_DMST_SAV_CR_AMT))         AS US_DOMESTIC_SAV_CREDIT   " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.ONE_WY_SAV_PFIT_ANAL_AMT))    AS OWNWAY_SAV " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(DECODE(@[f_pro_vw],'P',A2.PA_CM_COST_TTL_AMT,'R',A2.RA_CM_COST_TTL_AMT)))   AS CM_COST_TOTAL " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV+A2.DMDT_COM_AMT)  --DEMDET 추가 20150706" ).append("\n"); 
		query.append("                - SUM(DECODE(@[f_pro_vw],'P',A2.PA_CM_COST_TTL_AMT,'R',A2.RA_CM_COST_TTL_AMT)))        AS CM " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	      ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV) -- CM(BKG)는 CM 계산에서 수입 DEM/DET, 비용 장비비 제외" ).append("\n"); 
		query.append("                - SUM(DECODE(@[f_pro_vw],'P',A2.PA_CM_COST_TTL_AMT,'R',A2.RA_CM_COST_TTL_AMT)) " ).append("\n"); 
		query.append("                + SUM(NVL(A2.CNTR_STERM_RNTL_LAND_AMT, 0) + NVL(A2.CNTR_LTERM_RNTL_LAND_AMT, 0) + NVL(A2.CNTR_MNR_LAND_AMT, 0) " ).append("\n"); 
		query.append("                        + NVL(A2.CNTR_DPC_LAND_AMT, 0) + NVL(A2.CNTR_INSUR_LAND_AMT, 0) + NVL(A2.CNTR_STERM_RNTL_OTR_AMT, 0) " ).append("\n"); 
		query.append("                        + NVL(A2.CNTR_LTERM_RNTL_OTR_AMT, 0) + NVL(A2.CNTR_MNR_OTR_AMT, 0) + NVL(A2.CNTR_DPC_OTR_AMT, 0) " ).append("\n"); 
		query.append("                        + NVL(A2.CNTR_INSUR_OTR_AMT, 0) + NVL(A2.CHSS_AMT, 0) " ).append("\n"); 
		query.append("			+ NVL(A2.CNTR_RNTL_NORM_AMT, 0)" ).append("\n"); 
		query.append("			+ NVL(A2.CNTR_MNR_NORM_AMT, 0)" ).append("\n"); 
		query.append("			+ NVL(A2.CNTR_DPC_NORM_AMT, 0)" ).append("\n"); 
		query.append("			+ NVL(A2.CNTR_INSUR_NORM_AMT, 0) ))        AS CM_BKG " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- OP계정" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.PE_AMT),0))                                            AS PORT_EXPN_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.CNL_TZ_AMT),0))                                        AS CNL_TZ_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.BNK_AMT),0))                                           AS BNK_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.CRW_EXPN_AMT),0))                                      AS CRW_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.INSUR_AMT),0))                                         AS INSUR_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.STO_SPL_EXPN_AMT),0))                                  AS STO_SPL_EXPN_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.LBRC_EXPN_AMT),0))                                     AS LBRC_EXPN_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.VSL_MNR_AMT),0))                                       AS VSL_MNR_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.DPC_AMT),0))                                           AS DPC_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.TELCM_EXPN_AMT),0))                                    AS TELCM_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.OTR_OP_FX_AMT),0))                                     AS OTR_OP_FX_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.TC_AMT),0))                                            AS TC_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.SPC_CHRG_AMT),0))                                      AS SPC_CHTR_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.GEN_EXPN_AMT),0))                                      AS GEN_EXPN_AMT" ).append("\n"); 
		query.append("              ,TO_CHAR(NVL(SUM(A6.VSL_INT_AMT),0))                                       AS VSL_INT_AMT " ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("              ,TO_CHAR( NVL(SUM(A6.PA_OP_COST_TTL_AMT), 0))               AS OP_COST_TOTAL  -- 컬럼 추가되면 변경 20150323" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("              ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV+A2.DMDT_COM_AMT) - NVL(SUM(A2.RA_CM_COST_TTL_AMT),0)  " ).append("\n"); 
		query.append("                 - NVL(SUM(A6.PA_OP_COST_TTL_AMT), 0) -- 컬럼 DEMDET / OP 추가 변경 20150706" ).append("\n"); 
		query.append("                     )   AS OP_TOTAL   " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO' )" ).append("\n"); 
		query.append("              ,V.TRD_CD||V.RLANE_CD||V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD AS MON_VVD" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("              ,A2.TRD_CD||A2.RLANE_CD||A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD AS MON_VVD	" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("     	      ,MAS_PSG_TS_ARRAY_FNC(a2.n1st_trd_cd," ).append("\n"); 
		query.append("                              DECODE (MAS_SLAN_CONTI_CONV_FNC(A2.n1st_finc_vvd_cd,substr(A2.N1ST_RLANE_CD,1,3),SUBSTR (A2.n1st_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,MAS_SLAN_CONTI_CONV_FNC(A2.n1st_finc_vvd_cd,substr(A2.N1ST_RLANE_CD,1,3),SUBSTR (A2.n1st_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n1st_rlane_cd, SUBSTR (A2.n1st_finc_vvd_cd, 1, 9), A2.n1st_pol_cd, A2.n1st_pod_cd, --1" ).append("\n"); 
		query.append("                              a2.n2nd_trd_cd," ).append("\n"); 
		query.append("                              DECODE (MAS_SLAN_CONTI_CONV_FNC(A2.n2nd_finc_vvd_cd,substr(A2.N2nd_RLANE_CD,1,3),SUBSTR (A2.n2nd_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,MAS_SLAN_CONTI_CONV_FNC(A2.n2nd_finc_vvd_cd,substr(A2.n2nd_RLANE_CD,1,3),SUBSTR (A2.n2nd_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n2nd_rlane_cd, SUBSTR (A2.n2nd_finc_vvd_cd, 1, 9), A2.n2nd_pol_cd, A2.n2nd_pod_cd, --2" ).append("\n"); 
		query.append("                              a2.n3rd_trd_cd," ).append("\n"); 
		query.append("                              DECODE (MAS_SLAN_CONTI_CONV_FNC(A2.n3rd_finc_vvd_cd,substr(A2.n3rd_RLANE_CD,1,3),SUBSTR (A2.n3rd_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,MAS_SLAN_CONTI_CONV_FNC(A2.n3rd_finc_vvd_cd,substr(A2.n3rd_RLANE_CD,1,3),SUBSTR (A2.n3rd_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n3rd_rlane_cd, SUBSTR (A2.n3rd_finc_vvd_cd, 1, 9), A2.n3rd_pol_cd, A2.n3rd_pod_cd, --3" ).append("\n"); 
		query.append("                              a2.n4th_trd_cd," ).append("\n"); 
		query.append("                              DECODE (MAS_SLAN_CONTI_CONV_FNC(A2.n4th_finc_vvd_cd,substr(A2.n4th_RLANE_CD,1,3),SUBSTR (A2.n4th_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,MAS_SLAN_CONTI_CONV_FNC(A2.n4th_finc_vvd_cd,substr(A2.n4th_RLANE_CD,1,3),SUBSTR (A2.n4th_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n4th_rlane_cd, SUBSTR (A2.n4th_finc_vvd_cd, 1, 9), A2.n4th_pol_cd, A2.n4th_pod_cd --4" ).append("\n"); 
		query.append("                             ) vvd_info" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("        FROM  " ).append("\n"); 
		query.append("   #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("             MAS_BKG_EXPN_DTL A2" ).append("\n"); 
		query.append("   #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("             MAS_BKG_EXPN_DTL_WK A2 " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("             ,MAS_BKG_OP_EXPN_DTL A6" ).append("\n"); 
		query.append("   #if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("             ,MAS_MON_VVD V" ).append("\n"); 
		query.append("             ,BKG_VVD B" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("			 ,MAS_RGST_BKG MRB" ).append("\n"); 
		query.append("             ,MAS_OFC_LVL A4 " ).append("\n"); 
		query.append("             ,MDM_COMMODITY A3    " ).append("\n"); 
		query.append("             ,MDM_REP_CMDT A5" ).append("\n"); 
		query.append("             ,MAS_LANE_RGST R" ).append("\n"); 
		query.append("			 ,( SELECT BKG_NO, MAX(CGO_RCV_DT) AS CGO_RCV_DT  " ).append("\n"); 
		query.append("                FROM BKG_CONTAINER GROUP BY BKG_NO ) C" ).append("\n"); 
		query.append("       WHERE 1 = 1" ).append("\n"); 
		query.append("  #if(${f_include_ts} =='Y' && ${f_chkprd} =='M' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("         AND V.COST_YRMON   = @[f_year]||@[f_mon]" ).append("\n"); 
		query.append("         AND A2.COST_YRMON  BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("         AND NVL(V.delt_flg,'N') = 'N'" ).append("\n"); 
		query.append("         AND V.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("         AND V.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND V.DIR_CD       = B.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND B.BKG_NO       = A2.BKG_NO" ).append("\n"); 
		query.append("  #elseif(${f_include_ts} =='Y' && ${f_chkprd} =='W' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("         AND SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("         AND NVL(V.delt_flg,'N')   = 'N'" ).append("\n"); 
		query.append("         AND V.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("         AND V.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND V.DIR_CD       = B.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND B.BKG_NO       = A2.BKG_NO" ).append("\n"); 
		query.append("    #if(${f_sls_mon} !='')" ).append("\n"); 
		query.append("    	 AND V.SLS_YRMON    = @[f_year]||@[f_sls_mon]    " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("         AND A2.SLS_YRMON   BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("  #elseif((${f_include_ts} !='Y' && ${f_chkprd} =='M') || (${f_include_ts} =='Y' && ${f_chkprd} =='M' && ${f_rlane_cd} == 'RBCCO'))    " ).append("\n"); 
		query.append("         AND A2.COST_YRMON  = @[f_year]||@[f_mon] " ).append("\n"); 
		query.append("         AND A2.COST_YRMON  BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("  #elseif ((${f_include_ts} !='Y' && ${f_chkprd} =='W') || (${f_include_ts} =='Y' && ${f_chkprd} =='W' && ${f_rlane_cd} == 'RBCCO'))  " ).append("\n"); 
		query.append("    	 AND SUBSTR(A2.SLS_YRMON,1,4)||A2.COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("    	  " ).append("\n"); 
		query.append("    #if(${f_sls_mon} !='')" ).append("\n"); 
		query.append("    	 AND A2.SLS_YRMON   = @[f_year]||@[f_sls_mon]    " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("         AND A2.SLS_YRMON     BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 AND MRB.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_fixed_rate} == 'Y')" ).append("\n"); 
		query.append("	AND MRB.FX_RT_FLG = 'Y'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_ofc_vw} =='C')	" ).append("\n"); 
		query.append("    	 AND A2.AGMT_SGN_OFC_CD = A4.OFC_CD" ).append("\n"); 
		query.append("  #elseif (${f_ofc_vw} =='L')	" ).append("\n"); 
		query.append("	     AND A2.SLS_OFC_CD = A4.OFC_CD" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("	     AND 1 = 0" ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("         AND A2.CMDT_CD       = A3.CMDT_CD(+)  " ).append("\n"); 
		query.append("         AND A2.REP_CMDT_CD   = A5.REP_CMDT_CD(+) " ).append("\n"); 
		query.append("         AND NVL(A2.DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("         AND A2.BKG_STS_CD    IN ('F','S',DECODE(@[f_bkg_sts],'Y', 'W')) " ).append("\n"); 
		query.append("         AND A2.BKG_CGO_TP_CD <> 'P' " ).append("\n"); 
		query.append("         AND A2.BL_NO_TP      IN ('M','0')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         AND A2.RLANE_CD = R.RLANE_CD" ).append("\n"); 
		query.append("         AND A2.DIR_CD = R.DIR_CD" ).append("\n"); 
		query.append("         AND A2.IOC_CD = R.IOC_CD" ).append("\n"); 
		query.append("         AND A2.TRD_CD = R.TRD_CD" ).append("\n"); 
		query.append("         AND R.DELT_FLG = 'N' 	  " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		 AND A2.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_ofc_cd} !='')" ).append("\n"); 
		query.append("    #if(${f_excl_sts} =='')" ).append("\n"); 
		query.append("         AND DECODE(@[f_ofc_lvl],'1',A4.OFC_N1ST_LVL_CD,'2',A4.OFC_N2ND_LVL_CD,'3',A4.OFC_N3RD_LVL_CD,'4',A4.OFC_N4TH_LVL_CD,'5',A4.OFC_N5TH_LVL_CD,'6',A4.OFC_N6TH_LVL_CD,'7',A4.OFC_N7TH_LVL_CD) = @[f_ofc_cd] " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("         AND A4.OFC_CD = @[f_ofc_cd] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_ofc_lvl}=='6' || ${f_ofc_lvl}=='7')" ).append("\n"); 
		query.append("         AND A4.OFC_LVL = @[f_ofc_lvl]" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("         AND A4.OFC_LVL < '9'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_include_ts} == 'Y' && ${f_rlane_cd} != 'RBCCO')" ).append("\n"); 
		query.append("  #if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("         AND V.VSL_CD  = @[f_vsl_cd] " ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("  #if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("         AND V.SKD_VOY_NO     = @[f_skd_voy_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("         AND V.DIR_CD         = @[f_skd_dir_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_trd_cd} !='')" ).append("\n"); 
		query.append("         AND V.TRD_CD         = @[f_trd_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("         AND V.RLANE_CD       = @[f_rlane_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_ioc_cd} !='')" ).append("\n"); 
		query.append("         AND V.IOC_CD         = @[f_ioc_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("         AND V.DIR_CD         = @[f_dir_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#elseif(${f_include_ts} == 'Y' && ${f_rlane_cd} == 'RBCCO')" ).append("\n"); 
		query.append("	#if(${f_trd_cd} !='' && ${f_rlane_cd} !='')" ).append("\n"); 
		query.append("         AND @[f_trd_cd]||@[f_rlane_cd] IN (A2.N1ST_TRD_CD||A2.N1ST_RLANE_CD, A2.N2ND_TRD_CD||A2.N2ND_RLANE_CD, A2.N3RD_TRD_CD||A2.N3RD_RLANE_CD, A2.N4TH_TRD_CD||A2.N4TH_RLANE_CD)" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  #if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("         AND A2.VSL_CD  = @[f_vsl_cd] " ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("  #if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("         AND A2.SKD_VOY_NO     = @[f_skd_voy_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_skd_dir_cd} !='')" ).append("\n"); 
		query.append("         AND A2.DIR_CD         = @[f_skd_dir_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_trd_cd} !='')" ).append("\n"); 
		query.append("         AND A2.TRD_CD         = @[f_trd_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_sub_trd_cd} !='')" ).append("\n"); 
		query.append("         AND A2.SUB_TRD_CD         = @[f_sub_trd_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("         AND A2.RLANE_CD       = @[f_rlane_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_ioc_cd} !='')" ).append("\n"); 
		query.append("         AND A2.IOC_CD         = @[f_ioc_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("         AND A2.DIR_CD         = @[f_dir_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_bkg_por_cd} !='')" ).append("\n"); 
		query.append("         AND A2.BKG_POR_CD     LIKE @[f_bkg_por_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rev_pol_cd} !='')" ).append("\n"); 
		query.append("         AND A2.REV_POL_CD     LIKE @[f_rev_pol_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rev_pod_cd} !='')" ).append("\n"); 
		query.append("         AND A2.REV_POD_CD     LIKE @[f_rev_pod_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_bkg_del_cd} !='')" ).append("\n"); 
		query.append("         AND A2.BKG_DEL_CD     LIKE @[f_bkg_del_cd] || '%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_shpr_cd} !='')" ).append("\n"); 
		query.append("         AND A2.SHPR_CNT_CD||A2.SHPR_CUST_SEQ = @[f_shpr_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_sc_no} !='')" ).append("\n"); 
		query.append("         AND A2.SC_NO          = @[f_sc_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rfa_no} !='')" ).append("\n"); 
		query.append("         AND A2.RFA_NO         = @[f_rfa_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_taa_no} !='')" ).append("\n"); 
		query.append("         AND A2.TAA_NO         = @[f_taa_no] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_rep_cmdt_cd} !='')" ).append("\n"); 
		query.append("         AND A2.REP_CMDT_CD    = @[f_rep_cmdt_cd] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${f_usa_bkg_mod_cd} !='')" ).append("\n"); 
		query.append("         AND A2.USA_BKG_MOD_CD = @[f_usa_bkg_mod_cd] " ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_cntr_tpsz_cd} !='')" ).append("\n"); 
		query.append("         AND A2.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_hul_bnd_cd} !='')" ).append("\n"); 
		query.append("    	 AND R.HUL_BND_CD = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("    	 AND A2.BKG_NO         = A6.BKG_NO(+)" ).append("\n"); 
		query.append("         AND A2.CNTR_TPSZ_CD   = A6.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("         AND A2.COST_ROUT_NO   = A6.COST_ROUT_NO(+)" ).append("\n"); 
		query.append("   	 " ).append("\n"); 
		query.append("       GROUP BY " ).append("\n"); 
		query.append("               A2.COST_YRMON " ).append("\n"); 
		query.append("              ,A2.SLS_YRMON  " ).append("\n"); 
		query.append("              ,A2.COST_WK " ).append("\n"); 
		query.append("              ,A2.BKG_NO " ).append("\n"); 
		query.append("			  ,MRB.FX_RT_FLG" ).append("\n"); 
		query.append("              ,DECODE(SUBSTR(A2.BL_NO, 1, 4), 'KOSA', 'K' || A2.BKG_NO, A2.BL_NO || A2.BL_NO_TP || A2.BL_NO_CHK)   " ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO')	" ).append("\n"); 
		query.append("              ,V.COST_YRMON" ).append("\n"); 
		query.append("              ,V.COST_WK" ).append("\n"); 
		query.append("              ,V.TRD_CD" ).append("\n"); 
		query.append("              ,V.RLANE_CD" ).append("\n"); 
		query.append("              ,V.DIR_CD" ).append("\n"); 
		query.append("              ,V.VSL_CD" ).append("\n"); 
		query.append("              ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,V.IOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,A2.TRD_CD  " ).append("\n"); 
		query.append("              ,A2.SUB_TRD_CD " ).append("\n"); 
		query.append("              ,A2.RLANE_CD  " ).append("\n"); 
		query.append("              ,A2.IOC_CD  " ).append("\n"); 
		query.append("              ,A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD  " ).append("\n"); 
		query.append("              ,A2.DIR_CD" ).append("\n"); 
		query.append("              ,MAS_GET_CD_NM_FNC('CD03217', R.HUL_BND_CD)" ).append("\n"); 
		query.append("              ,A2.CTRT_HQ_OFC_CD  " ).append("\n"); 
		query.append("              ,A2.CTRT_RGN_OFC_CD  " ).append("\n"); 
		query.append("              ,A2.CTRT_OFC_CD " ).append("\n"); 
		query.append("              ,A2.CTRT_SREP_CD  " ).append("\n"); 
		query.append("              ,A2.RHQ_CD  " ).append("\n"); 
		query.append("              ,A2.RGN_OFC_CD  " ).append("\n"); 
		query.append("              ,A2.SLS_OFC_CD  " ).append("\n"); 
		query.append("              ,A2.SREP_CD " ).append("\n"); 
		query.append("              ,A2.BKG_OFC_CD   " ).append("\n"); 
		query.append("              ,A2.BKG_STS_CD   " ).append("\n"); 
		query.append("              ,A2.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("              ,A2.REV_POL_CD" ).append("\n"); 
		query.append("              ,A2.REV_POD_CD " ).append("\n"); 
		query.append("              ,A2.BKG_POR_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_POL_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_POD_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_DEL_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_RCV_TERM_CD  " ).append("\n"); 
		query.append("              ,A2.BKG_DE_TERM_CD  " ).append("\n"); 
		query.append("              ,A2.REP_CMDT_CD /*4400*/  " ).append("\n"); 
		query.append("              ,A5.REP_CMDT_NM  " ).append("\n"); 
		query.append("              ,A2.CMDT_CD /*440906  */" ).append("\n"); 
		query.append("              ,A3.CMDT_NM  " ).append("\n"); 
		query.append("              ,R.IAS_RGN_CD " ).append("\n"); 
		query.append("              ,A2.N1ST_TRD_CD   " ).append("\n"); 
		query.append("              ,A2.N2ND_TRD_CD   " ).append("\n"); 
		query.append("              ,A2.N3RD_TRD_CD   " ).append("\n"); 
		query.append("              ,A2.N4TH_TRD_CD   " ).append("\n"); 
		query.append("              ,A2.N1ST_RLANE_CD  " ).append("\n"); 
		query.append("              ,A2.N2ND_RLANE_CD  " ).append("\n"); 
		query.append("              ,A2.N3RD_RLANE_CD  " ).append("\n"); 
		query.append("              ,A2.N4TH_RLANE_CD  " ).append("\n"); 
		query.append("              ,A2.N1ST_FINC_VVD_CD  " ).append("\n"); 
		query.append("              ,A2.N2ND_FINC_VVD_CD  " ).append("\n"); 
		query.append("              ,A2.N3RD_FINC_VVD_CD  " ).append("\n"); 
		query.append("              ,A2.N4TH_FINC_VVD_CD  " ).append("\n"); 
		query.append("              ,A2.N1ST_POL_CD  " ).append("\n"); 
		query.append("              ,A2.N2ND_POL_CD  " ).append("\n"); 
		query.append("              ,A2.N3RD_POL_CD  " ).append("\n"); 
		query.append("              ,A2.N4TH_POL_CD  " ).append("\n"); 
		query.append("              ,A2.N1ST_POD_CD  " ).append("\n"); 
		query.append("              ,A2.N2ND_POD_CD  " ).append("\n"); 
		query.append("              ,A2.N3RD_POD_CD  " ).append("\n"); 
		query.append("              ,A2.N4TH_POD_CD   " ).append("\n"); 
		query.append("              ,A2.SC_NO " ).append("\n"); 
		query.append("              ,A2.RFA_NO " ).append("\n"); 
		query.append("              ,A2.CUST_TP_CD  " ).append("\n"); 
		query.append("              ,A2.AGMT_CUST_TP_CD  " ).append("\n"); 
		query.append("              ,A2.AGMT_CNT_CD || TO_CHAR(LPAD(DECODE(A2.AGMT_CUST_SEQ,0,'',A2.AGMT_CUST_SEQ),6,'0'))   /* SC_CUSTOMER CD*/  " ).append("\n"); 
		query.append("              ,A2.AGMT_CNT_CD   " ).append("\n"); 
		query.append("              ,A2.AGMT_CUST_SEQ   " ).append("\n"); 
		query.append("              ,A2.CUST_GRP_ID" ).append("\n"); 
		query.append("              --,A2.CUST_GRP_NM " ).append("\n"); 
		query.append("              ,A2.AGMT_PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("              ,A2.AGMT_CUST_SEQ -- C.CUSTOMER" ).append("\n"); 
		query.append("              ,A2.AGMT_CNT_CD   -- C.CUSTOMER  " ).append("\n"); 
		query.append("              ,A2.AGMT_ACT_CNT_CD || TO_CHAR(LPAD(DECODE(A2.AGMT_ACT_CUST_SEQ,0,'',A2.AGMT_ACT_CUST_SEQ),6,'0')) /*ACT_CUSTOMER_CD */" ).append("\n"); 
		query.append("              ,A2.ACT_CUST_NM" ).append("\n"); 
		query.append("              ,A2.SHPR_CNT_CD || TO_CHAR(LPAD(DECODE(A2.SHPR_CUST_SEQ,0,'',A2.SHPR_CUST_SEQ),6,'0')) /* SHPR_CD*/" ).append("\n"); 
		query.append("              ,A2.SHPR_CNT_CD   " ).append("\n"); 
		query.append("              ,A2.SHPR_CUST_SEQ   " ).append("\n"); 
		query.append("              ,A2.SHPR_NM /* BL_SHPR_NM*/ " ).append("\n"); 
		query.append("              ,A2.CNEE_CNT_CD || TO_CHAR(LPAD(DECODE(A2.CNEE_CUST_SEQ,0,'',A2.CNEE_CUST_SEQ),6,'0')) /* CNEE_CD*/" ).append("\n"); 
		query.append("              ,A2.CNEE_CNT_CD   " ).append("\n"); 
		query.append("              ,A2.CNEE_CUST_SEQ  " ).append("\n"); 
		query.append("              ,A2.NTFY_CNT_CD || TO_CHAR(LPAD(DECODE(A2.NTFY_CUST_SEQ,0,'',A2.NTFY_CUST_SEQ),6,'0')) /* NTFY_CD */" ).append("\n"); 
		query.append("              ,A2.NTFY_CNT_CD   " ).append("\n"); 
		query.append("              ,A2.NTFY_CUST_SEQ   " ).append("\n"); 
		query.append("              ,A2.OFT_TP_CD  /* PPD_CCT*/" ).append("\n"); 
		query.append("              ,TO_CHAR(A2.OBRD_DT,'YYYY-MM-DD') /*BL_ONBOARD_DT */" ).append("\n"); 
		query.append("              ,TO_CHAR(C.CGO_RCV_DT,'YYYY-MM-DD') /*CGO_RCV_DT */" ).append("\n"); 
		query.append("              ,A2.SOC_FLG  " ).append("\n"); 
		query.append("              ,DECODE(A2.BKG_CGO_TP_CD, 'R', 'Y', 'N')" ).append("\n"); 
		query.append("              ,NVL(A2.SPCL_RC_FLG, 'N')  " ).append("\n"); 
		query.append("              ,NVL(A2.SPCL_DG_CGO_FLG, 'N') " ).append("\n"); 
		query.append("              ,NVL(A2.SPCL_BB_CGO_FLG, 'N') " ).append("\n"); 
		query.append("              ,NVL(A2.SPCL_AWK_CGO_FLG, 'N')  " ).append("\n"); 
		query.append("              ,TO_CHAR(A2.BKG_CGO_WGT) " ).append("\n"); 
		query.append("              ,A2.BKG_WGT_TP_CD" ).append("\n"); 
		query.append("  #if(${f_include_ts} =='Y' && ${f_rlane_cd} != 'RBCCO' )" ).append("\n"); 
		query.append("              ,V.TRD_CD||V.RLANE_CD||V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("              ,A2.TRD_CD||A2.RLANE_CD||A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("              ,MAS_PSG_TS_ARRAY_FNC(a2.n1st_trd_cd," ).append("\n"); 
		query.append("                              DECODE (MAS_SLAN_CONTI_CONV_FNC(A2.n1st_finc_vvd_cd,substr(A2.N1ST_RLANE_CD,1,3),SUBSTR (A2.n1st_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,MAS_SLAN_CONTI_CONV_FNC(A2.n1st_finc_vvd_cd,substr(A2.N1ST_RLANE_CD,1,3),SUBSTR (A2.n1st_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n1st_rlane_cd, SUBSTR (A2.n1st_finc_vvd_cd, 1, 9), A2.n1st_pol_cd, A2.n1st_pod_cd, --1" ).append("\n"); 
		query.append("                              a2.n2nd_trd_cd," ).append("\n"); 
		query.append("                              DECODE (MAS_SLAN_CONTI_CONV_FNC(A2.n2nd_finc_vvd_cd,substr(A2.N2nd_RLANE_CD,1,3),SUBSTR (A2.n2nd_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,MAS_SLAN_CONTI_CONV_FNC(A2.n2nd_finc_vvd_cd,substr(A2.n2nd_RLANE_CD,1,3),SUBSTR (A2.n2nd_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n2nd_rlane_cd, SUBSTR (A2.n2nd_finc_vvd_cd, 1, 9), A2.n2nd_pol_cd, A2.n2nd_pod_cd, --2" ).append("\n"); 
		query.append("                              a2.n3rd_trd_cd," ).append("\n"); 
		query.append("                              DECODE (MAS_SLAN_CONTI_CONV_FNC(A2.n3rd_finc_vvd_cd,substr(A2.n3rd_RLANE_CD,1,3),SUBSTR (A2.n3rd_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,MAS_SLAN_CONTI_CONV_FNC(A2.n3rd_finc_vvd_cd,substr(A2.n3rd_RLANE_CD,1,3),SUBSTR (A2.n3rd_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n3rd_rlane_cd, SUBSTR (A2.n3rd_finc_vvd_cd, 1, 9), A2.n3rd_pol_cd, A2.n3rd_pod_cd, --3" ).append("\n"); 
		query.append("                              a2.n4th_trd_cd," ).append("\n"); 
		query.append("                              DECODE (MAS_SLAN_CONTI_CONV_FNC(A2.n4th_finc_vvd_cd,substr(A2.n4th_RLANE_CD,1,3),SUBSTR (A2.n4th_ioc_conti_cd, 1, 1))" ).append("\n"); 
		query.append("                                     ,MAS_SLAN_CONTI_CONV_FNC(A2.n4th_finc_vvd_cd,substr(A2.n4th_RLANE_CD,1,3),SUBSTR (A2.n4th_ioc_conti_cd, 2, 1)), 'I' ,'O')," ).append("\n"); 
		query.append("                              A2.n4th_rlane_cd, SUBSTR (A2.n4th_finc_vvd_cd, 1, 9), A2.n4th_pol_cd, A2.n4th_pod_cd --4" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("              ,A4.OFC_APLY_FM_YRMON" ).append("\n"); 
		query.append("              ,A4.OFC_APLY_TO_YRMON         " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${f_include_ts} =='Y')" ).append("\n"); 
		query.append("   AND @[f_trd_cd]||@[f_rlane_cd] IN ((SUBSTR(VVD_INFO,1,3)||SUBSTR(VVD_INFO,5,5)), (SUBSTR(VVD_INFO,29,3)||SUBSTR(VVD_INFO,33,5)), (SUBSTR(VVD_INFO,57,3)||SUBSTR(VVD_INFO,61,5)), (SUBSTR(VVD_INFO,85,3)||SUBSTR(VVD_INFO,89,5)), (SUBSTR(VVD_INFO,113,3)||SUBSTR(VVD_INFO,117,5)))" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}