/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSEspAdjustDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.14 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchCHSEspAdjustDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090827 1114 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSEspAdjustDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSEspAdjustDataRSQL").append("\n"); 
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
		query.append("@[scc_cd] AS SCC_CD" ).append("\n"); 
		query.append(",Index1.ESP_ADJ_KND_CD AS ESP_ADJ_KND_CD" ).append("\n"); 
		query.append(", DECODE(Index1.ESP_ADJ_KND_CD , 'A', 'Import Turn Time Adjustment (day)'" ).append("\n"); 
		query.append(", 'B', 'Export Turn Time Adjustment (day)'" ).append("\n"); 
		query.append(", 'C', 'Empty Turn Time Adjustment (day)'" ).append("\n"); 
		query.append(", 'D', 'Domestic Turn Time Adjustment (day)'" ).append("\n"); 
		query.append(", 'E', 'Maintenance and Repair Factor(%)'" ).append("\n"); 
		query.append(", 'F', 'Sales Volume Increase Factor(%)'" ).append("\n"); 
		query.append(", 'G', 'Utilization Factor(%)'" ).append("\n"); 
		query.append(", 'H', 'Other Factor(%)'" ).append("\n"); 
		query.append(", 'Unknown Factor' ) AS ESP_CALC_FACTOR" ).append("\n"); 
		query.append(",NVL(t1.CNTR_20FT_ADJ_VAL,0) AS CNTR_20FT_ADJ_VAL" ).append("\n"); 
		query.append(",NVL(t1.CNTR_40FT_ADJ_VAL,0) AS CNTR_40FT_ADJ_VAL" ).append("\n"); 
		query.append(",NVL(t1.CNTR_45FT_ADJ_VAL,0) AS CNTR_45FT_ADJ_VAL" ).append("\n"); 
		query.append(",NVL(t1.CNTR_R5_ADJ_VAL,0) AS CNTR_R5_ADJ_VAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("DECODE(ROWNUM , 1, 'A'" ).append("\n"); 
		query.append(", 2, 'B'" ).append("\n"); 
		query.append(", 3, 'C'" ).append("\n"); 
		query.append(", 4, 'D'" ).append("\n"); 
		query.append(", 5, 'E'" ).append("\n"); 
		query.append(", 6, 'F'" ).append("\n"); 
		query.append(", 7, 'G'" ).append("\n"); 
		query.append(", 8, 'H'" ).append("\n"); 
		query.append(", 'Unknown' ) AS ESP_ADJ_KND_CD" ).append("\n"); 
		query.append("FROM dict WHERE ROWNUM >=1 AND ROWNUM <=8) Index1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("LEFT JOIN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("*" ).append("\n"); 
		query.append("FROM CGM_ESP_ADJ tt1" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("tt1.SCC_CD IN ( SELECT" ).append("\n"); 
		query.append("A.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("AND B.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") t1 ON Index1.ESP_ADJ_KND_CD = t1.ESP_ADJ_KND_CD" ).append("\n"); 
		query.append("ORDER BY ESP_ADJ_KND_CD" ).append("\n"); 

	}
}