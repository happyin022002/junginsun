/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOSearchChgRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchChgRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 운임 목록 리스트 데이터를 조회한다.
	  * </pre>
	  */
	public BlRatingDBDAOSearchChgRateRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchChgRateRSQL").append("\n"); 
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
		query.append("#if (${caflag} == 'Y') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    BKG_NO" ).append("\n"); 
		query.append("    ,RT_SEQ" ).append("\n"); 
		query.append("    ,CHG_CD" ).append("\n"); 
		query.append("    ,TRF_ITM_NO" ).append("\n"); 
		query.append("    ,CURR_CD" ).append("\n"); 
		query.append("    ,CHG_UT_AMT" ).append("\n"); 
		query.append("    ,RAT_AS_QTY" ).append("\n"); 
		query.append("    ,RAT_UT_CD" ).append("\n"); 
		query.append("    ,CHG_AMT" ).append("\n"); 
		query.append("    ,FRT_INCL_XCLD_DIV_CD as INCL_OFT_FLG" ).append("\n"); 
		query.append("    ,FRT_TERM_CD" ).append("\n"); 
		query.append("    ,N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("    ,N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("	,DECODE(N3PTY_CUST_SEQ,0,'',N3PTY_CUST_SEQ) AS N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("    ,CGO_CATE_CD" ).append("\n"); 
		query.append("    ,RCV_TERM_CD" ).append("\n"); 
		query.append("    ,DE_TERM_CD" ).append("\n"); 
		query.append("    ,IMDG_CLSS_CD" ).append("\n"); 
		query.append("    ,AUTO_RAT_CD" ).append("\n"); 
		query.append("    ,PRN_HDN_FLG" ).append("\n"); 
		query.append("	,NOTE_RT_SEQ" ).append("\n"); 
		query.append("	,PROP_NO" ).append("\n"); 
		query.append("	,AMDT_SEQ" ).append("\n"); 
		query.append("	,SVC_SCP_CD" ).append("\n"); 
		query.append("	,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("	,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,ROUT_SEQ" ).append("\n"); 
		query.append("	,CASE  " ).append("\n"); 
		query.append("	 WHEN DP_SEQ = 0 THEN DP_SEQ + 999	" ).append("\n"); 
		query.append("	 ELSE DP_SEQ" ).append("\n"); 
		query.append("	 END DP_SEQ " ).append("\n"); 
		query.append("	,TAX_FLG" ).append("\n"); 
		query.append("	,(SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = A.CURR_CD) AS DP_PRCS_KNT" ).append("\n"); 
		query.append("    ,CASE WHEN (SELECT COUNT(TAX_CNT_CD) FROM MDM_CHARGE WHERE TAX_CNT_CD='VN' AND DELT_FLG ='N' AND CHG_CD = A.CHG_CD) > 0 THEN 'Y' ELSE 'N' END VN_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    BKG_CHG_RT_HIS A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("    AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("ORDER BY DECODE(FRT_INCL_XCLD_DIV_CD,'N','1','I','2','E','3','4'), DP_SEQ, RT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	,RT_SEQ" ).append("\n"); 
		query.append("    ,CHG_CD" ).append("\n"); 
		query.append("    ,TRF_ITM_NO" ).append("\n"); 
		query.append("    ,CURR_CD" ).append("\n"); 
		query.append("    ,CHG_UT_AMT" ).append("\n"); 
		query.append("    ,RAT_AS_QTY" ).append("\n"); 
		query.append("    ,RAT_UT_CD" ).append("\n"); 
		query.append("    ,CHG_AMT" ).append("\n"); 
		query.append("    ,FRT_INCL_XCLD_DIV_CD as INCL_OFT_FLG" ).append("\n"); 
		query.append("    ,FRT_TERM_CD" ).append("\n"); 
		query.append("    ,N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("    ,N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("	,DECODE(N3PTY_CUST_SEQ,0,'',N3PTY_CUST_SEQ) AS N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("    ,CGO_CATE_CD" ).append("\n"); 
		query.append("    ,RCV_TERM_CD" ).append("\n"); 
		query.append("    ,DE_TERM_CD" ).append("\n"); 
		query.append("    ,IMDG_CLSS_CD" ).append("\n"); 
		query.append("    ,AUTO_RAT_CD" ).append("\n"); 
		query.append("    ,PRN_HDN_FLG" ).append("\n"); 
		query.append("	,NOTE_RT_SEQ" ).append("\n"); 
		query.append("	,PROP_NO" ).append("\n"); 
		query.append("	,AMDT_SEQ" ).append("\n"); 
		query.append("	,SVC_SCP_CD" ).append("\n"); 
		query.append("	,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("	,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,ROUT_SEQ" ).append("\n"); 
		query.append("	,CASE  " ).append("\n"); 
		query.append("	 WHEN DP_SEQ = 0 THEN DP_SEQ + 999	" ).append("\n"); 
		query.append("	 ELSE DP_SEQ" ).append("\n"); 
		query.append("	 END DP_SEQ" ).append("\n"); 
		query.append("	,TAX_FLG" ).append("\n"); 
		query.append("	,(SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = A.CURR_CD) AS DP_PRCS_KNT" ).append("\n"); 
		query.append("    ,CASE WHEN (SELECT COUNT(TAX_CNT_CD) FROM MDM_CHARGE WHERE TAX_CNT_CD='VN' AND DELT_FLG ='N' AND CHG_CD = A.CHG_CD) > 0 THEN 'Y' ELSE 'N' END VN_FLG" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    BKG_CHG_RT A" ).append("\n"); 
		query.append("WHERE  BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("ORDER BY DECODE(FRT_INCL_XCLD_DIV_CD,'N','1','I','2','E','3','4'), DP_SEQ, RT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}