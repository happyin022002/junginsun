/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOModifyORCOTHChargeRateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.17 
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

public class UnmatchBLDBDAOModifyORCOTHChargeRateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 SC에 대해 OTH <> ORC 상호 호환하여 심사할 수 있도록 Charge Code를 업데이트
	  * </pre>
	  */
	public UnmatchBLDBDAOModifyORCOTHChargeRateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOModifyORCOTHChargeRateUSQL").append("\n"); 
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
		query.append("      USING (SELECT T.OFT_CMB_SEQ," ).append("\n"); 
		query.append("                    T.CHG_CD," ).append("\n"); 
		query.append("                    T.CHG_RT_SEQ," ).append("\n"); 
		query.append("                    T.RAT_UT_CD," ).append("\n"); 
		query.append("                    T.CURR_CD," ).append("\n"); 
		query.append("                    T.CHG_UT_AMT," ).append("\n"); 
		query.append("                    T.RAT_AS_QTY," ).append("\n"); 
		query.append("                    T.CHG_AMT," ).append("\n"); 
		query.append("                    T.CGO_CATE_CD," ).append("\n"); 
		query.append("                    C.BKG_CHG_CD" ).append("\n"); 
		query.append("             FROM BKG_REV_AUD_CHG_TMP T," ).append("\n"); 
		query.append("                 (SELECT B.BKG_NO, C.CHG_CD BKG_CHG_CD, C.CURR_CD, C.CHG_UT_AMT, C.RAT_UT_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING B, BKG_RATE R, BKG_CHG_RT C" ).append("\n"); 
		query.append("                  WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND B.SC_NO IN (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                                  FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                  WHERE HRD_CDG_ID = 'ORC_OTH_CONV')" ).append("\n"); 
		query.append("                  AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                  AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                  AND C.CHG_CD IN ('OTH','ORC')" ).append("\n"); 
		query.append("                  AND 'N' = @[ca_flg]" ).append("\n"); 
		query.append("                  UNION ALL" ).append("\n"); 
		query.append("                  SELECT B.BKG_NO, C.CHG_CD BKG_CHG_CD, C.CURR_CD, C.CHG_UT_AMT, C.RAT_UT_CD" ).append("\n"); 
		query.append("                  FROM BKG_BKG_HIS B, BKG_RT_HIS R, BKG_CHG_RT_HIS C" ).append("\n"); 
		query.append("                  WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND B.SC_NO IN (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                                  FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                  WHERE HRD_CDG_ID = 'ORC_OTH_CONV')" ).append("\n"); 
		query.append("                  AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                  AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                  AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                  AND B.CORR_NO = R.CORR_NO" ).append("\n"); 
		query.append("                  AND B.CORR_NO = C.CORR_NO" ).append("\n"); 
		query.append("                  AND C.CHG_CD IN ('OTH','ORC')" ).append("\n"); 
		query.append("                  AND 'Y' = @[ca_flg]" ).append("\n"); 
		query.append("                  ) C" ).append("\n"); 
		query.append("             WHERE T.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("             AND T.CHG_CD IN ('OTH','ORC')" ).append("\n"); 
		query.append("             AND T.CHG_CD <> C.BKG_CHG_CD" ).append("\n"); 
		query.append("             AND T.CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("             AND T.CHG_UT_AMT = C.CHG_UT_AMT" ).append("\n"); 
		query.append("             AND T.RAT_UT_CD = C.RAT_UT_CD) OTH" ).append("\n"); 
		query.append("      ON (TMP.OFT_CMB_SEQ = OTH.OFT_CMB_SEQ)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET TMP.CHG_CD = OTH.BKG_CHG_CD" ).append("\n"); 
		query.append("    WHERE TMP.CHG_CD = OTH.CHG_CD" ).append("\n"); 
		query.append("    AND TMP.CHG_RT_SEQ = OTH.CHG_RT_SEQ" ).append("\n"); 
		query.append("    AND TMP.RAT_UT_CD = OTH.RAT_UT_CD" ).append("\n"); 
		query.append("    AND TMP.CURR_CD = OTH.CURR_CD" ).append("\n"); 
		query.append("    AND TMP.CHG_UT_AMT = OTH.CHG_UT_AMT" ).append("\n"); 
		query.append("    AND TMP.RAT_AS_QTY = OTH.RAT_AS_QTY" ).append("\n"); 
		query.append("    AND TMP.CHG_AMT = OTH.CHG_AMT" ).append("\n"); 
		query.append("    AND TMP.CGO_CATE_CD = OTH.CGO_CATE_CD" ).append("\n"); 

	}
}