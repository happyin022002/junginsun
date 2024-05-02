/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRPTDBDAOSearchInqSrcDtAcct0035ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
	  * @SJH.20140814 : COA_BKG_EXPN_DTL_WK 삭제
	  * @SJH.20141023 : SLT_INTER_PRC_AMT 추가
	  * @SJH.20141215 : GROUP BY 정리 및 필드 그룹함수 추가
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
		params.put("f_svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bkg_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
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
		query.append("    , 'S.MONTH' SLS_YRMON" ).append("\n"); 
		query.append("    , 'WEEK'  COST_WK" ).append("\n"); 
		query.append("    , 'BKG NO'  BKG_NO" ).append("\n"); 
		query.append("    , '1ST SAILING DATE' N1ST_SAIL_DT				--SJH.20141217.ADD" ).append("\n"); 
		query.append("    , 'BL NO'  			BL_NO" ).append("\n"); 
		query.append("    , 'BL TYPE' 		BL_NO_TP					--SJH.20141217.ADD : BL_NO_TP, CNTR_TPSZ_CD, SVC_SCP_CD, SUB_TRD_CD" ).append("\n"); 
		query.append("    , 'TYPE/SIZE'		CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    , 'SERVICE SCOPE'	SVC_SCP_CD" ).append("\n"); 
		query.append("    , 'TRADE'  TRD_CD" ).append("\n"); 
		query.append("    , 'SUB TRADE'		SUB_TRD_CD" ).append("\n"); 
		query.append("    , 'R.LANE'  RLANE_CD" ).append("\n"); 
		query.append("    , 'IOC'  IOC_CD" ).append("\n"); 
		query.append("    , 'REV VVD'  R_VVD " ).append("\n"); 
		query.append("    , 'DIR'  DIR_CD" ).append("\n"); 
		query.append("    , 'C.RHQ'  C_RHQ" ).append("\n"); 
		query.append("    , 'C.AD'  C_AD" ).append("\n"); 
		query.append("    , 'C.OFC'  C_OFC" ).append("\n"); 
		query.append("    , 'C.S.REP'  CSREP_CD" ).append("\n"); 
		query.append("    , 'L.RHQ'  L_RHQ" ).append("\n"); 
		query.append("    , 'L.AD'  L_AD" ).append("\n"); 
		query.append("    , 'L.OFC'  L_OFC" ).append("\n"); 
		query.append("    , 'L.REP'  LREP_CD" ).append("\n"); 
		query.append("    , 'BKG OFC'  BKG_OFC_CD" ).append("\n"); 
		query.append("    , 'BKG STS'  BKG_STS_CD" ).append("\n"); 
		query.append("    , 'USA MODE'  USA_MODE" ).append("\n"); 
		query.append("    , 'POR'  BKG_POR_CD" ).append("\n"); 
		query.append("    , '1ST POL'  BKG_POL_CD							--SJH.20141217.MOD" ).append("\n"); 
		query.append("    , 'LAST POD'  BKG_POD_CD" ).append("\n"); 
		query.append("    , 'DEL'  BKG_DEL_CD" ).append("\n"); 
		query.append("    , 'RCV TERM'  BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("    , 'DEL TERM'  BKG_DE_TERM_CD" ).append("\n"); 
		query.append("    , 'REP CMDT CD'  REP_CMDT_CD" ).append("\n"); 
		query.append("    , 'REP CMDT DESC'  REP_CMDT_NM" ).append("\n"); 
		query.append("    , 'CMDT CD'  CMDT_CD" ).append("\n"); 
		query.append("    , 'CMDT DESC'  CMDT_NM" ).append("\n"); 
		query.append("    , 'TRADE1'  N1ST_TRD_CD" ).append("\n"); 
		query.append("    , 'TRADE2'  N2ND_TRD_CD" ).append("\n"); 
		query.append("    , 'TRADE3'  N3RD_TRD_CD" ).append("\n"); 
		query.append("    , 'TRADE4'  N4TH_TRD_CD" ).append("\n"); 
		query.append("    , 'LANE1'  N1ST_RLANE_CD" ).append("\n"); 
		query.append("    , 'LANE2'  N2ND_RLANE_CD" ).append("\n"); 
		query.append("    , 'LANE3'  N3RD_RLANE_CD" ).append("\n"); 
		query.append("    , 'LANE4'  N4TH_RLANE_CD" ).append("\n"); 
		query.append("    , 'VVD1'  N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("    , 'VVD2'  N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("    , 'VVD3'  N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("    , 'VVD4'  N4TH_FINC_VVD_CD" ).append("\n"); 
		query.append("    , 'POL1'  N1ST_POL_CD" ).append("\n"); 
		query.append("    , 'POL2'  N2ND_POL_CD" ).append("\n"); 
		query.append("    , 'POL3'  N3RD_POL_CD" ).append("\n"); 
		query.append("    , 'POL4'  N4TH_POL_CD" ).append("\n"); 
		query.append("    , 'POD1'  N1ST_POD_CD" ).append("\n"); 
		query.append("    , 'POD2'  N2ND_POD_CD" ).append("\n"); 
		query.append("    , 'POD3'  N3RD_POD_CD" ).append("\n"); 
		query.append("    , 'POD4'  N4TH_POD_CD" ).append("\n"); 
		query.append("    , 'TRUNK POL'			REV_POL_CD				--SJH.20141217.ADD" ).append("\n"); 
		query.append("	, 'TRUNK POD'			REV_POD_CD" ).append("\n"); 
		query.append("	, 'LAST VVD'			LAST_VVD" ).append("\n"); 
		query.append("	, 'LAST TRADE'			LAST_TRADE" ).append("\n"); 
		query.append("	, 'LAST LANE'			LAST_LANE" ).append("\n"); 
		query.append("	, 'EMPTY PICK UP'		MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("	, 'EMPTY RETURN'		MTY_RTN_YD_CD" ).append("\n"); 
		query.append("    , 'SC NO'  SC_NO" ).append("\n"); 
		query.append("    , 'RFA NO'  RFA_NO" ).append("\n"); 
		query.append("    , 'TAA NO'				TAA_NO					--SJH.20141217.ADD" ).append("\n"); 
		query.append("    , 'NVOCC'  NVOCC" ).append("\n"); 
		query.append("    , 'SC/RFA CUST TP'  CUST_TP						--SJH.20141217.MOD" ).append("\n"); 
		query.append("    , 'SC/RFC CUST CD'  SC_CUST_CD" ).append("\n"); 
		query.append("    , 'SC/RFC CUST NM'  SC_CUST_NM" ).append("\n"); 
		query.append("    , 'SC/RFA GROUP CUST NM'					CUST_GRP_NM				--SJH.20141218.ADD" ).append("\n"); 
		query.append("    , 'SC/RFA CUST NEED BASE SEG. CLASS 1'		NBS_CLSS_CD1" ).append("\n"); 
		query.append("	, 'SC/RFA CUST NEED BASE SEG. CLASS 2'		NBS_CLSS_CD2" ).append("\n"); 
		query.append("	, 'SC/RFA CUST NEED BASE SEG. CLASS 3'		NBS_CLSS_CD3" ).append("\n"); 
		query.append("	, 'SC/RFA CUST KEY ACCOUNT FLAG'			CUST_KEY_AGMT_MGR_FLG" ).append("\n"); 
		query.append("    , 'BKG SHPR_CD'  SHPR_CD" ).append("\n"); 
		query.append("    , 'BKG SHPR_NM'  SHPR_NM" ).append("\n"); 
		query.append("	, 'B/L SHPR TP'  BL_SHPR_TP" ).append("\n"); 
		query.append("    , 'B/L SHPR NM'  BL_SHPR_NM" ).append("\n"); 
		query.append("    , 'CNEE CD'  CNEE_CD" ).append("\n"); 
		query.append("    , 'CNEE NM'  CNEE_NM" ).append("\n"); 
		query.append("    , 'NOTIFY CD'  NTFY_CD" ).append("\n"); 
		query.append("    , 'NOTIFY NM'  NTFY_NM" ).append("\n"); 
		query.append("    , 'PRD CCT'  PPD_CCT" ).append("\n"); 
		query.append("    , 'BL ON BOARD DT'  BL_ONBOARD_DT" ).append("\n"); 
		query.append("    , 'CGO RCV DT'  CGO_RCV_DT" ).append("\n"); 
		query.append("    , 'SOC'  SOC" ).append("\n"); 
		query.append("    , 'REV MT'  REV_MT    " ).append("\n"); 
		query.append("    , 'DG'  DG" ).append("\n"); 
		query.append("    , 'RF'  RF		--SJH.20141111.ADD, SJH.20141217.MOD" ).append("\n"); 
		query.append("    , 'BB'  BB" ).append("\n"); 
		query.append("    , 'AK'  AK" ).append("\n"); 
		query.append("    , 'AUTO RATING DATE'	AUTO_RAT_DT				--SJH.2014121.ADD" ).append("\n"); 
		query.append("    , 'CARGO WEIGHT'  		WEIGHT" ).append("\n"); 
		query.append("    , 'TARE WEIGHT'			TARE_WEIGHT" ).append("\n"); 
		query.append("    , 'CARGO WEGHT UNIT' 	UNIT" ).append("\n"); 
		query.append("    , 'TARE WEIGHT UNIT'	TARE_WEIGHT_UNIT" ).append("\n"); 
		query.append("    , 'QUANTITY'			QUANTITY" ).append("\n"); 
		query.append("    , 'TEU'					TEU" ).append("\n"); 
		query.append("    , 'FR_REV'				FR_REV" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("  --#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("  --  ,'FR_$key' REV_$key" ).append("\n"); 
		query.append("  --#end " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  --,'FR_REV_TTL' TOT_FR_REV_TPSZ" ).append("\n"); 
		query.append("    ,'MISC_REV_TTL' TOT_MISC_REV_TPSZ" ).append("\n"); 
		query.append("    ,'REV_TTL' TOT_REV_TPSZ" ).append("\n"); 
		query.append("  --#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("  --  ,'LOAD_$key' QTY_$key" ).append("\n"); 
		query.append("  --#end  " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  --,'LOAD_TTL(TEU)' TOT_QTY" ).append("\n"); 
		query.append("  --,'Freight Revenue' FREIGTH_REV" ).append("\n"); 
		query.append("  --,'Misc Operation Revenue' MISC_REV" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O')      " ).append("\n"); 
		query.append("    ,'CNTR DEM/DET' DMDT_COST" ).append("\n"); 
		query.append("	#end		" ).append("\n"); 
		query.append("    --SJH.20141217.ADD" ).append("\n"); 
		query.append("    ,'OB BASIC STEVEDORAGE' 			OB_BASIC_STEVEDORAGE" ).append("\n"); 
		query.append("    ,'IB BASIC STEVEDORAGE' 			IB_BASIC_STEVEDORAGE" ).append("\n"); 
		query.append("    ,'OB ON DOCK CY EXPENSE' 			OB_DCK_CY_HNDL_COM_AMT" ).append("\n"); 
		query.append("    ,'OB CARGO HANDLING EXPENSE' 		OB_CGO_HNDL_COM_AMT" ).append("\n"); 
		query.append("    ,'OB STORAGE' 						OB_FCNTR_STO_COM_AMT" ).append("\n"); 
		query.append("    ,'OB MISC CARGO HANDLING EXPENSE' 	OB_MISC_CGO_HNDL_COM_AMT" ).append("\n"); 
		query.append("    ,'IB ON DOCK CY EXPENSE' 			IB_DCK_CY_HNDL_COM_AMT" ).append("\n"); 
		query.append("    ,'IB CARGO HANDLING EXPENSE' 		IB_CGO_HNDL_COM_AMT" ).append("\n"); 
		query.append("    ,'IB STORAGE' 						IB_FCNTR_STO_COM_AMT" ).append("\n"); 
		query.append("    ,'IB MISC CARGO HANDLING EXPENSE' 	IB_MISC_CGO_HNDL_COM_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,'TS STEVEDORAGE' 					TS_STVG_COM_AMT" ).append("\n"); 
		query.append("	,'TS OTHER CY EXPENSE' 				TS_OTHER_CY_EXPENSE" ).append("\n"); 
		query.append("	,'TS ON DOCK CY EXPENSE' 			TS_DCK_CY_HNDL_COM_AMT" ).append("\n"); 
		query.append("	,'TS CARGO HANDLING EXPENSE' 		TS_CGO_HNDL_COM_AMT" ).append("\n"); 
		query.append("	,'TS STORAGE' 						TS_FCNTR_STO_COM_AMT" ).append("\n"); 
		query.append("    ,'CARGO VARIABLE VOLUME DISCOUNT' 	CGO_VAR_VOL_DC_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'OB RAIL TRUCK' 					OB_FULL_RAIL_TRK_COM_AMT" ).append("\n"); 
		query.append("    ,'OB RAIL DIRECT' 					OB_FULL_RAIL_DIR_COM_AMT" ).append("\n"); 
		query.append("    ,'OB TRUCK DIRECT' 					OB_FULL_TRK_DIR_COM_AMT" ).append("\n"); 
		query.append("    ,'OB WATER DIRECT' 					OB_FULL_WTR_DIR_COM_AMT" ).append("\n"); 
		query.append("    ,'OB WATER RAIL' 					OB_FULL_WTR_RAIL_COM_AMT" ).append("\n"); 
		query.append("    ,'OB WATER TRUCK' 					OB_FULL_WTR_TRK_COM_AMT" ).append("\n"); 
		query.append("    ,'OB OTHER TRANSPORT EXPENSE' 		OB_FULL_TRSP_OTR_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'IB RAIL TRUCK' 					IB_FULL_RAIL_TRK_COM_AMT" ).append("\n"); 
		query.append("    ,'IB RAIL DIRECT' 					IB_FULL_RAIL_DIR_COM_AMT" ).append("\n"); 
		query.append("    ,'IB TRUCK DIRECT' 					IB_FULL_TRK_DIR_COM_AMT" ).append("\n"); 
		query.append("    ,'IB WATER DIRECT' 					IB_FULL_WTR_DIR_COM_AMT" ).append("\n"); 
		query.append("    ,'IB WATER RAIL' 					IB_FULL_WTR_RAIL_COM_AMT" ).append("\n"); 
		query.append("    ,'IB WATER TRUCK' 					IB_FULL_WTR_TRK_COM_AMT" ).append("\n"); 
		query.append("    ,'IB OTHER TRANSPORT EXPENSE' 		IB_FULL_TRSP_OTR_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'TS FULL TRANSPORT EXPENSE' 		TS_FULL_TRSP_COM_AMT" ).append("\n"); 
		query.append("	,'TS OTHER TRANSPORT EXPENSE' 		TS_FULL_TRSP_OTR_AMT" ).append("\n"); 
		query.append("	,'OB EMPTY REPOSITIONING COST A' 	OB_MTY_PA_AMT" ).append("\n"); 
		query.append("	,'IB EMPTY REPOSITIONING COST A' 	IB_MTY_PA_AMT" ).append("\n"); 
		query.append("	,'OB EMPTY REPOSITIONING COST B' 	OB_MTY_PA_AMT2" ).append("\n"); 
		query.append("	,'IB EMPTY REPOSITIONING COST B' 	IB_MTY_PA_AMT2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'OB AGENCY COMMISSION' 			OB_AC_COM_AMT" ).append("\n"); 
		query.append("	,'IB AGENCY COMMSISION' 			IB_AC_COM_AMT" ).append("\n"); 
		query.append("	,'T/S AGENCY COMMISSION' 			TS_AC_COM_AMT" ).append("\n"); 
		query.append("	,'FAC A/C' 							AC_FAC_AMT" ).append("\n"); 
		query.append("	,'CHF COMMISSION' 					AC_CHF_AMT" ).append("\n"); 
		query.append("	,'OTHER COMMISSION' 				AC_OTR_AMT" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  --#if (${f_pro_vw} =='P')" ).append("\n"); 
		query.append("  --  ,'Empty Reposition Expense(EPP A)' EMPTY_REPOSITION_EXPENSE_A	--SJH.20141111.MOD" ).append("\n"); 
		query.append("  --  ,'Empty Reposition Expense(EPP B)' EMPTY_REPOSITION_EXPENSE_B	--SJH.20141111.MOD" ).append("\n"); 
		query.append("  --#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("  --,'Agent Commission' AGENT_COMMISSION" ).append("\n"); 
		query.append("    ,'SLOT INTERNAL PRICING' SLT_INTER_PRC_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'MNR COST' 						CNTR_MNR_CHG_PA_AMT" ).append("\n"); 
		query.append("	,'REEFER COST' 						RF_COM_AMT" ).append("\n"); 
		query.append("	,'CHASSIS COST'						CHSS_FX_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_pro_vw} =='P')" ).append("\n"); 
		query.append("    ,'Variable Cost Total A' CM_COST_TOTAL_A		--SJH.20141111.MOD.ADD, SJH.20141217.MOD" ).append("\n"); 
		query.append("    ,'CM Total A' CM_A" ).append("\n"); 
		query.append("    ,'Variable Cost Total B' CM_COST_TOTAL_B" ).append("\n"); 
		query.append("    ,'CM Total B' CM_B" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  	" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O' && ${f_pro_vw} =='P' )			" ).append("\n"); 
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
		query.append("    ,'Chassis Insurance' CHASSIS_INSURANCE    " ).append("\n"); 
		query.append("  #end				" ).append("\n"); 
		query.append("  FROM DUAL " ).append("\n"); 
		query.append("  UNION ALL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("   A2.COST_YRMON  " ).append("\n"); 
		query.append("  ,A2.SLS_YRMON  " ).append("\n"); 
		query.append("  ,A2.COST_WK " ).append("\n"); 
		query.append("  ,A2.BKG_NO              									AS BKG_NO  " ).append("\n"); 
		query.append("  ,TO_CHAR(MAX(A6.N1ST_SAIL_DT),'YYYY-MM-DD HH24:MI:SS')   	AS N1ST_SAIL_DT		--SJH.20141215.ADD  " ).append("\n"); 
		query.append("  ,MAX(A2.BL_NO || A2.BL_NO_TP || A2.BL_NO_CHK) 			AS BL_NO  " ).append("\n"); 
		query.append("  ,MAX(A2.BL_NO_TP)											AS BL_NO_TP			--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,MAX(A2.CNTR_TPSZ_CD)      								AS CNTR_TPSZ_CD	" ).append("\n"); 
		query.append("  ,MAX(A6.SVC_SCP_CD)										AS SVC_SCP_CD" ).append("\n"); 
		query.append("  ,MAX(A2.TRD_CD)  									AS TRD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.SUB_TRD_CD)								AS SUB_TRD_CD				--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,MAX(A2.RLANE_CD)                               	AS RLANE_CD" ).append("\n"); 
		query.append("  ,MAX(A2.IOC_CD)                                 	AS IOC_CD " ).append("\n"); 
		query.append("  ,MAX(A2.VSL_CD || A2.SKD_VOY_NO || A2.DIR_CD)  	AS R_VVD  " ).append("\n"); 
		query.append("  ,MAX(A2.DIR_CD)  									AS DIR_CD" ).append("\n"); 
		query.append("  ,MAX(A2.CTRT_HQ_OFC_CD)                        	AS C_RHQ " ).append("\n"); 
		query.append("  ,MAX(A2.CTRT_RGN_OFC_CD)                       	AS C_AD " ).append("\n"); 
		query.append("  ,MAX(A2.CTRT_OFC_CD)                           	AS C_OFC " ).append("\n"); 
		query.append("  ,MAX(A2.CTRT_SREP_CD)                          	AS CSREP_CD " ).append("\n"); 
		query.append("  ,MAX(A2.RHQ_CD)                                	AS L_RHQ " ).append("\n"); 
		query.append("  ,MAX(A2.RGN_OFC_CD)                            	AS L_AD " ).append("\n"); 
		query.append("  ,MAX(A2.SLS_OFC_CD)                            	AS L_OFC " ).append("\n"); 
		query.append("  ,MAX(A2.SREP_CD)                               	AS LREP_CD  " ).append("\n"); 
		query.append("  ,MAX(A2.BKG_OFC_CD)                            	AS BKG_OFC_CD" ).append("\n"); 
		query.append("  ,MAX(A2.BKG_STS_CD)                            	AS BKG_STS_CD" ).append("\n"); 
		query.append("  ,MAX(A2.USA_BKG_MOD_CD)                        	AS USA_MODE " ).append("\n"); 
		query.append("  ,MAX(A2.BKG_POR_CD)                            	AS BKG_POR_CD" ).append("\n"); 
		query.append("  ,MAX(A2.BKG_POL_CD)                            	AS BKG_POL_CD" ).append("\n"); 
		query.append("  ,MAX(A2.BKG_POD_CD)                            	AS BKG_POD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.BKG_DEL_CD)                            	AS BKG_DEL_CD" ).append("\n"); 
		query.append("  ,MAX(A2.BKG_RCV_TERM_CD)                       	AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("  ,MAX(A2.BKG_DE_TERM_CD)                        	AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append("  ,MAX(A2.REP_CMDT_CD)                           	AS REP_CMDT_CD" ).append("\n"); 
		query.append("  ,MAX(A5.REP_CMDT_NM)                           	AS REP_CMDT_NM" ).append("\n"); 
		query.append("  ,MAX(A2.CMDT_CD)                               	AS CMDT_CD" ).append("\n"); 
		query.append("  ,MAX(A3.CMDT_NM)                               	AS CMDT_NM" ).append("\n"); 
		query.append("  ,MAX(A2.N1ST_TRD_CD)                           	AS N1ST_TRD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N2ND_TRD_CD)                           	AS N2ND_TRD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N3RD_TRD_CD)                           	AS N3RD_TRD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N4TH_TRD_CD)                           	AS N4TH_TRD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N1ST_RLANE_CD)                         	AS N1ST_RLANE_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N2ND_RLANE_CD)                         	AS N2ND_RLANE_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N3RD_RLANE_CD)                         	AS N3RD_RLANE_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N4TH_RLANE_CD)                         	AS N4TH_RLANE_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N1ST_FINC_VVD_CD)                      	AS N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N2ND_FINC_VVD_CD)                      	AS N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N3RD_FINC_VVD_CD)                      	AS N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N4TH_FINC_VVD_CD)                      	AS N4TH_FINC_VVD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N1ST_POL_CD)                           	AS N1ST_POL_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N2ND_POL_CD)                           	AS N2ND_POL_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N3RD_POL_CD)                           	AS N3RD_POL_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N4TH_POL_CD)                           	AS N4TH_POL_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N1ST_POD_CD)                           	AS N1ST_POD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N2ND_POD_CD)                           	AS N2ND_POD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N3RD_POD_CD)                           	AS N3RD_POD_CD" ).append("\n"); 
		query.append("  ,MAX(A2.N4TH_POD_CD)                           	AS N4TH_POD_CD" ).append("\n"); 
		query.append("  ,MAX(A6.REV_POL_CD)								AS REV_POL_CD				--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,MAX(A6.REV_POD_CD)								AS REV_POD_CD				--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,MAX(COALESCE(A2.N4TH_FINC_VVD_CD,A2.N3RD_FINC_VVD_CD,A2.N2ND_FINC_VVD_CD,A2.N1ST_FINC_VVD_CD)) 	AS LAST_VVD		--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,MAX(COALESCE(A2.N4TH_TRD_CD,A2.N3RD_TRD_CD,A2.N2ND_TRD_CD,A2.N1ST_TRD_CD)) 			 		 	AS LAST_TRADE	--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,MAX(COALESCE(A2.N4TH_RLANE_CD,A2.N3RD_RLANE_CD,A2.N2ND_RLANE_CD,A2.N1ST_RLANE_CD)) 			 	AS LAST_LANE	--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,MAX(A6.MTY_PKUP_YD_CD)							AS MTY_PKUP_YD_CD			--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,MAX(A6.MTY_RTN_YD_CD)							AS MTY_RTN_YD_CD			--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,MAX(A2.SC_NO)  									AS SC_NO" ).append("\n"); 
		query.append("  ,MAX(A2.RFA_NO)  									AS RFA_NO" ).append("\n"); 
		query.append("  ,MAX(A2.TAA_NO)									AS TAA_NO					--SJH.20141215.ADD				" ).append("\n"); 
		query.append("  ,MAX(DECODE(A2.CUST_TP_CD,'N','Y','N'))                               AS NVOCC " ).append("\n"); 
		query.append("  ,MAX(A2.AGMT_CUST_TP_CD)                          AS CUST_TP  " ).append("\n"); 
		query.append("  ,MAX(A2.AGMT_CNT_CD || TO_CHAR(LPAD(DECODE(A2.AGMT_CUST_SEQ,0,'',A2.AGMT_CUST_SEQ),6,'0')))  		AS SC_CUST_CD  " ).append("\n"); 
		query.append("  ,MAX((   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.AGMT_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.AGMT_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  )) AS SC_CUST_NM   " ).append("\n"); 
		query.append("  ,MAX(A8.CUST_GRP_NM)								AS CUST_GRP_NM				--SJH.20141218.ADD" ).append("\n"); 
		query.append("  ,MAX(A8.NBS_CLSS_CD1)								AS NBS_CLSS_CD1 " ).append("\n"); 
		query.append("  ,MAX(A8.NBS_CLSS_CD2)								AS NBS_CLSS_CD2 " ).append("\n"); 
		query.append("  ,MAX(A8.NBS_CLSS_CD3)								AS NBS_CLSS_CD3" ).append("\n"); 
		query.append("  ,MAX(A2.CUST_KEY_AGMT_MGR_FLG)					AS CUST_KEY_AGMT_MGR_FLG" ).append("\n"); 
		query.append("  ,MAX(A2.SHPR_CNT_CD || TO_CHAR(LPAD(DECODE(A2.SHPR_CUST_SEQ,0,'',A2.SHPR_CUST_SEQ),6,'0')))  		AS SHPR_CD   " ).append("\n"); 
		query.append("  ,MAX((   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.SHPR_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.SHPR_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  )) AS SHPR_NM" ).append("\n"); 
		query.append("  ,MAX(A2.CUST_TP_CD)								AS BL_SHPR_TP" ).append("\n"); 
		query.append("  ,MAX(A2.SHPR_NM)                                  AS BL_SHPR_NM  " ).append("\n"); 
		query.append("  ,MAX(A2.CNEE_CNT_CD || TO_CHAR(LPAD(DECODE(A2.CNEE_CUST_SEQ,0,'',A2.CNEE_CUST_SEQ),6,'0'))) 		AS CNEE_CD  " ).append("\n"); 
		query.append("  ,MAX((   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.CNEE_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.CNEE_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  )) AS CNEE_NM  /*CNEE   */" ).append("\n"); 
		query.append("  ,MAX(A2.NTFY_CNT_CD || TO_CHAR(LPAD(DECODE(A2.NTFY_CUST_SEQ,0,'',A2.NTFY_CUST_SEQ),6,'0')))	 	AS NTFY_CD " ).append("\n"); 
		query.append("  ,MAX((   " ).append("\n"); 
		query.append("    SELECT CUST_LGL_ENG_NM   " ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER B1   " ).append("\n"); 
		query.append("     WHERE A2.NTFY_CNT_CD   = B1.CUST_CNT_CD(+)   " ).append("\n"); 
		query.append("       AND A2.NTFY_CUST_SEQ = B1.CUST_SEQ(+)   " ).append("\n"); 
		query.append("  )) AS NTFY_NM   /*NTFY*/   " ).append("\n"); 
		query.append("  ,MAX(A2.OFT_TP_CD)                                AS PPD_CCT " ).append("\n"); 
		query.append("  ,MAX(TO_CHAR(A2.OBRD_DT,'YYYY-MM-DD'))            AS BL_ONBOARD_DT  " ).append("\n"); 
		query.append("  ,MAX(TO_CHAR(A2.CNTR_RCV_DT,'YYYY-MM-DD'))        AS CGO_RCV_DT  " ).append("\n"); 
		query.append("  ,MAX(A2.SOC_FLG)                                  AS SOC " ).append("\n"); 
		query.append("  ,DECODE(MAX(A2.BKG_CGO_TP_CD), 'R', 'Y', 'N')     AS REV_MT   " ).append("\n"); 
		query.append("  ,NVL(MAX(A2.SPCL_DG_CGO_FLG), 'N')                AS DG 						--SJH.20141215.MOD : DB, RC, BB, AK : A2.->A6." ).append("\n"); 
		query.append("  ,NVL(MAX(A2.SPCL_RC_FLG), 'N')                    AS RF 						--SJH.20141111.ADD" ).append("\n"); 
		query.append("  ,NVL(MAX(A2.SPCL_BB_CGO_FLG), 'N')                AS BB  " ).append("\n"); 
		query.append("  ,NVL(MAX(A2.SPCL_AWK_CGO_FLG), 'N')               AS AK " ).append("\n"); 
		query.append("  ,MAX(A2.AUTO_RAT_DT)								AS AUTO_RAT_DT				--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,TO_CHAR(MAX(A2.BKG_CGO_WGT))                     AS WEIGHT " ).append("\n"); 
		query.append("  ,TO_CHAR(MAX(NVL(A7.CNTR_TPSZ_TARE_WGT,0)*NVL(A2.BKG_QTY,0)))	AS TARE_WEIGHT	--SJH.20141215.ADD " ).append("\n"); 
		query.append("  ,MAX(A2.BKG_WGT_TP_CD)                            AS UNIT " ).append("\n"); 
		query.append("  ,'KGS'                                             AS TARE_WEIGHT_UNIT 		--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(NVL(A2.BKG_QTY,0)))                  AS QUANTITY 				--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(DECODE(SUBSTR(A2.SPCL_CNTR_TPSZ_CD,-1),'2',A2.BKG_QTY,A2.BKG_QTY*2)))	AS TEU 						--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(NVL(A2.BKG_REV,0)+NVL(A2.BKG_OFT_REV,0)))   AS FR_REV			--SJH.20141215.ADD" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("  --#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("  --  ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key',  A2.BKG_REV+A2.BKG_OFT_REV)))      AS REV_$key				--SJH.20141215.DEL" ).append("\n"); 
		query.append("  --#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV))                                   AS TOT_FR_REV_TPSZ 			 		--SJH.20141215.DEL" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_MISC_REV+A2.SCR_CHG_REV))                              AS TOT_MISC_REV_TPSZ " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV))    AS TOT_REV_TPSZ " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  --#foreach($key in ${allcols}) " ).append("\n"); 
		query.append("  --  ,TO_CHAR(SUM(DECODE(A2.SPCL_CNTR_TPSZ_CD, '$key',  A2.BKG_QTY)))                     AS QTY_$key" ).append("\n"); 
		query.append("  --#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(DECODE(SUBSTR(A2.SPCL_CNTR_TPSZ_CD,-1),'2',A2.BKG_QTY,A2.BKG_QTY*2))) AS TOT_QTY " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV))                                   AS FREIGTH_REV " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.BKG_MISC_REV+A2.SCR_CHG_REV))                              AS MISC_REV " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O')" ).append("\n"); 
		query.append("    ,TO_CHAR(SUM(A2.DMDT_COM_AMT))                                             AS DMDT_COST " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_BZC_STVG_COM_AMT))            	AS OB_BASIC_STEVEDORAGE " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_BZC_STVG_COM_AMT))            	AS IB_BASIC_STEVEDORAGE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  --SJH.20141217.ADD" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_DCK_CY_HNDL_COM_AMT))      	AS OB_DCK_CY_HNDL_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_CGO_HNDL_COM_AMT))            	AS OB_CGO_HNDL_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_FCNTR_STO_COM_AMT))          	AS OB_FCNTR_STO_COM_AMT " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_MISC_CGO_HNDL_COM_AMT))  		AS OB_MISC_CGO_HNDL_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_DCK_CY_HNDL_COM_AMT))      	AS IB_DCK_CY_HNDL_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_CGO_HNDL_COM_AMT))            	AS IB_CGO_HNDL_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_FCNTR_STO_COM_AMT))          	AS IB_FCNTR_STO_COM_AMT " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_MISC_CGO_HNDL_COM_AMT))  		AS IB_MISC_CGO_HNDL_COM_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.TS_STVG_COM_AMT))          	    AS TS_STVG_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OTR_CY_HNDL_COM_AMT))          	AS TS_OTHER_CY_EXPENSE" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.TS_DCK_CY_HNDL_COM_AMT))         	AS TS_DCK_CY_HNDL_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.TS_CGO_HNDL_COM_AMT))          	AS TS_CGO_HNDL_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.TS_FCNTR_STO_COM_AMT))          	AS TS_FCNTR_STO_COM_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.CGO_VAR_VOL_DC_AMT))          	AS CGO_VAR_VOL_DC_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_FULL_RAIL_TRK_COM_AMT))       	AS OB_FULL_RAIL_TRK_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_FULL_RAIL_DIR_COM_AMT))       	AS OB_FULL_RAIL_DIR_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_FULL_TRK_DIR_COM_AMT))         AS OB_FULL_TRK_DIR_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_FULL_WTR_DIR_COM_AMT))         AS OB_FULL_WTR_DIR_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_FULL_WTR_RAIL_COM_AMT))        AS OB_FULL_WTR_RAIL_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_FULL_WTR_TRK_COM_AMT ))        AS OB_FULL_WTR_TRK_COM_AMT " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_FULL_TRSP_OTR_AMT))          	AS OB_FULL_TRSP_OTR_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_FULL_RAIL_TRK_COM_AMT))       	AS IB_FULL_RAIL_TRK_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_FULL_RAIL_DIR_COM_AMT))       	AS IB_FULL_RAIL_DIR_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_FULL_TRK_DIR_COM_AMT))         AS IB_FULL_TRK_DIR_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_FULL_WTR_DIR_COM_AMT))         AS IB_FULL_WTR_DIR_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_FULL_WTR_RAIL_COM_AMT))        AS IB_FULL_WTR_RAIL_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_FULL_WTR_TRK_COM_AMT ))        AS IB_FULL_WTR_TRK_COM_AMT " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_FULL_TRSP_OTR_AMT))          	AS IB_FULL_TRSP_OTR_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.TS_FULL_TRSP_COM_AMT))          	AS TS_FULL_TRSP_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.TS_FULL_TRSP_OTR_AMT))          	AS TS_FULL_TRSP_OTR_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_MTY_PA_AMT))          			AS OB_MTY_PA_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_MTY_PA_AMT))          			AS IB_MTY_PA_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_MTY_PA_AMT2))          		AS OB_MTY_PA_AMT2" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_MTY_PA_AMT2))          		AS IB_MTY_PA_AMT2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.OB_AC_COM_AMT))          			AS OB_AC_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.IB_AC_COM_AMT))          			AS IB_AC_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.TS_AC_COM_AMT))          			AS TS_AC_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.AC_FAC_AMT))          			AS AC_FAC_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.AC_CHF_AMT))          			AS AC_CHF_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.AC_OTR_AMT))          			AS AC_OTR_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.TML_COM_AMT))                     AS EXCLUSIVE_TERMINAL_ADD_COST " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.CGO_VAR_VOL_DC_AMT))        		AS CARGO_VARIABLE_VOLUME_DISCOUNT " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.FULL_RAIL_DIR_COM_AMT))  			AS RAIL_DIRECT " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.FULL_RAIL_TRK_COM_AMT))  			AS RAIL_TRUCK " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.FULL_TRK_DIR_COM_AMT))    		AS TRUCK_DIRCET " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.FULL_WTR_DIR_COM_AMT))    		AS WATER_DIRECT " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.FULL_WTR_RAIL_COM_AMT))  			AS WATER_RAIL " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.FULL_WTR_TRK_COM_AMT))    		AS WATER_TRUCK " ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.FULL_TRSP_COM_AMT))          		AS OTHER_TRANSPORT_EXPENSE " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  --#if (${f_pro_vw} =='P')" ).append("\n"); 
		query.append("  --  ,TO_CHAR(SUM(A2.MTY_STVG_PA_AMT))              	AS EMPTY_REPOSITION_EXPENSE_A	--SJH.20141111.MOD" ).append("\n"); 
		query.append("  --  ,TO_CHAR(SUM(A2.MTY_TRSP_PA_AMT2))             	AS EMPTY_REPOSITION_EXPENSE_B	--SJH.20141111.MOD" ).append("\n"); 
		query.append("  --#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  --,TO_CHAR(SUM(A2.AC_COM_AMT))                      AS AGENT_COMMISSION " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.SLT_INTER_PRC_AMT))               AS SLT_INTER_PRC_AMT" ).append("\n"); 
		query.append("  --SJH.20141217.ADD " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.CNTR_MNR_CHG_PA_AMT))             AS CNTR_MNR_CHG_PA_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.RF_COM_AMT))              		AS RF_COM_AMT" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.CHSS_FX_AMT))               		AS CHSS_FX_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  --SJH.20141111.MOD, ADD" ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(DECODE(@[f_pro_vw],'P',A2.PA_CM_COST_TTL_AMT,'R',A2.RA_CM_COST_TTL_AMT)))   	AS CM_COST_TOTAL_A " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV) " ).append("\n"); 
		query.append("    - SUM(DECODE(@[f_pro_vw],'P',A2.PA_CM_COST_TTL_AMT,'R',A2.RA_CM_COST_TTL_AMT)))       	AS CM_A " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(DECODE(@[f_pro_vw],'P',A2.PA_CM_COST_TTL_AMT2,'R',A2.RA_CM_COST_TTL_AMT)))   AS CM_COST_TOTAL_B " ).append("\n"); 
		query.append("  ,TO_CHAR(SUM(A2.BKG_REV+A2.BKG_OFT_REV+A2.BKG_MISC_REV+A2.SCR_CHG_REV) " ).append("\n"); 
		query.append("    - SUM(DECODE(@[f_pro_vw],'P',A2.PA_CM_COST_TTL_AMT2,'R',A2.RA_CM_COST_TTL_AMT)))       	AS CM_B " ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("  #if(${f_pro_lvl} =='O' && ${f_pro_vw} =='P' )" ).append("\n"); 
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
		query.append("  #end	" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("   #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("    COA_BKG_EXPN_DTL A2" ).append("\n"); 
		query.append("   #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("    COA_BKG_EXPN_DTL A2 " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  ,COA_OFC_LVL A4 " ).append("\n"); 
		query.append("  ,MDM_COMMODITY A3    " ).append("\n"); 
		query.append("  ,MDM_REP_CMDT A5 " ).append("\n"); 
		query.append("  ,COA_RGST_BKG A6																--SJH.20141215.ADD" ).append("\n"); 
		query.append("  ,MDM_CNTR_TP_SZ A7" ).append("\n"); 
		query.append("  ,(SELECT CUST.CUST_CNT_CD,   													--SJH.20141218.ADD" ).append("\n"); 
		query.append("           CUST.CUST_SEQ, " ).append("\n"); 
		query.append("           GRP.CUST_GRP_NM," ).append("\n"); 
		query.append("           CUST.NBS_CLSS_CD1, " ).append("\n"); 
		query.append("           CUST.NBS_CLSS_CD2, " ).append("\n"); 
		query.append("           CUST.NBS_CLSS_CD3" ).append("\n"); 
		query.append("      FROM MDM_CUSTOMER CUST," ).append("\n"); 
		query.append("           MDM_CUST_PERF_GRP GRP" ).append("\n"); 
		query.append("     WHERE CUST.CUST_GRP_ID = GRP.CUST_GRP_ID(+)" ).append("\n"); 
		query.append("	) A8" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${f_chkprd} =='M')    " ).append("\n"); 
		query.append("    AND A2.COST_YRMON  = @[f_year]||@[f_mon] " ).append("\n"); 
		query.append("    AND A2.COST_YRMON  BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("  #elseif (${f_chkprd} =='W')    " ).append("\n"); 
		query.append("	AND SUBSTR(A2.SLS_YRMON,1,4)||A2.COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	  " ).append("\n"); 
		query.append("    #if(${f_sls_mon} !='')" ).append("\n"); 
		query.append("    	AND A2.SLS_YRMON = @[f_year]||@[f_sls_mon]    " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND A2.SLS_YRMON     BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("  AND A2.BL_NO_TP      IN ('M','0') 	 " ).append("\n"); 
		query.append("  AND A2.BKG_NO 	   = A6.BKG_NO 												--SJH.20141215.ADD" ).append("\n"); 
		query.append("  AND A2.SPCL_CNTR_TPSZ_CD = A7.CNTR_TPSZ_CD(+)									--SJH.20141215.ADD" ).append("\n"); 
		query.append("  AND A2.AGMT_CNT_CD   = A8.CUST_CNT_CD(+)   									--SJH.20141218.ADD" ).append("\n"); 
		query.append("  AND A2.AGMT_CUST_SEQ = A8.CUST_SEQ(+)  " ).append("\n"); 
		query.append("		" ).append("\n"); 
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
		query.append("				" ).append("\n"); 
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
		query.append("  --SJH.20141218.ADD" ).append("\n"); 
		query.append("  #if(${f_svc_scp_cd} !='')" ).append("\n"); 
		query.append("    AND A6.SVC_SCP_CD = @[f_svc_scp_cd] " ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("  #if(${f_bkg_pol_cd} !='')" ).append("\n"); 
		query.append("    AND A2.BKG_POL_CD = @[f_bkg_pol_cd] " ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("  #if(${f_bkg_pod_cd} !='')" ).append("\n"); 
		query.append("    AND A2.BKG_POD_CD = @[f_bkg_pod_cd] " ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("  #if(${f_cust_grp_nm} !='')" ).append("\n"); 
		query.append("    AND A8.CUST_GRP_NM LIKE '%'||@[f_cust_grp_nm]||'%'" ).append("\n"); 
		query.append("  #end	" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("   A2.COST_YRMON " ).append("\n"); 
		query.append("  ,A2.SLS_YRMON  " ).append("\n"); 
		query.append("  ,A2.COST_WK " ).append("\n"); 
		query.append("  ,A2.BKG_NO " ).append("\n"); 
		query.append("  ,A2.CNTR_TPSZ_CD" ).append("\n"); 

	}
}