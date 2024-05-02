/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOModifyDHFChargeRateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
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

public class UnmatchBLDBDAOModifyDHFChargeRateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * << DHF 예외로직 >>
	  * HKGSC, SZPSC의 BKG의 경우 CNY/HKD를 혼용하여 사용하고 있기 때문에
	  * 심사시 BKG과 Temp에 저장된 DHF의 Currency, Rate를 비교하고 
	  * Currency 가 다른 경우 Surcharge Table의 금액과 일치할 경우, 
	  * BKG 기준으로 Temp Table을 업데이트 한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOModifyDHFChargeRateUSQL(){
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
		query.append("FileName : UnmatchBLDBDAOModifyDHFChargeRateUSQL").append("\n"); 
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
		query.append("                    DECODE(C.BKG_CURR_CD,'CNY',CNY_CURR,HKD_CURR) CURR_CD," ).append("\n"); 
		query.append("                    DECODE(C.BKG_CURR_CD,'CNY',CNY_UT_AMT,HKD_UT_AMT) CHG_UT_AMT" ).append("\n"); 
		query.append("             FROM BKG_REV_AUD_CHG_TMP T," ).append("\n"); 
		query.append("                 (SELECT BKG_CURR_CD, BKG_UT_AMT," ).append("\n"); 
		query.append("                        'CNY' CNY_CURR, MAX(DECODE(CURR_CD,'CNY',SCG_AMT)) CNY_UT_AMT," ).append("\n"); 
		query.append("                        'HKD' HKD_CURR, MAX(DECODE(CURR_CD,'HKD',SCG_AMT)) HKD_UT_AMT" ).append("\n"); 
		query.append("                  FROM ( SELECT DECODE(LENGTH(POR_DEF_CD),0,0,1) ORD,  --- 요거 좀 조정해보면 좋을듯.." ).append("\n"); 
		query.append("                                P.CURR_CD, P.SCG_AMT, B.CURR_CD BKG_CURR_CD, B.CHG_UT_AMT BKG_UT_AMT" ).append("\n"); 
		query.append("                         FROM PRI_SCG_RT P," ).append("\n"); 
		query.append("                             (SELECT B.BKG_NO, B.SVC_SCP_CD, B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD, R.RT_APLY_DT, C.CURR_CD, C.CHG_UT_AMT" ).append("\n"); 
		query.append("                              FROM BKG_BOOKING B, BKG_RATE R, BKG_CHG_RT C" ).append("\n"); 
		query.append("                              WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                              AND B.BKG_OFC_CD IN ('SZPSC','HKGSC')" ).append("\n"); 
		query.append("                              AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                              AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                              AND C.CHG_CD = 'DHF'" ).append("\n"); 
		query.append("                              AND 'N' = @[ca_flg]" ).append("\n"); 
		query.append("                              UNION ALL" ).append("\n"); 
		query.append("                              SELECT B.BKG_NO, B.SVC_SCP_CD, B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD, R.RT_APLY_DT, C.CURR_CD, C.CHG_UT_AMT" ).append("\n"); 
		query.append("                              FROM BKG_BKG_HIS B, BKG_RT_HIS R, BKG_CHG_RT_HIS C" ).append("\n"); 
		query.append("                              WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                              AND B.BKG_OFC_CD IN ('SZPSC','HKGSC')" ).append("\n"); 
		query.append("                              AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                              AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                              AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                              AND B.CORR_NO = R.CORR_NO" ).append("\n"); 
		query.append("                              AND B.CORR_NO = C.CORR_NO" ).append("\n"); 
		query.append("                              AND C.CHG_CD = 'DHF'" ).append("\n"); 
		query.append("                              AND 'Y' = @[ca_flg]" ).append("\n"); 
		query.append("                              ) B" ).append("\n"); 
		query.append("                         WHERE P.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                         AND P.CHG_CD = 'DHF'" ).append("\n"); 
		query.append("                         AND B.RT_APLY_DT BETWEEN P.EFF_DT AND P.EXP_DT" ).append("\n"); 
		query.append("                         AND (P.POR_DEF_CD IN ('CN','CNS','CNHKG') OR P.POL_DEF_CD IN ('CN','CNS','CNHKG'))" ).append("\n"); 
		query.append("                         AND P.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                         AND P.WDR_FLG = 'N'" ).append("\n"); 
		query.append("                         ORDER BY P.CURR_CD)" ).append("\n"); 
		query.append("                  GROUP BY BKG_CURR_CD, BKG_UT_AMT) C" ).append("\n"); 
		query.append("             WHERE T.CHG_CD = 'DHF'" ).append("\n"); 
		query.append("             AND T.CURR_CD <> C.BKG_CURR_CD" ).append("\n"); 
		query.append("             AND((C.BKG_CURR_CD = C.CNY_CURR AND C.BKG_UT_AMT = C.CNY_UT_AMT)" ).append("\n"); 
		query.append("                OR " ).append("\n"); 
		query.append("                 (C.BKG_CURR_CD = C.HKD_CURR AND C.BKG_UT_AMT = C.HKD_UT_AMT))) DHF" ).append("\n"); 
		query.append("      ON (TMP.OFT_CMB_SEQ = DHF.OFT_CMB_SEQ " ).append("\n"); 
		query.append("        AND TMP.CHG_CD = DHF.CHG_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET TMP.CURR_CD = DHF.CURR_CD," ).append("\n"); 
		query.append("               TMP.CHG_UT_AMT = DHF.CHG_UT_AMT," ).append("\n"); 
		query.append("               TMP.CHG_AMT = DHF.CHG_UT_AMT * TMP.RAT_AS_QTY" ).append("\n"); 

	}
}