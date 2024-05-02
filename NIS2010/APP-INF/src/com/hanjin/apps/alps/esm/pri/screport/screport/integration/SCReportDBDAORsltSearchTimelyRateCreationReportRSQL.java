/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCReportDBDAORsltSearchTimelyRateCreationReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchTimelyRateCreationReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office /  S’rep 별로  적기 계약  생성에 대한  결과 값을 조회
	  * </pre>
	  */
	public SCReportDBDAORsltSearchTimelyRateCreationReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchTimelyRateCreationReportRSQL").append("\n"); 
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
		query.append("SELECT REGION" ).append("\n"); 
		query.append("      ,CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,CTRT_SREP_CD" ).append("\n"); 
		query.append("      ,AVG(TTL_CNT) TTL_CNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(RT_CHK_RSLT_CD, 'S', '0', S_E_CNT)) S_E_CNT --S는 success E는 Fail. Fail만 count 함" ).append("\n"); 
		query.append("      ,ROUND(SUM(DECODE(RT_CHK_RSLT_CD, 'F', '0', S_E_CNT)) /AVG(TTL_CNT) * 100, 3) RATIO --Success ratio 구함" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("     SELECT DISTINCT O.REGION" ).append("\n"); 
		query.append("     ,B.CTRT_OFC_CD" ).append("\n"); 
		query.append("     ,B.CTRT_SREP_CD" ).append("\n"); 
		query.append("     ,R.RT_CHK_RSLT_CD" ).append("\n"); 
		query.append("     ,COUNT(R.RT_CHK_RSLT_CD) OVER (PARTITION BY O.REGION, B.CTRT_OFC_CD ,B.CTRT_SREP_CD, R.RT_CHK_RSLT_CD) S_E_CNT" ).append("\n"); 
		query.append("     ,COUNT(B.BKG_NO) OVER (PARTITION BY O.REGION, B.CTRT_OFC_CD ,B.CTRT_SREP_CD) TTL_CNT" ).append("\n"); 
		query.append("    FROM BKG_BOOKING B" ).append("\n"); 
		query.append("        ,BKG_RATE R" ).append("\n"); 
		query.append("        ,BKG_OFC_LVL_V O" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${bkg_from_dt} != '' && ${bkg_to_dt} != '') " ).append("\n"); 
		query.append("      AND B.PORT_CLZ_DT BETWEEN TO_DATE(@[bkg_from_dt], 'YYYY-MM-DD') AND TO_DATE(@[bkg_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("      AND B.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${region} != '') " ).append("\n"); 
		query.append("      AND O.REGION= @[region]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '') " ).append("\n"); 
		query.append("      AND B.CTRT_OFC_CD= @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_srep_cd} != '') " ).append("\n"); 
		query.append("      AND B.CTRT_SREP_CD= @[ctrt_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("      AND R.RT_CHK_DT IS NOT NULL --결과가 나오지 않은 BKG은 제외" ).append("\n"); 
		query.append("      AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("      AND B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("      AND B.VSL_CD NOT IN ('SMXX','SMYY','SMZZ') -- pseudo VSL 제외" ).append("\n"); 
		query.append("      AND B.CTRT_OFC_CD =O.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("GROUP BY REGION, CTRT_OFC_CD, CTRT_SREP_CD" ).append("\n"); 
		query.append("ORDER BY REGION,CTRT_OFC_CD,CTRT_SREP_CD" ).append("\n"); 

	}
}