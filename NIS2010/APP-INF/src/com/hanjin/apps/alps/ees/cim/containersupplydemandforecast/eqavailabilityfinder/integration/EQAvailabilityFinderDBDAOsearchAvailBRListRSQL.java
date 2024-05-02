/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQAvailabilityFinderDBDAOsearchAvailBRListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.03.04 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQAvailabilityFinderDBDAOsearchAvailBRListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BR(Booking Reserved)의 Detail한 BKG 정보를 조회한다.
	  * </pre>
	  */
	public EQAvailabilityFinderDBDAOsearchAvailBRListRSQL(){
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
		params.put("fcast_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration").append("\n"); 
		query.append("FileName : EQAvailabilityFinderDBDAOsearchAvailBRListRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	TO_CHAR(A.FCAST_DT,'YYYY-MM-DD') FCAST_DT" ).append("\n"); 
		query.append("   ,A.YD_CD" ).append("\n"); 
		query.append("   ,A.BKG_NO" ).append("\n"); 
		query.append("   ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   ,A.CNTR_QTY CNTR_VOL_QTY" ).append("\n"); 
		query.append("   ,(SELECT /*+ INDEX(V XPKBKG_VVD) */" ).append("\n"); 
		query.append("            V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("     FROM BKG_VVD V" ).append("\n"); 
		query.append("     WHERE A.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("     AND   ROWNUM =1) VVD" ).append("\n"); 
		query.append("   ,(SELECT " ).append("\n"); 
		query.append("           TO_CHAR(S.VPS_ETA_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("     FROM  VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("     WHERE (S.VSL_CD,S.SKD_VOY_NO,S.SKD_DIR_CD,S.VPS_PORT_CD)=  " ).append("\n"); 
		query.append("                                                                 (SELECT /*+ INDEX(V XPKBKG_VVD) */" ).append("\n"); 
		query.append("                                                                    V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD,V.POL_CD" ).append("\n"); 
		query.append("                                                                  FROM BKG_VVD V" ).append("\n"); 
		query.append("                                                                 WHERE A.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                                                                 AND   ROWNUM =1)" ).append("\n"); 
		query.append("     AND   ROWNUM =1                                                             " ).append("\n"); 
		query.append("    ) ETA" ).append("\n"); 
		query.append("    ,B.RCV_TERM_CD" ).append("\n"); 
		query.append("    ,B.BKG_OFC_CD" ).append("\n"); 
		query.append("    ,(SELECT D.CMDT_NM " ).append("\n"); 
		query.append("      FROM  MDM_COMMODITY D" ).append("\n"); 
		query.append("      WHERE   B.CMDT_CD = D.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("    ,TO_CHAR(B.BKG_CRE_DT,'YYYY-MM-DD') BKG_CRE_DT" ).append("\n"); 
		query.append("    ,SUBSTR(B.INTER_RMK,1,100) INTER_RMK    " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    CIM_AVAL_DTL A, BKG_BOOKING B ,MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE A.CNTR_AVAL_FCAST_TP_CD='BR'" ).append("\n"); 
		query.append("AND   A.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("AND L.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#if (${fcast_dt} !='' )" ).append("\n"); 
		query.append("	AND A.FCAST_DT BETWEEN TO_DATE(@[fcast_dt],'YYYYMMDD') AND TO_DATE(@[fcast_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   L.LOC_CD = SUBSTR(A.YD_CD,1,5)" ).append("\n"); 
		query.append("ORDER BY  A.FCAST_DT ,A.YD_CD ,A.BKG_NO ,A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}