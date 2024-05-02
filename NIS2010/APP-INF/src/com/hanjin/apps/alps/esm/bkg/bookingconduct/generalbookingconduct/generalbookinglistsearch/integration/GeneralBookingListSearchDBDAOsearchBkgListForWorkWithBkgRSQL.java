/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOsearchBkgListForWorkWithBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOsearchBkgListForWorkWithBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgListForWorkWithBkg
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOsearchBkgListForWorkWithBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_stf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("non_rt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("si_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dlv_ctnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_ref_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOsearchBkgListForWorkWithBkgRSQL").append("\n"); 
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
		query.append("#if(${bkg_no} == ''&&${bkg_from_dt} != '')" ).append("\n"); 
		query.append("	#if (${date_gbn} == 'Y')" ).append("\n"); 
		query.append("        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("			/*+ INDEX (BK XAK3BKG_BOOKING) ORDERED USE_NL(BK VVD BL REFNO CUST) */" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			/*+ INDEX (BK XAK3BKG_BOOKING) ORDERED USE_NL(BK BL REFNO CUST) */" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("			/*+ INDEX (BL XAK2BKG_BL_DOC) ORDERED USE_NL(BL BK VVD REFNO CUST) */" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			/*+ INDEX (BL XAK2BKG_BL_DOC) ORDERED USE_NL(BL BK REFNO CUST) */" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bkg_no} == ''&&${vvd} != '')" ).append("\n"); 
		query.append("	#if(${pol_cd} != '')" ).append("\n"); 
		query.append("		/*+ INDEX (VVD XAK2BKG_VVD) */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${pod_cd} != '')" ).append("\n"); 
		query.append("		/*+ INDEX (VVD XAK3BKG_VVD) */" ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("	#if(${pol_cd} == '' && ${pod_cd} == '')" ).append("\n"); 
		query.append("		/*+ INDEX (VVD XAK1BKG_VVD) */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        --ROWNUM              SEQ" ).append("\n"); 
		query.append("        DISTINCT BK.BKG_NO         BKG_NO " ).append("\n"); 
		query.append("        , BK.USA_CSTMS_FILE_CD     US_FILE_CD" ).append("\n"); 
		query.append("        , BK.CND_CSTMS_FILE_CD     CA_FILE_CD " ).append("\n"); 
		query.append("        , REPLACE((SELECT CUST_NM FROM BKG_CUSTOMER CUST WHERE CUST.BKG_NO = BK.BKG_NO AND BKG_CUST_TP_CD = 'S'), CHR(13)||CHR(10), ' ') SHIPPER" ).append("\n"); 
		query.append("        , REPLACE((SELECT cust.CUST_CNT_CD||TO_CHAR(cust.CUST_SEQ) FROM BKG_CUSTOMER CUST WHERE CUST.BKG_NO = BK.BKG_NO AND BKG_CUST_TP_CD = 'S'), CHR(13)||CHR(10), ' ') SHIPPER_CODE" ).append("\n"); 
		query.append("	    , BK.SLAN_CD LANE" ).append("\n"); 
		query.append("        , BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD TVVD" ).append("\n"); 
		query.append("--        , BKG_JOIN_FNC( CURSOR(SELECT CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(NVL(OP_CNTR_QTY, 0),'990.99'))" ).append("\n"); 
		query.append("--                                  FROM BKG_QUANTITY" ).append("\n"); 
		query.append("--                                 WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("--                                   AND CNTR_TPSZ_CD IS NOT NULL)) CNTR_VOL" ).append("\n"); 
		query.append("		, (SELECT TO_CHAR(C.BKG_CZ_DESC) FROM BKG_CNTR_CZ C WHERE C.BKG_NO = BK.BKG_NO AND C.BKG_CZ_STS_CD = 'CQ') CNTR_VOL" ).append("\n"); 
		query.append("        , BK.POR_CD         POR" ).append("\n"); 
		query.append("        , SUBSTR(BK.POR_NOD_CD,      6, 2) POR_NOD_CD" ).append("\n"); 
		query.append("        , BK.POL_CD         POL" ).append("\n"); 
		query.append("        , SUBSTR(BK.POL_NOD_CD,      6, 2) POL_NOD_CD" ).append("\n"); 
		query.append("        , SUBSTR(BK.PRE_RLY_PORT_CD, 1, 5) PRE_LOC" ).append("\n"); 
		query.append("        , SUBSTR(BK.PRE_RLY_PORT_CD, 6, 2) PRE_YD" ).append("\n"); 
		query.append("        , SUBSTR(BK.PST_RLY_PORT_CD, 1, 5) PST_LOC" ).append("\n"); 
		query.append("        , SUBSTR(BK.PST_RLY_PORT_CD, 6, 2) PST_YD        " ).append("\n"); 
		query.append("        , BK.POD_CD         POD" ).append("\n"); 
		query.append("        , SUBSTR(BK.POD_NOD_CD, 	 6, 2) POD_NOD_CD" ).append("\n"); 
		query.append("        , BK.DEL_CD         DEL" ).append("\n"); 
		query.append("        , SUBSTR(BK.DEL_NOD_CD,      6, 2) DEL_NOD_CD" ).append("\n"); 
		query.append("        , BK.BKG_STS_CD     ST" ).append("\n"); 
		query.append("        , BK.RCV_TERM_CD    R" ).append("\n"); 
		query.append("        , BK.DE_TERM_CD     D" ).append("\n"); 
		query.append("        , DECODE(BL.BDR_FLG, 'N', 'NO', 'YES') BDR" ).append("\n"); 
		query.append("        , NVL((SELECT DSP --A:APPROVE -> 파랑, N:REJECT -> 빨강, P:PENDING, R:RQST, OTHER:SPECIAL CARGO EXIST" ).append("\n"); 
		query.append("			 FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("			        , (SELECT 'N' STS, 1 RANK, 'N' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'P' STS, 2 RANK, 'P' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'R' STS, 3 RANK, 'R' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'Y' STS, 4 RANK, 'A' DSP FROM DUAL" ).append("\n"); 
		query.append("					UNION SELECT 'NULL' STS, 5 RANK, 'Y' DSP FROM DUAL) RANK" ).append("\n"); 
		query.append("		    WHERE NVL(DG.SPCL_CGO_APRO_CD, 'NULL') = STS" ).append("\n"); 
		query.append("			  AND DG.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("			  AND ROWNUM = 1), DECODE(BK.DCGO_FLG, 'Y', 'Y', NULL)) DG" ).append("\n"); 
		query.append("        , NVL((SELECT DSP" ).append("\n"); 
		query.append("			 FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("			        , (SELECT 'N' STS, 1 RANK, 'N' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'P' STS, 2 RANK, 'P' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'R' STS, 3 RANK, 'R' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'Y' STS, 4 RANK, 'A' DSP FROM DUAL" ).append("\n"); 
		query.append("					UNION SELECT 'NULL' STS, 5 RANK, 'Y' DSP FROM DUAL) RANK" ).append("\n"); 
		query.append("		    WHERE NVL(RF.SPCL_CGO_APRO_CD, 'NULL') = STS" ).append("\n"); 
		query.append("			  AND RF.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("			  AND ROWNUM = 1), DECODE(BK.RC_FLG, 'Y', 'Y', NULL)) RF" ).append("\n"); 
		query.append("        , NVL((SELECT DSP" ).append("\n"); 
		query.append("			 FROM BKG_AWK_CGO AK" ).append("\n"); 
		query.append("			        , (SELECT 'N' STS, 1 RANK, 'N' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'P' STS, 2 RANK, 'P' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'R' STS, 3 RANK, 'R' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'Y' STS, 4 RANK, 'A' DSP FROM DUAL" ).append("\n"); 
		query.append("					UNION SELECT 'NULL' STS, 5 RANK, 'Y' DSP FROM DUAL) RANK" ).append("\n"); 
		query.append("		    WHERE NVL(AK.SPCL_CGO_APRO_CD, 'NULL') = STS" ).append("\n"); 
		query.append("			  AND AK.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("			  AND ROWNUM = 1), DECODE(BK.AWK_CGO_FLG, 'Y', 'Y', NULL)) AWK" ).append("\n"); 
		query.append("        , NVL((SELECT DSP" ).append("\n"); 
		query.append("			 FROM BKG_BB_CGO BB" ).append("\n"); 
		query.append("			        , (SELECT 'N' STS, 1 RANK, 'N' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'P' STS, 2 RANK, 'P' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'R' STS, 3 RANK, 'R' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'Y' STS, 4 RANK, 'A' DSP FROM DUAL" ).append("\n"); 
		query.append("					UNION SELECT 'NULL' STS, 5 RANK, 'Y' DSP FROM DUAL) RANK" ).append("\n"); 
		query.append("		    WHERE NVL(BB.SPCL_CGO_APRO_CD, 'NULL') = STS" ).append("\n"); 
		query.append("			  AND BB.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("			  AND ROWNUM = 1), DECODE(BK.BB_CGO_FLG, 'Y', 'Y', NULL)) BB" ).append("\n"); 
		query.append("        , DECODE(BK.RD_CGO_FLG, 'Y', 'Y', 'N', NULL) RD" ).append("\n"); 
		query.append("        , DECODE(BK.HNGR_FLG, 'Y', 'Y', 'N', NULL) HG" ).append("\n"); 
		query.append("        , DECODE(BK.SI_FLG, 'N', 'NO', 'YES') SI" ).append("\n"); 
		query.append("        , DECODE(BK.XTER_BKG_RQST_CD, 'NIS', 'OFF', 'APS', 'OFF', BK.XTER_BKG_RQST_CD)  BKG_VIA" ).append("\n"); 
		query.append("        , DECODE(BK.XTER_SI_CD,       'NIS', 'OFF', 'APS', 'OFF', BK.XTER_SI_CD)        SI_VIA" ).append("\n"); 
		query.append("        , REPLACE((SELECT CUST_NM FROM BKG_CUSTOMER CUST WHERE CUST.BKG_NO = BK.BKG_NO AND BKG_CUST_TP_CD = 'F'), CHR(13)||CHR(10), ' ') FORWARDER" ).append("\n"); 
		query.append("        , DECODE(BK.CUST_TO_ORD_FLG, 'Y'" ).append("\n"); 
		query.append("        , REPLACE((SELECT CUST_NM FROM BKG_CUSTOMER CUST WHERE CUST.BKG_NO = BK.BKG_NO AND BKG_CUST_TP_CD = 'N'), CHR(13)||CHR(10), ' ')" ).append("\n"); 
		query.append("        , REPLACE((SELECT CUST_NM FROM BKG_CUSTOMER CUST WHERE CUST.BKG_NO = BK.BKG_NO AND BKG_CUST_TP_CD = 'C'), CHR(13)||CHR(10), ' ')) CN_NT" ).append("\n"); 
		query.append("        , REFNO.CUST_REF_NO_CTNT CUST_REF_NO" ).append("\n"); 
		query.append("        , BK.OB_SREP_CD     SREP_CD" ).append("\n"); 
		query.append("        , (SELECT SREP.srep_nm FROM MDM_SLS_REP SREP WHERE SREP.SREP_CD = BK.OB_SREP_CD) SREP_NM" ).append("\n"); 
		query.append("        , BK.OB_SLS_OFC_CD  SALES_OFC" ).append("\n"); 
		query.append("        , BK.REP_CMDT_CD    REP_CMDT" ).append("\n"); 
		query.append("        , BK.CMDT_CD        CMDT" ).append("\n"); 
		query.append("		, BL.ACT_WGT        WGT" ).append("\n"); 
		query.append("        , BL.WGT_UT_CD      WGT_UT_CD " ).append("\n"); 
		query.append("        , BK.XTER_RMK       EXT_RMK " ).append("\n"); 
		query.append("		, NVL((SELECT TO_CHAR(TM.MNL_SET_DT,'YYYY-MM-DD HH24:MI') FROM BKG_CLZ_TM TM WHERE TM.BKG_NO(+) = BK.BKG_NO AND CLZ_TP_CD = 'V')" ).append("\n"); 
		query.append("             , NVL((SELECT TO_CHAR(TM.SYS_SET_DT,'YYYY-MM-DD HH24:MI') FROM BKG_CLZ_TM TM WHERE TM.BKG_NO(+) = BK.BKG_NO AND CLZ_TP_CD = 'V'), (SELECT TM.SYS_SET_DT_DESC FROM BKG_CLZ_TM TM WHERE TM.BKG_NO(+) = BK.BKG_NO AND CLZ_TP_CD = 'V'))" ).append("\n"); 
		query.append("             ) SYS_SET_DT_DESC" ).append("\n"); 
		query.append("        , (SELECT CMDT.CMDT_NM FROM MDM_COMMODITY CMDT WHERE CMDT.CMDT_CD = BK.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("        , NVL(BK.SC_NO, NVL(BK.RFA_NO, BK.TAA_NO)) SC_RFA" ).append("\n"); 
		query.append("		, (SELECT CUST_CNT_CD||TO_CHAR(CUST_SEQ) FROM BKG_CUSTOMER BROKER WHERE BROKER.BKG_CUST_TP_CD = 'B' AND BROKER.BKG_NO = BK.BKG_NO) BROKER" ).append("\n"); 
		query.append("		, BK.BKG_OFC_CD" ).append("\n"); 
		query.append("		, BK.CTRT_OFC_CD    C_OFC" ).append("\n"); 
		query.append("		, BK.CTRT_SREP_CD   C_REP" ).append("\n"); 
		query.append("        , (SELECT TO_CHAR(SKD.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') ETB" ).append("\n"); 
		query.append("            FROM BKG_BOOKING BKK" ).append("\n"); 
		query.append("            , BKG_VVD VVD" ).append("\n"); 
		query.append("            , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("            WHERE BKK.BKG_NO     = VVD.BKG_NO" ).append("\n"); 
		query.append("            AND BKK.POL_CD       = VVD.POL_CD" ).append("\n"); 
		query.append("            AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("            AND VVD.VSL_CD       = SKD.VSL_CD(+)" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO   = SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD   = SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("            AND VVD.POL_CD       = SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("            AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("            AND BKK.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("            AND ROWNUM = 1) VPS_ETB_DT" ).append("\n"); 
		query.append("         , '' SPOT_GUIDE_FLG" ).append("\n"); 
		query.append("         , (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("            FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("            WHERE INTG_CD_ID = 'CD03367'" ).append("\n"); 
		query.append("            AND INTG_CD_VAL_CTNT = BK.RTRO_KND_CD) RTRO_KND_CD" ).append("\n"); 
		query.append("#if (${date_gbn} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("       #if (${bkg_cust_tp_cd} != '' || ${cust_cnt_cd} != '' || ${cust_seq} != '' || ${cust_nm} != '') " ).append("\n"); 
		query.append("        --customer 입력시 " ).append("\n"); 
		query.append("      , BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("      , BKG_BL_DOC BL" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  FROM BKG_BL_DOC BL" ).append("\n"); 
		query.append("     , BKG_BOOKING BK" ).append("\n"); 
		query.append("       #if (${bkg_cust_tp_cd} != '' || ${cust_cnt_cd} != '' || ${cust_seq} != '' || ${cust_nm} != '') " ).append("\n"); 
		query.append("        --customer 입력시 " ).append("\n"); 
		query.append("     , BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , BKG_REFERENCE REFNO" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && (${vvd} != '' || ${pol_cd} != '' || ${pol_yd_cd} != '' || ${pod_cd} != '' || ${pod_yd_cd} != ''))" ).append("\n"); 
		query.append("        --vvd나 ROUTE 입력시" ).append("\n"); 
		query.append("     , BKG_VVD VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eqTpSzCd} != '') " ).append("\n"); 
		query.append("        --E/Q Type Size 입력시 " ).append("\n"); 
		query.append("     , BKG_QUANTITY QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = REFNO.BKG_NO(+)" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("   --booking no 입력시 (다른 조건 전부 비활성화)" ).append("\n"); 
		query.append("   AND BK.BKG_NO IN ( ${bkg_no} )" ).append("\n"); 
		query.append("   AND 'EBRF' = REFNO.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${bkg_cust_tp_cd} != '' || ${cust_cnt_cd} != '' || ${cust_seq} != '' || ${cust_nm} != '') " ).append("\n"); 
		query.append("	   --customer 입력시  " ).append("\n"); 
		query.append("	   AND BK.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${date_gbn} == 'Y') " ).append("\n"); 
		query.append("        --date : Booking 선택시" ).append("\n"); 
		query.append("    	#if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("    	       AND BK.BKG_CRE_DT > TO_DATE(REPLACE(@[bkg_from_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("    	       AND BK.BKG_CRE_DT < TO_DATE(REPLACE(@[bkg_to_dt],'-',''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        --date : on board 선택시   " ).append("\n"); 
		query.append("    	#if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("    	     AND BL.BL_OBRD_DT >= TO_DATE(REPLACE(@[bkg_from_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("    		 AND Bl.BL_OBRD_DT < TO_DATE(REPLACE(@[bkg_to_dt],'-',''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("    #if (${vvd} != '')" ).append("\n"); 
		query.append("       --vvd 입력시" ).append("\n"); 
		query.append("	   AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND VVD.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${pol_cd} != '' || ${pol_yd_cd} != '' ||${pod_cd} != '' || ${pod_yd_cd} != '')" ).append("\n"); 
		query.append("	   --por~del 입력시" ).append("\n"); 
		query.append(" 	   AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append(" 		#if (${pol_cd} != '')" ).append("\n"); 
		query.append(" 	       AND VVD.POL_CD        like @[pol_cd]||'%'" ).append("\n"); 
		query.append("     	#end" ).append("\n"); 
		query.append("	    #if (${pol_yd_cd} != '')" ).append("\n"); 
		query.append("    	   AND VVD.POL_YD_CD    = @[pol_cd]||@[pol_yd_cd]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("    	#if (${pod_cd} != '')" ).append("\n"); 
		query.append("	       AND VVD.POD_CD        like @[pod_cd]||'%'" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("	    #if (${pod_yd_cd} != '')" ).append("\n"); 
		query.append("    	   AND VVD.POD_YD_CD    = @[pod_cd]||@[pod_yd_cd]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("    #if (${por_cd} != '')" ).append("\n"); 
		query.append("	   AND BK.POR_CD        like @[por_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${del_cd} != '')" ).append("\n"); 
		query.append("       AND BK.DEL_CD        like @[del_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${dlv_ctnt_cd} != 'All' && ${dlv_ctnt_cd} != '')" ).append("\n"); 
		query.append("       --continent 선택시" ).append("\n"); 
		query.append("       AND @[dlv_ctnt_cd] = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD)" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("    #if (${bkg_sts_cd} != 'All' && ${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("       --bkg status 선택시 (CD00769, all이면 조건 제외)" ).append("\n"); 
		query.append("       AND BK.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	   AND BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("    #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("       --bkg office 입력시" ).append("\n"); 
		query.append("       AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("    #if (${bkg_stf_cd} != '')" ).append("\n"); 
		query.append("       --bkg staff 입력시" ).append("\n"); 
		query.append("       AND BK.DOC_USR_ID = @[bkg_stf_cd]" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("    #if (${sls_ofc_cd} != '')" ).append("\n"); 
		query.append("       --sales office 입력시" ).append("\n"); 
		query.append("       AND BK.OB_SLS_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("    #if (${srep_cd} != '')" ).append("\n"); 
		query.append("       --sales rep 입력시" ).append("\n"); 
		query.append("       AND BK.OB_SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("	#if (${dcgo_flg}!=''||${rf_flg}!=''||${awk_cgo_flg}!=''||${bb_cgo_flg}!=''||${rd_cgo_flg}!=''||${hngr_flg}!='')" ).append("\n"); 
		query.append("	   AND ( 1 = 0" ).append("\n"); 
		query.append("        #if (${dcgo_flg} != '')" ).append("\n"); 
		query.append("    	--dg check시" ).append("\n"); 
		query.append("           OR BK.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("        #end        " ).append("\n"); 
		query.append("        #if (${rf_flg} != '')" ).append("\n"); 
		query.append("        --rf check시" ).append("\n"); 
		query.append("           OR BK.RC_FLG = 'Y'" ).append("\n"); 
		query.append("        #end        " ).append("\n"); 
		query.append("        #if (${awk_cgo_flg} != '')" ).append("\n"); 
		query.append("        --ak check시" ).append("\n"); 
		query.append("           OR BK.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("        #end        " ).append("\n"); 
		query.append("        #if (${bb_cgo_flg} != '')" ).append("\n"); 
		query.append("        --bb check시" ).append("\n"); 
		query.append("           OR BK.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("        #end        " ).append("\n"); 
		query.append("        #if (${rd_cgo_flg} != '')" ).append("\n"); 
		query.append("        --rd check시 " ).append("\n"); 
		query.append("           OR BK.RD_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${hngr_flg} != '')" ).append("\n"); 
		query.append("        --hg check시 " ).append("\n"); 
		query.append("           OR BK.HNGR_FLG = 'Y'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("    #if (${bkg_cust_tp_cd} != 'All' && ${bkg_cust_tp_cd} != '')" ).append("\n"); 
		query.append("       --customer 입력시 " ).append("\n"); 
		query.append("       AND CUST.BKG_CUST_TP_CD = @[bkg_cust_tp_cd]--:bkgCustTpCd --drop down 선택값(CD00880, B 제외, null 선택 가능)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("       AND CUST.CUST_CNT_CD    = @[cust_cnt_cd]--:custCnt값" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_seq} != '')" ).append("\n"); 
		query.append("       AND CUST.CUST_SEQ       = to_number(@[cust_seq])--:custSeq" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cust_nm} != '')" ).append("\n"); 
		query.append("       AND CUST.CUST_NM  like @[cust_nm]||'%'" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("	#if(${cust_ref_tp_cd} == 'All' || ${cust_ref_tp_cd} == '')" ).append("\n"); 
		query.append("        AND 'EBRF' = REFNO.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("        --customer ref No 선택 입력시" ).append("\n"); 
		query.append("		#if(${cust_ref_tp_cd} == 'BKPO')" ).append("\n"); 
		query.append("		    AND REFNO.BKG_REF_TP_CD IN ('BKPO','CMPO','CTPO')" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	       AND REFNO.BKG_REF_TP_CD = @[cust_ref_tp_cd]--(CD01658, null 선택 가능)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${cust_ref_no} != '')" ).append("\n"); 
		query.append("		AND REFNO.CUST_REF_NO_CTNT = @[cust_ref_no]" ).append("\n"); 
		query.append("	#end   " ).append("\n"); 
		query.append("    #if (${sc_rfa_gbn} == 'S' && ${sc_rfa_no} != '')" ).append("\n"); 
		query.append("        --s/c check시" ).append("\n"); 
		query.append("   	    AND BK.SC_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${sc_rfa_gbn} == 'R' && ${sc_rfa_no} != '')" ).append("\n"); 
		query.append("        --rfa check시   " ).append("\n"); 
		query.append("    	AND BK.RFA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("    #if (${sc_rfa_gbn} == 'T' && ${sc_rfa_no} != '')" ).append("\n"); 
		query.append("		--taa check시" ).append("\n"); 
		query.append("    	AND BK.TAA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("    #if (${bdr_flg} != '')" ).append("\n"); 
		query.append("       --bdr 선택시(all 제외)" ).append("\n"); 
		query.append("       AND BL.BDR_FLG = @[bdr_flg]" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("    #if (${si_cd} != '')" ).append("\n"); 
		query.append("       --s/i 선택시(all 제외)" ).append("\n"); 
		query.append("       AND BK.SI_FLG = @[si_cd]" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("	#if (${bkgViaCd} != '')" ).append("\n"); 
		query.append("       AND BK.XTER_BKG_RQST_CD IN (" ).append("\n"); 
		query.append("       #foreach($bkgViaCdVal IN ${bkgViaCd})        " ).append("\n"); 
		query.append("          #if($velocityCount < $bkgViaCd.size()) '$bkgViaCdVal', #else '$bkgViaCdVal' #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("	   )	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${siViaCd} != '')" ).append("\n"); 
		query.append("       AND BK.XTER_SI_CD IN (" ).append("\n"); 
		query.append("       #foreach($siViaCdVal IN ${siViaCd})        " ).append("\n"); 
		query.append("          #if($velocityCount < $siViaCd.size()) '$siViaCdVal', #else '$siViaCdVal' #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${eqTpSzCd} != '')" ).append("\n"); 
		query.append("       AND QTY.BKG_NO  = BK.BKG_NO" ).append("\n"); 
		query.append("       AND QTY.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("       #foreach($eqTpSzCdVal IN ${eqTpSzCd})        " ).append("\n"); 
		query.append("          #if($velocityCount < $eqTpSzCd.size()) '$eqTpSzCdVal', #else '$eqTpSzCdVal' #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${non_rt_sts_cd} != '')" ).append("\n"); 
		query.append("       AND BK.NON_RT_STS_CD = @[non_rt_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${aloc_sts_cd} != '')" ).append("\n"); 
		query.append("       AND BK.ALOC_STS_CD = @[aloc_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${spot_guide_flg} != '')" ).append("\n"); 
		query.append("       AND NVL(SUBSTR(BK.RFA_NO,6,1),'X') = 'G' -- Spot Guide RFA" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("	#if(${rtroKndCd} != '')" ).append("\n"); 
		query.append("        AND BK.RTRO_KND_CD IN (" ).append("\n"); 
		query.append("       #foreach($rtroKndCdVal IN ${rtroKndCd})        " ).append("\n"); 
		query.append("          #if($velocityCount < $rtroKndCd.size()) '$rtroKndCdVal', #else '$rtroKndCdVal' #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("ORDER BY BK.BKG_NO" ).append("\n"); 

	}
}