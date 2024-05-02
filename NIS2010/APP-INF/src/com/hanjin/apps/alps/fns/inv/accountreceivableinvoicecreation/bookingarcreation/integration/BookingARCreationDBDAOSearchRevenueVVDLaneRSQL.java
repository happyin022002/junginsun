/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchRevenueVVDLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
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

public class BookingARCreationDBDAOSearchRevenueVVDLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchRevenueVVDLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchRevenueVVDLaneRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("REV_VVD_LANE AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT V.RLANE_CD REV_LANE, T.VSL, T.VSL_PRE_PST_CD, T.VOY_NO, T.DEP, T.LANE, T.SCONTI_CD, T.ZONE_IOC" ).append("\n"); 
		query.append("                  FROM AR_MST_REV_VVD  V," ).append("\n"); 
		query.append("                       (SELECT VSL_PRE_PST_CD, VSL, VOY_NO, DECODE(C.POD_CONTI_CD, B.POD_CONTI,POD_SLANE_DIR_CD||POD_RLANE_DIR_CD, NVL(SLAN_DIR_CD||RLANE_DIR_CD,DEP||DEP)) DEP," ).append("\n"); 
		query.append("                               DECODE(VSL, 'COMC','COM','CNTC','CNT', DECODE(LANE,'SYS','RBC',LANE) ) LANE, B.SCONTI_CD, ZONE_IOC" ).append("\n"); 
		query.append("                          FROM AR_FINC_DIR_CONV C," ).append("\n"); 
		query.append("                              (SELECT LANE, VSL, VOY_NO, DEP,  SCONTI_CD, ZONE_IOC, POD_CONTI, VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                 FROM (SELECT LANE, VSL, VOY_NO, DEP, POL, POD, VSL_PRE_PST_CD, MIN(SCONTI_CD)SCONTI_CD,  MIN(POD_CONTI) AS POD_CONTI," ).append("\n"); 
		query.append("                                              DECODE(MIN(POL_CONTI)||MIN(POD_CONTI), 'AA','IA', 'EE','IE','MM','IM','EF','IE','FE','IE','FF','IE','OO') ZONE_IOC" ).append("\n"); 
		query.append("                                         FROM (SELECT V.SLAN_CD LANE, V.VSL_CD VSL, V.SKD_VOY_NO VOY_NO, V.SKD_DIR_CD DEP," ).append("\n"); 
		query.append("                                                      V.POL_CD POL, V.POD_CD POD, L.CONTI_CD POL_CONTI, NULL POD_CONTI, L.SCONTI_CD SCONTI_CD" ).append("\n"); 
		query.append("                                                      , V.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                                 FROM BKG_VVD V, MDM_LOCATION L" ).append("\n"); 
		query.append("                                                WHERE V.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                  AND V.POL_CD = L.LOC_CD" ).append("\n"); 
		query.append("                                                UNION ALL" ).append("\n"); 
		query.append("                                               SELECT V.SLAN_CD LANE, V.VSL_CD VSL, V.SKD_VOY_NO VOY_NO, V.SKD_DIR_CD DEP," ).append("\n"); 
		query.append("                                                      V.POL_CD POL, V.POD_CD POD, NULL POL_CONTI, L.CONTI_CD POD_CONTI, NULL SCONTI_CD" ).append("\n"); 
		query.append("                                                      , V.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                                 FROM BKG_VVD V, MDM_LOCATION L" ).append("\n"); 
		query.append("                                                WHERE V.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("                                                  AND V.POD_CD = L.LOC_CD " ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                                        GROUP BY LANE, VSL, VOY_NO, DEP, VSL_PRE_PST_CD )" ).append("\n"); 
		query.append("                                WHERE SCONTI_CD IS NOT NULL" ).append("\n"); 
		query.append("                                ) B " ).append("\n"); 
		query.append("                         WHERE C.SLAN_CD(+) = B.LANE" ).append("\n"); 
		query.append("                           AND  C.SLAN_DIR_CD(+) = B.DEP" ).append("\n"); 
		query.append("                           AND  NVL(C.AP_MK_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND  C.SCONTI_CD(+) = B.SCONTI_CD )T" ).append("\n"); 
		query.append("                 WHERE V.VSL_CD= T.VSL" ).append("\n"); 
		query.append("                   AND V.SKD_VOY_NO = T.VOY_NO" ).append("\n"); 
		query.append("                   AND V.SKD_DIR_CD||V.RLANE_DIR_CD = T.DEP " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT NVL(SUBSTR(AA,4,5),'X') RLANE_CD, NVL(SUBSTR(AA,9),'X') REV_VVD" ).append("\n"); 
		query.append("  FROM (SELECT MIN(SUBSTR(TO_CHAR(N.RNK_SEQ,'999'),2)||N.RLANE_CD||Q.VSL||Q.VOY_NO||Q.DEP) AA" ).append("\n"); 
		query.append("          FROM AR_ROUT_RNK N," ).append("\n"); 
		query.append("               REV_VVD_LANE Q" ).append("\n"); 
		query.append("         WHERE N.RLANE_CD = Q.REV_LANE" ).append("\n"); 
		query.append("           AND N.SLAN_CD = Q.LANE" ).append("\n"); 
		query.append("           AND SUBSTR(N.ZN_IOC_CD,1,2) = Q.ZONE_IOC" ).append("\n"); 
		query.append("           AND (   Q.VSL_PRE_PST_CD = 'T' " ).append("\n"); 
		query.append("                       OR  NOT EXISTS ( SELECT 'X' " ).append("\n"); 
		query.append("                                        FROM   REV_VVD_LANE B" ).append("\n"); 
		query.append("                                        WHERE  B.LANE = Q.LANE" ).append("\n"); 
		query.append("                                        AND    B.ZONE_IOC = Q.ZONE_IOC" ).append("\n"); 
		query.append("                                        AND    B.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("                                      ) " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}