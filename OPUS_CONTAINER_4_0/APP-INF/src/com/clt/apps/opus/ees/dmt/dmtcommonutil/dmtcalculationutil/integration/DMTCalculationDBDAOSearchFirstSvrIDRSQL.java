/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchFirstSvrIDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.04
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.11.04 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchFirstSvrIDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMTCalculationDBDAOSearchFirstSvrIDRSQL
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchFirstSvrIDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchFirstSvrIDRSQL").append("\n"); 
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
		query.append("SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("  FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(" WHERE CO_IND_CD = 'H'" ).append("\n"); 
		query.append("   AND CNT_CD =" ).append("\n"); 
		query.append("       (SELECT BKG_CNT_CD" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("          (SELECT DECODE (SUBSTR (@[dmdt_trf_cd], 3, 1)," ).append("\n"); 
		query.append("                          'I', DECODE (@[dmdt_chg_loc_div_cd]," ).append("\n"); 
		query.append("                                       'POD', SUBSTR (POD_CD, 1, 2)," ).append("\n"); 
		query.append("                                       'DEL', SUBSTR (DEL_CD, 1, 2)," ).append("\n"); 
		query.append("                                       'TSP', (SELECT SUBSTR (PST_RLY_PORT_CD," ).append("\n"); 
		query.append("                                                              1," ).append("\n"); 
		query.append("                                                              2" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("                                                 FROM BKG_BOOKING" ).append("\n"); 
		query.append("                                                WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                                      )," ).append("\n"); 
		query.append("                          'O', DECODE (@[dmdt_chg_loc_div_cd]," ).append("\n"); 
		query.append("                                       'POL', SUBSTR (POL_CD, 1, 2)," ).append("\n"); 
		query.append("                                       'POR', SUBSTR (POR_CD, 1, 2)," ).append("\n"); 
		query.append("                                       'TSP', (SELECT SUBSTR (PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("                                                              1," ).append("\n"); 
		query.append("                                                              2" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("                                                 FROM BKG_BOOKING" ).append("\n"); 
		query.append("                                                WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                         ) AS BKG_CNT_CD" ).append("\n"); 
		query.append("             FROM DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("            WHERE CNTR_NO = @[cntr_no] " ).append("\n"); 
		query.append("              AND CNTR_CYC_NO = @[cntr_cyc_no]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("        WHERE BKG_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND ROWNUM = 1)" ).append("\n"); 

	}
}