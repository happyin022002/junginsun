/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalInformationComboDAOOptComvoRSQL.java
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

public class TerminalInformationComboDAOOptComvoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Combo Search
	  * </pre>
	  */
	public TerminalInformationComboDAOOptComvoRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationComboDAOOptComvoRSQL").append("\n"); 
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
		query.append("SELECT	A.YD_CD	AS VAL" ).append("\n"); 
		query.append("	  , A.YD_NM AS NAME" ).append("\n"); 
		query.append("FROM	MDM_YARD		A," ).append("\n"); 
		query.append("		(	" ).append("\n"); 
		query.append("                    " ).append("\n"); 
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
		query.append("		)B" ).append("\n"); 
		query.append("WHERE	A.LOC_CD		=	B.LOC_CD" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("AND	A.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_rhq} != '%') " ).append("\n"); 
		query.append("AND	B.POR_RHQ = @[por_rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.YD_CD" ).append("\n"); 

	}
}