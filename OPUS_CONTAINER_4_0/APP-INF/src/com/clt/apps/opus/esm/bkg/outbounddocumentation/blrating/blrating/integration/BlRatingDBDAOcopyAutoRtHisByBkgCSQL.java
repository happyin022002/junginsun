/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOcopyAutoRtHisByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.02
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.02.02 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOcopyAutoRtHisByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOcopyAutoRtHisByBkg
	  * </pre>
	  */
	public BlRatingDBDAOcopyAutoRtHisByBkgCSQL(){
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
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOcopyAutoRtHisByBkgCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_AUTO_RT_HIS( " ).append("\n"); 
		query.append("		  BKG_NO" ).append("\n"); 
		query.append("        , RT_SEQ" ).append("\n"); 
		query.append("		, BL_RT_SEQ" ).append("\n"); 
		query.append("        , DP_SEQ" ).append("\n"); 
		query.append("        , FRT_TERM_CD" ).append("\n"); 
		query.append("        , TRF_ITM_NO" ).append("\n"); 
		query.append("        , CGO_CATE_CD" ).append("\n"); 
		query.append("        , IMDG_CLSS_CD" ).append("\n"); 
		query.append("        , CHG_CD" ).append("\n"); 
		query.append("        , CURR_CD" ).append("\n"); 
		query.append("        , RAT_UT_CD" ).append("\n"); 
		query.append("        , BKG_QTY" ).append("\n"); 
		query.append("        , RAT_AS_QTY" ).append("\n"); 
		query.append("        , CHG_UT_AMT" ).append("\n"); 
		query.append("        , CHG_AMT" ).append("\n"); 
		query.append("        , RCV_TERM_CD" ).append("\n"); 
		query.append("        , DE_TERM_CD" ).append("\n"); 
		query.append("        , N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("        , N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("        , N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("        , FRT_INCL_XCLD_DIV_CD " ).append("\n"); 
		query.append("        , INV_STS_CD" ).append("\n"); 
		query.append("        , PRN_HDN_FLG" ).append("\n"); 
		query.append("		, DIFF_RMK" ).append("\n"); 
		query.append("        , AUTO_RAT_CD" ).append("\n"); 
		query.append("        , APLY_XCH_RTO" ).append("\n"); 
		query.append("        , AGMT_RAT_UT_CD" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT)" ).append("\n"); 
		query.append("SELECT @[mst_bkg_no] BKG_NO" ).append("\n"); 
		query.append("		,(SELECT " ).append("\n"); 
		query.append("					NVL(MAX(RT_SEQ),0)+CHG.RT_SEQ" ).append("\n"); 
		query.append("					FROM BKG_AUTO_RT_HIS" ).append("\n"); 
		query.append("					WHERE BKG_NO = @[mst_bkg_no]) RT_SEQ" ).append("\n"); 
		query.append("		, BL_RT_SEQ" ).append("\n"); 
		query.append("        , DP_SEQ" ).append("\n"); 
		query.append("        , FRT_TERM_CD" ).append("\n"); 
		query.append("        , TRF_ITM_NO" ).append("\n"); 
		query.append("        , CGO_CATE_CD" ).append("\n"); 
		query.append("        , IMDG_CLSS_CD" ).append("\n"); 
		query.append("        , CHG_CD" ).append("\n"); 
		query.append("        , CURR_CD" ).append("\n"); 
		query.append("        , RAT_UT_CD" ).append("\n"); 
		query.append("        , BKG_QTY" ).append("\n"); 
		query.append("        , RAT_AS_QTY" ).append("\n"); 
		query.append("        , CHG_UT_AMT" ).append("\n"); 
		query.append("        , CHG_AMT" ).append("\n"); 
		query.append("        , RCV_TERM_CD" ).append("\n"); 
		query.append("        , DE_TERM_CD" ).append("\n"); 
		query.append("        , N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("        , N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("        , N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("        , FRT_INCL_XCLD_DIV_CD " ).append("\n"); 
		query.append("        , INV_STS_CD" ).append("\n"); 
		query.append("        , PRN_HDN_FLG" ).append("\n"); 
		query.append("		, DIFF_RMK" ).append("\n"); 
		query.append("        , AUTO_RAT_CD" ).append("\n"); 
		query.append("        , APLY_XCH_RTO" ).append("\n"); 
		query.append("        , AGMT_RAT_UT_CD" ).append("\n"); 
		query.append("        , @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("  FROM BKG_AUTO_RT_HIS CHG" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}