/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetDemdetHolidayETARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.07.04 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetDemdetHolidayETARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 ETA의 Holiday/휴일 여부를 구한다.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetDemdetHolidayETARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetDemdetHolidayETARSQL").append("\n"); 
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
		query.append("SELECT ''''||MAX(NVL(DD,'N'))||''''" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- 휴일 등록을 한경우" ).append("\n"); 
		query.append("    SELECT  /*+ NO_EXPAND INDEX_DESC ( D XPKDMT_HOLIDAY ) */" ).append("\n"); 
		query.append("			'Y' DD" ).append("\n"); 
		query.append("#if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("    FROM DMT_HOLIDAY D, VSK_BUD_VSL_PORT_SKD V, MDM_LOCATION L" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    FROM DMT_HOLIDAY D, VSK_VSL_PORT_SKD V, MDM_LOCATION L" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      WHERE D.HOL_YR = TO_CHAR(V.VPS_ETA_DT, 'YYYY')" ).append("\n"); 
		query.append("      AND  D.CNT_CD = SUBSTR(V.VPS_PORT_CD,1,2) " ).append("\n"); 
		query.append("      AND  D.HOL_DT = TRUNC(V.VPS_ETA_DT)" ).append("\n"); 
		query.append("      AND  V.VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND  V.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND  V.SKD_DIR_CD = substr(@[vvd], 9)" ).append("\n"); 
		query.append("      AND  V.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("      AND  V.VPS_PORT_CD = L.LOC_CD" ).append("\n"); 
		query.append("      AND  D.RGN_CD IN (L.RGN_CD, ' ')" ).append("\n"); 
		query.append("      AND  D.STE_CD IN (L.STE_CD, ' ')" ).append("\n"); 
		query.append("      AND  D.LOC_CD IN (V.VPS_PORT_CD, ' ')" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT  CASE WHEN WKND_TP_CD = 'TF' THEN" ).append("\n"); 
		query.append("                    DECODE(TO_CHAR(VPS_ETA_DT,'D'),5,'Y',6,'Y','N' )" ).append("\n"); 
		query.append("                WHEN WKND_TP_CD = 'FS' THEN" ).append("\n"); 
		query.append("                    DECODE(TO_CHAR(VPS_ETA_DT,'D'),6,'Y',7,'Y','N' )" ).append("\n"); 
		query.append("				WHEN SUBSTR(@[yd_cd], 1, 2) = 'KR' THEN" ).append("\n"); 
		query.append("				    DECODE(TO_CHAR(VPS_ETA_DT,'D'),7,'N',1,'Y','N')  " ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                    DECODE(TO_CHAR(VPS_ETA_DT,'D'),7,'Y',1,'Y','N')  " ).append("\n"); 
		query.append("                END   DD        " ).append("\n"); 
		query.append("#if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("    FROM    DMT_WEEKEND D, VSK_BUD_VSL_PORT_SKD V" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    FROM    DMT_WEEKEND D, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("    WHERE  D.CNT_CD(+) = SUBSTR(V.VPS_PORT_CD,1,2) " ).append("\n"); 
		query.append("    AND VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("	AND SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("	AND SKD_DIR_CD = substr(@[vvd], 9)" ).append("\n"); 
		query.append("	AND YD_CD = @[yd_cd] " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}