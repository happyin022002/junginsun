/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOSearchRevenueAmountDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26 
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

public class BlRatingDBDAOSearchRevenueAmountDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue Amount 상세 내역을 조회한다
	  * </pre>
	  */
	public BlRatingDBDAOSearchRevenueAmountDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchRevenueAmountDetailRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO,          FRT_TERM_CD,          TRF_ITM_NO,           CGO_CATE_CD," ).append("\n"); 
		query.append("      IMDG_CLSS_CD,     CHG_CD,               CURR_CD,              RAT_UT_CD,  " ).append("\n"); 
		query.append("      RAT_AS_QTY,       CHG_UT_AMT,           CHG_AMT,              RCV_TERM_CD," ).append("\n"); 
		query.append("      DE_TERM_CD,       PRN_HDN_FLG,          'A' AUTO_RAT_CD,      FRT_INCL_XCLD_DIV_CD INCL_OFT_FLG, " ).append("\n"); 
		query.append("      0 APLY_XCH_RTO,   NOTE_RT_SEQ,          PROP_NO,              AMDT_SEQ," ).append("\n"); 
		query.append("      SVC_SCP_CD,       GEN_SPCL_RT_TP_CD,    CMDT_HDR_SEQ,         ROUT_SEQ," ).append("\n"); 
		query.append("      FX_RT_FLG,        @[usr_id] CRE_USR_ID, @[usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("      DECODE(SOC_FLG,'Y','Y','') SOC_FLG, MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("FROM BKG_REV_AUD_CHG_TMP T" ).append("\n"); 

	}
}