/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetLoadedWgtLastPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetLoadedWgtLastPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LAST PORT에서 ON-DECK LOADED WEIGHT 구하기 ( TIER 를 70이상으로 함)
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetLoadedWgtLastPortRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetLoadedWgtLastPortRSQL").append("\n"); 
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
		query.append("WITH PRE_SKD AS (		" ).append("\n"); 
		query.append("         SELECT  * 					" ).append("\n"); 
		query.append("           FROM ( SELECT *					" ).append("\n"); 
		query.append("                    #if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("                     FROM VSK_BUD_VSL_PORT_SKD" ).append("\n"); 
		query.append("                    #else 						" ).append("\n"); 
		query.append("                     FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                    #end 					" ).append("\n"); 
		query.append("                   WHERE  VPS_ETA_DT <	 ( SELECT MAX(VPS_ETA_DT) 				" ).append("\n"); 
		query.append("                                            #if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("                                             FROM VSK_BUD_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                            #else 						" ).append("\n"); 
		query.append("                                             FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                                            #end 					" ).append("\n"); 
		query.append("                                            WHERE VSL_CD     = SUBSTR(@[vvd], 1,4) 								" ).append("\n"); 
		query.append("                                              AND SKD_VOY_NO = SUBSTR(@[vvd], 5,4) 				" ).append("\n"); 
		query.append("                                              AND SKD_DIR_CD = SUBSTR(@[vvd], 9,1) 					" ).append("\n"); 
		query.append("                                              AND YD_CD      = @[yd_cd] )					" ).append("\n"); 
		query.append("                 AND TURN_PORT_IND_CD IN ('N','Y')					" ).append("\n"); 
		query.append("                 AND VSL_CD  = SUBSTR(@[vvd], 1,4) 		" ).append("\n"); 
		query.append("                 AND NVL(SKD_CNG_STS_CD,'X') <> 'S'			" ).append("\n"); 
		query.append("                ORDER BY VPS_ETA_DT DESC					" ).append("\n"); 
		query.append("                )					" ).append("\n"); 
		query.append("          WHERE  ROWNUM =1	)				" ).append("\n"); 
		query.append("      SELECT SUM(A.WEIGHT)					" ).append("\n"); 
		query.append("        FROM BAY_PLAN	A, PRE_SKD B				" ).append("\n"); 
		query.append("       WHERE A.VSL_CD    = B.VSL_CD					" ).append("\n"); 
		query.append("		 AND A.VOY_NO    = B.SKD_VOY_NO			" ).append("\n"); 
		query.append("		 AND A.DIR_CD    = B.SKD_DIR_CD			" ).append("\n"); 
		query.append("		 AND A.PLAN_TYPE = 'F'			" ).append("\n"); 
		query.append("         AND A.PORT_CD   = B.VPS_PORT_CD					" ).append("\n"); 
		query.append("         AND A.CALL_IND  = B.CLPT_IND_SEQ					" ).append("\n"); 
		query.append("         AND A.TIER      >= 70" ).append("\n"); 

	}
}