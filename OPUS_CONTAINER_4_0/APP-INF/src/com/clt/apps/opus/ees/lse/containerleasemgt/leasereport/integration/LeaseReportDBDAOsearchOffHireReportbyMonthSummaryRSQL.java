/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LeaseReportDBDAOsearchOffHireReportbyMonthSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOsearchOffHireReportbyMonthSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 월별로 임차한 실적을 조회
	  * </pre>
	  */
	public LeaseReportDBDAOsearchOffHireReportbyMonthSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_change",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOsearchOffHireReportbyMonthSummaryRSQL").append("\n"); 
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
		query.append("WITH PARAM" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("         @[period_stdt] PERIOD_STDT" ).append("\n"); 
		query.append("        ,@[period_eddt] PERIOD_EDDT" ).append("\n"); 
		query.append("        ,@[loc_cd] LOC_CD" ).append("\n"); 
		query.append("        ,@[loc_tp] LOC_TP" ).append("\n"); 
		query.append("        ,@[term_change] TERM_CHANGE" ).append("\n"); 
		query.append("	FROM   DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", XXX AS ( " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          SUM(DECODE(DD, '$key' , EE, 0)) $key ," ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("      CC  " ).append("\n"); 
		query.append("FROM ( SELECT " ).append("\n"); 
		query.append("         TO_CHAR(C.CNTR_STS_EVNT_DT , 'YYYY-MM') CC," ).append("\n"); 
		query.append("         A.CNTR_TPSZ_CD DD, " ).append("\n"); 
		query.append("         COUNT(A.CNTR_NO) EE" ).append("\n"); 
		query.append("FROM MST_CONTAINER A," ).append("\n"); 
		query.append("     MDM_CNTR_TP_SZ B," ).append("\n"); 
		query.append("     MST_CNTR_STS_HIS C," ).append("\n"); 
		query.append("     LSE_AGREEMENT D ," ).append("\n"); 
		query.append("     PARAM P" ).append("\n"); 
		query.append("WHERE A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--  AND A.ONH_YD_CD <> 'KRSEL1H'" ).append("\n"); 
		query.append("  AND A.CO_CRE_FLG = 'N'" ).append("\n"); 
		query.append("  AND A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("  AND C.CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("  AND C.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("  AND C.AGMT_SEQ = D.AGMT_SEQ" ).append("\n"); 
		query.append("--  AND SUBSTR(NVL(C.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("  --AND C.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("  --AND A.CO_CRE_FLG = P.TERM_CHANGE" ).append("\n"); 
		query.append("  AND C.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("#if (${term_change} != '' )             " ).append("\n"); 
		query.append("          AND C.CNTR_LSTM_CNG_FLG = P.TERM_CHANGE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dii} != '' )" ).append("\n"); 
		query.append("  #if (${dii} == 'N' )" ).append("\n"); 
		query.append("		  AND C.CNTR_STS_CD = 'LSO'" ).append("\n"); 
		query.append("  #elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD = 'DIO'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD IN ('LSO', 'DIO')" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("          AND DECODE(P.loc_tp, 'R', C.RCC_CD, 'L', C.LCC_CD, 'S', C.SCC_CD ) = P.LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("          AND D.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                     '$key'," ).append("\n"); 
		query.append("                                 #else" ).append("\n"); 
		query.append("                                     '$key'" ).append("\n"); 
		query.append("                                 #end" ).append("\n"); 
		query.append("                             #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       GROUP BY TO_CHAR(C.CNTR_STS_EVNT_DT , 'YYYY-MM'), A.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("GROUP BY CC " ).append("\n"); 
		query.append("ORDER BY CC )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})            " ).append("\n"); 
		query.append("   DECODE( AA.RCC , 'Ratio' ,  TO_CHAR( AA.$key , '990.00') , TO_CHAR( AA.$key , '999,999,999,990'  )) $key ,        " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  TO_CHAR( AA.DIV_TOTAL , '999,999,999,990'  ) DIV_TOTAL ," ).append("\n"); 
		query.append("  TO_CHAR((AA.DIV_TOTAL / BB.DIV_TOTAL ) * 100 , '990.00' ) || '%'  RATIO ," ).append("\n"); 
		query.append("  AA.RCC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("         $key ," ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("              $key + " ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("              $key" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("       ) DIV_TOTAL ," ).append("\n"); 
		query.append("      CC RCC" ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("        SUM( $key ) $key," ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("              SUM($key) + " ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("              SUM($key)" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("       ) DIV_TOTAL ," ).append("\n"); 
		query.append("      'G.TTL' RCC" ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("       SUM( $key ) / (" ).append("\n"); 
		query.append("          #foreach($key IN ${tysz})            " ).append("\n"); 
		query.append("              #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("                   SUM($key) + " ).append("\n"); 
		query.append("              #else" ).append("\n"); 
		query.append("                   SUM($key)" ).append("\n"); 
		query.append("              #end         " ).append("\n"); 
		query.append("          #end  " ).append("\n"); 
		query.append("                       ) * 100  $key ," ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("      100 DIV_TOTAL ," ).append("\n"); 
		query.append("      'Ratio' RCC" ).append("\n"); 
		query.append("FROM XXX ) AA , ( SELECT" ).append("\n"); 
		query.append("                    (#foreach($key IN ${tysz})            " ).append("\n"); 
		query.append("                        #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("                           SUM($key) + " ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                           SUM($key)" ).append("\n"); 
		query.append("                        #end         " ).append("\n"); 
		query.append("                     #end ) DIV_TOTAL " ).append("\n"); 
		query.append("                  FROM XXX ) BB" ).append("\n"); 

	}
}