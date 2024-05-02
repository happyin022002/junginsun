/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalInformationMgtDBDAOVskPortGntrCrnVORSQL.java
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

public class TerminalInformationMgtDBDAOVskPortGntrCrnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalInformationMgtDBDAOVskPortGntrCrnVORSQL(){
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
		query.append("FileName : TerminalInformationMgtDBDAOVskPortGntrCrnVORSQL").append("\n"); 
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
		query.append("SELECT      A.YD_CD                                          																																																																														 																																								                  " ).append("\n"); 
		query.append("		,	B.YD_NM                                          																																																																														 																																								                  " ).append("\n"); 
		query.append("		,	A.GRS_MAX_WGT                                    																																																																														 																																								                  " ).append("\n"); 
		query.append("		,	A.NET_MAX_WGT                                    																																																																														 																																								                  " ).append("\n"); 
		query.append("		,	A.CLR_BTWN_LEG_WDT                               																																																																														 																																								                  " ).append("\n"); 
		query.append("		,	A.CRN_RCH_ROW_KNT                                																																																																														 																																								                  " ).append("\n"); 
		query.append("		,	A.CNTR_TR_KNT                                    																																																																														 																																								                  " ).append("\n"); 
		query.append("		,	A.TTL_GNTR_CRN_QTY                               																																																																														 																																								                  " ).append("\n"); 
		query.append("		,	A.VSL_GNTR_CRN_MAX_QTY                           																																																																														 																																								                  " ).append("\n"); 
		query.append("		,	A.GNTR_RMK                                       																																																																														 																																								                  " ).append("\n"); 
		query.append("		,	A.CRE_USR_ID                                     																																																																																												 																																								                  " ).append("\n"); 
		query.append("		,	A.UPD_USR_ID                                     																																																																																												 																																								                  " ).append("\n"); 
		query.append("		,	TO_CHAR(A.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT	" ).append("\n"); 
		query.append("    	, 	H.SPCL_CGO_HNDL_RMK		" ).append("\n"); 
		query.append("		,   (SELECT COUNT(F.ATCH_FILE_SEQ) FROM VSK_PORT_GNTR_HNDL_FILE F WHERE F.LOC_CD = @[loc_cd])	AS ATCH_FILE_KNT																																																																																									 																																								                  " ).append("\n"); 
		query.append("FROM 		VSK_PORT_GNTR_CRN		A" ).append("\n"); 
		query.append("		,	MDM_YARD 				B" ).append("\n"); 
		query.append("		,	(                                                                   " ).append("\n"); 
		query.append("				SELECT LOC_CD, 'HAMRU' POR_RHQ                                  " ).append("\n"); 
		query.append("				FROM   MDM_LOCATION                                             " ).append("\n"); 
		query.append("				WHERE  DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E'               " ).append("\n"); 
		query.append("				AND    NVL(DELT_FLG, 'N') = 'N'                                 " ).append("\n"); 
		query.append("				AND    CALL_PORT_FLG = 'Y'                                      " ).append("\n"); 
		query.append("				AND    LOC_CD <> 'RUVVO'" ).append("\n"); 
		query.append("				UNION ALL                                                       " ).append("\n"); 
		query.append("				SELECT LOC_CD, 'PHXRA' POR_RHQ                                  " ).append("\n"); 
		query.append("				FROM   MDM_LOCATION                                             " ).append("\n"); 
		query.append("				WHERE  CONTI_CD  = 'M'                                          " ).append("\n"); 
		query.append("				AND    NVL(DELT_FLG, 'N') = 'N'                                 " ).append("\n"); 
		query.append("				AND    CALL_PORT_FLG = 'Y'                                      " ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
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
		query.append("        AND    CALL_PORT_FLG = 'Y'   " ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT LOC_CD, 'VVOIA' POR_RHQ" ).append("\n"); 
		query.append("		FROM   MDM_LOCATION" ).append("\n"); 
		query.append("		WHERE  LOC_CD = 'RUVVO'" ).append("\n"); 
		query.append("		AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(" 		AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("			)						C " ).append("\n"); 
		query.append("    	,   VSK_PORT_GNTR_HNDL_INFO H                                                               " ).append("\n"); 
		query.append("WHERE 		1 = 1" ).append("\n"); 
		query.append("AND       	A.YD_CD 				= B.YD_CD                                                 " ).append("\n"); 
		query.append("AND  		B.LOC_CD 				= C.LOC_CD" ).append("\n"); 
		query.append("AND     	B.LOC_CD  				= H.LOC_CD  (+)" ).append("\n"); 
		query.append("                                                " ).append("\n"); 
		query.append("#if (${loc_cd} != '')                                                   " ).append("\n"); 
		query.append("AND			B.LOC_CD 				= @[loc_cd]                                                " ).append("\n"); 
		query.append("#end                                                                    " ).append("\n"); 
		query.append("#if (${por_rhq} != '')                                                  " ).append("\n"); 
		query.append("AND			C.POR_RHQ 				= @[por_rhq]                                              " ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("                                                            " ).append("\n"); 
		query.append("ORDER BY 	A.YD_CD" ).append("\n"); 

	}
}