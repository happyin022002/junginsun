/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSUtilizationRptWGDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.13 조재성
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

public class ChassisMgsetInventoryDBDAOsearchCHSUtilizationRptWGDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090813 1112 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSUtilizationRptWGDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSUtilizationRptWGDataRSQL").append("\n"); 
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
		query.append("T1.CNMV_STS_CD AS CNMV_STS_CD" ).append("\n"); 
		query.append(",T4.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_psn_sts_cd} == 'W')" ).append("\n"); 
		query.append(", ROUND( SUM(   CASE WHEN SUBSTR(t1.EQ_TPSZ_CD,2,1) = '2'  THEN T1.Wheeled_KNT   ELSE 0 END )  / COUNT( DISTINCT PERIOD ) ) AS CHSS_20FT_VOL_QTY" ).append("\n"); 
		query.append(", ROUND( SUM(  CASE WHEN SUBSTR(t1.EQ_TPSZ_CD,2,1) IN ('4','5')  THEN T1.Wheeled_KNT   ELSE 0 END )  / COUNT( DISTINCT PERIOD ) ) AS CHSS_40FT_VOL_QTY" ).append("\n"); 
		query.append(", ROUND( SUM(  CASE WHEN SUBSTR(t1.EQ_TPSZ_CD,2,1) = '7' THEN T1.Wheeled_KNT  ELSE 0 END )  / COUNT( DISTINCT PERIOD ) ) AS CHSS_45FT_VOL_QTY" ).append("\n"); 
		query.append("#elseif (${cntr_psn_sts_cd} == 'G')" ).append("\n"); 
		query.append(", ROUND( SUM(   CASE WHEN SUBSTR(t1.EQ_TPSZ_CD,2,1) = '2'  THEN T1.GroundED_KNT   ELSE 0 END )  / COUNT( DISTINCT PERIOD ) ) AS CHSS_20FT_VOL_QTY" ).append("\n"); 
		query.append(", ROUND( SUM(  CASE WHEN SUBSTR(t1.EQ_TPSZ_CD,2,1) IN ('4','5')  THEN T1.GroundED_KNT   ELSE 0 END )  / COUNT( DISTINCT PERIOD ) ) AS CHSS_40FT_VOL_QTY" ).append("\n"); 
		query.append(", ROUND( SUM(  CASE WHEN SUBSTR(t1.EQ_TPSZ_CD,2,1) = '7' THEN T1.GroundED_KNT  ELSE 0 END )  / COUNT( DISTINCT PERIOD ) ) AS CHSS_45FT_VOL_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(SMRY_DT, 'YYYY-MM-DD') AS PERIOD," ).append("\n"); 
		query.append("EQ_TPSZ_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("INVT_SMRY_KNT," ).append("\n"); 
		query.append("CHSS_USG_RTO," ).append("\n"); 
		query.append("CNTR_PSN_STS_CD," ).append("\n"); 
		query.append("CNMV_STS_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CASE WHEN CNTR_PSN_STS_CD = 'G'  THEN round( (INVT_SMRY_KNT * CHSS_USG_RTO) / 100  )" ).append("\n"); 
		query.append("ELSE INVT_SMRY_KNT  - round( (INVT_SMRY_KNT * (CHSS_USG_RTO) ) / 100  )" ).append("\n"); 
		query.append("END GroundED_KNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CASE WHEN CNTR_PSN_STS_CD = 'W'  THEN round( (INVT_SMRY_KNT * CHSS_USG_RTO) / 100  )" ).append("\n"); 
		query.append("ELSE INVT_SMRY_KNT  - round( (INVT_SMRY_KNT * (CHSS_USG_RTO) ) / 100  )" ).append("\n"); 
		query.append("END Wheeled_KNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("T1.SMRY_DT," ).append("\n"); 
		query.append("T1.EQ_TPSZ_CD," ).append("\n"); 
		query.append("T1.YD_CD," ).append("\n"); 
		query.append("INVT_SMRY_KNT," ).append("\n"); 
		query.append("NVL(CHSS_USG_RTO,100)  CHSS_USG_RTO ," ).append("\n"); 
		query.append("CASE WHEN T2.CNTR_PSN_STS_CD IS NULL THEN" ).append("\n"); 
		query.append("DECODE(T1.CNMV_STS_CD,'EN','G','TS','G','VL','G','W')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("T2.CNTR_PSN_STS_CD" ).append("\n"); 
		query.append("END CNTR_PSN_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",T1.CNMV_STS_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_MVMT_DLY_INVT_SMRY t1 , CGM_CHSS_UTL_LOC_USG T2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t1.LOC_CD IN ( SELECT" ).append("\n"); 
		query.append("t2.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION t2, MDM_EQ_ORZ_CHT t3" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t2.SCC_CD = t3.SCC_CD" ).append("\n"); 
		query.append("#if (${crnt_loc_cd} != '')" ).append("\n"); 
		query.append("AND t3.LCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scc_cd} != '')" ).append("\n"); 
		query.append("AND t3.SCC_CD IN ($scc_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND t1.SMRY_DT BETWEEN TO_DATE(@[inq_fm_dys],'YYYYMMDD') AND TO_DATE(@[inq_to_dys],'YYYYMMDD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND T1.LOC_CD = T2.LOC_CD(+)" ).append("\n"); 
		query.append("AND T1.YD_CD = T2.YD_CD(+)" ).append("\n"); 
		query.append("AND DECODE( SUBSTR(T1.EQ_TPSZ_CD,1,1) ,'R','R', 'D') = T2.CNTR_DRY_RF_IND_CD (+)" ).append("\n"); 
		query.append("AND T1.CNMV_STS_CD =T2.CNMV_STS_CD(+)" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(") T1, COM_INTG_CD_DTL T4" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("T1.CNMV_STS_CD = T4.INTG_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("AND 'CD02386' = T4.INTG_CD_ID (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY T1.CNMV_STS_CD,T4.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("ORDER BY T4.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}