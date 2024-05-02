/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LeaseReportDBDAOsearchOffHireResultbyLocationAgreementCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOsearchOffHireResultbyLocationAgreementCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차 장비 반납 실적을 보는 화면-Off Hire Result by Location / AGMT No(Contract No.)-Option  
	  * 전체건수 조회
	  * </pre>
	  */
	public LeaseReportDBDAOsearchOffHireResultbyLocationAgreementCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_cntr_tp_sz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("term_change",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_rcc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOsearchOffHireResultbyLocationAgreementCountRSQL").append("\n"); 
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
		query.append("	 COUNT(*) AS TOTAL_CNT	 " ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS A , MST_CONTAINER B , LSE_AGREEMENT D, MST_CNTR_STS_HIS E ," ).append("\n"); 
		query.append("   (SELECT A.YD_CD, A.LOC_CD, C.RCC_CD,C.LCC_CD, C.SCC_CD" ).append("\n"); 
		query.append("    FROM MDM_YARD A," ).append("\n"); 
		query.append("         MDM_LOCATION B," ).append("\n"); 
		query.append("         MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("    WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("      AND B.SCC_CD = C.SCC_CD) F" ).append("\n"); 
		query.append("    , BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("--      AND   B.ONH_YD_CD <> 'KRSEL1H'" ).append("\n"); 
		query.append("AND   B.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("AND   A.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ    = D.AGMT_SEQ" ).append("\n"); 
		query.append("AND   B.ONH_YD_CD   = F.YD_CD" ).append("\n"); 
		query.append("AND   BKG.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("#if (${term_change} != '' )             " ).append("\n"); 
		query.append("AND   A.CNTR_LSTM_CNG_FLG = @[term_change]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dii} != '' )" ).append("\n"); 
		query.append("#if (${dii} == 'N' )" ).append("\n"); 
		query.append("		AND A.CNTR_STS_CD IN ('LSO', 'TLL')" ).append("\n"); 
		query.append("#elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("        AND A.CNTR_STS_CD = 'DIO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND A.CNTR_STS_CD IN ('LSO', 'DIO', 'TLL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("AND   substr(nvl(A.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("AND   A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[period_stdt],'yyyymmdd') AND TO_DATE(@[period_eddt],'yyyymmdd')" ).append("\n"); 
		query.append("AND   A.CNTR_NO = E.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   A.PRNR_STS_SEQ = E.CNTR_STS_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${detail_rcc} != '') " ).append("\n"); 
		query.append("  #if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("AND   A.LCC_CD = @[detail_rcc]" ).append("\n"); 
		query.append("  #elseif (${loc_tp} == 'L' ) " ).append("\n"); 
		query.append("AND   A.SCC_CD = @[detail_rcc]" ).append("\n"); 
		query.append("  #elseif (${loc_tp} == 'S' ) " ).append("\n"); 
		query.append("AND   A.YD_CD = @[detail_rcc]" ).append("\n"); 
		query.append("  #elseif (${loc_tp} == '' ) " ).append("\n"); 
		query.append("AND   A.RCC_CD = @[detail_rcc]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${detail_agmt_seq} != '0' ) " ).append("\n"); 
		query.append("AND   A.AGMT_CTY_CD  = @[detail_agmt_cty_cd]" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ     = @[detail_agmt_seq]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("AND  A.AGMT_CTY_CD  = @[agmt_cty_cd]       " ).append("\n"); 
		query.append("AND  A.AGMT_SEQ     = @[agmt_seq]  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${detail_cntr_tp_sz} != '' ) " ).append("\n"); 
		query.append("AND   B.CNTR_TPSZ_CD = @[detail_cntr_tp_sz]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${company} != '' )" ).append("\n"); 
		query.append("AND   B.CNTR_USE_CO_CD = @[company] " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("AND   DECODE(@[loc_tp], 'R', A.RCC_CD, 'L', A.LCC_CD, 'S', A.SCC_CD , 'Y' , A.YD_CD , 'C' , SUBSTR(A.YD_CD , 0 ,2)) = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("AND   B.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '' ) " ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                         #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                             '$key'," ).append("\n"); 
		query.append("                         #else" ).append("\n"); 
		query.append("                             '$key'" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                     #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("AND D.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                     #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                         '$key'," ).append("\n"); 
		query.append("                     #else" ).append("\n"); 
		query.append("                         '$key'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                 #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}