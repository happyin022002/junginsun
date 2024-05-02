/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOBkgRptDownExcel1705AKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.05 
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

public class StatusReportDBDAOBkgRptDownExcel1705AKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRptDownExcel1705AK
	  * </pre>
	  */
	public StatusReportDBDAOBkgRptDownExcel1705AKRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_staff",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_sts_cd_w",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : StatusReportDBDAOBkgRptDownExcel1705AKRSQL").append("\n"); 
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
		query.append("        ,'BKG & B/L Info' AS	BL_NO" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	BL_RLSE_OFC" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	BKG_CRE_DT" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	BKG_STAFF" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	BKG_NO" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	BKG_OFC_CD" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	XTER_RMK" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	VNDR_RMK" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	INTER_RMK" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	DG_CERTI" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	XPT_DECL_RCV" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	SLS_AREA" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	OB_SLS_OFC_CD" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	CTRT_SREP_CD" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	OB_SREP_CD" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	SI_FLG" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	SPCL_HND_RMK" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	SPCL_HNDL_INST_DESC" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	STOP_OFF_CNTC_PHN_NO" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	STOP_OFF_CNTC_PSON_NM" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append("        ,'BKG & B/L Info' AS	MER_HNGR_QTY" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS	BKG_STS_CD" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS	CGO_N" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS	CMDT_CD" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS	CMDT_DESC" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS	OB_HLG" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS	IB_HLG" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS	MARK_NOS" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS	PCK_QTY" ).append("\n"); 
		query.append("        ,'Cargo & Commodity' AS	PCK_DESC" ).append("\n"); 
		query.append("        ,'Container' AS	CNTR_NO" ).append("\n"); 
		query.append("        ,'Container' AS	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,'Container' AS	CNMV_STS_CD" ).append("\n"); 
		query.append("        ,'Container' AS	CGO_WGT" ).append("\n"); 
		query.append("        ,'Container' AS	CGO_WGT_UT_CD" ).append("\n"); 
		query.append("        ,'Container' AS	MEAS_QTY" ).append("\n"); 
		query.append("        ,'Container' AS	MEAS_UT_CD" ).append("\n"); 
		query.append("        ,'Container' AS	CNTR_SEAL_NO" ).append("\n"); 
		query.append("        ,'Container' AS	SOC_FLG" ).append("\n"); 
		query.append("        ,'Container' AS	SUBST_TYPE" ).append("\n"); 
		query.append("        ,'Container' AS	RD_CGO_FLG" ).append("\n"); 
		query.append("        ,'Container' AS	MTY_PKUP_LOC" ).append("\n"); 
		query.append("        ,'Container' AS	MTY_RTN_LOC" ).append("\n"); 
		query.append("        ,'Container' AS	FULL_RTN_LOC" ).append("\n"); 
		query.append("        ,'Container' AS	OP_ESTM_DT" ).append("\n"); 
		query.append("        ,'Container' AS	OC_ESTM_DT" ).append("\n"); 
		query.append("        ,'Container' AS	OP_ACT_DT" ).append("\n"); 
		query.append("        ,'Container' AS	OC_ACT_DT" ).append("\n"); 
		query.append("        ,'Customer' AS	SHPR_NM" ).append("\n"); 
		query.append("        ,'Customer' AS	SHPR_CNTC_NM" ).append("\n"); 
		query.append("        ,'Customer' AS	SHPR_CNTC_NO" ).append("\n"); 
		query.append("        ,'Customer' AS	SHPR_ADDR" ).append("\n"); 
		query.append("        ,'Customer' AS	CNEE_NM" ).append("\n"); 
		query.append("        ,'Customer' AS	CNEE_ADDR" ).append("\n"); 
		query.append("        ,'Customer' AS	FFWD_NM" ).append("\n"); 
		query.append("        ,'Customer' AS	FFWD_CNTC_NM" ).append("\n"); 
		query.append("        ,'Customer' AS	FFWD_CNTC_NO" ).append("\n"); 
		query.append("        ,'Customer' AS	NTFY_PARTY" ).append("\n"); 
		query.append("        ,'Customer' AS	NTFY_ADDR" ).append("\n"); 
		query.append("        ,'Customer' AS	CTRT_PTY_CD" ).append("\n"); 
		query.append("        ,'Customer' AS	CTRT_PTY_NM" ).append("\n"); 
		query.append("        ,'Rate & Invoice' AS	FRT_TERM_CD" ).append("\n"); 
		query.append("        ,'Rate & Invoice' AS	SC_NO" ).append("\n"); 
		query.append("        ,'Rate & Invoice' AS	RFA_NO" ).append("\n"); 
		query.append("        ,'Rate & Invoice' AS	TAA_NO" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	BOUND" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	SVC_SCP_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	TRD_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	TRAF_MOD_IB" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	TRAF_MOD_OB" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	TRSP_MOD_IB" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	TRSP_MOD_OB" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	BLCK_STWG_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	POL_ETB" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	POR_CNT_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	POR_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	POL_CNT_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	POL_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	POD_CNT_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	POD_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	DEL_CNT_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	DEL_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	TS_PORT_1" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	TS_PORT_2" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	TS_PORT_3" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	POD_ETB" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	TRUNK_VVD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	N1_V_SVC" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	N1_V_DIR" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	N1_V_VSL_CD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	N1_V_VOY_NO" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	N1_V_VSL_NM" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	N1_V_VVD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	N2_V_VVD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	N3_V_VVD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	N4_V_VVD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	POL_CUTOFF_DT" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	FIRST_POL_ETB" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	FIRST_POL_ETD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	FIRST_POL_ATD" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	LAST_POD_ETA" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	LAST_POD_ATA" ).append("\n"); 
		query.append("        ,'Route & Schedule' AS	LAST_POD_ETB" ).append("\n"); 
		query.append("        ,'AK Info' AS	APRO_REF_NO" ).append("\n"); 
		query.append("        ,'AK Info' AS	APRO_STS" ).append("\n"); 
		query.append("        ,'AK Info' AS	AWK_RE_SEQ" ).append("\n"); 
		query.append("        ,'AK Info' AS	AK_CMDT_CD" ).append("\n"); 
		query.append("        ,'AK Info' AS	AK_CMDT_DESC" ).append("\n"); 
		query.append("        ,'AK Info' AS	CNR_PST_STS" ).append("\n"); 
		query.append("        ,'AK Info' AS	DIM_OLF" ).append("\n"); 
		query.append("        ,'AK Info' AS	DIM_OLB" ).append("\n"); 
		query.append("        ,'AK Info' AS	DIM_OWR" ).append("\n"); 
		query.append("        ,'AK Info' AS	DIM_OWL" ).append("\n"); 
		query.append("        ,'AK Info' AS	DIM_OH" ).append("\n"); 
		query.append("        ,'AK Info' AS	TTL_LEN" ).append("\n"); 
		query.append("        ,'AK Info' AS	TTL_WDT" ).append("\n"); 
		query.append("        ,'AK Info' AS	TTL_HGT" ).append("\n"); 
		query.append("        ,'AK Info' AS	GRS_WGT" ).append("\n"); 
		query.append("        ,'AK Info' AS	GRS_WGT_UT_CD" ).append("\n"); 
		query.append("        ,'AK Info' AS	NET_WGT" ).append("\n"); 
		query.append("        ,'AK Info' AS	NET_WGT_UT_CD" ).append("\n"); 
		query.append("        ,'AK Info' AS	UD_TOP_FLG" ).append("\n"); 
		query.append("        ,'AK Info' AS	IN_GA_FLG" ).append("\n"); 
		query.append("        ,'AK Info' AS	AK_PCK_TP_CD" ).append("\n"); 
		query.append("        ,'AK Info' AS	AK_PCK_DESC" ).append("\n"); 
		query.append("        ,'AK Info' AS	RMK" ).append("\n"); 
		query.append("        ,'AK Info' AS	STWG_RQST" ).append("\n"); 
		query.append("        ,'AK Info' AS	VOID_TEU" ).append("\n"); 
		query.append("        ,'' AS AWK_CGO_SEQ--for ORDER BY" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         '2' AS TEMP" ).append("\n"); 
		query.append("        ,'B/L No.' AS	BL_NO" ).append("\n"); 
		query.append("        ,'B/L Release OFC' AS	BL_RLSE_OFC" ).append("\n"); 
		query.append("        ,'BKG Creation Date' AS	BKG_CRE_DT" ).append("\n"); 
		query.append("        ,'BKG Creator' AS	BKG_STAFF" ).append("\n"); 
		query.append("        ,'BKG No.' AS	BKG_NO" ).append("\n"); 
		query.append("        ,'BKG OFC' AS	BKG_OFC_CD" ).append("\n"); 
		query.append("        ,'Cust Remark' AS	XTER_RMK" ).append("\n"); 
		query.append("        ,'Vndr Remark' AS	VNDR_RMK" ).append("\n"); 
		query.append("        ,'Int Remark' AS	INTER_RMK" ).append("\n"); 
		query.append("        ,'DG Certificate Rsvd.' AS	DG_CERTI" ).append("\n"); 
		query.append("        ,'Export Declaration Rcvd.' AS	XPT_DECL_RCV" ).append("\n"); 
		query.append("        ,'Sales Area' AS	SLS_AREA" ).append("\n"); 
		query.append("        ,'Sales OFC' AS	OB_SLS_OFC_CD" ).append("\n"); 
		query.append("        ,'C.SREP' AS	CTRT_SREP_CD" ).append("\n"); 
		query.append("        ,'L.SREP' AS	OB_SREP_CD" ).append("\n"); 
		query.append("        ,'SI & B/L Master Rcvd' AS	SI_FLG" ).append("\n"); 
		query.append("        ,'Special Handling Instructions Type' AS	SPCL_HND_RMK" ).append("\n"); 
		query.append("        ,'Special Handling Instructions Detail' AS	SPCL_HNDL_INST_DESC" ).append("\n"); 
		query.append("        ,'Stop Off Cargo Order - Location' AS	STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("        ,'Stop Off Cargo Order - Tel' AS	STOP_OFF_CNTC_PHN_NO" ).append("\n"); 
		query.append("        ,'Stop Off Cargo Order - Contact Point' AS	STOP_OFF_CNTC_PSON_NM" ).append("\n"); 
		query.append("        ,'Stop Off Cargo Order - Remarks' AS	STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append("        ,'Hanger Installation Order - Single' AS	CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append("        ,'Hanger Installation Order - Double' AS	CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append("        ,'Hanger Installation Order - Triple' AS	CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append("        ,'Hanger Installation Order -  M''HGR' AS	MER_HNGR_QTY" ).append("\n"); 
		query.append("        ,'BKG Status' AS	BKG_STS_CD" ).append("\n"); 
		query.append("        ,'Cargo Nature' AS	CGO_N" ).append("\n"); 
		query.append("        ,'CMDT Code' AS	CMDT_CD" ).append("\n"); 
		query.append("        ,'CMDT Name' AS	CMDT_DESC" ).append("\n"); 
		query.append("        ,'OB Haulage Type' AS	OB_HLG" ).append("\n"); 
		query.append("        ,'IB Haulage Type' AS	IB_HLG" ).append("\n"); 
		query.append("        ,'Marks & NOS' AS	MARK_NOS" ).append("\n"); 
		query.append("        ,'No. of Packages' AS	PCK_QTY" ).append("\n"); 
		query.append("        ,'Package Type' AS	PCK_DESC" ).append("\n"); 
		query.append("        ,'CNTR No.' AS	CNTR_NO" ).append("\n"); 
		query.append("        ,'CNTR Size Type' AS	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,'CNTR Status' AS	CNMV_STS_CD" ).append("\n"); 
		query.append("        ,'Cargo WGT' AS	CGO_WGT" ).append("\n"); 
		query.append("        ,'Cargo WGT Unit' AS	CGO_WGT_UT_CD" ).append("\n"); 
		query.append("        ,'GRS MEA' AS	MEAS_QTY" ).append("\n"); 
		query.append("        ,'GRS MEA Unit' AS	MEAS_UT_CD" ).append("\n"); 
		query.append("        ,'Seal No.' AS	CNTR_SEAL_NO" ).append("\n"); 
		query.append("        ,'SOC' AS	SOC_FLG" ).append("\n"); 
		query.append("        ,'Substitution Type' AS	SUBST_TYPE" ).append("\n"); 
		query.append("        ,'RD (Reefer as DRY)' AS	RD_CGO_FLG" ).append("\n"); 
		query.append("        ,'Empty Pickup location' AS	MTY_PKUP_LOC" ).append("\n"); 
		query.append("        ,'Empty Return Location' AS	MTY_RTN_LOC" ).append("\n"); 
		query.append("        ,'Full Return Location' AS	FULL_RTN_LOC" ).append("\n"); 
		query.append("        ,'Estd Pick Up Date/Time' AS	OP_ESTM_DT" ).append("\n"); 
		query.append("        ,'Estd Return Date/Time' AS	OC_ESTM_DT" ).append("\n"); 
		query.append("        ,'Actual Pick Up Date/Time' AS	OP_ACT_DT" ).append("\n"); 
		query.append("        ,'Actual Return Date/Time' AS	OC_ACT_DT" ).append("\n"); 
		query.append("        ,'Shipper' AS	SHPR_NM" ).append("\n"); 
		query.append("        ,'Shipper Contact Name' AS	SHPR_CNTC_NM" ).append("\n"); 
		query.append("        ,'Shipper Contact Number' AS	SHPR_CNTC_NO" ).append("\n"); 
		query.append("        ,'Address of Shipper' AS	SHPR_ADDR" ).append("\n"); 
		query.append("        ,'Consignee' AS	CNEE_NM" ).append("\n"); 
		query.append("        ,'Address of Consignee' AS	CNEE_ADDR" ).append("\n"); 
		query.append("        ,'Forwarder' AS	FFWD_NM" ).append("\n"); 
		query.append("        ,'Forwarder Contact Name' AS	FFWD_CNTC_NM" ).append("\n"); 
		query.append("        ,'Forwarder Contact Number' AS	FFWD_CNTC_NO" ).append("\n"); 
		query.append("        ,'Notify Party' AS	NTFY_PARTY" ).append("\n"); 
		query.append("        ,'Address of Notify' AS	NTFY_ADDR" ).append("\n"); 
		query.append("        ,'Contract Party Code' AS	CTRT_PTY_CD" ).append("\n"); 
		query.append("        ,'Contract Party Name' AS	CTRT_PTY_NM" ).append("\n"); 
		query.append("        ,'Payment Term' AS	FRT_TERM_CD" ).append("\n"); 
		query.append("        ,'S/C No.' AS	SC_NO" ).append("\n"); 
		query.append("        ,'RFA No.' AS	RFA_NO" ).append("\n"); 
		query.append("        ,'Tariff No.' AS	TAA_NO" ).append("\n"); 
		query.append("        ,'Bound' AS	BOUND" ).append("\n"); 
		query.append("        ,'Service' AS	SVC_SCP_CD" ).append("\n"); 
		query.append("        ,'Trade ' AS	TRD_CD" ).append("\n"); 
		query.append("        ,'Traffic Mode I/B' AS	TRAF_MOD_IB" ).append("\n"); 
		query.append("        ,'Traffic Mode O/B' AS	TRAF_MOD_OB" ).append("\n"); 
		query.append("        ,'Transport Mode I/B' AS	TRSP_MOD_IB" ).append("\n"); 
		query.append("        ,'Transport Mode O/B' AS	TRSP_MOD_OB" ).append("\n"); 
		query.append("        ,'Block Stowage' AS	BLCK_STWG_CD" ).append("\n"); 
		query.append("        ,'Berth at First POL' AS	POL_ETB" ).append("\n"); 
		query.append("        ,'POR Country' AS	POR_CNT_CD" ).append("\n"); 
		query.append("        ,'POR Code' AS	POR_CD" ).append("\n"); 
		query.append("        ,'POL Country' AS	POL_CNT_CD" ).append("\n"); 
		query.append("        ,'POL Code' AS	POL_CD" ).append("\n"); 
		query.append("        ,'POD Country' AS	POD_CNT_CD" ).append("\n"); 
		query.append("        ,'POD Code' AS	POD_CD" ).append("\n"); 
		query.append("        ,'DEL Country' AS	DEL_CNT_CD" ).append("\n"); 
		query.append("        ,'DEL Code' AS	DEL_CD" ).append("\n"); 
		query.append("        ,'T/S Port 1' AS	TS_PORT_1" ).append("\n"); 
		query.append("        ,'T/S Port 2' AS	TS_PORT_2" ).append("\n"); 
		query.append("        ,'T/S Port 3' AS	TS_PORT_3" ).append("\n"); 
		query.append("        ,'Berth at Last POD' AS	POD_ETB" ).append("\n"); 
		query.append("        ,'Trunk VVD' AS	TRUNK_VVD" ).append("\n"); 
		query.append("        ,'1st Service' AS	N1_V_SVC" ).append("\n"); 
		query.append("        ,'1st Direction' AS	N1_V_DIR" ).append("\n"); 
		query.append("        ,'1st Vessel Code' AS	N1_V_VSL_CD" ).append("\n"); 
		query.append("        ,'1st Voyage' AS	N1_V_VOY_NO" ).append("\n"); 
		query.append("        ,'1st Vessel Name' AS	N1_V_VSL_NM" ).append("\n"); 
		query.append("        ,'1st VVD' AS	N1_V_VVD" ).append("\n"); 
		query.append("        ,'2nd  VVD ' AS	N2_V_VVD" ).append("\n"); 
		query.append("        ,'3rd VVD' AS	N3_V_VVD" ).append("\n"); 
		query.append("        ,'4th VVD' AS	N4_V_VVD" ).append("\n"); 
		query.append("        ,'First Load Port Cut-Off Date' AS	POL_CUTOFF_DT" ).append("\n"); 
		query.append("        ,'Berth at First POL Date' AS	FIRST_POL_ETB" ).append("\n"); 
		query.append("        ,'ETD from First POL' AS	FIRST_POL_ETD" ).append("\n"); 
		query.append("        ,'ATD from First POL' AS	FIRST_POL_ATD" ).append("\n"); 
		query.append("        ,'ETA at Last POD' AS	LAST_POD_ETA" ).append("\n"); 
		query.append("        ,'ATA at Last POD' AS	LAST_POD_ATA" ).append("\n"); 
		query.append("        ,'Berth at Last POD Date' AS	LAST_POD_ETB" ).append("\n"); 
		query.append("        ,'Approval Ref. No' AS	APRO_REF_NO" ).append("\n"); 
		query.append("        ,'Approval Status' AS	APRO_STS" ).append("\n"); 
		query.append("        ,'Cargo Detail for Container Sequence' AS	AWK_RE_SEQ" ).append("\n"); 
		query.append("        ,'Commodity Code' AS	AK_CMDT_CD" ).append("\n"); 
		query.append("        ,'Commodity Name' AS	AK_CMDT_DESC" ).append("\n"); 
		query.append("        ,'Corner Post Status' AS	CNR_PST_STS" ).append("\n"); 
		query.append("        ,'Dimension (in cm) - OLF' AS	DIM_OLF" ).append("\n"); 
		query.append("        ,'Dimension (in cm) - OLB' AS	DIM_OLB" ).append("\n"); 
		query.append("        ,'Dimension (in cm) - OWR' AS	DIM_OWR" ).append("\n"); 
		query.append("        ,'Dimension (in cm) - OWL' AS	DIM_OWL" ).append("\n"); 
		query.append("        ,'Dimension (in cm) - OH' AS	DIM_OH" ).append("\n"); 
		query.append("        ,'Total Dimension (in cm) - L' AS	TTL_LEN" ).append("\n"); 
		query.append("        ,'Total Dimension (in cm)  - W' AS	TTL_WDT" ).append("\n"); 
		query.append("        ,'Total Dimension (in cm) - H' AS	TTL_HGT" ).append("\n"); 
		query.append("        ,'Gross Weight' AS	GRS_WGT" ).append("\n"); 
		query.append("        ,'Gross Weight Unit' AS	GRS_WGT_UT_CD" ).append("\n"); 
		query.append("        ,'Net Weight' AS	NET_WGT" ).append("\n"); 
		query.append("        ,'Net Weight Unit' AS	NET_WGT_UT_CD" ).append("\n"); 
		query.append("        ,'UD-Top' AS	UD_TOP_FLG" ).append("\n"); 
		query.append("        ,'In-Gauge' AS	IN_GA_FLG" ).append("\n"); 
		query.append("        ,'Package Code' AS	AK_PCK_TP_CD" ).append("\n"); 
		query.append("        ,'Package Description' AS	AK_PCK_DESC" ).append("\n"); 
		query.append("        ,'Remarks' AS	RMK" ).append("\n"); 
		query.append("        ,'Stowage Request' AS	STWG_RQST" ).append("\n"); 
		query.append("        ,'Void FEU' AS	VOID_TEU" ).append("\n"); 
		query.append("        ,'' AS AWK_CGO_SEQ--for ORDER BY" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT '3' AS TEMP" ).append("\n"); 
		query.append("    -- BKG & B/L Info" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , BK.BL_NO" ).append("\n"); 
		query.append("         , (SELECT USR.OFC_CD FROM BKG_DOC_PROC_SKD PROC, COM_USER USR" ).append("\n"); 
		query.append("             WHERE PROC.BKG_DOC_PROC_TP_CD = 'OBLREL'" ).append("\n"); 
		query.append("               AND PROC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("               AND PROC.DOC_PERF_DELT_FLG ='N'" ).append("\n"); 
		query.append("               AND PROC.EVNT_USR_ID = USR.USR_ID) AS BL_RLSE_OFC" ).append("\n"); 
		query.append("         , TO_CHAR(BK.BKG_CRE_DT, 'YYYY-MM-DD HH24:MI') BKG_CRE_DT" ).append("\n"); 
		query.append("         , BK.DOC_USR_ID BKG_STAFF" ).append("\n"); 
		query.append("         , BK.BKG_NO" ).append("\n"); 
		query.append("         , BK.BKG_OFC_CD" ).append("\n"); 
		query.append("         , REPLACE(REPLACE(REPLACE(BK.XTER_RMK,CHR(10),' '),CHR(9),' '),CHR(34),'') XTER_RMK" ).append("\n"); 
		query.append("         , REPLACE(REPLACE(REPLACE(BK.VNDR_RMK,CHR(10),' '),CHR(9),' '),CHR(34),'') AS VNDR_RMK" ).append("\n"); 
		query.append("         , REPLACE(REPLACE(REPLACE(BK.INTER_RMK,CHR(10),' '),CHR(9),' '),CHR(34),'') AS INTER_RMK" ).append("\n"); 
		query.append("         , CASE WHEN (SELECT COUNT(1) FROM BKG_IMG_STO IMG WHERE IMG.BKG_NO = BK.BKG_NO AND IMG.RIDR_TP_CD = 'D') > 0 THEN 'Y' ELSE 'N' END DG_CERTI" ).append("\n"); 
		query.append("         , DECODE(NVL(DECODE(CNTR.CNTR_NO, NULL, " ).append("\n"); 
		query.append("                                  BKG_JOIN_FNC(CURSOR(SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("                                                        FROM BKG_REFERENCE CUCR" ).append("\n"); 
		query.append("                                                       WHERE CUCR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                         AND CUCR.BKG_REF_TP_CD = 'CMRN'" ).append("\n"); 
		query.append("                                                       ORDER BY CUCR.REF_SEQ" ).append("\n"); 
		query.append("                                                      ),',')," ).append("\n"); 
		query.append("                                  (SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("                                     FROM BKG_REFERENCE CUCR" ).append("\n"); 
		query.append("                                    WHERE CUCR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                      AND CUCR.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                                      AND CUCR.BKG_REF_TP_CD = 'CMRN')),''),'','N','Y') AS XPT_DECL_RCV" ).append("\n"); 
		query.append("         , (SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = BK.BKG_OFC_CD) AS SLS_AREA" ).append("\n"); 
		query.append("         , BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("         , BK.CTRT_SREP_CD" ).append("\n"); 
		query.append("         , BK.OB_SREP_CD" ).append("\n"); 
		query.append("         , BK.SI_FLG" ).append("\n"); 
		query.append("         , BK.STWG_CD SPCL_HND_RMK" ).append("\n"); 
		query.append("         , (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02146' AND INTG_CD_VAL_CTNT = BK.STWG_CD) AS SPCL_HNDL_INST_DESC" ).append("\n"); 
		query.append("         , BK.STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("         , BK.STOP_OFF_CNTC_PHN_NO" ).append("\n"); 
		query.append("         , BK.STOP_OFF_CNTC_PSON_NM" ).append("\n"); 
		query.append("         , REPLACE(REPLACE(REPLACE(BK.STOP_OFF_DIFF_RMK,CHR(10),' '),CHR(9),' '),CHR(34),'') STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append("         , TO_CHAR(QTY.CRR_HNGR_SGL_BAR_QTY) CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append("         , TO_CHAR(QTY.CRR_HNGR_DBL_BAR_QTY) CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append("         , TO_CHAR(QTY.CRR_HNGR_TPL_BAR_QTY) CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append("         , TO_CHAR(QTY.MER_HNGR_QTY) MER_HNGR_QTY" ).append("\n"); 
		query.append("    -- Cargo & Commodity" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , BK.BKG_STS_CD" ).append("\n"); 
		query.append("         , NVL(SUBSTR(DECODE(BK.DCGO_FLG,'Y',',DG','')||DECODE(BK.RC_FLG,'Y',',RF','')||DECODE(BK.AWK_CGO_FLG,'Y',',AW','')||DECODE(BK.BB_CGO_FLG,'Y',',BB','')||DECODE(BK.RD_CGO_FLG,'Y',',RD',''),2),'DR') AS CGO_N" ).append("\n"); 
		query.append("         , DECODE(SUBSTR(BK.CMDT_CD,1,1),0,'''','')||BK.CMDT_CD AS CMDT_CD" ).append("\n"); 
		query.append("         , (SELECT CMDT_NM FROM MDM_COMMODITY CMDT WHERE CMDT.CMDT_CD = BK.CMDT_CD) CMDT_DESC" ).append("\n"); 
		query.append("         , DECODE(BK.RCV_TERM_CD, 'D', 'C', 'M') AS OB_HLG" ).append("\n"); 
		query.append("         , NVL((SELECT DECODE(TRO.HLG_TP_CD, 'C', 'C', 'M')" ).append("\n"); 
		query.append("                  FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("                 WHERE TRO.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                   AND TRO.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                   AND TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                   AND TRO.CXL_FLG = 'N'), DECODE(BK.DE_TERM_CD, 'D', 'C', 'M')) AS IB_HLG" ).append("\n"); 
		query.append("         , (SELECT REPLACE(REPLACE(REPLACE(TO_CHAR(SUBSTR(MK.MK_DESC, 1, 4000)),CHR(10),' '),CHR(9),' '),CHR(34),'')" ).append("\n"); 
		query.append("              FROM BKG_BL_MK_DESC MK" ).append("\n"); 
		query.append("             WHERE BK.BKG_NO = MK.BKG_NO" ).append("\n"); 
		query.append("               AND MK.MK_SEQ = 1) MARK_NOS" ).append("\n"); 
		query.append("         , TO_CHAR(CNTR.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append("         , (SELECT PCK_NM FROM MDM_PCK_TP PCK WHERE CNTR.PCK_TP_CD = PCK.PCK_CD) PCK_DESC" ).append("\n"); 
		query.append("    -- Container" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , CNTR.CNTR_NO" ).append("\n"); 
		query.append("         , CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	     , DECODE(BK.BKG_STS_CD,'X',''," ).append("\n"); 
		query.append("				DECODE((SELECT COP.COP_STS_CD FROM SCE_COP_HDR COP WHERE COP.BKG_NO = CNTR.BKG_NO AND COP.CNTR_NO = CNTR.CNTR_NO AND COP.COP_STS_CD <> 'X'),'F','MT'," ).append("\n"); 
		query.append("					(SELECT B.CNMV_STS_CD FROM MST_CONTAINER B WHERE B.CNTR_NO = CNTR.CNTR_NO))) CNMV_STS_CD" ).append("\n"); 
		query.append("         , TRIM(TO_CHAR(CNTR.CNTR_WGT,'999,999,999,990.99')) CGO_WGT" ).append("\n"); 
		query.append("         , CNTR.WGT_UT_CD CGO_WGT_UT_CD" ).append("\n"); 
		query.append("         , TRIM(TO_CHAR(CNTR.MEAS_QTY,'999,999,999,990.99')) MEAS_QTY" ).append("\n"); 
		query.append("         , CNTR.MEAS_UT_CD" ).append("\n"); 
		query.append("         , BKG_JOIN_FNC(CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                         FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                        WHERE BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("                                          AND CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                                          AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("                               ),',') AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("         , CNTR.SOC_FLG" ).append("\n"); 
		query.append("         , DECODE(CNTR.EQ_SUBST_FLG, 'Y', CNTR.EQ_SUBST_TPSZ_CD, '') SUBST_TYPE" ).append("\n"); 
		query.append("         , BK.RD_CGO_FLG" ).append("\n"); 
		query.append("         ,(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/SUBSTR(D.NOD_CD,1,5)" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 SCE_COP_DTL D," ).append("\n"); 
		query.append("                 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("           WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND H.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("             AND H.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("             AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             AND MPG.ACT_STS_MAPG_CD = 'OP'" ).append("\n"); 
		query.append("             AND ROWNUM=1" ).append("\n"); 
		query.append("         ) MTY_PKUP_LOC" ).append("\n"); 
		query.append("         ,(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/SUBSTR(D.NOD_CD,1,5)" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 SCE_COP_DTL D," ).append("\n"); 
		query.append("                 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("           WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND H.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("             AND H.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("             AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             AND MPG.ACT_STS_MAPG_CD = 'MT'" ).append("\n"); 
		query.append("             AND ROWNUM=1" ).append("\n"); 
		query.append("         ) MTY_RTN_LOC" ).append("\n"); 
		query.append("         ,(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/SUBSTR(D.NOD_CD,1,5)" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 SCE_COP_DTL D," ).append("\n"); 
		query.append("                 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("           WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND H.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("             AND H.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("             AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             AND MPG.ACT_STS_MAPG_CD = 'OC'" ).append("\n"); 
		query.append("             AND ROWNUM=1" ).append("\n"); 
		query.append("         ) FULL_RTN_LOC" ).append("\n"); 
		query.append("         ,(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/TO_CHAR(D.ESTM_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 SCE_COP_DTL D," ).append("\n"); 
		query.append("                 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("           WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND H.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("             AND H.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("             AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             AND MPG.ACT_STS_MAPG_CD = 'OP'" ).append("\n"); 
		query.append("             AND ROWNUM=1" ).append("\n"); 
		query.append("         ) OP_ESTM_DT" ).append("\n"); 
		query.append("         ,(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/TO_CHAR(D.ESTM_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 SCE_COP_DTL D," ).append("\n"); 
		query.append("                 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("           WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND H.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("             AND H.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("             AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             AND MPG.ACT_STS_MAPG_CD = 'OC'" ).append("\n"); 
		query.append("             AND ROWNUM=1" ).append("\n"); 
		query.append("         ) OC_ESTM_DT" ).append("\n"); 
		query.append("         ,(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/TO_CHAR(D.ACT_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 SCE_COP_DTL D," ).append("\n"); 
		query.append("                 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("           WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND H.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("             AND H.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("             AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             AND MPG.ACT_STS_MAPG_CD = 'OP'" ).append("\n"); 
		query.append("             AND ROWNUM=1" ).append("\n"); 
		query.append("         ) OP_ACT_DT" ).append("\n"); 
		query.append("         ,(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/TO_CHAR(D.ACT_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 SCE_COP_DTL D," ).append("\n"); 
		query.append("                 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("           WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             AND H.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("             AND H.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("             AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             AND MPG.ACT_STS_MAPG_CD = 'OC'" ).append("\n"); 
		query.append("             AND ROWNUM=1" ).append("\n"); 
		query.append("         ) OC_ACT_DT" ).append("\n"); 
		query.append("    -- Customer" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , (SELECT REPLACE(REPLACE(REPLACE(CUST_NM,CHR(10),' '),CHR(9),' '),CHR(34),'')   FROM BKG_CUSTOMER C WHERE C.BKG_NO = BK.BKG_NO AND C.BKG_CUST_TP_CD = 'S') SHPR_NM" ).append("\n"); 
		query.append("         , (SELECT CNTC_PSON_NM FROM MDM_CUST_ADDR     ADDR, BKG_CUSTOMER S WHERE BK.BKG_NO = S.BKG_NO AND S.BKG_CUST_TP_CD = 'S' AND ADDR.CUST_CNT_CD = S.CUST_CNT_CD AND ADDR.CUST_SEQ = S.CUST_SEQ AND PRMRY_CHK_FLG = 'Y' AND ROWNUM = 1) AS SHPR_CNTC_NM" ).append("\n"); 
		query.append("         , (SELECT PHN_NO       FROM MDM_CUST_CNTC_PNT CNTC, BKG_CUSTOMER S WHERE BK.BKG_NO = S.BKG_NO AND S.BKG_CUST_TP_CD = 'S' AND CNTC.CUST_CNT_CD = S.CUST_CNT_CD AND CNTC.CUST_SEQ = S.CUST_SEQ AND ROWNUM = 1) AS SHPR_CNTC_NO" ).append("\n"); 
		query.append("         , (SELECT REPLACE(REPLACE(REPLACE(CUST_ADDR,CHR(10),' '),CHR(9),' '),CHR(34),'') FROM BKG_CUSTOMER S WHERE S.BKG_NO = BK.BKG_NO AND S.BKG_CUST_TP_CD = 'S') SHPR_ADDR" ).append("\n"); 
		query.append("         , (SELECT REPLACE(REPLACE(REPLACE(CUST_NM,CHR(10),' '),CHR(9),' '),CHR(34),'')   FROM BKG_CUSTOMER C WHERE C.BKG_NO = BK.BKG_NO AND C.BKG_CUST_TP_CD = 'C') CNEE_NM" ).append("\n"); 
		query.append("         , (SELECT REPLACE(REPLACE(REPLACE(CUST_ADDR,CHR(10),' '),CHR(9),' '),CHR(34),'') FROM BKG_CUSTOMER C WHERE C.BKG_NO = BK.BKG_NO AND C.BKG_CUST_TP_CD = 'C') CNEE_ADDR" ).append("\n"); 
		query.append("         , (SELECT REPLACE(REPLACE(REPLACE(CUST_NM,CHR(10),' '),CHR(9),' '),CHR(34),'')   FROM BKG_CUSTOMER F WHERE F.BKG_NO = BK.BKG_NO AND F.BKG_CUST_TP_CD = 'F') FFWD_NM" ).append("\n"); 
		query.append("         , (SELECT CNTC_PSON_NM FROM MDM_CUST_ADDR     ADDR, BKG_CUSTOMER F WHERE BK.BKG_NO = F.BKG_NO AND F.BKG_CUST_TP_CD = 'F' AND ADDR.CUST_CNT_CD = F.CUST_CNT_CD AND ADDR.CUST_SEQ = F.CUST_SEQ AND PRMRY_CHK_FLG = 'Y' AND ROWNUM = 1) AS FFWD_CNTC_NM" ).append("\n"); 
		query.append("         , (SELECT PHN_NO    FROM MDM_CUST_CNTC_PNT CNTC, BKG_CUSTOMER F WHERE BK.BKG_NO = F.BKG_NO AND F.BKG_CUST_TP_CD = 'F' AND CNTC.CUST_CNT_CD = F.CUST_CNT_CD AND CNTC.CUST_SEQ = F.CUST_SEQ AND ROWNUM = 1) AS FFWD_CNTC_NO" ).append("\n"); 
		query.append("         , (SELECT REPLACE(REPLACE(REPLACE(CUST_NM,CHR(10),' '),CHR(9),' '),CHR(34),'')   FROM BKG_CUSTOMER C WHERE C.BKG_NO = BK.BKG_NO AND C.BKG_CUST_TP_CD = 'N') NTFY_PARTY" ).append("\n"); 
		query.append("         , (SELECT REPLACE(REPLACE(REPLACE(CUST_ADDR,CHR(10),' '),CHR(9),' '),CHR(34),'') FROM BKG_CUSTOMER N WHERE N.BKG_NO = BK.BKG_NO AND N.BKG_CUST_TP_CD = 'N') NTFY_ADDR" ).append("\n"); 
		query.append("         , BKG_CTRL_PTY_CUST_CNT_CD||LPAD(BK.BKG_CTRL_PTY_CUST_SEQ,6,'0') AS CTRT_PTY_CD" ).append("\n"); 
		query.append("         , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = BK.BKG_CTRL_PTY_CUST_CNT_CD AND CUST_SEQ = BK.BKG_CTRL_PTY_CUST_SEQ) AS CTRT_PTY_NM" ).append("\n"); 
		query.append("    -- Rate & Invoice" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , RATE.FRT_TERM_CD" ).append("\n"); 
		query.append("         , BK.SC_NO" ).append("\n"); 
		query.append("         , BK.RFA_NO" ).append("\n"); 
		query.append("         , BK.TAA_NO" ).append("\n"); 
		query.append("    -- Route & Schedule" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , DECODE(@[io_bnd_cd], 'O', 'Departure', 'Arrival') BOUND" ).append("\n"); 
		query.append("         , BK.SVC_SCP_CD" ).append("\n"); 
		query.append("         , COA.TRD_CD" ).append("\n"); 
		query.append("         , DECODE(NVL(CNTR.DE_TERM_CD, BK.DE_TERM_CD),'S','LCL','FCL') AS TRAF_MOD_IB" ).append("\n"); 
		query.append("         , DECODE(NVL(CNTR.RCV_TERM_CD, BK.RCV_TERM_CD),'S','LCL','FCL') AS TRAF_MOD_OB" ).append("\n"); 
		query.append("         , BK.DEST_TRNS_MOD_CD AS TRSP_MOD_IB" ).append("\n"); 
		query.append("         , BK.ORG_TRNS_MOD_CD AS TRSP_MOD_OB" ).append("\n"); 
		query.append("         , BK.BLCK_STWG_CD" ).append("\n"); 
		query.append("         , TO_CHAR(N1ST_VVD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') POL_ETB " ).append("\n"); 
		query.append("         , SUBSTR(BK.POR_CD, 1, 2) POR_CNT_CD" ).append("\n"); 
		query.append("         , BK.POR_CD" ).append("\n"); 
		query.append("         , SUBSTR(BK.POL_CD, 1, 2) POL_CNT_CD" ).append("\n"); 
		query.append("         , BK.POL_CD" ).append("\n"); 
		query.append("         , SUBSTR(BK.POD_CD, 1, 2) POD_CNT_CD" ).append("\n"); 
		query.append("         , BK.POD_CD" ).append("\n"); 
		query.append("         , SUBSTR(BK.DEL_CD, 1, 2) DEL_CNT_CD" ).append("\n"); 
		query.append("         , BK.DEL_CD" ).append("\n"); 
		query.append("         , DECODE(ROUTE.POD_2, '', ROUTE.POD_1, '') TS_PORT_1" ).append("\n"); 
		query.append("         , DECODE(ROUTE.POD_3, '', ROUTE.POD_2, '') TS_PORT_2" ).append("\n"); 
		query.append("         , DECODE(ROUTE.POD_4, '', ROUTE.POD_3, '') TS_PORT_3" ).append("\n"); 
		query.append("         , TO_CHAR(LAST_VVD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') POD_ETB" ).append("\n"); 
		query.append("         , BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD TRUNK_VVD" ).append("\n"); 
		query.append("         , ROUTE.SLAN_1 N1_V_SVC" ).append("\n"); 
		query.append("         , SUBSTR(ROUTE.VVD_1, 9, 1) N1_V_DIR" ).append("\n"); 
		query.append("         , DECODE(SUBSTR(ROUTE.VVD_1, 5, 1),0,'''','')||SUBSTR(ROUTE.VVD_1, 5, 4) N1_V_VOY_NO" ).append("\n"); 
		query.append("         , SUBSTR(ROUTE.VVD_1, 5, 4) N1_V_VOY_NO  " ).append("\n"); 
		query.append("         , (SELECT M.VSL_ENG_NM FROM MDM_VSL_CNTR M WHERE M.VSL_CD = SUBSTR(ROUTE.VVD_1, 1, 4)) N1_V_VSL_NM" ).append("\n"); 
		query.append("         , ROUTE.VVD_1 N1_V_VVD  " ).append("\n"); 
		query.append("         , ROUTE.VVD_2 N2_V_VVD" ).append("\n"); 
		query.append("         , ROUTE.VVD_3 N3_V_VVD" ).append("\n"); 
		query.append("         , ROUTE.VVD_4 N4_V_VVD" ).append("\n"); 
		query.append("         , (SELECT TO_CHAR(NVL(MNL_SET_DT,SYS_SET_DT),'YYYY-MM-DD HH24:MI') FROM BKG_CLZ_TM WHERE CLZ_TP_CD = 'T' AND BKG_NO=BK.BKG_NO) AS POL_CUTOFF_DT" ).append("\n"); 
		query.append("         , TO_CHAR(N1ST_VVD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') FIRST_POL_ETB" ).append("\n"); 
		query.append("         , TO_CHAR(N1ST_VVD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') FIRST_POL_ETD" ).append("\n"); 
		query.append("         , DECODE(N1ST_VVD.ACT_INP_FLG,'Y',TO_CHAR(N1ST_VVD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI'),'') FIRST_POL_ATD" ).append("\n"); 
		query.append("         , TO_CHAR(LAST_VVD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') LAST_POD_ETA" ).append("\n"); 
		query.append("         , DECODE(LAST_VVD.ACT_INP_FLG,'Y',TO_CHAR(LAST_VVD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'),'') LAST_POD_ATA" ).append("\n"); 
		query.append("         , TO_CHAR(LAST_VVD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') LAST_POD_ETB" ).append("\n"); 
		query.append("    -- AK Info" ).append("\n"); 
		query.append("    -----------------------------------------------------------" ).append("\n"); 
		query.append("         , (SELECT APRO_REF_NO " ).append("\n"); 
		query.append("              FROM SCG_APRO_RQST RQST, SCG_AUTHORIZATION AUTH " ).append("\n"); 
		query.append("             WHERE AK.BKG_NO      = RQST.BKG_NO" ).append("\n"); 
		query.append("               AND AK.BKG_NO      = AUTH.BKG_NO(+)" ).append("\n"); 
		query.append("               AND AK.AWK_CGO_SEQ = AUTH.AWK_CGO_SEQ(+)" ).append("\n"); 
		query.append("               AND RQST.SPCL_CGO_CATE_CD       = AUTH.SPCL_CGO_CATE_CD(+)     " ).append("\n"); 
		query.append("               AND RQST.SPCL_CGO_APRO_RQST_SEQ = AUTH.SPCL_CGO_APRO_RQST_SEQ(+)     " ).append("\n"); 
		query.append("               AND AUTH.VSL_PRE_PST_CD(+) = 'T'" ).append("\n"); 
		query.append("               AND RQST.LST_RQST_DAT_FLG = 'Y' " ).append("\n"); 
		query.append("               AND RQST.SPCL_CGO_CATE_CD = 'AK'" ).append("\n"); 
		query.append("               AND ROWNUM=1 --안전하게" ).append("\n"); 
		query.append("               ) APRO_REF_NO" ).append("\n"); 
		query.append("         , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("              FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("             WHERE INTG_CD_ID = 'CD01955'" ).append("\n"); 
		query.append("               AND INTG_CD_VAL_CTNT = AK.SPCL_CGO_APRO_CD) APRO_STS  " ).append("\n"); 
		query.append("         , TO_CHAR(ROW_NUMBER() OVER (PARTITION BY AK.BKG_NO ORDER BY AWK_CGO_SEQ)) AWK_RE_SEQ " ).append("\n"); 
		query.append("         , DECODE(SUBSTR(AK.CMDT_CD,1,1),0,'''','')||AK.CMDT_CD AS AK_CMDT_CD" ).append("\n"); 
		query.append("         , (SELECT CMDT_NM FROM MDM_COMMODITY CMDT WHERE CMDT.CMDT_CD = AK.CMDT_CD) AK_CMDT_DESC" ).append("\n"); 
		query.append("         , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("              FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("             WHERE INTG_CD_ID = 'CD01593'" ).append("\n"); 
		query.append("               AND INTG_CD_VAL_CTNT = AK.CRN_PST_STS_CD) CNR_PST_STS" ).append("\n"); 
		query.append("         , TO_CHAR(AK.OVR_FWRD_LEN,'999,999,999,990.99') DIM_OLF" ).append("\n"); 
		query.append("         , TO_CHAR(AK.OVR_BKWD_LEN,'999,999,999,990.99') DIM_OLB" ).append("\n"); 
		query.append("         , TO_CHAR(AK.OVR_RT_LEN,'999,999,999,990.99')   DIM_OWR" ).append("\n"); 
		query.append("         , TO_CHAR(AK.OVR_LF_LEN,'999,999,999,990.99')   DIM_OWL" ).append("\n"); 
		query.append("         , TO_CHAR(AK.OVR_HGT,'999,999,999,990.99')      DIM_OH" ).append("\n"); 
		query.append("         , TO_CHAR(AK.TTL_DIM_LEN,'999,999,999,990.99')  TTL_LEN" ).append("\n"); 
		query.append("         , TO_CHAR(AK.TTL_DIM_WDT,'999,999,999,990.99')  TTL_WDT" ).append("\n"); 
		query.append("         , TO_CHAR(AK.TTL_DIM_HGT,'999,999,999,990.99')  TTL_HGT" ).append("\n"); 
		query.append("         , TO_CHAR(AK.GRS_WGT,'999,999,999,990.99')      GRS_WGT" ).append("\n"); 
		query.append("         , AK.WGT_UT_CD AS GRS_WGT_UT_CD" ).append("\n"); 
		query.append("         , TO_CHAR(AK.NET_WGT,'999,999,999,990.99')      NET_WGT" ).append("\n"); 
		query.append("         , AK.WGT_UT_CD AS NET_WGT_UT_CD" ).append("\n"); 
		query.append("         , AK.UND_DECK_TOP_FLG UD_TOP_FLG" ).append("\n"); 
		query.append("         , AK.IN_GA_FLG    IN_GA_FLG" ).append("\n"); 
		query.append("         , AK.PCK_TP_CD    AK_PCK_TP_CD" ).append("\n"); 
		query.append("         , (SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD = AK.PCK_TP_CD) AK_PCK_DESC" ).append("\n"); 
		query.append("         , REPLACE(REPLACE(REPLACE(AK.DIFF_RMK,CHR(10),' '),CHR(9),' '),CHR(34),'') RMK" ).append("\n"); 
		query.append("         , REPLACE(REPLACE(REPLACE(AK.STWG_RQST_DESC,CHR(10),' '),CHR(9),' '),CHR(34),'') STWG_RQST" ).append("\n"); 
		query.append("         , TO_CHAR(AK.OVR_VOID_SLT_QTY) VOID_TEU" ).append("\n"); 
		query.append("         , TO_CHAR(AK.AWK_CGO_SEQ) AWK_CGO_SEQ--for ORDER BY" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("         , BKG_VVD VVD" ).append("\n"); 
		query.append("         , BKG_BL_DOC BL" ).append("\n"); 
		query.append("         , BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("         , BKG_RATE RATE" ).append("\n"); 
		query.append("         , BKG_BL_ISS ISS" ).append("\n"); 
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
		query.append("         , BKG_AWK_CGO AK" ).append("\n"); 
		query.append("         , VSK_VSL_PORT_SKD N1ST_VVD" ).append("\n"); 
		query.append("         , VSK_VSL_PORT_SKD LAST_VVD" ).append("\n"); 
		query.append("         , BKG_QUANTITY QTY" ).append("\n"); 
		query.append("#if (${sail_from_dt} != '' && ${sail_to_dt} != '')" ).append("\n"); 
		query.append("         , VSK_VSL_PORT_SKD VSK_POL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${arr_from_dt} != '' && ${arr_to_dt} != '')" ).append("\n"); 
		query.append("         , VSK_VSL_PORT_SKD VSK_POD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     WHERE BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("       AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND BK.BKG_NO = ROUTE.BKG_NO" ).append("\n"); 
		query.append("       AND BK.BKG_NO = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("       AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("       AND BK.BKG_NO = COA.BKG_NO(+)" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
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
		query.append("       AND BK.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("       AND BK.BKG_NO = AK.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND AK.BKG_NO = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("       AND AK.CNTR_NO = CNTR.CNTR_NO(+)" ).append("\n"); 
		query.append("       AND NVL(AK.SPCL_CGO_APRO_CD,' ') <> 'C'" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND CNTR.BKG_NO = QTY.BKG_NO(+)" ).append("\n"); 
		query.append("       AND CNTR.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("	--===================================================================== 화면 조건절 start" ).append("\n"); 
		query.append("#if (${vvd_cd}!='' || ${pol_cd}!='' || ${pol_yard_cd}!='' || ${pod_cd}!='' || ${pod_yard_cd}!='' || ${sail_from_dt}!='' || ${sail_to_dt} != '' || ${arr_from_dt}!='' || ${arr_to_dt} != '') " ).append("\n"); 
		query.append(" #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("       AND VVD.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("  #if (${trunk_flag} != '')" ).append("\n"); 
		query.append("       AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pol_cd} != '') " ).append("\n"); 
		query.append("       AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("  #if (${pol_local} != '' && ${pol_ts} == '')" ).append("\n"); 
		query.append("       AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${pol_ts} != '' && ${pol_local} == '')" ).append("\n"); 
		query.append("       AND BK.POL_CD <> VVD.POL_CD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pol_yard_cd} != '') " ).append("\n"); 
		query.append("       AND SUBSTR(VVD.POL_YD_CD,-2) = @[pol_yard_cd]" ).append("\n"); 
		query.append("  #if (${pol_local} != '' && ${pol_ts} == '')" ).append("\n"); 
		query.append("    AND BK.POL_NOD_CD = VVD.POL_YD_CD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${pol_ts} != '' && ${pol_local} == '')" ).append("\n"); 
		query.append("       AND BK.POL_NOD_CD <> VVD.POL_YD_CD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pod_cd} != '') " ).append("\n"); 
		query.append("       AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("  #if (${pod_local} != '' && ${pod_ts} == '')" ).append("\n"); 
		query.append("       AND BK.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${pod_ts} != '' && ${pod_local} == '')" ).append("\n"); 
		query.append("       AND BK.POD_CD <> VVD.POD_CD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pod_yard_cd} != '') " ).append("\n"); 
		query.append("       AND SUBSTR(VVD.POD_YD_CD,-2) = @[pod_yard_cd]" ).append("\n"); 
		query.append("  #if (${pod_local} != '' && ${pod_ts} == '')" ).append("\n"); 
		query.append("       AND BK.POD_NOD_CD = VVD.POD_YD_CD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${pod_ts} != '' && ${pod_local} == '')" ).append("\n"); 
		query.append("       AND BK.POD_NOD_CD <> VVD.POD_YD_CD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${sail_from_dt} != '' && ${sail_to_dt} != '')" ).append("\n"); 
		query.append("       AND VSK_POL.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("       AND VSK_POL.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VSK_POL.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VSK_POL.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("       AND VSK_POL.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       AND VSK_POL.VPS_ETD_DT >= TO_DATE(@[sail_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("       AND VSK_POL.VPS_ETD_DT <= TO_DATE(@[sail_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${arr_from_dt} != '' && ${arr_to_dt} != '')" ).append("\n"); 
		query.append("       AND VSK_POD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("       AND VSK_POD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VSK_POD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VSK_POD.VPS_PORT_CD = VVD.POD_CD" ).append("\n"); 
		query.append("       AND VSK_POD.CLPT_IND_SEQ = VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       AND VSK_POD.VPS_ETD_DT >= TO_DATE(@[arr_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("       AND VSK_POD.VPS_ETD_DT <= TO_DATE(@[arr_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_from_dt} != '') " ).append("\n"); 
		query.append("	   AND BK.BKG_CRE_DT >= TO_DATE(@[bkg_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_to_dt} != '') " ).append("\n"); 
		query.append("	   AND BK.BKG_CRE_DT <= TO_DATE(@[bkg_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("       AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("       AND BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("       AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '') " ).append("\n"); 
		query.append("       AND BK.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_staff} != '' && ${bkg_staff_type} == 'ID')" ).append("\n"); 
		query.append("       AND BK.DOC_USR_ID = @[bkg_staff]" ).append("\n"); 
		query.append("#elseif (${bkg_staff} != '' && ${bkg_staff_type} == 'NAME')" ).append("\n"); 
		query.append("       AND (SELECT UPPER(USR_NM) FROM COM_USER WHERE USR_ID = BK.DOC_USR_ID) = @[bkg_staff]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_sts_cd_f} != '' || ${bkg_sts_cd_w} != '') " ).append("\n"); 
		query.append("       AND BK.BKG_STS_CD IN ( @[bkg_sts_cd_f], @[bkg_sts_cd_w]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${non_sp_cargo} != '') " ).append("\n"); 
		query.append("       AND BK.WT_RSN_SPCL_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${holding} != '') " ).append("\n"); 
		query.append("       AND BK.WT_RSN_HLD_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd2} != '') " ).append("\n"); 
		query.append("       AND BK.POR_CD LIKE @[por_cd2]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd2} != '') " ).append("\n"); 
		query.append("       AND BK.POL_CD LIKE @[pol_cd2]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd2} != '') " ).append("\n"); 
		query.append("       AND BK.POD_CD LIKE @[pod_cd2]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("       AND BK.DEL_CD LIKE @[del_cd2]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${r_term} != '') " ).append("\n"); 
		query.append("       AND BK.RCV_TERM_CD IN (${r_term})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${d_term} != '') " ).append("\n"); 
		query.append("       AND BK.DE_TERM_CD IN (${d_term})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '') " ).append("\n"); 
		query.append("       AND BK.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '') " ).append("\n"); 
		query.append("       AND COA.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sub_trd_cd} != '') " ).append("\n"); 
		query.append("       AND COA.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane_cd} != '') " ).append("\n"); 
		query.append("       AND BK.SLAN_CD = @[lane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_tp_cd_s} != '' || ${cust_tp_cd_c} != '' || ${cust_tp_cd_n} != '' || ${cust_tp_cd_f} != '' || ${cust_tp_cd_a} != '') " ).append("\n"); 
		query.append("       AND EXISTS (SELECT 'Y' FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("                    WHERE C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                    #if (${cust_cnt_cd} !='')                    " ).append("\n"); 
		query.append("                      AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${cust_seq} !='')                    " ).append("\n"); 
		query.append("                      AND C.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                      AND BKG_CUST_TP_CD IN ('',NVL(@[cust_tp_cd_s],''),NVL(@[cust_tp_cd_c],''),NVL(@[cust_tp_cd_n],''),NVL(@[cust_tp_cd_f],''),NVL(@[cust_tp_cd_a],''))" ).append("\n"); 
		query.append("                    #if (${cust_nm} !='')                    " ).append("\n"); 
		query.append("                      AND C.CUST_NM = @[cust_nm]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${cust_grp_id} !='')                    " ).append("\n"); 
		query.append("                      AND (SELECT CUST_GRP_ID FROM MDM_CUSTOMER M WHERE M.CUST_CNT_CD = B.CUST_CNT_CD AND M.CUST_SEQ = B.CUST_SEQ) = @[cust_grp_id]" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sc_rfa_gbn} == 'S') " ).append("\n"); 
		query.append(" #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("       AND BK.SC_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#elseif (${sc_rfa_gbn} == 'R') " ).append("\n"); 
		query.append(" #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("       AND BK.RFA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#elseif (${sc_rfa_gbn} == 'T') " ).append("\n"); 
		query.append(" #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("       AND BK.TAA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	--===================================================================== 화면 조건절 end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${orderby} == '') " ).append("\n"); 
		query.append("ORDER BY TEMP, BKG_NO, TO_NUMBER(AWK_CGO_SEQ)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY TEMP, ${orderby}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}