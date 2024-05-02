/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchBunkerPriceDaliyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2009.12.24 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchBunkerPriceDaliyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBunkerPriceDaliy
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchBunkerPriceDaliyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_wrk_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchBunkerPriceDaliyRSQL").append("\n"); 
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
		query.append("SELECT	ROUND( RTO_1ST * AVG (PRC_1TH) + RTO_2TH * AVG(PRC_2TH) )	AS BNK_PRC" ).append("\n"); 
		query.append("FROM	(SELECT		ROW_NUMBER() OVER (PARTITION BY T1.EVNT_DT ORDER BY T1.EVNT_DT) SEQ" ).append("\n"); 
		query.append(", T1.PORT_CD" ).append("\n"); 
		query.append(", T1.EVNT_DT" ).append("\n"); 
		query.append(", NVL((BNK_RFUEL_RTO / 100), 0)			AS RTO_1ST" ).append("\n"); 
		query.append(", NVL(HIGH_PRC, 0) 				AS PRC_1TH" ).append("\n"); 
		query.append(", NVL(LEAD(BNK_RFUEL_RTO / 100) OVER (PARTITION BY T1.EVNT_DT ORDER BY BNK_RFUEL_RTO ), 0) AS RTO_2TH" ).append("\n"); 
		query.append(", NVL(LEAD(HIGH_PRC			  ) OVER (PARTITION BY T1.EVNT_DT ORDER BY BNK_RFUEL_RTO ), 0) AS PRC_2TH" ).append("\n"); 
		query.append("FROM    VSK_BNK_PRC T1, VSK_PORT_BNK_RFUEL_RTO T2" ).append("\n"); 
		query.append("WHERE   1       = 1" ).append("\n"); 
		query.append("AND     T1.PORT_CD          = T2.LOC_CD" ).append("\n"); 
		query.append("AND     T1.FOIL_DOIL_DIV_CD = 'F'" ).append("\n"); 
		query.append("AND     T2.VSL_SLAN_CD      = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND     T1.EVNT_DT IN (" ).append("\n"); 
		query.append("SELECT  DT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  (FM_DT + LEVEL - 1) DT, TO_CHAR((FM_DT + LEVEL - 1), 'D') DAY" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  YYYYMM AS FM_DT, LAST_DAY(YYYYMM) + 0.99999 AS TO_DT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  TO_DATE(" ).append("\n"); 
		query.append("(CASE WHEN QT = 1 THEN TO_CHAR(TO_NUMBER(@[slt_prc_wrk_yr]) - 1) ELSE @[slt_prc_wrk_yr] END )||" ).append("\n"); 
		query.append("(CASE WHEN QT = 1 THEN '12' WHEN QT = 2 THEN '03' WHEN QT = 3 THEN '06' ELSE '09' END ), 'YYYYMM') AS YYYYMM" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  TO_CHAR(TO_DATE(@[slt_prc_wrk_yr]|| CASE WHEN @[bse_qtr_cd] = '1Q' THEN '01' WHEN @[bse_qtr_cd] = '2Q' THEN '04' WHEN @[bse_qtr_cd] = '3Q' THEN '07' ELSE '10' END, 'YYYYMM'), 'Q') AS QT FROM DUAL)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") T2" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= TO_DT - FM_DT + 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   DAY     = 5" ).append("\n"); 
		query.append("AND     ROWNUM <= 3" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	SEQ	= 1" ).append("\n"); 
		query.append("GROUP BY RTO_1ST, RTO_2TH" ).append("\n"); 

	}
}