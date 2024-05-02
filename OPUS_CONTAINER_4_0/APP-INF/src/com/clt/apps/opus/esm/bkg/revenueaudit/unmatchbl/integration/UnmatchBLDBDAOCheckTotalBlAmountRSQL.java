/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckTotalBlAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.14 
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

public class UnmatchBLDBDAOCheckTotalBlAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UnmatchBLDBDAOCheckTotalBlAmountRSQL
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckTotalBlAmountRSQL(){
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
		query.append("FileName : UnmatchBLDBDAOCheckTotalBlAmountRSQL").append("\n"); 
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
		query.append("SELECT  CURR_CD         ," ).append("\n"); 
		query.append("        USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM    GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE   ACCT_XCH_RT_YRMON = LEAST(( SELECT TO_CHAR(RT_APLY_DT, 'YYYYMM') FROM BKG_RATE WHERE BKG_NO = @[bkg_no] ), " ).append("\n"); 
		query.append("                                  ( SELECT MAX(ACCT_XCH_RT_YRMON) FROM GL_MON_XCH_RT ))" ).append("\n"); 
		query.append("AND     ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("AND     @[ca_flg]         = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  CURR_CD         ," ).append("\n"); 
		query.append("        USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM    GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE   ACCT_XCH_RT_YRMON = LEAST(( SELECT TO_CHAR(RT_APLY_DT, 'YYYYMM') FROM BKG_RT_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' ), " ).append("\n"); 
		query.append("                                  ( SELECT MAX(ACCT_XCH_RT_YRMON) FROM GL_MON_XCH_RT ))" ).append("\n"); 
		query.append("AND     ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("AND     @[ca_flg]         = 'Y'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("BR AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("INCLUDE 를 제외한 BKG RATE DATA" ).append("\n"); 
		query.append("COVERED B/L 일 경우는 'DHF', 'NMS', 'CMS', 'ODF' 만 심사 대상으로 처리함." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  SUM( (SELECT BR.CHG_AMT / XR.USD_LOCL_XCH_RT FROM XR WHERE XR.CURR_CD = BR.CURR_CD) )  CHG_USD_AMT, SUM(RAT_AS_QTY) RAT_AS_QTY" ).append("\n"); 
		query.append("FROM    BKG_CHG_RT  BR" ).append("\n"); 
		query.append("WHERE   BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND     NVL(FRT_INCL_XCLD_DIV_CD, 'N')  = 'N'" ).append("\n"); 
		query.append("--AND     AUTO_RAT_CD  NOT IN ( 'I', 'M' )" ).append("\n"); 
		query.append("AND     CHG_CD IN ( 'OFT', 'OAR', 'DAR' , 'DDC')" ).append("\n"); 
		query.append("AND     @[ca_flg]     = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  SUM( (SELECT BR.CHG_AMT / XR.USD_LOCL_XCH_RT FROM XR WHERE XR.CURR_CD = BR.CURR_CD) )  CHG_USD_AMT, SUM(RAT_AS_QTY) RAT_AS_QTY" ).append("\n"); 
		query.append("FROM    BKG_CHG_RT_HIS  BR" ).append("\n"); 
		query.append("WHERE   BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND     CORR_NO       = 'TMP0000001'" ).append("\n"); 
		query.append("AND     NVL(FRT_INCL_XCLD_DIV_CD, 'N')  = 'N'" ).append("\n"); 
		query.append("--AND     AUTO_RAT_CD  NOT IN ( 'I', 'M' )" ).append("\n"); 
		query.append("AND     CHG_CD IN ( 'OFT', 'OAR', 'DAR', 'DDC' )" ).append("\n"); 
		query.append("AND     @[ca_flg]     = 'Y'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("RA AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  RA.OFT_CMB_SEQ  , " ).append("\n"); 
		query.append("        SUM(( SELECT RA.CHG_AMT / XR.USD_LOCL_XCH_RT FROM XR WHERE XR.CURR_CD = RA.CURR_CD ))  CHG_USD_AMT, SUM(RAT_AS_QTY) RAT_AS_QTY" ).append("\n"); 
		query.append("FROM BKG_REV_AUD_CHG_TMP RA" ).append("\n"); 
		query.append("WHERE CHG_CD IN ( 'OFT', 'OAR', 'DAR', 'DDC' )" ).append("\n"); 
		query.append("GROUP BY RA.OFT_CMB_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT RA.OFT_CMB_SEQ" ).append("\n"); 
		query.append("FROM RA, BR" ).append("\n"); 
		query.append("WHERE ABS(BR.CHG_USD_AMT - RA.CHG_USD_AMT) <= 5" ).append("\n"); 
		query.append("AND BR.RAT_AS_QTY = RA.RAT_AS_QTY" ).append("\n"); 

	}
}