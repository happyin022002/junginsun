/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalInformationMgtDBDAOVskPortGngStrcVORSQL.java
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

public class TerminalInformationMgtDBDAOVskPortGngStrcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalInformationMgtDBDAOVskPortGngStrcVORSQL(){
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
		params.put("por_rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationMgtDBDAOVskPortGngStrcVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	A.LOC_CD" ).append("\n"); 
		query.append(",	CRN_SEQ" ).append("\n"); 
		query.append(",	GNG_WRK_ST_HRMNT" ).append("\n"); 
		query.append(",	GNG_WRK_END_HRMNT" ).append("\n"); 
		query.append(",	GNG_NWORK_ST_HRMNT" ).append("\n"); 
		query.append(",	GNG_NWORK_END_HRMNT" ).append("\n"); 
		query.append(",	GNG_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM VSK_PORT_GNG_STRC	A," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT LOC_CD, 'HAMRU' POR_RHQ" ).append("\n"); 
		query.append("		FROM   MDM_LOCATION" ).append("\n"); 
		query.append("		WHERE  DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E'" ).append("\n"); 
		query.append("		AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("		AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("		AND    LOC_CD <> 'RUVVO'" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT LOC_CD, 'PHXRA' POR_RHQ" ).append("\n"); 
		query.append("		FROM   MDM_LOCATION" ).append("\n"); 
		query.append("		WHERE  CONTI_CD  = 'M'" ).append("\n"); 
		query.append("		AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("		AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
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
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT LOC_CD, 'VVOIA' POR_RHQ" ).append("\n"); 
		query.append("		FROM   MDM_LOCATION" ).append("\n"); 
		query.append("		WHERE  LOC_CD = 'RUVVO'" ).append("\n"); 
		query.append("		AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(" 		AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("	)B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND B.POR_RHQ = @[por_rhq]" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("AND	A.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.LOC_CD,	A.CRN_SEQ" ).append("\n"); 

	}
}