/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchBookingDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchBookingDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG No. 나 B/L No. 에 해당되는 데이터를 조회하기 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchBookingDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("tariff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchBookingDataRSQL").append("\n"); 
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
		query.append("SELECT 	TVVD" ).append("\n"); 
		query.append("	, 	POR_CD" ).append("\n"); 
		query.append("	, 	POL_CD" ).append("\n"); 
		query.append("	, 	POD_CD" ).append("\n"); 
		query.append("	,	DEL_CD" ).append("\n"); 
		query.append("	, 	RD" ).append("\n"); 
		query.append("    ,   DCGO_FLG" ).append("\n"); 
		query.append("	,	RC_FLG" ).append("\n"); 
		query.append("	, 	AWK_CGO_FLG" ).append("\n"); 
		query.append("	,	BB_CGO_FLG" ).append("\n"); 
		query.append("	, 	RD_CGO_FLG" ).append("\n"); 
		query.append("	, 	SOC_FLG" ).append("\n"); 
		query.append("	, 	CMDT_CD" ).append("\n"); 
		query.append("	,	CMDT_NM" ).append("\n"); 
		query.append("	,	SC_NO" ).append("\n"); 
		query.append("	,	RFA_NO" ).append("\n"); 
		query.append("	,	TAA_NO" ).append("\n"); 
		query.append("	,	BKG_NO" ).append("\n"); 
		query.append("	,	BL_NO" ).append("\n"); 
		query.append("	,	CUST_CD" ).append("\n"); 
		query.append("	,	CUST_NM" ).append("\n"); 
		query.append("	,   ROUND(AFT_BKG_CM_AMT,2) AFT_BKG_CM_AMT" ).append("\n"); 
		query.append("    , NVL((        " ).append("\n"); 
		query.append("        SELECT 'Y'          " ).append("\n"); 
		query.append("				FROM    DMT_AFT_BKG_FILE_RQST FL" ).append("\n"); 
		query.append("				    ,   COM_UPLD_FILE T2" ).append("\n"); 
		query.append("				    ,   DMT_AFT_BKG_ADJ_RQST ADJ_RQST" ).append("\n"); 
		query.append("					,   DMT_AFT_BKG_ADJ_RQST_DTL ADJ_RQST_DTL" ).append("\n"); 
		query.append("					,   BKG_BOOKING BB" ).append("\n"); 
		query.append("					,   PRI_RP_HDR RP_HDR" ).append("\n"); 
		query.append("					,   PRI_RP_MN RP_MN" ).append("\n"); 
		query.append("					,   PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append("					,   PRI_SP_CTRT_PTY SP_PTY" ).append("\n"); 
		query.append("					,   PRI_TAA_HDR TAA_HDR" ).append("\n"); 
		query.append("					,   PRI_TAA_MN TAA_MN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("					AND ADJ_RQST.DMDT_EXPT_RQST_STS_CD = 'A'" ).append("\n"); 
		query.append("				    AND FL.AFT_BKG_FILE_DIV_CD = 'LETT01'" ).append("\n"); 
		query.append("                    AND FL.FILE_SAV_ID          = T2.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("                    AND T2.DELT_FLG(+)             = 'N'" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("				    AND FL.AFT_EXPT_DAR_NO = ADJ_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					AND ADJ_RQST.AFT_EXPT_DAR_NO = ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					AND ADJ_RQST_DTL.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND BB.RFA_NO = RP_HDR.RFA_NO(+)" ).append("\n"); 
		query.append("					AND RP_HDR.PROP_NO = RP_MN.PROP_NO(+)" ).append("\n"); 
		query.append("					AND	(" ).append("\n"); 
		query.append("							RP_MN.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							OR" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								RP_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT 	/*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("									FROM	PRI_RP_MN" ).append("\n"); 
		query.append("									WHERE	PROP_NO = RP_MN.PROP_NO" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					AND BB.SC_NO = SP_HDR.SC_NO(+)" ).append("\n"); 
		query.append("					AND SP_HDR.PROP_NO = SP_PTY.PROP_NO(+)" ).append("\n"); 
		query.append("					AND (" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SP_PTY.PRC_CTRT_PTY_TP_CD IS NULL AND SP_PTY.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							OR " ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SP_PTY.PRC_CTRT_PTY_TP_CD = 'C' " ).append("\n"); 
		query.append("								AND " ).append("\n"); 
		query.append("								SP_PTY.AMDT_SEQ = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT	/*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */AMDT_SEQ " ).append("\n"); 
		query.append("									FROM	PRI_SP_CTRT_PTY " ).append("\n"); 
		query.append("									WHERE 	PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("										AND	PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)				" ).append("\n"); 
		query.append("							)  " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND TAA_HDR.TAA_NO(+) = BB.TAA_NO" ).append("\n"); 
		query.append("					AND TAA_HDR.TAA_PROP_NO = TAA_MN.TAA_PROP_NO(+)" ).append("\n"); 
		query.append("					AND	(" ).append("\n"); 
		query.append("							TAA_MN.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							OR" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								TAA_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT 	/*+ INDEX_DESC(PRI_TAA_MN XFK1PRI_TAA_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("									FROM	PRI_TAA_MN" ).append("\n"); 
		query.append("									WHERE	TAA_PROP_NO = TAA_MN.TAA_PROP_NO" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND ( RP_MN.CTRT_CUST_CNT_CD || LPAD(RP_MN.CTRT_CUST_SEQ, 6, '0') = A.CUST_CD" ).append("\n"); 
		query.append("                       OR SP_PTY.CUST_CNT_CD || LPAD(SP_PTY.CUST_SEQ, 6, '0') = A.CUST_CD" ).append("\n"); 
		query.append("                       OR TAA_MN.CTRT_CUST_CNT_CD || LPAD(TAA_MN.CTRT_CUST_SEQ, 6, '0') = A.CUST_CD" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				AND ROWNUM = 1" ).append("\n"); 
		query.append("    ),'N') AS GNTE_LTR_FLG" ).append("\n"); 
		query.append("    , DECODE(OFC_CNT,1," ).append("\n"); 
		query.append("             NVL (( SELECT OFC_CD " ).append("\n"); 
		query.append("				   FROM DMT_CHG_BKG_CNTR A, DMT_CHG_CALC B, dmt_hrd_cdg_ctnt C" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                   AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                   AND A.CNTR_CYC_NO = B.CNTR_CYC_NO " ).append("\n"); 
		query.append("				#if(${bkg_no} != '')" ).append("\n"); 
		query.append("					AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND A.BKG_NO = (SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                   AND B.DMDT_TRF_CD = @[tariff]" ).append("\n"); 
		query.append("				   AND C.HRD_CDG_ID = 'AFT_BKG_OFC_CHK'" ).append("\n"); 
		query.append("				   AND B.OFC_CD = C.ATTR_CTNT1" ).append("\n"); 
		query.append("                   AND ROWNUM = 1 ),'N') , 'N') OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT	TVVD" ).append("\n"); 
		query.append("	, 	POR_CD" ).append("\n"); 
		query.append("	, 	POL_CD" ).append("\n"); 
		query.append("	, 	POD_CD" ).append("\n"); 
		query.append("	,	DEL_CD" ).append("\n"); 
		query.append("	, 	RD" ).append("\n"); 
		query.append("    ,   DCGO_FLG" ).append("\n"); 
		query.append("	,	RC_FLG" ).append("\n"); 
		query.append("	, 	AWK_CGO_FLG" ).append("\n"); 
		query.append("	,	BB_CGO_FLG" ).append("\n"); 
		query.append("	, 	RD_CGO_FLG" ).append("\n"); 
		query.append("	, 	SOC_FLG" ).append("\n"); 
		query.append("	, 	CMDT_CD" ).append("\n"); 
		query.append("	,	CMDT_NM" ).append("\n"); 
		query.append("	,	SC_NO" ).append("\n"); 
		query.append("	,	RFA_NO" ).append("\n"); 
		query.append("	,	TAA_NO" ).append("\n"); 
		query.append("	,	BKG_NO" ).append("\n"); 
		query.append("	,	BL_NO" ).append("\n"); 
		query.append("	,	DECODE(NVL(TAA_CUST_CD, '' ), '',DECODE(NVL(RP_CUST_CD, ''), '', SP_CUST_CD, RP_CUST_CD),TAA_CUST_CD) CUST_CD" ).append("\n"); 
		query.append("	,	DECODE(NVL(TAA_CUST_CD, ''), '', DECODE(NVL(RP_CUST_CD, ''), '', SP_CUST_NM, RP_CUST_NM),TAA_CUST_NM) CUST_NM" ).append("\n"); 
		query.append("	,   AFT_BKG_CM_AMT" ).append("\n"); 
		query.append("	,   ( SELECT COUNT(*)" ).append("\n"); 
		query.append("	      FROM" ).append("\n"); 
		query.append("	           ( SELECT OFC_CD, COUNT(*) FROM DMT_CHG_BKG_CNTR A, DMT_CHG_CALC B" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                   AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                   AND A.CNTR_CYC_NO = B.CNTR_CYC_NO " ).append("\n"); 
		query.append("				#if(${bkg_no} != '')" ).append("\n"); 
		query.append("					AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND A.BKG_NO = (SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                   AND B.DMDT_TRF_CD = @[tariff]" ).append("\n"); 
		query.append("                   GROUP BY OFC_CD ) ) OFC_CNT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("			SELECT  ROWNUM IDX" ).append("\n"); 
		query.append("				,	BOOKING.VSL_CD || BOOKING.SKD_VOY_NO || BOOKING.SKD_DIR_CD TVVD" ).append("\n"); 
		query.append("			    ,   BOOKING.POR_CD" ).append("\n"); 
		query.append("			    ,   BOOKING.POL_CD" ).append("\n"); 
		query.append("			    ,   BOOKING.POD_CD" ).append("\n"); 
		query.append("			    ,   BOOKING.DEL_CD" ).append("\n"); 
		query.append("			    ,   BOOKING.RCV_TERM_CD || '/' || BOOKING.DE_TERM_CD RD" ).append("\n"); 
		query.append("			    ,   DECODE(BOOKING.DCGO_FLG, 'N', '', BOOKING.DCGO_FLG) DCGO_FLG" ).append("\n"); 
		query.append("			    ,   DECODE(BOOKING.RC_FLG, 'N', '', BOOKING.RC_FLG) RC_FLG" ).append("\n"); 
		query.append("			    ,   DECODE(BOOKING.AWK_CGO_FLG, 'N', '', BOOKING.AWK_CGO_FLG) AWK_CGO_FLG" ).append("\n"); 
		query.append("			    ,   DECODE(BOOKING.BB_CGO_FLG, 'N', '', BOOKING.BB_CGO_FLG) BB_CGO_FLG" ).append("\n"); 
		query.append("				, 	DECODE(BOOKING.RD_CGO_FLG, 'N', '', BOOKING.RD_CGO_FLG) RD_CGO_FLG" ).append("\n"); 
		query.append("				, 	DECODE(BOOKING.SOC_FLG, 'N', '', BOOKING.SOC_FLG) SOC_FLG" ).append("\n"); 
		query.append("				,	BOOKING.BKG_NO" ).append("\n"); 
		query.append("				,	BOOKING.BL_NO" ).append("\n"); 
		query.append("				,	BOOKING.SC_NO" ).append("\n"); 
		query.append("				,	BOOKING.RFA_NO" ).append("\n"); 
		query.append("				,	BOOKING.TAA_NO" ).append("\n"); 
		query.append("	            ,   RP_MN.CTRT_CUST_CNT_CD || LPAD(RP_MN.CTRT_CUST_SEQ, 6, '0') RP_CUST_CD" ).append("\n"); 
		query.append("	            ,   (" ).append("\n"); 
		query.append("						SELECT	CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("						FROM 	MDM_CUSTOMER " ).append("\n"); 
		query.append("						WHERE	CUST_CNT_CD = RP_MN.CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("							AND CUST_SEQ = RP_MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("					) RP_CUST_NM" ).append("\n"); 
		query.append("	            ,   SP_PTY.CUST_CNT_CD || LPAD(SP_PTY.CUST_SEQ, 6, '0') SP_CUST_CD" ).append("\n"); 
		query.append("	            ,   (" ).append("\n"); 
		query.append("						SELECT	CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("						FROM	MDM_CUSTOMER " ).append("\n"); 
		query.append("						WHERE	CUST_CNT_CD = SP_PTY.CUST_CNT_CD " ).append("\n"); 
		query.append("							AND CUST_SEQ = SP_PTY.CUST_SEQ " ).append("\n"); 
		query.append("					) SP_CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		        ,   TAA_MN.CTRT_CUST_CNT_CD || LPAD(TAA_MN.CTRT_CUST_SEQ, 6, '0') TAA_CUST_CD" ).append("\n"); 
		query.append("		        ,   (" ).append("\n"); 
		query.append("						SELECT	CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("						FROM 	MDM_CUSTOMER " ).append("\n"); 
		query.append("						WHERE	CUST_CNT_CD = TAA_MN.CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("							AND CUST_SEQ = TAA_MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("					) TAA_CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				, 	BOOKING.CMDT_CD" ).append("\n"); 
		query.append("			    ,	CMDT.CMDT_NM" ).append("\n"); 
		query.append("				,   (" ).append("\n"); 
		query.append("                     SELECT   SUM(NVL(A2.BKG_REV,0) + NVL(A2.BKG_OFT_REV,0) + NVL(A2.BKG_MISC_REV,0) + NVL(A2.SCR_CHG_REV,0) + NVL(A1.DMDT_COM_AMT,0)) " ).append("\n"); 
		query.append("								- SUM(DECODE('P'||'C', 'PC',NVL(A2.ESTM_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 'PO',NVL(A2.ESTM_CM_COST_AMT,0) -- + NVL(A2.ESTM_OPFIT_COST_AMT,0) /*CHM-200901045 Trade profit - OP 선택 시 OP 계정이 CM에 계산 되어 반영 되는 부분  쿼리수정 [061]*/" ).append("\n"); 
		query.append("																	  , 'PM',NVL(A2.ESTM_CM_COST_AMT,0) + NVL(A1.OWN_FDR_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RC',NVL(A2.RA_CM_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RM',NVL(A2.RA_CM_COST_AMT,0) + NVL(A1.OWN_FDR_AMT,0)" ).append("\n"); 
		query.append("																	  , 'RO',NVL(A2.RA_CM_COST_AMT,0) + NVL(A2.RA_OPFIT_COST_AMT,0)" ).append("\n"); 
		query.append("																	  , 0))   AS CM" ).append("\n"); 
		query.append("                    FROM     MAS_BKG_EXPN_DTL    A1" ).append("\n"); 
		query.append("                            ,MAS_BKG_REV_DTL     A2" ).append("\n"); 
		query.append("                            ,MAS_BKG_OP_EXPN_DTL A6" ).append("\n"); 
		query.append("                    WHERE    1 = 1" ).append("\n"); 
		query.append("                    AND A1.BKG_NO         = BOOKING.BKG_NO" ).append("\n"); 
		query.append("                    AND a1.bl_no_tp      IN ('M','0')" ).append("\n"); 
		query.append("                    AND A1.BKG_STS_CD    IN ('F','S','W')" ).append("\n"); 
		query.append("                    AND A1.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                    AND A1.BKG_NO         = A2.BKG_NO (+)" ).append("\n"); 
		query.append("                    AND A1.CNTR_TPSZ_CD   = A2.CNTR_TPSZ_CD (+)" ).append("\n"); 
		query.append("                    AND A1.COST_ROUT_NO   = A2.COST_ROUT_NO (+)" ).append("\n"); 
		query.append("                    AND A1.BKG_NO         = A6.BKG_NO (+)" ).append("\n"); 
		query.append("                    AND A1.CNTR_TPSZ_CD   = A6.CNTR_TPSZ_CD (+)" ).append("\n"); 
		query.append("                    AND A1.COST_ROUT_NO   = A6.COST_ROUT_NO (+)" ).append("\n"); 
		query.append("					) AS AFT_BKG_CM_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			FROM	BKG_BOOKING BOOKING" ).append("\n"); 
		query.append("				,	MDM_COMMODITY CMDT" ).append("\n"); 
		query.append("				,   PRI_RP_HDR RP_HDR" ).append("\n"); 
		query.append("				,   PRI_RP_MN RP_MN" ).append("\n"); 
		query.append("				,   PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append("				,   PRI_TAA_HDR TAA_HDR" ).append("\n"); 
		query.append("				,   PRI_TAA_MN TAA_MN" ).append("\n"); 
		query.append("				,   PRI_SP_CTRT_PTY SP_PTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			WHERE   " ).append("\n"); 
		query.append("				#if(${bkg_no} != '')" ).append("\n"); 
		query.append("					BOOKING.BKG_NO 	= @[bkg_no]" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					BOOKING.BKG_NO 	= (SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				AND BOOKING.CMDT_CD = CMDT.CMDT_CD(+)" ).append("\n"); 
		query.append("				AND BOOKING.RFA_NO 	= RP_HDR.RFA_NO(+)" ).append("\n"); 
		query.append("				AND RP_HDR.PROP_NO 	= RP_MN.PROP_NO(+)" ).append("\n"); 
		query.append("				AND	(" ).append("\n"); 
		query.append("						RP_MN.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							RP_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SELECT 	/*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("								FROM	PRI_RP_MN" ).append("\n"); 
		query.append("								WHERE	PROP_NO = RP_MN.PROP_NO" ).append("\n"); 
		query.append("									AND	ROWNUM = 1" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				AND BOOKING.SC_NO 	= SP_HDR.SC_NO(+)" ).append("\n"); 
		query.append("				AND SP_HDR.PROP_NO 	= SP_PTY.PROP_NO(+)" ).append("\n"); 
		query.append("				AND (" ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							SP_PTY.PRC_CTRT_PTY_TP_CD IS NULL AND SP_PTY.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("						OR " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							SP_PTY.PRC_CTRT_PTY_TP_CD = 'C' " ).append("\n"); 
		query.append("							AND " ).append("\n"); 
		query.append("							SP_PTY.AMDT_SEQ = " ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SELECT	/*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */AMDT_SEQ " ).append("\n"); 
		query.append("								FROM	PRI_SP_CTRT_PTY " ).append("\n"); 
		query.append("								WHERE 	PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("									AND	PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("									AND	ROWNUM = 1" ).append("\n"); 
		query.append("							)				" ).append("\n"); 
		query.append("						)  " ).append("\n"); 
		query.append("					)		" ).append("\n"); 
		query.append("				AND TAA_HDR.TAA_NO(+) = BOOKING.TAA_NO" ).append("\n"); 
		query.append("				AND TAA_HDR.TAA_PROP_NO = TAA_MN.TAA_PROP_NO(+)" ).append("\n"); 
		query.append("				AND	(" ).append("\n"); 
		query.append("						TAA_MN.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							TAA_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SELECT 	/*+ INDEX_DESC(PRI_TAA_MN XFK1PRI_TAA_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("								FROM	PRI_TAA_MN" ).append("\n"); 
		query.append("								WHERE	TAA_PROP_NO = TAA_MN.TAA_PROP_NO" ).append("\n"); 
		query.append("									AND	ROWNUM = 1" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("WHERE IDX = 1" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}