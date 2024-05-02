/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchSlotXchStatusListByFinancePartnerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.02.02 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchSlotXchStatusListByFinancePartnerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dsfsdf
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchSlotXchStatusListByFinancePartnerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchSlotXchStatusListByFinancePartnerRSQL").append("\n"); 
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
		query.append("WITH P AS (SELECT SUBSTR( @[acct_yrmon],1,4)||'01' ACCT_YRMON_FR ,REPLACE( @[acct_yrmon] , '-')ACCT_YRMON, @[re_divr_cd] RE_DIVR_CD    FROM DUAL)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("S.JO_CRR_CD" ).append("\n"); 
		query.append(",      SUM(S.CUR_STL_BSA_QTY  )CUR_STL_BSA_QTY" ).append("\n"); 
		query.append(",      SUM(S.STL_LOCL_AMT     )STL_LOCL_AMT" ).append("\n"); 
		query.append(",      SUM(S.TERM_STL_BSA_QTY )TERM_STL_BSA_QTY" ).append("\n"); 
		query.append(",      SUM(S.TERM_STL_LOCL_AMT)TERM_STL_LOCL_AMT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT   /*+  ORDERED  */" ).append("\n"); 
		query.append("A.JO_CRR_CD" ).append("\n"); 
		query.append(",SUM(CASE WHEN A.ACCT_YRMON=P.ACCT_YRMON" ).append("\n"); 
		query.append("THEN ( CASE WHEN A.STL_ADJ_FLG= 'Y'" ).append("\n"); 
		query.append("THEN B.BSA_QTY" ).append("\n"); 
		query.append("ELSE A.BSA_QTY END)" ).append("\n"); 
		query.append("ELSE 0 END" ).append("\n"); 
		query.append(")CUR_STL_BSA_QTY" ).append("\n"); 
		query.append(",SUM(CASE WHEN A.ACCT_YRMON=P.ACCT_YRMON" ).append("\n"); 
		query.append("THEN B.STL_LOCL_AMT" ).append("\n"); 
		query.append("ELSE 0 END" ).append("\n"); 
		query.append(")STL_LOCL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",SUM(CASE WHEN A.ACCT_YRMON BETWEEN P.ACCT_YRMON_FR AND P.ACCT_YRMON" ).append("\n"); 
		query.append("THEN ( CASE WHEN A.STL_ADJ_FLG= 'Y'" ).append("\n"); 
		query.append("THEN B.BSA_QTY" ).append("\n"); 
		query.append("ELSE A.BSA_QTY END)" ).append("\n"); 
		query.append("ELSE 0 END" ).append("\n"); 
		query.append(")TERM_STL_BSA_QTY" ).append("\n"); 
		query.append(",SUM(CASE WHEN A.ACCT_YRMON BETWEEN P.ACCT_YRMON_FR AND P.ACCT_YRMON" ).append("\n"); 
		query.append("THEN ( CASE WHEN A.STL_ADJ_FLG= 'Y'" ).append("\n"); 
		query.append("THEN B.STL_LOCL_AMT" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("0" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("ELSE 0 END" ).append("\n"); 
		query.append(")TERM_STL_LOCL_AMT" ).append("\n"); 
		query.append("FROM  JOO_SETTLEMENT A," ).append("\n"); 
		query.append("JOO_STL_DTL    B," ).append("\n"); 
		query.append("P, JOO_CRR_AUTH AUTH" ).append("\n"); 
		query.append("WHERE A.ACCT_YRMON    = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND   A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND   A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND   A.RE_DIVR_CD    = P.RE_DIVR_CD" ).append("\n"); 
		query.append("AND   A.JO_STL_ITM_CD = 'OUS'" ).append("\n"); 
		query.append("AND   A.JO_CRR_CD = AUTH.JO_CRR_CD" ).append("\n"); 
		query.append("AND   A.RLANE_CD  = AUTH.RLANE_CD" ).append("\n"); 
		query.append("AND   AUTH.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    AUTH.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   A.ACCT_YRMON   BETWEEN  P.ACCT_YRMON_FR  AND P.ACCT_YRMON AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("GROUP BY A.JO_CRR_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   /*+  ORDERED  */" ).append("\n"); 
		query.append("A.JO_CRR_CD" ).append("\n"); 
		query.append(",0 CUR_STL_BSA_QTY" ).append("\n"); 
		query.append(",0 STL_LOCL_AMT" ).append("\n"); 
		query.append(",0 TERM_STL_BSA_QTY" ).append("\n"); 
		query.append(",SUM(CASE WHEN A.ACCT_YRMON BETWEEN P.ACCT_YRMON_FR AND P.ACCT_YRMON" ).append("\n"); 
		query.append("THEN ( CASE WHEN A.STL_ADJ_FLG= 'Y'" ).append("\n"); 
		query.append("THEN 0" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NVL(SL1_06.CSR_LOCL_AMT , 0)" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("ELSE 0 END" ).append("\n"); 
		query.append(")TERM_STL_LOCL_AMT" ).append("\n"); 
		query.append("FROM  JOO_SETTLEMENT A," ).append("\n"); 
		query.append("JOO_STL_DTL    B," ).append("\n"); 
		query.append("JOO_SLIP       SL1_06," ).append("\n"); 
		query.append("P, JOO_CRR_AUTH AUTH" ).append("\n"); 
		query.append("WHERE A.ACCT_YRMON    = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND   A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND   A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND   A.RE_DIVR_CD    = P.RE_DIVR_CD" ).append("\n"); 
		query.append("AND   A.JO_CRR_CD = AUTH.JO_CRR_CD" ).append("\n"); 
		query.append("AND   A.RLANE_CD  = AUTH.RLANE_CD" ).append("\n"); 
		query.append("AND   AUTH.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    AUTH.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   A.JO_STL_ITM_CD = 'OUS'  AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("AND   A.ACCT_YRMON  = SL1_06.ACCT_YRMON(+)" ).append("\n"); 
		query.append("AND   A.STL_VVD_SEQ = SL1_06.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND   A.STL_SEQ     = SL1_06.STL_SEQ(+)" ).append("\n"); 
		query.append("AND   SL1_06.SLP_TP_CD(+) = '06' --18수입, 06비용" ).append("\n"); 
		query.append("AND   SL1_06.DR_CR_CD(+)  = 'DR'" ).append("\n"); 
		query.append("AND   A.ACCT_YRMON   BETWEEN  P.ACCT_YRMON_FR  AND P.ACCT_YRMON" ).append("\n"); 
		query.append("GROUP BY A.JO_CRR_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   /*+  ORDERED  */" ).append("\n"); 
		query.append("A.JO_CRR_CD" ).append("\n"); 
		query.append(",0 CUR_STL_BSA_QTY" ).append("\n"); 
		query.append(",SUM(CASE WHEN A.ACCT_YRMON=P.ACCT_YRMON" ).append("\n"); 
		query.append("THEN ( CASE WHEN A.STL_ADJ_FLG= 'Y'" ).append("\n"); 
		query.append("THEN 0" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NVL(SL1_18.CSR_LOCL_AMT , 0)" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("ELSE 0 END" ).append("\n"); 
		query.append(")STL_LOCL_AMT" ).append("\n"); 
		query.append(",0 TERM_STL_BSA_QTY" ).append("\n"); 
		query.append(",0 TERM_STL_LOCL_AMT" ).append("\n"); 
		query.append("FROM  JOO_SETTLEMENT A," ).append("\n"); 
		query.append("JOO_STL_DTL    B," ).append("\n"); 
		query.append("JOO_SLIP       SL1_18," ).append("\n"); 
		query.append("P, JOO_CRR_AUTH AUTH" ).append("\n"); 
		query.append("WHERE A.ACCT_YRMON    = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND   A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND   A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND   A.RE_DIVR_CD    = P.RE_DIVR_CD" ).append("\n"); 
		query.append("AND   A.JO_CRR_CD = AUTH.JO_CRR_CD" ).append("\n"); 
		query.append("AND   A.RLANE_CD  = AUTH.RLANE_CD" ).append("\n"); 
		query.append("AND   AUTH.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    AUTH.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   A.JO_STL_ITM_CD = 'OUS'  AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("AND   A.ACCT_YRMON  = SL1_18.ACCT_YRMON(+)" ).append("\n"); 
		query.append("AND   A.STL_VVD_SEQ = SL1_18.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND   A.STL_SEQ     = SL1_18.STL_SEQ(+)" ).append("\n"); 
		query.append("AND   SL1_18.SLP_TP_CD(+) = '18' --18수입, 06비용" ).append("\n"); 
		query.append("AND   SL1_18.DR_CR_CD(+)  = 'DR'" ).append("\n"); 
		query.append("AND   A.ACCT_YRMON   BETWEEN  P.ACCT_YRMON_FR  AND P.ACCT_YRMON" ).append("\n"); 
		query.append("GROUP BY A.JO_CRR_CD" ).append("\n"); 
		query.append(")S" ).append("\n"); 
		query.append("GROUP BY S.JO_CRR_CD" ).append("\n"); 
		query.append("ORDER BY S.JO_CRR_CD" ).append("\n"); 

	}
}