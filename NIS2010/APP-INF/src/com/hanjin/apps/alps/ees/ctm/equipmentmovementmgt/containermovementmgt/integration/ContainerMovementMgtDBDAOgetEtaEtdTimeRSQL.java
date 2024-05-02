/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetEtaEtdTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.07.27 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetEtaEtdTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT VPS_ETD_DT, VPS_ETA_DT
	  *   FROM VSK_VSL_PORT_SKD
	  *  WHERE 1 = 1
	  *    AND VSL_CD = 'HNAT'
	  *    AND SKD_VOY_NO = '0062'
	  *    AND SKD_DIR_CD = 'W'
	  *    AND VPS_PORT_CD = 'KRKAN'
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetEtaEtdTimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetEtaEtdTimeRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT, TO_CHAR(VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') VPS_ETA_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND VSL_CD     = SUBSTR(@[p_vvd], 0,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[p_vvd], 5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[p_vvd], 9,1)" ).append("\n"); 
		query.append("#if (${p_pol} != '')" ).append("\n"); 
		query.append("AND VPS_PORT_CD = @[p_pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_pod} != '')" ).append("\n"); 
		query.append("AND VPS_PORT_CD = @[p_pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}