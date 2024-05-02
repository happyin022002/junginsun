/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerSupplyDemandPlanDBDAOEqPurPrcReportDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.20 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSupplyDemandPlanDBDAOEqPurPrcReportDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Purchasing Trend by Year inquiry
	  * </pre>
	  */
	public ContainerSupplyDemandPlanDBDAOEqPurPrcReportDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yrmon1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yrmon0",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration").append("\n"); 
		query.append("FileName : ContainerSupplyDemandPlanDBDAOEqPurPrcReportDetailVORSQL").append("\n"); 
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
		query.append("SELECT A.PUR_LIST" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       A.BSE_YRMON," ).append("\n"); 
		query.append("       NVL(D.VNDR_ABBR_NM, D.VNDR_LGL_ENG_NM) VNDR_NM," ).append("\n"); 
		query.append("       A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       SUBSTR(A.BSE_YRMON,1,4)||'-'||SUBSTR(A.BSE_YRMON,5,2)|| '|' ||" ).append("\n"); 
		query.append("       NVL(D.VNDR_ABBR_NM, D.VNDR_LGL_ENG_NM) || '|' ||" ).append("\n"); 
		query.append("       A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("#foreach ($pl in ${paramlist})" ).append("\n"); 
		query.append("       || '|' || MAX(DECODE('${pl.cnt}', '${pl.cnt}', DECODE(A.LOC_CD, '${pl.loc_cd}', A.EQ_QTY, 0))) || '|' ||" ).append("\n"); 
		query.append("       MAX(DECODE('${pl.cnt}', '${pl.cnt}', DECODE(A.LOC_CD, '${pl.loc_cd}', A.PUR_PRC, 0))) || '|' ||" ).append("\n"); 
		query.append("       MAX(DECODE('${pl.cnt}', '${pl.cnt}', DECODE(A.LOC_CD, '${pl.loc_cd}', A.PUR_UT_PRC, 0))) || '|' ||" ).append("\n"); 
		query.append("       MAX(DECODE('${pl.cnt}', '${pl.cnt}', DECODE(A.LOC_CD, '${pl.loc_cd}', A.DRYG_AMT, 0))) || '|' ||" ).append("\n"); 
		query.append("       TO_NUMBER(MAX(DECODE('${pl.cnt}', '${pl.cnt}', DECODE(A.LOC_CD, '${pl.loc_cd}', A.PUR_PRC, 0))) + MAX(DECODE('${pl.cnt}', '${pl.cnt}', DECODE(A.LOC_CD, '${pl.loc_cd}', A.PUR_UT_PRC, 0))) + MAX(DECODE('${pl.cnt}', '${pl.cnt}', DECODE(A.LOC_CD, '${pl.loc_cd}', A.DRYG_AMT, 0)))) || '|' ||" ).append("\n"); 
		query.append("       MAX(DECODE('${pl.cnt}', '${pl.cnt}', DECODE(A.LOC_CD, '${pl.loc_cd}', A.DIFF_RMK, '')))" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("       ||'|'|| SUM(A.EQ_QTY) || '|' || SUM(A.PUR_PRC) || '|' || SUM(A.PUR_UT_PRC) || '|' || SUM(A.DRYG_AMT) || '|' ||         " ).append("\n"); 
		query.append("       TO_NUMBER(SUM(A.PUR_PRC) + SUM(A.PUR_UT_PRC) + SUM(A.DRYG_AMT))" ).append("\n"); 
		query.append("       || '' AS PUR_LIST" ).append("\n"); 
		query.append("FROM MST_EQ_PUR_PRC A, MDM_LOCATION B, MDM_EQ_ORZ_CHT C, MDM_VENDOR D" ).append("\n"); 
		query.append("WHERE A.BSE_YRMON BETWEEN @[bse_yrmon0] AND @[bse_yrmon1]" ).append("\n"); 
		query.append("AND   A.LOC_CD   =   B.LOC_CD" ).append("\n"); 
		query.append("AND   B.SCC_CD   =   C.SCC_CD" ).append("\n"); 
		query.append("#if(${mloc_cd} == 'R')" ).append("\n"); 
		query.append("AND   C.RCC_CD   =   @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${mloc_cd} == 'L')" ).append("\n"); 
		query.append("AND   C.LCC_CD   =   @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${mloc_cd} == 'E')" ).append("\n"); 
		query.append("AND   C.ECC_CD   =   @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${mloc_cd} == 'S')" ).append("\n"); 
		query.append("AND   C.SCC_CD   =   @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '' && ${cntr_tpsz_cd} != 'ALL')" ).append("\n"); 
		query.append("AND   A.EQ_TPSZ_CD  IN ( " ).append("\n"); 
		query.append("		#foreach($cntrtpszcd in ${vel_tpsz_cd})  " ).append("\n"); 
		query.append("			'$cntrtpszcd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${eq_knd_cd} != '')" ).append("\n"); 
		query.append("AND   A.EQ_KND_CD   =  @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   D.VNDR_SEQ    =  A.VNDR_SEQ" ).append("\n"); 
		query.append("GROUP BY A.BSE_YRMON, A.VNDR_SEQ, A.EQ_TPSZ_CD, D.VNDR_ABBR_NM, D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(") A, " ).append("\n"); 
		query.append("#if(${eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("MDM_CNTR_TP_SZ B" ).append("\n"); 
		query.append("WHERE A.EQ_TPSZ_CD  = B.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.BSE_YRMON, A.VNDR_NM, B.RPT_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${eq_knd_cd} != 'U')" ).append("\n"); 
		query.append("CGM_EQ_TP_SZ B" ).append("\n"); 
		query.append("WHERE A.EQ_TPSZ_CD  = B.EQ_TPSZ_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.BSE_YRMON, A.VNDR_NM, B.DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}