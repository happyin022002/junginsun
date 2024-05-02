/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckRfaSurchargeDiscrepancyDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCheckRfaSurchargeDiscrepancyDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkRfaSurchargeDiscrepancyDetail
	  * 
	  * [20170417]  김동호 AUTO RATING 결과의 요금 중 
	  *                             단위가 BX, BL인 요금은 단위, 수량 무시하고 금액만 비교 
	  *                             (김경남 부장님 요청)
	  * [20170706]  김동호 모든걸 다 무시하고, 요금 코드별 금액(단가 X)만 비교
	  *                             (김경남 부장님 요청)
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckRfaSurchargeDiscrepancyDetailRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCheckRfaSurchargeDiscrepancyDetailRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("XR AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("환율 정보 조회" ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	CURR_CD					," ).append("\n"); 
		query.append("				USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM		GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE		ACCT_XCH_RT_YRMON	= LEAST(( SELECT TO_CHAR(RT_APLY_DT, 'YYYYMM') FROM BKG_RATE WHERE BKG_NO = @[bkg_no] ), (SELECT MAX(ACCT_XCH_RT_YRMON) FROM GL_MON_XCH_RT ))" ).append("\n"); 
		query.append("AND			ACCT_XCH_RT_LVL		= '1'" ).append("\n"); 
		query.append("AND			@[ca_flg]					= 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	CURR_CD					," ).append("\n"); 
		query.append("				USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM		GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE		ACCT_XCH_RT_YRMON	= LEAST(( SELECT TO_CHAR(RT_APLY_DT, 'YYYYMM') FROM BKG_RT_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO	= 'TMP0000001' ), (SELECT MAX(ACCT_XCH_RT_YRMON) FROM GL_MON_XCH_RT ))" ).append("\n"); 
		query.append("AND			ACCT_XCH_RT_LVL		= '1'" ).append("\n"); 
		query.append("AND			@[ca_flg]					= 'Y'" ).append("\n"); 
		query.append(")	," ).append("\n"); 
		query.append("BK AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("B/L TYPE CODE 를 SELECT 한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	(" ).append("\n"); 
		query.append("				SELECT	NVL(RT_BL_TP_CD, 'N')" ).append("\n"); 
		query.append("				FROM		BKG_RATE" ).append("\n"); 
		query.append("				WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("				AND			@[ca_flg]			= 'N'" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("				SELECT	NVL(RT_BL_TP_CD, 'N')" ).append("\n"); 
		query.append("				FROM		BKG_RT_HIS" ).append("\n"); 
		query.append("				WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("				AND			CORR_NO				= 'TMP0000001'	-- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("				AND			@[ca_flg]			= 'Y'" ).append("\n"); 
		query.append("        )	RT_BL_TP_CD	," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("				SELECT	MAX(BB_CGO_FLG)" ).append("\n"); 
		query.append("				FROM		BKG_QTY_DTL" ).append("\n"); 
		query.append("				WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("				AND			@[ca_flg]			= 'N'" ).append("\n"); 
		query.append("				HAVING  MAX(BB_CGO_FLG) IS NOT NULL" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("				SELECT	MAX(BB_CGO_FLG)" ).append("\n"); 
		query.append("				FROM		BKG_QTY_DTL_HIS" ).append("\n"); 
		query.append("				WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("				AND			CORR_NO				= 'TMP0000001'	-- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("				AND			@[ca_flg]			= 'Y'" ).append("\n"); 
		query.append("				HAVING  MAX(BB_CGO_FLG) IS NOT NULL" ).append("\n"); 
		query.append("        )	BB_CGO_FLG" ).append("\n"); 
		query.append("FROM		DUAL" ).append("\n"); 
		query.append(")	," ).append("\n"); 
		query.append("BR AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("INCLUDE 를 제외한 BKG RATE DATA" ).append("\n"); 
		query.append("COVERED B/L 일 경우는 'DHF', 'NMS', 'CMS', 'ODF' 만 심사 대상으로 처리함." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	CHG_CD				," ).append("\n"); 
		query.append("				CGO_CATE_CD		," ).append("\n"); 
		query.append("				RCV_TERM_CD		," ).append("\n"); 
		query.append("				DE_TERM_CD		," ).append("\n"); 
		query.append("				RAT_AS_QTY		," ).append("\n"); 
		query.append("				RAT_UT_CD			," ).append("\n"); 
		query.append("				CURR_CD				," ).append("\n"); 
		query.append("				CHG_UT_AMT		," ).append("\n"); 
		query.append("				CHG_AMT				," ).append("\n"); 
		query.append("				( SELECT BR.CHG_AMT / XR.USD_LOCL_XCH_RT FROM XR WHERE XR.CURR_CD = BR.CURR_CD )	CHG_USD_AMT" ).append("\n"); 
		query.append("FROM		BKG_CHG_RT	BR" ).append("\n"); 
		query.append("WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("AND			NVL(FRT_INCL_XCLD_DIV_CD, 'N')	= 'N'" ).append("\n"); 
		query.append("AND			(" ).append("\n"); 
		query.append("						( SELECT RT_BL_TP_CD FROM BK ) <> 'C'" ).append("\n"); 
		query.append("				OR	CHG_CD	IN ( 'DHF', 'NMS', 'CMS', 'ODF' )" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("AND			@[ca_flg]			= 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	CHG_CD				," ).append("\n"); 
		query.append("				CGO_CATE_CD		," ).append("\n"); 
		query.append("				RCV_TERM_CD		," ).append("\n"); 
		query.append("				DE_TERM_CD		," ).append("\n"); 
		query.append("				RAT_AS_QTY		," ).append("\n"); 
		query.append("				RAT_UT_CD			," ).append("\n"); 
		query.append("				CURR_CD				," ).append("\n"); 
		query.append("				CHG_UT_AMT		," ).append("\n"); 
		query.append("				CHG_AMT				," ).append("\n"); 
		query.append("				( SELECT BR.CHG_AMT / XR.USD_LOCL_XCH_RT FROM XR WHERE XR.CURR_CD = BR.CURR_CD )	CHG_USD_AMT" ).append("\n"); 
		query.append("FROM		BKG_CHG_RT_HIS	BR" ).append("\n"); 
		query.append("WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("AND			CORR_NO				= 'TMP0000001'" ).append("\n"); 
		query.append("AND			NVL(FRT_INCL_XCLD_DIV_CD, 'N')	= 'N'" ).append("\n"); 
		query.append("AND			(" ).append("\n"); 
		query.append("						( SELECT RT_BL_TP_CD FROM BK ) <> 'C'" ).append("\n"); 
		query.append("				OR	CHG_CD	IN ( 'DHF', 'NMS', 'CMS', 'ODF' )" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("AND			@[ca_flg]			= 'Y'" ).append("\n"); 
		query.append(")	," ).append("\n"); 
		query.append("B1 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("BKG 의 OFT ( OFT, OAR, DAR )" ).append("\n"); 
		query.append("BL RATING UNIT 을 고려하여 변환한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	BR.*	," ).append("\n"); 
		query.append("		( SELECT BR.CHG_AMT / XR.USD_LOCL_XCH_RT FROM XR WHERE XR.CURR_CD = BR.CURR_CD )	CHG_USD_AMT," ).append("\n"); 
		query.append("        SUM (( SELECT BR.CHG_AMT / XR.USD_LOCL_XCH_RT FROM XR WHERE XR.CURR_CD = BR.CURR_CD )) " ).append("\n"); 
		query.append("            OVER (PARTITION BY OFT_CMB_SEQ, CHG_CD, CHG_AMT) AS CHK_CHG_AMT" ).append("\n"); 
		query.append("FROM		(" ).append("\n"); 
		query.append("				SELECT	BR.OFT_CMB_SEQ	," ).append("\n"); 
		query.append("								BR.CHG_CD				," ).append("\n"); 
		query.append("								BR.CGO_CATE_CD	," ).append("\n"); 
		query.append("								BR.RCV_TERM_CD	," ).append("\n"); 
		query.append("								BR.DE_TERM_CD		," ).append("\n"); 
		query.append("								CASE" ).append("\n"); 
		query.append("								WHEN DECODE(CK.BL_FLG, 'Y', 'Y', 'N') = 'Y' THEN 1" ).append("\n"); 
		query.append("								ELSE BR.RAT_AS_QTY" ).append("\n"); 
		query.append("								END	RAT_AS_QTY	," ).append("\n"); 
		query.append("								CASE" ).append("\n"); 
		query.append("								WHEN DECODE(CK.BL_FLG, 'Y', 'Y', 'N') = 'Y' THEN 'BL'" ).append("\n"); 
		query.append("								ELSE BR.RAT_UT_CD" ).append("\n"); 
		query.append("								END	RAT_UT_CD		," ).append("\n"); 
		query.append("								BR.CURR_CD			," ).append("\n"); 
		query.append("								SUM(BR.CHG_AMT)	CHG_AMT" ).append("\n"); 
		query.append("				FROM		(" ).append("\n"); 
		query.append("								SELECT	RA.OFT_CMB_SEQ	," ).append("\n"); 
		query.append("												BR.*" ).append("\n"); 
		query.append("								FROM		BR		," ).append("\n"); 
		query.append("												(" ).append("\n"); 
		query.append("												SELECT	DISTINCT" ).append("\n"); 
		query.append("																OFT_CMB_SEQ" ).append("\n"); 
		query.append("												FROM		BKG_REV_AUD_CHG_TMP" ).append("\n"); 
		query.append("												)	RA" ).append("\n"); 
		query.append("								WHERE		CHG_CD	IN ( 'OFT', 'OAR', 'DAR' )" ).append("\n"); 
		query.append("								) BR	," ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("								SELECT	OFT_CMB_SEQ	," ).append("\n"); 
		query.append("												CHG_CD			," ).append("\n"); 
		query.append("												MAX(DECODE(RAT_UT_CD, 'BL', 'Y', 'N'))	BL_FLG" ).append("\n"); 
		query.append("								FROM	BKG_REV_AUD_CHG_TMP" ).append("\n"); 
		query.append("								WHERE   CHG_CD	IN ( 'OFT', 'OAR', 'DAR' )" ).append("\n"); 
		query.append("								GROUP BY" ).append("\n"); 
		query.append("												OFT_CMB_SEQ	," ).append("\n"); 
		query.append("												CHG_CD" ).append("\n"); 
		query.append("								)	CK" ).append("\n"); 
		query.append("				WHERE		CK.OFT_CMB_SEQ(+)	= BR.OFT_CMB_SEQ" ).append("\n"); 
		query.append("				AND			CK.CHG_CD(+)			= BR.CHG_CD" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("								BR.OFT_CMB_SEQ	," ).append("\n"); 
		query.append("								BR.CHG_CD				," ).append("\n"); 
		query.append("								BR.CGO_CATE_CD	," ).append("\n"); 
		query.append("								BR.RCV_TERM_CD	," ).append("\n"); 
		query.append("								BR.DE_TERM_CD		," ).append("\n"); 
		query.append("								CASE" ).append("\n"); 
		query.append("								WHEN DECODE(CK.BL_FLG, 'Y', 'Y', 'N') = 'Y' THEN 1" ).append("\n"); 
		query.append("								ELSE BR.RAT_AS_QTY" ).append("\n"); 
		query.append("								END							," ).append("\n"); 
		query.append("								CASE" ).append("\n"); 
		query.append("								WHEN DECODE(CK.BL_FLG, 'Y', 'Y', 'N') = 'Y' THEN 'BL'" ).append("\n"); 
		query.append("								ELSE BR.RAT_UT_CD" ).append("\n"); 
		query.append("								END							," ).append("\n"); 
		query.append("								BR.CURR_CD" ).append("\n"); 
		query.append("				) BR" ).append("\n"); 
		query.append(")	," ).append("\n"); 
		query.append("R1 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("AUDIT 의 OFT ( OFT, OAR, DAR )" ).append("\n"); 
		query.append("BL RATING UNIT 을 고려하여 변환한다." ).append("\n"); 
		query.append("COVERED B/L 일 경우는 'DHF', 'NMS', 'CMS', 'ODF' 만 심사 대상으로 처리함." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	RA.*	," ).append("\n"); 
		query.append("		( SELECT RA.CHG_AMT / XR.USD_LOCL_XCH_RT FROM XR WHERE XR.CURR_CD = RA.CURR_CD )	CHG_USD_AMT," ).append("\n"); 
		query.append("        SUM (( SELECT RA.CHG_AMT / XR.USD_LOCL_XCH_RT FROM XR WHERE XR.CURR_CD = RA.CURR_CD )) " ).append("\n"); 
		query.append("           OVER (PARTITION BY OFT_CMB_SEQ, CHG_CD, CHG_AMT) AS CHK_CHG_AMT" ).append("\n"); 
		query.append("FROM		(" ).append("\n"); 
		query.append("				SELECT	RA.OFT_CMB_SEQ	," ).append("\n"); 
		query.append("								RA.CHG_CD				," ).append("\n"); 
		query.append("								RA.CGO_CATE_CD	," ).append("\n"); 
		query.append("								RA.RCV_TERM_CD	," ).append("\n"); 
		query.append("								RA.DE_TERM_CD		," ).append("\n"); 
		query.append("								CASE" ).append("\n"); 
		query.append("								WHEN DECODE(CK.BL_FLG, 'Y', 'Y', 'N') = 'Y' THEN 1" ).append("\n"); 
		query.append("								ELSE RA.RAT_AS_QTY" ).append("\n"); 
		query.append("								END	RAT_AS_QTY	," ).append("\n"); 
		query.append("								CASE" ).append("\n"); 
		query.append("								WHEN DECODE(CK.BL_FLG, 'Y', 'Y', 'N') = 'Y' THEN 'BL'" ).append("\n"); 
		query.append("								ELSE RA.RAT_UT_CD" ).append("\n"); 
		query.append("								END	RAT_UT_CD		," ).append("\n"); 
		query.append("								RA.CURR_CD			," ).append("\n"); 
		query.append("								SUM(RA.CHG_AMT)	CHG_AMT" ).append("\n"); 
		query.append("				FROM		BKG_REV_AUD_CHG_TMP	RA	," ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("								SELECT	CHG_CD			," ).append("\n"); 
		query.append("												MAX(DECODE(RAT_UT_CD, 'BL', 'Y', 'N'))	BL_FLG" ).append("\n"); 
		query.append("								FROM	BR" ).append("\n"); 
		query.append("								GROUP BY" ).append("\n"); 
		query.append("												CHG_CD" ).append("\n"); 
		query.append("								)	CK" ).append("\n"); 
		query.append("				WHERE		CK.CHG_CD(+)			= RA.CHG_CD" ).append("\n"); 
		query.append("				AND			RA.CHG_CD					IN ( 'OFT', 'OAR', 'DAR' )" ).append("\n"); 
		query.append("				AND			(" ).append("\n"); 
		query.append("										( SELECT RT_BL_TP_CD FROM BK ) <> 'C'" ).append("\n"); 
		query.append("								OR	RA.CHG_CD	IN ( 'DHF', 'NMS', 'CMS', 'ODF' )" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("								RA.OFT_CMB_SEQ	," ).append("\n"); 
		query.append("								RA.CHG_CD				," ).append("\n"); 
		query.append("								RA.CGO_CATE_CD	," ).append("\n"); 
		query.append("								RA.RCV_TERM_CD	," ).append("\n"); 
		query.append("								RA.DE_TERM_CD		," ).append("\n"); 
		query.append("								CASE" ).append("\n"); 
		query.append("								WHEN DECODE(CK.BL_FLG, 'Y', 'Y', 'N') = 'Y' THEN 1" ).append("\n"); 
		query.append("								ELSE RA.RAT_AS_QTY" ).append("\n"); 
		query.append("								END							," ).append("\n"); 
		query.append("								CASE" ).append("\n"); 
		query.append("								WHEN DECODE(CK.BL_FLG, 'Y', 'Y', 'N') = 'Y' THEN 'BL'" ).append("\n"); 
		query.append("								ELSE RA.RAT_UT_CD" ).append("\n"); 
		query.append("								END							," ).append("\n"); 
		query.append("								RA.CURR_CD" ).append("\n"); 
		query.append("				)	RA" ).append("\n"); 
		query.append(")	," ).append("\n"); 
		query.append("C1 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("OFT 가 일치하는 OFT_CMB_SEQ 를 SELECT 한다." ).append("\n"); 
		query.append("B1 와 R1 가 모두 값이 없으면 C1 이 값이 없어서 불일치하는 것으로 표현되므로," ).append("\n"); 
		query.append("UNION ALL 로 전체 OFT_CMB_SEQ 를 가져오는 부분을 추가하였음." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	OFT_CMB_SEQ" ).append("\n"); 
		query.append("FROM		(" ).append("\n"); 
		query.append("				SELECT	R1.OFT_CMB_SEQ				," ).append("\n"); 
		query.append("								SUM(DECODE(B1.CHG_CD, NULL, 1, 0))	UMCH_CNT" ).append("\n"); 
		query.append("				FROM		(" ).append("\n"); 
		query.append("								SELECT	OFT_CMB_SEQ		," ).append("\n"); 
		query.append("												CHG_CD				," ).append("\n"); 
		query.append("												CGO_CATE_CD		," ).append("\n"); 
		query.append("												RCV_TERM_CD		," ).append("\n"); 
		query.append("												DE_TERM_CD		," ).append("\n"); 
		query.append("												RAT_AS_QTY		," ).append("\n"); 
		query.append("												RAT_UT_CD			," ).append("\n"); 
		query.append("												CURR_CD				," ).append("\n"); 
		query.append("												CHG_AMT				," ).append("\n"); 
		query.append("												CHG_USD_AMT         ," ).append("\n"); 
		query.append("                                                CHK_CHG_AMT" ).append("\n"); 
		query.append("								FROM		R1" ).append("\n"); 
		query.append("								WHERE		OFT_CMB_SEQ		NOT	IN	(" ).append("\n"); 
		query.append("																							SELECT	DISTINCT" ).append("\n"); 
		query.append("																											A.OFT_CMB_SEQ" ).append("\n"); 
		query.append("																							FROM		(" ).append("\n"); 
		query.append("																											SELECT	OFT_CMB_SEQ		," ).append("\n"); 
		query.append("																															CHG_CD				," ).append("\n"); 
		query.append("																															COUNT(1)	CNT" ).append("\n"); 
		query.append("																											FROM		R1" ).append("\n"); 
		query.append("																											GROUP BY" ).append("\n"); 
		query.append("																															OFT_CMB_SEQ	," ).append("\n"); 
		query.append("																															CHG_CD" ).append("\n"); 
		query.append("																											) A	," ).append("\n"); 
		query.append("																											(" ).append("\n"); 
		query.append("																											SELECT	OFT_CMB_SEQ		," ).append("\n"); 
		query.append("																															CHG_CD				," ).append("\n"); 
		query.append("																															COUNT(1)	CNT" ).append("\n"); 
		query.append("																											FROM		B1" ).append("\n"); 
		query.append("																											GROUP BY" ).append("\n"); 
		query.append("																															OFT_CMB_SEQ		," ).append("\n"); 
		query.append("																															CHG_CD" ).append("\n"); 
		query.append("																											)	B" ).append("\n"); 
		query.append("																							WHERE		B.OFT_CMB_SEQ(+)	= A.OFT_CMB_SEQ" ).append("\n"); 
		query.append("																							AND			B.CHG_CD(+)				= A.CHG_CD" ).append("\n"); 
		query.append("																							AND			B.CNT(+)					= A.CNT" ).append("\n"); 
		query.append("																							AND			B.CHG_CD					IS NULL" ).append("\n"); 
		query.append("																							)" ).append("\n"); 
		query.append("								)	R1" ).append("\n"); 
		query.append("								LEFT OUTER JOIN	B1" ).append("\n"); 
		query.append("								ON			B1.OFT_CMB_SEQ	= R1.OFT_CMB_SEQ" ).append("\n"); 
		query.append("								AND			B1.CHG_CD 		= R1.CHG_CD" ).append("\n"); 
		query.append("                                AND			B1.CHK_CHG_AMT 	= R1.CHK_CHG_AMT" ).append("\n"); 
		query.append("								AND			ABS(B1.CHG_USD_AMT - R1.CHG_USD_AMT) <= 5" ).append("\n"); 
		query.append("				GROUP BY	R1.OFT_CMB_SEQ" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("WHERE		UMCH_CNT	= 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INTERSECT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	B1.OFT_CMB_SEQ" ).append("\n"); 
		query.append("FROM		(" ).append("\n"); 
		query.append("				SELECT	OFT_CMB_SEQ	," ).append("\n"); 
		query.append("								SUM(CHG_USD_AMT)	CHG_USD_AMT" ).append("\n"); 
		query.append("				FROM		B1" ).append("\n"); 
		query.append("				GROUP BY	OFT_CMB_SEQ" ).append("\n"); 
		query.append("				)	B1	," ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("				SELECT	OFT_CMB_SEQ	," ).append("\n"); 
		query.append("								SUM(CHG_USD_AMT)	CHG_USD_AMT" ).append("\n"); 
		query.append("				FROM		R1" ).append("\n"); 
		query.append("				GROUP BY	OFT_CMB_SEQ" ).append("\n"); 
		query.append("				)	R1" ).append("\n"); 
		query.append("WHERE		R1.OFT_CMB_SEQ	= B1.OFT_CMB_SEQ" ).append("\n"); 
		query.append("AND			ABS(B1.CHG_USD_AMT - R1.CHG_USD_AMT) <= 5" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	DISTINCT" ).append("\n"); 
		query.append("				OFT_CMB_SEQ" ).append("\n"); 
		query.append("FROM		BKG_REV_AUD_CHG_TMP" ).append("\n"); 
		query.append("WHERE	( SELECT COUNT(1) FROM B1 ) = 0" ).append("\n"); 
		query.append("AND		( SELECT COUNT(1) FROM R1 ) = 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	'F'	UMCH_TP_CD					," ).append("\n"); 
		query.append("				'B'	UMCH_BKG_CTRT_TP_CD	," ).append("\n"); 
		query.append("				ROW_NUMBER() OVER ( ORDER BY DECODE(CHG_CD, 'OFT', 1, 'OAR', 2, 'DAR', 3, 4), RAT_UT_CD )	UMCH_ITM_SEQ	," ).append("\n"); 
		query.append("				CHG_CD									," ).append("\n"); 
		query.append("				RAT_UT_CD								," ).append("\n"); 
		query.append("				RAT_AS_QTY	RAT_UT_QTY	," ).append("\n"); 
		query.append("				CURR_CD									," ).append("\n"); 
		query.append("				CHG_UT_AMT	FRT_RT_AMT" ).append("\n"); 
		query.append("FROM		BR" ).append("\n"); 
		query.append("WHERE		CHG_CD				NOT IN ( 'OFT', 'OAR', 'DAR' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	'F'	UMCH_TP_CD					," ).append("\n"); 
		query.append("				'C'	UMCH_BKG_CTRT_TP_CD	," ).append("\n"); 
		query.append("				ROW_NUMBER() OVER ( ORDER BY CHG_CD, RAT_UT_CD )	UMCH_ITM_SEQ	," ).append("\n"); 
		query.append("				CHG_CD									," ).append("\n"); 
		query.append("				RAT_UT_CD								," ).append("\n"); 
		query.append("				RAT_AS_QTY	RAT_UT_QTY	," ).append("\n"); 
		query.append("				CURR_CD									," ).append("\n"); 
		query.append("				CHG_UT_AMT	FRT_RT_AMT" ).append("\n"); 
		query.append("FROM		BKG_REV_AUD_CHG_TMP" ).append("\n"); 
		query.append("WHERE		OFT_CMB_SEQ" ).append("\n"); 
		query.append("				=" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("				SELECT	OFT_CMB_SEQ" ).append("\n"); 
		query.append("				FROM		(" ).append("\n"); 
		query.append("								SELECT	OFT_CMB_SEQ		," ).append("\n"); 
		query.append("												ROW_NUMBER() OVER ( ORDER BY OFT_MTCH_PRIO, CHG_AMT, OFT_CMB_SEQ )	ROW_NUMBER" ).append("\n"); 
		query.append("								FROM		(" ).append("\n"); 
		query.append("												SELECT	RA.OFT_CMB_SEQ	," ).append("\n"); 
		query.append("																CASE" ).append("\n"); 
		query.append("																WHEN OFT_CMB_SEQ	IN ( SELECT OFT_CMB_SEQ FROM C1 ) THEN 1" ).append("\n"); 
		query.append("																ELSE 2" ).append("\n"); 
		query.append("																END	OFT_MTCH_PRIO	," ).append("\n"); 
		query.append("																SUM(RA.RAT_AS_QTY * RA.CHG_UT_AMT / DECODE(RA.RAT_UT_CD, 'PC', 100, 1) / XR.USD_LOCL_XCH_RT)	CHG_AMT" ).append("\n"); 
		query.append("												FROM		BKG_REV_AUD_CHG_TMP	RA	," ).append("\n"); 
		query.append("																XR" ).append("\n"); 
		query.append("												WHERE		XR.CURR_CD			= RA.CURR_CD" ).append("\n"); 
		query.append("												AND			(" ).append("\n"); 
		query.append("																		( SELECT RT_BL_TP_CD FROM BK ) <> 'C'" ).append("\n"); 
		query.append("																OR	RA.CHG_CD	IN ( 'DHF', 'NMS', 'CMS', 'ODF' )" ).append("\n"); 
		query.append("																)" ).append("\n"); 
		query.append("												GROUP BY" ).append("\n"); 
		query.append("																RA.OFT_CMB_SEQ" ).append("\n"); 
		query.append("								        )" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("				WHERE		ROW_NUMBER	= 1" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("AND			CHG_CD	NOT IN ( 'OFT', 'OAR', 'DAR' )" ).append("\n"); 
		query.append("AND			(" ).append("\n"); 
		query.append("						( SELECT RT_BL_TP_CD FROM BK ) <> 'C'" ).append("\n"); 
		query.append("				OR	CHG_CD	IN ( 'DHF', 'NMS', 'CMS', 'ODF' )" ).append("\n"); 
		query.append("				)" ).append("\n"); 

	}
}