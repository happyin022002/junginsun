/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchDischageForLoadingHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchDischageForLoadingHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  *  2010.11.30 남궁진호 [CHM-201007281-01] Loding Port의 Start  Port추가
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchDischageForLoadingHeaderRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchDischageForLoadingHeaderRSQL").append("\n"); 
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
		query.append("SELECT S1.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT  ROWNUM RN,S.*" ).append("\n"); 
		query.append("          , DECODE(POL_CD_CNT0, POL_CD_CNT1, POL_CD_CNT2, POL_CD_CNT1) POL_CD_CNT " ).append("\n"); 
		query.append("    FROM   (SELECT SKD.YD_CD||'/'||SKD.SKD_DIR_CD||'/'||SKD.CLPT_IND_SEQ POL_CD " ).append("\n"); 
		query.append("            ,      SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("            ,      SKD.CLPT_SEQ" ).append("\n"); 
		query.append("            ,      MIN(SKD.VPS_ETD_DT) OVER (PARTITION BY  SKD.SKD_DIR_CD) MIN_VPS_ETD_DT" ).append("\n"); 
		query.append("            ,      COUNT(SKD.SKD_DIR_CD) OVER (PARTITION BY SKD.VPS_PORT_CD, SKD.SKD_DIR_CD) POL_CD_CNT0               " ).append("\n"); 
		query.append("            ,      COUNT(SKD.VPS_PORT_CD) OVER (PARTITION BY SKD.VPS_PORT_CD) POL_CD_CNT1" ).append("\n"); 
		query.append("            ,      ROW_NUMBER() OVER (PARTITION BY SKD.VPS_PORT_CD ORDER BY  SKD.VPS_PORT_CD) POL_CD_CNT2" ).append("\n"); 
		query.append("            FROM   VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("            WHERE  SKD.VSL_CD       = SUBSTR( @[vvd], 1, 4)" ).append("\n"); 
		query.append("            AND    SKD.SKD_VOY_NO   = SUBSTR( @[vvd], 5)" ).append("\n"); 
		query.append("   AND ( ( NVL(SKD.SKD_CNG_STS_CD, 'A') =  'S'" ).append("\n"); 
		query.append("                    AND  1 = 1" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("                   OR " ).append("\n"); 
		query.append("                   ( NVL(SKD.SKD_CNG_STS_CD, 'A') <>  'S'" ).append("\n"); 
		query.append("                     AND  1 = 1" ).append("\n"); 
		query.append("                    --AND  SKD.TURN_PORT_IND_CD NOT IN ('D')" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            ORDER BY  MIN_VPS_ETD_DT  , CLPT_SEQ  " ).append("\n"); 
		query.append("        )S " ).append("\n"); 
		query.append("     ) S1" ).append("\n"); 

	}
}