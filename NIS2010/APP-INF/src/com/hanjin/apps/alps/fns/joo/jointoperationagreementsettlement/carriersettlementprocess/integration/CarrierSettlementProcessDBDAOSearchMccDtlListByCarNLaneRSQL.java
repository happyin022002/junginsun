/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchMccDtlListByCarNLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.05 장강철
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

public class CarrierSettlementProcessDBDAOSearchMccDtlListByCarNLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchMccDtlListByCarNLaneRSQL(){
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
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchMccDtlListByCarNLaneRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("/**/   DENSE_RANK() OVER (ORDER BY ORD)||'. '||T.JO_STL_ITM_CD_NM JO_STL_ITM_CD_NM" ).append("\n"); 
		query.append(",      ORD" ).append("\n"); 
		query.append(",      A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append(",      A1.RLANE_CD" ).append("\n"); 
		query.append(",      A1.LOCL_CURR_CD" ).append("\n"); 
		query.append(",      A1.VVD" ).append("\n"); 
		query.append(",      SUM(A1.BSA_QTY)BSA_QTY" ).append("\n"); 
		query.append(",      A1.BSA_SLT_PRC" ).append("\n"); 
		query.append(",      SUM(A1.STL_LOCL_AMT)STL_LOCL_AMT" ).append("\n"); 
		query.append(",      CASE WHEN MAX(A1.FM_PORT_CD) IS NULL THEN ''" ).append("\n"); 
		query.append("/**/        ELSE SUBSTR(XMLAGG(XMLELEMENT(A1,', '||A1.FM_PORT_CD) ORDER BY FM_PORT_CD).EXTRACT('//text()').GetStringVal(),2)" ).append("\n"); 
		query.append("/**/   END  STL_RMK" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("SELECT    S.JO_STL_ITM_CD" ).append("\n"); 
		query.append(",                 S.RLANE_CD" ).append("\n"); 
		query.append(",                 S.LOCL_CURR_CD" ).append("\n"); 
		query.append(",                 S.VVD" ).append("\n"); 
		query.append(",                 SUM(S.BSA_QTY) BSA_QTY" ).append("\n"); 
		query.append(",                 S.BSA_SLT_PRC" ).append("\n"); 
		query.append(",                 SUM(S.STL_LOCL_AMT) STL_LOCL_AMT" ).append("\n"); 
		query.append(",                 S.FM_PORT_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("/**/                      SELECT     A.JO_STL_ITM_CD" ).append("\n"); 
		query.append(",                                    A.RLANE_CD" ).append("\n"); 
		query.append(",                                    A.LOCL_CURR_CD" ).append("\n"); 
		query.append(",                                    A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD" ).append("\n"); 
		query.append(",                                    CASE WHEN   A.JO_STL_ITM_CD='R/F'  AND A.JO_MNU_NM = 'R/F'  /*R/F이외는 BSA_QTY         */" ).append("\n"); 
		query.append("/**/                                      THEN   A.USD_SLT_BSA_QTY      /*R/F는     USD_SLT_BSA_QTY */" ).append("\n"); 
		query.append("/**/                                      ELSE   A.BSA_QTY" ).append("\n"); 
		query.append("/**/                                 END BSA_QTY" ).append("\n"); 
		query.append(",                                    CASE WHEN   A.JO_STL_ITM_CD='R/F'  AND A.JO_MNU_NM = 'R/F'  /*R/F  RF_SCG_PRC         */" ).append("\n"); 
		query.append("/**/                                      THEN   A.RF_SCG_PRC      /*R/F이외는 BSA_SLT_PRC*/" ).append("\n"); 
		query.append("/**/                                      ELSE   A.BSA_SLT_PRC" ).append("\n"); 
		query.append("/**/                                 END  BSA_SLT_PRC" ).append("\n"); 
		query.append(",                                    A.STL_LOCL_AMT" ).append("\n"); 
		query.append(",                                    A.FM_PORT_CD" ).append("\n"); 
		query.append("/**/                       FROM   JOO_SETTLEMENT A" ).append("\n"); 
		query.append("/**/                      WHERE   A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-') AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("#if (${rlane_cds} != '')" ).append("\n"); 
		query.append("/**/                        AND   A.RLANE_CD in (" ).append("\n"); 
		query.append("#foreach($key IN ${rlane_cds})" ).append("\n"); 
		query.append("#if($velocityCount < $rlane_cds.size())" ).append("\n"); 
		query.append("/**/	         '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("/**/	         '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/**/)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("/**/                        AND  A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("/**/                        AND  A.TRD_CD  = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_dir_cd} != '')" ).append("\n"); 
		query.append("/**/                        AND  A.re_divr_cd  = @[rev_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND  (A.STL_ADJ_FLG = 'N' OR A.STL_ADJ_FLG IS NULL)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/**/                       SELECT      A.JO_STL_ITM_CD" ).append("\n"); 
		query.append(",                                      A.RLANE_CD" ).append("\n"); 
		query.append(",                                      A.LOCL_CURR_CD" ).append("\n"); 
		query.append(",                                      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD" ).append("\n"); 
		query.append(",                                      B.BSA_QTY" ).append("\n"); 
		query.append(",                                      B.BSA_SLT_PRC" ).append("\n"); 
		query.append(",                                      B.STL_LOCL_AMT" ).append("\n"); 
		query.append(",                                      ''FM_PORT_CD" ).append("\n"); 
		query.append("/**/                          FROM     JOO_SETTLEMENT  A," ).append("\n"); 
		query.append("/**/                                   JOO_STL_DTL     B" ).append("\n"); 
		query.append("/**/                         WHERE     A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("/**/                           AND     A.STL_VVD_SEQ = B.STL_VVD_SEQ" ).append("\n"); 
		query.append("/**/                           AND     A.STL_SEQ     = B.STL_SEQ" ).append("\n"); 
		query.append("/**/                           AND     A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-')  AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("#if (${rlane_cds} != '')" ).append("\n"); 
		query.append("/**/                           AND   A.RLANE_CD in (" ).append("\n"); 
		query.append("#foreach($key IN ${rlane_cds})" ).append("\n"); 
		query.append("#if($velocityCount < $rlane_cds.size())" ).append("\n"); 
		query.append("/**/	         '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("/**/	         '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/**/)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("/**/                          AND  A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("/**/                          AND  A.TRD_CD  = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_dir_cd} != '')" ).append("\n"); 
		query.append("/**/                          AND  A.re_divr_cd  = @[rev_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/**/                          AND  A.STL_ADJ_FLG = 'Y') S" ).append("\n"); 
		query.append("/**/                     GROUP BY  S.JO_STL_ITM_CD," ).append("\n"); 
		query.append("/**/                               S.RLANE_CD," ).append("\n"); 
		query.append("/**/                               S.LOCL_CURR_CD" ).append("\n"); 
		query.append(",S.VVD," ).append("\n"); 
		query.append("S.BSA_SLT_PRC" ).append("\n"); 
		query.append(", S.FM_PORT_CD)A1," ).append("\n"); 
		query.append("/**/     (  SELECT 1 ORD,'S/H' JO_STL_ITM_CD, 'T' IOC_CD, 'Slot Hire'           JO_STL_ITM_CD_NM FROM DUAL UNION ALL" ).append("\n"); 
		query.append("/**/        SELECT 2 ORD,'OUS' JO_STL_ITM_CD, 'T' IOC_CD, 'Over Used Slot Hire' JO_STL_ITM_CD_NM FROM DUAL UNION ALL" ).append("\n"); 
		query.append("/**/        SELECT 3 ORD,'R/F' JO_STL_ITM_CD, 'T' IOC_CD, 'Reefer Surcharge'    JO_STL_ITM_CD_NM FROM DUAL UNION ALL" ).append("\n"); 
		query.append("/**/        SELECT 4 ORD,'OTH' JO_STL_ITM_CD, 'T' IOC_CD, 'Other'               JO_STL_ITM_CD_NM FROM DUAL UNION ALL" ).append("\n"); 
		query.append("/**/        SELECT 5 ORD,'W/R' JO_STL_ITM_CD, 'T' IOC_CD, 'War Risk'            JO_STL_ITM_CD_NM FROM DUAL UNION ALL" ).append("\n"); 
		query.append("/**/        SELECT 6 ORD,'P/B' JO_STL_ITM_CD, 'T' IOC_CD, 'PBAS'                JO_STL_ITM_CD_NM FROM DUAL ) T" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("/**/     T.JO_STL_ITM_CD = A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append("GROUP BY  T.ORD,T.JO_STL_ITM_CD_NM" ).append("\n"); 
		query.append(",         A1.JO_STL_ITM_CD" ).append("\n"); 
		query.append(",         A1.RLANE_CD" ).append("\n"); 
		query.append(",         A1.LOCL_CURR_CD" ).append("\n"); 
		query.append(",         A1.VVD, A1.BSA_SLT_PRC" ).append("\n"); 
		query.append("ORDER BY T.ORD,A1.RLANE_CD ,A1.VVD" ).append("\n"); 

	}
}