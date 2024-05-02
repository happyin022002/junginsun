/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchBookingChargeOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchBookingChargeOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1) 해당 BKG의 Shipper code와 DMT의 Payer Code와 같은 경우
	  * 2) DMT type : DTOC, DMOF
	  * 3) Status : I
	  * 4) AR interface : No
	  * 5) TOTAL USD AMT
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchBookingChargeOBRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchBookingChargeOBRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(ROUND(B.INV_CHG_AMT/F1.USD_LOCL_XCH_RT* CASE WHEN C1.CURR_CD = NULL THEN 1" ).append("\n"); 
		query.append("ELSE F2.USD_LOCL_XCH_RT END, 2)),0)||' '||NVL(C1.CURR_CD,'USD') AS INV_AMT_USD" ).append("\n"); 
		query.append("FROM DMT_INV_MN B, BKG_CUSTOMER BC, GL_MON_XCH_RT F1, MDM_COUNTRY C1, GL_MON_XCH_RT F2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD IN ( 'DTOC', 'DMOF','CTOC' )" ).append("\n"); 
		query.append("AND NVL(B.PRG_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BC.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND B.ACT_PAYR_CNT_CD = BC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND B.ACT_PAYR_SEQ = BC.CUST_SEQ" ).append("\n"); 
		query.append("AND F1.ACCT_XCH_RT_YRMON    =   TO_CHAR(B.CRE_DT, 'YYYYMM')" ).append("\n"); 
		query.append("AND F1.ACCT_XCH_RT_LVL      =   1" ).append("\n"); 
		query.append("AND F1.CURR_CD              =   B.INV_CURR_CD" ).append("\n"); 
		query.append("AND B.DMDT_AR_IF_CD = 'N'" ).append("\n"); 
		query.append("AND BC.CUST_CNT_CD = C1.CNT_CD" ).append("\n"); 
		query.append("AND F2.ACCT_XCH_RT_YRMON    =   TO_CHAR(B.CRE_DT, 'YYYYMM')" ).append("\n"); 
		query.append("AND F2.ACCT_XCH_RT_LVL      =   1" ).append("\n"); 
		query.append("AND F2.CURR_CD              =   NVL(C1.CURR_CD,'USD')" ).append("\n"); 
		query.append("AND ( (B.DMDT_INV_STS_CD = 'I') OR (B.DMDT_INV_STS_CD = 'C' AND B.CR_INV_NO IS NOT NULL))" ).append("\n"); 
		query.append("GROUP BY C1.CURR_CD" ).append("\n"); 

	}
}