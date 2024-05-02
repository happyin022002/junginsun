/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(AA,4,5) REV_LANE, SUBSTR(AA,9) REV_VVD" ).append("\n"); 
		query.append("    FROM ( SELECT MIN(SUBSTR(TO_CHAR(N.RNK_SEQ,'999'),2)||N.RLANE_CD||Q.VSL_CD||Q.SKD_VOY_NO||Q.SKD_DIR_CD) AA" ).append("\n"); 
		query.append("            FROM AR_ROUT_RNK N," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT V.RLANE_CD , T.VSL_CD, T.SKD_VOY_NO, T.SKD_DIR_CD, T.LANE" ).append("\n"); 
		query.append("            FROM AR_MST_REV_VVD V," ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                      SELECT VSL_CD, SKD_VOY_NO, DECODE(C.POD_CONTI_CD, B.POD_CONTI,POD_SLANE_DIR_CD||POD_RLANE_DIR_CD, NVL(SLAN_DIR_CD||RLANE_DIR_CD,SKD_DIR_CD||SKD_DIR_CD)) SKD_DIR_CD, " ).append("\n"); 
		query.append("                           DECODE(VSL_CD, 'COMC','COM','CNTC','CNT','WLXC','WLX', DECODE(LANE,'SYS','RBC',LANE) ) LANE, B.SCONTI_CD, ZONE_IOC" ).append("\n"); 
		query.append("                       FROM AR_FINC_DIR_CONV C," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT LANE, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POL, POD, SCONTI_CD, ZONE_IOC,POD_CONTI" ).append("\n"); 
		query.append("                        FROM (SELECT LANE, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POL, POD, MIN(SCONTI_CD)SCONTI_CD,  MIN(POD_CONTI) POD_CONTI, @[zone_ioc] ZONE_IOC" ).append("\n"); 
		query.append("                                 FROM (    " ).append("\n"); 
		query.append("                                        SELECT  NVL(@[lane],'RBC') LANE, @[vsl] VSL_CD, @[voy] SKD_VOY_NO, @[dep] SKD_DIR_CD, @[pol] POL, @[pod] POD, L.CONTI_CD POL_CONTI, NULL POD_CONTI, L.SCONTI_CD SCONTI_CD" ).append("\n"); 
		query.append("                                        FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                                        WHERE L.LOC_CD =  @[pol]" ).append("\n"); 
		query.append("                                        UNION ALL" ).append("\n"); 
		query.append("                                        SELECT  NVL(@[lane],'RBC') LANE, @[vsl] VSL_CD, @[voy] SKD_VOY_NO, @[dep] SKD_DIR_CD, @[pol] POL,  NVL(@[pod],@[pol]) POD,  NULL POL_CONTI, L.CONTI_CD POD_CONTI, NULL SCONTI_CD" ).append("\n"); 
		query.append("                                        FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                                        WHERE L.LOC_CD = NVL(@[pod],@[pol])" ).append("\n"); 
		query.append("                                 " ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                                 GROUP BY LANE, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POL, POD)" ).append("\n"); 
		query.append("                         WHERE SCONTI_CD IS NOT NULL" ).append("\n"); 
		query.append("                         ) B  " ).append("\n"); 
		query.append("                    WHERE  C.SLAN_CD(+) = B.LANE" ).append("\n"); 
		query.append("                    AND  C.SLAN_DIR_CD(+) = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND  NVL(C.AP_MK_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("                    AND  C.SCONTI_CD(+) = B.SCONTI_CD " ).append("\n"); 
		query.append("                ) T" ).append("\n"); 
		query.append("                WHERE V.VSL_CD = T.VSL_CD" ).append("\n"); 
		query.append("                AND   V.SKD_VOY_NO = T.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND   V.SKD_DIR_CD||V.RLANE_DIR_CD = T.SKD_DIR_CD " ).append("\n"); 
		query.append("                AND   NVL(V.DELT_FLG,'N') <> 'Y' " ).append("\n"); 
		query.append("           ) Q" ).append("\n"); 
		query.append("    WHERE N.RLANE_CD = Q.RLANE_CD" ).append("\n"); 
		query.append("    AND   N.SLAN_CD = Q.LANE" ).append("\n"); 
		query.append("    AND   SUBSTR(N.ZN_IOC_CD,1,2) = @[zone_ioc] )" ).append("\n"); 

	}
}