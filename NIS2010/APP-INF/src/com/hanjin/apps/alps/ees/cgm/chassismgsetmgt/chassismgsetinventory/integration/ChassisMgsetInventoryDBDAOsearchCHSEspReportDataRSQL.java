/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSEspReportDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.12.10 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae-Shung, Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchCHSEspReportDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090831 1115 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSEspReportDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("troughput_inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_time_inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_time_inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("troughput_inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSEspReportDataRSQL").append("\n"); 
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
		query.append("A.SUBJ AS SUBJ" ).append("\n"); 
		query.append(",A.T20  AS T20" ).append("\n"); 
		query.append(",A.T40  AS T40" ).append("\n"); 
		query.append(",A.T45  AS T45" ).append("\n"); 
		query.append(",A.R5 AS R5" ).append("\n"); 
		query.append(",TO_CHAR(MONTHS_BETWEEN(ADD_MONTHS(TO_DATE(@[troughput_inq_to_dys],'YYYYMM'),1) , TO_DATE(@[troughput_inq_fm_dys],'YYYYMM'))) AS MDIFF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  /*+ ORDERED" ).append("\n"); 
		query.append("USE_NL ( T3 T1 ) INDEX( T3 XAK1MDM_LOCATION )*/" ).append("\n"); 
		query.append("t1.FULL_MTY_CD|| DECODE(t1.IB_QTY, 0 , 'O', 'I') SUBJ" ).append("\n"); 
		query.append(", COUNT(  CASE WHEN SUBSTR(t1.CNTR_TPSZ_CD,2,1) = '2' AND t1.CNTR_TPSZ_CD <>'R2' THEN 1" ).append("\n"); 
		query.append("ELSE NULL END  ) AS T20" ).append("\n"); 
		query.append(", COUNT(  CASE WHEN SUBSTR(t1.CNTR_TPSZ_CD,2,1) = '4' THEN 1" ).append("\n"); 
		query.append("ELSE NULL END  ) AS T40" ).append("\n"); 
		query.append(", COUNT(  CASE WHEN SUBSTR(t1.CNTR_TPSZ_CD,2,1) = '7' THEN 1" ).append("\n"); 
		query.append("ELSE NULL END  ) AS T45" ).append("\n"); 
		query.append(", COUNT(  CASE WHEN t1.CNTR_TPSZ_CD  = 'R5' THEN 1" ).append("\n"); 
		query.append("ELSE NULL END  ) AS R5" ).append("\n"); 
		query.append(", COUNT( 1) TOT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_LOCATION T3," ).append("\n"); 
		query.append("#if (${crnt_scc_cd} == 'USNYC' || ${crnt_scc_cd} == 'USORF' || ${crnt_scc_cd} == 'USILM' || ${crnt_scc_cd} == 'USCHS' || ${crnt_scc_cd} == 'USSAV' || ${crnt_scc_cd} == 'USLGB' || ${crnt_scc_cd} == 'USLAX' || ${crnt_scc_cd} == 'USOAK' || ${crnt_scc_cd} == 'USPDX' || ${crnt_scc_cd} == 'USSEA' || ${crnt_scc_cd} == 'USTIW' )" ).append("\n"); 
		query.append("CIM_PORT_MTCH_BAK t1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("CIM_LOC_MTCH_BAK t1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  t1.loc_cd  = t3.LOC_CD" ).append("\n"); 
		query.append("AND    t3.SCC_CD  = @[crnt_scc_cd]" ).append("\n"); 
		query.append("#if (${crnt_scc_cd} == 'USNYC' || ${crnt_scc_cd} == 'USORF' || ${crnt_scc_cd} == 'USILM' || ${crnt_scc_cd} == 'USCHS' || ${crnt_scc_cd} == 'USSAV' || ${crnt_scc_cd} == 'USLGB' || ${crnt_scc_cd} == 'USLAX' || ${crnt_scc_cd} == 'USOAK' || ${crnt_scc_cd} == 'USPDX' || ${crnt_scc_cd} == 'USSEA' || ${crnt_scc_cd} == 'USTIW' )" ).append("\n"); 
		query.append("AND    t1.TS_FLG  = 'N'" ).append("\n"); 
		query.append("AND    t1.SOC_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    t1.ENR_FLG = 'N'" ).append("\n"); 
		query.append("AND    t1.SOC_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    t1.TGT_MVMT_DT BETWEEN @[troughput_inq_fm_dys]||'01' AND @[troughput_inq_to_dys]|| '31'" ).append("\n"); 
		query.append("GROUP BY t1.FULL_MTY_CD|| DECODE(t1.IB_QTY, 0 , 'O', 'I')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  /*+ ORDERED USE_NL(T3 T1) INDEX(T3 XAK1MDM_LOCATION)" ).append("\n"); 
		query.append("INDEX( T1 XAK1CIM_MVMT_STS_TURN_TM ) */" ).append("\n"); 
		query.append("'TURNTIME' AS SUBJ" ).append("\n"); 
		query.append(", ROUND( AVG( CASE WHEN SUBSTR(t1.CNTR_TPSZ_CD,2,1) = '2' AND t1.CNTR_TPSZ_CD <>'R2' THEN TT_DYS" ).append("\n"); 
		query.append("ELSE NULL END ) , 2) AS T20" ).append("\n"); 
		query.append(", ROUND( AVG( CASE WHEN SUBSTR(t1.CNTR_TPSZ_CD,2,1) = '4' THEN TT_DYS" ).append("\n"); 
		query.append("ELSE NULL END ) , 2) AS T40" ).append("\n"); 
		query.append(", ROUND( AVG( CASE WHEN SUBSTR(t1.CNTR_TPSZ_CD,2,1) = '7' THEN TT_DYS" ).append("\n"); 
		query.append("ELSE NULL END ) , 2) AS T45" ).append("\n"); 
		query.append(", ROUND( AVG( CASE WHEN t1.CNTR_TPSZ_CD  = 'R5' THEN TT_DYS" ).append("\n"); 
		query.append("ELSE NULL END ) , 2) AS R5" ).append("\n"); 
		query.append(", t1.TT_MVMT_TP_CD AS MDIFF" ).append("\n"); 
		query.append("FROM    MDM_LOCATION            T3," ).append("\n"); 
		query.append("CIM_MVMT_STS_TURN_TM    t1" ).append("\n"); 
		query.append("WHERE   t1.FM_LOC_CD  = t3.LOC_CD" ).append("\n"); 
		query.append("AND   t3.SCC_CD = @[crnt_scc_cd]" ).append("\n"); 
		query.append("AND t1.TGT_MVMT_DT BETWEEN (@[turn_time_inq_fm_dys]||'01') AND (@[turn_time_inq_to_dys]||'31')" ).append("\n"); 
		query.append("GROUP BY t1.TT_MVMT_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'CGM_ESP_ADJ' AS SUBJ" ).append("\n"); 
		query.append(",NVL(t1.T20,0) AS T20" ).append("\n"); 
		query.append(",NVL(t1.T40,0) AS T40" ).append("\n"); 
		query.append(",NVL(t1.T45,0) AS T45" ).append("\n"); 
		query.append(",NVL(t1.R5,0) AS R5" ).append("\n"); 
		query.append(",Index1.ESP_ADJ_KND_CD  AS MDIFF" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
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
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CNTR_20FT_ADJ_VAL AS T20" ).append("\n"); 
		query.append(", CNTR_40FT_ADJ_VAL AS T40" ).append("\n"); 
		query.append(", CNTR_45FT_ADJ_VAL AS T45" ).append("\n"); 
		query.append(", CNTR_R5_ADJ_VAL AS R5" ).append("\n"); 
		query.append(", ESP_ADJ_KND_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CGM_ESP_ADJ" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCC_CD = @[crnt_scc_cd]" ).append("\n"); 
		query.append(") t1   ON Index1.ESP_ADJ_KND_CD =t1.ESP_ADJ_KND_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'DOM_BOOKING' AS SUBJ" ).append("\n"); 
		query.append(", COUNT( DECODE (SUBSTR(t1.CNTR_TPSZ_CD,2,1), '2' , 1, NULL) )  AS T20" ).append("\n"); 
		query.append(", COUNT( DECODE (SUBSTR(t1.CNTR_TPSZ_CD,2,1), '4' , 1, NULL) )  AS T40" ).append("\n"); 
		query.append(", COUNT( DECODE (t1.CNTR_TPSZ_CD , 'R5' , null, DECODE( SUBSTR(t1.CNTR_TPSZ_CD,2,1), '2' , NULL, '4', NULL , 1 ) )  )  AS T45" ).append("\n"); 
		query.append(", COUNT( DECODE (t1.CNTR_TPSZ_CD , 'R5' , 1, NULL) ) AS R5" ).append("\n"); 
		query.append(", TO_CHAR(MONTHS_BETWEEN(ADD_MONTHS(TO_DATE(@[troughput_inq_to_dys],'YYYYMM'),1) , TO_DATE(@[troughput_inq_fm_dys],'YYYYMM'))) AS MDIFF" ).append("\n"); 
		query.append("FROM DOM_BOOKING t1" ).append("\n"); 
		query.append("LEFT JOIN DOM_RAIL_SO_MST t3 ON (t1.DMST_BKG_NO = t3.DMST_BKG_NO AND t1.CNTR_NO = T3.CNTR_NO AND t3.DELT_FLG = 'N')" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t1.ORG_RAIL_LOC_CD IN ( SELECT" ).append("\n"); 
		query.append("A.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("AND B.SCC_CD = @[crnt_scc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND t1.DMST_BKG_STS_CD = 'F'" ).append("\n"); 
		query.append("AND t1.CRE_DT BETWEEN  TO_DATE(@[troughput_inq_fm_dys],'YYYYMM') AND ADD_MONTHS(TO_DATE(@[troughput_inq_to_dys], 'YYYYMM'),1 )" ).append("\n"); 

	}
}