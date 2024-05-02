/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchMonthlyClearanceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.10
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.08.10 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchMonthlyClearanceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchMonthlyClearanceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchMonthlyClearanceListRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("        A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append(",       DENSE_RANK() OVER (ORDER BY ORD)||'. '||T.JO_STL_ITM_NM JO_STL_ITM_CD_NM" ).append("\n"); 
		query.append(",       A1.RLANE_CD" ).append("\n"); 
		query.append(",       A1.LOCL_CURR_CD" ).append("\n"); 
		query.append(",       A1.R_VVD" ).append("\n"); 
		query.append(",       SUM(A1.R_BSA_QTY)R_BSA_QTY" ).append("\n"); 
		query.append(",       A1.R_BSA_SLT_PRC" ).append("\n"); 
		query.append(",       SUM(A1.R_STL_LOCL_AMT)R_STL_LOCL_AMT" ).append("\n"); 
		query.append(",       A1.E_VVD" ).append("\n"); 
		query.append(",       SUM(A1.E_BSA_QTY)E_BSA_QTY" ).append("\n"); 
		query.append(",       A1.E_BSA_SLT_PRC" ).append("\n"); 
		query.append(",       SUM(A1.E_STL_LOCL_AMT)E_STL_LOCL_AMT" ).append("\n"); 
		query.append(",       MAX((" ).append("\n"); 
		query.append("        SELECT 'DUP' || '/' || DTL.ACCT_YRMON || '/' || DTL.STL_CMB_SEQ" ).append("\n"); 
		query.append("          FROM JOO_SETTLEMENT STL" ).append("\n"); 
		query.append("             , JOO_STL_CMB_DTL DTL" ).append("\n"); 
		query.append("             , JOO_STL_CMB CMB" ).append("\n"); 
		query.append("             , JOO_CSR CSR" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND A1.TRD_CD = STL.TRD_CD" ).append("\n"); 
		query.append("           AND A1.RLANE_CD = STL.RLANE_CD" ).append("\n"); 
		query.append("           AND A1.JO_CRR_CD = STL.JO_CRR_CD" ).append("\n"); 
		query.append("           AND A1.RE_DIVR_CD = STL.RE_DIVR_CD" ).append("\n"); 
		query.append("           AND A1.JO_STL_ITM_CD = STL.JO_STL_ITM_CD" ).append("\n"); 
		query.append("           AND A1.VSL_CD = STL.VSL_CD" ).append("\n"); 
		query.append("           AND A1.SKD_VOY_NO = STL.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A1.SKD_DIR_CD = STL.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND STL.ACCT_YRMON = DTL.ACCT_YRMON" ).append("\n"); 
		query.append("           AND STL.STL_VVD_SEQ = DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("           AND STL.STL_SEQ = DTL.STL_SEQ" ).append("\n"); 
		query.append("           AND DTL.ACCT_YRMON = CMB.ACCT_YRMON" ).append("\n"); 
		query.append("           AND DTL.JO_CRR_CD = CMB.JO_CRR_CD" ).append("\n"); 
		query.append("           AND DTL.STL_CMB_SEQ = CMB.STL_CMB_SEQ" ).append("\n"); 
		query.append("           AND DTL.RE_DIVR_CD = CMB.RE_DIVR_CD" ).append("\n"); 
		query.append("           AND CMB.SLP_TP_CD = CSR.SLP_TP_CD" ).append("\n"); 
		query.append("           AND CMB.SLP_FUNC_CD = CSR.SLP_FUNC_CD" ).append("\n"); 
		query.append("           AND CMB.SLP_OFC_CD = CSR.SLP_OFC_CD" ).append("\n"); 
		query.append("           AND CMB.SLP_ISS_DT = CSR.SLP_ISS_DT" ).append("\n"); 
		query.append("           AND CMB.SLP_SER_NO = CSR.SLP_SER_NO" ).append("\n"); 
		query.append("           AND CSR.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("           AND CSR.CXL_FLG = 'N'" ).append("\n"); 
		query.append("           AND CMB.ACCT_YRMON  BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[acct_yrmon],'-',''),'YYYYMM'),-24),'YYYYMM') AND REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("           AND DTL.ACCT_YRMON || DTL.JO_CRR_CD || DTL.STL_CMB_SEQ != REPLACE(@[acct_yrmon],'-','') || @[jo_crr_cd] || @[stl_cmb_seq]" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("        )) REMARK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("/**/                  SELECT     A.JO_STL_ITM_CD, A.JO_CRR_CD" ).append("\n"); 
		query.append("/**/        ,                  A.RLANE_CD" ).append("\n"); 
		query.append("/**/        ,                  A.LOCL_CURR_CD" ).append("\n"); 
		query.append("/**/        ,                  A.RE_DIVR_CD" ).append("\n"); 
		query.append("            ,                  A.TRD_CD" ).append("\n"); 
		query.append("            ,                  A.VSL_CD" ).append("\n"); 
		query.append("            ,                  A.SKD_VOY_NO" ).append("\n"); 
		query.append("            ,                  A.SKD_DIR_CD" ).append("\n"); 
		query.append("/*                            REVENUE   ↓↓↓  */" ).append("\n"); 
		query.append("/**/        ,                  DECODE(A.RE_DIVR_CD,'R',A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD,'') AS R_VVD" ).append("\n"); 
		query.append("/**/        ,                  CASE   WHEN  A.RE_DIVR_CD  = 'R' " ).append("\n"); 
		query.append("/**/                                  THEN " ).append("\n"); 
		query.append("/**/                                        CASE   WHEN  A.STL_ADJ_FLG = 'N' OR A.STL_ADJ_FLG IS NULL" ).append("\n"); 
		query.append("/**/                                               THEN" ).append("\n"); 
		query.append("/**/                                                     CASE   WHEN   A.JO_STL_ITM_CD='R/F' AND A.JO_MNU_NM = 'R/F' /*R/F이외는 BSA_QTY         */" ).append("\n"); 
		query.append("/**/                                                            THEN   A.USD_SLT_BSA_QTY      /*R/F는     USD_SLT_BSA_QTY */" ).append("\n"); 
		query.append("/**/                                                            ELSE   A.BSA_QTY" ).append("\n"); 
		query.append("/**/                                                     END" ).append("\n"); 
		query.append("/**/                                               ELSE  B.BSA_QTY" ).append("\n"); 
		query.append("/**/                                        END" ).append("\n"); 
		query.append("/**/                            END    R_BSA_QTY" ).append("\n"); 
		query.append("/**/        ,                  CASE   WHEN  A.RE_DIVR_CD  = 'R' " ).append("\n"); 
		query.append("/**/                                  THEN " ).append("\n"); 
		query.append("/**/                                        CASE   WHEN  A.STL_ADJ_FLG = 'N' OR A.STL_ADJ_FLG IS NULL" ).append("\n"); 
		query.append("/**/                                               THEN" ).append("\n"); 
		query.append("/**/                                                     CASE   WHEN   A.JO_STL_ITM_CD='R/F' AND A.JO_MNU_NM = 'R/F'/*R/F이외는 BSA_SLT_PRC         */" ).append("\n"); 
		query.append("/**/                                                            THEN   A.RF_SCG_PRC         /*R/F는      RF_SCG_PRC */" ).append("\n"); 
		query.append("/**/                                                            ELSE   A.BSA_SLT_PRC" ).append("\n"); 
		query.append("/**/                                                     END" ).append("\n"); 
		query.append("/**/                                               ELSE  B.BSA_SLT_PRC" ).append("\n"); 
		query.append("/**/                                        END" ).append("\n"); 
		query.append("/**/                            END   R_BSA_SLT_PRC" ).append("\n"); 
		query.append("/**/        ,                  DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT))  AS R_STL_LOCL_AMT" ).append("\n"); 
		query.append("/*                          REVENUE   ↓↓↓  */" ).append("\n"); 
		query.append("/**/        ,                   DECODE(A.RE_DIVR_CD,'E',A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD,'') AS E_VVD" ).append("\n"); 
		query.append("/**/        ,                  CASE   WHEN  A.RE_DIVR_CD  = 'E' " ).append("\n"); 
		query.append("/**/                                  THEN " ).append("\n"); 
		query.append("/**/                                        CASE   WHEN  A.STL_ADJ_FLG = 'N' OR A.STL_ADJ_FLG IS NULL" ).append("\n"); 
		query.append("/**/                                               THEN" ).append("\n"); 
		query.append("/**/                                                     CASE   WHEN   A.JO_STL_ITM_CD='R/F'  AND A.JO_MNU_NM = 'R/F'/*R/F이외는 BSA_QTY         */" ).append("\n"); 
		query.append("/**/                                                            THEN   A.USD_SLT_BSA_QTY      /*R/F는     USD_SLT_BSA_QTY */" ).append("\n"); 
		query.append("/**/                                                            ELSE   A.BSA_QTY" ).append("\n"); 
		query.append("/**/                                                     END" ).append("\n"); 
		query.append("/**/                                               ELSE  B.BSA_QTY" ).append("\n"); 
		query.append("/**/                                        END" ).append("\n"); 
		query.append("/**/                            END   E_BSA_QTY" ).append("\n"); 
		query.append("/**/        ,                  CASE   WHEN  A.RE_DIVR_CD  = 'E' " ).append("\n"); 
		query.append("/**/                                  THEN " ).append("\n"); 
		query.append("/**/                                        CASE   WHEN  A.STL_ADJ_FLG = 'N' OR A.STL_ADJ_FLG IS NULL" ).append("\n"); 
		query.append("/**/                                               THEN" ).append("\n"); 
		query.append("/**/                                                     CASE   WHEN   A.JO_STL_ITM_CD='R/F' AND A.JO_MNU_NM = 'R/F' /*R/F이외는 BSA_SLT_PRC         */" ).append("\n"); 
		query.append("/**/                                                            THEN   A.RF_SCG_PRC         /*R/F는      RF_SCG_PRC */" ).append("\n"); 
		query.append("/**/                                                            ELSE   A.BSA_SLT_PRC" ).append("\n"); 
		query.append("/**/                                                     END" ).append("\n"); 
		query.append("/**/                                               ELSE  B.BSA_SLT_PRC" ).append("\n"); 
		query.append("/**/                                        END" ).append("\n"); 
		query.append("/**/                            END   E_BSA_SLT_PRC" ).append("\n"); 
		query.append("/**/        ,                   DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT) ) AS E_STL_LOCL_AMT" ).append("\n"); 
		query.append("/**/               FROM    JOO_SETTLEMENT A, JOO_STL_DTL B, JOO_CRR_AUTH    Z" ).append("\n"); 
		query.append("/**/              WHERE   A.ACCT_YRMON   =    B.ACCT_YRMON(+)" ).append("\n"); 
		query.append("/**/                AND   A.STL_VVD_SEQ  =    B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("/**/                AND   A.STL_SEQ      =    B.STL_SEQ(+)" ).append("\n"); 
		query.append("                    AND   A.JO_CRR_CD    =    Z.JO_CRR_CD" ).append("\n"); 
		query.append("                    AND   A.RLANE_CD     =    Z.RLANE_CD" ).append("\n"); 
		query.append("                    AND   Z.AUTH_OFC_CD  =    @[ofc_cd]" ).append("\n"); 
		query.append("                    AND   Z.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("                    AND   Z.JO_CRR_AUTH_CD     = 'W'" ).append("\n"); 
		query.append("/**/                AND   A.ACCT_YRMON   = REPLACE(@[acct_yrmon],'-') AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("/**/	        #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("/**/            AND   A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("	        #if (${stl_cmb_seq} != '')" ).append("\n"); 
		query.append("/**/            AND   (A.ACCT_YRMON, A.STL_VVD_SEQ, A.STL_SEQ) IN (" ).append("\n"); 
		query.append("/**/                                                                SELECT   CMB.ACCT_YRMON, CMB.STL_VVD_SEQ, CMB.STL_SEQ" ).append("\n"); 
		query.append("/**/                                                                 FROM   JOO_STL_CMB_DTL CMB" ).append("\n"); 
		query.append("/**/                                                                 WHERE   CMB.ACCT_YRMON  =   REPLACE(@[acct_yrmon],'-')" ).append("\n"); 
		query.append("/**/                                                                   AND   CMB.JO_CRR_CD   =   @[jo_crr_cd]" ).append("\n"); 
		query.append("/**/                                                                   AND   CMB.STL_CMB_SEQ =   @[stl_cmb_seq]" ).append("\n"); 
		query.append("/**/                                                              )" ).append("\n"); 
		query.append("/**/           AND    A.CMB_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("/**/           AND    NVL(A.CMB_CFM_FLG,'N') = 'N'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("/**/     )A1," ).append("\n"); 
		query.append("/**/     (SELECT     K.ORD,I.* " ).append("\n"); 
		query.append("/**/        FROM     JOO_STL_ITM I," ).append("\n"); 
		query.append("/**/                 (SELECT 1 ORD,'S/H' JO_STL_ITM_CD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("/**/                  SELECT 2 ORD,'OUS' JO_STL_ITM_CD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("/**/                  SELECT 3 ORD,'R/F' JO_STL_ITM_CD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("/**/                  SELECT 4 ORD,'OTH' JO_STL_ITM_CD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("/**/                  SELECT 5 ORD,'W/R' JO_STL_ITM_CD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("/**/                  SELECT 6 ORD,'P/B' JO_STL_ITM_CD FROM DUAL ) K                   " ).append("\n"); 
		query.append("/**/       WHERE     I.JO_STL_ITM_CD = K.JO_STL_ITM_CD " ).append("\n"); 
		query.append("/**/       )T    " ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("/**/      T.JO_STL_ITM_CD = A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("        A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append(",       A1.RLANE_CD" ).append("\n"); 
		query.append(",       A1.LOCL_CURR_CD" ).append("\n"); 
		query.append(",       A1.R_VVD" ).append("\n"); 
		query.append(",       A1.R_BSA_SLT_PRC" ).append("\n"); 
		query.append(",       A1.E_VVD" ).append("\n"); 
		query.append(",       A1.E_BSA_SLT_PRC" ).append("\n"); 
		query.append(",       T.ORD" ).append("\n"); 
		query.append(",       T.JO_STL_ITM_NM" ).append("\n"); 
		query.append("HAVING  (SUM(A1.R_STL_LOCL_AMT) != 0 OR SUM(A1.E_STL_LOCL_AMT) != 0)" ).append("\n"); 
		query.append("ORDER   BY  T.ORD,T.JO_STL_ITM_NM," ).append("\n"); 
		query.append("            A1.RLANE_CD," ).append("\n"); 
		query.append("            A1.R_VVD,A1.E_VVD" ).append("\n"); 

	}
}