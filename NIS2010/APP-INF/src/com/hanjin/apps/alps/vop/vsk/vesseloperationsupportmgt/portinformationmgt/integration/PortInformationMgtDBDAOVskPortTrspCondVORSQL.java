/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortInformationMgtDBDAOVskPortTrspCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.13 
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

public class PortInformationMgtDBDAOVskPortTrspCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PortInformationMgtDBDAOVskPortTrspCondVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration").append("\n"); 
		query.append("FileName : PortInformationMgtDBDAOVskPortTrspCondVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	LOC_CD" ).append("\n"); 
		query.append(",	TRSP_MOD_CD" ).append("\n"); 
		query.append(",	LMT_20FT_WGT" ).append("\n"); 
		query.append(",	LMT_40FT_WGT" ).append("\n"); 
		query.append(",	LMT_AXL_WGT" ).append("\n"); 
		query.append(",	LMT_LEN" ).append("\n"); 
		query.append(",	LMT_WDT" ).append("\n"); 
		query.append(",	LMT_HGT" ).append("\n"); 
		query.append(",	LMT_OVR_LEN" ).append("\n"); 
		query.append(",	LMT_OVR_WDT" ).append("\n"); 
		query.append(",	LMT_OVR_HGT" ).append("\n"); 
		query.append(",	TRSP_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT,'yyyy-mm-dd hh24:mi') UPD_DT " ).append("\n"); 
		query.append(",   LOC_CD AS TEMP_LOC_CD" ).append("\n"); 
		query.append("FROM VSK_PORT_TRSP_COND" ).append("\n"); 
		query.append("WHERE TRSP_MOD_CD = @[trsp_mod_cd]" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("  AND LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != '^') " ).append("\n"); 
		query.append("  AND LOC_CD IN " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT  LOC_CD" ).append("\n"); 
		query.append("        FROM    (                    " ).append("\n"); 
		query.append("                    SELECT LOC_CD, 'HAMRU' POR_RHQ" ).append("\n"); 
		query.append("                    FROM   MDM_LOCATION" ).append("\n"); 
		query.append("                    WHERE  DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E'" ).append("\n"); 
		query.append("                    AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                    AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                    AND    LOC_CD <> 'RUVVO'" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT LOC_CD, 'PHXRA' POR_RHQ" ).append("\n"); 
		query.append("                    FROM   MDM_LOCATION" ).append("\n"); 
		query.append("                    WHERE  CONTI_CD  = 'M'" ).append("\n"); 
		query.append("                    AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                    AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT LOC_CD, DECODE(SCONTI_CD, 'AF', 'SHARC', 'SINRS') POR_RHQ" ).append("\n"); 
		query.append("        FROM   MDM_LOCATION                                             " ).append("\n"); 
		query.append("        WHERE  CONTI_CD  = 'A'                                          " ).append("\n"); 
		query.append("        AND    NVL(DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("        AND    LOC_CD        NOT LIKE 'KR%' " ).append("\n"); 
		query.append("        AND    LOC_CD        NOT LIKE 'JP%'                                " ).append("\n"); 
		query.append("        AND    CALL_PORT_FLG = 'Y'      " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL                                                       " ).append("\n"); 
		query.append("        SELECT LOC_CD, 'SELSC' POR_RHQ" ).append("\n"); 
		query.append("        FROM   MDM_LOCATION                                             " ).append("\n"); 
		query.append("        WHERE  CONTI_CD  = 'A'                                          " ).append("\n"); 
		query.append("        AND    NVL(DELT_FLG, 'N') = 'N'  " ).append("\n"); 
		query.append("        AND    LOC_CD        LIKE 'KR%'                                        " ).append("\n"); 
		query.append("        AND    CALL_PORT_FLG = 'Y'   " ).append("\n"); 
		query.append("        UNION ALL                                                       " ).append("\n"); 
		query.append("        SELECT LOC_CD, 'TYOSC' POR_RHQ" ).append("\n"); 
		query.append("        FROM   MDM_LOCATION                                             " ).append("\n"); 
		query.append("        WHERE  CONTI_CD  = 'A'                                          " ).append("\n"); 
		query.append("        AND    NVL(DELT_FLG, 'N') = 'N'   " ).append("\n"); 
		query.append("        AND    LOC_CD        LIKE 'JP%'                                       " ).append("\n"); 
		query.append("        AND    CALL_PORT_FLG = 'Y' " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT LOC_CD, 'VVOIA' POR_RHQ" ).append("\n"); 
		query.append("        FROM   MDM_LOCATION" ).append("\n"); 
		query.append("        WHERE  LOC_CD = 'RUVVO'" ).append("\n"); 
		query.append("        AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("        AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   POR_RHQ = DECODE(SUBSTR(@[rhq], 1, 3), 'ALL', POR_RHQ, @[rhq])" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY LOC_CD ASC" ).append("\n"); 

	}
}