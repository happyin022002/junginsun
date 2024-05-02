/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UnmatchBLDBDAOModifyDDCChargeRateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.18 
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

public class UnmatchBLDBDAOModifyDDCChargeRateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG에 Rating된 DDC Charge와 Autorating된 DDC Charge의 Currency가 일치하지 않는 경우
	  * Unit Amount 일치시 DDC Charge에 대한 Local - USD 환산 요율표에 따라 Autorating 결과를 Update한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOModifyDDCChargeRateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOModifyDDCChargeRateUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_REV_AUD_CHG_TMP TMP" ).append("\n"); 
		query.append("      USING  ( SELECT  T.OFT_CMB_SEQ," ).append("\n"); 
		query.append("                        T.CHG_CD," ).append("\n"); 
		query.append("                        T.RAT_UT_CD," ).append("\n"); 
		query.append("                        T.CGO_CATE_CD," ).append("\n"); 
		query.append("                        DECODE(C.CURR_CD, 'USD', H.CURR_CD, H.LOCL_CURR_CD) CURR_CD," ).append("\n"); 
		query.append("                        DECODE(C.CURR_CD, 'USD', H.CHG_UT_AMT, H.LOCL_CHG_UT_AMT) CHG_UT_AMT" ).append("\n"); 
		query.append("                FROM BKG_REV_AUD_CHG_TMP T, BKG_BOOKING B, BKG_RATE R, BKG_CHG_RT C,BKG_REV_AUD_CHG_CONV H" ).append("\n"); 
		query.append("                WHERE T.CHG_CD = 'DDC'" ).append("\n"); 
		query.append("                AND T.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                AND T.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                AND T.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                AND C.CHG_CD = 'DDC'" ).append("\n"); 
		query.append("                AND C.RAT_UT_CD = T.RAT_UT_CD" ).append("\n"); 
		query.append("                AND C.CGO_CATE_CD = T.CGO_CATE_CD" ).append("\n"); 
		query.append("                AND C.CURR_CD <> T.CURR_CD" ).append("\n"); 
		query.append("                AND B.SVC_SCP_CD = H.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND R.RT_APLY_DT BETWEEN EFF_FM_DT AND EFF_TO_DT" ).append("\n"); 
		query.append("                AND H.CHG_CD = 'DDC'" ).append("\n"); 
		query.append("                AND B.DEL_CD LIKE H.DEL_CNT_CD||'%'" ).append("\n"); 
		query.append("                AND (SELECT CNTR_SZ_CD FROM PRI_RAT_UT WHERE RAT_UT_CD = T.RAT_UT_CD) = H.CNTR_SZ_CD" ).append("\n"); 
		query.append("                AND T.CGO_CATE_CD = H.CGO_CATE_CD" ).append("\n"); 
		query.append("                AND (" ).append("\n"); 
		query.append("                     (C.CURR_CD = H.CURR_CD AND C.CHG_UT_AMT = H.CHG_UT_AMT)" ).append("\n"); 
		query.append("                     OR" ).append("\n"); 
		query.append("                     (C.CURR_CD = H.LOCL_CURR_CD AND C.CHG_UT_AMT = H.LOCL_CHG_UT_AMT)" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("             ) DDC" ).append("\n"); 
		query.append("      ON (  TMP.OFT_CMB_SEQ = DDC.OFT_CMB_SEQ" ).append("\n"); 
		query.append("        AND TMP.CHG_CD = DDC.CHG_CD" ).append("\n"); 
		query.append("        AND TMP.RAT_UT_CD = DDC.RAT_UT_CD" ).append("\n"); 
		query.append("        AND TMP.CGO_CATE_CD = DDC.CGO_CATE_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("           TMP.CURR_CD = DDC.CURR_CD," ).append("\n"); 
		query.append("           TMP.CHG_UT_AMT = DDC.CHG_UT_AMT," ).append("\n"); 
		query.append("           TMP.CHG_AMT = DDC.CHG_UT_AMT * TMP.RAT_AS_QTY" ).append("\n"); 

	}
}