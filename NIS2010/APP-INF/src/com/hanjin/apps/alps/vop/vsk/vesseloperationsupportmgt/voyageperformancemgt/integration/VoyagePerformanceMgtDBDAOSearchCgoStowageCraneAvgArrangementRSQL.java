/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoyagePerformanceMgtDBDAOSearchCgoStowageCraneAvgArrangementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.23 
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

public class VoyagePerformanceMgtDBDAOSearchCgoStowageCraneAvgArrangementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Crane Average 조회
	  * </pre>
	  */
	public VoyagePerformanceMgtDBDAOSearchCgoStowageCraneAvgArrangementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration").append("\n"); 
		query.append("FileName : VoyagePerformanceMgtDBDAOSearchCgoStowageCraneAvgArrangementRSQL").append("\n"); 
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
		query.append("SELECT   ROUND(AVG(XX.VVD_CRANE_KNT),2) AS CGO_FROM_AVG_ARRANGEMENT" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("       --============================================" ).append("\n"); 
		query.append("        SELECT   X.VSL_CD" ).append("\n"); 
		query.append("              ,  X.VOY_NO" ).append("\n"); 
		query.append("              ,  X.DIR_CD" ).append("\n"); 
		query.append("              ,  X.PORT_CD" ).append("\n"); 
		query.append("              ,  X.CALL_IND" ).append("\n"); 
		query.append("              ,  COUNT(*)   VVD_CRANE_KNT" ).append("\n"); 
		query.append("        FROM     (" ).append("\n"); 
		query.append("                 ------------------------------------" ).append("\n"); 
		query.append("                  SELECT   	DISTINCT" ).append("\n"); 
		query.append("                           	BC.VSL_CD" ).append("\n"); 
		query.append("                        , 	BC.VOY_NO" ).append("\n"); 
		query.append("                        , 	BC.DIR_CD" ).append("\n"); 
		query.append("                        , 	BC.PORT_CD" ).append("\n"); 
		query.append("                        , 	BC.CALL_IND" ).append("\n"); 
		query.append("                        , 	BC.CRANE_ID" ).append("\n"); 
		query.append("                  FROM     	BAY_CRANE       	BC " ).append("\n"); 
		query.append("						,	VSK_VSL_PORT_SKD   	PS" ).append("\n"); 
		query.append("                  WHERE    	1 = 1" ).append("\n"); 
		query.append("                  AND      	PS.VSL_CD          	= BC.VSL_CD" ).append("\n"); 
		query.append("                  AND      	PS.SKD_VOY_NO      	= BC.VOY_NO" ).append("\n"); 
		query.append("                  AND      	PS.SKD_DIR_CD      	= BC.DIR_CD" ).append("\n"); 
		query.append("                  AND      	PS.VPS_PORT_CD     	= BC.PORT_CD" ).append("\n"); 
		query.append("                  AND      	PS.CLPT_IND_SEQ    	= BC.CALL_IND" ).append("\n"); 
		query.append("                  AND      	PS.VPS_ETB_DT      	BETWEEN SYSDATE - 90 AND SYSDATE" ).append("\n"); 
		query.append("                  AND      	BC.PORT_CD      	= @[vps_port_cd]" ).append("\n"); 
		query.append("                 ------------------------------------" ).append("\n"); 
		query.append("                 ) X      " ).append("\n"); 
		query.append("        GROUP BY X.VSL_CD" ).append("\n"); 
		query.append("              ,  X.VOY_NO" ).append("\n"); 
		query.append("              ,  X.DIR_CD" ).append("\n"); 
		query.append("              ,  X.PORT_CD" ).append("\n"); 
		query.append("              ,  X.CALL_IND   " ).append("\n"); 
		query.append("       --============================================                " ).append("\n"); 
		query.append("       ) XX" ).append("\n"); 

	}
}