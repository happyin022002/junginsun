/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSUtilizationUsageDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.02.24 조재성
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

public class ChassisMgsetInventoryDBDAOsearchCHSUtilizationUsageDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090811 1111 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSUtilizationUsageDataRSQL(){
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
		params.put("cntr_dry_rf_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSUtilizationUsageDataRSQL").append("\n"); 
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
		query.append("A.MVMT_STS_CD AS CNMV_STS_CD" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN B.CNTR_PSN_STS_CD IS NOT NULL THEN B.CNTR_PSN_STS_CD" ).append("\n"); 
		query.append("WHEN A.MVMT_STS_CD IN ('EN','TS','VL') THEN 'G'" ).append("\n"); 
		query.append("ELSE 'W'" ).append("\n"); 
		query.append("END AS CNTR_PSN_STS_CD" ).append("\n"); 
		query.append(",CASE WHEN TO_NUMBER(NVL(B.CHSS_USG_RTO,100))>100 THEN 100 ELSE NVL(B.CHSS_USG_RTO,100) END AS CHSS_USG_RTO" ).append("\n"); 
		query.append(",B.LOC_CD" ).append("\n"); 
		query.append(",B.YD_CD" ).append("\n"); 
		query.append(",B.CNTR_DRY_RF_IND_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM MDM_MVMT_STS A" ).append("\n"); 
		query.append("LEFT JOIN (SELECT" ).append("\n"); 
		query.append("t1.LOC_CD" ).append("\n"); 
		query.append(",t1.YD_CD" ).append("\n"); 
		query.append(",t1.CNTR_DRY_RF_IND_CD" ).append("\n"); 
		query.append(",t1.CNMV_STS_CD                     -- CD,CI,CM,..." ).append("\n"); 
		query.append(",t1.CNTR_PSN_STS_CD                -- W, G" ).append("\n"); 
		query.append(",t1.CHSS_USG_RTO" ).append("\n"); 
		query.append("FROM CGM_CHSS_UTL_LOC_USG t1" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t1.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND t1.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND t1.CNTR_DRY_RF_IND_CD = @[cntr_dry_rf_ind_cd] -- R/D" ).append("\n"); 
		query.append("AND t1.CNMV_STS_CD NOT IN ('BI','BO','BR','XX','CX','VD','VL')" ).append("\n"); 
		query.append(") B ON A.MVMT_STS_CD = B.CNMV_STS_CD" ).append("\n"); 
		query.append("LEFT JOIN COM_INTG_CD_DTL C ON (A.MVMT_STS_CD = C.INTG_CD_VAL_CTNT AND C.INTG_CD_ID = 'CD02386' )" ).append("\n"); 
		query.append("WHERE A.MVMT_STS_CD NOT IN ('BI','BO','BR','XX','CX','VD','VL')" ).append("\n"); 
		query.append("ORDER BY C.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}