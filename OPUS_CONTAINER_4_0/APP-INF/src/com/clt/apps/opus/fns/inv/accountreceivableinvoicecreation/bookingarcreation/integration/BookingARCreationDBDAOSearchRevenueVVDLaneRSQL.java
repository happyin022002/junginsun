/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchRevenueVVDLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.11.23 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
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
		query.append("SELECT NVL(SUBSTR(AA,4,5),'X') RLANE_CD, NVL(SUBSTR(AA,9),'X') REV_VVD" ).append("\n"); 
		query.append("FROM (SELECT MIN(SUBSTR(TO_CHAR(N.RNK_SEQ,'999'),2)||N.RLANE_CD||Q.VSL||Q.VOY_NO||Q.DEP) AA" ).append("\n"); 
		query.append("FROM AR_ROUT_RNK N," ).append("\n"); 
		query.append("(SELECT V.RLANE_CD REV_LANE, T.VSL, T.VOY_NO, T.DEP, T.LANE, T.SCONTI_CD, T.ZONE_IOC" ).append("\n"); 
		query.append("FROM AR_MST_REV_VVD  V," ).append("\n"); 
		query.append("(SELECT VSL, VOY_NO, NVL(SLAN_DIR_CD||RLANE_DIR_CD,DEP||DEP) DEP," ).append("\n"); 
		query.append("DECODE(VSL, 'COMC','COM','CNTC','CNT', DECODE(LANE,'SYS','RBC',LANE) ) LANE, B.SCONTI_CD, ZONE_IOC" ).append("\n"); 
		query.append("FROM AR_FINC_DIR_CONV C," ).append("\n"); 
		query.append("(SELECT LANE, VSL, VOY_NO, DEP, POL, POD, SCONTI_CD, ZONE_IOC" ).append("\n"); 
		query.append("FROM (SELECT LANE, VSL, VOY_NO, DEP, POL, POD, MIN(SCONTI_CD)SCONTI_CD," ).append("\n"); 
		query.append("DECODE(MIN(POL_CONTI)||MIN(POD_CONTI), 'AA','IA', 'EE','IE','MM','IM','EF','IE','FE','IE','FF','IE','OO') ZONE_IOC" ).append("\n"); 
		query.append("FROM (SELECT V.SLAN_CD LANE, V.VSL_CD VSL, V.SKD_VOY_NO VOY_NO, V.SKD_DIR_CD DEP," ).append("\n"); 
		query.append("V.POL_CD POL, V.POD_CD POD, L.CONTI_CD POL_CONTI, NULL POD_CONTI, L.SCONTI_CD SCONTI_CD" ).append("\n"); 
		query.append("FROM BKG_VVD V, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE V.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND V.POL_CD = L.LOC_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT V.SLAN_CD LANE, V.VSL_CD VSL, V.SKD_VOY_NO VOY_NO, V.SKD_DIR_CD DEP," ).append("\n"); 
		query.append("V.POL_CD POL, V.POD_CD POD, NULL POL_CONTI, L.CONTI_CD POD_CONTI, NULL SCONTI_CD" ).append("\n"); 
		query.append("FROM BKG_VVD V, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE V.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("AND V.POD_CD = L.LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY LANE, VSL, VOY_NO, DEP, POL, POD )" ).append("\n"); 
		query.append("WHERE SCONTI_CD IS NOT NULL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE C.SLAN_CD(+) = B.LANE" ).append("\n"); 
		query.append("AND  C.SLAN_DIR_CD(+) = B.DEP" ).append("\n"); 
		query.append("AND  NVL(C.AP_MK_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("AND  C.SCONTI_CD(+) = B.SCONTI_CD )T" ).append("\n"); 
		query.append("WHERE V.VSL_CD= T.VSL" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = T.VOY_NO" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD||V.RLANE_DIR_CD = T.DEP ) Q" ).append("\n"); 
		query.append("WHERE N.RLANE_CD = Q.REV_LANE" ).append("\n"); 
		query.append("AND N.SLAN_CD = Q.LANE" ).append("\n"); 
		query.append("AND SUBSTR(N.ZN_IOC_CD,1,2) = Q.ZONE_IOC )" ).append("\n"); 

	}
}