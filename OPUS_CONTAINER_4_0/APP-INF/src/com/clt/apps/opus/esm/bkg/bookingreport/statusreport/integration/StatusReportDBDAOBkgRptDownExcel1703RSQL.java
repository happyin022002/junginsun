/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOBkgRptDownExcel1703RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
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

public class StatusReportDBDAOBkgRptDownExcel1703RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRptDownExcel1703
	  * </pre>
	  */
	public StatusReportDBDAOBkgRptDownExcel1703RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOBkgRptDownExcel1703RSQL").append("\n"); 
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
		query.append("    ,'Cargo & Commodity' AS	GRS_WGT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	GRS_WGT_UT" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BKG_NO" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BKG_CRE_DT" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BKG_OFC_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	BKG_STS_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	SLS_OFC" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	CTRT_SREP_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	OB_SREP_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	CUST_RMK" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	VNDR_RMK" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	INT_RMK" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	SCC_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	SCC_NM" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	STWG_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS	STWG_DESC" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CGO_N" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CGO_TP" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CGO_WGT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CGO_WGT_UT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	TARE_WGT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	TARE_WGT_UT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	MEAS_QTY" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	MEAS_UT_CD" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	PCK_QTY" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	PCK_TP_CD" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CMDT_CD" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	CMDT_NM" ).append("\n"); 
		query.append("    ,'Container' AS	CNTR_NO" ).append("\n"); 
		query.append("    ,'Container' AS	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,'Container' AS	CNMV_STS_CD" ).append("\n"); 
		query.append("    ,'Container' AS	CNMV_STS_NMK" ).append("\n"); 
		query.append("    ,'Container' AS	CNTR_SEAL_NO" ).append("\n"); 
		query.append("    ,'Customer' AS	S_CUST_NM" ).append("\n"); 
		query.append("    ,'Customer' AS	F_CUST_NM" ).append("\n"); 
		query.append("    ,'Customer' AS	C_CUST_NM" ).append("\n"); 
		query.append("    ,'Customer' AS	CTRT_PTY_CD" ).append("\n"); 
		query.append("    ,'Customer' AS	CTRT_PTY_NM" ).append("\n"); 
		query.append("    ,'Reference No.' AS	BKG_REF" ).append("\n"); 
		query.append("    ,'Reference No' AS	BKSH_REF" ).append("\n"); 
		query.append("    ,'Reference No.' AS	ENS_MRN" ).append("\n"); 
		query.append("    ,'Reference No.' AS	CMRN_REF_NO" ).append("\n"); 
		query.append("    ,'Reference No.' AS	EXS_MRN" ).append("\n"); 
		query.append("    ,'Reference No' AS	INV_REF" ).append("\n"); 
		query.append("    ,'Reference No.' AS	REG_REF" ).append("\n"); 
		query.append("    ,'Reference No.' AS	FF_REF" ).append("\n"); 
		query.append("    ,'Reference No.' AS	SI_REF" ).append("\n"); 
		query.append("    ,'Reference No.' AS	SISH_REF" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	BLCK_STWG" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	RCV_TERM_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	DE_TERM_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRAF_MOD_OB" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRAF_MOD_IB" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POR_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POR_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POD_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	DEL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	DEL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	SLAN_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TVVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TVSL" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PRE_VSL" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POST_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	PST_VSL" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	N1ST_ETD_DT" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	LAST_ETA_DT" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	OC_DT" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	OP_DT" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	VL_DT" ).append("\n"); 
		query.append("    ,'Rate & Invoice' AS	RT_STS" ).append("\n"); 
		query.append("    ,'Rate & Invoice' AS	RFA_NO" ).append("\n"); 
		query.append("    ,'Rate & Invoice' AS	SC_NO" ).append("\n"); 
		query.append("    ,'Rate & Invoice' AS	TAA_NO" ).append("\n"); 
		query.append("    ,'DG Info' AS	DG_APRL_CD" ).append("\n"); 
		query.append("    ,'Reefer Info' AS	RF_CA" ).append("\n"); 
		query.append("    ,'Reefer Info' AS	RF_MA" ).append("\n"); 
		query.append("    ,'Reefer Info' AS	RF_TEMP" ).append("\n"); 
		query.append("    ,'Reefer Info' AS	VENT" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     '2' AS TEMP" ).append("\n"); 
		query.append("    ,'Gross Weight' AS	GRS_WGT" ).append("\n"); 
		query.append("    ,'Gross Weight Unit' AS	GRS_WGT_UT" ).append("\n"); 
		query.append("    ,'Booking Number' AS	BKG_NO" ).append("\n"); 
		query.append("    ,'Booking Date' AS	BKG_CRE_DT" ).append("\n"); 
		query.append("    ,'Booking Office' AS	BKG_OFC_CD" ).append("\n"); 
		query.append("    ,'Booking Status' AS	BKG_STS_CD" ).append("\n"); 
		query.append("    ,'Sales Office' AS	SLS_OFC" ).append("\n"); 
		query.append("    ,'C.SREP' AS	CTRT_SREP_CD" ).append("\n"); 
		query.append("    ,'L.SREP' AS	OB_SREP_CD" ).append("\n"); 
		query.append("    ,'Cust. Remark' AS	CUST_RMK" ).append("\n"); 
		query.append("    ,'Vndr. Remark' AS	VNDR_RMK" ).append("\n"); 
		query.append("    ,'Internal Remark' AS	INT_RMK" ).append("\n"); 
		query.append("    ,'SCC Code' AS	SCC_CD" ).append("\n"); 
		query.append("    ,'SCC Name' AS	SCC_NM" ).append("\n"); 
		query.append("    ,'Special Handling Instructions Type' AS	STWG_CD" ).append("\n"); 
		query.append("    ,'Special Handling Instructions Detail' AS	STWG_DESC" ).append("\n"); 
		query.append("    ,'Cargo Nature' AS	CGO_N" ).append("\n"); 
		query.append("    ,'Cargo Type' AS	CGO_TP" ).append("\n"); 
		query.append("    ,'Cargo Weight' AS	CGO_WGT" ).append("\n"); 
		query.append("    ,'Cargo Weight Unit' AS	CGO_WGT_UT" ).append("\n"); 
		query.append("    ,'Tare Weight' AS	TARE_WGT" ).append("\n"); 
		query.append("    ,'Tare Weight Unit' AS	TARE_WGT_UT" ).append("\n"); 
		query.append("    ,'Measure' AS	MEAS_QTY" ).append("\n"); 
		query.append("    ,'Measure Unit' AS	MEAS_UT_CD" ).append("\n"); 
		query.append("    ,'No. of Package' AS	PCK_QTY" ).append("\n"); 
		query.append("    ,'Package Unit' AS	PCK_TP_CD" ).append("\n"); 
		query.append("    ,'Commodity Code' AS	CMDT_CD" ).append("\n"); 
		query.append("    ,'Commodity Name' AS	CMDT_NM" ).append("\n"); 
		query.append("    ,'Container Number' AS	CNTR_NO" ).append("\n"); 
		query.append("    ,'Container Size Type' AS	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,'Container Movement Status' AS	CNMV_STS_CD" ).append("\n"); 
		query.append("    ,'Container Movement Status Description' AS	CNMV_STS_NMK" ).append("\n"); 
		query.append("    ,'Seal Number' AS	CNTR_SEAL_NO" ).append("\n"); 
		query.append("    ,'Shipper' AS	S_CUST_NM" ).append("\n"); 
		query.append("    ,'Forwarder' AS	F_CUST_NM" ).append("\n"); 
		query.append("    ,'Consignee' AS	C_CUST_NM" ).append("\n"); 
		query.append("    ,'Contract Party Code' AS	CTRT_PTY_CD" ).append("\n"); 
		query.append("    ,'Contract Party Name' AS	CTRT_PTY_NM" ).append("\n"); 
		query.append("    ,'BKG Ref. No.' AS	BKG_REF" ).append("\n"); 
		query.append("    ,'BKG SH Ref. No.' AS	BKSH_REF" ).append("\n"); 
		query.append("    ,'ENS MRN' AS	ENS_MRN" ).append("\n"); 
		query.append("    ,'Export MRN No.' AS	CMRN_REF_NO" ).append("\n"); 
		query.append("    ,'EXS MRN' AS	EXS_MRN" ).append("\n"); 
		query.append("    ,'Invoice Ref. No.' AS	INV_REF" ).append("\n"); 
		query.append("    ,'Regional BKG No.' AS	REG_REF" ).append("\n"); 
		query.append("    ,'SI FF Ref. No.' AS	FF_REF" ).append("\n"); 
		query.append("    ,'SI Ref. No.' AS	SI_REF" ).append("\n"); 
		query.append("    ,'SI SH Ref. No.' AS	SISH_REF" ).append("\n"); 
		query.append("    ,'Block Stowage' AS	BLCK_STWG" ).append("\n"); 
		query.append("    ,'Receiving Term' AS	RCV_TERM_CD" ).append("\n"); 
		query.append("    ,'Delivery Term' AS	DE_TERM_CD" ).append("\n"); 
		query.append("    ,'Traffic Mode OB' AS	TRAF_MOD_OB" ).append("\n"); 
		query.append("    ,'Traffic Mode IB' AS	TRAF_MOD_IB" ).append("\n"); 
		query.append("    ,'POR Code' AS	POR_CD" ).append("\n"); 
		query.append("    ,'POR Name' AS	POR_NM" ).append("\n"); 
		query.append("    ,'POL Code' AS	POL_CD" ).append("\n"); 
		query.append("    ,'POL Name' AS	POL_NM" ).append("\n"); 
		query.append("    ,'POD Code' AS	POD_CD" ).append("\n"); 
		query.append("    ,'POD Name' AS	POD_NM" ).append("\n"); 
		query.append("    ,'DEL Code' AS	DEL_CD" ).append("\n"); 
		query.append("    ,'DEL Name' AS	DEL_NM" ).append("\n"); 
		query.append("    ,'MTY CNTR Pick Up CY' AS	MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("    ,'Trade Code' AS	TRD_CD" ).append("\n"); 
		query.append("    ,'Trunk Lane' AS	SLAN_CD" ).append("\n"); 
		query.append("    ,'Trunk VVD' AS	TVVD" ).append("\n"); 
		query.append("    ,'Trunk Vessel' AS	TVSL" ).append("\n"); 
		query.append("    ,'Pre VVD' AS	PRE_VVD" ).append("\n"); 
		query.append("    ,'Pre Vessel' AS	PRE_VSL" ).append("\n"); 
		query.append("    ,'Post VVD' AS	POST_VVD" ).append("\n"); 
		query.append("    ,'Post Vessel' AS	PST_VSL" ).append("\n"); 
		query.append("    ,'ETD from First POL' AS	N1ST_ETD_DT" ).append("\n"); 
		query.append("    ,'ETA at Last POD' AS	LAST_ETA_DT" ).append("\n"); 
		query.append("    ,'OC Date/Time' AS	OC_DT" ).append("\n"); 
		query.append("    ,'OP Date/Time' AS	OP_DT" ).append("\n"); 
		query.append("    ,'VL Date/Time' AS	VL_DT" ).append("\n"); 
		query.append("    ,'Rating Status' AS	RT_STS" ).append("\n"); 
		query.append("    ,'RFA No.' AS	RFA_NO" ).append("\n"); 
		query.append("    ,'S/C No.' AS	SC_NO" ).append("\n"); 
		query.append("    ,'Tariff No.' AS	TAA_NO" ).append("\n"); 
		query.append("    ,'DG Approval Code' AS	DG_APRL_CD" ).append("\n"); 
		query.append("    ,'CA' AS	RF_CA" ).append("\n"); 
		query.append("    ,'MA' AS	RF_MA" ).append("\n"); 
		query.append("    ,'RF Temperature' AS	RF_TEMP" ).append("\n"); 
		query.append("    ,'RF Ventilation' AS	VENT" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     '3' AS TEMP" ).append("\n"); 
		query.append("     ,DECODE(CGO_WGT_UT,'KGS'," ).append("\n"); 
		query.append("                           TRIM(TO_CHAR(TO_NUMBER(NVL(CGO_WGT,0),'999,999,999,990.99')+TO_NUMBER(NVL(TARE_WGT,0),'999,999,999,990.99'),'999,999,999,990.99'))," ).append("\n"); 
		query.append("                         'LBS'," ).append("\n"); 
		query.append("                           TRIM(TO_CHAR(TO_NUMBER(NVL(CGO_WGT,0),'999,999,999,990.99')+ROUND(TO_NUMBER(NVL(TARE_WGT,0),'999,999,999,990.99') / 0.453592,2),'999,999,999,990.99'))" ).append("\n"); 
		query.append("             ) AS GRS_WGT" ).append("\n"); 
		query.append("     ,CGO_WGT_UT AS GRS_WGT_UT" ).append("\n"); 
		query.append("     ,BKG_Z.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("--Cargo & Commodity" ).append("\n"); 
		query.append("         BK.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(BK.BKG_CRE_DT,'YYYY-MM-DD HH24:MI') AS BKG_CRE_DT" ).append("\n"); 
		query.append("        ,BK.BKG_OFC_CD AS BKG_OFC_CD" ).append("\n"); 
		query.append("        ,BK.BKG_STS_CD AS BKG_STS_CD" ).append("\n"); 
		query.append("        ,BK.OB_SLS_OFC_CD AS SLS_OFC" ).append("\n"); 
		query.append("        ,BK.CTRT_SREP_CD AS CTRT_SREP_CD" ).append("\n"); 
		query.append("        ,BK.OB_SREP_CD" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(REPLACE(BK.XTER_RMK,CHR(10),' '),CHR(9),' '),CHR(34),'') AS CUST_RMK" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(REPLACE(BK.VNDR_RMK,CHR(10),' '),CHR(9),' '),CHR(34),'') AS VNDR_RMK" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(REPLACE(BK.INTER_RMK,CHR(10),' '),CHR(9),' '),CHR(34),'') AS INT_RMK" ).append("\n"); 
		query.append("        ,(SELECT OFC_CD FROM MDM_YARD M WHERE M.YD_CD = BK.MTY_PKUP_YD_CD) AS SCC_CD" ).append("\n"); 
		query.append("        ,(SELECT O.OFC_ENG_NM FROM MDM_YARD M, MDM_ORGANIZATION O WHERE M.YD_CD = BK.MTY_PKUP_YD_CD AND M.OFC_CD = O.OFC_CD) AS SCC_NM" ).append("\n"); 
		query.append("        ,BK.STWG_CD AS STWG_CD" ).append("\n"); 
		query.append("        ,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02146' AND INTG_CD_VAL_CTNT = BK.STWG_CD) AS STWG_DESC" ).append("\n"); 
		query.append("        ,NVL(DECODE(BK.DCGO_FLG,'Y','DG',NULL)||DECODE(BK.RC_FLG,'Y','RF',NULL)||DECODE(BK.AWK_CGO_FLG,'Y','AW',NULL)||DECODE(BK.RD_CGO_FLG,'Y','RAD',NULL),'GC') AS CGO_N" ).append("\n"); 
		query.append("        ,DECODE(BK.BKG_CGO_TP_CD, 'P', 'M', 'F') AS CGO_TP" ).append("\n"); 
		query.append("        ,TRIM(TO_CHAR(BC.CNTR_WGT,'999,999,999,990.99')) AS CGO_WGT" ).append("\n"); 
		query.append("        ,BC.WGT_UT_CD AS CGO_WGT_UT" ).append("\n"); 
		query.append("        ,NVL((SELECT TRIM(TO_CHAR(ROUND(B.TARE_WGT,1),'999,999,999,990.99'))" ).append("\n"); 
		query.append("                FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                    ,MST_CNTR_SPEC B" ).append("\n"); 
		query.append("               WHERE A.CNTR_SPEC_NO = B.CNTR_SPEC_NO" ).append("\n"); 
		query.append("                 AND A.CNTR_NO = BC.CNTR_NO)" ).append("\n"); 
		query.append("           , (SELECT TRIM(TO_CHAR(ROUND(CNTR_TPSZ_TARE_WGT,1),'999,999,999,990.99'))" ).append("\n"); 
		query.append("                FROM MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("               WHERE MDM.CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("         ) AS TARE_WGT" ).append("\n"); 
		query.append("        ,'KGS' AS TARE_WGT_UT" ).append("\n"); 
		query.append("        ,TO_CHAR(BC.MEAS_QTY) AS MEAS_QTY" ).append("\n"); 
		query.append("        ,BC.MEAS_UT_CD AS MEAS_UT_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(BC.PCK_QTY) AS PCK_QTY" ).append("\n"); 
		query.append("        ,BC.PCK_TP_CD AS PCK_TP_CD" ).append("\n"); 
		query.append("        ,DECODE(SUBSTR(BK.CMDT_CD,1,1),0,'''','')||BK.CMDT_CD AS CMDT_CD" ).append("\n"); 
		query.append("        ,(SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = BK.CMDT_CD) AS CMDT_NM" ).append("\n"); 
		query.append("--Container" ).append("\n"); 
		query.append("        ,BC.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("        ,BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	    ,DECODE(BK.BKG_STS_CD,'X',''," ).append("\n"); 
		query.append("				DECODE((SELECT COP.COP_STS_CD FROM SCE_COP_HDR COP WHERE COP.BKG_NO = BC.BKG_NO AND COP.CNTR_NO = BC.CNTR_NO AND COP.COP_STS_CD <> 'X'),'F','MT'," ).append("\n"); 
		query.append("						(SELECT B.CNMV_STS_CD FROM MST_CONTAINER B WHERE B.CNTR_NO = BC.CNTR_NO))) CNMV_STS_CD" ).append("\n"); 
		query.append("		,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL CD_DTL WHERE CD_DTL.INTG_CD_ID = 'CD00252' " ).append("\n"); 
		query.append("                                                                AND CD_DTL.INTG_CD_VAL_CTNT=(DECODE(BK.BKG_STS_CD,'X',''," ).append("\n"); 
		query.append("				                                                                                DECODE((SELECT COP.COP_STS_CD FROM SCE_COP_HDR COP WHERE COP.BKG_NO = BC.BKG_NO AND COP.CNTR_NO = BC.CNTR_NO AND COP.COP_STS_CD <> 'X'),'F','MT'," ).append("\n"); 
		query.append("						                                                                            (SELECT B.CNMV_STS_CD FROM MST_CONTAINER B WHERE B.CNTR_NO = BC.CNTR_NO))))) AS CNMV_STS_NMK" ).append("\n"); 
		query.append("        ,BKG_JOIN_FNC(CURSOR(SELECT CNTR_SEAL_NO " ).append("\n"); 
		query.append("                             FROM BKG_CNTR_SEAL_NO " ).append("\n"); 
		query.append("                             WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                               AND CNTR_NO = BC.CNTR_NO " ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                      ) AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("--Customer" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(REPLACE(S.CUST_NM,CHR(10), ' '),CHR(9),' '),CHR(34),'') AS S_CUST_NM" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(REPLACE(F.CUST_NM,CHR(10), ' '),CHR(9),' '),CHR(34),'') AS F_CUST_NM" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(REPLACE(C.CUST_NM,CHR(10), ' '),CHR(9),' '),CHR(34),'') AS C_CUST_NM" ).append("\n"); 
		query.append("        ,BKG_CTRL_PTY_CUST_CNT_CD||LPAD(BK.BKG_CTRL_PTY_CUST_SEQ,6,'0') AS CTRT_PTY_CD" ).append("\n"); 
		query.append("        ,(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = BK.BKG_CTRL_PTY_CUST_CNT_CD AND CUST_SEQ = BK.BKG_CTRL_PTY_CUST_SEQ) AS CTRT_PTY_NM" ).append("\n"); 
		query.append("--Reference No." ).append("\n"); 
		query.append("        ,RF1.CUST_REF_NO_CTNT  AS BKG_REF" ).append("\n"); 
		query.append("        ,RF2.CUST_REF_NO_CTNT  AS BKSH_REF" ).append("\n"); 
		query.append("        ,BKG_JOIN_FNC(CURSOR(SELECT EUR_BL.MVMT_REF_NO" ).append("\n"); 
		query.append("		 					   FROM BKG_CSTMS_EUR_BL EUR_BL" ).append("\n"); 
		query.append("							  WHERE BK.BL_NO = EUR_BL.BL_NO),';') AS ENS_MRN" ).append("\n"); 
		query.append("        ,DECODE(BC.CNTR_NO, NULL, " ).append("\n"); 
		query.append("                              BKG_JOIN_FNC(CURSOR(SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("                                                    FROM BKG_REFERENCE CUCR" ).append("\n"); 
		query.append("                                                   WHERE CUCR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                     AND CUCR.BKG_REF_TP_CD = 'CMRN'" ).append("\n"); 
		query.append("                                                   ORDER BY CUCR.REF_SEQ" ).append("\n"); 
		query.append("                                                  ),',')," ).append("\n"); 
		query.append("                              (SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("                                 FROM BKG_REFERENCE CUCR" ).append("\n"); 
		query.append("                                WHERE CUCR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                  AND CUCR.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                                  AND CUCR.BKG_REF_TP_CD = 'CMRN')) AS CMRN_REF_NO" ).append("\n"); 
		query.append("        ,BKG_JOIN_FNC(CURSOR(SELECT EX_EUR_BL.MVMT_REF_NO" ).append("\n"); 
		query.append("							 FROM BKG_CSTMS_EUR_IO_BL EX_EUR_BL" ).append("\n"); 
		query.append("							WHERE BK.BL_NO = EX_EUR_BL.BL_NO),';') AS EXS_MRN" ).append("\n"); 
		query.append("        ,RF4.CUST_REF_NO_CTNT  AS INV_REF" ).append("\n"); 
		query.append("        ,RF5.CUST_REF_NO_CTNT  AS REG_REF" ).append("\n"); 
		query.append("        ,RF6.CUST_REF_NO_CTNT  AS FF_REF" ).append("\n"); 
		query.append("        ,RF7.CUST_REF_NO_CTNT  AS SI_REF" ).append("\n"); 
		query.append("        ,RF8.CUST_REF_NO_CTNT  AS SISH_REF" ).append("\n"); 
		query.append("--Route & Schedule" ).append("\n"); 
		query.append("        ,BLCK_STWG_CD AS BLCK_STWG" ).append("\n"); 
		query.append("        ,BK.RCV_TERM_CD AS RCV_TERM_CD" ).append("\n"); 
		query.append("        ,BK.DE_TERM_CD AS DE_TERM_CD" ).append("\n"); 
		query.append("        ,DECODE(BK.RCV_TERM_CD,'S','LCL','FCL') AS TRAF_MOD_OB" ).append("\n"); 
		query.append("        ,DECODE(BK.DE_TERM_CD,'S','LCL','FCL') AS TRAF_MOD_IB" ).append("\n"); 
		query.append("        ,BK.POR_CD" ).append("\n"); 
		query.append("        ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.POR_CD) AS POR_NM" ).append("\n"); 
		query.append("        ,BK.POL_CD" ).append("\n"); 
		query.append("        ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.POL_CD) AS POL_NM" ).append("\n"); 
		query.append("        ,BK.POD_CD" ).append("\n"); 
		query.append("        ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.POD_CD) AS POD_NM" ).append("\n"); 
		query.append("        ,BK.DEL_CD" ).append("\n"); 
		query.append("        ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD) AS DEL_NM" ).append("\n"); 
		query.append("--        ,BK.MTY_PKUP_YD_CD AS MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("        ,(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/D.NOD_CD" ).append("\n"); 
		query.append("              FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                   SCE_COP_DTL D," ).append("\n"); 
		query.append("                   SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("             WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("               AND H.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("               AND H.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("               AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("               AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("               AND MPG.ACT_STS_MAPG_CD = 'OP'" ).append("\n"); 
		query.append("               AND ROWNUM=1" ).append("\n"); 
		query.append("         ) MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("        ,COA.TRD_CD" ).append("\n"); 
		query.append("        ,BK.SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append("        ,BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD AS TVVD" ).append("\n"); 
		query.append("        ,(SELECT M.VSL_ENG_NM FROM MDM_VSL_CNTR M WHERE M.VSL_CD = BK.VSL_CD ) AS TVSL" ).append("\n"); 
		query.append("        ,PRE.VSL_CD||PRE.SKD_VOY_NO||PRE.SKD_DIR_CD AS PRE_VVD" ).append("\n"); 
		query.append("        ,(SELECT M.VSL_ENG_NM FROM MDM_VSL_CNTR M WHERE M.VSL_CD = PRE.VSL_CD ) AS PRE_VSL" ).append("\n"); 
		query.append("        ,PST.VSL_CD||PST.SKD_VOY_NO||PST.SKD_DIR_CD AS POST_VVD" ).append("\n"); 
		query.append("        ,(SELECT M.VSL_ENG_NM FROM MDM_VSL_CNTR M WHERE M.VSL_CD = PST.VSL_CD ) AS PST_VSL" ).append("\n"); 
		query.append("        ,TO_CHAR(N1ST_SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') AS N1ST_ETD_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(LAST_SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') AS LAST_ETA_DT" ).append("\n"); 
		query.append("        ,(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/NVL(TO_CHAR(D.ACT_DT,'YYYY-MM-DD HH24:MI'),TO_CHAR(D.ESTM_DT,'YYYY-MM-DD HH24:MI'))" ).append("\n"); 
		query.append("              FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                   SCE_COP_DTL D," ).append("\n"); 
		query.append("                   SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("             WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("               AND H.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("               AND H.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("               AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("               AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("               AND MPG.ACT_STS_MAPG_CD = 'OC'" ).append("\n"); 
		query.append("               AND ROWNUM=1" ).append("\n"); 
		query.append("         ) OC_DT" ).append("\n"); 
		query.append("        ,(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/NVL(TO_CHAR(D.ACT_DT,'YYYY-MM-DD HH24:MI'),TO_CHAR(D.ESTM_DT,'YYYY-MM-DD HH24:MI'))" ).append("\n"); 
		query.append("              FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                   SCE_COP_DTL D," ).append("\n"); 
		query.append("                   SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("             WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("               AND H.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("               AND H.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("               AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("               AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("               AND MPG.ACT_STS_MAPG_CD = 'OP'" ).append("\n"); 
		query.append("               AND ROWNUM=1" ).append("\n"); 
		query.append("         ) OP_DT" ).append("\n"); 
		query.append("        ,(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/NVL(TO_CHAR(D.ACT_DT,'YYYY-MM-DD HH24:MI'),TO_CHAR(D.ESTM_DT,'YYYY-MM-DD HH24:MI'))" ).append("\n"); 
		query.append("              FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                   SCE_COP_DTL D," ).append("\n"); 
		query.append("                   SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("             WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("               AND H.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("               AND H.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("               AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("               AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("               AND MPG.ACT_STS_MAPG_CD = 'VL'" ).append("\n"); 
		query.append("               AND ROWNUM=1" ).append("\n"); 
		query.append("         ) VL_DT" ).append("\n"); 
		query.append("--Rate & Invoice" ).append("\n"); 
		query.append("        ,NVL((SELECT 'Y' FROM BKG_CHG_RT WHERE BKG_NO = BK.BKG_NO AND ROWNUM =1 ),'N') AS RT_STS" ).append("\n"); 
		query.append("        ,BK.RFA_NO" ).append("\n"); 
		query.append("        ,BK.SC_NO" ).append("\n"); 
		query.append("        ,BK.TAA_NO" ).append("\n"); 
		query.append("--DG Info" ).append("\n"); 
		query.append("        ,(SELECT SPCL_CGO_APRO_CD FROM BKG_DG_CGO WHERE BKG_NO = BK.BKG_NO AND ROWNUM =1 ) AS DG_APRL_CD" ).append("\n"); 
		query.append("--Reefer Info" ).append("\n"); 
		query.append("        ,RF.CTRL_ATMS_FLG AS RF_CA" ).append("\n"); 
		query.append("        ,RF.MODI_ATMS_FLG AS RF_MA" ).append("\n"); 
		query.append("        ,TO_CHAR(RF.CDO_TEMP) AS RF_TEMP" ).append("\n"); 
		query.append("        ,DECODE(RF.CNTR_VENT_TP_CD,'P',RF.VENT_RTO||'%',RF.CBM_PER_HR_QTY||'CMH') AS VENT" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("           BKG_VVD VVD,--KEY" ).append("\n"); 
		query.append("           BKG_BL_DOC BL," ).append("\n"); 
		query.append("           BKG_CONTAINER BC," ).append("\n"); 
		query.append("           BKG_CUSTOMER S," ).append("\n"); 
		query.append("           BKG_CUSTOMER C," ).append("\n"); 
		query.append("           BKG_CUSTOMER F," ).append("\n"); 
		query.append("           BKG_RF_CGO RF," ).append("\n"); 
		query.append("           BKG_REFERENCE RF1," ).append("\n"); 
		query.append("           BKG_REFERENCE RF2," ).append("\n"); 
		query.append("           BKG_REFERENCE RF4," ).append("\n"); 
		query.append("           BKG_REFERENCE RF5," ).append("\n"); 
		query.append("           BKG_REFERENCE RF6," ).append("\n"); 
		query.append("           BKG_REFERENCE RF7," ).append("\n"); 
		query.append("           BKG_REFERENCE RF8," ).append("\n"); 
		query.append("           BKG_VVD PRE," ).append("\n"); 
		query.append("           BKG_VVD PST," ).append("\n"); 
		query.append("           BKG_VVD N1ST_VVD," ).append("\n"); 
		query.append("           BKG_VVD LAST_VVD," ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD N1ST_SKD," ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD LAST_SKD," ).append("\n"); 
		query.append("           COA_RGST_BKG COA" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("    AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("    AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("    AND BC.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("    AND BC.CNTR_NO = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("    AND BK.BKG_NO = COA.BKG_NO(+)" ).append("\n"); 
		query.append("    AND BK.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("    AND S.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("    AND BK.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("    AND C.BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("    AND BK.BKG_NO = F.BKG_NO" ).append("\n"); 
		query.append("    AND F.BKG_CUST_TP_CD ='F'" ).append("\n"); 
		query.append("    AND BK.BKG_NO = RF1.BKG_NO(+)" ).append("\n"); 
		query.append("    AND 'EBRF' = RF1.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("    AND BK.BKG_NO = RF2.BKG_NO(+)" ).append("\n"); 
		query.append("    AND 'EBSH' = RF2.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("    AND BK.BKG_NO = RF4.BKG_NO(+)" ).append("\n"); 
		query.append("    AND 'FINV' = RF4.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("    AND BK.BKG_NO = RF5.BKG_NO(+)" ).append("\n"); 
		query.append("    AND 'RGBK' = RF5.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("    AND BK.BKG_NO = RF6.BKG_NO(+)" ).append("\n"); 
		query.append("    AND 'ESFF' = RF6.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("    AND BK.BKG_NO = RF7.BKG_NO(+)" ).append("\n"); 
		query.append("    AND 'ESRF' = RF7.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("    AND BK.BKG_NO = RF8.BKG_NO(+)" ).append("\n"); 
		query.append("    AND 'ESSH' = RF8.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("    AND BK.BKG_NO         = PRE.BKG_NO(+)					" ).append("\n"); 
		query.append("    AND 'S'               = PRE.VSL_PRE_PST_CD(+)					" ).append("\n"); 
		query.append("    AND BK.PRE_RLY_PORT_CD= PRE.POD_CD(+)					" ).append("\n"); 
		query.append("    AND BK.BKG_NO         = PST.BKG_NO(+)					" ).append("\n"); 
		query.append("    AND 'U'               = PST.VSL_PRE_PST_CD(+)	" ).append("\n"); 
		query.append("    AND BK.PST_RLY_PORT_CD= PST.POL_CD(+)					" ).append("\n"); 
		query.append("    AND (N1ST_VVD.BKG_NO, N1ST_VVD.VSL_PRE_PST_CD, N1ST_VVD.VSL_SEQ) " ).append("\n"); 
		query.append("                     = (SELECT /*+ index(v2 xpkbkg_vvd) */ " ).append("\n"); 
		query.append("                                V2.BKG_NO, V2.VSL_PRE_PST_CD, V2.VSL_SEQ" ).append("\n"); 
		query.append("                          FROM BKG_VVD V2" ).append("\n"); 
		query.append("                         WHERE V2.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                           AND ROWNUM = 1)" ).append("\n"); 
		query.append("    AND (LAST_VVD.BKG_NO, LAST_VVD.VSL_PRE_PST_CD, LAST_VVD.VSL_SEQ) " ).append("\n"); 
		query.append("                     = (SELECT /*+ index_desc(v2 xpkbkg_vvd) */ " ).append("\n"); 
		query.append("                                V2.BKG_NO, V2.VSL_PRE_PST_CD, V2.VSL_SEQ" ).append("\n"); 
		query.append("                          FROM BKG_VVD V2" ).append("\n"); 
		query.append("                         WHERE V2.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                           AND ROWNUM = 1)" ).append("\n"); 
		query.append("    AND N1ST_VVD.VSL_CD     = N1ST_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("    AND N1ST_VVD.SKD_VOY_NO = N1ST_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND N1ST_VVD.SKD_DIR_CD = N1ST_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND N1ST_VVD.POL_CD     = N1ST_SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("    AND N1ST_VVD.POL_CLPT_IND_SEQ = N1ST_SKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("    AND LAST_VVD.VSL_CD     = LAST_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("    AND LAST_VVD.SKD_VOY_NO = LAST_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND LAST_VVD.SKD_DIR_CD = LAST_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND LAST_VVD.POD_CD     = LAST_SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("    AND LAST_VVD.POD_CLPT_IND_SEQ = LAST_SKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("	--===================================================================== 화면 조건절 start" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("    AND VVD.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("    AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("    AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#if (${trunk_flag} != '')" ).append("\n"); 
		query.append("    AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane_cd} != '') " ).append("\n"); 
		query.append("    AND VVD.SLAN_CD = @[lane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '') " ).append("\n"); 
		query.append("    AND VVD.SKD_DIR_CD IN (@[dir_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("    AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#if (${pol_local} != '')" ).append("\n"); 
		query.append("    AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_ts} != '')" ).append("\n"); 
		query.append("    AND BK.POL_CD <> VVD.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_yard_cd} != '') " ).append("\n"); 
		query.append("    AND SUBSTR(VVD.POL_YD_CD,-2) = @[pol_yard_cd]" ).append("\n"); 
		query.append("#if (${pol_local} != '')" ).append("\n"); 
		query.append("    AND BK.POL_NOD_CD = VVD.POL_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_ts} != '')" ).append("\n"); 
		query.append("    AND BK.POL_NOD_CD <> VVD.POL_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("    AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#if (${pod_local} != '')" ).append("\n"); 
		query.append("    AND BK.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_ts} != '')" ).append("\n"); 
		query.append("    AND BK.POD_CD <> VVD.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_yard_cd} != '') " ).append("\n"); 
		query.append("    AND SUBSTR(VVD.POD_YD_CD,-2) = @[pod_yard_cd]" ).append("\n"); 
		query.append("#if (${pod_local} != '')" ).append("\n"); 
		query.append("    AND BK.POD_NOD_CD = VVD.POD_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_ts} != '')" ).append("\n"); 
		query.append("    AND BK.POD_NOD_CD <> VVD.POD_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("    AND BK.POR_CD LIKE @[por_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("    AND BK.DEL_CD LIKE @[del_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${r_term} != '') " ).append("\n"); 
		query.append("    AND BK.RCV_TERM_CD IN (${r_term})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${d_term} != '') " ).append("\n"); 
		query.append("    AND BK.DE_TERM_CD IN (${d_term})" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} != '') " ).append("\n"); 
		query.append("    AND BK.BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_type} != '') " ).append("\n"); 
		query.append("    AND EXISTS  ( SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                   WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                     AND CNTR_TPSZ_CD IN (${eq_type})" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("    AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("    AND BK.BKG_STS_CD IN (${bkg_sts_cd})" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	--===================================================================== 화면 조건절 end" ).append("\n"); 
		query.append("       ) BKG_Z" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${ecc_cd} != '')" ).append("\n"); 
		query.append("AND SCC_CD = @[ecc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${orderby} == '') " ).append("\n"); 
		query.append("ORDER BY TEMP, BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY TEMP, ${orderby}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}