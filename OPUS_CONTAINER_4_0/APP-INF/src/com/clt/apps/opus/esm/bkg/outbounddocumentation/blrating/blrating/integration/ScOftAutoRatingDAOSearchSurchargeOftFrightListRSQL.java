/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScOftAutoRatingDAOSearchSurchargeOftFrightListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.12.03 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScOftAutoRatingDAOSearchSurchargeOftFrightListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScOftAutoRatingDBDAOSearchSurchargeOftFrightListRSQL
	  * BKG_AUTO_RT_OCN_FRT_TMP 을 SELECT 한다
	  * </pre>
	  */
	public ScOftAutoRatingDAOSearchSurchargeOftFrightListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : ScOftAutoRatingDAOSearchSurchargeOftFrightListRSQL").append("\n"); 
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
		query.append("A.BKG_NO BKG_NO," ).append("\n"); 
		query.append("A.OFT_CMB_SEQ OFT_CMB_SEQ," ).append("\n"); 
		query.append("A.OFRT_SEQ OFRT_SEQ," ).append("\n"); 
		query.append("A.CHG_CD CHG_CD," ).append("\n"); 
		query.append("A.CHG_UT_AMT CHG_UT_AMT," ).append("\n"); 
		query.append("A.CURR_CD CURR_CD," ).append("\n"); 
		query.append("A.CHG_AMT CHG_AMT," ).append("\n"); 
		query.append("RAT_AS_QTY RAT_AS_QTY," ).append("\n"); 
		query.append("(SELECT MAX(OFT_CMB_SEQ) FROM BKG_AUTO_RT_OCN_FRT_TMP) MAX_OFT_CMB_SEQ," ).append("\n"); 
		query.append("(SELECT MAX(OFRT_SEQ) FROM BKG_AUTO_RT_OCN_FRT_TMP) MAX_OFRT_SEQ," ).append("\n"); 
		query.append("K.SUM_AMOUNT" ).append("\n"); 
		query.append("FROM BKG_AUTO_RT_OCN_FRT_TMP A," ).append("\n"); 
		query.append("(SELECT BKG_NO,OFT_CMB_SEQ," ).append("\n"); 
		query.append("SUM(CHG_AMT) SUM_AMOUNT" ).append("\n"); 
		query.append("FROM BKG_AUTO_RT_OCN_FRT_TMP" ).append("\n"); 
		query.append("GROUP BY BKG_NO,OFT_CMB_SEQ ) K" ).append("\n"); 
		query.append("WHERE A.BKG_NO = K.BKG_NO" ).append("\n"); 
		query.append("AND A.OFT_CMB_SEQ = K.OFT_CMB_SEQ" ).append("\n"); 
		query.append("ORDER BY OFRT_SEQ" ).append("\n"); 

	}
}