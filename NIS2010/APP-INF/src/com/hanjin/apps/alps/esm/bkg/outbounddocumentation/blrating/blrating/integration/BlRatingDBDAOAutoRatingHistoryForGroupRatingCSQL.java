/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOAutoRatingHistoryForGroupRatingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOAutoRatingHistoryForGroupRatingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Rating으로 계산된 Autorating History를 저장한다.
	  * </pre>
	  */
	public BlRatingDBDAOAutoRatingHistoryForGroupRatingCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOAutoRatingHistoryForGroupRatingCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_AUTO_RT_HIS (" ).append("\n"); 
		query.append("   BKG_NO, RT_SEQ, BL_RT_SEQ, DP_SEQ, " ).append("\n"); 
		query.append("   FRT_TERM_CD, TRF_ITM_NO, CGO_CATE_CD, " ).append("\n"); 
		query.append("   IMDG_CLSS_CD, CHG_CD, CURR_CD, " ).append("\n"); 
		query.append("   RAT_UT_CD, RAT_AS_QTY, " ).append("\n"); 
		query.append("   CHG_UT_AMT, CHG_AMT, RCV_TERM_CD, " ).append("\n"); 
		query.append("   DE_TERM_CD, FRT_INCL_XCLD_DIV_CD, " ).append("\n"); 
		query.append("   PRN_HDN_FLG, AUTO_RAT_CD, " ).append("\n"); 
		query.append("   NOTE_RT_SEQ,PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("   SOC_FLG," ).append("\n"); 
		query.append("   CRE_USR_ID, CRE_DT, " ).append("\n"); 
		query.append("   UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    BKG_NO, ROWNUM, 1,(SELECT A.DP_SEQ FROM MDM_CHARGE A WHERE A.CHG_CD= T.CHG_CD AND DELT_FLG='N')," ).append("\n"); 
		query.append("    FRT_TERM_CD, TRF_ITM_NO, CGO_CATE_CD," ).append("\n"); 
		query.append("    '' IMDG_CLSS_CD, CHG_CD, CURR_CD, " ).append("\n"); 
		query.append("   RAT_UT_CD, RAT_AS_QTY, " ).append("\n"); 
		query.append("   CHG_UT_AMT, CHG_AMT, RCV_TERM_CD, " ).append("\n"); 
		query.append("   DE_TERM_CD, " ).append("\n"); 
		query.append("   FRT_INCL_XCLD_DIV_CD, " ).append("\n"); 
		query.append("   PRN_HDN_FLG, 'A' AUTO_RAT_CD, " ).append("\n"); 
		query.append("   NOTE_RT_SEQ,PROP_NO,AMDT_SEQ,SVC_SCP_CD,GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("   DECODE(SOC_FLG,'Y','Y','') SOC_FLG," ).append("\n"); 
		query.append("   CRE_USR_ID, CRE_DT, " ).append("\n"); 
		query.append("   UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append("FROM BKG_REV_AUD_CHG_TMP T" ).append("\n"); 

	}
}