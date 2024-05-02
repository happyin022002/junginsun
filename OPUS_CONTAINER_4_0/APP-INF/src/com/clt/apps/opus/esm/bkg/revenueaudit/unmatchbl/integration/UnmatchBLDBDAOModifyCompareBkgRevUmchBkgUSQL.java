/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOModifyCompareBkgRevUmchBkgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.11 
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

public class UnmatchBLDBDAOModifyCompareBkgRevUmchBkgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCompareBkgRevUmchBkg
	  * </pre>
	  */
	public UnmatchBLDBDAOModifyCompareBkgRevUmchBkgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_umch_bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("umch_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOModifyCompareBkgRevUmchBkgUSQL").append("\n"); 
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
		query.append("UPDATE BKG_REV_UMCH_BKG" ).append("\n"); 
		query.append("SET   STL_SYS_DIFF_AMT " ).append("\n"); 
		query.append("                        = (" ).append("\n"); 
		query.append("							SELECT SUM( DECODE(A.UMCH_BKG_CTRT_TP_CD, 'C', A.RAT_UT_QTY * A.FRT_RT_AMT / DECODE(A.RAT_UT_CD, 'PC', 100, 1) / B.USD_LOCL_XCH_RT, 0) )" ).append("\n"); 
		query.append("                            	   -" ).append("\n"); 
		query.append("					        	   SUM( DECODE(A.UMCH_BKG_CTRT_TP_CD, 'B', A.RAT_UT_QTY * A.FRT_RT_AMT / DECODE(A.RAT_UT_CD, 'PC', 100, 1) / B.USD_LOCL_XCH_RT, 0) )" ).append("\n"); 
		query.append("					        FROM   BKG_REV_UMCH_ITM_DTL  A ," ).append("\n"); 
		query.append("						           GL_MON_XCH_RT         B" ).append("\n"); 
		query.append("						    WHERE  B.ACCT_XCH_RT_YRMON = LEAST(( SELECT TO_CHAR(RT_APLY_DT, 'YYYYMM') FROM BKG_RATE WHERE BKG_NO = @[bkg_no] ), (SELECT MAX(ACCT_XCH_RT_YRMON) FROM GL_MON_XCH_RT ))" ).append("\n"); 
		query.append("	                        AND     B.ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("				            AND     B.CURR_CD           = A.CURR_CD" ).append("\n"); 
		query.append("					        AND     A.BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("						    AND     A.UMCH_BKG_SEQ      = TO_NUMBER(@[max_umch_bkg_seq])" ).append("\n"); 
		query.append("						  )" ).append("\n"); 
		query.append("	  ,STL_MNL_DIFF_AMT" ).append("\n"); 
		query.append("                        = (" ).append("\n"); 
		query.append("							SELECT SUM( DECODE(A.UMCH_BKG_CTRT_TP_CD, 'C', A.RAT_UT_QTY * A.FRT_RT_AMT / DECODE(A.RAT_UT_CD, 'PC', 100, 1) / B.USD_LOCL_XCH_RT, 0) )" ).append("\n"); 
		query.append("                            	   -" ).append("\n"); 
		query.append("					        	   SUM( DECODE(A.UMCH_BKG_CTRT_TP_CD, 'B', A.RAT_UT_QTY * A.FRT_RT_AMT / DECODE(A.RAT_UT_CD, 'PC', 100, 1) / B.USD_LOCL_XCH_RT, 0) )" ).append("\n"); 
		query.append("					        FROM   BKG_REV_UMCH_ITM_DTL  A ," ).append("\n"); 
		query.append("						           GL_MON_XCH_RT         B" ).append("\n"); 
		query.append("						    WHERE  B.ACCT_XCH_RT_YRMON = LEAST(( SELECT TO_CHAR(RT_APLY_DT, 'YYYYMM') FROM BKG_RATE WHERE BKG_NO = @[bkg_no] ), (SELECT MAX(ACCT_XCH_RT_YRMON) FROM GL_MON_XCH_RT ))" ).append("\n"); 
		query.append("	                        AND     B.ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("				            AND     B.CURR_CD           = A.CURR_CD" ).append("\n"); 
		query.append("					        AND     A.BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("						    AND     A.UMCH_BKG_SEQ      = TO_NUMBER(@[max_umch_bkg_seq])" ).append("\n"); 
		query.append("						  )" ).append("\n"); 
		query.append("WHERE  BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND    UMCH_BKG_SEQ = TO_NUMBER(@[max_umch_bkg_seq])" ).append("\n"); 

	}
}