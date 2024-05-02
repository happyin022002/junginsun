/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommCalcHistoryDBDAOSearchCalcDtlBkgRevenueListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.10 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommCalcHistoryDBDAOSearchCalcDtlBkgRevenueListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AGNCommCalcHistoryDBDAOSearchCalcDtlBkgRevenueListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.integration").append("\n");
		query.append("FileName : AGNCommCalcHistoryDBDAOSearchCalcDtlBkgRevenueListRSQL").append("\n");
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
		query.append("SELECT DISTINCT A.CHG_CD AS CHG_CD," ).append("\n");
		query.append("       ROUND(A.CHG_AMT, 2) AS CHG_AMT," ).append("\n");
		query.append("       A.CURR_CD," ).append("\n");
		query.append("       ROUND(A.CHG_AMT * DECODE(A.CURR_CD, 'USD', 1, NVL(C.USD_LOCL_XCH_RT, 0)), 2) AS USD_CHG_AMT," ).append("\n");
		query.append("       A.RT_SEQ" ).append("\n");
		query.append("  FROM BKG_CHG_RT A," ).append("\n");
		query.append("       ACM_AGN_COMM_HIS B," ).append("\n");
		query.append("       GL_MON_XCH_RT C" ).append("\n");
		query.append(" WHERE B.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("   AND NVL(A.FRT_INCL_XCLD_DIV_CD, 'N') = 'N'" ).append("\n");
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n");
		query.append("   AND B.AGN_CD = @[agn_cd]" ).append("\n");
		query.append("   AND B.IO_BND_CD = @[io_bnd_cd]" ).append("\n");
		query.append("   AND B.AC_TP_CD <> 'T'" ).append("\n");
		query.append("   AND B.AC_SEQ = @[ac_seq]" ).append("\n");
		query.append("   AND B.CALC_NO = @[calc_no]" ).append("\n");
		query.append("   AND C.ACCT_XCH_RT_YRMON = DECODE(SIGN(TO_DATE(SUBSTR(NVL(B.SAIL_ARR_DT, TO_CHAR(SYSDATE, 'YYYYMMDD')), 1, 6), 'YYYYMM') - SYSDATE), 1, TO_CHAR(SYSDATE, 'YYYYMM'), SUBSTR(NVL(B.SAIL_ARR_DT, TO_CHAR(SYSDATE, 'YYYYMMDD')), 1, 6))" ).append("\n");
		query.append("   AND C.ACCT_XCH_RT_LVL = '1'" ).append("\n");
		query.append("   AND A.CURR_CD = C.CURR_CD" ).append("\n");
		query.append(" ORDER BY A.RT_SEQ" ).append("\n");

	}
}