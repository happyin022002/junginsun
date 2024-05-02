/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UnmatchBLDBDAOCreateRevenueAuditOftForMultiRatingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCreateRevenueAuditOftForMultiRatingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group & Multi B/L Rating을위해 RevenueAuditOft를 생성한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOCreateRevenueAuditOftForMultiRatingCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCreateRevenueAuditOftForMultiRatingCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_REV_AUD_CHG_TMP (" ).append("\n"); 
		query.append("       BKG_NO      ," ).append("\n"); 
		query.append("       OFT_CMB_SEQ ," ).append("\n"); 
		query.append("       CHG_RT_SEQ  ," ).append("\n"); 
		query.append("       CHG_CD      ," ).append("\n"); 
		query.append("       RAT_UT_CD   ," ).append("\n"); 
		query.append("       CURR_CD     ," ).append("\n"); 
		query.append("       CHG_UT_AMT  ," ).append("\n"); 
		query.append("       RAT_AS_QTY  ," ).append("\n"); 
		query.append("       CHG_AMT     ," ).append("\n"); 
		query.append("       CGO_CATE_CD ," ).append("\n"); 
		query.append("       SOC_FLG     ," ).append("\n"); 
		query.append("       RCV_TERM_CD ," ).append("\n"); 
		query.append("       DE_TERM_CD  ," ).append("\n"); 
		query.append("	   CRE_USR_ID  ," ).append("\n"); 
		query.append("	   CRE_DT      ," ).append("\n"); 
		query.append("       UPD_USR_ID  ," ).append("\n"); 
		query.append("	   UPD_DT      ," ).append("\n"); 
		query.append("       FRT_TERM_CD ," ).append("\n"); 
		query.append("       TRF_ITM_NO  ," ).append("\n"); 
		query.append("       FRT_INCL_XCLD_DIV_CD," ).append("\n"); 
		query.append("       PRN_HDN_FLG ," ).append("\n"); 
		query.append("       NOTE_RT_SEQ ," ).append("\n"); 
		query.append("       PROP_NO     ," ).append("\n"); 
		query.append("       AMDT_SEQ    ," ).append("\n"); 
		query.append("       SVC_SCP_CD  ," ).append("\n"); 
		query.append("       GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("       CMDT_HDR_SEQ," ).append("\n"); 
		query.append("       ROUT_SEQ    ," ).append("\n"); 
		query.append("       IMDG_CLSS_CD," ).append("\n"); 
		query.append("       FX_RT_FLG," ).append("\n"); 
		query.append("       MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG_NO      ," ).append("\n"); 
		query.append("       OFT_CMB_SEQ ," ).append("\n"); 
		query.append("       OFRT_SEQ    ," ).append("\n"); 
		query.append("       CHG_CD      ," ).append("\n"); 
		query.append("       RAT_UT_CD   ," ).append("\n"); 
		query.append("       CURR_CD     ," ).append("\n"); 
		query.append("       CHG_UT_AMT  ," ).append("\n"); 
		query.append("       RAT_AS_QTY  ," ).append("\n"); 
		query.append("       CHG_AMT     ," ).append("\n"); 
		query.append("       CASE WHEN DCGO_FLG    = 'Y' THEN 'DG'  " ).append("\n"); 
		query.append("            WHEN AWK_CGO_FLG = 'Y' THEN 'AK'" ).append("\n"); 
		query.append("            WHEN RC_FLG      = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("            WHEN BB_CGO_FLG  = 'Y' THEN 'BB'" ).append("\n"); 
		query.append("            ELSE 'DR'  " ).append("\n"); 
		query.append("       END CGO_CATE_CD ," ).append("\n"); 
		query.append("       SOC_FLG     ," ).append("\n"); 
		query.append("       RCV_TERM_CD ," ).append("\n"); 
		query.append("       DE_TERM_CD  ," ).append("\n"); 
		query.append("	   CRE_USR_ID  ," ).append("\n"); 
		query.append("	   SYSDATE     ," ).append("\n"); 
		query.append("       UPD_USR_ID  ," ).append("\n"); 
		query.append("	   SYSDATE     ," ).append("\n"); 
		query.append("       (SELECT FRT_TERM_CD FROM BKG_RATE R WHERE R.BKG_NO = T.BKG_NO)," ).append("\n"); 
		query.append("       TRF_ITM_NO  ," ).append("\n"); 
		query.append("       FRT_INCL_XCLD_DIV_CD," ).append("\n"); 
		query.append("       'N' PRN_HDN_FLG ," ).append("\n"); 
		query.append("       PRC_RT_SEQ  ," ).append("\n"); 
		query.append("       PROP_NO     ," ).append("\n"); 
		query.append("       AMDT_SEQ    ," ).append("\n"); 
		query.append("       SVC_SCP_CD  ," ).append("\n"); 
		query.append("       PRC_GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("       PRC_CMDT_HDR_SEQ," ).append("\n"); 
		query.append("       PRC_ROUT_SEQ    ," ).append("\n"); 
		query.append("       IMDG_CLSS_CD," ).append("\n"); 
		query.append("       FX_RT_FLG," ).append("\n"); 
		query.append("       MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("FROM   BKG_AUTO_RT_OCN_FRT_TMP T" ).append("\n"); 

	}
}