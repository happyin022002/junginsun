/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchManifestInfoKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.11
*@LastModifier :
*@LastVersion : 1.0
* 2012.10.11
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchManifestInfoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 한국세관 Main Table로 Download된 데이터 조회
	  * 2011.03.29 김영철 [CHM-201109637-01] KOR MANIFEST GENERATE 기능 보완  ( 조건 추가 )
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchManifestInfoKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_blno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_tmnl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOSearchManifestInfoKorRSQL").append("\n");
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
		query.append("#if(${bl_dl} != 'mc')" ).append("\n");
		query.append("--bl, dl" ).append("\n");
		query.append("SELECT  CSTMS_BL_NO BL_NO" ).append("\n");
		query.append(", BKG_NO BKG_NO" ).append("\n");
		query.append(", BKG_NO A_BKG_NO" ).append("\n");
		query.append(", DECODE(@[in_bound],'I',DECODE(DECODE(TRIM(NVL(MST_BL_SEQ_NO,' ')),'',0,LENGTH(TRIM(NVL(MST_BL_SEQ_NO,' ')))),0,'N','Y'),' ') HIDDEN2" ).append("\n");
		query.append(", NVL(KR_BL_AMDT_STS_CD,' ') CORRECTION" ).append("\n");
		query.append(", CSTMS_DECL_TP_CD TP" ).append("\n");
		query.append(", NVL(BKG_CGO_TP_CD,' ') FE" ).append("\n");
		query.append(", DECODE(MF_SND_DT,NULL,'N','Y')  TR" ).append("\n");
		query.append(", NVL(MST_BL_SEQ_NO,' ')   MSN" ).append("\n");
		query.append(", NVL(POL_CD,' ') POL" ).append("\n");
		query.append(", NVL(POD_CD,' ') POD" ).append("\n");
		query.append(", NVL(PCK_QTY,0 ) PCK_QTY" ).append("\n");
		query.append(", NVL(PCK_TP_CD,' ') PCK_TP_CD" ).append("\n");
		query.append(", ROUND(NVL(CNTR_TTL_WGT,0),3) ACT_WGT" ).append("\n");
		query.append(", NVL(WGT_UT_CD,' ') WGT_UT_CD" ).append("\n");
		query.append(", ROUND(NVL(MEAS_QTY,0),3) MEAS_QTY" ).append("\n");
		query.append(", NVL(BL_MEAS_UT_CD,' ') MEAS_UT_CD" ).append("\n");
		query.append(", CRS_CHK_RSLT_FLG" ).append("\n");
		query.append(", CRS_CHK_RMK" ).append("\n");
		query.append(", MF_DL_DIFF_FLG" ).append("\n");
		query.append(", MF_SND_FLG" ).append("\n");
		query.append(", DMST_PORT_CD" ).append("\n");
		query.append(", '' PKG_VALUE" ).append("\n");
		query.append(", '' PKG_CODE" ).append("\n");
		query.append(", '' WGT_VALUE" ).append("\n");
		query.append(", '' WGT_CODE" ).append("\n");
		query.append(", '' MATCH" ).append("\n");
		query.append(", '' PRE_VVD" ).append("\n");
		query.append(", '' SHPR_N" ).append("\n");
		query.append(", '' SHPR_A" ).append("\n");
		query.append(", '' CNEE_N" ).append("\n");
		query.append(", '' CNEE_A" ).append("\n");
		query.append(", '' NTFY_N" ).append("\n");
		query.append(", '' NTFY_A" ).append("\n");
		query.append(", '' CNTR" ).append("\n");
		query.append(", DECODE(@[in_bound],'I',DECODE(DECODE(TRIM(NVL(BD_AREA_CD,' ')),'',0,LENGTH(TRIM(NVL(BD_AREA_CD,' ')))),0,'N','Y'),' ') BAC" ).append("\n");
		query.append(", DECODE(@[in_bound],'I',DECODE(DECODE(TRIM(NVL(KR_CSTMS_WH_TP_CD,' ')),'',0,LENGTH(TRIM(NVL(KR_CSTMS_WH_TP_CD,' ')))),0,'N',DECODE(DECODE(TRIM(NVL(KR_WH_CD,' ')),'',0,LENGTH(TRIM(NVL(KR_WH_CD,' ')))),0,'N','Y')),' ') WH" ).append("\n");
		query.append(", DECODE(DECODE(TRIM(NVL(CGO_DESC1,' ')),'',0,LENGTH(TRIM(NVL(CGO_DESC1,' ')))),0,'N','Y') DESC_CODE" ).append("\n");
		query.append(", DECODE(NVL(CMDT_CD,' '), ' ', 'N', 'Y') CM" ).append("\n");
		query.append(", DECODE(NVL(BIZ_RGST_NO,' '), ' ', 'N', 'Y') BZ" ).append("\n");
		query.append(", '' ELNO_A" ).append("\n");
		query.append(", '' ELNO_B" ).append("\n");
		query.append(", NVL(KR_CSTMS_BL_TP_CD,' ') SC" ).append("\n");
		query.append(", '' CUST_NAME" ).append("\n");
		query.append(", TRNS_SEQ HIDDEN3" ).append("\n");
		query.append(", TO_CHAR(TRUNC(NVL(CNTR_TTL_WGT,0),0),'FM00000000') HIDDEN4" ).append("\n");
		query.append(", NVL(KR_CSTMS_BND_CD,'N')  HIDDEN5" ).append("\n");
		query.append(", TO_CHAR(NVL(TRUNC(NVL(PCK_QTY,0),0),0),'FM000000') HIDDEN6" ).append("\n");
		query.append(", NVL(A.CSTMS_BL_NO,' ') C_BL_NO        /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_MTY_BKG_NO,' ') IB_MTY_BKG_NO    /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_MTY_BL_NO,' ') IB_MTY_BL_NO   /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_TRNS_SEQ,0) IB_TRNS_SEQ        /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_CSTMS_DECL_TP_CD,' ') IB_CSTMS_DECL_TP_CD     /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_DMST_PORT_CD,' ') IB_DMST_PORT_CD    /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_VSL_CD || A.IB_SKD_VOY_NO || A.IB_SKD_DIR_CD,' ') IB_VVD         /* 추가 */" ).append("\n");
		query.append(", NVL(TRUNC(A.CRE_DT - A.IB_ETA_DT,0),0) DWELL_DT    /* 추가 */" ).append("\n");
		query.append(", NVL(TO_CHAR(A.IB_ETA_DT,'YYYY-MM-DD'),' ') IB_ETA_DT    /* 추가 */" ).append("\n");
		query.append("" ).append("\n");
		query.append(", NVL(A.BD_AREA_CD, ' ') BAC_NM                    /* 추가 */" ).append("\n");
		query.append("" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_BL A" ).append("\n");
		query.append("WHERE VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[in_vvd],9,1)" ).append("\n");
		query.append("AND ((@[in_bound] = 'O' AND TS_POL_CD = @[in_pol]) OR (@[in_bound] = 'I' AND TS_POD_CD = @[in_pod]))" ).append("\n");
		query.append("AND ((@[in_bound] = 'O' AND nvl(PORT_TML_CD,' ') like '%')" ).append("\n");
		query.append("OR DECODE(LENGTH(@[in_pod_tmnl]),7,PORT_TML_CD,' ') = DECODE(LENGTH(@[in_pod_tmnl]),7,@[in_pod_tmnl],' '))" ).append("\n");
		query.append("AND ((@[in_bound] = 'O' AND CSTMS_DECL_TP_CD IN ('E','R'))" ).append("\n");
		query.append("OR (@[in_bound] = 'I' AND" ).append("\n");
		query.append("#if (${sel_type} == 'A')" ).append("\n");
		query.append("CSTMS_DECL_TP_CD = 'I'))" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("CSTMS_DECL_TP_CD IN ('I','T')))" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${sel_type} == 'M')" ).append("\n");
		query.append("AND KR_CSTMS_BND_CD='M'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("AND DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("AND CSTMS_BL_NO = NVL(@[in_blno], CSTMS_BL_NO)" ).append("\n");
		query.append("AND BKG_NO = NVL(@[in_bkg_no], A.BKG_NO)" ).append("\n");
		query.append("AND TRNS_SEQ = (SELECT MAX(TRNS_SEQ)" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("WHERE BKG_NO = A.BKG_NO" ).append("\n");
		query.append("AND DMST_PORT_CD = A.DMST_PORT_CD" ).append("\n");
		query.append("AND VSL_CD = A.VSL_CD" ).append("\n");
		query.append("AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n");
		query.append("AND SKD_DIR_CD = A.SKD_DIR_CD)" ).append("\n");
		query.append("AND NVL(DELT_FLG,' ') <> 'Y'" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if (${bl_dl}== 'cr')" ).append("\n");
		query.append("AND MF_DL_DIFF_FLG ='Y'" ).append("\n");
		query.append("--AND MF_SND_FLG ='N' 2012.08.09" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("ORDER BY BL_NO, NVL(POL_CD,' '), NVL(POD_CD,' ')" ).append("\n");
		query.append("" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("--mc" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("A.BL_NO," ).append("\n");
		query.append("A.BKG_NO BKG_NO," ).append("\n");
		query.append("A.BKG_NO A_BKG_NO," ).append("\n");
		query.append("B.BKG_NO B_BKG_NO,------빼기" ).append("\n");
		query.append("B.HIDDEN2," ).append("\n");
		query.append("B.CORRECTION," ).append("\n");
		query.append("NVL(B.TP,A.TP) TP," ).append("\n");
		query.append("NVL(B.FE,A.FE) FE," ).append("\n");
		query.append("B.TR," ).append("\n");
		query.append("B.MSN," ).append("\n");
		query.append("B.POL," ).append("\n");
		query.append("B.POD," ).append("\n");
		query.append("B.PCK_QTY," ).append("\n");
		query.append("B.PCK_TP_CD," ).append("\n");
		query.append("B.ACT_WGT," ).append("\n");
		query.append("B.WGT_UT_CD," ).append("\n");
		query.append("B.MEAS_QTY ," ).append("\n");
		query.append("B.MEAS_UT_CD," ).append("\n");
		query.append("B.CRS_CHK_RSLT_FLG," ).append("\n");
		query.append("B.CRS_CHK_RMK," ).append("\n");
		query.append("B.MF_DL_DIFF_FLG," ).append("\n");
		query.append("B.MF_SND_FLG," ).append("\n");
		query.append("B.DMST_PORT_CD," ).append("\n");
		query.append("B.PKG_VALUE ," ).append("\n");
		query.append("B.PKG_CODE ," ).append("\n");
		query.append("B.WGT_VALUE ," ).append("\n");
		query.append("B.WGT_CODE ," ).append("\n");
		query.append("B.MATCH ," ).append("\n");
		query.append("B.PRE_VVD ," ).append("\n");
		query.append("B.SHPR_N ," ).append("\n");
		query.append("B.SHPR_A ," ).append("\n");
		query.append("B.CNEE_N ," ).append("\n");
		query.append("B.CNEE_A ," ).append("\n");
		query.append("B.NTFY_N ," ).append("\n");
		query.append("B.NTFY_A ," ).append("\n");
		query.append("B.CNTR ," ).append("\n");
		query.append("B.BAC ," ).append("\n");
		query.append("B.WH ," ).append("\n");
		query.append("B.DESC_CODE ," ).append("\n");
		query.append("B.CM ," ).append("\n");
		query.append("B.BZ ," ).append("\n");
		query.append("B.ELNO_A ," ).append("\n");
		query.append("B.ELNO_B ," ).append("\n");
		query.append("B.SC ," ).append("\n");
		query.append("B.CUST_NAME ," ).append("\n");
		query.append("B.HIDDEN3 ," ).append("\n");
		query.append("B.HIDDEN4," ).append("\n");
		query.append("NVL(B.HIDDEN5,A.CREATEDTYPE)  HIDDEN5," ).append("\n");
		query.append("B.HIDDEN6," ).append("\n");
		query.append("B.C_BL_NO       ," ).append("\n");
		query.append("B.IB_MTY_BKG_NO   ," ).append("\n");
		query.append("B.IB_MTY_BL_NO   ," ).append("\n");
		query.append("B.IB_TRNS_SEQ     ," ).append("\n");
		query.append("B.IB_CSTMS_DECL_TP_CD   ," ).append("\n");
		query.append("B.IB_DMST_PORT_CD   ," ).append("\n");
		query.append("B.IB_VVD       ," ).append("\n");
		query.append("B.DWELL_DT   ," ).append("\n");
		query.append("B.IB_ETA_DT    ," ).append("\n");
		query.append("B.BAC_NM          ," ).append("\n");
		query.append("" ).append("\n");
		query.append("NVL(B.PCK_QTY_CHK,'Y') PCK_QTY_CHK," ).append("\n");
		query.append("NVL(B.PCK_TP_CD_CHK,'Y') PCK_TP_CD_CHK," ).append("\n");
		query.append("NVL(B.CNTR_TTL_WGT_CHK,'Y') CNTR_TTL_WGT_CHK," ).append("\n");
		query.append("NVL(B.WGT_UT_CD_CHK,'Y') WGT_UT_CD_CHK," ).append("\n");
		query.append("NVL(B.MEAS_QTY_CHK,'Y') MEAS_QTY_CHK," ).append("\n");
		query.append("NVL(B.MEAS_UT_CD_CHK,'Y') MEAS_UT_CD_CHK" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("(" ).append("\n");
		query.append("SELECT NVL(B.BL_NO,' ') BL_NO" ).append("\n");
		query.append(", NVL(B.BKG_NO,' ') BKG_NO" ).append("\n");
		query.append(", NVL(B.BKG_NO,' ') A_BKG_NO" ).append("\n");
		query.append(", NVL(C.MF_SEQ_NO,' ') MSN" ).append("\n");
		query.append(", '' CORRECTION" ).append("\n");
		query.append("--, DECODE(A.POL_CD,B.POL_CD,'E','R') TP" ).append("\n");
		query.append(", CASE WHEN @[in_bound] = 'O'" ).append("\n");
		query.append("THEN CASE WHEN A.POL_CD = B.POL_CD THEN 'E'" ).append("\n");
		query.append("ELSE 'R' END" ).append("\n");
		query.append("WHEN @[in_bound] = 'I' THEN" ).append("\n");
		query.append("CASE WHEN @[in_pod] = B.POD_CD AND B.BKG_CGO_TP_CD = 'P' THEN 'M'" ).append("\n");
		query.append("WHEN A.POD_CD = B.POD_CD THEN 'I'" ).append("\n");
		query.append("ELSE 'T' END" ).append("\n");
		query.append("ELSE ' ' END TP" ).append("\n");
		query.append("" ).append("\n");
		query.append(", NVL(B.BKG_CGO_TP_CD,' ') FE" ).append("\n");
		query.append(", NVL(A.POL_CD,' ') HIDDEN1" ).append("\n");
		query.append(", NVL(A.POD_CD,' ') HIDDEN2" ).append("\n");
		query.append(", NVL(B.POL_CD,' ') POL_CD" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if( ${in_bound} == 'I')" ).append("\n");
		query.append(", NVL(B.POD_CD,' ') POD_CD" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("#if (${sel_type} !='A')" ).append("\n");
		query.append(", NVL(A.POD_CD,' ') POD_CD" ).append("\n");
		query.append("#else" ).append("\n");
		query.append(", NVL(B.POD_CD,' ') POD_CD" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append(", TO_CHAR(NVL(D.PCK_QTY ,0),'FM000000') PCK_QTY" ).append("\n");
		query.append(", D.PCK_TP_CD PCK_TP_CD" ).append("\n");
		query.append(", TO_CHAR(TRUNC(NVL(D.ACT_WGT,0),0),'FM00000000') ACT_WGT" ).append("\n");
		query.append(", D.WGT_UT_CD WGT_UT_CD" ).append("\n");
		query.append(", TO_CHAR(NVL(D.MEAS_QTY,0),'FM00000000.000') MEAS_QTY" ).append("\n");
		query.append(", D.MEAS_UT_CD MEAS_UT_CD" ).append("\n");
		query.append(", A.VSL_CD" ).append("\n");
		query.append(",A.SKD_VOY_NO" ).append("\n");
		query.append(",A.SKD_DIR_CD" ).append("\n");
		query.append("" ).append("\n");
		query.append(", CASE WHEN @[in_bound] = 'O'" ).append("\n");
		query.append("THEN CASE WHEN A.POL_CD <> B.POL_CD THEN 'C'" ).append("\n");
		query.append("WHEN SUBSTR(B.POD_CD,1,2) IN ('US','CA','MX','GT') AND B.BKG_CGO_TP_CD <> 'P' THEN 'A'" ).append("\n");
		query.append("WHEN B.BKG_CGO_TP_CD = 'P' THEN 'M'" ).append("\n");
		query.append("ELSE 'B' END" ).append("\n");
		query.append("WHEN @[in_bound] = 'I'" ).append("\n");
		query.append("THEN CASE WHEN @[in_pod] = B.POD_CD AND B.BKG_CGO_TP_CD = 'P' THEN 'M'" ).append("\n");
		query.append("ELSE 'A' END" ).append("\n");
		query.append("END CREATEDTYPE" ).append("\n");
		query.append("" ).append("\n");
		query.append("FROM BKG_VVD A, BKG_BOOKING B, BKG_CSTMS_KR_MF_SEQ_NO C, BKG_BL_DOC D, BKG_CSTMS_CD_CONV_CTNT F" ).append("\n");
		query.append("WHERE A.VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n");
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n");
		query.append("AND A.SKD_DIR_CD    = SUBSTR(@[in_vvd],9,1)" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if (${in_bound} == 'O')" ).append("\n");
		query.append("AND A.POL_CD LIKE @[in_pol]||'%'" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND A.POD_CD LIKE @[in_pod]||'%'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("AND DECODE(@[in_bound],'I',DECODE(LENGTH(NULL),7,A.POD_YD_CD,' '),' ')" ).append("\n");
		query.append("= DECODE(@[in_bound],'I',DECODE(LENGTH(NULL),7,NULL,' '),' ')" ).append("\n");
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n");
		query.append("AND B.BKG_NO = D.BKG_NO" ).append("\n");
		query.append("AND B.BL_NO  > ' '" ).append("\n");
		query.append("AND B.BKG_STS_CD != 'X'" ).append("\n");
		query.append("AND B.BKG_STS_CD != 'S'" ).append("\n");
		query.append("AND B.BL_NO = NVL(@[in_blno],B.BL_NO)" ).append("\n");
		query.append("AND B.BKG_NO = C.BKG_NO(+)" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if(${mrn_no}!='')" ).append("\n");
		query.append("AND C.MF_REF_NO(+) = @[mrn_no]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND F.CNT_CD(+) = 'KR'" ).append("\n");
		query.append("AND F.CSTMS_DIV_ID(+) = 'KOR_CSTM_CMDT'" ).append("\n");
		query.append("AND B.REP_CMDT_CD = F.ATTR_CTNT1(+)" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if( ${sel_type} == 'A'||${sel_type} == 'B'||${sel_type} == 'C')" ).append("\n");
		query.append("AND B.BKG_CGO_TP_CD !='P'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if( ${sel_type} == 'M')" ).append("\n");
		query.append("AND B.BKG_CGO_TP_CD ='P'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("ORDER BY NVL(B.BL_NO,' '), NVL(A.POL_CD,' '), NVL(A.POD_CD,' ')" ).append("\n");
		query.append("" ).append("\n");
		query.append(") A, --A BKG_BOOKING TABLE 에서 구하는 부분" ).append("\n");
		query.append("" ).append("\n");
		query.append("(" ).append("\n");
		query.append("" ).append("\n");
		query.append("SELECT  CSTMS_BL_NO BL_NO" ).append("\n");
		query.append(", BKG_NO BKG_NO" ).append("\n");
		query.append(", BKG_NO A_BKG_NO" ).append("\n");
		query.append(", DECODE(@[in_bound],'I',DECODE(DECODE(TRIM(NVL(MST_BL_SEQ_NO,' ')),'',0,LENGTH(TRIM(NVL(MST_BL_SEQ_NO,' ')))),0,'N','Y'),' ') HIDDEN2" ).append("\n");
		query.append(", NVL(KR_BL_AMDT_STS_CD,' ') CORRECTION" ).append("\n");
		query.append(", CSTMS_DECL_TP_CD TP" ).append("\n");
		query.append(", NVL(BKG_CGO_TP_CD,' ') FE" ).append("\n");
		query.append(", DECODE(MF_SND_DT,NULL,'N','Y')  TR" ).append("\n");
		query.append(", NVL(MST_BL_SEQ_NO,' ')   MSN" ).append("\n");
		query.append(", NVL(POL_CD,' ') POL" ).append("\n");
		query.append(", NVL(POD_CD,' ') POD" ).append("\n");
		query.append(", NVL(PCK_QTY,0 ) PCK_QTY" ).append("\n");
		query.append(", NVL(PCK_TP_CD,' ') PCK_TP_CD" ).append("\n");
		query.append(", ROUND(NVL(CNTR_TTL_WGT,0),3) ACT_WGT" ).append("\n");
		query.append(", NVL(WGT_UT_CD,' ') WGT_UT_CD" ).append("\n");
		query.append(", ROUND(NVL(MEAS_QTY,0),3) MEAS_QTY" ).append("\n");
		query.append(", NVL(BL_MEAS_UT_CD,' ') MEAS_UT_CD" ).append("\n");
		query.append(", CRS_CHK_RSLT_FLG" ).append("\n");
		query.append(", CRS_CHK_RMK" ).append("\n");
		query.append(", MF_DL_DIFF_FLG" ).append("\n");
		query.append(", MF_SND_FLG" ).append("\n");
		query.append(", DMST_PORT_CD" ).append("\n");
		query.append(", '' PKG_VALUE" ).append("\n");
		query.append(", '' PKG_CODE" ).append("\n");
		query.append(", '' WGT_VALUE" ).append("\n");
		query.append(", '' WGT_CODE" ).append("\n");
		query.append(", '' MATCH" ).append("\n");
		query.append(", '' PRE_VVD" ).append("\n");
		query.append(", '' SHPR_N" ).append("\n");
		query.append(", '' SHPR_A" ).append("\n");
		query.append(", '' CNEE_N" ).append("\n");
		query.append(", '' CNEE_A" ).append("\n");
		query.append(", '' NTFY_N" ).append("\n");
		query.append(", '' NTFY_A" ).append("\n");
		query.append(", '' CNTR" ).append("\n");
		query.append(", DECODE(@[in_bound],'I',DECODE(DECODE(TRIM(NVL(BD_AREA_CD,' ')),'',0,LENGTH(TRIM(NVL(BD_AREA_CD,' ')))),0,'N','Y'),' ') BAC" ).append("\n");
		query.append(", DECODE(@[in_bound],'I',DECODE(DECODE(TRIM(NVL(KR_CSTMS_WH_TP_CD,' ')),'',0,LENGTH(TRIM(NVL(KR_CSTMS_WH_TP_CD,' ')))),0,'N',DECODE(DECODE(TRIM(NVL(KR_WH_CD,' ')),'',0,LENGTH(TRIM(NVL(KR_WH_CD,' ')))),0,'N','Y')),' ') WH" ).append("\n");
		query.append(", DECODE(DECODE(TRIM(NVL(CGO_DESC1,' ')),'',0,LENGTH(TRIM(NVL(CGO_DESC1,' ')))),0,'N','Y') DESC_CODE" ).append("\n");
		query.append(", DECODE(NVL(CMDT_CD,' '), ' ', 'N', 'Y') CM" ).append("\n");
		query.append(", DECODE(NVL(BIZ_RGST_NO,' '), ' ', 'N', 'Y') BZ" ).append("\n");
		query.append(", '' ELNO_A" ).append("\n");
		query.append(", '' ELNO_B" ).append("\n");
		query.append(", NVL(KR_CSTMS_BL_TP_CD,' ') SC" ).append("\n");
		query.append(", '' CUST_NAME" ).append("\n");
		query.append(", TRNS_SEQ HIDDEN3" ).append("\n");
		query.append(", TO_CHAR(TRUNC(NVL(CNTR_TTL_WGT,0),0),'FM00000000') HIDDEN4" ).append("\n");
		query.append(", NVL(KR_CSTMS_BND_CD,'N')  HIDDEN5" ).append("\n");
		query.append(", TO_CHAR(NVL(TRUNC(NVL(PCK_QTY,0),0),0),'FM000000') HIDDEN6" ).append("\n");
		query.append(", NVL(A.CSTMS_BL_NO,' ') C_BL_NO        /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_MTY_BKG_NO,' ') IB_MTY_BKG_NO    /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_MTY_BL_NO,' ') IB_MTY_BL_NO   /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_TRNS_SEQ,0) IB_TRNS_SEQ        /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_CSTMS_DECL_TP_CD,' ') IB_CSTMS_DECL_TP_CD     /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_DMST_PORT_CD,' ') IB_DMST_PORT_CD    /* 추가 */" ).append("\n");
		query.append(", NVL(A.IB_VSL_CD || A.IB_SKD_VOY_NO || A.IB_SKD_DIR_CD,' ') IB_VVD         /* 추가 */" ).append("\n");
		query.append(", NVL(TRUNC(A.CRE_DT - A.IB_ETA_DT,0),0) DWELL_DT    /* 추가 */" ).append("\n");
		query.append(", NVL(TO_CHAR(A.IB_ETA_DT,'YYYY-MM-DD'),' ') IB_ETA_DT    /* 추가 */" ).append("\n");
		query.append("" ).append("\n");
		query.append(", NVL(A.BD_AREA_CD, ' ') BAC_NM                    /* 추가 */" ).append("\n");
		query.append(", DECODE(NVL(TO_CHAR(A.mf_snd_dt,'YYYYMMDD'),'N'),'N','N',DECODE((SELECT SIGN(A.PCK_QTY - BL.PCK_QTY) FROM BKG_BL_DOC BL WHERE BL.BKG_NO = A.BKG_NO ),0,'N','Y')) PCK_QTY_CHK" ).append("\n");
		query.append(", DECODE(NVL(TO_CHAR(A.mf_snd_dt,'YYYYMMDD'),'N'),'N','N',DECODE(NVL((SELECT 'N' FROM BKG_BL_DOC BL WHERE BL.BKG_NO = A.BKG_NO AND BL.PCK_TP_CD = A.PCK_TP_CD ),'Y'),'N','N','Y')) PCK_TP_CD_CHK" ).append("\n");
		query.append(", DECODE(NVL(TO_CHAR(A.mf_snd_dt,'YYYYMMDD'),'N'),'N','N',DECODE((SELECT SIGN(TRUNC(A.CNTR_TTL_WGT,1) - TRUNC(BL.ACT_WGT,1)) FROM BKG_BL_DOC BL WHERE BL.BKG_NO = A.BKG_NO ),0,'N','Y')) CNTR_TTL_WGT_CHK" ).append("\n");
		query.append(", DECODE(NVL(TO_CHAR(A.mf_snd_dt,'YYYYMMDD'),'N'),'N','N',DECODE(NVL((SELECT 'N' FROM BKG_BL_DOC BL WHERE BL.BKG_NO = A.BKG_NO AND BL.WGT_UT_CD = A.WGT_UT_CD ),'Y'),'N','N','Y')) WGT_UT_CD_CHK" ).append("\n");
		query.append(", DECODE(NVL(TO_CHAR(A.mf_snd_dt,'YYYYMMDD'),'N'),'N','N',DECODE((SELECT SIGN(A.MEAS_QTY - BL.MEAS_QTY) FROM BKG_BL_DOC BL WHERE BL.BKG_NO = A.BKG_NO ),0,'N','Y')) MEAS_QTY_CHK" ).append("\n");
		query.append(", DECODE(NVL(TO_CHAR(A.mf_snd_dt,'YYYYMMDD'),'N'),'N','N',DECODE(NVL((SELECT 'N' FROM BKG_BL_DOC BL WHERE BL.BKG_NO = A.BKG_NO AND BL.MEAS_UT_CD = A.BL_MEAS_UT_CD ),'Y'),'N','N','Y')) MEAS_UT_CD_CHK" ).append("\n");
		query.append("" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_BL A" ).append("\n");
		query.append("WHERE VSL_CD = SUBSTR(@[in_vvd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[in_vvd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[in_vvd], 9, 1)" ).append("\n");
		query.append("AND ((@[in_bound] = 'O'  AND TS_POL_CD = @[in_pol])" ).append("\n");
		query.append("OR  (@[in_bound] = 'I'  AND TS_POD_CD = @[in_pod]))" ).append("\n");
		query.append("AND ((@[in_bound] = 'O'  AND NVL(PORT_TML_CD, ' ') LIKE '%')" ).append("\n");
		query.append("OR DECODE(LENGTH(@[in_pod_tmnl]), 7, PORT_TML_CD, ' ') = DECODE(LENGTH(@[in_pod_tmnl]), 7, @[in_pod_tmnl], ' '))" ).append("\n");
		query.append("AND ((@[in_bound] = 'O'  AND CSTMS_DECL_TP_CD IN ('E','R'))" ).append("\n");
		query.append("OR (@[in_bound] = 'I'  AND" ).append("\n");
		query.append("#if (${sel_type} == 'A')" ).append("\n");
		query.append("CSTMS_DECL_TP_CD = 'I'))" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("CSTMS_DECL_TP_CD IN ('I','T')))" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${sel_type} == 'M')" ).append("\n");
		query.append("AND KR_CSTMS_BND_CD='M'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("AND DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("AND CSTMS_BL_NO = NVL(@[in_blno], CSTMS_BL_NO)" ).append("\n");
		query.append("AND BKG_NO = NVL(@[in_bkg_no], A.BKG_NO)" ).append("\n");
		query.append("AND TRNS_SEQ = (" ).append("\n");
		query.append("SELECT MAX(TRNS_SEQ)" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("WHERE BKG_NO = A.BKG_NO" ).append("\n");
		query.append("AND DMST_PORT_CD = A.DMST_PORT_CD" ).append("\n");
		query.append("AND VSL_CD = A.VSL_CD" ).append("\n");
		query.append("AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n");
		query.append("AND SKD_DIR_CD = A.SKD_DIR_CD)" ).append("\n");
		query.append("AND NVL(DELT_FLG, ' ') <> 'Y'" ).append("\n");
		query.append("#if (${bl_dl}== 'mc')" ).append("\n");
		query.append("AND NVL(KR_CSTMS_BL_TP_CD,' ') LIKE DECODE(@[sc],'C','C','S','S','%')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(") B" ).append("\n");
		query.append("" ).append("\n");
		query.append("WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n");
		query.append("AND A.TP = B.TP(+)" ).append("\n");
		query.append("AND A.CREATEDTYPE LIKE DECODE( @[sel_type],'D','%','N','%',@[sel_type] )" ).append("\n");
		query.append("#end" ).append("\n");

	}
}