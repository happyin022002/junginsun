/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAORbcvesselVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.01
*@LastModifier : jklim
*@LastVersion : 1.0
* 2013.10.01 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAORbcvesselVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAORbcvesselVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAORbcvesselVORSQL").append("\n"); 
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
		query.append("SELECT WEEK,VVD,LANE,POL,COUNT(*) BKG_QTY,ETD " ).append("\n"); 
		query.append(" FROM BKG_BOOKING B,(" ).append("\n"); 
		query.append(" SELECT " ).append("\n"); 
		query.append(" TO_CHAR(TO_DATE(SUBSTR(V.PSDO_VVD_CD,3,6),'RRMMDD'),'WW') WEEK, " ).append("\n"); 
		query.append(" TO_CHAR(TO_DATE(SUBSTR(V.PSDO_VVD_CD,3,6),'RRMMDD'),'YYYY/MM/DD') ETD," ).append("\n"); 
		query.append(" V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD," ).append("\n"); 
		query.append(" V.VSL_CD V_VSL,V.SKD_VOY_NO V_VOYAGE,V.SKD_DIR_CD V_DIR," ).append("\n"); 
		query.append(" S.VSL_SLAN_NM LANE," ).append("\n"); 
		query.append(" V.ST_PORT_CD POL" ).append("\n"); 
		query.append("       FROM VSK_VSL_SKD V, MDM_VSL_SVC_LANE S" ).append("\n"); 
		query.append("       WHERE V.SKD_STS_CD = 'ACT'" ).append("\n"); 
		query.append("       AND V.VSL_SLAN_CD = S.VSL_SLAN_CD" ).append("\n"); 
		query.append("	   AND SUBSTR(V.PSDO_VVD_CD,3,6) >= SUBSTR(REPLACE(@[from_dt],'-',''),3,6) " ).append("\n"); 
		query.append(" 	   AND SUBSTR(V.PSDO_VVD_CD,3,6) <= SUBSTR(REPLACE(@[to_dt],'-',''),3,6)  " ).append("\n"); 
		query.append("	   AND S.VSL_SVC_TP_CD ='O'" ).append("\n"); 
		query.append(" ) WHERE V_VSL = B.VSL_CD" ).append("\n"); 
		query.append(" AND   V_VOYAGE = B.SKD_VOY_NO" ).append("\n"); 
		query.append(" AND   V_DIR = B.SKD_DIR_CD" ).append("\n"); 
		query.append(" AND   B.BKG_STS_CD <> 'X' " ).append("\n"); 
		query.append(" AND   B.BKG_CGO_TP_CD NOT IN ('P','R')" ).append("\n"); 
		query.append(" GROUP BY WEEK, VVD, LANE, POL, ETD" ).append("\n"); 
		query.append(" ORDER BY WEEK, VVD" ).append("\n"); 

	}
}