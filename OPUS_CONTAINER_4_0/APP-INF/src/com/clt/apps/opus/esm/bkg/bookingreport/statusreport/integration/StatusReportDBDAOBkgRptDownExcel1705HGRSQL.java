/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOBkgRptDownExcel1705HGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.10 
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

public class StatusReportDBDAOBkgRptDownExcel1705HGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRptDownExcel1705HG
	  * 2015.05.30 decide to delete HG type.
	  * </pre>
	  */
	public StatusReportDBDAOBkgRptDownExcel1705HGRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("del_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_tp_cd_a",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_tp_cd_c",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_tp_cd_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("b_staff_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOBkgRptDownExcel1705HGRSQL").append("\n"); 
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
		query.append("#if (${sel_cols} != '') " ).append("\n"); 
		query.append("SELECT ${sel_cols}" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         '1' AS TEMP" ).append("\n"); 
		query.append("        ,'GOH Info' AS 	MER_HNGR_QTY" ).append("\n"); 
		query.append("        ,'GOH Info' AS 	CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append("        ,'GOH Info' AS 	CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append("        ,'GOH Info' AS 	CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	BL_NO" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	BL_RLSE_OFC" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	BKG_CRE_DT" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	BKG_STAFF" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	BKG_NO" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	BKG_OFC_CD" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	INTER_RMK" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	DG_CERTI" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	XPT_DECL_RCV" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	SLS_AREA" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	OB_SLS_OFC_CD" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	OB_SREP_CD" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	CTRL_PTY" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	SI_FLG" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	SPCL_HND_RMK" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS 	STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	BKG_STS" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	CGO_N" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	CMDT_DESC" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	IB_HLG" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	OB_HLG" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	MARK_NOS" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	PCK_DESC" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	FRT_TERM_CD" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	XTER_RMK" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	SEGR_GRP" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	STWG_RQST_DTL" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	STWG_RQST_TYPE" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS 	VENUS_STS" ).append("\n"); 
		query.append("        ,'Container' AS 	ACT_PKUP_DT" ).append("\n"); 
		query.append("        ,'Container' AS 	ACT_RTN_DT" ).append("\n"); 
		query.append("        ,'Container' AS 	CGO_WGT" ).append("\n"); 
		query.append("        ,'Container' AS 	CGO_WGT_UT_CD" ).append("\n"); 
		query.append("        ,'Container' AS 	MEAS_QTY" ).append("\n"); 
		query.append("        ,'Container' AS 	MEAS_UT_CD" ).append("\n"); 
		query.append("        ,'Container' AS 	CNTR_NO" ).append("\n"); 
		query.append("        ,'Container' AS 	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,'Container' AS 	CNMV_STS_CD" ).append("\n"); 
		query.append("        ,'Container' AS 	MTY_PKUP_LOC" ).append("\n"); 
		query.append("        ,'Container' AS 	MTY_RTN_LOC" ).append("\n"); 
		query.append("        ,'Container' AS 	ESTM_PKUP_DT" ).append("\n"); 
		query.append("        ,'Container' AS 	ESTM_RTN_DT" ).append("\n"); 
		query.append("        ,'Container' AS 	FULL_RTN_YD_CD" ).append("\n"); 
		query.append("        ,'Container' AS 	SEAL_NO" ).append("\n"); 
		query.append("        ,'Container' AS 	SOC_FLG" ).append("\n"); 
		query.append("        ,'Container' AS 	SUBST_TYPE" ).append("\n"); 
		query.append("        ,'Customer' AS 	CNEE_ADDR" ).append("\n"); 
		query.append("        ,'Customer' AS 	NTFY_ADDR" ).append("\n"); 
		query.append("        ,'Customer' AS 	SHPR_ADDR" ).append("\n"); 
		query.append("        ,'Customer' AS 	CNEE_NM" ).append("\n"); 
		query.append("        ,'Customer' AS 	FFWD_CNTC_NO" ).append("\n"); 
		query.append("        ,'Customer' AS 	FFWD_CNTC_NM" ).append("\n"); 
		query.append("        ,'Customer' AS 	NTFY_PARTY" ).append("\n"); 
		query.append("        ,'Customer' AS 	POR_EMER_CNTC_NM" ).append("\n"); 
		query.append("        ,'Customer' AS 	POR_EMER_CNTC_NO" ).append("\n"); 
		query.append("        ,'Customer' AS 	SHPR_CNTC_NM" ).append("\n"); 
		query.append("        ,'Customer' AS 	SHPR_CNTC_NO" ).append("\n"); 
		query.append("        ,'Customer' AS 	SHPR_NM" ).append("\n"); 
		query.append("        ,'Rate & Invoice' AS 	SC_RFA_NO" ).append("\n"); 
		query.append("        ,'Rate & Invoice' AS 	PROP_NO" ).append("\n"); 
		query.append("        ,'Rate & Invoice' AS 	TAA_NO" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	N1_V_DIR" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	N1_V_SVC" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	N1_V_VVD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	N1_V_VSL_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	N1_V_VSL_NM" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	N1_V_VOY_NO" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	N2_V_VVD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	N3_V_VVD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	N4_V_VVD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	POD_ETB" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	POL_ETB" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	POD_NOD_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	POL_NOD_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	BLCK_STWG_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	BOUND" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	N1_POL_CNT_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	FM_CTY_CNT_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	LST_POD_CNT_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	TO_CTY_CNT_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	ETA" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	ETD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	FNL_DEST_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	FIRST_POL" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	POL_CUTOFF_DT" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	POR_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	LAST_POD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	TRUNK_VVD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	DEL_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	POD_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	POL_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	VPS_ETD_DT" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	SERVICE" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	TO_CITY" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	TRD_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	TRF_MODE" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	TRSP_MOD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	TS_PORT_1" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	TS_PORT_2" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS 	TS_PORT_3" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         '2' AS TEMP" ).append("\n"); 
		query.append("        ,'Hanger Installation Order - M HGR' AS 	MER_HNGR_QTY" ).append("\n"); 
		query.append("        ,'Hanger Installation Order - Double' AS 	CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append("        ,'Hanger Installation Order - Single' AS 	CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append("        ,'Hanger Installation Order - Triple' AS 	CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append("        ,'B/L No.' AS 	BL_NO" ).append("\n"); 
		query.append("        ,'B/L Release OFC' AS 	BL_RLSE_OFC" ).append("\n"); 
		query.append("        ,'BKG Creation Date' AS 	BKG_CRE_DT" ).append("\n"); 
		query.append("        ,'BKG Creator' AS 	BKG_STAFF" ).append("\n"); 
		query.append("        ,'BKG No.' AS 	BKG_NO" ).append("\n"); 
		query.append("        ,'BKG OFC' AS 	BKG_OFC_CD" ).append("\n"); 
		query.append("        ,'BKG Remarks' AS 	INTER_RMK" ).append("\n"); 
		query.append("        ,'DG Certificate Rsvd.' AS 	DG_CERTI" ).append("\n"); 
		query.append("        ,'Export Declaration Rcvd.' AS 	XPT_DECL_RCV" ).append("\n"); 
		query.append("        ,'Stop Off Location' AS 	STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("        ,'Sales Area' AS 	SLS_AREA" ).append("\n"); 
		query.append("        ,'Sales OFC' AS 	OB_SLS_OFC_CD" ).append("\n"); 
		query.append("        ,'Sales Representative' AS 	OB_SREP_CD" ).append("\n"); 
		query.append("        ,'Shipment Control Party' AS 	CTRL_PTY" ).append("\n"); 
		query.append("        ,'SI & B/L Master Rcvd' AS 	SI_FLG" ).append("\n"); 
		query.append("        ,'Special Handling Instructions' AS 	SPCL_HND_RMK" ).append("\n"); 
		query.append("        ,'Stop Off Cargo Order Remarks' AS 	STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append("        ,'BKG Status' AS 	BKG_STS" ).append("\n"); 
		query.append("        ,'Cargo Nature' AS 	CGO_N" ).append("\n"); 
		query.append("        ,'CMDT Name' AS 	CMDT_DESC" ).append("\n"); 
		query.append("        ,'IB Haulage Type' AS 	IB_HLG" ).append("\n"); 
		query.append("        ,'OB Haulage Type' AS 	OB_HLG" ).append("\n"); 
		query.append("        ,'Marks and No.s' AS 	MARK_NOS" ).append("\n"); 
		query.append("        ,'No. and Type of PKGs' AS 	PCK_DESC" ).append("\n"); 
		query.append("        ,'Payment Term' AS 	FRT_TERM_CD" ).append("\n"); 
		query.append("        ,'Remarks' AS 	XTER_RMK" ).append("\n"); 
		query.append("        ,'Segregation Group' AS 	SEGR_GRP" ).append("\n"); 
		query.append("        ,'Stowage Special Request Detail' AS 	STWG_RQST_DTL" ).append("\n"); 
		query.append("        ,'Stowage Special Request Type' AS 	STWG_RQST_TYPE" ).append("\n"); 
		query.append("        ,'Venus Status (DG)' AS 	VENUS_STS" ).append("\n"); 
		query.append("        ,'Actual Pick Up Date/Time' AS 	ACT_PKUP_DT" ).append("\n"); 
		query.append("        ,'Actual Return Date/Time' AS 	ACT_RTN_DT" ).append("\n"); 
		query.append("        ,'Cargo WGT' AS 	CGO_WGT" ).append("\n"); 
		query.append("        ,'Cargo WGT Unit' AS 	CGO_WGT_UT_CD" ).append("\n"); 
		query.append("        ,'GRS MEA' AS 	MEAS_QTY" ).append("\n"); 
		query.append("        ,'GRS MEA Unit' AS 	MEAS_UT_CD" ).append("\n"); 
		query.append("        ,'CNTR No.' AS 	CNTR_NO" ).append("\n"); 
		query.append("        ,'CNTR Size Type' AS 	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,'CNTR Status' AS 	CNMV_STS_CD" ).append("\n"); 
		query.append("        ,'Empty Pickup location' AS 	MTY_PKUP_LOC" ).append("\n"); 
		query.append("        ,'Empty Return Location' AS 	MTY_RTN_LOC" ).append("\n"); 
		query.append("        ,'Estd Pick Up Date/Time' AS 	ESTM_PKUP_DT" ).append("\n"); 
		query.append("        ,'Estd Return Date/Time' AS 	ESTM_RTN_DT" ).append("\n"); 
		query.append("        ,'Full Return Location' AS 	FULL_RTN_YD_CD" ).append("\n"); 
		query.append("        ,'Seal No.' AS 	SEAL_NO" ).append("\n"); 
		query.append("        ,'SOC' AS 	SOC_FLG" ).append("\n"); 
		query.append("        ,'Substitution Type' AS 	SUBST_TYPE" ).append("\n"); 
		query.append("        ,'Address of CNEE' AS 	CNEE_ADDR" ).append("\n"); 
		query.append("        ,'Address of NTFY' AS 	NTFY_ADDR" ).append("\n"); 
		query.append("        ,'Address of SHPR' AS 	SHPR_ADDR" ).append("\n"); 
		query.append("        ,'CNEE Name' AS 	CNEE_NM" ).append("\n"); 
		query.append("        ,'FWDR Contact No.' AS 	FFWD_CNTC_NO" ).append("\n"); 
		query.append("        ,'FWDR Emergency Contact Name' AS 	FFWD_CNTC_NM" ).append("\n"); 
		query.append("        ,'NTFY Party' AS 	NTFY_PARTY" ).append("\n"); 
		query.append("        ,'POR Emergency Contact Name' AS 	POR_EMER_CNTC_NM" ).append("\n"); 
		query.append("        ,'POR Emergency Contact No.' AS 	POR_EMER_CNTC_NO" ).append("\n"); 
		query.append("        ,'SHPR Contact Name' AS 	SHPR_CNTC_NM" ).append("\n"); 
		query.append("        ,'SHPR Contact No.' AS 	SHPR_CNTC_NO" ).append("\n"); 
		query.append("        ,'SHPR Name' AS 	SHPR_NM" ).append("\n"); 
		query.append("        ,'SC/Rate Agreement No' AS 	SC_RFA_NO" ).append("\n"); 
		query.append("        ,'Service Agreement no' AS 	PROP_NO" ).append("\n"); 
		query.append("        ,'Tariff No' AS 	TAA_NO" ).append("\n"); 
		query.append("        ,'1st Direction' AS 	N1_V_DIR" ).append("\n"); 
		query.append("        ,'1st Service' AS 	N1_V_SVC" ).append("\n"); 
		query.append("        ,'1st SVVD' AS 	N1_V_VVD" ).append("\n"); 
		query.append("        ,'1st Vessel Code' AS 	N1_V_VSL_CD" ).append("\n"); 
		query.append("        ,'1st Vessel Name' AS 	N1_V_VSL_NM" ).append("\n"); 
		query.append("        ,'1st Voyage' AS 	N1_V_VOY_NO" ).append("\n"); 
		query.append("        ,'2nd  SVVD ' AS 	N2_V_VVD" ).append("\n"); 
		query.append("        ,'3rd SVVD' AS 	N3_V_VVD" ).append("\n"); 
		query.append("        ,'4th SVVD' AS 	N4_V_VVD" ).append("\n"); 
		query.append("        ,'Berth at First Port of Load Date' AS 	POD_ETB" ).append("\n"); 
		query.append("        ,'Berth at Last Port of Discharge Date' AS 	POL_ETB" ).append("\n"); 
		query.append("        ,'Berth at POD' AS 	POD_NOD_CD" ).append("\n"); 
		query.append("        ,'Berth at POL' AS 	POL_NOD_CD" ).append("\n"); 
		query.append("        ,'Block Stowage' AS 	BLCK_STWG_CD" ).append("\n"); 
		query.append("        ,'Bound' AS 	BOUND" ).append("\n"); 
		query.append("        ,'Country of First Load Port' AS 	N1_POL_CNT_CD" ).append("\n"); 
		query.append("        ,'Country of From City' AS 	FM_CTY_CNT_CD" ).append("\n"); 
		query.append("        ,'Country of Last Discharge Port' AS 	LST_POD_CNT_CD" ).append("\n"); 
		query.append("        ,'Country of To City' AS 	TO_CTY_CNT_CD" ).append("\n"); 
		query.append("        ,'Estimated Date of Arrival (ETA)' AS 	ETA" ).append("\n"); 
		query.append("        ,'Estimated Date of Departure (ETD)' AS 	ETD" ).append("\n"); 
		query.append("        ,'Final Destination' AS 	FNL_DEST_CD" ).append("\n"); 
		query.append("        ,'First Load Port' AS 	FIRST_POL" ).append("\n"); 
		query.append("        ,'First Load Port Cut-Off Date' AS 	POL_CUTOFF_DT" ).append("\n"); 
		query.append("        ,'From City' AS 	POR_CD" ).append("\n"); 
		query.append("        ,'Last Discharge Port' AS 	LAST_POD" ).append("\n"); 
		query.append("        ,'Mother SVVD' AS 	TRUNK_VVD" ).append("\n"); 
		query.append("        ,'Place of Delivery' AS 	DEL_CD" ).append("\n"); 
		query.append("        ,'Port of Discharge' AS 	POD_CD" ).append("\n"); 
		query.append("        ,'Port of Load' AS 	POL_CD" ).append("\n"); 
		query.append("        ,'Sailing Date at First POL' AS 	VPS_ETD_DT" ).append("\n"); 
		query.append("        ,'Service' AS 	SERVICE" ).append("\n"); 
		query.append("        ,'To City' AS 	TO_CITY" ).append("\n"); 
		query.append("        ,'Trade ' AS 	TRD_CD" ).append("\n"); 
		query.append("        ,'Traffic Mode' AS 	TRF_MODE" ).append("\n"); 
		query.append("        ,'Transport Mode' AS 	TRSP_MOD" ).append("\n"); 
		query.append("        ,'T/S Port 1' AS 	TS_PORT_1" ).append("\n"); 
		query.append("        ,'T/S Port 2' AS 	TS_PORT_2" ).append("\n"); 
		query.append("        ,'T/S Port 3' AS 	TS_PORT_3" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT '3' AS TEMP" ).append("\n"); 
		query.append("    -- GOH CARGO DETAILS" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , TO_CHAR(QTY.MER_HNGR_QTY) MER_HNGR_QTY" ).append("\n"); 
		query.append("         , TO_CHAR(QTY.CRR_HNGR_DBL_BAR_QTY) CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append("         , TO_CHAR(QTY.CRR_HNGR_SGL_BAR_QTY) CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append("         , TO_CHAR(QTY.CRR_HNGR_TPL_BAR_QTY) CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append("    -- BKG & B/L Info" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , BK.BL_NO" ).append("\n"); 
		query.append("         , (SELECT USR.OFC_CD FROM BKG_DOC_PROC_SKD PROC, COM_USER USR" ).append("\n"); 
		query.append("             WHERE PROC.BKG_DOC_PROC_TP_CD = 'OBLREL'" ).append("\n"); 
		query.append("               AND PROC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("               AND PROC.DOC_PERF_DELT_FLG ='N'" ).append("\n"); 
		query.append("               AND PROC.EVNT_USR_ID = USR.USR_ID) AS BL_RLSE_OFC" ).append("\n"); 
		query.append("         , TO_CHAR(BK.BKG_CRE_DT, 'YYYY-MM-DD') BKG_CRE_DT" ).append("\n"); 
		query.append("         , BK.DOC_USR_ID BKG_STAFF" ).append("\n"); 
		query.append("         , BK.BKG_NO" ).append("\n"); 
		query.append("         , BK.BKG_OFC_CD" ).append("\n"); 
		query.append("         , REPLACE(BK.INTER_RMK,CHR(10),' ') INTER_RMK" ).append("\n"); 
		query.append("         , CASE WHEN (SELECT COUNT(1) FROM BKG_IMG_STO IMG WHERE IMG.BKG_NO = BK.BKG_NO AND IMG.RIDR_TP_CD = 'D') > 0 THEN 'Y' ELSE 'N' END DG_CERTI" ).append("\n"); 
		query.append("         , DECODE(NVL(MRN.CUST_REF_NO_CTNT,''),'','N','Y') AS XPT_DECL_RCV" ).append("\n"); 
		query.append("         , BK.STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("         , (SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = BK.BKG_OFC_CD) AS SLS_AREA" ).append("\n"); 
		query.append("         , BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("         , BK.OB_SREP_CD" ).append("\n"); 
		query.append("         , '' CTRL_PTY" ).append("\n"); 
		query.append("         , BK.SI_FLG" ).append("\n"); 
		query.append("         , BK.STWG_CD SPCL_HND_RMK" ).append("\n"); 
		query.append("         , REPLACE(BK.STOP_OFF_DIFF_RMK,CHR(10),' ') STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append("    -- Cargo & Commodity" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("              FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("             WHERE INTG_CD_ID = 'CD00769'" ).append("\n"); 
		query.append("               AND INTG_CD_VAL_CTNT = BK.BKG_STS_CD) BKG_STS" ).append("\n"); 
		query.append("         , NVL(SUBSTR(DECODE(BK.DCGO_FLG,'Y',',DG','')||DECODE(BK.RC_FLG,'Y',',RF','')||DECODE(BK.AWK_CGO_FLG,'Y',',AW','')||DECODE(BK.BB_CGO_FLG,'Y',',BB','')||DECODE(BK.RD_CGO_FLG,'Y',',RD',''),2),'DR') AS CGO_N" ).append("\n"); 
		query.append("         , (SELECT CMDT_NM FROM MDM_COMMODITY CMDT WHERE CMDT.CMDT_CD = BK.CMDT_CD) CMDT_DESC" ).append("\n"); 
		query.append("         , NVL((SELECT DECODE(TRO.HLG_TP_CD, 'C', 'C', 'M')" ).append("\n"); 
		query.append("                  FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("                 WHERE TRO.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                   AND TRO.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                   AND TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                   AND TRO.CXL_FLG = 'N'), DECODE(BK.DE_TERM_CD, 'D', 'C', 'M')) AS IB_HLG" ).append("\n"); 
		query.append("         , DECODE(BK.RCV_TERM_CD, 'D', 'C', 'M') AS OB_HLG" ).append("\n"); 
		query.append("         , (SELECT REPLACE(TO_CHAR(MK.MK_DESC),CHR(10),' ')" ).append("\n"); 
		query.append("              FROM BKG_BL_MK_DESC MK" ).append("\n"); 
		query.append("             WHERE BK.BKG_NO = MK.BKG_NO" ).append("\n"); 
		query.append("               AND MK.MK_SEQ = 1) MARK_NOS" ).append("\n"); 
		query.append("         , BL.PCK_QTY||(SELECT PCK_NM FROM MDM_PCK_TP PCK WHERE BL.PCK_TP_CD = PCK.PCK_CD) PCK_DESC" ).append("\n"); 
		query.append("         , RATE.FRT_TERM_CD" ).append("\n"); 
		query.append("         , REPLACE(BK.XTER_RMK,CHR(10),' ') XTER_RMK" ).append("\n"); 
		query.append("         , (SELECT SEGR.IMDG_SEGR_GRP_NO || '-' || SEGR.IMDG_SEGR_GRP_NM " ).append("\n"); 
		query.append("              FROM BKG_DG_CGO DG, SCG_IMDG_SEGR_GRP SEGR, SCG_IMDG_UN_NO_SEGR_GRP UN_GRP" ).append("\n"); 
		query.append("             WHERE BK.BKG_NO         = DG.BKG_NO" ).append("\n"); 
		query.append("               AND DG.IMDG_UN_NO     = UN_GRP.IMDG_UN_NO" ).append("\n"); 
		query.append("               AND DG.IMDG_UN_NO_SEQ = UN_GRP.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("               AND SEGR.IMDG_SEGR_GRP_NO = UN_GRP.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("               AND ROWNUM = 1) SEGR_GRP" ).append("\n"); 
		query.append("         , REPLACE(BK.STWG_RMK,CHR(10),' ') STWG_RQST_DTL" ).append("\n"); 
		query.append("         , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("              FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("             WHERE INTG_CD_ID = 'CD02094'" ).append("\n"); 
		query.append("               AND INTG_CD_VAL_CTNT = BK.STWG_CD) STWG_RQST_TYPE" ).append("\n"); 
		query.append("         , CASE WHEN (SELECT COUNT(1) FROM BKG_DG_CGO DG WHERE DG.BKG_NO = BK.BKG_NO) = 0 THEN ''" ).append("\n"); 
		query.append("                WHEN (SELECT COUNT(1) FROM BKG_DG_CGO DG WHERE DG.BKG_NO = BK.BKG_NO AND SPCL_CGO_APRO_CD = 'P') > 0 THEN 'P'" ).append("\n"); 
		query.append("                WHEN (SELECT COUNT(1) FROM BKG_DG_CGO DG WHERE DG.BKG_NO = BK.BKG_NO AND SPCL_CGO_APRO_CD = 'N') > 0 THEN 'N'" ).append("\n"); 
		query.append("                WHEN (SELECT COUNT(1) FROM BKG_DG_CGO DG WHERE DG.BKG_NO = BK.BKG_NO AND SPCL_CGO_APRO_CD <> 'C')" ).append("\n"); 
		query.append("                    = (SELECT COUNT(1) FROM BKG_DG_CGO DG WHERE DG.BKG_NO = BK.BKG_NO AND SPCL_CGO_APRO_CD = 'Y') THEN 'Y' " ).append("\n"); 
		query.append("           END VENUS_STS" ).append("\n"); 
		query.append("    -- Container" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , (SELECT TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              FROM CTM_MOVEMENT CTM " ).append("\n"); 
		query.append("             WHERE CTM.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("               AND CTM.CNMV_YR = CNTR.CNMV_YR" ).append("\n"); 
		query.append("               AND CTM.CNMV_ID_NO = CNTR.CNMV_ID_NO" ).append("\n"); 
		query.append("               AND CTM.MVMT_STS_CD = 'OP') ACT_PKUP_DT" ).append("\n"); 
		query.append("         , (SELECT TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              FROM CTM_MOVEMENT CTM " ).append("\n"); 
		query.append("             WHERE CTM.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("               AND CTM.CNMV_YR = CNTR.CNMV_YR" ).append("\n"); 
		query.append("               AND CTM.CNMV_ID_NO = CNTR.CNMV_ID_NO" ).append("\n"); 
		query.append("               AND CTM.MVMT_STS_CD = 'OC') ACT_RTN_DT" ).append("\n"); 
		query.append("         , TO_CHAR(CNTR.CNTR_WGT) CGO_WGT" ).append("\n"); 
		query.append("         , CNTR.WGT_UT_CD CGO_WGT_UT_CD" ).append("\n"); 
		query.append("         , TO_CHAR(CNTR.MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append("         , CNTR.MEAS_UT_CD" ).append("\n"); 
		query.append("         , CNTR.CNTR_NO" ).append("\n"); 
		query.append("         , CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , CNTR.CNMV_STS_CD" ).append("\n"); 
		query.append("         , (SELECT SUBSTR(PRD.MTY_PKUP_YD_CD, 1, 5) FROM PRD_PROD_CTL_MST PRD WHERE PRD.PCTL_NO = BK.PCTL_NO) MTY_PKUP_LOC" ).append("\n"); 
		query.append("         , (SELECT SUBSTR(PRD.MTY_RTN_YD_CD,  1, 5) FROM PRD_PROD_CTL_MST PRD WHERE PRD.PCTL_NO = BK.PCTL_NO) MTY_RTN_LOC" ).append("\n"); 
		query.append("         , (SELECT TO_CHAR(ARR_ST_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_PROD_CTL_MST MST" ).append("\n"); 
		query.append("             WHERE BK.PCTL_NO = MST.PCTL_NO" ).append("\n"); 
		query.append("               AND BK.PCTL_NO = DTL.PCTL_NO" ).append("\n"); 
		query.append("               AND MST.MTY_PKUP_YD_CD = DTL.ORG_NOD_CD" ).append("\n"); 
		query.append("               AND DTL.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("               AND DTL.MTY_YD_FLG = 'Y') ESTM_PKUP_DT" ).append("\n"); 
		query.append("         , (SELECT TO_CHAR(ARR_ST_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_PROD_CTL_MST MST" ).append("\n"); 
		query.append("             WHERE BK.PCTL_NO = MST.PCTL_NO" ).append("\n"); 
		query.append("               AND BK.PCTL_NO = DTL.PCTL_NO" ).append("\n"); 
		query.append("               AND MST.MTY_RTN_YD_CD = DTL.ORG_NOD_CD" ).append("\n"); 
		query.append("               AND DTL.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("               AND DTL.MTY_YD_FLG = 'Y') ESTM_RTN_DT" ).append("\n"); 
		query.append("         , (SELECT SUBSTR(PRD.FULL_RTN_YD_CD, 1, 5) FROM PRD_PROD_CTL_MST PRD WHERE PRD.PCTL_NO = BK.PCTL_NO) FULL_RTN_YD_CD" ).append("\n"); 
		query.append("         , (SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO SEAL WHERE CNTR.CNTR_NO = SEAL.CNTR_NO AND ROWNUM = 1) SEAL_NO" ).append("\n"); 
		query.append("         , CNTR.SOC_FLG" ).append("\n"); 
		query.append("         , DECODE(CNTR.EQ_SUBST_FLG, 'Y', CNTR.EQ_SUBST_TPSZ_CD, '') SUBST_TYPE" ).append("\n"); 
		query.append("    -- Customer" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , (SELECT REPLACE(CUST_ADDR,CHR(10),' ') FROM BKG_CUSTOMER C WHERE C.BKG_NO = BK.BKG_NO AND C.BKG_CUST_TP_CD = 'C') CNEE_ADDR" ).append("\n"); 
		query.append("         , (SELECT REPLACE(CUST_ADDR,CHR(10),' ') FROM BKG_CUSTOMER N WHERE N.BKG_NO = BK.BKG_NO AND N.BKG_CUST_TP_CD = 'N') NTFY_ADDR" ).append("\n"); 
		query.append("         , (SELECT REPLACE(CUST_ADDR,CHR(10),' ') FROM BKG_CUSTOMER S WHERE S.BKG_NO = BK.BKG_NO AND S.BKG_CUST_TP_CD = 'S') SHPR_ADDR" ).append("\n"); 
		query.append("         , (SELECT REPLACE(CUST_NM,CHR(10),' ')   FROM BKG_CUSTOMER C WHERE C.BKG_NO = BK.BKG_NO AND C.BKG_CUST_TP_CD = 'C') CNEE_NM" ).append("\n"); 
		query.append("         , (SELECT PHN_NO    FROM MDM_CUST_CNTC_PNT CNTC, BKG_CUSTOMER F WHERE BK.BKG_NO = F.BKG_NO AND F.BKG_CUST_TP_CD = 'F' AND CNTC.CUST_CNT_CD = F.CUST_CNT_CD AND CNTC.CUST_SEQ = F.CUST_SEQ AND ROWNUM = 1) AS FFWD_CNTC_NO" ).append("\n"); 
		query.append("         , (SELECT CNTC_PSON_NM FROM MDM_CUST_ADDR     ADDR, BKG_CUSTOMER F WHERE BK.BKG_NO = F.BKG_NO AND F.BKG_CUST_TP_CD = 'F' AND ADDR.CUST_CNT_CD = F.CUST_CNT_CD AND ADDR.CUST_SEQ = F.CUST_SEQ AND PRMRY_CHK_FLG = 'Y' AND ROWNUM = 1) AS FFWD_CNTC_NM" ).append("\n"); 
		query.append("         , (SELECT REPLACE(CUST_NM,CHR(10),' ')   FROM BKG_CUSTOMER C WHERE C.BKG_NO = BK.BKG_NO AND C.BKG_CUST_TP_CD = 'N') NTFY_PARTY" ).append("\n"); 
		query.append("         , (SELECT SREP_NM FROM MDM_SLS_REP M WHERE M.SREP_CD = BK.OB_SREP_CD) POR_EMER_CNTC_NM" ).append("\n"); 
		query.append("         , (SELECT MPHN_NO FROM MDM_SLS_REP M WHERE M.SREP_CD = BK.OB_SREP_CD) POR_EMER_CNTC_NO" ).append("\n"); 
		query.append("         , (SELECT CNTC_PSON_NM FROM MDM_CUST_ADDR     ADDR, BKG_CUSTOMER S WHERE BK.BKG_NO = S.BKG_NO AND S.BKG_CUST_TP_CD = 'S' AND ADDR.CUST_CNT_CD = S.CUST_CNT_CD AND ADDR.CUST_SEQ = S.CUST_SEQ AND PRMRY_CHK_FLG = 'Y' AND ROWNUM = 1) AS SHPR_CNTC_NM" ).append("\n"); 
		query.append("         , (SELECT PHN_NO       FROM MDM_CUST_CNTC_PNT CNTC, BKG_CUSTOMER S WHERE BK.BKG_NO = S.BKG_NO AND S.BKG_CUST_TP_CD = 'S' AND CNTC.CUST_CNT_CD = S.CUST_CNT_CD AND CNTC.CUST_SEQ = S.CUST_SEQ AND ROWNUM = 1) AS SHPR_CNTC_NO" ).append("\n"); 
		query.append("         , (SELECT REPLACE(CUST_NM,CHR(10),' ')   FROM BKG_CUSTOMER C WHERE C.BKG_NO = BK.BKG_NO AND C.BKG_CUST_TP_CD = 'S') SHPR_NM" ).append("\n"); 
		query.append("    -- Rate & Invoice" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , NVL(BK.SC_NO, BK.RFA_NO) SC_RFA_NO" ).append("\n"); 
		query.append("         , (SELECT PROP_NO FROM BKG_CHG_RT WHERE BKG_NO = BK.BKG_NO AND RT_SEQ = 1) AS PROP_NO" ).append("\n"); 
		query.append("         , BK.TAA_NO" ).append("\n"); 
		query.append("    -- Route & Schedule" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , SUBSTR(ROUTE.VVD_1, 9, 1) N1_V_DIR" ).append("\n"); 
		query.append("         , ROUTE.SLAN_1 N1_V_SVC" ).append("\n"); 
		query.append("         , ROUTE.VVD_1 N1_V_VVD" ).append("\n"); 
		query.append("         , SUBSTR(ROUTE.VVD_1, 1, 4) N1_V_VSL_CD     " ).append("\n"); 
		query.append("         , (SELECT M.VSL_ENG_NM FROM MDM_VSL_CNTR M WHERE M.VSL_CD = SUBSTR(ROUTE.VVD_1, 1, 4)) N1_V_VSL_NM" ).append("\n"); 
		query.append("         , SUBSTR(ROUTE.VVD_1, 5, 4) N1_V_VOY_NO" ).append("\n"); 
		query.append("         , ROUTE.VVD_2 N2_V_VVD" ).append("\n"); 
		query.append("         , ROUTE.VVD_3 N3_V_VVD" ).append("\n"); 
		query.append("         , ROUTE.VVD_4 N4_V_VVD" ).append("\n"); 
		query.append("         , TO_CHAR(LAST_VVD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') POD_ETB" ).append("\n"); 
		query.append("         , TO_CHAR(N1ST_VVD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') POL_ETB " ).append("\n"); 
		query.append("         , BK.POD_NOD_CD" ).append("\n"); 
		query.append("         , BK.POL_NOD_CD" ).append("\n"); 
		query.append("         , BK.BLCK_STWG_CD" ).append("\n"); 
		query.append("         , DECODE(@[io_bnd_cd], 'O', 'Departure', 'Arrival') BOUND" ).append("\n"); 
		query.append("         , SUBSTR(ROUTE.POL_1,    1, 2) N1_POL_CNT_CD" ).append("\n"); 
		query.append("         , SUBSTR(BK.POR_CD,      1, 2) FM_CTY_CNT_CD" ).append("\n"); 
		query.append("         , SUBSTR(ROUTE.LAST_POD, 1, 2) LST_POD_CNT_cD" ).append("\n"); 
		query.append("         , SUBSTR(BK.DEL_CD,      1, 2) TO_CTY_CNT_CD" ).append("\n"); 
		query.append("         , TO_CHAR(LAST_VVD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') ETA" ).append("\n"); 
		query.append("         , TO_CHAR(N1ST_VVD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') ETD" ).append("\n"); 
		query.append("         , BK.FNL_DEST_CD" ).append("\n"); 
		query.append("         , BK.POL_CD FIRST_POL" ).append("\n"); 
		query.append("         , (SELECT TO_CHAR(NVL(MNL_SET_DT,SYS_SET_DT),'YYYY-MM-DD HH24:MI') FROM BKG_CLZ_TM WHERE CLZ_TP_CD = 'T' AND BKG_NO=BK.BKG_NO) AS POL_CUTOFF_DT" ).append("\n"); 
		query.append("         , BK.POR_CD" ).append("\n"); 
		query.append("         , ROUTE.LAST_POD" ).append("\n"); 
		query.append("         , BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD TRUNK_VVD" ).append("\n"); 
		query.append("         , BK.DEL_CD" ).append("\n"); 
		query.append("         , BK.POD_CD" ).append("\n"); 
		query.append("         , BK.POL_CD" ).append("\n"); 
		query.append("         , TO_CHAR(N1ST_VVD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') VPS_ETD_DT" ).append("\n"); 
		query.append("         , (SELECT SVC_SCP_NM FROM MDM_SVC_SCP SCP WHERE SCP.SVC_SCP_CD = BK.SVC_SCP_CD) SERVICE" ).append("\n"); 
		query.append("         , NVL((SELECT SUBSTR(LOC_CD,1,2) FROM BKG_EUR_TRO TRO, BKG_EUR_TRO_DTL DTL " ).append("\n"); 
		query.append("                 WHERE TRO.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                   AND TRO.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                   AND TRO.IO_BND_CD = 'I' " ).append("\n"); 
		query.append("                   AND TRO.BKG_NO = DTL.BKG_NO " ).append("\n"); 
		query.append("                   AND TRO.IO_BND_CD = DTL.IO_BND_CD " ).append("\n"); 
		query.append("                   AND TRO.TRO_SEQ = DTL.TRO_SEQ), SUBSTR(BK.DEL_CD,1,2)) AS TO_CITY" ).append("\n"); 
		query.append("         , COA.TRD_CD" ).append("\n"); 
		query.append("         , CASE WHEN BK.RCV_TERM_CD ='S' OR BK.DE_TERM_CD ='S' THEN 'LCL'" ).append("\n"); 
		query.append("                ELSE 'FCL'" ).append("\n"); 
		query.append("            END TRF_MODE" ).append("\n"); 
		query.append("         , DECODE(BK.ORG_TRNS_MOD_CD||BK.DEST_TRNS_MOD_CD, NULL, '' , BK.ORG_TRNS_MOD_CD||'/'||BK.DEST_TRNS_MOD_CD ) AS TRSP_MOD" ).append("\n"); 
		query.append("         , DECODE(ROUTE.POD_2, '', ROUTE.POD_1, '') TS_PORT_1" ).append("\n"); 
		query.append("         , DECODE(ROUTE.POD_3, '', ROUTE.POD_2, '') TS_PORT_2" ).append("\n"); 
		query.append("         , DECODE(ROUTE.POD_4, '', ROUTE.POD_3, '') TS_PORT_3" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("         , BKG_VVD VVD" ).append("\n"); 
		query.append("         , BKG_BL_DOC BL" ).append("\n"); 
		query.append("         , BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("         , BKG_RATE RATE" ).append("\n"); 
		query.append("         , BKG_BL_ISS ISS" ).append("\n"); 
		query.append("         , BKG_REFERENCE MRN" ).append("\n"); 
		query.append("         , COA_RGST_BKG COA" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         , (SELECT BKG_NO" ).append("\n"); 
		query.append("                  ,VVD_1" ).append("\n"); 
		query.append("                  ,VVD_2" ).append("\n"); 
		query.append("                  ,VVD_3" ).append("\n"); 
		query.append("                  ,VVD_4" ).append("\n"); 
		query.append("                  ,SLAN_1" ).append("\n"); 
		query.append("                  ,SLAN_2" ).append("\n"); 
		query.append("                  ,SLAN_3" ).append("\n"); 
		query.append("                  ,SLAN_4" ).append("\n"); 
		query.append("                  ,POL_1" ).append("\n"); 
		query.append("                  ,POL_2" ).append("\n"); 
		query.append("                  ,POL_3" ).append("\n"); 
		query.append("                  ,POL_4" ).append("\n"); 
		query.append("                  ,POL_YD_1" ).append("\n"); 
		query.append("                  ,POL_YD_2" ).append("\n"); 
		query.append("                  ,POL_YD_3" ).append("\n"); 
		query.append("                  ,POL_YD_4" ).append("\n"); 
		query.append("                  ,DECODE(POD_4, '', DECODE(POD_3, '', DECODE(POD_2, '', VVD_1, VVD_2), VVD_3), VVD_4) AS LAST_VVD" ).append("\n"); 
		query.append("                  ,COALESCE(POD_4, POD_3, POD_2, POD_1) AS LAST_POD" ).append("\n"); 
		query.append("                  ,COALESCE(POD_1, POD_2, POD_3, POD_4) AS FIRST_POD" ).append("\n"); 
		query.append("                  ,POD_1" ).append("\n"); 
		query.append("                  ,POD_2" ).append("\n"); 
		query.append("                  ,POD_3" ).append("\n"); 
		query.append("                  ,POD_4" ).append("\n"); 
		query.append("                  ,POD_YD_1" ).append("\n"); 
		query.append("                  ,POD_YD_2" ).append("\n"); 
		query.append("                  ,POD_YD_3" ).append("\n"); 
		query.append("                  ,POD_YD_4" ).append("\n"); 
		query.append("                  ,POL_CLPT_IND_SEQ_1" ).append("\n"); 
		query.append("                  ,DECODE(POD_4, '', DECODE(POD_3, '', DECODE(POD_2, '', POD_CLPT_IND_SEQ_1, POD_CLPT_IND_SEQ_2), POD_CLPT_IND_SEQ_3), POD_CLPT_IND_SEQ_4) AS LAST_POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    SELECT LEAD(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS VVD_1" ).append("\n"); 
		query.append("                          ,LEAD(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS VVD_2" ).append("\n"); 
		query.append("                          ,LEAD(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, 2) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS VVD_3" ).append("\n"); 
		query.append("                          ,LEAD(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, 3) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS VVD_4" ).append("\n"); 
		query.append("                          ,LEAD(SLAN_CD, 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS SLAN_1" ).append("\n"); 
		query.append("                          ,LEAD(SLAN_CD, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS SLAN_2" ).append("\n"); 
		query.append("                          ,LEAD(SLAN_CD, 2) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS SLAN_3" ).append("\n"); 
		query.append("                          ,LEAD(SLAN_CD, 3) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS SLAN_4" ).append("\n"); 
		query.append("                          ,LEAD(POL_CD, 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_1" ).append("\n"); 
		query.append("                          ,LEAD(POL_CD, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_2" ).append("\n"); 
		query.append("                          ,LEAD(POL_CD, 2) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_3" ).append("\n"); 
		query.append("                          ,LEAD(POL_CD, 3) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_4" ).append("\n"); 
		query.append("                          ,LEAD(SUBSTR(POL_YD_CD,-2), 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_YD_1" ).append("\n"); 
		query.append("                          ,LEAD(SUBSTR(POL_YD_CD,-2), 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_YD_2" ).append("\n"); 
		query.append("                          ,LEAD(SUBSTR(POL_YD_CD,-2), 2) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_YD_3" ).append("\n"); 
		query.append("                          ,LEAD(SUBSTR(POL_YD_CD,-2), 3) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_YD_4" ).append("\n"); 
		query.append("                          ,LEAD(POD_CD, 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_1" ).append("\n"); 
		query.append("                          ,LEAD(POD_CD, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_2" ).append("\n"); 
		query.append("                          ,LEAD(POD_CD, 2) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_3" ).append("\n"); 
		query.append("                          ,LEAD(POD_CD, 3) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_4" ).append("\n"); 
		query.append("                          ,LEAD(SUBSTR(POD_YD_CD,-2), 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_YD_1" ).append("\n"); 
		query.append("                          ,LEAD(SUBSTR(POD_YD_CD,-2), 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_YD_2" ).append("\n"); 
		query.append("                          ,LEAD(SUBSTR(POD_YD_CD,-2), 2) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_YD_3" ).append("\n"); 
		query.append("                          ,LEAD(SUBSTR(POD_YD_CD,-2), 3) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_YD_4" ).append("\n"); 
		query.append("                          ,LEAD(POL_CLPT_IND_SEQ, 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_CLPT_IND_SEQ_1" ).append("\n"); 
		query.append("                          ,LEAD(POD_CLPT_IND_SEQ, 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_CLPT_IND_SEQ_1" ).append("\n"); 
		query.append("                          ,LEAD(POD_CLPT_IND_SEQ, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_CLPT_IND_SEQ_2" ).append("\n"); 
		query.append("                          ,LEAD(POD_CLPT_IND_SEQ, 2) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_CLPT_IND_SEQ_3" ).append("\n"); 
		query.append("                          ,LEAD(POD_CLPT_IND_SEQ, 3) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_CLPT_IND_SEQ_4" ).append("\n"); 
		query.append("                          ,ROW_NUMBER() OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS RN" ).append("\n"); 
		query.append("                          ,BKG_NO" ).append("\n"); 
		query.append("                      FROM BKG_VVD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("             WHERE RN = 1" ).append("\n"); 
		query.append("           ) ROUTE" ).append("\n"); 
		query.append("         , BKG_QUANTITY QTY" ).append("\n"); 
		query.append("         , VSK_VSL_PORT_SKD N1ST_VVD" ).append("\n"); 
		query.append("         , VSK_VSL_PORT_SKD LAST_VVD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("     WHERE BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("       AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND BK.BKG_NO = ROUTE.BKG_NO" ).append("\n"); 
		query.append("       AND BK.BKG_NO = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("       AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("       AND BK.BKG_NO = COA.BKG_NO(+)" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("       AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND BK.BKG_NO = MRN.BKG_NO(+)" ).append("\n"); 
		query.append("       AND 'XMRN' = MRN.BKG_REF_TP_CD(+)--Export MRN No." ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("       AND SUBSTR(ROUTE.VVD_1,1,4) = N1ST_VVD.VSL_CD(+)" ).append("\n"); 
		query.append("       AND SUBSTR(ROUTE.VVD_1,5,4) = N1ST_VVD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND SUBSTR(ROUTE.VVD_1,9,1) = N1ST_VVD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       AND ROUTE.POL_1 = N1ST_VVD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("       AND ROUTE.POL_CLPT_IND_SEQ_1 = N1ST_VVD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("       AND SUBSTR(ROUTE.LAST_VVD,1,4) = LAST_VVD.VSL_CD(+)" ).append("\n"); 
		query.append("       AND SUBSTR(ROUTE.LAST_VVD,5,4) = LAST_VVD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND SUBSTR(ROUTE.LAST_VVD,9,1) = LAST_VVD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       AND ROUTE.LAST_POD = LAST_VVD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("       AND ROUTE.LAST_POD_CLPT_IND_SEQ = LAST_VVD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("       AND BK.HNGR_FLG = 'Y'" ).append("\n"); 
		query.append("       AND BK.BKG_NO = QTY.BKG_NO" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND QTY.BKG_NO = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("       AND QTY.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("       AND (QTY.CRR_HNGR_DBL_BAR_QTY > 0 OR QTY.CRR_HNGR_SGL_BAR_QTY > 0 OR QTY.CRR_HNGR_TPL_BAR_QTY > 0)" ).append("\n"); 
		query.append("       AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("	--===================================================================== 화면 조건절 start" ).append("\n"); 
		query.append("    #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("       AND @[vvd_cd] IN (ROUTE.VVD_1, ROUTE.VVD_2, ROUTE.VVD_3, ROUTE.VVD_4)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${pol_cd} != '') " ).append("\n"); 
		query.append("	   AND @[pol_cd] IN (ROUTE.POL_1, ROUTE.POL_2, ROUTE.POL_3, ROUTE.POL_4)" ).append("\n"); 
		query.append("	 #if (${local_ts} != '' && ${local_ts} == 'L')" ).append("\n"); 
		query.append("	   AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 #if (${local_ts} != '' && ${local_ts} == 'T')" ).append("\n"); 
		query.append("	   AND BK.POL_CD <> @[pol_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pol_yard_cd} != '') " ).append("\n"); 
		query.append("	   AND @[pol_yard_cd] IN (ROUTE.POL_YD_1, ROUTE.POL_YD_2, ROUTE.POL_YD_3, ROUTE.POL_YD_4)" ).append("\n"); 
		query.append("	 #if (${local_ts} != '' && ${local_ts} == 'L')" ).append("\n"); 
		query.append("	   AND SUBSTR(BK.POL_NOD_CD,-2) = @[pol_yard_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 #if (${local_ts} != '' && ${local_ts} == 'T')" ).append("\n"); 
		query.append("	   AND SUBSTR(BK.POL_NOD_CD,-2) <> @[pol_yard_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pod_cd} != '') " ).append("\n"); 
		query.append("	   AND @[pod_cd] IN (ROUTE.POD_1, ROUTE.POD_2, ROUTE.POD_3, ROUTE.POD_4)" ).append("\n"); 
		query.append("	 #if (${local_ts} != '' && ${local_ts} == 'L')" ).append("\n"); 
		query.append("	   AND BK.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 #if (${local_ts} != '' && ${local_ts} == 'T')" ).append("\n"); 
		query.append("	   AND BK.POD_CD <> @[pod_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pod_yard_cd} != '') " ).append("\n"); 
		query.append("	   AND @[pod_yard_cd] IN (ROUTE.POD_YD_1, ROUTE.POD_YD_2, ROUTE.POD_YD_3, ROUTE.POD_YD_4)" ).append("\n"); 
		query.append("	 #if (${local_ts} != '' && ${local_ts} == 'L')" ).append("\n"); 
		query.append("	   AND SUBSTR(BK.POD_NOD_CD,-2) = @[pod_yard_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 #if (${local_ts} != '' && ${local_ts} == 'T')" ).append("\n"); 
		query.append("	   AND SUBSTR(BK.POD_NOD_CD,-2) <> @[pod_yard_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("    #if (${sail_from_dt} != '') " ).append("\n"); 
		query.append("	   AND N1ST_VVD.VPS_ETD_DT >= TO_DATE(@[sail_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sail_to_dt} != '') " ).append("\n"); 
		query.append("	   AND N1ST_VVD.VPS_ETD_DT <= TO_DATE(@[sail_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${arr_from_dt} != '') " ).append("\n"); 
		query.append("	   AND LAST_VVD.VPS_ETA_DT >= TO_DATE(@[arr_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${arr_to_dt} != '') " ).append("\n"); 
		query.append("	   AND LAST_VVD.VPS_ETA_DT <= TO_DATE(@[arr_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_from_dt} != '') " ).append("\n"); 
		query.append("	   AND BK.BKG_CRE_DT >= TO_DATE(@[bkg_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_to_dt} != '') " ).append("\n"); 
		query.append("	   AND BK.BKG_CRE_DT <= TO_DATE(@[bkg_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${bkg_no} != '') " ).append("\n"); 
		query.append("       AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("       AND BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("       AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${ob_srep_cd} != '') " ).append("\n"); 
		query.append("       AND BK.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${b_staff_id} != '' && ${bkg_staff_type1} != '')" ).append("\n"); 
		query.append("       AND BK.DOC_USR_ID = @[b_staff_id]" ).append("\n"); 
		query.append("    #elseif (${b_staff_id} != '' && ${bkg_staff_type2} != '')" ).append("\n"); 
		query.append("       AND (SELECT USR_NM FROM COM_USER WHERE USR_ID = BK.DOC_USR_ID) = @[b_staff_id]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_STS_CD IN (@[bkg_sts_cd])--?이게 되나?" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("    #if (${por_cd2} != '') " ).append("\n"); 
		query.append("       AND BK.POR_CD LIKE @[por_cd2]||'%' " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd2} != '') " ).append("\n"); 
		query.append("       AND BK.POL_CD LIKE @[pol_cd2]||'%' " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_cd2} != '') " ).append("\n"); 
		query.append("       AND BK.POD_CD LIKE @[pod_cd2]||'%' " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${del_cd} != '') " ).append("\n"); 
		query.append("       AND BK.DEL_CD LIKE @[del_cd2]||'%' " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#if (${r_term} != '') " ).append("\n"); 
		query.append("       AND BK.RCV_TERM_CD IN (${r_term})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${d_term} != '') " ).append("\n"); 
		query.append("       AND BK.DE_TERM_CD IN (${d_term})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    #if (${dir_cd} != '') " ).append("\n"); 
		query.append("       AND BK.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${trd_cd} != '') " ).append("\n"); 
		query.append("       AND COA.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${sub_trd_cd} != '') " ).append("\n"); 
		query.append("       AND COA.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${lane_cd} != '') " ).append("\n"); 
		query.append("       AND @[lane_cd] IN (ROUTE.SLAN_1, ROUTE.SLAN_2, ROUTE.SLAN_3, ROUTE.SLAN_4)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cust_tp_cd_s} != '' || ${cust_tp_cd_c} != '' || ${cust_tp_cd_n} != '' || ${cust_tp_cd_f} != '' || ${cust_tp_cd_a} != '') " ).append("\n"); 
		query.append("       AND EXISTS (SELECT 'Y' FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("                    WHERE C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                    #if (${cust_cnt_cd} !='')                    " ).append("\n"); 
		query.append("                      AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${cust_seq} !='')                    " ).append("\n"); 
		query.append("                      AND C.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                      AND BKG_CUST_TP_CD IN ('',@[cust_tp_cd_s],@[cust_tp_cd_c],@[cust_tp_cd_n],@[cust_tp_cd_f],@[cust_tp_cd_a])" ).append("\n"); 
		query.append("                    #if (${cust_nm} !='')                    " ).append("\n"); 
		query.append("                      AND C.CUST_NM = @[cust_nm]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${cust_grp_id} !='')                    " ).append("\n"); 
		query.append("                      AND (SELECT CUST_GRP_ID FROM MDM_CUSTOMER M WHERE M.CUST_CNT_CD = B.CUST_CNT_CD AND M.CUST_SEQ = B.CUST_SEQ) = @[cust_grp_id]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${sc_rfa_gbn} == 'S') " ).append("\n"); 
		query.append("     #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("               AND BK.SC_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("    #elseif (${sc_rfa_gbn} == 'R') " ).append("\n"); 
		query.append("     #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("               AND BK.RFA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("    #elseif (${sc_rfa_gbn} == 'T') " ).append("\n"); 
		query.append("     #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("               AND BK.TAA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	--===================================================================== 화면 조건절 end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH TEMP = '1'										--20150309.ADD" ).append("\n"); 
		query.append("CONNECT BY LEVEL < 3" ).append("\n"); 
		query.append("#if (${orderby} == '') " ).append("\n"); 
		query.append("ORDER BY TEMP, BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY TEMP, ${orderby}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}