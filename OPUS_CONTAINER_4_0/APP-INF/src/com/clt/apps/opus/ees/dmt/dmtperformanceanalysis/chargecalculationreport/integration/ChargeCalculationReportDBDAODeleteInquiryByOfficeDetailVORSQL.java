/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationReportDBDAODeleteInquiryByOfficeDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.03.19 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationReportDBDAODeleteInquiryByOfficeDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Delete Charge 의 Detail 정보를 조회한다
	  * </pre>
	  */
	public ChargeCalculationReportDBDAODeleteInquiryByOfficeDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration").append("\n"); 
		query.append("FileName : ChargeCalculationReportDBDAODeleteInquiryByOfficeDetailVORSQL").append("\n"); 
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
		query.append("C.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(",C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",C.OFC_CD" ).append("\n"); 
		query.append(",C.OFC_RHQ_CD" ).append("\n"); 
		query.append(",DECODE(C.DMDT_CHG_DELT_RSN_CD, 'OTH', 'Other', R.INTG_CD_VAL_DP_DESC) DELT_RSN_DESC" ).append("\n"); 
		query.append(",C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",C.FT_DYS" ).append("\n"); 
		query.append(",C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",TO_CHAR(C.FM_MVMT_DT, 'YYYYMMDD') FM_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.FT_CMNC_DT, 'YYYYMMDD') FT_CMNC_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.FT_END_DT, 'YYYYMMDD') FT_END_DT" ).append("\n"); 
		query.append(",C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",C.ORG_CHG_AMT" ).append("\n"); 
		query.append(",C.SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append(",C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",C.BIL_AMT" ).append("\n"); 
		query.append(",B.BKG_NO" ).append("\n"); 
		query.append(",B.BL_NO" ).append("\n"); 
		query.append(",B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append(",(	SELECT	V.VSL_SLAN_CD LANE" ).append("\n"); 
		query.append("FROM	VSK_VSL_SKD V" ).append("\n"); 
		query.append("WHERE	B.VSL_CD		=	V.VSL_CD" ).append("\n"); 
		query.append("AND		B.SKD_VOY_NO	=	V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND		B.SKD_DIR_CD	=	V.SKD_DIR_CD" ).append("\n"); 
		query.append(") AS LANE" ).append("\n"); 
		query.append(",B.POR_CD" ).append("\n"); 
		query.append(",B.POL_CD" ).append("\n"); 
		query.append(",B.POD_CD" ).append("\n"); 
		query.append(",B.DEL_CD" ).append("\n"); 
		query.append(",B.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",B.BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",B.SC_NO" ).append("\n"); 
		query.append(",B.RFA_NO" ).append("\n"); 
		query.append(",DECODE(C.CHG_SEQ, 1, 'G', 'B') AS CHG_TYPE" ).append("\n"); 
		query.append(",C.CHG_SEQ" ).append("\n"); 
		query.append(",NVL(B.SOC_FLG, 'N') AS SOC_FLG" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD='ID' THEN 'L'" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD NOT IN ('ID','CS','DR') THEN 'I'" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD<>'POL' THEN 'L'" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD='POL' THEN 'I'" ).append("\n"); 
		query.append("END AS LI" ).append("\n"); 
		query.append(",(	SELECT NVL(HLG_TP_CD, 'N')" ).append("\n"); 
		query.append("FROM	BKG_EUR_TRO" ).append("\n"); 
		query.append("WHERE	BKG_NO				= B.BKG_NO" ).append("\n"); 
		query.append("AND	IO_BND_CD			= SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("AND	NVL(CXL_FLG, 'N')	= 'N'" ).append("\n"); 
		query.append("AND	CNTR_NO	= C.CNTR_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") AS CH" ).append("\n"); 
		query.append(",(	SELECT 'Y'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("SELECT BDD.RLSE_STS_CD" ).append("\n"); 
		query.append("FROM BKG_DO_DTL BDD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BDD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND BDD.RLSE_STS_CD IN ('R', 'I') )" ).append("\n"); 
		query.append(") AS D_O" ).append("\n"); 
		query.append(",NVL(C.OFC_TRNS_FLG, 'N') AS OFC_TRNS_FLG" ).append("\n"); 
		query.append(",(	SELECT 'S'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("SELECT 1" ).append("\n"); 
		query.append("FROM	BKG_ROLL_OVR R" ).append("\n"); 
		query.append("WHERE	R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND R.ROLL_OVR_RSN_CD = 'S')" ).append("\n"); 
		query.append(") AS ROLL_OVR" ).append("\n"); 
		query.append(",C.CNTR_CYC_NO" ).append("\n"); 
		query.append(",C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",C.CORR_RMK" ).append("\n"); 
		query.append(",DECODE( DECODE(C.ACT_CNT_CD,'00','',C.ACT_CNT_CD) || TO_CHAR(C.ACT_CUST_SEQ, 'FM000000')" ).append("\n"); 
		query.append(",'000000' , NULL, DECODE(C.ACT_CNT_CD,'00','',C.ACT_CNT_CD) || TO_CHAR(C.ACT_CUST_SEQ, 'FM000000')) AS PAYER_CD" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD='DTIC' AND B.BKG_DE_TERM_CD='Y' AND INSTR(NVL(B.POD_CD,'  '),'US')=1 THEN" ).append("\n"); 
		query.append("(	SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE MV.VNDR_SEQ = C.VNDR_SEQ	)" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD='DTOC' AND B.BKG_RCV_TERM_CD='Y' AND INSTR(NVL(B.POL_CD,'  '),'US')=1 THEN" ).append("\n"); 
		query.append("(	SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE MV.VNDR_SEQ = C.VNDR_SEQ	)" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD IN ('DMIF','CTIC') OR (C.DMDT_TRF_CD='DTIC' AND INSTR(NVL(B.POD_CD,'  '),'US')<>1) THEN" ).append("\n"); 
		query.append("(	SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE MC.CUST_CNT_CD = C.ACT_CNT_CD" ).append("\n"); 
		query.append("AND MC.CUST_SEQ = C.ACT_CUST_SEQ	)" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD IN ('DMOF','CTOC') OR (C.DMDT_TRF_CD='DTOC' AND INSTR(NVL(B.POL_CD,'  '),'US')<>1) THEN" ).append("\n"); 
		query.append("REPLACE(BS.CUST_NM, CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("END AS PAYER_NM" ).append("\n"); 
		query.append(",BS.CUST_CNT_CD || TRIM(TO_CHAR(BS.CUST_SEQ, '000000')) SHIPPER_CD" ).append("\n"); 
		query.append(",REPLACE(BS.CUST_NM, CHR(13) || CHR(10), ' ') SHIPPER_NM" ).append("\n"); 
		query.append(",DECODE(BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000')), '000000', NULL, BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000'))) CNEE_CD" ).append("\n"); 
		query.append(",REPLACE(BC.CUST_NM, CHR(13) || CHR(10), ' ') CNEE_NM" ).append("\n"); 
		query.append(",DECODE(BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000')), '000000', NULL, BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000'))) NTFY_CD" ).append("\n"); 
		query.append(",NVL(RTRIM(REPLACE(REPLACE(BN.CUST_NM, '\"', ''), CHR(13)||CHR(10), ' ')), '-') NTFY_NM" ).append("\n"); 
		query.append(",(	SELECT  I.ACT_CUST_CNT_CD || TO_CHAR(ACT_CUST_SEQ, '000000')" ).append("\n"); 
		query.append("FROM    INV_AR_MN I" ).append("\n"); 
		query.append("WHERE   I.BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("AND     I.IO_BND_CD	= SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("AND	AR_IF_NO	= ( SELECT	MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM	INV_AR_MN" ).append("\n"); 
		query.append("WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     ROWNUM  = 1" ).append("\n"); 
		query.append(") AS AR_ACT_CD" ).append("\n"); 
		query.append(",(	SELECT	MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM 	MDM_CUSTOMER MC, INV_AR_MN I" ).append("\n"); 
		query.append("WHERE	MC.CUST_CNT_CD = I.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND		MC.CUST_SEQ    = I.ACT_CUST_SEQ" ).append("\n"); 
		query.append("AND		I.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND		I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("SELECT	MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM	INV_AR_MN" ).append("\n"); 
		query.append("WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND		ROWNUM  = 1" ).append("\n"); 
		query.append(") AS AR_ACT_NM" ).append("\n"); 
		query.append(",DECODE(TRIM(TO_CHAR(C.VNDR_SEQ, '000000')), '000000', NULL, TRIM(TO_CHAR(C.VNDR_SEQ, '000000'))) AS SVC_PROVDR_CD" ).append("\n"); 
		query.append(",(	SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE MV.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append(") AS SVC_PROVDR_NM" ).append("\n"); 
		query.append(",TO_CHAR(C.UPD_DT, 'YYYYMMDD') DEL_DT" ).append("\n"); 
		query.append(",C.UPD_OFC_CD  DEL_OFC" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT	USR_NM" ).append("\n"); 
		query.append("FROM	COM_USER" ).append("\n"); 
		query.append("WHERE	USR_ID = C.UPD_USR_ID" ).append("\n"); 
		query.append(") DEL_USR_NM" ).append("\n"); 
		query.append("--,R.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM	DMT_CHG_CALC		C," ).append("\n"); 
		query.append("COM_INTG_CD_DTL		R," ).append("\n"); 
		query.append("BKG_CUSTOMER		BS," ).append("\n"); 
		query.append("BKG_CUSTOMER		BC," ).append("\n"); 
		query.append("BKG_CUSTOMER		BN," ).append("\n"); 
		query.append("DMT_CHG_BKG_CNTR    B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	C.DMDT_CHG_STS_CD = 'D'		/*_____________ Delete Mark */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dt_flg} == 'F')" ).append("\n"); 
		query.append("AND	C.FM_MVMT_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND C.UPD_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("BETWEEN TO_DATE(@[fm_dt],'YYYYMMDD') AND TO_DATE(@[to_dt],'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND	R.INTG_CD_ID			= 'CD01965'" ).append("\n"); 
		query.append("AND	C.DMDT_CHG_DELT_RSN_CD  = R.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("AND C.OFC_RHQ_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND C.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND	C.DMDT_CHG_DELT_RSN_CD	IN (" ).append("\n"); 
		query.append("#foreach( $del_cd in ${del_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $del_cd_list.size()) '$del_cd', #else '$del_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND	B.SYS_AREA_GRP_ID		= C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND	B.CNTR_NO				= C.CNTR_NO" ).append("\n"); 
		query.append("AND	B.CNTR_CYC_NO			= C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND	B.BKG_NO				= BS.BKG_NO(+)" ).append("\n"); 
		query.append("AND	BS.BKG_CUST_TP_CD(+)	= 'S'" ).append("\n"); 
		query.append("AND	B.BKG_NO				= BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND	BC.BKG_CUST_TP_CD(+)	= 'C'" ).append("\n"); 
		query.append("AND	B.BKG_NO				= BN.BKG_NO(+)" ).append("\n"); 
		query.append("AND	BN.BKG_CUST_TP_CD(+)	= 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD	<> 'SZP'	-- 2010/03/19 추가" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY C.OFC_CD,R.INTG_CD_VAL_DP_SEQ, C.DMDT_TRF_CD, C.CNTR_NO" ).append("\n"); 

	}
}