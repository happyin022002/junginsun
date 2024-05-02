/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOBasicRegisterDAOCustomAcctCateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDAOCustomAcctCateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOBasicRegisterDAOCustomAcctCateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDAOCustomAcctCateVORSQL").append("\n"); 
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
		query.append("SELECT B.ACCT_CD" ).append("\n"); 
		query.append("     , A.ACCT_ENG_NM" ).append("\n"); 
		query.append("     , B.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("     , B.ACCT_ITM_NM" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'OT', 'Y', 'N')) CHK_OTHER_EXP" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'CH', 'Y', 'N')) CHK_CHARTERER" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'OF', 'Y', 'N')) CHK_OFF_HIRE" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'BU', 'Y', 'N')) CHK_BODBOR_IF" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'TC', 'Y', 'N')) CHK_HIRE" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'TO', 'Y', 'N')) CHK_HIRE_REVENUE" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'AD', 'Y', 'N')) CHK_ADDRESS" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'BR', 'Y', 'N')) CHK_BROKERAGE" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'PR', 'Y', 'N')) CHK_PREPAYMENTP" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'OW', 'Y', 'N')) CHK_OWNER" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'PS', 'Y', 'N')) CHK_PREPAYMENTS" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'MS', 'Y', 'N')) CHK_MANUAL_SLIP" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'VV', 'Y', 'N')) CHK_VVD_REQUIRED" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'OT', 'OTY', 'OTN')) PREV_OTHER_EXP" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'CH', 'CHY', 'CHN')) PREV_CHARTERER" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'OF', 'OFY', 'OFN')) PREV_OFF_HIRE" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'BU', 'BUY', 'BUN')) PREV_BODBOR_IF" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'TC', 'TCY', 'TCN')) PREV_HIRE" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'TO', 'TOY', 'TON')) PREV_HIRE_REVENUE" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'AD', 'ADY', 'ADN')) PREV_ADDRESS" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'BR', 'BRY', 'BRN')) PREV_BROKERAGE" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'PR', 'PRY', 'PRN')) PREV_PREPAYMENTP" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'OW', 'OWY', 'OWN')) PREV_OWNER" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'PS', 'PSY', 'PSN')) PREV_PREPAYMENTS" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'MS', 'MSY', 'MSN')) PREV_MANUAL_SLIP" ).append("\n"); 
		query.append("     , MAX(DECODE( C.FLET_ACCT_CATE_CD, 'VV', 'VVY', 'VVN')) PREV_VVD_REQUIRED" ).append("\n"); 
		query.append("  FROM MDM_ACCOUNT A" ).append("\n"); 
		query.append("     , FMS_ACCT_ITM B" ).append("\n"); 
		query.append("     , FMS_ACCT_CATE C" ).append("\n"); 
		query.append(" WHERE A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("   AND B.ACCT_CD = C.ACCT_CD(+)" ).append("\n"); 
		query.append("   AND B.ACCT_ITM_SEQ = C.ACCT_ITM_SEQ(+)" ).append("\n"); 
		query.append("   AND B.ACCT_CD NOT IN ('610411', '612911', '710311', '712911')" ).append("\n"); 
		query.append(" GROUP BY B.ACCT_CD, A.ACCT_ENG_NM, B.ACCT_ITM_SEQ, B.ACCT_ITM_NM" ).append("\n"); 
		query.append(" ORDER BY B.ACCT_CD, B.ACCT_ITM_NM" ).append("\n"); 

	}
}