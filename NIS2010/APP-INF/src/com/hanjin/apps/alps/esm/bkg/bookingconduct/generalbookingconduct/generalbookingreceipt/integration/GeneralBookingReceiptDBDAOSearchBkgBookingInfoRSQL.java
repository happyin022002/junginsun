/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgBookingInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBkgBookingInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking 기본정보 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBkgBookingInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBkgBookingInfoRSQL").append("\n"); 
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
		query.append("SELECT                        BK.BKG_NO				" ).append("\n"); 
		query.append("					        , BK.BKG_NO         OLD_BKG_NO	" ).append("\n"); 
		query.append("					        , BK.MNL_BKG_NO_FLG" ).append("\n"); 
		query.append("					        , BK.SPLIT_FLG				" ).append("\n"); 
		query.append("							, BK.SPLIT_RSN_CD" ).append("\n"); 
		query.append("							, BK.ADV_SHTG_CD" ).append("\n"); 
		query.append("                            , BK.EDI_HLD_FLG	" ).append("\n"); 
		query.append("					        , BK.BL_NO||NVL(BK.BL_TP_CD, DECODE(ISS.OBL_SRND_FLG, 'Y', 'S', null)) BL_NO					" ).append("\n"); 
		query.append("					        , BK.SI_FLG					" ).append("\n"); 
		query.append("					        , BL.BDR_FLG				" ).append("\n"); 
		query.append("							, @[ca_flg] CA_FLG					" ).append("\n"); 
		query.append("					        , BL.CORR_USR_ID CA_USER					" ).append("\n"); 
		query.append("					        , BK.BKG_STS_CD					" ).append("\n"); 
		query.append("					        , DECODE(BK.WT_RSN_SPCL_CGO_FLG||BK.WT_RSN_HLD_FLG 					" ).append("\n"); 
		query.append("					                , 'YN', 'Special Cargo Non Approval'					" ).append("\n"); 
		query.append("					                , 'NY', 'User holding'					" ).append("\n"); 
		query.append("					                , 'YY', 'Special Cargo Non Approval', ' ') WAIT_RSN" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("							, '' ALOC_STS_CD" ).append("\n"); 
		query.append("							, '' BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("							, '' NEW_CUST_APRO_FLG" ).append("\n"); 
		query.append("							, '' NEW_CUST_APRO_CMDT_NM" ).append("\n"); 
		query.append("							, '' NEW_CUST_APRO_RMK" ).append("\n"); 
		query.append("							, 'X' NEW_CUST_APRO_MARK_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("							, BK.ALOC_STS_CD ALOC_STS_CD" ).append("\n"); 
		query.append("							, CASE WHEN BK.BKG_ALOC_TP_CD = 'C' THEN 'Customer Res.'" ).append("\n"); 
		query.append("								   WHEN BK.BKG_ALOC_TP_CD = 'E' THEN 'EQ & Commodity'" ).append("\n"); 
		query.append("								   WHEN BK.BKG_ALOC_TP_CD = 'M' THEN 'EQ & Commodity'" ).append("\n"); 
		query.append("								   WHEN BK.BKG_ALOC_TP_CD = 'T' THEN 'Trunk Allocation'" ).append("\n"); 
		query.append("								   WHEN BK.BKG_ALOC_TP_CD = 'S' THEN 'Post Allocation'" ).append("\n"); 
		query.append("								   WHEN BK.BKG_ALOC_TP_CD = 'X' THEN 'Mixed' END BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("							, BK.NEW_CUST_APRO_FLG" ).append("\n"); 
		query.append("							, BK.NEW_CUST_APRO_CMDT_NM" ).append("\n"); 
		query.append("							, BK.NEW_CUST_APRO_RMK" ).append("\n"); 
		query.append("							, CASE WHEN BK.NEW_CUST_APRO_FLG = 'Y' " ).append("\n"); 
		query.append("                                        AND LENGTH(NVL(BK.NEW_CUST_APRO_CMDT_NM,''))>0 " ).append("\n"); 
		query.append("                                   THEN 'Y' ELSE 'N' END NEW_CUST_APRO_MARK_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("							, BK.INDIV_PSON_FLG" ).append("\n"); 
		query.append("                            , BK.PRG_FLG" ).append("\n"); 
		query.append("                            , BK.NON_RT_STS_CD" ).append("\n"); 
		query.append("                            , BK.NON_RT_STS_CD" ).append("\n"); 
		query.append("                            , BK.IDA_HLG_TP_CD" ).append("\n"); 
		query.append("					--------BKG ROUTE---" ).append("\n"); 
		query.append("							, BK.SLAN_CD    SLAN_CD" ).append("\n"); 
		query.append("							, BK.SVC_SCP_CD SVC_SCP_CD" ).append("\n"); 
		query.append("					        , BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD BKG_TRUNK_VVD					" ).append("\n"); 
		query.append("					        , BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD BKG_TRUNK_VVD_OLD" ).append("\n"); 
		query.append("					        , BK.POR_CD	BKG_POR_CD				" ).append("\n"); 
		query.append("					        , BK.POR_CD POR_CD_OLD				" ).append("\n"); 
		query.append("							, BL.POR_NM POR_NM" ).append("\n"); 
		query.append("					        , SUBSTR(BK.POR_NOD_CD, 6, 2) BKG_POR_YD_CD		" ).append("\n"); 
		query.append("							, SUBSTR(BK.POR_NOD_CD, 6, 2) POR_YD_CD_OLD  			" ).append("\n"); 
		query.append("					        , BK.POL_CD BKG_POL_CD					" ).append("\n"); 
		query.append("					        , BK.POL_CD	POL_CD_OLD" ).append("\n"); 
		query.append("							, BL.POL_NM POL_NM" ).append("\n"); 
		query.append("					        , SUBSTR(BK.POL_NOD_CD, 6, 2) BKG_POL_YD_CD		" ).append("\n"); 
		query.append("					        , SUBSTR(BK.POL_NOD_CD, 6, 2) POL_YD_CD_OLD		" ).append("\n"); 
		query.append("					        , BK.POD_CD BKG_POD_CD					" ).append("\n"); 
		query.append("					        , BK.POD_CD	POD_CD_OLD" ).append("\n"); 
		query.append("							, BL.POD_NM POD_NM" ).append("\n"); 
		query.append("					        , SUBSTR(BK.POD_NOD_CD, 6, 2) BKG_POD_YD_CD				" ).append("\n"); 
		query.append("					        , SUBSTR(BK.POD_NOD_CD, 6, 2) POD_YD_CD_OLD	" ).append("\n"); 
		query.append("					        , BK.DEL_CD	BKG_DEL_CD				" ).append("\n"); 
		query.append("					        , BK.DEL_CD DEL_CD_OLD" ).append("\n"); 
		query.append("							, BL.DEL_NM DEL_NM" ).append("\n"); 
		query.append("					        , SUBSTR(BK.DEL_NOD_CD, 6, 2) BKG_DEL_YD_CD		" ).append("\n"); 
		query.append("					        , SUBSTR(BK.DEL_NOD_CD, 6, 2) DEL_YD_CD_OLD	" ).append("\n"); 
		query.append("							, BL.FNL_DEST_NM              FNL_DEST_NM" ).append("\n"); 
		query.append("					        , BK.OCP_CD					" ).append("\n"); 
		query.append("					        , BK.RCV_TERM_CD					" ).append("\n"); 
		query.append("					        , BK.RCV_TERM_CD RCV_TERM_CD_OLD" ).append("\n"); 
		query.append("					        , BK.DE_TERM_CD					" ).append("\n"); 
		query.append("					        , BK.DE_TERM_CD DE_TERM_CD_OLD" ).append("\n"); 
		query.append("					        , BK.PRE_RLY_PORT_CD	" ).append("\n"); 
		query.append("					        , SUBSTR(PRE.POD_YD_CD, 6, 2) PRE_RLY_PORT_YD_CD					" ).append("\n"); 
		query.append("					        , PRE.VSL_CD||PRE.SKD_VOY_NO||PRE.SKD_DIR_CD PRE_VVD_CD					" ).append("\n"); 
		query.append("					        , BK.PST_RLY_PORT_CD		" ).append("\n"); 
		query.append("					        , SUBSTR(PST.POL_YD_CD, 6, 2) PST_RLY_PORT_YD_CD			" ).append("\n"); 
		query.append("					        , PST.VSL_CD||PST.SKD_VOY_NO||PST.SKD_DIR_CD PST_VVD_CD	" ).append("\n"); 
		query.append("                            , CUST.CUST_CNT_CD S_CUST_CNT_CD		        " ).append("\n"); 
		query.append("                            , CUST.CUST_SEQ S_CUST_SEQ      	" ).append("\n"); 
		query.append("                            , BK.PCTL_NO" ).append("\n"); 
		query.append("                            , BK.PCTL_NO AS PCTL_NO_OLD                       " ).append("\n"); 
		query.append("					--------CUSTOMS---" ).append("\n"); 
		query.append("					        , BK.USA_CSTMS_FILE_CD				" ).append("\n"); 
		query.append("					        , BK.CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("					        , BK.SCAC_CD							" ).append("\n"); 
		query.append("					        , BK.KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append("					--------CONTRACT---		" ).append("\n"); 
		query.append("							, BK.RFA_NO RFA_NO   " ).append("\n"); 
		query.append("					        , BK.RFA_NO RFA_NO_OLD	" ).append("\n"); 
		query.append("							, '' as RFA_AVAILABLE" ).append("\n"); 
		query.append("                            , BK.SC_NO SC_NO			        				" ).append("\n"); 
		query.append("					        , BK.SC_NO SC_NO_OLD 			" ).append("\n"); 
		query.append("							, '' as SC_AVAILABLE	" ).append("\n"); 
		query.append("                            , BK.TAA_NO TAA_NO			" ).append("\n"); 
		query.append("                            , BK.TAA_NO TAA_NO_OLD	" ).append("\n"); 
		query.append("							, '' as TAA_AVAILABLE			" ).append("\n"); 
		query.append("					        , BK.CTRT_OFC_CD					" ).append("\n"); 
		query.append("					        , BK.CTRT_SREP_CD					" ).append("\n"); 
		query.append("					--------COMMODITY---						" ).append("\n"); 
		query.append("					        , BL.ACT_WGT					" ).append("\n"); 
		query.append("					        , BL.WGT_UT_CD									" ).append("\n"); 
		query.append("					        , BK.CMDT_CD					" ).append("\n"); 
		query.append("					        , BK.CMDT_CD CMDT_CD_OLD" ).append("\n"); 
		query.append("					        , BK.REP_CMDT_CD					" ).append("\n"); 
		query.append("					        , (SELECT CMDT.CMDT_NM FROM MDM_COMMODITY CMDT WHERE BK.CMDT_CD = CMDT.CMDT_CD) CMDT_DESC	" ).append("\n"); 
		query.append("                   ----------DPCS----------------" ).append("\n"); 
		query.append("                            , X.BL_DOC_INP_FLG" ).append("\n"); 
		query.append("                            , X.BL_RT_FLG" ).append("\n"); 
		query.append("                            , X.BL_AUD_FLG" ).append("\n"); 
		query.append("                            , X.BL_DRFT_FAX_OUT_FLG" ).append("\n"); 
		query.append("                            , CASE WHEN NVL(X.RETURN_TO_CD,' ') = ' ' THEN '' ELSE X.FNT_OFC_RTN_CD || ' ' || X.RETURN_TO_CD END AS RETURN_CD  " ).append("\n"); 
		query.append("                            , X.BL_FNT_OFC_FLG" ).append("\n"); 
		query.append("					--------FLEX HEIGHT---" ).append("\n"); 
		query.append("					        , BK.FLEX_HGT_FLG					" ).append("\n"); 
		query.append("					--------SPECIAL CARGO INFO---		 					" ).append("\n"); 
		query.append("					        , BK.DCGO_FLG					" ).append("\n"); 
		query.append("					        , BK.DCGO_FLG DCGO_FLG_OLD" ).append("\n"); 
		query.append("					        , BK.RC_FLG					" ).append("\n"); 
		query.append("					        , BK.RC_FLG RC_FLG_OLD" ).append("\n"); 
		query.append("					        , BK.AWK_CGO_FLG					" ).append("\n"); 
		query.append("					        , BK.AWK_CGO_FLG AWK_CGO_FLG_OLD" ).append("\n"); 
		query.append("					        , BK.BB_CGO_FLG					" ).append("\n"); 
		query.append("					        , BK.BB_CGO_FLG BB_CGO_FLG_OLD" ).append("\n"); 
		query.append("					        , BK.RD_CGO_FLG					" ).append("\n"); 
		query.append("					        , BK.SOC_FLG				" ).append("\n"); 
		query.append("					        , BK.EQ_SUBST_FLG " ).append("\n"); 
		query.append("							, '' as REJECT_FLAG" ).append("\n"); 
		query.append("							, BK.PORT_SKP_FLG" ).append("\n"); 
		query.append("        , NVL((SELECT DSP --A:APPROVE -> 파랑, N:REJECT -> 빨강, P:PENDING, R:RQST, OTHER:SPECIAL CARGO EXIST" ).append("\n"); 
		query.append("				 FROM (SELECT 'N' STS, 1 RANK, 'N' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'P' STS, 2 RANK, 'P' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'R' STS, 3 RANK, 'R' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'Y' STS, 4 RANK, 'A' DSP FROM DUAL" ).append("\n"); 
		query.append("					UNION SELECT 'NULL' STS, 5 RANK, 'Y' DSP FROM DUAL) RANK" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		         	, BKG_DG_CGO_HIS DG" ).append("\n"); 
		query.append("		    WHERE DG.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("			  AND DG.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		            , BKG_DG_CGO DG" ).append("\n"); 
		query.append("		    WHERE DG.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			  AND NVL(DG.SPCL_CGO_APRO_CD, 'NULL') = STS" ).append("\n"); 
		query.append("			  AND ROWNUM = 1), DECODE(BK.DCGO_FLG, 'Y', 'Y', NULL)) DG_FLG" ).append("\n"); 
		query.append("        , NVL((SELECT DSP" ).append("\n"); 
		query.append("				 FROM (SELECT 'N' STS, 1 RANK, 'N' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'P' STS, 2 RANK, 'P' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'R' STS, 3 RANK, 'R' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'Y' STS, 4 RANK, 'A' DSP FROM DUAL" ).append("\n"); 
		query.append("					UNION SELECT 'NULL' STS, 5 RANK, 'Y' DSP FROM DUAL) RANK" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		         	, BKG_RF_CGO_HIS RF" ).append("\n"); 
		query.append("		    WHERE RF.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("			  AND RF.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		            , BKG_RF_CGO RF" ).append("\n"); 
		query.append("		    WHERE RF.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			  AND NVL(RF.SPCL_CGO_APRO_CD, 'NULL') = STS" ).append("\n"); 
		query.append("			  AND ROWNUM = 1), DECODE(BK.RC_FLG, 'Y', 'Y', NULL)) RF_FLG" ).append("\n"); 
		query.append("        , NVL((SELECT DSP" ).append("\n"); 
		query.append("				 FROM (SELECT 'N' STS, 1 RANK, 'N' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'P' STS, 2 RANK, 'P' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'R' STS, 3 RANK, 'R' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'Y' STS, 4 RANK, 'A' DSP FROM DUAL" ).append("\n"); 
		query.append("					UNION SELECT 'NULL' STS, 5 RANK, 'Y' DSP FROM DUAL) RANK" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		         	, BKG_AWK_CGO_HIS AK" ).append("\n"); 
		query.append("		    WHERE AK.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("			  AND AK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		         	, BKG_AWK_CGO AK" ).append("\n"); 
		query.append("		    WHERE AK.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("			  AND NVL(AK.SPCL_CGO_APRO_CD, 'NULL') = STS" ).append("\n"); 
		query.append("			  AND ROWNUM = 1), DECODE(BK.AWK_CGO_FLG, 'Y', 'Y', NULL)) AWK_FLG" ).append("\n"); 
		query.append("        , NVL((SELECT DSP" ).append("\n"); 
		query.append("				 FROM (SELECT 'N' STS, 1 RANK, 'N' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'P' STS, 2 RANK, 'P' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'R' STS, 3 RANK, 'R' DSP FROM DUAL" ).append("\n"); 
		query.append("			        UNION SELECT 'Y' STS, 4 RANK, 'A' DSP FROM DUAL" ).append("\n"); 
		query.append("					UNION SELECT 'NULL' STS, 5 RANK, 'Y' DSP FROM DUAL) RANK" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		         	, BKG_BB_CGO_HIS BB" ).append("\n"); 
		query.append("		    WHERE BB.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("			  AND BB.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		         	, BKG_BB_CGO BB" ).append("\n"); 
		query.append("		    WHERE BB.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("			  AND NVL(BB.SPCL_CGO_APRO_CD, 'NULL') = STS" ).append("\n"); 
		query.append("			  AND ROWNUM = 1), DECODE(BK.BB_CGO_FLG, 'Y', 'Y', NULL)) BB_FLG" ).append("\n"); 
		query.append("					--------STOWAGE-------------------------------------------------------------------	" ).append("\n"); 
		query.append("					        , DECODE(NVL(BK.STWG_CD, 'NULL'), 'NULL', 'N', 'Y') STWG_FLG			" ).append("\n"); 
		query.append("					        , BK.STWG_CD					" ).append("\n"); 
		query.append("					        , BK.STWG_RMK					" ).append("\n"); 
		query.append("					        , BK.HNGR_FLG		" ).append("\n"); 
		query.append("					--------STOP OFF---" ).append("\n"); 
		query.append("							, DECODE(NVL(BK.STOP_OFF_LOC_CD, 'NULL'), 'NULL', 'N', 'Y') STOP_OFF_FLG			" ).append("\n"); 
		query.append("					        , BK.STOP_OFF_LOC_CD					" ).append("\n"); 
		query.append("					        , BK.STOP_OFF_CNTC_PSON_NM				" ).append("\n"); 
		query.append("					        , BK.STOP_OFF_CNTC_PHN_NO					" ).append("\n"); 
		query.append("					        , BK.STOP_OFF_DIFF_RMK					" ).append("\n"); 
		query.append("					--------FUMIGATION---" ).append("\n"); 
		query.append("							, DECODE(NVL(BK.FUMG_LOC_CD, 'NULL'), 'NULL', 'N', 'Y') FUMG_FLG			" ).append("\n"); 
		query.append("					        , BK.FUMG_LOC_CD					" ).append("\n"); 
		query.append("					        , BK.FUMG_CNTC_PSON_NM				" ).append("\n"); 
		query.append("					        , BK.FUMG_CNTC_PHN_NO					" ).append("\n"); 
		query.append("					        , BK.FUMG_DIFF_RMK	" ).append("\n"); 
		query.append("					--------ETC CGO TYPE---" ).append("\n"); 
		query.append("					        , BK.RAIL_BLK_CD			" ).append("\n"); 
		query.append("					        , BK.SPCL_HIDE_FLG	" ).append("\n"); 
		query.append("					        , BK.SPCL_HIDE_LNR_FLG					" ).append("\n"); 
		query.append("					        , BK.FD_GRD_FLG					" ).append("\n"); 
		query.append("					        , BK.PRCT_FLG --PRECAUTION" ).append("\n"); 
		query.append("					        , BK.VEH_CMDT_FLG --VEHICLE" ).append("\n"); 
		query.append("					        , BK.TWN_SO_NO				" ).append("\n"); 
		query.append("					        , BK.BKG_CGO_TP_CD --'R'=REVENUE EMPTY, 'P'=EMPTY REPO, 'F'=NORMAL FULL BKG" ).append("\n"); 
		query.append("					        , BK.CRR_SOC_FLG" ).append("\n"); 
		query.append("					        , BK.NON_DG_CHEM_FLG" ).append("\n"); 
		query.append("					--------PLANNED DELIVERY SCHEDULE---" ).append("\n"); 
		query.append("					        , TO_CHAR(BK.MTY_DOR_ARR_DT,  'YYYY-MM-DD') MTY_DOR_ARR_DT					" ).append("\n"); 
		query.append("					        , TO_CHAR(BK.MTY_DOR_ARR_DT,  'YYYY-MM-DD') MTY_DOR_ARR_DT_OLD" ).append("\n"); 
		query.append("					        , TO_CHAR(BK.LODG_DUE_DT,     'YYYY-MM-DD') LODG_DUE_DT					" ).append("\n"); 
		query.append("					        , TO_CHAR(BK.LODG_DUE_DT,     'YYYY-MM-DD') LODG_DUE_DT_OLD" ).append("\n"); 
		query.append("					        , TO_CHAR(BK.DE_DUE_DT,       'YYYY-MM-DD') DE_DUE_DT					" ).append("\n"); 
		query.append("					        , TO_CHAR(BK.DE_DUE_DT,       'YYYY-MM-DD') DE_DUE_DT_OLD" ).append("\n"); 
		query.append("					--------EMPTY CNTR P/UP, RTN CY---" ).append("\n"); 
		query.append("					        , BK.MTY_PKUP_YD_CD					" ).append("\n"); 
		query.append("					        , BK.MTY_PKUP_YD_CD MTY_PKUP_YD_CD_OLD" ).append("\n"); 
		query.append("					        , TO_CHAR(BK.MTY_PKUP_DT,     'YYYY-MM-DD') MTY_PKUP_DT					" ).append("\n"); 
		query.append("					        , TO_CHAR(BK.MTY_PKUP_DT,     'YYYY-MM-DD') MTY_PKUP_DT_OLD" ).append("\n"); 
		query.append("					        , BK.FULL_RTN_YD_CD					" ).append("\n"); 
		query.append("					        , BK.FULL_RTN_YD_CD	FULL_RTN_YD_CD_OLD" ).append("\n"); 
		query.append("                            , BK.MTY_RTN_YD_CD" ).append("\n"); 
		query.append("							, BK.FULL_PKUP_YD_CD		" ).append("\n"); 
		query.append("					--------PARTIAL BKG---ROUTE 변경하고 저장시 PARTIAL CHANGE POP-UP" ).append("\n"); 
		query.append("        , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')        					 " ).append("\n"); 
		query.append("        		 FROM BKG_BKG_HIS BK1, BKG_CNTR_HIS CNTR1" ).append("\n"); 
		query.append("            		, BKG_BOOKING BK2, BKG_CONTAINER CNTR2" ).append("\n"); 
		query.append("        		WHERE BK1.BKG_NO      	= CNTR1.BKG_NO " ).append("\n"); 
		query.append("        		  AND BK2.BKG_NO        = CNTR2.BKG_NO" ).append("\n"); 
		query.append("				  AND BK1.CORR_NO 		= 'TMP0000001'" ).append("\n"); 
		query.append("				  AND CNTR1.CORR_NO 	= 'TMP0000001'" ).append("\n"); 
		query.append("#else                	" ).append("\n"); 
		query.append("            	 FROM BKG_BOOKING BK1, BKG_CONTAINER CNTR1" ).append("\n"); 
		query.append("            		, BKG_BOOKING BK2, BKG_CONTAINER CNTR2" ).append("\n"); 
		query.append("            	WHERE BK1.BKG_NO        = CNTR1.BKG_NO " ).append("\n"); 
		query.append("            	  AND BK2.BKG_NO        = CNTR2.BKG_NO" ).append("\n"); 
		query.append("#end         					" ).append("\n"); 
		query.append("            	  AND BK1.BKG_NO        <> BK2.BKG_NO   --다른 BKG" ).append("\n"); 
		query.append("                  AND CNTR1.CNTR_NO     = CNTR2.CNTR_NO --같은 CNTR" ).append("\n"); 
		query.append("                  AND BK1.BKG_CGO_TP_CD = BK2.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                  AND BK1.POL_CD        = BK2.POL_CD" ).append("\n"); 
		query.append("                  AND BK1.POD_CD        = BK2.POD_CD" ).append("\n"); 
		query.append("                  AND BK1.VSL_CD        = BK2.VSL_CD" ).append("\n"); 
		query.append("                  AND BK1.SKD_VOY_NO    = BK2.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND BK1.SKD_DIR_CD    = BK2.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND CNTR1.CNTR_PRT_FLG= 'Y'" ).append("\n"); 
		query.append("                  AND CNTR2.CNTR_PRT_FLG= 'Y'" ).append("\n"); 
		query.append("				  AND BK1.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("				  AND BK2.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("                  AND BK1.BKG_NO        = BK.BKG_NO" ).append("\n"); 
		query.append("                  AND ROWNUM = 1), 'N') PARTIAL_VVD_ASSIGN_FLG" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')        					 " ).append("\n"); 
		query.append("		, NVL((SELECT 'Y' FROM BKG_CNTR_HIS CNTR WHERE CNTR.BKG_NO = BK.BKG_NO AND ROWNUM = 1), 'N') CNTR_FLG" ).append("\n"); 
		query.append("#else                	" ).append("\n"); 
		query.append("		, NVL((SELECT 'Y' FROM BKG_CONTAINER CNTR WHERE CNTR.BKG_NO = BK.BKG_NO AND ROWNUM = 1), 'N') CNTR_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					--------SVC MODE, ROUTE---" ).append("\n"); 
		query.append("					        , BK.ORG_SCONTI_CD  		" ).append("\n"); 
		query.append("					        , BK.DEST_SCONTI_CD 					" ).append("\n"); 
		query.append("					        , BK.ORG_TRNS_SVC_MOD_CD	" ).append("\n"); 
		query.append("					        , BK.DEST_TRNS_SVC_MOD_CD	" ).append("\n"); 
		query.append("					        , BK.ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append("					        , BK.DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("					        , BK.BLCK_STWG_CD	" ).append("\n"); 
		query.append("					--------REFERENCE NO---" ).append("\n"); 
		query.append("        , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')        					 " ).append("\n"); 
		query.append("           	     FROM BKG_REF_HIS REFNO" ).append("\n"); 
		query.append("		 	    WHERE REFNO.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("				  AND REFNO.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else                	" ).append("\n"); 
		query.append("                 FROM BKG_REFERENCE REFNO" ).append("\n"); 
		query.append("				WHERE REFNO.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#end    					  " ).append("\n"); 
		query.append("         		  AND BKG_REF_TP_CD IN ('EBRF', 'EBSH' ,'EBFF', 'RGBK', 'ESRF', 'ESSH', 'ESFF', 'FINV')" ).append("\n"); 
		query.append("         		  AND ROWNUM = 1" ).append("\n"); 
		query.append("								), 'N') REF_FLG" ).append("\n"); 
		query.append("					--------ROLL OVER INFO---" ).append("\n"); 
		query.append("						 	, (SELECT COUNT(1) FROM BKG_ROLL_OVR ROL WHERE ROL.BKG_NO = BK.BKG_NO) ROLL_OVR_CNT  " ).append("\n"); 
		query.append("					--------BKG STAFF INFO---" ).append("\n"); 
		query.append("					        , BK.OB_SLS_OFC_CD					" ).append("\n"); 
		query.append("					        , BK.OB_SREP_CD       								" ).append("\n"); 
		query.append("					        , BK.BKG_OFC_CD					" ).append("\n"); 
		query.append("					        , USR.USR_NM		" ).append("\n"); 
		query.append("					        , BK.DOC_USR_ID		" ).append("\n"); 
		query.append("					        , USR.OFC_CD" ).append("\n"); 
		query.append("					        , USR.USR_EML" ).append("\n"); 
		query.append("							, USR.XTN_PHN_NO" ).append("\n"); 
		query.append("					--------EXTERNAL REQUEST---" ).append("\n"); 
		query.append("					        , NVL(" ).append("\n"); 
		query.append("							  (SELECT A.XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("								 FROM BKG_XTER_RQST_MST A" ).append("\n"); 
		query.append("							    WHERE A.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("							      AND A.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("                   				  AND TO_CHAR(A.UPLD_GDT,'YYYYMMDDHH24MISS')||A.XTER_RQST_SEQ = " ).append("\n"); 
		query.append("				                                  (SELECT MAX(TO_CHAR(B.UPLD_GDT,'YYYYMMDDHH24MISS')||B.XTER_RQST_SEQ)" ).append("\n"); 
		query.append("			  					                     FROM BKG_XTER_RQST_MST B" ).append("\n"); 
		query.append("								                    WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("													  AND B.UPLD_GDT IS NOT NULL" ).append("\n"); 
		query.append("									                  AND B.DOC_TP_CD = 'B'))" ).append("\n"); 
		query.append("							      , DECODE(BK.XTER_BKG_RQST_CD, 'NIS', 'OFF', 'APS', 'OFF', BK.XTER_BKG_RQST_CD)) XTER_BKG_RQST_CD" ).append("\n"); 
		query.append("							, BK.XTER_BKG_RQST_REF_NO				" ).append("\n"); 
		query.append("					        , NVL(" ).append("\n"); 
		query.append("							  (SELECT A.XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("								 FROM BKG_XTER_RQST_MST A" ).append("\n"); 
		query.append("							    WHERE A.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("							      AND A.DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("                   				  AND TO_CHAR(A.UPLD_GDT,'YYYYMMDDHH24MISS')||A.XTER_RQST_SEQ = " ).append("\n"); 
		query.append("				                                  (SELECT MAX(TO_CHAR(B.UPLD_GDT,'YYYYMMDDHH24MISS')||B.XTER_RQST_SEQ)" ).append("\n"); 
		query.append("			  					                     FROM BKG_XTER_RQST_MST B" ).append("\n"); 
		query.append("								                    WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("													  AND B.UPLD_GDT IS NOT NULL" ).append("\n"); 
		query.append("									                  AND B.DOC_TP_CD = 'S')) " ).append("\n"); 
		query.append("							      , DECODE(BK.XTER_SI_CD, 'NIS', 'OFF', 'APS', 'OFF', BK.XTER_SI_CD)) XTER_SI_CD" ).append("\n"); 
		query.append("							, BK.XTER_SI_REF_NO" ).append("\n"); 
		query.append("							, BK.XTER_RQST_AUTO_NTC_FLG" ).append("\n"); 
		query.append("					--------REMARK---" ).append("\n"); 
		query.append("					        , BK.INTER_RMK					" ).append("\n"); 
		query.append("					        , BK.XTER_RMK " ).append("\n"); 
		query.append("					--------MANUAL CCT---" ).append("\n"); 
		query.append("						 	, NVL((SELECT 'Y' FROM BKG_CLZ_TM CLZ " ).append("\n"); 
		query.append("                                    WHERE CLZ.BKG_NO = BK.BKG_NO AND MNL_SET_DT IS NOT NULL AND ROWNUM = 1),'N') MNL_CCT_FLG  " ).append("\n"); 
		query.append("					--------ETC---				" ).append("\n"); 
		query.append("					        , BK.AGMT_ACT_CNT_CD					" ).append("\n"); 
		query.append("					        , DECODE(BK.AGMT_ACT_CUST_SEQ,0,'',BK.AGMT_ACT_CUST_SEQ) AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("					        , TO_CHAR(BK.BKG_CRE_DT,'YYYYMMDDHH24MI') BKG_CRE_DT" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')        					 " ).append("\n"); 
		query.append("		, (SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("			 FROM BKG_REF_HIS R " ).append("\n"); 
		query.append("			WHERE R.BKG_REF_TP_CD 	= 'FMCN' " ).append("\n"); 
		query.append("		 	  AND R.BKG_NO 			= BK.BKG_NO " ).append("\n"); 
		query.append("			  AND R.CORR_NO 		= 'TMP0000001'" ).append("\n"); 
		query.append("			  AND rownum = 1) FMC_NO" ).append("\n"); 
		query.append("#else                	" ).append("\n"); 
		query.append("		, (SELECT CUST_REF_NO_CTNT " ).append("\n"); 
		query.append("			 FROM BKG_REFERENCE R " ).append("\n"); 
		query.append("		    WHERE R.BKG_REF_TP_CD 	= 'FMCN' " ).append("\n"); 
		query.append("			  AND R.BKG_NO 			= BK.BKG_NO" ).append("\n"); 
		query.append("			  AND rownum = 1) FMC_NO" ).append("\n"); 
		query.append("#end    					  " ).append("\n"); 
		query.append("					--------ONLY FOR VO---" ).append("\n"); 
		query.append("							, '' AS REV_DIR_CD" ).append("\n"); 
		query.append("							, '' AS FIRST_POL_CD" ).append("\n"); 
		query.append("							, '' AS FIRST_POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("							, '' AS FIRST_VVD_CD" ).append("\n"); 
		query.append("							, '' AS LAST_POD_CD" ).append("\n"); 
		query.append("							, '' AS LAST_POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("							, '' AS LAST_VVD_CD" ).append("\n"); 
		query.append("							, '' AS CRE_USR_ID" ).append("\n"); 
		query.append("							, '' AS UPD_USR_ID" ).append("\n"); 
		query.append("							, '' AS VVD_FLAG" ).append("\n"); 
		query.append("							, '' AS FILER_CD" ).append("\n"); 
		query.append("							, '' AS IS_RATED_FLG" ).append("\n"); 
		query.append("							, '' AS EUR_TRO_CFM" ).append("\n"); 
		query.append("							, '' AS TVVD_MODIFY_FLG	" ).append("\n"); 
		query.append("							, '' AS HOT_DE_FLG" ).append("\n"); 
		query.append("							, '' AS PREMIUM_AVAILABLE_FLG" ).append("\n"); 
		query.append("							, '' AS WEB_SVC_FLG" ).append("\n"); 
		query.append("							, '' AS ACT_CUST_LIST_EXIST_FLG" ).append("\n"); 
		query.append("					--------추후에 SQL 통합 고려---" ).append("\n"); 
		query.append("							, '' AS BKG_CNTC_PSON_NM" ).append("\n"); 
		query.append("							, '' AS BKG_CNTC_PSON_EML" ).append("\n"); 
		query.append("							, '' AS BKG_CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("							, '' AS BKG_CNTC_PSON_MPHN_NO" ).append("\n"); 
		query.append("							, '' AS BKG_CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("							, '' AS SI_CNTC_PSON_NM" ).append("\n"); 
		query.append("							, '' AS SI_CNTC_PSON_EML" ).append("\n"); 
		query.append("							, '' AS SI_CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("							, '' AS SI_CNTC_PSON_MPHN_NO" ).append("\n"); 
		query.append("							, '' AS SI_CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		              FROM 	BKG_BKG_HIS BK," ).append("\n"); 
		query.append("					  		BKG_BL_DOC_HIS BL, " ).append("\n"); 
		query.append("					  		BKG_VVD_HIS PRE, 	" ).append("\n"); 
		query.append("					  		BKG_VVD_HIS PST,   " ).append("\n"); 
		query.append("							BKG_BL_ISS_HIS ISS, " ).append("\n"); 
		query.append("							BKG_CUST_HIS CUST," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		              FROM 	BKG_BOOKING BK," ).append("\n"); 
		query.append("					  		BKG_BL_DOC BL, 	" ).append("\n"); 
		query.append("					  		BKG_VVD PRE, 	" ).append("\n"); 
		query.append("					  		BKG_VVD PST,    " ).append("\n"); 
		query.append("							BKG_BL_ISS ISS," ).append("\n"); 
		query.append("							BKG_CUSTOMER CUST," ).append("\n"); 
		query.append("#end    					" ).append("\n"); 
		query.append("					  		COM_USER USR," ).append("\n"); 
		query.append("                            (SELECT DECODE(DECODE (A.SR_CRNT_INFO_CD,'R','RT','T','TF'),'RT','<<-','TF','->>',NULL) AS RETURN_TO_CD" ).append("\n"); 
		query.append("                                          ,(SELECT DECODE(H.FNT_OFC_RTN_CD,'S','FO','I','Inputer','R','Rater','C','Customer','P','S.REP') " ).append("\n"); 
		query.append("                                              FROM BKG_SR_HIS H " ).append("\n"); 
		query.append("                                             WHERE H.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("                                               AND H.SR_NO = A.SR_NO " ).append("\n"); 
		query.append("                                               AND H.SR_KND_CD = A.SR_KND_CD " ).append("\n"); 
		query.append("                                               AND H.SR_STS_CD = 'RR' " ).append("\n"); 
		query.append("                                               AND H.SR_HIS_SEQ = (SELECT MAX(H2.SR_HIS_SEQ)" ).append("\n"); 
		query.append("                                                                     FROM BKG_SR_HIS H2" ).append("\n"); 
		query.append("                                                                    WHERE H.BKG_NO = H2.BKG_NO  " ).append("\n"); 
		query.append("                                                                      AND H.SR_NO = H2.SR_NO " ).append("\n"); 
		query.append("                                                                      AND H2.SR_STS_CD = 'RR' " ).append("\n"); 
		query.append("                                                                      AND H.SR_KND_CD = H2.SR_KND_CD)) AS FNT_OFC_RTN_CD 								" ).append("\n"); 
		query.append("                                          ,A.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("                                          ,NVL(A.BL_DOC_INP_FLG,'N') AS BL_DOC_INP_FLG" ).append("\n"); 
		query.append("                                          ,NVL(A.BL_RT_FLG,'N') AS BL_RT_FLG" ).append("\n"); 
		query.append("                                          ,NVL(A.BL_AUD_FLG,'N') AS BL_AUD_FLG" ).append("\n"); 
		query.append("                                          ,NVL(A.BL_DRFT_FAX_OUT_FLG,'N') AS BL_DRFT_FAX_OUT_FLG" ).append("\n"); 
		query.append("                                          ,NVL(A.BL_FNT_OFC_FLG,'N') AS BL_FNT_OFC_FLG" ).append("\n"); 
		query.append("                                      FROM BKG_SR_CRNT_RQST A" ).append("\n"); 
		query.append("                                          ,BKG_BOOKING B" ).append("\n"); 
		query.append("                                          ,BKG_XTER_RQST_MST XTER" ).append("\n"); 
		query.append("                                     WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                       AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                       AND A.XTER_SNDR_ID       = XTER.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("                                       AND A.XTER_RQST_NO       = XTER.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("                                       AND A.XTER_RQST_SEQ      = XTER.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                                       AND NVL(XTER.SNACCS_MSG_TP_CD, ' ')  NOT IN ( 'SAT050', 'SAT054','SAT141','SAT142','SAT146','SAT147' )" ).append("\n"); 
		query.append("                                       AND A.SR_AMD_SEQ = (SELECT MAX(SR_AMD_SEQ)" ).append("\n"); 
		query.append("                                                             FROM BKG_SR_CRNT_RQST B" ).append("\n"); 
		query.append("                                                            WHERE B.BKG_NO = A.BKG_NO) " ).append("\n"); 
		query.append("                                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                                                    ) X                            " ).append("\n"); 
		query.append("					 WHERE BK.BKG_NO         = BL.BKG_NO			" ).append("\n"); 
		query.append("					   AND BK.BKG_NO		 = ISS.BKG_NO(+)		" ).append("\n"); 
		query.append("					   AND BK.BKG_NO         = PRE.BKG_NO(+)" ).append("\n"); 
		query.append("                       AND BK.BKG_NO         = X.BKG_NO (+)" ).append("\n"); 
		query.append("                       AND BK.BKG_NO         = CUST.BKG_NO (+)" ).append("\n"); 
		query.append("					   AND 'S'				 = CUST.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("					   AND 'S'               = PRE.VSL_PRE_PST_CD(+)					" ).append("\n"); 
		query.append("					   AND BK.PRE_RLY_PORT_CD= PRE.POD_CD(+)					" ).append("\n"); 
		query.append("					   AND BK.BKG_NO         = PST.BKG_NO(+)					" ).append("\n"); 
		query.append("					   AND BK.PST_RLY_PORT_CD= PST.POL_CD(+)					" ).append("\n"); 
		query.append("					   AND 'U'               = PST.VSL_PRE_PST_CD(+)			" ).append("\n"); 
		query.append("					   AND UPPER(BK.DOC_USR_ID) = UPPER(USR.USR_ID(+))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("					   AND BK.CORR_NO 		 = 'TMP0000001'" ).append("\n"); 
		query.append("					   AND BL.CORR_NO 		 = 'TMP0000001'" ).append("\n"); 
		query.append("					   AND CUST.CORR_NO(+) 	 = 'TMP0000001'" ).append("\n"); 
		query.append("					   AND ISS.CORR_NO(+)	 = 'TMP0000001'" ).append("\n"); 
		query.append("					   AND PRE.CORR_NO(+) 	 = 'TMP0000001'" ).append("\n"); 
		query.append("					   AND PST.CORR_NO(+) 	 = 'TMP0000001'" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("					   AND BK.BKG_NO         = @[bkg_no]" ).append("\n"); 

	}
}