/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommDBDAODeductionRatingVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.03.08 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommDBDAODeductionRatingVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0012  화면의 Rating 정보 조회
	  * </pre>
	  */
	public AGTCommDBDAODeductionRatingVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTCommDBDAODeductionRatingVORSQL").append("\n"); 
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
		query.append("DISTINCT A.CHG_CD AS CHG_CD," ).append("\n"); 
		query.append("A.CURR_CD CURR_CD," ).append("\n"); 
		query.append("ROUND(A.CHG_UT_AMT, 2) AS CHG_UT_AMT," ).append("\n"); 
		query.append("A.RAT_AS_QTY AS RAT_AS_QTY," ).append("\n"); 
		query.append("A.RAT_UT_CD AS RAT_UT_CD," ).append("\n"); 
		query.append("ROUND(A.CHG_AMT, 2) AS CHG_AMT," ).append("\n"); 
		query.append("ROUND(A.CHG_AMT/DECODE(A.CURR_CD, 'USD', 1, NVL(C.USD_LOCL_XCH_RT, 0)), 2) AS CHG_AMT_RT," ).append("\n"); 
		query.append("A.FRT_INCL_XCLD_DIV_CD AS INCL_OFT_FLG," ).append("\n"); 
		query.append("NVL(A.N3PTY_CUST_CNT_CD, ' ')||REPLACE(TO_CHAR(A.N3PTY_CUST_SEQ, 'FM000000'), '000000', ' ') AS CUST_PAYER," ).append("\n"); 
		query.append("A.CGO_CATE_CD AS CGO_CATE_CD ," ).append("\n"); 
		query.append("A.RCV_TERM_CD AS RCV_TERM_CD," ).append("\n"); 
		query.append("A.DE_TERM_CD AS DE_TERM_CD," ).append("\n"); 
		query.append("A.RT_SEQ AS RT_SEQ" ).append("\n"); 
		query.append("FROM   BKG_CHG_RT A," ).append("\n"); 
		query.append("AGT_AGN_COMM B," ).append("\n"); 
		query.append("GL_MON_XCH_RT C" ).append("\n"); 
		query.append("WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND NVL(A.FRT_INCL_XCLD_DIV_CD,'N') = 'N'" ).append("\n"); 
		query.append("AND    A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    B.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("AND    B.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND    B.AC_TP_CD <> 'T'" ).append("\n"); 
		query.append("AND    B.AC_SEQ = @[ac_seq]" ).append("\n"); 
		query.append("AND    C.ACCT_XCH_RT_YRMON = DECODE(SIGN(TO_DATE(SUBSTR(NVL(B.SAIL_ARR_DT, TO_CHAR(SYSDATE, 'YYYYMMDD')), 1, 6), 'YYYYMM') - SYSDATE), 1, TO_CHAR(SYSDATE, 'YYYYMM'), SUBSTR(NVL(B.SAIL_ARR_DT, TO_CHAR(SYSDATE, 'YYYYMMDD')), 1, 6) )" ).append("\n"); 
		query.append("AND    C.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND    A.CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("ORDER BY A.RT_SEQ" ).append("\n"); 

	}
}