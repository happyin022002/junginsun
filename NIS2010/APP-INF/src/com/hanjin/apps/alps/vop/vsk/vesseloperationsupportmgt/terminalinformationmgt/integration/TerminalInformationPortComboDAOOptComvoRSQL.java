/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalInformationPortComboDAOOptComvoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalInformationPortComboDAOOptComvoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPort
	  * </pre>
	  */
	public TerminalInformationPortComboDAOOptComvoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationPortComboDAOOptComvoRSQL").append("\n"); 
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
		query.append("SELECT	VAL, NAME" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("		SELECT LOC_CD as val, LOC_NM  as name, 'HAMRU' POR_RHQ" ).append("\n"); 
		query.append("		FROM   MDM_LOCATION" ).append("\n"); 
		query.append("		WHERE  DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E'" ).append("\n"); 
		query.append("		AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("		AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("		AND    LOC_CD <> 'RUVVO'" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT LOC_CD, LOC_NM,  'PHXRA' POR_RHQ" ).append("\n"); 
		query.append("		FROM   MDM_LOCATION" ).append("\n"); 
		query.append("		WHERE  CONTI_CD  = 'M'" ).append("\n"); 
		query.append("		AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("		AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT LOC_CD, LOC_NM, DECODE(SCONTI_CD, 'AF', 'SHARC', 'SINRS') POR_RHQ" ).append("\n"); 
		query.append("        FROM   MDM_LOCATION                                             " ).append("\n"); 
		query.append("        WHERE  CONTI_CD  = 'A'                                          " ).append("\n"); 
		query.append("        AND    NVL(DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("        AND    LOC_CD        NOT LIKE 'KR%' " ).append("\n"); 
		query.append("        AND    LOC_CD        NOT LIKE 'JP%'                                " ).append("\n"); 
		query.append("        AND    CALL_PORT_FLG = 'Y'      " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL                                                       " ).append("\n"); 
		query.append("        SELECT LOC_CD, LOC_NM, 'SELSC' POR_RHQ" ).append("\n"); 
		query.append("        FROM   MDM_LOCATION                                             " ).append("\n"); 
		query.append("        WHERE  CONTI_CD  = 'A'                                          " ).append("\n"); 
		query.append("        AND    NVL(DELT_FLG, 'N') = 'N'  " ).append("\n"); 
		query.append("        AND    LOC_CD        LIKE 'KR%'                                        " ).append("\n"); 
		query.append("        AND    CALL_PORT_FLG = 'Y'   " ).append("\n"); 
		query.append("        UNION ALL                                                       " ).append("\n"); 
		query.append("        SELECT LOC_CD, LOC_NM, 'TYOSC' POR_RHQ" ).append("\n"); 
		query.append("        FROM   MDM_LOCATION                                             " ).append("\n"); 
		query.append("        WHERE  CONTI_CD  = 'A'                                          " ).append("\n"); 
		query.append("        AND    NVL(DELT_FLG, 'N') = 'N'   " ).append("\n"); 
		query.append("        AND    LOC_CD        LIKE 'JP%'                                       " ).append("\n"); 
		query.append("        AND    CALL_PORT_FLG = 'Y' " ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT LOC_CD, LOC_NM, 'VVOIA' POR_RHQ" ).append("\n"); 
		query.append("		FROM   MDM_LOCATION" ).append("\n"); 
		query.append("		WHERE  LOC_CD = 'RUVVO'" ).append("\n"); 
		query.append("		AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(" 		AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE POR_RHQ LIKE @[por_rhq]" ).append("\n"); 
		query.append("ORDER BY VAL" ).append("\n"); 

	}
}