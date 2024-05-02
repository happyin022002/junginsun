/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiChgDtl1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.11.04 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiChgDtl1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiChgDtl1RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiChgDtl1RSQL").append("\n"); 
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
		query.append("SELECT '{CHARGE_TTL' || CHR(10)" ).append("\n"); 
		query.append("|| 'PPD_TOTAL:' || SUM(DECODE(RATE.FRT_TERM_CD, 'P', DECODE(CHG_AMT, 'USD', RATE.CHG_AMT" ).append("\n"); 
		query.append(", ROUND(RATE.CHG_AMT/USD_LOCL_XCH_RT, 2))" ).append("\n"); 
		query.append(", 0)) || CHR(10)" ).append("\n"); 
		query.append("|| 'CCT_TOTAL:' || SUM(DECODE(RATE.FRT_TERM_CD, 'C', DECODE(CHG_AMT, 'USD', RATE.CHG_AMT" ).append("\n"); 
		query.append(", ROUND(RATE.CHG_AMT/USD_LOCL_XCH_RT, 2))" ).append("\n"); 
		query.append(", 0)) || CHR(10)" ).append("\n"); 
		query.append("|| 'TOTAL_CUR:' || 'USD' || CHR(10)" ).append("\n"); 
		query.append("|| 'LCL_TOT_AMT:' || CHR(10)" ).append("\n"); 
		query.append("|| 'CGO_RCV_DT:'  || CHR(10)" ).append("\n"); 
		query.append("|| 'ACT_CUST:' || CHR(10)" ).append("\n"); 
		query.append("|| '}CHARGE_TTL'|| CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_CHG_RT RATE, GL_MON_XCH_RT ACCT" ).append("\n"); 
		query.append("WHERE  RATE.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND RATE.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND ACCT.ACCT_XCH_RT_YRMON = (SELECT TO_CHAR (BL_OBRD_DT, 'YYYYMM')" ).append("\n"); 
		query.append("FROM   BKG_BL_DOC" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("AND ACCT.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND ACCT.CURR_CD = RATE.CURR_CD" ).append("\n"); 
		query.append("GROUP BY RATE.FRT_TERM_CD, RATE.CURR_CD" ).append("\n"); 

	}
}