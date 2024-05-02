/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortInformationMgtDBDAOVskPortNworkVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortInformationMgtDBDAOVskPortNworkVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PortInformationMgtDBDAOVskPortNworkVORSQL(){
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
		params.put("cel_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration").append("\n"); 
		query.append("FileName : PortInformationMgtDBDAOVskPortNworkVORSQL").append("\n"); 
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
		query.append("SELECT                    " ).append("\n"); 
		query.append("    VPN.LOC_CD " ).append("\n"); 
		query.append(",	VPN.HOL_SEQ " ).append("\n"); 
		query.append(",	TO_CHAR(VPN.HOL_ST_DT,'yyyy-mm-dd hh24:mi') HOL_ST_DT" ).append("\n"); 
		query.append(",	TO_CHAR(VPN.HOL_END_DT,'yyyy-mm-dd hh24:mi') HOL_END_DT " ).append("\n"); 
		query.append(",	VPN.HOL_NM " ).append("\n"); 
		query.append(",	VPN.HOL_RMK " ).append("\n"); 
		query.append(",	VPN.UPD_USR_ID " ).append("\n"); 
		query.append(",	TO_CHAR(VPN.UPD_DT,'yyyy-mm-dd hh24:mi') UPD_DT " ).append("\n"); 
		query.append(",	VPN.CRE_USR_ID" ).append("\n"); 
		query.append(",   VPN.LOC_CD AS TEMP_LOC_CD" ).append("\n"); 
		query.append("FROM VSK_PORT_NWORK VPN " ).append("\n"); 
		query.append("WHERE to_char(VPN.HOL_ST_DT, 'YYYY') = @[cel_year]" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("  AND VPN.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != '^') " ).append("\n"); 
		query.append("  AND VPN.LOC_CD IN " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT  LOC_CD" ).append("\n"); 
		query.append("        FROM    (     " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("              SELECT    MX.LOC_CD" ).append("\n"); 
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
		query.append("--                     SELECT LOC_CD, (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001', 'VSK'))) AS POR_RHQ" ).append("\n"); 
		query.append("--                     FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                     WHERE  DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E'" ).append("\n"); 
		query.append("--                     AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                     AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--                     UNION ALL" ).append("\n"); 
		query.append("--                     SELECT LOC_CD, (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000002', 'VSK'))) AS POR_RHQ" ).append("\n"); 
		query.append("--                     FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                     WHERE  CONTI_CD  = 'M'" ).append("\n"); 
		query.append("--                     AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                     AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--                     UNION ALL" ).append("\n"); 
		query.append("--                     SELECT LOC_CD, DECODE(SCONTI_CD, 'AF'," ).append("\n"); 
		query.append("--                                            (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000003', 'VSK')))," ).append("\n"); 
		query.append("--                                            (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000004', 'VSK')))) POR_RHQ" ).append("\n"); 
		query.append("--                     FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                     WHERE  CONTI_CD  = 'A'" ).append("\n"); 
		query.append("--                     AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                     AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   POR_RHQ = DECODE(SUBSTR(@[rhq], 1, 3), 'ALL', POR_RHQ, @[rhq])" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY VPN.LOC_CD ASC" ).append("\n"); 

	}
}