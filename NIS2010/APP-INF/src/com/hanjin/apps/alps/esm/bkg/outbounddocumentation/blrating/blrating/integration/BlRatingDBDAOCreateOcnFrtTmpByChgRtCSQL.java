/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOCreateOcnFrtTmpByChgRtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.12 
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

public class BlRatingDBDAOCreateOcnFrtTmpByChgRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_AUTO_RT_OCN_FRT_TMP 가 생성
	  * </pre>
	  */
	public BlRatingDBDAOCreateOcnFrtTmpByChgRtCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOCreateOcnFrtTmpByChgRtCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_AUTO_RT_OCN_FRT_TMP " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("OFT_CMB_SEQ," ).append("\n"); 
		query.append("USR_ID," ).append("\n"); 
		query.append("OFRT_SEQ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("EQ_SUBST_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CTRT_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("RCV_TERM_CD," ).append("\n"); 
		query.append("DE_TERM_CD," ).append("\n"); 
		query.append("DRY_CGO_FLG," ).append("\n"); 
		query.append("AWK_CGO_FLG," ).append("\n"); 
		query.append("DCGO_FLG," ).append("\n"); 
		query.append("RC_FLG," ).append("\n"); 
		query.append("BB_CGO_FLG," ).append("\n"); 
		query.append("SOC_FLG," ).append("\n"); 
		query.append("IMDG_CLSS_CD," ).append("\n"); 
		query.append("PRC_GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("PRC_CMDT_HDR_SEQ," ).append("\n"); 
		query.append("PRC_ROUT_SEQ," ).append("\n"); 
		query.append("PRC_RT_SEQ," ).append("\n"); 
		query.append("OP_CNTR_QTY," ).append("\n"); 
		query.append("CHG_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("CHG_UT_AMT," ).append("\n"); 
		query.append("RAT_AS_QTY," ).append("\n"); 
		query.append("CHG_AMT," ).append("\n"); 
		query.append("RAT_UT_CD," ).append("\n"); 
		query.append("POR_MTCH_FLG," ).append("\n"); 
		query.append("DEL_MTCH_FLG," ).append("\n"); 
		query.append("TRI_PROP_NO," ).append("\n"); 
		query.append("FRT_INCL_XCLD_DIV_CD," ).append("\n"); 
		query.append("UT_NOTE_CONV_TP_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("SELECT R.BKG_NO," ).append("\n"); 
		query.append("       1 OFT_CMB_SEQ," ).append("\n"); 
		query.append("       'HOMPAGE' USR_ID," ).append("\n"); 
		query.append("       RT_SEQ OFRT_SEQ,  " ).append("\n"); 
		query.append("       RAT_UT_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       RAT_UT_CD EQ_SUBST_CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("       RAT_UT_CD CTRT_CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("       RCV_TERM_CD," ).append("\n"); 
		query.append("       DE_TERM_CD," ).append("\n"); 
		query.append("       DECODE(CGO_CATE_CD,'DR','Y','RD','Y','N') DRY_CGO_FLG," ).append("\n"); 
		query.append("       DECODE(CGO_CATE_CD,'AK','Y','N') AWK_CGO_FLG," ).append("\n"); 
		query.append("       DECODE(CGO_CATE_CD,'DG','Y','N') DCGO_FLG," ).append("\n"); 
		query.append("       DECODE(CGO_CATE_CD,'RF','Y','N') RC_FLG," ).append("\n"); 
		query.append("       DECODE(CGO_CATE_CD,'BB','Y','N') BB_CGO_FLG," ).append("\n"); 
		query.append("       'N' SOC_FLG, " ).append("\n"); 
		query.append("       IMDG_CLSS_CD," ).append("\n"); 
		query.append("       'S'," ).append("\n"); 
		query.append("       1," ).append("\n"); 
		query.append("       1," ).append("\n"); 
		query.append("       1 PRC_RT_SEQ, " ).append("\n"); 
		query.append("       C.RAT_AS_QTY OP_CNTR_QTY," ).append("\n"); 
		query.append("       C.CHG_CD," ).append("\n"); 
		query.append("       C.CURR_CD," ).append("\n"); 
		query.append("       C.CHG_UT_AMT," ).append("\n"); 
		query.append("       C.RAT_AS_QTY," ).append("\n"); 
		query.append("       C.CHG_AMT," ).append("\n"); 
		query.append("       C.RAT_UT_CD," ).append("\n"); 
		query.append("       NULL POR_MTCH_FLG," ).append("\n"); 
		query.append("       NULL DEL_MTCH_FLG," ).append("\n"); 
		query.append("       NULL TRI_PROP_NO," ).append("\n"); 
		query.append("       'N' FRT_INCL_XCLD_DIV_CD," ).append("\n"); 
		query.append("       NULL UT_NOTE_CONV_TP_CD, " ).append("\n"); 
		query.append("       'HOMPAGE' CRE_USR_ID," ).append("\n"); 
		query.append("       SYSDATE CRE_DT," ).append("\n"); 
		query.append("       'HOMPAGE' UPD_USR_ID," ).append("\n"); 
		query.append("       SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM BKG_RATE R, BKG_CHG_RT C" ).append("\n"); 
		query.append("WHERE R.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CHG_CD IN ( 'OFT', 'OAR','DAR')" ).append("\n"); 

	}
}