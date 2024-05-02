/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOUnmatchDiffAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.08 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOUnmatchDiffAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 차이금액 상세내역
	  * </pre>
	  */
	public UnmatchBLDBDAOUnmatchDiffAmountRSQL(){
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
		params.put("umch_bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOUnmatchDiffAmountRSQL").append("\n"); 
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
		query.append("T.CODE" ).append("\n"); 
		query.append(",T.CURR_CD_C" ).append("\n"); 
		query.append(",T.AMT_C" ).append("\n"); 
		query.append(",T.CHG_CD_B" ).append("\n"); 
		query.append(",T.CURR_CD_B" ).append("\n"); 
		query.append(",T.AMT_B" ).append("\n"); 
		query.append(",T.CURR_CD_D" ).append("\n"); 
		query.append(",(NVL(T.AMT_C,0) - NVL(T.AMT_B,0))            AS AMT_D" ).append("\n"); 
		query.append(",T.US_RT" ).append("\n"); 
		query.append(",(NVL(T.AMT_C,0) - NVL(T.AMT_B,0)) * T.US_RT  AS USD_AMT" ).append("\n"); 
		query.append(",''                                           AS BKG_NO" ).append("\n"); 
		query.append(",''                                           AS UMCH_BKG_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  NVL(A.CHG_CD_C, B.CHG_CD_B)    AS CODE" ).append("\n"); 
		query.append(",A.CURR_CD_C" ).append("\n"); 
		query.append(",A.AMT_C" ).append("\n"); 
		query.append(",B.CHG_CD_B" ).append("\n"); 
		query.append(",B.CURR_CD_B" ).append("\n"); 
		query.append(",B.AMT_B" ).append("\n"); 
		query.append(",NVL(A.CURR_CD_C, B.CURR_CD_B) AS CURR_CD_D" ).append("\n"); 
		query.append(",(SELECT (1 / A1.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT    A1" ).append("\n"); 
		query.append(",BKG_REV_UMCH_BKG B1" ).append("\n"); 
		query.append("WHERE B1.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("AND  B1.UMCH_BKG_SEQ    = @[umch_bkg_seq]" ).append("\n"); 
		query.append("AND  (A1.CURR_CD    = A.CURR_CD_C" ).append("\n"); 
		query.append("OR A1.CURR_CD = B.CURR_CD_B" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND  A1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND  A1.ACCT_XCH_RT_YRMON = SUBSTR(TO_CHAR(NVL(B1.LST_UMCH_FND_DT,SYSDATE),'YYYYMMDD'),0,6)" ).append("\n"); 
		query.append(") AS US_RT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  CHG_CD  													   AS CHG_CD_C" ).append("\n"); 
		query.append(",CURR_CD 												       AS CURR_CD_C" ).append("\n"); 
		query.append(",SUM(RAT_UT_QTY * FRT_RT_AMT / DECODE(RAT_UT_CD, 'PC', 100, 1)) AS AMT_C" ).append("\n"); 
		query.append("FROM    BKG_REV_UMCH_ITM_DTL" ).append("\n"); 
		query.append("WHERE   BKG_NO              = @[bkg_no]" ).append("\n"); 
		query.append("AND     UMCH_BKG_SEQ        = @[umch_bkg_seq]" ).append("\n"); 
		query.append("AND     UMCH_BKG_CTRT_TP_CD = 'C'" ).append("\n"); 
		query.append("GROUP BY CHG_CD, CURR_CD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("FULL OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  CHG_CD												           AS CHG_CD_B" ).append("\n"); 
		query.append(",CURR_CD													       AS CURR_CD_B" ).append("\n"); 
		query.append(",SUM(RAT_UT_QTY * FRT_RT_AMT / DECODE(RAT_UT_CD, 'PC', 100, 1)) AS AMT_B" ).append("\n"); 
		query.append("FROM   BKG_REV_UMCH_ITM_DTL" ).append("\n"); 
		query.append("WHERE  BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND    UMCH_BKG_SEQ  = @[umch_bkg_seq]" ).append("\n"); 
		query.append("AND    UMCH_BKG_CTRT_TP_CD = 'B'" ).append("\n"); 
		query.append("GROUP BY CHG_CD, CURR_CD" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON  A.CHG_CD_C  = B.CHG_CD_B" ).append("\n"); 
		query.append("AND A.CURR_CD_C = B.CURR_CD_B" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}