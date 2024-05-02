/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOBkgRptDownExcel1702RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOBkgRptDownExcel1702RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRptDownExcel1702
	  * </pre>
	  */
	public StatusReportDBDAOBkgRptDownExcel1702RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_srnd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_rlse_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rlse_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_prn_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_prn_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cptr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_srnd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_srnd_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("internet_bl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOBkgRptDownExcel1702RSQL").append("\n"); 
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
		query.append("#if (${sel_cols} != '')  " ).append("\n"); 
		query.append("SELECT ${sel_cols}" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     '1' AS TEMP" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TS_PORT_1" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TS_PORT_2" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TS_PORT_3" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TS_PORT_4" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	CGO_RLSE_STS" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	DO_ISSUE_BY" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	DO_ISSUE_DT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	GRS_WGT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	GRS_WGT_UT" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	DOC_USR_ID" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BL_NO" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BL_TP_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BKG_NO" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BKG_STS_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BKG_KND" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	CRD" ).append("\n"); 
		query.append("    ,'' AS	CGO_RLSE" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	CARRIER" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	OBL_INET_PRN_DT" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	HBL_NO" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BL_OBRD_DT" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	OBL_ISS_FLG" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	OBL_ISS_DT" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BKG_ISS_OFC_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	OBL_PRN_FLG" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BL_PRT_DT" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	OBL_RLSE_FLG" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	OBL_RLSE_DT" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BL_RLSE_OFC" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	SRD_DT" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	SRD_OFC" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	SPLIT_FLG" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	OB_SLS_RGN_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	OB_SREP_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	SCAC_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	SI_DT" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	CNTR_VOL" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CGO_DESC" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CGO_NATURE" ).append("\n"); 
		query.append("    ,'' AS	CNTR_WGT" ).append("\n"); 
		query.append("    ,'' AS	CNTR_WGT_UT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CGO_WGT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CGO_WGT_UT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CM_MEAS" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CM_MEAS_UT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	TARE_WGT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	TARE_WGT_UT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	PCK_QTY" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	PCK_TP_CD" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CMDT_HS_CD" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	HAMO_CD_DESC" ).append("\n"); 
		query.append("    ,'Charge' AS	C_1_CURR" ).append("\n"); 
		query.append("    ,'Charge' AS	C_1_AMT" ).append("\n"); 
		query.append("    ,'Charge' AS	C_2_CURR" ).append("\n"); 
		query.append("    ,'Charge' AS	C_2_AMT" ).append("\n"); 
		query.append("    ,'Charge' AS	C_3_CURR" ).append("\n"); 
		query.append("    ,'Charge' AS	C_3_AMT" ).append("\n"); 
		query.append("    ,'Charge' AS	C_4_CURR" ).append("\n"); 
		query.append("    ,'Charge' AS	C_4_AMT" ).append("\n"); 
		query.append("    ,'Charge' AS	P_1_CURR" ).append("\n"); 
		query.append("    ,'Charge' AS	P_1_AMT" ).append("\n"); 
		query.append("    ,'Charge' AS	P_2_CURR" ).append("\n"); 
		query.append("    ,'Charge' AS	P_2_AMT" ).append("\n"); 
		query.append("    ,'Charge' AS	P_3_CURR" ).append("\n"); 
		query.append("    ,'Charge' AS	P_3_AMT" ).append("\n"); 
		query.append("    ,'Charge' AS	P_4_CURR" ).append("\n"); 
		query.append("    ,'Charge' AS	P_4_AMT" ).append("\n"); 
		query.append("    ,'Container' AS	CNTR_NO" ).append("\n"); 
		query.append("    ,'Container' AS	CNTR_SZ" ).append("\n"); 
		query.append("    ,'Container' AS	CNMV_STS_CD" ).append("\n"); 
		query.append("    ,'Container' AS	CNMV_STS_NMK" ).append("\n"); 
		query.append("    ,'Container' AS	CNTR_SEAL_NO" ).append("\n"); 
		query.append("    ,'Container' AS	CNTR_VOL_QTY" ).append("\n"); 
		query.append("    ,'Container' AS	TEU" ).append("\n"); 
		query.append("    ,'Container' AS	FEU" ).append("\n"); 
		query.append("	,'Container' AS	VGM" ).append("\n"); 
		query.append("    ,'Customer' AS	NF_CUST_NM" ).append("\n"); 
		query.append("    ,'Customer' AS	AN_CUST_NM" ).append("\n"); 
		query.append("    ,'Customer' AS	SH_CUST_NM" ).append("\n"); 
		query.append("    ,'Customer' AS	SH_CNTC_PSON_NM" ).append("\n"); 
		query.append("    ,'Customer' AS	SH_CNTC_NUM" ).append("\n"); 
		query.append("    ,'Customer' AS	CN_CUST_NM" ).append("\n"); 
		query.append("    ,'Customer' AS	FF_CUST_NM" ).append("\n"); 
		query.append("    ,'Customer' AS	FF_CNTC_PSON_NM" ).append("\n"); 
		query.append("    ,'Customer' AS	FW_CNTC_NUM" ).append("\n"); 
		query.append("    ,'Customer' AS	OBL_INET_FLG" ).append("\n"); 
		query.append("    ,'Customer' AS	CTRT_PTY_CD" ).append("\n"); 
		query.append("    ,'Customer' AS	CTRT_PTY_NM" ).append("\n"); 
		query.append("    ,'Inbound Info' AS	IB_CTRL_OFC" ).append("\n"); 
		query.append("    ,'Inbound Info' AS	TROI" ).append("\n"); 
		query.append("    ,'Inbound Info' AS	IB_FRH_FLG" ).append("\n"); 
		query.append("    ,'Rate & Invoice' AS	ACM_AMT" ).append("\n"); 
		query.append("    ,'Rate & Invoice' AS	ACM_PTY" ).append("\n"); 
		query.append("    ,'Rate & Invoice' AS	TRF_CD" ).append("\n"); 
		query.append("    ,'Reference No' AS	IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("    ,'Reference No' AS	CRN" ).append("\n"); 
		query.append("    ,'Reference No' AS	ENS_MRN" ).append("\n"); 
		query.append("    ,'Reference No' AS	EXS_MRN" ).append("\n"); 
		query.append("    ,'Reference No' AS	CMRN_REF_NO" ).append("\n"); 
		query.append("    ,'Reference No' AS	ACT_CSTMS_SMT_DT" ).append("\n"); 
		query.append("    ,'Reference No' AS	XPT_LIC_NO" ).append("\n"); 
		query.append("    ,'Reference No' AS	IBD_TRSP_NO" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	BLCK_STWG_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	RCV_TERM_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	DE_TERM_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRAF_MOD_OB" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRAF_MOD_IB" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRUNK_SLAN_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRUNK_POL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRUNK_POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRUNK_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	VSL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	BL_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	BL_SLAN_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	SVC_SCP_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POR_CNT_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POR_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POR_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE1_POL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE1_POL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE2_POL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE2_POL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE3_POL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE3_POL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE4_POL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE4_POL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST1_POL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST1_POL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST2_POL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST2_POL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST3_POL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST3_POL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST4_POL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST4_POL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE1_POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE1_POD_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE2_POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE2_POD_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE3_POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE3_POD_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE4_POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE4_POD_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST1_POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST1_POD_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST2_POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST2_POD_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST3_POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST3_POD_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST4_POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST4_POD_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	LAST_POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	LAST_POD_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	DEL_CNT_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	DEL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	DEL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE1_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE2_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE3_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE4_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST1_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST2_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST3_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST4_VVD" ).append("\n"); 
		query.append("    ,'Routing details' AS	FIRST_VVD" ).append("\n"); 
		query.append("    ,'Routing details' AS	LAST_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	FIRST_POL_ETD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	FIRST_POL_ATD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	LAST_POD_ETA" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	LAST_POD_ATA" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRSP_MOD_IB" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRSP_MOD_OB" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	FIRST_POL_CUTOFF_DT" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	FIRST_POL_ETB" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	LAST_POD_ETB" ).append("\n"); 
		query.append("    ,'' AS	TS_POD" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     '2' AS TEMP" ).append("\n"); 
		query.append("    ,'T/S Port 1' AS	TS_PORT_1" ).append("\n"); 
		query.append("    ,'T/S Port 2' AS	TS_PORT_2" ).append("\n"); 
		query.append("    ,'T/S Port 3' AS	TS_PORT_3" ).append("\n"); 
		query.append("    ,'T/S Port 4' AS	TS_PORT_4" ).append("\n"); 
		query.append("    ,'Cargo Release Status' AS	CGO_RLSE_STS" ).append("\n"); 
		query.append("    ,'Cleared By' AS	DO_ISSUE_BY" ).append("\n"); 
		query.append("    ,'D/O Issue Date' AS	DO_ISSUE_DT" ).append("\n"); 
		query.append("    ,'Gross Weight' AS	GRS_WGT" ).append("\n"); 
		query.append("    ,'Gross Weight Unit' AS	GRS_WGT_UT" ).append("\n"); 
		query.append("    ,'B/L Creator' AS	DOC_USR_ID" ).append("\n"); 
		query.append("    ,'B/L No.' AS	BL_NO" ).append("\n"); 
		query.append("    ,'B/L Type' AS	BL_TP_CD" ).append("\n"); 
		query.append("    ,'B/L Type (KOR)' AS	KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append("    ,'Booking No.' AS	BKG_NO" ).append("\n"); 
		query.append("    ,'Booking Status' AS	BKG_STS_CD" ).append("\n"); 
		query.append("    ,'Booking Kind' AS	BKG_KND" ).append("\n"); 
		query.append("    ,'Cargo Received Date' AS	CRD" ).append("\n"); 
		query.append("    ,'' AS	CGO_RLSE" ).append("\n"); 
		query.append("    ,'Carrier' AS	CARRIER" ).append("\n"); 
		query.append("    ,'Date Final B/L released to internet' AS	OBL_INET_PRN_DT" ).append("\n"); 
		query.append("    ,'House B/L No.' AS	HBL_NO" ).append("\n"); 
		query.append("    ,'On Board Date' AS	BL_OBRD_DT" ).append("\n"); 
		query.append("    ,'B/L Issued' AS	OBL_ISS_FLG" ).append("\n"); 
		query.append("    ,'B/L Issue Date' AS	OBL_ISS_DT" ).append("\n"); 
		query.append("    ,'B/L Issue Office' AS	BKG_ISS_OFC_CD" ).append("\n"); 
		query.append("    ,'O.B/L Printed' AS	OBL_PRN_FLG" ).append("\n"); 
		query.append("    ,'B/L Print Date' AS	BL_PRT_DT" ).append("\n"); 
		query.append("    ,'O.B/L Release Status' AS	OBL_RLSE_FLG" ).append("\n"); 
		query.append("    ,'O.B/L Release Date' AS	OBL_RLSE_DT" ).append("\n"); 
		query.append("    ,'Release OFC' AS	BL_RLSE_OFC" ).append("\n"); 
		query.append("    ,'B/L Surrender Date' AS	SRD_DT" ).append("\n"); 
		query.append("    ,'Surrender OFC' AS	SRD_OFC" ).append("\n"); 
		query.append("    ,'Partial Shipment' AS	SPLIT_FLG" ).append("\n"); 
		query.append("    ,'Sales OFC' AS	OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,'Sales Region' AS	OB_SLS_RGN_CD" ).append("\n"); 
		query.append("    ,'Sales Rep' AS	OB_SREP_CD" ).append("\n"); 
		query.append("    ,'SCAC Code' AS	SCAC_CD" ).append("\n"); 
		query.append("    ,'SI Received Date/Time' AS	SI_DT" ).append("\n"); 
		query.append("    ,'Booking Quantity' AS	CNTR_VOL" ).append("\n"); 
		query.append("    ,'Cargo Description' AS	CGO_DESC" ).append("\n"); 
		query.append("    ,'Cargo Nature' AS	CGO_NATURE" ).append("\n"); 
		query.append("    ,'' AS	CNTR_WGT" ).append("\n"); 
		query.append("    ,'' AS	CNTR_WGT_UT" ).append("\n"); 
		query.append("    ,'Cargo Weight' AS	CGO_WGT" ).append("\n"); 
		query.append("    ,'Cargo Weight Unit' AS	CGO_WGT_UT" ).append("\n"); 
		query.append("    ,'Gross Measurement' AS	CM_MEAS" ).append("\n"); 
		query.append("    ,'Gross Measurement Unit' AS	CM_MEAS_UT" ).append("\n"); 
		query.append("    ,'Tare Weight' AS	TARE_WGT" ).append("\n"); 
		query.append("    ,'Tare Weight Unit' AS	TARE_WGT_UT" ).append("\n"); 
		query.append("    ,'No. of Package' AS	PCK_QTY" ).append("\n"); 
		query.append("    ,'Package Type' AS	PCK_TP_CD" ).append("\n"); 
		query.append("    ,'HS Code' AS	CMDT_HS_CD" ).append("\n"); 
		query.append("    ,'HS Description' AS	HAMO_CD_DESC" ).append("\n"); 
		query.append("    ,'Collect Freight Currency_1' AS	C_1_CURR" ).append("\n"); 
		query.append("    ,'Collect Freight Total_1' AS	C_1_AMT" ).append("\n"); 
		query.append("    ,'Collect Freight Currency_2' AS	C_2_CURR" ).append("\n"); 
		query.append("    ,'Collect Freight Total_2' AS	C_2_AMT" ).append("\n"); 
		query.append("    ,'Collect Freight Currency_3' AS	C_3_CURR" ).append("\n"); 
		query.append("    ,'Collect Freight Total_3' AS	C_3_AMT" ).append("\n"); 
		query.append("    ,'Collect Freight Currency_4' AS	C_4_CURR" ).append("\n"); 
		query.append("    ,'Collect Freight Total_4' AS	C_4_AMT" ).append("\n"); 
		query.append("    ,'Prepaid Freight Currency_1' AS	P_1_CURR" ).append("\n"); 
		query.append("    ,'Prepaid Freight Total_1' AS	P_1_AMT" ).append("\n"); 
		query.append("    ,'Prepaid Freight Currency_2' AS	P_2_CURR" ).append("\n"); 
		query.append("    ,'Prepaid Freight Total_2' AS	P_2_AMT" ).append("\n"); 
		query.append("    ,'Prepaid Freight Currency_3' AS	P_3_CURR" ).append("\n"); 
		query.append("    ,'Prepaid Freight Total_3' AS	P_3_AMT" ).append("\n"); 
		query.append("    ,'Prepaid Freight Currency_4' AS	P_4_CURR" ).append("\n"); 
		query.append("    ,'Prepaid Freight Total_4' AS	P_4_AMT" ).append("\n"); 
		query.append("    ,'Container Number' AS	CNTR_NO" ).append("\n"); 
		query.append("    ,'Container Size Type' AS	CNTR_SZ" ).append("\n"); 
		query.append("    ,'Container Movement Status' AS	CNMV_STS_CD" ).append("\n"); 
		query.append("    ,'Container Movement Status Description' AS	CNMV_STS_NMK" ).append("\n"); 
		query.append("    ,'Seal Number' AS	CNTR_SEAL_NO" ).append("\n"); 
		query.append("    ,'Container Quantity' AS	CNTR_VOL_QTY" ).append("\n"); 
		query.append("    ,'TEU' AS	TEU" ).append("\n"); 
		query.append("    ,'FEU' AS	FEU" ).append("\n"); 
		query.append("	,'VGM' AS 	VGM" ).append("\n"); 
		query.append("    ,'1st Notify Party' AS	NF_CUST_NM" ).append("\n"); 
		query.append("    ,'2nd Notify Party' AS	AN_CUST_NM" ).append("\n"); 
		query.append("    ,'Shipper' AS	SH_CUST_NM" ).append("\n"); 
		query.append("    ,'Shipper Contact Name' AS	SH_CNTC_PSON_NM" ).append("\n"); 
		query.append("    ,'Shipper Contact Number' AS	SH_CNTC_NUM" ).append("\n"); 
		query.append("    ,'Consignee' AS	CN_CUST_NM" ).append("\n"); 
		query.append("    ,'Forwarder' AS	FF_CUST_NM" ).append("\n"); 
		query.append("    ,'Forwarder Contact Name' AS	FF_CNTC_PSON_NM" ).append("\n"); 
		query.append("    ,'Forwarder Contact Number' AS	FW_CNTC_NUM" ).append("\n"); 
		query.append("    ,'Internet BL Flag' AS	OBL_INET_FLG" ).append("\n"); 
		query.append("    ,'Contract Party Code' AS	CTRT_PTY_CD" ).append("\n"); 
		query.append("    ,'Contract Party Name' AS	CTRT_PTY_NM" ).append("\n"); 
		query.append("    ,'IB Control Office ' AS	IB_CTRL_OFC" ).append("\n"); 
		query.append("    ,'IB Door Delivery Setup' AS	TROI" ).append("\n"); 
		query.append("    ,'IB Freighting Setup' AS	IB_FRH_FLG" ).append("\n"); 
		query.append("    ,'Brokerage Commission Amount' AS	ACM_AMT" ).append("\n"); 
		query.append("    ,'Brokerage Commission Party' AS	ACM_PTY" ).append("\n"); 
		query.append("    ,'Tariff Code' AS	TRF_CD" ).append("\n"); 
		query.append("    ,'Customs IT/TE/IE #' AS	IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("    ,'Customs Reference Number' AS	CRN" ).append("\n"); 
		query.append("    ,'ENS MRN' AS	ENS_MRN" ).append("\n"); 
		query.append("    ,'EXS MRN' AS	EXS_MRN" ).append("\n"); 
		query.append("    ,'Export MRN No. ' AS	CMRN_REF_NO" ).append("\n"); 
		query.append("    ,'Actual Submission Date' AS	ACT_CSTMS_SMT_DT" ).append("\n"); 
		query.append("    ,'Export License #' AS	XPT_LIC_NO" ).append("\n"); 
		query.append("    ,'Status Remarks / I.T. #' AS	IBD_TRSP_NO" ).append("\n"); 
		query.append("    ,'Block Stowage' AS	BLCK_STWG_CD" ).append("\n"); 
		query.append("    ,'Receiving Term' AS	RCV_TERM_CD" ).append("\n"); 
		query.append("    ,'Delivery Term' AS	DE_TERM_CD" ).append("\n"); 
		query.append("    ,'Traffic Mode OB' AS	TRAF_MOD_OB" ).append("\n"); 
		query.append("    ,'Traffic Mode IB' AS	TRAF_MOD_IB" ).append("\n"); 
		query.append("    ,'Trunk Lane' AS	TRUNK_SLAN_CD" ).append("\n"); 
		query.append("    ,'Trunk POL' AS	TRUNK_POL_CD" ).append("\n"); 
		query.append("    ,'Trunk POD' AS	TRUNK_POD_CD" ).append("\n"); 
		query.append("    ,'Trunk VVD' AS	TRUNK_VVD" ).append("\n"); 
		query.append("    ,'Trunk Vessel' AS	VSL_NM" ).append("\n"); 
		query.append("    ,'B/L VVD' AS	BL_VVD" ).append("\n"); 
		query.append("    ,'B/L Service' AS	BL_SLAN_CD" ).append("\n"); 
		query.append("    ,'Trade Code' AS	TRD_CD" ).append("\n"); 
		query.append("    ,'Service Scope Code' AS	SVC_SCP_CD" ).append("\n"); 
		query.append("    ,'POR Country' AS	POR_CNT_CD" ).append("\n"); 
		query.append("    ,'POR Code' AS	POR_CD" ).append("\n"); 
		query.append("    ,'POR Name' AS	POR_NM" ).append("\n"); 
		query.append("    ,'Pre 1. POL Code' AS	PRE1_POL_CD" ).append("\n"); 
		query.append("    ,'Pre 1. POL Name' AS	PRE1_POL_NM" ).append("\n"); 
		query.append("    ,'Pre 2. POL Code' AS	PRE2_POL_CD" ).append("\n"); 
		query.append("    ,'Pre 2. POL Name' AS	PRE2_POL_NM" ).append("\n"); 
		query.append("    ,'Pre 3. POL Code' AS	PRE3_POL_CD" ).append("\n"); 
		query.append("    ,'Pre 3. POL Name' AS	PRE3_POL_NM" ).append("\n"); 
		query.append("    ,'Pre 4. POL Code' AS	PRE4_POL_CD" ).append("\n"); 
		query.append("    ,'Pre 4. POL Name' AS	PRE4_POL_NM" ).append("\n"); 
		query.append("    ,'Post 1. POL Code' AS	POST1_POL_CD" ).append("\n"); 
		query.append("    ,'Post 1. POL Name' AS	POST1_POL_NM" ).append("\n"); 
		query.append("    ,'Post 2. POL Code' AS	POST2_POL_CD" ).append("\n"); 
		query.append("    ,'Post 2. POL Name' AS	POST2_POL_NM" ).append("\n"); 
		query.append("    ,'Post 3. POL Code' AS	POST3_POL_CD" ).append("\n"); 
		query.append("    ,'Post 3. POL Name' AS	POST3_POL_NM" ).append("\n"); 
		query.append("    ,'Post 4. POL Code' AS	POST4_POL_CD" ).append("\n"); 
		query.append("    ,'Post 4. POL Name' AS	POST4_POL_NM" ).append("\n"); 
		query.append("    ,'Pre 1. POD Code' AS	PRE1_POD_CD" ).append("\n"); 
		query.append("    ,'Pre 1. POD Name' AS	PRE1_POD_NM" ).append("\n"); 
		query.append("    ,'Pre 2. POD Code' AS	PRE2_POD_CD" ).append("\n"); 
		query.append("    ,'Pre 2. POD Name' AS	PRE2_POD_NM" ).append("\n"); 
		query.append("    ,'Pre 3. POD Code' AS	PRE3_POD_CD" ).append("\n"); 
		query.append("    ,'Pre 3. POD Name' AS	PRE3_POD_NM" ).append("\n"); 
		query.append("    ,'Pre 4. POD Code' AS	PRE4_POD_CD" ).append("\n"); 
		query.append("    ,'Pre 4. POD Name' AS	PRE4_POD_NM" ).append("\n"); 
		query.append("    ,'Post 1. POD Code' AS	POST1_POD_CD" ).append("\n"); 
		query.append("    ,'Post 1. POD Name' AS	POST1_POD_NM" ).append("\n"); 
		query.append("    ,'Post 2. POD Code' AS	POST2_POD_CD" ).append("\n"); 
		query.append("    ,'Post 2. POD Name' AS	POST2_POD_NM" ).append("\n"); 
		query.append("    ,'Post 3. POD Code' AS	POST3_POD_CD" ).append("\n"); 
		query.append("    ,'Post 3. POD Name' AS	POST3_POD_NM" ).append("\n"); 
		query.append("    ,'Post 4. POD Code' AS	POST4_POD_CD" ).append("\n"); 
		query.append("    ,'Post 4. POD Name' AS	POST4_POD_NM" ).append("\n"); 
		query.append("    ,'Last POD Code' AS	LAST_POD_CD" ).append("\n"); 
		query.append("    ,'Last POD Name' AS	LAST_POD_NM" ).append("\n"); 
		query.append("    ,'DEL Country' AS	DEL_CNT_CD" ).append("\n"); 
		query.append("    ,'DEL Code' AS	DEL_CD" ).append("\n"); 
		query.append("    ,'DEL Name' AS	DEL_NM" ).append("\n"); 
		query.append("    ,'Pre 1.VVD' AS	PRE1_VVD" ).append("\n"); 
		query.append("    ,'Pre 2.VVD' AS	PRE2_VVD" ).append("\n"); 
		query.append("    ,'Pre 3.VVD' AS	PRE3_VVD" ).append("\n"); 
		query.append("    ,'Pre 4.VVD' AS	PRE4_VVD" ).append("\n"); 
		query.append("    ,'Post 1.VVD' AS	POST1_VVD" ).append("\n"); 
		query.append("    ,'Post 2.VVD' AS	POST2_VVD" ).append("\n"); 
		query.append("    ,'Post 3.VVD' AS	POST3_VVD" ).append("\n"); 
		query.append("    ,'Post 4.VVD' AS	POST4_VVD" ).append("\n"); 
		query.append("    ,'OB Voyage Control' AS	FIRST_VVD" ).append("\n"); 
		query.append("    ,'IB Voyage Control' AS	LAST_VVD" ).append("\n"); 
		query.append("    ,'ETD from First POL' AS	FIRST_POL_ETD" ).append("\n"); 
		query.append("    ,'ATD from First POL' AS	FIRST_POL_ATD" ).append("\n"); 
		query.append("    ,'ETA at Last POD' AS	LAST_POD_ETA" ).append("\n"); 
		query.append("    ,'ATA at Last POD' AS	LAST_POD_ATA" ).append("\n"); 
		query.append("    ,'Transport Mode O/B' AS	TRSP_MOD_IB" ).append("\n"); 
		query.append("    ,'Transport Mode I/B' AS	TRSP_MOD_OB" ).append("\n"); 
		query.append("    ,'POL Cut-Off Date' AS	FIRST_POL_CUTOFF_DT" ).append("\n"); 
		query.append("    ,'Berth at First POL' AS	FIRST_POL_ETB" ).append("\n"); 
		query.append("    ,'Berth at Last POD' AS	LAST_POD_ETB" ).append("\n"); 
		query.append("    ,'' AS	TS_POD" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("         '3' AS TEMP" ).append("\n"); 
		query.append("          ,BKG_GET_TOKEN_FNC(TS_POD,1) AS TS_PORT_1" ).append("\n"); 
		query.append("          ,BKG_GET_TOKEN_FNC(TS_POD,2) AS TS_PORT_2" ).append("\n"); 
		query.append("          ,BKG_GET_TOKEN_FNC(TS_POD,3) AS TS_PORT_3" ).append("\n"); 
		query.append("          ,BKG_GET_TOKEN_FNC(TS_POD,4) AS TS_PORT_4" ).append("\n"); 
		query.append("          ,BKG_GET_TOKEN_FNC(CGO_RLSE,1) AS CGO_RLSE_STS" ).append("\n"); 
		query.append("          ,BKG_GET_TOKEN_FNC(CGO_RLSE,2) AS DO_ISSUE_BY" ).append("\n"); 
		query.append("          ,BKG_GET_TOKEN_FNC(CGO_RLSE,3) AS DO_ISSUE_DT" ).append("\n"); 
		query.append("          ,DECODE(CNTR_WGT_UT,'KGS'," ).append("\n"); 
		query.append("                               TRIM(TO_CHAR(TO_NUMBER(NVL(CNTR_WGT,0),'999,999,999,990.99')+TO_NUMBER(NVL(TARE_WGT,0),'999,999,999,990.99'),'999,999,999,990.99'))," ).append("\n"); 
		query.append("                             'LBS'," ).append("\n"); 
		query.append("                               TRIM(TO_CHAR(TO_NUMBER(NVL(CNTR_WGT,0),'999,999,999,990.99')+ROUND(TO_NUMBER(NVL(TARE_WGT,0),'999,999,999,990.99') / 0.453592,2),'999,999,999,990.99'))" ).append("\n"); 
		query.append("                 ) AS GRS_WGT" ).append("\n"); 
		query.append("          ,CNTR_WGT_UT AS GRS_WGT_UT" ).append("\n"); 
		query.append("          ,Z.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("			 --BKG & B/L Info" ).append("\n"); 
		query.append("			       ISS.BL_RDY_USR_ID AS DOC_USR_ID" ).append("\n"); 
		query.append("			      ,BKG.BL_NO" ).append("\n"); 
		query.append("			      ,DECODE(BKG.BL_NO_TP,9,'M',NVL(BKG.BL_TP_CD,'O')) AS BL_TP_CD" ).append("\n"); 
		query.append("			      ,BKG.KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append("			      ,BKG.BKG_NO" ).append("\n"); 
		query.append("			      ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("                  ,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01619' AND INTG_CD_VAL_CTNT = BKG.XTER_BKG_RQST_CD) AS BKG_KND" ).append("\n"); 
		query.append("			      ,TO_CHAR(MIN(CNTR.CGO_RCV_DT) OVER (PARTITION BY BKG.BKG_NO),'YYYY-MM-DD HH24:MI') AS CRD" ).append("\n"); 
		query.append("                  ,NVL(CASE WHEN SUBSTR(BKG.POD_CD,1,2) = 'KR' OR SUBSTR(BKG.POD_CD,1,2) = 'JP'" ).append("\n"); 
		query.append("                            THEN (SELECT /*+ INDEX_DESC(DOTL XPKBKG_DO_DTL) */DECODE(DOTL.RLSE_STS_CD,'R','CLEAR','D','CLEAR',NULL)||','|| DOTL.EVNT_USR_ID||','||TO_CHAR(DOTL.EVNT_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                    FROM BKG_DO_DTL DOTL" ).append("\n"); 
		query.append("                                   WHERE DOTL.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("                            WHEN SUBSTR(BKG.POD_CD,1,2) = 'US' OR SUBSTR(BKG.DEL_CD,1,2) = 'US'" ).append("\n"); 
		query.append("                            THEN (SELECT DECODE(MRN_TML_EDI_SND_CD,'R','CLEAR','J','CLEAR',NULL) ||','|| RLSE.UPD_USR_ID||','||TO_CHAR(RLSE.MRN_TML_EDI_LST_SND_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                   FROM  BKG_CGO_RLSE RLSE" ).append("\n"); 
		query.append("                                  WHERE  RLSE.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                            ELSE (SELECT DECODE(DOTL.RLSE_STS_CD,'R','CLEAR','D','CLEAR',NULL)||','|| DOTL.EVNT_USR_ID||','||TO_CHAR(DOTL.EVNT_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                    FROM BKG_DO_DTL DOTL, BKG_DO_CNTR DCNTR" ).append("\n"); 
		query.append("                                   WHERE DCNTR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                     AND DCNTR.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                                     AND DOTL.BKG_NO = DCNTR.BKG_NO" ).append("\n"); 
		query.append("                                     AND DOTL.RLSE_SEQ = DCNTR.RLSE_SEQ" ).append("\n"); 
		query.append("                                     AND ROWNUM = 1" ).append("\n"); 
		query.append("                      ) END ,'HOLD') CGO_RLSE" ).append("\n"); 
		query.append("                  ,'NYK' AS CARRIER" ).append("\n"); 
		query.append("                  ,(SELECT TO_CHAR(MAX(N1ST_PRN_DT),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                      FROM BKG_INET_BL_PRN_AUTH INET" ).append("\n"); 
		query.append("                     WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                       AND N1ST_PRN_DT IS NOT NULL) OBL_INET_PRN_DT" ).append("\n"); 
		query.append("			      ,BKG_JOIN_FNC(CURSOR(SELECT HBL.HBL_NO" ).append("\n"); 
		query.append("			                             FROM BKG_HBL HBL" ).append("\n"); 
		query.append("			                            WHERE BKG.BKG_NO = HBL.BKG_NO),';') AS HBL_NO" ).append("\n"); 
		query.append("			      ,TO_CHAR(DOC.BL_OBRD_DT,'YYYY-MM-DD') AS BL_OBRD_DT" ).append("\n"); 
		query.append("			      ,ISS.OBL_ISS_FLG" ).append("\n"); 
		query.append("			      ,TO_CHAR(OBL_ISS_DT,'YYYY-MM-DD') AS OBL_ISS_DT" ).append("\n"); 
		query.append("			      ,OBL_ISS_OFC_CD AS BKG_ISS_OFC_CD" ).append("\n"); 
		query.append("			      ,NVL((SELECT 'Y' FROM BKG_INET_BL_PRN_AUTH WHERE BKG_NO = BKG.BKG_NO AND N1ST_PRN_DT IS NOT NULL AND DELT_FLG = 'N' AND ROWNUM = 1),NVL(ISS.OBL_PRN_FLG,'N')) AS OBL_PRN_FLG" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),nvl2(MIN(H.CRE_DT), nvl2(MIN(A.N1ST_PRN_DT), least(MIN(H.CRE_DT), MIN(A.N1ST_PRN_DT)), MIN(H.CRE_DT)), MIN(A.N1ST_PRN_DT)),BKG.POL_CD),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                      FROM BKG_BOOKING T, BKG_HIS_DTL H, BKG_INET_BL_PRN_AUTH A" ).append("\n"); 
		query.append("                     WHERE T.BKG_NO = H.BKG_NO(+)" ).append("\n"); 
		query.append("                       AND T.BKG_NO = A.BKG_NO(+)" ).append("\n"); 
		query.append("                       AND T.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                       AND H.HIS_CATE_NM(+) = 'O.B/L PRINT'" ).append("\n"); 
		query.append("                       AND A.N1ST_PRN_DT(+) IS NOT NULL" ).append("\n"); 
		query.append("                       AND A.DELT_FLG(+) = 'N' ) AS BL_PRT_DT" ).append("\n"); 
		query.append("			      ,ISS.OBL_RLSE_FLG" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(EVNT_DT,'YYYY-MM-DD HH24:MI') FROM BKG_DOC_PROC_SKD PROC" ).append("\n"); 
		query.append("                     WHERE PROC.BKG_DOC_PROC_TP_CD = 'OBLREL'" ).append("\n"); 
		query.append("                       AND PROC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                       AND PROC.DOC_PERF_DELT_FLG ='N'" ).append("\n"); 
		query.append("                       AND ROWNUM=1) AS OBL_RLSE_DT" ).append("\n"); 
		query.append("                  ,(SELECT USR.OFC_CD FROM BKG_DOC_PROC_SKD PROC, COM_USER USR" ).append("\n"); 
		query.append("                     WHERE PROC.BKG_DOC_PROC_TP_CD = 'OBLREL'" ).append("\n"); 
		query.append("                       AND PROC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                       AND PROC.DOC_PERF_DELT_FLG ='N'" ).append("\n"); 
		query.append("                       AND PROC.EVNT_USR_ID = USR.USR_ID" ).append("\n"); 
		query.append("                       AND ROWNUM=1) AS BL_RLSE_OFC" ).append("\n"); 
		query.append("			      ,TO_CHAR(SRD.EVNT_DT,'YYYY-MM-DD HH24:MI') AS SRD_DT" ).append("\n"); 
		query.append("			      ,USR.OFC_CD AS SRD_OFC" ).append("\n"); 
		query.append("			      ,BKG.SPLIT_FLG" ).append("\n"); 
		query.append("			      ,BKG.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("			      ,SLS_LOC.RGN_CD AS OB_SLS_RGN_CD" ).append("\n"); 
		query.append("			      ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("			      ,BKG.SCAC_CD" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(MIN(XTER.RQST_DT) OVER (PARTITION BY BKG.BKG_NO),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("			          FROM BKG_XTER_RQST_MST XTER" ).append("\n"); 
		query.append("			         WHERE XTER.DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("			           AND BKG.BKG_NO = XTER.BKG_NO" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS SI_DT" ).append("\n"); 
		query.append("			      ,BKG_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(NVL(OP_CNTR_QTY, 0),'990.99'))" ).append("\n"); 
		query.append("                                         FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                                        WHERE Q.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                          AND Q.CNTR_TPSZ_CD IS NOT NULL)) CNTR_VOL" ).append("\n"); 
		query.append("			 --Cargo & Commodity" ).append("\n"); 
		query.append("			      ,REPLACE(REPLACE(REPLACE(CM.CNTR_MF_GDS_DESC,CHR(10),' '),CHR(9),' '),CHR(34),'') AS CGO_DESC" ).append("\n"); 
		query.append("			      ,NVL(SUBSTR(DECODE(BKG.DCGO_FLG,'Y',',DG','')||DECODE(BKG.RC_FLG,'Y',',RF','')||DECODE(BKG.AWK_CGO_FLG,'Y',',AW','')||DECODE(BKG.BB_CGO_FLG,'Y',',BB','')||DECODE(BKG.RD_CGO_FLG,'Y',',RD',''),2),'DR') AS CGO_NATURE" ).append("\n"); 
		query.append("			      ,TRIM(TO_CHAR(CNTR.CNTR_WGT,'999,999,999,990.99')) AS CNTR_WGT" ).append("\n"); 
		query.append("			      ,CNTR.WGT_UT_CD AS CNTR_WGT_UT" ).append("\n"); 
		query.append("			      ,TRIM(TO_CHAR(CM.CNTR_MF_WGT,'999,999,999,990.99')) AS CGO_WGT" ).append("\n"); 
		query.append("			      ,CM.WGT_UT_CD AS CGO_WGT_UT" ).append("\n"); 
		query.append("			      ,TO_CHAR(CM.MEAS_QTY) AS CM_MEAS" ).append("\n"); 
		query.append("			      ,CM.MEAS_UT_CD AS CM_MEAS_UT" ).append("\n"); 
		query.append("			      ,NVL((SELECT TRIM(TO_CHAR(ROUND(B.TARE_WGT,1),'999,999,999,990.99'))" ).append("\n"); 
		query.append("                          FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                              ,MST_CNTR_SPEC B" ).append("\n"); 
		query.append("                         WHERE A.CNTR_SPEC_NO = B.CNTR_SPEC_NO" ).append("\n"); 
		query.append("                           AND A.CNTR_NO = CNTR.CNTR_NO)" ).append("\n"); 
		query.append("                     , (SELECT TRIM(TO_CHAR(ROUND(CNTR_TPSZ_TARE_WGT,1),'999,999,999,990.99'))" ).append("\n"); 
		query.append("                          FROM MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("                         WHERE MDM.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                   ) AS TARE_WGT" ).append("\n"); 
		query.append("                  ,'KGS' AS TARE_WGT_UT" ).append("\n"); 
		query.append("			      ,TO_CHAR(CM.PCK_QTY) AS PCK_QTY" ).append("\n"); 
		query.append("			      ,CM.PCK_TP_CD" ).append("\n"); 
		query.append("				  ,DECODE(SUBSTR(CM.CMDT_HS_CD,1,1),0,'''','')||CM.CMDT_HS_CD AS CMDT_HS_CD" ).append("\n"); 
		query.append("				  ,HS.HAMO_CD_DESC" ).append("\n"); 
		query.append("			 --Charge" ).append("\n"); 
		query.append("                  ,CHG.C_1_CURR" ).append("\n"); 
		query.append("                  ,TRIM(TO_CHAR(CHG.C_1_AMT,'999,999,999,990.99')) AS C_1_AMT" ).append("\n"); 
		query.append("                  ,CHG.C_2_CURR" ).append("\n"); 
		query.append("                  ,TRIM(TO_CHAR(CHG.C_2_AMT,'999,999,999,990.99')) AS C_2_AMT" ).append("\n"); 
		query.append("                  ,CHG.C_3_CURR" ).append("\n"); 
		query.append("                  ,TRIM(TO_CHAR(CHG.C_3_AMT,'999,999,999,990.99')) AS C_3_AMT" ).append("\n"); 
		query.append("                  ,CHG.C_4_CURR" ).append("\n"); 
		query.append("                  ,TRIM(TO_CHAR(CHG.C_4_AMT,'999,999,999,990.99')) AS C_4_AMT" ).append("\n"); 
		query.append("                  ,CHG.P_1_CURR" ).append("\n"); 
		query.append("                  ,TRIM(TO_CHAR(CHG.P_1_AMT,'999,999,999,990.99')) AS P_1_AMT" ).append("\n"); 
		query.append("                  ,CHG.P_2_CURR" ).append("\n"); 
		query.append("                  ,TRIM(TO_CHAR(CHG.P_2_AMT,'999,999,999,990.99')) AS P_2_AMT" ).append("\n"); 
		query.append("                  ,CHG.P_3_CURR" ).append("\n"); 
		query.append("                  ,TRIM(TO_CHAR(CHG.P_3_AMT,'999,999,999,990.99')) AS P_3_AMT" ).append("\n"); 
		query.append("                  ,CHG.P_4_CURR" ).append("\n"); 
		query.append("                  ,TRIM(TO_CHAR(CHG.P_4_AMT,'999,999,999,990.99')) AS P_4_AMT" ).append("\n"); 
		query.append("			 --Container" ).append("\n"); 
		query.append("			      ,CNTR.CNTR_NO" ).append("\n"); 
		query.append("			      ,CNTR.CNTR_TPSZ_CD AS CNTR_SZ" ).append("\n"); 
		query.append("				  ,DECODE(BKG.BKG_STS_CD,'X',''," ).append("\n"); 
		query.append("							DECODE((SELECT COP.COP_STS_CD FROM SCE_COP_HDR COP WHERE COP.BKG_NO = CNTR.BKG_NO AND COP.CNTR_NO = CNTR.CNTR_NO AND COP_STS_CD <> 'X'),'F','MT'," ).append("\n"); 
		query.append("									(SELECT B.CNMV_STS_CD FROM MST_CONTAINER B WHERE B.CNTR_NO = CNTR.CNTR_NO))) CNMV_STS_CD" ).append("\n"); 
		query.append("			      ,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL CD_DTL WHERE CD_DTL.INTG_CD_ID = 'CD00252' " ).append("\n"); 
		query.append("																		AND CD_DTL.INTG_CD_VAL_CTNT=(DECODE(BKG.BKG_STS_CD,'X',''," ).append("\n"); 
		query.append("							DECODE((SELECT COP.COP_STS_CD FROM SCE_COP_HDR COP WHERE COP.BKG_NO = CNTR.BKG_NO AND COP.CNTR_NO = CNTR.CNTR_NO AND COP_STS_CD <> 'X'),'F','MT'," ).append("\n"); 
		query.append("									(SELECT B.CNMV_STS_CD FROM MST_CONTAINER B WHERE B.CNTR_NO = CNTR.CNTR_NO))))) AS CNMV_STS_NMK" ).append("\n"); 
		query.append("			      ,BKG_JOIN_FNC(CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("										 FROM BKG_CNTR_SEAL_NO CNTR_SEAL" ).append("\n"); 
		query.append("										WHERE CNTR.BKG_NO = CNTR_SEAL.BKG_NO" ).append("\n"); 
		query.append("										  AND CNTR.CNTR_NO = CNTR_SEAL.CNTR_NO),';') AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("                  ,TO_CHAR(CNTR.CNTR_VOL_QTY) AS CNTR_VOL_QTY" ).append("\n"); 
		query.append("                  ,(SELECT TO_CHAR(SUM(DECODE(CNTR_SZ_CD, 2, 1, 2) * OP_CNTR_QTY))" ).append("\n"); 
		query.append("                      FROM BKG_QUANTITY QTY," ).append("\n"); 
		query.append("                           MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("                     WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                       AND QTY.CNTR_TPSZ_CD = MDM.CNTR_TPSZ_CD) AS TEU" ).append("\n"); 
		query.append("                  ,(SELECT TO_CHAR(SUM(DECODE(CNTR_SZ_CD, 2, 0.5, 1) * OP_CNTR_QTY))" ).append("\n"); 
		query.append("                      FROM BKG_QUANTITY QTY," ).append("\n"); 
		query.append("                           MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("                     WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                       AND QTY.CNTR_TPSZ_CD = MDM.CNTR_TPSZ_CD) AS FEU" ).append("\n"); 
		query.append("				  ,DECODE(NVL(CNTR.VGM_WGT,0),0,'N','Y') AS VGM" ).append("\n"); 
		query.append("			 --Customer" ).append("\n"); 
		query.append("			      ,REPLACE(REPLACE(REPLACE(NF.CUST_NM,CHR(10),' '),CHR(9),' '),CHR(34),'') AS NF_CUST_NM" ).append("\n"); 
		query.append("			      ,REPLACE(REPLACE(REPLACE(AN.CUST_NM,CHR(10),' '),CHR(9),' '),CHR(34),'') AS AN_CUST_NM" ).append("\n"); 
		query.append("			      ,REPLACE(REPLACE(REPLACE(SH.CUST_NM,CHR(10),' '),CHR(9),' '),CHR(34),'') AS SH_CUST_NM" ).append("\n"); 
		query.append("			      ,SH_ADDR.CNTC_PSON_NM AS SH_CNTC_PSON_NM" ).append("\n"); 
		query.append("			      ,(SELECT A.INTL_PHN_NO || A.PHN_NO" ).append("\n"); 
		query.append("			          FROM MDM_CUST_CNTC_PNT A" ).append("\n"); 
		query.append("			              ,BKG_CUSTOMER B" ).append("\n"); 
		query.append("			         WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("			           AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("			           AND B.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS SH_CNTC_NUM" ).append("\n"); 
		query.append("			      ,REPLACE(REPLACE(REPLACE(CN.CUST_NM,CHR(10),' '),CHR(9),' '),CHR(34),'') AS CN_CUST_NM" ).append("\n"); 
		query.append("			      ,REPLACE(REPLACE(REPLACE(FF.CUST_NM,CHR(10),' '),CHR(9),' '),CHR(34),'') AS FF_CUST_NM" ).append("\n"); 
		query.append("			      ,FF_ADDR.CNTC_PSON_NM AS FF_CNTC_PSON_NM" ).append("\n"); 
		query.append("			      ,(SELECT A.INTL_PHN_NO || A.PHN_NO" ).append("\n"); 
		query.append("			          FROM MDM_CUST_CNTC_PNT A" ).append("\n"); 
		query.append("			              ,BKG_CUSTOMER B" ).append("\n"); 
		query.append("			         WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("			           AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("			           AND B.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS FW_CNTC_NUM" ).append("\n"); 
		query.append("			      ,ISS.OBL_INET_FLG" ).append("\n"); 
		query.append("                  ,BKG_CTRL_PTY_CUST_CNT_CD||LPAD(BKG.BKG_CTRL_PTY_CUST_SEQ,6,'0') AS CTRT_PTY_CD" ).append("\n"); 
		query.append("                  ,(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = BKG.BKG_CTRL_PTY_CUST_CNT_CD AND CUST_SEQ = BKG.BKG_CTRL_PTY_CUST_SEQ) AS CTRT_PTY_NM" ).append("\n"); 
		query.append("			 --Inbound Info" ).append("\n"); 
		query.append("                  ,(SELECT SLS_OFC_CD" ).append("\n"); 
		query.append("                      FROM MDM_LOCATION A" ).append("\n"); 
		query.append("                     WHERE A.LOC_CD = BKG.DEL_CD) AS IB_CTRL_OFC" ).append("\n"); 
		query.append("			      ,(SELECT DECODE(COUNT(TROI.BKG_NO) OVER (PARTITION BY TROI.BKG_NO), 0, 'N', 'Y')     " ).append("\n"); 
		query.append("			          FROM BKG_EUR_TRO TROI" ).append("\n"); 
		query.append("			         WHERE BKG.BKG_NO = TROI.BKG_NO" ).append("\n"); 
		query.append("			           AND TROI.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS TROI" ).append("\n"); 
		query.append("                  ,NVL((SELECT 'Complete' FROM BKG_CHG_RT WHERE BKG_NO = BKG.BKG_NO AND ROWNUM=1),'Incomplete') AS IB_FRH_FLG" ).append("\n"); 
		query.append("			 --Rate & Invoice" ).append("\n"); 
		query.append("			      ,(SELECT /*+ INDEX_DESC(A XPKACM_FF_CMPN) */TO_CHAR(CRNT_AMT)" ).append("\n"); 
		query.append("                      FROM ACM_FF_CMPN A" ).append("\n"); 
		query.append("                     WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) AS ACM_AMT" ).append("\n"); 
		query.append("			      ,(SELECT /*+ INDEX_DESC(A XPKACM_FF_CMPN) */M.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      FROM ACM_FF_CMPN A, MDM_CUSTOMER M" ).append("\n"); 
		query.append("                     WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                       AND A.BKG_FF_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("                       AND A.BKG_FF_SEQ = M.CUST_SEQ" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) AS ACM_PTY" ).append("\n"); 
		query.append("			      ,NVL(BKG.TAA_NO,NVL(BKG.RFA_NO,BKG.SC_NO)) AS TRF_CD" ).append("\n"); 
		query.append("			 --Reference No" ).append("\n"); 
		query.append("			      ,IBD_TRSP_TP_CD||DECODE(IBD_TRSP_TP_CD,'61','(IT)','62','(T&E)','63','(IE)','') AS IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("			      ,(SELECT CRN_BL.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("			          FROM BKG_VVD CRN_VVD" ).append("\n"); 
		query.append("			              ,BKG_CSTMS_RTM_BL CRN_BL" ).append("\n"); 
		query.append("			              ,BKG_CSTMS_RTM_VSL CRN_VSL" ).append("\n"); 
		query.append("			         WHERE BKG.BKG_NO = CRN_VVD.BKG_NO" ).append("\n"); 
		query.append("			           AND BKG.BKG_NO = CRN_BL.BKG_NO" ).append("\n"); 
		query.append("			           AND CRN_VVD.POD_CD LIKE 'NL%'" ).append("\n"); 
		query.append("			           AND CRN_VVD.VSL_CD = CRN_VSL.VSL_CD" ).append("\n"); 
		query.append("			           AND CRN_VVD.SKD_VOY_NO = CRN_VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("			           AND CRN_VVD.SKD_DIR_CD = CRN_VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("			           AND CRN_VSL.VSL_CALL_REF_NO = CRN_BL.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("                       AND ROWNUM = 1) AS CRN" ).append("\n"); 
		query.append("                  ,BKG_JOIN_FNC(CURSOR(SELECT EUR_BL.MVMT_REF_NO" ).append("\n"); 
		query.append("										 FROM BKG_CSTMS_EUR_BL EUR_BL" ).append("\n"); 
		query.append("										WHERE BKG.BL_NO = EUR_BL.BL_NO),';') AS ENS_MRN" ).append("\n"); 
		query.append("			      ,BKG_JOIN_FNC(CURSOR(SELECT EX_EUR_BL.MVMT_REF_NO" ).append("\n"); 
		query.append("										 FROM BKG_CSTMS_EUR_IO_BL EX_EUR_BL" ).append("\n"); 
		query.append("										WHERE BKG.BL_NO = EX_EUR_BL.BL_NO),';') AS EXS_MRN" ).append("\n"); 
		query.append("                  ,DECODE(CNTR.CNTR_NO, NULL, " ).append("\n"); 
		query.append("                                          BKG_JOIN_FNC(CURSOR(SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("                                                                FROM BKG_REFERENCE CMRN" ).append("\n"); 
		query.append("                                                               WHERE CMRN.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                                                 AND CMRN.BKG_REF_TP_CD = 'CMRN'" ).append("\n"); 
		query.append("                                                               ORDER BY CMRN.REF_SEQ" ).append("\n"); 
		query.append("                                                              ),',')," ).append("\n"); 
		query.append("                                          (SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("                                             FROM BKG_REFERENCE CMRN" ).append("\n"); 
		query.append("                                            WHERE CMRN.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                              AND CMRN.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                                              AND CMRN.BKG_REF_TP_CD = 'CMRN')) AS CMRN_REF_NO" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(SND_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("			          FROM BKG_CSTMS_EUR_IO_BL IO, " ).append("\n"); 
		query.append("			               BKG_CSTMS_EUR_IO_SND SND," ).append("\n"); 
		query.append("			               BKG_VVD IO_VVD" ).append("\n"); 
		query.append("                     WHERE IO.MSG_SND_NO = SND.MSG_SND_NO" ).append("\n"); 
		query.append("                       AND IO.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("                       AND IO_VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                       AND IO.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                       AND IO.VSL_CD = IO_VVD.VSL_CD" ).append("\n"); 
		query.append("                       AND IO.SKD_VOY_NO = IO_VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND IO.SKD_DIR_CD = IO_VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) AS ACT_CSTMS_SMT_DT			" ).append("\n"); 
		query.append("			      ,(SELECT XPT_LIC_NO" ).append("\n"); 
		query.append("			          FROM BKG_XPT_IMP_LIC XIL" ).append("\n"); 
		query.append("			         WHERE BKG.BKG_NO = XIL.BKG_NO" ).append("\n"); 
		query.append("			           AND XPT_LIC_NO IS NOT NULL" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS XPT_LIC_NO" ).append("\n"); 
		query.append("			      ,IBD_TRSP_NO" ).append("\n"); 
		query.append("			 --Route & Schedule" ).append("\n"); 
		query.append("			      ,BKG.BLCK_STWG_CD" ).append("\n"); 
		query.append("                  ,DECODE(BKG.RCV_TERM_CD, 'D', 'C', 'M') AS RCV_TERM_CD" ).append("\n"); 
		query.append("                  ,NVL((SELECT DECODE(TRO.HLG_TP_CD, 'C', 'C', 'M')" ).append("\n"); 
		query.append("                            FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("                           WHERE TRO.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                             AND TRO.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                             AND TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                             AND TRO.CXL_FLG = 'N'" ).append("\n"); 
		query.append("							 AND ROWNUM = 1), DECODE(BKG.DE_TERM_CD, 'D', 'C', 'M')) AS DE_TERM_CD" ).append("\n"); 
		query.append("                  ,DECODE(NVL(CNTR.RCV_TERM_CD, BKG.RCV_TERM_CD),'S','LCL','FCL') AS TRAF_MOD_OB" ).append("\n"); 
		query.append("                  ,DECODE(NVL(CNTR.DE_TERM_CD, BKG.DE_TERM_CD),'S','LCL','FCL') AS TRAF_MOD_IB" ).append("\n"); 
		query.append("			      ,BKG.SLAN_CD AS TRUNK_SLAN_CD" ).append("\n"); 
		query.append("                  ,TRUNK.POL_CD AS TRUNK_POL_CD" ).append("\n"); 
		query.append("                  ,TRUNK.POD_CD AS TRUNK_POD_CD" ).append("\n"); 
		query.append("			      ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS TRUNK_VVD" ).append("\n"); 
		query.append("                  ,(SELECT VSL_ENG_NM FROM MDM_VSL_CNTR M WHERE M.VSL_CD = BKG.VSL_CD) AS VSL_NM" ).append("\n"); 
		query.append("			      ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS BL_VVD" ).append("\n"); 
		query.append("			      ,BKG.SLAN_CD AS BL_SLAN_CD" ).append("\n"); 
		query.append("			      ,(SELECT TRD_CD FROM COA_RGST_BKG C WHERE C.BKG_NO = BKG.BKG_NO) AS TRD_CD" ).append("\n"); 
		query.append("			      ,BKG.SVC_SCP_CD AS SVC_SCP_CD" ).append("\n"); 
		query.append("			      ,SUBSTR(BKG.POR_CD,1,2) POR_CNT_CD" ).append("\n"); 
		query.append("			      ,BKG.POR_CD" ).append("\n"); 
		query.append("			      ,(SELECT LOC_NM FROM MDM_LOCATION MDM WHERE MDM.LOC_CD = BKG.POR_CD) AS POR_NM" ).append("\n"); 
		query.append("                  ,VVD5.POL_CD AS PRE1_POL_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD5.POL_CD) AS PRE1_POL_NM" ).append("\n"); 
		query.append("                  ,VVD6.POL_CD AS PRE2_POL_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD6.POL_CD) AS PRE2_POL_NM" ).append("\n"); 
		query.append("                  ,VVD7.POL_CD AS PRE3_POL_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD7.POL_CD) AS PRE3_POL_NM" ).append("\n"); 
		query.append("                  ,VVD8.POL_CD AS PRE4_POL_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD8.POL_CD) AS PRE4_POL_NM" ).append("\n"); 
		query.append("                  ,VVD1.POL_CD AS POST1_POL_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD1.POL_CD) AS POST1_POL_NM" ).append("\n"); 
		query.append("                  ,VVD2.POL_CD AS POST2_POL_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD2.POL_CD) AS POST2_POL_NM" ).append("\n"); 
		query.append("                  ,VVD3.POL_CD AS POST3_POL_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD3.POL_CD) AS POST3_POL_NM" ).append("\n"); 
		query.append("                  ,VVD4.POL_CD AS POST4_POL_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD4.POL_CD) AS POST4_POL_NM" ).append("\n"); 
		query.append("                  ,VVD5.POD_CD AS PRE1_POD_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD5.POD_CD) AS PRE1_POD_NM" ).append("\n"); 
		query.append("                  ,VVD6.POD_CD AS PRE2_POD_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD6.POD_CD) AS PRE2_POD_NM" ).append("\n"); 
		query.append("                  ,VVD7.POD_CD AS PRE3_POD_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD7.POD_CD) AS PRE3_POD_NM" ).append("\n"); 
		query.append("                  ,VVD8.POD_CD AS PRE4_POD_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD8.POD_CD) AS PRE4_POD_NM" ).append("\n"); 
		query.append("                  ,VVD1.POD_CD AS POST1_POD_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD1.POD_CD) AS POST1_POD_NM" ).append("\n"); 
		query.append("                  ,VVD2.POD_CD AS POST2_POD_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD2.POD_CD) AS POST2_POD_NM" ).append("\n"); 
		query.append("                  ,VVD3.POD_CD AS POST3_POD_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD3.POD_CD) AS POST3_POD_NM" ).append("\n"); 
		query.append("                  ,VVD4.POD_CD AS POST4_POD_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD4.POD_CD) AS POST4_POD_NM" ).append("\n"); 
		query.append("                  ,BKG.POD_CD AS LAST_POD_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BKG.POD_CD) AS LAST_POD_NM" ).append("\n"); 
		query.append("                  ,(SELECT CNT_CD FROM MDM_LOCATION WHERE LOC_CD = BKG.DEL_CD) AS DEL_CNT_CD" ).append("\n"); 
		query.append("                  ,BKG.DEL_CD" ).append("\n"); 
		query.append("                  ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BKG.DEL_CD) AS DEL_NM" ).append("\n"); 
		query.append("                  ,VVD5.VSL_CD||VVD5.SKD_VOY_NO||VVD5.SKD_DIR_CD AS PRE1_VVD" ).append("\n"); 
		query.append("                  ,VVD6.VSL_CD||VVD6.SKD_VOY_NO||VVD6.SKD_DIR_CD AS PRE2_VVD" ).append("\n"); 
		query.append("                  ,VVD7.VSL_CD||VVD7.SKD_VOY_NO||VVD7.SKD_DIR_CD AS PRE3_VVD" ).append("\n"); 
		query.append("                  ,VVD8.VSL_CD||VVD8.SKD_VOY_NO||VVD8.SKD_DIR_CD AS PRE4_VVD" ).append("\n"); 
		query.append("                  ,VVD1.VSL_CD||VVD1.SKD_VOY_NO||VVD1.SKD_DIR_CD AS POST1_VVD" ).append("\n"); 
		query.append("                  ,VVD2.VSL_CD||VVD2.SKD_VOY_NO||VVD2.SKD_DIR_CD AS POST2_VVD" ).append("\n"); 
		query.append("                  ,VVD3.VSL_CD||VVD3.SKD_VOY_NO||VVD3.SKD_DIR_CD AS POST3_VVD" ).append("\n"); 
		query.append("                  ,VVD4.VSL_CD||VVD4.SKD_VOY_NO||VVD4.SKD_DIR_CD AS POST4_VVD" ).append("\n"); 
		query.append("			      ,N1ST_VVD.VSL_CD||N1ST_VVD.SKD_VOY_NO||N1ST_VVD.SKD_DIR_CD AS FIRST_VVD" ).append("\n"); 
		query.append("			      ,LAST_VVD.VSL_CD||LAST_VVD.SKD_VOY_NO||LAST_VVD.SKD_DIR_CD AS LAST_VVD" ).append("\n"); 
		query.append("			      ,TO_CHAR(N1ST_SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') AS FIRST_POL_ETD" ).append("\n"); 
		query.append("                  ,DECODE(N1ST_SKD.ACT_INP_FLG,'Y',TO_CHAR(N1ST_SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI'),'') AS FIRST_POL_ATD" ).append("\n"); 
		query.append("			      ,TO_CHAR(LAST_SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') AS LAST_POD_ETA" ).append("\n"); 
		query.append("                  ,DECODE(LAST_SKD.ACT_INP_FLG,'Y',TO_CHAR(LAST_SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'),'') AS LAST_POD_ATA" ).append("\n"); 
		query.append("                  ,BKG.DEST_TRNS_MOD_CD AS TRSP_MOD_IB" ).append("\n"); 
		query.append("                  ,BKG.ORG_TRNS_MOD_CD AS TRSP_MOD_OB" ).append("\n"); 
		query.append("                  ,(SELECT TO_CHAR(NVL(MNL_SET_DT,SYS_SET_DT),'YYYY-MM-DD HH24:MI') FROM BKG_CLZ_TM WHERE CLZ_TP_CD = 'T' AND BKG_NO=BKG.BKG_NO) AS FIRST_POL_CUTOFF_DT" ).append("\n"); 
		query.append("			      ,TO_CHAR(N1ST_SKD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') AS FIRST_POL_ETB" ).append("\n"); 
		query.append("			      ,TO_CHAR(LAST_SKD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') AS LAST_POD_ETB" ).append("\n"); 
		query.append("                  ,BKG_JOIN_FNC(CURSOR(SELECT /*+ INDEX(VV XPKBKG_VVD) */POD_CD" ).append("\n"); 
		query.append("                      FROM BKG_VVD VV" ).append("\n"); 
		query.append("                     WHERE VV.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                       AND VV.POD_CD <> BKG.POD_CD--LAST POD는 TS PORT가 아님" ).append("\n"); 
		query.append("                   ),',') AS TS_POD--위에서 GET해서 사용" ).append("\n"); 
		query.append("			  FROM " ).append("\n"); 
		query.append("                   BKG_VVD VVD," ).append("\n"); 
		query.append("#if (${sail_from_dt} != '' && ${sail_to_dt} != '') " ).append("\n"); 
		query.append("                   VSK_VSL_PORT_SKD ETD_VSK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${arr_from_dt} != '' && ${arr_to_dt} != '') " ).append("\n"); 
		query.append("                   VSK_VSL_PORT_SKD ETA_VSK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   BKG_BOOKING BKG" ).append("\n"); 
		query.append("			      ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("			      ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("			      ,BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("			      ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("			      ,BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("			      ,BKG_HAMO_TRF HS" ).append("\n"); 
		query.append("			      ,BKG_CUSTOMER SH" ).append("\n"); 
		query.append("			      ,BKG_CUSTOMER FF" ).append("\n"); 
		query.append("			      ,BKG_CUSTOMER NF" ).append("\n"); 
		query.append("			      ,BKG_CUSTOMER AN" ).append("\n"); 
		query.append("			      ,BKG_CUSTOMER CN" ).append("\n"); 
		query.append("			      ,BKG_DOC_PROC_SKD SRD" ).append("\n"); 
		query.append("			      ,COM_USER USR" ).append("\n"); 
		query.append("			      ,MDM_ORGANIZATION SLS_ORG" ).append("\n"); 
		query.append("			      ,MDM_LOCATION SLS_LOC" ).append("\n"); 
		query.append("			      ,MDM_COMMODITY CMDT" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD1" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD2" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD3" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD4" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD5" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD6" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD7" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD8" ).append("\n"); 
		query.append("                  ,BKG_VVD TRUNK" ).append("\n"); 
		query.append("                  ,BKG_VVD N1ST_VVD" ).append("\n"); 
		query.append("                  ,BKG_VVD LAST_VVD" ).append("\n"); 
		query.append("			      ,VSK_VSL_PORT_SKD N1ST_SKD" ).append("\n"); 
		query.append("			      ,VSK_VSL_PORT_SKD LAST_SKD" ).append("\n"); 
		query.append("			      ,MDM_CUST_ADDR FF_ADDR" ).append("\n"); 
		query.append("			      ,MDM_CUST_ADDR SH_ADDR" ).append("\n"); 
		query.append("			      ,(SELECT BKG_NO, " ).append("\n"); 
		query.append("                           MAX(DECODE(FRT_TERM_CD,'C',DECODE(RNUM,1,CURR_CD,0),0)) AS C_1_CURR, MAX(DECODE(FRT_TERM_CD,'C',DECODE(RNUM,1,AMT,0),0)) AS C_1_AMT," ).append("\n"); 
		query.append("                           MAX(DECODE(FRT_TERM_CD,'C',DECODE(RNUM,2,CURR_CD,0),0)) AS C_2_CURR, MAX(DECODE(FRT_TERM_CD,'C',DECODE(RNUM,2,AMT,0),0)) AS C_2_AMT," ).append("\n"); 
		query.append("                           MAX(DECODE(FRT_TERM_CD,'C',DECODE(RNUM,3,CURR_CD,0),0)) AS C_3_CURR, MAX(DECODE(FRT_TERM_CD,'C',DECODE(RNUM,3,AMT,0),0)) AS C_3_AMT," ).append("\n"); 
		query.append("                           MAX(DECODE(FRT_TERM_CD,'C',DECODE(RNUM,4,CURR_CD,0),0)) AS C_4_CURR, MAX(DECODE(FRT_TERM_CD,'C',DECODE(RNUM,4,AMT,0),0)) AS C_4_AMT," ).append("\n"); 
		query.append("                           MAX(DECODE(FRT_TERM_CD,'P',DECODE(RNUM,1,CURR_CD,0),0)) AS P_1_CURR, MAX(DECODE(FRT_TERM_CD,'P',DECODE(RNUM,1,AMT,0),0)) AS P_1_AMT," ).append("\n"); 
		query.append("                           MAX(DECODE(FRT_TERM_CD,'P',DECODE(RNUM,2,CURR_CD,0),0)) AS P_2_CURR, MAX(DECODE(FRT_TERM_CD,'P',DECODE(RNUM,2,AMT,0),0)) AS P_2_AMT," ).append("\n"); 
		query.append("                           MAX(DECODE(FRT_TERM_CD,'P',DECODE(RNUM,3,CURR_CD,0),0)) AS P_3_CURR, MAX(DECODE(FRT_TERM_CD,'P',DECODE(RNUM,3,AMT,0),0)) AS P_3_AMT," ).append("\n"); 
		query.append("                           MAX(DECODE(FRT_TERM_CD,'P',DECODE(RNUM,4,CURR_CD,0),0)) AS P_4_CURR, MAX(DECODE(FRT_TERM_CD,'P',DECODE(RNUM,4,AMT,0),0)) AS P_4_AMT" ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                            SELECT BKG_NO, FRT_TERM_CD, CURR_CD, SUM(CHG_AMT) AMT, ROW_NUMBER() OVER(PARTITION BY BKG_NO, FRT_TERM_CD ORDER BY DECODE(CURR_CD,'USD',0,1),CURR_CD) AS RNUM" ).append("\n"); 
		query.append("                              FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                             WHERE N3PTY_RCV_OFC_CD IS NULL" ).append("\n"); 
		query.append("                               AND FRT_INCL_XCLD_DIV_CD='N'" ).append("\n"); 
		query.append("                            GROUP BY BKG_NO, FRT_TERM_CD, CURR_CD" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                    GROUP BY BKG_NO" ).append("\n"); 
		query.append("                   ) CHG" ).append("\n"); 
		query.append("			 WHERE BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("			   AND BKG.BL_NO = IBD.BL_NO (+)" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = CNTR.BKG_NO (+)" ).append("\n"); 
		query.append("			   AND CNTR.BKG_NO = CM.BKG_NO (+)" ).append("\n"); 
		query.append("			   AND CNTR.CNTR_NO = CM.CNTR_NO (+)" ).append("\n"); 
		query.append("			   AND CM.CMDT_HS_CD = HS.HAMO_TRF_CD (+)" ).append("\n"); 
		query.append("			   AND HS.HAMO_TP_CD (+) = 'H'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = SH.BKG_NO" ).append("\n"); 
		query.append("			   AND SH.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = FF.BKG_NO" ).append("\n"); 
		query.append("			   AND FF.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = NF.BKG_NO" ).append("\n"); 
		query.append("			   AND NF.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = AN.BKG_NO" ).append("\n"); 
		query.append("			   AND AN.BKG_CUST_TP_CD = 'A'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = CN.BKG_NO" ).append("\n"); 
		query.append("			   AND CN.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = SRD.BKG_NO (+)" ).append("\n"); 
		query.append("			   AND SRD.BKG_DOC_PROC_TP_CD (+) = 'OBLSRD'" ).append("\n"); 
		query.append("			   AND SRD.DOC_PERF_DELT_FLG (+) = 'N'" ).append("\n"); 
		query.append("			   AND SRD.EVNT_USR_ID = USR.USR_ID (+)" ).append("\n"); 
		query.append("			   AND BKG.OB_SLS_OFC_CD = SLS_ORG.OFC_CD (+)" ).append("\n"); 
		query.append("			   AND SLS_ORG.LOC_CD = SLS_LOC.LOC_CD (+)   " ).append("\n"); 
		query.append("			   AND BKG.CMDT_CD = CMDT.CMDT_CD(+)" ).append("\n"); 
		query.append("			   AND FF.CUST_CNT_CD = FF_ADDR.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("			   AND FF.CUST_SEQ = FF_ADDR.CUST_SEQ (+)" ).append("\n"); 
		query.append("			   AND 'Y' = FF_ADDR.PRMRY_CHK_FLG (+)" ).append("\n"); 
		query.append("			   AND SH.CUST_CNT_CD = SH_ADDR.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("			   AND SH.CUST_SEQ = SH_ADDR.CUST_SEQ (+)" ).append("\n"); 
		query.append("			   AND 'S' = SH_ADDR.PRMRY_CHK_FLG (+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO         = TRUNK.BKG_NO(+)" ).append("\n"); 
		query.append("               AND BKG.VSL_CD         = TRUNK.VSL_CD(+)" ).append("\n"); 
		query.append("               AND BKG.SKD_VOY_NO     = TRUNK.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("               AND BKG.SKD_DIR_CD     = TRUNK.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("               AND 'T'                = TRUNK.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD1.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 1 = VVD1.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'U' = VVD1.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD2.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 2 = VVD2.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'U' = VVD2.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD3.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 3 = VVD3.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'U' = VVD3.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD4.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 4 = VVD4.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'U' = VVD4.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD5.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 1 = VVD5.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'S' = VVD5.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD6.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 2 = VVD6.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'S' = VVD6.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD7.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 3 = VVD7.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'S' = VVD7.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD8.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 4 = VVD8.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'S' = VVD8.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND (N1ST_VVD.BKG_NO, N1ST_VVD.VSL_PRE_PST_CD, N1ST_VVD.VSL_SEQ) " ).append("\n"); 
		query.append("                                         = (SELECT /*+ index(v2 xpkbkg_vvd) */ " ).append("\n"); 
		query.append("                                                    V2.BKG_NO, V2.VSL_PRE_PST_CD, V2.VSL_SEQ" ).append("\n"); 
		query.append("                                              FROM BKG_VVD V2" ).append("\n"); 
		query.append("                                             WHERE V2.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("               AND (LAST_VVD.BKG_NO, LAST_VVD.VSL_PRE_PST_CD, LAST_VVD.VSL_SEQ) " ).append("\n"); 
		query.append("                                         = (SELECT /*+ index_desc(v2 xpkbkg_vvd) */ " ).append("\n"); 
		query.append("                                                    V2.BKG_NO, V2.VSL_PRE_PST_CD, V2.VSL_SEQ" ).append("\n"); 
		query.append("                                              FROM BKG_VVD V2" ).append("\n"); 
		query.append("                                             WHERE V2.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("               AND N1ST_VVD.VSL_CD     = N1ST_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("               AND N1ST_VVD.SKD_VOY_NO = N1ST_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("               AND N1ST_VVD.SKD_DIR_CD = N1ST_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("               AND N1ST_VVD.POL_CD     = N1ST_SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("               AND N1ST_VVD.POL_CLPT_IND_SEQ = N1ST_SKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("               AND LAST_VVD.VSL_CD     = LAST_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("               AND LAST_VVD.SKD_VOY_NO = LAST_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("               AND LAST_VVD.SKD_DIR_CD = LAST_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("               AND LAST_VVD.POD_CD     = LAST_SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("               AND LAST_VVD.POD_CLPT_IND_SEQ = LAST_SKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = CHG.BKG_NO(+)" ).append("\n"); 
		query.append("--ROUTE" ).append("\n"); 
		query.append("               AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("               AND VVD.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("               AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("               AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#if (${trunk_flag} != '')" ).append("\n"); 
		query.append("               AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '') " ).append("\n"); 
		query.append("               AND VVD.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("               AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#if (${pol_local} != '')" ).append("\n"); 
		query.append("               AND BKG.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_ts} != '')" ).append("\n"); 
		query.append("               AND BKG.POL_CD <> VVD.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_yard_cd} != '') " ).append("\n"); 
		query.append("               AND SUBSTR(VVD.POL_YD_CD,-2) = @[pol_yard_cd]" ).append("\n"); 
		query.append("#if (${pol_local} != '')" ).append("\n"); 
		query.append("               AND BKG.POL_NOD_CD = VVD.POL_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_ts} != '')" ).append("\n"); 
		query.append("               AND BKG.POL_NOD_CD <> VVD.POL_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("               AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#if (${pod_local} != '')" ).append("\n"); 
		query.append("               AND BKG.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_ts} != '')" ).append("\n"); 
		query.append("               AND BKG.POD_CD <> VVD.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_yard_cd} != '') " ).append("\n"); 
		query.append("               AND SUBSTR(VVD.POD_YD_CD,-2) = @[pod_yard_cd]" ).append("\n"); 
		query.append("#if (${pod_local} != '')" ).append("\n"); 
		query.append("               AND BKG.POD_NOD_CD = VVD.POD_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_ts} != '')" ).append("\n"); 
		query.append("               AND BKG.POD_NOD_CD <> VVD.POD_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sail_from_dt} != '' && ${sail_to_dt} != '') " ).append("\n"); 
		query.append("               AND ETD_VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("               AND ETD_VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND ETD_VSK.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND ETD_VSK.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("               AND ETD_VSK.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("               AND ETD_VSK.VPS_ETD_DT >= TO_DATE(@[sail_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("               AND ETD_VSK.VPS_ETD_DT <= TO_DATE(@[sail_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${arr_from_dt} != '' && ${arr_to_dt} != '') " ).append("\n"); 
		query.append("               AND ETA_VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("               AND ETA_VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND ETA_VSK.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND ETA_VSK.VPS_PORT_CD = VVD.POD_CD" ).append("\n"); 
		query.append("               AND ETA_VSK.CLPT_IND_SEQ = VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("               AND ETA_VSK.VPS_ETD_DT >= TO_DATE(@[arr_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("               AND ETA_VSK.VPS_ETD_DT <= TO_DATE(@[arr_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("               AND BKG.POR_CD LIKE @[por_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("               AND BKG.DEL_CD LIKE @[del_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${r_term} != '') " ).append("\n"); 
		query.append("               AND BKG.RCV_TERM_CD IN (${r_term})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${d_term} != '') " ).append("\n"); 
		query.append("               AND BKG.DE_TERM_CD IN (${d_term})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--B/L Surrender Date" ).append("\n"); 
		query.append("#if (${bl_srnd_from_dt} != '')" ).append("\n"); 
		query.append("               AND SRD.EVNT_DT >= TO_DATE(@[bl_srnd_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_srnd_to_dt} != '')" ).append("\n"); 
		query.append("               AND SRD.EVNT_DT <= TO_DATE(@[bl_srnd_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Carrier" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("               AND BKG.SCAC_CD      = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sc_rfa_gbn} == 'S') " ).append("\n"); 
		query.append("#if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("               AND BKG.SC_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${sc_rfa_gbn} == 'R') " ).append("\n"); 
		query.append("#if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("               AND BKG.RFA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${sc_rfa_gbn} == 'T') " ).append("\n"); 
		query.append("#if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("               AND BKG.TAA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--B/L Status" ).append("\n"); 
		query.append("#if (${bl_sts_cd} == 'RDY')" ).append("\n"); 
		query.append("               AND ISS.BL_RDY_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${bl_sts_cd} == 'NRD')" ).append("\n"); 
		query.append("               AND ISS.BL_RDY_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${bl_sts_cd} == 'ISS')" ).append("\n"); 
		query.append("               AND ISS.OBL_ISS_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${bl_sts_cd} == 'NIS')" ).append("\n"); 
		query.append("               AND ISS.OBL_ISS_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${bl_sts_cd} == 'RLS')" ).append("\n"); 
		query.append("               AND ISS.OBL_RLSE_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${bl_sts_cd} == 'SRR')" ).append("\n"); 
		query.append("               AND ISS.OBL_SRND_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${bl_sts_cd} == 'RCV')" ).append("\n"); 
		query.append("               AND ISS.OBL_RDEM_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Internet BL" ).append("\n"); 
		query.append("#if (${internet_bl} != '')" ).append("\n"); 
		query.append("               AND ISS.OBL_INET_FLG      = @[internet_bl]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Country of POR" ).append("\n"); 
		query.append("#if (${por_cd2} != '')" ).append("\n"); 
		query.append("               AND SUBSTR(BKG.POR_CD, 1, 2) = @[por_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Country of POD" ).append("\n"); 
		query.append("#if (${pod_cd2} != '')" ).append("\n"); 
		query.append("               AND SUBSTR(BKG.POD_CD, 1, 2) = @[pod_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Last Discharge VVD" ).append("\n"); 
		query.append("#if (${vvd_cd2} != '')" ).append("\n"); 
		query.append("               AND LAST_VVD.VSL_CD = SUBSTR(@[vvd_cd2],1,4)" ).append("\n"); 
		query.append("               AND LAST_VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd2],5,4)" ).append("\n"); 
		query.append("               AND LAST_VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd2],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--B/L Surrender Office" ).append("\n"); 
		query.append("#if (${bl_srnd_ofc_cd} != '')" ).append("\n"); 
		query.append("               AND USR.OFC_CD = @[bl_srnd_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--B/L Issue Office" ).append("\n"); 
		query.append("#if (${cptr_ofc_cd} != '')" ).append("\n"); 
		query.append("			   AND OBL_ISS_OFC_CD = @[cptr_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Customer" ).append("\n"); 
		query.append("#if (${cust_tp_cd_s} != '' || ${cust_tp_cd_c} != '' || ${cust_tp_cd_n} != '' || ${cust_tp_cd_f} != '' || ${cust_tp_cd_a} != '')" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} !='' && ${cust_seq} != '')" ).append("\n"); 
		query.append("               AND ( 1=2" ).append("\n"); 
		query.append("#if (${cust_tp_cd_s} !='')" ).append("\n"); 
		query.append("                    OR (SH.CUST_CNT_CD = @[cust_cnt_cd] AND SH.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd_c} !='')" ).append("\n"); 
		query.append("                    OR (CN.CUST_CNT_CD = @[cust_cnt_cd] AND CN.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("                    OR (NF.CUST_CNT_CD = @[cust_cnt_cd] AND NF.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd_f} !='')" ).append("\n"); 
		query.append("                    OR (FF.CUST_CNT_CD = @[cust_cnt_cd] AND FF.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("                    OR (AN.CUST_CNT_CD = @[cust_cnt_cd] AND AN.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_nm} !='')" ).append("\n"); 
		query.append("               AND ( 1=2" ).append("\n"); 
		query.append("#if (${cust_tp_cd_s} !='')" ).append("\n"); 
		query.append("                    OR SH.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd_c} !='')" ).append("\n"); 
		query.append("                    OR CN.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("                    OR NF.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd_f} !='')" ).append("\n"); 
		query.append("                    OR FF.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("                    OR AN.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ) Z" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("--B/L pring status" ).append("\n"); 
		query.append("#if (${bl_sts_cd} == 'PRT')" ).append("\n"); 
		query.append("   AND OBL_PRN_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${bl_sts_cd} == 'NPT')" ).append("\n"); 
		query.append("   AND OBL_PRN_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--B/L Print Date" ).append("\n"); 
		query.append("#if (${bl_prn_from_dt} != '') " ).append("\n"); 
		query.append("   AND TO_DATE(BL_PRT_DT,'YYYY-MM-DD HH24:MI') >= TO_DATE(@[bl_prn_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_prn_to_dt} != '') " ).append("\n"); 
		query.append("   AND TO_DATE(BL_PRT_DT,'YYYY-MM-DD HH24:MI') <= TO_DATE(@[bl_prn_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Cleared By" ).append("\n"); 
		query.append("#if (${obl_iss_usr_id} != '')" ).append("\n"); 
		query.append("   AND BKG_GET_TOKEN_FNC(CGO_RLSE,2) LIKE @[obl_iss_usr_id]||'%' 	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--B/L Type" ).append("\n"); 
		query.append("#if (${bl_tp_cd} == 'H')" ).append("\n"); 
		query.append("   AND HBL_NO IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${bl_tp_cd} == 'O')" ).append("\n"); 
		query.append("   AND (HBL_NO IS NULL AND BKG_STS_CD <> 'S' AND BL_TP_CD <> 'W')" ).append("\n"); 
		query.append("#elseif (${bl_tp_cd} == 'W')" ).append("\n"); 
		query.append("   AND BL_TP_CD = 'W'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--B/L Rlease Office" ).append("\n"); 
		query.append("#if (${bl_rlse_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND BL_RLSE_OFC = @[bl_rlse_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Cargo Release Status" ).append("\n"); 
		query.append("#if (${cgo_rlse_sts_cd} != '')" ).append("\n"); 
		query.append("   AND SUBSTR(BKG_GET_TOKEN_FNC(CGO_RLSE,1),1,1) = @[cgo_rlse_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${orderby} == '') " ).append("\n"); 
		query.append("ORDER BY TEMP, BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY TEMP, ${orderby}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}