/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSupplyDemandPlanDBDAOSearchEqPriceDataSubSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.12.23 이호선
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

public class ContainerSupplyDemandPlanDBDAOSearchEqPriceDataSubSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select SubSEQ
	  * </pre>
	  */
	public ContainerSupplyDemandPlanDBDAOSearchEqPriceDataSubSeqRSQL(){
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
		query.append("FileName : ContainerSupplyDemandPlanDBDAOSearchEqPriceDataSubSeqRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM CNT, AAA.LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT AA.LOC_CD LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.LOC_CD" ).append("\n"); 
		query.append("FROM MST_EQ_PUR_PRC A," ).append("\n"); 
		query.append("MDM_LOCATION B," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT C" ).append("\n"); 
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
		query.append("AND   A.EQ_TPSZ_CD  IN (" ).append("\n"); 
		query.append("#foreach($cntrtpszcd in ${vel_tpsz_cd})" ).append("\n"); 
		query.append("'$cntrtpszcd'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${eq_knd_cd} != '')" ).append("\n"); 
		query.append("AND   A.EQ_KND_CD   =  @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.LOC_CD" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("ORDER BY AA.LOC_CD ASC" ).append("\n"); 
		query.append(") AAA" ).append("\n"); 

	}
}