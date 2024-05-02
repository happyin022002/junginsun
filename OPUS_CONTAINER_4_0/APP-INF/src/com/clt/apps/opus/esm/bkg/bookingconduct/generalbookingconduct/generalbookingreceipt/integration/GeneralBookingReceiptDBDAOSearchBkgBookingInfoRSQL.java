/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgBookingInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
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
		query.append("SELECT                       				" ).append("\n"); 
		query.append("							BK.BKG_PTY_CUST_CNT_CD AS BKG_PTY_CNT_CD" ).append("\n"); 
		query.append("							, BK.BKG_PTY_CUST_SEQ" ).append("\n"); 
		query.append("							, (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = BK.BKG_PTY_CUST_CNT_CD AND CUST_SEQ = BK.BKG_PTY_CUST_SEQ) AS BKG_PTY_CUST_NM" ).append("\n"); 
		query.append("							, BK.BKG_NO	" ).append("\n"); 
		query.append("							, BK.IRR_BL_NO_FLG	" ).append("\n"); 
		query.append("							, BK.BKG_WT_CHK_FLG" ).append("\n"); 
		query.append("					        , BK.BKG_NO         OLD_BKG_NO	 " ).append("\n"); 
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
		query.append("					        , BK.BKG_STS_CD		" ).append("\n"); 
		query.append("							, BK.IRR_BL_NO_FLG			" ).append("\n"); 
		query.append("					        , DECODE(BK.WT_RSN_SPCL_CGO_FLG||BK.WT_RSN_HLD_FLG 					" ).append("\n"); 
		query.append("					                , 'YN', 'Special Cargo Non Approval'					" ).append("\n"); 
		query.append("					                , 'NY', 'User holding'					" ).append("\n"); 
		query.append("					                , 'YY', 'SPC CGO non APVL & User hold', ' ') WAIT_RSN					" ).append("\n"); 
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
		query.append("					        , PST.VSL_CD||PST.SKD_VOY_NO||PST.SKD_DIR_CD PST_VVD_CD		" ).append("\n"); 
		query.append("                            , BK.PCTL_NO					" ).append("\n"); 
		query.append("					--------CUSTOMS---" ).append("\n"); 
		query.append("					        , BK.USA_CSTMS_FILE_CD				" ).append("\n"); 
		query.append("					        , BK.CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("					        , BK.SCAC_CD" ).append("\n"); 
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
		query.append("        , NVL((" ).append("\n"); 
		query.append("               SELECT DSP --A:APPROVE -> 파랑, N:REJECT -> 빨강, P:PENDING, R:RQST, OTHER:SPECIAL CARGO EXIST" ).append("\n"); 
		query.append("                 FROM (SELECT NVL(DG.SPCL_CGO_APRO_CD,'Y') AS DSP" ).append("\n"); 
		query.append("                         FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("#if ('Y'==${ca_flg})" ).append("\n"); 
		query.append("                            , BKG_DG_CGO_HIS DG" ).append("\n"); 
		query.append("                        WHERE DG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                          AND 'TMP0000001' = DG.CORR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                            , BKG_DG_CGO DG" ).append("\n"); 
		query.append("                        WHERE DG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          AND 'CD01955' = CD.INTG_CD_ID(+)" ).append("\n"); 
		query.append("                          AND DG.SPCL_CGO_APRO_CD = CD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("                        ORDER BY CD.INTG_CD_VAL_DP_SEQ)" ).append("\n"); 
		query.append("                WHERE 1 = ROWNUM" ).append("\n"); 
		query.append("          ), DECODE(BK.DCGO_FLG, 'Y', 'Y', NULL)) DG_FLG" ).append("\n"); 
		query.append("        , NVL((" ).append("\n"); 
		query.append("               SELECT DSP" ).append("\n"); 
		query.append("                 FROM (SELECT NVL(RF.SPCL_CGO_APRO_CD,'Y') AS DSP" ).append("\n"); 
		query.append("                         FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("#if ('Y'==${ca_flg})" ).append("\n"); 
		query.append("                            , BKG_RF_CGO_HIS RF" ).append("\n"); 
		query.append("                        WHERE RF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                          AND 'TMP0000001' = RF.CORR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                            , BKG_RF_CGO RF" ).append("\n"); 
		query.append("                        WHERE RF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          AND 'CD01955' = CD.INTG_CD_ID(+)" ).append("\n"); 
		query.append("                          AND RF.SPCL_CGO_APRO_CD = CD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("                        ORDER BY CD.INTG_CD_VAL_DP_SEQ)" ).append("\n"); 
		query.append("                WHERE 1 = ROWNUM" ).append("\n"); 
		query.append("          ), DECODE(BK.RC_FLG, 'Y', 'Y', NULL)) RF_FLG" ).append("\n"); 
		query.append("        , NVL((" ).append("\n"); 
		query.append("               SELECT DSP" ).append("\n"); 
		query.append("                 FROM (SELECT NVL(AK.SPCL_CGO_APRO_CD,'Y') AS DSP" ).append("\n"); 
		query.append("                         FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("#if ('Y'==${ca_flg})" ).append("\n"); 
		query.append("                            , BKG_AWK_CGO_HIS AK" ).append("\n"); 
		query.append("                        WHERE AK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                          AND 'TMP0000001' = AK.CORR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                            , BKG_AWK_CGO AK" ).append("\n"); 
		query.append("                        WHERE AK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          AND 'CD01955' = CD.INTG_CD_ID(+)" ).append("\n"); 
		query.append("                          AND AK.SPCL_CGO_APRO_CD = CD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("                        ORDER BY CD.INTG_CD_VAL_DP_SEQ)" ).append("\n"); 
		query.append("                WHERE 1 = ROWNUM" ).append("\n"); 
		query.append("          ), DECODE(BK.AWK_CGO_FLG, 'Y', 'Y', NULL)) AWK_FLG" ).append("\n"); 
		query.append("        , NVL((" ).append("\n"); 
		query.append("               SELECT DSP" ).append("\n"); 
		query.append("                 FROM (SELECT NVL(BB.SPCL_CGO_APRO_CD,'Y') AS DSP" ).append("\n"); 
		query.append("                         FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("#if ('Y'==${ca_flg})" ).append("\n"); 
		query.append("                            , BKG_BB_CGO_HIS BB" ).append("\n"); 
		query.append("                        WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                          AND 'TMP0000001' = BB.CORR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                            , BKG_BB_CGO BB" ).append("\n"); 
		query.append("                        WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          AND 'CD01955' = CD.INTG_CD_ID(+)" ).append("\n"); 
		query.append("                          AND BB.SPCL_CGO_APRO_CD = CD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("                        ORDER BY CD.INTG_CD_VAL_DP_SEQ)" ).append("\n"); 
		query.append("                WHERE 1 = ROWNUM" ).append("\n"); 
		query.append("          ), DECODE(BK.BB_CGO_FLG, 'Y', 'Y', NULL)) BB_FLG" ).append("\n"); 
		query.append("					--------STOWAGE-------------------------------------------------------------------	" ).append("\n"); 
		query.append("					        --, DECODE(NVL(BK.STWG_CD, 'NULL'), 'NULL', 'N', 'Y') STWG_FLG			" ).append("\n"); 
		query.append("					        --, BK.STWG_CD					" ).append("\n"); 
		query.append("					        --, BK.STWG_RMK					" ).append("\n"); 
		query.append("					        , DECODE(NVL(STW.STWG_CD, 'NULL'), 'NULL', 'N', 'Y') STWG_FLG			" ).append("\n"); 
		query.append("					        , STW.STWG_CD					" ).append("\n"); 
		query.append("					        , STW.STWG_RMK					" ).append("\n"); 
		query.append("					        , BK.HNGR_FLG		" ).append("\n"); 
		query.append("					--------STOP OFF---" ).append("\n"); 
		query.append("							, DECODE(NVL(BK.STOP_OFF_LOC_CD, 'NULL'), 'NULL', 'N', 'Y') STOP_OFF_FLG			" ).append("\n"); 
		query.append("					        , BK.STOP_OFF_LOC_CD					" ).append("\n"); 
		query.append("					        , BK.STOP_OFF_CNTC_PSON_NM				" ).append("\n"); 
		query.append("					        , BK.STOP_OFF_CNTC_PHN_NO					" ).append("\n"); 
		query.append("					        , BK.STOP_OFF_DIFF_RMK					" ).append("\n"); 
		query.append("					--------ETC CGO TYPE---" ).append("\n"); 
		query.append("					        , BK.RAIL_BLK_CD					" ).append("\n"); 
		query.append("					        , BK.HOT_DE_FLG					" ).append("\n"); 
		query.append("					        , BK.SPCL_HIDE_FLG					" ).append("\n"); 
		query.append("					        , BK.FD_GRD_FLG					" ).append("\n"); 
		query.append("					        , BK.PRCT_FLG --PRECAUTION" ).append("\n"); 
		query.append("					        , BK.TWN_SO_NO				" ).append("\n"); 
		query.append("					        , BK.BKG_CGO_TP_CD --'R'=REVENUE EMPTY, 'P'=EMPTY REPO, 'F'=NORMAL FULL BKG" ).append("\n"); 
		query.append("        , NVL((SELECT 'Y' --PREMIUM(HOT DELIVERY)를 선택할 수 있는 화주임" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')        					 " ).append("\n"); 
		query.append("        		FROM BKG_CUST_HIS CUST, MDM_CUSTOMER MDM_CUST" ).append("\n"); 
		query.append("               WHERE CUST.BKG_NO      = BK.BKG_NO" ).append("\n"); 
		query.append("			     AND CUST.CORR_NO     = 'TMP0000001'" ).append("\n"); 
		query.append("#else                	" ).append("\n"); 
		query.append("                FROM BKG_CUSTOMER CUST, MDM_CUSTOMER MDM_CUST" ).append("\n"); 
		query.append("               WHERE CUST.BKG_NO      = BK.BKG_NO" ).append("\n"); 
		query.append("#end    					  " ).append("\n"); 
		query.append("                 AND CUST.CUST_CNT_CD = MDM_CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("                 AND CUST.CUST_SEQ    = MDM_CUST.CUST_SEQ" ).append("\n"); 
		query.append("                 AND CUST.BKG_CUST_TP_CD IN ('S', 'F')" ).append("\n"); 
		query.append("                 AND MDM_CUST.VBS_CLSS_CD = '01'" ).append("\n"); 
		query.append("                 AND ROWNUM = 1), 'N') PREMIUM_AVAILABLE_FLG" ).append("\n"); 
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
		query.append("					        , decode(BK.XTER_BKG_RQST_CD, 'CLT', 'OFF', BK.XTER_BKG_RQST_CD) XTER_BKG_RQST_CD" ).append("\n"); 
		query.append("							, BK.XTER_VGM_RQST_CD" ).append("\n"); 
		query.append("							, BK.XTER_BKG_RQST_REF_NO				" ).append("\n"); 
		query.append("					        , decode(BK.XTER_SI_CD, 'CLT', 'OFF', BK.XTER_SI_CD) XTER_SI_CD" ).append("\n"); 
		query.append("							, BK.XTER_SI_REF_NO" ).append("\n"); 
		query.append("							, BK.XTER_RQST_AUTO_NTC_FLG" ).append("\n"); 
		query.append("					--------REMARK---" ).append("\n"); 
		query.append("					        , BK.INTER_RMK					" ).append("\n"); 
		query.append("					        , BK.XTER_RMK        	" ).append("\n"); 
		query.append("                            , BK.VNDR_RMK" ).append("\n"); 
		query.append("					--------ETC---				" ).append("\n"); 
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
		query.append("#end    			--------CONTRACT Party---	" ).append("\n"); 
		query.append("							, BK.BKG_CTRL_PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("							, BK.BKG_CTRL_PTY_CUST_SEQ		" ).append("\n"); 
		query.append("							, (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER MDM WHERE MDM.CUST_CNT_CD = BK.BKG_CTRL_PTY_CUST_CNT_CD AND MDM.CUST_SEQ = BK.BKG_CTRL_PTY_CUST_SEQ AND DELT_FLG ='N')  BKG_CTRL_PTY_CUST_NM" ).append("\n"); 
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
		query.append("							BKG_BL_ISS_HIS ISS," ).append("\n"); 
		query.append("							BKG_STWG_CGO_HIS STW, " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		              FROM 	BKG_BOOKING BK," ).append("\n"); 
		query.append("					  		BKG_BL_DOC BL, 	" ).append("\n"); 
		query.append("					  		BKG_VVD PRE, 	" ).append("\n"); 
		query.append("					  		BKG_VVD PST,    " ).append("\n"); 
		query.append("							BKG_BL_ISS ISS," ).append("\n"); 
		query.append("							BKG_STWG_CGO STW," ).append("\n"); 
		query.append("#end    					" ).append("\n"); 
		query.append("					  		COM_USER USR					" ).append("\n"); 
		query.append("					 WHERE BK.BKG_NO         = BL.BKG_NO			" ).append("\n"); 
		query.append("					   AND BK.BKG_NO		 = ISS.BKG_NO(+)		" ).append("\n"); 
		query.append("					   AND BK.BKG_NO         = PRE.BKG_NO(+)					" ).append("\n"); 
		query.append("					   AND 'S'               = PRE.VSL_PRE_PST_CD(+)					" ).append("\n"); 
		query.append("					   AND BK.PRE_RLY_PORT_CD= PRE.POD_CD(+)					" ).append("\n"); 
		query.append("					   AND BK.BKG_NO         = PST.BKG_NO(+)					" ).append("\n"); 
		query.append("					   AND BK.PST_RLY_PORT_CD= PST.POL_CD(+)					" ).append("\n"); 
		query.append("					   AND 'U'               = PST.VSL_PRE_PST_CD(+)			" ).append("\n"); 
		query.append("					   AND UPPER(BK.DOC_USR_ID) = UPPER(USR.USR_ID(+))" ).append("\n"); 
		query.append("					   AND BK.BKG_NO		 = STW.BKG_NO(+)" ).append("\n"); 
		query.append("					   AND 1		 		 = STW.STWG_SEQ(+)" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("					   AND BK.CORR_NO 		 = 'TMP0000001'" ).append("\n"); 
		query.append("					   AND BL.CORR_NO 		 = 'TMP0000001'" ).append("\n"); 
		query.append("					   AND ISS.CORR_NO(+)	 = 'TMP0000001'" ).append("\n"); 
		query.append("					   AND PRE.CORR_NO(+) 	 = 'TMP0000001'" ).append("\n"); 
		query.append("					   AND PST.CORR_NO(+) 	 = 'TMP0000001'" ).append("\n"); 
		query.append("					   AND STW.CORR_NO(+)	 = 'TMP0000001'" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("					   AND BK.BKG_NO         = @[bkg_no]" ).append("\n"); 

	}
}