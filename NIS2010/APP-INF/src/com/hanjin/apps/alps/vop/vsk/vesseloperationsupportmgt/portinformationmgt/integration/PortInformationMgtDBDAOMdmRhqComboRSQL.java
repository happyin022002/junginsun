/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PortInformationMgtDBDAOMdmRhqComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortInformationMgtDBDAOMdmRhqComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public PortInformationMgtDBDAOMdmRhqComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration").append("\n"); 
		query.append("FileName : PortInformationMgtDBDAOMdmRhqComboRSQL").append("\n"); 
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
		query.append("SELECT      X.LOC_NM AS NAME" ).append("\n"); 
		query.append("        ,   CASE WHEN DECODE(X.CONTI_CD, 'F', 'E', X.CONTI_CD) = 'E' AND NVL(X.DELT_FLG, 'N') = 'N' AND X.CALL_PORT_FLG = 'Y' AND X.LOC_CD <> 'RUVVO' THEN 'HAMRU'" ).append("\n"); 
		query.append("                 WHEN X.CONTI_CD  = 'M' AND NVL(X.DELT_FLG, 'N') = 'N' AND X.CALL_PORT_FLG = 'Y' THEN 'PHXRA'" ).append("\n"); 
		query.append("                 WHEN X.CONTI_CD  = 'A' AND X.CNT_CD NOT IN ('KR','JP') AND NVL(X.DELT_FLG, 'N') = 'N' AND X.CALL_PORT_FLG = 'Y' AND X.SCONTI_CD = 'AF' THEN 'SHARC'" ).append("\n"); 
		query.append("                 WHEN X.CONTI_CD  = 'A' AND X.CNT_CD NOT IN ('KR','JP') AND NVL(X.DELT_FLG, 'N') = 'N' AND X.CALL_PORT_FLG = 'Y' THEN 'SINRS'" ).append("\n"); 
		query.append("                 WHEN X.CNT_CD    = 'KR' THEN 'SELSC'" ).append("\n"); 
		query.append("                 WHEN X.CNT_CD    = 'JP' THEN 'TYOSC'" ).append("\n"); 
		query.append("                 WHEN X.LOC_CD    = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("            END AS VAL" ).append("\n"); 
		query.append("FROM        MDM_LOCATION          	X" ).append("\n"); 
		query.append("WHERE		X.CALL_PORT_FLG 		= 'Y'" ).append("\n"); 
		query.append("AND			X.LOC_CD              	= @[loc_cd]" ).append("\n"); 

	}
}