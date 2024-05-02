/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchMGSLeaseInvoiceVerifyDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOsearchMGSLeaseInvoiceVerifyDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091215 1030 MGS 추가사항.
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchMGSLeaseInvoiceVerifyDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchMGSLeaseInvoiceVerifyDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("/*+  USE_NL( A B D)   */" ).append("\n"); 
		query.append(" A.EQ_KND_CD" ).append("\n"); 
		query.append("    ,A.COST_YRMON" ).append("\n"); 
		query.append(",A.EQ_NO" ).append("\n"); 
		query.append("    ,A.CHG_CRE_SEQ" ).append("\n"); 
		query.append("    ,A.INV_CUST_EQ_NO" ).append("\n"); 
		query.append("    ,A.INV_EQ_NO" ).append("\n"); 
		query.append("    ,A.INV_REF_NO" ).append("\n"); 
		query.append("    ,A.INV_NO" ).append("\n"); 
		query.append("	,A.INV_CHG_TP_NM" ).append("\n"); 
		query.append("    ,A.CHG_CD" ).append("\n"); 
		query.append("    ,A.INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append("    ,A.INV_EQ_ONH_DT" ).append("\n"); 
		query.append("    ,A.INV_BIL_ST_DT" ).append("\n"); 
		query.append("    ,A.INV_EQ_OFFH_LOC_NM" ).append("\n"); 
		query.append("    ,A.INV_EQ_OFFH_DT" ).append("\n"); 
		query.append("    ,A.INV_BIL_END_DT" ).append("\n"); 
		query.append("    ,A.INV_LSE_USE_DYS" ).append("\n"); 
		query.append("    ,A.INV_LSE_RT_AMT" ).append("\n"); 
		query.append("    ,A.INV_LSE_CHG_AMT" ).append("\n"); 
		query.append("    ,A.INV_TAX_AMT" ).append("\n"); 
		query.append("    ,A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    ,A.AGMT_SEQ" ).append("\n"); 
		query.append("    ,A.AGMT_VER_NO" ).append("\n"); 
		query.append("    ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("    ,A.COST_CD" ).append("\n"); 
		query.append("    ,A.ACCT_CD     " ).append("\n"); 
		query.append("	,A.CURR_CD " ).append("\n"); 
		query.append(",CASE WHEN A.CHG_CD NOT IN ('CRD') AND  -- CRD 일때 EQ Dup 체크 제외. CRD 일때 EQ_NO 는 Seq하게 생성되므로 관계없음. " ).append("\n"); 
		query.append("           A.EQ_NO = LAG(A.EQ_NO) OVER (PARTITION BY  A.EQ_NO, A.CHG_CD, A.INV_LSE_RT_AMT ORDER BY A.EQ_NO )  THEN 'Equipment No. Duplicated!'" ).append("\n"); 
		query.append("      ELSE A.VRFY_RSLT_DESC" ).append("\n"); 
		query.append(" END AS VRFY_RSLT_DESC" ).append("\n"); 
		query.append(",CASE WHEN A.CHG_CD NOT IN ('CRD') AND  -- CRD 일때 EQ Dup 체크 제외. CRD 일때 EQ_NO 는 Seq하게 생성되므로 관계없음." ).append("\n"); 
		query.append("           A.EQ_NO = LAG(A.EQ_NO) OVER (PARTITION BY  A.EQ_NO, A.CHG_CD, A.INV_LSE_RT_AMT ORDER BY A.EQ_NO )  THEN 'N'" ).append("\n"); 
		query.append("      ELSE A.VRFY_SCS_FLG" ).append("\n"); 
		query.append(" END AS VRFY_SCS_FLG" ).append("\n"); 
		query.append(",A.INV_SEQ" ).append("\n"); 
		query.append(", CASE " ).append("\n"); 
		query.append("    WHEN B.EQ_NO  IS NOT NULL THEN  " ).append("\n"); 
		query.append("        CASE WHEN B.LSE_CHG_AMT = A.INV_LSE_CHG_AMT THEN 'C'" ).append("\n"); 
		query.append("             ELSE 'D'" ).append("\n"); 
		query.append("        END   --CHG_AMT 같으면 C , 다르면 D" ).append("\n"); 
		query.append("    ELSE  -- RATE 도 다르고.." ).append("\n"); 
		query.append("    'I'        -- 대응 CHG_SEQ 없으면 I" ).append("\n"); 
		query.append("  END LSE_CHG_AUD_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CASE " ).append("\n"); 
		query.append("  WHEN B.EQ_NO IS NULL THEN NVL(  (    CASE " ).append("\n"); 
		query.append("                                       WHEN D.EQ_ASET_STS_CD = 'LSO' THEN 'P'" ).append("\n"); 
		query.append("                    WHEN D.EQ_ASET_STS_CD = 'LST' THEN 'Q'" ).append("\n"); 
		query.append("                    WHEN D.EQ_ASET_STS_CD = 'TLL' THEN 'R'" ).append("\n"); 
		query.append("                                       ELSE 'I' " ).append("\n"); 
		query.append("                                       END ) , 'O') " ).append("\n"); 
		query.append("  WHEN B.LSE_CHG_AMT <> REPLACE(REPLACE(A.INV_LSE_CHG_AMT,' ',''),',','') THEN" ).append("\n"); 
		query.append("       CASE " ).append("\n"); 
		query.append("       WHEN B.LSE_USE_DYS <> REPLACE(REPLACE(A.INV_LSE_USE_DYS,' ',''),',','') AND B.LSE_RT_AMT  <> REPLACE(REPLACE(A.INV_LSE_RT_AMT,' ',''),',','') THEN 'E'" ).append("\n"); 
		query.append("       WHEN B.LSE_RT_AMT  <> REPLACE(REPLACE(A.INV_LSE_RT_AMT,' ',''),',','') THEN 'F'" ).append("\n"); 
		query.append("       WHEN B.LSE_USE_DYS <> REPLACE(REPLACE(A.INV_LSE_USE_DYS,' ',''),',','') THEN 'G'" ).append("\n"); 
		query.append("       ELSE 'D' " ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("  END AS LSE_CHG_AUD_RSLT_RSN_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    EQ_KND_CD" ).append("\n"); 
		query.append("    ,COST_YRMON" ).append("\n"); 
		query.append("    ,CHG_CRE_SEQ" ).append("\n"); 
		query.append("    ,INV_CUST_EQ_NO" ).append("\n"); 
		query.append("    ,INV_EQ_NO" ).append("\n"); 
		query.append("    ,INV_REF_NO" ).append("\n"); 
		query.append("    ,INV_NO" ).append("\n"); 
		query.append("    ,INV_CHG_TP_NM" ).append("\n"); 
		query.append("    ,CHG_CD" ).append("\n"); 
		query.append("    ,INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append("    ,INV_EQ_ONH_DT" ).append("\n"); 
		query.append("    ,INV_BIL_ST_DT" ).append("\n"); 
		query.append("    ,INV_EQ_OFFH_LOC_NM" ).append("\n"); 
		query.append("    ,INV_EQ_OFFH_DT" ).append("\n"); 
		query.append("    ,INV_BIL_END_DT" ).append("\n"); 
		query.append("    ,INV_LSE_USE_DYS" ).append("\n"); 
		query.append("    ,INV_LSE_RT_AMT" ).append("\n"); 
		query.append("    ,INV_LSE_CHG_AMT" ).append("\n"); 
		query.append("    ,INV_TAX_AMT" ).append("\n"); 
		query.append("    ,VRFY_RSLT_DESC" ).append("\n"); 
		query.append("    ,VRFY_SCS_FLG" ).append("\n"); 
		query.append("    ,AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    ,AGMT_SEQ" ).append("\n"); 
		query.append("    ,AGMT_VER_NO" ).append("\n"); 
		query.append("    ,AGMT_LSTM_CD" ).append("\n"); 
		query.append("    ,COST_CD" ).append("\n"); 
		query.append("    ,ACCT_CD" ).append("\n"); 
		query.append("    ,EQ_NO" ).append("\n"); 
		query.append("    ,CURR_CD" ).append("\n"); 
		query.append("    ,ROW_NUMBER() OVER (PARTITION BY A.AGMT_OFC_CTY_CD,A.AGMT_SEQ,A.AGMT_VER_NO,A.COST_YRMON,A.EQ_NO,CHG_CD ORDER BY INV_BIL_ST_DT,INV_LSE_RT_AMT) INV_SEQ" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("    A.EQ_KND_CD" ).append("\n"); 
		query.append("    ,A.COST_YRMON" ).append("\n"); 
		query.append("    ,A.CHG_CRE_SEQ" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,A.INV_CUST_EQ_NO" ).append("\n"); 
		query.append("    ,A.INV_EQ_NO" ).append("\n"); 
		query.append("    ,A.INV_REF_NO" ).append("\n"); 
		query.append("    ,A.INV_NO" ).append("\n"); 
		query.append("	,A.INV_CHG_TP_NM" ).append("\n"); 
		query.append("    ,A.CHG_CD" ).append("\n"); 
		query.append("    ,A.INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append("    ,TO_CHAR(A.INV_EQ_ONH_DT,'YYYY-MM-DD') AS INV_EQ_ONH_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(A.INV_BIL_ST_DT,'YYYY-MM-DD') AS INV_BIL_ST_DT" ).append("\n"); 
		query.append("    ,A.INV_EQ_OFFH_LOC_NM" ).append("\n"); 
		query.append("    ,TO_CHAR(A.INV_EQ_OFFH_DT,'YYYY-MM-DD') AS INV_EQ_OFFH_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(A.INV_BIL_END_DT,'YYYY-MM-DD') AS INV_BIL_END_DT" ).append("\n"); 
		query.append("    ,A.INV_LSE_USE_DYS" ).append("\n"); 
		query.append("    ,A.INV_LSE_RT_AMT" ).append("\n"); 
		query.append("    ,A.INV_LSE_CHG_AMT" ).append("\n"); 
		query.append("    ,A.INV_TAX_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,NVL( CASE " ).append("\n"); 
		query.append("          WHEN  LENGTH( TO_CHAR(INV_EQ_ONH_DT  ,'YYYYMMDD' ) ) <>8  THEN  'Please check up the On-Hire Date!'" ).append("\n"); 
		query.append("          WHEN  LENGTH( TO_CHAR(INV_EQ_OFFH_DT ,'YYYYMMDD' ) ) <>8  THEN  'Please check up the Off-Hire Date!'" ).append("\n"); 
		query.append("          WHEN  LENGTH( TO_CHAR(INV_BIL_ST_DT  ,'YYYYMMDD' ) ) <>8  THEN  'Please check up the Billing Start Date!'" ).append("\n"); 
		query.append("          WHEN  LENGTH( TO_CHAR(INV_BIL_END_DT ,'YYYYMMDD' ) ) <>8  THEN  'Please check up the Billing End Date!'" ).append("\n"); 
		query.append("          WHEN  SUBSTR(INV_CHG_TP_NM,1,3) IN ('HON','DON') AND LENGTH( TO_CHAR(INV_EQ_ONH_DT,'YYYYMMDD' ) ) <> 8 THEN  'Please check up the On-Hire Date!'" ).append("\n"); 
		query.append("          WHEN  INV_CHG_TP_NM IN ('HOF','DOF') AND LENGTH( TO_CHAR(INV_EQ_OFFH_DT,'YYYYMMDD' ) ) <> 8 THEN  'Please check up the Off-Hire Date!'" ).append("\n"); 
		query.append("          WHEN  G.AGMT_OFC_CTY_CD IS NULL THEN     'Please check up the Reference No!(AGMT NO Does Not Matching or Invalid Agreement No)'" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("              CASE " ).append("\n"); 
		query.append("			  WHEN SUBSTR(INV_CHG_TP_NM,1,3) NOT IN ('X S', 'X V', 'X W', 'XSE', 'XVI', 'XWA', 'CRD','TAX') THEN" ).append("\n"); 
		query.append("                          CASE " ).append("\n"); 
		query.append("                          WHEN D.EQ_NO IS NULL AND E.EQ_NO IS NULL AND F.EQ_NO IS NULL AND D2.EQ_NO IS NULL AND D3.EQ_NO IS NULL THEN	'M.G.Set No does not exist!'" ).append("\n"); 
		query.append("                          WHEN A.INV_EQ_NO IS NULL AND A.INV_CUST_EQ_NO IS NOT NULL AND E.EQ_NO IS NULL AND F.EQ_NO IS NULL THEN  'Lessor M.G.Set No does not exist!'" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("              END" ).append("\n"); 
		query.append("          END ,'OK') VRFY_RSLT_DESC" ).append("\n"); 
		query.append("    ,DECODE(NVL( CASE " ).append("\n"); 
		query.append("          WHEN  LENGTH( TO_CHAR(INV_EQ_ONH_DT  ,'YYYYMMDD' ) ) <>8  THEN  'Please check up the On-Hire Date!'" ).append("\n"); 
		query.append("          WHEN  LENGTH( TO_CHAR(INV_EQ_OFFH_DT ,'YYYYMMDD' ) ) <>8  THEN  'Please check up the Off-Hire Date!'" ).append("\n"); 
		query.append("          WHEN  LENGTH( TO_CHAR(INV_BIL_ST_DT  ,'YYYYMMDD' ) ) <>8  THEN  'Please check up the Billing Start Date!'" ).append("\n"); 
		query.append("          WHEN  LENGTH( TO_CHAR(INV_BIL_END_DT ,'YYYYMMDD' ) ) <>8  THEN  'Please check up the Billing End Date!'" ).append("\n"); 
		query.append("          WHEN  SUBSTR(INV_CHG_TP_NM,1,3) IN ('HON','DON') AND LENGTH( TO_CHAR(INV_EQ_ONH_DT,'YYYYMMDD' ) ) <> 8 THEN  'Please check up the On-Hire Date!'" ).append("\n"); 
		query.append("          WHEN  INV_CHG_TP_NM IN ('HOF','DOF') AND LENGTH( TO_CHAR(INV_EQ_OFFH_DT,'YYYYMMDD' ) ) <> 8 THEN  'Please check up the Off-Hire Date!'" ).append("\n"); 
		query.append("          WHEN  G.AGMT_OFC_CTY_CD IS NULL THEN     'Please check up the Reference No!(AGMT NO Does Not Matching or Invalid Agreement No)'" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("              CASE " ).append("\n"); 
		query.append("			  WHEN SUBSTR(INV_CHG_TP_NM,1,3) NOT IN ('X S', 'X V', 'X W', 'XSE', 'XVI', 'XWA', 'CRD','TAX') THEN" ).append("\n"); 
		query.append("                          CASE " ).append("\n"); 
		query.append("                          WHEN D.EQ_NO IS NULL AND E.EQ_NO IS NULL AND F.EQ_NO IS NULL  AND D2.EQ_NO IS NULL AND D3.EQ_NO IS NULL THEN	'M.G.Set No does not exist!'" ).append("\n"); 
		query.append("                          WHEN A.INV_EQ_NO IS NULL AND A.INV_CUST_EQ_NO IS NOT NULL AND E.EQ_NO IS NULL AND F.EQ_NO IS NULL THEN  'Lessor M.G.Set No does not exist!'" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("              END" ).append("\n"); 
		query.append("          END ,'OK'),'OK','Y','N') AS VRFY_SCS_FLG" ).append("\n"); 
		query.append("    ,B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    ,B.AGMT_SEQ" ).append("\n"); 
		query.append("    ,C.AGMT_VER_NO" ).append("\n"); 
		query.append("    ,C.AGMT_LSTM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , CASE " ).append("\n"); 
		query.append("      WHEN A.CHG_CD = 'PDM' THEN" ).append("\n"); 
		query.append("           CASE " ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'ST' THEN 'EQCGST'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LT' THEN 'EQCGLT'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LP' THEN 'EQCGLP' " ).append("\n"); 
		query.append("           ELSE 'EQCGST'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("      WHEN A.CHG_CD = 'WDP' THEN" ).append("\n"); 
		query.append("           CASE " ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'ST' THEN 'EQCGST'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LT' THEN 'EQCGLT'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LP' THEN 'EQCGLP' " ).append("\n"); 
		query.append("           ELSE 'EQCGST'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("      WHEN A.CHG_CD = 'DOC' THEN" ).append("\n"); 
		query.append("           CASE " ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'ST' THEN 'EQCGST'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LT' THEN 'EQCGLT'" ).append("\n"); 
		query.append("           ELSE 'EQCGST'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("      WHEN A.CHG_CD IN ('HON','DON') THEN 'EQCGLT'" ).append("\n"); 
		query.append("      WHEN A.CHG_CD IN ('HOF','DOF') THEN 'EQCGLT'" ).append("\n"); 
		query.append("      WHEN A.CHG_CD IN ('GTO','GTI') THEN 'EQCZSB'" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      ELSE " ).append("\n"); 
		query.append("           CASE " ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'ST' THEN 'EQXTXY'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LT' THEN 'EQXTXX'" ).append("\n"); 
		query.append("           ELSE 'EQXTXY'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("      END AS COST_CD" ).append("\n"); 
		query.append("    , CASE " ).append("\n"); 
		query.append("      WHEN A.CHG_CD = 'PDM' THEN" ).append("\n"); 
		query.append("           CASE " ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'ST' THEN '510842'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LT' THEN '510841'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LP' THEN '510843' " ).append("\n"); 
		query.append("           ELSE '510842'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("      WHEN A.CHG_CD = 'WDP' THEN" ).append("\n"); 
		query.append("           CASE " ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'ST' THEN '510842'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LT' THEN '510841'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LP' THEN '510843' " ).append("\n"); 
		query.append("           ELSE '510842'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("      WHEN A.CHG_CD = 'DOC' THEN" ).append("\n"); 
		query.append("           CASE " ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'ST' THEN '510844'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LT' THEN '510844'" ).append("\n"); 
		query.append("           ELSE '510844'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("      WHEN A.CHG_CD IN ('HON','DON') THEN '510845'" ).append("\n"); 
		query.append("      WHEN A.CHG_CD IN ('HOF','DOF') THEN '510845'" ).append("\n"); 
		query.append("      WHEN A.CHG_CD = 'GTO' THEN '510846'" ).append("\n"); 
		query.append("      WHEN A.CHG_CD = 'GTI' THEN '510847'" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("      ELSE " ).append("\n"); 
		query.append("           CASE " ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'ST' THEN '510848'" ).append("\n"); 
		query.append("           WHEN C.AGMT_LSTM_CD = 'LT' THEN '510848'" ).append("\n"); 
		query.append("           ELSE '510848'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("      END AS ACCT_CD      " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("            ,CASE WHEN A.CHG_CD IN ('X S', 'XSE') THEN 'SEA'||SUBSTR(A.COST_YRMON,3,4) || LPAD(RANK() OVER (PARTITION BY A.CHG_CD  ORDER BY ROWNUM ),3,0)" ).append("\n"); 
		query.append("            WHEN A.CHG_CD IN ('X V', 'XVI') THEN 'VIR'||SUBSTR(A.COST_YRMON,3,4)|| LPAD(RANK() OVER (PARTITION BY A.CHG_CD  ORDER BY ROWNUM ),3,0)" ).append("\n"); 
		query.append("            WHEN A.CHG_CD IN ('X W', 'XWA') THEN 'WAS'||SUBSTR(A.COST_YRMON,3,4)|| LPAD(RANK() OVER (PARTITION BY A.CHG_CD  ORDER BY ROWNUM ),3,0)" ).append("\n"); 
		query.append("            WHEN A.CHG_CD IN ('CRD')        THEN 'CRD'||SUBSTR(A.COST_YRMON,3,4)|| LPAD(RANK() OVER (PARTITION BY A.CHG_CD  ORDER BY ROWNUM ),3,0)" ).append("\n"); 
		query.append("        	WHEN A.CHG_CD IN ('TAX')        THEN 'TAX'||SUBSTR(A.COST_YRMON,3,4)|| LPAD(RANK() OVER (PARTITION BY A.CHG_CD  ORDER BY ROWNUM ),3,0)" ).append("\n"); 
		query.append("            ELSE NVL( D.EQ_NO, NVL(E.EQ_NO, NVL(F.EQ_NO,NVL(D2.EQ_NO,D3.EQ_NO))) )" ).append("\n"); 
		query.append("            END EQ_NO" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("    ,C.CURR_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    CGM_LSE_INV_TMP A " ).append("\n"); 
		query.append("    LEFT JOIN CGM_INV_REF_NO_RGST B ON (A.INV_REF_NO = B.INV_REF_NO)" ).append("\n"); 
		query.append("    LEFT JOIN CGM_AGREEMENT C ON (B.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD AND B.AGMT_SEQ = C.AGMT_SEQ AND C.LST_VER_FLG = 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    LEFT JOIN CGM_EQUIPMENT D ON (A.INV_EQ_NO = D.EQ_NO AND D.EQ_KND_CD= @[eq_knd_cd] AND C.AGMT_OFC_CTY_CD = D.AGMT_OFC_CTY_CD AND C.AGMT_SEQ = D.AGMT_SEQ AND C.AGMT_VER_NO = D.AGMT_VER_NO)      --EQ_NO JN" ).append("\n"); 
		query.append("	LEFT JOIN CGM_EQUIPMENT D2 ON (A.INV_EQ_NO = D2.CHSS_ALS_NO) --INV_EQ_NO, ALIAS1 JN" ).append("\n"); 
		query.append("	LEFT JOIN CGM_EQUIPMENT D3 ON (A.INV_EQ_NO = D3.N2ND_CHSS_ALS_NO) -- INV_EQ_NO, ALIAS2 JN" ).append("\n"); 
		query.append("    LEFT JOIN CGM_EQUIPMENT E ON (A.INV_CUST_EQ_NO = E.CHSS_ALS_NO)                         --CUST_EQ_NO ,ALIAS1 JN" ).append("\n"); 
		query.append("    LEFT JOIN CGM_EQUIPMENT F ON (A.INV_CUST_EQ_NO = F.N2ND_CHSS_ALS_NO)                    --CUST_EQ_NO ,ALIAS2 JN" ).append("\n"); 
		query.append("    LEFT JOIN CGM_LSE_CHG_HDR G ON ( " ).append("\n"); 
		query.append("			C.AGMT_OFC_CTY_CD = G.AGMT_OFC_CTY_CD " ).append("\n"); 
		query.append("			AND C.AGMT_SEQ = G.AGMT_SEQ  " ).append("\n"); 
		query.append("			AND C.AGMT_VER_NO = G.AGMT_VER_NO" ).append("\n"); 
		query.append("			AND G.COST_YRMON= A.COST_YRMON " ).append("\n"); 
		query.append("			AND G.CHG_CRE_SEQ = A.CHG_CRE_SEQ" ).append("\n"); 
		query.append("	)    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    A.CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")   A" ).append("\n"); 
		query.append(")   A" ).append("\n"); 
		query.append("    -- B 에서, CHG_SEQ 하나에 대해서만 체크하여 C,D / InvOnly 판별." ).append("\n"); 
		query.append("    LEFT JOIN CGM_LSE_CHG_DTL B ON (    A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD " ).append("\n"); 
		query.append("                                        AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("                                        AND A.AGMT_VER_NO = B.AGMT_VER_NO " ).append("\n"); 
		query.append("                                        AND A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("                                        AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("                                        AND A.CHG_CD = B.CHG_CD" ).append("\n"); 
		query.append("                                        AND A.INV_SEQ = B.CHG_SEQ  " ).append("\n"); 
		query.append("                                        AND B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("										AND B.LSE_CHG_AUD_STS_CD  <>  'I') " ).append("\n"); 
		query.append("    LEFT JOIN CGM_EQUIPMENT C   ON (    A.EQ_NO = C.EQ_NO )" ).append("\n"); 
		query.append("    LEFT JOIN CGM_EQ_STS_HIS D  ON (    C.EQ_NO = D.EQ_NO AND C.EQ_STS_SEQ =  D.EQ_STS_SEQ)" ).append("\n"); 

	}
}