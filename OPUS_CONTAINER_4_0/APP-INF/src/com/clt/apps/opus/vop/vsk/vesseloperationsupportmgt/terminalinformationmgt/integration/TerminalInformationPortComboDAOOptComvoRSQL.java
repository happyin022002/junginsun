/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalInformationPortComboDAOOptComvoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
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
		query.append("            " ).append("\n"); 
		query.append("            SELECT    	MX.LOC_CD		AS VAL" ).append("\n"); 
		query.append("					,	MX.LOC_NM 		AS NAME" ).append("\n"); 
		query.append("                     ,  (" ).append("\n"); 
		query.append("                        SELECT    MAX(DECODE(MO.OFC_TP_CD, 'HQ', MO.OFC_CD))--  AS VAL    " ).append("\n"); 
		query.append("                            FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                            CONNECT BY   NOCYCLE PRIOR MO.PRNT_OFC_CD  = MO.OFC_CD" ).append("\n"); 
		query.append("                            START WITH   MO.OFC_CD             = MX.SLS_OFC_CD" ).append("\n"); 
		query.append("                        ) AS POR_RHQ" ).append("\n"); 
		query.append("            FROM      MDM_LOCATION       MX " ).append("\n"); 
		query.append("          WHERE      MX.CALL_PORT_FLG    = 'Y'" ).append("\n"); 
		query.append("          AND        MX.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--             SELECT LOC_CD AS VAL, LOC_NM AS NAME, (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001', 'VSK'))) AS POR_RHQ" ).append("\n"); 
		query.append("--             FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--             WHERE  DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E'" ).append("\n"); 
		query.append("--             AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--             AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--             UNION ALL" ).append("\n"); 
		query.append("--             SELECT LOC_CD AS VAL, LOC_NM AS NAME, (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000002', 'VSK'))) AS POR_RHQ" ).append("\n"); 
		query.append("--             FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--             WHERE  CONTI_CD  = 'M'" ).append("\n"); 
		query.append("--             AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--             AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--             UNION ALL" ).append("\n"); 
		query.append("--             SELECT LOC_CD AS VAL, LOC_NM AS NAME, (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000003', 'VSK'))) AS POR_RHQ" ).append("\n"); 
		query.append("--             FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--             WHERE  CONTI_CD  = 'A'" ).append("\n"); 
		query.append("--             AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--             AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE POR_RHQ LIKE @[por_rhq]" ).append("\n"); 
		query.append("ORDER BY VAL" ).append("\n"); 

	}
}