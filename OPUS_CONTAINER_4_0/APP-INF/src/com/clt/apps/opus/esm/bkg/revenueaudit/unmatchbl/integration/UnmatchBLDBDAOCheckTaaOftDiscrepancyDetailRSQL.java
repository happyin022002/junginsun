/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckTaaOftDiscrepancyDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCheckTaaOftDiscrepancyDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkTaaOftDiscrepancyDetail
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckTaaOftDiscrepancyDetailRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCheckTaaOftDiscrepancyDetailRSQL").append("\n"); 
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
		query.append("USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM		GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE		ACCT_XCH_RT_YRMON	= LEAST(( SELECT TO_CHAR(RT_APLY_DT, 'YYYYMM') FROM BKG_RATE WHERE BKG_NO = @[bkg_no] ), (SELECT MAX(ACCT_XCH_RT_YRMON) FROM GL_MON_XCH_RT ))" ).append("\n"); 
		query.append("AND			ACCT_XCH_RT_LVL		= '1'" ).append("\n"); 
		query.append("AND			@[ca_flg]					= 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	CURR_CD					," ).append("\n"); 
		query.append("USD_LOCL_XCH_RT" ).append("\n"); 
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
		query.append("SELECT	NVL(RT_BL_TP_CD, 'N')" ).append("\n"); 
		query.append("FROM		BKG_RATE" ).append("\n"); 
		query.append("WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("AND			@[ca_flg]			= 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	NVL(RT_BL_TP_CD, 'N')" ).append("\n"); 
		query.append("FROM		BKG_RT_HIS" ).append("\n"); 
		query.append("WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("AND			CORR_NO				= 'TMP0000001'	-- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("AND			@[ca_flg]			= 'Y'" ).append("\n"); 
		query.append(")	RT_BL_TP_CD	," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	MAX(BB_CGO_FLG)" ).append("\n"); 
		query.append("FROM		BKG_QTY_DTL" ).append("\n"); 
		query.append("WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("AND			@[ca_flg]			= 'N'" ).append("\n"); 
		query.append("HAVING  MAX(BB_CGO_FLG) IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	MAX(BB_CGO_FLG)" ).append("\n"); 
		query.append("FROM		BKG_QTY_DTL_HIS" ).append("\n"); 
		query.append("WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("AND			CORR_NO				= 'TMP0000001'	-- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("AND			@[ca_flg]			= 'Y'" ).append("\n"); 
		query.append("HAVING  MAX(BB_CGO_FLG) IS NOT NULL" ).append("\n"); 
		query.append(")	BB_CGO_FLG" ).append("\n"); 
		query.append("FROM		DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	'E'	UMCH_TP_CD					," ).append("\n"); 
		query.append("'B'	UMCH_BKG_CTRT_TP_CD	," ).append("\n"); 
		query.append("ROW_NUMBER() OVER ( ORDER BY DECODE(CHG_CD, 'OFT', 1, 'OAR', 2, 'DAR', 3, 4), RAT_UT_CD )	UMCH_ITM_SEQ	," ).append("\n"); 
		query.append("CHG_CD									," ).append("\n"); 
		query.append("RAT_UT_CD								," ).append("\n"); 
		query.append("RAT_AS_QTY	RAT_UT_QTY	," ).append("\n"); 
		query.append("CURR_CD									," ).append("\n"); 
		query.append("CHG_UT_AMT	FRT_RT_AMT" ).append("\n"); 
		query.append("FROM		BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("AND			CHG_CD				IN ( 'OFT', 'OAR', 'DAR' )" ).append("\n"); 
		query.append("AND			NVL(FRT_INCL_XCLD_DIV_CD, 'N')	= 'N'" ).append("\n"); 
		query.append("AND			( SELECT RT_BL_TP_CD FROM BK )	NOT IN ( 'M', 'C' )" ).append("\n"); 
		query.append("AND			( SELECT BB_CGO_FLG FROM BK )		= 'N'" ).append("\n"); 
		query.append("AND			@[ca_flg]			= 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	'E'	UMCH_TP_CD					," ).append("\n"); 
		query.append("'B'	UMCH_BKG_CTRT_TP_CD	," ).append("\n"); 
		query.append("ROW_NUMBER() OVER ( ORDER BY DECODE(CHG_CD, 'OFT', 1, 'OAR', 2, 'DAR', 3, 4), RAT_UT_CD )	UMCH_ITM_SEQ	," ).append("\n"); 
		query.append("CHG_CD									," ).append("\n"); 
		query.append("RAT_UT_CD								," ).append("\n"); 
		query.append("RAT_AS_QTY	RAT_UT_QTY	," ).append("\n"); 
		query.append("CURR_CD									," ).append("\n"); 
		query.append("CHG_UT_AMT	FRT_RT_AMT" ).append("\n"); 
		query.append("FROM		BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("WHERE		BKG_NO				= @[bkg_no]" ).append("\n"); 
		query.append("AND			CORR_NO				= 'TMP0000001'" ).append("\n"); 
		query.append("AND			CHG_CD				IN ( 'OFT', 'OAR', 'DAR' )" ).append("\n"); 
		query.append("AND			NVL(FRT_INCL_XCLD_DIV_CD, 'N')	= 'N'" ).append("\n"); 
		query.append("AND			( SELECT RT_BL_TP_CD FROM BK )	NOT IN ( 'M', 'C' )" ).append("\n"); 
		query.append("AND			( SELECT BB_CGO_FLG FROM BK )		= 'N'" ).append("\n"); 
		query.append("AND			@[ca_flg]			= 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	'E'	UMCH_TP_CD					," ).append("\n"); 
		query.append("'C'	UMCH_BKG_CTRT_TP_CD	," ).append("\n"); 
		query.append("ROW_NUMBER() OVER ( ORDER BY DECODE(CHG_CD, 'OFT', 1, 'OAR', 2, 'DAR', 3, 4), RAT_UT_CD )	UMCH_ITM_SEQ	," ).append("\n"); 
		query.append("CHG_CD									," ).append("\n"); 
		query.append("RAT_UT_CD								," ).append("\n"); 
		query.append("RAT_AS_QTY	RAT_UT_QTY	," ).append("\n"); 
		query.append("CURR_CD									," ).append("\n"); 
		query.append("CHG_UT_AMT	FRT_RT_AMT" ).append("\n"); 
		query.append("FROM		BKG_REV_AUD_CHG_TMP" ).append("\n"); 
		query.append("WHERE		OFT_CMB_SEQ" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	OFT_CMB_SEQ" ).append("\n"); 
		query.append("FROM		(" ).append("\n"); 
		query.append("SELECT	OFT_CMB_SEQ		," ).append("\n"); 
		query.append("ROW_NUMBER() OVER ( ORDER BY OFT_CHG_AMT, SUR_CHG_AMT, OFT_CMB_SEQ )	ROW_NUMBER" ).append("\n"); 
		query.append("FROM		(" ).append("\n"); 
		query.append("SELECT	RA.OFT_CMB_SEQ	," ).append("\n"); 
		query.append("SUM(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN CHG_CD IN ( 'OFT', 'OAR', 'DAR' ) THEN RA.RAT_AS_QTY * RA.CHG_UT_AMT / DECODE(RA.RAT_UT_CD, 'PC', 100, 1) / XR.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")	OFT_CHG_AMT		," ).append("\n"); 
		query.append("SUM(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN CHG_CD NOT IN ( 'OFT', 'OAR', 'DAR' ) THEN RA.RAT_AS_QTY * RA.CHG_UT_AMT / DECODE(RA.RAT_UT_CD, 'PC', 100, 1) / XR.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")	SUR_CHG_AMT" ).append("\n"); 
		query.append("FROM		BKG_REV_AUD_CHG_TMP	RA	," ).append("\n"); 
		query.append("XR" ).append("\n"); 
		query.append("WHERE		XR.CURR_CD = RA.CURR_CD" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("RA.OFT_CMB_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE		ROW_NUMBER	= 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND			CHG_CD	IN ( 'OFT', 'OAR', 'DAR' )" ).append("\n"); 
		query.append("AND			( SELECT RT_BL_TP_CD FROM BK )	NOT IN ( 'M', 'C' )" ).append("\n"); 
		query.append("AND			( SELECT BB_CGO_FLG FROM BK )		= 'N'" ).append("\n"); 

	}
}