/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoyagePerformanceMgtDBDAOSearchPortToPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoyagePerformanceMgtDBDAOSearchPortToPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD를 가지고  Port to Port 구하기
	  * </pre>
	  */
	public VoyagePerformanceMgtDBDAOSearchPortToPortRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration").append("\n"); 
		query.append("FileName : VoyagePerformanceMgtDBDAOSearchPortToPortRSQL").append("\n"); 
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
		query.append("SELECT   Y.VSL_CD" ).append("\n"); 
		query.append("      ,  Y.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,  Y.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,  Y.VPS_PORT_CD" ).append("\n"); 
		query.append("      ,  Y.NXT_PORT_CD" ).append("\n"); 
		query.append("      ,  Y.CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,  Y.CLPT_SEQ" ).append("\n"); 
		query.append("      ,  Y.PAIR_PORT_CD " ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("         --=================================================================================" ).append("\n"); 
		query.append("          SELECT   XX.VSL_CD" ).append("\n"); 
		query.append("                ,  XX.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,  XX.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,  XX.CLPT_IND_SEQ  " ).append("\n"); 
		query.append("                ,  XX.CLPT_SEQ  " ).append("\n"); 
		query.append("                ,  XX.VPS_PORT_CD " ).append("\n"); 
		query.append("                ,  LEAD(XX.VPS_PORT_CD) OVER (ORDER BY XX.CLPT_SEQ ASC)                             AS NXT_PORT_CD" ).append("\n"); 
		query.append("                ,  XX.VPS_PORT_CD || ' ~ ' || LEAD(XX.VPS_PORT_CD) OVER (ORDER BY XX.CLPT_SEQ ASC)  AS PAIR_PORT_CD" ).append("\n"); 
		query.append("                ,  XX.TURN_PORT_FLG" ).append("\n"); 
		query.append("                ,  XX.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("          FROM     (" ).append("\n"); 
		query.append("                    ------------------------------------------------------------" ).append("\n"); 
		query.append("                    SELECT   X.VSL_CD" ).append("\n"); 
		query.append("                          ,  X.SKD_VOY_NO" ).append("\n"); 
		query.append("                          ,  X.SKD_DIR_CD" ).append("\n"); 
		query.append("                          ,  X.VPS_PORT_CD" ).append("\n"); 
		query.append("                          ,  X.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                          ,  X.CLPT_SEQ" ).append("\n"); 
		query.append("                          ,  X.TURN_PORT_FLG" ).append("\n"); 
		query.append("                          ,  X.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                          ,  X.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                          ,  X.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                          ,  X.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    FROM     VSK_VSL_PORT_SKD           X" ).append("\n"); 
		query.append("                    WHERE    1 = 1" ).append("\n"); 
		query.append("                    AND      NVL(X.SKD_CNG_STS_CD,'*')  <> 'S'" ).append("\n"); 
		query.append("                    AND      X.TURN_PORT_IND_CD         IN ('Y','N')" ).append("\n"); 
		query.append("                    AND      X.VSL_CD                   = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                    AND      X.SKD_VOY_NO               = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                    AND      X.SKD_DIR_CD               = SUBSTR(@[vvd],9)" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    SELECT   X.VSL_CD" ).append("\n"); 
		query.append("                          ,  X.SKD_VOY_NO" ).append("\n"); 
		query.append("                          ,  X.SKD_DIR_CD" ).append("\n"); 
		query.append("                          ,  X.VPS_PORT_CD                          " ).append("\n"); 
		query.append("                          ,  X.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                          ,  9999                       AS CLPT_SEQ" ).append("\n"); 
		query.append("                          ,  X.TURN_PORT_FLG" ).append("\n"); 
		query.append("                          ,  X.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("                          ,  X.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                          ,  X.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                          ,  X.TURN_CLPT_IND_SEQ                " ).append("\n"); 
		query.append("                    FROM     VSK_VSL_PORT_SKD           X" ).append("\n"); 
		query.append("                    WHERE    1 = 1" ).append("\n"); 
		query.append("                    AND      NVL(X.SKD_CNG_STS_CD,'*')  <> 'S'" ).append("\n"); 
		query.append("                    AND      X.TURN_PORT_FLG            = 'Y'" ).append("\n"); 
		query.append("                    AND      X.VSL_CD                   = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                    AND      X.TURN_SKD_VOY_NO          = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                    AND      X.TURN_SKD_DIR_CD          = SUBSTR(@[vvd],9)" ).append("\n"); 
		query.append("                    AND      X.CLPT_SEQ                 = (SELECT    MIN(PS.CLPT_SEQ)" ).append("\n"); 
		query.append("                                                           FROM      VSK_VSL_PORT_SKD         PS" ).append("\n"); 
		query.append("                                                           WHERE     PS.TURN_PORT_FLG         = 'Y'" ).append("\n"); 
		query.append("                                                           AND      NVL(PS.SKD_CNG_STS_CD,'*')  <> 'S'" ).append("\n"); 
		query.append("                                                           AND       PS.VSL_CD                = X.VSL_CD" ).append("\n"); 
		query.append("                                                           AND       PS.TURN_SKD_VOY_NO       = X.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                                           AND       PS.TURN_SKD_DIR_CD       = X.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                                           )" ).append("\n"); 
		query.append("                    ------------------------------------------------------------                                                           " ).append("\n"); 
		query.append("                    ) XX" ).append("\n"); 
		query.append("         --=================================================================================   " ).append("\n"); 
		query.append("         ) Y    " ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      Y.NXT_PORT_CD                      IS NOT NULL " ).append("\n"); 
		query.append("AND      Y.VSL_CD                           = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND      Y.SKD_VOY_NO                       = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND      Y.SKD_DIR_CD                       = SUBSTR(@[vvd],9)" ).append("\n"); 
		query.append("ORDER BY Y.CLPT_SEQ                         ASC" ).append("\n"); 

	}
}