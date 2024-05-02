/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchMRIRevenueVVDLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOsearchMRIRevenueVVDLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOsearchMRIRevenueVVDLaneRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchMRIRevenueVVDLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zone_ioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchMRIRevenueVVDLaneRSQL").append("\n"); 
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
		query.append("#if (${vsl} == 'USAC') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT V.RLANE_CD REV_LANE , T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD REV_VVD, T.LANE SLANE_CD " ).append("\n"); 
		query.append("FROM AR_MST_REV_VVD V," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("          SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD||NVL(C.RLANE_DIR_CD, SKD_DIR_CD) SKD_DIR_CD," ).append("\n"); 
		query.append("               DECODE(VSL_CD, 'COMC','COM','CNTC','CNT', 'USAC','USA','WLXC','WLX', DECODE(LANE,'SYS','RBC',LANE) ) LANE" ).append("\n"); 
		query.append("        FROM AR_FINC_DIR_CONV C," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  NVL(@[lane_cd],'RBC') LANE,  SUBSTR(@[vvd], 1, 4) VSL_CD, SUBSTR(@[vvd], 5, 4) SKD_VOY_NO" ).append("\n"); 
		query.append("                      , SUBSTR(@[vvd], 9, 1) SKD_DIR_CD, @[pol] POL, SCONTI_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                WHERE L.LOC_CD = @[pol]) B" ).append("\n"); 
		query.append("        WHERE  C.SLAN_CD(+) = B.LANE" ).append("\n"); 
		query.append("        AND  C.SLAN_DIR_CD(+) = B.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND  NVL(C.AP_MK_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("        AND  C.SCONTI_CD(+) = B.SCONTI_CD ) T" ).append("\n"); 
		query.append("    WHERE V.VSL_CD = T.VSL_CD" ).append("\n"); 
		query.append("AND   V.SKD_VOY_NO = T.SKD_VOY_NO" ).append("\n"); 
		query.append("--AND   V.SKD_DIR_CD = T.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   V.SKD_DIR_CD = SUBSTR(T.SKD_DIR_CD,1,1)" ).append("\n"); 
		query.append("AND   V.RLANE_DIR_CD = SUBSTR(T.SKD_DIR_CD,2,1)" ).append("\n"); 
		query.append("AND   NVL(V.DELT_FLG,'N') <> 'Y' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("SELECT SUBSTR(AA,4,5) REV_LANE, SUBSTR(AA,9) REV_VVD, '' SLANE_CD" ).append("\n"); 
		query.append("    FROM ( SELECT MIN(SUBSTR(TO_CHAR(N.RNK_SEQ,'999'),2)||N.RLANE_CD||Q.VSL_CD||Q.SKD_VOY_NO||Q.SKD_DIR_CD) AA" ).append("\n"); 
		query.append("            FROM AR_ROUT_RNK N," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT V.RLANE_CD , T.VSL_CD, T.SKD_VOY_NO, T.SKD_DIR_CD, T.LANE" ).append("\n"); 
		query.append("                    FROM AR_MST_REV_VVD V," ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                              SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD||NVL(C.RLANE_DIR_CD, SKD_DIR_CD) SKD_DIR_CD," ).append("\n"); 
		query.append("                                   DECODE(VSL_CD, 'COMC','COM','CNTC','CNT', 'USAC','USA','WLXC','WLX', DECODE(LANE,'SYS','RBC',LANE) ) LANE" ).append("\n"); 
		query.append("                            FROM AR_FINC_DIR_CONV C," ).append("\n"); 
		query.append("                                    (" ).append("\n"); 
		query.append("                                    SELECT  NVL(@[lane_cd],'RBC') LANE,  SUBSTR(@[vvd], 1, 4) VSL_CD, SUBSTR(@[vvd], 5, 4) SKD_VOY_NO" ).append("\n"); 
		query.append("                                          , SUBSTR(@[vvd], 9, 1) SKD_DIR_CD, @[pol] POL, SCONTI_CD" ).append("\n"); 
		query.append("                                    FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                                    WHERE L.LOC_CD = @[pol]) B" ).append("\n"); 
		query.append("                            WHERE  C.SLAN_CD(+) = B.LANE" ).append("\n"); 
		query.append("                            AND  C.SLAN_DIR_CD(+) = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND  NVL(C.AP_MK_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("                            AND  C.SCONTI_CD(+) = B.SCONTI_CD ) T" ).append("\n"); 
		query.append("                        WHERE V.VSL_CD = T.VSL_CD" ).append("\n"); 
		query.append("                    AND   V.SKD_VOY_NO = T.SKD_VOY_NO" ).append("\n"); 
		query.append("                    --AND   V.SKD_DIR_CD = T.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND   V.SKD_DIR_CD = SUBSTR(T.SKD_DIR_CD,1,1)" ).append("\n"); 
		query.append("                    AND   V.RLANE_DIR_CD = SUBSTR(T.SKD_DIR_CD,2,1)" ).append("\n"); 
		query.append("                    AND   NVL(V.DELT_FLG,'N') <> 'Y' ) Q" ).append("\n"); 
		query.append("            WHERE N.RLANE_CD = Q.RLANE_CD" ).append("\n"); 
		query.append("            AND   N.SLAN_CD = Q.LANE" ).append("\n"); 
		query.append("            AND   SUBSTR(N.ZN_IOC_CD,1,2) = @[zone_ioc] )" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("#end            " ).append("\n"); 

	}
}